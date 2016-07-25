package com.liantuo.trade.bus.vo;

public class NoticeVo {
	private String notifyUrl;
	private String errorCode;
	private String errorMessage;
	private String result;
	private String tradeData;

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTradeData() {
		return tradeData;
	}

	public void setTradeData(String tradeData) {
		this.tradeData = tradeData;
	}

}
