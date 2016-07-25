package com.liantuo.trade.bus.service;

import com.liantuo.trade.client.trade.packet.TradePacket;

import java.util.List;

/**
 * 交易明细分页查询
 */
public interface TradeDetailsPageQueryService<T extends TradePacket> {
    List<T> query(T tradePacket) throws Exception;
}