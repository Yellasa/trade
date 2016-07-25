package com.liantuo.trade.client.trade.packet.rsp;

import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyCommon;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import org.testng.annotations.Test;


public class TradePacketRspCommonTest {

    @Test
    public void testTradePacketRspCommon() {
        TradePacketRspCommon rsp = new TradePacketRspCommon();
        TradePacketHead head = new TradePacketHead();
        head.setRequest_code("0001_001_001");
        TradePacketRspBodyCommon body = new TradePacketRspBodyCommon();
        rsp.setBusHead(head);
        body.setIs_success("F");
        body.setReturn_code("F");
        body.setErr_code("0001");
        body.setErr_code_des("交易异常");
        rsp.setBody(body);
        System.err.println(rsp.marshal());
    }
}