package com.liantuo.deposit.advanceaccount.web.vo.req;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
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
public class AccountForbidUpdateReqVo{

	 
	@NotBlank(message="partner_id is required")
	@Pattern(message = "partner_id format error", regexp = "[\\d]{17,17}")
	private String partnerId;
	
	@NotBlank(message="merchant_no is required")
	@Length(min=2,max=32,message="merchant_no format error")
	private String merchantNo;
	
	@NotBlank(message="account_no is required")
	@Length(min=10,max=32,message="account_no format error")
	private String accountNo;
	
	@NotBlank(message="forbid_detail is required")
	private String  forbidDetail;

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getForbidDetail() {
		return forbidDetail;
	}

	public void setForbidDetail(String forbidDetail) {
		this.forbidDetail = forbidDetail;
	}
	
 
}
