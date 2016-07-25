package com.liantuo.deposit.advanceaccount.web.vo.req;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.deposit.advanceaccount.web.constants.RegexConstants;
import com.liantuo.deposit.advanceaccount.web.util.CannotEmptyString;
import com.liantuo.trade.common.constants.TradeConstants;

/**
 * @类名: CreditAccountPageQueryReqVo
 * @类说明: 账户查询接口请求参数(服务端)
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
public class CreditAccountPageQueryReqVo{

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
	* @字段名 accountNo : 账户编号
	*/
	@CannotEmptyString(message = "account_no format error", regexp = RegexConstants.ACCOUNTNO_REGEX)
	private String accountNo;
	
	/**
	* @字段名 merchantNo : 商户编号
	*/
	@Length(min=2,max=32,message="merchant_no format error")
	private String merchantNo;
	/**
	* @字段名 accountName : 账户名称
	*/
	@Length(min=1,max=45,message="account_name format error")
	private String accountName;
	/**
	* @字段名 accountType : 账户类型
	* 账户类型：1-企业; 2-个人; 3-内部账户
	*/
	@Pattern(message = "account_type format error", regexp = "[1|2|3]")
	private String accountType;
	/**
	* @字段名 status : 账户状态
	* 账户状态：1-正常；2-冻结状态；3-待确认
	*/
	@Pattern(message = "status format error", regexp = "[1|2|3]")
	private String status;
	
	/**
	* @字段名 createTimeStart : 开始时间
	*/
	@CannotEmptyString(message="gmt_date_begin format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE)
	private String createTimeStart;
	
	/**
	* @字段名 createTimeEnd : 结束时间
	*/
	@CannotEmptyString(message="gmt_date_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE)
	private String createTimeEnd;
	
	/**
	* @字段名 currentPage : 分页页数
	* 默认0页，0表示第一页
	     如总页数为20页，则分页页数为0-19页
	*/
	//@Pattern(message="page format error", regexp =RegexConstants.CURRENTPAGE_REGEX )
	@CannotEmptyString(message="page format error", regexp =RegexConstants.CURRENTPAGE_REGEX )
	private String currentPage;
	
	/**
	* @字段名 showCount : 分页每页条数
	* 默认50条，最大100条
	*/
	//@Pattern(message="page_size format error", regexp =RegexConstants.SHOWCOUNT_REGEX )
	@CannotEmptyString(message="page_size format error", regexp =RegexConstants.SHOWCOUNT_REGEX )
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

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
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

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
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
	
	
}
