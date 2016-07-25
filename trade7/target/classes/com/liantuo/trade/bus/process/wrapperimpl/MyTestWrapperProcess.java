package com.liantuo.trade.bus.process.wrapperimpl;

import com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateSingleTxNoPaymentTemp;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.TradePacketReqBodyInnerRefund;
import com.liantuo.trade.spring.SpringUtils;
import com.liantuo.trade.spring.annotation.JobFlow;

/**
 * @author yangting
 *2016年6月6日 上午9:51:38
 */
@JobFlow(value = "111_111_111", version = "1.0",template=ATradeCreateSingleTxNoPaymentTemp.class)
public class MyTestWrapperProcess implements TradeCreateSingleTxNoPaymentInterface<TradePacketReqBodyInnerRefund>{

	private Object bean;
	
	@Override
	public void transaction(TradeRequest<TradePacketReqBodyInnerRefund> tradeRquest) throws Exception {
		String process =  getProcess(tradeRquest);
		if(process.equals("123456")){
			MyTestProcess bean =(MyTestProcess) SpringUtils.getBean("111_111_111:1.1");
			this.bean = bean;
			bean.transaction(tradeRquest);
		}
	}

	@Override
	public void formatValidate(TradeRequest<TradePacketReqBodyInnerRefund> tradeRquest) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bizValidate(TradeRequest<TradePacketReqBodyInnerRefund> tradeRquest) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tradeCreate(TradeRequest<TradePacketReqBodyInnerRefund> tradeRquest) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tradeUpdateForFail(TradeRequest<TradePacketReqBodyInnerRefund> tradeRquest) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReqNo(String reqNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getTradeDetails() {
		MyTestProcess process = (MyTestProcess) bean;
		return process.getTradeDetails();
	}
	
	private String getProcess(TradeRequest<TradePacketReqBodyInnerRefund> tradeRquest){
		String merchant_extend_field_1 = tradeRquest.getBody().getMerchant_extend_field_1();
		return merchant_extend_field_1;
	}

}
