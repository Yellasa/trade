package com.liantuo.trade.web.controller.local;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyFullUnFreeze;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqFullUnFreeze;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspFullUnFreeze;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ModUnfreezeFullProcessTestHttp {

    private String TRADE_URL = "http://192.168.19.77:8000/trade/service/tx.in";//本地地址
//    private String TRADE_URL = "http://127.0.0.1:8888/trade/service/tx.in";//本地地址
//	 private String TRADE_URL = "http://192.168.30.141:8000/trade/service/tx.in";//线上内网
//	 private String TRADE_URL = "http://trade.51ebill.com/trade/service/tx.in";//线上地址


    @Test
    public void testFreeze() throws Exception {
        TradePacketReqFullUnFreeze bizReq = new TradePacketReqFullUnFreeze();
        TradePacketHead head = new TradePacketHead();
        TradePacketReqBodyFullUnFreeze body = new TradePacketReqBodyFullUnFreeze();

        head.setRequest_code("0001_001_003");
        head.setVersion("1");
        head.setPartner_id("10000002057141223");
        head.setCore_merchant_no("SXSL");
        head.setFund_pool_no("PN01000000000000824");
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

        body.setTrade_no("00010011603011651453180000212800");

        bizReq.setBusHead(head);
        bizReq.setBody(body);

        String reqXml = bizReq.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);

        String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
        System.out.println("rspXml===========" + rspXml);
        TradePacketRspFullUnFreeze rsp = TradePacket.unmarshal(rspXml, TradePacketRspFullUnFreeze.class);
//	         TradePacketRspMerchantFreeze rsp = TradeClient.merchantFreeze(bizReq);
        if (null != rsp) {
            System.err.println(rsp.marshal());
        }
    }

    public static String requestAsHttpPOST(String urlvalue, Map<String, String> paras, String enc) {
        HttpClient http = new HttpClient();
        PostMethod method = new PostMethod(urlvalue);
        method.getParams().setHttpElementCharset(enc);
        method.getParams().setContentCharset(enc);
        method.getParams().setCredentialCharset(enc);
        for (String key : paras.keySet()) {
            method.addParameter(key, paras.get(key));
        }
        System.out.println(paras);
        String result = "";
        try {
            http.executeMethod(method);
            http.setTimeout(20 * 1000);
            result = method.getResponseBodyAsString();
        } catch (IOException e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }
}
