package com.liantuo.trade.bus.template.impl;


import com.liantuo.trade.bus.template.DistributedHandle;
import com.liantuo.trade.bus.template.DistributedHandleInvoke;
import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.exception.BizRuntimeException;
import org.springframework.stereotype.Component;

@Component(value = "distributedHandleInvoker")
public class DistributedHandleInvoker implements DistributedHandleInvoke {
    @Override
    public <R extends TradePacket, T extends ATradeBizVO> void realAccountInvoke(DistributedHandle distributedHandler, R req, T trade) throws BizRuntimeException {
        distributedHandler.doDistTx(req, trade);
    }
}
