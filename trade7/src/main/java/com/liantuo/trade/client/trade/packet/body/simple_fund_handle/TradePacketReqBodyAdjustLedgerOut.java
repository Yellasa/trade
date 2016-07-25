package com.liantuo.trade.client.trade.packet.body.simple_fund_handle;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

/**
 * @ClassName:     TradePacketReqBodyAdjustLedgerOut.java
 * @Description:   0003_001_003 V1.0CA台账出金
 * Company:联拓金融信息服务有限公司
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-4-1 下午5:57:46 
 */
public class TradePacketReqBodyAdjustLedgerOut extends TradeRequestBody {

    /**
     * 交易发起方业务系统订单号
     */
    @Pattern(message = "out_trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no;

    /**
     * 交易发起方发起请求编号,必填
     */
    @NotBlank(message = "out_trade_no_ext is required", groups = {Required.class})
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no_ext;

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
     * 付出CA账户编号,必填
     */
    @NotBlank(message = "payment_account_no is required", groups = {Required.class})
    @Pattern(message = "payment_account_no format error", regexp = "[\\w]{6,32}", groups = Format.class)
    private String payment_account_no;
    
    /**
     * 付出CA账务备注1
     */
    @Pattern(message = "payment_account_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String payment_account_extend_field_1;
    
    /**
     * 付出CA账务备注2
     */
    @Pattern(message = "payment_account_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String payment_account_extend_field_2;
    
    /**
     * 付出CA账务备注3
     */
    @Pattern(message = "payment_account_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String payment_account_extend_field_3;
    
    /**
     * 付款渠道编号,必填
     */
    @NotBlank(message = "clear_channel is required", groups = { Required.class })
    @Pattern(message = "clear_channel format error", regexp = "[\\w]{1,16}", groups = Format.class)
    private String clear_channel;
    
    /**
     * 付款渠道付出日期时间,必填
     */
    @NotNull(message = "gmt_success_clear_channel is required", groups = { Required.class })
    @Pattern(message = "gmt_success_clear_channel format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE, groups = Format.class)
    private String gmt_success_clear_channel;
    
    /**
     * 付款渠道订单号
     */
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
     * 台账备注1
     */
    @Pattern(message = "ledger_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_1;
    
    /**
     * 台账备注2
     */
    @Pattern(message = "ledger_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_2;
    
    /**
     * 台账备注3
     */
    @Pattern(message = "ledger_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_3;
    
    /**
     * 台账备注4
     */
    @Pattern(message = "ledger_extend_field_4 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_4;
    
    /**
     * 台账备注5
     */
    @Pattern(message = "ledger_extend_field_5 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_5;
    
    /**
     * 台账备注6
     */
    @Pattern(message = "ledger_extend_field_6 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_6;
    
    /**
     * 台账备注7
     */
    @Pattern(message = "ledger_extend_field_7 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_7;
    
    /**
     * 台账备注8
     */
    @Pattern(message = "ledger_extend_field_8 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_8;
    
    /**
     * 台账备注9
     */
    @Pattern(message = "ledger_extend_field_9 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_9;
    
    /**
     * 台账备注10
     */
    @Pattern(message = "ledger_extend_field_10 format error", regexp = ".{0,1024}", groups = Format.class)
    private String ledger_extend_field_10;
    
    /**
     * 台账客户保留字段1
     */
    @Pattern(message = "ledger_merchant_extend_field_1 format error", regexp = ".{0,512}", groups = Format.class)
    private String ledger_merchant_extend_field_1;
    
    /**
     * 台账客户保留字段2
     */
    @Pattern(message = "ledger_merchant_extend_field_2 format error", regexp = ".{0,512}", groups = Format.class)
    private String ledger_merchant_extend_field_2;
    
    /**
     * 台账客户保留字段3
     */
    @Pattern(message = "ledger_merchant_extend_field_3 format error", regexp = ".{0,512}", groups = Format.class)
    private String ledger_merchant_extend_field_3;
    
    /**
     * 出金金额
     */
    @NotBlank(message = "adjust_amount is required", groups = {Required.class})
    @DecimalMin(message = "adjust_amount format error", groups = {Format.class}, value = "0.00")
    @Digits(message = "adjust_amount format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String adjust_amount;

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

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

	public String getPayment_account_no() {
		return payment_account_no;
	}

	public void setPayment_account_no(String payment_account_no) {
		this.payment_account_no = payment_account_no;
	}

	public String getPayment_account_extend_field_1() {
		return payment_account_extend_field_1;
	}

	public void setPayment_account_extend_field_1(
			String payment_account_extend_field_1) {
		this.payment_account_extend_field_1 = payment_account_extend_field_1;
	}

	public String getPayment_account_extend_field_2() {
		return payment_account_extend_field_2;
	}

	public void setPayment_account_extend_field_2(
			String payment_account_extend_field_2) {
		this.payment_account_extend_field_2 = payment_account_extend_field_2;
	}

	public String getPayment_account_extend_field_3() {
		return payment_account_extend_field_3;
	}

	public void setPayment_account_extend_field_3(
			String payment_account_extend_field_3) {
		this.payment_account_extend_field_3 = payment_account_extend_field_3;
	}

	public String getClear_channel() {
		return clear_channel;
	}

	public void setClear_channel(String clear_channel) {
		this.clear_channel = clear_channel;
	}

	public String getGmt_success_clear_channel() {
		return gmt_success_clear_channel;
	}

	public void setGmt_success_clear_channel(String gmt_success_clear_channel) {
		this.gmt_success_clear_channel = gmt_success_clear_channel;
	}

	public String getThird_trade_no() {
		return third_trade_no;
	}

	public void setThird_trade_no(String third_trade_no) {
		this.third_trade_no = third_trade_no;
	}

	public String getClear_channel_attr_1() {
		return clear_channel_attr_1;
	}

	public void setClear_channel_attr_1(String clear_channel_attr_1) {
		this.clear_channel_attr_1 = clear_channel_attr_1;
	}

	public String getClear_channel_attr_2() {
		return clear_channel_attr_2;
	}

	public void setClear_channel_attr_2(String clear_channel_attr_2) {
		this.clear_channel_attr_2 = clear_channel_attr_2;
	}

	public String getClear_channel_attr_3() {
		return clear_channel_attr_3;
	}

	public void setClear_channel_attr_3(String clear_channel_attr_3) {
		this.clear_channel_attr_3 = clear_channel_attr_3;
	}

	public String getClear_channel_attr_4() {
		return clear_channel_attr_4;
	}

	public void setClear_channel_attr_4(String clear_channel_attr_4) {
		this.clear_channel_attr_4 = clear_channel_attr_4;
	}

	public String getClear_channel_attr_5() {
		return clear_channel_attr_5;
	}

	public void setClear_channel_attr_5(String clear_channel_attr_5) {
		this.clear_channel_attr_5 = clear_channel_attr_5;
	}

	public String getClear_channel_attr_6() {
		return clear_channel_attr_6;
	}

	public void setClear_channel_attr_6(String clear_channel_attr_6) {
		this.clear_channel_attr_6 = clear_channel_attr_6;
	}

	public String getLedger_extend_field_1() {
		return ledger_extend_field_1;
	}

	public void setLedger_extend_field_1(String ledger_extend_field_1) {
		this.ledger_extend_field_1 = ledger_extend_field_1;
	}

	public String getLedger_extend_field_2() {
		return ledger_extend_field_2;
	}

	public void setLedger_extend_field_2(String ledger_extend_field_2) {
		this.ledger_extend_field_2 = ledger_extend_field_2;
	}

	public String getLedger_extend_field_3() {
		return ledger_extend_field_3;
	}

	public void setLedger_extend_field_3(String ledger_extend_field_3) {
		this.ledger_extend_field_3 = ledger_extend_field_3;
	}

	public String getLedger_extend_field_4() {
		return ledger_extend_field_4;
	}

	public void setLedger_extend_field_4(String ledger_extend_field_4) {
		this.ledger_extend_field_4 = ledger_extend_field_4;
	}

	public String getLedger_extend_field_5() {
		return ledger_extend_field_5;
	}

	public void setLedger_extend_field_5(String ledger_extend_field_5) {
		this.ledger_extend_field_5 = ledger_extend_field_5;
	}

	public String getLedger_extend_field_6() {
		return ledger_extend_field_6;
	}

	public void setLedger_extend_field_6(String ledger_extend_field_6) {
		this.ledger_extend_field_6 = ledger_extend_field_6;
	}

	public String getLedger_extend_field_7() {
		return ledger_extend_field_7;
	}

	public void setLedger_extend_field_7(String ledger_extend_field_7) {
		this.ledger_extend_field_7 = ledger_extend_field_7;
	}

	public String getLedger_extend_field_8() {
		return ledger_extend_field_8;
	}

	public void setLedger_extend_field_8(String ledger_extend_field_8) {
		this.ledger_extend_field_8 = ledger_extend_field_8;
	}

	public String getLedger_extend_field_9() {
		return ledger_extend_field_9;
	}

	public void setLedger_extend_field_9(String ledger_extend_field_9) {
		this.ledger_extend_field_9 = ledger_extend_field_9;
	}

	public String getLedger_extend_field_10() {
		return ledger_extend_field_10;
	}

	public void setLedger_extend_field_10(String ledger_extend_field_10) {
		this.ledger_extend_field_10 = ledger_extend_field_10;
	}

	public String getLedger_merchant_extend_field_1() {
		return ledger_merchant_extend_field_1;
	}

	public void setLedger_merchant_extend_field_1(
			String ledger_merchant_extend_field_1) {
		this.ledger_merchant_extend_field_1 = ledger_merchant_extend_field_1;
	}

	public String getLedger_merchant_extend_field_2() {
		return ledger_merchant_extend_field_2;
	}

	public void setLedger_merchant_extend_field_2(
			String ledger_merchant_extend_field_2) {
		this.ledger_merchant_extend_field_2 = ledger_merchant_extend_field_2;
	}

	public String getLedger_merchant_extend_field_3() {
		return ledger_merchant_extend_field_3;
	}

	public void setLedger_merchant_extend_field_3(
			String ledger_merchant_extend_field_3) {
		this.ledger_merchant_extend_field_3 = ledger_merchant_extend_field_3;
	}

	public String getAdjust_amount() {
		return adjust_amount;
	}

	public void setAdjust_amount(String adjust_amount) {
		this.adjust_amount = adjust_amount;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}