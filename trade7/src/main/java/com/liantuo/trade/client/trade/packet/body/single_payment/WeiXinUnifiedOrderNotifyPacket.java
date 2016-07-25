package com.liantuo.trade.client.trade.packet.body.single_payment;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.common.validate.WeakRequired;
import com.liantuo.trade.validator.AssociateWeak;
import com.liantuo.trade.validator.date.DateTime;

/**
 * @ClassName: WeiXinUnifiedOrderPacket.java
 * @Description: 微信返回的第三方数据
 * @Company: 联拓金融信息服务有限公司
 * @author zoran.huang
 * @version V1.0
 * @date 2016年7月11日 下午5:14:30
 */
public class WeiXinUnifiedOrderNotifyPacket extends TradeRequestBody {
	// 返回状态码
	@NotBlank(message = "return_code is required", groups = { Required.class })
	@Pattern(message = "return_code content not match", regexp = ".{1,16}", groups = Format.class)
	private String return_code;
	// 返回信息
	@Pattern(message = "return_msg content not match", regexp = ".{0,128}", groups = Format.class)
	private String return_msg;
	// 当return_code为SUCCESS的时候，还会包括以下字段：
	// 子商户公众账号ID
	@AssociateWeak(message = "当return_code为SUCCESS的时候,sub_appid 必填", associate_prop_name = "return_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@Pattern(message = "sub_appid content not match", regexp = ".{1,32}", groups = Format.class)
	private String sub_appid;
	// 设备号
	@Pattern(message = "device_info content not match", regexp = ".{0,32}", groups = Format.class)
	private String device_info;
	// 业务结果
	@AssociateWeak(message = "当return_code为SUCCESS的时候,result_code 必填", associate_prop_name = "return_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@Pattern(message = "result_code content not match", regexp = ".{1,16}", groups = Format.class)
	private String result_code;
	// 错误代码
	@Pattern(message = "err_code content not match", regexp = ".{0,16}", groups = Format.class)
	private String err_code;
	// 错误代码描述
	@Pattern(message = "err_code_des content not match", regexp = ".{0,128}", groups = Format.class)
	private String err_code_des;
	// 当return_code 和result_code都为SUCCESS的时，还会包括以下字段：
	// 用户标识
	@AssociateWeak(message = "当result_code为SUCCESS的时候,openid 必填", associate_prop_name = "result_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@Pattern(message = "openid content not match", regexp = ".{1,128}", groups = Format.class)
	private String openid;
	// 是否关注公众账号
	@AssociateWeak(message = "当result_code为SUCCESS的时候,is_subscribe 必填", associate_prop_name = "result_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@Pattern(message = "is_subscribe content not match", regexp = ".{1}", groups = Format.class)
	private String is_subscribe;
	// 用户子标识
	@Pattern(message = "sub_openid content not match", regexp = ".{0,128}", groups = Format.class)
	private String sub_openid;
	// 是否关注子公众账号
	@Pattern(message = "sub_is_subscribe content not match", regexp = ".{0,1}", groups = Format.class)
	private String sub_is_subscribe;
	// 交易类型
	@AssociateWeak(message = "当result_code为SUCCESS的时候,trade_type 必填", associate_prop_name = "result_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@Pattern(message = "trade_type content not match", regexp = "JSAPI|NATIVE|APP", groups = Format.class)
	private String trade_type;
	// 付款银行
	@AssociateWeak(message = "当result_code为SUCCESS的时候,bank_type 必填", associate_prop_name = "result_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@Pattern(message = "bank_type content not match", regexp = ".{1,16}", groups = Format.class)
	private String bank_type;
	// 总金额
	@AssociateWeak(message = "当result_code为SUCCESS的时候,total_fee 必填", associate_prop_name = "result_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@DecimalMin(message = "total_fee format error", groups = { Format.class }, value = "0")
	@Digits(message = "total_fee format error", groups = { Format.class }, integer = 13, fraction = 0)
	private String total_fee;
	// 货币种类
	@Pattern(message = "fee_type content not match", regexp = ".{0,8}", groups = Format.class)
	private String fee_type = "CNY";
	// 现金支付金额
	@AssociateWeak(message = "当result_code为SUCCESS的时候,cash_fee 必填", associate_prop_name = "result_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@DecimalMin(message = "cash_fee format error", groups = { Format.class }, value = "0")
	@Digits(message = "cash_fee format error", groups = { Format.class }, integer = 13, fraction = 0)
	private String cash_fee;
	// 现金支付货币类型
	@Pattern(message = "cash_fee_type content not match", regexp = ".{0,16}", groups = Format.class)
	private String cash_fee_type;
	// 微信支付订单号
	@AssociateWeak(message = "当result_code为SUCCESS的时候,transaction_id 必填", associate_prop_name = "result_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@Pattern(message = "transaction_id content not match", regexp = ".{1,32}", groups = Format.class)
	private String transaction_id;
	// 商户订单号
	@AssociateWeak(message = "当result_code为SUCCESS的时候,out_trade_no 必填", associate_prop_name = "result_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@Pattern(message = "out_trade_no content not match", regexp = ".{1,32}", groups = Format.class)
	private String out_trade_no;
	// 商家数据包
	@Pattern(message = "attach content not match", regexp = ".{0,128}", groups = Format.class)
	private String attach;
	// 支付完成时间
	@AssociateWeak(message = "当result_code为SUCCESS的时候,time_end 必填", associate_prop_name = "result_code", associate_prop_value = "SUCCESS", groups = { WeakRequired.class })
	@DateTime(message = "time_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_WX_PAY_TIME_CAN_BLANK, groups = Format.class)
	private String time_end;
	// 代金券或立减优惠金额
	@Digits(message = "coupon_fee format error", groups = { Format.class }, integer = 13, fraction = 0)
	private String coupon_fee;
	// 代金券或立减优惠使用数量
	@Digits(message = "coupon_count format error", groups = { Format.class }, integer = 13, fraction = 0)
	private String coupon_count;
	// 代金券或立减优惠List
	@Valid
	private List<WeiXinCouponNotifyPacket> couponInfos;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getSub_appid() {
		return sub_appid;
	}

	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getSub_openid() {
		return sub_openid;
	}

	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	public String getSub_is_subscribe() {
		return sub_is_subscribe;
	}

	public void setSub_is_subscribe(String sub_is_subscribe) {
		this.sub_is_subscribe = sub_is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(String cash_fee) {
		this.cash_fee = cash_fee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(String coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public String getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(String coupon_count) {
		this.coupon_count = coupon_count;
	}

	public List<WeiXinCouponNotifyPacket> getCouponInfos() {
		return couponInfos;
	}

	public void setCouponInfos(List<WeiXinCouponNotifyPacket> couponInfos) {
		this.couponInfos = couponInfos;
	}
}
