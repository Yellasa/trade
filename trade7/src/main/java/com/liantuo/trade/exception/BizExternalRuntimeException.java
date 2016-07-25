package com.liantuo.trade.exception;

/**
 * 外部异常
 * @author yjs
 *
 */
public class BizExternalRuntimeException extends BusinessUncheckedException{
	

	private static final long serialVersionUID = -1487624783969954726L;
	public BizExternalRuntimeException(String errorCode, String errorMessage) {
        super(errorCode,errorMessage);
    }
    public BizExternalRuntimeException(String key){
    	this.key = key;
    }
    
    public BizExternalRuntimeException(String message, Throwable cause){
    	super(message,cause);
    }
    public BizExternalRuntimeException (Exception e, String errorCode, String errorMessage){
    	super(e,errorCode,errorMessage);
    }
    public BizExternalRuntimeException(){
    	super();
    }


}
