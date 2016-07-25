package com.liantuo.deposit.advanceaccount.web.vo.rsp;



public class DepositRsp {
	/**
	* @字段名 success : 结果 S-成功，F-失败
	*/
	private String success;
	
	/**
	* @字段名 retCode : 错误码
	*/
	private String retCode;
	
	/**
	* @字段名 retInfo : 错误描述
	*/
	private String retInfo;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetInfo() {
		return retInfo;
	}

	public void setRetInfo(String retInfo) {
		this.retInfo = retInfo;
	}
	
    
    public void setResult(String success , String retCode,String retInfo){
    	this.success = success;
    	this.retCode = retCode;
    	this.retInfo = retInfo;
    }
	
}
