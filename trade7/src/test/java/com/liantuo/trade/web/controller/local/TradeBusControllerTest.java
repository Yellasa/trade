package com.liantuo.trade.web.controller.local;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqMerchantFreeze;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.*;

@ContextConfiguration(
        locations = {
                "classpath:config/spring/controller-context.xml",
                "classpath:config/spring/applicationContext-*.xml"
//                "classpath:config/biz/trade-*.xml"
        })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = false)
public class TradeBusControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    private TradeBusController tradeBusController;
    @Test
    public void testTradeTemplateInController() throws Exception {
        Assert.assertNotNull(tradeBusController);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        TradePacketReqMerchantFreeze bizReq = new TradePacketReqMerchantFreeze();
        TradePacketHead head = new TradePacketHead();
        TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
        bizReq.setBusHead(head);
        bizReq.setBody(body);

        head.setPartner_id("12345678901234567");
        head.setRequest_code("0001_001_001");
        head.setCore_merchant_no("CC_1234567890");
        head.setFund_pool_no("12345678901234567890123456789012");
        head.setVersion("1");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        request.setMethod("POST");
        request.addParameter("para", bizReq.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
    }

    /**
     * 不能读取交易报文
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testEmptyXml() throws Exception {
        Assert.assertNotNull(tradeBusController);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setMethod("POST");
//        request.addParameter("para", " ");
        request.addParameter("para", "");
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
    }

    /**
     * 交易报文解析失败，请按交易报文规范提交请求报文
     *
     * @throws Exception
     */
    @Test
    @Ignore
    public void testErrorFormatXml() throws Exception {
        Assert.assertNotNull(tradeBusController);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setMethod("POST");
        request.addParameter("para", "{\"hostAddress\":\"http://192.168.19.35:8080\",\"serviceId\":null,\"partnerid\":null,\"tradeNo\":null,\"notifyUrl\":null,\"returnUrl\":null,\"sign\":null,\"signType\":null,\"inputCharset\":\"utf-8\",\"channelType\":null,\"ip\":null,\"systemId\":null}{\"host\":\"http://192.168.19.35:8080\",\"requester\":\"FRONT\",\"requestTime\":\"2015-12-15 21:16:00\",\"version\":\"1.0\",\"extAttr\":null,\"signType\":\"MD5\",\"inputCharset\":\"UTF-8\",\"sign\":\"MD5\",\"partnerId\":\"10000002048131212\",\"orderNo\":\"LYTX20151110000002672644\",\"status\":null}");
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
    }

    /**
     * 协议参数校验失败
     *
     * @throws Exception
     */
    @Test
//    @Ignore
    public void testTradeProtocolRequired() throws Exception {
        Assert.assertNotNull(tradeBusController);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        TradePacketReqMerchantFreeze bizReq = new TradePacketReqMerchantFreeze();
        TradePacketHead head = new TradePacketHead();
        TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
        bizReq.setBusHead(head);
        bizReq.setBody(body);

        head.setRequest_code("0001_001_001");
        request.setMethod("POST");
        request.addParameter("para", bizReq.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
    }


    @Test
    @Ignore
    public void testTradeProtocolFormatPartnerId() throws Exception {
        Assert.assertNotNull(tradeBusController);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        TradePacketReqMerchantFreeze bizReq = new TradePacketReqMerchantFreeze();
        TradePacketHead head = new TradePacketHead();
        TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
        bizReq.setBusHead(head);
        bizReq.setBody(body);

        head.setPartner_id("1234567890");
        head.setRequest_code("0001_001_001");
        head.setCore_merchant_no("1234567890");
        head.setFund_pool_no("1");
        head.setVersion("1.000");
        head.setAuth_code("123456");
        head.setBusi_code("123456");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSS").format(Calendar.getInstance().getTime()));
        head.setSign("adsfsadfasdfasdfasdfasdf");
        request.setMethod("POST");
        request.addParameter("para", bizReq.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
    }

    @Test
    @Ignore
    public void testTradeLogSave() throws Exception {
        Assert.assertNotNull(tradeBusController);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        TradePacketReqMerchantFreeze bizReq = new TradePacketReqMerchantFreeze();
        TradePacketHead head = new TradePacketHead();
        TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
        bizReq.setBusHead(head);
        bizReq.setBody(body);

        head.setPartner_id("12345678901234567");
        head.setRequest_code("0001_001_001");
        head.setCore_merchant_no("CC_1234567890");
        head.setFund_pool_no("12345678901234567890123456789012");
        head.setVersion("1.0");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        request.setMethod("POST");
        request.addParameter("para", bizReq.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
    }

    @Test
    @Ignore
    public void testTradeBuildProcess() throws Exception {
        Assert.assertNotNull(tradeBusController);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        TradePacketReqMerchantFreeze bizReq = new TradePacketReqMerchantFreeze();
        TradePacketHead head = new TradePacketHead();
        TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
        bizReq.setBusHead(head);
        bizReq.setBody(body);

        head.setPartner_id("12345678901234567");
        head.setRequest_code("0001_001_001");
        head.setCore_merchant_no("CC_1234567890");
        head.setFund_pool_no("12345678901234567890123456789012");
        head.setVersion("1");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        request.setMethod("POST");
        request.addParameter("para", bizReq.marshal());
        tradeBusController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
    }


}