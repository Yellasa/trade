package com.liantuo.trade.bus.process.impl.single_payment;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.trade.bus.process.TradeModSingleTxHasPaymentInterface;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.service.ProfitLossLedgerService;
import com.liantuo.trade.bus.service.SinglePaymentService;
import com.liantuo.trade.bus.template.impl.v1_1.mod.ATradeModSingleTxHasPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalAddRecorded;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.TradeCommonValidation;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeProfitLossLedger;
import com.liantuo.trade.orm.pojo.TradeSinglePayment;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentExample;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentExample.Criteria;
import com.liantuo.trade.spring.annotation.JobFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YT
 * @ClassName: SingleExternalPayOfflineAddAccountProcess
 * @Description: 1.1.2	0006_001_003 V1.0外部支付收款补充入账
 * @date 2016年7月5日 上午10:28:20
 */
@JobFlow(value = "0006_001_003", version = "1.0", template = ATradeModSingleTxHasPaymentTemp.class)
public class SingleExternalPayOfflineAddAccountProcess implements TradeModSingleTxHasPaymentInterface<TradePacketReqBodyExternalAddRecorded> {
    private static Logger logger = LoggerFactory.getLogger(SingleExternalPayOfflineAddAccountProcess.class);
    @Autowired
    private ExceptionService exceptionService;
    
    @Resource(name = "profitLossLedgerServiceImpl")
    private ProfitLossLedgerService profitLossLedgerService;
    
    @Resource(name = "singlePaymentServiceImpl")
    private SinglePaymentService singlePaymentService;
    
    @SuppressWarnings("rawtypes")
    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService bizAccountService;
    
    private String reqNo;//请求编号
    private TradeSinglePayment tradeSinglePayment;//支付交易记录

    @Override
    public void transaction(TradeRequest<TradePacketReqBodyExternalAddRecorded> tradeRequest) throws Exception {
        //账务处理
    	handlerAccount();
    	//生效收款损益台账
        profitLossLegderEffect(tradeRequest);
        //生效其他损益台账
        extendProfitLossLegderEffect(tradeRequest);
        //修改支付成功交易记录
        modifyTradeRecordSuccess(tradeRequest);
    }

    private void handlerAccount() {
    	List<RealTimeAccountingVo> request_list = new ArrayList<RealTimeAccountingVo>();
        //1 【付款方付出方式】为【第三方充付】时执行--充付入账账务处理
    	//2 【付款方付出方式】为【第三方充付】时执行--充付出账账务处理
        if (TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(this.tradeSinglePayment.getPayType())) {
            RealTimeAccountingVo realAcountSetp1 = realAcountSetp1();
            request_list.add(realAcountSetp1);
            RealTimeAccountingVo realAcountSetp2 = realAcountSetp2();
            request_list.add(realAcountSetp2);
        }
        //3 【付款方手续费账户出账金额】不为空时处理--付款方手续费账户账务处理
        if (AmountUtils.ifNullOrElse(this.tradeSinglePayment.getPayFeeAccountOutAccountingAmt())>0) {
            RealTimeAccountingVo realAcountSetp3 = realAcountSetp3();
            request_list.add(realAcountSetp3);
        }
        //4 【收款方收到方式】为【账户】时执行--收款方账户账务处理
        if (TradeConstants.PAY_BY_ACCOUNT.equals(this.tradeSinglePayment.getReceiveType())) {
            RealTimeAccountingVo realAcountSetp4 = realAcountStep4();
            request_list.add(realAcountSetp4);
        }
        //5 【收款方手续费账户出账金额】不为空时处理--收款方手续费账户账务处理
        if (AmountUtils.ifNullOrElse(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingAmt())>0) {
            RealTimeAccountingVo realAcountSetp5 = realAcountStep5();
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
            throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            throw exceptionService.buildBusinessException("JY000000000000401");
        }
	}
    
    private RealTimeAccountVO initAcountVo() {
		RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE); // 本交易类型0006_001
        accountvo.setTradeNo(this.tradeSinglePayment.getTradeNo()); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT_SUPPLEMENT_IN_ACCOUNTING); // 交易请求类型0006_001_003
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); //本交易业务系统订单号
		return accountvo;
	}
    
    /**
     * 1 充付入账账务处理
     */
    private RealTimeAccountingVo realAcountSetp1() {
        RealTimeAccountVO accountvo = initAcountVo();
        accountvo.setAccountNo(this.tradeSinglePayment.getPayAccountNo());//付款方账户账户编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getPayAccountInAccountingHis1());//付款方账户入账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getPayAccountInAccountingHis2());//付款方账户入账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getPayAccountInAccountingHis3());//付款方账户入账账务历史3
        accountvo.setAmount(this.tradeSinglePayment.getExternalPayReceivedAmt());
        return bizAccountService.avlBalIncrWrapper(accountvo);
    }
    /**
     * 2 充付出账账务处理
     */
    private RealTimeAccountingVo realAcountSetp2() {
        RealTimeAccountVO accountvo = initAcountVo();
        accountvo.setAccountNo(this.tradeSinglePayment.getPayAccountNo());//付款方账户账户编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getPayAccountOutAccountingHis1());//付款方账户出账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getPayAccountOutAccountingHis2());//付款方账户出账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getPayAccountOutAccountingHis3());//付款方账户出账账务历史3
        accountvo.setAmount(this.tradeSinglePayment.getPayAccountOutAccountingAmt());//付款方账户出账金额
        return bizAccountService.avlBalDecrWrapper(accountvo);
    }
    
    /**
     * 3 付款方手续费账户账务处理
     */
    private RealTimeAccountingVo realAcountSetp3() {
    	RealTimeAccountVO accountvo = initAcountVo();
        accountvo.setAccountNo(this.tradeSinglePayment.getPayFeeAccountNo());//付款方手续费账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getPayFeeAccountOutAccountingHis1());//付款方手续费账户出账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getPayFeeAccountOutAccountingHis2());//付款方手续费账户出账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getPayFeeAccountOutAccountingHis3());//付款方手续费账户出账账务历史3
        accountvo.setAmount(this.tradeSinglePayment.getPayFeeAccountOutAccountingAmt());
        return bizAccountService.avlBalDecrWrapper(accountvo);
    }
    
    
    /**
     * 4 收款方账户账务处理
     */
    private RealTimeAccountingVo realAcountStep4() {
    	RealTimeAccountVO accountvo = initAcountVo();
    	accountvo.setAccountNo(this.tradeSinglePayment.getReceiveAccountNo());//收款方账户账户编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getReceiveAccountInAccountingHis1());//收款方账户入账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getReceiveAccountInAccountingHis2());//收款方账户入账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getReceiveAccountInAccountingHis3());//收款方账户入账账务历史3
        String sub_type = this.tradeSinglePayment.getReceiveAccountInAccountingType();
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(sub_type)) {
            accountvo.setFrozenTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE);
            accountvo.setFrozenTradeNo(this.tradeSinglePayment.getTradeNo());
            accountvo.setAmount(this.tradeSinglePayment.getReceiveAccountInAccountingAmt());
            return bizAccountService.FrozenBalIncrAmtWrapper(accountvo);
        } else {
            accountvo.setAmount(this.tradeSinglePayment.getReceiveAccountInAccountingAmt());
            return bizAccountService.avlBalIncrWrapper(accountvo);
        }
    }
    
    /**
     *5 收款方手续费账户账务处理
     */
    private RealTimeAccountingVo realAcountStep5() {
        RealTimeAccountVO accountvo = initAcountVo();
        accountvo.setAccountNo(this.tradeSinglePayment.getReceiveFeeAccountNo());//收款方手续费账户账户编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingHis1());//收款方手续费账户出账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingHis2());//收款方手续费账户出账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingHis3());//收款方手续费账户出账账务历史3
        String sub_type = this.tradeSinglePayment.getReceiveAccountInAccountingType();
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(sub_type)) {
	    	 accountvo.setFrozenTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE);
	         accountvo.setFrozenTradeNo(this.tradeSinglePayment.getTradeNo());
	         accountvo.setAmount(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingAmt());
             return bizAccountService.FrozenBalDecrAmtWrapper(accountvo);
        } else {
            accountvo.setAmount(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingAmt());
            return bizAccountService.avlBalDecrWrapper(accountvo);
        }
    }
    
    
    
	/**
     * 创建失败返回记录
     */
    @Override
    public void createTradeFailRecode(TradeRequest<TradePacketReqBodyExternalAddRecorded> tradeRequest) throws Exception {
    }


    @Override
    public Object getTradeDetails() {
        return this.tradeSinglePayment;
    }

    @Override
    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    /**
     * 校验输入参数格式
     */
    public void formatValidate(TradeRequest<TradePacketReqBodyExternalAddRecorded> tradeRequest) throws Exception {
    	String msg = TradeValidationUtil.validateRequest(tradeRequest);
        if (!StringUtils.isEmpty(msg)) {
            throw exceptionService.buildBusinessException("JY00060010031000100", msg);
        }
    }

    public void bizValidate(TradeRequest<TradePacketReqBodyExternalAddRecorded> tradeRequest) throws Exception {
        //校验【交易编号】、【交易发起方发起请求编号】与主体是否一致 
        checkDuplicate(tradeRequest);
        //校验【核心商户编号】、【资金池编号】对应关系
        TradeCommonValidation.validateCoreMerchantNoAndFundPoolNo(tradeRequest, true, exceptionService.buildBusinessException("JY00060010031000200"));
        //校验组别
        String tradeCatagory = tradeSinglePayment.getTradeCatagory();
        if(org.springframework.util.StringUtils.hasText(tradeCatagory)&&!TradeConstants.TRADE_PAYMENT_REFUND_OUTER.equals(tradeCatagory)){//外部支付类
        	throw exceptionService.buildBusinessException("JY00060010031000500");
        }
    }


    protected void checkDuplicate(TradeRequest<TradePacketReqBodyExternalAddRecorded> tradeRequest) throws Exception {
    	 String trade_no = tradeRequest.getBody().getTrade_no();
         String core_merchant_no = tradeRequest.getHead().getCore_merchant_no();
         String fund_pool_no = tradeRequest.getHead().getFund_pool_no();
         String out_trade_no_ext = tradeRequest.getBody().getOut_trade_no_ext();
         if(StringUtils.isEmpty(trade_no)&&StringUtils.isEmpty(out_trade_no_ext)){
         	throw exceptionService.buildBusinessException("JY00060010031000400");
         }
    	
    	TradeSinglePaymentExample tradeRechargeExample = new TradeSinglePaymentExample();
        Criteria criteria = tradeRechargeExample.createCriteria();
        criteria.andCoreMerchantNoEqualTo(core_merchant_no)
        .andFundPoolNoEqualTo(fund_pool_no);
        if(!StringUtils.isEmpty(trade_no)){
        	criteria.andTradeNoEqualTo(trade_no);
        }
        if(StringUtils.isEmpty(trade_no)&&!StringUtils.isEmpty(out_trade_no_ext)){
        	criteria.andOutTradeNoExtEqualTo(out_trade_no_ext);
        }
        List<TradeSinglePayment> list = singlePaymentService.queryByExample(tradeRechargeExample);
        if (CollectionUtils.isEmpty(list)) {
            logger.info("-->交易编号或交易发起方发起请求编号不存在");
            throw exceptionService.buildBusinessException("JY00060010031000400");
        }
        TradeSinglePayment tradeSinglePayment2 = list.get(0);
        this.tradeSinglePayment = tradeSinglePayment2;
    }

    /**
     * 生效收款损益台账
     *
     * @param tradeRequest
     */
    private void profitLossLegderEffect(TradeRequest<TradePacketReqBodyExternalAddRecorded> tradeRequest) {
        try {
            TradeProfitLossLedger ledger = profitLossLedgerService.queryByLedgerNoAndTradeNo(this.tradeSinglePayment.getReceiveProfitLossLedgerNo(), this.tradeSinglePayment.getTradeNo());
            ledger.setLedgerNo(this.tradeSinglePayment.getReceiveProfitLossLedgerNo());
            ledger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PAYMENT_SUPPLEMENT_IN_ACCOUNTING);
            ledger.setEffectiveReqNo(this.reqNo);
            profitLossLedgerService.updateBlankLegderEffective(ledger);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->生效收款损益台账失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("TZ000200301");
        }
	}
    
    /**
     * 生效其他损益台
     *
     * @param tradeRequest
     */
    private void extendProfitLossLegderEffect(TradeRequest<TradePacketReqBodyExternalAddRecorded> tradeRequest) {
        try {
        	String json = this.tradeSinglePayment.getExtendProfitLoss();
        	List<TradeProfitLossLedger> otherProfitLossLedgerList = ObjectJsonUtil.json2ArrayList(json, TradeProfitLossLedger.class);
            for (TradeProfitLossLedger ledger : otherProfitLossLedgerList) {
                TradeProfitLossLedger lossLedger = profitLossLedgerService.queryByLedgerNoAndTradeNo(ledger.getLedgerNo(), this.tradeSinglePayment.getTradeNo());
                lossLedger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PAYMENT_SUPPLEMENT_IN_ACCOUNTING);
                lossLedger.setEffectiveReqNo(this.reqNo);
                profitLossLedgerService.updateBlankLegderEffective(lossLedger);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->生效其他损益台账失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("TZ000200301");
        }
    }
    
    /**
     * 修改支付成功交易记录
     *
     * @param tradeRequest
     * @throws Exception
     */
    private void modifyTradeRecordSuccess(TradeRequest<TradePacketReqBodyExternalAddRecorded> tradeRequest) throws Exception {
        try {
        	//最后变更日期时间
            tradeSinglePayment.setGmtSuccessPay(new Date());
            //最后变更交易请求类型 本次请求类型
            tradeSinglePayment.setLatestTradeReqType(TradeConstants.TRADE_OUTER_PAYMENT_SUPPLEMENT_IN_ACCOUNTING);
            //最后变更交易请求编号	来自交易请求记录
            tradeSinglePayment.setLatestReqNo(this.reqNo);
            //支付成功日期时间	系统时间
            tradeSinglePayment.setGmtSuccessPay(new Date());
            long receiveFreezeBal = 0;
            int bal_version = 0;
            if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(this.tradeSinglePayment.getReceiveAccountInAccountingType())) {
                receiveFreezeBal = this.tradeSinglePayment.getReceiveAccountInAccountingAmt();
                ++bal_version;
            }
            if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingType())) {
                receiveFreezeBal -= this.tradeSinglePayment.getReceiveFeeAccountOutAccountingAmt();
                ++bal_version;
            }
            if(bal_version>0){
            	tradeSinglePayment.setReceiveFreezeBal(receiveFreezeBal);
            }
            this.tradeSinglePayment = singlePaymentService.updateTradeSuccess(this.tradeSinglePayment);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->支付成功交易记录修改失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060010031000700");
        }
    }
}	