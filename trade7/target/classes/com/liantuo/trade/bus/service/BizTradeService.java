package com.liantuo.trade.bus.service;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;

/**
 * 交易创建
 */
public interface BizTradeService<R extends TradePacket, T extends ATradeBizVO> {
    void create(T trade);

    void update(T trade);

    boolean checkDuplicate(R tradePacket);

    /**
     * 这个方法只在0001冻减付系列交易的v1.0版本使用
     */
    T queryOriginalTrade(String originalTradeNo, String fund_pool_no, String core_merchant_no);
    
    T queryOriginalTrade(R tradePacket);
    
}
