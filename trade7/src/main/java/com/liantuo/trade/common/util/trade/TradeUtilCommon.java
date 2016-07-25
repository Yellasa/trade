package com.liantuo.trade.common.util.trade;

public class TradeUtilCommon {

	/**
	 * 根据请求类型获取交易类型（0001_001_002->0001_001）
	 * @param req_code
	 * @return
	 */
	public static String getTradeType(String req_code){
		return req_code.substring(0,8);
	}
	
	/**获取seqence拼接（0001_001_002->0001001）
	 * @param req_code
	 * @return
	 */
	public static String getServiceCode(String req_code){
		return req_code.substring(0,4)+req_code.substring(5,8);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getServiceCode("0001_001_002"));;
	}
}
