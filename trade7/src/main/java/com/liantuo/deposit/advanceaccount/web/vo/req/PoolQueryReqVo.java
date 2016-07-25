package com.liantuo.deposit.advanceaccount.web.vo.req;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.deposit.advanceaccount.web.constants.RegexConstants;
import com.liantuo.deposit.advanceaccount.web.util.CannotEmptyString;

/**
 * @类名: CreditAccountPageQueryReqVo
 * @类说明: 资金池查询接口请求参数(服务端)
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: liujingbei
 * @创建时间: 2016年3月23日 下午2:46:26
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */
public class PoolQueryReqVo{

	@NotBlank(message="partner_id is required")
	@Pattern(message="partner_id format error", regexp = RegexConstants.PARTNERID_REGEX)
	private String partnerId;
	/**
	* @字段名 coreMerchantNo : 核心商户编号
	*/
	@NotBlank(message="core_merchant_no is required")
	@Length(min=2,max=32,message="core_merchant_no format error")
	private String coreMerchantNo;
	/**
	* @字段名 poolNo : 资金池编号
	*/
	@CannotEmptyString(message = "fund_pool_no format error", regexp = RegexConstants.POOLNO_REGEX)
	private String poolNo;
	/**
	* @字段名 poolName : 资金池名称
	*/
	@Length(min=1,max=128,message="pool_name format error")
	private String poolName;
	/**
	* @字段名 currentPage : 分页页数
	* 默认0页，0表示第一页
	     如总页数为20页，则分页页数为0-19页
	*/
	@CannotEmptyString(message="page format error", regexp =RegexConstants.CURRENTPAGE_REGEX )
	private String currentPage;
	
	/**
	* @字段名 showCount : 分页每页条数
	* 默认50条，最大100条
	*/
	@CannotEmptyString(message="page_size format error", regexp =RegexConstants.POOL_SHOWCOUNT_REGEX )
	private String showCount;

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

	public String getPoolNo() {
		return poolNo;
	}

	public void setPoolNo(String poolNo) {
		this.poolNo = poolNo;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getShowCount() {
		return showCount;
	}

	public void setShowCount(String showCount) {
		this.showCount = showCount;
	}

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}
	
	
}
