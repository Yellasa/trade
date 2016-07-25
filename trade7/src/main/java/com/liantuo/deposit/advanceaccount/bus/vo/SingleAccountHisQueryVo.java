package com.liantuo.deposit.advanceaccount.bus.vo;

import java.util.Date;

import com.liantuo.deposit.common.plugin.mybatis.vo.Page;

public class SingleAccountHisQueryVo {

	private String partnerId;
	
	private String coreMerchantNo;
	
	private String accountNo;

	private Date gmtCreateBegin;
	
	private Date gmtCreateEnd;
	
	private String subAccountType;
	
	private String sortType;
	
	/**
	* @字段名 currentPage : 分页页数
	* 默认0页，0表示第一页
	     如总页数为20页，则分页页数为0-19页
	*/
	private String currentPage;
	/**
	* @字段名 page : 分页
	*/
	private Page page;
	/**
	* @字段名 showCount : 分页每页条数
	* 默认50条，最大1000条
	*/
	private String showCount;
	private String reservedFields1;
	private String reservedFields2;
	private String reservedFields3;
	private String outTradeNo;
	private String tradeCode;
	private String tradeNo;
	private String tradeReqCode;
	private String tradeReqNo;
	
	public String getPartnerId() {
		return partnerId;
	}

	public Date getGmtCreateBegin() {
		return gmtCreateBegin;
	}

	public void setGmtCreateBegin(Date gmtCreateBegin) {
		this.gmtCreateBegin = gmtCreateBegin;
	}

	public Date getGmtCreateEnd() {
		return gmtCreateEnd;
	}

	public void setGmtCreateEnd(Date gmtCreateEnd) {
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
