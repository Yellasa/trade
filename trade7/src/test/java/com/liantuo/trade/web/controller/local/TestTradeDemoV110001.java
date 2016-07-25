/**
 * 
 */
package com.liantuo.trade.web.controller.local;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyFullUnFreeze;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyUnFreezeOfflineSettle;
import com.liantuo.trade.client.trade.packet.body.simple_fund_transfer.QueryPage4TransferDetail;
import com.liantuo.trade.client.trade.packet.body.simple_fund_transfer.TradePacketReqBodyMerchantTransfer;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

/**
 * @ClassName:     TestTradeDemoV110001.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-3-9 下午4:42:07 
 */
public class TestTradeDemoV110001 {

//	private String TRADE_URL ="http://127.0.0.1:5555/trade/service/tx.in";//本地地址
//	private String TRADE_URL ="http://192.168.4.115:5555/trade/service/tx.in";//本地地址
//	 private String TRADE_URL ="http://192.168.19.63:8000/trade/service/tx.in";//线下地址

	// private String TRADE_URL ="http://192.168.30.141:8000/trade/service/tx.in";//线上内网
//	private String TRADE_URL = "http://trade.51ebill.com/trade/service/tx.in";// 线上地址
	
	//线下测试数据：PID:10012426000150917、POOL:PN01000000000010876、core_merchant_no:CC_C8785258588、成员CA:CA21000000017026
	//线上测试数据：PID:10038012689151119、POOL:PN01000000000032988、core_merchant_no:EW_B1156484098、成员CA:CA21000000029960
	//CA21000000029957、10000002048131212、liantuo、PN01000000000000761

	/**
	 * V1.1
	 * 0001_001_001：成员冻结
	 * @throws Exception
	 */
	@Test
	public void testFreeze() throws Exception{
		TradeRequest<TradePacketReqBodyMerchantFreeze> bizReq = new TradeRequest<TradePacketReqBodyMerchantFreeze>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();

		head.setRequest_code("0001_001_001");
		head.setVersion("1.1");

		head.setPartner_id("10012426000150917");//10038012689151119 10012426000150917
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098 CC_C8785258588
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988 PN01000000000010876

		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setOut_trade_no_ext("123456789201604290153");
		body.setOut_trade_no("12345678920160329053");
		body.setPayment_account_no("CA21000000017026");//CA21000000029960 CA21000000017026

		body.setFreeze_amount("0.01");
		body.setMerchant_extend_field_1("");
		body.setMerchant_extend_field_2("扩展参数2");
		
		body.setAvl_bal_decr_field_1("avl1");
		body.setAvl_bal_decr_field_2("avl2");
		body.setAvl_bal_decr_field_3("avl3");
		body.setFro_bal_incr_field_1("fro1");
		body.setFro_bal_incr_field_2("fro2");
		body.setFro_bal_incr_field_3("fro3");

		bizReq.setHead(head);
		bizReq.setBody(body);

//		String requestXML = bizReq.marshal();
//		System.out.println("requestXML=="+requestXML);
		TradeResponse response = TradeClient.excute(bizReq);

		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
	/**
	 * 0001_001_002：线下付款，剩余解冻
	 */
	@Test
	public void testUnFreezeOfflineSettle() {
		TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> bizReq = new TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle>();
		
        TradePacketHead head = new TradePacketHead();
        head.setRequest_code("0001_001_002");
        head.setVersion("1.1");
        
        head.setPartner_id("10012426000150917");
        head.setCore_merchant_no("CC_C8785258588");
        head.setFund_pool_no("PN01000000000010876");
        
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        
        TradePacketReqBodyUnFreezeOfflineSettle body = new TradePacketReqBodyUnFreezeOfflineSettle();
        body.setTrade_no("00010011604061532416980000236201");
        body.setClear_channel("w123");
        body.setGmt_success_clear_channel("2015-01-02 14:23:15");
        body.setThird_trade_no("w11111");
        body.setActual_amount("0.01");
        body.setClear_channel_attr_1("clearChannelAttr_1");
        body.setClear_channel_attr_2("clearChannelAttr_2");
        body.setClear_channel_attr_3("clearChannelAttr_3");
        body.setClear_channel_attr_4("clearChannelAttr_4");
        body.setClear_channel_attr_5("clearChannelAttr_5");
        body.setClear_channel_attr_6("clearChannelAttr_6");
        
        body.setFro_bal_decr_field_1("frodecr1");
        body.setFro_bal_decr_field_2("frodecr2");
        body.setFro_bal_decr_field_3("frodecr3");
        body.setAvl_bal_incr_field_1("avlin1");
        body.setAvl_bal_incr_field_2("avlin2");
        body.setAvl_bal_incr_field_3("avlin3");
        body.setAvl_bal_decr_field_1("avldecr1");
        body.setAvl_bal_decr_field_2("avldecr2");
        body.setAvl_bal_decr_field_3("avldecr3");

		bizReq.setHead(head);
		bizReq.setBody(body);

		TradeResponse response = TradeClient.excute(bizReq);
		
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
	/**
	 * 0001_001_003：全额解冻
	 */
	@Test
	public void testUnFreezeAll() {
		TradeRequest<TradePacketReqBodyFullUnFreeze> bizReq = new TradeRequest<TradePacketReqBodyFullUnFreeze>();
		
		TradePacketHead head=new TradePacketHead();
		TradePacketReqBodyFullUnFreeze body=new TradePacketReqBodyFullUnFreeze();
		
		head.setRequest_code("0001_001_003");
		head.setVersion("1.1");
		head.setPartner_id("10012426000150917");//10038012689151119
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988
		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setTrade_no("00010011603181715414020000228000");
		
		body.setAvl_bal_incr_field_1("avl_incr1");
		body.setAvl_bal_incr_field_2("avl_incr2");
		body.setAvl_bal_incr_field_3("avl_incr3");
		body.setFro_bal_decr_field_1("for_decr1");
		body.setFro_bal_decr_field_2("for_decr2");
		body.setFro_bal_decr_field_3("for_decr3");

		bizReq.setHead(head);
		bizReq.setBody(body);

		TradeResponse response = TradeClient.excute(bizReq);
		
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
	/**
	 * 0001_002_001：线下付款退回
	 */
	@Test
	public void testRefundOfflineSettle() {
		TradeRequest<TradePacketReqBodyRefundOfflineSettle> bizReq = new TradeRequest<TradePacketReqBodyRefundOfflineSettle>();
		
        TradePacketHead head = new TradePacketHead();
        head.setRequest_code("0001_002_001");
        head.setVersion("1.1");
        
        head.setPartner_id("10012426000150917");
        head.setCore_merchant_no("CC_C8785258588");
        head.setFund_pool_no("PN01000000000010876");
        
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        
        TradePacketReqBodyRefundOfflineSettle body = new TradePacketReqBodyRefundOfflineSettle();
        body.setOut_trade_no("R123456789201603180151"); // 已在数据库
        body.setOut_trade_no_ext("R123456789201603180151"); // 已在数据库
        body.setOriginal_trade_no("00010011603181715414020000228000");
        body.setGmt_refund_clear_channel("2015-10-10 10:10:10");
        body.setClear_refund_amount("0.01");
        body.setThird_trade_no("123456");
        
        body.setMerchant_extend_field_1("扩展字段1");
        
        body.setClear_channel_attr_1("att1");
        body.setClear_channel_attr_2("att2");
        body.setClear_channel_attr_3("att3");
        body.setClear_channel_attr_4("att4");
        body.setClear_channel_attr_5("att5");
        body.setClear_channel_attr_6("att6");
        
        body.setAvl_bal_incr_field_1("avl_incr1");
        body.setAvl_bal_incr_field_2("avl_incr2");
        body.setAvl_bal_incr_field_3("avl_incr3");

		bizReq.setHead(head);
		bizReq.setBody(body);

		TradeResponse response = TradeClient.excute(bizReq);
		
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
	/**
	 * 0007_001_001：成员转账
	 */
	@Test
	public void testMemberTransfer() {
		TradeRequest<TradePacketReqBodyMerchantTransfer> bizReq = new TradeRequest<TradePacketReqBodyMerchantTransfer>();
		
        TradePacketHead head = new TradePacketHead();
        head.setRequest_code("0007_001_001");
        head.setVersion("1.0");
        
        head.setPartner_id("10012426000150917");
        head.setCore_merchant_no("CC_C8785258588");
        head.setFund_pool_no("PN01000000000010876");//PN01000000000032988 PN01000000000010876
        
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        
        TradePacketReqBodyMerchantTransfer body = new TradePacketReqBodyMerchantTransfer();
        body.setOut_trade_no("R123456789201603180151"); // 已在数据库
        body.setOut_trade_no_ext("R123456789201603180103"); // 已在数据库
        body.setPayment_account_no("CA21000000017026"); 
        body.setPayment_account_extend_field_1("支付宝");
        body.setPayment_account_extend_field_2("微信");
        body.setPayment_account_extend_field_3("银行卡");
        body.setReceive_account_no("CA21000000046047");
        body.setReceive_account_extend_field_1("支付宝收");
        body.setReceive_account_extend_field_2("微信收");
        body.setReceive_account_extend_field_3("银行卡收");
//        body.setTransfer_amount("0.18");
        body.setMerchant_extend_field_1("扩展字段1");

		bizReq.setHead(head);
		bizReq.setBody(body);
		body.setTransfer_amount("22222222222.22");
		TradeResponse response = TradeClient.excute(bizReq);
		
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
	@Test
	public void TestTransfer(){
		TradeRequest<QueryPage4TransferDetail> req = new TradeRequest<QueryPage4TransferDetail>();
    	QueryPage4TransferDetail body = new QueryPage4TransferDetail();
    	TradePacketHead head = new TradePacketHead();
    	req.setBody(body);
    	req.setHead(head);
    	
    	head.setPartner_id("10000002057141223");
    	head.setCore_merchant_no("CC_C8785258588");
    	head.setFund_pool_no("PN01000000000010876");
    	head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
    	head.setVersion("1.0");
    	head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
//    	head.setRequest_code("0007_001_999");
    	head.setRequest_code("0007_001_998");
    	
    	
//    	body.setPage(" ");
//    	body.setPage_size(" ");
    	
//        body.setGmt_freeze_success_datetime_start("2016-02-01 00:00:00");
//    	body.setPayment_account_no(" ");
    	body.setTransfer_amount_start("22222222.22");
    	body.setTransfer_amount_end("22222222.23");
    	TradeResponse response = TradeClient.excute(req);
    	if (null != response) {
			System.err.println(response.marshal());
		}
	}
	@Test
	public void TestTransfer2(){
		TradeRequest<QueryPage4TransferDetail> req = new TradeRequest<QueryPage4TransferDetail>();
		QueryPage4TransferDetail body = new QueryPage4TransferDetail();
		TradePacketHead head = new TradePacketHead();
		req.setBody(body);
		req.setHead(head);
		
		head.setPartner_id("10012426000150917");
		head.setCore_merchant_no("0a");
		head.setFund_pool_no("PN01000000000010876");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
		head.setVersion("1.0");
		head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
//    	head.setRequest_code("0007_001_999");
		head.setRequest_code("0007_001_998");
		
		
//    	body.setPage(" ");
//    	body.setPage_size(" ");
		
//        body.setGmt_freeze_success_datetime_start("2016-02-01 00:00:00");
//    	body.setPayment_account_no(" ");
		body.setTrade_no("LY21512151445596834302");
		body.setGmt_created_start("2015-12-24 12:14:41");
		body.setGmt_created_end("2015-12-24 12:14:41");
		body.setGmt_latest_modified_start("2015-12-24 12:14:41");
		body.setGmt_latest_modified_end("2015-12-24 12:14:41");
		body.setTransfer_amount_start("11111111111110.01");
		body.setTransfer_amount_end("22222222222220.18");
		TradeResponse response = TradeClient.excute(req);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
}
