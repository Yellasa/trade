package com.liantuo.trade.web.controller.local;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqMerchantFreeze;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspMerchantFreeze;

public class TradeMerchantFreezeTestHttp {

//	 private String TRADE_URL = "http://127.0.0.1:6666/trade/service/tx.in";//本地地址
//	 private String TRADE_URL = "http://192.168.19.63:8000/trade/service/tx.in";//线下地址
//	 private String TRADE_URL = "http://192.168.30.141:8000/trade/service/tx.in";//线上内网
	 private String TRADE_URL = "http://trade.51ebill.com/trade/service/tx.in";//线上地址


	    @Test
	    public void testFreeze() throws Exception {
	    	 TradePacketReqMerchantFreeze bizReq = new TradePacketReqMerchantFreeze();
	         TradePacketHead head = new TradePacketHead();
	         TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
	         
	         head.setRequest_code("0001_001_001");
	         head.setVersion("1");
	         head.setPartner_id("10012426000150917");
	         head.setCore_merchant_no("CC_C8785258588");
	         head.setFund_pool_no("PN01000000000010876");
	         head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
	         head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
	         
	         body.setOut_trade_no_ext("12345678920151230003");
//	         body.setOut_trade_no("1234567892015122601");
	         body.setPayment_account_no("CA21000000017026");
	         body.setFreeze_amount("1");
	         body.setMerchant_extend_field_1("扩展字段1");
	         body.setMerchant_extend_field_2("扩展参数2");

	         bizReq.setBusHead(head);
	         bizReq.setBody(body);
	         
	         String reqXml = bizReq.marshal();
	         Map<String, String> paras = new HashMap<String, String>();
	         paras.put("para", reqXml);
	         
	         String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
	         System.out.println("rspXml==========="+rspXml);
	         TradePacketRspMerchantFreeze rsp = (TradePacketRspMerchantFreeze) TradePacket.unmarshal(rspXml,
	                 TradePacketRspMerchantFreeze.class);
	         
//	         TradePacketRspMerchantFreeze rsp = TradeClient.merchantFreeze(bizReq);

	         if (null != rsp) {
	             System.err.println(rsp.marshal());
	         }
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
	            http.setTimeout(20 * 1000);
	            result = method.getResponseBodyAsString();
	        } catch (IOException e) {
	            result = "";
	            e.printStackTrace();
	        }
	        return result;
	    }
}
