package com.liantuo.trade.unittest.jy0006;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.TradePacketReqBodyOuterRefundSuccessChannelUpdate;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;

public class TradeClient625 {

	@Test
	public void test() {
		TradeRequest<TradePacketReqBodyOuterRefundSuccessChannelUpdate> bizReq = new TradeRequest<TradePacketReqBodyOuterRefundSuccessChannelUpdate>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyOuterRefundSuccessChannelUpdate body = new TradePacketReqBodyOuterRefundSuccessChannelUpdate();
		init(head, body);
		bizReq.setHead(head);
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
	}

	private void init(TradePacketHead head, TradePacketReqBodyOuterRefundSuccessChannelUpdate body) {
		head.setCore_merchant_no("CC_C3878185775");
		head.setFund_pool_no("PN01000000000010429");
		head.setRequest_code("0006_002_005");
		head.setVersion("1.0");
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setPartner_id("12345678912345650");

		// NotBlank(message = "original_trade_no is required", groups =
		// {Required.class})
		// Pattern(message = "original_trade_no format error", regexp =
		// "[\\da-zA-Z_]{8,64}", groups = Format.class)
//		body.setOriginal_trade_no("00060021606171126253400000006203");
//		body.setOriginal_trade_no("00060021606171126253400000006204");
//		body.setOriginal_trade_no("00060021606171126253400000006205");
		body.setOriginal_trade_no("00060021606171126253400000006206");
//		body.setOriginal_trade_no("00060021606171126253400000006207");
		// Pattern(message =
		// "external_refund_merchant_extend_field_1 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_merchant_extend_field_1("002005field1");

		// Pattern(message =
		// "external_refund_merchant_extend_field_2 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_merchant_extend_field_2("002005field2");

		// Pattern(message =
		// "external_refund_merchant_extend_field_3 format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_merchant_extend_field_3("002005field3");

		// Pattern(message = "external_refund_channel format error", regexp =
		// ".{0,6}", groups = Format.class)
		body.setExternal_refund_channel("002005channel");

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
		body.setExternal_refund_channel_attr_3("002005attr3");

		// Pattern(message = "external_refund_channel_attr_4 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_4("002005attr4");

		// Pattern(message = "external_refund_channel_attr_5 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_5("002005attr5");

		// Pattern(message = "external_refund_channel_attr_6 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_attr_6("002005attr6");

		// Pattern(message =
		// "external_refund_channel_transaction_id format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_transaction_id("002005transactionid");

		// Pattern(message =
		// "external_refund_channel_pay_account_no format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_pay_account_no("002005payaccountno");

		// Pattern(message =
		// "external_refund_channel_pay_account_name format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_pay_account_name("002005payaccountname");

		// Pattern(message = "external_refund_channel_batch_no format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_batch_no("002005batchno");

		// Pattern(message = "external_refund_channel_serial_no format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_serial_no("002005serialno");

		// Pattern(message =
		// "external_refund_channel_receive_account_no format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_receive_account_no("002005receiveaccountno");

		// Pattern(message =
		// "external_refund_channel_recieve_account_name format error", regexp =
		// ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_recieve_account_name("002005receiveaccountname");

		// Pattern(message = "external_refund_channel_field_8 format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_field_8("002005channelfield8");

		// Pattern(message = "external_refund_channel_field_9 format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_field_9("002005channelfield9");

		// Pattern(message = "external_refund_channel_field_10 format error",
		// regexp = ".{0,1024}", groups = Format.class)
		body.setExternal_refund_channel_field_10("002005channelfield10");

		// DateTime(message = "gmt_external_refund_channel_clear format error",
		// groups = Format.class)
		body.setGmt_external_refund_channel_clear("2016-06-15 17:42:27");

		// DateTime(message = "gmt_external_refund_accouting format error",
		// groups = Format.class)
		body.setGmt_external_refund_accouting("2016-06-15 17:42:27");

		// Pattern(message = "external_refund_channel_field_13 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_field_13("002005channelfield13");

		// Pattern(message = "external_refund_channel_field_14 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_field_14("002005channelfield14");

		// Pattern(message = "external_refund_channel_field_15 format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_field_15("002005channelfield15");

		// DateTime(message = "gmt_success_external_refund format error", groups
		// = Format.class)
		body.setGmt_success_external_refund("2016-06-15 17:42:27");

		// Pattern(message = "external_refund_channel_trade_no format error",
		// regexp = ".{0,128}", groups = Format.class)
		body.setExternal_refund_channel_trade_no("002005channeltradeName");
	}
}
