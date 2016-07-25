package com.liantuo.trade.bus.vo;

import com.liantuo.trade.orm.pojo.TradePayment;

import java.util.List;

public class TradePageQueryPaymentBizVO extends ATradeFundLegderBizVO {
    public List<TradePayment> getList() {
        return list;
    }

    public void setList(List<TradePayment> list) {
        this.list = list;
    }

    List<TradePayment> list;
}
