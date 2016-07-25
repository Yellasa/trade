package com.liantuo.trade.client.trade.packet.body.withdraw;

import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

/**
 * 成员提现-出款
 */
public class TradePacketReqBodySingleWithdrawPay {
	/**
     * 参数名：原交易编号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "trade_no is required", groups = {Required.class})
    @Pattern(message = "trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String trade_no;
    /**
     * 出款渠道身份编号,必填
     */
    @NotBlank(message = "pay_transaction_id is required", groups = {Required.class})
    @Pattern(message = "pay_transaction_id format error", regexp = "[\\d|a-z-A-Z|_]{1,16}", groups = Format.class)
    private String pay_transaction_id;
    /**
     * 金融业务类型
     */
    @Pattern(message = "requester format error", regexp = ".{0}|[\\d]{1,2}", groups = Format.class)
    private String requester;
    /**
     *付款方账户 
     */
    @NotBlank(message = "payer_account is required", groups = {Required.class})
    @Pattern(message = "payer_account format error", regexp = ".{1,64}", groups = Format.class)
    private String payer_account;
    /**
     * 付款方账户名称
     */
    @NotBlank(message = "payer_name is required", groups = {Required.class})
    @Pattern(message = "payer_name format error", regexp = ".{1,64}", groups = Format.class)
    private String payer_name;
    /**
     * 提现第三方账户
     */
    @NotBlank(message = "withdraw_third_account is required", groups = {Required.class})
    @Pattern(message = "withdraw_third_account format error", regexp = ".{1,64}", groups = Format.class)
    private String withdraw_third_account;
    /**
     * 提现第三方账户姓名
     */
    @NotBlank(message = "withdraw_third_account_name is required", groups = {Required.class})
    @Pattern(message = "withdraw_third_account_name format error", regexp = ".{1,64}", groups = Format.class)
    private String withdraw_third_account_name;
    /**
     * 提现第三方UserID
     */
    @Pattern(message = "withdraw_third_userid format error", regexp = ".{0,64}", groups = Format.class)
    private String withdraw_third_userid;
    /**
     * 提现第三方账户付款说明
     */
    @NotBlank(message = "withdraw_third_account_paymemo is required", groups = {Required.class})
    @Pattern(message = "withdraw_third_account_paymemo format error", regexp = ".{1,50}", groups = Format.class)
    private String withdraw_third_account_paymemo;
    /**
     * 异步通知地址
     */
    @NotBlank(message = "notify_url is required", groups = {Required.class})
    @Pattern(message = "notify_url format error", regexp = ".{0,1024}", groups = Format.class)
    private String notify_url;
    /**
     * 业务台账保留字段1
     */
    @Pattern(message = "merchant_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_1;
    /**
     * 业务台账保留字段2
     */
    @Pattern(message = "merchant_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_2;
    /**
     * 业务台账保留字段3
     */
    @Pattern(message = "merchant_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_3;
	
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getPay_transaction_id() {
		return pay_transaction_id;
	}

	public void setPay_transaction_id(String pay_transaction_id) {
		this.pay_transaction_id = pay_transaction_id;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getPayer_account() {
		return payer_account;
	}

	public void setPayer_account(String payer_account) {
		this.payer_account = payer_account;
	}

	public String getPayer_name() {
		return payer_name;
	}

	public void setPayer_name(String payer_name) {
		this.payer_name = payer_name;
	}

	public String getWithdraw_third_account() {
		return withdraw_third_account;
	}

	public void setWithdraw_third_account(String withdraw_third_account) {
		this.withdraw_third_account = withdraw_third_account;
	}

	public String getWithdraw_third_account_name() {
		return withdraw_third_account_name;
	}

	public void setWithdraw_third_account_name(String withdraw_third_account_name) {
		this.withdraw_third_account_name = withdraw_third_account_name;
	}

	public String getWithdraw_third_userid() {
		return withdraw_third_userid;
	}

	public void setWithdraw_third_userid(String withdraw_third_userid) {
		this.withdraw_third_userid = withdraw_third_userid;
	}

	public String getWithdraw_third_account_paymemo() {
		return withdraw_third_account_paymemo;
	}

	public void setWithdraw_third_account_paymemo(String withdraw_third_account_paymemo) {
		this.withdraw_third_account_paymemo = withdraw_third_account_paymemo;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
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
    
	
}
