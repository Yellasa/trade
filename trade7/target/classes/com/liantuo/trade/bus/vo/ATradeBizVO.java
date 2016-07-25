package com.liantuo.trade.bus.vo;

import com.liantuo.trade.bus.service.impl.TradeContext;
import com.liantuo.trade.common.util.trade.Context;
import com.liantuo.trade.common.util.trade.ReqContext;

public abstract class ATradeBizVO{
    private Context context;

    private ReqContext reqContext;

    public ReqContext getReqContext() {
        return reqContext;
    }

    public void setReqContext(ReqContext reqContext) {
        this.reqContext = reqContext;
    }

    public ATradeBizVO() {
        this.context = new TradeContext();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}