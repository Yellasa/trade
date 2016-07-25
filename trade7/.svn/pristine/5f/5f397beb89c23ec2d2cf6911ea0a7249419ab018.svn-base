package com.liantuo.trade.web.controller.local;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.liantuo.trade.common.util.date.DateUtil;
import com.payment.client.pay.BusHead;
import com.payment.client.pay.BusTransaction;
import com.payment.client.pay.PaymentClient1;
import com.payment.client.pay.PaymentConstants;
import com.payment.client.pay.vo1.BusBodyReqAttachTradeInfo;
import com.payment.client.pay.vo1.BusBodyReqBalanceQuery;
import com.payment.client.pay.vo1.BusBodyReqCarPay;
import com.payment.client.pay.vo1.BusBodyReqClearing;
import com.payment.client.pay.vo1.BusBodyReqFreeze;
import com.payment.client.pay.vo1.BusBodyReqFreezeQuery;
import com.payment.client.pay.vo1.BusBodyReqPay;
import com.payment.client.pay.vo1.BusBodyReqPayBatch;
import com.payment.client.pay.vo1.BusBodyReqPayQuery;
import com.payment.client.pay.vo1.BusBodyReqRefund;
import com.payment.client.pay.vo1.BusBodyReqRefundQuery;
import com.payment.client.pay.vo1.BusBodyReqRoyalty;
import com.payment.client.pay.vo1.BusBodyReqSign;
import com.payment.client.pay.vo1.BusBodyReqTrustQuery;
import com.payment.client.pay.vo1.BusBodyReqUnFreezeQuery;
import com.payment.client.pay.vo1.BusBodyReqUnSign;
import com.payment.client.pay.vo1.BusBodyReqUnfreeze;
import com.payment.client.pay.vo1.BusTransactionReqAttachTradeInfo;
import com.payment.client.pay.vo1.BusTransactionReqBalanceQuery;
import com.payment.client.pay.vo1.BusTransactionReqCarPay;
import com.payment.client.pay.vo1.BusTransactionReqClearing;
import com.payment.client.pay.vo1.BusTransactionReqFreeze;
import com.payment.client.pay.vo1.BusTransactionReqFreezeQuery;
import com.payment.client.pay.vo1.BusTransactionReqPay;
import com.payment.client.pay.vo1.BusTransactionReqPayBatch;
import com.payment.client.pay.vo1.BusTransactionReqPayBatchQuery;
import com.payment.client.pay.vo1.BusTransactionReqPayQuery;
import com.payment.client.pay.vo1.BusTransactionReqRefund;
import com.payment.client.pay.vo1.BusTransactionReqRefundQuery;
import com.payment.client.pay.vo1.BusTransactionReqRoyalty;
import com.payment.client.pay.vo1.BusTransactionReqSign;
import com.payment.client.pay.vo1.BusTransactionReqTrustQuery;
import com.payment.client.pay.vo1.BusTransactionReqUnFreezeQuery;
import com.payment.client.pay.vo1.BusTransactionReqUnSign;
import com.payment.client.pay.vo1.BusTransactionReqUnfreeze;
import com.payment.client.pay.vo1.BusTransactionRspAttachTradeInfo;
import com.payment.client.pay.vo1.BusTransactionRspBalanceQuery;
import com.payment.client.pay.vo1.BusTransactionRspClearing;
import com.payment.client.pay.vo1.BusTransactionRspFreeze;
import com.payment.client.pay.vo1.BusTransactionRspFreezeQuery;
import com.payment.client.pay.vo1.BusTransactionRspPay;
import com.payment.client.pay.vo1.BusTransactionRspPayNotify;
import com.payment.client.pay.vo1.BusTransactionRspRefund;
import com.payment.client.pay.vo1.BusTransactionRspRefundQuery;
import com.payment.client.pay.vo1.BusTransactionRspRoyalty;
import com.payment.client.pay.vo1.BusTransactionRspSign;
import com.payment.client.pay.vo1.BusTransactionRspTrustQuery;
import com.payment.client.pay.vo1.BusTransactionRspUnFreezeQuery;
import com.payment.client.pay.vo1.BusTransactionRspUnSign;
import com.payment.client.pay.vo1.BusTransactionRspUnfreeze;

public class TestAlipay1 {
	private static BusHead initBusHead() {
		BusHead h = new BusHead();
		h.setPay_channel(String.valueOf(PaymentConstants.PAY_CHANNEL_ALIPAY));
		h.setRequest_time(DateUtil.toString(new Date(), "yyyyMMddHHmmss"));
//		h.setRequester(String.valueOf(PaymentConstants.BIZ_TYPE_TOURISM));
		h.setRequester(String.valueOf(PaymentConstants.BIZ_TYPE_B2B));
//		h.setRequester(String.valueOf(PaymentConstants.BIZ_TYPE_ADVANCED_PAYMENT));
//		h.setRequester(String.valueOf(PaymentConstants.BIZ_TYPE_TOURISM));
		h.setPartner_code("liantuo");
		h.setVersion("1");
		return h;
	}

	public static void pay() {
		BusTransactionReqPay pay = new BusTransactionReqPay();
		BusHead h = initBusHead();
//		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_WAP_PAY));
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_PAYMENT));
		h.setTransaction_id("114221");
		pay.setBusHead(h);
		BusBodyReqPay body = new BusBodyReqPay();
		body.setDescription("测试");
        //指定支付宝收银台默认支付方式
//        body.setPay_type("1");
		body.setOrder_no("102016010701285454210013");
		body.setPay_type(Integer.valueOf(PaymentConstants.PAY_TYPE_THIRDCMP).toString());
//		body.setPay_type(Integer.valueOf(PaymentConstants.PAY_TYPE_MOTO).toString());
//		body.setPayer_account("liantuo.log@gmail.com");
		// 支付并分润时需要setRoyalty_detail
		// body.setRoyalty_detail("liantuo.alipay@gmail.com^0.04^insurance^insurance^1");
		body.setPayer_code_name("CC_C3558030264");
		body.setPayer_name("CC_C3558030264");
		body.setSpbill_create_ip("219.141.233.68");
//		body.setNeedValidatePayerInfo(false);
		body.setSubject("测试");
		body.setTotal_fee("0.01");
//		body.setSeller_account("zfblt@126.com");
		body.setNotify_url("www.baidu.com");
        body.setReturn_url("www.baidu.com");
		pay.setBusBodyReqPay(body);
		pay.setBusHead(h);
//		BusTransactionRspPay rsp = (BusTransactionRspPay) PaymentClient1.pay(pay);
//		System.out.println(rsp.getBusBodyRspPay().getRet_code());
//		System.out.println(rsp.getBusBodyRspPay().getRet_des());
//		System.out.println(rsp.getBusBodyRspPay().getPay_url());
		
		BusTransaction rsp = PaymentClient1.pay(pay);
		checkvalid(rsp);
	}

	public static void checkvalid(BusTransaction rsp){
		BusTransactionRspPay rsp1 = (BusTransactionRspPay)rsp;
		System.out.println(rsp1.getBusBodyRspPay().getPay_url());
	}

	public static void batchPay() {
		BusTransactionReqPayBatch pay = new BusTransactionReqPayBatch();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_BATCH_PAY));
		h.setTransaction_id("117005");
		BusBodyReqPayBatch body = new BusBodyReqPayBatch();
		body.setPayer_account("liantuo.log@gmail.com");
		body.setPayer_code_name("yndy");
		body.setPayer_name("刘峰");
		body.setBatch_detail("001^liantuo.alipay@gmail.com^刘峰^0.01^虚拟账户在线冲值批次号：102014111500000999");
		body.setBatch_fee("0.01");
		body.setBatch_no("102014111124254545454544");
		body.setBatch_num("1");
		pay.setBusBodyReqPayBatch(body);
		pay.setBusHead(h);
		BusTransactionRspPay rsp = (BusTransactionRspPay) PaymentClient1
				.batchPay(pay);
		System.out.println(rsp.getBusBodyRspPay().getPay_url());
		
	}

	
	public static void payBatchQuery() {
		BusTransactionReqPayBatchQuery pay = new BusTransactionReqPayBatchQuery();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_BATCH_PAY_QUERY));
//		h.setTransaction_id("101005");
		h.setTransaction_id("136385");
		BusBodyReqPayBatch body=new BusBodyReqPayBatch();
		body.setPayer_account("zfbjk@liantuobank.com");
		body.setBatch_no("102016010724254541221451");
		pay.setBusBodyReqPayBatch(body);
		pay.setBusHead(h);
		BusTransactionRspPayNotify rsp = (BusTransactionRspPayNotify) PaymentClient1
				.payBatchQuery(pay);
		System.out.println(rsp.marshal());
		System.out.println(rsp.getBusBodyRspPay().getRet_code());
		System.out.println(rsp.getBusBodyRspPay().getPay_info());
	}
	
	public static void payNopwd() {
		BusTransactionReqPay pay = new BusTransactionReqPay();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_PAY_NOPWD));
		h.setTransaction_id("114221");
		pay.setBusHead(h);
		BusBodyReqPay body = new BusBodyReqPay();
//		body.setDescription("XXXXXXXXXXXXXXXXXXXXXXXXXX");
		body.setOrder_no("102016010701285454212542");
		System.out.println(body.getOrder_no());
		body.setPay_type(Integer.valueOf(PaymentConstants.PAY_TYPE_THIRDCMP)
				.toString());
		body.setBank_type(PaymentConstants.TENPAY_BANK_BL);
		body.setPayer_account("ltfzfb03@126.com");
		body.setPayer_code_name("liantuo");
		body.setPayer_name("liantuo");
		body.setSpbill_create_ip("219.141.233.68");
		body.setSubject("测试");
		body.setTotal_fee("0.01");
//		body.setSeller_account("18661830893");
		body.setNotify_url("www.baidu.com");
        body.setReturn_url("www.baidu.com");
		pay.setBusBodyReqPay(body);
		pay.setBusHead(h);
		BusTransactionRspPayNotify rsp = (BusTransactionRspPayNotify) PaymentClient1
				.payNoPwd(pay);
		System.out.println(rsp.getBusBodyRspPay().getPay_info());
		System.out.println(rsp.getBusBodyRspPay().getRet_code());
	}

	public static void paySuppl() {
		BusTransactionReqPay pay = new BusTransactionReqPay();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_SUPPL_PAY));
		h.setTransaction_id("124721");
		pay.setBusHead(h);
		BusBodyReqPay body = new BusBodyReqPay();
		body.setOrder_no("102012053000000019");// 主单单号
		body.setOut_suppl_no("102012053100000180");// 子单单号
		body.setHft_trade_no("hft52012053017243612053000000019");// 主单hft（ebill内部交易号）
		body.setSuppl_amount("0.03");// 补差金额
		pay.setBusBodyReqPay(body);
		pay.setBusHead(h);
		BusTransactionRspPay rsp = (BusTransactionRspPay) PaymentClient1
				.pay(pay);
		System.out.println(rsp.getBusBodyRspPay().getRet_code());
	}

	public static void payDirect() {
		BusTransactionReqPay pay = new BusTransactionReqPay();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_DIRECT_PAY));
		h.setTransaction_id("121974");
		pay.setBusHead(h);
		BusBodyReqPay body = new BusBodyReqPay();
		body.setOrder_no("10201206060000098766");
//		 body.setBank_type(PaymentConstants.TENPAY_BANK_CCB);
//		 body.setPayer_account("ltdkj@liantuo.com");
		body.setPayer_code_name("BTOCCS");
		body.setPayer_name("BTOCCS");
		body.setSubject("去程航段：北京首都机场-杭州萧山机场 去程航班号：CA1509 去程时间：2013-01-30 08:00:00.0");
		body.setTotal_fee("1.00");
		body.setPay_type(String.valueOf(PaymentConstants.PAY_TYPE_MOTO));
		body.setNotify_url("www.51ebill.com");
		pay.setBusBodyReqPay(body);
		pay.setBusHead(h);
		BusTransactionRspPay rsp = (BusTransactionRspPay) PaymentClient1
				.pay(pay);
		System.out.println(rsp.getBusBodyRspPay().getPay_url());
	}

	public static void royalty() {
		BusTransactionReqRoyalty pay = new BusTransactionReqRoyalty();
		BusHead h = initBusHead();
		h.setTransaction_id("117005");
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_ROYALTY));
		BusBodyReqRoyalty busBodyReqRoyalty = new BusBodyReqRoyalty();
//		busBodyReqRoyalty.setBus_inf("");
		busBodyReqRoyalty.setHft_trade_no("hft01120151028144000151028019128");
		busBodyReqRoyalty.setOrder_no("AP0120151028019128");
		busBodyReqRoyalty.setOut_bill_no("AP0120151028019128");
		busBodyReqRoyalty.setThird_pay_no("AP0120151028019128");
		busBodyReqRoyalty
				.setRoyalty_detail("ltfzfb03@126.com^0.5^test^test^1");
		pay.setBusBodyReqRoyalty(busBodyReqRoyalty);
		pay.setBusHead(h);
		BusTransactionRspRoyalty rsp = (BusTransactionRspRoyalty) PaymentClient1
				.royalty(pay);
		System.out.println(rsp.getBusBodyRspRoyalty().getRet_code());
		System.out.println(rsp.getBusBodyRspRoyalty().getPay_info());
	}

	public static void multiRoyalty() {
		BusTransactionReqRoyalty pay = new BusTransactionReqRoyalty();
		BusHead h = initBusHead();
		h.setTransaction_id("323431");
		h.setTrade_type(String
				.valueOf(PaymentConstants.TRADE_TYPE_MULTI_ROYALTY));
		BusBodyReqRoyalty busBodyReqRoyalty = new BusBodyReqRoyalty();
		busBodyReqRoyalty.setBus_inf("");
		busBodyReqRoyalty.setHft_trade_no("hft32012090613370020090600000205");
		busBodyReqRoyalty.setOrder_no("1020120090600000205");
		busBodyReqRoyalty.setOut_bill_no("1020120090600000205");
		busBodyReqRoyalty
				.setMulti_royalty_detail("liantuo.alipay@gmail.com^liantuo_yf@163.com^0.04^insurance^insurance^1");
		pay.setBusBodyReqRoyalty(busBodyReqRoyalty);
		pay.setBusHead(h);
		BusTransactionRspRoyalty rsp = (BusTransactionRspRoyalty) PaymentClient1
				.multiRoyalty(pay);
		System.out.println(rsp.getBusBodyRspRoyalty().getRet_code());
		System.out.println(rsp.getBusBodyRspRoyalty().getPay_info());
	}

	public static void refund() {
		BusTransactionReqRefund refund = new BusTransactionReqRefund();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_REFUND));
		h.setTransaction_id("101773");
		BusBodyReqRefund busBodyReqRefund = new BusBodyReqRefund();
		refund.setBusHead(h);
		busBodyReqRefund.setOrder_no("1020150816105100005");
		busBodyReqRefund.setHft_trade_no("hft01120150816141900816105100005");
		busBodyReqRefund.setRefund_batch_no("R1020150816105100005");
		// "0$ltjl^0|c^b^0.03" c给b退钱
		// "0$ltjl^0|liantuo.log@gmail.com,csx,hxx^cd9mzfb@163.com^0.03";
		// "0$liantuo.alipay@gmail.com,csx,陈寿星^cd9mzfb@163.com^0.02|liantuo_yf@163.com,csx,陈寿星^cd9mzfb@163.com^0.02";
		String detail = "0$ltftest06_zfb@126.com,NBDHBG,宁波东航变更^account@liantuo.com^0.01|";
		busBodyReqRefund.setRefund_detail(detail);
//		busBodyReqRefund.setThird_pay_no("20120910200000000775036");
		busBodyReqRefund.setTotal_fee("0.01");
//		busBodyReqRefund.setRmk("PNR");
//		busBodyReqRefund.setUser_code_name("liantuo976");
//		busBodyReqRefund.setNotify_url("www.baidu.com");
		refund.setBusBodyReqRefund(busBodyReqRefund);
		BusTransactionRspRefund rsp = (BusTransactionRspRefund) PaymentClient1
				.refund(refund);
		System.out.println(rsp.getBusBodyRspRefund().getRet_code());
		System.out.println(rsp.getBusBodyRspRefund().getPay_info());
	}
	
	public static void refundPwd() {
		BusTransactionReqRefund refund = new BusTransactionReqRefund();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_REFUND_PWD));
		h.setTransaction_id("2088001425892773");
		BusBodyReqRefund busBodyReqRefund = new BusBodyReqRefund();
		refund.setBusHead(h);
		busBodyReqRefund.setOrder_no("1020120091000000206");
		busBodyReqRefund.setHft_trade_no("hft12012082110584020082100000204");
		busBodyReqRefund.setRefund_batch_no("2012091100000202");
		busBodyReqRefund.setThird_pay_no("2012091144662686");
		// "0$ltjl^0|c^b^0.03" c给b退钱
		// "0$ltjl^0|liantuo.log@gmail.com,csx,陈寿星^cd9mzfb@163.com^0.03";
		// "0$cd9mzfb@163.com,csx,陈寿星^liantuo.log@gmail.com^0.04";
		busBodyReqRefund.setNotify_url("www.xxxxxxxxxxxx.com");
		String detail = "0.04$";
		busBodyReqRefund.setRefund_detail(detail);
		busBodyReqRefund.setTotal_fee("0.04");
		refund.setBusBodyReqRefund(busBodyReqRefund);
		BusTransactionRspRefund rsp = (BusTransactionRspRefund) PaymentClient1
				.refundPwd(refund);
		System.out.println(rsp.getBusBodyRspRefund().getRefund_url());
		System.out.println(rsp.getBusBodyRspRefund().getPay_info());
	}

	public static void refundQuery() {
		BusTransactionReqRefundQuery refundQuery = new BusTransactionReqRefundQuery();
		BusHead h = initBusHead();
		h.setTransaction_id("114221");
		h.setTrade_type(String
				.valueOf(PaymentConstants.TRADE_TYPE_REFUND_QUERY));
		BusBodyReqRefundQuery busBodyReqRefundQuery = new BusBodyReqRefundQuery();
		refundQuery.setBusHead(h);
		busBodyReqRefundQuery.setRefund_batch_no("2014042222100000005052458");
		busBodyReqRefundQuery.setOrder_no("112012042416395180");
		busBodyReqRefundQuery.setThird_pay_no("2012042459610934");
		busBodyReqRefundQuery.setHft_trade_no("hft12012042412001612042416395180");
		busBodyReqRefundQuery.setNotify_url("XXXXXXXXXXXXXXX");
		refundQuery.setBusBodyReqRefundQuery(busBodyReqRefundQuery);
		BusTransactionRspRefundQuery rsp = (BusTransactionRspRefundQuery) PaymentClient1
				.refundQuery(refundQuery);
		System.out.println(rsp.getBusBodyRspRefundQuery().getPay_info());
		System.out.println(rsp.getBusBodyRspRefundQuery().getRefund_ret_detail());
		System.exit(0);
	}

	public static void freeze() {
		BusTransactionReqFreeze freeze = new BusTransactionReqFreeze();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_FREEZE));
		h.setTransaction_id("114221");
		freeze.setBusHead(h);
		BusBodyReqFreeze body = new BusBodyReqFreeze();
		body.setFreeze_id("R1020150724000110787987522");
		body.setHft_trade_no("hft01120150804170414110787987522");
		body.setFreeze_account("ltfzfb03@126.com");
		body.setFreeze_amount("0.01");
//		body.setThird_pay_no("2012092001540086");
		freeze.setBusBodyReqFreeze(body);
		freeze.setBusHead(h);
		BusTransactionRspFreeze rsp = (BusTransactionRspFreeze) PaymentClient1
				.freeze(freeze);
		System.out.println(rsp.getBusBodyRspFreeze().getRet_code());
		System.out.println(rsp.getBusBodyRspFreeze().getPay_info());

	}

	public static void freezequery() {
		BusTransactionReqFreezeQuery freezeQuery = new BusTransactionReqFreezeQuery();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_FREEZE_QUERY));
//		h.setTrade_type(String.valueOf(PaymentConstants.TEMP_TRADE_TYPE_FREEZE_QUERY));
//		h.setTransaction_id("2088001425892773");
		h.setTransaction_id("114221");
		freezeQuery.setBusHead(h);
		BusBodyReqFreezeQuery body = new BusBodyReqFreezeQuery();
		body.setFreeze_id("R1020150724000110787987522");
		body.setOrder_no("1020150724000110787987522");
		body.setHft_trade_no("hft01120150804170414110787987522");
		body.setThird_pay_no("2015080400001000970063660194");
		freezeQuery.setBusBodyReqFreezeQuery(body);
		freezeQuery.setBusHead(h);
		BusTransactionRspFreezeQuery rsp = (BusTransactionRspFreezeQuery) PaymentClient1
				.freezeQuery(freezeQuery);
		System.out.println(rsp.getBusBodyRspFreezeQuery().getRet_code());
		System.out.println(rsp.getBusBodyRspFreezeQuery().getPay_info());
		System.out.println(rsp.getBusBodyRspFreezeQuery().getFreeze_details());
	}
	
	public static void FreezeOrUnfreeze(){
		BusTransactionReqFreezeQuery freezeQuery = new BusTransactionReqFreezeQuery();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TEMP_TRADE_TYPE_FREEZE_Or_Unfreeze));
		h.setTransaction_id("2088201994709221");
		freezeQuery.setBusHead(h);
		BusBodyReqFreezeQuery body = new BusBodyReqFreezeQuery();
		body.setOrder_no("102014040360066674");
		freezeQuery.setBusBodyReqFreezeQuery(body);
		freezeQuery.setBusHead(h);
		BusTransactionRspFreezeQuery rsp = (BusTransactionRspFreezeQuery) PaymentClient1
				.freezeOrUnfreezeQuery(freezeQuery);
		System.out.println(rsp.getBusBodyRspFreezeQuery().getRet_code());
		System.out.println(rsp.getBusBodyRspFreezeQuery().getPay_info());
		System.out.println(rsp.getBusBodyRspFreezeQuery().getFreeze_details());
		System.out.println(rsp.getBusBodyRspFreezeQuery().getUnfreeze_details());
		System.out.println(rsp.getBusBodyRspFreezeQuery().getFreeze_no());
		System.out.println(rsp.getBusBodyRspFreezeQuery().getUnfreeze_no());
	}

	public static void unfreeze() {
		BusTransactionReqUnfreeze unfreeze = new BusTransactionReqUnfreeze();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_UN_FREEZE));
//		h.setTrade_type(String.valueOf(PaymentConstants.TEMP_TRADE_TYPE_UN_FREEZE));
		h.setTransaction_id("114221");
		unfreeze.setBusHead(h);
		BusBodyReqUnfreeze body = new BusBodyReqUnfreeze();
		body.setUnfreeze_id("UR1020150724000110787987522");
		body.setFreeze_id("R1020150724000110787987522");
		body.setOrder_no("1020150724000110787987522");
		body.setHft_trade_no("hft01120150804170414110787987522");
//		body.setThird_pay_no("2013111974227966");
		body.setFreeze_account("ltfzfb03@126.com");
		body.setFreeze_amount("0.01");
		unfreeze.setBusBodyReqUnfreeze(body);
		unfreeze.setBusHead(h);
		BusTransactionRspUnfreeze rsp = (BusTransactionRspUnfreeze) PaymentClient1				.unfreeze(unfreeze);
		System.out.println(rsp.getBusBodyRspUnfreeze().getRet_code());
		System.out.println(rsp.getBusBodyRspUnfreeze().getPay_info());
	}
	
	public static void unfreezeQuery() {
		BusTransactionReqUnFreezeQuery unfreezeQuery = new BusTransactionReqUnFreezeQuery();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_UN_FREEZE_QUERY));
		h.setTransaction_id("114221");
		unfreezeQuery.setBusHead(h);
		BusBodyReqUnFreezeQuery body = new BusBodyReqUnFreezeQuery();
		body.setUnfreeze_id("UR1020150724000110787987522");
		body.setFreeze_id("R1020150724000110787987522");
		body.setOrder_no("1020150724000110787987522");
		body.setHft_trade_no("hft01120150804170414110787987522");
//		body.setThird_pay_no("2013102808520986");
		unfreezeQuery.setBusBodyReqUnFreezeQuery(body);
		unfreezeQuery.setBusHead(h);
		BusTransactionRspUnFreezeQuery rsp = (BusTransactionRspUnFreezeQuery) PaymentClient1.unFreezeQuery(unfreezeQuery);
		System.out.println(rsp.getBusBodyRspUnFreezeQuery().getRet_code());
		System.out.println(rsp.getBusBodyRspUnFreezeQuery().getPay_info());
	}

	public static void payCar() {
		BusTransactionReqCarPay pay = new BusTransactionReqCarPay();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_CAR_PAY));
		h.setTransaction_id("225512");
		pay.setBusHead(h);
		BusBodyReqCarPay body = new BusBodyReqCarPay();
		body.setOrder_no("102012111300000095");
		body.setSubject("test");
		body.setTotal_fee("5");
		body.setBiz_type("TRAVEL");
		body.setBatch_detail("张希吾世界巡游");
		body.setPayer_name("张希吾");// 操作人姓名
		body.setPayer_code_name("zxw");
		body.setTelephone("18612372034");
		body.setBank_type(PaymentConstants.TENPAY_BANK_CMB);// bank_code
		body.setBank_name("招商银行");// 银行名称
		body.setCard_type("CC");// DC借记卡 CC贷记卡
		body.setCard_no("4392260019258498");// 银行卡号
		body.setCert_type("A");
		body.setCert_no("321283198808220211");// 身份证号
		body.setReal_name("张希吾");
		body.setCard_mobile("18612372034");// 持卡人手机号
		body.setIt_b_pay("30m");
		body.setCard_validity("07/15");
		body.setNotify_url("http://www.51ebill.com");
		pay.setBusBodyReqCarPay(body);
		pay.setBusHead(h);
		BusTransactionRspPay rsp = (BusTransactionRspPay) PaymentClient1
				.carPay(pay);
		System.out.println(rsp.getBusBodyRspPay().getRet_des());
	}
	
	public static void payQuery() {
		BusTransactionReqPayQuery payQuery = new BusTransactionReqPayQuery();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_PAY_QUERY));
//		h.setTransaction_id("101773^101335^114221|101501");
		h.setTransaction_id("114221");
		BusBodyReqPayQuery busBodyReqPay = new BusBodyReqPayQuery();
		busBodyReqPay.setOrder_no("112016011172049592");
		payQuery.setBusBodyReqPayQuery(busBodyReqPay);
		payQuery.setBusHead(h);
		BusTransactionRspPayNotify rsp = (BusTransactionRspPayNotify) PaymentClient1
				.payQuery(payQuery);
		System.out.println(rsp.getBusBodyRspPay().getPay_info());
		System.out.println(rsp.getBusBodyRspPay().getRet_code());
		System.out.println(rsp.marshal());
	}

	public static void payQueryByDirectThirdPay() {
		BusTransactionReqPayQuery payQuery = new BusTransactionReqPayQuery();
		BusHead h = initBusHead();
		h.setTrade_type("1009");
//		h.setTransaction_id("101773^101335^114221|101501");
		h.setTransaction_id("101773");
		BusBodyReqPayQuery busBodyReqPay = new BusBodyReqPayQuery();
		busBodyReqPay.setOrder_no("102015110460122208");
		payQuery.setBusBodyReqPayQuery(busBodyReqPay);
		payQuery.setBusHead(h);
		BusTransactionRspPayNotify rsp = (BusTransactionRspPayNotify) PaymentClient1
				.payQuery(payQuery);
		System.out.println(rsp.getBusBodyRspPay().getPay_info());
		System.out.println(rsp.getBusBodyRspPay().getRet_code());
		System.out.println(rsp.marshal());
	}
	
	public static void alipayClearing() {
		BusTransactionReqClearing  query= new BusTransactionReqClearing();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TEMP_TRADE_TYPE_ALIPAY_Or_TenPay_Or_ChINAPNR_CLEARING));
		h.setTransaction_id("");
		BusBodyReqClearing busBodyReqPay = new BusBodyReqClearing();
		busBodyReqPay.setOut_bill_no("102013103060015943");
		query.setBodyReqClearing(busBodyReqPay);
		query.setBusHead(h);
		BusTransactionRspClearing rsp = (BusTransactionRspClearing) PaymentClient1
				.alipayClearing(query);
		System.out.println(rsp.getBodyRspClearing().getRet_code());
		System.out.println(rsp.getBodyRspClearing().getPay_info());
		System.out.println(rsp.getBodyRspClearing().getPay_details());
		System.out.println(rsp.getBodyRspClearing().getRoyalty_details());
		System.out.println(rsp.getBodyRspClearing().getRefund_royalty_details());
		System.out.println(rsp.getBodyRspClearing().getRefund_details());
		System.out.println(rsp.getBodyRspClearing().getFreeze_details());
		System.out.println(rsp.getBodyRspClearing().getUnfreeze_details());
	}
	
	public static void sign() {
		BusTransactionReqSign sign = new BusTransactionReqSign();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_SIGN));
		h.setTransaction_id("114221");
		BusBodyReqSign body = new BusBodyReqSign();
		sign.setBusHead(h);
		body.setSign_type("0");
		body.setAccount("account@liantuo.com");
		sign.setBusBodyReqSign(body);
		BusTransactionRspSign rsp = (BusTransactionRspSign) PaymentClient1
				.sign(sign);
		System.out.println(rsp.getBusBodyRspSign().getSign_url());
	}
	
	public static void attachTradeInfo(){
		BusTransactionReqAttachTradeInfo req = new BusTransactionReqAttachTradeInfo();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_ATTACH_TRADE_INFO));
		h.setTransaction_id("101773");
		BusBodyReqAttachTradeInfo body = new BusBodyReqAttachTradeInfo();
		body.setBatch_no("2012090316419381");
		body.setDetail_data("^102012090316419381^JXY91S^7812113346198^7812113346198");
		req.setBusBodyReqAttachTradeInfo(body);
		req.setBusHead(h);
		BusTransactionRspAttachTradeInfo rsp = (BusTransactionRspAttachTradeInfo)PaymentClient1.attachTradeInfo(req);
		System.out.println(rsp.getBusBodyRspArrachTradeInfo().getRet_code());
		System.out.println(rsp.getBusBodyRspArrachTradeInfo().getPay_info());
	}
	
	public static void balanceQuery(){
		BusTransactionReqBalanceQuery req = new BusTransactionReqBalanceQuery();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_BALANCE_QUERY));
		h.setTransaction_id("126694");
		BusBodyReqBalanceQuery body = new BusBodyReqBalanceQuery();
		body.setAccount("jiuzhouzhilv01@yahoo.cn");
//		body.setDate("20110927");
		req.setBusBodyReqBalanceQuery(body);
		req.setBusHead(h);
		BusTransactionRspBalanceQuery rsp = (BusTransactionRspBalanceQuery)PaymentClient1.balanceQuery(req);
		System.out.println(rsp);
	}
	
	public static void signQuery() {
		BusTransactionReqTrustQuery signQuery = new BusTransactionReqTrustQuery();
		BusHead h = initBusHead();
		h.setTransaction_id("114221");
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_TRUST_QUERY));
		BusBodyReqTrustQuery body = new BusBodyReqTrustQuery();
		body.setAccount("18611103801");
		body.setSign_type(PaymentConstants.SIGN_TYPE_WITHHOLD);
		signQuery.setBusBodyReqTrustQuery(body);
		signQuery.setBusHead(h);
		BusTransactionRspTrustQuery rsp = (BusTransactionRspTrustQuery) PaymentClient1
				.trustQuery(signQuery);
		System.out.println(rsp.getBusBodyRspTrustQuery().getRet_code());
	}
	
	
	/**
	 * 支付宝被扫支付
	 */
	public static void acquirepay() {
		BusTransactionReqPay pay = new BusTransactionReqPay();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_ACQUIRE_PAY));
		h.setTransaction_id("101773");
		pay.setBusHead(h);
		BusBodyReqPay body = new BusBodyReqPay();
//		body.setDescription("机票");
		body.setOrder_no("102015072240000199101");
		body.setSubject("测试");
		body.setPay_type("BARCODE");
		body.setTotal_fee("0.01");
		body.setSeller_account("frank@liantuo.com");
		body.setPayer_account("280383842043309341");
//		body.setRoyalty_detail("2088001425892773^2088001426547005^0.01^insurance|2088001425892773^2088001426547005^0.01^insurance");
		body.setPayer_code_name("hxx");
		body.setPayer_name("洪星星");
		body.setSpbill_create_ip("219.141.233.68");
		body.setNotify_url("www.baidu.com");
        body.setReturn_url("www.baidu.com");
		pay.setBusBodyReqPay(body);
		pay.setBusHead(h);
		BusTransactionRspPayNotify rsp = (BusTransactionRspPayNotify) PaymentClient1
				.payNoPwd(pay);
		System.out.println(rsp.getBusBodyRspPay().getPay_info());
	}
	
	/**
	 * 支付宝扫码支付
	 */
	public static void acquire_precreate() {
		BusTransactionReqPay pay = new BusTransactionReqPay();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_ACQUIRE_PRECREATE));
//		h.setTransaction_id("101773");
		h.setTransaction_id("101580");
		pay.setBusHead(h);
		BusBodyReqPay body = new BusBodyReqPay();
//		body.setDescription("机票");
		body.setOrder_no("102015072440000199112");
		body.setSubject("测试");
		body.setPay_type("QR_CODE");
		body.setTotal_fee("0.01");
//		body.setSeller_account("frank@liantuo.com");
		body.setSeller_account("account@liantuo.com");
//		body.setRoyalty_detail("2088001425892773^2088001426547005^0.01^insurance|2088001425892773^2088001426547005^0.01^insurance");
		body.setPayer_code_name("hxx");
		body.setPayer_name("洪星星");
		body.setSpbill_create_ip("219.141.233.68");
		body.setNotify_url("www.baidu.com");
        body.setReturn_url("www.baidu.com");
		pay.setBusBodyReqPay(body);
		pay.setBusHead(h);
		BusTransactionRspPay rsp = (BusTransactionRspPay) PaymentClient1
				.pay(pay);
		System.out.println(rsp.getBusBodyRspPay().getRet_des());
		System.out.println(rsp.marshal());
	}
	
	/**
	 * 支付宝扫码收单查询
	 */
	public static void  aquirepayQuery() {
		BusTransactionReqPayQuery payQuery = new BusTransactionReqPayQuery();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_ACQUIRE_QUERY));
//		h.setTransaction_id("101773^101335^114221|101501");
		h.setTransaction_id("101773");
		BusBodyReqPayQuery busBodyReqPay = new BusBodyReqPayQuery();
		busBodyReqPay.setOrder_no("102015040840000199101");
		payQuery.setBusBodyReqPayQuery(busBodyReqPay);
		payQuery.setBusHead(h);
		BusTransactionRspPayNotify rsp = (BusTransactionRspPayNotify) PaymentClient1
				.payQuery(payQuery);
		System.out.println(rsp.getBusBodyRspPay().getPay_info());
		System.out.println(rsp.getBusBodyRspPay().getRet_code());
		System.out.println(rsp.marshal());
	}
	
	/**
	 * 支付宝扫码收单撤销
	 */
	public static void  aquirepayCancle() {
		BusTransactionReqPayQuery payQuery = new BusTransactionReqPayQuery();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_ACQUIRE_CANCEL));
//		h.setTransaction_id("101580");
		h.setTransaction_id("101773");
		BusBodyReqPayQuery busBodyReqPay = new BusBodyReqPayQuery();
		busBodyReqPay.setOrder_no("102015072240000199101");
		payQuery.setBusBodyReqPayQuery(busBodyReqPay);
		payQuery.setBusHead(h);
		BusTransactionRspPayNotify rsp = (BusTransactionRspPayNotify) PaymentClient1
				.payReverse(payQuery);
		System.out.println(rsp.getBusBodyRspPay().getPay_info());
		System.out.println(rsp.getBusBodyRspPay().getRet_code());
		System.out.println(rsp.marshal());
	}
	
	/**
	 * 支付宝扫码收单关闭
	 */
	public static void  aquirepayClose() {
		BusTransactionReqPayQuery payQuery = new BusTransactionReqPayQuery();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_ACQUIRE_CLOSE));
		h.setTransaction_id("101773");
		BusBodyReqPayQuery busBodyReqPay = new BusBodyReqPayQuery();
		busBodyReqPay.setOrder_no("102015040840000199101");
		payQuery.setBusBodyReqPayQuery(busBodyReqPay);
		payQuery.setBusHead(h);
		BusTransactionRspPayNotify rsp = (BusTransactionRspPayNotify) PaymentClient1
				.payReverse(payQuery);
		System.out.println(rsp.getBusBodyRspPay().getPay_info());
		System.out.println(rsp.getBusBodyRspPay().getRet_code());
		System.out.println(rsp.marshal());
	}
	
	public static void aquirerefund() {
		BusTransactionReqRefund refund = new BusTransactionReqRefund();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_ACQUIRE_REFUND));
		h.setTransaction_id("101580");
		BusBodyReqRefund busBodyReqRefund = new BusBodyReqRefund();
		refund.setBusHead(h);
		busBodyReqRefund.setOrder_no("102015071314345745054");
		busBodyReqRefund.setHft_trade_no("hft10120150713113043314345745054");
		busBodyReqRefund.setRefund_batch_no("RE1020150713143457450545");
		// "0$ltjl^0|c^b^0.03" c给b退钱
		// "0$ltjl^0|liantuo.log@gmail.com,csx,hxx^cd9mzfb@163.com^0.03";
		// "0$liantuo.alipay@gmail.com,csx,陈寿星^cd9mzfb@163.com^0.02|liantuo_yf@163.com,csx,陈寿星^cd9mzfb@163.com^0.02";
		String detail = "0.01$";
		busBodyReqRefund.setRefund_detail(detail);
		busBodyReqRefund.setTotal_fee("0.01");
		refund.setBusBodyReqRefund(busBodyReqRefund);
		BusTransactionRspRefund rsp = (BusTransactionRspRefund) PaymentClient1
				.refund(refund);
		System.out.println(rsp.getBusBodyRspRefund().getRet_code());
		System.out.println(rsp.getBusBodyRspRefund().getPay_info());
	}

	public static void payThread() {
		for(int i = 0; i < 380; ++i){
			new Thread(new Runnable() {
				@Override
				public void run() {

					BusTransactionReqPay pay = new BusTransactionReqPay();
					BusHead h = initBusHead();
			//		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_WAP_PAY));
					h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_PAYMENT));
					h.setTransaction_id("101773");
					pay.setBusHead(h);
					BusBodyReqPay body = new BusBodyReqPay();
					body.setDescription("测试");
					//指定支付宝收银台默认支付方式
					body.setPay_type("1");
					body.setPay_type(Integer.valueOf(PaymentConstants.PAY_TYPE_THIRDCMP).toString());
					body.setPayer_account("liantuo.log@gmail.com");
					// 支付并分润时需要setRoyalty_detail
					// body.setRoyalty_detail("liantuo.alipay@gmail.com^0.04^insurance^insurance^1");
					body.setPayer_code_name("hxx");
					body.setPayer_name("洪星星");
					body.setSpbill_create_ip("219.141.233.68");
			//		body.setNeedValidatePayerInfo(false);
					body.setSubject("测试");
					body.setTotal_fee("0.01");
			//		body.setSeller_account("luohao0@yeah.net");
					body.setNotify_url("pay.51ebill.com");
					body.setReturn_url("pay.51ebill.com");
					pay.setBusBodyReqPay(body);
					pay.setBusHead(h);

					BusTransactionRspPay rsp;
					body.setOrder_no("102015051119" + new SimpleDateFormat("ssSSSS").format(Calendar.getInstance().getTime()));
					rsp = (BusTransactionRspPay) PaymentClient1.pay(pay);
					System.out.println(rsp.getBusBodyRspPay().getRet_code());
					System.out.println(rsp.getBusBodyRspPay().getRet_des());
					System.out.println(rsp.getBusBodyRspPay().getPay_url());
				}
			}).start();
		}
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String getrandom(){
		Random random = new Random();

		String result="";

		for(int i=0;i<6;i++){

		result+=random.nextInt(10);

		}
		return result;
//		System.out.print(result);
	}
	
	//商户解约测试
//	public static void unSign() {
//		BusTransactionReqUnSign sign = new BusTransactionReqUnSign();
//		BusHead h = initBusHead();
//		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_UN_SIGN));
//		h.setTransaction_id("114221");
//		BusBodyReqUnSign body = new BusBodyReqUnSign();
//		sign.setBusHead(h);
//		body.setAccount("18611103801");
//		sign.setBusBodyReqUnSign(body);
//		BusTransactionRspUnSign rsp = (BusTransactionRspUnSign) PaymentClient1
//				.unSign(sign);
//		System.out.println(rsp.getBusBodyRspUnSign().getRet_code());
//		System.out.println(rsp.getBusBodyRspUnSign().getPay_info());
//	}
//	
	public static void batchPayNoPwd() {
		BusTransactionReqPayBatch pay = new BusTransactionReqPayBatch();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_BATCH_PAY_NOPWD));
		h.setTransaction_id("136385");
		BusBodyReqPayBatch body = new BusBodyReqPayBatch();
		body.setPayer_account("zfbjk@liantuobank.com");//zfbjk@liantuobank.com
		body.setPayer_code_name("yndy");
		body.setPayer_name("合肥联拓金融信息服务有限公司北京分公司");
		body.setBatch_detail("001^ltftest02_zfb@126.com^合肥联拓金融信息服务有限公司^0.01^虚拟账户在线冲值批次号");
		body.setBatch_fee("0.01");
		body.setBatch_no("102016012524254541221455");
		body.setBatch_num("1");
		body.setNotify_url("http://192.133.125.22:8000/index.com");
		pay.setBusBodyReqPayBatch(body);
		pay.setBusHead(h);
		BusTransactionRspPay rsp = (BusTransactionRspPay) PaymentClient1
				.batchPay(pay);
		System.out.println(rsp.marshal());
		System.out.println(rsp.getBusBodyRspPay().getRet_code());

	}
	
	public static void main(String[] args) throws InterruptedException {
		 TestAlipay1.pay();
//		TestAlipay1.payThread();
//		 TestAlipay1.payQuery();
//		 TestAlipay1.payQueryByDirectThirdPay();
//		TestAlipay1.payDirect();
//		TestAlipay1.alipayClearing();
//		  TestAlipay1.refund();
//		 TestAlipay1.refundQuery();

//		 TestAlipay1.paySuppl();
//		 TestAlipay1.payNopwd();
//		 TestAlipay1.royalty();
//		 TestAlipay1.multiRoyalty();
//		 TestAlipay1.freeze();
//		 TestAlipay1.freezequery();
//		TestAlipay1.FreezeOrUnfreeze();
//		 TestAlipay1.unfreeze();
//		 TestAlipay1.payCar();
//		 TestAlipay1.sign();
//		TestAlipay1.unSign();
//		 TestAlipay1.signQuery();
		// TestAlipay1.refundPwd();
		// TestAlipay1.attachTradeInfo();
//		 TestAlipay1.balanceQuery();
//		 TestAlipay1.unfreezeQuery();
//		 TestAlipay1.batchPay();
		 TestAlipay1.payBatchQuery();//批付查询
//		TestAlipay1.batchPayNoPwd();
		 
//		 TestAlipay1.acquirepay();
//		TestAlipay1.acquire_precreate();
//		 TestAlipay1.aquirepayQuery();
//		TestAlipay1.aquirepayCancle();
//		TestAlipay1.aquirepayClose();
//		 TestAlipay1.aquirerefund();
		 
		 System.exit(0);
	}
}
