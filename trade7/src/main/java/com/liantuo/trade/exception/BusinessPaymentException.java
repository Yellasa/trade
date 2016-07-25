package com.liantuo.trade.exception;

public class BusinessPaymentException extends RuntimeException{
	
	private static final long serialVersionUID = 2542377975946722096L;
	private String errorCode;
	private String errorMessage;
	private String busErrorCode;
	private String busErrorMessage;
	private String key;
	
	public BusinessPaymentException(){
		super();
	}
	public BusinessPaymentException(String msg){
		super(msg);
		
	}
	public BusinessPaymentException(Throwable cause) {
		super(cause);
	}
	public BusinessPaymentException(String busErrorCode,String busErrorMessage){
		super(busErrorMessage);
		this.busErrorCode=busErrorCode;
		this.busErrorMessage=busErrorMessage;
	}
	public BusinessPaymentException(String errorCode,String errorMessage,String busErrorCode,String busErrorMessage){
		super(busErrorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.busErrorCode=busErrorCode;
		this.busErrorMessage=busErrorMessage;
	}
	/**
	 * @param message
	 * @param cause
	 */
	public BusinessPaymentException(String message, Throwable cause) {
		super(message, cause);
	}
	public String getBusErrorCode() {
		return busErrorCode;
	}
	public void setBusErrorCode(String busErrorCode) {
		this.busErrorCode = busErrorCode;
	}
	public String getBusErrorMessage() {
		return busErrorMessage;
	}
	public void setBusErrorMessage(String busErrorMessage) {
		this.busErrorMessage = busErrorMessage;
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}