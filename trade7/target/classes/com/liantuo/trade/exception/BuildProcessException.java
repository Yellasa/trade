package com.liantuo.trade.exception;


public class BuildProcessException extends BusinessCheckedException{

	private static final long serialVersionUID = 2189704174497893768L;

	public BuildProcessException() {
    }

    public BuildProcessException(String message) {
        super(message);
    }

    public BuildProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuildProcessException(Throwable cause) {
        super(cause);
    }
}
