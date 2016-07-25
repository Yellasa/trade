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

import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawPageDetails;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPageDetails;


@ContextConfiguration(
        locations = {
                "classpath:config/spring/controller-context.xml",
                "classpath:config/spring/applicationContext-*.xml"
        })
//@TransactionConfiguration(defaultRollback = false)
public class WithdrawQueryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private TradeBusController tradeBusController;
    
    TradePacketReqSingleWithdrawPageDetails req = null;
    
    @Before
    public void before(){
        req = new TradePacketReqSingleWithdrawPageDetails();
        
        TradePacketHead head = new TradePacketHead();
        head.setPartner_id("10000002048131212");
        head.setRequest_code("0002_001_998");
        head.setCore_merchant_no("CC_C8785258588");
        
        head.setFund_pool_no("PN01000000000010876");
        head.setVersion("1.0");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        req.setBusHead(head);
        
        TradePacketReqBodySingleWithdrawPageDetails body = new TradePacketReqBodySingleWithdrawPageDetails();
        
        body.setTrade_no("00020011602051059197830000008120");
        body.setMerchant_extend_field_1("自动出票");
        body.setMerchant_extend_field_2("PKS4EB");
        body.setMerchant_extend_field_3("JZP0RM");
        body.setMerchant_extend_field_4("郭荣学");
        body.setMerchant_extend_field_5("SC");
        
        body.setOut_trade_no_ext("ote20162143207");
        body.setOut_trade_no("ot20162142079");
        body.setStatus("01^02^03^04^05^06^07^08");
        body.setPay_clear_channel("36");
        body.setWithdraw_batch_no("00020011602051145165550000008210");
        body.setWithdraw_serial_number("001");
        body.setPay_third_trade_no("20160214541465474");
        
        body.setPayer_account("zfbjk@liantuobank.com");
        body.setPayer_name("合肥联拓金融信息服务有限公司北京分公司");
        body.setWithdraw_account_no("CA21000000017026");
        body.setWithdraw_merchant_no("CC_C3212780145");
        body.setWithdraw_account_type("1");
        //body.setWithdraw_bank_account("ltftest02_zfb@126.com");
        body.setWithdraw_third_account("ltftest02_zfb@126.com");
        body.setWithdraw_third_account_name("合肥联拓金融信息服务有限公司");
        
        body.setGmt_created_start("2016-02-01 17:14:42");
        body.setGmt_created_end("2016-02-15 17:14:42");
        
        body.setGmt_deduct_success_start("2016-02-02 09:14:42");
        body.setGmt_deduct_success_end("2016-02-15 17:14:42");
        
        body.setGmt_pay_success_start("2016-02-10 17:14:45");
        body.setGmt_pay_success_end("2016-02-14 17:14:46");
        
        body.setPage("0");
        body.setPage_size("100");
        
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
