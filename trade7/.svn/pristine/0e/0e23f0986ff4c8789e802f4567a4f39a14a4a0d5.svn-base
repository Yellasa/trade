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
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqMerchantFreeze;

@ContextConfiguration(
        locations = {
                "classpath:config/spring/controller-context.xml",
                "classpath:config/spring/applicationContext-*.xml"
        })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = false)

public class TradeMerchantFreezeTest extends AbstractJUnit4SpringContextTests {

	@Resource
    private TradeBusController tradeBusController;

    @Test
    public void initialContext() throws Exception {
        Assert.assertNotNull(tradeBusController);
    }

	@Test
	public void testTradeMerchantFreezeProcess() throws Exception {
        Assert.assertNotNull(tradeBusController);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        TradePacketReqMerchantFreeze bizReq = new TradePacketReqMerchantFreeze();
        TradePacketHead head = new TradePacketHead();
        TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
        
        head.setRequest_code("0001_001_001");
        head.setVersion("1");
        head.setPartner_id("10012426000150917");
        head.setCore_merchant_no("CC_C8785258588");
        head.setFund_pool_no("PN01000000000010876");
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        
//        body.setOut_trade_no_ext("12345678920151226011");
        body.setOut_trade_no("1234567892015122503");
        body.setPayment_account_no("CA21000000017026");
        body.setFreeze_amount("1");
        body.setMerchant_extend_field_1("扩展字段1");

        bizReq.setBusHead(head);
        bizReq.setBody(body);
        
        request.setMethod("POST");
        request.addParameter("para", bizReq.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
    }

}


