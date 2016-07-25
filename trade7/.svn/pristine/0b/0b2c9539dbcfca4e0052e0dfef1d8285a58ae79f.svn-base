package com.liantuo.trade.bus.process.impl.single_payment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.liantuo.deposit.advanceaccount.bus.service.AdvanceAccountService;
import com.liantuo.deposit.advanceaccount.bus.vo.AdvanceAccountVO;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.payment.client.pay.PaymentRequest;
import com.liantuo.payment.client.pay.PaymentResponse;
import com.liantuo.payment.client.pay.alipay.base.ExtendParams;
import com.liantuo.payment.client.pay.alipay.base.GoodsDetail;
import com.liantuo.payment.client.pay.alipay.vo1.req.AlipayTradePayRequest;
import com.liantuo.payment.client.pay.alipay.vo1.rsp.AlipayTradePayResponse;
import com.liantuo.payment.client.pay.head.PaymentHead;
import com.liantuo.payment.client.pay.weixin.vo1.agent.req.WeiXinScanPayRequest;
import com.liantuo.payment.client.pay.weixin.vo1.agent.rsp.WeiXinScanPayResponse;
import com.liantuo.trade.bus.process.TradeCreateMultiTxHasPaymentInterface;
import com.liantuo.trade.bus.process.TradeState;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.service.LegderService;
import com.liantuo.trade.bus.service.ProfitLossLedgerService;
import com.liantuo.trade.bus.service.SinglePaymentService;
import com.liantuo.trade.bus.service.TradeRequestPaymentInterface;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateMultiTxHasPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalSynPayment;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.OtherPofitLossLedgerForRefund;
import com.liantuo.trade.client.trade.packet.body.zf.AliPaymentAttachment;
import com.liantuo.trade.client.trade.packet.body.zf.Attachment;
import com.liantuo.trade.client.trade.packet.body.zf.Extend_params;
import com.liantuo.trade.client.trade.packet.body.zf.WxAttachment;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.TradeCommonValidation;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.common.validate.ValidationUtil;
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
 * @author zzd
 * @ClassName: SingleExternalSynPayOfflineProcess
 * @Description: 外部收款同步支付
 * @date 2016年7月4日 下午4:12:20
 */
@JobFlow(value = "0006_001_006", version = "1.0", template = ATradeCreateMultiTxHasPaymentTemp.class)
public class SingleExternalSynPayOfflineProcess implements TradeCreateMultiTxHasPaymentInterface<TradePacketReqBodyExternalSynPayment> {
	 private static Logger logger = LoggerFactory.getLogger(SingleExternalSynPayOfflineProcess.class);
	 @Autowired
	 private ExceptionService exceptionService;
	 @Resource(name = "singlePaymentServiceImpl")
	 private SinglePaymentService singlePaymentService;
	 @Resource(name = "advanceAccountServiceImpl")
	 private AdvanceAccountService advanceAccountService;
	 @Resource(name = "idFactorySinglePaymentTradeNo")
	 private IdFactory idFactorySinglePaymentTradeNo;
	 @Resource(name = "idFactoryWithdrawThirdBatchno")
	 private IdFactory idFactoryWithdrawThirdBatchno;
	 @Resource(name = "legderServiceImpl")
	 private LegderService legderService;
	 @Resource(name = "profitLossLedgerServiceImpl")
	 private ProfitLossLedgerService profitLossLedgerService;
	 @Resource(name = "bizAccountServiceImpl")
	 private BizAccountService bizAccountService;
	 @Autowired
	 private TradeRequestPaymentInterface  requestPaymentImpl;//请求支付中心service
	 
	 private String reqNo;//请求编号
	 private String payMerchantNo;//付款商户编号
	 private String payFeeMerchantNo;//付款方手续费账户商户编号
	 private String receiveMerchantNo;//收款方账户商户编号
	 private String receiveFeeMerchantNo;//收款方手续费账户商户编号
	 private TradeLedger ledger  ; //空白付款方台账
	 private String tradeNo;//交易编号
	 private String serial_number;//批次号
	 private String payLedgerNo;//外部空白台账NO
	 private String receiveProfitLossLedgerNo;//收款损益台账编号
	 private List<TradeProfitLossLedger> otherProfitLossLedgerList;//其他损益台账list
	 private String otherProfitLossLedgerNo;//其他损益台账编号
	 private String jsonList = "";//其他损益台账ListJson
	 private TradeSinglePayment tradeSinglePayment;
	 private Attachment attachment;
	 private PaymentRequest zfRequest ;
	 private String responseXml;
	 private BusinessException exception;
	 private String pay_income_money;//付款方入账金额
	
	@Override
	public void validate(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest)throws Exception {
		  //校验输入参格式
        formatValidate(tradeRequest);
        //参数正确性校验
        bizValidate(tradeRequest);
	}
	
	/**
     * 校验输入参数格式
     */
    private void formatValidate(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) throws Exception {
        String msg = TradeValidationUtil.validateRequestWeak(tradeRequest);
        if (!StringUtils.isEmpty(msg)) {
            logger.info("-->输入参数校验不通过：" + msg);
            throw exceptionService.buildBusinessException("JY00060010061000100", msg);
        }
        //获取支付标准输入中的附加组件，并进行校验
       
        if(TradeConstants.ZF0001_02_001.equals(tradeRequest.getBody().getPay_channel())&&
        		tradeRequest.getBody().getOther_attachment_group_json()!=null	
        ){
        	AliPaymentAttachment  aliPaymentAttachment = ObjectJsonUtil.string2Object(tradeRequest.getBody().getOther_attachment_group_json(), AliPaymentAttachment.class);
        	msg = ValidationUtil.validateObject(aliPaymentAttachment,Format.class,Required.class);
			if(StringUtils.isEmpty(msg)){
				//组件里边的good_detail 跟 Extend_params 直接到支付中心侧进行校验
				attachment = aliPaymentAttachment;
			}
        }else if(TradeConstants.ZF0003_01_001.equals(tradeRequest.getBody().getPay_channel())&&
        		tradeRequest.getBody().getOther_attachment_group_json()!=null
        ){
        	WxAttachment wxAttachment = ObjectJsonUtil.string2Object(tradeRequest.getBody().getOther_attachment_group_json(), WxAttachment.class);
        	msg = ValidationUtil.validateObject(wxAttachment,Format.class,Required.class);
			if(StringUtils.isEmpty(msg)){
				attachment = wxAttachment;
			}
        }
		if (!StringUtils.isEmpty(msg)) {
            logger.info("-->输入参数校验不通过：" + msg);
            throw exceptionService.buildBusinessException("JY00060010061000100", msg);
        }
		
        
        //当【收款方账户入账子账户类型】为【冻结】时，若【收款方手续费账户账户编号】与【收款方账户账户编号】不同，则【收款方手续费出账子账户类型】只能是【可用】，若相同，则能是【可用】或【冻结】
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_account_in_accounting_type())
        		&&TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())) {
            if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_fee_account_out_accounting_type()) 
            		&& !tradeRequest.getBody().getReceive_account_no().equals(tradeRequest.getBody().getReceive_fee_account_no())) {
                logger.info("-->收款账户和收款手续费账户不同时，收款子账户类型必须为可用");
                throw exceptionService.buildBusinessException("JY00060010061000100", "收款账户和收款手续费账户不同时，收款手续费子账户类型必须为可用");
            }
        }else if(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE.equals(tradeRequest.getBody().getReceive_account_in_accounting_type())
        		&&TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())){
        	if(TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_fee_account_out_accounting_type())){
        		logger.info("-->当收款账户子类型为可用时，收款手续费账户子类型必须为可用");
        		throw exceptionService.buildBusinessException("JY00060010061000100", "当收款账户子类型为可用时，收款手续费账户子类型必须为可用");
        	}
        }else if(TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type())
        		&&TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_fee_account_out_accounting_type())){
        	   logger.info("-->当收款方式为损益时，收款手续费账户子类型必须为可用");
               throw exceptionService.buildBusinessException("JY00060010061000100", "当收款方式为损益时，收款手续费账户子类型必须为可用");
        }
        //收款方手续费账户出账金额,需小于等于【收款方收到金额】
        if (TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getReceive_type()) && !StringUtils.isEmpty(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt())) {
            if (!compareAmt(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt(), tradeRequest.getBody().getReceive_account_in_accounting_amt())) {
                logger.info("--> " + "收款方手续费账户出账金额需要小于或等于收款方收到金额");
                throw exceptionService.buildBusinessException("JY00060010061000100", "收款方手续费账户出账金额需要小于或等于收款方收到金额");
            }
        } else if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type()) && !StringUtils.isEmpty(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt())) {
            if (!StringUtils.isEmpty(tradeRequest.getBody().getReceive_profit_loss_income_incr()) && !compareAmt(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt(), tradeRequest.getBody().getReceive_profit_loss_income_incr())) {
                logger.info("--> " + "收款方手续费账户出账金额需要小于或等于收款方收到金额");
                throw exceptionService.buildBusinessException("JY00060010061000100", "收款方手续费账户出账金额需要小于或等于收款方收到金额");
            } else if (!StringUtils.isEmpty(tradeRequest.getBody().getReceive_profit_loss_cost_decr()) && !compareAmt(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt(), tradeRequest.getBody().getReceive_profit_loss_cost_decr())) {
                logger.info("--> " + "收款方手续费账户出账金额需要小于或等于收款方收到金额");
                throw exceptionService.buildBusinessException("JY00060010061000100", "收款方手续费账户出账金额需要小于或等于收款方收到金额");
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
    private void bizValidate(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) throws Exception {
        //校验交易发起方请求编号是否重复
        checkDuplicate(tradeRequest);
        //校验【核心商户编号】、【资金池编号】对应关系
        TradeCommonValidation.validateCoreMerchantNoAndFundPoolNo(tradeRequest, false, exceptionService.buildBusinessException("JY00060010061000200"));
        //校验【付款方账户账户编号】正确性
        if (!StringUtils.isEmpty(tradeRequest.getBody().getPay_account_no())) {
            AdvanceAccountVO accountVo = getCreditAccountInfo(tradeRequest.getBody().getPay_account_no());
            if (accountVo == null || !(tradeRequest.getHead().getCore_merchant_no().equals(accountVo.getCoreMerchantNo()) && tradeRequest.getHead().getFund_pool_no().equals(accountVo.getPoolNo()))) {
                logger.info("--> " + "【付款方账户账户编号】与【核心商户编号】、【资金池编号】、【所属成员商户编号】 不对应");
                throw exceptionService.buildBusinessException("JY00060010061000500");
            } else {
            	payMerchantNo =  accountVo.getMerchantNo();
            }
        }
        //校验【付款方手续费账户账户编号】正确性
        if (!StringUtils.isEmpty(tradeRequest.getBody().getPay_fee_account_no())) {
            AdvanceAccountVO accountVo = getCreditAccountInfo(tradeRequest.getBody().getPay_fee_account_no());
            if (accountVo == null || !(tradeRequest.getHead().getCore_merchant_no().equals(accountVo.getCoreMerchantNo()) && tradeRequest.getHead().getFund_pool_no().equals(accountVo.getPoolNo()))) {
                logger.info("--> " + "【付款方手续费账户账户编号】与【核心商户编号】、【资金池编号】、【所属成员商户编号】 不对应");
                throw exceptionService.buildBusinessException("JY00060010061000600");
            } else {
            	payFeeMerchantNo =   accountVo.getMerchantNo();
            }
        }
        //校验【收款方账户账户编号】正确性
        if (!StringUtils.isEmpty(tradeRequest.getBody().getReceive_account_no())) {
            AdvanceAccountVO accountVo = getCreditAccountInfo(tradeRequest.getBody().getReceive_account_no());
            if (accountVo == null || !(tradeRequest.getHead().getCore_merchant_no().equals(accountVo.getCoreMerchantNo()) && tradeRequest.getHead().getFund_pool_no().equals(accountVo.getPoolNo()))) {
                logger.info("--> " + "【收款方账户账户编号】与【核心商户编号】、【资金池编号】、【所属成员商户编号】 不对应");
                throw exceptionService.buildBusinessException("JY00060010061000700");
            } else {
            	receiveMerchantNo =  accountVo.getMerchantNo();
            }
        }
        //校验【收款方手续费账户账户编号】正确性
        if (!StringUtils.isEmpty(tradeRequest.getBody().getReceive_fee_account_no())) {
            AdvanceAccountVO accountVo = getCreditAccountInfo(tradeRequest.getBody().getReceive_fee_account_no());
            if (accountVo == null || !(tradeRequest.getHead().getCore_merchant_no().equals(accountVo.getCoreMerchantNo()) && tradeRequest.getHead().getFund_pool_no().equals(accountVo.getPoolNo()))) {
                logger.info("--> " + "【收款方手续费账户账户编号】与【核心商户编号】、【资金池编号】、【所属成员商户编号】 不对应");
                throw exceptionService.buildBusinessException("JY00060010061000800");
            } else {
            	receiveFeeMerchantNo = accountVo.getMerchantNo();
            }
        }
        //校验金额关系
        checkAmountRelation(tradeRequest);
    }
    
    /**
     * @param tradeRequest
     * @throws Exception
     * @Title:checkDuplicate
     * @Description: 根据资金池标号和 交易发起方发起请求编号，检查交易发起方发起请求编号是否重复
     * @return:void
     */
    protected void checkDuplicate(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) throws Exception {
        TradeSinglePaymentExample tradeRechargeExample = new TradeSinglePaymentExample();
        tradeRechargeExample.createCriteria().andFundPoolNoEqualTo(tradeRequest.getHead().getFund_pool_no()).andOutTradeNoExtEqualTo(tradeRequest.getBody().getOut_trade_no_ext());
        List<TradeSinglePayment> list = singlePaymentService.queryByExample(tradeRechargeExample);
        if (!CollectionUtils.isEmpty(list)) {
            logger.info("-->交易发起方发起请求编号重复");
            throw exceptionService.buildBusinessException("JY00060010061000400");
        }
    }
    
    private void checkAmountRelation(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
        long positiveTotal = 0;
        long negativeTotal = 0;
        
        if (!TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(tradeRequest.getBody().getPay_type())) {
            positiveTotal += strToLong(tradeRequest.getBody().getTotal_amount());//+
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
            throw exceptionService.buildBusinessException("JY00060010061000900");
        }
    }

    @Override
	public void prepareLedgerData(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
    	 //获取充值交易编号
		     this.tradeNo = idFactorySinglePaymentTradeNo.generate().toString();
		     this.serial_number =idFactoryWithdrawThirdBatchno.generate().toString();
		     TradePacketReqBodyExternalSynPayment  paymentCommonEntry = tradeRequest.getBody();
    		 ledger = new TradeLedger();
             ledger.setCoreMerchantNo(tradeRequest.getHead().getCore_merchant_no());// 核心商户编号
             ledger.setFundPoolNo(tradeRequest.getHead().getFund_pool_no());// 资金池编号
             ledger.setMerchantExtendField1(paymentCommonEntry.getMerchant_extend_field_1());// 支付中心标准输入：业务台账客户保留字段1
             ledger.setMerchantExtendField2(paymentCommonEntry.getMerchant_extend_field_2());// 支付中心标准输入：业务台账客户保留字段2
             ledger.setMerchantExtendField3(paymentCommonEntry.getMerchant_extend_field_3());// 支付中心标准输入：业务台账客户保留字段3
             ledger.setTradeType(TradeConstants.TRADE_OUTER_PAYMENT_TYPE); // 业务交易类型（例：0006_001）
             ledger.setTradeNo(this.tradeNo); //业务交易编号
             ledger.setGmtTradeCreated(new Date()); //业务交易创建日期
             ledger.setCreateReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);//创建交易请求类型
             ledger.setCreateReqNo(this.reqNo);//创建交易请求编号
             ledger.setOutTradeNo(tradeRequest.getBody().getOut_trade_no());// 交易发起方业务系统订单号
             ledger.setOutTradeNoExt(tradeRequest.getBody().getOut_trade_no_ext());//付款方外部交易发起方发起请求编号
             ledger.setClearChannel(paymentCommonEntry.getPay_channel()); //支付中心标准输入：收付款渠道编号
             ledger.setExtendField1(paymentCommonEntry.getPay_transaction_id()); //支付中心标准输入：付款方外部收付款备注1【支付渠道身份编号】
             ledger.setExtendField5(serial_number);//付款方外部收付款备注5【提交第三方请求流水号】
             if(TradeConstants.ZF0001_02_001.equals(paymentCommonEntry.getPay_channel())){
            	 AliPaymentAttachment aliPaymentAsynAttachment =(AliPaymentAttachment)attachment;
            	ledger.setExtendField6(aliPaymentAsynAttachment.getSeller_id());//付款方外部收付款备注6【收款方账户】--->支付中心标准输入：卖方ID
             }
             ledger.setReceiveAmount(strToLong(paymentCommonEntry.getTotal_amount()));//支付中心标准输入：订单金额
            
	}
    
    @Override
	public void transactionCreate(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest)throws Exception {
		//创建空白付款方外部收款台账
    	 createBlankLedgerRecode(ledger);
    	 Date date = new Date();
    	//创建其他空白损益台账
    	 createExtendBlankProfitLossLegder(tradeRequest, date);
    	//创建空白收款损益台账
    	 if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type())) {
    		 	createBlankProfitLossLegder(tradeRequest, date);
    	 }
    	//创建等待付款交易记录
    	 createTradeRecordWaitForPay(tradeRequest, date);
	}
    
	
	private void createBlankLedgerRecode(TradeLedger ledger) {
		 try {
			 legderService.createBlankLegder(ledger);
		  } catch (Exception e) {
	          e.printStackTrace();
	          logger.error("-->创建空白付款方外部收款台账失败：" + e.getMessage(), e);
	          throw exceptionService.buildBusinessException("TZ000100301");
	      }
	}
	
	/**
     * 创建其他空白损益台账
     *
     * @param tradeRequest
     * @param currentTime
     */
    private void createExtendBlankProfitLossLegder(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest, Date currentTime) {
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
                    profitLossLedger.setTradeType(TradeConstants.TRADE_OUTER_PAYMENT_TYPE);
                    profitLossLedger.setTradeNo(this.tradeNo);
                    profitLossLedger.setGmtTradeCreated(currentTime);//交易创建日期
                    profitLossLedger.setCreateReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);//创建交易请求类型
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
                    profitLossLedger.setIncomeIncr(strToLong(ledger.getIncome_incr()));//损益收入增加金额
                    profitLossLedger.setIncomeDecr(strToLong(ledger.getIncome_decr()));//损益收入减少金额
                    profitLossLedger.setCostIncr(strToLong(ledger.getCost_incr()));//损益成本费用减少金额
                    profitLossLedger.setCostDecr(strToLong(ledger.getCost_decr()));//损益成本费用减少金额
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
     * 创建空白收款损益台账
     *
     * @param tradeRequest
     * @param currentTime
     */
    private void createBlankProfitLossLegder(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest, Date currentTime) {
            try {
                TradeProfitLossLedger receiveProfitLossLedger = new TradeProfitLossLedger();
                TradePacketReqBodyExternalSynPayment  synPayment = tradeRequest.getBody();
                receiveProfitLossLedger.setCoreMerchantNo(tradeRequest.getHead().getCore_merchant_no());//收款方损益核心商户编号
                receiveProfitLossLedger.setFundPoolNo(tradeRequest.getHead().getFund_pool_no());//收款方损益资金池编号
                receiveProfitLossLedger.setMerchantExtendField1(synPayment.getReceive_profit_loss_extend_field_1());//收款方损益业务台账客户保留字段1
                receiveProfitLossLedger.setMerchantExtendField2(synPayment.getReceive_profit_loss_extend_field_2());//收款方损益业务台账客户保留字段2
                receiveProfitLossLedger.setMerchantExtendField3(synPayment.getReceive_profit_loss_extend_field_3());//收款方损益业务台账客户保留字段3
                receiveProfitLossLedger.setTradeType(TradeConstants.TRADE_OUTER_PAYMENT_TYPE);//收款方损益所属业务交易类型
                receiveProfitLossLedger.setTradeNo(this.tradeNo);//收款方损益所属业务交易编号
                receiveProfitLossLedger.setGmtTradeCreated(currentTime);//收款方损益所属业务交易创建日期v
                receiveProfitLossLedger.setCreateReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);//收款方损益创建交易请求类型
                receiveProfitLossLedger.setCreateReqNo(this.reqNo);//收款方损益创建交易请求编号
                receiveProfitLossLedger.setOutTradeNoExt(synPayment.getOut_trade_no_ext());//交易发起方发起请求编号
                receiveProfitLossLedger.setOutTradeNo(synPayment.getOut_trade_no());//交易发起方业务系统订单号
                receiveProfitLossLedger.setProfitLossAttr1(synPayment.getReceive_profit_loss_attr_1());//收款方损益损益属性1
                receiveProfitLossLedger.setProfitLossAttr2(synPayment.getReceive_profit_loss_attr_2());//收款方损益损益属性2
                receiveProfitLossLedger.setProfitLossAttr3(synPayment.getReceive_profit_loss_attr_3());//收款方损益损益属性3
                receiveProfitLossLedger.setProfitLossAttr4(synPayment.getReceive_profit_loss_attr_4());//收款方损益损益属性4
                receiveProfitLossLedger.setProfitLossAttr5(synPayment.getReceive_profit_loss_attr_5());//收款方损益损益属性5
                receiveProfitLossLedger.setProfitLossAttr6(synPayment.getReceive_profit_loss_attr_6());//收款方损益损益属性6
                receiveProfitLossLedger.setProfitLossAttr7(synPayment.getReceive_profit_loss_attr_7());//收款方损益损益属性7
                receiveProfitLossLedger.setProfitLossAttr8(synPayment.getReceive_profit_loss_attr_8());//收款方损益损益属性8
                receiveProfitLossLedger.setProfitLossAttr9(synPayment.getReceive_profit_loss_attr_9());//收款方损益损益属性9
                receiveProfitLossLedger.setProfitLossAttr10(synPayment.getReceive_profit_loss_attr_10());//收款方损益损益属性10
                receiveProfitLossLedger.setIncomeIncr(strToLong(synPayment.getReceive_profit_loss_income_incr()));//收款方损益收入增加金额
                receiveProfitLossLedger.setCostDecr(strToLong(synPayment.getReceive_profit_loss_cost_decr()));//收款方损益成本费用减少金额
                this.receiveProfitLossLedgerNo = profitLossLedgerService.createBlankProfitLossLedger(receiveProfitLossLedger);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("-->创建空白收款损益台账失败：" + e.getMessage(), e);
                throw exceptionService.buildBusinessException("TZ000200201");
            }
    }


	
	 /**
     * 创建等待支付交易记录
     *
     * @param tradeRequest
     * @param currentTime
     */
    private void createTradeRecordWaitForPay(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest, Date currentTime) {
       try{
	    	TradeSinglePayment _tradeSinglePayment = initSinglePayment(tradeRequest);
	         //其他损益台账List部分
	    	_tradeSinglePayment.setExtendProfitLoss(this.jsonList);
            this.tradeSinglePayment = singlePaymentService.createForPayOfWait(_tradeSinglePayment);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->等待支付交易记录创建失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060010061001000");
        }
    }
    
    @Override
	public void createPayFail(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest)throws Exception {
    	 TradeSinglePayment payment = initSinglePayment(tradeRequest);
         //其他损益台账部分
         List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list = tradeRequest.getBody().getProfit_loss_list();
         if (!CollectionUtils.isEmpty(profit_loss_list)) {
             for (TradePacketReqBodyOtherPofitLossLedger profitLoss : profit_loss_list) {
                 if (!StringUtils.isEmpty(profitLoss.getIncome_incr())) {
                     profitLoss.setIncome_incr(String.valueOf(strToLong(profitLoss.getIncome_incr())));
                 }
                 if (!StringUtils.isEmpty(profitLoss.getIncome_decr())) {
                     profitLoss.setIncome_decr(String.valueOf(strToLong(profitLoss.getIncome_decr())));
                 }
                 if (!StringUtils.isEmpty(profitLoss.getCost_incr())) {
                     profitLoss.setCost_incr(String.valueOf(strToLong(profitLoss.getCost_incr())));
                 }
                 if (!StringUtils.isEmpty(profitLoss.getCost_decr())) {
                     profitLoss.setCost_decr(String.valueOf(strToLong(profitLoss.getCost_decr())));
                 }
             }
         }

         payment.setExtendProfitLoss(ObjectJsonUtil.object2String(profit_loss_list));
         payment.setGmtFailPay(new Date());
         TradeSinglePayment _singlePayment;
         try {
             _singlePayment = singlePaymentService.createTradeFailureRecode(payment);
         } catch (Exception e) {
             e.printStackTrace();
             throw exceptionService.buildBusinessException("JY00060010011001100");
         }

         tradeSinglePayment = _singlePayment;
	}
    
    private TradeSinglePayment initSinglePayment(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRquest) throws Exception {
        TradeSinglePayment payment = new TradeSinglePayment();

        TradePacketHead head = tradeRquest.getHead();
        TradePacketReqBodyExternalSynPayment body = tradeRquest.getBody();

        payment.setTradeNo(tradeNo);
        payment.setCoreMerchantNo(head.getCore_merchant_no());
        payment.setFundPoolNo(head.getFund_pool_no());
        payment.setPartnerId(head.getPartner_id());
        
        payment.setMerchantExtendField1(body.getMerchant_extend_field_1());
        payment.setMerchantExtendField2(body.getMerchant_extend_field_2());
        payment.setMerchantExtendField3(body.getMerchant_extend_field_3());
        payment.setMerchantExtendField4(body.getMerchant_extend_field_4());
        payment.setMerchantExtendField5(body.getMerchant_extend_field_5());
        payment.setMerchantExtendField6(body.getMerchant_extend_field_6());
        payment.setMerchantExtendField7(body.getMerchant_extend_field_7());
        payment.setMerchantExtendField8(body.getMerchant_extend_field_8());
        payment.setMerchantExtendField9(body.getMerchant_extend_field_9());
        payment.setMerchantExtendField10(body.getMerchant_extend_field_10());
        payment.setOutTradeNoExt(body.getOut_trade_no_ext());
        payment.setOutTradeNo(body.getOut_trade_no());
        payment.setLatestTradeReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
        payment.setLatestReqNo(this.reqNo);
        //付款方基本部分
        if(TradeConstants.PAY_BY_THIRD_ACCOUNT.equals(body.getPay_type())){//第三方充付
        	 payment.setPayAmt(strToLong(body.getPay_account_out_accounting_amt()));
        }else if(TradeConstants.PAY_BY_THIRD.equals(body.getPay_type())){//第三方直付
        	payment.setPayAmt(ledger.getReceiveAmount());
        }
        
        payment.setPayType(body.getPay_type());
        
        //付出方外部部分
        payment.setExternalPayLedgerNo(ledger.getLedgerNo()); //付款方外部业务台账编号  --->来自外部台账
        payment.setExternalPayChannel(ledger.getClearChannel());//付款方外部收付款渠道编号  --->来自外部台账
        //付款方外部收付款属性1（付出手续费金额）   --->来自外部台账    输入为空，所以可以省略
        //payment.setExternalPayChannelFeeAmt(ledger.getClearChannelAttr1());
        //付款方外部收付款属性1（退回手续费金额）   --->来自外部台账    输入为空，所以可以省略
        //payment.setExternalPayChannelRefundFeeAmt(ledger.getClearChannelAttr1());
        //付款方外部收款金额   --->来自外部台账
        payment.setExternalPayReceivedAmt(ledger.getReceiveAmount());
        payment.setExternalRefundChannelBatchNo(ledger.getExtendField4());//付款方外部收付款备注4【提交第三方批次号】--->来自外部台账 
        payment.setExternalRefundChannelSerialNo(ledger.getExtendField5());//付款方外部收付款备注5【提交第三方请求流水号】--->来自外部台账 
        
        //付出方账户部分
        payment.setPayAccountNo(body.getPay_account_no());
        payment.setPayAccountMerchantNo(payMerchantNo);
        payment.setPayAccountOutAccountingAmt(strToLong(body.getPay_account_out_accounting_amt()));
        payment.setPayAccountOutAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);
        payment.setPayAccountOutAccountingHis1(body.getPay_account_out_accounting_his1());
        payment.setPayAccountOutAccountingHis2(body.getPay_account_out_accounting_his2());
        payment.setPayAccountOutAccountingHis3(body.getPay_account_out_accounting_his3());
        payment.setPayAccountInAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);
        payment.setPayAccountInAccountingHis1(body.getPay_account_in_accounting_his1());
        payment.setPayAccountInAccountingHis2(body.getPay_account_in_accounting_his2());
        payment.setPayAccountInAccountingHis3(body.getPay_account_in_accounting_his3());
        
        //付款方手续费账户部分
        payment.setPayFeeAccountNo(body.getPay_fee_account_no());
        payment.setPayFeeAccountMerchantNo(payFeeMerchantNo);
        payment.setPayFeeAccountOutAccountingAmt(strToLong(body.getPay_fee_account_out_accounting_amt()));
        payment.setPayFeeAccountOutAccountingType(TradeConstants.TRADE_ACCONUT_AVAILABLE_TYPE);
        payment.setPayFeeAccountOutAccountingHis1(body.getPay_fee_account_out_accounting_his1());
        payment.setPayFeeAccountOutAccountingHis2(body.getPay_fee_account_out_accounting_his2());
        payment.setPayFeeAccountOutAccountingHis3(body.getPay_fee_account_out_accounting_his3());

        //收到方基本部分
        payment.setReceiveType(body.getReceive_type());
        payment.setReceiveAmt(strToLong(body.getReceive_account_in_accounting_amt()));
        if (TradeConstants.RECEIVE_BY_THIRD_ACCOUNT.equals(body.getReceive_type())) {
            payment.setReceiveAmt(strToLong(body.getReceive_account_in_accounting_amt()));
            payment.setReceiveAccountNo(body.getReceive_account_no());
            payment.setReceiveAccountMerchantNo(receiveMerchantNo);
            payment.setReceiveAccountInAccountingAmt(strToLong(body.getReceive_account_in_accounting_amt()));
            payment.setReceiveAccountInAccountingType(body.getReceive_account_in_accounting_type());
            payment.setReceiveAccountInAccountingHis1(body.getReceive_account_in_accounting_his1());
            payment.setReceiveAccountInAccountingHis2(body.getReceive_account_in_accounting_his2());
            payment.setReceiveAccountInAccountingHis3(body.getReceive_account_in_accounting_his3());
        } else if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(body.getReceive_type())) {//如果是损益，则与台账收入增加相同
            if (!StringUtils.isEmpty(body.getReceive_profit_loss_income_incr())) {
                payment.setReceiveAmt(strToLong(body.getReceive_profit_loss_income_incr()));
                payment.setReceiveProfitLossIncomeIncr(strToLong(body.getReceive_profit_loss_income_incr()));
            } else if (!StringUtils.isEmpty(body.getReceive_profit_loss_cost_decr())) {
                payment.setReceiveAmt(strToLong(body.getReceive_profit_loss_cost_decr()));
                payment.setReceiveProfitLossCostDecr(strToLong(body.getReceive_profit_loss_cost_decr()));
            }
        }

        //收款方手续费
        payment.setReceiveFeeAccountNo(body.getReceive_fee_account_no());
        payment.setReceiveFeeAccountMerchantNo(receiveFeeMerchantNo);
        payment.setReceiveFeeAccountOutAccountingAmt(strToLong(body.getReceive_fee_account_out_accounting_amt()));
        payment.setReceiveFeeAccountOutAccountingType(body.getReceive_fee_account_out_accounting_type());
        payment.setReceiveFeeAccountOutAccountingHis1(body.getReceive_fee_account_out_accounting_his1());
        payment.setReceiveFeeAccountOutAccountingHis2(body.getReceive_fee_account_out_accounting_his2());
        payment.setReceiveFeeAccountOutAccountingHis3(body.getReceive_fee_account_out_accounting_his3());

        long receive_in_amt = 0;
        long receive_fee_out_amt = 0;
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(body.getReceive_account_in_accounting_type())) {
            receive_in_amt = strToLong(body.getReceive_account_in_accounting_amt());
        }
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(body.getReceive_fee_account_out_accounting_type())) {
            receive_fee_out_amt = strToLong(body.getReceive_fee_account_out_accounting_amt());
        }
        payment.setReceiveFreezeBal(receive_in_amt - receive_fee_out_amt);

        return payment;
    }
	
   

	/**
	 * 组织调用支付中心数据
	 */
	public String createPaymentRequest(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest)throws Exception {
		TradePacketReqBodyExternalSynPayment  tradeCommonEntry = tradeRequest.getBody();
		PaymentHead zf_head = setBasicParam(tradeRequest);//设置请求head
		if(TradeConstants.ZF0001_02_001.equals(tradeCommonEntry.getPay_channel())){//支付宝条码支付
			AliPaymentAttachment  aliPaymentAttachment = (AliPaymentAttachment)attachment;
			AlipayTradePayRequest request = new AlipayTradePayRequest();
			zf_head.setApp_auth_token(aliPaymentAttachment.getApp_auth_token());//Token
			request.setZf_head(zf_head);
			request.setOut_trade_no(serial_number);//商户订单号 ---> 流水号
			request.setScene(aliPaymentAttachment.getScene());//支付场景
			request.setAuth_code(aliPaymentAttachment.getAuth_code());//支付授权码
			request.setSeller_id(aliPaymentAttachment.getSeller_id());//卖方ID
			request.setTotal_amount(tradeCommonEntry.getTotal_amount());//订单总金额
			request.setDiscountable_amount("0");//参与打折优惠金额
			request.setUndiscountable_amount(tradeCommonEntry.getTotal_amount());//不参与打折金额
			request.setSubject(tradeCommonEntry.getSubject());//订单标题
			request.setBody(tradeCommonEntry.getBody());//订单描述
			if(!StringUtils.isEmpty(aliPaymentAttachment.getGoods_detail())){//订单包含的商品列表信息
				List<GoodsDetail> goods_details = (List<GoodsDetail>)ObjectJsonUtil.json2List(aliPaymentAttachment.getGoods_detail(),new TypeReference<List<GoodsDetail>>(){});
				request.setGoods_detail(goods_details);	
			}
			request.setOperator_id(aliPaymentAttachment.getOperator_id());//商户操作员编号
			request.setStore_id(aliPaymentAttachment.getStore_id());//商户门店编号
			request.setTerminal_id(aliPaymentAttachment.getTerminal_id());//商户机具终端编号
			request.setAlipay_store_id(aliPaymentAttachment.getAlipay_store_id());//支付宝店铺编号
			Extend_params  extend_params = aliPaymentAttachment.getExtend_params();//业务扩展参数
			if(extend_params != null){
				ExtendParams  extendParams = new ExtendParams();
				BeanUtils.copyProperties(extend_params, extendParams);
				request.setExtend_params(extendParams);
			}
			request.setTimeout_express(aliPaymentAttachment.getTimeout_express());//该笔订单允许的最晚付款时间
			zfRequest = request;
			return ObjectXmlUtil.marshal(request);
		}else if(TradeConstants.ZF0003_01_001.equals(tradeCommonEntry.getPay_channel())){//微信刷卡支付
			WxAttachment wxAttachment = (WxAttachment)attachment;
			WeiXinScanPayRequest request = new WeiXinScanPayRequest();
			request.setSub_appid(wxAttachment.getSub_appid());//子商户公众账号ID
	    	request.setDevice_info(wxAttachment.getDevice_info());//设备号
			request.setBody(tradeCommonEntry.getSubject());//subject对应第三方的body
			request.setDetail(tradeCommonEntry.getBody());//body对应第三方的detail
			request.setAttach(wxAttachment.getAttach());//附加数据
			request.setOut_trade_no(serial_number);//收付款备注5【提交第三方请求流水号】<--->来自交易，交易公共模块自动生成
			request.setTotal_fee(String.valueOf(AmountUtils.bizYuan2Fen(tradeCommonEntry.getTotal_amount())));//订单金额，需要转换为分
	    	request.setFee_type(wxAttachment.getFee_type());//货币类型
			request.setSpbill_create_ip(wxAttachment.getSpbill_create_ip());//终端IP
	    	request.setGoods_tag(wxAttachment.getGoods_tag());//商品标记
	    	request.setLimit_pay(wxAttachment.getLimit_pay());//指定支付方式
			request.setAuth_code(wxAttachment.getAuth_code());//授权码
			request.setZf_head(zf_head);
			zfRequest = request;
			return ObjectXmlUtil.marshal(request);
		}
		return null;
	}

	public PaymentHead setBasicParam(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
		PaymentHead head=new PaymentHead();
		head.setVersion("1.0");
		head.setTrade_no(tradeNo);
		head.setTrade_req_no(reqNo);
		head.setLedger_no(ledger.getLedgerNo());
		head.setCore_merchant_no(tradeRequest.getHead().getCore_merchant_no());
		head.setOut_trade_no(tradeRequest.getBody().getOut_trade_no());
		head.setPay_channel(ledger.getClearChannel());
		head.setPay_transaction_id(ledger.getExtendField1());
		return head;
	}
	
	public PaymentResponse requestPayment() throws Exception {
		 PaymentResponse response = requestPaymentImpl.synRequestPayment(zfRequest);
	     this.responseXml = ObjectXmlUtil.marshal(response);
	     logger.info("支付系列-->同步支付--->支付中心返回参数如下： " + this.responseXml );
		 return response;
	}
	
	@Override
	public TradeState parseObject(PaymentResponse _response) throws Exception {
		String ret_code = _response.getZf_head().getRet_code();
	    String err_code = _response.getZf_head().getErr_code();
	    String err_code_des = _response.getZf_head().getErr_code_des();
	    if (_response == null || (TradeConstants.ALIPAY_PAY_INFO_FAILURE.equals(ret_code) &&
	              (TradeConstants.ALIPAY_PAY_INFO_CONNECT_TIME_OUT.equals(err_code) ||
	                        TradeConstants.ALIPAY_PAY_INFO_PROCCESS_TIME_OUT.equals(err_code) ||
	                        TradeConstants.ALIPAY_PAY_INFO_HTTP_ERROR.equals(err_code)
	                        )
	     )){//调用支付中心返回超时异常，但不能直接抛出异常
	         exception = exceptionService.buildBusinessException("JY00060010061001500", err_code_des);
	    	 return TradeState.UNKNOWN;
	     }
		
		if(TradeConstants.ZF0001_02_001.equals(ledger.getClearChannel())){//支付宝条码支付
			AlipayTradePayResponse response =(AlipayTradePayResponse) _response;
		    //如果返回成功，则准备台账生效数据
		    if(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS.equals(ret_code)){
		    	ledger.setExtendField2(response.getBuyer_user_id());//收付款备注2【付款方账户】-->支付宝同步返回【买家在支付宝的用户id】
		    	ledger.setExtendField3(response.getBuyer_logon_id());//收付款备注3【付款方账户名称】-->支付宝同步返回【买家支付宝账号】
		    	ledger.setReceiveAmount(Long.valueOf(strToLong(response.getReceipt_amount())));//收款金额 -->支付宝同步返回【实收金额】
		    	ledger.setGmtSuccessClearChannel(response.getGmt_payment());//外部渠道收付款成功日期时间 -->支付宝同步返回【交易支付时间】
		    	ledger.setThirdTradeNo(response.getTrade_no());//收付款渠道订单号-->支付宝同步返回【支付宝交易号】
		    	ledger.setPaymentTradeNo(response.getZf_head().getTrade_req_no());//支付中心记录号-->支付中心【支付中心请求编号】
		    	ledger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
		    	ledger.setEffectiveReqNo(reqNo);
		    	ledger.setGmtEffective(new Date());
		    	pay_income_money = response.getReceipt_amount();
		    	return TradeState.SUCCESS;
		    }else if(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE.equals(ret_code)){//如果返回失败，则准备台账失效数据
		    	ledger.setExtendField10(response.getSub_code()+":"+response.getSub_msg());//收付款备注10【错误码】 -->支付中心同步返回【错误码】+“:”+【错误码描述】
		        ledger.setFailReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
		        ledger.setPaymentTradeNo(response.getZf_head().getTrade_req_no());//支付中心记录号-->支付中心【支付中心请求编号】
		        ledger.setFailReqNo(reqNo);
		        ledger.setGmtFailed(new Date());
		        return TradeState.FAILURE;
		    }else if(TradeConstants.TRADE_RESPONSE_STATUS_UNKNOWN.equals(ret_code)){//如果返回结果未知
		    	exception = new BusinessException(err_code, err_code_des);
		        return TradeState.UNKNOWN;
		    }
			
		}else if(TradeConstants.ZF0003_01_001.equals(ledger.getClearChannel())){//微信刷卡支付
			WeiXinScanPayResponse response =(WeiXinScanPayResponse) _response;
		     //如果返回成功，则准备台账生效数据
		    if(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS.equals(ret_code)){
		    	ledger.setExtendField2(response.getSub_openid());//收付款备注2【付款方账户】-->支付宝同步返回【用户子标识】
		    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    	ledger.setGmtSuccessClearChannel(dateFormat.parse(response.getTime_end()));//外部渠道收付款成功日期时间 -->支付宝同步返回【支付完成时间】
		    	ledger.setThirdTradeNo(response.getTransaction_id());//收付款渠道订单号-->支付宝同步返回【支付宝交易号】
		    	ledger.setPaymentTradeNo(response.getZf_head().getTrade_req_no());//支付中心记录号-->支付中心【支付中心请求编号】
		    	ledger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
		    	ledger.setEffectiveReqNo(reqNo);
		    	ledger.setGmtEffective(new Date());
		    	pay_income_money = response.getTotal_fee();
		    	return TradeState.SUCCESS;
		    }else if(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE.equals(ret_code)){//如果返回失败，则准备台账失效数据
		    	ledger.setExtendField10(response.getErr_code()+":"+response.getErr_code_des());//收付款备注10【错误码】 -->支付中心同步返回【错误码】+“:”+【错误码描述】
		        ledger.setFailReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
		        ledger.setPaymentTradeNo(response.getZf_head().getTrade_req_no());//支付中心记录号-->支付中心【支付中心请求编号】
		        ledger.setFailReqNo(reqNo);
		        ledger.setGmtFailed(new Date());
		        return TradeState.FAILURE;
		    }else if(TradeConstants.TRADE_RESPONSE_STATUS_UNKNOWN.equals(ret_code)){//如果返回结果未知
		    	exception = new BusinessException(err_code, err_code_des);
		        return TradeState.UNKNOWN;
		    }
		}
		return TradeState.UNKNOWN;
	}
	
	@Override
	public String getResponseXml() {
		return this.responseXml;
	}

	/**
	 * 生效外部台账
	 * 变更状态：等待入账
	 */
	@Override
	public void transactionEntry(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest)throws Exception {
		effectiveLegder(ledger);
		modifyTradeRecordEnterOfWait(tradeSinglePayment);
	}

	private void effectiveLegder(TradeLedger ledger) {
		try {
			 legderService.updateBlankLegderEffective(ledger);
		  } catch (Exception e) {
	          e.printStackTrace();
	          logger.error("-->付款方外部收款台账生效失败：" + e.getMessage(), e);
	          throw exceptionService.buildBusinessException("TZ000100401");
	      }
		
	}

	private void modifyTradeRecordEnterOfWait(TradeSinglePayment tradeSinglePayment) {
		tradeSinglePayment.setLatestReqNo(reqNo);
		tradeSinglePayment.setLatestTradeReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
		tradeSinglePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);
		tradeSinglePayment.setStatus(TradeConstants.TRADE_PAYMENT_WAIT_ENTER);
		tradeSinglePayment.setGmtWaitInAccountting(new Date());//设置等待入账时间
		try {
			tradeSinglePayment = singlePaymentService.updateTrade(tradeSinglePayment);
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("-->等待入账交易记录修改失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060010061001300");
		}
	}
	
	private void modifyTradeRecordSuccess(TradeSinglePayment tradeSinglePayment) {
		tradeSinglePayment.setLatestReqNo(reqNo);
		tradeSinglePayment.setLatestTradeReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
		tradeSinglePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		tradeSinglePayment.setStatus(TradeConstants.TRADE_PAYMENT_SUCCESS);
		tradeSinglePayment.setGmtSuccessPay(new Date());//设置支付成功日期时间
		try {
			tradeSinglePayment = singlePaymentService.updateTrade(tradeSinglePayment);
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("-->支付成功交易记录修改失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060010061001400");
		}
	}
	
	private void modifyTradeRecordFail(TradeSinglePayment tradeSinglePayment) {
		tradeSinglePayment.setLatestReqNo(reqNo);
		tradeSinglePayment.setLatestTradeReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
		tradeSinglePayment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
		tradeSinglePayment.setStatus(TradeConstants.TRADE_PAYMENT_PAY_FAIL);
		tradeSinglePayment.setGmtFailPay(new Date());//设置支付失败日期时间
		try {
			tradeSinglePayment = singlePaymentService.updateTrade(tradeSinglePayment);
		} catch (Exception e) {
			e.printStackTrace();
            logger.error("-->支付失败交易记录修改失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00060010061001200");
		}
	}

	@Override
	public void transactionPayFailure(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest)throws Exception {
		//失效付款方外部台账
		failLegder(ledger);
		//失效其他损益台账
		 if(org.apache.commons.collections.CollectionUtils.isNotEmpty(otherProfitLossLedgerList)){
			  extendProfitLossLegderFail(tradeRequest);
		 }
		//失效收款损益台账
		 if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type())) {
		     profitLossLegderFail(tradeRequest);
		 }
		//修改支付失败交易记录
		modifyTradeRecordFail(tradeSinglePayment);
		
	}

	/**
	 * 
	 * @Description: 失效其他损益台账
	 * @param @param tradeRequest   
	 */
	private void extendProfitLossLegderFail(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
		try {
            for (TradeProfitLossLedger ledger : otherProfitLossLedgerList) {
                ledger = profitLossLedgerService.queryByLedgerNoAndTradeNo(ledger.getLedgerNo(), tradeNo);
                ledger.setFailReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
                ledger.setFailReqNo(this.reqNo);
                profitLossLedgerService.updateBlankLegderFail(ledger);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->失效其他损益台账失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("TZ000200401");
        }
		
	}

	/**
	 * 
	 * @Description: 失效收款损益台账
	 * @param @param tradeRequest   
	 * @return void  
	 * @throws
	 * @author zzd
	 * @date 2016-7-7
	 */
	private void profitLossLegderFail(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
		try {
            TradeProfitLossLedger ledger = profitLossLedgerService.queryByLedgerNoAndTradeNo(receiveProfitLossLedgerNo, tradeNo);
            ledger.setLedgerNo(receiveProfitLossLedgerNo);
            ledger.setFailReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
            ledger.setFailReqNo(this.reqNo);
            profitLossLedgerService.updateBlankLegderFail(ledger);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->失效收款损益台账失败：" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("TZ000200401");
        }
	}

	private void failLegder(TradeLedger ledger) {
		try {
			 legderService.updateBlankLegderFail(ledger);
		  } catch (Exception e) {
	          e.printStackTrace();
	          logger.error("-->付款方外部收款台账失效失败：" + e.getMessage(), e);
	          throw exceptionService.buildBusinessException("TZ000100501");
	      }
	}

	@Override
	public void transactionPaySuccess(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest)throws Exception {
		//执行账务处理
		 handlerRealAcount(tradeRequest);
		 //生效收款损益台账
		 if (TradeConstants.RECEIVE_BY_THIRD_PROFIT_LOSS.equals(tradeRequest.getBody().getReceive_type())) {
		     profitLossLegderEffect(tradeRequest);
		 }
	     //生效其他损益台账
		 if(org.apache.commons.collections.CollectionUtils.isNotEmpty(otherProfitLossLedgerList)){
			 extendProfitLossLegderEffect(tradeRequest);
		 }
	     
		//修改交易记录为：成功支付
		modifyTradeRecordSuccess(tradeSinglePayment);
	}
	
	 /**
     * 生效收款损益台账
     *
     * @param tradeRequest
     */
    private void profitLossLegderEffect(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
            try {
                TradeProfitLossLedger ledger = profitLossLedgerService.queryByLedgerNoAndTradeNo(receiveProfitLossLedgerNo, tradeNo);
                ledger.setLedgerNo(receiveProfitLossLedgerNo);
                ledger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
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
    private void extendProfitLossLegderEffect(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
        try {
            for (TradeProfitLossLedger ledger : otherProfitLossLedgerList) {
                ledger = profitLossLedgerService.queryByLedgerNoAndTradeNo(ledger.getLedgerNo(), tradeNo);
                ledger.setEffectiveReqType(TradeConstants.TRADE_OUTER_PAYMENT_SYN);
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
     * 账务操作
     * @param tradeRequest
     */
    private void handlerRealAcount(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
        List<RealTimeAccountingVo> request_list = new ArrayList<RealTimeAccountingVo>();
        //付款方充付入账账务处理
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
        if (tradeRequest.getBody().getPay_fee_account_out_accounting_amt()!= null) {
            RealTimeAccountingVo realAcountSetp3 = realAcountSetp3(tradeRequest);
            request_list.add(realAcountSetp3);
        }
        //4 【收款方收到方式】为【账户】时执行--收款方账户账务处理
        if (TradeConstants.PAY_BY_ACCOUNT.equals(tradeRequest.getBody().getReceive_type())) {
            RealTimeAccountingVo realAcountSetp4 = realAcountStep4(tradeRequest);
            request_list.add(realAcountSetp4);
        }
        //5 【收款方手续费账户出账金额】不为空时处理--收款方手续费账户账务处理
        if (tradeRequest.getBody().getReceive_fee_account_out_accounting_amt() !=null) {
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
    private RealTimeAccountingVo realAcountSetp1(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getPayAccountNo());//付款方账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getPayAccountInAccountingHis1());//付款方账户入账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getPayAccountInAccountingHis2());//付款方账户入账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getPayAccountInAccountingHis3());//付款方账户入账账务历史3
        accountvo.setTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE); // 交易类型0006_001
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT_SYN); // 交易请求类型0006_001_006
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        //付款方入账金额：根据渠道号不同，取不同返回值
        accountvo.setAmount(strToLong(pay_income_money));
        return bizAccountService.avlBalIncrWrapper(accountvo);
    }
    
    /**
     * 2 充付出账账务处理
     */
    private RealTimeAccountingVo realAcountSetp2(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getPayAccountNo());//付款方账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getPayAccountOutAccountingHis1());//付款方账户出账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getPayAccountOutAccountingHis2());//付款方账户出账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getPayAccountOutAccountingHis3());//付款方账户出账账务历史3
        accountvo.setTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE); // 交易类型0006_001
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT_SYN); // 交易请求类型0006_001_006
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setAmount(strToLong(tradeRequest.getBody().getPay_account_out_accounting_amt()));
        return bizAccountService.avlBalDecrWrapper(accountvo);
    }
    
    /**
     * 3 付款方手续费账户账务处理
     */
    private RealTimeAccountingVo realAcountSetp3(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getPayFeeAccountNo());//付款方手续费账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getPayFeeAccountOutAccountingHis1());//付款方手续费账户出账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getPayFeeAccountOutAccountingHis2());//付款方手续费账户出账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getPayFeeAccountOutAccountingHis3());//付款方手续费账户出账账务历史3
        accountvo.setTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE); // 交易类型0006_001
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT_SYN); // 交易请求类型0006_001_006
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setAmount(strToLong(tradeRequest.getBody().getPay_fee_account_out_accounting_amt()));
        return bizAccountService.avlBalDecrWrapper(accountvo);
    }
    
    /**
     * 4 收款方账户账务处理
     */
    private RealTimeAccountingVo realAcountStep4(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getReceiveAccountNo());//收款方账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getReceiveAccountInAccountingHis1());//收款方账户入账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getReceiveAccountInAccountingHis2());//收款方账户入账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getReceiveAccountInAccountingHis3());//收款方账户入账账务历史3
        accountvo.setTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE); // 交易类型0006_001
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT_SYN); // 交易请求类型0006_001_006
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_account_in_accounting_type())) {
            accountvo.setFrozenTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE);
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
    private RealTimeAccountingVo realAcountStep5(TradeRequest<TradePacketReqBodyExternalSynPayment> tradeRequest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setAccountNo(this.tradeSinglePayment.getReceiveFeeAccountNo());//收款方手续费账户账户编号
        accountvo.setCoreMerchantNo(this.tradeSinglePayment.getCoreMerchantNo()); // 核心商户编号
        accountvo.setPoolNo(this.tradeSinglePayment.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingHis1());//收款方手续费账户出账账务历史1
        accountvo.setReservedFields2(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingHis2());//收款方手续费账户出账账务历史2
        accountvo.setReservedFields3(this.tradeSinglePayment.getReceiveFeeAccountOutAccountingHis3());//收款方手续费账户出账账务历史3
        accountvo.setTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE); // 交易类型0006_001
        accountvo.setTradeNo(this.tradeNo); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeSinglePayment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_OUTER_PAYMENT_SYN); // 交易请求类型0006_001_006
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setSequenceNo(this.tradeSinglePayment.getOutTradeNo()); // 本交易业务系统订单号
        if (TradeConstants.TRADE_ACCOUNT_FREEZE_TYPE.equals(tradeRequest.getBody().getReceive_fee_account_out_accounting_type())) {
            accountvo.setFrozenTradeCode(TradeConstants.TRADE_OUTER_PAYMENT_TYPE);
            accountvo.setFrozenTradeNo(this.tradeNo);
            accountvo.setAmount(strToLong(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt()));
            return bizAccountService.FrozenBalDecrAmtWrapper(accountvo);
        } else {
            accountvo.setAmount(strToLong(tradeRequest.getBody().getReceive_fee_account_out_accounting_amt()));
            return bizAccountService.avlBalDecrWrapper(accountvo);
        }
    }
	
	@Override
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
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

    @Override
	public Object getTradeDetails() {
    	 TradeSinglePaymentVo paymentVo = new TradeSinglePaymentVo();
         if (tradeSinglePayment != null) {
             BeanUtils.copyProperties(tradeSinglePayment, paymentVo);
             return paymentVo;
         }
         return null;
	}

	public BusinessException getException() {
		return exception;
	}
	
}