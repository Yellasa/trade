package com.liantuo.trade.unittest.jy0005;

import org.junit.Before;
import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodyRechargeOnline;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//        "classpath:config/spring/applicationContext-*.xml"
//})
//@TestExecutionListeners({ 
//    WebContextTestExecutionListener.class, 
//    DependencyInjectionTestExecutionListener.class,
//    DirtiesContextTestExecutionListener.class })
public class Recharge004 {

//	@Resource(name = "0005_001_004:1.0")
//	private SingleRechargeOnlineAlipayPwdBatchPayProcess process;
//	@Autowired
//	private ATradeHasPaymentOnlineCreateTemp temp;
	
    private	TradeRequest<TradePacketReqBodyRechargeOnline> request;
	
	@Before
	public void prepareParam(){
		 
		request = new TradeRequest<TradePacketReqBodyRechargeOnline>();
		TradePacketReqBodyRechargeOnline body = new TradePacketReqBodyRechargeOnline();
		TradePacketHead head = new TradePacketHead();
		head.setPartner_id("10012426000150917");
		head.setCore_merchant_no("CC_C3878185775");
		head.setFund_pool_no("PN01000000000010429");
		head.setRequest_time("2016-05-17 19:21:55");
		head.setRequest_code("0005_001_004");
		head.setVersion("1.0");
		head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
		
//		body.setFee_amount("2");
//		body.setFee_way("2");
		body.setOut_trade_no_ext("df20163589233959994898");
		body.setOut_trade_no("df20163589233959992847");
		body.setPay_remark("ces");
		body.setPay_date("20160622");
		body.setNotify_url("www.baidu.com");
		body.setRecharge_account_no("CA21000000060621");
		body.setTransaction_id("000000000000105");
		body.setAccount_name("合肥联拓金融信息服务有限公司");
		body.setEmail("ltfzfb03@126.com");
		body.setReceive_email("ltftest02_zfb@126.com");
		body.setReceive_name("合肥联拓金融信息服务有限公司");
		body.setRecharge_amount("0.01");
		body.setPay_amount("0.01");
//		body.setSupply_amount("0.04");
//		body.setFee_receive_account_no("CA21000000060623");
//		body.setSupply_profit_loss_attr_1("95645643F_S58886435643ADSFGDSFGSD32453245654656564374375qwd####!#$$___*()_)*_^^####$$$$$$$$$$$$$$$$$$$RWQERWSDF14234ABcd01345789a");
		request.setBody(body);
		request.setHead(head);
//		temp.setProcess(process);
//		temp.setIp("127.0.0.1");
//		temp.setRequestXML("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><tradeRequest><body/><head><core_merchant_no>CC_C8785258588</core_merchant_no><fund_pool_no>PN01000000000010876</fund_pool_no><partner_id>10012426000150917</partner_id><request_code>0005_001_004</request_code><request_time>2016-02-24 19:21:55</request_time><sign>02E039A8FB4D7FF322CD3C7E7103E184</sign><version>1.0</version></head></tradeRequest>");
	}
	
	
	
	@Test
	public void testExec(){
		try {
			TradeResponse response = TradeClient.excute(request);
	        System.err.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
