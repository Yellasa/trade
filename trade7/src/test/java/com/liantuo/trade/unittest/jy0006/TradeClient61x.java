package com.liantuo.trade.unittest.jy0006;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.liantuo.payment.client.pay.alipay.base.GoodsDetail;
import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.single_payment.InnerQueryPage4SinlePaymentDetail;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalPayment;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalQuePayment;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalSynPayment;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyInnerPayment;
import com.liantuo.trade.client.trade.packet.body.zf.AliPaymentAttachment;
import com.liantuo.trade.client.trade.packet.body.zf.Extend_params;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.validate.TradeValidationUtil;

public class TradeClient61x {


	/**
	 * 0006_001_001：V1.0   内部支付
	 * @throws Exception
	 * 
	 */
	@Test
	public void test0006001001() throws Exception{
		TradeRequest<TradePacketReqBodyInnerPayment> bizReq = new TradeRequest<TradePacketReqBodyInnerPayment>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyInnerPayment body = new TradePacketReqBodyInnerPayment();
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setPartner_id("12345678912345650");
		//核心商户编号	来自输入
		head.setCore_merchant_no("CC_C3878185775");
		//资金池编号	来自输入
		head.setFund_pool_no("PN01000000000010429");
		//交易客户保留字段1	来自输入
		body.setMerchant_extend_field_1("merchant_extend_field_1-001");
		//交易客户保留字段2	来自输入
		body.setMerchant_extend_field_2("Merchant_extend_field_2-001");
		//交易客户保留字段3	来自输入
		body.setMerchant_extend_field_3("Merchant_extend_field_3-001");
		//交易客户保留字段4	来自输入
		body.setMerchant_extend_field_4("Merchant_extend_field_4-001");
		//交易客户保留字段5	来自输入
		body.setMerchant_extend_field_5("Merchant_extend_field_5-001");
		//交易发起方发起请求编号	来自输入
		body.setOut_trade_no_ext("");
		//交易发起方业务系统订单号	来自输入
		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		head.setRequest_code("0006_001_001");
		head.setVersion("1.0");
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("1");
		//当付款方式为：2,3时，需要有值
//		body.setPay_profit_loss_income_decr("1234567891234.12");
//		body.setPay_profit_loss_cost_incr("1234567891234.12");
		//付款方账户账户编号   当付款方式为：1,3时，需要有值
		body.setPay_account_no("CA21000000060621");
		body.setPay_account_out_accounting_amt("100");
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("");
//		body.setReceive_profit_loss_cost_decr("");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("100");
		body.setReceive_account_in_accounting_type("1");
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setMerchant_extend_field_1("OtherPofitLossMerchant_extend_field_1");
		profit.setIncome_incr("2");
		List<TradePacketReqBodyOtherPofitLossLedger> profit_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
		profit_list.add(profit);
		body.setProfit_loss_list(profit_list);
		
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
	/**
	 * 0006_001_002：V1.0   内部支付
	 * @throws Exception
	 * 
	 */
	@Test
	public void test0006001002() throws Exception{
		TradeRequest<TradePacketReqBodyExternalPayment> bizReq = new TradeRequest<TradePacketReqBodyExternalPayment>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyExternalPayment body = new TradePacketReqBodyExternalPayment();
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setRequest_code("0006_001_002");
		head.setVersion("1.0");
		
		head.setPartner_id("12345678912345650");
		//核心商户编号	来自输入
		head.setCore_merchant_no("CC_C3878185775");
		//资金池编号	来自输入
		head.setFund_pool_no("PN01000000000010429");
		
//		//交易客户保留字段1	来自输入
//		body.setMerchant_extend_field_1("merchant_extend_field_1-001");
//		//交易客户保留字段2	来自输入
//		body.setMerchant_extend_field_2("Merchant_extend_field_2-001");
//		//交易客户保留字段3	来自输入
//		body.setMerchant_extend_field_3("Merchant_extend_field_3-001");
//		//交易客户保留字段4	来自输入
//		body.setMerchant_extend_field_4("Merchant_extend_field_4-001");
//		//交易客户保留字段5	来自输入
//		body.setMerchant_extend_field_5("Merchant_extend_field_5-001");
		//交易发起方发起请求编号	来自输入
		body.setOut_trade_no_ext("20160612105361");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("5");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("200");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
		//付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
		body.setPay_account_out_accounting_amt("200");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("99");
//		body.setReceive_profit_loss_cost_decr("");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("200");
		body.setReceive_account_in_accounting_type("1");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088177");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setIncome_incr("2");
		List<TradePacketReqBodyOtherPofitLossLedger> profit_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
		profit_list.add(profit);
		body.setProfit_loss_list(profit_list);
		
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
	@Test
	public void testValidate(){
		TradeRequest<TradePacketReqBodyInnerPayment> bizReq = new TradeRequest<TradePacketReqBodyInnerPayment>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyInnerPayment body = new TradePacketReqBodyInnerPayment();
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
//		head.setPartner_id("12345678912345650");
		//核心商户编号	来自输入
		head.setCore_merchant_no("CC_C3878185775");
		//资金池编号	来自输入
		head.setFund_pool_no("PN01000000000010429");
		//交易客户保留字段1	来自输入
		body.setMerchant_extend_field_1("merchant_extend_field_1-001");
		//交易客户保留字段2	来自输入
		body.setMerchant_extend_field_2("Merchant_extend_field_2-001");
		//交易客户保留字段3	来自输入
		body.setMerchant_extend_field_3("Merchant_extend_field_3-001");
		//交易客户保留字段4	来自输入
		body.setMerchant_extend_field_4("Merchant_extend_field_4-001");
		//交易客户保留字段5	来自输入
		body.setMerchant_extend_field_5("Merchant_extend_field_5-001");
		//交易发起方发起请求编号	来自输入
		body.setOut_trade_no_ext("20160612105372");
		//交易发起方业务系统订单号	来自输入
		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		head.setRequest_code("0006_001_001");
		head.setVersion("1.0");
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("1");
		//当付款方式为：2,3时，需要有值
//		body.setPay_profit_loss_income_decr("1234567891234.12");
		body.setPay_profit_loss_cost_incr("1234567891234.12");
		//付款方账户账户编号   当付款方式为：1,3时，需要有值
		body.setPay_account_no("CA21000000060621");
		body.setPay_account_out_accounting_amt("100");
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("2");
		//收款方式为损益时，需有值
		body.setReceive_profit_loss_income_incr("12");
//		body.setReceive_profit_loss_cost_decr("123");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("100");
		body.setReceive_account_in_accounting_type("1");
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setMerchant_extend_field_1("OtherPofitLossMerchant_extend_field_1");
//		profit.setIncome_incr("2");
		profit.setIncome_decr("2s");
		List<TradePacketReqBodyOtherPofitLossLedger> profit_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
		profit_list.add(profit);
		body.setProfit_loss_list(profit_list);
		
		bizReq.setHead(head);
		bizReq.setBody(body);
		
		System.out.println(TradeValidationUtil.validateRequestWeak(bizReq));
		
	}
	
	@Test
	public void testValidate2(){
//		TradePacketReqBodyInnerPayment body = new TradePacketReqBodyInnerPayment();
//		body.setReceive_type("1");
//		body.setReceive_account_in_accounting_type("1");
//		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
//		Set<ConstraintViolation<TradePacketReqBodyInnerPayment>> set = vf.getValidator().validateProperty(body, "receive_account_in_accounting_type", WeakRequired.class);
//		 for (Iterator<ConstraintViolation<TradePacketReqBodyInnerPayment>> iterator = set.iterator(); iterator.hasNext(); ) {
//             ConstraintViolation<?> constraintViolation = iterator.next();
//             System.out.println(constraintViolation.getMessage());
//         }
		System.out.println("".matches("[\\da-zA-Z_]{6,32}"));
	}
	
	
	@Test
	public void test0006001006() throws Exception{
		TradeRequest<TradePacketReqBodyExternalSynPayment> bizReq = new TradeRequest<TradePacketReqBodyExternalSynPayment>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyExternalSynPayment body = new TradePacketReqBodyExternalSynPayment();
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setPartner_id("16070615445815544");
		//核心商户编号	来自输入
		head.setCore_merchant_no("EW_N5496622881");
		//资金池编号	来自输入
		head.setFund_pool_no("PN02000000000003860");
		head.setRequest_code("0006_001_006");
		head.setVersion("1.0");
		bizReq.setHead(head);
		//交易客户保留字段1	来自输入
		body.setMerchant_extend_field_1("merchant_extend_field_1-001");
		//交易客户保留字段2	来自输入
		body.setMerchant_extend_field_2("Merchant_extend_field_2-001");
		//交易客户保留字段3	来自输入
		body.setMerchant_extend_field_3("Merchant_extend_field_3-001");
		//交易客户保留字段4	来自输入
		body.setMerchant_extend_field_4("Merchant_extend_field_4-001");
		//交易客户保留字段5	来自输入
		body.setMerchant_extend_field_5("Merchant_extend_field_5-001");
		body.setOut_trade_no_ext("20160712091200abc148");
		body.setPay_type("5");//第三方充付
		
		body.setPay_account_no("CA31000000000660");
		body.setPay_account_out_accounting_amt("0.01");
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA31000000000661");
		body.setPay_fee_account_out_accounting_amt("0.01");
		
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("");
//		body.setReceive_profit_loss_cost_decr("");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA31000000000663");
		body.setReceive_account_in_accounting_amt("0.02");
		body.setReceive_account_in_accounting_type("1");
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA31000000000662");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("0.01");
		
		//其他损益列表
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setMerchant_extend_field_1("OtherPofitLossMerchant_extend_field_1");
		profit.setIncome_incr("0.01");
		List<TradePacketReqBodyOtherPofitLossLedger> profit_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
		profit_list.add(profit);
		body.setProfit_loss_list(profit_list);
		
		//支付中心标准输入
//		tce.setPay_channel("ZF0001_02_001");//支付渠道编号:支付宝支付
//		tce.setPay_channel("ZF0003_01_001");//支付渠道编号:微信刷卡支付
		
		body.setMerchant_extend_field_1("body_merchant_extend_field_1");//业务台账客户保留字段
		body.setTotal_amount("1");
		body.setBody("商品描述");
		body.setSubject("商品标题");
		
		//微信刷卡支付
//		WxAttachment wxa = new WxAttachment();
//		wxa.setAuth_code("130176519952650413");//授权码
//		wxa.setSpbill_create_ip("219.141.233.68");//终端IP
//		body.setOther_attachment_group_json(ObjectJsonUtil.object2String(wxa));
//		body.setPay_transaction_id("000000000000021");//支付渠道身份编号
		
		//支付宝支付
		AliPaymentAttachment ac = new AliPaymentAttachment();
		ac.setScene("bar_code");
		ac.setAuth_code("289407546358155362");
		ac.setSeller_id("2088101568353491");
		ac.setTimeout_express("100m");
		body.setPay_transaction_id("000000000000109");//支付渠道身份编号
		// 商品明细列表，需填写购买商品详细信息，
		List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
		// 创建商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
		GoodsDetail goods1 = new GoodsDetail();
		goods1.setGoods_id("goods_id001");
		goods1.setGoods_name("产品01");
		goods1.setPrice("0.03");
		goods1.setQuantity("1");
		goodsDetailList.add(goods1);
		GoodsDetail goods2 = new GoodsDetail();
		goods2.setGoods_id("goods_id002");
		goods2.setGoods_name("产品02");
		goods2.setPrice("0.03");
		goods2.setQuantity("1");
		goodsDetailList.add(goods2);
		ac.setGoods_detail(ObjectJsonUtil.object2String(goodsDetailList));
		
		//扩展字段列表
		Extend_params  params = new Extend_params();
		params.setSys_service_provider_id("extend_params_service_provider_id");
		ac.setExtend_params(params);
		body.setOther_attachment_group_json(ObjectJsonUtil.object2String(ac));
//		body.setTradeCommonEntry(body);
		
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
		System.out.println(response.marshal());
		
	}
	
	 
	@Test
	public void test0006001009(){
		TradeRequest<TradePacketReqBodyExternalQuePayment> bizReq = new TradeRequest<TradePacketReqBodyExternalQuePayment>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyExternalQuePayment body = new TradePacketReqBodyExternalQuePayment();
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setPartner_id("16070615445815544");
		//核心商户编号	来自输入
		head.setCore_merchant_no("EW_N5496622881");//EW_N5496622881
		//资金池编号	来自输入
		head.setFund_pool_no("PN01000000000010876");//  PN02000000000003860
		head.setRequest_code("0006_001_009");
		head.setVersion("1.0");
		bizReq.setHead(head);
//		body.setTrade_no("00060011607151052045010000011800");
		body.setOut_trade_no_ext("oroe20167189020");
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
		
	}
	
	@Test
	public void test006001999(){
	        TradeRequest<InnerQueryPage4SinlePaymentDetail> request = new TradeRequest<InnerQueryPage4SinlePaymentDetail>();
	        InnerQueryPage4SinlePaymentDetail body = new InnerQueryPage4SinlePaymentDetail();
			TradePacketHead head = new TradePacketHead();
			head.setPartner_id("10000002057141223");
			head.setCore_merchant_no("CC_C8785258588");
			head.setFund_pool_no("PN01000000000010876");
			head.setRequest_time("2016-02-24 19:21:55");
			head.setRequest_code("0003_001_999");
			head.setVersion("1.0");
			head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
			
	//		body.setOut_trade_no("12345678920160405051");
	//		body.setPayment_account_no("CA12050317300000");
	//		body.setOut_trade_no_ext("df201635972353959002741");
			
			body.setStatus("01");
			body.setGmt_created_start("2016-04-05 18:19:50");
			body.setGmt_created_end("2016-07-15 18:19:52");
			body.setPage("3");
			body.setPage_size("3");
			request.setBody(body);
			request.setHead(head);
			
		
	}
	
//	public static void main(String[] args) throws Exception {
//		 ObjectJsonUtil.string2Object(null,WxAttachment.class);
//	}

}
