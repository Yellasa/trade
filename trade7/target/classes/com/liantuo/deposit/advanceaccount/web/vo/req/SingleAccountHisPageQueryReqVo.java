package com.liantuo.deposit.advanceaccount.web.vo.req;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.liantuo.deposit.advanceaccount.web.util.CannotEmptyString;
import com.liantuo.deposit.common.plugin.mybatis.vo.Page;
import com.liantuo.trade.common.constants.TradeConstants;

/**
 * @类名: SingleAccountHisPageQueryReqVo
 * @类说明: 单账户账务历史查询接口请求参数(服务端)
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: bjl
 * @创建时间: 2016年1月8日 下午2:46:26
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */
public class SingleAccountHisPageQueryReqVo{

	/**
	* @字段名 coreMerchantNo : 核心商户编号
	*/
	@NotBlank(message="core_merchant_no is required")
	@Length(min=2,max=32,message="core_merchant_no format error")
	private String coreMerchantNo;
	
	/**
	* @字段名 poolNo : 资金池编号
	*/
	@CannotEmptyString(message = "fund_pool_no format error", regexp = "[\\d|a-z-A-Z]{19,32}")
	private String poolNo;
	
	/**
	* @字段名 accountNo : 账户编号
	*/
	@NotBlank(message="account_no is required")
	@Pattern(message = "account_no format error", regexp = "[\\d|a-z-A-Z]{10,32}")
	private String accountNo;
	
	/**
	* @字段名 sequenceNo : 交易发起方业务系统订单号
	*/
	@CannotEmptyString(message = "out_trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,64}")
	private String sequenceNo;
	
	/**
	* @字段名 tradeCode : 所属业务交易类型
	*/
	@CannotEmptyString(message = "trade_code format error", regexp = "[\\d|_]{1,32}")
	private String tradeCode;
	
	/**
	* @字段名 tradeNo : 所属业务交易编号
	*/
	@CannotEmptyString(message = "trade_no format error", regexp = "[\\d|a-z-A-Z|_]{8,32}")
	private String tradeNo;
	
	/**
	* @字段名 tradeReqCode : 所属业务交易请求类型
	*/
	@CannotEmptyString(message = "trade_req_type format error", regexp = "[\\d|_]{1,32}")
	private String tradeReqCode;
	
	/**
	* @字段名 tradeStepNo : 所属业务交易请求编号
	*/
	@CannotEmptyString(message = "trade_req_no format error", regexp = "[\\d|a-z-A-Z|_]{8,32}")
	private String tradeStepNo;
	
	/**
	* @字段名 beginTime : 账务历史开始时间
	*/
	@NotBlank(message="gmt_date_begin is required")
	@Pattern(message="gmt_date_begin format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE)
	private String beginTime;
	
	/**
	* @字段名 endTime : 账务历史结束时间
	*/
	@NotBlank(message="gmt_date_end is required")
	@Pattern(message="gmt_date_end format error", regexp = TradeConstants.TRADE_REGEX_FORMAT_PAY_DATE)
	private String endTime;
	
	/**
	* @字段名 sortType : 排序方式
	* 00：按照【账户变动日期时间】升序排列 01：按照【账户变动日期时间】降序排列 默认00
	*/
	@Pattern(message = "sort_type format error", regexp = "00|01")
	private String sortType;
	
	/**
	* @字段名 type : 账务历史类型  FRZ-冻结；AVL-可用;ALL-全部
	*/
	@NotBlank(message="account_his_type is required")
	@Pattern(message = "account_his_type format error", regexp = "FRZ|AVL|ALL")
	private String type;
	/**
	* @字段名 reservedFields1 reservedFields2 reservedFields3 精确查询
	*/
	@Length(max=1024,message="reserved_fields1 format error")
	private String reservedFields1;
	@Length(max=1024,message="reserved_Fields2 format error")
	private String reservedFields2;
	@Length(max=1024,message="reserved_fields3 format error")
	private String reservedFields3;
	/**
	* @字段名 reservedFields1Fuzzy reservedFields2Fuzzy reservedFields3Fuzzy 模糊查询
	*/
	@Length(max=1024,message="reserved_fields1_fuzzy format error")
	private String reservedFields1Fuzzy;
	@Length(max=1024,message="reserved_fields2_fuzzy format error")
	private String reservedFields2Fuzzy;
	@Length(max=1024,message="reserved_fields3_fuzzy format error")
	private String reservedFields3Fuzzy;
	/**
	* @字段名 page : 分页
	*/
	private Page page;
	
	/**
	* @字段名 currentPage : 分页页数
	* 默认0页，0表示第一页
	     如总页数为20页，则分页页数为0-19页  9位
	*/
	@CannotEmptyString(message = "page format error", regexp = "^[1-9]\\d{0,8}|0")
	private String currentPage;
	
	/**
	* @字段名 showCount : 分页每页条数
	* 默认50条，最大1000条
	*/
//    @Pattern(message = "page_size format error", regexp = "^(?:[1-9]{1,3}|1000)$")   ^(?!00)(?:[0-9]{1,3}|1000)$
	@CannotEmptyString(message = "page_size format error", regexp = "^([1-9]\\d{0,2}|1000)$")
	private String showCount;
	private Integer creditAccountId;
	
	@NotBlank(message="partner_id is required")
	@Pattern(message = "partner_id format error", regexp = "[\\d]{17,17}")
	private String partnerId;
	
	public Integer getCreditAccountId() {
		return creditAccountId;
	}

	public void setCreditAccountId(Integer creditAccountId) {
		this.creditAccountId = creditAccountId;
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

	public String getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	
	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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

	public String getTradeStepNo() {
		return tradeStepNo;
	}

	public void setTradeStepNo(String tradeStepNo) {
		this.tradeStepNo = tradeStepNo;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
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

	public String getReservedFields1Fuzzy() {
		return reservedFields1Fuzzy;
	}

	public void setReservedFields1Fuzzy(String reservedFields1Fuzzy) {
		this.reservedFields1Fuzzy = reservedFields1Fuzzy;
	}

	public String getReservedFields2Fuzzy() {
		return reservedFields2Fuzzy;
	}

	public void setReservedFields2Fuzzy(String reservedFields2Fuzzy) {
		this.reservedFields2Fuzzy = reservedFields2Fuzzy;
	}

	public String getReservedFields3Fuzzy() {
		return reservedFields3Fuzzy;
	}

	public void setReservedFields3Fuzzy(String reservedFields3Fuzzy) {
		this.reservedFields3Fuzzy = reservedFields3Fuzzy;
	}
	
}
