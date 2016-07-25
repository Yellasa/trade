package com.liantuo.deposit.common.constants.errorcode;

/**
 * 0_012V1.0预存款账户批量禁止结构变更
 * @author shb
 *
 */

public class ErrorCode012Constants {
	
	/**
	* @字段名 ACCOUNT_FORBID_CHECK_NOT_PASS : 禁止结构格式校验未通过
	*/
	public static final String ACCOUNT_FORBID_CHECK_NOT_PASS = "ZW00121000100";
	/**
	* @字段名 POOL_OPEN_NAME_REPEAT : 禁止结构核心商户编号不存在
	*/
	public static final String ACCOUNT_FORBID_COREMERCHANTNO_NO_EXIST = "ZW00121000200";
	/**
	* @字段名 POOL_OPEN_NAME_REPEAT : 禁止结构输入参数有误
	*/
	public static final String INPUT_PARAMETER_ERROR = "ZW00121000300";
	/**
	* @字段名 POOL_OPEN_NAME_REPEAT : 禁止结构数据不可重复
	*/
	public static final String DATA_REPEAT = "ZW00121000400"; 
	
	/**
	* @字段名 ACCOUNT_FORBID_DATA_NO_MATCH : 禁止结构数据不匹配
	*/
	public static final String ACCOUNT_FORBID_DATA_NO_MATCH = "ZW00121000600";
	
	/**
	* @字段名 ACCOUNT_FORBID_DATA_NO_EXIST : 禁止结构数据不存在
	*/
	public static final String ACCOUNT_FORBID_DATA_NO_EXIST = "ZW00121000500";

}
