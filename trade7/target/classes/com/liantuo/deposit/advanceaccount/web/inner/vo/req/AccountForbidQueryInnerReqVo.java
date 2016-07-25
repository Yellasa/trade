package com.liantuo.deposit.advanceaccount.web.inner.vo.req;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @类名: AccountForbidQueryInnerReqVo
 * @类说明: 禁止结构内部查询接口请求参数(服务端)
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
public class AccountForbidQueryInnerReqVo{

 
	@NotBlank(message="coreMerchantNo is required")
	@Length(min=2,max=32,message="coreMerchantNo format error")
	private String coreMerchantNo;
	
	@NotBlank(message="accountNo is required")
	@Length(min=10,max=32,message="accountNo format error")
	private String accountNo;

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
