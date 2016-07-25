package com.liantuo.trade.bus.process;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.util.trade.ReqContext;

public interface Process {
    TradePacket processHandle(String xml, ReqContext reqContext) throws Exception;
}
