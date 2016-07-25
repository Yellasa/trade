package com.liantuo.trade.client.trade.packet.body.single_payment;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import org.hibernate.validator.constraints.NotBlank;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.common.validate.WeakRequired;
import com.liantuo.trade.validator.AssociateWeak;
import com.liantuo.trade.validator.ConflictWeak;
import com.liantuo.trade.validator.date.DateTime;

/**
 * @author zzd
 * @version V1.0
 * @ClassName: TradePacketReqBodyExternalPayment 外部支付付款
 * @Description: 0006_001_002 V1.0
 * Company:联拓金融信息服务有限公司
 * @Date 2016-6-2
 */
public class TradePacketReqBodyExternalPayment extends TradeRequestBody {

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

    /**
     * 参数名：支付方式</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "pay_type is required", groups = {Required.class})
    @Pattern(message = "pay_type format error", regexp = "[45]", groups = Format.class)
    private String pay_type;

    /**
     * 参数名：付款方外部业务台账客户保留字段1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_merchant_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_merchant_extend_field_1;
    
    /**
     * 参数名：付款方外部业务台账客户保留字段2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_merchant_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_merchant_extend_field_2;
    
    /**
     * 参数名：付款方外部业务台账客户保留字段3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_merchant_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_merchant_extend_field_3;
    
    /**
     * 参数名：付款方外部收付款渠道编号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "external_pay_channel is required", groups = {Required.class})
    @Pattern(message = "external_pay_channel format error", regexp = "(.{0})||([\\da-zA-Z_]{1,16})", groups = Format.class)
    private String external_pay_channel;
    
    
    /**
     * 参数名：付款方外部收付款属性1（付出手续费金额）</br>
     * 参数类型：可空</br>
     */
    @DecimalMin(message = "external_pay_channel_fee_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "external_pay_channel_fee_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String external_pay_channel_fee_amt;
    
    
    /**
     * 参数名：付款方外部收付款属性2（退回手续费金额）</br>
     * 参数类型：可空</br>
     */
    @DecimalMin(message = "external_pay_channel_refund_fee_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "external_pay_channel_refund_fee_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String external_pay_channel_refund_fee_amt;
    
    
    /**
     * 参数名：付款方外部收付款属性3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_attr_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_pay_channel_attr_3;
    
    
    /**
     * 参数名：付款方外部收付款属性4</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_attr_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_pay_channel_attr_4;
    
    /**
     * 参数名：付款方外部收付款属性5</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_attr_5 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_pay_channel_attr_5;
    
    /**
     * 参数名：付款方外部收付款属性6</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_attr_6 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_pay_channel_attr_6;
    
    /**
     * 参数名：付款方外部收付款备注1【支付渠道身份编号】</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_transaction_id format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_transaction_id;
    
    /**
     * 参数名：付款方外部收付款备注2【付款方账户】</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_pay_account_no format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_pay_account_no;
    
    /**
     * 参数名：付款方外部收付款备注3【付款方账户名称】</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_pay_account_name format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_pay_account_name;
    
    /**
     * 参数名：付款方外部收付款备注4【提交第三方批次号】</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_batch_no format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_batch_no;
    
    /**
     * 参数名：付款方外部收付款备注5【提交第三方请求流水号】</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_serial_no format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_serial_no;
    
    /**
     * 参数名：付款方外部收付款备注6【收款方账户】</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_receive_account_no format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_receive_account_no;
    
    /**
     * 参数名：付款方外部收付款备注7【收款方账户名称】</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_receive_account_name format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_receive_account_name;
    
    /**
     * 参数名：付款方外部收付款备注8</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_field_8 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_field_8;
    
    /**
     * 参数名：付款方外部收付款备注9</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_field_9 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_field_9;
    
    /**
     * 参数名：付款方外部收付款备注10</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_field_10 format error", regexp = ".{0,1024}", groups = Format.class)
    private String external_pay_channel_field_10;
    
    /**
     * 参数名：付款方外部收付款备注11【清算日期】</br>
     * 参数类型：可空</br>
     */
    @DateTime(message = "gmt_external_pay_channel_clear format error", groups = Format.class)
    private String gmt_external_pay_channel_clear;
    
    /**
     * 参数名：付款方外部收付款备注12【出入账日期】</br>
     * 参数类型：可空</br>
     */
    @DateTime(message = "gmt_external_pay_accounting format error", groups = Format.class)
    private String gmt_external_pay_accounting;
    
    /**
     * 参数名：付款方外部收付款备注13</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_field_13 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_pay_channel_field_13;
    
    /**
     * 参数名：付款方外部收付款备注14</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_field_14 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_pay_channel_field_14;
    
    /**
     * 参数名：付款方外部收付款备注15</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "external_pay_channel_field_15 format error", regexp = ".{0,128}", groups = Format.class)
    private String external_pay_channel_field_15;
    
    /**
     * 参数名：付款方外部收款金额</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "external_pay_received_amt is required", groups = {Required.class})
    @DecimalMin(message = "external_pay_received_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "external_pay_received_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String external_pay_received_amt;
    
    /**
     * 参数名：付款方外部渠道收付款成功日期时间，程序中进行格式校验</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "gmt_success_external_pay_channel is required", groups = {Required.class})
    @DateTime(message = "gmt_success_external_pay_channel format error", groups = Format.class)
    private String gmt_success_external_pay_channel;
    
    /**
     * 参数名：付款方外部收付款渠道订单号</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "external_pay_channel_trade_no is required", groups = {Required.class})
    @Pattern(message = "external_pay_channel_trade_no format error", regexp = ".{0,128}", groups = Format.class)
    private String external_pay_channel_trade_no;
    
    /**
     * 参数名：付款方账户账户编号</br>
     * 参数类型：可空</br>
     */
    @AssociateWeak(message="付款方付出方式为第三方充付时,付款方账户账户编号、付款方账户出账金额必填", associate_prop_name = "pay_type", associate_prop_value = "5", groups = {WeakRequired.class})
    @Pattern(message = "pay_account_no format error", regexp = ".{0}|[\\da-zA-Z_]{6,32}", groups = Format.class)
    private String pay_account_no;
    
    /**
     * 参数名：付款方账户出账金额</br>
     * 参数类型：可空</br>
     */
    @AssociateWeak(message="付款方付出方式为第三方充付时,付款方账户账户编号、付款方账户出账金额必填", associate_prop_name = "pay_type", associate_prop_value = "5", groups = {WeakRequired.class})
    @DecimalMin(message = "pay_account_out_accounting_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "pay_account_out_accounting_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String pay_account_out_accounting_amt;
    
    /**
     * 参数名：付款方账户出账账务历史1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "pay_account_out_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String pay_account_out_accounting_his1;
    
    /**
     * 参数名：付款方账户出账账务历史2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "pay_account_out_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String pay_account_out_accounting_his2;
  
    /**
     * 参数名：付款方账户出账账务历史3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "pay_account_out_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String pay_account_out_accounting_his3;
  
    /**
     * 参数名：付款方账户入账账务历史1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "pay_account_in_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String pay_account_in_accounting_his1;
   
    /**
     * 参数名：付款方账户入账账务历史2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "pay_account_in_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String pay_account_in_accounting_his2;
    /**
     * 参数名：付款方账户入账账务历史3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "pay_account_in_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String pay_account_in_accounting_his3;
    
    /**
     * 参数名：付款方手续费账户账户编号</br>
     * 参数类型：可空</br>
     */
    @AssociateWeak(message="付款方手续费账户出账金额不为空时，付款方手续费账户账户编号不可为空", associate_prop_name = "pay_fee_account_out_accounting_amt", associate_prop_value = "\\d{1,13}(?:\\.\\d{1,2})?", groups = {WeakRequired.class})
    @Pattern(message = "pay_fee_account_no format error", regexp = ".{0}|[\\da-zA-Z_]{6,32}", groups = Format.class)
    private String pay_fee_account_no;
    
    /**
     * 参数名：付款方手续费账户出账金额</br>
     * 参数类型：可空</br>
     */
    @DecimalMin(message = "pay_fee_account_out_accounting_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "pay_fee_account_out_accounting_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String pay_fee_account_out_accounting_amt;
    
    /**
     * 参数名：付款方手续费账户出账账务历史1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "pay_fee_account_out_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String pay_fee_account_out_accounting_his1;
    
    /**
     * 参数名：付款方手续费账户出账账务历史2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "pay_fee_account_out_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String pay_fee_account_out_accounting_his2;
  
    /**
     * 参数名：付款方手续费账户出账账务历史3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "pay_fee_account_out_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String pay_fee_account_out_accounting_his3;
    
    /**
     * 参数名：收款方收到方式</br>
     * 参数类型：必填</br>
     */
    @ConflictWeak(message="当接收方式为损益时，损益收入增加或者损益成本减少有且只有一个",   
		      mutual_exclusion_prop_name="receive_profit_loss_cost_decr,receive_profit_loss_income_incr", exclusion_prop_value="2", groups = {WeakRequired.class})
    @NotBlank(message = "receive_type is required", groups = {Required.class})
    @Pattern(message = "receive_type format error", regexp = "[12]", groups = Format.class)
    private String receive_type;
    
    /**
     * 参数名：收款方损益业务台账客户保留字段1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    private String receive_profit_loss_extend_field_1;
    
    /**
     * 参数名：收款方损益业务台账客户保留字段2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    private String receive_profit_loss_extend_field_2;
    
    /**
     * 参数名：收款方损益业务台账客户保留字段3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    private String receive_profit_loss_extend_field_3;
    
    /**
     * 参数名：收款方损益损益属性1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_1 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_1;
    
    /**
     * 参数名：收款方损益损益属性2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_2 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_2;
    
    /**
     * 参数名：收款方损益损益属性3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_3 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_3;
    
    /**
     * 参数名：收款方损益损益属性4</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_4 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_4;
    
    /**
     * 参数名：收款方损益损益属性5</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_5 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_5;
    
    /**
     * 参数名：收款方损益损益属性6</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_6 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_6;
    
    /**
     * 参数名：收款方损益损益属性7</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_7 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_7;
    
    /**
     * 参数名：收款方损益损益属性8</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_8 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_8;
    
    /**
     * 参数名：收款方损益损益属性9</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_9 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_9;
    
    /**
     * 参数名：收款方损益损益属性10</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_profit_loss_attr_10 format error", regexp = ".{0,128}", groups = Format.class)
    private String receive_profit_loss_attr_10;
    
    /**
     * 参数名：收款方损益收入增加金额</br>
     * 参数类型：可空</br>
     */
    @DecimalMin(message = "receive_profit_loss_income_incr format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "receive_profit_loss_income_incr format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String receive_profit_loss_income_incr;
    
    
    /**
     * 参数名：收款方损益成本费用减少金额</br>
     * 参数类型：可空</br>
     */
    @DecimalMin(message = "receive_profit_loss_cost_decr format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "receive_profit_loss_cost_decr format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String receive_profit_loss_cost_decr;
    
    /**
     * 参数名：收款方账户账户编号</br>
     * 参数类型：可空</br>
     */
    @AssociateWeak(message="【收款方收到方式】为账户时,receive_account_no必填", 
    		associate_prop_name = "receive_type", associate_prop_value = "[1]", groups = {WeakRequired.class})
    @Pattern(message = "receive_account_no format error", regexp = ".{0}|[\\da-zA-Z_]{6,32}", groups = Format.class)
    private String receive_account_no;
    
    /**
     * 参数名：收款方账户入账金额</br>
     * 参数类型：可空</br>
     */
    @AssociateWeak(message="【收款方收到方式】为账户时,receive_account_in_accounting_amt必填", 
    		associate_prop_name = "receive_type", associate_prop_value = "[1]", groups = {WeakRequired.class})
    @DecimalMin(message = "receive_account_in_accounting_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "receive_account_in_accounting_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String receive_account_in_accounting_amt;
    
    /**
     * 参数名：收款方账户入账子账户类型</br>
     * 参数类型：可空</br>
     */
    @AssociateWeak(message="【收款方收到方式】为账户时,receive_account_in_accounting_type必填", 
    		associate_prop_name = "receive_type", associate_prop_value = "[1]", groups = {WeakRequired.class})
    @Pattern(message = "receive_account_in_accounting_type format error", regexp = ".{0}|[\\d]{1}", groups = Format.class)
    private String receive_account_in_accounting_type;
    
    /**
     * 参数名：收款方账户入账账务历史1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_account_in_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String receive_account_in_accounting_his1;
    
    /**
     * 参数名：收款方账户入账账务历史2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_account_in_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String receive_account_in_accounting_his2;
  
    /**
     * 参数名：收款方账户入账账务历史3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_account_in_accounting_his3receive_account_in_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String receive_account_in_accounting_his3;
    
    /**
     * 参数名：收款方手续费账户账户编号</br>
     * 参数类型：可空</br>
     */
    @AssociateWeak(message="收款方手续费账户出账金额不为空时,收款方手续费账户账户编号不能为空", 
    		associate_prop_name = "receive_fee_account_out_accounting_amt", associate_prop_value = "\\d{1,13}(?:\\.\\d{1,2})?", groups = {WeakRequired.class})
    @Pattern(message = "receive_fee_account_no format error", regexp = ".{0}|[\\da-zA-Z_]{6,32}", groups = Format.class)
    private String receive_fee_account_no;
    
    /**
     * 参数名：收款方手续费账户出账子账户类型</br>
     * 参数类型：可空</br>
     */
    @AssociateWeak(message="收款方手续费账户出账金额不为空时,收款方手续费账户出账子账户类型不能为空", 
    		associate_prop_name = "receive_fee_account_out_accounting_amt", associate_prop_value = "\\d{1,13}(?:\\.\\d{1,2})?", groups = {WeakRequired.class})
    @Pattern(message = "receive_fee_account_out_accounting_type format error", regexp = ".{0}|[\\d]{1}", groups = Format.class)
    private String receive_fee_account_out_accounting_type;
    
    /**
     * 参数名：收款方手续费账户出账金额</br>
     * 参数类型：可空</br>
     */
    @DecimalMin(message = "receive_fee_account_out_accounting_amt format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "receive_fee_account_out_accounting_amt format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
    private String receive_fee_account_out_accounting_amt;
    
    /**
     * 参数名：收款方手续费账户出账账务历史1</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_fee_account_out_accounting_his1 format error", regexp = ".{0,16}", groups = Format.class)
    private String receive_fee_account_out_accounting_his1;
    
    /**
     * 参数名：收款方手续费账户出账账务历史2</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_fee_account_out_accounting_his2 format error", regexp = ".{0,16}", groups = Format.class)
    private String receive_fee_account_out_accounting_his2;
  
    /**
     * 参数名：收款方手续费账户出账账务历史3</br>
     * 参数类型：可空</br>
     */
    @Pattern(message = "receive_fee_account_out_accounting_his3 format error", regexp = ".{0,512}", groups = Format.class)
    private String receive_fee_account_out_accounting_his3;

    @Valid
    private List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list;
    
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

	public String getMerchant_extend_field_4() {
		return merchant_extend_field_4;
	}

	public void setMerchant_extend_field_4(String merchantExtendField_4) {
		merchant_extend_field_4 = merchantExtendField_4;
	}

	public String getMerchant_extend_field_5() {
		return merchant_extend_field_5;
	}

	public void setMerchant_extend_field_5(String merchantExtendField_5) {
		merchant_extend_field_5 = merchantExtendField_5;
	}

	public String getMerchant_extend_field_6() {
		return merchant_extend_field_6;
	}

	public void setMerchant_extend_field_6(String merchantExtendField_6) {
		merchant_extend_field_6 = merchantExtendField_6;
	}

	public String getMerchant_extend_field_7() {
		return merchant_extend_field_7;
	}

	public void setMerchant_extend_field_7(String merchantExtendField_7) {
		merchant_extend_field_7 = merchantExtendField_7;
	}

	public String getMerchant_extend_field_8() {
		return merchant_extend_field_8;
	}

	public void setMerchant_extend_field_8(String merchantExtendField_8) {
		merchant_extend_field_8 = merchantExtendField_8;
	}

	public String getMerchant_extend_field_9() {
		return merchant_extend_field_9;
	}

	public void setMerchant_extend_field_9(String merchantExtendField_9) {
		merchant_extend_field_9 = merchantExtendField_9;
	}

	public String getMerchant_extend_field_10() {
		return merchant_extend_field_10;
	}

	public void setMerchant_extend_field_10(String merchantExtendField_10) {
		merchant_extend_field_10 = merchantExtendField_10;
	}

	public String getOut_trade_no_ext() {
		return out_trade_no_ext;
	}

	public void setOut_trade_no_ext(String outTradeNoExt) {
		out_trade_no_ext = outTradeNoExt;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
	}

	public String getPay_type() {
		return pay_type;
	}

	public void setPay_type(String payType) {
		pay_type = payType;
	}

	public String getExternal_pay_merchant_extend_field_1() {
		return external_pay_merchant_extend_field_1;
	}

	public void setExternal_pay_merchant_extend_field_1(
			String externalPayMerchantExtendField_1) {
		external_pay_merchant_extend_field_1 = externalPayMerchantExtendField_1;
	}

	public String getExternal_pay_merchant_extend_field_2() {
		return external_pay_merchant_extend_field_2;
	}

	public void setExternal_pay_merchant_extend_field_2(
			String externalPayMerchantExtendField_2) {
		external_pay_merchant_extend_field_2 = externalPayMerchantExtendField_2;
	}

	public String getExternal_pay_merchant_extend_field_3() {
		return external_pay_merchant_extend_field_3;
	}

	public void setExternal_pay_merchant_extend_field_3(
			String externalPayMerchantExtendField_3) {
		external_pay_merchant_extend_field_3 = externalPayMerchantExtendField_3;
	}

	public String getExternal_pay_channel() {
		return external_pay_channel;
	}

	public void setExternal_pay_channel(String externalPayChannel) {
		external_pay_channel = externalPayChannel;
	}

	public String getExternal_pay_channel_fee_amt() {
		return external_pay_channel_fee_amt;
	}

	public void setExternal_pay_channel_fee_amt(String externalPayChannelFeeAmt) {
		external_pay_channel_fee_amt = externalPayChannelFeeAmt;
	}

	public String getExternal_pay_channel_refund_fee_amt() {
		return external_pay_channel_refund_fee_amt;
	}

	public void setExternal_pay_channel_refund_fee_amt(
			String externalPayChannelRefundFeeAmt) {
		external_pay_channel_refund_fee_amt = externalPayChannelRefundFeeAmt;
	}

	public String getExternal_pay_channel_attr_3() {
		return external_pay_channel_attr_3;
	}

	public void setExternal_pay_channel_attr_3(String externalPayChannelAttr_3) {
		external_pay_channel_attr_3 = externalPayChannelAttr_3;
	}

	public String getExternal_pay_channel_attr_4() {
		return external_pay_channel_attr_4;
	}

	public void setExternal_pay_channel_attr_4(String externalPayChannelAttr_4) {
		external_pay_channel_attr_4 = externalPayChannelAttr_4;
	}

	public String getExternal_pay_channel_attr_5() {
		return external_pay_channel_attr_5;
	}

	public void setExternal_pay_channel_attr_5(String externalPayChannelAttr_5) {
		external_pay_channel_attr_5 = externalPayChannelAttr_5;
	}

	public String getExternal_pay_channel_attr_6() {
		return external_pay_channel_attr_6;
	}

	public void setExternal_pay_channel_attr_6(String externalPayChannelAttr_6) {
		external_pay_channel_attr_6 = externalPayChannelAttr_6;
	}

	public String getExternal_pay_channel_transaction_id() {
		return external_pay_channel_transaction_id;
	}

	public void setExternal_pay_channel_transaction_id(
			String externalPayChannelTransactionId) {
		external_pay_channel_transaction_id = externalPayChannelTransactionId;
	}

	public String getExternal_pay_channel_pay_account_no() {
		return external_pay_channel_pay_account_no;
	}

	public void setExternal_pay_channel_pay_account_no(
			String externalPayChannelPayAccountNo) {
		external_pay_channel_pay_account_no = externalPayChannelPayAccountNo;
	}

	public String getExternal_pay_channel_pay_account_name() {
		return external_pay_channel_pay_account_name;
	}

	public void setExternal_pay_channel_pay_account_name(
			String externalPayChannelPayAccountName) {
		external_pay_channel_pay_account_name = externalPayChannelPayAccountName;
	}

	public String getExternal_pay_channel_batch_no() {
		return external_pay_channel_batch_no;
	}

	public void setExternal_pay_channel_batch_no(String externalPayChannelBatchNo) {
		external_pay_channel_batch_no = externalPayChannelBatchNo;
	}

	public String getExternal_pay_channel_serial_no() {
		return external_pay_channel_serial_no;
	}

	public void setExternal_pay_channel_serial_no(String externalPayChannelSerialNo) {
		external_pay_channel_serial_no = externalPayChannelSerialNo;
	}

	public String getExternal_pay_channel_receive_account_no() {
		return external_pay_channel_receive_account_no;
	}

	public void setExternal_pay_channel_receive_account_no(
			String externalPayChannelReceiveAccountNo) {
		external_pay_channel_receive_account_no = externalPayChannelReceiveAccountNo;
	}

	public String getExternal_pay_channel_receive_account_name() {
		return external_pay_channel_receive_account_name;
	}

	public void setExternal_pay_channel_receive_account_name(
			String externalPayChannelReceiveAccountName) {
		external_pay_channel_receive_account_name = externalPayChannelReceiveAccountName;
	}

	public String getExternal_pay_channel_field_8() {
		return external_pay_channel_field_8;
	}

	public void setExternal_pay_channel_field_8(String externalPayChannelField_8) {
		external_pay_channel_field_8 = externalPayChannelField_8;
	}

	public String getExternal_pay_channel_field_9() {
		return external_pay_channel_field_9;
	}

	public void setExternal_pay_channel_field_9(String externalPayChannelField_9) {
		external_pay_channel_field_9 = externalPayChannelField_9;
	}
	
	
	public String getExternal_pay_channel_field_10() {
		return external_pay_channel_field_10;
	}

	public void setExternal_pay_channel_field_10(String external_pay_channel_field_10) {
		this.external_pay_channel_field_10 = external_pay_channel_field_10;
	}

	public String getGmt_external_pay_channel_clear() {
		return gmt_external_pay_channel_clear;
	}

	public void setGmt_external_pay_channel_clear(String gmtExternalPayChannelClear) {
		gmt_external_pay_channel_clear = gmtExternalPayChannelClear;
	}

	public String getGmt_external_pay_accounting() {
		return gmt_external_pay_accounting;
	}

	public void setGmt_external_pay_accounting(String gmtExternalPayAccounting) {
		gmt_external_pay_accounting = gmtExternalPayAccounting;
	}

	public String getExternal_pay_channel_field_13() {
		return external_pay_channel_field_13;
	}

	public void setExternal_pay_channel_field_13(String externalPayChannelField_13) {
		external_pay_channel_field_13 = externalPayChannelField_13;
	}

	public String getExternal_pay_channel_field_14() {
		return external_pay_channel_field_14;
	}

	public void setExternal_pay_channel_field_14(String externalPayChannelField_14) {
		external_pay_channel_field_14 = externalPayChannelField_14;
	}

	public String getExternal_pay_channel_field_15() {
		return external_pay_channel_field_15;
	}

	public void setExternal_pay_channel_field_15(String externalPayChannelField_15) {
		external_pay_channel_field_15 = externalPayChannelField_15;
	}

	public String getExternal_pay_received_amt() {
		return external_pay_received_amt;
	}

	public void setExternal_pay_received_amt(String externalPayReceivedAmt) {
		external_pay_received_amt = externalPayReceivedAmt;
	}

	public String getGmt_success_external_pay_channel() {
		return gmt_success_external_pay_channel;
	}

	public void setGmt_success_external_pay_channel(
			String gmtSuccessExternalPayChannel) {
		gmt_success_external_pay_channel = gmtSuccessExternalPayChannel;
	}

	public String getExternal_pay_channel_trade_no() {
		return external_pay_channel_trade_no;
	}

	public void setExternal_pay_channel_trade_no(String externalPayChannelTradeNo) {
		external_pay_channel_trade_no = externalPayChannelTradeNo;
	}

	public String getPay_account_no() {
		return pay_account_no;
	}

	public void setPay_account_no(String payAccountNo) {
		pay_account_no = payAccountNo;
	}

	public String getPay_account_out_accounting_amt() {
		return pay_account_out_accounting_amt;
	}

	public void setPay_account_out_accounting_amt(String payAccountOutAccountingAmt) {
		pay_account_out_accounting_amt = payAccountOutAccountingAmt;
	}

	public String getPay_account_out_accounting_his1() {
		return pay_account_out_accounting_his1;
	}

	public void setPay_account_out_accounting_his1(
			String payAccountOutAccountingHis1) {
		pay_account_out_accounting_his1 = payAccountOutAccountingHis1;
	}

	public String getPay_account_out_accounting_his2() {
		return pay_account_out_accounting_his2;
	}

	public void setPay_account_out_accounting_his2(
			String payAccountOutAccountingHis2) {
		pay_account_out_accounting_his2 = payAccountOutAccountingHis2;
	}

	public String getPay_account_out_accounting_his3() {
		return pay_account_out_accounting_his3;
	}

	public void setPay_account_out_accounting_his3(
			String payAccountOutAccountingHis3) {
		pay_account_out_accounting_his3 = payAccountOutAccountingHis3;
	}

	public String getPay_account_in_accounting_his1() {
		return pay_account_in_accounting_his1;
	}

	public void setPay_account_in_accounting_his1(String payAccountInAccountingHis1) {
		pay_account_in_accounting_his1 = payAccountInAccountingHis1;
	}

	public String getPay_account_in_accounting_his2() {
		return pay_account_in_accounting_his2;
	}

	public void setPay_account_in_accounting_his2(String payAccountInAccountingHis2) {
		pay_account_in_accounting_his2 = payAccountInAccountingHis2;
	}

	public String getPay_account_in_accounting_his3() {
		return pay_account_in_accounting_his3;
	}

	public void setPay_account_in_accounting_his3(String payAccountInAccountingHis3) {
		pay_account_in_accounting_his3 = payAccountInAccountingHis3;
	}

	public String getPay_fee_account_no() {
		return pay_fee_account_no;
	}

	public void setPay_fee_account_no(String payFeeAccountNo) {
		pay_fee_account_no = payFeeAccountNo;
	}

	public String getPay_fee_account_out_accounting_amt() {
		return pay_fee_account_out_accounting_amt;
	}

	public void setPay_fee_account_out_accounting_amt(
			String payFeeAccountOutAccountingAmt) {
		pay_fee_account_out_accounting_amt = payFeeAccountOutAccountingAmt;
	}

	public String getPay_fee_account_out_accounting_his1() {
		return pay_fee_account_out_accounting_his1;
	}

	public void setPay_fee_account_out_accounting_his1(
			String payFeeAccountOutAccountingHis1) {
		pay_fee_account_out_accounting_his1 = payFeeAccountOutAccountingHis1;
	}

	public String getPay_fee_account_out_accounting_his2() {
		return pay_fee_account_out_accounting_his2;
	}

	public void setPay_fee_account_out_accounting_his2(
			String payFeeAccountOutAccountingHis2) {
		pay_fee_account_out_accounting_his2 = payFeeAccountOutAccountingHis2;
	}

	public String getPay_fee_account_out_accounting_his3() {
		return pay_fee_account_out_accounting_his3;
	}

	public void setPay_fee_account_out_accounting_his3(
			String payFeeAccountOutAccountingHis3) {
		pay_fee_account_out_accounting_his3 = payFeeAccountOutAccountingHis3;
	}

	public String getReceive_type() {
		return receive_type;
	}

	public void setReceive_type(String receiveType) {
		receive_type = receiveType;
	}

	public String getReceive_profit_loss_extend_field_1() {
		return receive_profit_loss_extend_field_1;
	}

	public void setReceive_profit_loss_extend_field_1(
			String receiveProfitLossExtendField_1) {
		receive_profit_loss_extend_field_1 = receiveProfitLossExtendField_1;
	}

	public String getReceive_profit_loss_extend_field_2() {
		return receive_profit_loss_extend_field_2;
	}

	public void setReceive_profit_loss_extend_field_2(
			String receiveProfitLossExtendField_2) {
		receive_profit_loss_extend_field_2 = receiveProfitLossExtendField_2;
	}

	public String getReceive_profit_loss_extend_field_3() {
		return receive_profit_loss_extend_field_3;
	}

	public void setReceive_profit_loss_extend_field_3(
			String receiveProfitLossExtendField_3) {
		receive_profit_loss_extend_field_3 = receiveProfitLossExtendField_3;
	}

	public String getReceive_profit_loss_attr_1() {
		return receive_profit_loss_attr_1;
	}

	public void setReceive_profit_loss_attr_1(String receiveProfitLossAttr_1) {
		receive_profit_loss_attr_1 = receiveProfitLossAttr_1;
	}

	public String getReceive_profit_loss_attr_2() {
		return receive_profit_loss_attr_2;
	}

	public void setReceive_profit_loss_attr_2(String receiveProfitLossAttr_2) {
		receive_profit_loss_attr_2 = receiveProfitLossAttr_2;
	}

	public String getReceive_profit_loss_attr_3() {
		return receive_profit_loss_attr_3;
	}

	public void setReceive_profit_loss_attr_3(String receiveProfitLossAttr_3) {
		receive_profit_loss_attr_3 = receiveProfitLossAttr_3;
	}

	public String getReceive_profit_loss_attr_4() {
		return receive_profit_loss_attr_4;
	}

	public void setReceive_profit_loss_attr_4(String receiveProfitLossAttr_4) {
		receive_profit_loss_attr_4 = receiveProfitLossAttr_4;
	}

	public String getReceive_profit_loss_attr_5() {
		return receive_profit_loss_attr_5;
	}

	public void setReceive_profit_loss_attr_5(String receiveProfitLossAttr_5) {
		receive_profit_loss_attr_5 = receiveProfitLossAttr_5;
	}

	public String getReceive_profit_loss_attr_6() {
		return receive_profit_loss_attr_6;
	}

	public void setReceive_profit_loss_attr_6(String receiveProfitLossAttr_6) {
		receive_profit_loss_attr_6 = receiveProfitLossAttr_6;
	}

	public String getReceive_profit_loss_attr_7() {
		return receive_profit_loss_attr_7;
	}

	public void setReceive_profit_loss_attr_7(String receiveProfitLossAttr_7) {
		receive_profit_loss_attr_7 = receiveProfitLossAttr_7;
	}

	public String getReceive_profit_loss_attr_8() {
		return receive_profit_loss_attr_8;
	}

	public void setReceive_profit_loss_attr_8(String receiveProfitLossAttr_8) {
		receive_profit_loss_attr_8 = receiveProfitLossAttr_8;
	}

	public String getReceive_profit_loss_attr_9() {
		return receive_profit_loss_attr_9;
	}

	public void setReceive_profit_loss_attr_9(String receiveProfitLossAttr_9) {
		receive_profit_loss_attr_9 = receiveProfitLossAttr_9;
	}

	public String getReceive_profit_loss_attr_10() {
		return receive_profit_loss_attr_10;
	}

	public void setReceive_profit_loss_attr_10(String receiveProfitLossAttr_10) {
		receive_profit_loss_attr_10 = receiveProfitLossAttr_10;
	}

	public String getReceive_profit_loss_income_incr() {
		return receive_profit_loss_income_incr;
	}

	public void setReceive_profit_loss_income_incr(
			String receiveProfitLossIncomeIncr) {
		receive_profit_loss_income_incr = receiveProfitLossIncomeIncr;
	}

	public String getReceive_profit_loss_cost_decr() {
		return receive_profit_loss_cost_decr;
	}

	public void setReceive_profit_loss_cost_decr(String receiveProfitLossCostDecr) {
		receive_profit_loss_cost_decr = receiveProfitLossCostDecr;
	}

	public String getReceive_account_no() {
		return receive_account_no;
	}

	public void setReceive_account_no(String receiveAccountNo) {
		receive_account_no = receiveAccountNo;
	}

	public String getReceive_account_in_accounting_amt() {
		return receive_account_in_accounting_amt;
	}

	public void setReceive_account_in_accounting_amt(
			String receiveAccountInAccountingAmt) {
		receive_account_in_accounting_amt = receiveAccountInAccountingAmt;
	}

	public String getReceive_account_in_accounting_type() {
		return receive_account_in_accounting_type;
	}

	public void setReceive_account_in_accounting_type(
			String receiveAccountInAccountingType) {
		receive_account_in_accounting_type = receiveAccountInAccountingType;
	}

	public String getReceive_account_in_accounting_his1() {
		return receive_account_in_accounting_his1;
	}

	public void setReceive_account_in_accounting_his1(
			String receiveAccountInAccountingHis1) {
		receive_account_in_accounting_his1 = receiveAccountInAccountingHis1;
	}

	public String getReceive_account_in_accounting_his2() {
		return receive_account_in_accounting_his2;
	}

	public void setReceive_account_in_accounting_his2(
			String receiveAccountInAccountingHis2) {
		receive_account_in_accounting_his2 = receiveAccountInAccountingHis2;
	}

	public String getReceive_account_in_accounting_his3() {
		return receive_account_in_accounting_his3;
	}

	public void setReceive_account_in_accounting_his3(
			String receiveAccountInAccountingHis3) {
		receive_account_in_accounting_his3 = receiveAccountInAccountingHis3;
	}

	public String getReceive_fee_account_no() {
		return receive_fee_account_no;
	}

	public void setReceive_fee_account_no(String receiveFeeAccountNo) {
		receive_fee_account_no = receiveFeeAccountNo;
	}

	public String getReceive_fee_account_out_accounting_type() {
		return receive_fee_account_out_accounting_type;
	}

	public void setReceive_fee_account_out_accounting_type(
			String receiveFeeAccountOutAccountingType) {
		receive_fee_account_out_accounting_type = receiveFeeAccountOutAccountingType;
	}

	public String getReceive_fee_account_out_accounting_amt() {
		return receive_fee_account_out_accounting_amt;
	}

	public void setReceive_fee_account_out_accounting_amt(
			String receiveFeeAccountOutAccountingAmt) {
		receive_fee_account_out_accounting_amt = receiveFeeAccountOutAccountingAmt;
	}

	public String getReceive_fee_account_out_accounting_his1() {
		return receive_fee_account_out_accounting_his1;
	}

	public void setReceive_fee_account_out_accounting_his1(
			String receiveFeeAccountOutAccountingHis1) {
		receive_fee_account_out_accounting_his1 = receiveFeeAccountOutAccountingHis1;
	}

	public String getReceive_fee_account_out_accounting_his2() {
		return receive_fee_account_out_accounting_his2;
	}

	public void setReceive_fee_account_out_accounting_his2(
			String receiveFeeAccountOutAccountingHis2) {
		receive_fee_account_out_accounting_his2 = receiveFeeAccountOutAccountingHis2;
	}

	public String getReceive_fee_account_out_accounting_his3() {
		return receive_fee_account_out_accounting_his3;
	}

	public void setReceive_fee_account_out_accounting_his3(
			String receiveFeeAccountOutAccountingHis3) {
		receive_fee_account_out_accounting_his3 = receiveFeeAccountOutAccountingHis3;
	}

    @XmlElementWrapper(name = "profit_loss_list")
    @XmlElement(name = "profit_loss")
	public List<TradePacketReqBodyOtherPofitLossLedger> getProfit_loss_list() {
		return profit_loss_list;
	}

	public void setProfit_loss_list(
			List<TradePacketReqBodyOtherPofitLossLedger> profitLossList) {
		profit_loss_list = profitLossList;
	}

}