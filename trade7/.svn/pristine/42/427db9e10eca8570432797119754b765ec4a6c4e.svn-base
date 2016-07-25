package com.liantuo.deposit.advanceaccount.web.vo.req;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.deposit.advanceaccount.web.constants.RegexConstants;

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
public class AccountForbidQueryReqVo{

	 
	@NotBlank(message="partner_id is required")
	@Pattern(message = "partner_id format error", regexp = RegexConstants.PARTNERID_REGEX)
	private String partnerId;
	
	@NotBlank(message="core_merchant_no is required")
	@Length(min=2,max=32,message="core_merchant_no format error")
	private String coreMerchantNo;
	
	@NotBlank(message="account_no is required")
	@Length(min=10,max=32,message="account_no format error")
	private String accountNo;

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getCoreMerchantNo() {
		return coreMerchantNo;
	}

	public void setCoreMerchantNo(String coreMerchantNo) {
		this.coreMerchantNo = coreMerchantNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
}
