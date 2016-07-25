package com.liantuo.trade.client.trade.packet.body.zf;

import javax.validation.constraints.Pattern;

import com.liantuo.trade.common.validate.Format;

/**
 * 
 * ClassName: WxQueryAttachment
 * @Description: 微信刷卡支付查询组件
 * @author zzd
 * @date 2016-7-5
 */
public class WxQueryAttachment extends Attachment {
	//子商户公众账号ID
    @Pattern(message = "sub_appid format error", regexp = ".{0,32}", groups = Format.class)
	private String sub_appid; 
	
	public String getSub_appid() {
		return sub_appid;
	}
	public void setSub_appid(String subAppid) {
		sub_appid = subAppid;
	}
	
}
