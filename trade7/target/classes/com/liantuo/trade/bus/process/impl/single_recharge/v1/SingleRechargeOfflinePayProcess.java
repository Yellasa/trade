package com.liantuo.trade.bus.process.impl.single_recharge.v1;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.service.AdvanceAccountService;
import com.liantuo.deposit.advanceaccount.bus.vo.AdvanceAccountVO;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.trade.bus.process.TradeCreateMultiTxNoPaymentInterface;
import com.liantuo.trade.bus.service.*;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateMultiTxNoPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodyRechargeOffline;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.pojo.TradeProfitLossLedger;
import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.seqno.IdFactory;
import com.liantuo.trade.spring.annotation.JobFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version V1.0
 * @Description: 线下充值
 */
@JobFlow(value = "0005_001_001", version = "1.0", template = ATradeCreateMultiTxNoPaymentTemp.class)
public class SingleRechargeOfflinePayProcess implements TradeCreateMultiTxNoPaymentInterface<TradePacketReqBodyRechargeOffline> {
    private static Logger logger = LoggerFactory.getLogger(SingleRechargeOfflinePayProcess.class);
    private final static int INIT_VERSION = 0;
    @Autowired
    private ExceptionService exceptionService;

    @SuppressWarnings("rawtypes")
    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService bizAccountService;

    @Resource(name = "advanceAccountServiceImpl")
    private AdvanceAccountService advanceAccountService;
    @Resource(name = "legderServiceImpl")
    private LegderService legderService;

    @Resource(name = "rechargeServiceImpl")
    private RechargeService rechargeService;

    //损益台账service
    @Resource(name = "profitLossLedgerServiceImpl")
    private ProfitLossLedgerService profitLossLedgerService;

    @Resource(name = "idFactoryOfflineandOnlineTradeNo")
    private IdFactory idFactoryOfflineandOnlineTradeNo;

    //	private long id;
    private String tradeNo;
    private String payMerchantNo;
    private String reqNo;
    private String ledgerNo;//生效台账编号
    //	private String batch_no;//批次号
    private TradeRecharge tradeRecharge;
    private String supplyLedgerNo;//补差台账编号
    private String feeLedgerNo;//手续费台账编号

    /**
     * 验证数据格式
     * 校验【交易发起方发起请求编号】是否重复
     * 校验【核心商户编号】、【资金池编号】与【充值CA账户编号】对应关系
     * 校验【核心商户编号】、【资金池编号】与【充值手续费收款账户】对应关系
     * 校验【核心商户编号】、【资金池编号】与【充值补差付款账户】对应关系
     * 查询【充值CA账户编号】与【充值成员商户编号】
     * 校验金额关系
     */
    @Override
    public void validate(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) throws Exception {
        formatValidate(tradeRquest);
        bizValidate(tradeRquest);
    }

    /**
     * @param tradeRquest
     * @throws Exception
     * @Title:formatValidate
     * @Description: 参数验证
     * @return:void
     */
    private void formatValidate(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) throws Exception {
        String msg = TradeValidationUtil.validateRequest(tradeRquest);
        if (!StringUtils.isEmpty(msg)) {
            logger.info("-->输入参数校验不通过：" + msg);
            throw exceptionService.buildBusinessException("JY00050010011000100", msg);
        }
        //充值手续费金额不为0时,充值手续费接收方式必填
        if (strParseToLong(tradeRquest.getBody().getFee_amount()) > 0 && StringUtils.isEmpty(tradeRquest.getBody().getFee_way())) {
            logger.info("-->【充值手续费金额】不为0时，【充值手续费接收方式】 未填：");
            throw exceptionService.buildBusinessException("JY00050010011000100", "【充值手续费金额】不为0时，【充值手续费接收方式】  为必填");
        }
        //【充值手续费接收方式】为2时，【充值手续费收款账户】 为必填
        if (TradeConstants.FEE_WAY_CA.equals(tradeRquest.getBody().getFee_way()) && StringUtils.isEmpty(tradeRquest.getBody().getFee_receive_account_no())) {
            logger.info("-->【充值手续费接收方式】为2时，【充值手续费收款账户】 未填：");
            throw exceptionService.buildBusinessException("JY00050010011000100", "【充值手续费接收方式】为2时，【充值手续费收款账户】 为必填");
        }

        //【充值手续费付出方式】为1时，【充值手续费台账类别】为必填
        if (TradeConstants.FEE_WAY_LEDGER.equals(tradeRquest.getBody().getFee_way()) && StringUtils.isEmpty(tradeRquest.getBody().getFee_ledger_type())) {
            logger.info("-->【充值手续费付出方式】为1时，【充值手续费台账类别】 未填：");
            throw exceptionService.buildBusinessException("JY00050010011000100", "【充值手续费付出方式】为1时，【充值手续费台账类别】为必填");
        }
        //必填
        //充值补差金额不为0时,充值补差付出方式必填
        if (strParseToLong(tradeRquest.getBody().getSupply_amount()) > 0 && StringUtils.isEmpty(tradeRquest.getBody().getSupply_way())) {
            logger.info("-->【充值手续费金额】不为0时，【充值手续费接收方式】 未填：");
            throw exceptionService.buildBusinessException("JY00050010011000100", "【充值补差金额】不为0时，【充值补差付出方式】  为必填");
        }

        //【充值补差付出方式】为1时，【充值补差台账类别】为必填
        if (TradeConstants.SUPPLY_WAY_LEDGER.equals(tradeRquest.getBody().getSupply_way()) && StringUtils.isEmpty(tradeRquest.getBody().getSupply_ledger_type())) {
            logger.info("-->【充值补差付出方式】为1时，【充值补差台账类别】 未填：");
            throw exceptionService.buildBusinessException("JY00050010011000100", "【充值补差付出方式】为1时，【充值补差台账类别】为必填");
        }

        //【充值补差付出方式】为2时，【充值补差付款账户】为必填
        if (TradeConstants.SUPPLY_WAY_CA.equals(tradeRquest.getBody().getSupply_way()) && StringUtils.isEmpty(tradeRquest.getBody().getSupply_pay_account_no())) {
            logger.info("-->【充值补差付出方式】为2时，【充值补差付款账户】 未填：");
            throw exceptionService.buildBusinessException("JY00050010011000100", "【充值补差付出方式】为2时，【充值补差付款账户】为必填");
        }

    }

    private void bizValidate(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) throws Exception {
        String core_merchant_no = tradeRquest.getHead().getCore_merchant_no();
        String fund_pool_no = tradeRquest.getHead().getFund_pool_no();
        //校验交易发起方请求编号是否重复
        checkDuplicate(tradeRquest);
        //校验【核心商户编号】、【资金池编号】与【充值CA账户编号】对应关系
        AdvanceAccountVO rechargeAccount = checkMatchCoreMerchantNoFundPoolNoCreditAccount(tradeRquest.getBody().getRecharge_account_no());
        if (!StringUtils.isEmpty(tradeRquest.getBody().getRecharge_account_no())) {
            if (null == rechargeAccount || !(core_merchant_no.equals(rechargeAccount.getCoreMerchantNo()) && fund_pool_no.equals(rechargeAccount.getPoolNo()))) {
                logger.info("-->【核心商户编号】、【资金池编号】与【充值CA账户编号】不对应");
                throw exceptionService.buildBusinessException("JY00050010011000400");
            }
        }
        //校验【核心商户编号】、【资金池编号】与【充值手续费收款账户】对应关系
        if (!StringUtils.isEmpty(tradeRquest.getBody().getFee_receive_account_no())) {
            AdvanceAccountVO feeAccount = checkMatchCoreMerchantNoFundPoolNoCreditAccount(tradeRquest.getBody().getFee_receive_account_no());
            if (feeAccount == null || !(core_merchant_no.equals(feeAccount.getCoreMerchantNo()) && fund_pool_no.equals(feeAccount.getPoolNo()))) {
                logger.info("-->【核心商户编号】、【资金池编号】与【充值手续费收款账户】不对应");
                throw exceptionService.buildBusinessException("JY00050010011000500");
            }
        }
        //校验【核心商户编号】、【资金池编号】与【充值补差付款账户】对应关系
        if (!StringUtils.isEmpty(tradeRquest.getBody().getSupply_pay_account_no())) {
            AdvanceAccountVO supplyAccount = checkMatchCoreMerchantNoFundPoolNoCreditAccount(tradeRquest.getBody().getSupply_pay_account_no());
            if (supplyAccount == null || !(core_merchant_no.equals(supplyAccount.getCoreMerchantNo()) && fund_pool_no.equals(supplyAccount.getPoolNo()))) {
                logger.info("-->【核心商户编号】、【资金池编号】与【充值补差付款账户】不对应");
                throw exceptionService.buildBusinessException("JY00050010011000600");
            }
        }
        // 查询【充值CA账户编号】与【充值成员商户编号】
        if (null == rechargeAccount || StringUtils.isEmpty(rechargeAccount.getMerchantNo())) {
            logger.info("-->充值CA账户编号无所属成员商户编号");
            throw exceptionService.buildBusinessException("JY00050010011000700");
        } else {
            this.payMerchantNo = rechargeAccount.getMerchantNo();
        }
        //校验金额关系:【充值补差金额】+【支付金额】=【充值金额】
        checkAmountPay(tradeRquest);
    }

    /**
     * 验证【核心商户编号】、【资金池编号】与【CA账户编号】对应关系
     *
     * @param accountNo CA账户编号
     * @Title:correspond
     * @Description:验证【核心商户编号】、【资金池编号】与【CA账户编号】对应关系
     * @return:void
     * @author:zoran.huang
     * @date:2016年5月6日 上午10:12:10
     */
    private AdvanceAccountVO checkMatchCoreMerchantNoFundPoolNoCreditAccount(String accountNo) {
        return advanceAccountService.selectByAccountNo(accountNo);
    }

    private void checkAmountPay(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) {
        logger.info("-->开始校验【充值补差金额+支付金额=充值金额】");
        long pay_amount = strParseToLong(tradeRquest.getBody().getPay_amount());
        long recharge_amount = strParseToLong(tradeRquest.getBody().getRecharge_amount());
        long supply_amount = strParseToLong(tradeRquest.getBody().getSupply_amount());
        if ((pay_amount + supply_amount) != recharge_amount) {
            logger.info("-->充值补差金额（" + pay_amount + "）+支付金额（" + supply_amount + "）【不等于】充值金额（" + recharge_amount + "）");
            throw exceptionService.buildBusinessException("JY00050010011000800");
        }
    }

    /**
     * @Description: 将字符串转换为数字
     */
    private long strParseToLong(String str) {
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
     * @param tradeRquest
     * @throws Exception
     * @Title:checkDuplicate
     * @Description: 根据资金池标号和 交易发起方发起请求编号，检查交易发起方发起请求编号是否重复
     * @return:void
     */
    protected void checkDuplicate(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) throws Exception {
        TradeRecharge query = new TradeRecharge();
        query.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());
        query.setOutTradeNoExt(tradeRquest.getBody().getOut_trade_no_ext());
        List<TradeRecharge> list = rechargeService.queryBy(query);
        if (!CollectionUtils.isEmpty(list)) {
            logger.info("-->交易发起方发起请求编号重复");
            throw exceptionService.buildBusinessException("JY00050010011000300");
        }
    }

    @Override
    public void transactionStep01(
            TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest)
            throws Exception {
        //获取充值交易编号
        this.tradeNo = TradeUtilCommon.getServiceCode(tradeRquest.getHead().getRequest_code()) + idFactoryOfflineandOnlineTradeNo.generate().toString();
        Date currentTime = new Date();
        //创建生效外部收款台账
        createEffectiveLegder(tradeRquest, currentTime);
        //创建等待入账交易记录(包括了相应的历史记录)
        createTradeWaitForAccounting(tradeRquest, currentTime);
    }

    /**
     * @param dateTime 创建充值交易创建日期
     * @Title:createEffectiveLegder
     * @Description:创建生效外部收款台账
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月28日 下午6:07:36
     */
    private void createEffectiveLegder(TradeRequest<TradePacketReqBodyRechargeOffline> request, Date dateTime) {
        try {
            TradeLedger ledger = new TradeLedger();
            ledger.setCoreMerchantNo(request.getHead().getCore_merchant_no());// 核心商户编号
            ledger.setFundPoolNo(request.getHead().getFund_pool_no());// 资金池编号

            ledger.setMerchantExtendField1(request.getBody().getRecharge_ledger_extend_field_1());// 业务台账客户保留字段1
            ledger.setMerchantExtendField2(request.getBody().getRecharge_ledger_extend_field_2());// 业务台账客户保留字段2
            ledger.setMerchantExtendField3(request.getBody().getRecharge_ledger_extend_field_3());// 业务台账客户保留字段3

            ledger.setTradeType(TradeUtilCommon.getTradeType(request.getHead().getRequest_code())); // 所属业务交易类型（例：0003_001）
            ledger.setTradeNo(this.tradeNo); // 交易编号
            ledger.setGmtTradeCreated(dateTime); // 所属业务交易创建日期
            ledger.setEffectiveReqNo(this.reqNo);//生效交易请求类型
            ledger.setEffectiveReqType(request.getHead().getRequest_code());//生效的请求编号

            ledger.setOutTradeNoExt(request.getBody().getOut_trade_no_ext()); // 交易发起方发起请求编号
            if (!StringUtils.isEmpty(request.getBody().getOut_trade_no())) {// 交易发起方业务系统订单号
                ledger.setOutTradeNo(request.getBody().getOut_trade_no());
            }

            ledger.setClearChannel(request.getBody().getClear_channel()); // 收付款渠道编号（请求业务参数）
            ledger.setClearChannelAttr1(request.getBody().getRecharge_attr_1());// 收付款属性1	来自输入
            ledger.setClearChannelAttr2(request.getBody().getRecharge_attr_2());//收付款属性2	来自输入
            ledger.setClearChannelAttr3(request.getBody().getRecharge_attr_3());//收付款属性3	来自输入
            ledger.setClearChannelAttr4(request.getBody().getRecharge_attr_4());//收付款属性4	来自输入
            ledger.setClearChannelAttr5(request.getBody().getRecharge_attr_5());//收付款属性5	来自输入
            ledger.setClearChannelAttr6(request.getBody().getRecharge_attr_6());//收付款属性6	来自输入


            ledger.setExtendField1(request.getBody().getRecharge_remark_1()); //收付款备注1	来自输入
            ledger.setExtendField2(request.getBody().getRecharge_remark_2());//收付款备注2	来自输入
            ledger.setExtendField3(request.getBody().getRecharge_remark_3());//收付款备注3	来自输入
            ledger.setExtendField4(request.getBody().getRecharge_remark_4());//收付款备注4	来自输入
            ledger.setExtendField5(request.getBody().getRecharge_remark_5());//收付款备注5	来自输入
            ledger.setExtendField6(request.getBody().getRecharge_remark_6());//收付款备注6	来自输入
            ledger.setExtendField7(request.getBody().getRecharge_remark_7());//收付款备注7	来自输入
            ledger.setExtendField8(request.getBody().getRecharge_remark_8());//收付款备注8	来自输入
            ledger.setExtendField9(request.getBody().getRecharge_remark_9());//收付款备注9	来自输入
            ledger.setExtendField10(request.getBody().getRecharge_remark_10());//收付款备注10	来自输入
            long receiveAmount = AmountUtils.bizAmountConvertToLong(request.getBody().getPay_amount());
            ledger.setReceiveAmount(receiveAmount);//收款金额	来自输入【支付金额】

            //付款金额	空

            Date gmtSuccessClearChannel = DateUtil.formatDateTime(request.getBody().getGmt_success_clear_channel());
            ledger.setGmtSuccessClearChannel(gmtSuccessClearChannel);//外部渠道收付款成功日期时间	来自输入【外部付款成功日期时间】
            ledger.setThirdTradeNo(request.getBody().getThird_trade_no());//收付款渠道订单号	来自输入【充值渠道订单号】

            //支付中心请求编号	空

            this.ledgerNo = legderService.createEffectiveLegder(ledger);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->创建生效的台账失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("TZ000100201");
        }
    }

    /**
     * @param request  输入
     * @param dateTime 创建时间
     * @Title:createForEnterOfWait
     * @Description: 创建等待入账的充值交易
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 上午9:19:54
     */
    private void createTradeWaitForAccounting(TradeRequest<TradePacketReqBodyRechargeOffline> request, Date dateTime) {
        TradeRecharge eowTraderecharge = new TradeRecharge();
        try {
            //交易编号
            eowTraderecharge.setTradeNo(this.tradeNo);
            //合作商户编号	来自输入
            eowTraderecharge.setPartnerId(request.getHead().getPartner_id());
            //核心商户编号	来自输入
            eowTraderecharge.setCoreMerchantNo(request.getHead().getCore_merchant_no());
            //资金池编号	来自输入
            eowTraderecharge.setFundPoolNo(request.getHead().getFund_pool_no());
            //交易客户保留字段1	来自输入
            eowTraderecharge.setMerchantExtendField1(request.getBody().getMerchant_extend_field_1());
            //交易客户保留字段2	来自输入
            eowTraderecharge.setMerchantExtendField2(request.getBody().getMerchant_extend_field_2());
            //交易客户保留字段3	来自输入
            eowTraderecharge.setMerchantExtendField3(request.getBody().getMerchant_extend_field_3());
            //交易客户保留字段4	来自输入
            eowTraderecharge.setMerchantExtendField4(request.getBody().getMerchant_extend_field_4());
            //交易客户保留字段5	来自输入
            eowTraderecharge.setMerchantExtendField5(request.getBody().getMerchant_extend_field_5());
            //交易发起方发起请求编号	来自输入
            eowTraderecharge.setOutTradeNoExt(request.getBody().getOut_trade_no_ext());
            //交易发起方业务系统订单号	来自输入
            eowTraderecharge.setOutTradeNo(request.getBody().getOut_trade_no());
            //交易创建日期时间	系统日期时间
            eowTraderecharge.setGmtCreated(dateTime);
            //最后变更日期时间	系统日期时间
            eowTraderecharge.setGmtLatestModified(dateTime);
            //最后变更交易请求类型	0005_001_001
            eowTraderecharge.setLatestTradeReqType(request.getHead().getRequest_code());
            //最后变更交易请求编号	来自系统产生
            eowTraderecharge.setLatestReqNo(this.reqNo);
            //交易结束状态	【未结束】
            eowTraderecharge.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);
            //交易状态	【等待入账】
            eowTraderecharge.setStatus(TradeConstants.TRADE_RECHARGE_WAIT_ENTER);
            /**
             * 交易时间
             */
            //等待入账日期时间	系统日期时间
            eowTraderecharge.setGmtRechargeWait(dateTime);
            /**
             * 充值付款方数据
             */
            //支付金额	来自输入
            eowTraderecharge.setPayAmount(str2Long(request.getBody().getPay_amount()));
            //充值渠道号	来自输入
            eowTraderecharge.setClearChannel(request.getBody().getClear_channel());
            //充值渠道身份编号	来自输入
            eowTraderecharge.setTransactionId(request.getBody().getTransaction_id());
            //提交第三方批次号	来自输入
            eowTraderecharge.setBatchNo(request.getBody().getBatch_no());
            //提交第三方批次流水号	来自输入
            eowTraderecharge.setSerialNumber(request.getBody().getSerial_number());
            //充值渠道订单号	来自输入
            eowTraderecharge.setThirdTradeNo(request.getBody().getThird_trade_no());
            //外部付款成功日期时间	来自输入
            Date gmtSuccessClearChannel = DateUtil.formatDateTime(request.getBody().getGmt_success_clear_channel());
            eowTraderecharge.setGmtSuccessClearChannel(gmtSuccessClearChannel);
            //充值付款业务台账保留字段1	来自输入
            eowTraderecharge.setRechargeLedgerExtendField1(request.getBody().getRecharge_ledger_extend_field_1());
            //充值付款业务台账保留字段2	来自输入
            eowTraderecharge.setRechargeLedgerExtendField2(request.getBody().getRecharge_ledger_extend_field_2());
            //充值付款业务台账保留字段3	来自输入
            eowTraderecharge.setRechargeLedgerExtendField3(request.getBody().getRecharge_ledger_extend_field_3());
            //充值付款业务台账编号	来自台账
            eowTraderecharge.setRechargeLedgerNo(this.ledgerNo);
            /**
             * 收款账户数据
             */
            //充值CA账户编号	来自输入
            eowTraderecharge.setRechargeAccountNo(request.getBody().getRecharge_account_no());
            //充值成员商户编号
            eowTraderecharge.setRechargeMerchantNo(this.payMerchantNo);
            //充值CA账户入账账务历史1	来自输入
            eowTraderecharge.setRechargeAccountExtendField1(request.getBody().getRecharge_account_extend_field_1());
            //充值CA账户入账账务历史2	来自输入
            eowTraderecharge.setRechargeAccountExtendField2(request.getBody().getRecharge_account_extend_field_2());
            //充值CA账户入账账务历史3	来自输入
            eowTraderecharge.setRechargeAccountExtendField3(request.getBody().getRecharge_account_extend_field_3());
            /**
             * 交易数据
             */
            //充值金额	来自输入
            eowTraderecharge.setRechargeAmount(str2Long(request.getBody().getRecharge_amount()));
            //交易版本号	【0】
            eowTraderecharge.setVersion(INIT_VERSION);
            //请求组别	【线下】
            eowTraderecharge.setRequestGroup(TradeConstants.REQUEST_GROUP_OF_OFFLINE);
            /**
             * 充值手续费数据
             */
            //充值手续费金额	来自输入
            eowTraderecharge.setFeeAmount(str2Long(request.getBody().getFee_amount()));
            //充值手续费接收方式	来自输入
            eowTraderecharge.setFeeWay(request.getBody().getFee_way());
            //充值手续费收款账户	来自输入
            eowTraderecharge.setFeeReceiveAccountNo(request.getBody().getFee_receive_account_no());
            //充值手续费充值CA账户扣费账务历史1	来自输入
            eowTraderecharge.setFeePayAccountExtendField1(request.getBody().getFee_pay_account_extend_field_1());
            //充值手续费充值CA账户扣费账务历史2	来自输入
            eowTraderecharge.setFeePayAccountExtendField2(request.getBody().getFee_pay_account_extend_field_2());
            //充值手续费充值CA账户扣费账务历史3	来自输入
            eowTraderecharge.setFeePayAccountExtendField3(request.getBody().getFee_pay_account_extend_field_3());
            //充值手续费收款账户入账账务历史1	来自输入
            eowTraderecharge.setFeeReceiveAccountExtendField1(request.getBody().getFee_receive_account_extend_field_1());
            //充值手续费收款账户入账账务历史2	来自输入
            eowTraderecharge.setFeeReceiveAccountExtendField2(request.getBody().getFee_receive_account_extend_field_2());
            //充值手续费收款账户入账账务历史3	来自输入
            eowTraderecharge.setFeeReceiveAccountExtendField3(request.getBody().getFee_receive_account_extend_field_3());
            //充值手续费台账类别	来自输入
            eowTraderecharge.setFeeLedgerType(request.getBody().getFee_ledger_type());
            //充值手续费台账客户保留字段1	来自输入
            eowTraderecharge.setFeeLedgerExtendField1(request.getBody().getFee_ledger_extend_field_1());
            //充值手续费台账客户保留字段2	来自输入
            eowTraderecharge.setFeeLedgerExtendField2(request.getBody().getFee_ledger_extend_field_2());
            //充值手续费台账客户保留字段3	来自输入
            eowTraderecharge.setFeeLedgerExtendField3(request.getBody().getFee_ledger_extend_field_3());
            //充值手续费损益属性1	来自输入
            eowTraderecharge.setFeeProfitLossAttr1(request.getBody().getFee_profit_loss_attr_1());
            //充值手续费损益属性2	来自输入
            eowTraderecharge.setFeeProfitLossAttr2(request.getBody().getFee_profit_loss_attr_2());
            //充值手续费损益属性3	来自输入
            eowTraderecharge.setFeeProfitLossAttr3(request.getBody().getFee_profit_loss_attr_3());
            //充值手续费损益属性4	来自输入
            eowTraderecharge.setFeeProfitLossAttr4(request.getBody().getFee_profit_loss_attr_4());
            //充值手续费损益属性5	来自输入
            eowTraderecharge.setFeeProfitLossAttr5(request.getBody().getFee_profit_loss_attr_5());
            //充值手续费损益属性6	来自输入
            eowTraderecharge.setFeeProfitLossAttr6(request.getBody().getFee_profit_loss_attr_6());
            //充值手续费损益属性7	来自输入
            eowTraderecharge.setFeeProfitLossAttr7(request.getBody().getFee_profit_loss_attr_7());
            //充值手续费损益属性8	来自输入
            eowTraderecharge.setFeeProfitLossAttr8(request.getBody().getFee_profit_loss_attr_8());
            //充值手续费损益属性9	来自输入
            eowTraderecharge.setFeeProfitLossAttr9(request.getBody().getFee_profit_loss_attr_9());
            //充值手续费损益属性10	来自输入
            eowTraderecharge.setFeeProfitLossAttr10(request.getBody().getFee_profit_loss_attr_10());
            /**
             * 充值补差数据
             */
            //充值补差金额	来自输入
            eowTraderecharge.setSupplyAmount(str2Long(request.getBody().getSupply_amount()));
            //充值补差付出方式	来自输入
            eowTraderecharge.setSupplyWay(request.getBody().getSupply_way());
            //充值补差付款账户	来自输入
            eowTraderecharge.setSupplyPayAccountNo(request.getBody().getSupply_pay_account_no());
            //充值补差充值CA账户扣费账务历史1	来自输入
            eowTraderecharge.setSupplyPayAccountExtendField1(request.getBody().getSupply_pay_account_extend_field_1());
            //充值补差充值CA账户扣费账务历史2	来自输入
            eowTraderecharge.setSupplyPayAccountExtendField2(request.getBody().getSupply_pay_account_extend_field_2());
            //充值补差充值CA账户扣费账务历史3	来自输入
            eowTraderecharge.setSupplyPayAccountExtendField3(request.getBody().getSupply_pay_account_extend_field_3());
            //充值补差入账方式	1（暗补）
            eowTraderecharge.setSupplyRechargeType(TradeConstants.SUPPLY_RECHARGE_TYPE_1);
            //充值补差台账类别	来自输入
            eowTraderecharge.setSupplyLedgerType(request.getBody().getSupply_ledger_type());
            //充值补差台账客户保留字段1	来自输入
            eowTraderecharge.setSupplyLedgerExtendField1(request.getBody().getSupply_ledger_extend_field_1());
            //充值补差台账客户保留字段2	来自输入
            eowTraderecharge.setSupplyLedgerExtendField2(request.getBody().getSupply_ledger_extend_field_2());
            //充值补差台账客户保留字段3	来自输入
            eowTraderecharge.setSupplyLedgerExtendField3(request.getBody().getSupply_ledger_extend_field_3());
            //充值补差损益属性1	来自输入
            eowTraderecharge.setSupplyProfitLossAttr1(request.getBody().getSupply_profit_loss_attr_1());
            //充值补差损益属性2	来自输入
            eowTraderecharge.setSupplyProfitLossAttr2(request.getBody().getSupply_profit_loss_attr_2());
            //充值补差损益属性3	来自输入
            eowTraderecharge.setSupplyProfitLossAttr3(request.getBody().getSupply_profit_loss_attr_3());
            //充值补差损益属性4	来自输入
            eowTraderecharge.setSupplyProfitLossAttr4(request.getBody().getSupply_profit_loss_attr_4());
            //充值补差损益属性5	来自输入
            eowTraderecharge.setSupplyProfitLossAttr5(request.getBody().getSupply_profit_loss_attr_5());
            //充值补差损益属性6	来自输入
            eowTraderecharge.setSupplyProfitLossAttr6(request.getBody().getSupply_profit_loss_attr_6());
            //充值补差损益属性7	来自输入
            eowTraderecharge.setSupplyProfitLossAttr7(request.getBody().getSupply_profit_loss_attr_7());
            //充值补差损益属性8	来自输入
            eowTraderecharge.setSupplyProfitLossAttr8(request.getBody().getSupply_profit_loss_attr_8());
            //充值补差损益属性9	来自输入
            eowTraderecharge.setSupplyProfitLossAttr9(request.getBody().getSupply_profit_loss_attr_9());
            //充值补差损益属性10	来自输入
            eowTraderecharge.setSupplyProfitLossAttr10(request.getBody().getSupply_profit_loss_attr_10());
            this.tradeRecharge = rechargeService.createForEnterOfWait(eowTraderecharge);
//			this.id = tradeRecharge.getId();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->创建等待入账的线下充值交易失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00050010011000900");
        }

    }

    @Override
    public void createTradeFailRecode(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) throws Exception {
        Date createDateTime = new Date();
        createTradeRechargeFail(tradeRquest, createDateTime);
    }

    private void createTradeRechargeFail(TradeRequest<TradePacketReqBodyRechargeOffline> request, Date createDateTime) {
        TradeRecharge failRechare = new TradeRecharge();
        try {
            //交易编号
            failRechare.setTradeNo(tradeNo);
            //合作商户编号	来自输入
            failRechare.setPartnerId(request.getHead().getPartner_id());
            //核心商户编号	来自输入
            failRechare.setCoreMerchantNo(request.getHead().getCore_merchant_no());
            //资金池编号	来自输入
            failRechare.setFundPoolNo(request.getHead().getFund_pool_no());
            //交易客户保留字段1	来自输入
            failRechare.setMerchantExtendField1(request.getBody().getMerchant_extend_field_1());
            //交易客户保留字段2	来自输入
            failRechare.setMerchantExtendField2(request.getBody().getMerchant_extend_field_2());
            //交易客户保留字段3	来自输入
            failRechare.setMerchantExtendField3(request.getBody().getMerchant_extend_field_3());
            //交易客户保留字段4	来自输入
            failRechare.setMerchantExtendField4(request.getBody().getMerchant_extend_field_4());
            //交易客户保留字段5	来自输入
            failRechare.setMerchantExtendField5(request.getBody().getMerchant_extend_field_5());
            //交易发起方发起请求编号	来自输入
            failRechare.setOutTradeNoExt(request.getBody().getOut_trade_no_ext());
            //交易发起方业务系统订单号	来自输入
            failRechare.setOutTradeNo(request.getBody().getOut_trade_no());
            //交易创建日期时间	系统日期时间
            failRechare.setGmtCreated(createDateTime);
            //最后变更日期时间	系统日期时间
            failRechare.setGmtLatestModified(createDateTime);
            //最后变更交易请求类型	0005_001_001
            failRechare.setLatestTradeReqType(request.getHead().getRequest_code());
            //最后变更交易请求编号	来自系统产生
            failRechare.setLatestReqNo(this.reqNo);
            //交易结束状态	【已结束】
            failRechare.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
            //交易状态	【等待入账】
            failRechare.setStatus(TradeConstants.TRADE_RECHARGE_PAY_FAIL);
            /**
             * 交易时间
             */
            //充值失败时间
            failRechare.setGmtRechargeFail(createDateTime);
            /**
             * 充值付款方数据
             */
            //支付金额	来自输入
            failRechare.setPayAmount(str2Long(request.getBody().getPay_amount()));
            //充值渠道号	来自输入
            failRechare.setClearChannel(request.getBody().getClear_channel());
            //充值渠道身份编号	来自输入
            failRechare.setTransactionId(request.getBody().getTransaction_id());
            //提交第三方批次号	来自输入
            failRechare.setBatchNo(request.getBody().getBatch_no());
            //提交第三方批次流水号	来自输入
            failRechare.setSerialNumber(request.getBody().getSerial_number());
            //充值渠道订单号	来自输入
            failRechare.setThirdTradeNo(request.getBody().getThird_trade_no());
            //外部付款成功日期时间	来自输入
            Date gmtSuccessClearChannel = DateUtil.formatDateTime(request.getBody().getGmt_success_clear_channel());
            failRechare.setGmtSuccessClearChannel(gmtSuccessClearChannel);
            //充值付款业务台账保留字段1	来自输入
            failRechare.setRechargeLedgerExtendField1(request.getBody().getRecharge_ledger_extend_field_1());
            //充值付款业务台账保留字段2	来自输入
            failRechare.setRechargeLedgerExtendField2(request.getBody().getRecharge_ledger_extend_field_2());
            //充值付款业务台账保留字段3	来自输入
            failRechare.setRechargeLedgerExtendField3(request.getBody().getRecharge_ledger_extend_field_3());
            //充值付款业务台账编号	来自台账
            failRechare.setRechargeLedgerNo(this.ledgerNo);
            /**
             * 收款账户数据
             */
            //充值CA账户编号	来自输入
            failRechare.setRechargeAccountNo(request.getBody().getRecharge_account_no());
            //充值成员商户编号
            failRechare.setRechargeMerchantNo(this.payMerchantNo);
            //充值CA账户入账账务历史1	来自输入
            failRechare.setRechargeAccountExtendField1(request.getBody().getRecharge_account_extend_field_1());
            //充值CA账户入账账务历史2	来自输入
            failRechare.setRechargeAccountExtendField2(request.getBody().getRecharge_account_extend_field_2());
            //充值CA账户入账账务历史3	来自输入
            failRechare.setRechargeAccountExtendField3(request.getBody().getRecharge_account_extend_field_3());
            /**
             * 交易数据
             */
            //充值金额	来自输入
            failRechare.setRechargeAmount(str2Long(request.getBody().getRecharge_amount()));
            //交易版本号	【0】
            failRechare.setVersion(INIT_VERSION);
            //请求组别	【线下】
            failRechare.setRequestGroup(TradeConstants.REQUEST_GROUP_OF_OFFLINE);
            /**
             * 充值手续费数据
             */
            //充值手续费金额	来自输入
            failRechare.setFeeAmount(str2Long(request.getBody().getFee_amount()));
            //充值手续费接收方式	来自输入
            failRechare.setFeeWay(request.getBody().getFee_way());
            //充值手续费收款账户	来自输入
            failRechare.setFeeReceiveAccountNo(request.getBody().getFee_receive_account_no());
            //充值手续费充值CA账户扣费账务历史1	来自输入
            failRechare.setFeePayAccountExtendField1(request.getBody().getFee_pay_account_extend_field_1());
            //充值手续费充值CA账户扣费账务历史2	来自输入
            failRechare.setFeePayAccountExtendField2(request.getBody().getFee_pay_account_extend_field_2());
            //充值手续费充值CA账户扣费账务历史3	来自输入
            failRechare.setFeePayAccountExtendField3(request.getBody().getFee_pay_account_extend_field_3());
            //充值手续费收款账户入账账务历史1	来自输入
            failRechare.setFeeReceiveAccountExtendField1(request.getBody().getFee_receive_account_extend_field_1());
            //充值手续费收款账户入账账务历史2	来自输入
            failRechare.setFeeReceiveAccountExtendField2(request.getBody().getFee_receive_account_extend_field_2());
            //充值手续费收款账户入账账务历史3	来自输入
            failRechare.setFeeReceiveAccountExtendField3(request.getBody().getFee_receive_account_extend_field_3());
            //充值手续费台账类别	来自输入
            failRechare.setFeeLedgerType(request.getBody().getFee_ledger_type());
            //充值手续费台账客户保留字段1	来自输入
            failRechare.setFeeLedgerExtendField1(request.getBody().getFee_ledger_extend_field_1());
            //充值手续费台账客户保留字段2	来自输入
            failRechare.setFeeLedgerExtendField2(request.getBody().getFee_ledger_extend_field_2());
            //充值手续费台账客户保留字段3	来自输入
            failRechare.setFeeLedgerExtendField3(request.getBody().getFee_ledger_extend_field_3());
            //充值手续费损益属性1	来自输入
            failRechare.setFeeProfitLossAttr1(request.getBody().getFee_profit_loss_attr_1());
            //充值手续费损益属性2	来自输入
            failRechare.setFeeProfitLossAttr2(request.getBody().getFee_profit_loss_attr_2());
            //充值手续费损益属性3	来自输入
            failRechare.setFeeProfitLossAttr3(request.getBody().getFee_profit_loss_attr_3());
            //充值手续费损益属性4	来自输入
            failRechare.setFeeProfitLossAttr4(request.getBody().getFee_profit_loss_attr_4());
            //充值手续费损益属性5	来自输入
            failRechare.setFeeProfitLossAttr5(request.getBody().getFee_profit_loss_attr_5());
            //充值手续费损益属性6	来自输入
            failRechare.setFeeProfitLossAttr6(request.getBody().getFee_profit_loss_attr_6());
            //充值手续费损益属性7	来自输入
            failRechare.setFeeProfitLossAttr7(request.getBody().getFee_profit_loss_attr_7());
            //充值手续费损益属性8	来自输入
            failRechare.setFeeProfitLossAttr8(request.getBody().getFee_profit_loss_attr_8());
            //充值手续费损益属性9	来自输入
            failRechare.setFeeProfitLossAttr9(request.getBody().getFee_profit_loss_attr_9());
            //充值手续费损益属性10	来自输入
            failRechare.setFeeProfitLossAttr10(request.getBody().getFee_profit_loss_attr_10());
            /**
             * 充值补差数据
             */
            //充值补差金额	来自输入
            failRechare.setSupplyAmount(str2Long(request.getBody().getSupply_amount()));
            //充值补差付出方式	来自输入
            failRechare.setSupplyWay(request.getBody().getSupply_way());
            //充值补差付款账户	来自输入
            failRechare.setSupplyPayAccountNo(request.getBody().getSupply_pay_account_no());
            //充值补差充值CA账户扣费账务历史1	来自输入
            failRechare.setSupplyPayAccountExtendField1(request.getBody().getSupply_pay_account_extend_field_1());
            //充值补差充值CA账户扣费账务历史2	来自输入
            failRechare.setSupplyPayAccountExtendField2(request.getBody().getSupply_pay_account_extend_field_2());
            //充值补差充值CA账户扣费账务历史3	来自输入
            failRechare.setSupplyPayAccountExtendField3(request.getBody().getSupply_pay_account_extend_field_3());
            //充值补差入账方式	1（暗补）
            failRechare.setSupplyRechargeType(TradeConstants.SUPPLY_RECHARGE_TYPE_1);
            //充值补差台账类别	来自输入
            failRechare.setSupplyLedgerType(request.getBody().getSupply_ledger_type());
            //充值补差台账客户保留字段1	来自输入
            failRechare.setSupplyLedgerExtendField1(request.getBody().getSupply_ledger_extend_field_1());
            //充值补差台账客户保留字段2	来自输入
            failRechare.setSupplyLedgerExtendField2(request.getBody().getSupply_ledger_extend_field_2());
            //充值补差台账客户保留字段3	来自输入
            failRechare.setSupplyLedgerExtendField3(request.getBody().getSupply_ledger_extend_field_3());
            //充值补差损益属性1	来自输入
            failRechare.setSupplyProfitLossAttr1(request.getBody().getSupply_profit_loss_attr_1());
            //充值补差损益属性2	来自输入
            failRechare.setSupplyProfitLossAttr2(request.getBody().getSupply_profit_loss_attr_2());
            //充值补差损益属性3	来自输入
            failRechare.setSupplyProfitLossAttr3(request.getBody().getSupply_profit_loss_attr_3());
            //充值补差损益属性4	来自输入
            failRechare.setSupplyProfitLossAttr4(request.getBody().getSupply_profit_loss_attr_4());
            //充值补差损益属性5	来自输入
            failRechare.setSupplyProfitLossAttr5(request.getBody().getSupply_profit_loss_attr_5());
            //充值补差损益属性6	来自输入
            failRechare.setSupplyProfitLossAttr6(request.getBody().getSupply_profit_loss_attr_6());
            //充值补差损益属性7	来自输入
            failRechare.setSupplyProfitLossAttr7(request.getBody().getSupply_profit_loss_attr_7());
            //充值补差损益属性8	来自输入
            failRechare.setSupplyProfitLossAttr8(request.getBody().getSupply_profit_loss_attr_8());
            //充值补差损益属性9	来自输入
            failRechare.setSupplyProfitLossAttr9(request.getBody().getSupply_profit_loss_attr_9());
            //充值补差损益属性10	来自输入
            failRechare.setSupplyProfitLossAttr10(request.getBody().getSupply_profit_loss_attr_10());
            this.tradeRecharge = rechargeService.createTradeFailureRecode(failRechare);
//			this.id = tradeRecharge.getId();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->创建失败的下线充值交易失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00050010011001000");
        }
    }

    @Override
    public void transactionStep02(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) throws Exception {
        logger.error("--->开始执行第二个事务。。。");
        //如果【充值补差付出方式】为【台账】且【充值补差金额】不为空，创建补差损益台账
        createSupplyProfitLedger();
        logger.error("--->开始执行第二个事务。。。createSupplyProfitLedger");
        //账务操作
        handlerRealAcount(tradeRquest);
        logger.error("--->开始执行第二个事务。。。handlerRealAcount");
        //如果充值手续费金额>0，不为空，且充值手续费接收方式为【台账】，创建手续费损益台账
        createFeeProfitLedger();
        logger.error("--->开始执行第二个事务。。。createFeeProfitLedger");
        //修改交易记录
        updateTradeRecharge(tradeRquest);
        logger.error("--->开始执行第二个事务。。。updateTradeRecharge");
    }

    /**
     * 创建手续费损益台账
     *
     * @Title:createProfitLedger
     * @Description: 创建手续费损益台账
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午4:13:53
     */
    private void createFeeProfitLedger() {
        String way = this.tradeRecharge.getFeeWay();
        Long amount = this.tradeRecharge.getFeeAmount();//手续费金额
        if (!StringUtils.isEmpty(way) && TradeConstants.FEE_WAY_LEDGER.equals(way) && (amount != null && amount > 0)) {
            TradeProfitLossLedger ledger = new TradeProfitLossLedger();
            try {
                //核心商户编号
                ledger.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo());
                //资金池编号
                ledger.setFundPoolNo(this.tradeRecharge.getFundPoolNo());
                //业务台账客户保留字段1
                ledger.setMerchantExtendField1(this.tradeRecharge.getFeeLedgerExtendField1());
                //业务台账客户保留字段2
                ledger.setMerchantExtendField2(this.tradeRecharge.getFeeLedgerExtendField2());
                //业务台账客户保留字段3
                ledger.setMerchantExtendField3(this.tradeRecharge.getFeeLedgerExtendField3());
                //所属业务交易类型
                ledger.setTradeType(TradeUtilCommon.getTradeType(TradeConstants.TRADE_OFFLINE_RECHARGE));
                //所属业务交易编号
                ledger.setTradeNo(this.tradeRecharge.getTradeNo());
                //所属业务交易创建日期
                ledger.setGmtTradeCreated(this.tradeRecharge.getGmtCreated());
                //生效交易请求类型
                ledger.setEffectiveReqType(TradeConstants.TRADE_OFFLINE_RECHARGE);
                //生效交易请求编号
                ledger.setEffectiveReqNo(this.reqNo);
                //交易发起方发起请求编号
                ledger.setOutTradeNoExt(this.tradeRecharge.getOutTradeNoExt());
                //交易发起方业务系统订单号
                ledger.setOutTradeNo(this.tradeRecharge.getOutTradeNo());
                ledger.setGmtEffective(new Date());
                ledger.setProfitLossAttr1(this.tradeRecharge.getFeeProfitLossAttr1());
                ledger.setProfitLossAttr2(this.tradeRecharge.getFeeProfitLossAttr2());
                ledger.setProfitLossAttr3(this.tradeRecharge.getFeeProfitLossAttr3());
                ledger.setProfitLossAttr4(this.tradeRecharge.getFeeProfitLossAttr4());
                ledger.setProfitLossAttr5(this.tradeRecharge.getFeeProfitLossAttr5());
                ledger.setProfitLossAttr6(this.tradeRecharge.getFeeProfitLossAttr6());
                ledger.setProfitLossAttr7(this.tradeRecharge.getFeeProfitLossAttr7());
                ledger.setProfitLossAttr8(this.tradeRecharge.getFeeProfitLossAttr8());
                ledger.setProfitLossAttr9(this.tradeRecharge.getFeeProfitLossAttr9());
                ledger.setProfitLossAttr10(this.tradeRecharge.getFeeProfitLossAttr10());
                String feeLedgerType = this.tradeRecharge.getFeeLedgerType();//充值手续费台账类别1收入增加,2成本费用减少,【充值手续费付出方式】为1时必输
                if (TradeConstants.HANDING_LEDGER_TYPE_INCOME_INC.equals(feeLedgerType)) {
                    //收入增加	来自交易【充值手续费金额】（【充值手续费台账类别】为【收入增加】）
                    ledger.setIncomeIncr(amount);
                } else if (TradeConstants.HANDING_LEDGER_TYPE_COSET_DEC.equals(feeLedgerType)) {
                    //成本费用减少	来自交易【充值手续费金额】（【充值手续费台账类别】为【成本费用减少】）
                    ledger.setCostDecr(amount);
                }
                this.feeLedgerNo = profitLossLedgerService.createEffectiveProfitLossLedger(ledger);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("-->创建损益台账失败：" + e.getMessage(), e);
                throw exceptionService.buildBusinessException("TZ000200101");
            }
        }
    }

    /**
     * 创建补差损益台账
     *
     * @Title:createProfitLedger
     * @Description: 创建补差损益台账
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午4:13:53
     */
    private void createSupplyProfitLedger() {
        logger.info("-->创建补差损益台账   " + this.tradeRecharge);
        String way = this.tradeRecharge.getSupplyWay();
        Long amount = this.tradeRecharge.getSupplyAmount();
        if (!StringUtils.isEmpty(way) && TradeConstants.SUPPLY_WAY_LEDGER.equals(way) && amount != null && amount > 0) {
            TradeProfitLossLedger ledger = new TradeProfitLossLedger();
            try {
                //核心商户编号
                ledger.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo());
                //资金池编号
                ledger.setFundPoolNo(this.tradeRecharge.getFundPoolNo());
                //业务台账客户保留字段1
                ledger.setMerchantExtendField1(this.tradeRecharge.getSupplyLedgerExtendField1());
                //业务台账客户保留字段2
                ledger.setMerchantExtendField2(this.tradeRecharge.getSupplyLedgerExtendField2());
                //业务台账客户保留字段3
                ledger.setMerchantExtendField3(this.tradeRecharge.getSupplyLedgerExtendField3());
                //所属业务交易类型
                ledger.setTradeType(TradeUtilCommon.getTradeType(TradeConstants.TRADE_OFFLINE_RECHARGE));
                //所属业务交易编号
                ledger.setTradeNo(this.tradeRecharge.getTradeNo());
                //所属业务交易创建日期
                ledger.setGmtTradeCreated(this.tradeRecharge.getGmtCreated());
                //生效交易请求类型
                ledger.setEffectiveReqType(TradeConstants.TRADE_OFFLINE_RECHARGE);
                //生效交易请求编号
                ledger.setEffectiveReqNo(this.reqNo);
                //交易发起方发起请求编号
                ledger.setOutTradeNoExt(this.tradeRecharge.getOutTradeNoExt());
                //交易发起方业务系统订单号
                ledger.setOutTradeNo(this.tradeRecharge.getOutTradeNo());
                ledger.setGmtEffective(new Date());
                ledger.setProfitLossAttr1(this.tradeRecharge.getSupplyProfitLossAttr1());
                ledger.setProfitLossAttr2(this.tradeRecharge.getSupplyProfitLossAttr2());
                ledger.setProfitLossAttr3(this.tradeRecharge.getSupplyProfitLossAttr3());
                ledger.setProfitLossAttr4(this.tradeRecharge.getSupplyProfitLossAttr4());
                ledger.setProfitLossAttr5(this.tradeRecharge.getSupplyProfitLossAttr5());
                ledger.setProfitLossAttr6(this.tradeRecharge.getSupplyProfitLossAttr6());
                ledger.setProfitLossAttr7(this.tradeRecharge.getSupplyProfitLossAttr7());
                ledger.setProfitLossAttr8(this.tradeRecharge.getSupplyProfitLossAttr8());
                ledger.setProfitLossAttr9(this.tradeRecharge.getSupplyProfitLossAttr9());
                ledger.setProfitLossAttr10(this.tradeRecharge.getSupplyProfitLossAttr10());
                String supplyLedgerType = this.tradeRecharge.getSupplyLedgerType();//充值补差台账类别
                if (TradeConstants.SUPPLY_LEDGER_TYPE_INCOME_DEC.equals(supplyLedgerType)) {
                    //收入减少金额	来自交易【充值补差金额】（【充值补差台账类别】为【收入减少】）
                    ledger.setIncomeDecr(amount);
                } else if (TradeConstants.SUPPLY_LEDGER_TYPE_COSET_INC.equals(supplyLedgerType)) {
                    //成本费用增加金额	来自交易【充值补差金额】（【充值补差台账类别】为【成本费用增加】）
                    ledger.setCostIncr(amount);
                }
                this.supplyLedgerNo = profitLossLedgerService.createEffectiveProfitLossLedger(ledger);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("-->创建损益台账失败：" + e.getMessage(), e);
                throw exceptionService.buildBusinessException("TZ000200101");
            }
        }
    }

    /**
     * 账务操作
     *
     * @param tradeRquest
     * @Title:handlerRealAcount
     * @Description:账务操作
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午4:29:11
     */
    private void handlerRealAcount(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) {
        List<RealTimeAccountingVo> request_list = new ArrayList<RealTimeAccountingVo>();
        //1 充值补差出账
        RealTimeAccountingVo realAcountSetp1 = realAcountSetp1(tradeRquest);
        if (realAcountSetp1 != null) {
            request_list.add(realAcountSetp1);
        }
        //2 充值入账
        RealTimeAccountingVo realAcountSetp2 = realAcountSetp2(tradeRquest);
        if (realAcountSetp2 != null) {
            request_list.add(realAcountSetp2);
        }
        //3 手续费扣除
        RealTimeAccountingVo realAcountSetp3 = realAcountSetp3(tradeRquest);
        if (realAcountSetp3 != null) {
            request_list.add(realAcountSetp3);
        }
        //4 手续费入账
        RealTimeAccountingVo realAcountSetp4 = realAcountStep4(tradeRquest);
        if (realAcountSetp4 != null) {
            request_list.add(realAcountSetp4);
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
            logger.error(tradeRquest.getHead().getRequest_code(), e);
            throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            throw exceptionService.buildBusinessException("JY000000000000401");
        }
    }

    /**
     * 充值补差出账
     *
     * @param tradeRquest
     * @Title:realAcountSetp1
     * @Description: 充值补差出账
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午4:19:39
     */
    private RealTimeAccountingVo realAcountSetp1(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) {
        String type = this.tradeRecharge.getSupplyWay();
        Long money = this.tradeRecharge.getSupplyAmount();
        if (!StringUtils.isEmpty(type) && TradeConstants.SUPPLY_WAY_CA.equals(type) && (money != null && money > 0)) {
            RealTimeAccountVO accountvo = new RealTimeAccountVO();
            accountvo.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo()); // 核心商户编号
            accountvo.setAccountNo(this.tradeRecharge.getSupplyPayAccountNo());
            accountvo.setPoolNo(this.tradeRecharge.getFundPoolNo()); // 资金池编号
            accountvo.setReservedFields1(this.tradeRecharge.getSupplyPayAccountExtendField1());
            accountvo.setReservedFields2(this.tradeRecharge.getSupplyPayAccountExtendField2());
            accountvo.setReservedFields3(this.tradeRecharge.getSupplyPayAccountExtendField3());

            accountvo.setSequenceNo(this.tradeRecharge.getOutTradeNo()); // 本交易业务系统订单号
            accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0005_001
            accountvo.setTradeNo(this.tradeRecharge.getTradeNo()); // 本交易编号
            accountvo.setTradeGmtCreated(this.tradeRecharge.getGmtCreated()); // 本交易创建时间
            accountvo.setTradeReqCode(TradeConstants.TRADE_OFFLINE_RECHARGE); // 交易请求类型0005_001_001
            accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
            accountvo.setAmount(money);
            return bizAccountService.avlBalDecrWrapper(accountvo);
        }
        return null;
    }

    /**
     * 充值入账
     *
     * @param tradeRquest
     */
    private RealTimeAccountingVo realAcountSetp2(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo()); // 核心商户编号
        accountvo.setAccountNo(this.tradeRecharge.getRechargeAccountNo());
        accountvo.setPoolNo(this.tradeRecharge.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeRecharge.getRechargeAccountExtendField1());
        accountvo.setReservedFields2(this.tradeRecharge.getRechargeAccountExtendField2());
        accountvo.setReservedFields3(this.tradeRecharge.getRechargeAccountExtendField3());

        accountvo.setSequenceNo(this.tradeRecharge.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0005_001
        accountvo.setTradeNo(this.tradeRecharge.getTradeNo()); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeRecharge.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OFFLINE_RECHARGE); // 交易请求类型0005_001_001
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setAmount(this.tradeRecharge.getRechargeAmount());
        return bizAccountService.avlBalIncrWrapper(accountvo);

    }

    /**
     * 手续费扣除
     *
     * @param tradeRquest
     * @Title:realAcountSetp3
     * @Description: 手续费扣除
     * @return:void
     * @author:zoran.huang
     * @date:2016年5月4日 上午11:48:18
     */
    private RealTimeAccountingVo realAcountSetp3(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) {
        Long feeAmount = this.tradeRecharge.getFeeAmount();//充值手续费
        if (null != feeAmount && feeAmount > 0) {
            RealTimeAccountVO accountvo = new RealTimeAccountVO();
            accountvo.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo()); // 核心商户编号
            accountvo.setAccountNo(this.tradeRecharge.getRechargeAccountNo());
            accountvo.setPoolNo(this.tradeRecharge.getFundPoolNo()); // 资金池编号
            accountvo.setReservedFields1(this.tradeRecharge.getFeePayAccountExtendField1());//充值手续费充值CA账户扣费账务历史1
            accountvo.setReservedFields2(this.tradeRecharge.getFeePayAccountExtendField2());//充值手续费充值CA账户扣费账务历史2
            accountvo.setReservedFields3(this.tradeRecharge.getFeePayAccountExtendField3());//充值手续费充值CA账户扣费账务历史3

            accountvo.setSequenceNo(this.tradeRecharge.getOutTradeNo()); // 本交易业务系统订单号
            accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0005_001
            accountvo.setTradeNo(this.tradeRecharge.getTradeNo()); // 本交易编号
            accountvo.setTradeGmtCreated(this.tradeRecharge.getGmtCreated()); // 本交易创建时间
            accountvo.setTradeReqCode(TradeConstants.TRADE_OFFLINE_RECHARGE); // 交易请求类型0005_001_001
            accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
            accountvo.setAmount(feeAmount);
            return bizAccountService.avlBalDecrWrapper(accountvo);
        }
        return null;
    }

    /**
     * 手续费入帐
     *
     * @param tradeRquest
     * @Title:realAcountStep4
     * @Description: 手续费入帐
     * @return:void
     * @author:zoran.huang
     * @date:2016年5月4日 上午11:49:19
     */
    private RealTimeAccountingVo realAcountStep4(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) {
        String type = this.tradeRecharge.getFeeWay();//充值手续费接收方式
        Long feeAmount = this.tradeRecharge.getFeeAmount();//充值手续费
        if (!StringUtils.isEmpty(type) && TradeConstants.SUPPLY_WAY_CA.equals(type) && (feeAmount != null && feeAmount > 0)) {
            RealTimeAccountVO accountvo = new RealTimeAccountVO();
            accountvo.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo()); // 核心商户编号
            accountvo.setAccountNo(this.tradeRecharge.getFeeReceiveAccountNo());//充值手续费收款账号
            accountvo.setPoolNo(this.tradeRecharge.getFundPoolNo()); // 资金池编号
            accountvo.setReservedFields1(this.tradeRecharge.getFeeReceiveAccountExtendField1());//充值手续费收款账户入账账务历史1
            accountvo.setReservedFields2(this.tradeRecharge.getFeeReceiveAccountExtendField2());//充值手续费收款账户入账账务历史2
            accountvo.setReservedFields3(this.tradeRecharge.getFeeReceiveAccountExtendField3());//充值手续费收款账户入账账务历史3

            accountvo.setSequenceNo(this.tradeRecharge.getOutTradeNo()); // 本交易业务系统订单号
            accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0005_001
            accountvo.setTradeNo(this.tradeRecharge.getTradeNo()); // 本交易编号
            accountvo.setTradeGmtCreated(this.tradeRecharge.getGmtCreated()); // 本交易创建时间
            accountvo.setTradeReqCode(TradeConstants.TRADE_OFFLINE_RECHARGE); // 交易请求类型0005_001_001
            accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
            accountvo.setAmount(feeAmount);
            return bizAccountService.avlBalIncrWrapper(accountvo);
        }
        return null;
    }

    /**
     * @param tradeRquest
     * @Title:updateTradeRecharge
     * @Description: 修改交易记录为成功关闭状态
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午5:02:37
     */
    private void updateTradeRecharge(TradeRequest<TradePacketReqBodyRechargeOffline> tradeRquest) {
        try {
            TradeRecharge newTradeRecharge = new TradeRecharge();
            BeanUtils.copyProperties(this.tradeRecharge, newTradeRecharge);
            Date successDateTime = new Date();
            //交易结束状态	【已结束】
            newTradeRecharge.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
            //交易状态	【充值成功】
            newTradeRecharge.setStatus(TradeConstants.TRADE_RECHARGE_SUCCESS);
            //充值成功日期时间	系统日期时间
            newTradeRecharge.setGmtRechargeSuccess(successDateTime);
            //最后变更日期时间	系统日期时间
            newTradeRecharge.setGmtLatestModified(successDateTime);
            //最后变更交易请求类型	本次请求类型
            newTradeRecharge.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());
            //最后变更交易请求编号	本次请求编号
            newTradeRecharge.setLatestReqNo(this.reqNo);
            //充值手续费台账编号	来自台账,【充值手续费接收方式】为【台账】时fee_ledger_no
            if (!StringUtils.isEmpty(this.feeLedgerNo)) {
                newTradeRecharge.setFeeLedgerNo(this.feeLedgerNo);
            }
            //充值补差台账编号	来自台账,【充值补差付出方式】为【台账】时supply_ledger_no
            if (!StringUtils.isEmpty(this.supplyLedgerNo)) {
                newTradeRecharge.setSupplyLedgerNo(this.supplyLedgerNo);
            }
            //交易版本号	原版本号+1
            this.tradeRecharge = rechargeService.updateTradeSuccess(newTradeRecharge);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->充值交易记录修改失败:" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00050010011001100");
        }
    }

    @Override
    public Object getTradeDetails() {
        return this.tradeRecharge;

    }

    @Override
    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

}