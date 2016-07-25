package com.liantuo.trade.client.trade;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyOtherPofitLossLedger;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyPayPageDetails;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundPageDetails;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodyQueryAndCheck;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodyRechargeOnline;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawPageDetails;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.validate.Format;
import com.liantuo.trade.common.validate.Required;
import com.liantuo.trade.common.validate.ValidationUtil;

public class TradeClientTest {

    /**
     * 0001_001_998
     * 0001_001_999
     * @throws Exception
     */
    @Test
    public void testPayPageDetails() throws Exception {
        TradeRequest<TradePacketReqBodyPayPageDetails> request = new TradeRequest<TradePacketReqBodyPayPageDetails>();
        TradePacketReqBodyPayPageDetails body = new TradePacketReqBodyPayPageDetails();
        TradePacketHead head = new TradePacketHead();
        request.setBody(body);
        request.setHead(head);

        head.setPartner_id("10000002057141223");
        head.setCore_merchant_no("SXSL");
        head.setFund_pool_no("PN01000000000000824");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(Calendar.getInstance().getTime()));
        head.setVersion("1.0");
        head.setVersion("1.1");

        head.setRequest_code("0001_001_999");
        head.setRequest_code("0001_001_998");

        head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");

        body.setPayment_account_no("CA12050317300000");
        body.setOut_trade_no_ext("df20163589233959992741");

        TradeResponse response = TradeClient.excute(request);
        System.err.println(response);
    }

    /**
     * 0001_002_998
     * 0001_002_999
     * @throws Exception
     */
    @Test
    public void testRefundPageDetails() throws Exception {
        TradeRequest<TradePacketReqBodyRefundPageDetails> request = new TradeRequest<TradePacketReqBodyRefundPageDetails>();
        TradePacketReqBodyRefundPageDetails body = new TradePacketReqBodyRefundPageDetails();
        TradePacketHead head = new TradePacketHead();
        request.setBody(body);
        request.setHead(head);

        head.setPartner_id("10000002057141223");
        head.setCore_merchant_no("SXSL");
        head.setFund_pool_no("PN01000000000000824");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(Calendar.getInstance().getTime()));
        head.setVersion("1.0");
        head.setVersion("1.1");

        head.setRequest_code("0001_002_999");
        head.setRequest_code("0001_002_998");
        body.setRefund_account_no("CA12050317300000");
        body.setOut_trade_no_ext("df20163589233959992741");

        head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");

        TradeResponse response = TradeClient.excute(request);
        System.out.println(response);
    }

    /**
     * 0002_001_999
     * @throws Exception
     */
    @Test
    public void singleWithdrawPageDetails() throws Exception {
        TradeRequest<TradePacketReqBodySingleWithdrawPageDetails> request = new TradeRequest<TradePacketReqBodySingleWithdrawPageDetails>();
        TradePacketReqBodySingleWithdrawPageDetails body = new TradePacketReqBodySingleWithdrawPageDetails();
        TradePacketHead head = new TradePacketHead();
        request.setBody(body);
        request.setHead(head);

        head.setPartner_id("10000002057141223");
        head.setCore_merchant_no("SXSL");
        head.setFund_pool_no("PN01000000000000824");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(Calendar.getInstance().getTime()));
        head.setVersion("1.0");

        head.setRequest_code("0002_001_999");
        body.setOut_trade_no_ext("df20163589233959992741");

        head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");

        TradeResponse response = TradeClient.excute(request);
        System.out.println(response);
    }

    /**
     * 0001_001_001
     * @throws Exception
     */
    @Test
    public void testMerchantFreeze() throws Exception {
        TradeRequest<TradePacketReqBodyMerchantFreeze> request = new TradeRequest<TradePacketReqBodyMerchantFreeze>();

        TradePacketReqBodyMerchantFreeze body = new TradePacketReqBodyMerchantFreeze();
        TradePacketHead head = new TradePacketHead();
        head.setAuth_code("123123123123");
        head.setPartner_id("10000002057141223");
        head.setCore_merchant_no("SXSL");
        head.setFund_pool_no("PN01000000000000824");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(Calendar.getInstance().getTime()));
        head.setRequest_code("0001_001_001");
        head.setVersion("1.1");
        head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
        body.setOut_trade_no("outTradeNo20160224233514491224");
        body.setFreeze_amount("21279627.80");
        body.setPayment_account_no("CA12050317300000");
        body.setOut_trade_no_ext("df20163589233959992741");

        request.setBody(body);
        request.setHead(head);
        TradeResponse response = TradeClient.excute(request);
        System.out.println(response);

    }
    
    @Test
    public void Test0005001005(){
    	TradePacketReqBodyQueryAndCheck body = new TradePacketReqBodyQueryAndCheck();
    	
    }

    @Test
    public void testFreezeOfflineSettle() throws Exception {

    }

    @Test
    public void testFullUnFreeze() throws Exception {

    }

    @Test
    public void testUnFreezeOnlineSettle() throws Exception {

    }

    @Test
    public void testRefundOfflineSettle() throws Exception {

    }
    
    /**
     * 
     * @Description: 0005_001_004,0005_001_005
     * @param @throws Exception   
     * @return void  
     * @throws
     * @author zzd
     * @date 2016-5-3
     */
    @Test
    public void testRechargeOnlineAlipayPwdBatch() throws Exception {
    	TradeRequest<TradePacketReqBodyRechargeOnline> request = new TradeRequest<TradePacketReqBodyRechargeOnline>();

    	TradePacketReqBodyRechargeOnline body = new TradePacketReqBodyRechargeOnline();
        TradePacketHead head = new TradePacketHead();
        head.setPartner_id("10000002057141223");
        head.setCore_merchant_no("SXSL");
        head.setFund_pool_no("PN01000000000000824");
        head.setRequest_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(Calendar.getInstance().getTime()));
        head.setRequest_code("0005_001_004");
        head.setVersion("1.0");
        head.setSign("02E039A8FB4D7FF322CD3C7E7103E184");
       
        body.setOut_trade_no_ext("df20163589233959992741");
        body.setPay_amount("1.01");
        body.setRecharge_account_no("Recharge_123");
        body.setRecharge_amount("0.01");
        body.setAccount_name("zailushang");
        body.setEmail("15116967897");
        body.setReceive_name("zailushang_receive");
        body.setReceive_email("1");
        body.setPay_remark("1");
        body.setPay_date("2016-05-03");
        
        
//        body.setOut_trade_no("outTradeNo20160224233514491224");
       

        request.setBody(body);
        request.setHead(head);
        TradeResponse response = TradeClient.excute(request);
        System.out.println(response);
    }
    
    @Test
    public void testVo(){
    	List<TradePacketReqBodyOtherPofitLossLedger> profit_loss_list = new ArrayList<TradePacketReqBodyOtherPofitLossLedger>();
    	TradePacketReqBodyOtherPofitLossLedger item = new TradePacketReqBodyOtherPofitLossLedger();
    	item.setCost_decr("xasd");
    	item.setCost_incr("1xasad");
    	profit_loss_list.add(item);
    	for (TradePacketReqBodyOtherPofitLossLedger obj : profit_loss_list) {
    		System.out.println(ValidationUtil.validateObjectAllMsg(obj,Required.class, Format.class));
		}
    }
    
}