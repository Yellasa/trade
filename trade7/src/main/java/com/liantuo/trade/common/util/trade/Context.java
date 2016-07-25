package com.liantuo.trade.common.util.trade;

public interface Context {
    Object get(String key);
    void put(String key, Object obj);
}

