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

import com.liantuo.trade.client.trade.packet.body.withdraw.WithdrawNotifyReqBody;
import com.liantuo.trade.client.trade.packet.head.NotifyPacketHead;
import com.liantuo.trade.client.trade.packet.req.withdraw.WithdrawNotifyReqPacket;

@ContextConfiguration(
        locations = {
                "classpath:config/spring/controller-context.xml",
                "classpath:config/spring/applicationContext-*.xml"
        })
public class WithdrawNotifyTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Resource
    private TradeNotifyController tradeNotifyController;
    
    private WithdrawNotifyReqPacket req = null;
    
    @Before
    public void before(){
        req = new WithdrawNotifyReqPacket();
        
        NotifyPacketHead head = new NotifyPacketHead();
        head.setPay_channel("1");
        head.setRequest_time(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()));
        head.setRequester("1");
        head.setTrade_type("36");
        head.setTransaction_id("136385");
        req.setBusHead(head);
        
        WithdrawNotifyReqBody body = new WithdrawNotifyReqBody();
        body.setHft_trade_no("hft01120160114104817254541221451");
        body.setIsBalance("N");
        body.setIsBank("N");
        body.setIsCredit("N");
        body.setIsCreditCard("N");
        body.setIsMotoPay("N");
        body.setOut_batch_no("102016011424254541221451");
        body.setPartnerId("2088021460214385");
        body.setPay_account("zfbjk@liantuobank.com");
        body.setPay_info("001^ltftest02_zfb@126.com^合肥联拓金融信息服务有限公司^0.01^S^^20160114538429372^20160114104817|");
        body.setPay_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime()));
        body.setReceive_account("ltftest02_zfb@126.com");
        body.setRet_code("0");
        body.setThird_pay_no("102016011424254541221451");
        
        req.setBody(body);
    }
    
    @Test
    public void testNotify() throws Exception{
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        // 原交易不存在
        req.getBody().setOut_batch_no("102016011424254541221451");
        
        request.addParameter("para", req.marshal());
        tradeNotifyController.excuteRequest(request, response);
        System.err.println(response.getContentAsString());
        Assert.assertTrue(response.getContentAsString().contains("SUCCESS"));
        
    }
    
    
}
