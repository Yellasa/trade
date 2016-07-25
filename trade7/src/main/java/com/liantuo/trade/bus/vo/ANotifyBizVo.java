package com.liantuo.trade.bus.vo;

import com.liantuo.trade.common.util.trade.NotifyReqContext;

/**
 */
public class ANotifyBizVo<T> {

    private T trade;

    private NotifyReqContext reqContext;

    private ANotifyPayInfoVo payInfo;

    public void setTrade(T trade) {
        this.trade = trade;
    }

    public T getTrade() {
        return trade;
    }

    public NotifyReqContext getReqContext() {
        return reqContext;
    }

    public void setReqContext(NotifyReqContext reqContext) {
        this.reqContext = reqContext;
    }

    public ANotifyPayInfoVo getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(ANotifyPayInfoVo payInfo) {
        this.payInfo = payInfo;
    }

}
