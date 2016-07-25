package com.liantuo.trade.bus.process.impl.simple_fund_transfer.v1;

import java.util.Date;
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
import com.liantuo.trade.client.trade.packet.body.simple_fund_transfer.TradePacketReqBodyMerchantTransfer;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeTransferAccount;
import com.liantuo.trade.orm.pojo.TradeTransferAccountExample;
import com.liantuo.trade.orm.pojo.TradeTransferAccountLog;
import com.liantuo.trade.orm.service.TradeTransferAccountLogService;
import com.liantuo.trade.orm.service.TradeTransferAccountService;
import com.liantuo.trade.seqno.IdFactory;
import com.liantuo.trade.spring.annotation.JobFlow;

/**
 * CA成员转账
 */
@JobFlow(value = "0007_001_001", version = "1.0", template = ATradeCreateSingleTxNoPaymentTemp.class)
public class MemberTransferProcess implements TradeCreateSingleTxNoPaymentInterface<TradePacketReqBodyMerchantTransfer> {

	private final Logger logger = LoggerFactory.getLogger(MemberTransferProcess.class);
	
	@Resource(name = "tradeTransferAccountServiceImpl")
    private TradeTransferAccountService transferService;
	
	@Resource(name = "idFactoryTradeTransferAccountNo")
	private IdFactory idFactoryTradeTransferAccountNo;

    @SuppressWarnings("rawtypes")
    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService bizAccountService;

    @Resource(name = "tradeTransferAccountLogService")
    private TradeTransferAccountLogService tradePaymentLogService;

    @Autowired
	private ExceptionService exceptionService;
    private TradeTransferAccount payment; // 存放交易数据 
    //付出CA账户编号所属成员编号
    private String payCANo;
    //接收CA账户编号所属成员编号
    private String recCANo;
    
    private List<RealTimeAccountingRsp> realTimeAccountingRsps; // 存放账务结果数据 
	
    private String reqNo;
	@Override
	public void transaction(TradeRequest<TradePacketReqBodyMerchantTransfer> tradeRquest) throws Exception {
		realAcount(tradeRquest);//账务操作
		try {
			updateStatus(tradeRquest);// 修改交易记录
			updateTradeChgHis();// 记录交易历史变更
		} catch (Exception e) {
			throw exceptionService.buildBusinessException("JY000000000000801");
		}
	}


	private void realAcount(TradeRequest<TradePacketReqBodyMerchantTransfer> req) {
		RealTimeAccountVO accountvo = new RealTimeAccountVO();
		accountvo.setCoreMerchantNo(req.getHead().getCore_merchant_no()); // 核心商户编号
        accountvo.setPayAccountNo(payment.getPaymentAccountNo()); // 付款CA账号
        accountvo.setReceiveAccountNo(payment.getReceiveAccountNo());//收款CA账号
        accountvo.setPoolNo(req.getHead().getFund_pool_no()); // 资金池编号
        accountvo.setPayCAFields1(payment.getPaymentAccountExtendField1());//付出CA账务备注1
        accountvo.setPayCAFields2(payment.getPaymentAccountExtendField2());//付出CA账务备注2
        accountvo.setPayCAFields3(payment.getPaymentAccountExtendField3());//付出CA账务备注3
        
        accountvo.setRecCAFields1(payment.getReceiveAccountExtendField1());//收到CA账务备注1
        accountvo.setRecCAFields2(payment.getReceiveAccountExtendField2());//收到CA账务备注2
        accountvo.setRecCAFields3(payment.getReceiveAccountExtendField3());//收到CA账务备注3
        
        // accountvo.setRmk("备注");
        accountvo.setSequenceNo(payment.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(req.getHead().getRequest_code())); // 交易类型0007_001
        accountvo.setTradeNo(payment.getTradeNo()); // 本交易编号
        accountvo.setTradeGmtCreated(payment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(req.getHead().getRequest_code()); // 交易请求类型0007_001_001
        accountvo.setTradeStepNo(reqNo);// 交易请求编号
//        accountvo.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 所属业务冻结交易类型0007_001
//        accountvo.setFrozenTradeNo(payment.getTradeNo()); // 所属业务冻结交易编号
        accountvo.setFrozenTradeCode(""); // 所属业务冻结交易类型0007_001
        accountvo.setFrozenTradeNo(""); // 所属业务冻结交易编号
        accountvo.setAmount(payment.getTransferAmount());
        
		realTimeAccountingRsps= bizAccountService.transfer(accountvo);
		for (Iterator<RealTimeAccountingRsp> it = realTimeAccountingRsps.iterator();it.hasNext();) {
            RealTimeAccountingRsp rsp = it.next();
            if ("F".equals(rsp.getSuccess())) {
                throw new BusinessException(rsp.getRetCode(), rsp.getErrMessage());
            }
        }
	}

	private void updateStatus(TradeRequest<TradePacketReqBodyMerchantTransfer> req) throws Exception {
        //修改交易状态
        payment.setLatestTradeReqType(req.getHead().getRequest_code());   //本次请求类型
        payment.setLatestReqNo(reqNo);   //本次请求编号
        payment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//【未结束】改为【已结束】
        payment.setStatus(TradeConstants.TRADE_TRANSFER_ACCOUNT_SUCCESS);//【创建】改为【转账成功】
        payment.setGmtTransferSuccess(realTimeAccountingRsps.get(0).getAccountingRecord().getGmtCreated());//转账成功日期时间	来自账务成功日期时间
        payment.setGmtLatestModified(new Date());
        payment.setVersion(payment.getVersion());
        transferService.updateStatus(payment);
    }

	@Override
	public void formatValidate(TradeRequest<TradePacketReqBodyMerchantTransfer> tradeRquest) throws Exception {
		String msg = TradeValidationUtil.validateRequest(tradeRquest);
		if (!StringUtils.isEmpty(msg)) {
			throw exceptionService.buildBusinessException("JY00070010011000100", msg);
		}
	}

	protected void checkDuplicate(TradeRequest<TradePacketReqBodyMerchantTransfer> tradeRquest) throws Exception {
		TradeTransferAccountExample tradePaymentExample = new TradeTransferAccountExample();
		tradePaymentExample.createCriteria().andFundPoolNoEqualTo(tradeRquest.getHead().getFund_pool_no()).andOutTradeNoExtEqualTo(tradeRquest.getBody().getOut_trade_no_ext());
		List<TradeTransferAccount> list = transferService.queryExample(tradePaymentExample);
		if (!CollectionUtils.isEmpty(list)) {
			throw exceptionService.buildBusinessException("JY00070010011000300");
		}
	}
	
	protected void existCAPayNo(TradeRequest<TradePacketReqBodyMerchantTransfer> tradeRquest) throws Exception {

		CreditAccount ca = bizAccountService.selectByAccountNo(tradeRquest.getBody().getPayment_account_no());
		if (null == ca) {
			throw exceptionService.buildBusinessException("JY00070010011000400");
		} else {
			payCANo = ca.getMerchantNo();
		}
	}
	
	protected void existCARecNo(TradeRequest<TradePacketReqBodyMerchantTransfer> tradeRquest) throws Exception {
		
		CreditAccount ca = bizAccountService.selectByAccountNo(tradeRquest.getBody().getReceive_account_no());
		if (null == ca) {
			throw exceptionService.buildBusinessException("JY00070010011000500");
		} else {
			recCANo = ca.getMerchantNo();
		}
	}
	
	
	@Override
	public void bizValidate(TradeRequest<TradePacketReqBodyMerchantTransfer> tradeRquest) throws Exception {
		//业务校验
		//1	校验【交易发起方发起请求编号】是否已存在
		checkDuplicate(tradeRquest);
		//2	查询【付出CA账户编号】所属商户编号
		existCAPayNo(tradeRquest);
		//3 查询【收到CA账户编号】所属商户编号
		existCARecNo(tradeRquest);
		
	}


	@Override
	public void tradeCreate(TradeRequest<TradePacketReqBodyMerchantTransfer> tradeRquest) throws Exception {
		//转账记录插入
		tradePaymentCreate(tradeRquest);
		//转账历史插入
		updateTradeChgHis();
	}
	
	protected void tradePaymentCreate(TradeRequest<TradePacketReqBodyMerchantTransfer> tradeRquest) throws Exception {
		TradeTransferAccount payment = new TradeTransferAccount();
		payment.setTradeNo(TradeUtilCommon.getServiceCode(tradeRquest.getHead().getRequest_code()) + idFactoryTradeTransferAccountNo.generate().toString());
		logger.info("trade_no="+payment.getTradeNo());
		payment.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());// 核心商户编号
		payment.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());// 池编号
		payment.setMerchantExtendField1(tradeRquest.getBody().getMerchant_extend_field_1());// 扩展
		payment.setMerchantExtendField2(tradeRquest.getBody().getMerchant_extend_field_2());
		payment.setMerchantExtendField3(tradeRquest.getBody().getMerchant_extend_field_3());
		payment.setMerchantExtendField4(tradeRquest.getBody().getMerchant_extend_field_4());
		payment.setMerchantExtendField5(tradeRquest.getBody().getMerchant_extend_field_5());
		payment.setOutTradeNo(tradeRquest.getBody().getOut_trade_no());// 交易发起方业务系统订单号
		payment.setOutTradeNoExt(tradeRquest.getBody().getOut_trade_no_ext());// 交易发起方发起请求编号
		payment.setGmtCreated(new Date());// 创建时间
		payment.setGmtLatestModified(new Date());// 最后变更时间
		payment.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
		payment.setLatestReqNo(reqNo);// 最后变更交易请求编号
		payment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);// 交易结束状态-未结束
		payment.setPaymentAccountNo(tradeRquest.getBody().getPayment_account_no());// 付出CA账户编号
		payment.setPaymentMerchantNo(payCANo);// 付出CA账户编号所属成员编号
		payment.setPaymentAccountExtendField1(tradeRquest.getBody().getPayment_account_extend_field_1());//付出CA账务备注1
		payment.setPaymentAccountExtendField2(tradeRquest.getBody().getPayment_account_extend_field_2());//付出CA账务备注2
		payment.setPaymentAccountExtendField3(tradeRquest.getBody().getPayment_account_extend_field_3());//付出CA账务备注3
		
		payment.setReceiveAccountNo(tradeRquest.getBody().getReceive_account_no());//收到CA账户编号
		payment.setReceiveMerchantNo(recCANo);//收到成员商户编号
		payment.setReceiveAccountExtendField1(tradeRquest.getBody().getReceive_account_extend_field_1());//收到CA账务备注1
		payment.setReceiveAccountExtendField2(tradeRquest.getBody().getReceive_account_extend_field_2());//收到CA账务备注2
		payment.setReceiveAccountExtendField3(tradeRquest.getBody().getReceive_account_extend_field_3());//收到CA账务备注3
		
		payment.setVersion(TradeConstants.DEFAULT_LOCK_VRESION); // 初始版本为0
		long tradeAmount;
		try {
			tradeAmount = AmountUtils.bizAmountConvertToLong(tradeRquest.getBody().getTransfer_amount());
		} catch (AmountConvertException e) {
			throw exceptionService.buildBusinessException("JY000000000000201");
		}
		payment.setStatus(TradeConstants.TRADE_TRANSFER_ACCOUNT_INIT);// 交易状态-创建
		payment.setTransferAmount(tradeAmount);//转账金额
		transferService.insert(payment);
		this.payment = payment;
		
	}
	
	protected void updateTradeChgHis() throws Exception {
		TradeTransferAccountLog his = new TradeTransferAccountLog();
		// 为了插入version的变更所以需要重新查询交易
		TradeTransferAccount item = transferService.selectByPrimaryKey(payment.getId());
		BeanUtils.copyProperties(item, his);
		his.setId(null);
		tradePaymentLogService.insert(his);
		this.payment = item;
//		throw new RuntimeException("出错了");
	}
	
	@Override
	public void tradeUpdateForFail(TradeRequest<TradePacketReqBodyMerchantTransfer> tradeRquest) throws Exception {
		// 实现更新交易为失败状态
		try {
			updateStatusFail(tradeRquest);// 修改交易记录
			updateTradeChgHis();// 记录交易历史变更
		} catch (Exception e) {
			throw exceptionService.buildBusinessException("JY000000000000801");
		}
	}

	private void updateStatusFail(TradeRequest<TradePacketReqBodyMerchantTransfer> req) throws Exception {
		//修改交易状态
        payment.setLatestTradeReqType(req.getHead().getRequest_code());   //本次请求类型
        payment.setLatestReqNo(reqNo);   //本次请求编号
        payment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//【未结束】改为【已结束】
        payment.setStatus(TradeConstants.TRADE_TRANSFER_ACCOUNT_FAILED);//【创建】改为【转账成功】
        payment.setGmtLatestModified(new Date());
        payment.setGmtCreatedFail(new Date());
//        payment.setVersion(payment.getVersion());
        transferService.updateStatus(payment);
	}


	@Override
	public void setReqNo(String reqNo) {
		this.reqNo=reqNo;
	}

	@Override
	public Object getTradeDetails() {
		return this.payment;
	}

}
