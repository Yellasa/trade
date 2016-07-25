package com.liantuo.trade.bus.vo;

public class ZFPaymentAsynNotifyDetail {
	/**
	 * 错误原因
	 */
	private String reason;
	/**
	 * 失败原因描述
	 */
	private String reason_commont;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReason_commont() {
		return reason_commont;
	}
	public void setReason_commont(String reason_commont) {
		this.reason_commont = reason_commont;
	}
	
}
