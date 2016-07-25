package com.liantuo.trade.bus.template;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.util.trade.ReqContext;

/**
 * 交易模板执行
 */
public interface Execute<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> {
    Q execute(R tradePacket, ReqContext reqContext);
}
