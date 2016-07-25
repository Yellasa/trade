package com.liantuo.trade.client.trade.packet.body;

import com.liantuo.trade.client.trade.packet.TradePacketResultInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 交易列表查询 付款
 * 0001_001_998
 * 0001_001_999
 */
public class TradePacketRspBodyPayPageDetails extends TradePacketResultInfo {

    private String resultCount;

    private String trade_details;

    public String getResultCount() {
        return resultCount;
    }

    public void setResultCount(String resultCount) {
        this.resultCount = resultCount;
    }

    public String getTrade_details() {
        return trade_details;
    }

    public void setTrade_details(String trade_details) {
        this.trade_details = trade_details;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}