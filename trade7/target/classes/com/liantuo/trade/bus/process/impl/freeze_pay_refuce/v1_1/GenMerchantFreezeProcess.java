/**
 * 
 */
package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1_1;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateSingleTxNoPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;
import com.liantuo.trade.orm.pojo.TradePaymentLog;
import com.liantuo.trade.orm.service.TradePaymentLogService;
import com.liantuo.trade.orm.service.TradePaymentService;
import com.liantuo.trade.seqno.IdFactory;
import com.liantuo.trade.spring.annotation.JobFlow;

/**
 * @ClassName: GenMerchantFreezeProcess.java
 * @Description: 冻结
 *               <p>
 *               Company:联拓金融信息服务有限公司
 *               </p>
 * @author kelly
 * @version V1.1
 * @Date 2016-3-9 下午2:24:33
 */
@JobFlow(value = "0001_001_001", version = "1.1", template = ATradeCreateSingleTxNoPaymentTemp.class)
public class GenMerchantFreezeProcess implements TradeCreateSingleTxNoPaymentInterface<TradePacketReqBodyMerchantFreeze> {

	private final Logger logger = LoggerFactory.getLogger(GenMerchantFreezeProcess.class);

	@Resource(name = "idFactoryTradePaymentTradeNo")
	private IdFactory idFactoryTradePaymentTradeNo;

	@Resource(name = "tradePaymentService")
	private TradePaymentService tradePaymentService;

	@SuppressWarnings("rawtypes")
	@Resource(name = "bizAccountServiceImpl")
	private BizAccountService bizAccountService;

	@Resource(name = "tradePaymentLogService")
	private TradePaymentLogService tradePaymentLogService;
	@Autowired
	private ExceptionService exceptionService;
	private String merchantNo;
	private TradePayment payment;
	private String reqNo;
	private List<RealTimeAccountingRsp> realTimeAccountingRsps; // 存放账务结果数据

	protected void checkDuplicate(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) throws Exception {
		TradePaymentExample tradePaymentExample = new TradePaymentExample();
		tradePaymentExample.createCriteria().andFundPoolNoEqualTo(tradeRquest.getHead().getFund_pool_no()).andOutTradeNoExtEqualTo(tradeRquest.getBody().getOut_trade_no_ext());
		List<TradePayment> list = tradePaymentService.queryExample(tradePaymentExample);
		if (!CollectionUtils.isEmpty(list)) {
			throw exceptionService.buildBusinessException("JY00010010011100300");
		}
	}

	@Override
	public void bizValidate(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) throws Exception {
		// 交易编号重复校验
		checkDuplicate(tradeRquest);
		// 查询CA所属商户编号
		CreditAccount ca = bizAccountService.selectByAccountNo(tradeRquest.getBody().getPayment_account_no());
		if (null == ca) {
			throw exceptionService.buildBusinessException("JY00010010011100400");
		} else {
			merchantNo = ca.getMerchantNo();
		}
	}

	@Override
	public void tradeCreate(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) throws Exception {
		try {
			this.tradePaymentCreate(tradeRquest);// 创建交易
			this.updateTradeChgHis();// 交易历史插入
		} catch (Exception e) {
			logger.error(String.format("交易创建失败 OutTradeNoExt=%s ", tradeRquest.getBody().getOut_trade_no_ext()));
			throw exceptionService.buildBusinessException("JY000000000000301");
		}
	}

	protected void tradePaymentCreate(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) throws Exception {
		TradePayment payment = new TradePayment();
		payment.setTradeNo(TradeUtilCommon.getServiceCode(tradeRquest.getHead().getRequest_code()) + idFactoryTradePaymentTradeNo.generate().toString());
		payment.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());// 核心商户编号
		payment.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());// 池编号
		payment.setMerchantExtendField1(tradeRquest.getBody().getMerchant_extend_field_1());// 扩展
		payment.setMerchantExtendField2(tradeRquest.getBody().getMerchant_extend_field_2());
		payment.setMerchantExtendField3(tradeRquest.getBody().getMerchant_extend_field_3());
		payment.setMerchantExtendField4(tradeRquest.getBody().getMerchant_extend_field_4());
		payment.setMerchantExtendField5(tradeRquest.getBody().getMerchant_extend_field_5());
		payment.setOutTradeNo(tradeRquest.getBody().getOut_trade_no());// 交易发起方业务系统订单号
		payment.setOutTradeNoExt(tradeRquest.getBody().getOut_trade_no_ext());// 交易发起方发起请求编号
		// payment.setGmtCreated(new Date());// 创建时间
		// payment.setGmtLatestModified(new Date());// 最后变更时间
		payment.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
		payment.setLatestReqNo(reqNo);// 最后变更交易请求编号
		payment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);// 交易结束状态-未结束
		payment.setPaymentAccountNo(tradeRquest.getBody().getPayment_account_no());// 付出CA账户编号
		payment.setPaymentMerchantNo(merchantNo);// 付出CA账户编号所属成员编号
		payment.setVersion(TradeConstants.DEFAULT_LOCK_VRESION); // 初始版本为0
		long tradeAmount;
		try {
			tradeAmount = AmountUtils.bizAmountConvertToLong(tradeRquest.getBody().getFreeze_amount());
		} catch (AmountConvertException e) {
			throw exceptionService.buildBusinessException("JY000000000000201");
		}
		payment.setFreezeAmount(tradeAmount);// 冻结金额
		payment.setStatus(TradeConstants.TRADE_STATUS_INIT);// 交易状态-创建
		tradePaymentService.insertTradePayment(payment);
		this.payment = payment;
	}

	protected void updateTradeChgHis() throws Exception {
		TradePaymentLog his = new TradePaymentLog();
		// 为了插入version的变更所以需要重新查询交易
		TradePayment tradePayment = tradePaymentService.selectByPrimaryKey(payment.getId());
		BeanUtils.copyProperties(tradePayment, his);
		his.setId(null);
		tradePaymentLogService.insertTradePaymentLog(his);
		this.payment = tradePayment;
	}

	protected void freezeOp(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) throws Exception {
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
		}
	}

	@SuppressWarnings({ "unchecked" })
	protected List<RealTimeAccountingRsp> account(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) throws Exception {
		List<RealTimeAccountingRsp> realTimeAccountingRsps;
		RealTimeAccountVO accounvo = new RealTimeAccountVO();
		accounvo.setPayAccountNo(tradeRquest.getBody().getPayment_account_no());// 付款账号
		accounvo.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());// 核心商户编号
		accounvo.setPoolNo(tradeRquest.getHead().getFund_pool_no());// 资金池编号
		accounvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code()));// 交易类型0001_001
		accounvo.setTradeNo(payment.getTradeNo());// 本交易编号
		accounvo.setTradeGmtCreated(payment.getGmtCreated());// 本交易创建时间
		accounvo.setRmk("");
		accounvo.setTradeReqCode(tradeRquest.getHead().getRequest_code());// 交易请求类型0001_001_001
		accounvo.setTradeStepNo(reqNo);// 交易请求编号
		if (!StringUtils.isEmpty(tradeRquest.getBody().getOut_trade_no())) {
			accounvo.setSequenceNo(tradeRquest.getBody().getOut_trade_no());// 本交易业务系统订单号
		}
		accounvo.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code()));// 所属业务冻结交易类型0001_001
		accounvo.setFrozenTradeNo(payment.getTradeNo());// 所属业务冻结交易编号
		accounvo.setFreezeAmount(payment.getFreezeAmount());// 可用余额减少金额,来自输入【冻结金额】
		accounvo.setAvl_bal_decr_field_1(tradeRquest.getBody().getAvl_bal_decr_field_1());// 可用余额减少客户账务历史1
		accounvo.setAvl_bal_decr_field_2(tradeRquest.getBody().getAvl_bal_decr_field_2());// 可用余额减少客户账务历史2
		accounvo.setAvl_bal_decr_field_3(tradeRquest.getBody().getAvl_bal_decr_field_3());// 可用余额减少客户账务历史3
		accounvo.setFro_bal_incr_field_1(tradeRquest.getBody().getFro_bal_incr_field_1());// 冻结余额增加客户账务历史1
		accounvo.setFro_bal_incr_field_2(tradeRquest.getBody().getFro_bal_incr_field_2());// 冻结余额增加客户账务历史2
		accounvo.setFro_bal_incr_field_3(tradeRquest.getBody().getFro_bal_incr_field_3());// 冻结余额增加客户账务历史3
		realTimeAccountingRsps = bizAccountService.freeze(accounvo);
		this.realTimeAccountingRsps = realTimeAccountingRsps;
		return realTimeAccountingRsps;
	}

	protected void updateStatus(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) {
		payment.setLatestReqNo(reqNo);// 最后变更交易请求编号
		payment.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
		payment.setGmtFreeze(realTimeAccountingRsps.get(0).getAccountingRecord().getGmtCreated());// 冻结时间，由账务来
		payment.setStatus(TradeConstants.TRADE_STATUS_FREEZE);// 冻结成功
		tradePaymentService.updateTradePayment(payment);
	}

	@Override
	public void transaction(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) throws Exception {
		freezeOp(tradeRquest);// 执行账务冻结
		try {
			updateStatus(tradeRquest);// 修改交易记录
			updateTradeChgHis();// 记录交易历史变更
		} catch (Exception e) {
			throw exceptionService.buildBusinessException("JY000000000000801");
		}
	}

	@Override
	public void tradeUpdateForFail(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) {
		// 实现更新交易为失败状态
		try {
			updateStatusFail(tradeRquest);// 修改交易记录
			updateTradeChgHis();// 记录交易历史变更
		} catch (Exception e) {
			throw exceptionService.buildBusinessException("JY000000000000801");
		}
	}
	
	protected void updateStatusFail(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) {
		payment.setLatestReqNo(reqNo);// 最后变更交易请求编号
		payment.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
		payment.setStatus(TradeConstants.TRADE_STATUS_INIT_FAILED);// 创建失败
		payment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);// 交易状态变更为已结束
		tradePaymentService.updateTradePayment(payment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liantuo.trade.bus.template.impl1.ATradeNoPaymentCreateTemp#formatValidate
	 * (com.liantuo.trade.client.trade.packet.TradeRequest)
	 */
	@Override
	public void formatValidate(TradeRequest<TradePacketReqBodyMerchantFreeze> tradeRquest) throws Exception {
		String msg = TradeValidationUtil.validateRequest(tradeRquest);
		if (!StringUtils.isEmpty(msg)) {
			throw exceptionService.buildBusinessException("JY00010010011100100", msg);
		}
	}

	@Override
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
		
	}

	@Override
	public Object getTradeDetails() {
		return payment;
	}

}
