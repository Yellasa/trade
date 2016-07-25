package com.liantuo.trade.client.trade.packet.body.single_payment;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import lombok.Data;

import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.common.validate.WeakRequired;
import com.liantuo.trade.validator.AssociateWeak;
import com.liantuo.trade.validator.ConflictWeak;

/**
 * @ClassName: TradePacketReqBodyExternalAsynPayment.java
 * @Description: 外部收款同步获取连接
 * @Company: 联拓金融信息服务有限公司
 * @author zoran.huang
 * @version V1.0
 * @date 2016年7月6日 下午3:11:39
 */
@Data
public class TradePacketReqBodyExternalAsynPayment extends TradeRequestBody {
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
     * 参数名：异步通知地址</br>
     * 参数类型：可空1204位的异步URL地址</br>
     */
    @Pattern(message = "notify_url format error", regexp = ".{0,1024}", groups = Format.class)
    private String notify_url;
    /**
     * 参数名：支付方式</br>
     * 参数类型：必填</br>
     */
    @NotBlank(message = "pay_type is required", groups = {Required.class})
    @Pattern(message = "pay_type format error", regexp = "[45]", groups = Format.class)
    private String pay_type;

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
    
   
    @NotBlank(message = "pay_channel is required", groups = {Required.class})
    @Pattern(message = "pay_channel format error", regexp = "[\\da-zA-Z_]{1,16}", groups = Format.class)
	//支付渠道编号
	private String pay_channel;
	
	@NotBlank(message = "pay_transaction_id is required", groups = {Required.class})
    @Pattern(message = "pay_transaction_id format error", regexp = "[\\da-zA-Z_]{1,15}", groups = Format.class)
	//支付渠道身份编号
	private String pay_transaction_id;
	
	@NotBlank(message = "total_amount is required", groups = {Required.class})
    @DecimalMin(message = "total_amount format error", groups = {Format.class}, value = "0.01")
    @Digits(message = "total_amount format error", groups = {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
	//订单金额
	private String total_amount;
	
    @Pattern(message = "subject format error", regexp = ".{0,64}", groups = Format.class)
	//商品标题
	private String subject;
	
    @Pattern(message = "body format error", regexp = ".{0,64}", groups = Format.class)
	//商品描述
	private String body;
    
    @Pattern(message = "ledger_merchant_extend_field_1 format error", regexp = ".{0,1024}", groups = Format.class)
    //业务台账客户保留字段1
    private String ledger_merchant_extend_field_1;
    
    @Pattern(message = "merchant_extend_field_2 format error", regexp = ".{0,1024}", groups = Format.class)
    //业务台账客户保留字段2
    private String ledger_merchant_extend_field_2;
    
    @Pattern(message = "ledger_ledger_merchant_extend_field_3 format error", regexp = ".{0,1024}", groups = Format.class)
    //业务台账客户保留字段3
    private String ledger_merchant_extend_field_3;
    
    @NotBlank(message = "other_attachment_group_json is required", groups = {Required.class})
    //其它附加组 json格式第三发其他数据
    private String other_attachment_group_json;
	
}
