package com.liantuo.trade.client.trade.packet.body;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

/**
 * 0001_001_001
 * 成员冻结 请求VO
 */
public class TradePacketReqBodyMerchantFreeze extends TradeRequestBody {

    @Pattern(message = "out_trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no;

    @NotBlank(message = "out_trade_no_ext is required", groups = {Required.class})
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no_ext;

    @NotBlank(message = "payment_account_no is required", groups = {Required.class})
    @Pattern(message = "payment_account_no format error", regexp = "[\\w]{6,32}", groups = Format.class)
    private String payment_account_no;

    @NotBlank(message = "freeze_amount is required", groups = {Required.class})
    @DecimalMin(message = "freeze_amount format error", groups = {Format.class}, value = "0.00")
    @Digits(message = "freeze_amount format error", groups = {Format.class}, integer = 16, fraction = 2)
    private String freeze_amount;

    @Pattern(message = "merchant_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_1;

    @Pattern(message = "merchant_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_2;

    @Pattern(message = "merchant_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_3;

    @Pattern(message = "merchant_extend_field_4 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_4;

    @Pattern(message = "merchant_extend_field_5 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_5;

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

    public String getOut_trade_no_ext() {
        return out_trade_no_ext;
    }

    public void setOut_trade_no_ext(String out_trade_no_ext) {
        this.out_trade_no_ext = out_trade_no_ext;
    }

    public String getPayment_account_no() {
        return payment_account_no;
    }

    public void setPayment_account_no(String payment_account_no) {
        this.payment_account_no = payment_account_no;
    }

    public String getFreeze_amount() {
        return freeze_amount;
    }

    public void setFreeze_amount(String freeze_amount) {
        this.freeze_amount = freeze_amount;
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

    public String getAvl_bal_decr_field_1() {
        return avl_bal_decr_field_1;
    }

    public void setAvl_bal_decr_field_1(String avl_bal_decr_field_1) {
        this.avl_bal_decr_field_1 = avl_bal_decr_field_1;
    }

    public String getAvl_bal_decr_field_2() {
        return avl_bal_decr_field_2;
    }

    public void setAvl_bal_decr_field_2(String avl_bal_decr_field_2) {
        this.avl_bal_decr_field_2 = avl_bal_decr_field_2;
    }

    public String getAvl_bal_decr_field_3() {
        return avl_bal_decr_field_3;
    }

    public void setAvl_bal_decr_field_3(String avl_bal_decr_field_3) {
        this.avl_bal_decr_field_3 = avl_bal_decr_field_3;
    }

    public String getFro_bal_incr_field_1() {
        return fro_bal_incr_field_1;
    }

    public void setFro_bal_incr_field_1(String fro_bal_incr_field_1) {
        this.fro_bal_incr_field_1 = fro_bal_incr_field_1;
    }

    public String getFro_bal_incr_field_2() {
        return fro_bal_incr_field_2;
    }

    public void setFro_bal_incr_field_2(String fro_bal_incr_field_2) {
        this.fro_bal_incr_field_2 = fro_bal_incr_field_2;
    }

    public String getFro_bal_incr_field_3() {
        return fro_bal_incr_field_3;
    }

    public void setFro_bal_incr_field_3(String fro_bal_incr_field_3) {
        this.fro_bal_incr_field_3 = fro_bal_incr_field_3;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}