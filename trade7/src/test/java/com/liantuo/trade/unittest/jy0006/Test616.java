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
import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyExternalSynPayment;
import com.liantuo.trade.client.trade.packet.body.zf.WxAttachment;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;


public class Test616 {
	@Test
	public void test() throws Exception{
		TradeRequest<TradePacketReqBodyExternalSynPayment> bizReq = new TradeRequest<TradePacketReqBodyExternalSynPayment>();
		TradePacketHead head = new TradePacketHead();
		TradePacketReqBodyExternalSynPayment body = new TradePacketReqBodyExternalSynPayment();
		head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
		head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
		head.setPartner_id("12345678912345650");
		//核心商户编号	来自输入
		head.setCore_merchant_no("CC_C3878185775");
		//资金池编号	来自输入
		head.setFund_pool_no("PN01000000000010429");
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
		body.setOut_trade_no_ext("20160712091200abc131");
		body.setPay_type("5");//第三方充付
		
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
		
		//其他损益列表
		TradePacketReqBodyOtherPofitLossLedger profit = new TradePacketReqBodyOtherPofitLossLedger();
		profit.setMerchant_extend_field_1("OtherPofitLossMerchant_extend_field_1");
		profit.setIncome_incr("2");
		List<TradePacketReqBodyOtherPofitLossLedger> profit_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
		profit_list.add(profit);
		body.setProfit_loss_list(profit_list);
		
		//支付中心标准输入
		body.setPay_channel("ZF0003_01_001");//支付渠道编号:微信刷卡支付
		body.setPay_transaction_id("000000000000136");//支付渠道身份编号
		body.setMerchant_extend_field_1("tce_merchant_extend_field_1");//业务台账客户保留字段
		body.setTotal_amount("1");
		body.setBody("商品详情");
		//微信刷卡支付
		WxAttachment wxa = new WxAttachment();
		wxa.setAuth_code("130091862146205555");//授权码
		wxa.setSpbill_create_ip("127.0.0.l");//终端IP
		body.setOther_attachment_group_json(ObjectJsonUtil.object2String(wxa));
		
		//支付宝支付
//		AliPaymentAttachment ac = new AliPaymentAttachment();
//		ac.setScene("bar_code");
//		ac.setAuth_code("289407546358155362");
//		ac.setSeller_id("2088101568353491");
//		ac.setTimeout_express("100m");
//		// 商品明细列表，需填写购买商品详细信息，
//		List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
//		// 创建商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
//		GoodsDetail goods1 = new GoodsDetail();
//		goods1.setGoods_id("goods_id001");
//		goods1.setGoods_name("产品01");
//		goods1.setPrice("0.03");
//		goods1.setQuantity("1");
//		goodsDetailList.add(goods1);
//		GoodsDetail goods2 = new GoodsDetail();
//		goods2.setGoods_id("goods_id002");
//		goods2.setGoods_name("产品02");
//		goods2.setPrice("0.03");
//		goods2.setQuantity("1");
//		goodsDetailList.add(goods2);
//		ac.setGoods_detail(ObjectJsonUtil.object2String(goodsDetailList));
//		
//		//扩展字段列表
//		Extend_params  params = new Extend_params();
//		params.setSys_service_provider_id("extend_params_service_provider_id");
//		ac.setExtend_params(params);
		
		
		bizReq.setBody(body);
		TradeResponse response = TradeClient.excute(bizReq);
		if (null != response) {
			System.err.println(response.marshal());
		}
		System.out.println(bizReq.marshal());
		
	}
}
