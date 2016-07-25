package com.liantuo.trade.bus.factory.template;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqRefundOfflineSettle;
import com.liantuo.trade.common.constants.TradeConstants;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;

@ContextConfiguration(
        locations = {
                "classpath:config/spring/applicationContext-common.xml",
                "classpath:config/spring/applicationContext-myBatis.xml"
        }
)
public class TradeTemplateFactoryTest extends AbstractTransactionalJUnit4SpringContextTests {
//    @Resource(name = "tradeTemplateFactory")
    private TradeTemplateFactory tradeTemplateFactory;


    /**
     * 成员冻结	0001_001_001
     */
   
    public void testTemplateFreeze() {
        System.err.println("0001_001_001");
        Assert.assertNotNull(tradeTemplateFactory);
        TradePacketReqRefundOfflineSettle req = new TradePacketReqRefundOfflineSettle();
        TradePacketHead head = new TradePacketHead();
        head.setRequest_code(TradeConstants.TRADE_TYPE_PAY_NO_PWD_MERCHANT_FREEZE);
        TradePacketReqBodyRefundOfflineSettle body = new TradePacketReqBodyRefundOfflineSettle();
        req.setBusHead(head);
        req.setBody(body);
        try {
            this.tradeTemplateFactory.create(TradeConstants.TRADE_TYPE_PAY_NO_PWD_MERCHANT_FREEZE).execute(req, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("");
    }

    /**
     * 0001_001_002 线下付款成功,剩余解冻
     */
    
    public void testTemplateOfflineUnFreeze() {
        System.err.println("0001_001_002");
        Assert.assertNotNull(tradeTemplateFactory);
        TradePacketReqRefundOfflineSettle req = new TradePacketReqRefundOfflineSettle();
        TradePacketHead head = new TradePacketHead();
        head.setRequest_code(TradeConstants.TRADE_TYPE_PAY_NO_PWD_UN_FREEZE_OFFLINE_SETTLE);
        TradePacketReqBodyRefundOfflineSettle body = new TradePacketReqBodyRefundOfflineSettle();
        req.setBusHead(head);
        req.setBody(body);
        try {
            this.tradeTemplateFactory.create(TradeConstants.TRADE_TYPE_PAY_NO_PWD_UN_FREEZE_OFFLINE_SETTLE).execute(req, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("");
    }

    /**
     * 0001_001_003 全额解冻
     */
    @Test
    public void testTemplateFullUnFreeze() {
        System.err.println("0001_001_003");
        Assert.assertNotNull(tradeTemplateFactory);
        TradePacketReqRefundOfflineSettle req = new TradePacketReqRefundOfflineSettle();
        TradePacketHead head = new TradePacketHead();
        head.setRequest_code(TradeConstants.TRADE_TYPE_PAY_NO_PWD_MERCHANT_FREEZE);
        TradePacketReqBodyRefundOfflineSettle body = new TradePacketReqBodyRefundOfflineSettle();
        req.setBusHead(head);
        req.setBody(body);
        try {
        	System.out.println(tradeTemplateFactory.create(TradeConstants.TRADE_TYPE_PAY_NO_PWD_MERCHANT_FREEZE).getVoClass());
            //this.tradeTemplateFactory.create(req).execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("");
    }

    /**
     * 线下付款退回 0001_002_001
     */
   
    public void testTemplateRefund() {
        System.err.println("0001_002_001");
        Assert.assertNotNull(tradeTemplateFactory);
        TradePacketReqRefundOfflineSettle req = new TradePacketReqRefundOfflineSettle();
        TradePacketHead head = new TradePacketHead();
        head.setRequest_code(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_OFFLINE_SETTLE);
        TradePacketReqBodyRefundOfflineSettle body = new TradePacketReqBodyRefundOfflineSettle();
        req.setBusHead(head);
        req.setBody(body);
        try {
            this.tradeTemplateFactory.create(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_OFFLINE_SETTLE).execute(req, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("");
    }
}