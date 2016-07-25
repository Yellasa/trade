package com.liantuo.trade.common.constants;

import java.util.HashMap;
import java.util.Map;

public class TradeServiceConstants {
	private static Map<String, String> serviceMap;
	public final static String VERSION_CODE = ":1.0" ;
	public static synchronized Map<String, String> getServiceMap() {
		if (serviceMap == null) {
			serviceMap = new HashMap<String, String>();
			initServiceMap(serviceMap);
		}
		return serviceMap;
	}

	private static void initServiceMap(Map<String, String> serviceMap) {
		serviceMap.put(TradeConstants.ALI_ASYN_PAY_CHANNEL+VERSION_CODE, "alipayAsynTradePrecreateService");
		serviceMap.put(TradeConstants.WX_ASYN_PAY_CHANNEL+VERSION_CODE, "weiXinUnifiedOrderNotifyService");
	}
}
