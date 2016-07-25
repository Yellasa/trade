package com.liantuo.trade.client.trade.packet.body.withdraw;

import com.liantuo.trade.client.trade.packet.TradePacketResultInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 成员提现-出款
 */
public class TradePacketRspBodySingleWithdrawPay extends TradePacketResultInfo {
    private String trade_details;

    public String getTrade_details() {
        return trade_details;
    }

    public void setTrade_details(String tradeDetails) {
        trade_details = tradeDetails;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
