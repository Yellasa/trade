package com.liantuo.trade.bus.process.impl.single_payment_refund;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface;
import com.liantuo.trade.bus.service.*;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateSingleTxNoPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.OtherPofitLossLedgerForRefund;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.TradePacketReqBodyOuterRefund;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.TradeCommonValidation;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.*;
import com.liantuo.trade.orm.pojo.subvo.TradeSinglePaymentRefundVo;
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
 * @author zoran.huang
 * @version V1.0
 * @Description: 0006_002_002 V1.0外部支付退款扣帐 (一个事物)
 * @Company: 联拓金融信息服务有限公司
 * @date 2016年6月6日 上午9:59:51
 */
@JobFlow(value = "0006_002_002", version = "1.0", template = ATradeCreateSingleTxNoPaymentTemp.class)
public class SinglePaymentRefundOuterOfflineProcess implements TradeCreateSingleTxNoPaymentInterface<TradePacketReqBodyOuterRefund> {
    private static Logger logger = LoggerFactory.getLogger(SinglePaymentRefundOuterOfflineProcess.class);

    @Autowired
    private ExceptionService exceptionService;
    @Resource(name = "singlePaymentRefundServiceImpl")
    private SinglePaymentRefundService singlePaymentRefundService;
    @Resource(name = "singlePaymentServiceImpl")
    private SinglePaymentService singlePaymentService;
    @Resource(name = "idFactorySinglePaymentRefundTradeNo")
    private IdFactory idFactorySinglePaymentRefundTradeNo;
    @Resource(name = "profitLossLedgerServiceImpl")
    private ProfitLossLedgerService profitLossLedgerService;    // 损益台账service
    @SuppressWarnings("rawtypes")
    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService bizAccountService;
    @Resource(name = "legderServiceImpl")

    private LegderService legderService;
    private TradeSinglePayment tradeSinglePayment;// 原交易
    private String oiginalTradePayType;// 原交易支付类别
    private List<TradePacketReqBodyOtherPofitLossLedger> otherProfitLossList;// 其他损益台账数据集合
    private String tradeNo;// 本次交易编号
    private Date gmtCreated;// 本次交易创建时间
    private String reqNo; // 交易请求编号
    private String refundReceivedLossLedgerNo;// 收款损益退回台账编号
    private String ledgerNo;// 空白付款外部退回台账编号
    private TradeSinglePaymentRefund singlePaymentRefund;
    private String refundExtendProfitLoss; // 其他损益台账

    @Override
    public void formatValidate(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        logger.info("开始业务数据格式验证-->");
        String errMsg = TradeValidationUtil.validateRequestWeak(tradeRquest);
        if (!StringUtils.isEmpty(errMsg)) {
            logger.info("-->输入参数校验不通过：" + errMsg);
            throw exceptionService.buildBusinessException("JY00060020021000100", errMsg);
        }
        //【income_incr、income_decr、cost_incr、cost_decr】有且有且只能有一个金额存在
//		validateOtherProfitLossList(tradeRquest.getBody().getProfit_loss_list());
        logger.info("业务数据格式验证结束-->");
    }

    /**
     * @param bodyOtherPofitLossLedgers
     * @Title:validateOtherProfitLossList
     * @Description: 验证【income_incr、income_decr、cost_incr、cost_decr】有且只有一个金额存在
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月14日 上午10:47:33
     */
    private void validateOtherProfitLossList(List<TradePacketReqBodyOtherPofitLossLedger> bodyOtherPofitLossLedgers) {
        if (bodyOtherPofitLossLedgers != null) {
            for (TradePacketReqBodyOtherPofitLossLedger pofitLossLedger : bodyOtherPofitLossLedgers) {
                int incomeIncr = StringUtils.isEmpty(pofitLossLedger.getIncome_incr()) ? 0 : 1;
                int iincomeDecr = StringUtils.isEmpty(pofitLossLedger.getIncome_decr()) ? 0 : 1;
                int costIncr = StringUtils.isEmpty(pofitLossLedger.getCost_incr()) ? 0 : 1;
                int costDecr = StringUtils.isEmpty(pofitLossLedger.getCost_decr()) ? 0 : 1;
                int result = (incomeIncr + iincomeDecr + costIncr + costDecr);
                if (result != 1) {
                    logger.info("-->输入参数校验不通过： 【income_incr、income_decr、cost_incr、cost_decr】有且有且只能有一个金额存在");
                    throw exceptionService.buildBusinessException("JY00060020021000100", "其他损益属性【income_incr、income_decr、cost_incr、cost_decr】有且只有一个金额存在");
                }
                /*boolean isHaveIncomeIncr = StringUtils.isEmpty(pofitLossLedger.getIncome_incr());
				boolean isHaveIncomeDecr = StringUtils.isEmpty(pofitLossLedger.getIncome_decr());
				boolean isHaveCostIncr = StringUtils.isEmpty(pofitLossLedger.getCost_incr());
				boolean isHaveCostDecr = StringUtils.isEmpty(pofitLossLedger.getCost_decr());
				//如果其他损益台账List收入增加金额有值
				if(!isHaveIncomeIncr){
					//判断其他三个属性必须全部为空
					if( !(isHaveIncomeDecr && isHaveCostIncr && isHaveCostDecr)){
						logger.info("-->输入参数校验不通过： 【income_incr、income_decr、cost_incr、cost_decr】有且有且只能有一个金额存在");
						throw exceptionService.buildBusinessException("JY00060020021000100", "其他损益属性【income_decr、cost_incr、cost_decr】，必须为空");
					}
					return ;
				}
				//如果其他损益台账List收入减少金额有值
				if(!isHaveIncomeDecr){
					//判断其他两个属性必须全部为空
					if(!(isHaveCostIncr && isHaveCostDecr)){
						logger.info("-->输入参数校验不通过： 【income_incr、income_decr、cost_incr、cost_decr】有且有且只能有一个金额存在");
						throw exceptionService.buildBusinessException("JY00060020021000100", "其他损益属性【cost_incr、cost_decr】，必须为空");
					}
					return ;
				}
				//如果其他损益台账List成本费用增加金额有值
				if(!isHaveCostIncr){
					//判断剩余的属性
					if(!isHaveCostDecr){
						logger.info("-->输入参数校验不通过： 【income_incr、income_decr、cost_incr、cost_decr】有且只能有一个金额存在");
						throw exceptionService.buildBusinessException("JY00060020021000100", "其他损益属性【cost_decr】，必须为空");
					}
					return ;
				}
				//如果其他损益台账List成本费用减少金额为空
				if(isHaveIncomeDecr){
					logger.info("-->输入参数校验不通过： 【income_incr、income_decr、cost_incr、cost_decr】有且有且只能有一个金额存在");
					throw exceptionService.buildBusinessException("JY00060020021000100", "其他损益属性【income_incr、income_decr、cost_incr、cost_decr】，全部为空");
				}*/
            }
        }
    }

    @Override
    public void bizValidate(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        // 1.校验【核心商户编号】、【资金池编号】对应关系
        TradeCommonValidation.validateCoreMerchantNoAndFundPoolNo(tradeRquest, false, exceptionService.buildBusinessException("JY00060020021000200"));
//		validateCoreMerchantNoAndFundPoolNo(tradeRquest);

        // 2.校验【交易发起方发起请求编号】是否重复
        validateDuplicate(tradeRquest);

		/*
		 * 3、校验【核心商户编号】、【资金池编号】、【原交易编号】，原交易类型对应关系 4、查看原交易状态
		 * 5、校验原交易状态，校验原交易是否已关闭，原交易【交易组别】 6、原交易付款方付出方式【第三方充付】时,付款方账户退回入账金额必须填写
		 */
        validateOiginalTrade(tradeRquest);

        // 7.校验退款金额关系
        validateRefundMoney(tradeRquest);

        // 8.校验累计退款各项金额是否超过原交易各项金额
        validateSumRefundMoney(tradeRquest);
    }

    /**
     * @param tradeRquest
     * @Title:validateSumRefundMoney
     * @Description:校验累计退款各项金额是否超过原交易各项金额
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月6日 下午2:39:51
     */
    private void validateSumRefundMoney(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) {
        // 累计收款方退款金额
        // 原交易【累计收款方退款金额】+输入【收款方退回付出金额】<=原交易【收款方收到金额】（注：即使分润了，也可以先行退款，所以不考虑分润）
        long sum_refunded_receive_account_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedReceiveAccountAmt());
        long refund_receive_amt = str2long(tradeRquest.getBody().getRefund_receive_amt());
        long receive_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getReceiveAmt());
        if ((sum_refunded_receive_account_amt + refund_receive_amt) > receive_amt) {
            logger.info("-->原交易【累计收款方退款金额:" + refund_receive_amt + "】+输入【收款方退回付出金额:" + refund_receive_amt + "】>原交易【收款方收到金额:" + receive_amt + "】");
            throw exceptionService.buildBusinessException("JY00060020021001200");
        }
        // 累计付款方账户手续费退回金额
        // 原交易【累计付款方账户手续费退回金额】+输入【付款方手续费账户退回入账金额】<=原交易【付款方手续费账户出账金额】
        long sum_refunded_pay_fee_account_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedPayFeeAccountAmt());
        long refund_pay_fee_account_in_accounting_amt = str2long(tradeRquest.getBody().getRefund_pay_fee_account_in_accounting_amt());
        long pay_fee_account_out_accounting_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getPayFeeAccountOutAccountingAmt());
        if ((sum_refunded_pay_fee_account_amt + refund_pay_fee_account_in_accounting_amt) > pay_fee_account_out_accounting_amt) {
            logger.info("-->原交易【累计付款方账户手续费退回金额:" + sum_refunded_pay_fee_account_amt + "】+输入【付款方手续费账户退回入账金额:" + refund_pay_fee_account_in_accounting_amt + "】>原交易【付款方手续费账户出账金额:" + pay_fee_account_out_accounting_amt + "】");
            throw exceptionService.buildBusinessException("JY00060020021001200");
        }

        // 累计收款方账户手续费退回金额
        // 原交易【累计收款方账户手续费退回金额】+输入【收款方手续费账户退回入账金额】<=原交易【收款方手续费账户出账金额】
        long sum_refunded_receive_fee_account_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedReceiveFeeAccountAmt());
        long refund_receive_fee_account_in_accounting_amt = str2long(tradeRquest.getBody().getRefund_receive_fee_account_in_accounting_amt());
        long receive_fee_account_out_accounting_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getReceiveFeeAccountOutAccountingAmt());
        if ((sum_refunded_receive_fee_account_amt + refund_receive_fee_account_in_accounting_amt) > receive_fee_account_out_accounting_amt) {
            logger.info("-->原交易【累计收款方账户手续费退回金额:" + sum_refunded_receive_fee_account_amt + "】+输入【收款方手续费账户退回入账金额:" + refund_receive_fee_account_in_accounting_amt + "】>原交易【收款方手续费账户出账金额:" + receive_fee_account_out_accounting_amt + "】");
            throw exceptionService.buildBusinessException("JY00060020021001200");
        }

        // 当原交易【付款方付出方式】为【第三方充付】时校验（本次退款为第三方充退），原交易【累计付款方账户出账退回金额】+输入【付款方账户退回入账金额】<=原交易【付款方账户出账金额】
        if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType)) {
            long sum_refunded_pay_account_out_accounting_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedPayAccountOutAccountingAmt());
            long refund_pay_account_in_accounting_amt = str2long(tradeRquest.getBody().getRefund_pay_account_in_accounting_amt());
            long pay_account_out_accounting_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getPayAccountOutAccountingAmt());
            if ((sum_refunded_pay_account_out_accounting_amt + refund_pay_account_in_accounting_amt) > pay_account_out_accounting_amt) {
                logger.info("-->原交易【累计付款方账户出账退回金额:" + sum_refunded_pay_account_out_accounting_amt + "】+输入【付款方账户退回入账金额:" + refund_pay_account_in_accounting_amt + "】>原交易【付款方账户出账金额:" + pay_account_out_accounting_amt + "】");
                throw exceptionService.buildBusinessException("JY00060020021001200");
            }
        }
        // 原交易【累计付款方台账退回金额】+输入【付款方外部退回付款金额】<=原交易【付款方外部收款金额】
        long sum_refunded_pay_ledger_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedPayLedgerAmt());
        long external_refund_amt = str2long(tradeRquest.getBody().getExternal_refund_amt());
        long external_pay_received_amt = AmountUtils.ifNullOrElse(tradeSinglePayment.getExternalPayReceivedAmt());
        if ((sum_refunded_pay_ledger_amt + external_refund_amt) > external_pay_received_amt) {
            logger.info("-->原交易【累计付款方台账退回金额:" + sum_refunded_pay_ledger_amt + "】+输入【付款方外部退回付款金额:" + external_refund_amt + "】>原交易【付款方外部收款金额:" + external_pay_received_amt + "】");
            throw exceptionService.buildBusinessException("JY00060020021001200");
        }
    }

    /**
     * @param tradeRquest
     * @Title:validateRefundMoney
     * @Description:校验退款金额关系
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月6日 下午2:11:42
     */
    private void validateRefundMoney(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) {
        long forwardAmount = 0; // 正向
        long negativeAmount = 0; // 负向
        // 付款方外部退回付出金额 负向，原交易【付款方付出方式】为【第三方充付】时，不计算
        if (!TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType)) {
            negativeAmount = negativeAmount + str2long(tradeRquest.getBody().getExternal_refund_amt());
        }
        // 付款方账户退回入账金额 负向，原交易【付款方付出方式】为【第三方直付】时，不计算
        if (!TradeConstants.PAY_BY_THIRD.equals(oiginalTradePayType)) {
            negativeAmount = negativeAmount + str2long(tradeRquest.getBody().getRefund_pay_account_in_accounting_amt());
        }
        // 付款方手续费账户退回入账金额 负向 refund_pay_fee_account_in_accounting_amt
        negativeAmount = negativeAmount + str2long(tradeRquest.getBody().getRefund_pay_fee_account_in_accounting_amt());

        // 收款方手续费账户退回入账金额 负向 refund_receive_fee_account_in_accounting_amt
        negativeAmount = negativeAmount + str2long(tradeRquest.getBody().getRefund_receive_fee_account_in_accounting_amt());

        otherProfitLossList = tradeRquest.getBody().getProfit_loss_list();
        if (otherProfitLossList != null) {
            for (TradePacketReqBodyOtherPofitLossLedger otherPofitLossLedger : otherProfitLossList) {
                // 其他损益台账X收入增加金额 负向 income_incr
                negativeAmount = negativeAmount + str2long(otherPofitLossLedger.getIncome_incr());
                // 其他损益台账X收入减少金额 正向 income_decr
                forwardAmount = forwardAmount + str2long(otherPofitLossLedger.getIncome_decr());
                // 其他损益台账X成本费用增加金额 正向 cost_incr
                forwardAmount = forwardAmount + str2long(otherPofitLossLedger.getCost_incr());
                // 其他损益台账X成本费用减少金额 负向 cost_decr
                negativeAmount = negativeAmount + str2long(otherPofitLossLedger.getCost_decr());
            }
        }
        // 收款方退回付出金额 正向 refund_receive_type
        forwardAmount = forwardAmount + str2long(tradeRquest.getBody().getRefund_receive_amt());
        if (negativeAmount != forwardAmount) {
            logger.info("-->校验退款金额关系,金额合计校验不通过:正向金额：【" + forwardAmount + "】,负向金额：【" + negativeAmount + "】");
            throw exceptionService.buildBusinessException("JY00060020021000900");
        }
    }

    /**
     * @Description: 将字符串转换为数字
     */
    private long str2long(String str) {
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

    /**
     * @Description: 将字符串转换为数字
     */
    private Long str2Long(String str) {
        Long parseNum = null;
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

    /**
     * @param tradeRquest
     * @throws Exception
     * @Title:checkMatchCoreMerchantNoFundPoolNoCreditAccount
     * @Description:1、校验【核心商户编号】、【资金池编号】、【原交易编号】，原交易类型对应关系, 2、查看原交易状态
     * 3、校验原交易状态，校验原交易是否已关闭
     * ，原交易【交易组别】
     * 4、原交易付款方付出方式
     * 【第三方充付】时,
     * 付款方账户退回入账金额必须填写
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月6日 下午1:37:08
     */
    private void validateOiginalTrade(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        TradeSinglePaymentExample example = new TradeSinglePaymentExample();
        example.createCriteria().andCoreMerchantNoEqualTo(tradeRquest.getHead().getCore_merchant_no()).andFundPoolNoEqualTo(tradeRquest.getHead().getFund_pool_no()).andTradeNoEqualTo(tradeRquest.getBody().getOriginal_trade_no());

        List<TradeSinglePayment> list = singlePaymentService.queryByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            logger.info("-->原交易不存在");
            throw exceptionService.buildBusinessException("JY00060020021000500");
        }
        tradeSinglePayment = list.get(0);
        oiginalTradePayType = tradeSinglePayment.getPayType();
        // 校验原交易状态为【支付成功】,若校验失败，返回【失败】
        if (!TradeConstants.TRADE_PAYMENT_SUCCESS.equals(tradeSinglePayment.getStatus())) {
            logger.info("-->原交易状态:[" + tradeSinglePayment.getStatus() + "],原交易状态不正确");
            throw exceptionService.buildBusinessException("JY00060020021000600");
        }
        // 校验原交易后续交易状态是否为【开启】，若不是，校验失败，返回【失败】
        if (!TradeConstants.CONTINUE_TRADE_STATUS_OPEN.equals(tradeSinglePayment.getContinueTradeStatus())) {
            logger.info("-->原交易后续交易状态是:[" + tradeSinglePayment.getContinueTradeStatus() + "],原交易已关闭");
            throw exceptionService.buildBusinessException("JY00060020021000700");
        }
        // 校验原交易状态，校验原交易是否已关闭，原交易【交易组别】原交易类型不正确
        if (!TradeConstants.PAY_TYPE_BY_THIRD.equals(tradeSinglePayment.getTradeCatagory())) {
            logger.info("-->原交易类型:[" + tradeSinglePayment.getTradeCatagory() + "],原交易类型不正确");
            throw exceptionService.buildBusinessException("JY00060020021000800");
        }
        // 付款方账户退回入账金额:原交易付款方付出方式【第三方充付】时必须填写
        if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType) && StringUtils.isEmpty(tradeRquest.getBody().getRefund_pay_account_in_accounting_amt())) {
            logger.info("-->原交易付款方付出方式【第三方充付】时必须填写");
            throw exceptionService.buildBusinessException("JY00060020021000100", "原交易付款方付出方式【第三方充付】时refund_pay_account_in_accounting_amt必须填写");
        }

    }

    /**
     * @param tradeRquest
     * @throws Exception
     * @Title:checkDuplicate
     * @Description:校验【交易发起方发起请求编号】是否重复
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月6日 下午1:25:26
     */
    private void validateDuplicate(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        TradeSinglePaymentRefund query = new TradeSinglePaymentRefund();
        query.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());
        query.setOutTradeNoExt(tradeRquest.getBody().getOut_trade_no_ext());
        List<TradeSinglePaymentRefund> list = singlePaymentRefundService.queryByOutTradeNoExt(query);
        if (!CollectionUtils.isEmpty(list)) {
            logger.info("-->交易发起方发起请求编号重复");
            throw exceptionService.buildBusinessException("JY00060020021000400");
        }
    }

    @Override
    public void transaction(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        this.tradeNo = idFactorySinglePaymentRefundTradeNo.generate().toString();
        this.gmtCreated = new Date();
        // 1.创建生效收款损益退回台账
        createRefundReceivedLossLedger(tradeRquest);
        // 2.账务退回处理
        handlerRealAcount(tradeRquest);
        // 3.创建生效其他损益退回台账
        createRefundOtherLossLedger(tradeRquest);
        // 4.创建空白付款外部退回台账
        createPayAccountOutBlankLegder(tradeRquest);
        // 5.修改原支付交易记录
        updateTradeSinglePayment(tradeRquest);
        // 6.创建退款扣款成功交易记录
        createTradeSinglePaymentRefundSuccess(tradeRquest);
    }

    private void createTradeSinglePaymentRefundSuccess(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) {
        TradePacketReqBodyOuterRefund body = tradeRquest.getBody();
        TradeSinglePaymentRefund refund = new TradeSinglePaymentRefund();
        try {
            // 合作商户编号
            refund.setPartnerId(tradeRquest.getHead().getPartner_id());
            // 交易编号 系统自动产生
            refund.setTradeNo(this.tradeNo);
            // 核心商户编号 来自输入
            refund.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());
            // 资金池编号 来自输入
            refund.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());
            // 原交易编号 来自输入
            refund.setOriginalTradeNo(body.getOriginal_trade_no());
            // 交易客户保留字段1~10 来自输入
            refund.setMerchantExtendField1(body.getMerchant_extend_field_1());
            refund.setMerchantExtendField2(body.getMerchant_extend_field_2());
            refund.setMerchantExtendField3(body.getMerchant_extend_field_3());
            refund.setMerchantExtendField4(body.getMerchant_extend_field_4());
            refund.setMerchantExtendField5(body.getMerchant_extend_field_5());
            refund.setMerchantExtendField6(body.getMerchant_extend_field_6());
            refund.setMerchantExtendField7(body.getMerchant_extend_field_7());
            refund.setMerchantExtendField8(body.getMerchant_extend_field_8());
            refund.setMerchantExtendField9(body.getMerchant_extend_field_9());
            refund.setMerchantExtendField10(body.getMerchant_extend_field_10());
            // 交易发起方发起请求编号 来自输入
            refund.setOutTradeNoExt(body.getOut_trade_no_ext());
            // 交易发起方业务系统订单号 来自输入
            refund.setOutTradeNo(body.getOut_trade_no());
            // 交易创建日期时间 系统时间
            refund.setGmtCreated(gmtCreated);
            // 最后变更日期时间 系统时间
            refund.setGmtModifiedLatest(gmtCreated);
            // 最后变更交易请求类型 本次请求类型
            refund.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());
            // 最后变更交易请求编号 来自交易请求记录
            refund.setLatestReqNo(this.reqNo);
            // 交易结束状态 【未结束】
            refund.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);
            // 交易状态 【退款扣帐成功】
            refund.setStatus(TradeConstants.TRADE_PAYMENT_REFUND_DEBIT_SUCCESS);
            // 交易组别 2【外部支付退款】
            refund.setTradeCatatory(TradeConstants.TRADE_PAYMENT_REFUND_OUTER);
            // 交易版本 0
            refund.setVersion(0);

            // 退款扣帐日期时间 系统时间
            refund.setGmtRefundDeduct(gmtCreated);

            if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType)) {// 第三方充付
                // 付款方退回收到退回金额
                refund.setRefundPayAmt(str2Long(body.getRefund_pay_account_in_accounting_amt()));
                // 付款方退回收到方式
                refund.setRefundPayType(TradeConstants.TRADE_REFUND_PAY_THIRD_ACCOUNT);
            } else if (TradeConstants.PAY_BY_THIRD.equals(oiginalTradePayType)) {// 第三方直付
                // 付款方退回收到退回金额
                refund.setRefundPayAmt(str2Long(body.getExternal_refund_amt()));
                // 付款方退回收到方式
                refund.setRefundPayType(TradeConstants.TRADE_REFUND_PAY_THIRD);
            }
            // 付款方外部退回业务台账编号 来自台账
            refund.setExternalRefundLedgerNo(this.ledgerNo);
            // 付款方外部退回收付款渠道编号 来自输入
            refund.setExternalRefundChannel(body.getExternal_refund_channel());
            // 付款方外部退回收付款属性1（付出手续费金额） 来自输入
            refund.setExternalRefundChannelPayFeeAmt(str2Long(body.getExternal_refund_pay_channel_fee_amt()));
            // 付款方外部退回收付款属性2（退回手续费金额） 来自输入
            refund.setExternalRefundChannelFeeAmt(str2Long(body.getExternal_refund_channel_fee_amt()));
            // 付款方外部退回付出金额 来自输入
            refund.setExternalRefundAmt(str2Long(body.getExternal_refund_amt()));
            // 付款方外部退回收付款备注4【提交第三方批次号】 来自输入
            refund.setExternalRefundChannelBatchNo(body.getExternal_refund_channel_batch_no());
            // 付款方外部退回收付款备注5【提交第三方请求流水号】 来自输入
            refund.setExternalRefundChannelSerialNo(body.getExternal_refund_channel_serial_no());
            // 判断第三方冲付的情况
            if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType)) {
                // 付款方账户退回账户编号 来自原交易【付款方账户账户编号】
                refund.setRefundPayAccountNo(tradeSinglePayment.getPayAccountNo());
                // 付款方账户退回所属商户编号 来自原交易【付款方账户所属商户编号】
                refund.setRefundPayAccountMerchantNo(tradeSinglePayment.getPayAccountMerchantNo());
                // 付款方账户退回入账金额 来自输入【付款方账户退回入账金额】
                refund.setRefundPayAccountInAccountingAmt(str2Long(body.getRefund_pay_account_in_accounting_amt()));
                // 付款方账户退回出账子账户类型 【可用】
                refund.setRefundPayAccountOutAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);
                // 付款方账户退回出账账务历史1~3 来自输入
                refund.setRefundPayAccountOutAccountingHis1(body.getRefund_pay_account_out_accounting_his1());
                refund.setRefundPayAccountOutAccountingHis2(body.getRefund_pay_account_out_accounting_his2());
                refund.setRefundPayAccountOutAccountingHis3(body.getRefund_pay_account_out_accounting_his3());
                // 付款方账户退回入账子账户类型 【可用】
                refund.setRefundPayAccountInAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);
                // 付款方账户退回入账账务历史1~3 来自输入
                refund.setRefundPayAccountInAccountingHis1(body.getRefund_pay_account_in_accounting_his1());
                refund.setRefundPayAccountInAccountingHis2(body.getRefund_pay_account_in_accounting_his2());
                refund.setRefundPayAccountInAccountingHis3(body.getRefund_pay_account_in_accounting_his3());
            }

            // 付款方手续费账户退回账户编号 来自原交易【付款方手续费账户账户编号】
            refund.setRefundPayFeeAccountNo(tradeSinglePayment.getPayFeeAccountNo());
            // 付款方手续费账户退回所属商户编号 来自原交易【付款方手续费账户所属商户编号】
            refund.setRefundPayFeeAccountMerchantNo(tradeSinglePayment.getPayFeeAccountMerchantNo());
            // 付款方手续费账户退回入账金额 来自输入【付款方账户手续费退回入账金额】
            refund.setRefundPayFeeAccountInAccountingAmt(str2Long(body.getRefund_pay_fee_account_in_accounting_amt()));
            // 付款方手续费账户退回入账子账户类型 【可用】
            refund.setRefundPayFeeAccountInAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);
            // 付款方手续费账户退回入账账务历史1~3 来自输入
            refund.setRefundPayFeeAccountInAccountingHis1(body.getRefund_pay_fee_account_in_accounting_his1());
            refund.setRefundPayFeeAccountInAccountingHis2(body.getRefund_pay_fee_account_in_accounting_his2());
            refund.setRefundPayFeeAccountInAccountingHis3(body.getRefund_pay_fee_account_in_accounting_his3());

            // 收款方退回付出金额 来自输入
            refund.setRefundReceiveAmt(str2Long(body.getRefund_receive_amt()));
            // 收款方退回付出方式
            refund.setRefundReceiveType(tradeSinglePayment.getReceiveType());

            if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeSinglePayment.getReceiveType())) {
                // 收款方损益退回业务台账编号 来自台账
                refund.setRefundReceiveProfitLossLedgerNo(this.refundReceivedLossLedgerNo);
                // 收款方损益退回付款金额 来自台账
                refund.setRefundReceiveProfitLossAmt(str2Long(body.getRefund_receive_amt()));
            }
            if (TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeSinglePayment.getReceiveType())) {
                // 收款方账户退回账户编号 来自原交易【收款方账户账户编号】
                refund.setRefundReceiveAccountNo(tradeSinglePayment.getReceiveAccountNo());
                // 收款方账户退回所属商户编号 来自原交易【收款方账户所属商户编号】
                refund.setRefundReceiveAccountMerchantNo(tradeSinglePayment.getReceiveAccountMerchantNo());
                // 收款方账户退回出账金额 来自输入【收款方退回付出金额】
                refund.setRefundReceiveAccountOutAccountingAmt(str2Long(body.getRefund_receive_amt()));
                // 收款方账户退回出账账务历史1 来自输入
                refund.setRefundReceiveAccountOutAccountingHis1(body.getRefund_receive_account_out_accounting_his1());
                // 收款方账户退回出账账务历史2 来自输入
                refund.setRefundReceiveAccountOutAccountingHis2(body.getRefund_receive_account_out_accounting_his2());
                // 收款方账户退回出账账务历史3 来自输入
                refund.setRefundReceiveAccountOutAccountingHis3(body.getRefund_receive_account_out_accounting_his3());
            }
            // 收款方手续费账户退回账户编号 来自原交易【收款方手续费账户账户编号】
            refund.setRefundReceiveFeeAccountNo(tradeSinglePayment.getReceiveFeeAccountNo());
            // 收款方手续费账户退回所属商户编号 来自原交易【收款方手续费账户所属商户编号】
            refund.setRefundReceiveFeeAccountMerchantNo(tradeSinglePayment.getReceiveFeeAccountMerchantNo());
            // 收款方手续费账户退回入账金额 来自输入
            refund.setRefundReceiveFeeAccountInAccountingAmt(str2Long(body.getRefund_receive_fee_account_in_accounting_amt()));
            // 收款方手续费账户退回入账子账户类型 来自原交易【收款方手续费账户出账子账户类型】
            refund.setRefundReceiveFeeAccountInAccountingType(tradeSinglePayment.getReceiveFeeAccountOutAccountingType());
            // 收款方手续费账户退回入账账务历史1 来自输入
            refund.setRefundReceiveFeeAccountInAccountingHis1(body.getRefund_receive_fee_account_in_accounting_his1());
            // 收款方手续费账户退回入账账务历史2 来自输入
            refund.setRefundReceiveFeeAccountInAccountingHis2(body.getRefund_receive_fee_account_in_accounting_his2());
            // 收款方手续费账户退回入账账务历史3 来自输入
            refund.setRefundReceiveFeeAccountInAccountingHis3(body.getRefund_receive_fee_account_in_accounting_his3());

            // 其他损益台账部分
            refund.setRefundExtendProfitLoss(refundExtendProfitLoss);
            // 付出方冻结余额 0
            refund.setPayFreezeBal(0l);
            // 收到方冻结余额 0
            refund.setReceiveFreezeBal(0l);

            singlePaymentRefund = singlePaymentRefundService.createOuterTradeForRefundOfSuccess(refund);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->创建退款扣款成功交易记录失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060020021001000");
        }
    }

    /**
     * @param tradeRquest
     * @throws Exception
     * @Title:updateTradeSinglePayment
     * @Description:修改原支付交易记录
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月7日 下午4:12:30
     */
    private void updateTradeSinglePayment(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        try {
            // 最后变更日期时间 系统时间
            tradeSinglePayment.setGmtModifiedLatest(this.gmtCreated);
            // 最后变更交易请求类型 本次请求类型
            tradeSinglePayment.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());
            // 最后变更交易请求编号 来自本次交易请求记录
            tradeSinglePayment.setLatestReqNo(this.reqNo);
            // 收到方冻结余额 执行STEP5中收款方账户实际冻结余额变化
            tradeSinglePayment.setReceiveFreezeBal(calculateReceiveFreezeBal(tradeRquest));
            // 累计收款方退款金额 原值+输入【收款方退回付出金额】
            long sumRefundedReceiveAccountAmt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedReceiveAccountAmt()) + str2long(tradeRquest.getBody().getRefund_receive_amt());
            tradeSinglePayment.setSumRefundedReceiveAccountAmt(sumRefundedReceiveAccountAmt);
            // 累计付款方账户手续费退回金额 原值+输入【收款方手续费账户退回入账金额】
            long sumRefundedPayFeeAccountAmt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedPayFeeAccountAmt()) + str2long(tradeRquest.getBody().getRefund_pay_fee_account_in_accounting_amt());
            tradeSinglePayment.setSumRefundedPayFeeAccountAmt(sumRefundedPayFeeAccountAmt);
            // 累计收款方账户手续费退回金额 原值+输入【付款方手续费账户退回入账金额】
            long sumRefundedReceiveFeeAccountAmt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedReceiveFeeAccountAmt()) + str2long(tradeRquest.getBody().getRefund_receive_fee_account_in_accounting_amt());
            tradeSinglePayment.setSumRefundedReceiveFeeAccountAmt(sumRefundedReceiveFeeAccountAmt);
            // 累计付款方账户出账退回金额 输入原交易【付款方付出方式】为【第三方充付】时：原值+输入【付款方账户退回入账金额】
            if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType)) {
                long sumRefundedPayAccountOutAccountingAmt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedPayAccountOutAccountingAmt()) + str2long(tradeRquest.getBody().getRefund_pay_account_in_accounting_amt());
                tradeSinglePayment.setSumRefundedPayAccountOutAccountingAmt(sumRefundedPayAccountOutAccountingAmt);
            }
            // 累计付款方台账退回金额 输入原交易【付款方付出方式】为【第三方直付】、【第三方充付】时：原值+输入【付款方外部退回付出金额】
            if (TradeConstants.PAY_BY_THIRD.equals(oiginalTradePayType) || TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType)) {
                long sumRefundedPayLedgerAmt = AmountUtils.ifNullOrElse(tradeSinglePayment.getSumRefundedPayLedgerAmt()) + str2long(tradeRquest.getBody().getExternal_refund_amt());
                tradeSinglePayment.setSumRefundedPayLedgerAmt(sumRefundedPayLedgerAmt);
            }
            tradeSinglePayment = singlePaymentService.updateTrade(tradeSinglePayment);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->修改原支付交易记录出错:" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060020021001300");// 外部支付退款扣帐交易记录创建失败
        }
    }

    /**
     * @param tradeRquest
     * @return
     * @throws Exception
     * @Title:calculateReceiveFreezeBal
     * @Description:计算收款方账户实际冻结余额变化
     * @return:long
     * @author:zoran.huang
     * @date:2016年6月8日 上午10:12:50
     */
    private long calculateReceiveFreezeBal(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        long lastReceiveFreezeBal = 0l;
        // 收款方退回付出金额
        long refundReceiveAmt = str2long(tradeRquest.getBody().getRefund_receive_amt());
        // 收款方手续费账户退回入账金额
        long refundReceivefeeAmt = 0l;
        // 原交易中当前【收到方冻结余额】
        long receiveFreezeBal = AmountUtils.ifNullOrElse(tradeSinglePayment.getReceiveFreezeBal());
        // 如果原交易收款方手续出账类型为 ：冻结账户类型
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeSinglePayment.getReceiveFeeAccountOutAccountingType())) {
            refundReceivefeeAmt = str2long(tradeRquest.getBody().getRefund_receive_fee_account_in_accounting_amt());
        }
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeSinglePayment.getReceiveAccountInAccountingType())) {
            // 若【收款方退回付出金额】=<原交易中当前【收到方冻结余额】+冻结退回的【收款方手续费账户退回入账金额】
            if (refundReceiveAmt <= (receiveFreezeBal + refundReceivefeeAmt)) {
                lastReceiveFreezeBal = (receiveFreezeBal + refundReceivefeeAmt) - refundReceiveAmt;
            } else if (refundReceiveAmt > (receiveFreezeBal + refundReceivefeeAmt)) {
                lastReceiveFreezeBal = 0l;
            }
        } else if (TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE.equals(tradeSinglePayment.getReceiveAccountInAccountingType())) {
            lastReceiveFreezeBal = (receiveFreezeBal + refundReceivefeeAmt);
        }
        return lastReceiveFreezeBal;
    }

    /**
     * @param tradeRquest
     * @Title:createPayAccountOutBlankLegder
     * @Description:创建空白付款外部退回台账
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月7日 下午3:33:23
     */
    private void createPayAccountOutBlankLegder(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) {
        TradePacketReqBodyOuterRefund body = tradeRquest.getBody();
        TradeLedger ledger = new TradeLedger();
        try {
            // 付款方外部退回核心商户编号 来自输入
            ledger.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());
            // 付款方外部退回资金池编号 来自输入
            ledger.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());
            // 付款方外部退回业务台账客户保留字段1 来自输入
            ledger.setMerchantExtendField1(body.getExternal_refund_merchant_extend_field_1());
            // 付款方外部退回业务台账客户保留字段2 来自输入
            ledger.setMerchantExtendField2(body.getExternal_refund_merchant_extend_field_2());
            // 付款方外部退回业务台账客户保留字段3 来自输入
            ledger.setMerchantExtendField3(body.getExternal_refund_merchant_extend_field_3());
            // 付款方外部退回所属业务交易类型 本次交易类型
            ledger.setTradeType(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 所属业务交易类型（例：0003_001）
            // 付款方外部退回所属业务交易编号 来自交易
            ledger.setTradeNo(this.tradeNo); // 交易编号
            // 付款方外部退回所属业务交易创建日期 来自交易
            ledger.setGmtTradeCreated(this.gmtCreated); // 所属业务交易创建日期
            // 付款方外部退回创建交易请求类型 本次交易请求类型
            ledger.setCreateReqType(tradeRquest.getHead().getRequest_code());
            // 付款方外部退回创建交易请求编号 来自交易
            ledger.setCreateReqNo(this.reqNo);
            // 付款方外部退回交易发起方业务系统订单号 来自输入
            ledger.setOutTradeNoExt(body.getOut_trade_no_ext()); // 交易发起方发起请求编号
            ledger.setOutTradeNo(body.getOut_trade_no());
            
            // 付款方外部退回收付款渠道编号 来自输入
            ledger.setClearChannel(body.getExternal_refund_channel());
            // 付款方外部退回收付款属性1（付出手续费金额） 来自输入
            ledger.setClearChannelAttr1(AmountUtils.long2Str(str2Long(body.getExternal_refund_pay_channel_fee_amt())));
            // 付款方外部退回收付款属性2（退回手续费金额） 来自输入
            ledger.setClearChannelAttr2(AmountUtils.long2Str(str2Long(body.getExternal_refund_channel_fee_amt())));
            // 付款方外部退回收付款属性3 来自输入
            ledger.setClearChannelAttr3(body.getExternal_refund_channel_attr_3());
            // 付款方外部退回收付款属性4 来自输入
            ledger.setClearChannelAttr4(body.getExternal_refund_channel_attr_4());
            // 付款方外部退回收付款属性5 来自输入
            ledger.setClearChannelAttr5(body.getExternal_refund_channel_attr_5());
            // 付款方外部退回收付款属性6 来自输入
            ledger.setClearChannelAttr6(body.getExternal_refund_channel_attr_6());
            // 付款方外部退回收付款备注1【出款渠道身份编号】 来自输入
            ledger.setExtendField1(body.getExternal_refund_channel_transaction_id());
            // 付款方外部退回收付款备注2【付款方账户】 来自输入
            ledger.setExtendField2(body.getExternal_refund_channel_pay_account_no());
            // 付款方外部退回收付款备注3【付款方账户名称】 来自输入
            ledger.setExtendField3(body.getExternal_refund_channel_pay_account_name());
            // 付款方外部退回收付款备注4【提交第三方批次号】 来自输入
            ledger.setExtendField4(body.getExternal_refund_channel_batch_no());
            // 付款方外部退回收付款备注5【提交第三方请求流水号】 来自输入
            ledger.setExtendField5(body.getExternal_refund_channel_serial_no());
            // 付款方外部退回收付款备注6【收款方账户】 来自输入
            ledger.setExtendField6(body.getExternal_refund_channel_receive_account_no());
            // 付款方外部退回收付款备注7【收款方账户名称】 来自输入
            ledger.setExtendField7(body.getExternal_refund_channel_recieve_account_name());
            // 付款方外部退回收付款备注8 来自输入
            ledger.setExtendField8(body.getExternal_refund_channel_field_8());
            // 付款方外部退回收付款备注9 来自输入
            ledger.setExtendField9(body.getExternal_refund_channel_field_9());
            // 付款方外部退回收付款备注10 来自输入
            ledger.setExtendField10(body.getExternal_refund_channel_field_10());
            // 付款方外部退回收付款备注11【清算日期】 来自输入
            ledger.setExtendField11(body.getGmt_external_refund_channel_clear());
            // 付款方外部退回收付款备注12【出入账日期】 来自输入
            ledger.setExtendField12(body.getGmt_external_refund_accouting());
            // 付款方外部退回收付款备注13 来自输入
            ledger.setExtendField13(body.getExternal_refund_channel_field_13());
            // 付款方外部退回收付款备注14 来自输入
            ledger.setExtendField14(body.getExternal_refund_channel_field_14());
            // 付款方外部退回收付款备注15 来自输入
            ledger.setExtendField15(body.getExternal_refund_channel_field_15());
            // 付款方外部退回付款金额 来自输入
            ledger.setPaymentAmount(str2Long(body.getExternal_refund_amt()));
            this.ledgerNo = legderService.createBlankLegder(ledger);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("创建空白付款外部退回台账失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("TZ000100301");
        }
    }

    /**
     * @param tradeRquest
     * @Title:createRefundOtherLossLedger
     * @Description:创建生效其他损益退回台账
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月7日 下午2:46:37
     */
    private void createRefundOtherLossLedger(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        List<TradePacketReqBodyOtherPofitLossLedger> otherLossLedgerList = tradeRquest.getBody().getProfit_loss_list();
        List<OtherPofitLossLedgerForRefund> otherLossLedgerListForRefund = new ArrayList<OtherPofitLossLedgerForRefund>();
        if (otherLossLedgerList != null) {
            for (TradePacketReqBodyOtherPofitLossLedger otherPofitLossLedger : otherLossLedgerList) {
                TradeProfitLossLedger ledger = new TradeProfitLossLedger();
                // 收款方损益业务台账编号 receive_profit_loss_ledger_no
                try {
                    // 其他损益台账List退回核心商户编号
                    ledger.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());
                    // 其他损益台账List退回资金池编号 来自输入
                    ledger.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());
                    // 其他损益台账List退回业务台账客户保留字段1 来自输入
                    ledger.setMerchantExtendField1(otherPofitLossLedger.getMerchant_extend_field_1());
                    // 其他损益台账List退回业务台账客户保留字段2 来自输入
                    ledger.setMerchantExtendField2(otherPofitLossLedger.getMerchant_extend_field_2());
                    // 其他损益台账List退回业务台账客户保留字段3 来自输入
                    ledger.setMerchantExtendField3(otherPofitLossLedger.getMerchant_extend_field_3());
                    // 其他损益台账List退回交易发起方发起请求编号
                    ledger.setOutTradeNoExt(tradeRquest.getBody().getOut_trade_no_ext());
                    // 其他损益台账List退回所属业务交易类型 来自交易
                    ledger.setTradeType(TradeUtilCommon.getTradeType(TradeConstants.TRADE_OUTER_PR_DEBIT));
                    // 其他损益台账List退回所属业务交易编号 来自交易
                    ledger.setTradeNo(this.tradeNo);
                    // 其他损益台账List退回所属业务交易创建日期 来自交易
                    ledger.setGmtTradeCreated(this.gmtCreated);
                    // 其他损益台账List退回创建交易请求类型 来自交易
                    ledger.setCreateReqType(TradeConstants.TRADE_OUTER_PR_DEBIT);
                    // 其他损益台账List退回创建交易请求编号 来自交易
                    ledger.setCreateReqNo(this.reqNo);
                    // 其他损益台账List退回生效交易请求类型 来自交易
                    ledger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PR_DEBIT);
                    // 其他损益台账List退回生效交易请求编号 来自交易
                    ledger.setEffectiveReqNo(this.reqNo);
                    // 其他损益台账List退回交易发起方发起请求编号 来自输入
                    ledger.setOutTradeNoExt(tradeRquest.getBody().getOut_trade_no_ext());
                    // 其他损益台账List退回交易发起方业务系统订单号 来自输入
                    ledger.setOutTradeNo(tradeRquest.getBody().getOut_trade_no());
                    // 其他损益台账List退回损益属性1 来自输入
                    ledger.setProfitLossAttr1(otherPofitLossLedger.getProfit_loss_attr_1());
                    // 其他损益台账List退回损益属性2 来自输入
                    ledger.setProfitLossAttr2(otherPofitLossLedger.getProfit_loss_attr_2());
                    // 其他损益台账List退回损益属性3 来自输入
                    ledger.setProfitLossAttr3(otherPofitLossLedger.getProfit_loss_attr_3());
                    // 其他损益台账List退回损益属性4 来自输入
                    ledger.setProfitLossAttr4(otherPofitLossLedger.getProfit_loss_attr_4());
                    // 其他损益台账List退回损益属性5 来自输入
                    ledger.setProfitLossAttr5(otherPofitLossLedger.getProfit_loss_attr_5());
                    // 其他损益台账List退回损益属性6 来自输入
                    ledger.setProfitLossAttr6(otherPofitLossLedger.getProfit_loss_attr_6());
                    // 其他损益台账List退回损益属性7 来自输入
                    ledger.setProfitLossAttr7(otherPofitLossLedger.getProfit_loss_attr_7());
                    // 其他损益台账List退回损益属性8 来自输入
                    ledger.setProfitLossAttr8(otherPofitLossLedger.getProfit_loss_attr_8());
                    // 其他损益台账List退回损益属性9 来自输入
                    ledger.setProfitLossAttr9(otherPofitLossLedger.getProfit_loss_attr_9());
                    // 其他损益台账List退回损益属性10 来自输入
                    ledger.setProfitLossAttr10(otherPofitLossLedger.getProfit_loss_attr_10());
                    // 其他损益台账List退回收入增加金额 来自输入
                    ledger.setIncomeIncr(str2Long(otherPofitLossLedger.getIncome_incr()));
                    // 其他损益台账List退回收入减少金额 来自输入
                    ledger.setIncomeDecr(str2Long(otherPofitLossLedger.getIncome_decr()));
                    // 其他损益台账List退回成本费用增加金额 来自输入
                    ledger.setCostIncr(str2Long(otherPofitLossLedger.getCost_incr()));
                    // 其他损益台账List退回成本费用减少金额 来自输入
                    ledger.setCostDecr(str2Long(otherPofitLossLedger.getCost_decr()));
                    String otherLossledgerNo = profitLossLedgerService.createEffectiveProfitLossLedger(ledger);
                    OtherPofitLossLedgerForRefund otherPofitLossLedgerForRefund = new OtherPofitLossLedgerForRefund();
                    otherPofitLossLedgerForRefund.setLedger_no(otherLossledgerNo);
                    otherPofitLossLedgerForRefund.setIncome_incr(AmountUtils.long2Str(ledger.getIncomeIncr()));
                    otherPofitLossLedgerForRefund.setIncome_decr(AmountUtils.long2Str(ledger.getIncomeDecr()));
                    otherPofitLossLedgerForRefund.setCost_incr(AmountUtils.long2Str(ledger.getCostIncr()));
                    otherPofitLossLedgerForRefund.setCost_decr(AmountUtils.long2Str(ledger.getCostDecr()));
                    otherLossLedgerListForRefund.add(otherPofitLossLedgerForRefund);
                } catch (Exception e) {
                    e.printStackTrace();
                    refundExtendProfitLoss = null;
                    logger.error("-->创建生效其他损益退回台账失败：" + e.getMessage(), e);
                    throw exceptionService.buildBusinessException("TZ000200101");
                }
            }
            try {
                refundExtendProfitLoss = otherLossLedgerList2JosnStr(otherLossLedgerListForRefund);
            } catch (Exception e) {
                logger.error("-->其他损益台账转换失败：" + e.getMessage(), e);
                throw exceptionService.buildBusinessException("TZ000200101");
            }

        }
    }

    /**
     * @param tradeRquest
     * @Title:handlerRealAcount
     * @Description:账务退回处理
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月6日 下午5:33:33
     */
    private void handlerRealAcount(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        List<RealTimeAccountingVo> requestList = new ArrayList<RealTimeAccountingVo>();
        // 1.原收款方手续费账户退回,
        RealTimeAccountingVo receiveFeeAccountVo = receiveFeeAccountRefund(tradeRquest);
        if (receiveFeeAccountVo != null) {
            requestList.add(receiveFeeAccountVo);
        }
        // 2.原收款方账户退回
        List<RealTimeAccountingVo> receiveAccountRefundList = receiveAccountRefund(tradeRquest);
        if (receiveAccountRefundList != null) {
            requestList.addAll(receiveAccountRefundList);
        }
        // 3.原付款方手续费账户退回
        RealTimeAccountingVo payFeeAccountVo = payFeeAccountRefund(tradeRquest);
        if (payFeeAccountVo != null) {
            requestList.add(payFeeAccountVo);
        }
        // 4.原付款方账户入账
        RealTimeAccountingVo payAccountInnerVo = payAccountRefundInAccounting(tradeRquest);
        if (payAccountInnerVo != null) {
            requestList.add(payAccountInnerVo);
        }
        // 5.原付款方账户充退出账
        RealTimeAccountingVo payAccountOuterVo = payAccountRefundOutAccounting(tradeRquest);
        if (payAccountOuterVo != null) {
            requestList.add(payAccountOuterVo);
        }
        try {
            @SuppressWarnings("unchecked")
            List<RealTimeAccountingRsp> list = this.bizAccountService.senderRequestToAccount(requestList);
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
     * @param tradeRquest
     * @return
     * @throws Exception
     * @Title:payAccountRefundOutAccounting
     * @Description:原付款方账户充退出账
     * @return:RealTimeAccountingVo
     * @author:zoran.huang
     * @date:2016年6月7日 下午2:16:58
     */
    private RealTimeAccountingVo payAccountRefundOutAccounting(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        // 付款方外部退回付款金额
        long payAccountOutAccountingAmt = str2long(tradeRquest.getBody().getExternal_refund_amt());
        // 付款方退回收到退回方式为【第三方充退】时执行
        if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType) && payAccountOutAccountingAmt > 0) {
            RealTimeAccountVO accountVo = new RealTimeAccountVO();
            // 目标账户编号 来自原交易【付款方账户账户编号】
            accountVo.setAccountNo(tradeSinglePayment.getPayAccountNo());
            // 核心商户编号 来自原交易【核心商户编号】
            accountVo.setCoreMerchantNo(tradeSinglePayment.getCoreMerchantNo());
            // 资金池编号 来自原交易【资金池编号】
            accountVo.setPoolNo(tradeSinglePayment.getFundPoolNo());
            // 用户账务历史保留字段1 来自输入【付款方退回账户出账账务历史1】
            accountVo.setReservedFields1(tradeRquest.getBody().getRefund_pay_account_out_accounting_his1());
            // 用户账务历史保留字段2 来自输入【付款方退回账户出账账务历史2】
            accountVo.setReservedFields2(tradeRquest.getBody().getRefund_pay_account_out_accounting_his2());
            // 用户账务历史保留字段3 来自输入【付款方退回账户出账账务历史3】
            accountVo.setReservedFields3(tradeRquest.getBody().getRefund_pay_account_out_accounting_his3());
            // 所属业务交易类型 本交易类型
            accountVo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0006_002
            // 所属业务交易编号 本交易编号
            accountVo.setTradeNo(this.tradeNo);
            // 所属业务交易创建日期 本交易创建日期
            accountVo.setTradeGmtCreated(this.gmtCreated);
            // 所属业务交易请求类型 本交易请求类型
            accountVo.setTradeReqCode(TradeConstants.TRADE_OUTER_PR_DEBIT); // 交易请求类型0006_002_002
            // 所属业务交易请求编号 本交易请求编号
            accountVo.setTradeStepNo(this.reqNo);//
            // 所属业务业务系统订单号 本交易业务系统订单号
            accountVo.setSequenceNo(tradeRquest.getBody().getOut_trade_no()); // 本交易业务系统订单号
            accountVo.setAmount(payAccountOutAccountingAmt);
            // 可用余额减少金额
            return bizAccountService.avlBalDecrWrapper(accountVo);
        }
        return null;
    }

    /**
     * @param tradeRquest
     * @return
     * @throws Exception
     * @Title:payAccountRefundInAccounting
     * @Description:原付款方账户入账
     * @return:RealTimeAccountingVo
     * @author:zoran.huang
     * @date:2016年6月7日 下午2:01:05
     */
    private RealTimeAccountingVo payAccountRefundInAccounting(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        // 付款方账户退回入账金额 refund_pay_account_in_accounting_amt
        long payAccountInAccountingAmt = str2long(tradeRquest.getBody().getRefund_pay_account_in_accounting_amt());
        // 付款方退回收到退回方式为【第三方充退】时执行
        if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType) && payAccountInAccountingAmt > 0) {
            RealTimeAccountVO accountVo = new RealTimeAccountVO();
            // 目标账户编号 来自原交易【付款方账户账户编号】
            accountVo.setAccountNo(tradeSinglePayment.getPayAccountNo());
            // 核心商户编号 来自原交易【核心商户编号】
            accountVo.setCoreMerchantNo(tradeSinglePayment.getCoreMerchantNo());
            // 资金池编号 来自原交易【资金池编号】
            accountVo.setPoolNo(tradeSinglePayment.getFundPoolNo());
            // 用户账务历史保留字段1 来自输入【付款方退回账户入账账务历史1】
            accountVo.setReservedFields1(tradeRquest.getBody().getRefund_pay_account_in_accounting_his1());
            // 用户账务历史保留字段2 来自输入【付款方退回账户入账账务历史2】
            accountVo.setReservedFields2(tradeRquest.getBody().getRefund_pay_account_in_accounting_his2());
            // 用户账务历史保留字段3 来自输入【付款方退回账户入账账务历史3】
            accountVo.setReservedFields3(tradeRquest.getBody().getRefund_pay_account_in_accounting_his3());
            // 所属业务交易类型 本交易类型
            accountVo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0006_002
            // 所属业务交易编号 本交易编号
            accountVo.setTradeNo(this.tradeNo);
            // 所属业务交易创建日期 本交易创建日期
            accountVo.setTradeGmtCreated(this.gmtCreated);
            // 所属业务交易请求类型 本交易请求类型
            accountVo.setTradeReqCode(TradeConstants.TRADE_OUTER_PR_DEBIT); // 交易请求类型0006_002_002
            // 所属业务交易请求编号 本交易请求编号
            accountVo.setTradeStepNo(this.reqNo);//
            // 所属业务业务系统订单号 本交易业务系统订单号
            accountVo.setSequenceNo(tradeRquest.getBody().getOut_trade_no()); // 本交易业务系统订单号
            accountVo.setAmount(payAccountInAccountingAmt);
            // 可用余额增加金额
            return bizAccountService.avlBalIncrWrapper(accountVo);
        }
        return null;

    }

    /**
     * @param tradeRquest
     * @return
     * @throws Exception
     * @Title:payFeeAccountRefund
     * @Description: 原付款方手续费账户退回
     * @return:RealTimeAccountingVo
     * @author:zoran.huang
     * @date:2016年6月7日 下午1:48:55
     */
    private RealTimeAccountingVo payFeeAccountRefund(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        long refundPayFeeAmt = str2long(tradeRquest.getBody().getRefund_pay_fee_account_in_accounting_amt());
        if (refundPayFeeAmt > 0) {
            RealTimeAccountVO accountVo = new RealTimeAccountVO();
            // 目标账户编号 来自原交易【付款方手续费账户账户编号】
            accountVo.setAccountNo(tradeSinglePayment.getPayFeeAccountNo());
            // 核心商户编号 来自原交易【核心商户编号】
            accountVo.setCoreMerchantNo(tradeSinglePayment.getCoreMerchantNo());
            // 资金池编号 来自原交易【资金池编号】
            accountVo.setPoolNo(tradeSinglePayment.getFundPoolNo());
            // 用户账务历史保留字段1 来自输入【付款方手续费退回账户入账账务历史1】
            accountVo.setReservedFields1(tradeRquest.getBody().getRefund_pay_fee_account_in_accounting_his1());
            // 用户账务历史保留字段2 来自输入【付款方手续费退回账户入账账务历史2】
            accountVo.setReservedFields2(tradeRquest.getBody().getRefund_pay_fee_account_in_accounting_his2());
            // 用户账务历史保留字段3 来自输入【付款方手续费退回账户入账账务历史3】
            accountVo.setReservedFields3(tradeRquest.getBody().getRefund_pay_fee_account_in_accounting_his3());
            // 所属业务交易类型 本交易类型
            accountVo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0006_002
            // 所属业务交易编号 本交易编号
            accountVo.setTradeNo(this.tradeNo);
            // 所属业务交易创建日期 本交易创建日期
            accountVo.setTradeGmtCreated(this.gmtCreated);
            // 所属业务交易请求类型 本交易请求类型
            accountVo.setTradeReqCode(TradeConstants.TRADE_OUTER_PR_DEBIT); // 交易请求类型0006_002_002
            // 所属业务交易请求编号 本交易请求编号
            accountVo.setTradeStepNo(this.reqNo);//
            // 所属业务业务系统订单号 本交易业务系统订单号
            accountVo.setSequenceNo(tradeRquest.getBody().getOut_trade_no()); // 本交易业务系统订单号
            accountVo.setAmount(refundPayFeeAmt);
            // 可用余额增加金额
            return bizAccountService.avlBalIncrWrapper(accountVo);
        }
        return null;

    }

    /**
     * @param tradeRquest
     * @throws Exception
     * @Title:receiveAccountRefund
     * @Description:原收款方账户退回
     * @return:List<RealTimeAccountingVo>
     * @author:zoran.huang
     * @date:2016年6月7日 上午9:39:10
     */
    private List<RealTimeAccountingVo> receiveAccountRefund(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        List<RealTimeAccountingVo> accountingVoList = new ArrayList<RealTimeAccountingVo>();
        // 收款方退回付出金额
        long refundReceiveAmt = str2long(tradeRquest.getBody().getRefund_receive_amt());
        // 收款方手续费账户退回入账金额
        long refundReceivefeeAmt = 0l;
        // 原交易中当前【收到方冻结余额】
        long receiveFreezeBal = AmountUtils.ifNullOrElse(tradeSinglePayment.getReceiveFreezeBal());
        // 如果原交易收款方手续出账类型为 ：冻结账户类型
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeSinglePayment.getReceiveFeeAccountOutAccountingType())) {
            refundReceivefeeAmt = str2long(tradeRquest.getBody().getRefund_receive_fee_account_in_accounting_amt());
        }
        // 原交易【收款方收到方式】为【账户】且【收款方退回付出金额】不为0时处理。
        if (TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeSinglePayment.getReceiveType()) && refundReceiveAmt > 0) {
            // 若原交易【收款方账户入账子账户类型】为【冻结】，优先退回冻结金额，若冻结金额不足，可用余额补充
            if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeSinglePayment.getReceiveAccountInAccountingType())) {
                // 若【收款方退回付出金额】=<原交易中当前【收到方冻结余额】+冻结退回的【收款方手续费账户退回入账金额】
                if (refundReceiveAmt <= (receiveFreezeBal + refundReceivefeeAmt)) {
                    RealTimeAccountVO accountVo = initRealTimeAccountVO(tradeRquest, refundReceiveAmt);
                    // 所属业务冻结交易类型 来自原交易类型
                    accountVo.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradeSinglePayment.getLatestTradeReqType()));
                    // 所属业务冻结交易编号 来自原交易编号
                    accountVo.setFrozenTradeNo(tradeSinglePayment.getTradeNo());
                    // 调用 冻结余额减少金额
                    RealTimeAccountingVo accountingVo = bizAccountService.FrozenBalDecrAmtWrapper(accountVo);
                    accountingVoList.add(accountingVo);
                    return accountingVoList;
                } else if (refundReceiveAmt > (receiveFreezeBal + refundReceivefeeAmt)) {
                    if ((receiveFreezeBal + refundReceivefeeAmt) == 0) {// 原交易中当前【收到方冻结余额】+【收款方手续费账户退回入账金额】=0
                        RealTimeAccountVO accountVo = initRealTimeAccountVO(tradeRquest, refundReceiveAmt);
                        // 调用 可用余额减少金额
                        RealTimeAccountingVo accountingVo = bizAccountService.avlBalDecrWrapper(accountVo);
                        accountingVoList.add(accountingVo);
                        return accountingVoList;
                    } else {// 原交易中当前【收到方冻结余额】+【收款方手续费账户退回入账金额】!=0
                        // 1.先退冻结
                        RealTimeAccountVO accountFrozenVo = initRealTimeAccountVO(tradeRquest, receiveFreezeBal + refundReceivefeeAmt);
                        // 所属业务冻结交易类型 来自原交易类型
                        accountFrozenVo.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradeSinglePayment.getLatestTradeReqType()));
                        // 所属业务冻结交易编号 来自原交易编号
                        accountFrozenVo.setFrozenTradeNo(tradeSinglePayment.getTradeNo());
                        // 调用 冻结余额减少金额
                        RealTimeAccountingVo accountingFrozenVo = bizAccountService.FrozenBalDecrAmtWrapper(accountFrozenVo);
                        accountingVoList.add(accountingFrozenVo);
                        // 2.冻结不够可用补可用余额减少金额
                        RealTimeAccountVO accountVo = initRealTimeAccountVO(tradeRquest, refundReceiveAmt - (receiveFreezeBal + refundReceivefeeAmt));
                        // 调用 可用余额减少金额
                        RealTimeAccountingVo accountingVo = bizAccountService.avlBalDecrWrapper(accountVo);
                        accountingVoList.add(accountingVo);
                        return accountingVoList;
                    }
                }
            } else if (TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE.equals(tradeSinglePayment.getReceiveAccountInAccountingType())) {
                RealTimeAccountVO accountVo = initRealTimeAccountVO(tradeRquest, refundReceiveAmt);
                // 调用 可用余额减少金额
                RealTimeAccountingVo accountingVo = bizAccountService.avlBalDecrWrapper(accountVo);
                accountingVoList.add(accountingVo);
                return accountingVoList;
            }

        }
        return null;
    }

    private RealTimeAccountVO initRealTimeAccountVO(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest, long amt) {
        RealTimeAccountVO accountVo = new RealTimeAccountVO();
        // 目标账户编号 来自原交易【收款方账户账户编号】
        accountVo.setAccountNo(tradeSinglePayment.getReceiveAccountNo());
        // 用户账务历史保留字段1 来自输入【收款方账户退回出账账务历史1】
        accountVo.setReservedFields1(tradeRquest.getBody().getRefund_receive_account_out_accounting_his1());
        // 用户账务历史保留字段2 来自输入【收款方账户退回出账账务历史2】
        accountVo.setReservedFields2(tradeRquest.getBody().getRefund_receive_account_out_accounting_his2());
        // 用户账务历史保留字段3 来自输入【收款方账户退回出账账务历史3】
        accountVo.setReservedFields3(tradeRquest.getBody().getRefund_receive_account_out_accounting_his3());
        // 核心商户编号 来自原交易【核心商户编号】
        accountVo.setCoreMerchantNo(tradeSinglePayment.getCoreMerchantNo());
        // 资金池编号 来自原交易【资金池编号】
        accountVo.setPoolNo(tradeSinglePayment.getFundPoolNo());
        // 所属业务交易类型 本交易类型
        accountVo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0006_002
        // 所属业务交易编号 本交易编号
        accountVo.setTradeNo(this.tradeNo);
        // 所属业务交易创建日期 本交易创建日期
        accountVo.setTradeGmtCreated(this.gmtCreated);
        // 所属业务交易请求类型 本交易请求类型
        accountVo.setTradeReqCode(TradeConstants.TRADE_OUTER_PR_DEBIT); // 交易请求类型0006_002_002
        // 所属业务交易请求编号 本交易请求编号
        accountVo.setTradeStepNo(this.reqNo);//
        // 所属业务业务系统订单号 本交易业务系统订单号
        accountVo.setSequenceNo(tradeRquest.getBody().getOut_trade_no()); // 本交易业务系统订单号
        accountVo.setAmount(amt);
        return accountVo;
    }

    /**
     * @param tradeRquest
     * @throws Exception
     * @Title:payFeeAccountRefund
     * @Description: 原收款方手续费账户退回
     * @return:RealTimeAccountingVo
     * @author:zoran.huang
     * @date:2016年6月7日 上午9:30:58
     */
    private RealTimeAccountingVo receiveFeeAccountRefund(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        // 【收款方手续费账户退回入账金额】不为空时处理
        long refundReceivefeeAmt = str2long(tradeRquest.getBody().getRefund_receive_fee_account_in_accounting_amt());
        if (refundReceivefeeAmt > 0) {
            RealTimeAccountVO accountVo = new RealTimeAccountVO();
            // 目标账户编号 来自原交易【收款方手续费账户账户编号】
            accountVo.setAccountNo(tradeSinglePayment.getReceiveFeeAccountNo());
            // 核心商户编号 来自原交易【核心商户编号】
            accountVo.setCoreMerchantNo(tradeSinglePayment.getCoreMerchantNo());
            // 资金池编号 来自原交易【资金池编号】
            accountVo.setPoolNo(tradeSinglePayment.getFundPoolNo());
            // 用户账务历史保留字段1 来自输入【收款方手续费退回账户入账账务历史1】
            accountVo.setReservedFields1(tradeRquest.getBody().getRefund_receive_fee_account_in_accounting_his1());
            // 用户账务历史保留字段2 来自输入【收款方手续费退回账户入账账务历史2】
            accountVo.setReservedFields2(tradeRquest.getBody().getRefund_receive_fee_account_in_accounting_his2());
            // 用户账务历史保留字段3 来自输入【收款方手续费退回账户入账账务历史3】
            accountVo.setReservedFields3(tradeRquest.getBody().getRefund_receive_fee_account_in_accounting_his3());
            // 所属业务交易类型 本交易类型
            accountVo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0006_002
            // 所属业务交易编号 本交易编号
            accountVo.setTradeNo(this.tradeNo);
            // 所属业务交易创建日期 本交易创建日期
            accountVo.setTradeGmtCreated(this.gmtCreated);
            // 所属业务交易请求类型 本交易请求类型
            accountVo.setTradeReqCode(TradeConstants.TRADE_OUTER_PR_DEBIT); // 交易请求类型0006_002_002
            // 所属业务交易请求编号 本交易请求编号
            accountVo.setTradeStepNo(this.reqNo);//
            // 所属业务业务系统订单号 本交易业务系统订单号
            accountVo.setSequenceNo(tradeRquest.getBody().getOut_trade_no()); // 本交易业务系统订单号
            accountVo.setAmount(refundReceivefeeAmt);
            // 所属业务冻结交易类型 来自原交易类型
            // 所属业务冻结交易编号 来自原交易编号
            if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeSinglePayment.getReceiveFeeAccountOutAccountingType())) {
                // 冻结账户类型
                // 所属业务冻结交易类型 来自原交易类型
                accountVo.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradeSinglePayment.getLatestTradeReqType()));
                // 所属业务冻结交易编号 来自原交易编号
                accountVo.setFrozenTradeNo(tradeSinglePayment.getTradeNo());
                // 冻结余额增加金额
                return bizAccountService.FrozenBalIncrAmtWrapper(accountVo);
            } else if (TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE.equals(tradeSinglePayment.getReceiveFeeAccountOutAccountingType())) {
                // 可用账户 单边可用余额增加请求对象组织
                return bizAccountService.avlBalIncrWrapper(accountVo);
            }
        }
        return null;
    }

    /**
     * @param tradeRquest
     * @Title:createRefundReceivedLossLedger
     * @Description:创建生效收款损益退回台账
     * @return:void
     * @author:zoran.huang
     * @date:2016年6月6日 下午3:52:47
     */
    private void createRefundReceivedLossLedger(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        // 原交易为【收款方收到方式】为【损益】时创建
        if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeSinglePayment.getReceiveType())) {
            TradeProfitLossLedger ledger = new TradeProfitLossLedger();
            // 收款方损益业务台账编号 receive_profit_loss_ledger_no
            try {
                // 收款方损益退回核心商户编号 来自输入
                ledger.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());
                // 收款方损益退回资金池编号 来自输入
                ledger.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());
                // 收款方损益退回业务台账客户保留字段1 来自输入
                ledger.setMerchantExtendField1(tradeRquest.getBody().getRefund_receive_profit_loss_extend_field_1());
                // 收款方损益退回业务台账客户保留字段2 来自输入
                ledger.setMerchantExtendField2(tradeRquest.getBody().getRefund_receive_profit_loss_extend_field_2());
                // 收款方损益退回业务台账客户保留字段3 来自输入
                ledger.setMerchantExtendField3(tradeRquest.getBody().getRefund_receive_profit_loss_extend_field_3());
                // 收款方损益退回所属业务交易类型 来自交易
                ledger.setTradeType(TradeUtilCommon.getTradeType(TradeConstants.TRADE_OUTER_PR_DEBIT));
                // 收款方损益退回所属业务交易编号 来自交易
                ledger.setTradeNo(this.tradeNo);
                // 收款方损益退回所属业务交易创建日期 来自交易
                ledger.setGmtTradeCreated(this.gmtCreated);
                // 收款方损益退回创建交易请求类型 来自交易
                ledger.setCreateReqType(TradeConstants.TRADE_OUTER_PR_DEBIT);
                // 收款方损益退回创建交易请求编号 来自交易
                ledger.setCreateReqNo(this.reqNo);
                // 收款方损益退回生效交易请求类型 来自交易
                ledger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PR_DEBIT);
                // 收款方损益退回生效交易请求编号 来自交易
                ledger.setEffectiveReqNo(this.reqNo);
                // 收款方损益退回交易发起方发起请求编号 来自输入
                ledger.setOutTradeNoExt(tradeRquest.getBody().getOut_trade_no_ext());
                // 收款方损益退回交易发起方业务系统订单号 来自输入
                ledger.setOutTradeNo(tradeRquest.getBody().getOut_trade_no());

                TradeProfitLossLedger lossledger = profitLossLedgerService.queryByLedgerNoAndTradeNo(tradeSinglePayment.getReceiveProfitLossLedgerNo(), tradeSinglePayment.getTradeNo());
                if (lossledger == null) {
                    throw exceptionService.buildBusinessException("TZ000200101");
                }
                // 收款方损益退回损益属性1 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr1(lossledger.getProfitLossAttr1());
                // 收款方损益退回损益属性2 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr2(lossledger.getProfitLossAttr2());
                // 收款方损益退回损益属性3 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr3(lossledger.getProfitLossAttr3());
                // 收款方损益退回损益属性4 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr4(lossledger.getProfitLossAttr4());
                // 收款方损益退回损益属性5 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr5(lossledger.getProfitLossAttr5());
                // 收款方损益退回损益属性6 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr6(lossledger.getProfitLossAttr6());
                // 收款方损益退回损益属性7 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr7(lossledger.getProfitLossAttr7());
                // 收款方损益退回损益属性8 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr8(lossledger.getProfitLossAttr8());
                // 收款方损益退回损益属性9 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr9(lossledger.getProfitLossAttr9());
                // 收款方损益退回损益属性10 来自原交易【收款方损益台账】对应属性
                ledger.setProfitLossAttr10(lossledger.getProfitLossAttr10());

                if (tradeSinglePayment.getReceiveProfitLossIncomeIncr() != null && tradeSinglePayment.getReceiveProfitLossIncomeIncr() != 0) {
                    // 收款方损益退回收入减少金额 若原交易为【收款方损益台账】为【收入增加】时，来自输入【收款方退回付出金额】
                    ledger.setIncomeDecr(str2Long(tradeRquest.getBody().getRefund_receive_amt()));
                } else if (tradeSinglePayment.getReceiveProfitLossCostDecr() != null && tradeSinglePayment.getReceiveProfitLossCostDecr() != 0) {
                    // 收款方损益退回成本费用增加金额 若原交易为【收款方损益台账】为【成本费用减少】时，来自输入【收款方退回付出金额】
                    ledger.setCostIncr(str2Long(tradeRquest.getBody().getRefund_receive_amt()));
                }
                this.refundReceivedLossLedgerNo = profitLossLedgerService.createEffectiveProfitLossLedger(ledger);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("-->创建生效收款损益退回台账失败：" + e.getMessage(), e);
                throw exceptionService.buildBusinessException("TZ000200101");
            }
        }
    }

    @Override
    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    @Override
    public Object getTradeDetails() {
        TradeSinglePaymentRefundVo singlePaymentRefundVo = null;
        if (singlePaymentRefund != null) {
            singlePaymentRefundVo = new TradeSinglePaymentRefundVo();
            BeanUtils.copyProperties(singlePaymentRefund, singlePaymentRefundVo);
        }
        return singlePaymentRefundVo;
    }

    @Override
    public void tradeCreate(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
    }

    @Override
    public void tradeUpdateForFail(TradeRequest<TradePacketReqBodyOuterRefund> tradeRquest) throws Exception {
        TradePacketReqBodyOuterRefund body = tradeRquest.getBody();
        TradeSinglePaymentRefund refund = new TradeSinglePaymentRefund();
        try {
            // 合作商户编号
            refund.setPartnerId(tradeRquest.getHead().getPartner_id());
            // 交易编号 系统自动产生
            refund.setTradeNo(this.tradeNo);
            // 核心商户编号 来自输入
            refund.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());
            // 资金池编号 来自输入
            refund.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());
            // 原交易编号 来自输入
            refund.setOriginalTradeNo(body.getOriginal_trade_no());
            // 交易客户保留字段1~10 来自输入
            refund.setMerchantExtendField1(body.getMerchant_extend_field_1());
            refund.setMerchantExtendField2(body.getMerchant_extend_field_2());
            refund.setMerchantExtendField3(body.getMerchant_extend_field_3());
            refund.setMerchantExtendField4(body.getMerchant_extend_field_4());
            refund.setMerchantExtendField5(body.getMerchant_extend_field_5());
            refund.setMerchantExtendField6(body.getMerchant_extend_field_6());
            refund.setMerchantExtendField7(body.getMerchant_extend_field_7());
            refund.setMerchantExtendField8(body.getMerchant_extend_field_8());
            refund.setMerchantExtendField9(body.getMerchant_extend_field_9());
            refund.setMerchantExtendField10(body.getMerchant_extend_field_10());
            // 交易发起方发起请求编号 来自输入
            refund.setOutTradeNoExt(body.getOut_trade_no_ext());
            // 交易发起方业务系统订单号 来自输入
            refund.setOutTradeNo(body.getOut_trade_no());
            // 交易创建日期时间 系统时间
            refund.setGmtCreated(gmtCreated);
            // 最后变更日期时间 系统时间
            refund.setGmtModifiedLatest(gmtCreated);
            // 最后变更交易请求类型 本次请求类型
            refund.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());
            // 最后变更交易请求编号 来自交易请求记录
            refund.setLatestReqNo(this.reqNo);
            // 交易结束状态 【结束】
            refund.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
            // 交易状态 【退款失败】
            refund.setStatus(TradeConstants.TRADE_PAYMENT_REFUND_FAIL);
            // 交易组别 2【外部支付退款】
            refund.setTradeCatatory(TradeConstants.TRADE_PAYMENT_REFUND_OUTER);
            // 交易版本 0
            refund.setVersion(0);

            // 退款失败日期时间 系统时间
            refund.setGmtFailRefund(gmtCreated);

            if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType)) {// 第三方充付
                // 付款方退回收到退回金额
                refund.setRefundPayAmt(str2Long(body.getRefund_pay_account_in_accounting_amt()));
                // 付款方退回收到方式
                refund.setRefundPayType(TradeConstants.TRADE_REFUND_PAY_THIRD_ACCOUNT);
            } else if (TradeConstants.PAY_BY_THIRD.equals(oiginalTradePayType)) {// 第三方直付
                // 付款方退回收到退回金额
                refund.setRefundPayAmt(str2Long(body.getExternal_refund_amt()));
                // 付款方退回收到方式
                refund.setRefundPayType(TradeConstants.TRADE_REFUND_PAY_THIRD);
            }

            // 付款方外部退回收付款渠道编号 来自输入
            refund.setExternalRefundChannel(body.getExternal_refund_channel());
            // 付款方外部退回收付款属性1（付出手续费金额） 来自输入
            refund.setExternalRefundChannelPayFeeAmt(str2Long(body.getExternal_refund_pay_channel_fee_amt()));
            // 付款方外部退回收付款属性2（退回手续费金额） 来自输入
            refund.setExternalRefundChannelFeeAmt(str2Long(body.getExternal_refund_channel_fee_amt()));
            // 付款方外部退回付出金额 来自输入
            refund.setExternalRefundAmt(str2Long(body.getExternal_refund_amt()));
            // 付款方外部退回收付款备注4【提交第三方批次号】 来自输入
            refund.setExternalRefundChannelBatchNo(body.getExternal_refund_channel_batch_no());
            // 付款方外部退回收付款备注5【提交第三方请求流水号】 来自输入
            refund.setExternalRefundChannelSerialNo(body.getExternal_refund_channel_serial_no());

            // 要判断第三方冲付的情况
            if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(oiginalTradePayType)) {
                // 付款方账户退回账户编号 来自原交易【付款方账户账户编号】
                refund.setRefundPayAccountNo(tradeSinglePayment.getPayAccountNo());
                // 付款方账户退回所属商户编号 来自原交易【付款方账户所属商户编号】
                refund.setRefundPayAccountMerchantNo(tradeSinglePayment.getPayAccountMerchantNo());
                // 付款方账户退回入账金额 来自输入【付款方账户退回入账金额】
                refund.setRefundPayAccountInAccountingAmt(str2Long(body.getRefund_pay_account_in_accounting_amt()));
                // 付款方账户退回出账子账户类型 【可用】
                refund.setRefundPayAccountOutAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);
                // 付款方账户退回出账账务历史1~3 来自输入
                refund.setRefundPayAccountOutAccountingHis1(body.getRefund_pay_account_out_accounting_his1());
                refund.setRefundPayAccountOutAccountingHis2(body.getRefund_pay_account_out_accounting_his2());
                refund.setRefundPayAccountOutAccountingHis3(body.getRefund_pay_account_out_accounting_his3());
                // 付款方账户退回入账子账户类型 【可用】
                refund.setRefundPayAccountInAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);
                // 付款方账户退回入账账务历史1~3 来自输入
                refund.setRefundPayAccountInAccountingHis1(body.getRefund_pay_account_in_accounting_his1());
                refund.setRefundPayAccountInAccountingHis2(body.getRefund_pay_account_in_accounting_his2());
                refund.setRefundPayAccountInAccountingHis3(body.getRefund_pay_account_in_accounting_his3());
            }
            // 付款方手续费账户退回账户编号 来自原交易【付款方手续费账户账户编号】
            refund.setRefundPayFeeAccountNo(tradeSinglePayment.getPayFeeAccountNo());
            // 付款方手续费账户退回所属商户编号 来自原交易【付款方手续费账户所属商户编号】
            refund.setRefundPayFeeAccountMerchantNo(tradeSinglePayment.getPayFeeAccountMerchantNo());
            // 付款方手续费账户退回入账金额 来自输入【付款方账户手续费退回入账金额】
            refund.setRefundPayFeeAccountInAccountingAmt(str2Long(body.getRefund_pay_fee_account_in_accounting_amt()));
            // 付款方手续费账户退回入账子账户类型 【可用】
            refund.setRefundPayFeeAccountInAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);
            // 付款方手续费账户退回入账账务历史1~3 来自输入
            refund.setRefundPayFeeAccountInAccountingHis1(body.getRefund_pay_fee_account_in_accounting_his1());
            refund.setRefundPayFeeAccountInAccountingHis2(body.getRefund_pay_fee_account_in_accounting_his2());
            refund.setRefundPayFeeAccountInAccountingHis3(body.getRefund_pay_fee_account_in_accounting_his3());

            // 收款方退回付出金额 来自输入
            refund.setRefundReceiveAmt(str2Long(body.getRefund_receive_amt()));
            // 收款方退回付出方式
            refund.setRefundReceiveType(tradeSinglePayment.getReceiveType());

            if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeSinglePayment.getReceiveType())) {
                // 收款方损益退回业务台账编号 来自台账
                refund.setRefundReceiveProfitLossLedgerNo(this.refundReceivedLossLedgerNo);
                // 收款方损益退回付款金额 来自台账
                refund.setRefundReceiveProfitLossAmt(str2Long(body.getRefund_receive_amt()));
            }
            if (TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeSinglePayment.getReceiveType())) {
                // 收款方账户退回账户编号 来自原交易【收款方账户账户编号】
                refund.setRefundReceiveAccountNo(tradeSinglePayment.getReceiveAccountNo());
                // 收款方账户退回所属商户编号 来自原交易【收款方账户所属商户编号】
                refund.setRefundReceiveAccountMerchantNo(tradeSinglePayment.getReceiveAccountMerchantNo());
                // 收款方账户退回出账金额 来自输入【收款方退回付出金额】
                refund.setRefundReceiveAccountOutAccountingAmt(str2Long(body.getRefund_receive_amt()));
                // 收款方账户退回出账账务历史1 来自输入
                refund.setRefundReceiveAccountOutAccountingHis1(body.getRefund_receive_account_out_accounting_his1());
                // 收款方账户退回出账账务历史2 来自输入
                refund.setRefundReceiveAccountOutAccountingHis2(body.getRefund_receive_account_out_accounting_his2());
                // 收款方账户退回出账账务历史3 来自输入
                refund.setRefundReceiveAccountOutAccountingHis3(body.getRefund_receive_account_out_accounting_his3());
            }
            // 收款方手续费账户退回账户编号 来自原交易【收款方手续费账户账户编号】
            refund.setRefundReceiveFeeAccountNo(tradeSinglePayment.getReceiveFeeAccountNo());
            // 收款方手续费账户退回所属商户编号 来自原交易【收款方手续费账户所属商户编号】
            refund.setRefundReceiveFeeAccountMerchantNo(tradeSinglePayment.getReceiveFeeAccountMerchantNo());
            // 收款方手续费账户退回入账金额 来自输入
            refund.setRefundReceiveFeeAccountInAccountingAmt(str2Long(body.getRefund_receive_fee_account_in_accounting_amt()));
            // 收款方手续费账户退回入账子账户类型 来自原交易【收款方手续费账户出账子账户类型】
            refund.setRefundReceiveFeeAccountInAccountingType(tradeSinglePayment.getReceiveFeeAccountOutAccountingType());
            // 收款方手续费账户退回入账账务历史1 来自输入
            refund.setRefundReceiveFeeAccountInAccountingHis1(body.getRefund_receive_fee_account_in_accounting_his1());
            // 收款方手续费账户退回入账账务历史2 来自输入
            refund.setRefundReceiveFeeAccountInAccountingHis2(body.getRefund_receive_fee_account_in_accounting_his2());
            // 收款方手续费账户退回入账账务历史3 来自输入
            refund.setRefundReceiveFeeAccountInAccountingHis3(body.getRefund_receive_fee_account_in_accounting_his3());

            // 其他损益台账部分
            initRefundExtendProfitLoss(body.getProfit_loss_list());
            refund.setRefundExtendProfitLoss(refundExtendProfitLoss);

            // 付出方冻结余额 0
            refund.setPayFreezeBal(0l);
            // 收到方冻结余额 0
            refund.setReceiveFreezeBal(0l);
            singlePaymentRefund = singlePaymentRefundService.createOuterTradeForRefundOfFailure(refund);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->创建退款失败交易记录创建失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060020021001100");
        }
    }

    /**
     * @return
     * @throws Exception
     * @Title:otherLossLedgerList2JosnStr
     * @Description: 将其他损益台账转换为字符串
     * @return:String
     * @author:zoran.huang
     * @date:2016年6月8日 上午10:29:05
     */
    private String otherLossLedgerList2JosnStr(List<OtherPofitLossLedgerForRefund> otherLossLedgerListForRefund) throws Exception {
        if (otherLossLedgerListForRefund != null && otherLossLedgerListForRefund.size() > 0) {
            return ObjectJsonUtil.object2String(otherLossLedgerListForRefund);
        }
        return null;
    }

    private void initRefundExtendProfitLoss(List<TradePacketReqBodyOtherPofitLossLedger> otherLossLedgerList) throws Exception {
        if (otherLossLedgerList != null) {
            List<OtherPofitLossLedgerForRefund> otherLossLedgerListForRefund = new ArrayList<OtherPofitLossLedgerForRefund>();
            for (TradePacketReqBodyOtherPofitLossLedger otherPofitLossLedger : otherLossLedgerList) {
                OtherPofitLossLedgerForRefund lossLedgerForRefund = new OtherPofitLossLedgerForRefund();
                lossLedgerForRefund.setIncome_incr(AmountUtils.long2Str(str2Long(otherPofitLossLedger.getIncome_incr())));
                // 其他损益台账List退回收入减少金额 来自输入
                lossLedgerForRefund.setIncome_decr(AmountUtils.long2Str(str2Long(otherPofitLossLedger.getIncome_decr())));
                // 其他损益台账List退回成本费用增加金额 来自输入
                lossLedgerForRefund.setCost_incr(AmountUtils.long2Str(str2Long(otherPofitLossLedger.getCost_incr())));
                // 其他损益台账List退回成本费用减少金额 来自输入
                lossLedgerForRefund.setCost_decr(AmountUtils.long2Str(str2Long(otherPofitLossLedger.getCost_decr())));
                otherLossLedgerListForRefund.add(lossLedgerForRefund);
            }
            refundExtendProfitLoss = otherLossLedgerList2JosnStr(otherLossLedgerListForRefund);
        }
    }
}