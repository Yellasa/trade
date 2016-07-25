package com.liantuo.trade.unittest.jy0006;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.single_payment.InnerQueryPage4SinlePaymentDetail;
import com.liantuo.trade.client.trade.packet.body.single_payment.QueryPage4SinlePaymentDetail;

public class TradeClientQuery {

	public TradeRequest<QueryPage4SinlePaymentDetail> init998() {
		TradeRequest<QueryPage4SinlePaymentDetail> request = new TradeRequest<QueryPage4SinlePaymentDetail>();
		QueryPage4SinlePaymentDetail body = new QueryPage4SinlePaymentDetail();
		body.setExternal_pay_channel_batch_no("epcbn0000");
		body.setExternal_pay_channel_serial_no("epcsn0000");
		body.setFrozen_amt_end("0.03");
		body.setFrozen_amt_start("0.02");
		body.setGmt_created_end("2016-01-02 22:24:25");
		body.setGmt_created_start("2015-11-04 02:04:05");
		body.setGmt_latest_modified_end("2016-01-12 22:24:25");
		body.setGmt_latest_modified_start("2015-12-04 02:04:05");
		body.setMerchant_extend_field_1("bbbbccc003");
		body.setMerchant_extend_field_10("bbbbccc003");
		body.setMerchant_extend_field_2("bbbbccc003");
		body.setMerchant_extend_field_3("bbbbccc003");
		body.setMerchant_extend_field_4("bbbbccc003");
		body.setMerchant_extend_field_5("bbbbccc003");
		body.setMerchant_extend_field_6("bbbbccc003");
		body.setMerchant_extend_field_7("bbbbccc003");
		body.setMerchant_extend_field_8("bbbbccc003");
		body.setMerchant_extend_field_9("bbbbccc003");
		body.setOut_trade_no("otn20167191072");
		body.setOut_trade_no_ext("otoe20167197820");
		body.setPage("1");
		body.setPage_size("51");
		body.setStatus("01^02^03");
		body.setTrade_catagory("2^1");
		body.setTrade_no("tn20167196593");
		request.setBody(body);
		request.getHead().setCore_merchant_no("12345678901234567890123456789012");
		request.getHead().setFund_pool_no("PN01000000000010876");
		request.getHead().setPartner_id("10012426000150917");
		request.getHead().setRequest_code("0006_001_998");
		request.getHead().setRequest_time("2016-07-19 02:01:40");
		request.getHead().setSign("47821166eefb26c06151ae489064a7c2");
		request.getHead().setVersion("1.0");
		return request;

	}

	public TradeRequest<InnerQueryPage4SinlePaymentDetail> init999() {
		TradeRequest<InnerQueryPage4SinlePaymentDetail> request = new TradeRequest<InnerQueryPage4SinlePaymentDetail>();
		InnerQueryPage4SinlePaymentDetail body = new InnerQueryPage4SinlePaymentDetail();

		body.setExternal_pay_channel_batch_no("epcbn0000");
		body.setExternal_pay_channel_serial_no("epcsn0000");
		body.setFrozen_amt_end("0.03");
		body.setFrozen_amt_start("0.02");
		body.setGmt_created_end("2016-01-02 22:24:25");
		body.setGmt_created_start("2015-11-04 02:04:05");
		body.setGmt_latest_modified_end("2016-01-12 22:24:25");
		body.setGmt_latest_modified_start("2015-12-04 02:04:05");
		body.setMerchant_extend_field_1("bbbbccc003");
		body.setMerchant_extend_field_10("bbbbccc003");
		body.setMerchant_extend_field_2("bbbbccc003");
		body.setMerchant_extend_field_3("bbbbccc003");
		body.setMerchant_extend_field_4("bbbbccc003");
		body.setMerchant_extend_field_5("bbbbccc003");
		body.setMerchant_extend_field_6("bbbbccc003");
		body.setMerchant_extend_field_7("bbbbccc003");
		body.setMerchant_extend_field_8("bbbbccc003");
		body.setMerchant_extend_field_9("bbbbccc003");
		body.setOut_trade_no("otn20167191072");
		body.setOut_trade_no_ext("otoe20167197820");
		body.setPage("1");
		body.setPage_size("51");
		body.setStatus("01");
		body.setTrade_catagory("2");
		body.setTrade_no("tn20167196593");
		request.setBody(body);
		request.getHead().setFund_pool_no("PN01000000000010876");
		request.getHead().setPartner_id("10012426000150917");
		request.getHead().setRequest_code("0006_001_999");
		request.getHead().setRequest_time("2016-07-19 02:01:40");
		request.getHead().setSign("47821166eefb26c06151ae489064a7c2");
		request.getHead().setVersion("1.0");
		return request;

	}

	/**
	 * 0006_001_002：V1.0 内部支付
	 * 
	 * @throws Exception
	 *             直充,账户收,无手续费
	 */
	@Test
	public void test998() throws Exception {
		try {

			TradeResponse response = TradeClient.excute(init998());
			if (null != response) {
				System.err.println(response.marshal());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Test
	public void test999() throws Exception {
		try {
			TradeResponse response = TradeClient.excute(init999());
			if (null != response) {
				System.err.println(response.marshal());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String reqxml = "<tradeRequest>" + "<body xsi:type=\"innerQueryPage4SinlePaymentDetail\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" + "<trade_no>tn20167198268</trade_no>" + "<external_pay_channel_batch_no>epcbn0000</external_pay_channel_batch_no>" + "<external_pay_channel_serial_no>epcsn0000</external_pay_channel_serial_no>" + "<out_trade_no_ext>otoe20167191104</out_trade_no_ext>" + "<out_trade_no>otn20167195859</out_trade_no>" + " <frozen_amt_start>0.02</frozen_amt_start>" + "  <frozen_amt_end>0.03</frozen_amt_end>" + " <merchant_extend_field_1>bbbbccc003</merchant_extend_field_1>" + "<merchant_extend_field_2>bbbbccc003</merchant_extend_field_2>" + "<merchant_extend_field_3>bbbbccc003</merchant_extend_field_3>"
				+ " <merchant_extend_field_4>bbbbccc003</merchant_extend_field_4>" + "<merchant_extend_field_5>bbbbccc003</merchant_extend_field_5>" + " <merchant_extend_field_6>bbbbccc003</merchant_extend_field_6>" + " <merchant_extend_field_7>bbbbccc003</merchant_extend_field_7>" + " <merchant_extend_field_8>bbbbccc003</merchant_extend_field_8>" + " <merchant_extend_field_9>bbbbccc003</merchant_extend_field_9>" + " <merchant_extend_field_10>45645643FDS58886435643ADSFSFGSD32453245654656564374375qwd####!#$$%%&*()_)*&^^####$$$$$$$$$$$$$$$$$$$RWQERWSDF14234128765</merchant_extend_field_10>" + " <merchant_extend_field_1_fuzzy>bbbbccc001</merchant_extend_field_1_fuzzy>" + " <merchant_extend_field_2_fuzzy>bbbbccc002</merchant_extend_field_2_fuzzy>"
				+ " <merchant_extend_field_3_fuzzy>bbbbccc003</merchant_extend_field_3_fuzzy>" + " <merchant_extend_field_4_fuzzy>bbbbccc004</merchant_extend_field_4_fuzzy>" + " <merchant_extend_field_5_fuzzy>bbbbccc005</merchant_extend_field_5_fuzzy>" + " <gmt_created_start>2015-11-04 02:04:05</gmt_created_start>" + " <gmt_created_end>2016-01-02 22:24:25</gmt_created_end>" + " <gmt_latest_modified_start>2015-12-04 02:04:05</gmt_latest_modified_start>" + " <gmt_latest_modified_end>2016-01-12 22:24:25</gmt_latest_modified_end>" + "  <trade_catagory>2</trade_catagory>" + "<status>01</status>" + " <page>1</page>" + "<page_size>51</page_size>" + "  </body>" + " <head>" + " <core_merchant_no>CC_C8785258588</core_merchant_no>" + " <fund_pool_no>PN01000000000010876</fund_pool_no>"
				+ " <request_code>0006_001_999</request_code>" + " <request_time>2016-07-19 16:50:27</request_time>" + " <sign>02E039A8FB4D7FF322CD3C7E7103E184</sign>" + " <sign_type>MD5</sign_type>" + " <input_charset>UTF-8</input_charset>" + "<version>1.0</version>" + " </head>" + "</tradeRequest>";

		try {
			TradeRequest<InnerQueryPage4SinlePaymentDetail> request = (TradeRequest<InnerQueryPage4SinlePaymentDetail>) TradeRequest.unmarshal(reqxml, InnerQueryPage4SinlePaymentDetail.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
