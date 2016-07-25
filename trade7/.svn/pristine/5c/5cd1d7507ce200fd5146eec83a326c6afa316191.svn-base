package com.liantuo.trade.bus.process.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1_1.ModUnfreezeOfflineSettleProcess;
import com.liantuo.trade.bus.template.impl.v1_1.mod.ATradeModSingleTxNoPaymentTemp;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyUnFreezeOfflineSettle;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({ 
    WebContextTestExecutionListener.class, 
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class })
public class TradeUnfreezeOfflineSettleTest {

    @Resource(name = "0001_001_002:1.1")
    ModUnfreezeOfflineSettleProcess process;
    @Autowired
	private ATradeModSingleTxNoPaymentTemp temp;
    TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> request;
    
    @Before
    public void before() throws Exception {
        Assert.assertNotNull(process);
        
        request = new TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle>();
        
        TradePacketHead head = new TradePacketHead();
        head.setRequest_code("0001_001_002");
        head.setVersion("1.1");
        head.setPartner_id("10012426000150917");
        head.setCore_merchant_no("CC_C8785258588");
        head.setFund_pool_no("PN01000000000010876");
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        
        TradePacketReqBodyUnFreezeOfflineSettle body = new TradePacketReqBodyUnFreezeOfflineSettle();
        body.setTrade_no("20151225134222911000000000000900");
        body.setClear_channel("w123");
        body.setGmt_success_clear_channel("2015-01-02 14:23:15");
        body.setThird_trade_no("w11111");
        body.setActual_amount("10");
        body.setClear_channel_attr_1("clearChannelAttr_1");
        body.setClear_channel_attr_2("clearChannelAttr_2");
        body.setClear_channel_attr_3("clearChannelAttr_3");
        body.setClear_channel_attr_4("clearChannelAttr_4");
        body.setClear_channel_attr_5("clearChannelAttr_5");
        body.setClear_channel_attr_6("clearChannelAttr_6");

        request.setHead(head);
        request.setBody(body);
        
        temp.setIp("127.0.0.2");
        temp.setProcess(process);
        temp.buildRequest(request.marshal());
    }

    @Test
    public void testFormart() throws Exception {
        request.getBody().setTrade_no("2016--");
        TradeResponse rsp = temp.execute(request);
        System.out.println(rsp.getBody().getErr_code() + "：" + rsp.getBody().getErr_code_des());
        Assert.assertEquals("JY00010010021100100", rsp.getBody().getErr_code());
    }
    
	@Test
	public void testOriginalTrade() throws Exception {
        request.getBody().setTrade_no("111-0105200717578000000000004076");
        TradeResponse rsp = temp.execute(request);
        System.out.println(rsp.getBody().getErr_code() + "：" + rsp.getBody().getErr_code_des());
        Assert.assertEquals("JY00010010021100300", rsp.getBody().getErr_code());
    }

	@Test
    public void testOriginalTradeStatus() throws Exception {
        request.getBody().setTrade_no("20160105200717578000000000004076");
        TradeResponse rsp = temp.execute(request);
        System.out.println(rsp.getBody().getErr_code() + "：" + rsp.getBody().getErr_code_des());
        Assert.assertEquals("JY00010010021100400", rsp.getBody().getErr_code());
    }
	
	@Test
	public void testTradeAmount()  throws Exception {
	    request.getBody().setTrade_no("20151224181443655000000000000401");
        TradeResponse rsp = temp.execute(request);
        System.out.println(rsp.getBody().getErr_code() + "：" + rsp.getBody().getErr_code_des());
        Assert.assertEquals("JY00010010021100500", rsp.getBody().getErr_code());
	}
	
	@Test
    public void testTrade()  throws Exception {
        request.getBody().setTrade_no("20151223134506825000000000002300");
        request.getBody().setActual_amount("0.1");
        TradeResponse rsp = temp.execute(request);
        System.out.println(rsp.getBody().getErr_code() + "：" + rsp.getBody().getErr_code_des());
        Assert.assertEquals("S", rsp.getBody().getIs_success());
    }
	
}


