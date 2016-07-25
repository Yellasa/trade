package com.liantuo.trade.client.trade.packet.body.withdraw;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

/**
 * 成员提现-退回
 */
public class TradePacketReqBodySingleWithdrawDeductRefund {

    @NotBlank(message = "trade_no is required", groups = { Required.class })
    @Pattern(message = "trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String trade_no;

    @Length(message = "reserved_fields1 length not match", min = 0, max = 1024, groups = Format.class)
    private String reserved_fields1;

    @Length(message = "reserved_fields2 length not match", min = 0, max = 1024, groups = Format.class)
    private String reserved_fields2;

    @Length(message = "reserved_fields3 length not match", min = 0, max = 1024, groups = Format.class)
    private String reserved_fields3;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getReserved_fields1() {
        return reserved_fields1;
    }

    public void setReserved_fields1(String reserved_fields1) {
        this.reserved_fields1 = reserved_fields1;
    }

    public String getReserved_fields2() {
        return reserved_fields2;
    }

    public void setReserved_fields2(String reserved_fields2) {
        this.reserved_fields2 = reserved_fields2;
    }

    public String getReserved_fields3() {
        return reserved_fields3;
    }

    public void setReserved_fields3(String reserved_fields3) {
        this.reserved_fields3 = reserved_fields3;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
