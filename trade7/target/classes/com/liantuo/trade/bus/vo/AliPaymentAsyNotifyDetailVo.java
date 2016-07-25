package com.liantuo.trade.bus.vo;

/**
 * 
 * ClassName: AliPaymentAsyNotifyDetailVo
 * @Description: 支付中心通知交易中心详细信息VO
 * @author zzd
 * @date 2016-5-3
 */
public class AliPaymentAsyNotifyDetailVo {

	/**
	 * 流水号
	 */
	private String serialNumber;
	/**
	 * 收款方账号
	 */
	private String receive_account_no;
	/**
	 * 收款账号姓名
	 */
	private String receive_account_name;
	/**
	 * 付款金额
	 */
	private String payment;
	/**
	 * 成功(失败)标示
	 */
	private String flag;
    /**
     * 成功（失败）原因
     */
	private String reason;
	/**
	 * 支付宝内部流水号
	 */
	private String alipayment_inner_trade_no;
	/**
	 * 完成时间
	 */
	private String complimentTime;
	/**
	 * 失败原因描述
	 */
	private String reason_commont;
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getReceive_account_no() {
		return receive_account_no;
	}
	public void setReceive_account_no(String receiveAccountNo) {
		receive_account_no = receiveAccountNo;
	}
	public String getReceive_account_name() {
		return receive_account_name;
	}
	public void setReceive_account_name(String receiveAccountName) {
		receive_account_name = receiveAccountName;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getAlipayment_inner_trade_no() {
		return alipayment_inner_trade_no;
	}
	public void setAlipayment_inner_trade_no(String alipaymentInnerTradeNo) {
		alipayment_inner_trade_no = alipaymentInnerTradeNo;
	}
	public String getComplimentTime() {
		return complimentTime;
	}
	public void setComplimentTime(String complimentTime) {
		this.complimentTime = complimentTime;
	}
	public String getReason_commont() {
		return reason_commont;
	}
	public void setReason_commont(String reasonCommont) {
		reason_commont = reasonCommont;
	}
	
}
