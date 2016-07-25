package com.liantuo.trade.bus.process.impl.simple_fund_handle.v1;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.service.LegderService;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateSingleTxNoPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.simple_fund_handle.TradePacketReqBodyAdjustLedgerOut;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeAdjustAccount;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountExample;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountLog;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.service.TradeAdjustAccountService;
import com.liantuo.trade.orm.service.TradeAdjustAccountServiceLog;
import com.liantuo.trade.seqno.IdFactory;
import com.liantuo.trade.spring.annotation.JobFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName:     TradeAdjustLedgerOutProcess.java
 * @Description:   0003_001_003 V1.0CA台账出金
 * Company:联拓金融信息服务有限公司
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-4-6 下午4:57:30 
 */
@JobFlow(value = "0003_001_003", version = "1.0", template = ATradeCreateSingleTxNoPaymentTemp.class)
public class TradeAdjustLedgerOutProcess implements TradeCreateSingleTxNoPaymentInterface<TradePacketReqBodyAdjustLedgerOut> {

	private final Logger logger = LoggerFactory.getLogger(TradeAdjustLedgerOutProcess.class);

	@Resource(name = "idFactoryTradeAdjustAccountNo")
	private IdFactory idFactoryTradeAdjustAccountNo;

	@Resource(name = "tradeAdjustAccountService")
	private TradeAdjustAccountService tradeAdjustAccountService;

	@SuppressWarnings("rawtypes")
	@Resource(name = "bizAccountServiceImpl")
	private BizAccountService bizAccountService;

	@Resource(name = "tradeAdjustAccountLogService")
	private TradeAdjustAccountServiceLog tradeAdjustAccountLogService;
	
	@Resource(name="legderServiceImpl")
    private LegderService legderService;
	
	@Autowired
	private ExceptionService exceptionService;
	private String payMerchantNo;
	private TradeAdjustAccount adjustAccount;
	private String reqNo;
	private List<RealTimeAccountingRsp> realTimeAccountingRsps; // 存放账务结果数据
	private String ledgerNo;//台账编号
	
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface#formatValidate(com.liantuo.trade.client.trade.packet.TradeRequest)
	 */
	@Override
	public void formatValidate(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) throws Exception {
		String msg = TradeValidationUtil.validateRequest(tradeRquest);
		if (!StringUtils.isEmpty(msg)) {
			throw exceptionService.buildBusinessException("JY00030010031000100", msg);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface#bizValidate(com.liantuo.trade.client.trade.packet.TradeRequest)
	 */
	@Override
	public void bizValidate(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) throws Exception {
		// 交易编号重复校验
		checkDuplicate(tradeRquest);

		// 查询付出CA所属商户编号
		CreditAccount payca = bizAccountService.selectByAccountNo(tradeRquest.getBody().getPayment_account_no());
		if (null == payca) {
			throw exceptionService.buildBusinessException("JY00030010031000400");
		} else {
			payMerchantNo = payca.getMerchantNo();
		}
	}
	
	protected void checkDuplicate(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) throws Exception {
		TradeAdjustAccountExample tradeAdjustAccountExample = new TradeAdjustAccountExample();
		tradeAdjustAccountExample.createCriteria().andFundPoolNoEqualTo(tradeRquest.getHead().getFund_pool_no()).andOutTradeNoExtEqualTo(tradeRquest.getBody().getOut_trade_no_ext());
		List<TradeAdjustAccount> list = tradeAdjustAccountService.queryExample(tradeAdjustAccountExample);
		if (!CollectionUtils.isEmpty(list)) {
			throw exceptionService.buildBusinessException("JY00030010031000300");
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface#tradeCreate(com.liantuo.trade.client.trade.packet.TradeRequest)
	 */
	@Override
	public void tradeCreate(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) throws Exception {
		try {
			this.tradeAdjustCreate(tradeRquest);// 创建交易
			this.updateTradeChgHis();// 交易历史插入
		} catch (Exception e) {
			logger.error(String.format("交易创建失败 OutTradeNoExt=%s ", tradeRquest.getBody().getOut_trade_no_ext()));
			throw exceptionService.buildBusinessException("JY000000000000301");
		}
	}
	
	protected void tradeAdjustCreate(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) throws Exception {
		TradeAdjustAccount adjust = new TradeAdjustAccount();
		adjust.setTradeNo(TradeUtilCommon.getServiceCode(tradeRquest.getHead().getRequest_code()) + idFactoryTradeAdjustAccountNo.generate().toString());
		adjust.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());// 核心商户编号
		adjust.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());// 池编号
		adjust.setMerchantExtendField1(tradeRquest.getBody().getMerchant_extend_field_1());// 扩展
		adjust.setMerchantExtendField2(tradeRquest.getBody().getMerchant_extend_field_2());
		adjust.setMerchantExtendField3(tradeRquest.getBody().getMerchant_extend_field_3());
		adjust.setMerchantExtendField4(tradeRquest.getBody().getMerchant_extend_field_4());
		adjust.setMerchantExtendField5(tradeRquest.getBody().getMerchant_extend_field_5());
		adjust.setOutTradeNoExt(tradeRquest.getBody().getOut_trade_no_ext());// 交易发起方发起请求编号
		adjust.setOutTradeNo(tradeRquest.getBody().getOut_trade_no());// 交易发起方业务系统订单号
		adjust.setGmtCreated(new Date());// 创建时间
		adjust.setGmtLatestModified(new Date());// 最后变更时间
		adjust.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
		adjust.setLatestReqNo(reqNo);// 最后变更交易请求编号
		adjust.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);// 交易结束状态-未结束
		adjust.setStatus(TradeConstants.TRADE_ADJUST_ACCOUNT_INIT);// 交易状态-创建
		adjust.setRequestGroup(TradeConstants.TRADE_GROUP_LEDGER_OUT);//请求组别02
		adjust.setVersion(TradeConstants.DEFAULT_LOCK_VRESION);// 初始版本为0
		adjust.setPaymentAccountNo(tradeRquest.getBody().getPayment_account_no());//付出CA账户编号
		adjust.setPaymentMerchantNo(payMerchantNo);//付出成员商户编号
		adjust.setPaymentAccountExtendField1(tradeRquest.getBody().getPayment_account_extend_field_1());//付出CA账务备注1
		adjust.setPaymentAccountExtendField2(tradeRquest.getBody().getPayment_account_extend_field_2());//付出CA账务备注2
		adjust.setPaymentAccountExtendField3(tradeRquest.getBody().getPayment_account_extend_field_3());//付出CA账务备注3
		adjust.setClearChannel(tradeRquest.getBody().getClear_channel());//收款渠道编号
		adjust.setGmtSuccessClearChannel(DateUtil.formatDateTime(tradeRquest.getBody().getGmt_success_clear_channel()));//收款渠道收到日期时间
		adjust.setThirdTradeNo(tradeRquest.getBody().getThird_trade_no());//收款渠道订单号
		adjust.setLedgerMerchantExtendField1(tradeRquest.getBody().getLedger_merchant_extend_field_1());//收付款台账客户保留字段1
		adjust.setLedgerMerchantExtendField2(tradeRquest.getBody().getLedger_merchant_extend_field_2());//收付款台账客户保留字段2
		adjust.setLedgerMerchantExtendField3(tradeRquest.getBody().getLedger_merchant_extend_field_3());//收付款台账客户保留字段3
		long tradeAmount;
		try {
			tradeAmount = AmountUtils.bizAmountConvertToLong(tradeRquest.getBody().getAdjust_amount());//调整金额
		} catch (AmountConvertException e) {
			throw exceptionService.buildBusinessException("JY000000000000201");
		}
		adjust.setAdjustAmount(tradeAmount);//入金金额
		
		tradeAdjustAccountService.insertAdjustAccount(adjust);
		this.adjustAccount = adjust;
	}

	protected void updateTradeChgHis() throws Exception {
		TradeAdjustAccountLog his = new TradeAdjustAccountLog();
		// 为了插入version的变更所以需要重新查询交易
		TradeAdjustAccount tradeadjust = tradeAdjustAccountService.selectByPrimaryKey(adjustAccount.getId());
		BeanUtils.copyProperties(tradeadjust, his);
		his.setId(null);
		tradeAdjustAccountLogService.insertAdjustAccountLog(his);
		this.adjustAccount = tradeadjust;
	}
	
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface#transaction(com.liantuo.trade.client.trade.packet.TradeRequest)
	 */
	@Override
	public void transaction(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) throws Exception {
		freezeOp(tradeRquest);// 执行账务
		
		try {
            // 创建生效业务台账，返回台账编号
			ledgerNo = createLegder(tradeRquest);
        } catch (Exception e) {
            throw exceptionService.buildBusinessException("JY000000000000501");
        }
		
		try {
			updateStatus(tradeRquest);// 修改交易记录
			updateTradeChgHis();// 记录交易历史变更
		} catch (Exception e) {
			throw exceptionService.buildBusinessException("JY000000000000801");
		}
		
	}
	
	protected String createLegder(TradeRequest<TradePacketReqBodyAdjustLedgerOut> req) {
        TradeLedger ledger = new TradeLedger();
        ledger.setCoreMerchantNo(req.getHead().getCore_merchant_no());// 核心商户编号
        ledger.setFundPoolNo(req.getHead().getFund_pool_no());// 资金池编号

        ledger.setMerchantExtendField1(req.getBody().getLedger_merchant_extend_field_1());// 业务台账客户保留字段1
        ledger.setMerchantExtendField2(req.getBody().getLedger_merchant_extend_field_2());
        ledger.setMerchantExtendField3(req.getBody().getLedger_merchant_extend_field_3());
        ledger.setMerchantExtendField4("");
        ledger.setMerchantExtendField5("");

        ledger.setTradeType(TradeUtilCommon.getTradeType(req.getHead().getRequest_code())); // 所属业务交易类型（例：0003_001）
        ledger.setTradeNo(adjustAccount.getTradeNo()); // 交易编号
        ledger.setGmtTradeCreated(adjustAccount.getGmtCreated()); // 所属业务交易创建日期

        ledger.setEffectiveReqType(req.getHead().getRequest_code()); // 生效交易请求类型
        ledger.setEffectiveReqNo(reqNo); // 生效交易请求编号
        if (!StringUtils.isEmpty(adjustAccount.getOutTradeNo())) {
            ledger.setOutTradeNo(adjustAccount.getOutTradeNo()); // 交易发起方业务系统订单号
        }
        ledger.setOutTradeNoExt(adjustAccount.getOutTradeNoExt()); // 交易发起方发起请求ID
        ledger.setClearChannel(req.getBody().getClear_channel()); // 收付款渠道编号（请求业务参数）
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_1())) {
            ledger.setClearChannelAttr1(req.getBody().getClear_channel_attr_1());// 收付款属性1
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_2())) {
            ledger.setClearChannelAttr2(req.getBody().getClear_channel_attr_2());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_3())) {
            ledger.setClearChannelAttr3(req.getBody().getClear_channel_attr_3());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_3())) {
            ledger.setClearChannelAttr3(req.getBody().getClear_channel_attr_3());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_4())) {
            ledger.setClearChannelAttr4(req.getBody().getClear_channel_attr_4());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_5())) {
            ledger.setClearChannelAttr5(req.getBody().getClear_channel_attr_5());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_6())) {
            ledger.setClearChannelAttr6(req.getBody().getClear_channel_attr_6());
        }
        ledger.setExtendField1(req.getBody().getLedger_extend_field_1());//台账备注1
        ledger.setExtendField2(req.getBody().getLedger_extend_field_2());//台账备注2
        ledger.setExtendField3(req.getBody().getLedger_extend_field_3());//台账备注3
        ledger.setExtendField4(req.getBody().getLedger_extend_field_4());//台账备注4
        ledger.setExtendField5(req.getBody().getLedger_extend_field_5());//台账备注5
        ledger.setExtendField6(req.getBody().getLedger_extend_field_6());//台账备注6
        ledger.setExtendField7(req.getBody().getLedger_extend_field_7());//台账备注7
        ledger.setExtendField8(req.getBody().getLedger_extend_field_8());//台账备注8
        ledger.setExtendField9(req.getBody().getLedger_extend_field_9());//台账备注9
        ledger.setExtendField10(req.getBody().getLedger_extend_field_10());//台账备注10
        
        ledger.setPaymentAmount(AmountUtils.bizAmountConvertToLong(req.getBody().getAdjust_amount()));//付款金额
        ledger.setGmtSuccessClearChannel(DateUtil.formatDateTime(req.getBody().getGmt_success_clear_channel()));// 外部渠道收付款成功日期时间
        ledger.setThirdTradeNo(req.getBody().getThird_trade_no());// 收付款渠道订单号
        ledger.setPaymentTradeNo(""); // 支付中心交易号

        return legderService.createEffectiveLegder(ledger);
    }
	 
	
	protected void freezeOp(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) throws Exception {
		/** 实时记账操作 */
		List<RealTimeAccountingRsp> resultlist;
		try {
			long start = System.currentTimeMillis();
			resultlist = account(tradeRquest);
			logger.info(" ->>> 账务执行时间：" + (System.currentTimeMillis() - start));
			RealTimeAccountingRsp rsp;
			for (Iterator<RealTimeAccountingRsp> it = resultlist.iterator(); it.hasNext();) {
				rsp = it.next();
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
	
	@SuppressWarnings({ "unchecked" })
	protected List<RealTimeAccountingRsp> account(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) throws Exception {
		List<RealTimeAccountingRsp> realTimeAccountingRsps;
		RealTimeAccountVO accounvo = new RealTimeAccountVO();
		accounvo.setAccountNo(tradeRquest.getBody().getPayment_account_no());//付出CA账户编号
		accounvo.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());// 核心商户编号
		accounvo.setPoolNo(tradeRquest.getHead().getFund_pool_no());// 资金池编号
		accounvo.setReservedFields1(tradeRquest.getBody().getPayment_account_extend_field_1());//付出CA账务备注1
		accounvo.setReservedFields2(tradeRquest.getBody().getPayment_account_extend_field_2());//付出CA账务备注2
		accounvo.setReservedFields3(tradeRquest.getBody().getPayment_account_extend_field_3());//付出CA账务备注3
		accounvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code()));// 交易类型0003_001
		accounvo.setTradeNo(adjustAccount.getTradeNo());// 本交易编号
		accounvo.setTradeGmtCreated(adjustAccount.getGmtCreated());// 本交易创建时间
		accounvo.setRmk("");
		accounvo.setTradeReqCode(tradeRquest.getHead().getRequest_code());// 交易请求类型0003_001_003
		accounvo.setTradeStepNo(reqNo);// 交易请求编号
		if (!StringUtils.isEmpty(tradeRquest.getBody().getOut_trade_no())) {
			accounvo.setSequenceNo(tradeRquest.getBody().getOut_trade_no());// 本交易业务系统订单号
		}
		accounvo.setAmount(adjustAccount.getAdjustAmount());//入金金额
		realTimeAccountingRsps = bizAccountService.avlBalDecr(accounvo);//可用余额减少
		this.realTimeAccountingRsps = realTimeAccountingRsps;
		return realTimeAccountingRsps;
	}
	
	protected void updateStatus(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) {
		adjustAccount.setGmtLatestModified(new Date());//最后变更日期时间
		adjustAccount.setLatestReqNo(reqNo);// 最后变更交易请求编号
		adjustAccount.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
		adjustAccount.setGmtAdjustSuccess(realTimeAccountingRsps.get(0).getAccountingRecord().getGmtCreated());// 调整时间，由账务来
		adjustAccount.setStatus(TradeConstants.TRADE_ADJUST_ACCOUNT_SUCCESS);// 【创建】改为【调整成功】
		adjustAccount.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//【未结束】改为【已结束】
		adjustAccount.setLedgerNo(ledgerNo);//外部收付款台账编号
		tradeAdjustAccountService.updateTradeAdjustAccount(adjustAccount);
	}
	
	
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface#tradeUpdateForFail(com.liantuo.trade.client.trade.packet.TradeRequest)
	 */
	@Override
	public void tradeUpdateForFail(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) throws Exception {
		// 实现更新交易为失败状态
		try {
			updateStatusFail(tradeRquest);// 修改交易记录
			updateTradeChgHis();// 记录交易历史变更
		} catch (Exception e) {
			throw exceptionService.buildBusinessException("JY000000000000801");
		}
	}
	
	protected void updateStatusFail(TradeRequest<TradePacketReqBodyAdjustLedgerOut> tradeRquest) {
		adjustAccount.setGmtLatestModified(new Date());//最后变更日期时间
		adjustAccount.setGmtCreatedFail(new Date());//创建失败日期时间
		adjustAccount.setLatestReqNo(reqNo);// 最后变更交易请求编号
		adjustAccount.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
		adjustAccount.setStatus(TradeConstants.TRADE_ADJUST_ACCOUNT_FAILED);// 【创建】改为【创建失败】
		adjustAccount.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//【未结束】改为【已结束】
		adjustAccount.setLedgerNo(ledgerNo);//外部收付款台账编号
		tradeAdjustAccountService.updateTradeAdjustAccount(adjustAccount);
	}
	
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface#setReqNo(java.lang.String)
	 */
	@Override
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}
	
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface#getTradeDetails()
	 */
	@Override
	public Object getTradeDetails() {
		return adjustAccount;
	}
	
}
