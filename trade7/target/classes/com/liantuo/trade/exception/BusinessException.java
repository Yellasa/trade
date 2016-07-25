package com.liantuo.trade.exception;

public class BusinessException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -392419467548677317L;
	
	private String errorCode;
	private String errorMessage;
	private String key;
	
	public BusinessException(){
		super();
	}
	public BusinessException(String msg){
		super(msg);
		
	}
	public BusinessException(Throwable cause) {
		super(cause);
	}
	public BusinessException(String errorCode,String errorMessage){
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	/**
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	public void setErrorCode(String errorCode){
		this.errorCode = errorCode;
	}
	public String getErrorCode(){
		return errorCode;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setKey(String key){
		this.key = key;
	}
	public String getKey(){
		return key;
	}
}