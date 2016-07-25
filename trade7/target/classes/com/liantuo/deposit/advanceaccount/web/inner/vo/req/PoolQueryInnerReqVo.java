package com.liantuo.deposit.advanceaccount.web.inner.vo.req;


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
public class PoolQueryInnerReqVo{

	/**
	* @字段名 coreMerchantNo : 核心商户编号
	*/
	@NotBlank(message="coreMerchantNo is required")
	@Length(min=2,max=32,message="coreMerchantNo format error")
	private String coreMerchantNo;
	/**
	* @字段名 poolNo : 资金池编号
	*/
	@CannotEmptyString(message = "poolNo format error", regexp = RegexConstants.POOLNO_REGEX)
	private String poolNo;
	/**
	* @字段名 poolName : 资金池名称
	*/
	@Length(min=1,max=128,message="poolName format error")
	private String poolName;
	/**
	* @字段名 currentPage : 分页页数
	* 默认0页，0表示第一页
	     如总页数为20页，则分页页数为0-19页
	*/
	@CannotEmptyString(message="currentPage format error", regexp =RegexConstants.CURRENTPAGE_REGEX )
	private String currentPage;
	
	/**
	* @字段名 showCount : 分页每页条数
	* 默认50条，最大100条
	*/
	@CannotEmptyString(message="showCount format error", regexp =RegexConstants.SHOWCOUNT_REGEX )
	private String showCount;
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
