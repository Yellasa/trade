package com.liantuo.trade.unittest.jy0006;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.liantuo.payment.client.pay.PaymentClientV3;
import com.liantuo.payment.client.pay.head.PaymentHead;
import com.liantuo.payment.client.pay.weixin.vo1.agent.req.WeiXinCloseRequest;
import com.liantuo.payment.client.pay.weixin.vo1.agent.req.WeiXinQueryRequest;
import com.liantuo.payment.client.pay.weixin.vo1.agent.req.WeiXinRefundQueryRequest;
import com.liantuo.payment.client.pay.weixin.vo1.agent.req.WeiXinRefundRequest;
import com.liantuo.payment.client.pay.weixin.vo1.agent.req.WeiXinReverseRequest;
import com.liantuo.payment.client.pay.weixin.vo1.agent.req.WeiXinScanPayRequest;
import com.liantuo.payment.client.pay.weixin.vo1.agent.req.WeiXinUnifiedOrderRequest;
import com.liantuo.payment.client.pay.weixin.vo1.agent.rsp.WeiXinCloseResponse;
import com.liantuo.payment.client.pay.weixin.vo1.agent.rsp.WeiXinQueryResponse;
import com.liantuo.payment.client.pay.weixin.vo1.agent.rsp.WeiXinRefundQueryResponse;
import com.liantuo.payment.client.pay.weixin.vo1.agent.rsp.WeiXinRefundResponse;
import com.liantuo.payment.client.pay.weixin.vo1.agent.rsp.WeiXinReverseResponse;
import com.liantuo.payment.client.pay.weixin.vo1.agent.rsp.WeiXinScanPayResponse;
import com.liantuo.payment.client.pay.weixin.vo1.agent.rsp.WeiXinUnifiedOrderResponse;

/**
 * 微信服务商测试
 */
public class TestWXZF003_01 {
	//设置请求协议参数
	public PaymentHead setBasicParam() {
		PaymentHead head=new PaymentHead();
		head.setVersion("1.0");
		head.setTrade_no("123124123412312314");
		head.setTrade_req_no("13412341234134123415");
		head.setLedger_no("11aa012345_78avcdeer");
		head.setCore_merchant_no("EW_N8516881089");
		head.setOut_trade_no("123120122342340002");
		head.setPay_transaction_id("000000000000001");
		return head;
	}
	
	//条码支付
    @Test
    public void scanPay(){
    	WeiXinScanPayRequest request=new WeiXinScanPayRequest();
		PaymentHead head=setBasicParam();
		head.setPay_channel("ZF0003_01_001");
		request.setZf_head(head);
    	request.setSub_appid("wx41a886877df49e6a");
    	//request.setDevice_info("");
    	request.setBody("联拓金融1分钱测试");
    	//request.setDetail("");
    	//request.setAttach("");
    	request.setOut_trade_no("10201607046007574514602");
    	request.setTotal_fee("1");
    	//request.setFee_type("");
    	request.setSpbill_create_ip("219.141.233.68");
//    	request.setGoods_tag("");
//    	request.setLimit_pay("");
    	request.setAuth_code("130091862146205555");
    	WeiXinScanPayResponse response = PaymentClientV3.weixinScanPay(request, WeiXinScanPayResponse.class);
    }
    
    //统一下单
    @Test
    public void unifiedOrder(){
    	WeiXinUnifiedOrderRequest request=new WeiXinUnifiedOrderRequest();
		PaymentHead head=setBasicParam();
		head.setPay_channel("ZF0003_01_002");
		request.setZf_head(head);
		request.setNotify_url("0003_01_002:1.0");
    	request.setSub_appid("wx41a886877df49e6a");
    	//request.setDevice_info("");
    	request.setBody("联拓金融1分钱测试");
    	//request.setDetail("");
    	//request.setAttach("");
    	request.setOut_trade_no("1020150415600757412360");
    	request.setTotal_fee("1");
    	//request.setFee_type("");
    	request.setSpbill_create_ip("219.141.233.68");
//    	request.setGoods_tag("");
//    	request.setLimit_pay("");
    	request.setTime_start("");
    	request.setTime_expire("");
    	request.setOpenid("");
    	request.setSub_openid("oOALut5GcgkAWHE927iRJO4Iz18E");
    	request.setTrade_type("JSAPI");
    	WeiXinUnifiedOrderResponse response = PaymentClientV3.weixinUnifiedOrder(request, WeiXinUnifiedOrderResponse.class);
    }
    
   //统一下单异步通知
    @Test
    public void unifiedOrderNotify() throws Exception{
    	Map<String,String> reqParam=new HashMap<String,String>();
    	reqParam.put("is_subscribe","N");
    	reqParam.put("sub_openid","oOALut5GcgkAWHE927iRJO4Iz18E");
    	reqParam.put("appid","wx6c68ab3d898a1a96");
    	reqParam.put("fee_type","CNY");
    	reqParam.put("nonce_str","gHW6jf1dmiPwd1cF");
    	reqParam.put("out_trade_no","102015041560075745142");
    	reqParam.put("transaction_id","4008432001201607048353587631");
    	reqParam.put("trade_type","NATIVE");
    	reqParam.put("payChannel","ZF0003_01_002");
    	reqParam.put("version","1.0");
    	reqParam.put("sign","CFDF24A40873918F74D8D7564EE62B74");
    	reqParam.put("result_code","SUCCESS");
    	reqParam.put("mch_id","1267388801");
    	reqParam.put("sub_appid","wx41a886877df49e6a");
    	reqParam.put("sub_is_subscribe","Y");
    	reqParam.put("total_fee","1");
    	reqParam.put("sub_mch_id","1268894301");
    	reqParam.put("time_end","20160704140911");
    	reqParam.put("openid","oLNmRjuCTuMGURO6vD7GNyQB328M");
    	reqParam.put("bank_type","CFT");
    	reqParam.put("return_code","SUCCESS");
    	reqParam.put("paymentReqNo","00000173942");
    	reqParam.put("cash_fee","1");
    	String notifyUrl = "http://localhost:8787/payment_center/notify/weixin/agent/weixinUnifiedOrderNotify.in";
//    	System.out.println(LocalHttpClient.doPost(notifyUrl, reqParam, ReqChannel.WEIXIN));
    }
    //查询
    @Test
    public void query(){
    	WeiXinQueryRequest request=new WeiXinQueryRequest();
		PaymentHead head=setBasicParam();
		head.setPay_channel("ZF0003_01_003");
		request.setZf_head(head);
		request.setOut_trade_no("102015041560075745142");
		request.setSub_appid("");
		request.setTransaction_id("");
		WeiXinQueryResponse response=PaymentClientV3.weixinQuery(request, WeiXinQueryResponse.class);
    }
    
    //撤销订单
    @Test
    public void reverse(){
    	WeiXinReverseRequest request=new WeiXinReverseRequest();
		PaymentHead head=setBasicParam();
		head.setPay_channel("ZF0003_01_004");
		request.setZf_head(head);
		request.setOut_trade_no("10201607046007574514602");
		request.setSub_appid("");
		request.setTransaction_id("");
		WeiXinReverseResponse response=PaymentClientV3.weixinReverse(request, WeiXinReverseResponse.class);
    }
    
    //关闭订单
    @Test
    public void close(){
    	WeiXinCloseRequest request=new WeiXinCloseRequest();
		PaymentHead head=setBasicParam();
		head.setPay_channel("ZF0003_01_005");
		request.setZf_head(head);
		request.setOut_trade_no("102015041560075745142");
		request.setSub_appid("");
		WeiXinCloseResponse response=PaymentClientV3.weixinClose(request, WeiXinCloseResponse.class);
    }
    
    //退款申请
    @Test
    public void refund(){
    	WeiXinRefundRequest request=new WeiXinRefundRequest();
		PaymentHead head=setBasicParam();
		head.setPay_channel("ZF0003_01_006");
		request.setZf_head(head);
		request.setOut_trade_no("10201607046007574514602");
		request.setTotal_fee("1");
		request.setRefund_fee("1");
		request.setOut_refund_no("10201600000000003");
		request.setTotal_fee("1");
		WeiXinRefundResponse response=PaymentClientV3.weixinRefund(request, WeiXinRefundResponse.class);
    }
    
    //退款查询
    @Test
    public void refundQuery(){
    	WeiXinRefundQueryRequest request=new WeiXinRefundQueryRequest();
		PaymentHead head=setBasicParam();
		head.setPay_channel("ZF0003_01_007");
		request.setZf_head(head);
		request.setOut_trade_no("102015041560075745142");
		request.setSub_appid("");
		request.setTransaction_id("");
		WeiXinRefundQueryResponse response=PaymentClientV3.weixinRefundQuery(request, WeiXinRefundQueryResponse.class);
    }
    
}
