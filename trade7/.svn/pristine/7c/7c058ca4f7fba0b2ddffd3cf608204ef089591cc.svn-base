package com.liantuo.trade.bus.template.impl;

import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.template.NotifyDistributedHandle;
import com.liantuo.trade.bus.template.NotifyDistributedHandleInvoke;
import com.liantuo.trade.bus.vo.ANotifyBizVo;
import com.liantuo.trade.client.trade.packet.NotifyPacket;
import com.liantuo.trade.exception.BizRuntimeException;


/**
 */
@Component(value = "notifyDistributedHandleInvoker")
public class NotifyDistributedHandleInvoker implements NotifyDistributedHandleInvoke{

    @SuppressWarnings("unchecked")
    @Override
    public <R extends NotifyPacket, T extends ANotifyBizVo> void realAccountInvoke(NotifyDistributedHandle distributedHandler, R req, T trade) throws BizRuntimeException {
        distributedHandler.doDistTx(req, trade);
    }

}
