package com.liantuo.trade.bus.service.impl;

import com.liantuo.trade.common.util.trade.Context;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

public class TradeContext implements Context {
    private Map<String, Object> context = new HashedMap();

    @Override
    public Object get(String key) {
        return context.get(key);
    }

    @Override
    public void put(String key, Object obj) {
        context.put(key, obj);
    }
}
