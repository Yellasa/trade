package com.liantuo.trade.bus.template;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.exception.BizRuntimeException;

public interface DistributedHandleInvoke {
    <R extends TradePacket, T extends ATradeBizVO> void realAccountInvoke(DistributedHandle distributedHandler, R req, T trade) throws BizRuntimeException;
}