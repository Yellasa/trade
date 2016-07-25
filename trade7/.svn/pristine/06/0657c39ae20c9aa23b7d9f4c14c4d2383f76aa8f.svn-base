package com.liantuo.trade.client.trade.packet.body.single_payment_refund;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.validator.date.DateTime;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 0006_002_005 VO
 *
 * @author zzd
 *         2016年6月2日 上午10:02:49
 */
public class TradePacketReqBodyOuterRefundSuccessChannelUpdate extends TradeRequestBody {

    @NotBlank(message = "original_trade_no is required", groups = {Required.class})
    @Pattern(message = "original_trade_no format error", regexp = "[\\da-zA-Z_]{8,64}", groups = Format.class)
    private String original_trade_no;

    @Pattern(message = "external_refund_merchant_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_merchant_extend_field_1;

    @Pattern(message = "external_refund_merchant_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_merchant_extend_field_2;

    @Pattern(message = "external_refund_merchant_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_merchant_extend_field_3;
    
    @NotBlank(message = "external_refund_channel is required", groups = {Required.class})
    @Pattern(message = "external_refund_channel format error", regexp = "[\\da-zA-Z_]{1,16}", groups = Format.class)
    private String external_refund_channel;

    @DecimalMin(message = "external_refund_pay_channel_fee_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "external_refund_pay_channel_fee_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String external_refund_pay_channel_fee_amt;

    @DecimalMin(message = "external_refund_channel_fee_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "external_refund_channel_fee_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String external_refund_channel_fee_amt;

    @Pattern(message = "external_refund_channel_attr_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_refund_channel_attr_3;

    @Pattern(message = "external_refund_channel_attr_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_refund_channel_attr_4;

    @Pattern(message = "external_refund_channel_attr_5 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_refund_channel_attr_5;

    @Pattern(message = "external_refund_channel_attr_6 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_refund_channel_attr_6;

    @Pattern(message = "external_refund_channel_transaction_id format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_transaction_id;

    @Pattern(message = "external_refund_channel_pay_account_no format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_pay_account_no;

    @Pattern(message = "external_refund_channel_pay_account_name format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_pay_account_name;

    @Pattern(message = "external_refund_channel_batch_no format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_batch_no;

    @Pattern(message = "external_refund_channel_serial_no format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_serial_no;
    
    @Pattern(message = "external_refund_channel_receive_account_no format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_receive_account_no;

    @Pattern(message = "external_refund_channel_recieve_account_name format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_recieve_account_name;

    @Pattern(message = "external_refund_channel_field_8 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_field_8;

    @Pattern(message = "external_refund_channel_field_9 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_field_9;
    
    @Pattern(message = "external_refund_channel_field_10 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_channel_field_10;

    @DateTime(message = "gmt_external_refund_channel_clear format error", groups = Format.class)
    private String gmt_external_refund_channel_clear;

    @DateTime(message = "gmt_external_refund_accouting format error", groups = Format.class)
    private String gmt_external_refund_accouting;

    @Pattern(message = "external_refund_channel_field_13 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_refund_channel_field_13;

    @Pattern(message = "external_refund_channel_field_14 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_refund_channel_field_14;

    @Pattern(message = "external_refund_channel_field_15 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_refund_channel_field_15;

    @NotBlank(message = "gmt_success_external_refund is required", groups = {Required.class})
    @DateTime(message = "gmt_success_external_refund format error", groups = Format.class)
    private String gmt_success_external_refund;
   
    @NotBlank(message = "external_refund_channel_trade_no is required", groups = {Required.class})
    @Pattern(message = "external_refund_channel_trade_no format error", regexp = ".{0,128}", groups = Format.class)
    private String external_refund_channel_trade_no;

    public String getOriginal_trade_no() {
        return original_trade_no;
    }

    public void setOriginal_trade_no(String originalTradeNo) {
    	original_trade_no = originalTradeNo;
    }

    public String getExternal_refund_merchant_extend_field_1() {
        return external_refund_merchant_extend_field_1;
    }

    public void setExternal_refund_merchant_extend_field_1(
            String externalRefundMerchantExtendField_1) {
        external_refund_merchant_extend_field_1 = externalRefundMerchantExtendField_1;
    }

    public String getExternal_refund_merchant_extend_field_2() {
        return external_refund_merchant_extend_field_2;
    }

    public void setExternal_refund_merchant_extend_field_2(
            String externalRefundMerchantExtendField_2) {
        external_refund_merchant_extend_field_2 = externalRefundMerchantExtendField_2;
    }

    public String getExternal_refund_merchant_extend_field_3() {
        return external_refund_merchant_extend_field_3;
    }

    public void setExternal_refund_merchant_extend_field_3(
            String externalRefundMerchantExtendField_3) {
        external_refund_merchant_extend_field_3 = externalRefundMerchantExtendField_3;
    }

    public String getExternal_refund_channel() {
        return external_refund_channel;
    }

    public void setExternal_refund_channel(String externalRefundChannel) {
        external_refund_channel = externalRefundChannel;
    }

    public String getExternal_refund_pay_channel_fee_amt() {
        return external_refund_pay_channel_fee_amt;
    }

    public void setExternal_refund_pay_channel_fee_amt(
            String externalRefundPayChannelFeeAmt) {
        external_refund_pay_channel_fee_amt = externalRefundPayChannelFeeAmt;
    }

    public String getExternal_refund_channel_fee_amt() {
        return external_refund_channel_fee_amt;
    }

    public void setExternal_refund_channel_fee_amt(
            String externalRefundChannelFeeAmt) {
        external_refund_channel_fee_amt = externalRefundChannelFeeAmt;
    }

    public String getExternal_refund_channel_attr_3() {
        return external_refund_channel_attr_3;
    }

    public void setExternal_refund_channel_attr_3(String externalRefundChannelAttr_3) {
        external_refund_channel_attr_3 = externalRefundChannelAttr_3;
    }

    public String getExternal_refund_channel_attr_4() {
        return external_refund_channel_attr_4;
    }

    public void setExternal_refund_channel_attr_4(String externalRefundChannelAttr_4) {
        external_refund_channel_attr_4 = externalRefundChannelAttr_4;
    }

    public String getExternal_refund_channel_attr_5() {
        return external_refund_channel_attr_5;
    }

    public void setExternal_refund_channel_attr_5(String externalRefundChannelAttr_5) {
        external_refund_channel_attr_5 = externalRefundChannelAttr_5;
    }

    public String getExternal_refund_channel_attr_6() {
        return external_refund_channel_attr_6;
    }

    public void setExternal_refund_channel_attr_6(String externalRefundChannelAttr_6) {
        external_refund_channel_attr_6 = externalRefundChannelAttr_6;
    }

    public String getExternal_refund_channel_transaction_id() {
        return external_refund_channel_transaction_id;
    }

    public void setExternal_refund_channel_transaction_id(
            String externalRefundChannelTransactionId) {
        external_refund_channel_transaction_id = externalRefundChannelTransactionId;
    }

    public String getExternal_refund_channel_pay_account_no() {
        return external_refund_channel_pay_account_no;
    }

    public void setExternal_refund_channel_pay_account_no(
            String externalRefundChannelPayAccountNo) {
        external_refund_channel_pay_account_no = externalRefundChannelPayAccountNo;
    }

    public String getExternal_refund_channel_pay_account_name() {
        return external_refund_channel_pay_account_name;
    }

    public void setExternal_refund_channel_pay_account_name(
            String externalRefundChannelPayAccountName) {
        external_refund_channel_pay_account_name = externalRefundChannelPayAccountName;
    }

    public String getExternal_refund_channel_batch_no() {
        return external_refund_channel_batch_no;
    }

    public void setExternal_refund_channel_batch_no(
            String externalRefundChannelBatchNo) {
        external_refund_channel_batch_no = externalRefundChannelBatchNo;
    }

    public String getExternal_refund_channel_serial_no() {
        return external_refund_channel_serial_no;
    }

    public void setExternal_refund_channel_serial_no(
            String externalRefundChannelSerialNo) {
        external_refund_channel_serial_no = externalRefundChannelSerialNo;
    }

    public String getExternal_refund_channel_receive_account_no() {
        return external_refund_channel_receive_account_no;
    }

    public void setExternal_refund_channel_receive_account_no(
            String externalRefundChannelReceiveAccountNo) {
        external_refund_channel_receive_account_no = externalRefundChannelReceiveAccountNo;
    }

    public String getExternal_refund_channel_recieve_account_name() {
        return external_refund_channel_recieve_account_name;
    }

    public void setExternal_refund_channel_recieve_account_name(
            String externalRefundChannelRecieveAccountName) {
        external_refund_channel_recieve_account_name = externalRefundChannelRecieveAccountName;
    }

    public String getExternal_refund_channel_field_8() {
        return external_refund_channel_field_8;
    }

    public void setExternal_refund_channel_field_8(
            String externalRefundChannelField_8) {
        external_refund_channel_field_8 = externalRefundChannelField_8;
    }

    public String getExternal_refund_channel_field_9() {
        return external_refund_channel_field_9;
    }

    public void setExternal_refund_channel_field_9(
            String externalRefundChannelField_9) {
        external_refund_channel_field_9 = externalRefundChannelField_9;
    }

    public String getGmt_external_refund_channel_clear() {
        return gmt_external_refund_channel_clear;
    }

    public void setGmt_external_refund_channel_clear(
            String gmtExternalRefundChannelClear) {
        gmt_external_refund_channel_clear = gmtExternalRefundChannelClear;
    }

    public String getGmt_external_refund_accouting() {
        return gmt_external_refund_accouting;
    }

    public void setGmt_external_refund_accouting(String gmtExternalRefundAccouting) {
        gmt_external_refund_accouting = gmtExternalRefundAccouting;
    }

    public String getExternal_refund_channel_field_13() {
        return external_refund_channel_field_13;
    }

    public void setExternal_refund_channel_field_13(
            String externalRefundChannelField_13) {
        external_refund_channel_field_13 = externalRefundChannelField_13;
    }

    public String getExternal_refund_channel_field_14() {
        return external_refund_channel_field_14;
    }

    public void setExternal_refund_channel_field_14(
            String externalRefundChannelField_14) {
        external_refund_channel_field_14 = externalRefundChannelField_14;
    }

    public String getExternal_refund_channel_field_15() {
        return external_refund_channel_field_15;
    }

    public void setExternal_refund_channel_field_15(
            String externalRefundChannelField_15) {
        external_refund_channel_field_15 = externalRefundChannelField_15;
    }

    public String getGmt_success_external_refund() {
        return gmt_success_external_refund;
    }

    public void setGmt_success_external_refund(String gmtSuccessExternalRefund) {
        gmt_success_external_refund = gmtSuccessExternalRefund;
    }

    public String getExternal_refund_channel_trade_no() {
        return external_refund_channel_trade_no;
    }

    public void setExternal_refund_channel_trade_no(
            String externalRefundChannelTradeNo) {
        external_refund_channel_trade_no = externalRefundChannelTradeNo;
    }

	public String getExternal_refund_channel_field_10() {
		return external_refund_channel_field_10;
	}

	public void setExternal_refund_channel_field_10(String external_refund_channel_field_10) {
		this.external_refund_channel_field_10 = external_refund_channel_field_10;
	}
    

}