package com.liantuo.trade.bus.service;

import com.liantuo.trade.bus.vo.ANotifyBizVo;
import com.liantuo.trade.client.trade.packet.NotifyPacket;


/**
 * 回调通知的交易修改服务
 */
public interface NotifyTradeService<R extends NotifyPacket, T extends ANotifyBizVo<?>> {

    /**
     * 查询原交易
     * @param notifyPacket
     * @return ANotifyBizVo<原交易>
     */
    <V> V queryOriginalTrade(R notifyPacket);
    
    /**
     * 交易成功
     * @param notifyPacket
     * @param bizVo
     */
    void updateToSuccess(R notifyPacket, T bizVo);

    /**
     * 交易失败
     * @param notifyPacket
     * @param bizVo
     */
    void updateToFailed(R notifyPacket, T bizVo);
    
}
