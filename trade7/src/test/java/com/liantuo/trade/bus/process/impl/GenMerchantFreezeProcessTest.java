package com.liantuo.trade.bus.process.impl;

import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1_1.GenMerchantFreezeProcess;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateSingleTxNoPaymentTemp;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({ 
    WebContextTestExecutionListener.class, 
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class })
public class GenMerchantFreezeProcessTest {
	@Resource(name = "0001_001_001:1.1")
	private GenMerchantFreezeProcess process;
	@Autowired
	private ATradeCreateSingleTxNoPaymentTemp temp;
	@Test
	public void testExec(){
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
		body.setOut_trade_no("outTradeNo20160224233514491223");
		body.setFreeze_amount("21279627.80");
		body.setPayment_account_no("CA12050317300000");
		body.setOut_trade_no_ext("df201635972353959002741");
		
		request.setBody(body);
		request.setHead(head);
		try {
			temp.setProcess(process);
			temp.setIp("127.0.0.1");
			temp.setRequestXML("");
			temp.execute(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
