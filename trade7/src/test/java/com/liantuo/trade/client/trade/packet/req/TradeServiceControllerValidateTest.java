package com.liantuo.trade.client.trade.packet.req;


import org.junit.*;
import org.springframework.util.StringUtils;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyCommon;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyUnFreezeOfflineSettle;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyFullUnFreeze;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyPayPageDetails;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundPageDetails;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyUnFreezeOnlineSettle;
import com.liantuo.trade.common.validate.ValidationUtil;

public class TradeServiceControllerValidateTest {
    @Test
    public void testValidateProtocol() throws Exception {
        int caseTag = 4;
        switch(caseTag){
        case 1:
            //TradePacketReqBodyCommon
            TradePacketReqBodyCommon tradePacketReqBodyCommon = new TradePacketReqBodyCommon();
            tradePacketReqBodyCommon.setOut_trade_no("out_trade_no");
            tradePacketReqBodyCommon.setOut_trade_no_ext("out_trade_no_ext");
            tradePacketReqBodyCommon.setTrade_no("reqCommon");
            System.err.println(this.validateRequiredAndFormat(tradePacketReqBodyCommon));
            break;
        case 2:
            //TradePacketReqBodyUnFreezeOfflineSettle
            TradePacketReqBodyUnFreezeOfflineSettle tradePacketReqBodyFreezeOfflineSettle = new TradePacketReqBodyUnFreezeOfflineSettle();
            tradePacketReqBodyFreezeOfflineSettle.setActual_amount("511.01");
            tradePacketReqBodyFreezeOfflineSettle.setClear_channel("w123");
            tradePacketReqBodyFreezeOfflineSettle.setClear_channel_attr_1("clearChannelAttr_1");
            tradePacketReqBodyFreezeOfflineSettle.setClear_channel_attr_2("clearChannelAttr_2");
            tradePacketReqBodyFreezeOfflineSettle.setClear_channel_attr_3("clearChannelAttr_3");
            tradePacketReqBodyFreezeOfflineSettle.setClear_channel_attr_4("clearChannelAttr_4");
            tradePacketReqBodyFreezeOfflineSettle.setClear_channel_attr_5("clearChannelAttr_5");
            tradePacketReqBodyFreezeOfflineSettle.setClear_channel_attr_6("clearChannelAttr_6");
            tradePacketReqBodyFreezeOfflineSettle.setGmt_success_clear_channel("2015-01-02 14:23:15");
            tradePacketReqBodyFreezeOfflineSettle.setThird_trade_no("w11111");
            tradePacketReqBodyFreezeOfflineSettle.setTrade_no("d12311111");
            System.err.println(this.validateRequiredAndFormat(tradePacketReqBodyFreezeOfflineSettle));
            break;
        case 3:
            //TradePacketReqBodyFullUnFreeze
            TradePacketReqBodyFullUnFreeze tradePacketReqBodyFullUnFreeze = new TradePacketReqBodyFullUnFreeze();
            tradePacketReqBodyFullUnFreeze.setTrade_no("tradeNo11");
            System.err.println(this.validateRequiredAndFormat(tradePacketReqBodyFullUnFreeze));
            break;
        case 4:
            //TradePacketReqBodyMerchantFreeze
            TradePacketReqBodyMerchantFreeze tradePacketReqBodyMerchantFreeze = new TradePacketReqBodyMerchantFreeze();
            tradePacketReqBodyMerchantFreeze.setFreeze_amount("123.1211");
            tradePacketReqBodyMerchantFreeze.setMerchant_extend_field_1("merchant_extend_field_1");
            tradePacketReqBodyMerchantFreeze.setMerchant_extend_field_2("merchant_extend_field_2");
            tradePacketReqBodyMerchantFreeze.setMerchant_extend_field_3("merchant_extend_field_3");
            tradePacketReqBodyMerchantFreeze.setMerchant_extend_field_4("merchant_extend_field_4");
            tradePacketReqBodyMerchantFreeze.setMerchant_extend_field_5("merchant_extend_field_5");
            tradePacketReqBodyMerchantFreeze.setOut_trade_no("out_trade_no");
            tradePacketReqBodyMerchantFreeze.setOut_trade_no_ext("out_trade_no_ext");
            tradePacketReqBodyMerchantFreeze.setPayment_account_no("payment_account_no");
            System.err.println(this.validateRequiredAndFormat(tradePacketReqBodyMerchantFreeze));
            break;
        case 5:
            //TradePacketReqBodyPayPageDetails
            TradePacketReqBodyPayPageDetails tradePacketReqBodyPayPageDetails = new TradePacketReqBodyPayPageDetails();
            tradePacketReqBodyPayPageDetails.setGmt_created_end("2015-01-02 14:23:15");
            tradePacketReqBodyPayPageDetails.setGmt_created_start("2015-01-02 14:23:15");
            tradePacketReqBodyPayPageDetails.setGmt_latest_modified_end("2015-01-02 14:23:15");
            tradePacketReqBodyPayPageDetails.setGmt_latest_modified_start("2015-01-02 14:23:15");
            tradePacketReqBodyPayPageDetails.setOut_trade_no_ext("outTradeNoExt");
            tradePacketReqBodyPayPageDetails.setPayment_merchant_no("paymentMerchantNo");
            tradePacketReqBodyPayPageDetails.setReceive_merchant_no("receiveMerchantNo");
            tradePacketReqBodyPayPageDetails.setTrade_no("tradeNo11");
            System.err.println(this.validateRequiredAndFormat(tradePacketReqBodyPayPageDetails));
            break;
        case 6:
            //TradePacketReqBodyRefundOfflineSettle
            TradePacketReqBodyRefundOfflineSettle tradePacketReqBodyRefundOfflineSettle = new TradePacketReqBodyRefundOfflineSettle();
            tradePacketReqBodyRefundOfflineSettle.setClear_channel_attr_1("clearChannelAttr_1");
            tradePacketReqBodyRefundOfflineSettle.setClear_channel_attr_2("clearChannelAttr_2");
            tradePacketReqBodyRefundOfflineSettle.setClear_channel_attr_3("clearChannelAttr_3");
            tradePacketReqBodyRefundOfflineSettle.setClear_channel_attr_4("clearChannelAttr_4");
            tradePacketReqBodyRefundOfflineSettle.setClear_channel_attr_5("clearChannelAttr_5");
            tradePacketReqBodyRefundOfflineSettle.setClear_channel_attr_6("clearChannelAttr_6");
            tradePacketReqBodyRefundOfflineSettle.setClear_refund_amount("12.12");
            tradePacketReqBodyRefundOfflineSettle.setGmt_refund_clear_channel("2015-01-02 14:23:15");
            tradePacketReqBodyRefundOfflineSettle.setMerchant_extend_field_1("merchantExtendField_1");
            tradePacketReqBodyRefundOfflineSettle.setMerchant_extend_field_2("merchantExtendField_2");
            tradePacketReqBodyRefundOfflineSettle.setMerchant_extend_field_3("merchantExtendField_3");
            tradePacketReqBodyRefundOfflineSettle.setMerchant_extend_field_4("merchantExtendField_4");
            tradePacketReqBodyRefundOfflineSettle.setMerchant_extend_field_5("merchantExtendField_5");
            tradePacketReqBodyRefundOfflineSettle.setOriginal_trade_no("originalTradeNo");
            tradePacketReqBodyRefundOfflineSettle.setOut_trade_no("outTradeNo");
            tradePacketReqBodyRefundOfflineSettle.setOut_trade_no_ext("outTradeNoExt");
            tradePacketReqBodyRefundOfflineSettle.setThird_trade_no("thirdTradeNo");
            System.err.println(this.validateRequiredAndFormat(tradePacketReqBodyRefundOfflineSettle));
            break;
        case 7:
            //TradePacketReqBodyRefundPageDetails
            TradePacketReqBodyRefundPageDetails tradePacketReqBodyRefundPageDetails  = new TradePacketReqBodyRefundPageDetails();
            tradePacketReqBodyRefundPageDetails.setGmt_created_end("2015-01-02 14:23:15");
            tradePacketReqBodyRefundPageDetails.setGmt_created_start("2015-01-02 14:23:15");
            tradePacketReqBodyRefundPageDetails.setGmt_latest_modified_end("2015-01-02 14:23:15");
            tradePacketReqBodyRefundPageDetails.setGmt_latest_modified_start("2015-01-02 14:23:15");
            tradePacketReqBodyRefundPageDetails.setOut_trade_no_ext("outTradeNoExt");
//            tradePacketReqBodyRefundPageDetails.setPayment_merchant_no("paymentMerchantNo");
            tradePacketReqBodyRefundPageDetails.setReceive_merchant_no("receiveMerchantNo");
            tradePacketReqBodyRefundPageDetails.setTrade_no("tradeNo1212");
            System.err.println(this.validateRequiredAndFormat(tradePacketReqBodyRefundPageDetails));
            break;
        case 8:
            //TradePacketReqBodyUnFreezeOnlineSettle
            TradePacketReqBodyUnFreezeOnlineSettle tradePacketReqBodyUnFreezeOnlineSettle  = new TradePacketReqBodyUnFreezeOnlineSettle();
            tradePacketReqBodyUnFreezeOnlineSettle.setActual_amount("123.12");
            tradePacketReqBodyUnFreezeOnlineSettle.setReceive_account_no("receiveAccountNo");
            tradePacketReqBodyUnFreezeOnlineSettle.setTrade_no("tradeNo12");
            System.err.println(this.validateRequiredAndFormat(tradePacketReqBodyUnFreezeOnlineSettle));
            break;
        default:
            System.out.println("");
        }
    }

    protected String validateRequiredAndFormat(Object req) throws Exception {
        /**必填验证*/
        String msg = ValidationUtil.validateRequired(req);

        //协议参数校验
        if (!StringUtils.isEmpty(msg)) {
            return msg;
        }

        /**格式验证*/
        msg = ValidationUtil.validateFormat(req);
        if (!StringUtils.isEmpty(msg)) {

            return msg;
        }
        return "pass";
    }

}
