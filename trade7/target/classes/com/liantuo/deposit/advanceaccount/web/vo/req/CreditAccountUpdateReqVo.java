package com.liantuo.deposit.advanceaccount.web.vo.req;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.deposit.advanceaccount.web.constants.RegexConstants;

/**
 * @类名: CreditAccountUpdateReqVo
 * @类说明: 账户修改接口请求参数(服务端)
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: shb
 * @创建时间: 2016年3月23日 下午2:46:26
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */
public class CreditAccountUpdateReqVo{

	@NotBlank(message="partner_id is required")
	@Pattern(message="partner_id format error", regexp = RegexConstants.PARTNERID_REGEX)
	private String partnerId;
	/**
	* @字段名 coreMerchantNo : 核心商户编号
	*/
	@NotBlank(message="core_merchant_no is required")
//	@Length(min=2,max=32,message="core_merchant_no format error")
	@Pattern(message="core_merchant_no format error", regexp = RegexConstants.coreMerchantNO_REGEX)
	private String coreMerchantNo;
	
	/**
	* @字段名 accountNo : 账户编号
	*/
	@NotBlank(message="account_no is required")
	@Pattern(message = "account_no format error", regexp ="[\\d|a-zA-Z|_]{6,32}")
	private String accountNo;
	
	/**
	* @字段名 accountName : 账户名称
	*/
	@Length(min=0,max=45,message="account_name format error")
	private String accountName;
	/**
	* @字段名 accountType : 账户类型
	* 账户类型： 内部账户
	*/
	
	@Pattern(message = "account_type format error", regexp = "[\\d]{0,3}")
	private String accountType;
	/**
	* @字段名 status : 账户状态
	* 账户状态：1-正常；2-冻结状态；3-待确认
	*/
//	@Pattern(message = "status format error", regexp = "[1|2]")
	private String status;
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
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
 
}
