package com.liantuo.trade.common.util.properties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {
	/**
	 * properites文件名为key一个Map
	 */
	private static Map<String, Properties> proMap = new HashMap<String, Properties>();
	
	public static synchronized Properties getProperties(String filePath) {
		try {
			if(proMap.containsKey(filePath)) {
	        	return proMap.get(filePath);
            } else {
    			Properties prop = new Properties();
                prop.load(com.payment.util.tenpay.util.PropertyUtil.class.getResourceAsStream(filePath));
            	proMap.put(filePath, prop);
            	return prop;
             }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param key propertiesd对应的key
	 * @param filePath 文件相对路径 如：com/properties/server.properties
	 * @return key对应的value
	 */
	public static String getProperty(String key , String filePath) {
		Properties property = com.payment.util.tenpay.util.PropertyUtil.getProperties(filePath);
		return (String)property.get(key);
	}
}
