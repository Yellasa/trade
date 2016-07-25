package com.liantuo.trade.bus.template.impl;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;


/**
 * 资金类-无台账
 * 参考（暂无）
 */
public abstract class ATradeNoLegderTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeSettleTemp<R, Q, T> {

}