package com.liantuo.trade.bus.process;

import com.liantuo.payment.client.pay.PaymentResponse;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.exception.BusinessException;

public interface ATradeQueryHasPaymentInterface<B  extends TradeRequestBody> {
	boolean validate(TradeRequest<B> tradeRquest) throws Exception;
//	public TradeState queryTradeStatus(TradeRequest<B> tradeRquest) throws Exception;
//	public TradeState requestPayment(TradeRequest<B> tradeRquest) throws Exception;
	PaymentResponse requestPayment() throws Exception;
	TradeState parseObj(PaymentResponse obj) throws Exception;
	void transactionReceipt(TradeRequest<B> tradeRquest) throws Exception;
	void transactionEntry(TradeRequest<B> tradeRquest) throws Exception;
	void transactionFailure(TradeRequest<B> tradeRquest) throws Exception;
	void setReqNo(String reqNo);
	
	Object getTradeDetails();
	String createPaymentRequest();
	
	String getResponseXml();
	
	BusinessException getException();
}
