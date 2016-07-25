package com.liantuo.trade.exception;

public class BizRuntimeException extends BusinessUncheckedException{
    
	private static final long serialVersionUID = -7332441706022209142L;
	public BizRuntimeException(String errorCode,String errorMessage){
		super(errorCode,errorMessage);
	}
	public BizRuntimeException(){
		super();
	}
	public BizRuntimeException(String key){
		this.key = key;
	}
	private String key;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
   
}
