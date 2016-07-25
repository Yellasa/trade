package com.liantuo.trade.unittest.jy0001;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyModTradePaymentInfo;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalPayment;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

public class TradeClient0001001997 {
	@Test
	public void test1() throws Exception{
		TradeRequest<TradePacketReqBodyModTradePaymentInfo> bizReq = new TradeRequest<TradePacketReqBodyModTradePaymentInfo>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyModTradePaymentInfo body = new TradePacketReqBodyModTradePaymentInfo();
		head.setRequest_code("0001_001_997");
		head.setVersion("1.0");

		head.setPartner_id("10012426000150917");//10038012689151119 10012426000150917
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098 CC_C8785258588
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988 PN01000000000010876
		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

//		body.setTrade_no("00010011606041043262800000243008");//
		body.setOut_trade_no_ext("1020160616233510242582");//
		body.setMerchant_extend_field_1("11");
		body.setMerchant_extend_field_2("22");
		body.setMerchant_extend_field_3("33");
		body.setMerchant_extend_field_4("");
		body.setMerchant_extend_field_5("55");
		body.setMerchant_extend_field_6("abc_123!@#abc_123!@#abc_123!@#abc_123!@#abc_123!@#abc_123!@#1234");
		body.setMerchant_extend_field_7("7");
		body.setMerchant_extend_field_8("8");
		body.setMerchant_extend_field_9("");
//		body.setMerchant_extend_field_10("10");		
		
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
}
