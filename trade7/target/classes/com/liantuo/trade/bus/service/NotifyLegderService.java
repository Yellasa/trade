package com.liantuo.trade.bus.service;

import com.liantuo.trade.bus.vo.ANotifyBizVo;
import com.liantuo.trade.client.trade.packet.NotifyPacket;
import com.liantuo.trade.orm.pojo.TradeLedger;


/**
 * 回调通知的台帐服务
 */
public interface NotifyLegderService <R extends NotifyPacket, T extends ANotifyBizVo<?>> {

    /**
     * 生效台帐
     * @param notifyPacket
     * @param bizVo
     */
    TradeLedger updateToEffect(R notifyPacket, T bizVo);
    
    /**
     * 失败台帐
     * @param notifyPacket
     * @param bizVo
     */
    TradeLedger updateToField(R notifyPacket, T bizVo);
    
}
