package com.liantuo.trade.common.util.trade;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.orm.pojo.TradeReqLog;

public class ReqContext implements Context {
    private TradeReqLog req;
    
    private TradePacketHead busHead;

    public TradeReqLog getReq() {
        return req;
    }

    public void setReq(TradeReqLog req) {
        this.req = req;
    }

    @SuppressWarnings("unchecked")
    public ReqContext() {
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

    public TradePacketHead getBusHead() {
        return busHead;
    }
    
    public void setBusHead(TradePacketHead busHead) {
        this.busHead = busHead;
    }
    
}
