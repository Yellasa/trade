package com.liantuo.trade.web.controller.local;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawDeductRefund;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawDeductRefund;


@ContextConfiguration(
        locations = {
                "classpath:config/spring/controller-context.xml",
                "classpath:config/spring/applicationContext-*.xml"
        })
//@TransactionConfiguration(defaultRollback = false)
public class WithdrawDeductRefundTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private TradeBusController tradeBusController;
    
    TradePacketReqSingleWithdrawDeductRefund req = null;
    
    @Before
    public void before(){
        req = new TradePacketReqSingleWithdrawDeductRefund();
        
        TradePacketHead head = new TradePacketHead();
        head.setPartner_id("10000002048131212");
        head.setRequest_code("0002_001_005");
        head.setCore_merchant_no("CC_C8785258588");
        
        head.setFund_pool_no("PN01000000000010876");
        head.setVersion("1.0");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        req.setBusHead(head);
        
        TradePacketReqBodySingleWithdrawDeductRefund body = new TradePacketReqBodySingleWithdrawDeductRefund();
        body.setTrade_no("20160125140506528000000000001400");
        
        req.setBody(body);
    }
    
    @Test
    public void testRefund() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        request.addParameter("para", req.marshal());
        
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
        Assert.assertTrue(response.getContentAsString().contains("<result_code>S</result_code>"));
    }
    
}
