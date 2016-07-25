package com.liantuo.trade.bus.service;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.payment.client.pay.BusTransaction;

public interface BizPaymentCenterService <R extends TradePacket, T extends ATradeBizVO> {
	BusTransaction paymentRequest(R tradePacket, T trade);
}