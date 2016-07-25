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

import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawDeduct;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawDeduct;

@ContextConfiguration(
        locations = {
                "classpath:config/spring/controller-context.xml",
                "classpath:config/spring/applicationContext-*.xml"
        })
public class WithdrawDeductTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private TradeBusController tradeBusController;
    
    TradePacketReqSingleWithdrawDeduct req = null;
    
    @Before
    public void before(){
        req = new TradePacketReqSingleWithdrawDeduct();
        
        TradePacketHead head = new TradePacketHead();
        head.setPartner_id("10000002048131212");
        head.setRequest_code("0002_001_001");
        head.setCore_merchant_no("CC_C8785258588");
        
        head.setFund_pool_no("PN01000000000010876");
        head.setVersion("1.0");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        req.setBusHead(head);
        
        TradePacketReqBodySingleWithdrawDeduct body = new TradePacketReqBodySingleWithdrawDeduct();
        body.setOut_trade_no_ext(System.currentTimeMillis()+"-"); // 已在数据库
        body.setOut_trade_no(body.getOut_trade_no_ext());
        body.setWithdraw_account_no("CA21000000017026");
        body.setWithdraw_amount("1.2");
        
        body.setMerchant_extend_field_1("mef1");
        body.setMerchant_extend_field_2("mef2");
        body.setMerchant_extend_field_3("mef3");
        body.setMerchant_extend_field_4("mef4");
        body.setMerchant_extend_field_5("mef5");
        
        body.setReserved_fields1("rf1");
        body.setReserved_fields2("rf2");
        body.setReserved_fields3("rf3");
        
        req.setBody(body);
    }
    
    @Test
    public void testDeduct() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        request.addParameter("para", req.marshal());
        
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
        Assert.assertTrue(response.getContentAsString().contains("<result_code>S</result_code>"));
    }
    
}
