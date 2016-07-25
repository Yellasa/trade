package com.liantuo.deposit.advanceaccount.web.vo.rsp;


/**
 * @类名: AccountForbidRspVo
 * @类说明: 禁止结构回参(服务端)
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: shb
 * @创建时间: 2016年1月8日 下午2:49:48
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */
public class AccountForbidRspVo { 
	
	private String accountNo;
	
	private String forbidCode;
	
	private String type;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getForbidCode() {
		return forbidCode;
	}

	public void setForbidCode(String forbidCode) {
		this.forbidCode = forbidCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	 
}
