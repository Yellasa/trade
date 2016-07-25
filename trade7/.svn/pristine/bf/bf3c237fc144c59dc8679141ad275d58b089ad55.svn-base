package com.liantuo.trade.unittest.jy0006;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

import com.liantuo.payment.client.pay.PaymentClientV3;
import com.liantuo.payment.client.pay.alipay.base.GoodsDetail;
import com.liantuo.payment.client.pay.alipay.base.RoyaltyDetailInfos;
import com.liantuo.payment.client.pay.alipay.base.RoyaltyInfo;
import com.liantuo.payment.client.pay.alipay.vo1.req.AlipayTradeCancelRequest;
import com.liantuo.payment.client.pay.alipay.vo1.req.AlipayTradePayRequest;
import com.liantuo.payment.client.pay.alipay.vo1.req.AlipayTradePrecreateRequest;
import com.liantuo.payment.client.pay.alipay.vo1.req.AlipayTradeQueryRequest;
import com.liantuo.payment.client.pay.alipay.vo1.req.AlipayTradeRefundRequest;
import com.liantuo.payment.client.pay.alipay.vo1.rsp.AlipayTradeCancelResponse;
import com.liantuo.payment.client.pay.alipay.vo1.rsp.AlipayTradePayResponse;
import com.liantuo.payment.client.pay.alipay.vo1.rsp.AlipayTradePrecreateResponse;
import com.liantuo.payment.client.pay.alipay.vo1.rsp.AlipayTradeQueryResponse;
import com.liantuo.payment.client.pay.alipay.vo1.rsp.AlipayTradeRefundResponse;
import com.liantuo.payment.client.pay.head.PaymentHead;

/**
 * 支付宝当面付2.0
 * 
 * @author BZX
 * 
 */
public class TestZFBZF001_02 {
	public PaymentHead setBasicParam() {
		PaymentHead head = new PaymentHead();
		head.setVersion("1.0");
		head.setTrade_no("123124123412312314");
		head.setTrade_req_no("13412341234134123415");
		head.setLedger_no("11aa012345_78avcdeer");
		head.setCore_merchant_no("liantuo");
		head.setOut_trade_no("12312012234234");
		head.setPay_transaction_id("000000000000136");
		// head.setPay_transaction_id("EW_B0480444447");
		return head;
	}

	/**
	 * 支付宝当面付2.0条码|声波支付
	 * 
	 * @throws Exception
	 */
	@Test
	public void alipayTradePay() throws Exception {
		AlipayTradePayRequest request = new AlipayTradePayRequest();
		PaymentHead head = setBasicParam();
		head.setPay_channel("ZF0001_02_001");
		request.setZf_head(head);
		request.setOut_trade_no("tradepay20160527102136590");
		request.setSubject("大麵包");
		// bar_code 条码 wave_code 声波
		request.setScene("bar_code");
		request.setAuth_code("289407546358155362");
		request.setTotal_amount("0.01");
		request.setSeller_id("2088101568353491");
		request.setTimeout_express("100m");
		// 商品明细列表，需填写购买商品详细信息，
		List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
		// 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
		GoodsDetail goods1 = new GoodsDetail();
		goods1.setGoods_id("goods_id001");
		goods1.setGoods_name("是对方身份的");
		goods1.setPrice("0.03");
		goods1.setQuantity("1");
		goodsDetailList.add(goods1);
		request.setGoods_detail(goodsDetailList);
		// 分账信息
		List<RoyaltyDetailInfos> royaltyList = new ArrayList<RoyaltyDetailInfos>();
		RoyaltyDetailInfos detailInfos = new RoyaltyDetailInfos();
		detailInfos.setSerial_no("123222121");
		detailInfos.setTrans_in_type("userId");
		detailInfos.setBatch_no("12322212122212000000001");
		detailInfos.setOut_relation_id("20160613001");
		detailInfos.setTrans_out_type("userId");
		detailInfos.setTrans_out("2088101568353491");
		detailInfos.setTrans_in("2088112554715421");
		detailInfos.setAmount("0.01");
		detailInfos.setDesc("分账测试Hxx");
		royaltyList.add(detailInfos);
		RoyaltyInfo royaltyInfo = new RoyaltyInfo();
		royaltyInfo.setRoyalty_detail_infos(royaltyList);
		royaltyInfo.setRoyalty_type("ROYALTY");
		request.setRoyalty_info(royaltyInfo);
		AlipayTradePayResponse response = PaymentClientV3.alipayTradePay(request, AlipayTradePayResponse.class);
	}

	/**
	 * 当面付2.0查询
	 */
	@Test
	public void alipayTradeQuery() {
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		PaymentHead head = setBasicParam();
		head.setPay_channel("ZF0001_02_003");
		request.setZf_head(head);
		request.setTrade_no("");
		request.setOut_trade_no("tradepay20160527102136598");
		AlipayTradeQueryResponse response = PaymentClientV3.alipayTradeQuery(request, AlipayTradeQueryResponse.class);
		System.out.println(response.getTrade_status());
	}

	/**
	 * 当面付2.0撤销
	 */
	@Test
	public void alipayTradeCancel() {
		AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
		PaymentHead head = setBasicParam();
		head.setPay_channel("ZF0001_02_004");
		request.setZf_head(head);
		request.setOut_trade_no("tradepay20160527102136598");
		AlipayTradeCancelResponse response = PaymentClientV3.alipayTradeCancel(request, AlipayTradeCancelResponse.class);
		System.out.println(response.getAction());
	}

	/**
	 * 当面付2.0退款
	 * 
	 * @throws Exception
	 */
	@Test
	public void alipayTradeRefund() throws Exception {
		AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
		PaymentHead head = setBasicParam();
		head.setPay_channel("ZF0001_02_005");
		request.setZf_head(head);
		request.setOut_trade_no("tradepay20160527102136598");
		request.setRefund_amount("0.01");
		request.setRefund_reason("买多了");
		request.setOut_request_no("201606130102512004");
		AlipayTradeRefundResponse response = PaymentClientV3.alipayTradeRefund(request, AlipayTradeRefundResponse.class);
	}

	/**
	 * 支付宝当面付2.0扫码支付
	 */
	@Test
	public void alipayTradePrecreate() {
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
		request.setNotify_url("0006_01_002");
		PaymentHead head = setBasicParam();
		head.setPay_channel("ZF0001_02_002");
		request.setZf_head(head);
		request.setOut_trade_no("tradepay20160527102136598");
		request.setSubject("測試包");
		// bar_code 条码 wave_code 声波
		request.setTotal_amount("0.01");
		request.setSeller_id("");
		request.setDiscountable_amount("100000000");
		// request.setUndiscountable_amount("0.01");
		request.setTimeout_express("5m");
		// 商品明细列表，需填写购买商品详细信息，
		List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
		// 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
		GoodsDetail goods1 = new GoodsDetail();
		goods1.setGoods_id("goods_id001");
		goods1.setGoods_name("是对方身份的");
		goods1.setPrice("1500");
		goods1.setQuantity("1");
		goodsDetailList.add(goods1);
		request.setGoods_detail(goodsDetailList);
		AlipayTradePrecreateResponse response = PaymentClientV3.alipayTradePrecreate(request, AlipayTradePrecreateResponse.class);
	}

	@Test
	public void alipayPrecreateNotify() {
		SortedMap<String, String> map = new TreeMap<String, String>();
		map.put("paymentReqNo", "00000171497");
		map.put("payChannel", "ZF0001_02_002");
		map.put("version", "1.0");
		map.put("body", "订单描述");
		map.put("trade_status", "TRADE_SUCCESS");
		map.put("gmt_payment", "2016-07-01 14:00:11");
		map.put("gmt_create", "2016-07-01 14:00:04");
		map.put("buyer_pay_amount", "0.02");
		map.put("receipt_amount", "0.02");
		map.put("seller_id", "2088101568353491");
		map.put("app_id", "2015090900262421");
		map.put("sign",
				"KlX7zsA8iMqRDNoTSjaLPWHneys5LLBt1JNZ/xDGTZdOMgQOxzln+JbsPekaHMYj7nXGvtjm8GFnu7T51Nl7W9BiC99PBOrNDVvgnvwAv/AmmEjqtfDQYOgKwbNRYkhBlHvzKRTAIdpmxdAREhYefHaO/uvyx0dQkqiWWlWRkeU=");
		// map.put("fail_details","1^moxie1@shoufei.com^莫邪^22.00^F^123^20100812^20100812001");
		map.put("seller_email", "alipay-test07@alipay.com");
		map.put("notify_id", "d09dcddf65ee38fcb38f0c95eae04d3h2y");
		map.put("invoice_amount", "0.02");
		map.put("notify_time", "2016-07-01 14:00:12");
		map.put("trade_no", "2016060321001004880216273757");
		map.put("buyer_id", "2088102842758885");
		map.put("total_amount", "0.01");
		map.put("point_amount", "0.00");
		map.put("out_trade_no", "order_201658843300");
		map.put("notify_type", "trade_status_sync");
		map.put("buyer_logon_id", "183****9830");
		map.put("sign_type", "RSA");
		map.put("subject", "订单标题");
		map.put("open_id", "20880083345268609220930461414914");
		map.put("fund_bill_list", "[{\"amount\":\"0.02\",\"fundChannel\":\"ALIPAYACCOUNT\"}]");
		String notifyUrl = "http://localhost:8787/payment_center/notify/alipay/alipayTradePrecreateNotify.in";
//		System.out.println(PaymentTestUtils.alipayNotify(notifyUrl, map));
	}
}
