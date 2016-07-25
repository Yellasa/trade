package com.liantuo.trade.bus.service;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.orm.pojo.TradeLedger;

/**
 * 台账服务
 */
public interface BizLegderService<R extends TradePacket, T extends ATradeBizVO> {
    void create(R tradePacket, T trade);
    
//    void createEffectiveLegder(TradeLedger tradeledger);
}