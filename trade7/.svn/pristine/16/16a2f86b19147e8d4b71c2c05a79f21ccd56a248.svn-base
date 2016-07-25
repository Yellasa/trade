package com.liantuo.trade.client.trade.packet.body.zf;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;

/**
 * 
 * ClassName: WxAttachment
 * @Description: 微信刷卡支付组件
 * @author zzd
 * @date 2016-7-5
 */
public class WxAttachment extends Attachment {
	//子商户公众账号ID
	/*	
	 * 子商户公众账号ID
	 * 字符串
	 * 32
	 * 可空
	 * 微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传。
	*/	
    @Pattern(message = "sub_appid format error", regexp = ".{0,32}", groups = Format.class)
	private String sub_appid; 
	//设备号
    @Pattern(message = "device_info format error", regexp = ".{0,32}", groups = Format.class)
	private String device_info;
	//附加数据
    @Pattern(message = "attach format error", regexp = ".{0,127}", groups = Format.class)
	private String attach;
	//货币类型 符合ISO 4217标准的三位字母代码，默认人民币：CNY
    @Pattern(message = "fee_type format error", regexp = ".{0,16}", groups = Format.class)
	private String fee_type = "CNY";
	//终端IP
    @NotBlank(message = "spbill_create_ip is required", groups = {Required.class})
    @Pattern(message = "spbill_create_ip format error", regexp = ".{1,16}", groups = Format.class)
	private String spbill_create_ip;
	//商品标记
    @Pattern(message = "goods_tag format error", regexp = ".{0,32}", groups = Format.class)
	private String goods_tag;
	//指定支付方式
    @Pattern(message = "limit_pay format error", regexp = ".{0,32}", groups = Format.class)
	private String limit_pay;
	//授权码
    @NotBlank(message = "auth_code is required", groups = {Required.class})
    @Pattern(message = "auth_code format error", regexp = ".{0,128}", groups = Format.class)
	private String auth_code;
	public String getSub_appid() {
		return sub_appid;
	}
	public void setSub_appid(String subAppid) {
		sub_appid = subAppid;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String deviceInfo) {
		device_info = deviceInfo;
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
	public void setFee_type(String feeType) {
		fee_type = feeType;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbillCreateIp) {
		spbill_create_ip = spbillCreateIp;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goodsTag) {
		goods_tag = goodsTag;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limitPay) {
		limit_pay = limitPay;
	}
	public String getAuth_code() {
		return auth_code;
	}
	public void setAuth_code(String authCode) {
		auth_code = authCode;
	}
	
}
