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
 * CA付款成功,剩余解冻 请求VO
 * 0001_001_004
 */
public class TradePacketReqBodyUnFreezeOnlineSettle extends TradeRequestBody {

    /**
     * 参数名：原交易编号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "trade_no is required", groups = {Required.class})
    @Pattern(message = "trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String trade_no;

    /**
     * 参数名：收款CA账户编号</br>
     * 参数类型：<font color="red">必填</font></br>
     */
    @NotBlank(message = "receive_account_no is required", groups = {Required.class})
    @Pattern(message = "receive_account_no format error", regexp = "[\\w]{6,32}", groups = Format.class)
    private String receive_account_no;

    /**
     * 参数名：实际付出金额</br>
     * 参数类型：<font color="red">必填</font></br>
     */
    @NotBlank(message = "actual_amount is required", groups = {Required.class})
    @DecimalMin(message = "actual_amount format error", groups = {Format.class}, value = "0.00")
    @Digits(message = "actual_amount format error", groups = {Format.class}, integer = 16, fraction = 2)
    private String actual_amount;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String tradeNo) {
        trade_no = tradeNo;
    }

    public String getReceive_account_no() {
        return receive_account_no;
    }

    public void setReceive_account_no(String receiveAccountNo) {
        receive_account_no = receiveAccountNo;
    }

    public String getActual_amount() {
        return actual_amount;
    }

    public void setActual_amount(String actualAmount) {
        actual_amount = actualAmount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
