package com.liantuo.trade.web.controller.local;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspRefundOfflineSettle;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TradeRefundWithServerTest {
    private String TRADE_URL = "http://127.0.0.1:8888/trade/service/tx.in";


    @Test
    public void testRefund() throws Exception {
        TradePacketReqRefundOfflineSettle req = new TradePacketReqRefundOfflineSettle();

        TradePacketHead head = new TradePacketHead();
        head.setPartner_id("10000002048131212");
        head.setRequest_code("0001_002_001");
        head.setCore_merchant_no("CC_C8785258588");

        head.setFund_pool_no("PN01000000000010876");
        head.setVersion("1.0");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");

        TradePacketReqBodyRefundOfflineSettle body = new TradePacketReqBodyRefundOfflineSettle();
        body.setOut_trade_no_ext("zrx" + System.currentTimeMillis());
        body.setOriginal_trade_no("000000000000000700201512171928481");
        body.setGmt_refund_clear_channel("2015-10-10 10:10:10");
        body.setClear_refund_amount("1.2");
        body.setThird_trade_no("thirdTradeNo");

        body.setOut_trade_no("999");
        body.setClear_channel_attr_1("att1");
        body.setClear_channel_attr_2("att2");
        body.setClear_channel_attr_3("att3");
        body.setClear_channel_attr_4("att4");
        body.setClear_channel_attr_5("att5");
        body.setClear_channel_attr_6("att6");

        req.setBusHead(head);
        req.setBody(body);
        TradePacketRspRefundOfflineSettle rsp = TradeClient.refundOfflineSettle(req);

        if (null != rsp) {
            System.err.println(rsp.marshal());
        }
    }

}


