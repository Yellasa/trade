package com.liantuo.trade.client.trade.packet.body.single_payment_refund;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.validator.date.DateTime;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

/**
 * 0006_002_002 VO
 *
 * @author yangting
 *         2016年6月2日 上午10:02:49
 */
public class TradePacketReqBodyOuterRefund extends TradeRequestBody {

    @NotBlank(message = "original_trade_no is required", groups = {Required.class})
    @Pattern(message = "original_trade_no format error", regexp = "[\\da-zA-Z_]{8,64}", groups = Format.class)
    private String original_trade_no;

    /**
     * 参数名：交易客户保留字段1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_1 format error", regexp = ".{0,64}", groups = Format.class)
    private String merchant_extend_field_1;

    /**
     * 参数名：交易客户保留字段2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_2 format error", regexp = ".{0,64}", groups = Format.class)
    private String merchant_extend_field_2;

    /**
     * 参数名：交易客户保留字段3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_3 format error", regexp = ".{0,64}", groups = Format.class)
    private String merchant_extend_field_3;

    /**
     * 参数名：交易客户保留字段4</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String merchant_extend_field_4;

    /**
     * 参数名：交易客户保留字段5</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_5 format error", regexp = ".{0,128}", groups = Format.class)
    private String merchant_extend_field_5;

    /**
     * 参数名：交易客户保留字段6</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_6 format error", regexp = ".{0,256}", groups = Format.class)
    private String merchant_extend_field_6;

    /**
     * 参数名：交易客户保留字段7</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_7 format error", regexp = ".{0,256}", groups = Format.class)
    private String merchant_extend_field_7;

    /**
     * 参数名：交易客户保留字段8</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_8 format error", regexp = ".{0,256}", groups = Format.class)
    private String merchant_extend_field_8;

    /**
     * 参数名：交易客户保留字段9</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_9 format error", regexp = ".{0,256}", groups = Format.class)
    private String merchant_extend_field_9;

    /**
     * 参数名：交易客户保留字段10</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_10 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_10;

    /**
     * 参数名：交易发起方发起请求编号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "out_trade_no_ext is required", groups = {Required.class})
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\da-zA-Z_]{8,64}", groups = Format.class)
    private String out_trade_no_ext;

    /**
     * 参数名：交易发起方业务系统订单号</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "out_trade_no format error", regexp = ".{0}|[\\da-zA-Z_]{8,64}", groups = Format.class)
    private String out_trade_no;


    @Pattern(message = "external_refund_merchant_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_merchant_extend_field_1;

    @Pattern(message = "external_refund_merchant_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_merchant_extend_field_2;

    @Pattern(message = "external_refund_merchant_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_refund_merchant_extend_field_3;

    @Pattern(message = "external_refund_channel format error", regexp = "(.{0})||([\\da-zA-Z_]{1,16})", groups = Format.class)
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

    @NotBlank(message = "external_refund_amt is required", groups = {Required.class})
    @DecimalMin(message = "external_refund_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "external_refund_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String external_refund_amt;

    @DecimalMin(message = "refund_pay_account_in_accounting_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "refund_pay_account_in_accounting_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String refund_pay_account_in_accounting_amt;

    @Pattern(message = "refund_pay_account_out_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_pay_account_out_accounting_his1;

    @Pattern(message = "refund_pay_account_out_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_pay_account_out_accounting_his2;

    @Pattern(message = "refund_pay_account_out_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String refund_pay_account_out_accounting_his3;

    @Pattern(message = "refund_pay_account_in_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_pay_account_in_accounting_his1;

    @Pattern(message = "refund_pay_account_in_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_pay_account_in_accounting_his2;

    @Pattern(message = "refund_pay_account_in_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String refund_pay_account_in_accounting_his3;

    @DecimalMin(message = "refund_pay_fee_account_in_accounting_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "refund_pay_fee_account_in_accounting_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String refund_pay_fee_account_in_accounting_amt;

    @Pattern(message = "refund_pay_fee_account_in_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_pay_fee_account_in_accounting_his1;

    @Pattern(message = "refund_pay_fee_account_in_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_pay_fee_account_in_accounting_his2;

    @Pattern(message = "refund_pay_fee_account_in_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String refund_pay_fee_account_in_accounting_his3;

    @DecimalMin(message = "refund_receive_fee_account_in_accounting_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "refund_receive_fee_account_in_accounting_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String refund_receive_fee_account_in_accounting_amt;

    @Pattern(message = "refund_receive_fee_account_in_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_receive_fee_account_in_accounting_his1;

    @Pattern(message = "refund_receive_fee_account_in_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_receive_fee_account_in_accounting_his2;

    @Pattern(message = "refund_receive_fee_account_in_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String refund_receive_fee_account_in_accounting_his3;

    @NotBlank(message = "refund_receive_amt is required", groups = {Required.class})
    @DecimalMin(message = "refund_receive_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "refund_receive_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String refund_receive_amt;

    @Pattern(message = "refund_receive_profit_loss_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String refund_receive_profit_loss_extend_field_1;

    @Pattern(message = "refund_receive_profit_loss_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String refund_receive_profit_loss_extend_field_2;

    @Pattern(message = "refund_receive_profit_loss_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String refund_receive_profit_loss_extend_field_3;

    @Pattern(message = "refund_receive_account_out_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_receive_account_out_accounting_his1;

    @Pattern(message = "refund_receive_account_out_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String refund_receive_account_out_accounting_his2;

    @Pattern(message = "refund_receive_account_out_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String refund_receive_account_out_accounting_his3;
   
    @Valid
    private List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list;

   

    public String getOriginal_trade_no() {
		return original_trade_no;
	}

	public void setOriginal_trade_no(String original_trade_no) {
		this.original_trade_no = original_trade_no;
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

    public String getMerchant_extend_field_6() {
        return merchant_extend_field_6;
    }

    public void setMerchant_extend_field_6(String merchant_extend_field_6) {
        this.merchant_extend_field_6 = merchant_extend_field_6;
    }

    public String getMerchant_extend_field_7() {
        return merchant_extend_field_7;
    }

    public void setMerchant_extend_field_7(String merchant_extend_field_7) {
        this.merchant_extend_field_7 = merchant_extend_field_7;
    }

    public String getMerchant_extend_field_8() {
        return merchant_extend_field_8;
    }

    public void setMerchant_extend_field_8(String merchant_extend_field_8) {
        this.merchant_extend_field_8 = merchant_extend_field_8;
    }

    public String getMerchant_extend_field_9() {
        return merchant_extend_field_9;
    }

    public void setMerchant_extend_field_9(String merchant_extend_field_9) {
        this.merchant_extend_field_9 = merchant_extend_field_9;
    }

    public String getMerchant_extend_field_10() {
        return merchant_extend_field_10;
    }

    public void setMerchant_extend_field_10(String merchant_extend_field_10) {
        this.merchant_extend_field_10 = merchant_extend_field_10;
    }

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

    @XmlElementWrapper(name = "profit_loss_list")
    @XmlElement(name = "profit_loss")
    public List<TradePacketReqBodyOtherPofitLossLedger> getProfit_loss_list() {
        return profit_loss_list;
    }

    public void setProfit_loss_list(List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list) {
        this.profit_loss_list = profit_loss_list;
    }

    public String getExternal_refund_merchant_extend_field_1() {
        return external_refund_merchant_extend_field_1;
    }

    public void setExternal_refund_merchant_extend_field_1(String external_refund_merchant_extend_field_1) {
        this.external_refund_merchant_extend_field_1 = external_refund_merchant_extend_field_1;
    }

    public String getExternal_refund_merchant_extend_field_2() {
        return external_refund_merchant_extend_field_2;
    }

    public void setExternal_refund_merchant_extend_field_2(String external_refund_merchant_extend_field_2) {
        this.external_refund_merchant_extend_field_2 = external_refund_merchant_extend_field_2;
    }

    public String getExternal_refund_merchant_extend_field_3() {
        return external_refund_merchant_extend_field_3;
    }

    public void setExternal_refund_merchant_extend_field_3(String external_refund_merchant_extend_field_3) {
        this.external_refund_merchant_extend_field_3 = external_refund_merchant_extend_field_3;
    }

    public String getExternal_refund_channel() {
        return external_refund_channel;
    }

    public void setExternal_refund_channel(String external_refund_channel) {
        this.external_refund_channel = external_refund_channel;
    }

    public String getExternal_refund_pay_channel_fee_amt() {
        return external_refund_pay_channel_fee_amt;
    }

    public void setExternal_refund_pay_channel_fee_amt(String external_refund_pay_channel_fee_amt) {
        this.external_refund_pay_channel_fee_amt = external_refund_pay_channel_fee_amt;
    }

    public String getExternal_refund_channel_fee_amt() {
        return external_refund_channel_fee_amt;
    }

    public void setExternal_refund_channel_fee_amt(String external_refund_channel_fee_amt) {
        this.external_refund_channel_fee_amt = external_refund_channel_fee_amt;
    }

    public String getExternal_refund_channel_attr_3() {
        return external_refund_channel_attr_3;
    }

    public void setExternal_refund_channel_attr_3(String external_refund_channel_attr_3) {
        this.external_refund_channel_attr_3 = external_refund_channel_attr_3;
    }

    public String getExternal_refund_channel_attr_4() {
        return external_refund_channel_attr_4;
    }

    public void setExternal_refund_channel_attr_4(String external_refund_channel_attr_4) {
        this.external_refund_channel_attr_4 = external_refund_channel_attr_4;
    }

    public String getExternal_refund_channel_attr_5() {
        return external_refund_channel_attr_5;
    }

    public void setExternal_refund_channel_attr_5(String external_refund_channel_attr_5) {
        this.external_refund_channel_attr_5 = external_refund_channel_attr_5;
    }

    public String getExternal_refund_channel_attr_6() {
        return external_refund_channel_attr_6;
    }

    public void setExternal_refund_channel_attr_6(String external_refund_channel_attr_6) {
        this.external_refund_channel_attr_6 = external_refund_channel_attr_6;
    }

    public String getExternal_refund_channel_transaction_id() {
        return external_refund_channel_transaction_id;
    }

    public void setExternal_refund_channel_transaction_id(String external_refund_channel_transaction_id) {
        this.external_refund_channel_transaction_id = external_refund_channel_transaction_id;
    }

    public String getExternal_refund_channel_pay_account_no() {
        return external_refund_channel_pay_account_no;
    }

    public void setExternal_refund_channel_pay_account_no(String external_refund_channel_pay_account_no) {
        this.external_refund_channel_pay_account_no = external_refund_channel_pay_account_no;
    }

    public String getExternal_refund_channel_pay_account_name() {
        return external_refund_channel_pay_account_name;
    }

    public void setExternal_refund_channel_pay_account_name(String external_refund_channel_pay_account_name) {
        this.external_refund_channel_pay_account_name = external_refund_channel_pay_account_name;
    }

    public String getExternal_refund_channel_batch_no() {
        return external_refund_channel_batch_no;
    }

    public void setExternal_refund_channel_batch_no(String external_refund_channel_batch_no) {
        this.external_refund_channel_batch_no = external_refund_channel_batch_no;
    }

    public String getExternal_refund_channel_serial_no() {
        return external_refund_channel_serial_no;
    }

    public void setExternal_refund_channel_serial_no(String external_refund_channel_serial_no) {
        this.external_refund_channel_serial_no = external_refund_channel_serial_no;
    }

    public String getExternal_refund_channel_receive_account_no() {
        return external_refund_channel_receive_account_no;
    }

    public void setExternal_refund_channel_receive_account_no(String external_refund_channel_receive_account_no) {
        this.external_refund_channel_receive_account_no = external_refund_channel_receive_account_no;
    }

    public String getExternal_refund_channel_recieve_account_name() {
        return external_refund_channel_recieve_account_name;
    }

    public void setExternal_refund_channel_recieve_account_name(String external_refund_channel_recieve_account_name) {
        this.external_refund_channel_recieve_account_name = external_refund_channel_recieve_account_name;
    }

    public String getExternal_refund_channel_field_8() {
        return external_refund_channel_field_8;
    }

    public void setExternal_refund_channel_field_8(String external_refund_channel_field_8) {
        this.external_refund_channel_field_8 = external_refund_channel_field_8;
    }

    public String getExternal_refund_channel_field_9() {
        return external_refund_channel_field_9;
    }

    public void setExternal_refund_channel_field_9(String external_refund_channel_field_9) {
        this.external_refund_channel_field_9 = external_refund_channel_field_9;
    }

    public String getGmt_external_refund_channel_clear() {
        return gmt_external_refund_channel_clear;
    }

    public void setGmt_external_refund_channel_clear(String gmt_external_refund_channel_clear) {
        this.gmt_external_refund_channel_clear = gmt_external_refund_channel_clear;
    }

    public String getGmt_external_refund_accouting() {
        return gmt_external_refund_accouting;
    }

    public void setGmt_external_refund_accouting(String gmt_external_refund_accouting) {
        this.gmt_external_refund_accouting = gmt_external_refund_accouting;
    }

    public String getExternal_refund_channel_field_13() {
        return external_refund_channel_field_13;
    }

    public void setExternal_refund_channel_field_13(String external_refund_channel_field_13) {
        this.external_refund_channel_field_13 = external_refund_channel_field_13;
    }

    public String getExternal_refund_channel_field_14() {
        return external_refund_channel_field_14;
    }

    public void setExternal_refund_channel_field_14(String external_refund_channel_field_14) {
        this.external_refund_channel_field_14 = external_refund_channel_field_14;
    }

    public String getExternal_refund_channel_field_15() {
        return external_refund_channel_field_15;
    }

    public void setExternal_refund_channel_field_15(String external_refund_channel_field_15) {
        this.external_refund_channel_field_15 = external_refund_channel_field_15;
    }

    public String getExternal_refund_amt() {
        return external_refund_amt;
    }

    public void setExternal_refund_amt(String external_refund_amt) {
        this.external_refund_amt = external_refund_amt;
    }

    public String getRefund_pay_account_in_accounting_amt() {
        return refund_pay_account_in_accounting_amt;
    }

    public void setRefund_pay_account_in_accounting_amt(String refund_pay_account_in_accounting_amt) {
        this.refund_pay_account_in_accounting_amt = refund_pay_account_in_accounting_amt;
    }

    public String getRefund_pay_account_out_accounting_his1() {
        return refund_pay_account_out_accounting_his1;
    }

    public void setRefund_pay_account_out_accounting_his1(String refund_pay_account_out_accounting_his1) {
        this.refund_pay_account_out_accounting_his1 = refund_pay_account_out_accounting_his1;
    }

    public String getRefund_pay_account_out_accounting_his2() {
        return refund_pay_account_out_accounting_his2;
    }

    public void setRefund_pay_account_out_accounting_his2(String refund_pay_account_out_accounting_his2) {
        this.refund_pay_account_out_accounting_his2 = refund_pay_account_out_accounting_his2;
    }

    public String getRefund_pay_account_out_accounting_his3() {
        return refund_pay_account_out_accounting_his3;
    }

    public void setRefund_pay_account_out_accounting_his3(String refund_pay_account_out_accounting_his3) {
        this.refund_pay_account_out_accounting_his3 = refund_pay_account_out_accounting_his3;
    }

    public String getRefund_pay_account_in_accounting_his1() {
        return refund_pay_account_in_accounting_his1;
    }

    public void setRefund_pay_account_in_accounting_his1(String refund_pay_account_in_accounting_his1) {
        this.refund_pay_account_in_accounting_his1 = refund_pay_account_in_accounting_his1;
    }

    public String getRefund_pay_account_in_accounting_his2() {
        return refund_pay_account_in_accounting_his2;
    }

    public void setRefund_pay_account_in_accounting_his2(String refund_pay_account_in_accounting_his2) {
        this.refund_pay_account_in_accounting_his2 = refund_pay_account_in_accounting_his2;
    }

    public String getRefund_pay_account_in_accounting_his3() {
        return refund_pay_account_in_accounting_his3;
    }

    public void setRefund_pay_account_in_accounting_his3(String refund_pay_account_in_accounting_his3) {
        this.refund_pay_account_in_accounting_his3 = refund_pay_account_in_accounting_his3;
    }

    public String getRefund_pay_fee_account_in_accounting_amt() {
        return refund_pay_fee_account_in_accounting_amt;
    }

    public void setRefund_pay_fee_account_in_accounting_amt(String refund_pay_fee_account_in_accounting_amt) {
        this.refund_pay_fee_account_in_accounting_amt = refund_pay_fee_account_in_accounting_amt;
    }

    public String getRefund_pay_fee_account_in_accounting_his1() {
        return refund_pay_fee_account_in_accounting_his1;
    }

    public void setRefund_pay_fee_account_in_accounting_his1(String refund_pay_fee_account_in_accounting_his1) {
        this.refund_pay_fee_account_in_accounting_his1 = refund_pay_fee_account_in_accounting_his1;
    }

    public String getRefund_pay_fee_account_in_accounting_his2() {
        return refund_pay_fee_account_in_accounting_his2;
    }

    public void setRefund_pay_fee_account_in_accounting_his2(String refund_pay_fee_account_in_accounting_his2) {
        this.refund_pay_fee_account_in_accounting_his2 = refund_pay_fee_account_in_accounting_his2;
    }

    public String getRefund_pay_fee_account_in_accounting_his3() {
        return refund_pay_fee_account_in_accounting_his3;
    }

    public void setRefund_pay_fee_account_in_accounting_his3(String refund_pay_fee_account_in_accounting_his3) {
        this.refund_pay_fee_account_in_accounting_his3 = refund_pay_fee_account_in_accounting_his3;
    }

    public String getRefund_receive_fee_account_in_accounting_amt() {
        return refund_receive_fee_account_in_accounting_amt;
    }

    public void setRefund_receive_fee_account_in_accounting_amt(String refund_receive_fee_account_in_accounting_amt) {
        this.refund_receive_fee_account_in_accounting_amt = refund_receive_fee_account_in_accounting_amt;
    }

    public String getRefund_receive_fee_account_in_accounting_his1() {
        return refund_receive_fee_account_in_accounting_his1;
    }

    public void setRefund_receive_fee_account_in_accounting_his1(String refund_receive_fee_account_in_accounting_his1) {
        this.refund_receive_fee_account_in_accounting_his1 = refund_receive_fee_account_in_accounting_his1;
    }

    public String getRefund_receive_fee_account_in_accounting_his2() {
        return refund_receive_fee_account_in_accounting_his2;
    }

    public void setRefund_receive_fee_account_in_accounting_his2(String refund_receive_fee_account_in_accounting_his2) {
        this.refund_receive_fee_account_in_accounting_his2 = refund_receive_fee_account_in_accounting_his2;
    }

    public String getRefund_receive_fee_account_in_accounting_his3() {
        return refund_receive_fee_account_in_accounting_his3;
    }

    public void setRefund_receive_fee_account_in_accounting_his3(String refund_receive_fee_account_in_accounting_his3) {
        this.refund_receive_fee_account_in_accounting_his3 = refund_receive_fee_account_in_accounting_his3;
    }

    public String getRefund_receive_amt() {
		return refund_receive_amt;
	}

	public void setRefund_receive_amt(String refund_receive_amt) {
		this.refund_receive_amt = refund_receive_amt;
	}

    public String getRefund_receive_profit_loss_extend_field_1() {
        return refund_receive_profit_loss_extend_field_1;
    }

    public void setRefund_receive_profit_loss_extend_field_1(String refund_receive_profit_loss_extend_field_1) {
        this.refund_receive_profit_loss_extend_field_1 = refund_receive_profit_loss_extend_field_1;
    }

    public String getRefund_receive_profit_loss_extend_field_2() {
        return refund_receive_profit_loss_extend_field_2;
    }

    public void setRefund_receive_profit_loss_extend_field_2(String refund_receive_profit_loss_extend_field_2) {
        this.refund_receive_profit_loss_extend_field_2 = refund_receive_profit_loss_extend_field_2;
    }

    public String getRefund_receive_profit_loss_extend_field_3() {
        return refund_receive_profit_loss_extend_field_3;
    }

    public void setRefund_receive_profit_loss_extend_field_3(String refund_receive_profit_loss_extend_field_3) {
        this.refund_receive_profit_loss_extend_field_3 = refund_receive_profit_loss_extend_field_3;
    }

    public String getRefund_receive_account_out_accounting_his1() {
        return refund_receive_account_out_accounting_his1;
    }

    public void setRefund_receive_account_out_accounting_his1(String refund_receive_account_out_accounting_his1) {
        this.refund_receive_account_out_accounting_his1 = refund_receive_account_out_accounting_his1;
    }

    public String getRefund_receive_account_out_accounting_his2() {
        return refund_receive_account_out_accounting_his2;
    }

    public void setRefund_receive_account_out_accounting_his2(String refund_receive_account_out_accounting_his2) {
        this.refund_receive_account_out_accounting_his2 = refund_receive_account_out_accounting_his2;
    }

    public String getRefund_receive_account_out_accounting_his3() {
        return refund_receive_account_out_accounting_his3;
    }

    public void setRefund_receive_account_out_accounting_his3(String refund_receive_account_out_accounting_his3) {
        this.refund_receive_account_out_accounting_his3 = refund_receive_account_out_accounting_his3;
    }

	public String getExternal_refund_channel_field_10() {
		return external_refund_channel_field_10;
	}

	public void setExternal_refund_channel_field_10(String external_refund_channel_field_10) {
		this.external_refund_channel_field_10 = external_refund_channel_field_10;
	}
    
}