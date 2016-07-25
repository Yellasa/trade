package com.liantuo.deposit.advanceaccount.web.vo.req;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.deposit.advanceaccount.web.constants.RegexConstants;
import com.liantuo.deposit.advanceaccount.web.util.CannotEmptyString;
import com.liantuo.deposit.common.plugin.mybatis.vo.Page;
import com.liantuo.trade.common.constants.TradeConstants;

/**
 * @类名: SingleAccountHisPageQueryReqVo
 * @类说明: 单账户账务历史查询接口请求参数(服务端)
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
public class SingleAccountHisQueryReqVo{

	@NotBlank(message="partner_id is required")
	@Pattern(message="partner_id format error", regexp = RegexConstants.PARTNERID_REGEX)
	private String partnerId;
	
	@NotBlank(message="core_merchant_no is required")
	@Pattern(message="core_merchant_no format error", regexp = RegexConstants.coreMerchantNO_REGEX)
	private String coreMerchantNo;
	
	@NotBlank(message="account_no is required")
	@Pattern(message = "account_no format error", regexp = "[\\d|a-zA-Z]{6,32}")
	private String accountNo;
	
	@NotBlank(message="gmt_create_begin is required")
	@Pattern(message="gmt_create_begin format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE)
	private String gmtCreateBegin;
	
	@NotBlank(message="gmt_create_end is required")
	@Pattern(message="gmt_create_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE)
	private String gmtCreateEnd;
	
	@NotBlank(message="sub_account_type is required")
	@Pattern(message = "sub_account_type format error", regexp = "FRZ|AVL|ALL")
	private String subAccountType;
	
	@CannotEmptyString(message = "sort_type format error", regexp = "00|01")
	private String sortType;
	
	/**
	* @字段名 currentPage : 分页页数
	* 默认0页，0表示第一页
	     如总页数为20页，则分页页数为0-19页
	*/
	@CannotEmptyString(message="current_page format error", regexp ="^[1-9]\\d{0,7}|0" )
	private String currentPage;
	/**
	* @字段名 page : 分页
	*/
	private Page page;
	/**
	* @字段名 showCount : 分页每页条数
	* 默认50条，最大1000条
	*/
	@CannotEmptyString(message="show_count format error", regexp =RegexConstants.POOL_SHOWCOUNT_REGEX )
	private String showCount;

	private String reservedFields1;
	private String reservedFields2;
	private String reservedFields3;
	
	
	@Pattern(message="out_trade_no format error", regexp = "[\\d|a-zA-Z|_]{8,64}")
	private String outTradeNo;
	@Pattern(message="trade_code format error", regexp = "[\\d|_]{1,32}")
	private String tradeCode;
	@Pattern(message="trade_no format error", regexp = "[\\d|a-zA-Z|_]{8,32}")
	private String tradeNo;
	@Pattern(message="trade_req_code format error", regexp = "[\\d|_]{1,32}")
	private String tradeReqCode;
	@Pattern(message="trade_req_no format error", regexp = "[\\d|a-zA-Z|_]{8,64}")
	private String tradeReqNo;
	
	public String getPartnerId() {
		return partnerId;
	}

	public String getGmtCreateBegin() {
		return gmtCreateBegin;
	}

	public void setGmtCreateBegin(String gmtCreateBegin) {
		this.gmtCreateBegin = gmtCreateBegin;
	}

	public String getGmtCreateEnd() {
		return gmtCreateEnd;
	}

	public void setGmtCreateEnd(String gmtCreateEnd) {
		this.gmtCreateEnd = gmtCreateEnd;
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

	public String getReservedFields1() {
		return reservedFields1;
	}

	public void setReservedFields1(String reservedFields1) {
		this.reservedFields1 = reservedFields1;
	}

	public String getReservedFields2() {
		return reservedFields2;
	}

	public void setReservedFields2(String reservedFields2) {
		this.reservedFields2 = reservedFields2;
	}

	public String getReservedFields3() {
		return reservedFields3;
	}

	public void setReservedFields3(String reservedFields3) {
		this.reservedFields3 = reservedFields3;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getTradeReqCode() {
		return tradeReqCode;
	}

	public void setTradeReqCode(String tradeReqCode) {
		this.tradeReqCode = tradeReqCode;
	}

	public String getTradeReqNo() {
		return tradeReqNo;
	}

	public void setTradeReqNo(String tradeReqNo) {
		this.tradeReqNo = tradeReqNo;
	}

	public String getSubAccountType() {
		return subAccountType;
	}

	public void setSubAccountType(String subAccountType) {
		this.subAccountType = subAccountType;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
