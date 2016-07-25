package com.liantuo.trade.web.controller.local;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.body.simple_fund_handle.TradePacketReqBodyAdjustAccount;
import com.liantuo.trade.client.trade.packet.body.simple_fund_handle.TradePacketReqBodyAdjustLedgerIn;
import com.liantuo.trade.client.trade.packet.body.simple_fund_handle.TradePacketReqBodyAdjustLedgerOut;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

/**
 * @ClassName:     TestTradeDemoV100003.java
 * @Description:   TODO
 * Company:联拓金融信息服务有限公司
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-4-5 下午4:17:45 
 */
public class TestTradeDemoV100003 {

	/**
	 * V1.0
	 * 0003_001_001：调账
	 * @throws Exception
	 */
	@Test
	public void testAdjustAccount() throws Exception{
		TradeRequest<TradePacketReqBodyAdjustAccount> bizReq = new TradeRequest<TradePacketReqBodyAdjustAccount>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyAdjustAccount body = new TradePacketReqBodyAdjustAccount();

		head.setRequest_code("0003_001_001");
		head.setVersion("1.0");

		head.setPartner_id("10012426000150917");//10038012689151119 10012426000150917
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098 CC_C8785258588
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988 PN01000000000010876
		body.setMerchant_extend_field_1("");
		body.setMerchant_extend_field_2("扩展参数2");

		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setOut_trade_no_ext("123456789201604080163");
		body.setOut_trade_no("12345678920160408056");
		
		body.setPayment_account_no("CA21000000017026");//CA21000000029960 CA21000000017026/CA21000000046047
		body.setPayment_account_extend_field_1("pay_备注1");
		body.setPayment_account_extend_field_2("pay_备注2");
		body.setPayment_account_extend_field_3("");
		body.setReceive_account_no("CA21000000046047");
		body.setReceive_account_extend_field_1("rev_备注1");
		body.setReceive_account_extend_field_2("rev_备注2");
//		body.setReceive_account_extend_field_3("");
		
		body.setAdjust_amount("0.01");

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
	 * 0003_001_002 V1.0 CA台账入金
	 * @throws Exception
	 */
	@Test
	public void testAdjustLedgerIn() throws Exception{
		TradeRequest<TradePacketReqBodyAdjustLedgerIn> bizReq = new TradeRequest<TradePacketReqBodyAdjustLedgerIn>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyAdjustLedgerIn body = new TradePacketReqBodyAdjustLedgerIn();

		head.setRequest_code("0003_001_002");
		head.setVersion("1.0");

		head.setPartner_id("10012426000150917");//10038012689151119 10012426000150917
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098 CC_C8785258588
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988 PN01000000000010876
		body.setMerchant_extend_field_1("");
		body.setMerchant_extend_field_2("扩展参数2");

		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setOut_trade_no_ext("123456789201604060122");
		body.setOut_trade_no("12345678920160406022");

		body.setReceive_account_no("CA21000000046047");
		body.setReceive_account_extend_field_1("收到CA账务备注1");
		body.setReceive_account_extend_field_2("收到CA账务备注2");
//		body.setReceive_account_extend_field_3("");
		
		body.setGmt_success_clear_channel(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()));
		body.setClear_channel("311003");
		body.setThird_trade_no("123546798");
		
		body.setClear_channel_attr_1("收付款属性1");
		body.setLedger_extend_field_1("台账备注1");
		body.setLedger_merchant_extend_field_3("台账客户保留字段3");
		
		body.setAdjust_amount("0.01");

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
	 * 0003_001_003 V1.0 CA台账出金
	 * @throws Exception
	 */
	@Test
	public void testAdjustLedgerOut() throws Exception{
		TradeRequest<TradePacketReqBodyAdjustLedgerOut> bizReq = new TradeRequest<TradePacketReqBodyAdjustLedgerOut>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyAdjustLedgerOut body = new TradePacketReqBodyAdjustLedgerOut();

		head.setRequest_code("0003_001_003");
		head.setVersion("1.0");

		head.setPartner_id("10012426000150917");//10038012689151119 10012426000150917
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098 CC_C8785258588
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988 PN01000000000010876
		body.setMerchant_extend_field_1("");
		body.setMerchant_extend_field_2("扩展参数2");

		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setOut_trade_no_ext("123456789201604080122");
		body.setOut_trade_no("12345678920160408022");

		body.setPayment_account_no("CA21000000017026");
		body.setPayment_account_extend_field_1("付出CA账务备注1");
//		body.setPayment_account_extend_field_2("付出CA账务备注2");
		body.setPayment_account_extend_field_3("付出CA账务备注3");
		
		body.setGmt_success_clear_channel(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()));
		body.setClear_channel("311003");
		body.setThird_trade_no("123546798");
		
		body.setClear_channel_attr_1("收付款属性1");
		body.setLedger_extend_field_1("台账备注1");
		body.setLedger_merchant_extend_field_1("台账客户保留字段1");
		
		body.setAdjust_amount("0.01");

		bizReq.setHead(head);
		bizReq.setBody(body);

//		String requestXML = bizReq.marshal();
//		System.out.println("requestXML=="+requestXML);
		TradeResponse response = TradeClient.excute(bizReq);

		if (null != response) {
			System.err.println(response.marshal());
		}
	}
}
