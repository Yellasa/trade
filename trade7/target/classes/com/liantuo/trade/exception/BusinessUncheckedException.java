package com.liantuo.trade.exception;


/**
 * 业务异常体系建议继承自BusinessException
 * 该类不建议继续使用
 * @author dengchao
 *
 */
@Deprecated
public class BusinessUncheckedException extends BusinessException {


	private static final long serialVersionUID = -2523338937618698944L;
	// 错误码
    protected String errorCode;
    // 错误信息
    protected String errorMessage;
    protected String key;
    public BusinessUncheckedException(){
    	super();
    }

    public BusinessUncheckedException(String msg)
    {
        super(msg);
    }

    public BusinessUncheckedException(Exception e)
    {
        super(e);
        if (e instanceof BusinessUncheckedException)
        {
            BusinessUncheckedException be = (BusinessUncheckedException) e;
            this.errorCode = be.errorCode;
            this.errorMessage = be.errorMessage;
        }
        else
        {
            this.errorCode = "UNKNOWN_EXCEPTION";
            this.errorMessage = e.getMessage();
        }
    }

    public BusinessUncheckedException(String errorCode, String errorMessage)
    {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BusinessUncheckedException(Exception e, String errorCode, String errorMessage)
    {
        this(e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * @param cause
     */
    public BusinessUncheckedException(Throwable cause)
    {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public BusinessUncheckedException(String message, Throwable cause)
    {
        super(message, cause);
    }

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
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
