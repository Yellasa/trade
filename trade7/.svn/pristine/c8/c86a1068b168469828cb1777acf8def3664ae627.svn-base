package com.liantuo.trade.web.controller.local;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liantuo.trade.client.trade.packet.body.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyUnFreezeOfflineSettle;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqFullUnFreeze;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqMerchantFreeze;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqPayPageDetails;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqRefundPageDetails;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqUnFreezeOfflineSettle;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspFullUnFreeze;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspMerchantFreeze;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspPayPageDetails;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspRefundPageDetails;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspUnFreezeOfflineSettle;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.orm.pojo.TradePayment;

public class TestTradeDemo {


	 private String TRADE_URL ="http://127.0.0.1:5555/trade/service/tx.in";//本地地址
//	 private String TRADE_URL ="http://192.168.19.63:8000/trade/service/tx.in";//线下地址

	// private String TRADE_URL ="http://192.168.30.141:8000/trade/service/tx.in";//线上内网
//	private String TRADE_URL = "http://trade.51ebill.com/trade/service/tx.in";// 线上地址
	
	//线下测试数据：PID:10012426000150917、POOL:PN01000000000010876、core_merchant_no:CC_C8785258588、成员CA:CA21000000017026
	//线上测试数据：PID:10038012689151119、POOL:PN01000000000032988、core_merchant_no:EW_B1156484098、成员CA:CA21000000029960
	//CA21000000029957、10000002048131212、liantuo、PN01000000000000761

	/**
	 * 0001_001_001：成员冻结
	 * @throws Exception
	 */
	@Test
	public void testFreeze() throws Exception{
		TradePacketReqMerchantFreeze bizReq = new TradePacketReqMerchantFreeze();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();

		head.setRequest_code("0001_001_001");
		head.setVersion("1");

		head.setPartner_id("10012426000150917");//10038012689151119 10012426000150917
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098 CC_C8785258588
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988 PN01000000000010876

		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setOut_trade_no_ext("12345678920160329026");
		body.setOut_trade_no("1234567892016032906");
		body.setPayment_account_no("CA21000000017026");//CA21000000029960 CA21000000017026

		body.setFreeze_amount("1");
		body.setMerchant_extend_field_1("");
		body.setMerchant_extend_field_2("扩展参数2");

		bizReq.setBusHead(head);
		bizReq.setBody(body);

		String reqXml = bizReq.marshal();
		System.out.println("reqXml="+reqXml);
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("para", reqXml);

		String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
		System.out.println("rspXml===========" + rspXml);
		TradePacketRspMerchantFreeze rsp = (TradePacketRspMerchantFreeze) TradePacket.unmarshal(rspXml, TradePacketRspMerchantFreeze.class);

		// TradePacketRspMerchantFreeze rsp =
		// TradeClient.merchantFreeze(bizReq);

		if (null != rsp) {
			System.err.println(rsp.marshal());
		}
	}

	/**
	 * 0001_001_002：线下付款，剩余解冻
	 */
	@Test
	public void testUnFreezeOffline() {
		TradePacketReqUnFreezeOfflineSettle bizReq = new TradePacketReqUnFreezeOfflineSettle();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyUnFreezeOfflineSettle body = new TradePacketReqBodyUnFreezeOfflineSettle();

		head.setRequest_code("0001_001_002");
		head.setVersion("1");

		head.setPartner_id("10012426000150917");//10038012689151119 10012426000150917
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098 CC_C8785258588
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988 PN01000000000010876

		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setTrade_no("00010011604061532416980000236200");
		body.setClear_channel("w123");
		body.setGmt_success_clear_channel("2015-01-02 14:23:15");
		body.setThird_trade_no("w11111");
		body.setActual_amount("1");
		body.setClear_channel_attr_1("clearChannelAttr_1");
		body.setClear_channel_attr_2("clearChannelAttr_2");
		body.setClear_channel_attr_3("clearChannelAttr_3");
		body.setClear_channel_attr_4("clearChannelAttr_4");
		body.setClear_channel_attr_5("clearChannelAttr_5");
		body.setClear_channel_attr_6("clearChannelAttr_6");

		bizReq.setBusHead(head);
		bizReq.setBody(body);

		String reqXml = bizReq.marshal();
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("para", reqXml);

		String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
		System.out.println("rspXml===========" + rspXml);
		TradePacketRspUnFreezeOfflineSettle rsp = (TradePacketRspUnFreezeOfflineSettle) TradePacket.unmarshal(rspXml, TradePacketRspUnFreezeOfflineSettle.class);

		// TradePacketRspUnFreezeOfflineSettle rsp =TradeClient.FreezeOfflineSettle(bizReq);

		if (null != rsp) {
			System.err.println(rsp.marshal());
		}
	}
	
	/**
	 * 0001_001_003：全额解冻
	 */
	@Test
	public void testUnFreezeAll() {
		TradePacketReqFullUnFreeze fullUnFreeze =new TradePacketReqFullUnFreeze();
		TradePacketHead head=new TradePacketHead();
		TradePacketReqBodyFullUnFreeze body=new TradePacketReqBodyFullUnFreeze();
		
		head.setRequest_code("0001_001_003");
		head.setVersion("1");
		head.setPartner_id("10038012689151119");
		head.setCore_merchant_no("EW_B1156484098");
		head.setFund_pool_no("PN01000000000032988");
		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setTrade_no("000000000000001400201512231054447");

		fullUnFreeze.setBusHead(head);
		fullUnFreeze.setBody(body);

		String reqXml = fullUnFreeze.marshal();
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("para", reqXml);

		String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
		System.out.println("rspXml===========" + rspXml);
		TradePacketRspFullUnFreeze rsp = (TradePacketRspFullUnFreeze) TradePacket.unmarshal(rspXml, TradePacketRspFullUnFreeze.class);

//		TradePacketRspFullUnFreeze rsp=TradeClient.fullUnFreeze(fullUnFreeze);

		if (null != rsp) {
			System.err.println(rsp.marshal());
		}
	}
	
	/**
	 * 0001_001_004：CA付款成功，剩余解冻
	 */
	@Test
	public void testUnFreezeOnline() {
//		TradePacketReqUnFreezeOnlineSettle OnlineSettle=new TradePacketReqUnFreezeOnlineSettle(); 
//		TradePacketHead head=new TradePacketHead();
//		TradePacketReqBodyUnFreezeOnlineSettle body=new TradePacketReqBodyUnFreezeOnlineSettle();
//		
//		head.setRequest_code("0001_001_004");
//		head.setVersion("1");
//		head.setPartner_id("10038012689151119");
//		head.setCore_merchant_no("EW_B1156484098");
//		head.setFund_pool_no("PN01000000000032988");
//		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
//		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
//		
//		body.setActual_amount("5.00");
//		body.setReceive_account_no("CA21000000030059");
//		body.setTrade_no("000000000000001400201512231054447");
//		
//		OnlineSettle.setBusHead(head);
//		OnlineSettle.setBody(body);
//		TradePacketRspUnFreezeOnlineSettle resp=TradeClient.(OnlineSettle);
	}
	
	/**
	 * 0001_001_998：交易记录查询
	 */
	@Test
	public void testPaymentDetails() {
    	TradePacketReqPayPageDetails payPageDetails=new TradePacketReqPayPageDetails();
    	TradePacketHead head=new TradePacketHead();
    	TradePacketReqBodyPayPageDetails body=new TradePacketReqBodyPayPageDetails();
    	
    	head.setRequest_code("0001_001_998");
		head.setVersion("1");
		head.setPartner_id("10012426000150917");
		head.setCore_merchant_no("CC_C8785258588");
		head.setFund_pool_no("PN01000000000010876");
		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setTrade_no("20160115111452531000000000033400");
//		body.setPayment_merchant_no("12");
		
    	payPageDetails.setBusHead(head);
    	payPageDetails.setBody(body);
    	
    	String reqXml = payPageDetails.marshal();
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("para", reqXml);

		String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
		System.out.println("rspXml===========" + rspXml);
		TradePacketRspPayPageDetails rsp = (TradePacketRspPayPageDetails) TradePacket.unmarshal(rspXml, TradePacketRspPayPageDetails.class);

//		TradePacketRspPayPageDetails rsp=TradeClient.payPageDetails(payPageDetails);
		if (null != rsp) {
			System.err.println(rsp.marshal());
			
			List<TradePayment> ulist = new ArrayList<TradePayment>();
			ulist=(List<TradePayment>) Testjson.json2List(rsp.getBody().getTrade_details(),new TypeReference<List<TradePayment>>() {});
			System.out.println(ulist.get(0).getGmtCreated());
			System.out.println(DateUtil.toDateTime(ulist.get(0).getGmtCreated()));
		}
	}
	
	/**
	 * 0001_002_001:线下付款退回
	 */
	@Test
	public void testRefundOffline() {
		TradePacketReqRefundOfflineSettle req = new TradePacketReqRefundOfflineSettle();
        TradePacketHead head = new TradePacketHead();
        TradePacketReqBodyRefundOfflineSettle body = new TradePacketReqBodyRefundOfflineSettle();
        
        head.setRequest_code("0001_002_001");
		head.setVersion("1");
		head.setPartner_id("10038012689151119");
		head.setCore_merchant_no("EW_B1156484098");
		head.setFund_pool_no("PN01000000000032988");
		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

        body.setOut_trade_no_ext("zrx" + System.currentTimeMillis());
        body.setOriginal_trade_no("000000000000000700201512171928481");
        body.setGmt_refund_clear_channel("2015-10-10 10:10:10");
        body.setClear_refund_amount("1.2");
        body.setThird_trade_no("thirdTradeNo");

        body.setOut_trade_no("999");
        body.setClear_channel_attr_1("att1");
        body.setClear_channel_attr_2("att2");
        body.setClear_channel_attr_3("att3");
        body.setClear_channel_attr_4("att4");
        body.setClear_channel_attr_5("att5");
        body.setClear_channel_attr_6("att6");

        req.setBusHead(head);
        req.setBody(body);
        
        String reqXml = req.marshal();
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("para", reqXml);

		String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
		System.out.println("rspXml===========" + rspXml);
		TradePacketRspRefundOfflineSettle rsp = (TradePacketRspRefundOfflineSettle) TradePacket.unmarshal(rspXml, TradePacketRspRefundOfflineSettle.class);
//        TradePacketRspRefundOfflineSettle rsp = TradeClient.refundOfflineSettle(req);

        if (null != rsp) {
            System.err.println(rsp.marshal());
        }
	}
	
	/**
	 * 0001_002_998:退回交易记录查询
	 */
	@Test
	public void testRefundDetails() {
		TradePacketReqRefundPageDetails refundPageDetails=new TradePacketReqRefundPageDetails();
		TradePacketHead head=new TradePacketHead();
    	TradePacketReqBodyRefundPageDetails body=new TradePacketReqBodyRefundPageDetails();
		
    	head.setRequest_code("0001_002_998");
		head.setVersion("1");
		head.setPartner_id("10038012689151119");
		head.setCore_merchant_no("EW_B1156484098");
		head.setFund_pool_no("PN01000000000032988");
		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
    	
		
		body.setTrade_no("20151223102915842000000000002300");
    	body.setGmt_created_start("2015-12-23 10:28:12");
    	body.setGmt_created_end("2015-12-23 10:30:12");
    	body.setGmt_latest_modified_start("2015-12-23 10:28:15");
    	body.setGmt_latest_modified_end("2015-12-23 10:31:15");
    	body.setOut_trade_no_ext("test000000000000001");
    	
    	refundPageDetails.setBusHead(head);
    	refundPageDetails.setBody(body);
    	
    	String reqXml = refundPageDetails.marshal();
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("para", reqXml);

		String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
		System.out.println("rspXml===========" + rspXml);
		TradePacketRspRefundPageDetails rsp = (TradePacketRspRefundPageDetails) TradePacket.unmarshal(rspXml, TradePacketRspRefundPageDetails.class);
//		TradePacketRspRefundPageDetails rsp=TradeClient.refundPageDetails(refundPageDetails);

        if (null != rsp) {
            System.err.println(rsp.marshal());
        }
	}

	public static String requestAsHttpPOST(String urlvalue, Map<String, String> paras, String enc) {
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
