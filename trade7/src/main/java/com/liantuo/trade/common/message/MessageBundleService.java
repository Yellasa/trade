package com.liantuo.trade.common.message;

public interface MessageBundleService {
    String getMessage(String key, Object[] param);
    String getCode(String key);
    void setRequestCode(String reqCode);
}
