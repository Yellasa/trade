package com.liantuo.trade.client.trade.packet.body;

import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 线下付款退回 请求VO
 * 0002_001_001
 */
public class TradePacketReqBodyRefundOfflineSettle extends TradeRequestBody {

    /**
     * 参数名：交易发起方业务系统订单号</br>
     * 参数类型：必填</br>
     */
    @Pattern(message = "out_trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no;

    /**
     * 参数名：交易发起方发起请求编号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "out_trade_no_ext is required", groups = {Required.class})
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no_ext;

    /**
     * 参数名：原交易编号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "original_trade_no is required", groups = {Required.class})
    @Pattern(message = "original_trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String original_trade_no;

    /**
     * 参数名：付款渠道订单号</br>
     * 参数类型：必填</br>
     */ 
    @NotBlank(message = "third_trade_no is required", groups = {Required.class})
    @Pattern(message = "third_trade_no format error", regexp = "[\\w]{1,128}", groups = Format.class)
    private String third_trade_no;

    /**
     * 参数名：交易客户保留字段1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_1;

    /**
     * 参数名：交易客户保留字段2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_2;

    /**
     * 参数名：交易客户保留字段3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_3;

    /**
     * 参数名：交易客户保留字段4</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_4 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_4;

    /**
     * 参数名：交易客户保留字段5</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_5 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_5;

    /**
     * 参数名：付款渠道退回日期时间</br>
     * 参数类型：必填</br>
     */
    @NotNull(message="gmt_refund_clear_channel is required", groups={Required.class})
    @Pattern(message="gmt_refund_clear_channel format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    private String gmt_refund_clear_channel;

    /**
     * 参数名：付款渠道退回金额</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "clear_refund_amount is required", groups = {Required.class})
    @DecimalMin(message = "clear_refund_amount format error", groups = {Format.class}, value = "0.00")
    @Digits(message = "clear_refund_amount format error", groups = {Format.class}, integer = 16, fraction = 2)
    private String clear_refund_amount;

    /**
     * 参数名：收付款属性1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_1;

    /**
     * 参数名：收付款属性2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_2;

    /**
     * 参数名：收付款属性3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_3;

    /**
     * 参数名：收付款属性4</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_4;

    /**
     * 参数名：收付款属性5</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_5 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_5;

    /**
     * 参数名：收付款属性6</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_6 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_6;

    /**
     * 可用余额增加客户账务历史
     */
    @Pattern(message = "avl_bal_incr_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_incr_field_1;
    @Pattern(message = "avl_bal_incr_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_incr_field_2;
    @Pattern(message = "avl_bal_incr_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_incr_field_3;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String outTradeNo) {
        out_trade_no = outTradeNo;
    }

    public String getOut_trade_no_ext() {
        return out_trade_no_ext;
    }

    public void setOut_trade_no_ext(String outTradeNoExt) {
        out_trade_no_ext = outTradeNoExt;
    }

    public String getOriginal_trade_no() {
        return original_trade_no;
    }

    public void setOriginal_trade_no(String originalTradeNo) {
        original_trade_no = originalTradeNo;
    }

    public String getThird_trade_no() {
        return third_trade_no;
    }

    public void setThird_trade_no(String thirdTradeNo) {
        third_trade_no = thirdTradeNo;
    }

    public String getMerchant_extend_field_1() {
        return merchant_extend_field_1;
    }

    public void setMerchant_extend_field_1(String merchantExtendField_1) {
        merchant_extend_field_1 = merchantExtendField_1;
    }

    public String getMerchant_extend_field_2() {
        return merchant_extend_field_2;
    }

    public void setMerchant_extend_field_2(String merchantExtendField_2) {
        merchant_extend_field_2 = merchantExtendField_2;
    }

    public String getMerchant_extend_field_3() {
        return merchant_extend_field_3;
    }

    public void setMerchant_extend_field_3(String merchantExtendField_3) {
        merchant_extend_field_3 = merchantExtendField_3;
    }

    public String getMerchant_extend_field_4() {
        return merchant_extend_field_4;
    }

    public void setMerchant_extend_field_4(String merchantExtendField_4) {
        merchant_extend_field_4 = merchantExtendField_4;
    }

    public String getMerchant_extend_field_5() {
        return merchant_extend_field_5;
    }

    public void setMerchant_extend_field_5(String merchantExtendField_5) {
        merchant_extend_field_5 = merchantExtendField_5;
    }

    public String getGmt_refund_clear_channel() {
        return gmt_refund_clear_channel;
    }

    public void setGmt_refund_clear_channel(String gmtRefundClearChannel) {
        gmt_refund_clear_channel = gmtRefundClearChannel;
    }

    public String getClear_refund_amount() {
        return clear_refund_amount;
    }

    public void setClear_refund_amount(String clearRefundAmount) {
        clear_refund_amount = clearRefundAmount;
    }

    public String getClear_channel_attr_1() {
        return clear_channel_attr_1;
    }

    public void setClear_channel_attr_1(String clearChannelAttr_1) {
        clear_channel_attr_1 = clearChannelAttr_1;
    }

    public String getClear_channel_attr_2() {
        return clear_channel_attr_2;
    }

    public void setClear_channel_attr_2(String clearChannelAttr_2) {
        clear_channel_attr_2 = clearChannelAttr_2;
    }

    public String getClear_channel_attr_3() {
        return clear_channel_attr_3;
    }

    public void setClear_channel_attr_3(String clearChannelAttr_3) {
        clear_channel_attr_3 = clearChannelAttr_3;
    }

    public String getClear_channel_attr_4() {
        return clear_channel_attr_4;
    }

    public void setClear_channel_attr_4(String clearChannelAttr_4) {
        clear_channel_attr_4 = clearChannelAttr_4;
    }

    public String getClear_channel_attr_5() {
        return clear_channel_attr_5;
    }

    public void setClear_channel_attr_5(String clearChannelAttr_5) {
        clear_channel_attr_5 = clearChannelAttr_5;
    }

    public String getClear_channel_attr_6() {
        return clear_channel_attr_6;
    }

    public void setClear_channel_attr_6(String clearChannelAttr_6) {
        clear_channel_attr_6 = clearChannelAttr_6;
    }

    public String getAvl_bal_incr_field_1() {
        return avl_bal_incr_field_1;
    }

    public void setAvl_bal_incr_field_1(String avl_bal_incr_field_1) {
        this.avl_bal_incr_field_1 = avl_bal_incr_field_1;
    }

    public String getAvl_bal_incr_field_2() {
        return avl_bal_incr_field_2;
    }

    public void setAvl_bal_incr_field_2(String avl_bal_incr_field_2) {
        this.avl_bal_incr_field_2 = avl_bal_incr_field_2;
    }

    public String getAvl_bal_incr_field_3() {
        return avl_bal_incr_field_3;
    }

    public void setAvl_bal_incr_field_3(String avl_bal_incr_field_3) {
        this.avl_bal_incr_field_3 = avl_bal_incr_field_3;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
