package com.liantuo.trade.bus.process.impl.single_payment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.liantuo.payment.client.pay.alipay.vo1.rsp.AlipayTradePrecreateNotifyResponse;
import com.liantuo.payment.client.pay.head.PaymentHead;
import com.liantuo.payment.client.pay.weixin.base.WeiXinCouponInfo;
import com.liantuo.payment.client.pay.weixin.vo1.agent.rsp.WeiXinUnifiedOrderNotifyResponse;
import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.bus.template.impl.v1_1.notify.ATradeNotifyOnlineAsynPaymentTemp;
import com.liantuo.trade.client.trade.packet.body.single_payment_refund.OtherPofitLossLedgerForRefund;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({ 
    WebContextTestExecutionListener.class, 
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class })
public class SinglePayment618 {
	@Resource(name = "0006_001_008:1.0")
	private SingleExternalAsynPaymentOnlineNotifyProcess process;
	@Autowired
	private ATradeNotifyOnlineAsynPaymentTemp temp;
	@Test
	public void testNotifyAli() {
		
		try {
			temp.setProcess(process);
			temp.setIp("127.0.0.1");
			temp.execute(getAliResponse());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testNotifyWx() {
		
		try {
			temp.setProcess(process);
			temp.setIp("127.0.0.1");
			temp.execute(getWxResponse());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private WeiXinUnifiedOrderNotifyResponse getWxResponse(){
		WeiXinUnifiedOrderNotifyResponse response = new WeiXinUnifiedOrderNotifyResponse();
		PaymentHead zf_head = new PaymentHead();
		zf_head.setApp_auth_token("token");
		zf_head.setPay_channel("ZF0003_01_002");
		zf_head.setTrade_no("00060011607081647306890000009900");
		zf_head.setLedger_no("00060011607081647307060000187100");
		zf_head.setOut_trade_no("20160707_no991");
		zf_head.setTrade_req_no("00060011607071825378840001376600");
		zf_head.setCore_merchant_no("CC_C3878185775");
		zf_head.setPay_transaction_id("000000000000021");
//		zf_head.setPayment_req_no("payment_req_no12");
		zf_head.setVersion("1.0");
		response.setZf_head(zf_head);
		response.setAttach("attach");
		response.setReturn_code("SUCCESS");
		response.setReturn_msg("支付成功");
		response.setSub_appid("sub_appid");
		response.setDevice_info("device_info");
//		response.setResult_code("SUCCS");
		response.setErr_code("err_code");
		response.setErr_code_des("err_code_des");
		response.setOpenid("openid");
		response.setIs_subscribe("1");
		response.setTrade_type("NATIVE");
		response.setBank_type("ICBC");
		response.setTotal_fee("20000");
		response.setFee_type("CNY");
		response.setCash_fee("0");
		response.setCash_fee_type("CNY");
		response.setTransaction_id("wxtransaction_id-122");
		response.setOut_trade_no("zf_sn_1607081647306960000000100");
		response.setTime_end("20091225091010");
		response.setCoupon_fee("0");
		response.setCoupon_count("1");
		List<WeiXinCouponInfo> couponInfos = new ArrayList<WeiXinCouponInfo>();
		WeiXinCouponInfo info = new WeiXinCouponInfo();
		info.setCoupon_id("coupon_id");
		info.setCoupon_fee("2");
		info.setCoupon_batch_id("coupon_batch_id");
		couponInfos.add(info);
		response.setCouponInfos(couponInfos);
		return response;
	}
	
	private AlipayTradePrecreateNotifyResponse getAliResponse(){
		AlipayTradePrecreateNotifyResponse response = new AlipayTradePrecreateNotifyResponse();
		PaymentHead zf_head = new PaymentHead();
		zf_head.setApp_auth_token("token");
		zf_head.setPay_channel("ZF0001_02_002");
		zf_head.setTrade_no("00060011607081608039070000009400");
		zf_head.setLedger_no("00060011607081608039250000186600");
		zf_head.setOut_trade_no("20160707_no748");
		zf_head.setTrade_req_no("00060011607071825378840001376600");
		zf_head.setCore_merchant_no("CC_C3878185775");
		zf_head.setPay_transaction_id("000000000000136");
		zf_head.setPayment_req_no("payment_req_no12");
		zf_head.setVersion("1.0");
		response.setZf_head(zf_head);
		response.setApp_id("2014072300007148");
		response.setBody("body");
		response.setBuyer_id("2088102122524333");
		response.setBuyer_logon_id("15901825620");
		response.setBuyer_pay_amount("13.88");
		response.setFund_bill_list("fund_bill_list");
		response.setGmt_close("2015-04-29 15:45:57");
		response.setGmt_create("2015-04-27 15:45:57");
		response.setGmt_payment("2015-04-27 15:45:57");
		response.setGmt_refund("2015-04-28 15:45:57");
		response.setInvoice_amount("10.00");
		/*response.setNotify_id("ac05099524730693a8b330c5ecf72da9786");
		response.setNotify_time("2015-12-27 15:45:58");
		response.setNotify_type("trade_status_sync");*/
		response.setOut_biz_no("HZRF001");
		response.setOut_trade_no("zf_sn_1607081608039150000000050");
		response.setPoint_amount("12.00");
		response.setReceipt_amount("200");
		response.setRefund_fee("2.58");
		response.setSeller_email("zhuzhanghu@alitest.com");
		response.setSeller_id("2088101106499364");
		response.setSend_back_fee("2.08");
		/*response.setSign("601510b7970e52cc63db0f44997cf70e");
		response.setSign_type("RSA");*/
		response.setSubject("subject");
		response.setTotal_amount("20");
		response.setTrade_no("2013112011001004330000121536");
		response.setTrade_status("TRADE_CLOSED");
//		response.setthird_trade_no
//		response.setmerch_order_no
		return response;
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String json = "[{\"ledger_no\":\"00060011607071825387440000186105\",\"income_incr\":\"2\"}]";
		List<OtherPofitLossLedgerForRefund> list = (List<OtherPofitLossLedgerForRefund>)ObjectJsonUtil.json2ArrayList(json, OtherPofitLossLedgerForRefund.class);
		for(OtherPofitLossLedgerForRefund refund : list ){
			System.out.println(refund.getLedger_no());
		}
	}
}
