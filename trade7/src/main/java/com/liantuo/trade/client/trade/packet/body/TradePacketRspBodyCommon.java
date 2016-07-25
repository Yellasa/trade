package com.liantuo.trade.client.trade.packet.body;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.liantuo.trade.client.trade.packet.TradePacketResultInfo;

public class TradePacketRspBodyCommon extends TradePacketResultInfo {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
