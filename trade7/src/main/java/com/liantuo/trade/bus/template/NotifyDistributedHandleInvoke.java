package com.liantuo.trade.bus.template;

import com.liantuo.trade.bus.vo.ANotifyBizVo;
import com.liantuo.trade.client.trade.packet.NotifyPacket;
import com.liantuo.trade.exception.BizRuntimeException;


/**
 */
public interface NotifyDistributedHandleInvoke {

    <R extends NotifyPacket, T extends ANotifyBizVo> void realAccountInvoke(NotifyDistributedHandle distributedHandler, R req, T trade) throws BizRuntimeException;
    
}
