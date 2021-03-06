package com.liantuo.trade.bus.process.impl.single_payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.liantuo.trade.bus.process.TradeCreateMultiTxNoPaymentInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.service.AdvanceAccountService;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountService;
import com.liantuo.deposit.advanceaccount.bus.vo.AdvanceAccountVO;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.mc.web.util.StringUtil;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.service.LegderService;
import com.liantuo.trade.bus.service.ProfitLossLedgerService;
import com.liantuo.trade.bus.service.SinglePaymentService;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateMultiTxNoPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalPayment;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.OtherPofitLossLedgerForRefund;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.TradeCommonValidation;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.pojo.TradeProfitLossLedger;
import com.liantuo.trade.orm.pojo.TradeSinglePayment;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentExample;
import com.liantuo.trade.orm.pojo.subvo.TradeSinglePaymentVo;
import com.liantuo.trade.seqno.IdFactory;
import com.liantuo.trade.spring.annotation.JobFlow;

/**
 * @author JiangKun
 * @ClassName: SingleExternalPayOfflineProcess
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2016年6月13日 上午10:28:20
 */
@JobFlow(value = "0006_001_002", version = "1.0", template = ATradeCreateMultiTxNoPaymentTemp.class)
public class SingleExternalPayOfflineProcess implements TradeCreateMultiTxNoPaymentInterface<TradePacketReqBodyExternalPayment> {
    private static Logger logger = LoggerFactory.getLogger(SingleExternalPayOfflineProcess.class);
    private final static int INIT_VERSION = 0;
    @Autowired
    private ExceptionService exceptionService;
    @Resource(name = "creditAccountServiceImpl")
    private CreditAccountService creditAccountService;
    @Resource(name = "idFactorySinglePaymentTradeNo")
    private IdFactory idFactorySinglePaymentTradeNo;
    @Resource(name = "legderServiceImpl")
    private LegderService legderService;
    @Resource(name = "profitLossLedgerServiceImpl")
    private ProfitLossLedgerService profitLossLedgerService;
    @Resource(name = "singlePaymentServiceImpl")
    private SinglePaymentService singlePaymentService;
    @SuppressWarnings("rawtypes")
    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService bizAccountService;
    @Resource(name = "advanceAccountServiceImpl")
    private AdvanceAccountService advanceAccountService;


    private String tradeNo;//交易编号
    private String reqNo;//请求编号
    private String payLedgerNo;//付款方台账编号
    private String otherProfitLossLedgerNo;//其他损益台账编号
    private String receiveProfitLossLedgerNo;//收款损益台账编号
    private String payMerchantNo;//付款商户编号
    private String payFeeMerchantNo;//付款方手续费账户商户编号
    private String receiveMerchantNo;//收款方账户商户编号
    private String receiveFeeMerchantNo;//收款方手续费账户商户编号
    private TradeSinglePayment tradeSinglePayment;//支付交易记录
    private List<TradeProfitLossLedger> otherProfitLossLedgerList;//其他损益台账list
    private String jsonList = "";//其他损益台账ListJson

    /**
     * 入口校验
     */
    @Override
    public void validate(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) throws Exception {
        //校验输入参格式
        formatValidate(tradeRequest);
        //参数正确性校验
        bizValidate(tradeRequest);
    }

    /**
     * 第一个事务
     */
    @Override
    public void transactionStep01(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) throws Exception {
        //获取充值交易编号
        this.tradeNo = idFactorySinglePaymentTradeNo.generate().toString();
        Date currentTime = new Date();
        //创建生效付款方外部收款台账
        createEffectiveLegder(tradeRequest, currentTime);
        //创建其他空白损益台账
        createExtendBlankProfitLossLegder(tradeRequest, currentTime);
        //创建空白收款损益台账
        createBlankProfitLossLegder(tradeRequest, currentTime);
        //创建等待入账交易记录
        createTradeRecordWaitForPosting(tradeRequest, currentTime);
    }

    /**
     * 创建失败返回记录
     */
    @Override
    public void createTradeFailRecode(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) throws Exception {
        Date currentTime = new Date();
        //创建支付失败交易记录
        createRecordPaymentFailed(tradeRequest, currentTime);
    }

    /**
     * 第二个事务
     */
    @Override
    public void transactionStep02(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) throws Exception {
        //账务处理
        handlerRealAcount(tradeRequest);
        //生效收款损益台账
        profitLossLegderEffect(tradeRequest);
        //生效其他损益台账
        extendProfitLossLegderEffect(tradeRequest);
        //修改支付成功交易记录
        modifyTradeRecordSuccess(tradeRequest);
    }

    @Override
    public Object getTradeDetails() {
    	TradeSinglePaymentVo paymentVo = new TradeSinglePaymentVo();
        if (tradeSinglePayment != null) {
            BeanUtils.copyProperties(tradeSinglePayment, paymentVo);
            return paymentVo;
        }
        return null;
    }

    @Override
    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    /**
     * 校验输入参数格式
     */
    private void formatValidate(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) throws Exception {
        String msg = TradeValidationUtil.validateRequestWeak(tradeRequest);
        if (!StringUtils.isEmpty(msg)) {
            logger.info("-->输入参数校验不通过：" + msg);
            throw exceptionService.buildBusinessException("JY00060010021000100", msg);
        }
        //当【收款方账户入账子账户类型】为【冻结】时，若【收款方手续费账户账户编号】与【收款方账户账户编号】不同，则【收款方手续费出账子账户类型】只能是【可用】，若相同，则能是【可用】或【冻结】
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_account_in_accounting_type())
        		&&TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())) {
            if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_fee_account_out_accounting_type()) 
            		&& !tradeRequest.getBody().getReceive_account_no().equals(tradeRequest.getBody().getReceive_fee_account_no())) {
                logger.info("-->收款账户和收款手续费账户不同时，收款子账户类型必须为可用");
                throw exceptionService.buildBusinessException("JY00060010021000100", "收款账户和收款手续费账户不同时，收款手续费子账户类型必须为可用");
            }
        }else if(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE.equals(tradeRequest.getBody().getReceive_account_in_accounting_type())
        		&&TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())){
        	if(TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_fee_account_out_accounting_type())){
        		logger.info("-->当收款账户子类型为可用时，收款手续费账户子类型必须为可用");
        		throw exceptionService.buildBusinessException("JY00060010021000100", "当收款账户子类型为可用时，收款手续费账户子类型必须为可用");
        	}
        }else if(TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type())
        		&&TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_fee_account_out_accounting_type())){
        	   logger.info("-->当收款方式为损益时，收款手续费账户子类型必须为可用");
               throw exceptionService.buildBusinessException("JY00060010021000100", "当收款方式为损益时，收款手续费账户子类型必须为可用");
        }
        //收款方手续费账户出账金额,需小于等于【收款方收到金额】
        if (TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type()) && !StringUtils.isEmpty(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt())) {
            if (!compareAmt(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt(), tradeRequest.getBody().getReceive_account_in_accounting_amt())) {
                logger.info("--> " + "收款方手续费账户出账金额需要小于或等于收款方收到金额");
                throw exceptionService.buildBusinessException("JY00060010021000100", "收款方手续费账户出账金额需要小于或等于收款方收到金额");
            }
        } else if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type()) && !StringUtils.isEmpty(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt())) {
            if (!StringUtils.isEmpty(tradeRequest.getBody().getReceive_profit_loss_income_incr()) && !compareAmt(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt(), tradeRequest.getBody().getReceive_profit_loss_income_incr())) {
                logger.info("--> " + "收款方手续费账户出账金额需要小于或等于收款方收到金额");
                throw exceptionService.buildBusinessException("JY00060010021000100", "收款方手续费账户出账金额需要小于或等于收款方收到金额");
            } else if (!StringUtils.isEmpty(tradeRequest.getBody().getReceive_profit_loss_cost_decr()) && !compareAmt(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt(), tradeRequest.getBody().getReceive_profit_loss_cost_decr())) {
                logger.info("--> " + "收款方手续费账户出账金额需要小于或等于收款方收到金额");
                throw exceptionService.buildBusinessException("JY00060010021000100", "收款方手续费账户出账金额需要小于或等于收款方收到金额");
            }
        }
    }

    /**
     * 校验【交易发起方发起请求编号】是否重复
     * 校验【核心商户编号】、【资金池编号】对应关系
     * 校验【合作商户编号】权限（暂不实现）
     * 校验【付款方账户账户编号】正确性
     * 校验【付款方手续费账户账户编号】正确性
     * 校验【收款方账户账户编号】正确性
     * 校验【收款方手续费账户账户编号】正确性
     * 校验金额关系
     *
     * @throws Exception
     */
    private void bizValidate(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) throws Exception {
        //校验交易发起方请求编号是否重复
        checkDuplicate(tradeRequest);
        //校验【核心商户编号】、【资金池编号】对应关系
        TradeCommonValidation.validateCoreMerchantNoAndFundPoolNo(tradeRequest, false, exceptionService.buildBusinessException("JY00060010021000200"));
        //校验【付款方账户账户编号】正确性
        if (!StringUtils.isEmpty(tradeRequest.getBody().getPay_account_no())) {
            AdvanceAccountVO accountVo = getCreditAccountInfo(tradeRequest.getBody().getPay_account_no());
            if (accountVo == null || !(tradeRequest.getHead().getCore_merchant_no().equals(accountVo.getCoreMerchantNo()) && tradeRequest.getHead().getFund_pool_no().equals(accountVo.getPoolNo()))) {
                logger.info("--> " + "【付款方账户账户编号】与【核心商户编号】、【资金池编号】、【所属成员商户编号】 不对应");
                throw exceptionService.buildBusinessException("JY00060010011000500");
            } else {
                payMerchantNo = accountVo.getMerchantNo();
            }
        }
        //校验【付款方手续费账户账户编号】正确性
        if (!StringUtils.isEmpty(tradeRequest.getBody().getPay_fee_account_no())) {
            AdvanceAccountVO accountVo = getCreditAccountInfo(tradeRequest.getBody().getPay_fee_account_no());
            if (accountVo == null || !(tradeRequest.getHead().getCore_merchant_no().equals(accountVo.getCoreMerchantNo()) && tradeRequest.getHead().getFund_pool_no().equals(accountVo.getPoolNo()))) {
                logger.info("--> " + "【付款方手续费账户账户编号】与【核心商户编号】、【资金池编号】、【所属成员商户编号】 不对应");
                throw exceptionService.buildBusinessException("JY00060010011000600");
            } else {
                payFeeMerchantNo = accountVo.getMerchantNo();
            }
        }
        //校验【收款方账户账户编号】正确性
        if (!StringUtils.isEmpty(tradeRequest.getBody().getReceive_account_no())) {
            AdvanceAccountVO accountVo = getCreditAccountInfo(tradeRequest.getBody().getReceive_account_no());
            if (accountVo == null || !(tradeRequest.getHead().getCore_merchant_no().equals(accountVo.getCoreMerchantNo()) && tradeRequest.getHead().getFund_pool_no().equals(accountVo.getPoolNo()))) {
                logger.info("--> " + "【收款方账户账户编号】与【核心商户编号】、【资金池编号】、【所属成员商户编号】 不对应");
                throw exceptionService.buildBusinessException("JY00060010011000700");
            } else {
                receiveMerchantNo = accountVo.getMerchantNo();
            }
        }
        //校验【收款方手续费账户账户编号】正确性
        if (!StringUtils.isEmpty(tradeRequest.getBody().getReceive_fee_account_no())) {
            AdvanceAccountVO accountVo = getCreditAccountInfo(tradeRequest.getBody().getReceive_fee_account_no());
            if (accountVo == null || !(tradeRequest.getHead().getCore_merchant_no().equals(accountVo.getCoreMerchantNo()) && tradeRequest.getHead().getFund_pool_no().equals(accountVo.getPoolNo()))) {
                logger.info("--> " + "【收款方手续费账户账户编号】与【核心商户编号】、【资金池编号】、【所属成员商户编号】 不对应");
                throw exceptionService.buildBusinessException("JY00060010011000800");
            } else {
                receiveFeeMerchantNo = accountVo.getMerchantNo();
            }
        }
        //校验金额关系
        checkAmountRelation(tradeRequest);
    }

    /**
     * 校验以下各项金额，按照正负向分布汇总后应相等，若不等，校验失败，返回【失败】
     * 付款方外部收款金额	正向，【付款方付出方式】为【第三方充付】时不计算
     * 付款方账户出账金额	正向【付款方付出方式】为【第三方直付】时不计算
     * 付款方手续费账户出账金额	正向
     * 收款方账户入账金额	负向
     * 收款方损益收入增加金额	负向
     * 收款方损益成本费用减少金额	负向
     * 收款方手续费账户出账金额	正向
     * 其他损益台账X收入增加金额	负向
     * 其他损益台账X收入减少金额	正向
     * 其他损益台账X成本费用增加金额	正向
     * 其他损益台账X成本费用减少金额	负向
     *
     * @param tradeRequest
     */
    private void checkAmountRelation(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) {
        long positiveTotal = 0;
        long negativeTotal = 0;
        if (!TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getPay_type())) {
            positiveTotal += strToLong(tradeRequest.getBody().getExternal_pay_received_amt());//+
        }
        if (!TradeConstants.PAY_BY_THIRD.equals(tradeRequest.getBody().getPay_type())) {
            positiveTotal += strToLong(tradeRequest.getBody().getPay_account_out_accounting_amt());//+
        }
        positiveTotal += strToLong(tradeRequest.getBody().getPay_fee_account_out_accounting_amt());//+
        if(TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())){
        	negativeTotal += strToLong(tradeRequest.getBody().getReceive_account_in_accounting_amt());//-
        }else if(TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type())){
        	negativeTotal += strToLong(tradeRequest.getBody().getReceive_profit_loss_income_incr());//-
        	negativeTotal += strToLong(tradeRequest.getBody().getReceive_profit_loss_cost_decr());//-        	
        }
        positiveTotal += strToLong(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt());//+
        List<TradePacketReqBodyOtherPofitLossLedger> list = tradeRequest.getBody().getProfit_loss_list();
        if(list!=null){
        	for (TradePacketReqBodyOtherPofitLossLedger ledger : list) {
        		negativeTotal += strToLong(ledger.getIncome_incr());
        		positiveTotal += strToLong(ledger.getIncome_decr());
        		positiveTotal += strToLong(ledger.getCost_incr());
        		negativeTotal += strToLong(ledger.getCost_decr());
        	}
        }
        if (positiveTotal != negativeTotal) {
            logger.info("-->金额合计校验不通过！");
            throw exceptionService.buildBusinessException("JY00060010021000900");
        }
    }

    /**
     * @param tradeRequest
     * @throws Exception
     * @Title:checkDuplicate
     * @Description: 根据资金池标号和 交易发起方发起请求编号，检查交易发起方发起请求编号是否重复
     * @return:void
     */
    protected void checkDuplicate(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) throws Exception {
        TradeSinglePaymentExample tradeRechargeExample = new TradeSinglePaymentExample();
        tradeRechargeExample.createCriteria().andFundPoolNoEqualTo(tradeRequest.getHead().getFund_pool_no()).andOutTradeNoExtEqualTo(tradeRequest.getBody().getOut_trade_no_ext());
        List<TradeSinglePayment> list = singlePaymentService.queryByExample(tradeRechargeExample);
        if (!CollectionUtils.isEmpty(list)) {
            logger.info("-->交易发起方发起请求编号重复");
            throw exceptionService.buildBusinessException("JY00060010021000400");
        }
    }

    /**
     * @Description: 将字符串转换为数字
     */
    private long strToLong(String str) {
        long parseNum = 0;
        if (!StringUtils.isEmpty(str)) {
            try {
                parseNum = AmountUtils.bizAmountConvertToLong(str);
            } catch (AmountConvertException e) {
                e.printStackTrace();
                logger.error("-->金额转换异常，输入金额：" + str, e);
                throw exceptionService.buildBusinessException("JY000000000000201");
            }
        }
        return parseNum;
    }

    private Long str2Long(String str) {
        if (str != null) {
            try {
                return AmountUtils.bizAmountConvertToLong(str);
            } catch (AmountConvertException e) {
                e.printStackTrace();
                logger.error("-->金额转换异常，输入金额：" + str, e);
                throw exceptionService.buildBusinessException("JY000000000000201");
            }
        }
        return null;
    }


    /**
     * 创建等待入账交易记录
     *
     * @param tradeRequest
     * @param currentTime
     */
    private void createTradeRecordWaitForPosting(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest, Date currentTime) {
        TradeSinglePayment tradeSinglePayment = new TradeSinglePayment();
        try {
            /**
             * 交易公共部分
             */
            tradeSinglePayment.setTradeNo(this.tradeNo);
            tradeSinglePayment.setCoreMerchantNo(tradeRequest.getHead().getCore_merchant_no());//核心商户编号
            tradeSinglePayment.setFundPoolNo(tradeRequest.getHead().getFund_pool_no());//资金池编号
            tradeSinglePayment.setPartnerId(tradeRequest.getHead().getPartner_id());
            tradeSinglePayment.setMerchantExtendField1(tradeRequest.getBody().getMerchant_extend_field_1());//交易客户保留字段1
            tradeSinglePayment.setMerchantExtendField2(tradeRequest.getBody().getMerchant_extend_field_2());//交易客户保留字段2
            tradeSinglePayment.setMerchantExtendField3(tradeRequest.getBody().getMerchant_extend_field_3());//交易客户保留字段3
            tradeSinglePayment.setMerchantExtendField4(tradeRequest.getBody().getMerchant_extend_field_4());//交易客户保留字段4
            tradeSinglePayment.setMerchantExtendField5(tradeRequest.getBody().getMerchant_extend_field_5());//交易客户保留字段5
            tradeSinglePayment.setMerchantExtendField6(tradeRequest.getBody().getMerchant_extend_field_6());//交易客户保留字段6
            tradeSinglePayment.setMerchantExtendField7(tradeRequest.getBody().getMerchant_extend_field_7());//交易客户保留字段7
            tradeSinglePayment.setMerchantExtendField8(tradeRequest.getBody().getMerchant_extend_field_8());//交易客户保留字段8
            tradeSinglePayment.setMerchantExtendField9(tradeRequest.getBody().getMerchant_extend_field_9());//交易客户保留字段9
            tradeSinglePayment.setMerchantExtendField10(tradeRequest.getBody().getMerchant_extend_field_10());//交易客户保留字段10
            tradeSinglePayment.setOutTradeNoExt(tradeRequest.getBody().getOut_trade_no_ext());//交易发起方发起请求编号
            tradeSinglePayment.setOutTradeNo(tradeRequest.getBody().getOut_trade_no());//交易发起方业务系统订单号
            tradeSinglePayment.setGmtCreated(currentTime);//交易创建日期时间
            tradeSinglePayment.setGmtModifiedLatest(currentTime);//最后变更日期时间
            tradeSinglePayment.setLatestTradeReqType(tradeRequest.getHead().getRequest_code());//最后变更交易请求类型
            tradeSinglePayment.setLatestReqNo(this.reqNo);//最后变更交易请求编号
            tradeSinglePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);//交易结束状态  ---未结束
            tradeSinglePayment.setStatus(TradeConstants.TRADE_PAYMENT_WAIT_ENTER);//交易状态  ---等待入账
            tradeSinglePayment.setTradeCatagory(TradeConstants.PAY_TYPE_BY_THIRD);
            ;//交易组别    1.内部支付  2.外部支付
            tradeSinglePayment.setVersion(INIT_VERSION);//交易版本
            /**
             *  交易时间部分
             */
            tradeSinglePayment.setGmtWaitInAccountting(currentTime);//等待入账日期时间
            /**
             * 付款方基本部分
             */
            //付款方付出金额---账户、第三方充付、损益充付与付款方账户出账金额相同
            if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getPay_type())) {
                tradeSinglePayment.setPayAmt(strToLong(tradeRequest.getBody().getPay_account_out_accounting_amt()));
                //付款方付出金额---第三方支付、损益直付与台账付出金额相同
            } else if (TradeConstants.PAY_BY_THIRD.equals(tradeRequest.getBody().getPay_type())) {
                tradeSinglePayment.setPayAmt(strToLong(tradeRequest.getBody().getExternal_pay_received_amt()));
            }
            tradeSinglePayment.setPayType(tradeRequest.getBody().getPay_type());//付款方付出方式
            /**
             * 付出方外部部分
             */
            tradeSinglePayment.setExternalPayLedgerNo(this.payLedgerNo);//付款方外部业务台账编号
            tradeSinglePayment.setExternalPayChannel(tradeRequest.getBody().getExternal_pay_channel());//付款方外部收付款渠道编号
            tradeSinglePayment.setExternalPayChannelFeeAmt(strToLong(tradeRequest.getBody().getExternal_pay_channel_fee_amt()));//付款方外部收付款属性1（付出手续费金额）
            tradeSinglePayment.setExternalPayChannelRefundFeeAmt(strToLong(tradeRequest.getBody().getExternal_pay_channel_refund_fee_amt()));//付款方外部收付款属性2（退回手续费金额）
            tradeSinglePayment.setExternalPayReceivedAmt(strToLong(tradeRequest.getBody().getExternal_pay_received_amt()));//付款方外部收款金额
            tradeSinglePayment.setGmtSuccessExternalPayChannel(DateUtil.formatDateTime(tradeRequest.getBody().getGmt_success_external_pay_channel()));//付款方外部渠道收付款成功日期时间
            tradeSinglePayment.setExternalPayChannelTradeNo(tradeRequest.getBody().getExternal_pay_channel_trade_no());//付款方外部收付款渠道订单号
            tradeSinglePayment.setExternalPayChannelBatchNo(tradeRequest.getBody().getExternal_pay_channel_batch_no());//付款方外部收付款备注4【提交第三方批次号】
            tradeSinglePayment.setExternalPayChannelSerialNo(tradeRequest.getBody().getExternal_pay_channel_serial_no());//付款方外部收付款备注5【提交第三方请求流水号】
            /**
             * 付出方账户部分
             */
            tradeSinglePayment.setPayAccountNo(tradeRequest.getBody().getPay_account_no());//付款方账户账户编号
            tradeSinglePayment.setPayAccountMerchantNo(this.payMerchantNo);//付款方账户所属商户编号
            tradeSinglePayment.setPayAccountOutAccountingAmt(strToLong(tradeRequest.getBody().getPay_account_out_accounting_amt()));//付款方账户出账金额
            tradeSinglePayment.setPayAccountOutAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);//付款方账户出账子账户类型
            tradeSinglePayment.setPayAccountOutAccountingHis1(tradeRequest.getBody().getPay_account_out_accounting_his1());//付款方账户出账账务历史1
            tradeSinglePayment.setPayAccountOutAccountingHis2(tradeRequest.getBody().getPay_account_out_accounting_his2());//付款方账户出账账务历史2
            tradeSinglePayment.setPayAccountOutAccountingHis3(tradeRequest.getBody().getPay_account_out_accounting_his3());//付款方账户出账账务历史3
            tradeSinglePayment.setPayAccountInAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);//付款方账户入账子账户类型
            tradeSinglePayment.setPayAccountInAccountingHis1(tradeRequest.getBody().getPay_account_in_accounting_his1());//付款方账户入账账务历史1
            tradeSinglePayment.setPayAccountInAccountingHis2(tradeRequest.getBody().getPay_account_in_accounting_his2());//付款方账户入账账务历史2
            tradeSinglePayment.setPayAccountInAccountingHis3(tradeRequest.getBody().getPay_account_in_accounting_his3());//付款方账户入账账务历史3
            /**
             * 付款方手续费账户部分
             */
            tradeSinglePayment.setPayFeeAccountNo(tradeRequest.getBody().getPay_fee_account_no());//付款方手续费账户账户编号
            tradeSinglePayment.setPayFeeAccountMerchantNo(this.payFeeMerchantNo);//付款方手续费账户所属商户编号
            tradeSinglePayment.setPayFeeAccountOutAccountingAmt(strToLong(tradeRequest.getBody().getPay_fee_account_out_accounting_amt()));//付款方手续费账户出账金额
            tradeSinglePayment.setPayFeeAccountOutAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);//付款方手续费账户出账子账户类型
            tradeSinglePayment.setPayFeeAccountOutAccountingHis1(tradeRequest.getBody().getPay_fee_account_out_accounting_his1());//付款方手续费账户出账账务历史1
            tradeSinglePayment.setPayFeeAccountOutAccountingHis2(tradeRequest.getBody().getPay_fee_account_out_accounting_his2());//付款方手续费账户出账账务历史2
            tradeSinglePayment.setPayFeeAccountOutAccountingHis3(tradeRequest.getBody().getPay_fee_account_out_accounting_his3());//付款方手续费账户出账账务历史3
            /**
             * 收到方基本部分
             */
            //收款方收到金额
            if (TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())) {//收款方式为账户
                tradeSinglePayment.setReceiveAmt(strToLong(tradeRequest.getBody().getReceive_account_in_accounting_amt()));
            } else if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type()) && null != tradeRequest.getBody().getReceive_profit_loss_income_incr()) {//收款方式为损益
                tradeSinglePayment.setReceiveAmt(strToLong(tradeRequest.getBody().getReceive_profit_loss_income_incr()));
            } else if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type()) && null != tradeRequest.getBody().getReceive_profit_loss_cost_decr()) {//收款方式为损益
                tradeSinglePayment.setReceiveAmt(strToLong(tradeRequest.getBody().getReceive_profit_loss_cost_decr()));
            }
            tradeSinglePayment.setReceiveType(tradeRequest.getBody().getReceive_type());//收款方收到方式
            /**
             * 收到方损益部分
             */
            if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type())) {
                tradeSinglePayment.setReceiveProfitLossLedgerNo(this.receiveProfitLossLedgerNo);//收款方损益业务台账编号
                tradeSinglePayment.setReceiveProfitLossIncomeIncr(str2Long(tradeRequest.getBody().getReceive_profit_loss_income_incr()));//收款方损益收入增加金额
                tradeSinglePayment.setReceiveProfitLossCostDecr(str2Long(tradeRequest.getBody().getReceive_profit_loss_cost_decr()));////收款方损益成本费用减少金额
            }
            /**
             * 收到方账户部分
             */
            if (TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())) {
                tradeSinglePayment.setReceiveAccountNo(tradeRequest.getBody().getReceive_account_no());//收款方账户账户编号
                tradeSinglePayment.setReceiveAccountMerchantNo(this.receiveMerchantNo);//收款方账户所属商户编号
                tradeSinglePayment.setReceiveAccountInAccountingAmt(strToLong(tradeRequest.getBody().getReceive_account_in_accounting_amt()));//收款方账户入账金额
                tradeSinglePayment.setReceiveAccountInAccountingType(tradeRequest.getBody().getReceive_account_in_accounting_type());//收款方账户入账子账户类型
                tradeSinglePayment.setReceiveAccountInAccountingHis1(tradeRequest.getBody().getReceive_account_in_accounting_his1());//收款方账户入账账务历史1
                tradeSinglePayment.setReceiveAccountInAccountingHis2(tradeRequest.getBody().getReceive_account_in_accounting_his2());//收款方账户入账账务历史2
                tradeSinglePayment.setReceiveAccountInAccountingHis3(tradeRequest.getBody().getReceive_account_in_accounting_his3());//收款方账户入账账务历史3
            }
            /**
             * 收款方手续费账户部分
             */
            tradeSinglePayment.setReceiveFeeAccountNo(tradeRequest.getBody().getReceive_fee_account_no());//收款方手续费账户账户编号
            tradeSinglePayment.setReceiveFeeAccountMerchantNo(this.receiveFeeMerchantNo);//收款方手续费账户所属商户编号
            tradeSinglePayment.setReceiveFeeAccountOutAccountingAmt(strToLong(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt()));//收款方手续费账户出账金额
            tradeSinglePayment.setReceiveFeeAccountOutAccountingType(tradeRequest.getBody().getReceive_fee_account_out_accounting_type());//收款方手续费账户出账子账户类型
            tradeSinglePayment.setReceiveFeeAccountOutAccountingHis1(tradeRequest.getBody().getReceive_fee_account_out_accounting_his1());//收款方手续费账户出账账务历史1
            tradeSinglePayment.setReceiveFeeAccountOutAccountingHis2(tradeRequest.getBody().getReceive_fee_account_out_accounting_his2());//收款方手续费账户出账账务历史2
            tradeSinglePayment.setReceiveFeeAccountOutAccountingHis3(tradeRequest.getBody().getReceive_fee_account_out_accounting_his3());//收款方手续费账户出账账务历史3

            /**
             * 其他损益台账List部分
             */
            tradeSinglePayment.setExtendProfitLoss(this.jsonList);
            /**
             * 累计金额部分
             */
            tradeSinglePayment.setContinueTradeStatus(TradeConstants.CONTINUE_TRADE_STATUS_OPEN);//后续交易开关
            this.tradeSinglePayment = singlePaymentService.createForEnterOfWait(tradeSinglePayment);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->等待入账交易记录创建失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060010021001000");
        }
    }

    /**
     * 创建空白收款损益台账
     *
     * @param tradeRequest
     * @param currentTime
     */
    private void createBlankProfitLossLegder(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest, Date currentTime) {
        if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type())) {
            try {
                TradeProfitLossLedger receiveProfitLossLedger = new TradeProfitLossLedger();
                receiveProfitLossLedger.setCoreMerchantNo(tradeRequest.getHead().getCore_merchant_no());//收款方损益核心商户编号
                receiveProfitLossLedger.setFundPoolNo(tradeRequest.getHead().getFund_pool_no());//收款方损益资金池编号
                receiveProfitLossLedger.setMerchantExtendField1(tradeRequest.getBody().getReceive_profit_loss_extend_field_1());//收款方损益业务台账客户保留字段1
                receiveProfitLossLedger.setMerchantExtendField2(tradeRequest.getBody().getReceive_profit_loss_extend_field_2());//收款方损益业务台账客户保留字段2
                receiveProfitLossLedger.setMerchantExtendField3(tradeRequest.getBody().getReceive_profit_loss_extend_field_3());//收款方损益业务台账客户保留字段3
                receiveProfitLossLedger.setTradeType(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code()));//收款方损益所属业务交易类型
                receiveProfitLossLedger.setTradeNo(this.tradeNo);//收款方损益所属业务交易编号
                receiveProfitLossLedger.setGmtTradeCreated(currentTime);//收款方损益所属业务交易创建日期v
                receiveProfitLossLedger.setCreateReqType(tradeRequest.getHead().getRequest_code());//收款方损益创建交易请求类型
                receiveProfitLossLedger.setCreateReqNo(this.reqNo);//收款方损益创建交易请求编号
                receiveProfitLossLedger.setOutTradeNoExt(tradeRequest.getBody().getOut_trade_no_ext());//交易发起方发起请求编号
                receiveProfitLossLedger.setOutTradeNo(tradeRequest.getBody().getOut_trade_no());//交易发起方业务系统订单号
                receiveProfitLossLedger.setProfitLossAttr1(tradeRequest.getBody().getReceive_profit_loss_attr_1());//收款方损益损益属性1
                receiveProfitLossLedger.setProfitLossAttr2(tradeRequest.getBody().getReceive_profit_loss_attr_2());//收款方损益损益属性2
                receiveProfitLossLedger.setProfitLossAttr3(tradeRequest.getBody().getReceive_profit_loss_attr_3());//收款方损益损益属性3
                receiveProfitLossLedger.setProfitLossAttr4(tradeRequest.getBody().getReceive_profit_loss_attr_4());//收款方损益损益属性4
                receiveProfitLossLedger.setProfitLossAttr5(tradeRequest.getBody().getReceive_profit_loss_attr_5());//收款方损益损益属性5
                receiveProfitLossLedger.setProfitLossAttr6(tradeRequest.getBody().getReceive_profit_loss_attr_6());//收款方损益损益属性6
                receiveProfitLossLedger.setProfitLossAttr7(tradeRequest.getBody().getReceive_profit_loss_attr_7());//收款方损益损益属性7
                receiveProfitLossLedger.setProfitLossAttr8(tradeRequest.getBody().getReceive_profit_loss_attr_8());//收款方损益损益属性8
                receiveProfitLossLedger.setProfitLossAttr9(tradeRequest.getBody().getReceive_profit_loss_attr_9());//收款方损益损益属性9
                receiveProfitLossLedger.setProfitLossAttr10(tradeRequest.getBody().getReceive_profit_loss_attr_10());//收款方损益损益属性10
                receiveProfitLossLedger.setIncomeIncr(str2Long(tradeRequest.getBody().getReceive_profit_loss_income_incr()));//收款方损益收入增加金额
                receiveProfitLossLedger.setCostDecr(str2Long(tradeRequest.getBody().getReceive_profit_loss_cost_decr()));//收款方损益成本费用减少金额
                this.receiveProfitLossLedgerNo = profitLossLedgerService.createBlankProfitLossLedger(receiveProfitLossLedger);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("-->创建空白收款损益台账失败：" + e.getMessage(), e);
                throw exceptionService.buildBusinessException("TZ000200201");
            }
        }
    }

    /**
     * 创建其他空白损益台账
     *
     * @param tradeRequest
     * @param currentTime
     */
    private void createExtendBlankProfitLossLegder(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest, Date currentTime) {
        try {
            String core_merchant_no = tradeRequest.getHead().getCore_merchant_no();
            String fund_pool_no = tradeRequest.getHead().getFund_pool_no();
            List<TradePacketReqBodyOtherPofitLossLedger> list = tradeRequest.getBody().getProfit_loss_list();
            List<OtherPofitLossLedgerForRefund> otherList = new ArrayList<OtherPofitLossLedgerForRefund>();
            this.otherProfitLossLedgerList = new ArrayList<TradeProfitLossLedger>();
            if (null != list && list.size() > 0) {
                for (TradePacketReqBodyOtherPofitLossLedger ledger : list) {
                    TradeProfitLossLedger profitLossLedger = new TradeProfitLossLedger();
                    profitLossLedger.setCoreMerchantNo(core_merchant_no);
                    profitLossLedger.setFundPoolNo(fund_pool_no);
                    profitLossLedger.setMerchantExtendField1(ledger.getMerchant_extend_field_1());
                    profitLossLedger.setMerchantExtendField2(ledger.getMerchant_extend_field_2());
                    profitLossLedger.setMerchantExtendField3(ledger.getMerchant_extend_field_3());
                    profitLossLedger.setTradeType(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code()));
                    profitLossLedger.setTradeNo(this.tradeNo);
                    profitLossLedger.setGmtTradeCreated(currentTime);//交易创建日期
                    profitLossLedger.setCreateReqType(tradeRequest.getHead().getRequest_code());//创建交易请求类型
                    profitLossLedger.setCreateReqNo(this.reqNo);//创建交易请求编号
                    profitLossLedger.setOutTradeNoExt(tradeRequest.getBody().getOut_trade_no_ext());//交易发起方发起请求编号
                    profitLossLedger.setOutTradeNo(tradeRequest.getBody().getOut_trade_no());//交易发起方业务系统订单号
                    profitLossLedger.setProfitLossAttr1(ledger.getProfit_loss_attr_1());//损益属性1
                    profitLossLedger.setProfitLossAttr2(ledger.getProfit_loss_attr_2());//损益属性2
                    profitLossLedger.setProfitLossAttr3(ledger.getProfit_loss_attr_3());//损益属性3
                    profitLossLedger.setProfitLossAttr4(ledger.getProfit_loss_attr_4());//损益属性4
                    profitLossLedger.setProfitLossAttr5(ledger.getProfit_loss_attr_5());//损益属性5
                    profitLossLedger.setProfitLossAttr6(ledger.getProfit_loss_attr_6());//损益属性6
                    profitLossLedger.setProfitLossAttr7(ledger.getProfit_loss_attr_7());//损益属性7
                    profitLossLedger.setProfitLossAttr8(ledger.getProfit_loss_attr_8());//损益属性8
                    profitLossLedger.setProfitLossAttr9(ledger.getProfit_loss_attr_9());//损益属性9
                    profitLossLedger.setProfitLossAttr10(ledger.getProfit_loss_attr_10());//损益属性10
                    profitLossLedger.setIncomeIncr(str2Long(ledger.getIncome_incr()));//损益收入增加金额
                    profitLossLedger.setIncomeDecr(str2Long(ledger.getIncome_decr()));//损益收入减少金额
                    profitLossLedger.setCostIncr(str2Long(ledger.getCost_incr()));//损益成本费用减少金额
                    profitLossLedger.setCostDecr(str2Long(ledger.getCost_decr()));//损益成本费用减少金额
                    this.otherProfitLossLedgerNo = profitLossLedgerService.createBlankProfitLossLedger(profitLossLedger);
                    this.otherProfitLossLedgerList.add(profitLossLedger);
                    //交易记录其他损益台账
                    OtherPofitLossLedgerForRefund other = new OtherPofitLossLedgerForRefund();
                    other.setLedger_no(otherProfitLossLedgerNo);
                    other.setIncome_incr(ledger.getIncome_incr());
                    other.setIncome_decr(ledger.getIncome_decr());
                    other.setCost_incr(ledger.getCost_incr());
                    other.setCost_decr(ledger.getCost_decr());
                    otherList.add(other);
                }
                this.jsonList = ObjectJsonUtil.object2String(otherList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->创建其他空白损益台账失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("TZ000200201");
        }

    }


    /**
     * 
     * @Description: 创建生效付款方外部收款台账
     * @author JiangKun
     * @date 2016年6月16日 下午2:45:35
     */
    private void createEffectiveLegder(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest, Date currentTime) {
        try {
            TradeLedger ledger = new TradeLedger();
            ledger.setCoreMerchantNo(tradeRequest.getHead().getCore_merchant_no());// 核心商户编号
            ledger.setFundPoolNo(tradeRequest.getHead().getFund_pool_no());// 资金池编号

            ledger.setMerchantExtendField1(tradeRequest.getBody().getExternal_pay_merchant_extend_field_1());// 付款方外部业务台账客户保留字段1
            ledger.setMerchantExtendField2(tradeRequest.getBody().getExternal_pay_merchant_extend_field_2());// 付款方外部业务台账客户保留字段2
            ledger.setMerchantExtendField3(tradeRequest.getBody().getExternal_pay_merchant_extend_field_3());// 付款方外部业务台账客户保留字段3
            ledger.setTradeType(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code())); // 业务交易类型（例：0006_001）
            ledger.setTradeNo(this.tradeNo); //业务交易编号
            ledger.setGmtTradeCreated(currentTime); //业务交易创建日期
            ledger.setCreateReqType(tradeRequest.getHead().getRequest_code());//创建交易请求类型
            ledger.setCreateReqNo(this.reqNo);//创建交易请求编号
            ledger.setEffectiveReqType(tradeRequest.getHead().getRequest_code());//生效的请求类型
            ledger.setEffectiveReqNo(this.reqNo);//生效交易请求编号
            ledger.setOutTradeNo(tradeRequest.getBody().getOut_trade_no());// 交易发起方业务系统订单号
            ledger.setOutTradeNoExt(tradeRequest.getBody().getOut_trade_no_ext());//付款方外部交易发起方发起请求编号
            ledger.setClearChannel(tradeRequest.getBody().getExternal_pay_channel()); //付款方外部收付款渠道编号
            ledger.setClearChannelAttr1(Long.toString(strToLong(tradeRequest.getBody().getExternal_pay_channel_fee_amt())));//付款方外部收付款属性1（付出手续费金额）
            ledger.setClearChannelAttr2(Long.toString(strToLong(tradeRequest.getBody().getExternal_pay_channel_refund_fee_amt())));//付款方外部收付款属性2（退回手续费金额）
            ledger.setClearChannelAttr3(tradeRequest.getBody().getExternal_pay_channel_attr_3());//付款方外部收付款属性3
            ledger.setClearChannelAttr4(tradeRequest.getBody().getExternal_pay_channel_attr_4());//付款方外部收付款属性4
            ledger.setClearChannelAttr5(tradeRequest.getBody().getExternal_pay_channel_attr_5());//付款方外部收付款属性5
            ledger.setClearChannelAttr6(tradeRequest.getBody().getExternal_pay_channel_attr_6());//付款方外部收付款属性6
            ledger.setExtendField1(tradeRequest.getBody().getExternal_pay_channel_transaction_id()); //付款方外部收付款备注1【支付渠道身份编号】
            ledger.setExtendField2(tradeRequest.getBody().getExternal_pay_channel_pay_account_no());//收付款方外部收付款备注2【付款方账户】
            ledger.setExtendField3(tradeRequest.getBody().getExternal_pay_channel_pay_account_name());//付款方外部收付款备注3【付款方账户名称】
            ledger.setExtendField4(tradeRequest.getBody().getExternal_pay_channel_batch_no());//付款方外部收付款备注4【提交第三方批次号】
            ledger.setExtendField5(tradeRequest.getBody().getExternal_pay_channel_serial_no());//付款方外部收付款备注5【提交第三方请求流水号】
            ledger.setExtendField6(tradeRequest.getBody().getExternal_pay_channel_receive_account_no());//付款方外部收付款备注6【收款方账户】
            ledger.setExtendField7(tradeRequest.getBody().getExternal_pay_channel_receive_account_name());//付款方外部收付款备注7【收款方账户名称】
            ledger.setExtendField8(tradeRequest.getBody().getExternal_pay_channel_field_8());//付款方外部收付款备注8
            ledger.setExtendField9(tradeRequest.getBody().getExternal_pay_channel_field_9());//付款方外部收付款备注9
            ledger.setExtendField10(tradeRequest.getBody().getExternal_pay_channel_field_10());//付款方外部收付款备注10
            ledger.setExtendField11(tradeRequest.getBody().getGmt_external_pay_channel_clear());//付款方外部收付款备注11【清算日期】
            ledger.setExtendField12(tradeRequest.getBody().getGmt_external_pay_accounting());//付款方外部收付款备注12【出入账日期】
            ledger.setExtendField13(tradeRequest.getBody().getExternal_pay_channel_field_13());//付款方外部收付款备注13
            ledger.setExtendField14(tradeRequest.getBody().getExternal_pay_channel_field_14());//付款方外部收付款备注14
            ledger.setExtendField15(tradeRequest.getBody().getExternal_pay_channel_field_15());//付款方外部收付款备注15
            ledger.setReceiveAmount(strToLong(tradeRequest.getBody().getExternal_pay_received_amt()));//付款方外部收款金额
            Date gmtSuccessClearChannel = DateUtil.formatDateTime(tradeRequest.getBody().getGmt_success_external_pay_channel());
            ledger.setGmtSuccessClearChannel(gmtSuccessClearChannel);//外部渠道收付款成功日期时间
            ledger.setThirdTradeNo(tradeRequest.getBody().getExternal_pay_channel_trade_no());//付款方外部收付款渠道订单号
            this.payLedgerNo = legderService.createEffectiveLegder(ledger);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->创建生效付款方外部收款台账失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("TZ000100101");
        }
    }

    /**
     * @Description: 创建支付失败交易记录
     * @author JiangKun
     * @date 2016年6月16日 下午2:44:40 
     */
    private void createRecordPaymentFailed(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest, Date currentTime) {
        TradeSinglePayment tradeSinglePayment = new TradeSinglePayment();
        try {
            /**
             * 交易公共部分
             */
            tradeSinglePayment.setTradeNo(this.tradeNo);
            tradeSinglePayment.setCoreMerchantNo(tradeRequest.getHead().getCore_merchant_no());//核心商户编号
            tradeSinglePayment.setFundPoolNo(tradeRequest.getHead().getFund_pool_no());//资金池编号
            tradeSinglePayment.setPartnerId(tradeRequest.getHead().getPartner_id());
            tradeSinglePayment.setMerchantExtendField1(tradeRequest.getBody().getMerchant_extend_field_1());//交易客户保留字段1
            tradeSinglePayment.setMerchantExtendField2(tradeRequest.getBody().getMerchant_extend_field_2());//交易客户保留字段2
            tradeSinglePayment.setMerchantExtendField3(tradeRequest.getBody().getMerchant_extend_field_3());//交易客户保留字段3
            tradeSinglePayment.setMerchantExtendField4(tradeRequest.getBody().getMerchant_extend_field_4());//交易客户保留字段4
            tradeSinglePayment.setMerchantExtendField5(tradeRequest.getBody().getMerchant_extend_field_5());//交易客户保留字段5
            tradeSinglePayment.setMerchantExtendField6(tradeRequest.getBody().getMerchant_extend_field_6());//交易客户保留字段6
            tradeSinglePayment.setMerchantExtendField7(tradeRequest.getBody().getMerchant_extend_field_7());//交易客户保留字段7
            tradeSinglePayment.setMerchantExtendField8(tradeRequest.getBody().getMerchant_extend_field_8());//交易客户保留字段8
            tradeSinglePayment.setMerchantExtendField9(tradeRequest.getBody().getMerchant_extend_field_9());//交易客户保留字段9
            tradeSinglePayment.setMerchantExtendField10(tradeRequest.getBody().getMerchant_extend_field_10());//交易客户保留字段10
            tradeSinglePayment.setOutTradeNoExt(tradeRequest.getBody().getOut_trade_no_ext());//交易发起方发起请求编号
            tradeSinglePayment.setOutTradeNo(tradeRequest.getBody().getOut_trade_no());//交易发起方业务系统订单号
            tradeSinglePayment.setGmtCreated(currentTime);//交易创建日期时间
            tradeSinglePayment.setGmtModifiedLatest(currentTime);//最后变更日期时间
            tradeSinglePayment.setLatestTradeReqType(tradeRequest.getHead().getRequest_code());//最后变更交易请求类型
            tradeSinglePayment.setLatestReqNo(this.reqNo);//最后变更交易请求编号
            tradeSinglePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//交易结束状态  ---结束
            tradeSinglePayment.setStatus(TradeConstants.TRADE_PAYMENT_PAY_FAIL);//交易状态  ---等待入账
            tradeSinglePayment.setTradeCatagory(TradeConstants.PAY_TYPE_BY_THIRD);
            ;//交易组别    1.内部支付  2.外部支付
            tradeSinglePayment.setVersion(INIT_VERSION);//交易版本
            /**
             *  交易失败时间部分
             */
            tradeSinglePayment.setGmtFailPay(currentTime);//支付失败日期时间
            /**
             * 付款方基本部分
             */
            //付款方付出金额---账户、第三方充付、损益充付与付款方账户出账金额相同
            if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getPay_type())) {
                tradeSinglePayment.setPayAmt(strToLong(tradeRequest.getBody().getPay_account_out_accounting_amt()));
                //付款方付出金额---第三方支付、损益直付与台账付出金额相同
            } else if (TradeConstants.PAY_BY_THIRD.equals(tradeRequest.getBody().getPay_type())) {
                tradeSinglePayment.setPayAmt(strToLong(tradeRequest.getBody().getExternal_pay_received_amt()));
            }
            tradeSinglePayment.setPayType(tradeRequest.getBody().getPay_type());//付款方付出方式
            /**
             * 付出方外部部分
             */
            tradeSinglePayment.setExternalPayChannel(tradeRequest.getBody().getExternal_pay_channel());//付款方外部收付款渠道编号
            tradeSinglePayment.setExternalPayChannelFeeAmt(strToLong(tradeRequest.getBody().getExternal_pay_channel_fee_amt()));//付款方外部收付款属性1（付出手续费金额）
            tradeSinglePayment.setExternalPayChannelRefundFeeAmt(strToLong(tradeRequest.getBody().getExternal_pay_channel_refund_fee_amt()));//付款方外部收付款属性2（退回手续费金额）
            tradeSinglePayment.setExternalPayReceivedAmt(strToLong(tradeRequest.getBody().getExternal_pay_received_amt()));//付款方外部收款金额
            tradeSinglePayment.setGmtSuccessExternalPayChannel(DateUtil.formatDateTime(tradeRequest.getBody().getGmt_success_external_pay_channel()));//付款方外部渠道收付款成功日期时间
            tradeSinglePayment.setExternalPayChannelTradeNo(tradeRequest.getBody().getExternal_pay_channel_trade_no());//付款方外部收付款渠道订单号
            tradeSinglePayment.setExternalPayChannelBatchNo(tradeRequest.getBody().getExternal_pay_channel_batch_no());//付款方外部收付款备注4【提交第三方批次号】
            tradeSinglePayment.setExternalPayChannelSerialNo(tradeRequest.getBody().getExternal_pay_channel_serial_no());//付款方外部收付款备注5【提交第三方请求流水号】
            /**
             * 付出方账户部分
             */
            tradeSinglePayment.setPayAccountNo(tradeRequest.getBody().getPay_account_no());//付款方账户账户编号
            tradeSinglePayment.setPayAccountMerchantNo(this.payMerchantNo);//付款方账户所属商户编号
            tradeSinglePayment.setPayAccountOutAccountingAmt(strToLong(tradeRequest.getBody().getPay_account_out_accounting_amt()));//付款方账户出账金额
            tradeSinglePayment.setPayAccountOutAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);//付款方账户出账子账户类型
            tradeSinglePayment.setPayAccountOutAccountingHis1(tradeRequest.getBody().getPay_account_out_accounting_his1());//付款方账户出账账务历史1
            tradeSinglePayment.setPayAccountOutAccountingHis2(tradeRequest.getBody().getPay_account_out_accounting_his2());//付款方账户出账账务历史2
            tradeSinglePayment.setPayAccountOutAccountingHis3(tradeRequest.getBody().getPay_account_out_accounting_his3());//付款方账户出账账务历史3
            tradeSinglePayment.setPayAccountInAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);//付款方账户入账子账户类型
            tradeSinglePayment.setPayAccountInAccountingHis1(tradeRequest.getBody().getPay_account_in_accounting_his1());//付款方账户入账账务历史1
            tradeSinglePayment.setPayAccountInAccountingHis2(tradeRequest.getBody().getPay_account_in_accounting_his2());//付款方账户入账账务历史2
            tradeSinglePayment.setPayAccountInAccountingHis3(tradeRequest.getBody().getPay_account_in_accounting_his3());//付款方账户入账账务历史3
            /**
             * 付款方手续费账户部分
             */
            tradeSinglePayment.setPayFeeAccountNo(tradeRequest.getBody().getPay_fee_account_no());//付款方手续费账户账户编号
            tradeSinglePayment.setPayFeeAccountMerchantNo(this.payFeeMerchantNo);//付款方手续费账户所属商户编号
            tradeSinglePayment.setPayFeeAccountOutAccountingAmt(strToLong(tradeRequest.getBody().getPay_fee_account_out_accounting_amt()));//付款方手续费账户出账金额
            tradeSinglePayment.setPayFeeAccountOutAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);//付款方手续费账户出账子账户类型
            tradeSinglePayment.setPayFeeAccountOutAccountingHis1(tradeRequest.getBody().getPay_fee_account_out_accounting_his1());//付款方手续费账户出账账务历史1
            tradeSinglePayment.setPayFeeAccountOutAccountingHis2(tradeRequest.getBody().getPay_fee_account_out_accounting_his2());//付款方手续费账户出账账务历史2
            tradeSinglePayment.setPayFeeAccountOutAccountingHis3(tradeRequest.getBody().getPay_fee_account_out_accounting_his3());//付款方手续费账户出账账务历史3
            /**
             * 收到方基本部分
             */
            //收款方收到金额
            if (TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())) {//收款方式为账户
                tradeSinglePayment.setReceiveAmt(strToLong(tradeRequest.getBody().getReceive_account_in_accounting_amt()));
            } else if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type()) && null != tradeRequest.getBody().getReceive_profit_loss_income_incr()) {//收款方式为损益
                tradeSinglePayment.setReceiveAmt(strToLong(tradeRequest.getBody().getReceive_profit_loss_income_incr()));
            } else if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type()) && null != tradeRequest.getBody().getReceive_profit_loss_cost_decr()) {//收款方式为损益
                tradeSinglePayment.setReceiveAmt(strToLong(tradeRequest.getBody().getReceive_profit_loss_cost_decr()));
            }
            tradeSinglePayment.setReceiveType(tradeRequest.getBody().getReceive_type());//收款方收到方式
            /**
             * 收到方损益部分
             */
            tradeSinglePayment.setReceiveProfitLossIncomeIncr(str2Long(tradeRequest.getBody().getReceive_profit_loss_income_incr()));//收款方损益收入增加金额
            tradeSinglePayment.setReceiveProfitLossCostDecr(str2Long(tradeRequest.getBody().getReceive_profit_loss_cost_decr()));////收款方损益成本费用减少金额
            /**
             * 收到方账户部分
             */
            tradeSinglePayment.setReceiveAccountNo(tradeRequest.getBody().getReceive_account_no());//收款方账户账户编号
            tradeSinglePayment.setReceiveAccountMerchantNo(this.receiveMerchantNo);//收款方账户所属商户编号
            tradeSinglePayment.setReceiveAccountInAccountingAmt(strToLong(tradeRequest.getBody().getReceive_account_in_accounting_amt()));//收款方账户入账金额
            tradeSinglePayment.setReceiveAccountInAccountingType(tradeRequest.getBody().getReceive_account_in_accounting_type());//收款方账户入账子账户类型
            tradeSinglePayment.setReceiveAccountInAccountingHis1(tradeRequest.getBody().getReceive_account_in_accounting_his1());//收款方账户入账账务历史1
            tradeSinglePayment.setReceiveAccountInAccountingHis2(tradeRequest.getBody().getReceive_account_in_accounting_his2());//收款方账户入账账务历史2
            tradeSinglePayment.setReceiveAccountInAccountingHis3(tradeRequest.getBody().getReceive_account_in_accounting_his3());//收款方账户入账账务历史3
            /**
             * 收款方手续费账户部分
             */
            tradeSinglePayment.setReceiveFeeAccountNo(tradeRequest.getBody().getReceive_fee_account_no());//收款方手续费账户账户编号
            tradeSinglePayment.setReceiveFeeAccountMerchantNo(this.receiveFeeMerchantNo);//收款方手续费账户所属商户编号
            tradeSinglePayment.setReceiveFeeAccountOutAccountingAmt(strToLong(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt()));//收款方手续费账户出账金额
            tradeSinglePayment.setReceiveFeeAccountOutAccountingType(tradeRequest.getBody().getReceive_fee_account_out_accounting_type());//收款方手续费账户出账子账户类型
            tradeSinglePayment.setReceiveFeeAccountOutAccountingHis1(tradeRequest.getBody().getReceive_fee_account_out_accounting_his1());//收款方手续费账户出账账务历史1
            tradeSinglePayment.setReceiveFeeAccountOutAccountingHis2(tradeRequest.getBody().getReceive_fee_account_out_accounting_his2());//收款方手续费账户出账账务历史2
            tradeSinglePayment.setReceiveFeeAccountOutAccountingHis3(tradeRequest.getBody().getReceive_fee_account_out_accounting_his3());//收款方手续费账户出账账务历史3
            /**
             * 其他损益台账List部分
             */
            tradeSinglePayment.setExtendProfitLoss(this.jsonList);
            /**
             * 累计金额部分
             */
            tradeSinglePayment.setContinueTradeStatus(TradeConstants.CONTINUE_TRADE_STATUS_END);//后续交易开关-关
            this.tradeSinglePayment = singlePaymentService.createOuterTradeFailureRecode(tradeSinglePayment);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->支付失败交易记录创建失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060010021001100");
        }
    }

    /**
     * 修改支付成功交易记录
     *
     * @param tradeRequest
     * @throws Exception
     */
    private void modifyTradeRecordSuccess(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) throws Exception {
        try {

            tradeSinglePayment.setGmtSuccessPay(new Date());
            //收到方冻结余额  【收款方账户入账金额】（冻结入账时）-【收款方手续费账户出账金额】（冻结出账时）
            BigDecimal receiveFreezeBal = BigDecimal.ZERO;
            if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_account_in_accounting_type())) {
                receiveFreezeBal = receiveFreezeBal.add(new BigDecimal(tradeRequest.getBody().getReceive_account_in_accounting_amt()));
            }
            if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_fee_account_out_accounting_type())) {
                receiveFreezeBal = receiveFreezeBal.subtract(new BigDecimal(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt()));
            }
            tradeSinglePayment.setReceiveFreezeBal(strToLong(receiveFreezeBal.toString()));
            this.tradeSinglePayment = singlePaymentService.updateTradeSuccess(this.tradeSinglePayment);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->支付成功交易记录修改失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060010021001200");
        }
    }

    /**
     * 生效其他损益台
     *
     * @param tradeRequest
     */
    private void extendProfitLossLegderEffect(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) {
        try {
            for (TradeProfitLossLedger ledger : otherProfitLossLedgerList) {
                ledger = profitLossLedgerService.queryByLedgerNoAndTradeNo(ledger.getLedgerNo(), tradeNo);
                ledger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PAYMENT);
                ledger.setEffectiveReqNo(this.reqNo);
                profitLossLedgerService.updateBlankLegderEffective(ledger);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->生效其他损益台账失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("TZ000200301");
        }
    }

    /**
     * 生效收款损益台账
     *
     * @param tradeRequest
     */
    private void profitLossLegderEffect(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) {
        if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type())) {
            try {
                TradeProfitLossLedger ledger = profitLossLedgerService.queryByLedgerNoAndTradeNo(receiveProfitLossLedgerNo, tradeNo);
                ledger.setLedgerNo(receiveProfitLossLedgerNo);
                ledger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PAYMENT);
                ledger.setEffectiveReqNo(this.reqNo);
                profitLossLedgerService.updateBlankLegderEffective(ledger);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("-->生效收款损益台账失败：" + e.getMessage(), e);
                throw exceptionService.buildBusinessException("TZ000200301");
            }
        }
    }

    /**
     * 账务操作
     *
     * @param tradeRequest
     */
    private void handlerRealAcount(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) {
        List<RealTimeAccountingVo> request_list = new ArrayList<RealTimeAccountingVo>();
        //1 【付款方付出方式】为【第三方充付】时执行--充付入账账务处理
        if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getPay_type())) {
            RealTimeAccountingVo realAcountSetp1 = realAcountSetp1(tradeRequest);
            request_list.add(realAcountSetp1);
        }
        //2 【付款方付出方式】为【第三方充付】时执行--充付出账账务处理
        if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getPay_type())) {
            RealTimeAccountingVo realAcountSetp2 = realAcountSetp2(tradeRequest);
            request_list.add(realAcountSetp2);
        }
        //3 【付款方手续费账户出账金额】不为空时处理--付款方手续费账户账务处理
        if (!StringUtil.isEmpty(tradeRequest.getBody().getPay_fee_account_out_accounting_amt())) {
            RealTimeAccountingVo realAcountSetp3 = realAcountSetp3(tradeRequest);
            request_list.add(realAcountSetp3);
        }
        //4 【收款方收到方式】为【账户】时执行--收款方账户账务处理
        if (TradeConstants.PAY_BY_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())) {
            RealTimeAccountingVo realAcountSetp4 = realAcountStep4(tradeRequest);
            request_list.add(realAcountSetp4);
        }
        //5 【收款方手续费账户出账金额】不为空时处理--收款方手续费账户账务处理
        if (!StringUtil.isEmpty(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt())) {
            RealTimeAccountingVo realAcountSetp5 = realAcountStep5(tradeRequest);
            request_list.add(realAcountSetp5);
        }
        try {
            @SuppressWarnings("unchecked")
            List<RealTimeAccountingRsp> list = this.bizAccountService.senderRequestToAccount(request_list);
            RealTimeAccountingRsp rsp;
            for (RealTimeAccountingRsp aList : list) {
                rsp = aList;
                if ("F".equals(rsp.getSuccess())) {
                    throw new BusinessException(rsp.getRetCode(), rsp.getErrMessage());
                }
            }
        } catch (BusinessException e) {
            logger.error(tradeRequest.getHead().getRequest_code(), e);
            throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            throw exceptionService.buildBusinessException("JY000000000000401");
        }


    }


    /**
     * 1 充付入账账务处理
     */
    private RealTimeAccountingVo realAcountSetp1(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getPayAccountNo());//付款方账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getPayAccountInAccountingHis1());//付款方账户入账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getPayAccountInAccountingHis2());//付款方账户入账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getPayAccountInAccountingHis3());//付款方账户入账账务历史3
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code())); // 交易类型0006_002
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT); // 交易请求类型0006_001_002
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setAmount(strToLong(tradeRequest.getBody().getExternal_pay_received_amt()));
        return bizAccountService.avlBalIncrWrapper(accountvo);
    }
    /**
     * 2 充付出账账务处理
     */
    private RealTimeAccountingVo realAcountSetp2(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getPayAccountNo());//付款方账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getPayAccountOutAccountingHis1());//付款方账户出账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getPayAccountOutAccountingHis2());//付款方账户出账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getPayAccountOutAccountingHis3());//付款方账户出账账务历史3
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code())); // 交易类型0006_002
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT); // 交易请求类型0006_001_002
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setAmount(strToLong(tradeRequest.getBody().getPay_account_out_accounting_amt()));
        return bizAccountService.avlBalDecrWrapper(accountvo);
    }
    
    /**
     * 3 付款方手续费账户账务处理
     */
    private RealTimeAccountingVo realAcountSetp3(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getPayFeeAccountNo());//付款方手续费账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getPayFeeAccountOutAccountingHis1());//付款方手续费账户出账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getPayFeeAccountOutAccountingHis2());//付款方手续费账户出账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getPayFeeAccountOutAccountingHis3());//付款方手续费账户出账账务历史3
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code())); // 交易类型0006_002
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT); // 交易请求类型0006_001_002
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setAmount(strToLong(tradeRequest.getBody().getPay_fee_account_out_accounting_amt()));
        return bizAccountService.avlBalDecrWrapper(accountvo);
    }

    /**
     * 4 收款方账户账务处理
     */
    private RealTimeAccountingVo realAcountStep4(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getReceiveAccountNo());//收款方账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getReceiveAccountInAccountingHis1());//收款方账户入账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getReceiveAccountInAccountingHis2());//收款方账户入账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getReceiveAccountInAccountingHis3());//收款方账户入账账务历史3
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code())); // 交易类型0006_002
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT); // 交易请求类型0006_001_002
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_account_in_accounting_type())) {
            accountvo.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code()));
            accountvo.setFrozenTradeNo(this.tradeNo);
            accountvo.setAmount(strToLong(tradeRequest.getBody().getReceive_account_in_accounting_amt()));
            return bizAccountService.FrozenBalIncrAmtWrapper(accountvo);
        } else {
            accountvo.setAmount(strToLong(tradeRequest.getBody().getReceive_account_in_accounting_amt()));
            return bizAccountService.avlBalIncrWrapper(accountvo);
        }
    }

    /**
     *5 收款方手续费账户账务处理
     */
    private RealTimeAccountingVo realAcountStep5(TradeRequest<TradePacketReqBodyExternalPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getReceiveFeeAccountNo());//收款方手续费账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingHis1());//收款方手续费账户出账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingHis2());//收款方手续费账户出账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingHis3());//收款方手续费账户出账账务历史3
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code())); // 交易类型0006_002
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT); // 交易请求类型0006_001_002
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_fee_account_out_accounting_type())) {
            accountvo.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradeRequest.getHead().getRequest_code()));
            accountvo.setFrozenTradeNo(this.tradeNo);
            accountvo.setAmount(strToLong(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt()));
            return bizAccountService.FrozenBalDecrAmtWrapper(accountvo);
        } else {
            accountvo.setAmount(strToLong(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt()));
            return bizAccountService.avlBalDecrWrapper(accountvo);
        }
    }

    /**
     * @Description: 金额比较
     */
    private boolean compareAmt(String receiveFeeAccountOutAccountingAmt, String receiveAccountInAccountingAmt) {
        long receive_fee_amt = strToLong(receiveFeeAccountOutAccountingAmt);
        long receive_account_amt = strToLong(receiveAccountInAccountingAmt);
        if (receive_fee_amt <= receive_account_amt) {
            return true;
        }
        return false;
    }

    /**
     * 验证【核心商户编号】、【资金池编号】与【CA账户编号】对应关系
     *
     * @param //coreMerchantNo 核心商户编号
     * @param //fundPoolNo     资金池编号
     * @param accountNo        CA账户编号
     * @Title:correspond
     * @Description:验证【核心商户编号】、【资金池编号】与【CA账户编号】对应关系
     * @return:void
     * @author:zoran.huang
     * @date:2016年5月6日 上午10:12:10
     */
    private AdvanceAccountVO getCreditAccountInfo(String accountNo) {
        AdvanceAccountVO accountVo = advanceAccountService.selectByAccountNo(accountNo);
        if (accountVo != null) {
            return accountVo;
        }
        return null;
    }

}