package com.liantuo.trade.client.trade.packet;


import javax.xml.bind.JAXBException;

import org.springframework.web.client.RestTemplate;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

public class RestTemplateTest {
	public static void main(String[] args) throws JAXBException{

		TradeRequest<TradePacketReqBodyMerchantFreeze> request = new TradeRequest<TradePacketReqBodyMerchantFreeze>();
		
		TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
		TradePacketHead head = new TradePacketHead();
		head.setAuth_code("123123123123");
		head.setPartner_id("10000002057141223");
		head.setCore_merchant_no("SXSL");
		head.setFund_pool_no("PN01000000000000824");
		head.setRequest_time("2016-02-24 19:21:55");
		head.setRequest_code("0001_001_001");
		head.setVersion("1.1");
		head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
		body.setOut_trade_no("outTradeNo20160224233514491224");
		body.setFreeze_amount("0.10");
		body.setPayment_account_no("CA12050317300000");
		body.setOut_trade_no_ext("df20160302133959992741");
		
		request.setBody(body);
		request.setHead(head);
		RestTemplate restTemplate = new RestTemplate();
		String requestXML = request.marshal();
//		System.out.println("requestXML=="+requestXML);
		TradeResponse response = TradeClient.excute(request);
		
//		String response = restTemplate.postForObject("http://localhost:5555/trade/api/service/{request_code}/{version}.in", requestXML, String.class, head.getRequest_code(),head.getVersion());
		System.out.println(response);
	}
}
