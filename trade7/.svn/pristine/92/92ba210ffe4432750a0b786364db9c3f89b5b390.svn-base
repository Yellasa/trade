package com.liantuo.trade.client.trade.packet.body.withdraw;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

/**
 * 成员提现-扣减
 */
public class TradePacketReqBodySingleWithdrawDeduct {

    @NotBlank(message = "out_trade_no_ext is required", groups = {Required.class})
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no_ext; // 交易发起方发起请求编号

    @Pattern(message = "out_trade_no format error", regexp = ".{0}|[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no; // 交易发起方业务系统订单号

    @NotBlank(message = "withdraw_account_no is required", groups = Required.class)
    @Pattern(message = "withdraw_account_no format error", regexp = "[\\w]{6,32}", groups = Format.class)
    private String withdraw_account_no; // 提现CA账户编号

    @NotBlank(message = "withdraw_amount is required", groups = {Required.class})
    @DecimalMin(message = "withdraw_amount format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "withdraw_amount format error", groups = {Format.class}, integer = 16, fraction = 2)
    private String withdraw_amount; // 提现金额

    @Length(message = "merchant_extend_field_1 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_1; // 交易客户保留字段1

    @Length(message = "merchant_extend_field_2 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_2;

    @Length(message = "merchant_extend_field_3 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_3;

    @Length(message = "merchant_extend_field_4 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_4;

    @Length(message = "merchant_extend_field_5 length not match", min = 0, max = 1024, groups = Format.class)
    private String merchant_extend_field_5;

    @Length(message = "reserved_fields1 length not match", min = 0, max = 1024, groups = Format.class)
    private String reserved_fields1; // 提现客户账务历史1

    @Length(message = "reserved_fields2 length not match", min = 0, max = 1024, groups = Format.class)
    private String reserved_fields2;

    @Length(message = "reserved_fields3 length not match", min = 0, max = 1024, groups = Format.class)
    private String reserved_fields3;

    public String getOut_trade_no_ext() {
        return out_trade_no_ext;
    }

    public void setOut_trade_no_ext(String out_trade_no_ext) {
        this.out_trade_no_ext = out_trade_no_ext;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getWithdraw_account_no() {
        return withdraw_account_no;
    }

    public void setWithdraw_account_no(String withdraw_account_no) {
        this.withdraw_account_no = withdraw_account_no;
    }

    public String getWithdraw_amount() {
        return withdraw_amount;
    }

    public void setWithdraw_amount(String withdraw_amount) {
        this.withdraw_amount = withdraw_amount;
    }

    public String getMerchant_extend_field_1() {
        return merchant_extend_field_1;
    }

    public void setMerchant_extend_field_1(String merchant_extend_field_1) {
        this.merchant_extend_field_1 = merchant_extend_field_1;
    }

    public String getMerchant_extend_field_2() {
        return merchant_extend_field_2;
    }

    public void setMerchant_extend_field_2(String merchant_extend_field_2) {
        this.merchant_extend_field_2 = merchant_extend_field_2;
    }

    public String getMerchant_extend_field_3() {
        return merchant_extend_field_3;
    }

    public void setMerchant_extend_field_3(String merchant_extend_field_3) {
        this.merchant_extend_field_3 = merchant_extend_field_3;
    }

    public String getMerchant_extend_field_4() {
        return merchant_extend_field_4;
    }

    public void setMerchant_extend_field_4(String merchant_extend_field_4) {
        this.merchant_extend_field_4 = merchant_extend_field_4;
    }

    public String getMerchant_extend_field_5() {
        return merchant_extend_field_5;
    }

    public void setMerchant_extend_field_5(String merchant_extend_field_5) {
        this.merchant_extend_field_5 = merchant_extend_field_5;
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
