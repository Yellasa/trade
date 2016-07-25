package com.liantuo.trade.bus.template;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.exception.BizRuntimeException;

/**
 * 分布式业务处理，需要回滚
 */
public interface DistributedHandle<R extends TradePacket, T extends ATradeBizVO> {
    void doDistTx(R tradePacket, T trade) throws BizRuntimeException;
}