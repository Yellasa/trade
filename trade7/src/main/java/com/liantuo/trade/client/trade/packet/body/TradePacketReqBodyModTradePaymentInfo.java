package com.liantuo.trade.client.trade.packet.body;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

public class TradePacketReqBodyModTradePaymentInfo extends TradeRequestBody{
	/**
     * 参数名：交易编号</br>
     * 参数类型：必填</br>
	 */
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\da-zA-Z_]{8,64}", groups = Format.class)
	private String trade_no;
	 /**
     * 参数名：交易发起方发起请求编号</br>
     * 参数类型：必填</br>
     */
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\da-zA-Z_]{8,64}", groups = Format.class)
	private String out_trade_no_ext;
	
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

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getOut_trade_no_ext() {
		return out_trade_no_ext;
	}

	public void setOut_trade_no_ext(String out_trade_no_ext) {
		this.out_trade_no_ext = out_trade_no_ext;
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
    
    
}
