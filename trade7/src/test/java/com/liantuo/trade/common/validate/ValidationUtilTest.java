package com.liantuo.trade.common.validate;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyInnerPayment;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ValidationUtilTest {
	@Test
	public void testValidateObject(){
		TradeRequest<TradePacketReqBodyMerchantFreeze> request = new TradeRequest<TradePacketReqBodyMerchantFreeze>();
		
		TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
		TradePacketHead head = new TradePacketHead();
		head.setAuth_code("123123123123");
		head.setPartner_id("10000002057141223");
		head.setCore_merchant_no("SXSL");
		head.setFund_pool_no("PN01000000000000824");
		head.setRequest_time("2016-02-24 19:21:55");
		head.setRequest_code("0001_001_001");
		head.setVersion("");
		head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
		body.setOut_trade_no("outTradeNo20160224233514491224");
		body.setFreeze_amount("21279627.80");
		body.setPayment_account_no("CA12050317300000");
		body.setOut_trade_no_ext("df20163589233959992741");
		
		request.setBody(body);
		request.setHead(head);
//		String message = ValidationUtil.validateObject(request, "");
//		assertThat(message).isEmpty();
		String message = ValidationUtil.validateObject(request.getHead(), "request_code,version",Required.class);
		System.out.println(message);
		assertThat(message).isNotEmpty();
	}

	@Test
	public void testValidateObject2(){
		TradePacketReqBodyInnerPayment payment = new TradePacketReqBodyInnerPayment();
		payment.setPay_type("3");
		payment.setPay_account_no("");
		payment.setPay_account_no(" ");
		payment.setPay_account_no("  ");
		payment.setPay_account_no(null);
		System.err.println(ValidationUtil.validateObject(payment, "*", WeakRequired.class));
	}
}
