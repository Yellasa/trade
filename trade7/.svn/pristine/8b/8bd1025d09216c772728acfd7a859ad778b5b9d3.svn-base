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
 * 线下付款成功,剩余解冻 请求VO 0001_001_002
 */
public class TradePacketReqBodyUnFreezeOfflineSettle extends TradeRequestBody {

    /**
     * 参数名：原交易编号</br> 参数类型：必填</br>
     */
    @NotBlank(message = "trade_no is required", groups = { Required.class })
    @Pattern(message = "trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String trade_no;

    /**
     * 参数名：付款渠道编号</br> 参数类型：必填</br>
     */
    @NotBlank(message = "clear_channel is required", groups = { Required.class })
    @Pattern(message = "clear_channel format error", regexp = "[\\w]{1,16}", groups = Format.class)
    private String clear_channel;

    /**
     * 参数名：付款渠道订单号</br> 参数类型：<font color="red">必填</font></br>
     */
    @NotBlank(message = "third_trade_no is required", groups = { Required.class })
    @Pattern(message = "third_trade_no format error", regexp = "[\\w]{1,128}", groups = Format.class)
    private String third_trade_no;

    /**
     * 参数名：收付款属性1</br> 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_1;

    /**
     * 参数名：收付款属性2</br> 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_2;

    /**
     * 参数名：收付款属性3</br> 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_3;

    /**
     * 参数名：收付款属性4</br> 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_4;

    /**
     * 参数名：收付款属性5</br> 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_5 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_5;

    /**
     * 参数名：收付款属性6</br> 参数类型：可空</br>
     */
    @Pattern(message = "clear_channel_attr_6 format error", regexp = ".{0,128}", groups = Format.class)
    private String clear_channel_attr_6;

    /**
     * 参数名：实际付出金额</br> 参数类型：<font color="red">必填</font></br>
     */
    @NotBlank(message = "actual_amount is required", groups = { Required.class })
    @DecimalMin(message = "actual_amount format error", groups = { Format.class }, value = "0.00")
    @Digits(message = "actual_amount format error", groups = { Format.class }, integer = 16, fraction = 2)
    private String actual_amount;

    /**
     * 参数名：付款渠道成功日期时间</br> 参数类型：<font color="red">必填</font></br>
     */
    @NotNull(message = "gmt_success_clear_channel is required", groups = { Required.class })
    @Pattern(message = "gmt_success_clear_channel format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups = Format.class)
    private String gmt_success_clear_channel;

    // 冻结余额减少客户账务历史1
    @Pattern(message = "fro_bal_decr_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_decr_field_1;

    // 冻结余额减少客户账务历史2
    @Pattern(message = "fro_bal_decr_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_decr_field_2;

    // 冻结余额减少客户账务历史3
    @Pattern(message = "fro_bal_decr_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String fro_bal_decr_field_3;

    // 可用余额增加客户账务历史1
    @Pattern(message = "avl_bal_incr_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_incr_field_1;

    // 可用余额增加客户账务历史2
    @Pattern(message = "avl_bal_incr_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_incr_field_2;

    // 可用余额增加客户账务历史3
    @Pattern(message = "avl_bal_incr_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_incr_field_3;

    // 可用余额减少客户账务历史1
    @Pattern(message = "avl_bal_decr_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_decr_field_1;

    // 可用余额减少客户账务历史2
    @Pattern(message = "avl_bal_decr_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_decr_field_2;

    // 可用余额减少客户账务历史3
    @Pattern(message = "avl_bal_decr_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String avl_bal_decr_field_3;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String tradeNo) {
        trade_no = tradeNo;
    }

    public String getClear_channel() {
        return clear_channel;
    }

    public void setClear_channel(String clearChannel) {
        clear_channel = clearChannel;
    }

    public String getThird_trade_no() {
        return third_trade_no;
    }

    public void setThird_trade_no(String thirdTradeNo) {
        third_trade_no = thirdTradeNo;
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

    public String getActual_amount() {
        return actual_amount;
    }

    public void setActual_amount(String actualAmount) {
        actual_amount = actualAmount;
    }

    public String getGmt_success_clear_channel() {
        return gmt_success_clear_channel;
    }

    public void setGmt_success_clear_channel(String gmtSuccessClearChannel) {
        gmt_success_clear_channel = gmtSuccessClearChannel;
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

    public String getFro_bal_decr_field_1() {
        return fro_bal_decr_field_1;
    }

    public void setFro_bal_decr_field_1(String fro_bal_decr_field_1) {
        this.fro_bal_decr_field_1 = fro_bal_decr_field_1;
    }

    public String getFro_bal_decr_field_2() {
        return fro_bal_decr_field_2;
    }

    public void setFro_bal_decr_field_2(String fro_bal_decr_field_2) {
        this.fro_bal_decr_field_2 = fro_bal_decr_field_2;
    }

    public String getFro_bal_decr_field_3() {
        return fro_bal_decr_field_3;
    }

    public void setFro_bal_decr_field_3(String fro_bal_decr_field_3) {
        this.fro_bal_decr_field_3 = fro_bal_decr_field_3;
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
