package com.liantuo.trade.bus.vo;

import com.liantuo.trade.orm.pojo.TradePayment;

public class TradePaymentBizVO extends ATradeFundLegderBizVO {
    private TradePayment payment;

    public TradePaymentBizVO() {
        super();
    }

    public TradePayment getPayment() {
        return payment;
    }

    public void setPayment(TradePayment payment) {
        this.payment = payment;
    }
}
