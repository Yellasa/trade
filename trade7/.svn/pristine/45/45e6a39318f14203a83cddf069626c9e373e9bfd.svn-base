package com.liantuo.trade.client.trade.packet.body.zf;

import javax.validation.constraints.Pattern;
import org.dozer.Mapping;
import com.liantuo.trade.common.validate.Format;

/**
 * 
 * ClassName: AliPaymentQueryAttachment
 * @Description: 外部收款订单查询：ZF0001_02_001、ZF0001_02_002 
 * @author zzd
 * @date 2016-7-7
 */
public class AliPaymentQueryAttachment extends Attachment  {
	//Token	字符串40	否	
    @Pattern(message = "app_auth_token format error", regexp = ".{0,40}", groups = Format.class)
	private String app_auth_token;
    
	public String getApp_auth_token() {
		return app_auth_token;
	}
	public void setApp_auth_token(String app_auth_token) {
		this.app_auth_token = app_auth_token;
	}
	
}
