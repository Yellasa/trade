package com.liantuo.trade.client.trade.packet.req;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

public class TradePacketReqMerchantFreezeTest {

    @BeforeClass
    public void beforeClass() {
    }

    @Test
    public void TestReqObjToXml() {
        TradePacketReqMerchantFreeze req = new TradePacketReqMerchantFreeze();
        TradePacketHead head = new TradePacketHead();
        head.setAuth_code("0001");
        head.setPartner_id("100000000999");
        head.setFund_pool_no("0001");
        head.setCore_merchant_no("CC99999999");
        head.setSystem_code("0");
        head.setBusi_code("1");
        head.setSign("tradepacketmerchantfreeze");
        head.setVersion("1.0");
        head.setRequest_time(new SimpleDateFormat("yyyyMMddhhmmssSSSS").format(Calendar.getInstance().getTime()));

        TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();

        body.setOut_trade_no("10201512141446000001");
        body.setOut_trade_no_ext("102015121414460000010001");
        body.setPayment_account_no("CA9999999999");
        body.setFreeze_amount("100.00");
        body.setMerchant_extend_field_1("merchant_extend_field_1");
        body.setMerchant_extend_field_2("merchant_extend_field_2");
        body.setMerchant_extend_field_3("merchant_extend_field_3");
        body.setMerchant_extend_field_4("merchant_extend_field_4");
        body.setMerchant_extend_field_5("merchant_extend_field_5");

        req.setBusHead(head);
        req.setBody(body);

        System.err.println(req.marshal());

    }

    @Test
    public void TestReqXmlToObj() {
        TradePacketReqMerchantFreeze tradePacketMerchantFreeze = null;
        tradePacketMerchantFreeze = (TradePacketReqMerchantFreeze) TradePacketReqMerchantFreeze
                .unmarshal(
                        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><trade><head><auth_code>0001</auth_code><busi_code>1</busi_code><core_merchant_no>CC99999999</core_merchant_no><fund_pool_no>0001</fund_pool_no><partner_id>100000000999</partner_id><request_time>201512151003080235</request_time><sign>tradepacketmerchantfreeze</sign><system_code>0</system_code><version>1.0</version></head><body><freeze_amount>100.00</freeze_amount><merchant_extend_field_1>merchant_extend_field_1</merchant_extend_field_1><merchant_extend_field_2>merchant_extend_field_2</merchant_extend_field_2><merchant_extend_field_3>merchant_extend_field_3</merchant_extend_field_3><merchant_extend_field_4>merchant_extend_field_4</merchant_extend_field_4><merchant_extend_field_5>merchant_extend_field_5</merchant_extend_field_5><out_trade_no>10201512141446000001</out_trade_no><out_trade_no_ext>102015121414460000010001</out_trade_no_ext><payment_account_no>CA9999999999</payment_account_no></body></trade>",
                        TradePacketReqMerchantFreeze.class);

        Assert.assertNotNull(tradePacketMerchantFreeze);
    }

    @AfterClass
    public void afterClass() {
    }

}