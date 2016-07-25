package com.liantuo.trade.unittest.jy0006;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalPayment;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyInnerPayment;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.validate.TradeValidationUtil;

public class TradeClient612 {


	
	
	/**
	 * 0006_001_002：V1.0   内部支付
	 * @throws Exception
	 * 直充,账户收,无手续费
	 */
	@Test
	public void test1() throws Exception{
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
		body.setOut_trade_no_ext("20160612106481");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
//		body.setPay_fee_account_no("CA21000000060623");
//		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
//		body.setReceive_fee_account_no("CA21000000088173");
//		body.setReceive_fee_account_out_accounting_type("2");
//		body.setReceive_fee_account_out_accounting_amt("1");
		
//		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
//		profit.setCost_decr("2");
		List<TradePacketReqBodyOtherPofitLossLedger> profit_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
//		profit_list.add(profit);
		body.setProfit_loss_list(profit_list);
		
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	/**
	 * 直充,账户收,账户不同，收款可用，收费可用
	 */
	@Test
	public void test2() throws Exception{
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
		body.setOut_trade_no_ext("20160612106481");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("1");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088177");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setIncome_incr("2");
//		profit.setCost_decr("2");
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
	 * 直充,账户收,账户不同，收款冻结，收费可用
	 */
	@Test
	public void test3() throws Exception{
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
		body.setOut_trade_no_ext("20160612106481");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setIncome_incr("2");
//		profit.setCost_decr("2");
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
	 * 直充,账户收,账户相同，收款可用，收费可用
	 */
	@Test
	public void test4() throws Exception{
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
		body.setOut_trade_no_ext("20160612106481");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("1");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setIncome_incr("2");
//		profit.setCost_decr("2");
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
	 * 直充,账户收,账户相同，收款冻结，收费可用
	 */
	@Test
	public void test5() throws Exception{
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
		body.setOut_trade_no_ext("20160612106481");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setIncome_incr("2");
//		profit.setCost_decr("2");
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
	 * 直充,账户收,账户相同，收款冻结，收费冻结
	 */
	@Test
	public void test6() throws Exception{
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
		body.setOut_trade_no_ext("20160628106482");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("2");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setIncome_incr("2");
//		profit.setCost_decr("2");
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
	 * 直充,损益收
	 */
	@Test
	public void test7() throws Exception{
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
		body.setOut_trade_no_ext("20160612106483");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("2");//1-账户  2-损益
		//收款方式为损益时，需有值
		body.setReceive_profit_loss_income_incr("10");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
//		body.setReceive_account_no("CA21000000088173");
//		body.setReceive_account_in_accounting_amt("10");
//		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088177");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
		profit.setCost_decr("2");
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
	 * 直充,损益收
	 */
	@Test
	public void test8() throws Exception{
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
		body.setOut_trade_no_ext("20160612106486");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("0.5");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("2");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("");
		body.setReceive_profit_loss_cost_decr("10");
		//收款方式为账户时，需有值
//		body.setReceive_account_no("CA21000000088173");
//		body.setReceive_account_in_accounting_amt("10");
//		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088177");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("0.5");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
		profit.setCost_decr("1");
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
	 * 充付,账户收,账户不同，收款可用，收费可用
	 */
	@Test
	public void test9() throws Exception{
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
		body.setOut_trade_no_ext("20160628106487");
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
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("1");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088177");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setIncome_incr("2");
//		profit.setCost_decr("2");
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
	 * 充付,账户收,账户不同，收款冻结，收费可用
	 */
	@Test
	public void test10() throws Exception{
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
		body.setOut_trade_no_ext("20160612106490");
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
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088177");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setIncome_incr("2");
//		profit.setCost_decr("2");
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
	 * 充付,账户收,账户不同，收款冻结，收费可用
	 */
	@Test
	public void test11() throws Exception{
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
		body.setOut_trade_no_ext("20160612106492");
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
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("0.5");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("1");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("0.5");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
		profit.setCost_decr("1");
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
	 * 充付,账户收,账户同，收款冻结，收费可用
	 */
	@Test
	public void test12() throws Exception{
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
		body.setOut_trade_no_ext("20160612106493");
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
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("0.5");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("0.5");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
		profit.setCost_decr("1");
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
	 * 充付,账户收,账户同，收款冻结，收费冻结
	 */
	@Test
	public void test13() throws Exception{
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
		body.setOut_trade_no_ext("20160612106494");
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
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("0.5");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("2");
		body.setReceive_fee_account_out_accounting_amt("0.5");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
		profit.setCost_decr("1");
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
	 * 充付,损益收
	 */
	@Test
	public void test14() throws Exception{
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
		body.setOut_trade_no_ext("20160612106496");
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
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("2");//1-账户  2-损益
		//收款方式为损益时，需有值
		body.setReceive_profit_loss_income_incr("10");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
//		body.setReceive_account_no("CA21000000088173");
//		body.setReceive_account_in_accounting_amt("10");
//		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088177");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setIncome_incr("2");
//		profit.setCost_decr("2");
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
	 * 充付,损益收
	 */
	@Test
	public void test15() throws Exception{
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
		body.setOut_trade_no_ext("20160612106499");
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
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("0.5");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("2");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
		body.setReceive_profit_loss_cost_decr("10");
		//收款方式为账户时，需有值
//		body.setReceive_account_no("CA21000000088173");
//		body.setReceive_account_in_accounting_amt("10");
//		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("1");
		body.setReceive_fee_account_out_accounting_amt("0.5");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
		profit.setCost_decr("1");
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
	public void test16() throws Exception{
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
		body.setOut_trade_no_ext("20160612106481");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("2");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
		profit.setCost_decr("2");
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
	public void test17() throws Exception{
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
		body.setOut_trade_no_ext("20160612106481");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("2");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
		profit.setCost_decr("2");
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
	public void test18() throws Exception{
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
		body.setOut_trade_no_ext("20160612106481");
		//交易发起方业务系统订单号	来自输入
//		body.setOut_trade_no("78avcdeerf012345678Avcdeerf012345678avcdeerf012345678a");
		//最后变更交易请求类型	0006_001_001
		/**
		 * 付款方数据	
		 */
		//付款方付出方式
		body.setPay_type("4");//4-支付   5-充付
		//付款方外部收付款渠道编号
		body.setExternal_pay_channel("310000");
		//付款方外部收款金额
		body.setExternal_pay_received_amt("10");
		//付款方外部渠道收付款成功日期时间
		body.setGmt_success_external_pay_channel("2016-06-13 12:00:00");
		//付款方外部收付款渠道订单号
		body.setExternal_pay_channel_trade_no("123123123");
//		付款方账户账户编号-----【付款方付出方式】为第三方充付时必填
//		body.setPay_account_no("CA21000000060621");
		//付款方账户出账金额-----【付款方付出方式】为第三方充付必填
//		body.setPay_account_out_accounting_amt("10");
		
		//付款方手续费账户出账金额不为空时，不可为空
		body.setPay_fee_account_no("CA21000000060623");
		body.setPay_fee_account_out_accounting_amt("1");
		
		/**
		 * 收款方数据
		 */
		body.setReceive_type("1");//1-账户  2-损益
		//收款方式为损益时，需有值
//		body.setReceive_profit_loss_income_incr("200");
//		body.setReceive_profit_loss_cost_decr("200");
		//收款方式为账户时，需有值
		body.setReceive_account_no("CA21000000088173");
		body.setReceive_account_in_accounting_amt("10");
		body.setReceive_account_in_accounting_type("2");//2-冻结  1-可用
		//收款方手续费账户出账金额不为空时，不可为空 
		body.setReceive_fee_account_no("CA21000000088173");
		body.setReceive_fee_account_out_accounting_type("2");
		body.setReceive_fee_account_out_accounting_amt("1");
		
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
//		profit.setIncome_incr("2");
		profit.setCost_decr("2");
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
	
	
	

}
