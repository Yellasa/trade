package com.liantuo.trade.client.trade.packet.body.single_payment;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.validator.date.DateTime;

/**
 * @ClassName:   AlipayTradePrecreatePacket.java
 * @Description: 支付到扫码付第三方数据 
 * @Company:     联拓金融信息服务有限公司
 * @author       zoran.huang
 * @version      V1.0  
 * @date         2016年7月11日 下午5:15:08
 */
public class AlipayTradePrecreateNotifyPacket extends TradeRequestBody{
	// 通知时间
	@NotBlank(message = "notify_type is required", groups = { Required.class })
	@DateTime(message = "notify_time is required", groups = { Format.class })
	private String notify_time;
	// 通知类型
	@NotBlank(message = "notify_type is required", groups = { Required.class })
	@Pattern(message = "notify_type content not match", regexp = ".{1,64}", groups = Format.class)
	private String notify_type;
	// 通知校验ID
	@NotBlank(message = "notify_id is required", groups = { Required.class })
	@Pattern(message = "notify_id content not match", regexp = ".{1,128}", groups = Format.class)
	private String notify_id;
	// 签名类型
	@NotBlank(message = "sign_type is required", groups = { Required.class })
	@Pattern(message = "sign_type content not match", regexp = ".{1,10}", groups = Format.class)
	private String sign_type;
	// 签名
	@NotBlank(message = "sign is required", groups = { Required.class })
	@Pattern(message = "sign content not match", regexp = ".{1,256}", groups = Format.class)
	private String sign;
	// 支付宝交易号
	@NotBlank(message = "trade_no is required", groups = { Required.class })
	@Pattern(message = "trade_no content not match", regexp = ".{1,64}", groups = Format.class)
	private String trade_no;
	// 开发者的app_id
	@NotBlank(message = "app_id is required", groups = { Required.class })
	@Pattern(message = "app_id content not match", regexp = ".{1,32}", groups = Format.class)
	private String app_id;
	// 商户订单号
	@NotBlank(message = "out_trade_no is required", groups = { Required.class })
	@Pattern(message = "out_trade_no content not match", regexp = ".{1,64}", groups = Format.class)
	private String out_trade_no;
	// 商户业务号
	@NotBlank(message = "out_biz_no is required", groups = { Required.class })
	@Pattern(message = "out_biz_no content not match", regexp = ".{1,64}", groups = Format.class)
	private String out_biz_no;
	// 买家支付宝用户号
	@Pattern(message = "buyer_id content not match", regexp = "[\\d]{0,16}", groups = Format.class)
	private String buyer_id;
	// 买家支付宝账号
	@Pattern(message = "buyer_logon_id content not match", regexp = ".{0,100}", groups = Format.class)
	private String buyer_logon_id;
	// 卖家支付宝用户号
	@Pattern(message = "seller_id content not match", regexp = ".{0,30}", groups = Format.class)
	private String seller_id;
	// 卖家支付宝账号
	@Pattern(message = "seller_email content not match", regexp = ".{0,100}", groups = Format.class)
	private String seller_email;
	// 交易状态
	@Pattern(message = "trade_status content not match", regexp = ".{0,32}", groups = Format.class)
	private String trade_status;
	// 订单金额
	@DecimalMin(message = "total_amount format error", groups = { Format.class }, value = "0.01")
	@Digits(message = "total_amount format error", groups = { Format.class }, integer = 9, fraction = 2)
	private String total_amount;
	// 实收金额
	@DecimalMin(message = "receipt_amount format error", groups = { Format.class }, value = "0.01")
	@Digits(message = "receipt_amount format error", groups = { Format.class }, integer = 9, fraction = 2)
	private String receipt_amount;
	// 开票金额
	@DecimalMin(message = "invoice_amount format error", groups = { Format.class }, value = "0.01")
	@Digits(message = "invoice_amount format error", groups = { Format.class }, integer = 9, fraction = 2)
	private String invoice_amount;
	// 付款金额
	@DecimalMin(message = "buyer_pay_amount format error", groups = { Format.class }, value = "0.01")
	@Digits(message = "buyer_pay_amount format error", groups = { Format.class }, integer = 9, fraction = 2)
	private String buyer_pay_amount;
	// 集分宝金额
	@DecimalMin(message = "point_amount format error", groups = { Format.class }, value = "0.01")
	@Digits(message = "point_amount format error", groups = { Format.class }, integer = 9, fraction = 2)
	private String point_amount;
	// 总退款金额
	@DecimalMin(message = "refund_fee format error", groups = { Format.class }, value = "0.01")
	@Digits(message = "refund_fee format error", groups = { Format.class }, integer = 9, fraction = 2)
	private String refund_fee;

	// 实际退款金额
	@DecimalMin(message = "send_back_fee format error", groups = { Format.class }, value = "0.01")
	@Digits(message = "send_back_fee format error", groups = { Format.class }, integer = 9, fraction = 2)
	private String send_back_fee;
	// 订单标题
	@Pattern(message = "subject content not match", regexp = ".{0,256}", groups = Format.class)
	private String subject;
	// 商品描述
	@Pattern(message = "body content not match", regexp = ".{0,400}", groups = Format.class)
	private String body;
	// 交易创建时间
	@DateTime(message = "gmt_create format error", groups = Format.class)
	private String gmt_create;
	// 交易付款时间
	@DateTime(message = "gmt_payment format error", groups = Format.class)
	private String gmt_payment;
	// 交易退款时间
	@DateTime(message = "gmt_refund format error", groups = Format.class)
	private String gmt_refund;
	// 交易结束时间
	@DateTime(message = "gmt_close format error", groups = Format.class)
	private String gmt_close;
	// 支付金额信息
	@Pattern(message = "buyer_logon_id content not match", regexp = ".{0,512}", groups = Format.class)
	private String fund_bill_list;

	public String getNotify_time() {
		return notify_time;
	}

	public void setNotify_time(String notify_time) {
		this.notify_time = notify_time;
	}

	public String getNotify_type() {
		return notify_type;
	}

	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	public String getNotify_id() {
		return notify_id;
	}

	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}


	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getOut_biz_no() {
		return out_biz_no;
	}

	public void setOut_biz_no(String out_biz_no) {
		this.out_biz_no = out_biz_no;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}

	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getReceipt_amount() {
		return receipt_amount;
	}

	public void setReceipt_amount(String receipt_amount) {
		this.receipt_amount = receipt_amount;
	}

	public String getInvoice_amount() {
		return invoice_amount;
	}

	public void setInvoice_amount(String invoice_amount) {
		this.invoice_amount = invoice_amount;
	}

	public String getBuyer_pay_amount() {
		return buyer_pay_amount;
	}

	public void setBuyer_pay_amount(String buyer_pay_amount) {
		this.buyer_pay_amount = buyer_pay_amount;
	}

	public String getPoint_amount() {
		return point_amount;
	}

	public void setPoint_amount(String point_amount) {
		this.point_amount = point_amount;
	}

	public String getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	}

	public String getSend_back_fee() {
		return send_back_fee;
	}

	public void setSend_back_fee(String send_back_fee) {
		this.send_back_fee = send_back_fee;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(String gmt_create) {
		this.gmt_create = gmt_create;
	}

	public String getGmt_payment() {
		return gmt_payment;
	}

	public void setGmt_payment(String gmt_payment) {
		this.gmt_payment = gmt_payment;
	}

	public String getGmt_refund() {
		return gmt_refund;
	}

	public void setGmt_refund(String gmt_refund) {
		this.gmt_refund = gmt_refund;
	}

	public String getGmt_close() {
		return gmt_close;
	}

	public void setGmt_close(String gmt_close) {
		this.gmt_close = gmt_close;
	}

	public String getFund_bill_list() {
		return fund_bill_list;
	}

	public void setFund_bill_list(String fund_bill_list) {
		this.fund_bill_list = fund_bill_list;
	}

}
