package com.liantuo.trade.client.trade.packet.body.simple_fund_handle;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

/**
 * @ClassName:     TradePacketReqBodyAdjustAccount.java
 * @Description:   0003_001_001 V1.0CA调整
 * Company:联拓金融信息服务有限公司
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-4-1 下午5:18:34 
 */
public class TradePacketReqBodyAdjustAccount extends TradeRequestBody {

    /**
     * 交易发起方业务系统订单号
     */
    @Pattern(message = "out_trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no;

    /**
     * 交易发起方发起请求编号
     */
    @NotBlank(message = "out_trade_no_ext is required", groups = {Required.class})
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no_ext;

    /**
     * 付出CA账户编号
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
     * 收到CA账户编号
     */
    @NotBlank(message = "receive_account_no is required", groups = {Required.class})
    @Pattern(message = "receive_account_no format error", regexp = "[\\w]{6,32}", groups = Format.class)
    private String receive_account_no;
    
    /**
     * 收到CA账务备注1
     */
    @Pattern(message = "receive_account_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String receive_account_extend_field_1;
    
    /**
     * 收到CA账务备注2
     */
    @Pattern(message = "receive_account_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String receive_account_extend_field_2;
    
    /**
     * 收到CA账务备注3
     */
    @Pattern(message = "receive_account_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String receive_account_extend_field_3;
    
    /**
     * 调整金额
     */
    @NotBlank(message = "adjust_amount is required", groups = {Required.class})
    @DecimalMin(message = "adjust_amount format error", groups = {Format.class}, value = "0.00")
    @Digits(message = "adjust_amount format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String adjust_amount;

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

    

    public String getOut_trade_no_ext() {
        return out_trade_no_ext;
    }

    public void setOut_trade_no_ext(String out_trade_no_ext) {
        this.out_trade_no_ext = out_trade_no_ext;
    }

    public String getPayment_account_no() {
        return payment_account_no;
    }

    public void setPayment_account_no(String payment_account_no) {
        this.payment_account_no = payment_account_no;
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

	public String getReceive_account_no() {
		return receive_account_no;
	}

	public void setReceive_account_no(String receive_account_no) {
		this.receive_account_no = receive_account_no;
	}

	public String getReceive_account_extend_field_1() {
		return receive_account_extend_field_1;
	}

	public void setReceive_account_extend_field_1(
			String receive_account_extend_field_1) {
		this.receive_account_extend_field_1 = receive_account_extend_field_1;
	}

	public String getReceive_account_extend_field_2() {
		return receive_account_extend_field_2;
	}

	public void setReceive_account_extend_field_2(
			String receive_account_extend_field_2) {
		this.receive_account_extend_field_2 = receive_account_extend_field_2;
	}

	public String getReceive_account_extend_field_3() {
		return receive_account_extend_field_3;
	}

	public void setReceive_account_extend_field_3(
			String receive_account_extend_field_3) {
		this.receive_account_extend_field_3 = receive_account_extend_field_3;
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