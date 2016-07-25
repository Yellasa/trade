/**
 * 
 */
package com.liantuo.trade.web.controller.local;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawDeduct;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawDeductRefund;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawPageDetails;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawPay;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawPayResultQuery;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawDeduct;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawDeductRefund;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPageDetails;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPay;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPayResultQuery;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspMerchantFreeze;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.TradePacketRspSingleWithdrawDeduct;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.TradePacketRspSingleWithdrawDeductRefund;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.TradePacketRspSingleWithdrawPageDetails;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.TradePacketRspSingleWithdrawPayResultQuery;

/**
 * @ClassName:     TestTradeDemo0002.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-1-27 上午10:38:52 
 */
public class TestTradeDemo0002 {

//	private String TRADE_URL ="http://127.0.0.1:5555/trade/service/tx.in";//本地地址
//	private String TRADE_URL ="http://192.168.40.81:8080/trade/service/tx.in";//本地地址
	 private String TRADE_URL ="http://192.168.19.63:8000/trade/service/tx.in";//线下地址
	// private String TRADE_URL ="http://192.168.30.141:8000/trade/service/tx.in";//线上内网
//	private String TRADE_URL = "http://trade.51ebill.com/trade/service/tx.in";// 线上地址
	
	//线下测试数据：PID:10012426000150917、POOL:PN01000000000010876、core_merchant_no:CC_C8785258588、成员CA:CA21000000017026
	//线上测试数据：PID:10038012689151119、POOL:PN01000000000032988、core_merchant_no:EW_B1156484098、成员CA:CA21000000029960
	//CA21000000029957、10000002048131212、liantuo、PN01000000000000761

	/**
	 * 0002_001_002：支付宝批付出款
	 * @throws Exception
	 */
	@Test
	public void testWithdrawAlipayPay() throws Exception{
		TradePacketReqSingleWithdrawPay bizReq = new TradePacketReqSingleWithdrawPay();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodySingleWithdrawPay body = new TradePacketReqBodySingleWithdrawPay();

		head.setRequest_code("0002_001_002");
		head.setVersion("1");
		head.setPartner_id("10012426000150917");//10038012689151119
		head.setCore_merchant_no("CC_C8785258588");//EW_B1156484098
		head.setFund_pool_no("PN01000000000010876");//PN01000000000032988
		head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));

		body.setTrade_no("00020011602041230095200000006600");//原交易编号
		body.setPay_transaction_id("136385");
		body.setRequester("1");
		body.setPayer_account("zfbjk@liantuobank.com");//付款账号 zfbjk@liantuobank.com
		body.setPayer_name("合肥联拓金融信息服务有限公司北京分公司");//付款名称  合肥联拓金融信息服务有限公司北京分公司
		body.setWithdraw_third_account("ltftest02_zfb@126.com");//提现第三方账户ltftest02_zfb@126.com
		body.setWithdraw_third_account_name("合肥联拓金融信息服务有限公司");//提现第三方账户姓名
		body.setNotify_url("www.baidu.com");//通知地址
		body.setMerchant_extend_field_1("扩展参数1");
		body.setMerchant_extend_field_2("扩展参数2");
		body.setWithdraw_third_account_paymemo("备注");

		bizReq.setBusHead(head);
		bizReq.setBody(body);

		String reqXml = bizReq.marshal();
		Map<String, String> paras = new HashMap<String, String>();
		paras.put("para", reqXml);

		String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
		System.out.println("rspXml===========" + rspXml);
		TradePacketRspMerchantFreeze rsp = (TradePacketRspMerchantFreeze) TradePacket.unmarshal(rspXml, TradePacketRspMerchantFreeze.class);

		// TradePacketRspMerchantFreeze rsp =
		// TradeClient.merchantFreeze(bizReq);

		if (null != rsp) {
			System.err.println(rsp.marshal());
		}
	}
	
	/**
     * 0002_001_001：提现扣减
     */
	@Test
    public void testWithdrawDeduct()  {
	    TradePacketReqSingleWithdrawDeduct req = new TradePacketReqSingleWithdrawDeduct();
        req.setBusHead(initHeader("0002_001_001"));
        
        TradePacketReqBodySingleWithdrawDeduct body = new TradePacketReqBodySingleWithdrawDeduct();
        body.setOut_trade_no_ext("000200112345678920160308011");
        body.setOut_trade_no("000200112345678920160308011");
        body.setWithdraw_account_no("CA21000000017026");
        body.setWithdraw_amount("0.01");
        
        body.setMerchant_extend_field_1("mef1");
        body.setMerchant_extend_field_2("mef2");
        body.setMerchant_extend_field_3("mef3");
        body.setMerchant_extend_field_4("mef4");
        body.setMerchant_extend_field_5("mef5");
        
        body.setReserved_fields1("rf1");
        body.setReserved_fields2("rf2");
        body.setReserved_fields3("rf3");
        
        req.setBody(body);

        requestServer(req, TradePacketRspSingleWithdrawDeduct.class);
    }
	
	/**
     * 0002_001_004：出款查询
     */
    @Test
    public void testWithdrawPayResultQuery()  {
        TradePacketReqSingleWithdrawPayResultQuery req = new TradePacketReqSingleWithdrawPayResultQuery();
        req.setBusHead(initHeader("0002_001_004"));
        
        TradePacketReqBodySingleWithdrawPayResultQuery body = new TradePacketReqBodySingleWithdrawPayResultQuery();
        body.setTrade_no("20160125140506528000000000001400");
        
        req.setBody(body);

        requestServer(req, TradePacketRspSingleWithdrawPayResultQuery.class);
    }
    
    /**
     * 0002_001_005：提现退回
     */
    @Test
    public void testWithdrawDeductRefund()  {
        TradePacketReqSingleWithdrawDeductRefund req = new TradePacketReqSingleWithdrawDeductRefund();
        req.setBusHead(initHeader("0002_001_005"));
        
        TradePacketReqBodySingleWithdrawDeductRefund body = new TradePacketReqBodySingleWithdrawDeductRefund();
        body.setTrade_no("20160125140506528000000000001400");
        body.setReserved_fields1("rf1");
        body.setReserved_fields2("rf2");
        body.setReserved_fields3("rf3");
        
        req.setBody(body);

        requestServer(req, TradePacketRspSingleWithdrawDeductRefund.class);
    }
	
    /**
     * 0002_001_998：提现查询
     */
    @Test
    public void testWithdrawQuery()  {
        TradePacketReqSingleWithdrawPageDetails req = new TradePacketReqSingleWithdrawPageDetails();
        req.setBusHead(initHeader("0002_001_998"));
        
        TradePacketReqBodySingleWithdrawPageDetails body = new TradePacketReqBodySingleWithdrawPageDetails();
        
        // body.setTrade_no("20160125140506528000000000001400");
        
         body.setPage("0");
         body.setPage_size("5");
         body.setGmt_created_end("");
        
        req.setBody(body);

        requestServer(req, TradePacketRspSingleWithdrawPageDetails.class);
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
    private void requestServer(TradePacket req, Class clazz){
	    String reqXml = req.marshal();
        Map<String, String> paras = new HashMap<String, String>();
        paras.put("para", reqXml);
        System.out.println("para="+reqXml);

        String rspXml = requestAsHttpPOST(TRADE_URL, paras, "utf-8");
        System.out.println("rspXml===========" + rspXml);
        TradePacket rsp = TradePacket.unmarshal(rspXml, clazz);
        if (null != rsp) {
            System.err.println(rsp.marshal());
        }
	}
	
	private TradePacketHead initHeader(String requestCode){
	    TradePacketHead head = new TradePacketHead();
        head.setRequest_code(requestCode);
        head.setPartner_id("10000002048131212");
//        core_merchant_no:CC_C8785258588、成员CA:CA21000000017026,POOL:PN01000000000010876
        head.setCore_merchant_no("CC_C8785258588");//wnjjt
        head.setFund_pool_no("PN01000000000010876");//PN01000000000014842
        head.setVersion("1.0");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
        head.setSign("f644f5387aaeadae26bf45bf6d4759b9");
        return head;
	}
	
	@SuppressWarnings("deprecation")
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
