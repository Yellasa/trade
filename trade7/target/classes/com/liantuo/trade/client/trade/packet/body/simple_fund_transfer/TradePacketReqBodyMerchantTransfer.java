package com.liantuo.trade.client.trade.packet.body.simple_fund_transfer;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

/**
 * 0007_001_001
 * 成员转账请求VO
 */
public class TradePacketReqBodyMerchantTransfer extends TradeRequestBody {

    @Pattern(message = "out_trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no;

    @NotBlank(message = "out_trade_no_ext is required", groups = {Required.class})
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\d|a-z-A-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no_ext;

    @NotBlank(message = "payment_account_no is required", groups = {Required.class})
    @Pattern(message = "payment_account_no format error", regexp = "[\\w]{6,32}", groups = Format.class)
    private String payment_account_no;
    
    @Pattern(message = "payment_account_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String payment_account_extend_field_1;

    @Pattern(message = "payment_account_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String payment_account_extend_field_2;

    @Pattern(message = "payment_account_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String payment_account_extend_field_3;

//    @NotBlank(message = "fund_pool_no is required", groups = {Required.class})
//    private String fund_pool_no;
    
    //CA成员收款信息
    @NotBlank(message = "receive_account_no is required", groups = {Required.class})
    @Pattern(message = "receive_account_no format error", regexp = "[\\w]{6,32}", groups = Format.class)
    private String receive_account_no;
    
    @Pattern(message = "receive_account_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String receive_account_extend_field_1;
    
    @Pattern(message = "receive_account_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String receive_account_extend_field_2;
    
    @Pattern(message = "receive_account_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String receive_account_extend_field_3;
    
    /**
     * 参数名：转账金额
     */
    @NotBlank(message = "transfer_amount is required", groups = { Required.class })
    @DecimalMin(message = "transfer_amount format error,max length 13", groups = { Format.class }, value = "0.00")
    @Digits(message = "transfer_amount format error,max length 13", groups = { Format.class }, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String transfer_amount;
    
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

	public void setPayment_account_extend_field_1(String payment_account_extend_field_1) {
		this.payment_account_extend_field_1 = payment_account_extend_field_1;
	}

	public String getPayment_account_extend_field_2() {
		return payment_account_extend_field_2;
	}

	public void setPayment_account_extend_field_2(String payment_account_extend_field_2) {
		this.payment_account_extend_field_2 = payment_account_extend_field_2;
	}

	public String getPayment_account_extend_field_3() {
		return payment_account_extend_field_3;
	}

	public void setPayment_account_extend_field_3(String payment_account_extend_field_3) {
		this.payment_account_extend_field_3 = payment_account_extend_field_3;
	}

//	public String getFund_pool_no() {
//		return fund_pool_no;
//	}
//
//	public void setFund_pool_no(String fund_pool_no) {
//		this.fund_pool_no = fund_pool_no;
//	}

	public String getReceive_account_no() {
		return receive_account_no;
	}

	public void setReceive_account_no(String receive_account_no) {
		this.receive_account_no = receive_account_no;
	}

	public String getReceive_account_extend_field_1() {
		return receive_account_extend_field_1;
	}

	public void setReceive_account_extend_field_1(String receive_account_extend_field_1) {
		this.receive_account_extend_field_1 = receive_account_extend_field_1;
	}

	public String getReceive_account_extend_field_2() {
		return receive_account_extend_field_2;
	}

	public void setReceive_account_extend_field_2(String receive_account_extend_field_2) {
		this.receive_account_extend_field_2 = receive_account_extend_field_2;
	}

	public String getReceive_account_extend_field_3() {
		return receive_account_extend_field_3;
	}

	public void setReceive_account_extend_field_3(String receive_account_extend_field_3) {
		this.receive_account_extend_field_3 = receive_account_extend_field_3;
	}

	public String getTransfer_amount() {
		return transfer_amount;
	}

	public void setTransfer_amount(String transfer_amount) {
		this.transfer_amount = transfer_amount;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}