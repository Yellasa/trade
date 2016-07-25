package com.liantuo.trade.bus.vo;

import com.liantuo.trade.orm.pojo.TradeWithdraw;

/**
 * 提现-冻结业务vo
 */
public class WithdrawDeductBizVo extends ATradeFundLegderBizVO {

    private TradeWithdraw tradeWithdraw;

    public TradeWithdraw getTradeWithdraw() {
        return tradeWithdraw;
    }

    public void setTradeWithdraw(TradeWithdraw tradeWithdraw) {
        this.tradeWithdraw = tradeWithdraw;
    }

}
