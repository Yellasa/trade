package com.liantuo.trade.bus.service.impl;

import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyPayPageDetails;
import com.liantuo.trade.client.trade.packet.body.simple_fund_transfer.QueryPage4TransferDetail;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.orm.service.TradeTransferAccountService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({
        WebContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public class BizPaymentTradePageQueryServiceImplTest {
    @Resource(name = "bizPaymentTradePageQueryServiceImpl")
    private BizTradePageQueryService pageQueryService;
    
    @Resource(name = "transferPageQueryServiceImpl")
    private BizTradePageQueryService transferService;

    @Test
    public void testQueryByPage() throws Exception {
        Assert.assertNotNull(pageQueryService);
        TradeRequest<TradePacketReqBodyPayPageDetails> req = new TradeRequest<TradePacketReqBodyPayPageDetails>();
        TradePacketReqBodyPayPageDetails body = new TradePacketReqBodyPayPageDetails();
        TradePacketHead head = new TradePacketHead();
        req.setBody(body);
        req.setHead(head);

        head.setPartner_id("10000002057141223");
        head.setCore_merchant_no("SXSL");
        head.setFund_pool_no("PN01000000000000824");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(Calendar.getInstance().getTime()));
        head.setVersion("1.0");
        head.setVersion("1.1");
        head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");

        head.setRequest_code("0001_001_999");
        head.setRequest_code("0001_001_998");


        body.setPage(" ");
        body.setPage_size(" ");
        body.setPayment_account_no(" ");
//        body.setGmt_freeze_success_datetime_start("2016-02-01 00:00:00");

        TradeResponse rsp = new TradeResponse();
        pageQueryService.queryByPage(req, rsp);
    }
    
    
    @Test
    public void testQueryByPage4Transfer() throws Exception {
    	Assert.assertNotNull(transferService);
    	TradeRequest<QueryPage4TransferDetail> req = new TradeRequest<QueryPage4TransferDetail>();
    	QueryPage4TransferDetail body = new QueryPage4TransferDetail();
    	TradePacketHead head = new TradePacketHead();
    	req.setBody(body);
    	req.setHead(head);
    	
    	head.setPartner_id("10000002057141223");
    	head.setCore_merchant_no("CC_C8785258588");
    	head.setFund_pool_no("PN01000000000010876");
    	head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(Calendar.getInstance().getTime()));
    	head.setVersion("1.0");
    	head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
    	
//    	head.setRequest_code("0001_001_999");
    	head.setRequest_code("0007_001_998");
    	
    	
    	body.setPage("0");
    	body.setPage_size("10");
    	body.setPayment_account_no(" ");
//        body.setGmt_freeze_success_datetime_start("2016-02-01 00:00:00");
    	
    	TradeResponse rsp = new TradeResponse();
    	transferService.queryByPage(req, rsp);
    }
    
    
}