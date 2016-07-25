package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.trade.bus.process.TradeModSingleTxNoPaymentInterface;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.template.impl.v1_1.mod.ATradeModSingleTxNoPaymentTemp;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyModTradePaymentInfo;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;
import com.liantuo.trade.orm.pojo.TradePaymentLog;
import com.liantuo.trade.orm.service.TradePaymentLogService;
import com.liantuo.trade.orm.service.TradePaymentService;
import com.liantuo.trade.spring.annotation.JobFlow;

/**
 * 
* @ClassName: ModTradePaymentInfoProcess 
* @Description:  TradePayment交易记录修改
* @author JiangKun
* @date 2016年6月20日 下午5:46:31 
*
 */
@JobFlow(value = "0001_001_997", version = "1.0", template = ATradeModSingleTxNoPaymentTemp.class)
public class ModTradePaymentInfoProcess implements TradeModSingleTxNoPaymentInterface<TradePacketReqBodyModTradePaymentInfo> {
    private static Logger logger = LoggerFactory.getLogger(ModTradePaymentInfoProcess.class);
    @Autowired
    private ExceptionService exceptionService;
    @Resource(name = "tradePaymentService")
    private TradePaymentService tradePaymentService;
	@Resource(name = "tradePaymentLogService")
	private TradePaymentLogService tradePaymentLogService;
	
	private String reqNo;//请求编号
	private TradePayment payment;//当前交易
	/**
	 * 入参格式校验
	 */
    @Override
    public void formatValidate(TradeRequest<TradePacketReqBodyModTradePaymentInfo> tradeRequest)throws Exception {
		 String msg = TradeValidationUtil.validateRequestWeak(tradeRequest);
	        if (!StringUtils.isEmpty(msg)) {
	            logger.info("-->输入参数校验不通过：" + msg);
	            throw exceptionService.buildBusinessException("JY00010019971000100", msg);
	        }
	        //【交易编号】和【交易发起方发起请求编号】不能同时为空
	        if(StringUtils.isEmpty(tradeRequest.getBody().getOut_trade_no_ext())
	        		&&StringUtils.isEmpty(tradeRequest.getBody().getTrade_no())){
	        	logger.info("-->【交易编号】和【交易发起方发起请求编号】不能同时为空");
	        	throw exceptionService.buildBusinessException("JY00010019971000100", "【交易编号】和【交易发起方发起请求编号】不能同时为空");
	        }
    }
    /**
     * 参数正确性校验
     */
    @Override
    public void bizValidate(
    		TradeRequest<TradePacketReqBodyModTradePaymentInfo> tradeRequest)
    				throws Exception {
    	TradePaymentExample tradePaymentExample = new TradePaymentExample();
    	if(!StringUtils.isEmpty(tradeRequest.getBody().getTrade_no())){
    		tradePaymentExample.createCriteria().andTradeNoEqualTo(tradeRequest.getBody().getTrade_no());			
    	}
    	if(!StringUtils.isEmpty(tradeRequest.getBody().getOut_trade_no_ext())){
    		tradePaymentExample.createCriteria().andOutTradeNoExtEqualTo(tradeRequest.getBody().getOut_trade_no_ext());			
    	}
    	List<TradePayment> list = tradePaymentService.queryExample(tradePaymentExample);
    	if(CollectionUtils.isEmpty(list)){
    		logger.info("-->交易编号或交易发起方发起请求编号有误");
    		throw exceptionService.buildBusinessException("JY00010019971000300");
    	}else{
    		payment = list.get(0);
    	}
    }
    
    /**
     * 执行事务，更新交易
     */
	@Override
	public void transaction(
			TradeRequest<TradePacketReqBodyModTradePaymentInfo> tradeRequest)
			throws Exception {
		updateTrade(tradeRequest);
	}
	
	/**
	 * 
	 * @Description: 
	 * @author JiangKun
	 * @date 2016年6月20日 下午5:46:24
	 */
	private void updateTrade(TradeRequest<TradePacketReqBodyModTradePaymentInfo> tradeRequest) {
		try {
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_1())){
				payment.setMerchantExtendField1(tradeRequest.getBody().getMerchant_extend_field_1());//交易客户保留字段1				
			}
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_2())){
				payment.setMerchantExtendField2(tradeRequest.getBody().getMerchant_extend_field_2());//交易客户保留字段2				
			}
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_3())){
				payment.setMerchantExtendField3(tradeRequest.getBody().getMerchant_extend_field_3());//交易客户保留字段3				
			}
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_4())){
				payment.setMerchantExtendField4(tradeRequest.getBody().getMerchant_extend_field_4());//交易客户保留字段4			
			}
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_5())){
				payment.setMerchantExtendField5(tradeRequest.getBody().getMerchant_extend_field_5());//交易客户保留字段1				
			}
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_6())){
				payment.setMerchantExtendField6(tradeRequest.getBody().getMerchant_extend_field_6());//交易客户保留字段1				
			}
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_7())){
				payment.setMerchantExtendField7(tradeRequest.getBody().getMerchant_extend_field_7());//交易客户保留字段1				
			}
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_8())){
				payment.setMerchantExtendField8(tradeRequest.getBody().getMerchant_extend_field_8());//交易客户保留字段1				
			}
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_9())){
				payment.setMerchantExtendField9(tradeRequest.getBody().getMerchant_extend_field_9());//交易客户保留字段1				
			}
			if(!StringUtils.isEmpty(tradeRequest.getBody().getMerchant_extend_field_10())){
				payment.setMerchantExtendField10(tradeRequest.getBody().getMerchant_extend_field_10());//交易客户保留字段1				
			}
			payment.setLatestTradeReqType(tradeRequest.getHead().getRequest_code());
			tradePaymentService.updateTradePayment(payment);
			//日志表插入记录
			updateTradeChgHis();
		} catch (Exception e) {
            e.printStackTrace();
            logger.error("-->交易记录修改失败" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00010019971000400");
		}
	}
	
	/**
	 * 交易日志表插入记录
	 */
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
		return this.payment;
	}
	
}
