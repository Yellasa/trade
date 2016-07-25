package com.liantuo.trade.unittest.jy0006;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.TradePacketReqBodyInnerRefund;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.TradePacketReqBodyOuterRefund;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

public class TradeClient622 {
	@Test
	public void test() throws InterruptedException {
		TradeRequest<TradePacketReqBodyOuterRefund> bizReq = new TradeRequest<TradePacketReqBodyOuterRefund>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyOuterRefund body = new TradePacketReqBodyOuterRefund();
		init(head, body);
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	private void init(TradePacketHead head, TradePacketReqBodyOuterRefund body) {
		head.setCore_merchant_no("CC_C3878185775");
		head.setFund_pool_no("PN01000000000010429");
		head.setRequest_code("0006_002_002");
		head.setVersion("1.0");
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setPartner_id("12345678912345650");
		/*
		 * "id":25, "partnerId":"12345678912345650",
		 * "tradeNo":"00060011606141258414070000002000",
		 * "coreMerchantNo":"CC_C3878185775",
		 * "fundPoolNo":"PN01000000000010429",
		 */
		body.setOriginal_trade_no("00060011606161152041860000003900");
		
		/**
		 * 参数名：交易客户保留字段1</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_1 format error", regexp =
		// ".{0,64}", groups = Format.class)
		body.setMerchant_extend_field_1("merchant_extend_field_1");

		/**
		 * 参数名：交易客户保留字段2</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_2 format error", regexp =
		// ".{0,64}", groups = Format.class)
		body.setMerchant_extend_field_2("merchant_extend_field_2");

		/**
		 * 参数名：交易客户保留字段3</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_3 format error", regexp =
		// ".{0,64}", groups = Format.class)
		body.setMerchant_extend_field_3("merchant_extend_field_3");

		/**
		 * 参数名：交易客户保留字段4</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_4 format error", regexp =
		// ".{0,128}", groups = Format.class)
		body.setMerchant_extend_field_4("merchant_extend_field_4");

		/**
		 * 参数名：交易客户保留字段5</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_5 format error", regexp =
		// ".{0,128}", groups = Format.class)
		body.setMerchant_extend_field_5("merchant_extend_field_5");

		/**
		 * 参数名：交易客户保留字段6</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_6 format error", regexp =
		// ".{0,256}", groups = Format.class)
		body.setMerchant_extend_field_6("merchant_extend_field_6");

		/**
		 * 参数名：交易客户保留字段7</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_7 format error", regexp =
		// ".{0,256}", groups = Format.class)
		body.setMerchant_extend_field_7("merchant_extend_field_7");

		/**
		 * 参数名：交易客户保留字段8</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_8 format error", regexp =
		// ".{0,256}", groups = Format.class)
		body.setMerchant_extend_field_8("merchant_extend_field_8");

		/**
		 * 参数名：交易客户保留字段9</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_9 format error", regexp =
		// ".{0,256}", groups = Format.class)
		body.setMerchant_extend_field_9("merchant_extend_field_9");

		/**
		 * 参数名：交易客户保留字段10</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_10 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setMerchant_extend_field_10("merchant_extend_field_10");

		/**
		 * 参数名：交易发起方发起请求编号</br> 参数类型：必填</br>
		 */
		// NotBlank(message = "out_trade_no_ext is required", groups =
		// {Required.class})
		// Pattern(message = "out_trade_no_ext format error", regexp =
		// "[\\da-zA-Z_]{8,64}", groups = Format.class)
		body.setOut_trade_no_ext("a201611111a_as11111as" + new Random().nextInt(1000));

		/**
		 * 参数名：交易发起方业务系统订单号</br> 参数类型：可空</br>
		 */
		// Pattern(message = "out_trade_no format error", regexp =
		// ".{0}|[\\da-zA-Z_]{8,64}", groups = Format.class)
		body.setOut_trade_no("20161222222222222" + new Random().nextInt(1000));

		// Pattern(message =
		// "external_refund_merchant_extend_field_1 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_merchant_extend_field_1("external_refund_merchant_extend_field_1");

		// Pattern(message =
		// "external_refund_merchant_extend_field_2 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_merchant_extend_field_2("external_refund_merchant_extend_field_2");

		// Pattern(message =
		// "external_refund_merchant_extend_field_3 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_merchant_extend_field_3("external_refund_merchant_extend_field_3");

		// Pattern(message = "external_refund_channel format error", regexp =
		// ".{0,6}", groups = Format.class)
		body.setExternal_refund_channel("0123456789123456");

		// DecimalMin(message =
		// "external_refund_pay_channel_fee_amt format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "external_refund_pay_channel_fee_amt format error",
		// groups = {Format.class}, integer =
		// TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		body.setExternal_refund_pay_channel_fee_amt("0.01");

		// DecimalMin(message = "external_refund_channel_fee_amt format error",
		// groups = {Format.class}, value = "0.01")
		// Digits(message = "external_refund_channel_fee_amt format error",
		// groups = {Format.class}, integer =
		// TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		body.setExternal_refund_channel_fee_amt("0.01");

		// Pattern(message = "external_refund_channel_attr_3 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_3("external_refund_channel_attr_3");

		// Pattern(message = "external_refund_channel_attr_4 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_4("external_refund_channel_attr_4");

		// Pattern(message = "external_refund_channel_attr_5 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_5("external_refund_channel_attr_5");

		// Pattern(message = "external_refund_channel_attr_6 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_6("external_refund_channel_attr_6");

		// Pattern(message =
		// "external_refund_channel_transaction_id format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_transaction_id("transaction_id_2016");

		// Pattern(message =
		// "external_refund_channel_pay_account_no format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_pay_account_no("1234567890");

		// Pattern(message =
		// "external_refund_channel_pay_account_name format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_pay_account_name("external_refund_channel_pay_account_name");

		// Pattern(message = "external_refund_channel_batch_no format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_batch_no("external_refund_channel_batch_no");

		// Pattern(message = "external_refund_channel_serial_no format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_serial_no("external_refund_channel_serial_no");

		// Pattern(message =
		// "external_refund_channel_receive_account_no format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_receive_account_no("external_refund_channel_receive_account_no");

		// Pattern(message =
		// "external_refund_channel_recieve_account_name format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_recieve_account_name("external_refund_channel_recieve_account_name");

		// Pattern(message = "external_refund_channel_field_8 format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_field_8("external_refund_channel_field_8");

		// Pattern(message = "external_refund_channel_field_9 format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_field_9("external_refund_channel_field_9");

		// Pattern(message = "external_refund_channel_field_10 format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_field_10("external_refund_channel_field_10");

		// DateTime(message = "gmt_external_refund_channel_clear format error",
		// groups = Format.class)
		body.setGmt_external_refund_channel_clear("2016-06-14 17:42:27");

		// DateTime(message = "gmt_external_refund_accouting format error",
		// groups = Format.class)
		body.setGmt_external_refund_accouting("2016-06-14 17:42:27");

		// Pattern(message = "external_refund_channel_field_13 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_field_13("external_refund_channel_field_13");

		// Pattern(message = "external_refund_channel_field_14 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_field_14("external_refund_channel_field_14");

		// Pattern(message = "external_refund_channel_field_15 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_field_15("external_refund_channel_field_15");

		// NotBlank(message = "external_refund_amt is required", groups =
		// {Required.class})
		// DecimalMin(message = "external_refund_amt format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "external_refund_amt format error", groups =
		// {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH,
		// fraction = 2)
		body.setExternal_refund_amt("0.09");

		// DecimalMin(message =
		// "refund_pay_account_in_accounting_amt format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "refund_pay_account_in_accounting_amt format error",
		// groups = {Format.class}, integer =
		// TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		body.setRefund_pay_account_in_accounting_amt("0.1");

		// Pattern(message =
		// "refund_pay_account_out_accounting_his1 format error", regexp =
		// ".{0,16}", groups = Format.class)
		body.setRefund_pay_account_out_accounting_his1("payouthis1");

		// Pattern(message =
		// "refund_pay_account_out_accounting_his2 format error", regexp =
		// ".{0,16}", groups = Format.class)
		body.setRefund_pay_account_out_accounting_his2("payouthis2");

		// Pattern(message =
		// "refund_pay_account_out_accounting_his3 format error", regexp =
		// ".{0,512}", groups = Format.class)
		body.setRefund_pay_account_out_accounting_his3("payouthis3");
		// Pattern(message =
		// "refund_pay_account_in_accounting_his1 format error", regexp =
		// ".{0,16}", groups = Format.class)
		body.setRefund_pay_account_in_accounting_his1("payinhis1");

		// Pattern(message =
		// "refund_pay_account_in_accounting_his2 format error", regexp =
		// ".{0,16}", groups = Format.class)
		body.setRefund_pay_account_in_accounting_his2("payinhis2");

		// Pattern(message =
		// "refund_pay_account_in_accounting_his3 format error", regexp =
		// ".{0,512}", groups = Format.class)
		body.setRefund_pay_account_in_accounting_his3("payinhis3");

		// DecimalMin(message =
		// "refund_pay_fee_account_in_accounting_amt format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message =
		// "refund_pay_fee_account_in_accounting_amt format error", groups =
		// {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH,
		// fraction = 2)
		body.setRefund_pay_fee_account_in_accounting_amt("0.01");

		// Pattern(message =
		// "refund_pay_fee_account_in_accounting_his1 format error", regexp =
		// ".{0,16}", groups = Format.class)
		body.setRefund_pay_fee_account_in_accounting_his1("payfeeouthis1");

		// Pattern(message =
		// "refund_pay_fee_account_in_accounting_his2 format error", regexp =
		// ".{0,16}", groups = Format.class)
		body.setRefund_pay_fee_account_in_accounting_his2("payfeeouthis2");

		// Pattern(message =
		// "refund_pay_fee_account_in_accounting_his3 format error", regexp =
		// ".{0,512}", groups = Format.class)
		body.setRefund_pay_fee_account_in_accounting_his3("payfeeouthis3");

		// DecimalMin(message =
		// "refund_receive_fee_account_in_accounting_amt format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message =
		// "refund_receive_fee_account_in_accounting_amt format error", groups =
		// {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH,
		// fraction = 2)
		body.setRefund_receive_fee_account_in_accounting_amt("0.01");

		// Pattern(message =
		// "refund_receive_fee_account_in_accounting_his1 format error", regexp
		// = ".{0,16}", groups = Format.class)
		body.setRefund_receive_fee_account_in_accounting_his1("rfinhis1");

		// Pattern(message =
		// "refund_receive_fee_account_in_accounting_his2 format error", regexp
		// = ".{0,16}", groups = Format.class)
		body.setRefund_receive_fee_account_in_accounting_his2("rfinhis2");

		// Pattern(message =
		// "refund_receive_fee_account_in_accounting_his3 format error", regexp
		// = ".{0,512}", groups = Format.class)
		body.setRefund_receive_fee_account_in_accounting_his3("rfinhis3");

		// NotBlank(message = "refund_receive_amt is required", groups =
		// {Required.class})
		// DecimalMin(message = "refund_receive_amt format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "refund_receive_amt format error", groups =
		// {Format.class}, integer = TradeConstants.DIGIT_AMOUNT_LENGTH,
		// fraction = 2)
		body.setRefund_receive_amt("0.1");

		// Pattern(message =
		// "refund_receive_profit_loss_extend_field_1 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setRefund_receive_profit_loss_extend_field_1("receive_profit_loss_extend_field_1");

		// Pattern(message =
		// "refund_receive_profit_loss_extend_field_2 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setRefund_receive_profit_loss_extend_field_2("receive_profit_loss_extend_field_2");

		// Pattern(message =
		// "refund_receive_profit_loss_extend_field_3 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setRefund_receive_profit_loss_extend_field_3("receive_profit_loss_extend_field_3");

		// Pattern(message =
		// "refund_receive_account_out_accounting_his1 format error", regexp =
		// ".{0,16}", groups = Format.class)
		body.setRefund_receive_account_out_accounting_his1("rfouthis1");

		// Pattern(message =
		// "refund_receive_account_out_accounting_his2 format error", regexp =
		// ".{0,16}", groups = Format.class)
		body.setRefund_receive_account_out_accounting_his2("rfouthis2");

		// Pattern(message =
		// "refund_receive_account_out_accounting_his3 format error", regexp =
		// ".{0,512}", groups = Format.class)
		body.setRefund_receive_account_out_accounting_his3("rfouthis3");

		// Valid
		initProfitLossList(body);
	}

	private void initProfitLossList(TradePacketReqBodyOuterRefund body) {
		List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
		TradePacketReqBodyOtherPofitLossLedger ledger = new TradePacketReqBodyOtherPofitLossLedger();
		/*
		 * 以下4个金额有且只有1个金额存在 有且有且只能有一个金额存在
		 */

		// DecimalMin(message = "income_incr format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "income_incr format error", groups = {Format.class},
		// integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		// ledger.setIncome_incr("0.1");

		// DecimalMin(message = "income_decr format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "income_decr format error", groups = {Format.class},
		// integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		ledger.setIncome_decr("0.02");

		// DecimalMin(message = "cost_incr format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "cost_incr format error", groups = {Format.class},
		// integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		// ledger.setCost_incr("");

		// DecimalMin(message = "cost_decr format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "cost_decr format error", groups = {Format.class},
		// integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		// ledger.setCost_decr(costDecr);
		setOtherAtt(ledger);
		profit_loss_list.add(ledger);
		body.setProfit_loss_list(profit_loss_list);
	}

	private void setOtherAtt(TradePacketReqBodyOtherPofitLossLedger ledger) {
		/**
		 * 参数名：交易客户保留字段1</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_1 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		ledger.setMerchant_extend_field_1("merchantExtendField_1");

		/**
		 * 参数名：交易客户保留字段2</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_2 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		ledger.setMerchant_extend_field_2("merchantExtendField_2");

		/**
		 * 参数名：交易客户保留字段3</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_3 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		ledger.setMerchant_extend_field_3("merchantExtendField_3");

		// Pattern(message = "profit_loss_attr_1 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_1("profitLossAttr_1");

		// Pattern(message = "profit_loss_attr_2 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_2("profitLossAttr_2");

		// Pattern(message = "profit_loss_attr_3 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_3("profitLossAttr_3");

		// Pattern(message = "profit_loss_attr_4 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_4("profitLossAttr_4");

		// Pattern(message = "profit_loss_attr_5 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_5("profitLossAttr_5");

		// Pattern(message = "profit_loss_attr_6 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_6("profitLossAttr_6");

		// Pattern(message = "profit_loss_attr_7 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_7("profitLossAttr_7");

		// Pattern(message = "profit_loss_attr_8 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_8("profitLossAttr_8");

		// Pattern(message = "profit_loss_attr_9 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_9("profitLossAttr_9");

		// Pattern(message = "profit_loss_attr_10 format error", regexp =
		// ".{0,128}", groups = Format.class)
		ledger.setProfit_loss_attr_10("profitLossAttr_10");
	}
	@Test
	public  void  testCase(){
		List<String> list = new ArrayList<String>();
		//直退--直充--账户收--无手续费 部分退回 Ok
		String case1_1 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004901,out6002002001,5,-,-,-,5";
		//直退--直充--账户收--无手续费 部分退回 Ok
		String case1_2 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004901,out6002002001,3,-,-,-,3";
		//直退--直充--账户收--无手续费 部分退回 Ok
		String case1_3 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004901,out6002002001,2,-,-,-,2";
		//直退--直充--账户收--无手续费 全部退回后，在退回 NG 
		String case1_4 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004901,out6002002001,2,-,-,-,2";
//		list.add(case1_1);
//		list.add(case1_2);
//		list.add(case1_3);
//		list.add(case1_4);
		
		//直退--直充--账户收--账户不同，收款可用，收费可用
		String case2_1 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004902,out6002002002,5,-,0.5,0.5,5,-,1";
		String case2_2 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004902,out6002002002,3,-,0.5,0.5,3,-,1";
		String case2_3 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004902,out6002002002,2,-,-,-,2,-,-";
		String case2_4 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004902,out6002002002,2,-,-,-,2,-,-";
//		list.add(case2_1);//00060021606171126253400000006203
//		list.add(case2_2);//00060021606171126253400000006204
//		list.add(case2_3);//00060021606171126253400000006205
//		list.add(case2_4);//累计退款金额校验不通过
		
		
		//直退--直充--账户收--账户不同，收款冻结，收费可用
		String case3_1 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004903,out6002002003,5,-,0.5,0.5,5,-,1";
		String case3_2 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004903,out6002002003,3,-,0.5,0.5,3,-,1";
		String case3_3 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004903,out6002002003,2,-,-,-,2,-,-";
		String case3_4 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004903,out6002002003,10,-,1,1,10,-,2";
//		list.add(case3_1);//00060021606171126253400000006207
//		list.add(case3_2);//00060021606171126253400000006208
//		list.add(case3_3);//00060021606171126253400000006206
//		list.add(case3_4);//累计退款金额校验不通过
		
		//直退--直充--账户收--账户相同，收款可用，收费可用
		String case4_1 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004904,out6002002004,10,-,1,1,10,-,2";
		String case4_2 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004904,out6002002004,10,-,1,1,10,-,2";

//		list.add(case4_1);//00060021606171126253400000006209
//		list.add(case4_2);//累计退款金额校验不通过
		
		//直退--直充--账户收--账户相同，收款冻结，收费可用
		String case5_1 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004905,out6002002005,10,-,1,1,10,-,2";
		String case5_2 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004905,out6002002005,10,-,1,1,10,-,2";
//		list.add(case5_1);//00060021606171126253400000006210
//		list.add(case5_2);//累计退款金额校验不通过
		
		
		//直退--直充--账户收--账户相同，收款冻结，收费冻结
		String case6_1 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004906,out6002002006,10,-,1,1,10,-,2";
		String case6_2 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004906,out6002002006,10,-,1,1,10,-,2";
//		list.add(case6_1);//00060021606171126253400000006211
//		list.add(case6_2);//累计退款金额校验不通过
		
		//直退--直充--损益收--
		String case7_1 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004907,out6002002007,5,-,0.5,0.5,5,-,1";
		String case7_2 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004907,out6002002007,5,-,0.5,0.5,5,-,1";
		String case7_3 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004907,out6002002007,10,-,0.5,0.5,-,-,-";
//		list.add(case7_1);//00060021606171126253400000006212
//		list.add(case7_2);//00060021606171126253400000006213
//		list.add(case7_3);//累计退款金额校验不通过
		
		
		//直退--直充--损益收--
		String case8_1 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004909,out6002002008,10,-,0.5,0.5,10,-,1";
		String case8_2 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004909,out6002002008,10,-,0.5,0.5,10,-,1";
//		list.add(case8_1);//00060021606171126253400000006214
//		list.add(case8_2);//累计退款金额校验不通过
		
		//充退--充付--账户收--账户不同，收款可用，收费可用
		String case9_1 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004910,out6002002009,5,5,0.5,0.5,5,-,1";
		String case9_2 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004910,out6002002009,3,3,0.5,0.5,3,-,1";
		String case9_3 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004910,out6002002009,1,2,-,-,2,-,-";
		String case9_4 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004910,out6002002009,1,-,-,-,-,-,-";
//		list.add(case9_1);//00060021606171126253400000006215
//		list.add(case9_2);//00060021606171126253400000006216
//		list.add(case9_3);//00060021606171126253400000006217
//		list.add(case9_4);//refund_receive_amt is required格式校验未通过
		
		//充退--充付--账户收--账户不同，收款冻结，收费可用
		String case10 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004911,out6002002010,10,10,1,1,10,-,2";
		//充退--充付--账户收--账户相同，收款可用，收费可用
		String case11 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004912,out6002002011,10,10,0.5,0.5,10,-,1";
		//充退--充付--账户收--户相同，收款冻结，收费可用
		String case12 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004913,out6002002012,10,10,0.5,0.5,10,-,1";
		//充退--充付--账户收--账户相同，收款冻结，收费冻结
		String case13 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004914,out6002002013,10,10,0.5,0.5,10,-,1";
		//充退--充付--损益收--
		String case14 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606171002142500000004915,out6002002014,10,10,0.5,0.5,10,-,1";
		//充退--充付--损益收--
		String case15 = "12345678912345650,CC_C3878185775,PN01000000000010429,00060011606291427547810000008301,out6002002015,10,10,0.5,0.5,10,-,1";
//		list.add(case10);//00060021606171126253400000006218
//		list.add(case11);//00060021606171126253400000006221
//		list.add(case12);//00060021606171126253400000006222
//		list.add(case13);//00060021606171126253400000006223
//		list.add(case14);//00060021606171126253400000006219
		list.add(case15);//00060021606171126253400000006220
		List<TradeRequest<TradePacketReqBodyOuterRefund>> list2 = new ArrayList<TradeRequest<TradePacketReqBodyOuterRefund>>();
		for(String s : list ){
			
			String arr[] = s.split(",");
			for(int i = 0 ; i<arr.length ;i++){
				if("-".equals(arr[i])){
					arr[i] = null ;
				}
			}
			TradeRequest<TradePacketReqBodyOuterRefund> bizReq = new TradeRequest<TradePacketReqBodyOuterRefund>();
			TradePacketHead head = new TradePacketHead();
			TradePacketReqBodyOuterRefund body = new TradePacketReqBodyOuterRefund();
			head.setRequest_code("0006_002_002");
			head.setVersion("1.0");
			head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
			head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
			head.setPartner_id(arr[0]);
			head.setCore_merchant_no(arr[1]);
			head.setFund_pool_no(arr[2]);
			body.setOriginal_trade_no(arr[3]);
			body.setOut_trade_no_ext("20160617"+arr[4]+new Random().nextInt(1000));
			//付款方外部退回付款金额
			body.setExternal_refund_amt(arr[5]);
			//付款方账户退回入账金额
			body.setRefund_pay_account_in_accounting_amt(arr[6]);
			//付款方手续费账户退回入账金额
			body.setRefund_pay_fee_account_in_accounting_amt(arr[7]);
			//收款方手续费账户退回入账金额
			body.setRefund_receive_fee_account_in_accounting_amt(arr[8]);
			//收款方退回付出金额
			body.setRefund_receive_amt(arr[9]);
			if(arr[10] != null || arr[11]!=null){
				initProfitLossList(body,arr[10],arr[11]);
			}
			bizReq.setHead(head);
			bizReq.setBody(body);
			list2.add(bizReq);
		}
		for(TradeRequest<TradePacketReqBodyOuterRefund> bizReq : list2){
			TradeResponse response = TradeClient.excute(bizReq);
			if (null != response) {
				System.err.println(response.marshal());
			}
		}
	}
	
	private void initProfitLossList(TradePacketReqBodyOuterRefund body,String incr,String decr) {
		List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
		TradePacketReqBodyOtherPofitLossLedger ledger = new TradePacketReqBodyOtherPofitLossLedger();
		ledger.setIncome_incr(incr);
		ledger.setIncome_decr(decr);
		setOtherAtt(ledger);
		profit_loss_list.add(ledger);
		body.setProfit_loss_list(profit_loss_list);
	}
}
