package com.liantuo.trade.web.controller.local;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyUnFreezeOfflineSettle;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqUnFreezeOfflineSettle;

@ContextConfiguration(
        locations = {
                "classpath:config/spring/controller-context.xml",
                "classpath:config/spring/applicationContext-*.xml"
        })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = false)

public class TradeUnfreezeOfflineSettleTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Resource
    private TradeBusController tradeBusController;

    @Test
    public void initialContext() throws Exception {
        Assert.assertNotNull(tradeBusController);
    }

	@Test
	public void testTradeUnfreezeOfflineSettleProcess() throws Exception {
        Assert.assertNotNull(tradeBusController);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        TradePacketReqUnFreezeOfflineSettle bizReq = new TradePacketReqUnFreezeOfflineSettle();
        TradePacketHead head = new TradePacketHead();
        TradePacketReqBodyUnFreezeOfflineSettle body = new TradePacketReqBodyUnFreezeOfflineSettle();
        
        head.setRequest_code("0001_001_002");
        head.setVersion("1");
        head.setPartner_id("10012426000150917");
        head.setCore_merchant_no("CC_C8785258588");
        head.setFund_pool_no("PN01000000000010876");
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        
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

        bizReq.setBusHead(head);
        bizReq.setBody(body);
        
        request.setMethod("POST");
        request.addParameter("para", bizReq.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
    }

}


