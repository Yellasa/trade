package com.liantuo.trade.exception;

public class MerchantFreezeException extends BusinessUncheckedException {

	private static final long serialVersionUID = 2604765608979361302L;

	public MerchantFreezeException(){
		super();
	}
	/**
	 * 错误编码
	 * @param message
	 */
	public MerchantFreezeException(String message){
		super(message);
	}
	public MerchantFreezeException(String errorCode,String errorMessage){
		super(errorCode,errorMessage);
	}
    public MerchantFreezeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MerchantFreezeException(Throwable cause) {
        super(cause);
    }
}
