package com.liantuo.trade.client.trade.packet.body;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.WeakRequired;
import com.liantuo.trade.validator.ConflictWeak;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


/**
 * 其他损益台账List Vo
 *
 * @author yangting
 *         2016年6月2日 上午10:35:27
 */
@JsonIgnoreProperties({"merchant_extend_field_1","merchant_extend_field_2","merchant_extend_field_3","profit_loss_attr_1","profit_loss_attr_2",
		"profit_loss_attr_3","profit_loss_attr_4","profit_loss_attr_5","profit_loss_attr_6","profit_loss_attr_7","profit_loss_attr_8","profit_loss_attr_9","profit_loss_attr_10"})
public class TradePacketReqBodyOtherPofitLossLedger extends TradeRequestBody {

    /**
     * 参数名：交易客户保留字段1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_1;

    /**
     * 参数名：交易客户保留字段2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_2;

    /**
     * 参数名：交易客户保留字段3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "merchant_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String merchant_extend_field_3;

    @Pattern(message = "profit_loss_attr_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_1;


    @Pattern(message = "profit_loss_attr_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_2;


    @Pattern(message = "profit_loss_attr_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_3;


    @Pattern(message = "profit_loss_attr_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_4;


    @Pattern(message = "profit_loss_attr_5 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_5;


    @Pattern(message = "profit_loss_attr_6 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_6;


    @Pattern(message = "profit_loss_attr_7 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_7;


    @Pattern(message = "profit_loss_attr_8 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_8;


    @Pattern(message = "profit_loss_attr_9 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_9;


    @Pattern(message = "profit_loss_attr_10 format error", regexp = ".{0,128}", groups = Format.class)
    private String profit_loss_attr_10;
    
    /*
     * 以下4个金额有且只有1个金额存在
     * 有且有且只能有一个金额存在
     */
    @DecimalMin(message = "income_incr format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "income_incr format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String income_incr;

    @DecimalMin(message = "income_decr format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "income_decr format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String income_decr;

    @DecimalMin(message = "cost_incr format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "cost_incr format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String cost_incr;

    @ConflictWeak(message="income_incr,income_decr,cost_incr,cost_decr有且只能有一个", 
    		exclusion_prop_name = "income_incr,income_decr,cost_incr,cost_decr",  groups = {WeakRequired.class})
    @DecimalMin(message = "cost_decr format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "cost_decr format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String cost_decr;

    public String getMerchant_extend_field_1() {
        return merchant_extend_field_1;
    }

    public void setMerchant_extend_field_1(String merchantExtendField_1) {
        merchant_extend_field_1 = merchantExtendField_1;
    }

    public String getMerchant_extend_field_2() {
        return merchant_extend_field_2;
    }

    public void setMerchant_extend_field_2(String merchantExtendField_2) {
        merchant_extend_field_2 = merchantExtendField_2;
    }

    public String getMerchant_extend_field_3() {
        return merchant_extend_field_3;
    }

    public void setMerchant_extend_field_3(String merchantExtendField_3) {
        merchant_extend_field_3 = merchantExtendField_3;
    }

    public String getProfit_loss_attr_1() {
        return profit_loss_attr_1;
    }

    public void setProfit_loss_attr_1(String profitLossAttr_1) {
        profit_loss_attr_1 = profitLossAttr_1;
    }

    public String getProfit_loss_attr_2() {
        return profit_loss_attr_2;
    }

    public void setProfit_loss_attr_2(String profitLossAttr_2) {
        profit_loss_attr_2 = profitLossAttr_2;
    }

    public String getProfit_loss_attr_3() {
        return profit_loss_attr_3;
    }

    public void setProfit_loss_attr_3(String profitLossAttr_3) {
        profit_loss_attr_3 = profitLossAttr_3;
    }

    public String getProfit_loss_attr_4() {
        return profit_loss_attr_4;
    }

    public void setProfit_loss_attr_4(String profitLossAttr_4) {
        profit_loss_attr_4 = profitLossAttr_4;
    }

    public String getProfit_loss_attr_5() {
        return profit_loss_attr_5;
    }

    public void setProfit_loss_attr_5(String profitLossAttr_5) {
        profit_loss_attr_5 = profitLossAttr_5;
    }

    public String getProfit_loss_attr_6() {
        return profit_loss_attr_6;
    }

    public void setProfit_loss_attr_6(String profitLossAttr_6) {
        profit_loss_attr_6 = profitLossAttr_6;
    }

    public String getProfit_loss_attr_7() {
        return profit_loss_attr_7;
    }

    public void setProfit_loss_attr_7(String profitLossAttr_7) {
        profit_loss_attr_7 = profitLossAttr_7;
    }

    public String getProfit_loss_attr_8() {
        return profit_loss_attr_8;
    }

    public void setProfit_loss_attr_8(String profitLossAttr_8) {
        profit_loss_attr_8 = profitLossAttr_8;
    }

    public String getProfit_loss_attr_9() {
        return profit_loss_attr_9;
    }

    public void setProfit_loss_attr_9(String profitLossAttr_9) {
        profit_loss_attr_9 = profitLossAttr_9;
    }

    public String getProfit_loss_attr_10() {
        return profit_loss_attr_10;
    }

    public void setProfit_loss_attr_10(String profitLossAttr_10) {
        profit_loss_attr_10 = profitLossAttr_10;
    }

    public String getIncome_incr() {
        return income_incr;
    }

    public void setIncome_incr(String incomeIncr) {
        income_incr = incomeIncr;
    }

    public String getIncome_decr() {
        return income_decr;
    }

    public void setIncome_decr(String incomeDecr) {
        income_decr = incomeDecr;
    }

    public String getCost_incr() {
        return cost_incr;
    }

    public void setCost_incr(String costIncr) {
        cost_incr = costIncr;
    }

    public String getCost_decr() {
        return cost_decr;
    }

    public void setCost_decr(String costDecr) {
        cost_decr = costDecr;
    }

}