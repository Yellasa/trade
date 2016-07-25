package com.liantuo.trade.bus.service.impl;

import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundPageDetails;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({
        WebContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public class BizRefundTradePageQueryServiceImplTest {

    @Resource(name = "bizRefundTradePageQueryServiceImpl")
    private BizTradePageQueryService bizTradePageQueryService;

    @Test
    public void testQueryByPage() throws Exception {
        Assert.assertNotNull(bizTradePageQueryService);
        TradePacketHead head = new TradePacketHead();
        head.setCore_merchant_no("SXSL");
        head.setFund_pool_no("PN01000000000000824");
        TradePacketReqBodyRefundPageDetails body = new TradePacketReqBodyRefundPageDetails();
        body.setRefund_account_no("CA12050317300000");
        body.setOut_trade_no_ext("df20163589233959992741");
        TradeRequest<TradePacketReqBodyRefundPageDetails> req = new TradeRequest<TradePacketReqBodyRefundPageDetails>();
        req.setHead(head);
        req.setBody(body);

//        Object result = bizTradePageQueryService.queryByPage(req);
//        Assert.assertNotNull(result);
    }
}