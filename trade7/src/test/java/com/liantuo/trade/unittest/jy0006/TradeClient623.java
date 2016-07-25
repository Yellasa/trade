package com.liantuo.trade.unittest.jy0006;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.TradePacketReqBodyOuterRefundSuccessUpdate;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

public class TradeClient623 {

	@Test
	public void test() {
		TradeRequest<TradePacketReqBodyOuterRefundSuccessUpdate> bizReq = new TradeRequest<TradePacketReqBodyOuterRefundSuccessUpdate>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyOuterRefundSuccessUpdate body = new TradePacketReqBodyOuterRefundSuccessUpdate();
		init(head, body);
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}

	private void init(TradePacketHead head, TradePacketReqBodyOuterRefundSuccessUpdate body) {
		head.setCore_merchant_no("CC_C3878185775");
		head.setFund_pool_no("PN01000000000010429");
		head.setRequest_code("0006_002_003");
		head.setVersion("1.0");
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setPartner_id("12345678912345650");

		// NotBlank(message = "original_trade_no is required", groups =
		// {Required.class})
		// Pattern(message = "original_trade_no format error", regexp =
		// "[\\da-zA-Z_]{8,64}", groups = Format.class)
//		body.setOriginal_trade_no("00060021606171126253400000006212");
//		body.setOriginal_trade_no("00060021606171126253400000006213");
		body.setOriginal_trade_no("00060021606171126253400000006214");
//		body.setOriginal_trade_no("00060021606171126253400000006215");
//		body.setOriginal_trade_no("00060021606171126253400000006216");
//		
		// Pattern(message =
		// "external_refund_merchant_extend_field_1 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_merchant_extend_field_1("002003field1");

		// Pattern(message =
		// "external_refund_merchant_extend_field_2 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_merchant_extend_field_2("002003field2");

		// Pattern(message =
		// "external_refund_merchant_extend_field_3 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_merchant_extend_field_3("002003field3");

		// Pattern(message = "external_refund_channel format error", regexp =
		// ".{0,6}", groups = Format.class)
		body.setExternal_refund_channel("002003channel");

		// DecimalMin(message =
		// "external_refund_pay_channel_fee_amt format error", groups =
		// {Format.class}, value = "0.01")
		// Digits(message = "external_refund_pay_channel_fee_amt format error",
		// groups = {Format.class}, integer =
		// TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		body.setExternal_refund_pay_channel_fee_amt("1");

		// DecimalMin(message = "external_refund_channel_fee_amt format error",
		// groups = {Format.class}, value = "0.01")
		// Digits(message = "external_refund_channel_fee_amt format error",
		// groups = {Format.class}, integer =
		// TradeConstants.DIGIT_AMOUNT_LENGTH, fraction = 2)
		body.setExternal_refund_channel_fee_amt("2");

		// Pattern(message = "external_refund_channel_attr_3 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_3("002003attr3");

		// Pattern(message = "external_refund_channel_attr_4 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_4("002003attr4");

		// Pattern(message = "external_refund_channel_attr_5 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_5("002003attr5");

		// Pattern(message = "external_refund_channel_attr_6 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_6("002003attr6");

		// Pattern(message =
		// "external_refund_channel_transaction_id format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_transaction_id("002003transactionid");

		// Pattern(message =
		// "external_refund_channel_pay_account_no format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_pay_account_no("002003payaccountno");

		// Pattern(message =
		// "external_refund_channel_pay_account_name format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_pay_account_name("002003payaccountname");

		// Pattern(message = "external_refund_channel_batch_no format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_batch_no("002003batchno");

		// Pattern(message = "external_refund_channel_serial_no format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_serial_no("002003serialno");

		// Pattern(message =
		// "external_refund_channel_receive_account_no format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_receive_account_no("002003receiveaccountno");

		// Pattern(message =
		// "external_refund_channel_recieve_account_name format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_recieve_account_name("002003receiveaccountname");

		// Pattern(message = "external_refund_channel_field_8 format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_field_8("002003channelfield8");

		// Pattern(message = "external_refund_channel_field_9 format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_field_9("002003channelfield9");

		// Pattern(message = "external_refund_channel_field_10 format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_field_10("002003channelfield10");

		// DateTime(message = "gmt_external_refund_channel_clear format error",
		// groups = Format.class)
		body.setGmt_external_refund_channel_clear("2016-06-15 17:42:27");

		// DateTime(message = "gmt_external_refund_accouting format error",
		// groups = Format.class)
		body.setGmt_external_refund_accouting("2016-06-15 17:42:27");

		// Pattern(message = "external_refund_channel_field_13 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_field_13("002003channelfield13");

		// Pattern(message = "external_refund_channel_field_14 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_field_14("002003channelfield14");

		// Pattern(message = "external_refund_channel_field_15 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_field_15("002003channelfield15");

		// DateTime(message = "gmt_success_external_refund format error", groups
		// = Format.class)
		body.setGmt_success_external_refund("2016-06-15 17:42:27");

		// Pattern(message = "external_refund_channel_trade_no format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_trade_no("002003channeltradeName");
	}
}
