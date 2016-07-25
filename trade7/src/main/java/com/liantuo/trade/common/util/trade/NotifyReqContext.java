package com.liantuo.trade.common.util.trade;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.liantuo.trade.client.trade.packet.head.NotifyPacketHead;
import com.liantuo.trade.orm.pojo.TradeNotifyPaymentLog;

public class NotifyReqContext implements Context {
    
    private TradeNotifyPaymentLog req;
    
    private NotifyPacketHead busHead;

    public TradeNotifyPaymentLog getReq() {
        return req;
    }

    public void setReq(TradeNotifyPaymentLog req) {
        this.req = req;
    }

    @SuppressWarnings("unchecked")
    public NotifyReqContext() {
        this.map = new HashedMap();
    }

    private Map<String, Object> map;

    @Override
    public Object get(String key) {
        return map.get(key);
    }

    @Override
    public void put(String key, Object obj) {
        map.put(key, obj);
    }

    public NotifyPacketHead getBusHead() {
        return busHead;
    }
    
    public void setBusHead(NotifyPacketHead busHead) {
        this.busHead = busHead;
    }
    
}
