package com.liantuo.trade.web.controller.local;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Assert;
import org.junit.Test;

public class TestTradeDemoForZW {
	private static final String ENCODING = "UTF8";
	private String TRADE_URL1 = "http://127.0.0.1:8081/trade/creditAccountQueryInner/accountQuery.in";
	private static final int HTTP_TIME_OUT = 2000000;

	/**
	 * 0_011_账户查询接口-内部接口
	 * @throws Exception
	 */
	@Test
	public void trade_credit_account_query() throws Exception{

		SortedMap<String,String> paras = new TreeMap<String, String>();
		//不可空
		paras.put("coreMerchantNo", "CC_C2255709155");
		//可空
//		paras.put("poolNo", "PN01000000000012624");
//		paras.put("merchantNo", "CC_C2255709155");
//		paras.put("accountNo","CA21000000045963");
//		paras.put("accountName", "联拓结算账户");
//		paras.put("accountType", "1");
//		paras.put("status", "1");
		paras.put("createTimeStart", "2016-04-01 00:00:00");
		paras.put("createTimeEnd", "2016-04-02 00:00:00");
//		paras.put("currentPage", "");
//		paras.put("showCount", "99");

		String res = requestAsHttpPOST(TRADE_URL1, paras, ENCODING);
		Assert.assertNotNull(res);
		System.err.println(res);

	}






	public static String requestAsHttpPOST(String urlvalue, Map<String, String> paras , String enc) {
        HttpClient http = new HttpClient();
        PostMethod method = new PostMethod(urlvalue);
		method.getParams().setHttpElementCharset(enc);
		method.getParams().setContentCharset(enc);
		method.getParams().setCredentialCharset(enc);
        for (String key : paras.keySet()) {
            method.addParameter(key, paras.get(key));
        }
        System.out.println(paras);
        String result = "";
        try {
            http.executeMethod(method);
            http.setTimeout(HTTP_TIME_OUT * 1000);
            result = method.getResponseBodyAsString();
        } catch (IOException e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }

}
