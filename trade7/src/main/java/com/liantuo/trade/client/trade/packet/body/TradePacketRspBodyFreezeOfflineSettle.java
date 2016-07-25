package com.liantuo.trade.client.trade.packet.body;

import com.liantuo.trade.client.trade.packet.TradePacketResultInfo;
import com.liantuo.trade.common.validate.Format;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Pattern;

/**
 * 线下付款成功,剩余解冻
 * 0001_001_002
 */
public class TradePacketRspBodyFreezeOfflineSettle extends TradePacketResultInfo {
    private String trade_details;
    /**
     * 可用余额减少客户账务历史
     */
    @Pattern(message = "avl_bal_decr_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_decr_field_1;
    @Pattern(message = "avl_bal_decr_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_decr_field_2;
    @Pattern(message = "avl_bal_decr_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_decr_field_3;
    /**
     * 冻结余额增加客户账务历史
     */
    @Pattern(message = "fro_bal_incr_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_incr_field_1;
    @Pattern(message = "fro_bal_incr_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_incr_field_2;
    @Pattern(message = "fro_bal_incr_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_incr_field_3;
    /**
     * 冻结余额减少客户账务历史
     */
    @Pattern(message = "fro_bal_decr_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_decr_field_1;
    @Pattern(message = "fro_bal_decr_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_decr_field_2;
    @Pattern(message = "fro_bal_decr_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_decr_field_3;

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
