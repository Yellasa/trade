package com.liantuo.trade.web.controller.local;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.liantuo.trade.client.trade.TradeClient;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodyRechargeOffline;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodySupplyBill;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.date.DateUtil;

public class TestTradeDemo0005 {

	 /**
		 * 0005_001_001：V1.0线下充值
		 * @throws Exception
		 * 充值金额 (10) = 支付金额(9)+充值补差金额(1)
		 */
		@Test
		public void testSingleRechargeOfflinePay() throws Exception{
			TradeRequest<TradePacketReqBodyRechargeOffline> bizReq = new TradeRequest<TradePacketReqBodyRechargeOffline>();
			TradePacketHead head = new TradePacketHead();
			TradePacketReqBodyRechargeOffline body = new TradePacketReqBodyRechargeOffline();
			setHeadAndBody001(head, body);
			bizReq.setHead(head);
			bizReq.setBody(body);
			TradeResponse response = TradeClient.excute(bizReq);
			if (null != response) {
				System.err.println(response.marshal());
			}
		}
		 /**
		 * 0005_001_002：V1.0补充入账
		 * @throws Exception
		 */
		@Test
		public void testSingleRechargeOfflineSupplyAccount() throws Exception{
			TradeRequest<TradePacketReqBodySupplyBill> bizReq = new TradeRequest<TradePacketReqBodySupplyBill>();
			TradePacketHead head = new TradePacketHead();
			TradePacketReqBodySupplyBill body = new TradePacketReqBodySupplyBill();
			setHeadAndBody002(head, body);
			bizReq.setHead(head);
			bizReq.setBody(body);
			TradeResponse response = TradeClient.excute(bizReq);
			if (null != response) {
				System.err.println(response.marshal());
			}
		}
		public static void setHeadAndBody002(TradePacketHead head,TradePacketReqBodySupplyBill body ){
			head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
			head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
			head.setPartner_id("12345678912345681");
			//核心商户编号	来自输入
			head.setCore_merchant_no("CC_C3878185775");
			//资金池编号	来自输入
			head.setFund_pool_no("PN01000000000010429");
			//交易发起方业务系统订单号	来自输入
			//最后变更交易请求类型	0005_001_001
			head.setRequest_code("0005_001_002");
			head.setVersion("1.0");
			body.setTrade_no("1605051336357590000005300");
			
		}
		public static void setHeadAndBody001(TradePacketHead head,TradePacketReqBodyRechargeOffline body ){
			//合作商户编号	来自输入
			head.setSign("f644f5387aaeadae26bf45bf6d4759c2");
			head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Calendar.getInstance().getTime()));
			head.setPartner_id("12345678912345689");
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
			body.setOut_trade_no_ext("20160503105319");
			//交易发起方业务系统订单号	来自输入
			body.setOut_trade_no("123456789119");
			//最后变更交易请求类型	0005_001_001
			head.setRequest_code("0005_001_001");
			head.setVersion("1.0");
			/**
			 * 充值付款方数据	
			 */
			//支付金额	来自输入 sign is required
			body.setPay_amount("99");
			//充值渠道号	来自输入
			body.setClear_channel("01");
			//充值渠道身份编号	来自输入
			body.setTransaction_id("transaction_id_0");
			//提交第三方批次号	来自输入
			body.setBatch_no("batch_no_001");
			//提交第三方批次流水号	来自输入
			body.setSerial_number("Serial_number_001");
			//充值渠道订单号	来自输入
			body.setThird_trade_no("Third_trade_no_001");
			//外部付款成功日期时间	来自输入yyyy-mm-dd hh:mm:ss
			body.setGmt_success_clear_channel(DateUtil.toDateTime(new Date()));
			//充值付款业务台账保留字段1	来自输入
			body.setRecharge_ledger_extend_field_1("Recharge_ledger_extend_field_1-001");
			//充值付款业务台账保留字段2	来自输入
			body.setRecharge_ledger_extend_field_2("Recharge_ledger_extend_field_2-001");
			//充值付款业务台账保留字段3	来自输入
			body.setRecharge_ledger_extend_field_3("Recharge_ledger_extend_field_3-001");
			
			/**
			 * 收款账户数据	
			 */
			//充值CA账户编号	来自输入
			body.setRecharge_account_no("CA21000000060625");//CA21000000060625
			//充值CA账户入账账务历史1	来自输入
			body.setRecharge_account_extend_field_1("Recharge_account_extend_field_1-001");
			//充值CA账户入账账务历史2	来自输入
			body.setRecharge_account_extend_field_2("Recharge_account_extend_field_2-001");
			//充值CA账户入账账务历史3	来自输入
			body.setRecharge_account_extend_field_3("Recharge_account_extend_field_3-001");
			/**
			 * 交易数据	
			 */
			//充值金额	来自输入
			body.setRecharge_amount("100");
			/**
			 * 充值手续费数据	
			 */
			/*//充值手续费金额	来自输入
			body.setFee_amount("1");
			//充值手续费接收方式	来自输入
			body.setFee_way("2");
			//充值手续费收款账户	来自输入
			body.setFee_receive_account_no("CA21000000060623");
			//充值手续费充值CA账户扣费账务历史1	来自输入
			body.setFee_pay_account_extend_field_1("Fee_pay_account_extend_field_1-001");
			//充值手续费充值CA账户扣费账务历史2	来自输入
			body.setFee_pay_account_extend_field_2("Fee_pay_account_extend_field_2-001");
			//充值手续费充值CA账户扣费账务历史3	来自输入
			body.setFee_pay_account_extend_field_3("Fee_pay_account_extend_field_3-001");
			//充值手续费收款账户入账账务历史1	来自输入
			body.setFee_receive_account_extend_field_1("Fee_receive_account_extend_field_1-001");
			//充值手续费收款账户入账账务历史2	来自输入
			body.setFee_receive_account_extend_field_2("Fee_receive_account_extend_field_2-001");
			//充值手续费收款账户入账账务历史3	来自输入
			body.setFee_receive_account_extend_field_3("Fee_receive_account_extend_field_3-001");
			//充值手续费台账类别	来自输入
			body.setFee_ledger_type("1");
			//充值手续费台账客户保留字段1	来自输入
			body.setFee_ledger_extend_field_1("Fee_ledger_extend_field_1-001");
			//充值手续费台账客户保留字段2	来自输入
			body.setFee_ledger_extend_field_2("Fee_ledger_extend_field_2-001");
			//充值手续费台账客户保留字段3	来自输入
			body.setFee_ledger_extend_field_1("Fee_ledger_extend_field_3-001");
			//充值手续费损益属性1	来自输入
			body.setFee_profit_loss_attr_1("Fee_profit_loss_attr_1-001");
			//充值手续费损益属性2	来自输入
			body.setFee_profit_loss_attr_2("Fee_profit_loss_attr_2-001");
			//充值手续费损益属性3	来自输入
			body.setFee_profit_loss_attr_3("Fee_profit_loss_attr_3-001");
			//充值手续费损益属性4	来自输入
			body.setFee_profit_loss_attr_4("Fee_profit_loss_attr_4-001");
			//充值手续费损益属性5	来自输入
			body.setFee_profit_loss_attr_5("Fee_profit_loss_attr_5-001");
			//充值手续费损益属性6	来自输入
			body.setFee_profit_loss_attr_6("Fee_profit_loss_attr_6-001");
			//充值手续费损益属性7	来自输入
			body.setFee_profit_loss_attr_7("Fee_profit_loss_attr_7-001");
			//充值手续费损益属性8	来自输入
			body.setFee_profit_loss_attr_8("Fee_profit_loss_attr_8-001");
			//充值手续费损益属性9	来自输入
			body.setFee_profit_loss_attr_9("Fee_profit_loss_attr_9-001");
			//充值手续费损益属性10	来自输入
			body.setFee_profit_loss_attr_10("Fee_profit_loss_attr_10-001");*/
			/**
			 * 充值补差数据	
			 */
			//充值补差金额	来自输入
			body.setSupply_amount("1");
			//充值补差付出方式	来自输入
			body.setSupply_way("2");
			//充值补差付款账户	来自输入
			body.setSupply_pay_account_no("CA21000000060621");//CA21000000060621
			//充值补差充值CA账户扣费账务历史1	来自输入
			body.setSupply_pay_account_extend_field_1("Supply_pay_account_extend_field_1-001");
			//充值补差充值CA账户扣费账务历史2	来自输入
			body.setSupply_pay_account_extend_field_2("Supply_pay_account_extend_field_2-001");
			//充值补差充值CA账户扣费账务历史3	来自输入
			body.setSupply_pay_account_extend_field_3("Supply_pay_account_extend_field_3-001");
			//充值补差台账类别	来自输入
			body.setSupply_ledger_type("1");
			//充值补差台账客户保留字段1	来自输入
			body.setSupply_ledger_extend_field_1("Supply_ledger_extend_field_1-001");
			//充值补差台账客户保留字段2	来自输入
			body.setSupply_ledger_extend_field_2("Supply_ledger_extend_field_2-001");
			//充值补差台账客户保留字段3	来自输入
			body.setSupply_ledger_extend_field_3("Supply_ledger_extend_field_3-001");
			//充值补差损益属性1	来自输入
			body.setSupply_profit_loss_attr_1("Supply_profit_loss_attr_1-001");
			//充值补差损益属性2	来自输入
			body.setSupply_profit_loss_attr_2("Supply_profit_loss_attr_2-001");
			//充值补差损益属性3	来自输入
			body.setSupply_profit_loss_attr_3("Supply_profit_loss_attr_3-001");
			//充值补差损益属性4	来自输入
			body.setSupply_profit_loss_attr_4("Supply_profit_loss_attr_4-001");
			//充值补差损益属性5	来自输入
			body.setSupply_profit_loss_attr_5("Supply_profit_loss_attr_5-001");
			//充值补差损益属性6	来自输入
			body.setSupply_profit_loss_attr_6("Supply_profit_loss_attr_6-001");
			//充值补差损益属性7	来自输入
			body.setSupply_profit_loss_attr_7("Supply_profit_loss_attr_7-001");
			//充值补差损益属性8	来自输入
			body.setSupply_profit_loss_attr_8("Supply_profit_loss_attr_8-001");
			//充值补差损益属性9	来自输入
			body.setSupply_profit_loss_attr_9("Supply_profit_loss_attr_9-001");
			//充值补差损益属性10	来自输入
			body.setSupply_profit_loss_attr_10("Supply_profit_loss_attr_10-001");
		}
}
