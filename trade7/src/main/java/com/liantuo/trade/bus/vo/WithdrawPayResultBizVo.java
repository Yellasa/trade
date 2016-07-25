package com.liantuo.trade.bus.vo;

import com.payment.client.pay.vo1.BusTransactionRspPayNotify;

public class WithdrawPayResultBizVo extends WithdrawDeductBizVo {

    private BusTransactionRspPayNotify payNotify;
    
    private WithdrawNotifyPayInfoVo payInfo;
    
    public WithdrawNotifyPayInfoVo getPayInfo() {
        return payInfo;
    }
    
    public void setPayInfo(WithdrawNotifyPayInfoVo payInfo) {
        this.payInfo = payInfo;
    }

    public BusTransactionRspPayNotify getPayNotify() {
        return payNotify;
    }

    public void setPayNotify(BusTransactionRspPayNotify payNotify) {
        this.payNotify = payNotify;
    }

}
