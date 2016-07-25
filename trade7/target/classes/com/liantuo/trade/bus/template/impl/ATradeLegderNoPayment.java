package com.liantuo.trade.bus.template.impl;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;

/**
 * 资金类-有台账-无清算
 */
public abstract class ATradeLegderNoPayment<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeLegderTemp<R, Q, T> {

}