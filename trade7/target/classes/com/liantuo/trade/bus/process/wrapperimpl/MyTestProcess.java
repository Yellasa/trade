package com.liantuo.trade.bus.process.wrapperimpl;

import com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateSingleTxNoPaymentTemp;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.TradePacketReqBodyInnerRefund;
import com.liantuo.trade.orm.pojo.subvo.TradeSinglePaymentRefundVo;
import com.liantuo.trade.spring.annotation.JobFlow;

/**
 * @author yangting
 *2016年6月6日 上午9:51:38
 */
@JobFlow(value = "111_111_111", version = "1.1", template = ATradeCreateSingleTxNoPaymentTemp.class)
public class MyTestProcess implements TradeCreateSingleTxNoPaymentInterface<TradePacketReqBodyInnerRefund> {


	@Override
	public void transaction(TradeRequest<TradePacketReqBodyInnerRefund> tradeRquest) throws Exception {
		System.out.println("111_111_111:1.1 ---->>> transaction");
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
		TradeSinglePaymentRefundVo vo = new TradeSinglePaymentRefundVo();
		vo.setMerchantExtendField1("1234");
		vo.setMerchantExtendField2("4321");
		return vo;
	}
	
	
}
