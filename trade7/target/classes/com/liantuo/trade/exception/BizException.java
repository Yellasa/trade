package com.liantuo.trade.exception;

/**
 * 内部非回滚异常
 * @author yjs
 *
 */
public class BizException extends BusinessCheckedException {

	private static final long serialVersionUID = 818653822917097465L;
	public BizException(String errorCode,String errorMessage){
		super(errorCode,errorMessage);
	}
	public BizException(String key){
		this.key = key;
	}
	public BizException(){
		super();
	}
	

	
}
