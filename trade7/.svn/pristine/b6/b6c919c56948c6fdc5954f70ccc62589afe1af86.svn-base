package com.liantuo.trade.bus.process.impl.single_recharge.v1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateSingleTxHasPaymentTemp;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodyRechargeOnline;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({ 
    WebContextTestExecutionListener.class, 
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class })
public class Recharge004 {

	@Resource(name = "0005_001_004:1.0")
	private SingleRechargeOnlineAlipayPwdBatchPayProcess process;
	@Autowired
	private ATradeCreateSingleTxHasPaymentTemp temp;
	@Test
	public void testExec(){
		new ClassPathXmlApplicationContext();
		
		TradeRequest<TradePacketReqBodyRechargeOnline> request = new TradeRequest<TradePacketReqBodyRechargeOnline>();
		
		TradePacketReqBodyRechargeOnline body = new TradePacketReqBodyRechargeOnline();
		TradePacketHead head = new TradePacketHead();
		head.setPartner_id("10012426000150917");
		head.setCore_merchant_no("CC_C8785258588");
		head.setFund_pool_no("PN01000000000010876");
		head.setRequest_time("2016-02-24 19:21:55");
		head.setRequest_code("0005_001_004");
		head.setVersion("1.0");
		
		head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
		body.setOut_trade_no_ext("df20163589233959992844");
		body.setOut_trade_no("df20163589233959992844");
		body.setPay_remark("ces");
		body.setPay_date("20160506");
		body.setNotify_url("www.baidu.com");
		body.setRecharge_account_no("CA21000000017026");
		body.setTransaction_id("000000000000104");
		body.setAccount_name("合肥联拓金融信息服务有限公司");
		body.setEmail("ltfzfb03@126.com");
		body.setReceive_email("ltftest02_zfb@126.com");
		body.setReceive_name("合肥联拓金融信息服务有限公司");
		body.setRecharge_amount("0.01");
		body.setPay_amount("0.01");
		
		request.setBody(body);
		request.setHead(head);
		
		try {
			temp.setProcess(process);
			temp.setIp("127.0.0.1");
			temp.setRequestXML("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><tradeRequest><body/><head><core_merchant_no>CC_C8785258588</core_merchant_no><fund_pool_no>PN01000000000010876</fund_pool_no><partner_id>10012426000150917</partner_id><request_code>0005_001_004</request_code><request_time>2016-02-24 19:21:55</request_time><sign>02E039A8FB4D7FF322CD3C7E7103E184</sign><version>1.0</version></head></tradeRequest>");
			temp.buildRequest("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><tradeRequest><body/><head><core_merchant_no>CC_C8785258588</core_merchant_no><fund_pool_no>PN01000000000010876</fund_pool_no><partner_id>10012426000150917</partner_id><request_code>0005_001_004</request_code><request_time>2016-02-24 19:21:55</request_time><sign>02E039A8FB4D7FF322CD3C7E7103E184</sign><version>1.0</version></head></tradeRequest>");
			
			temp.execute(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
