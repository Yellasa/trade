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

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqRefundOfflineSettle;


/**
 * 
 * @作者 Jimmy
 * @日期 2015年12月22日 下午6:02:37
 * @最后修改人
 * @修改时间
 * @复审人 
 */
@ContextConfiguration(
        locations = {
                "classpath:config/spring/controller-context.xml",
                "classpath:config/spring/applicationContext-*.xml"
        })
//@TransactionConfiguration(defaultRollback = false)
public class RefundTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private TradeBusController tradeBusController;
    
    TradePacketReqRefundOfflineSettle req = null;
    
    @Before
    public void before(){
        req = new TradePacketReqRefundOfflineSettle();
        
        TradePacketHead head = new TradePacketHead();
        head.setPartner_id("10000002048131212");
        head.setRequest_code("0001_002_001");
        head.setCore_merchant_no("CC_C8785258588");
        
        head.setFund_pool_no("PN01000000000010876");
        head.setVersion("1.0");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        req.setBusHead(head);
        
        TradePacketReqBodyRefundOfflineSettle body = new TradePacketReqBodyRefundOfflineSettle();
        body.setOut_trade_no_ext("test000000000000001"); // 已在数据库
        body.setOriginal_trade_no("000000000000000700201512171928481");
        body.setGmt_refund_clear_channel("2015-10-10 10:10:10");
        body.setClear_refund_amount("1.2");
        body.setThird_trade_no("thirdTradeNo");
        
        body.setOut_trade_no("//TODO可空");
        body.setClear_channel_attr_1("att1");
        body.setClear_channel_attr_2("att2");
        body.setClear_channel_attr_3("att3");
        body.setClear_channel_attr_4("att4");
        body.setClear_channel_attr_5("att5");
        body.setClear_channel_attr_6("att6");
        
        req.setBody(body);
    }
    
    @Test
    public void testRefund() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        req.getBody().setOut_trade_no_ext("test000000000000002");
        request.addParameter("para", req.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
        Assert.assertTrue(response.getContentAsString().contains("<is_success>S</is_success>"));
    }
    
    @Test
    public void testRefundDuplicate() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        req.getBody().setOut_trade_no_ext("test000000000000003");
        request.addParameter("para", req.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
        Assert.assertTrue(response.getContentAsString().contains("<is_success>S</is_success>"));
        
        // 交易重复
        response = new MockHttpServletResponse();
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
        Assert.assertTrue(response.getContentAsString().contains("<err_code>JY000100200</err_code>"));
    }
    
    @Test
    public void testOriginal_trade_no() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        // 原交易不存在
        req.getBody().setOut_trade_no_ext("test000000000000004");
        req.getBody().setOriginal_trade_no("000000000000000700201512171920000");
        request.addParameter("para", req.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
        Assert.assertTrue(response.getContentAsString().contains("<err_code>JY000100300</err_code>"));
    }
    
    @Test
    public void testOriginal_trade_status_error() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        // 原交易状态不正确
        req.getBody().setOut_trade_no_ext("test000000000000004");
        req.getBody().setOriginal_trade_no("000000000000000800201512172023795");
        request.addParameter("para", req.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
        Assert.assertTrue(response.getContentAsString().contains("<err_code>JY000100400</err_code>"));
    }
}
