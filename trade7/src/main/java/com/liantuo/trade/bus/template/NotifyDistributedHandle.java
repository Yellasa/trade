package com.liantuo.trade.bus.template;

import com.liantuo.trade.bus.vo.ANotifyBizVo;
import com.liantuo.trade.client.trade.packet.NotifyPacket;
import com.liantuo.trade.exception.BizRuntimeException;


/**
 * 
 * @作者 Jimmy
 * @日期 2016年1月12日 下午12:48:54
 * @最后修改人
 * @修改时间
 * @复审人 
 */
public interface NotifyDistributedHandle <R extends NotifyPacket, T extends ANotifyBizVo<?>> {

    void doDistTx(R notifyPacket, T bizVo) throws BizRuntimeException;
    
}
