package com.liantuo.trade.client.trade.packet.body.single_payment_refund;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

/**
 * 0006_002_001 VO
 *
 * @author yangting
 *         2016年6月2日 上午10:02:49
 */
public class TradePacketReqBodyInnerRefund extends TradeRequestBody {

    @NotBlank(message = "original_trade_no is required", groups = {Required.class})
    @Pattern(message = "original_trade_no format error", regexp = "[\\da-zA-Z_]{8,64}", groups = Format.class)
    private String original_trade_no;

    /**
     * 参数名：交易客户保留字段1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_1 format error", regexp = ".{0,64}", groups =Format.class)
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

//    @NotBlank(message = "refund_pay_type is required", groups = {Required.class})
    @Pattern(message = "refund_pay_type format error", regexp = "[12345]", groups = Format.class)
    private String refund_pay_type;

    @Pattern(message = "refund_pay_profit_loss_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String refund_pay_profit_loss_extend_field_1;

    @Pattern(message = "refund_pay_profit_loss_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String refund_pay_profit_loss_extend_field_2;

    @Pattern(message = "refund_pay_profit_loss_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String refund_pay_profit_loss_extend_field_3;

    @DecimalMin(message = "refund_pay_profit_loss_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "refund_pay_profit_loss_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String refund_pay_profit_loss_amt;

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

    public String getRefund_pay_type() {
		return refund_pay_type;
	}

	public void setRefund_pay_type(String refund_pay_type) {
		this.refund_pay_type = refund_pay_type;
	}

	public String getRefund_pay_profit_loss_extend_field_1() {
        return refund_pay_profit_loss_extend_field_1;
    }

    public void setRefund_pay_profit_loss_extend_field_1(String refund_pay_profit_loss_extend_field_1) {
        this.refund_pay_profit_loss_extend_field_1 = refund_pay_profit_loss_extend_field_1;
    }

    public String getRefund_pay_profit_loss_extend_field_2() {
        return refund_pay_profit_loss_extend_field_2;
    }

    public void setRefund_pay_profit_loss_extend_field_2(String refund_pay_profit_loss_extend_field_2) {
        this.refund_pay_profit_loss_extend_field_2 = refund_pay_profit_loss_extend_field_2;
    }

    public String getRefund_pay_profit_loss_extend_field_3() {
        return refund_pay_profit_loss_extend_field_3;
    }

    public void setRefund_pay_profit_loss_extend_field_3(String refund_pay_profit_loss_extend_field_3) {
        this.refund_pay_profit_loss_extend_field_3 = refund_pay_profit_loss_extend_field_3;
    }

    public String getRefund_pay_profit_loss_amt() {
        return refund_pay_profit_loss_amt;
    }

    public void setRefund_pay_profit_loss_amt(String refund_pay_profit_loss_amt) {
        this.refund_pay_profit_loss_amt = refund_pay_profit_loss_amt;
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

    public List<TradePacketReqBodyOtherPofitLossLedger> getProfit_loss_list() {
        return profit_loss_list;
    }

    public void setProfit_loss_list(List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list) {
        this.profit_loss_list = profit_loss_list;
    }

}