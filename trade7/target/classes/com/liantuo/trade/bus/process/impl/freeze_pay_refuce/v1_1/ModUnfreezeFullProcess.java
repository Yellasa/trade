/**
 * 
 */
package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1_1;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.trade.bus.process.TradeModSingleTxNoPaymentInterface;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.template.impl.v1_1.mod.ATradeModSingleTxNoPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyFullUnFreeze;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;
import com.liantuo.trade.orm.pojo.TradePaymentLog;
import com.liantuo.trade.orm.service.TradePaymentLogService;
import com.liantuo.trade.orm.service.TradePaymentService;
import com.liantuo.trade.spring.annotation.JobFlow;

/**
 * @ClassName:     ModUnfreezeFullProcess.java
 * @Description:   全额解冻 
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.1  
 * @Date           2016-3-11 下午3:17:50 
 */
@JobFlow(value = "0001_001_003", version = "1.1", template = ATradeModSingleTxNoPaymentTemp.class)
public class ModUnfreezeFullProcess implements TradeModSingleTxNoPaymentInterface<TradePacketReqBodyFullUnFreeze> {

	private final Logger logger = LoggerFactory.getLogger(ModUnfreezeFullProcess.class);
	
	@Resource(name = "tradePaymentService")
    private TradePaymentService tradePaymentService;

    @SuppressWarnings("rawtypes")
    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService bizAccountService;

    @Resource(name = "tradePaymentLogService")
    private TradePaymentLogService tradePaymentLogService;

    @Autowired
	private ExceptionService exceptionService;
    private TradePayment payment; // 存放交易数据 
    
    private List<RealTimeAccountingRsp> realTimeAccountingRsps; // 存放账务结果数据 
	
    private String reqNo;
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.template.impl1.ATradePaymentModTemp#formatValidate(com.liantuo.trade.client.trade.packet.TradeRequest)
	 */
	@Override
	public void formatValidate(TradeRequest<TradePacketReqBodyFullUnFreeze> tradeRquest) throws Exception {
		String msg = TradeValidationUtil.validateRequest(tradeRquest);
		if (!StringUtils.isEmpty(msg)) {
			throw exceptionService.buildBusinessException("JY00010010031100100", msg);
		}
	}

	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.template.impl1.ATradePaymentModTemp#bizValidate(com.liantuo.trade.client.trade.packet.TradeRequest)
	 */
	@Override
	public void bizValidate(TradeRequest<TradePacketReqBodyFullUnFreeze> tradeRquest) throws Exception {
		// 校验原交易编号与资金池是否一致
		TradePayment payment = validateOriginalTrade(tradeRquest);
        if (!TradeConstants.TRADE_STATUS_FREEZE.equals(payment.getStatus())) {//状态校验
        	throw exceptionService.buildBusinessException("JY00010010031100400");
        }
	}
	
	private TradePayment validateOriginalTrade(TradeRequest<TradePacketReqBodyFullUnFreeze> tradeRquest) throws Exception {
        // 校验原交易编号与资金池是否一致
        TradePaymentExample example = new TradePaymentExample();
        example.createCriteria().andTradeNoEqualTo(tradeRquest.getBody().getTrade_no())
                .andFundPoolNoEqualTo(tradeRquest.getHead().getFund_pool_no())
                .andCoreMerchantNoEqualTo(tradeRquest.getHead().getCore_merchant_no());
        List<TradePayment> list = (List<TradePayment>) tradePaymentService.queryExample(example);
        if (CollectionUtils.isEmpty(list)) {
            // 原交易不存在
        	throw exceptionService.buildBusinessException("JY00010010031100300");
        } else {
            payment = list.get(0);
            return payment;
        }
    }
	
	/* (non-Javadoc)
	 * @see com.liantuo.trade.bus.template.impl1.ATradePaymentModTemp#transaction(com.liantuo.trade.client.trade.packet.TradeRequest)
	 */
	@Override
	public void transaction(TradeRequest<TradePacketReqBodyFullUnFreeze> tradeRquest) throws Exception {
		unfreezeOp(tradeRquest);// 执行账务冻结
		try {
			updateStatus(tradeRquest);// 修改交易记录
			updateTradeChgHis();// 记录交易历史变更
		} catch (Exception e) {
			throw exceptionService.buildBusinessException("JY000000000000801");
		}
		
	}

	protected void unfreezeOp(TradeRequest<TradePacketReqBodyFullUnFreeze> tradeRquest) throws Exception {
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
	protected List<RealTimeAccountingRsp> account(TradeRequest<TradePacketReqBodyFullUnFreeze> tradeRquest) throws Exception {
		List<RealTimeAccountingRsp> realTimeAccountingRsps;
		RealTimeAccountVO fullUnFreezeAccountParam = new RealTimeAccountVO(); // 全额解冻记账参数

        fullUnFreezeAccountParam.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());////核心商户编号
        fullUnFreezeAccountParam.setPoolNo(tradeRquest.getHead().getFund_pool_no());//资金池编号
        fullUnFreezeAccountParam.setPayAccountNo(payment.getPaymentAccountNo());//付款账号
        fullUnFreezeAccountParam.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code()));//交易类型0001_001
        fullUnFreezeAccountParam.setTradeNo(payment.getTradeNo());//本交易编号
        fullUnFreezeAccountParam.setTradeGmtCreated(payment.getGmtCreated());//本交易创建时间
        fullUnFreezeAccountParam.setTradeReqCode(tradeRquest.getHead().getRequest_code());//交易请求类型0001_001_003
        fullUnFreezeAccountParam.setTradeStepNo(reqNo);//交易请求编号
        if(!StringUtils.isEmpty(payment.getOutTradeNo())){
        	fullUnFreezeAccountParam.setSequenceNo(payment.getOutTradeNo());//本交易业务系统订单号
        }
        fullUnFreezeAccountParam.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code()));//所属业务冻结交易类型0001_001
        fullUnFreezeAccountParam.setFrozenTradeNo(payment.getTradeNo());//所属业务冻结交易编号
        fullUnFreezeAccountParam.setFreezeAmount(payment.getFreezeAmount());//解冻金额
        
        fullUnFreezeAccountParam.setFro_bal_decr_field_1(tradeRquest.getBody().getFro_bal_decr_field_1());//冻结余额减少客户账务历史1
        fullUnFreezeAccountParam.setFro_bal_decr_field_2(tradeRquest.getBody().getFro_bal_decr_field_2());//冻结余额减少客户账务历史2
        fullUnFreezeAccountParam.setFro_bal_decr_field_3(tradeRquest.getBody().getFro_bal_decr_field_3());//冻结余额减少客户账务历史3
        fullUnFreezeAccountParam.setAvl_bal_incr_field_1(tradeRquest.getBody().getAvl_bal_incr_field_1());//可用余额增加客户账务历史1
        fullUnFreezeAccountParam.setAvl_bal_incr_field_2(tradeRquest.getBody().getAvl_bal_incr_field_2());//可用余额增加客户账务历史2
        fullUnFreezeAccountParam.setAvl_bal_incr_field_3(tradeRquest.getBody().getAvl_bal_incr_field_3());//可用余额增加客户账务历史3

        realTimeAccountingRsps = bizAccountService.fullUnFreeze(fullUnFreezeAccountParam);
        this.realTimeAccountingRsps = realTimeAccountingRsps;
		return realTimeAccountingRsps;
	}

	protected void updateStatus(TradeRequest<TradePacketReqBodyFullUnFreeze> tradeRquest) {
		payment.setLatestReqNo(reqNo);// 最后变更交易请求编号
		payment.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
		payment.setGmtUnfreeze(realTimeAccountingRsps.get(0).getAccountingRecord().getGmtCreated());// 解冻时间，由账务来
		payment.setStatus(TradeConstants.TRADE_STATUS_UNFREEZE_SUCCESS);// 解冻成功
		payment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//交易结束状态-已结束
		tradePaymentService.updateTradePayment(payment);
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

	@Override
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
		
	}

	@Override
	public Object getTradeDetails() {
		return payment;
	}

}
