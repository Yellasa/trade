package com.liantuo.trade.bus.vo;

import com.liantuo.trade.orm.pojo.TradeRefund;

import java.util.List;

public class TradePageQueryRefundBizVO extends ATradeFundLegderBizVO {
    public List<TradeRefund> getList() {
        return list;
    }

    public void setList(List<TradeRefund> list) {
        this.list = list;
    }

    List<TradeRefund> list;
}
