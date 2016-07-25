package com.liantuo.deposit.processor;

import com.liantuo.trade.spring.SpringUtils;

public class DepRequestProcessorFactory {
	
	public static DepRequestProcessor getProccessor(String requestCode, String version) {
		DepRequestProcessor drp = SpringUtils.getBean("dep_"+requestCode + "_"
				+ version);
		return drp;
	}
}
