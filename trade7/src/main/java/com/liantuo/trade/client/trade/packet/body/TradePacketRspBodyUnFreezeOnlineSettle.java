package com.liantuo.trade.client.trade.packet.body;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.liantuo.trade.client.trade.packet.TradePacketResultInfo;

/**
 * CA付款成功,剩余解冻
 */
public class TradePacketRspBodyUnFreezeOnlineSettle extends TradePacketResultInfo {
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
