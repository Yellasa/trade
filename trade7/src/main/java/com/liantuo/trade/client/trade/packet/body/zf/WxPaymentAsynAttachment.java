package com.liantuo.trade.client.trade.packet.body.zf;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.common.validate.ValidationUtil;
import com.liantuo.trade.common.validate.WeakRequired;
import com.liantuo.trade.validator.AssociateWeak;
import com.liantuo.trade.validator.date.DateTime;

public class WxPaymentAsynAttachment extends Attachment  {
	/*	
	 * 子商户公众账号ID
	 * 字符串
	 * 32
	 * 可空
	 * 微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传。
	*/	
    @Pattern(message = "sub_appid format error", regexp = ".{0,32}", groups = Format.class)
	private String sub_appid;
	
	/*	
	 * 设备号 device_info
	 * 字符串
	 * 32
	 * 可空
	 * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
	*/
    @Pattern(message = "device_info format error", regexp = ".{0,32}", groups = Format.class)
	private String device_info;

	/*	
	 * 附加数据 attach
	 * 	字符串
	 * 	127
	 * 	可空
	 * 	附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
	*/
    @Pattern(message = "attach format error", regexp = ".{0,127}", groups = Format.class)
	private String attach;
	/*
	 * 货币类型
	 * fee_type
	 * 字符串
	 * 16
	 * 可空
	 * 符合ISO 4217标准的三位字母代码，默认人民币：CNY
	*/	
    @Pattern(message = "fee_type format error", regexp = ".{0,16}", groups = Format.class)
	private String fee_type;
	
	/*
	 * 终端IP	spbill_create_ip
	 * 字符串
	 * 16
	 * 必填
	 * APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
	 * 
	*/
    @NotBlank(message = "spbill_create_ip is required", groups = {Required.class})
    @Pattern(message = "spbill_create_ip format error", regexp = ".{1,16}", groups = Format.class)
	private String spbill_create_ip;
	
	/*
	 * 交易起始时间	time_start
	 * 字符串
	 * 14
	 * 可空
	 * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。
	*/	
    @DateTime(message = "time_start format error", regexp=TradeConstants.TRADE_REGEX_FORMAT_WX_PAY_TIME_CAN_BLANK, groups = Format.class)
	private String time_start;
	
	/*	
	 *交易结束时间 time_expire
	 *字符串
	 *14
	 *可空
	 *订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。
	*/
    
    @DateTime(message = "time_expire format error", regexp=TradeConstants.TRADE_REGEX_FORMAT_WX_PAY_TIME_CAN_BLANK, groups = Format.class)
	private String time_expire;
	
	/*	
	 *商品标记 goods_tag
	 *字符串	32
	 *可空
	 *商品标记，微信方代金券或立减优惠功能的参数
	*/
    @Pattern(message = "goods_tag format error", regexp = ".{0,32}", groups = Format.class)
	private String goods_tag;
	
	/*	
	 *交易类型 trade_type
	 *字符串
	 *16	
	 *必填	
	 *取值如下：JSAPI，NATIVE，APP
	*/
    @NotBlank(message = "trade_type is required", groups = {Required.class})
    @Pattern(message = "trade_type format error", regexp = "JSAPI|NATIVE", groups = Format.class)
	private String trade_type;
	
	/*	
	 *商品ID 	product_id	
	 *字符串	32
	 *可空
	 *trade_type=NATIVE，且模式一方式，此参数必传。此id为二维码中包含的商品ID，商户自行定义。暂不用
	*/
    @AssociateWeak(message="trade_type=NATIVE，product_id is required", associate_prop_name = "trade_type", associate_prop_value = "NATIVE", groups = {WeakRequired.class})
    @Pattern(message = "product_id format error", regexp = ".{0,32}", groups = Format.class)
	private String product_id;
	/*
	 *指定支付方式	limit_pay
	 *字符串
	 *32
	 *可空
	 *no_credit--指定不能使用信用卡支付
	*/
    @Pattern(message = "limit_pay format error", regexp = ".{0,32}", groups = Format.class)
	private String limit_pay;
	/*	
	 *用户子标识	sub_openid
	 *字符串
	 *128
	 *可空
	 *trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。 
	*/
    @AssociateWeak(message="trade_type=JSAPI，sub_openid is required", associate_prop_name = "trade_type", associate_prop_value = "JSAPI", groups = {WeakRequired.class})
    @Pattern(message = "sub_openid format error", regexp = ".{0,128}", groups = Format.class)
	private String sub_openid;
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
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	public String getSub_openid() {
		return sub_openid;
	}
	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}
	
	public static void main(String[] args) {
		WxPaymentAsynAttachment wsta = new WxPaymentAsynAttachment();
		wsta.setSub_appid("sub_appid");
		wsta.setDevice_info("device_info");
		wsta.setAttach("attach");
		wsta.setFee_type("fee_type");
		wsta.setSpbill_create_ip("spbill_create_ip");
		wsta.setTime_start("20091225091010");
		wsta.setTime_expire("20091225091013");
		wsta.setGoods_tag("");
		wsta.setTrade_type("NATIVE");
		wsta.setProduct_id("11");
		wsta.setLimit_pay("limit_pay");
		wsta.setSub_openid("12");
		System.out.println(ValidationUtil.validateRequiredWeaks(wsta));
		
	}
}
