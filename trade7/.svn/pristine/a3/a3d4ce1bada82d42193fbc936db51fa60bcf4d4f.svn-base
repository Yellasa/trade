package com.liantuo.trade.client.vo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

/**
 * @author jiangkun
 * @version V1.0
 * @ClassName: TradePacketReqBodyRechargeOnline
 * @Description: 0005_001_004 V1.0 在线充值-支付宝批量付款请求
 * Company:联拓金融信息服务有限公司
 * @Date 2016-4-26
 */
public class TradePacketReqBodyRechargeOnline extends TradeRequestBodyVisible {

    /**
     * 参数名：交易发起方发起请求编号</br>
     * 参数类型：必填</br>
     */
    @JsonIgnore
    @NotBlank(message = "out_trade_no_ext is required", groups = {Required.class})
    @Pattern(message = "out_trade_no_ext format error", regexp = "[\\d|a-zA-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no_ext;

    /**
     * 参数名：交易发起方业务系统订单号</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "out_trade_no format error", regexp = ".{0}|[\\d|a-zA-Z|_]{8,64}", groups = Format.class)
    private String out_trade_no;

    /**
     * 参数名：支付金额</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "pay_amount is required", groups = {Required.class})
    @DecimalMin(message = "pay_amount format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "pay_amount format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String pay_amount;

    /**
     * 参数名：充值渠道身份编号</br>
     * 参数类型：可空</br>
     */
    @NotBlank(message = "transaction_id is required", groups = {Required.class})
    @Pattern(message = "transaction_id format error", regexp = ".{0}|[\\d|a-zA-Z|_]{15}", groups = Format.class)
    private String transaction_id;

    /**
     * 参数名：充值付款台账客户保留字段1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "recharge_ledger_extend_field_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String recharge_ledger_extend_field_1;

    /**
     * 参数名：充值付款台账客户保留字段2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "recharge_ledger_extend_field_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String recharge_ledger_extend_field_2;

    /**
     * 参数名：充值付款台账客户保留字段3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "recharge_ledger_extend_field_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String recharge_ledger_extend_field_3;

    /**
     * 参数名：充值CA账户编号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "recharge_account_no is required", groups = {Required.class})
    @Pattern(message = "recharge_account_no format error", regexp = "[\\d|a-zA-Z|_]{6,32}", groups = Format.class)
    private String recharge_account_no;

    /**
     * 参数名：充值CA账户入账账务历史1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "recharge_account_extend_field_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String recharge_account_extend_field_1;

    /**
     * 参数名：充值CA账户入账账务历史2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "recharge_account_extend_field_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String recharge_account_extend_field_2;

    /**
     * 参数名：充值CA账户入账账务历史3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "recharge_account_extend_field_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String recharge_account_extend_field_3;

    /**
     * 参数名：充值金额</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "recharge_amount is required", groups = {Required.class})
    @DecimalMin(message = "recharge_amount format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "recharge_amount format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String recharge_amount;

    /**
     * 参数名：异步通知地址</br>
     * 参数类型：可空</br>
     */
    @NotBlank(message = "notify_url is required", groups = {Required.class})
    @Pattern(message = "notify_url format error", regexp = ".{0,1024}", groups = Format.class)
    private String notify_url;

    /**
     * 参数名：充值手续费金额</br>
     * 参数类型：可空</br>
     */
    @DecimalMin(message = "fee_amount format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "fee_amount format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String fee_amount;

    /**
     * 参数名：充值手续费接收方式</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_way format error", regexp = ".{0}|1|2", groups = Format.class)
    private String fee_way;

    /**
     * 参数名：充值手续费收款账户</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_receive_account_no format error", regexp = ".{0}|[\\d|a-zA-Z|_]{6,32}", groups = Format.class)
    private String fee_receive_account_no;

    /**
     * 参数名：充值手续费充值CA账户扣费账务历史1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_pay_account_extend_field_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_pay_account_extend_field_1;

    /**
     * 参数名：充值手续费充值CA账户扣费账务历史2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_pay_account_extend_field_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_pay_account_extend_field_2;

    /**
     * 参数名：充值手续费充值CA账户扣费账务历史3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_pay_account_extend_field_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_pay_account_extend_field_3;

    /**
     * 参数名：充值手续费收款账户入账账务历史1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_receive_account_extend_field_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_receive_account_extend_field_1;

    /**
     * 参数名：充值手续费收款账户入账账务历史2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_receive_account_extend_field_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_receive_account_extend_field_2;

    /**
     * 参数名：充值手续费收款账户入账账务历史3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_receive_account_extend_field_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_receive_account_extend_field_3;

    /**
     * 参数名：充值手续费台账类别</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_ledger_type format error", regexp = ".{0}|1|2", groups = Format.class)
    private String fee_ledger_type;

    /**
     * 参数名：充值手续费台账客户保留字段1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_ledger_extend_field_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_ledger_extend_field_1;

    /**
     * 参数名：充值手续费台账客户保留字段2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_ledger_extend_field_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_ledger_extend_field_2;

    /**
     * 参数名：充值手续费台账客户保留字段3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_ledger_extend_field_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_ledger_extend_field_3;

    /**
     * 参数名：充值手续费损益属性1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_1;

    /**
     * 参数名：充值手续费损益属性2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_2;

    /**
     * 参数名：充值手续费损益属性3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_3;

    /**
     * 参数名：充值手续费损益属性4</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_4;

    /**
     * 参数名：充值手续费损益属性5</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_5 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_5;

    /**
     * 参数名：充值手续费损益属性6</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_6 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_6;

    /**
     * 参数名：充值手续费损益属性7</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_7 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_7;

    /**
     * 参数名：充值手续费损益属性8</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_8 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_8;

    /**
     * 参数名：充值手续费损益属性9</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_9 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_9;

    /**
     * 参数名：充值手续费损益属性10</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "fee_profit_loss_attr_10 format error", regexp = ".{0,128}", groups = Format.class)
    private String fee_profit_loss_attr_10;

    /**
     * 参数名：充值补差金额</br>
     * 参数类型：可空</br>
     */
    @DecimalMin(message = "supply_amount format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "supply_amount format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String supply_amount;

    /**
     * 参数名：充值补差付出方式</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_way format error", regexp = ".{0}|1|2", groups = Format.class)
    private String supply_way;

    /**
     * 参数名：充值补差付款账户</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_pay_account_no format error", regexp = ".{0}|[\\d|a-zA-Z|_]{6,32}", groups = Format.class)
    private String supply_pay_account_no;

    /**
     * 参数名：充值补差充值CA账户扣费账务历史1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_pay_account_extend_field_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_pay_account_extend_field_1;

    /**
     * 参数名：充值补差充值CA账户扣费账务历史2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_pay_account_extend_field_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_pay_account_extend_field_2;

    /**
     * 参数名：充值补差充值CA账户扣费账务历史3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_pay_account_extend_field_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_pay_account_extend_field_3;

    /**
     * 参数名：充值补差台账类别</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_ledger_type format error", regexp = ".{0}|1|2", groups = Format.class)
    private String supply_ledger_type;

    /**
     * 参数名：充值补差台账客户保留字段1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_ledger_extend_field_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_ledger_extend_field_1;

    /**
     * 参数名：充值补差台账客户保留字段2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_ledger_extend_field_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_ledger_extend_field_2;

    /**
     * 参数名：充值补差台账客户保留字段3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_ledger_extend_field_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_ledger_extend_field_3;

    /**
     * 参数名：充值补差损益属性1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_1;

    /**
     * 参数名：充值补差损益属性2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_2;

    /**
     * 参数名：充值补差损益属性3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_3;

    /**
     * 参数名：充值补差损益属性4</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_4;

    /**
     * 参数名：充值补差损益属性5</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_5 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_5;

    /**
     * 参数名：充值补差损益属性6</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_6 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_6;

    /**
     * 参数名：充值补差损益属性7</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_7 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_7;

    /**
     * 参数名：充值补差损益属性8</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_8 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_8;

    /**
     * 参数名：充值补差损益属性9</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_9 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_9;

    /**
     * 参数名：充值补差损益属性10</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "supply_profit_loss_attr_10 format error", regexp = ".{0,128}", groups = Format.class)
    private String supply_profit_loss_attr_10;

    /**
     * 参数名：付款账号名</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "account_name is required", groups = {Required.class})
    @Pattern(message = "account_name format error", regexp = ".{1,128}", groups = Format.class)
    private String account_name;

    /**
     * 参数名：付款账号别名</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "buyer_account_name format error", regexp = ".{1,128}", groups = Format.class)
    private String buyer_account_name;

    /**
     * 参数名：付款账号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "email is required", groups = {Required.class})
    @Pattern(message = "email format error", regexp = ".{1,128}", groups = Format.class)
    private String email;

    /**
     * 参数名：收款账号姓名</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "receive_name is required", groups = {Required.class})
    @Pattern(message = "receive_name format error", regexp = ".{1,128}", groups = Format.class)
    private String receive_name;

    /**
     * 参数名：收款方账号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "receive_email is required", groups = {Required.class})
    @Pattern(message = "receive_email format error", regexp = ".{1,128}", groups = Format.class)
    private String receive_email;

    /**
     * 参数名：备注说明</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "pay_remark is required", groups = {Required.class})
    @Pattern(message = "pay_remark format error", regexp = ".{1,100}", groups = Format.class)
    private String pay_remark;

    /**
     * 参数名：支付日期</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "pay_date is required", groups = {Required.class})
    @Pattern(message = "pay_date format error", regexp = "[\\d]{8}", groups = Format.class)
    private String pay_date;

    /**
     * 参数名：业务扩展参数</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "extend_param format error", regexp = ".{0,200}", groups = Format.class)
    private String extend_param;

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

    public String getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(String pay_amount) {
        this.pay_amount = pay_amount;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getRecharge_ledger_extend_field_1() {
        return recharge_ledger_extend_field_1;
    }

    public void setRecharge_ledger_extend_field_1(
            String recharge_ledger_extend_field_1) {
        this.recharge_ledger_extend_field_1 = recharge_ledger_extend_field_1;
    }

    public String getRecharge_ledger_extend_field_2() {
        return recharge_ledger_extend_field_2;
    }

    public void setRecharge_ledger_extend_field_2(
            String recharge_ledger_extend_field_2) {
        this.recharge_ledger_extend_field_2 = recharge_ledger_extend_field_2;
    }

    public String getRecharge_ledger_extend_field_3() {
        return recharge_ledger_extend_field_3;
    }

    public void setRecharge_ledger_extend_field_3(
            String recharge_ledger_extend_field_3) {
        this.recharge_ledger_extend_field_3 = recharge_ledger_extend_field_3;
    }

    public String getRecharge_account_no() {
        return recharge_account_no;
    }

    public void setRecharge_account_no(String recharge_account_no) {
        this.recharge_account_no = recharge_account_no;
    }

    public String getRecharge_account_extend_field_1() {
        return recharge_account_extend_field_1;
    }

    public void setRecharge_account_extend_field_1(
            String recharge_account_extend_field_1) {
        this.recharge_account_extend_field_1 = recharge_account_extend_field_1;
    }

    public String getRecharge_account_extend_field_2() {
        return recharge_account_extend_field_2;
    }

    public void setRecharge_account_extend_field_2(
            String recharge_account_extend_field_2) {
        this.recharge_account_extend_field_2 = recharge_account_extend_field_2;
    }

    public String getRecharge_account_extend_field_3() {
        return recharge_account_extend_field_3;
    }

    public void setRecharge_account_extend_field_3(
            String recharge_account_extend_field_3) {
        this.recharge_account_extend_field_3 = recharge_account_extend_field_3;
    }

    public String getRecharge_amount() {
        return recharge_amount;
    }

    public void setRecharge_amount(String recharge_amount) {
        this.recharge_amount = recharge_amount;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getFee_amount() {
        return fee_amount;
    }

    public void setFee_amount(String fee_amount) {
        this.fee_amount = fee_amount;
    }

    public String getFee_way() {
        return fee_way;
    }

    public void setFee_way(String fee_way) {
        this.fee_way = fee_way;
    }

    public String getFee_receive_account_no() {
        return fee_receive_account_no;
    }

    public void setFee_receive_account_no(String fee_receive_account_no) {
        this.fee_receive_account_no = fee_receive_account_no;
    }

    public String getFee_pay_account_extend_field_1() {
        return fee_pay_account_extend_field_1;
    }

    public void setFee_pay_account_extend_field_1(
            String fee_pay_account_extend_field_1) {
        this.fee_pay_account_extend_field_1 = fee_pay_account_extend_field_1;
    }

    public String getFee_pay_account_extend_field_2() {
        return fee_pay_account_extend_field_2;
    }

    public void setFee_pay_account_extend_field_2(
            String fee_pay_account_extend_field_2) {
        this.fee_pay_account_extend_field_2 = fee_pay_account_extend_field_2;
    }

    public String getFee_pay_account_extend_field_3() {
        return fee_pay_account_extend_field_3;
    }

    public void setFee_pay_account_extend_field_3(
            String fee_pay_account_extend_field_3) {
        this.fee_pay_account_extend_field_3 = fee_pay_account_extend_field_3;
    }

    public String getFee_receive_account_extend_field_1() {
        return fee_receive_account_extend_field_1;
    }

    public void setFee_receive_account_extend_field_1(
            String fee_receive_account_extend_field_1) {
        this.fee_receive_account_extend_field_1 = fee_receive_account_extend_field_1;
    }

    public String getFee_receive_account_extend_field_2() {
        return fee_receive_account_extend_field_2;
    }

    public void setFee_receive_account_extend_field_2(
            String fee_receive_account_extend_field_2) {
        this.fee_receive_account_extend_field_2 = fee_receive_account_extend_field_2;
    }

    public String getFee_receive_account_extend_field_3() {
        return fee_receive_account_extend_field_3;
    }

    public void setFee_receive_account_extend_field_3(
            String fee_receive_account_extend_field_3) {
        this.fee_receive_account_extend_field_3 = fee_receive_account_extend_field_3;
    }

    public String getFee_ledger_type() {
        return fee_ledger_type;
    }

    public void setFee_ledger_type(String fee_ledger_type) {
        this.fee_ledger_type = fee_ledger_type;
    }

    public String getFee_ledger_extend_field_1() {
        return fee_ledger_extend_field_1;
    }

    public void setFee_ledger_extend_field_1(String fee_ledger_extend_field_1) {
        this.fee_ledger_extend_field_1 = fee_ledger_extend_field_1;
    }

    public String getFee_ledger_extend_field_2() {
        return fee_ledger_extend_field_2;
    }

    public void setFee_ledger_extend_field_2(String fee_ledger_extend_field_2) {
        this.fee_ledger_extend_field_2 = fee_ledger_extend_field_2;
    }

    public String getFee_ledger_extend_field_3() {
        return fee_ledger_extend_field_3;
    }

    public void setFee_ledger_extend_field_3(String fee_ledger_extend_field_3) {
        this.fee_ledger_extend_field_3 = fee_ledger_extend_field_3;
    }

    public String getFee_profit_loss_attr_1() {
        return fee_profit_loss_attr_1;
    }

    public void setFee_profit_loss_attr_1(String fee_profit_loss_attr_1) {
        this.fee_profit_loss_attr_1 = fee_profit_loss_attr_1;
    }

    public String getFee_profit_loss_attr_2() {
        return fee_profit_loss_attr_2;
    }

    public void setFee_profit_loss_attr_2(String fee_profit_loss_attr_2) {
        this.fee_profit_loss_attr_2 = fee_profit_loss_attr_2;
    }

    public String getFee_profit_loss_attr_3() {
        return fee_profit_loss_attr_3;
    }

    public void setFee_profit_loss_attr_3(String fee_profit_loss_attr_3) {
        this.fee_profit_loss_attr_3 = fee_profit_loss_attr_3;
    }

    public String getFee_profit_loss_attr_4() {
        return fee_profit_loss_attr_4;
    }

    public void setFee_profit_loss_attr_4(String fee_profit_loss_attr_4) {
        this.fee_profit_loss_attr_4 = fee_profit_loss_attr_4;
    }

    public String getFee_profit_loss_attr_5() {
        return fee_profit_loss_attr_5;
    }

    public void setFee_profit_loss_attr_5(String fee_profit_loss_attr_5) {
        this.fee_profit_loss_attr_5 = fee_profit_loss_attr_5;
    }

    public String getFee_profit_loss_attr_6() {
        return fee_profit_loss_attr_6;
    }

    public void setFee_profit_loss_attr_6(String fee_profit_loss_attr_6) {
        this.fee_profit_loss_attr_6 = fee_profit_loss_attr_6;
    }

    public String getFee_profit_loss_attr_7() {
        return fee_profit_loss_attr_7;
    }

    public void setFee_profit_loss_attr_7(String fee_profit_loss_attr_7) {
        this.fee_profit_loss_attr_7 = fee_profit_loss_attr_7;
    }

    public String getFee_profit_loss_attr_8() {
        return fee_profit_loss_attr_8;
    }

    public void setFee_profit_loss_attr_8(String fee_profit_loss_attr_8) {
        this.fee_profit_loss_attr_8 = fee_profit_loss_attr_8;
    }

    public String getFee_profit_loss_attr_9() {
        return fee_profit_loss_attr_9;
    }

    public void setFee_profit_loss_attr_9(String fee_profit_loss_attr_9) {
        this.fee_profit_loss_attr_9 = fee_profit_loss_attr_9;
    }

    public String getFee_profit_loss_attr_10() {
        return fee_profit_loss_attr_10;
    }

    public void setFee_profit_loss_attr_10(String fee_profit_loss_attr_10) {
        this.fee_profit_loss_attr_10 = fee_profit_loss_attr_10;
    }

    public String getSupply_amount() {
        return supply_amount;
    }

    public void setSupply_amount(String supply_amount) {
        this.supply_amount = supply_amount;
    }

    public String getSupply_way() {
        return supply_way;
    }

    public void setSupply_way(String supply_way) {
        this.supply_way = supply_way;
    }

    public String getSupply_pay_account_no() {
        return supply_pay_account_no;
    }

    public void setSupply_pay_account_no(String supply_pay_account_no) {
        this.supply_pay_account_no = supply_pay_account_no;
    }

    public String getSupply_pay_account_extend_field_1() {
        return supply_pay_account_extend_field_1;
    }

    public void setSupply_pay_account_extend_field_1(
            String supply_pay_account_extend_field_1) {
        this.supply_pay_account_extend_field_1 = supply_pay_account_extend_field_1;
    }

    public String getSupply_pay_account_extend_field_2() {
        return supply_pay_account_extend_field_2;
    }

    public void setSupply_pay_account_extend_field_2(
            String supply_pay_account_extend_field_2) {
        this.supply_pay_account_extend_field_2 = supply_pay_account_extend_field_2;
    }

    public String getSupply_pay_account_extend_field_3() {
        return supply_pay_account_extend_field_3;
    }

    public void setSupply_pay_account_extend_field_3(
            String supply_pay_account_extend_field_3) {
        this.supply_pay_account_extend_field_3 = supply_pay_account_extend_field_3;
    }

    public String getSupply_ledger_type() {
        return supply_ledger_type;
    }

    public void setSupply_ledger_type(String supply_ledger_type) {
        this.supply_ledger_type = supply_ledger_type;
    }

    public String getSupply_ledger_extend_field_1() {
        return supply_ledger_extend_field_1;
    }

    public void setSupply_ledger_extend_field_1(String supply_ledger_extend_field_1) {
        this.supply_ledger_extend_field_1 = supply_ledger_extend_field_1;
    }

    public String getSupply_ledger_extend_field_2() {
        return supply_ledger_extend_field_2;
    }

    public void setSupply_ledger_extend_field_2(String supply_ledger_extend_field_2) {
        this.supply_ledger_extend_field_2 = supply_ledger_extend_field_2;
    }

    public String getSupply_ledger_extend_field_3() {
        return supply_ledger_extend_field_3;
    }

    public void setSupply_ledger_extend_field_3(String supply_ledger_extend_field_3) {
        this.supply_ledger_extend_field_3 = supply_ledger_extend_field_3;
    }

    public String getSupply_profit_loss_attr_1() {
        return supply_profit_loss_attr_1;
    }

    public void setSupply_profit_loss_attr_1(String supply_profit_loss_attr_1) {
        this.supply_profit_loss_attr_1 = supply_profit_loss_attr_1;
    }

    public String getSupply_profit_loss_attr_2() {
        return supply_profit_loss_attr_2;
    }

    public void setSupply_profit_loss_attr_2(String supply_profit_loss_attr_2) {
        this.supply_profit_loss_attr_2 = supply_profit_loss_attr_2;
    }

    public String getSupply_profit_loss_attr_3() {
        return supply_profit_loss_attr_3;
    }

    public void setSupply_profit_loss_attr_3(String supply_profit_loss_attr_3) {
        this.supply_profit_loss_attr_3 = supply_profit_loss_attr_3;
    }

    public String getSupply_profit_loss_attr_4() {
        return supply_profit_loss_attr_4;
    }

    public void setSupply_profit_loss_attr_4(String supply_profit_loss_attr_4) {
        this.supply_profit_loss_attr_4 = supply_profit_loss_attr_4;
    }

    public String getSupply_profit_loss_attr_5() {
        return supply_profit_loss_attr_5;
    }

    public void setSupply_profit_loss_attr_5(String supply_profit_loss_attr_5) {
        this.supply_profit_loss_attr_5 = supply_profit_loss_attr_5;
    }

    public String getSupply_profit_loss_attr_6() {
        return supply_profit_loss_attr_6;
    }

    public void setSupply_profit_loss_attr_6(String supply_profit_loss_attr_6) {
        this.supply_profit_loss_attr_6 = supply_profit_loss_attr_6;
    }

    public String getSupply_profit_loss_attr_7() {
        return supply_profit_loss_attr_7;
    }

    public void setSupply_profit_loss_attr_7(String supply_profit_loss_attr_7) {
        this.supply_profit_loss_attr_7 = supply_profit_loss_attr_7;
    }

    public String getSupply_profit_loss_attr_8() {
        return supply_profit_loss_attr_8;
    }

    public void setSupply_profit_loss_attr_8(String supply_profit_loss_attr_8) {
        this.supply_profit_loss_attr_8 = supply_profit_loss_attr_8;
    }

    public String getSupply_profit_loss_attr_9() {
        return supply_profit_loss_attr_9;
    }

    public void setSupply_profit_loss_attr_9(String supply_profit_loss_attr_9) {
        this.supply_profit_loss_attr_9 = supply_profit_loss_attr_9;
    }

    public String getSupply_profit_loss_attr_10() {
        return supply_profit_loss_attr_10;
    }

    public void setSupply_profit_loss_attr_10(String supply_profit_loss_attr_10) {
        this.supply_profit_loss_attr_10 = supply_profit_loss_attr_10;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getBuyer_account_name() {
        return buyer_account_name;
    }

    public void setBuyer_account_name(String buyer_account_name) {
        this.buyer_account_name = buyer_account_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }

    public String getReceive_email() {
        return receive_email;
    }

    public void setReceive_email(String receive_email) {
        this.receive_email = receive_email;
    }

    public String getPay_remark() {
        return pay_remark;
    }

    public void setPay_remark(String pay_remark) {
        this.pay_remark = pay_remark;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getExtend_param() {
        return extend_param;
    }

    public void setExtend_param(String extend_param) {
        this.extend_param = extend_param;
    }


}
