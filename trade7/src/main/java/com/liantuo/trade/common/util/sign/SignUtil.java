package com.liantuo.trade.common.util.sign;

import java.util.*;


import com.ebill.framework.res.BeanUtils;
import com.payment.util.tenpay.util.MD5Util;

public class SignUtil {
	public static String createSign(Map<String, Object> paras, String key,
			String enc) {
		SortedMap<String, Object> paraMap = new TreeMap<String, Object>();
		paraMap.putAll(paras);
		StringBuffer sb = new StringBuffer();
		Set<Map.Entry<String,Object>> es = paraMap.entrySet();
		Iterator<Map.Entry<String, Object>> it = es.iterator();
		while (it.hasNext()) {
			Map.Entry<String,Object> entry = it.next();
			String k = entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + key);
		/* System.err.println("key=" + key); */
		return MD5Util.MD5Encode(sb.toString(), enc).toLowerCase();
	}

	public static String createSign(Object pojo, String key, String enc) {
		StringBuffer sb = new StringBuffer();
		sb.append(pojo);
		sb.append("key=" + key);
		return MD5Util.MD5Encode(sb.toString(), enc).toLowerCase();
	}

}
