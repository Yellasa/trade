package com.liantuo.trade.bus.process.impl.single_payment.asyn_service;

import com.liantuo.payment.client.pay.PaymentNotify;
import com.liantuo.trade.bus.process.TradeState;
import com.liantuo.trade.client.trade.packet.body.TradeNotifyRequestBody;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.orm.pojo.TradeLedger;

public interface AsynNotifyService {
	/**
	 * @Title:parsePaymentNotify 
	 * @Description: 解析并转换数据
	 * @param notify
	 * @return:TradeNotifyRequestBody
	 * @author:zoran.huang
	 * @date:2016年7月11日 下午5:38:10
	 */
	public TradeNotifyRequestBody parsePaymentNotify(PaymentNotify notify) throws Exception;
	
	public String getThirdOutTradeNo(TradeRequestBody body) throws Exception ; 
	
	public long getThirdReceiveAmount(TradeRequestBody body) throws Exception;
	
	public TradeState getTradePaymentStatus(TradeNotifyRequestBody tradeRquest) throws Exception;
	public void prepareEffectLedger(TradeRequestBody body,TradeLedger ledger) ;
	public void prepareFailureLedger(TradeRequestBody body,TradeLedger ledger) ;
}
