package com.liantuo.trade.client.trade.packet.rsp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

public class TradePacketRspMerchantFreezeTest {

    @BeforeClass
    public void beforeClass() {
    }

    @Test
    public void TestRspObjToXml() {
        TradePacketRspMerchantFreeze rsp = new TradePacketRspMerchantFreeze();
        TradePacketHead head = new TradePacketHead();
        head.setRequest_time(new SimpleDateFormat("yyyyMMdd hh:mm:ss.SSSS").format(Calendar.getInstance().getTime()));
        head.setCore_merchant_no("123456");
        head.setSign("tradepacketmerchantfreeze");
        head.setVersion("1.0");
        head.setFund_pool_no("pool001");
        head.setPartner_id("wwww");
        head.setRequest_code("adfadd");
        head.setAuth_code("ddd");
        TradePacketRspBodyMerchantFreeze body = new TradePacketRspBodyMerchantFreeze();
        body.setIs_success("S");
        body.setReturn_code("F");
        body.setErr_code("0001");
        body.setErr_code_des("交易数据：json格式");
        body.setTrade_details("");
        rsp.setBusHead(head);
        rsp.setBody(body);
        System.err.println(rsp.marshal());

    }

    @Test
    public void TestRspXmlToObj() {
        TradePacketRspMerchantFreeze tradePacketRspMerchantFreeze = null;
        tradePacketRspMerchantFreeze = (TradePacketRspMerchantFreeze) TradePacketRspMerchantFreeze
                .unmarshal(
                        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Trade><head><auth_code>1234</auth_code><busi_code>1</busi_code><request_time>20151214 04:43:15.0651</request_time><sign>tradepacketmerchantfreeze</sign><system_code>0</system_code><version>1.0</version></head><body><result_code>0001</result_code><result_msg>交易处理失败</result_msg><trade_details>交易数据：json格式</trade_details></body></Trade>",
                        TradePacketRspMerchantFreeze.class);
        Assert.assertNotNull(tradePacketRspMerchantFreeze);
    }

    @AfterClass
    public void afterClass() {
    }

}