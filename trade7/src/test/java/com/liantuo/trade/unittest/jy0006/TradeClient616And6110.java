package com.liantuo.trade.unittest.jy0006;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liantuo.trade.bus.service.SinglePaymentService;
import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalAddRecorded;
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyRecieveCaThaw;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.TradePacketReqBodyInnerRefund;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.orm.pojo.TradeProfitLossLedger;
import com.liantuo.trade.orm.pojo.TradeSinglePayment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
      "classpath:config/spring/applicationContext-*.xml"
})
//@TestExecutionListeners({
//      WebContextTestExecutionListener.class,
//      DependencyInjectionTestExecutionListener.class,
//      DirtiesContextTestExecutionListener.class})
public class TradeClient616And6110 {
	
	@Resource(name="singlePaymentServiceImpl")
    private SinglePaymentService singlePaymentService;
	
	@Resource(name="singlePaymentBasicServiceImpl")
	private SinglePaymentService singleBasciPaymentService;
	
	@Test
	public void test0006001003(){
//		Assert.isNull(singlePaymentService);
		TradeSinglePayment item = singlePaymentService.queryByTradeNo("00060011606291516506120000008400");
		String json = item.getExtendProfitLoss();
		try {
			System.out.println(json);
			List<TradeProfitLossLedger> otherProfitLossLedgerList = ObjectJsonUtil.json2ArrayList(json, TradeProfitLossLedger.class);
			for (TradeProfitLossLedger subitem : otherProfitLossLedgerList) {
				System.out.println(subitem.getLedgerNo());
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test613Process(){
		TradeRequest<TradePacketReqBodyExternalAddRecorded> bizReq = new TradeRequest<TradePacketReqBodyExternalAddRecorded>();
		TradePacketReqBodyExternalAddRecorded body = new TradePacketReqBodyExternalAddRecorded();
		TradePacketHead head = initHead();
		body.setTrade_no("");
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}
	
	@Test 
	public void test6110Process(){
		TradeRequest<TradePacketReqBodyRecieveCaThaw> bizReq = new TradeRequest<TradePacketReqBodyRecieveCaThaw>();
		TradePacketReqBodyRecieveCaThaw body = new TradePacketReqBodyRecieveCaThaw();
		TradePacketHead head = initHead();
		body.setOriginal_trade_no("or20167186089");
		body.setUn_frozen_amt("0.01");
		body.setOut_trade_no_ext("81234_a4");
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}

	private TradePacketHead initHead() {
		TradePacketHead head = new TradePacketHead();
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setRequest_code("0006_001_010");
		head.setVersion("1.0");
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setPartner_id("10012426000150917");
		//核心商户编号	来自输入
		head.setCore_merchant_no("EW_N5496622881");
		//资金池编号	来自输入
		head.setFund_pool_no("PN02000000000003860");
		return head;
	}

	@Test
	public void getBean(){
		TradeRequest<TradePacketReqBodyInnerRefund> biz = new TradeRequest<TradePacketReqBodyInnerRefund>();
		TradePacketHead head = initHead();
		TradePacketReqBodyInnerRefund body = new TradePacketReqBodyInnerRefund();
		init0006002001(head, body);
		head.setRequest_code("111_111_111");
		biz.setHead(head);
		biz.setBody(body);
		TradeResponse response = TradeClient.excute(biz);
		if (null != response) {
			System.err.println(response.marshal());
		}
		
	}
	
	private void init0006002001(TradePacketHead head, TradePacketReqBodyInnerRefund body) {
		head.setCore_merchant_no("CC_C3878185775");
		head.setFund_pool_no("PN01000000000010429");
		head.setRequest_code("111_111_111");
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
		body.setOriginal_trade_no("00060011606161400152520000004400");

		/**
		 * 参数名：交易客户保留字段1</br> 参数类型：可空</br>
		 */
		// Pattern(message = "merchant_extend_field_1 format error", regexp =
		// ".{0,64}", groups = Format.class)
		body.setMerchant_extend_field_1("123456");

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
		body.setOut_trade_no_ext("a201611111a_as11111as"+new Random().nextInt(1000));

		/**
		 * 参数名：交易发起方业务系统订单号</br> 参数类型：可空</br>
		 */
		// Pattern(message = "out_trade_no format error", regexp =
		// ".{0}|[\\da-zA-Z_]{8,64}", groups = Format.class)
		body.setOut_trade_no("20161222222222222"+new Random().nextInt(1000));

		
		//付款方退回收到方式	　refund_pay_type	枚举	　	原交易付款方付出方式为【损益充付】时填写，只能是【账户】或【损益充退】	是	1位数字
		body.setRefund_pay_type("1");
		//负向
		body.setRefund_pay_profit_loss_amt("0.1");
		// DecimalMin(message =
		// "refund_pay_account_in_accounting_amt format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "refund_pay_account_in_accounting_amt format error",
		// groups = {Format.class}, integer =
		// TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		//负向
		body.setRefund_pay_account_in_accounting_amt("0.12");

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
		//负向
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
		initProfitLossList0006002001(body);
	}
	
	private void initProfitLossList0006002001(TradePacketReqBodyInnerRefund body) {
		List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
		TradePacketReqBodyOtherPofitLossLedger ledger = new TradePacketReqBodyOtherPofitLossLedger();
		/*
		 * 以下4个金额有且只有1个金额存在 有且有且只能有一个金额存在
		 */

		// DecimalMin(message = "income_incr format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "income_incr format error", groups = {Format.class},
		// integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
//		 ledger.setIncome_incr("0.06");

		// DecimalMin(message = "income_decr format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "income_decr format error", groups = {Format.class},
		// integer = TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		ledger.setIncome_decr("0.14");

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
}
