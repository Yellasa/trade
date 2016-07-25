package com.liantuo.deposit.advanceaccount.web.vo.req;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.deposit.advanceaccount.web.constants.RegexConstants;

/**
 * @类名: SingleAccountHisPageQueryReqVo
 * @类说明: 资金池接口请求参数(服务端)
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: shb
 * @创建时间: 2016年1月8日 下午2:46:26
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */
public class PoolOpenReqVo{

	/**
	* @字段名 coreMerchantNo : 核心商户编号
	*/
	@NotBlank(message="core_merchant_no is required")
	@Length(min=2,max=32,message="core_merchant_no format error")
	private String coreMerchantNo;
	
	/**
	* @字段名 poolNo : 资金池名称
	*/
	@NotBlank(message="pool_name is required")
	@Length(min=1,max=128,message="pool_name format error")
	private String poolName;
	
	
	@NotBlank(message="partner_id is required")
	@Pattern(message = "partner_id format error", regexp = RegexConstants.PARTNERID_REGEX)
	private String partnerId;
	 
	@Length(max=512,message="rmk format error")
	private String rmk;

	public String getCoreMerchantNo() {
		return coreMerchantNo;
	}

	public void setCoreMerchantNo(String coreMerchantNo) {
		this.coreMerchantNo = coreMerchantNo;
	}

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getRmk() {
		return rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
}
