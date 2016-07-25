package com.liantuo.trade.client.trade.packet.body.withdraw;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

public class NotifyReqBody {

    @Pattern(message = "hft_trade_no format error", regexp = "[\\d|a-z-A-Z]{1,128}", groups = Format.class)
    private String hft_trade_no; // 航付通号

    private String isBalance; //

    private String isBank; //

    private String isCredit; //

    private String isCreditCard; //

    private String isMotoPay; //

    @Pattern(message = "partnerId format error", regexp = "[\\d|a-z-A-Z|_]{2,16}", groups = Format.class)
    private String partnerId; // pid

    @NotBlank(message = "pay_account is required", groups = Required.class)
    @Pattern(message = "pay_account format error", regexp = ".{1,64}", groups = Format.class)
    private String pay_account; // 付款账号

    @NotBlank(message = "pay_info is required", groups = Required.class)
    private String pay_info; // 付款明细

    @Pattern(message="pay_time format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups=Format.class)
    private String pay_time; // 支付中心处理时间

    @Pattern(message = "receive_account format error", regexp = ".{1,64}", groups = Format.class)
    private String receive_account; // 支付宝收款账号

    @NotBlank(message = "ret_code is required", groups = Required.class)
    @Pattern(message = "ret_code format error", regexp = "-1|0", groups = Format.class)
    private String ret_code; // 支付中心处理状态

    
    private String third_pay_no; // 支付宝内部流水号

    public String getHft_trade_no() {
        return hft_trade_no;
    }

    public void setHft_trade_no(String hft_trade_no) {
        this.hft_trade_no = hft_trade_no;
    }

    public String getIsBalance() {
        return isBalance;
    }

    public void setIsBalance(String isBalance) {
        this.isBalance = isBalance;
    }

    public String getIsBank() {
        return isBank;
    }

    public void setIsBank(String isBank) {
        this.isBank = isBank;
    }

    public String getIsCredit() {
        return isCredit;
    }

    public void setIsCredit(String isCredit) {
        this.isCredit = isCredit;
    }

    public String getIsCreditCard() {
        return isCreditCard;
    }

    public void setIsCreditCard(String isCreditCard) {
        this.isCreditCard = isCreditCard;
    }

    public String getIsMotoPay() {
        return isMotoPay;
    }

    public void setIsMotoPay(String isMotoPay) {
        this.isMotoPay = isMotoPay;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPay_account() {
        return pay_account;
    }

    public void setPay_account(String pay_account) {
        this.pay_account = pay_account;
    }

    public String getPay_info() {
        return pay_info;
    }

    public void setPay_info(String pay_info) {
        this.pay_info = pay_info;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getReceive_account() {
        return receive_account;
    }

    public void setReceive_account(String receive_account) {
        this.receive_account = receive_account;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    public String getThird_pay_no() {
        return third_pay_no;
    }

    public void setThird_pay_no(String third_pay_no) {
        this.third_pay_no = third_pay_no;
    }

}
