package com.liantuo.trade.bus.process;

import com.liantuo.trade.client.trade.packet.NotifyRspPacket;
import com.liantuo.trade.common.util.trade.NotifyReqContext;

public interface NotifyProcess {

    NotifyRspPacket processHandle(String xml, NotifyReqContext reqContext) throws Exception;
    
}
