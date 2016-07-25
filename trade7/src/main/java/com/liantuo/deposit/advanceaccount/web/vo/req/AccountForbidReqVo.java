package com.liantuo.deposit.advanceaccount.web.vo.req;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @类名: AccountForbidUpdateReqVo
 * @类说明: 预存款账户批量禁止结构变更(服务端)
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: shb
 * @创建时间: 2016年3月29日 下午2:46:26
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */
public class AccountForbidReqVo{

	@NotBlank(message="type is required")
	@Pattern(message = "type format error", regexp = "0|1")
	private String type;
	
	@NotBlank(message="forbid_code is required")
	@Pattern(message = "frozen_trade_no format error", regexp = "[\\d|_]{2,32}")
	private String forbidCode;
	
	@NotBlank(message="forbid_type is required")
	@Pattern(message = "type format error", regexp = "01|02")
	private String forbidType;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getForbidCode() {
		return forbidCode;
	}

	public void setForbidCode(String forbidCode) {
		this.forbidCode = forbidCode;
	}

	public String getForbidType() {
		return forbidType;
	}

	public void setForbidType(String forbidType) {
		this.forbidType = forbidType;
	}
	
}
