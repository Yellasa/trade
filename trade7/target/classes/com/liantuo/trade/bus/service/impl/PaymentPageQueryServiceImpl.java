package com.liantuo.trade.bus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ebill.framework.datatype.StringUtil;
import com.liantuo.trade.bus.service.SinglePaymentService;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.single_payment.InnerQueryPage4SinlePaymentDetail;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeStatusUtils;
import com.liantuo.trade.orm.pojo.TradeSinglePayment;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentExample;
import com.liantuo.trade.orm.pojo.TradeSinglePaymentExample.Criteria;

@Component(value = "paymentPageQueryServiceImpl")
public class PaymentPageQueryServiceImpl implements com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService<TradeRequest<InnerQueryPage4SinlePaymentDetail>> {

	@Resource(name = "singlePaymentServiceImpl")
	 private SinglePaymentService singlePaymentService;

    @Override
    public Object queryByPage(TradeRequest<InnerQueryPage4SinlePaymentDetail> req, TradeResponse tradeResponse) {
        TradePacketHead head = req.getHead();
        InnerQueryPage4SinlePaymentDetail body = req.getBody();
        TradeSinglePaymentExample example = new TradeSinglePaymentExample();
        Criteria criteria = example.createCriteria();

        //核心商户号
        if (!StringUtils.isEmpty(head.getCore_merchant_no())) {
            criteria.andCoreMerchantNoEqualTo(head.getCore_merchant_no());
        }
        //资金池编号
        if (!StringUtils.isEmpty(head.getFund_pool_no())) {
            criteria.andFundPoolNoEqualTo(head.getFund_pool_no());
        }
        //交易编号
        if (!StringUtils.isEmpty(body.getTrade_no())) {
            criteria.andTradeNoEqualTo(body.getTrade_no());
        }
        //付款方冻结余额起始frozen_amt_start
        if (!StringUtil.isEmpty(body.getFrozen_amt_start())) {
            criteria.andPayFreezeBalGreaterThanOrEqualTo(AmountUtils.bizAmountConvertToLong(body.getFrozen_amt_start()));
        }
        //付款方冻结余额起始frozen_amt_end
        if (!StringUtil.isEmpty(body.getFrozen_amt_end())) {
            criteria.andPayFreezeBalLessThanOrEqualTo(AmountUtils.bizAmountConvertToLong(body.getFrozen_amt_end()));
        }
        
        //付款方外部收付款备注4【提交第三方批次号】
        if (!StringUtil.isEmpty(body.getExternal_pay_channel_batch_no())) {
            criteria.andExternalRefundChannelBatchNoEqualTo(body.getExternal_pay_channel_batch_no());
        }
        //付款方外部收付款备注5【提交第三方请求流水号】
        if (!StringUtil.isEmpty(body.getExternal_pay_channel_serial_no())) {
            criteria.andExternalRefundChannelSerialNoEqualTo(body.getExternal_pay_channel_serial_no());
        }
        //交易发起方发起请求编号
        if (!StringUtil.isEmpty(body.getOut_trade_no_ext())) {
            criteria.andOutTradeNoExtEqualTo(body.getOut_trade_no_ext());
        }
        //交易发起发起方业务系统订单号
        if (!StringUtil.isEmpty(body.getOut_trade_no())) {
            criteria.andOutTradeNoEqualTo(body.getOut_trade_no());
        }
        //交易客户保留字段1
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_1())) {
            criteria.andMerchantExtendField1EqualTo(body.getMerchant_extend_field_1());
        }
        //交易客户保留字段2
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_2())) {
            criteria.andMerchantExtendField2EqualTo(body.getMerchant_extend_field_2());
        }
        //交易客户保留字段3
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_3())) {
            criteria.andMerchantExtendField3EqualTo(body.getMerchant_extend_field_3());
        }
        //交易客户保留字段4
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_4())) {
            criteria.andMerchantExtendField4EqualTo(body.getMerchant_extend_field_4());
        }
        //交易客户保留字段5
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_5())) {
            criteria.andMerchantExtendField5EqualTo(body.getMerchant_extend_field_5());
        }
        //交易客户保留字段6
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_6())) {
            criteria.andMerchantExtendField1EqualTo(body.getMerchant_extend_field_6());
        }
        //交易客户保留字段7
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_7())) {
            criteria.andMerchantExtendField2EqualTo(body.getMerchant_extend_field_7());
        }
        //交易客户保留字段8
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_8())) {
            criteria.andMerchantExtendField3EqualTo(body.getMerchant_extend_field_8());
        }
        //交易客户保留字段9
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_9())) {
            criteria.andMerchantExtendField4EqualTo(body.getMerchant_extend_field_9());
        }
        //交易客户保留字段10
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_10())) {
            criteria.andMerchantExtendField5EqualTo(body.getMerchant_extend_field_10());
        }
        
        //交易客户保留字段1(模糊)
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_1_fuzzy())) {
            criteria.andMerchantExtendField1Like(body.getMerchant_extend_field_1_fuzzy());
        }
        //交易客户保留字段2(模糊)
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_2_fuzzy())) {
            criteria.andMerchantExtendField2Like(body.getMerchant_extend_field_2_fuzzy());
        }
        //交易客户保留字段3(模糊)
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_3_fuzzy())) {
            criteria.andMerchantExtendField3Like(body.getMerchant_extend_field_3_fuzzy());
        }
        //交易客户保留字段4(模糊)
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_4_fuzzy())) {
            criteria.andMerchantExtendField4Like(body.getMerchant_extend_field_4_fuzzy());
        }
        //交易客户保留字段5(模糊)
        if (!StringUtil.isEmpty(body.getMerchant_extend_field_5_fuzzy())) {
            criteria.andMerchantExtendField5Like(body.getMerchant_extend_field_5_fuzzy());
        }
        //交易创建日期时间起始
        if(!StringUtil.isEmpty(body.getGmt_created_start())){
        	criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(body.getGmt_created_start()));
        }
        //交易创建日期时间结束
        if(!StringUtil.isEmpty(body.getGmt_created_end())){
        	criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(body.getGmt_created_end()));
        }
        //最后变更日期时间起始
        if(!StringUtil.isEmpty(body.getGmt_latest_modified_start())){
        	criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(body.getGmt_latest_modified_start()));
        }
        //最后变更日期时间结束
        if(!StringUtil.isEmpty(body.getGmt_latest_modified_end())){
        	criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(body.getGmt_latest_modified_end()));
        }
        //交易组别
        if (org.apache.commons.lang3.StringUtils.isNotBlank(body.getTrade_catagory())) {
            if (body.getTrade_catagory().contains("^")) {
                criteria.andTradeCatagoryIn(TradeStatusUtils.parseToList(body.getTrade_catagory(), "\\^"));
            } else {
                criteria.andTradeCatagoryEqualTo(body.getTrade_catagory());
            }
        }
       
        //交易状态
        if (org.apache.commons.lang3.StringUtils.isNotBlank(body.getStatus())) {
            if (body.getStatus().contains("^")) {
                criteria.andStatusIn(TradeStatusUtils.parseToList(body.getStatus(), "\\^"));
            } else {
                criteria.andStatusEqualTo(body.getStatus());
            }
        }

        //查询结果 total
        List<TradeSinglePayment> results = null;
        int total = singlePaymentService.selectCountByExample(example);
        if (0 < total) {
            example.setOrderByClause("gmt_created DESC");
            tradeResponse.getBody().setResultCount(total + "");
            results = singlePaymentService.pageQueryByExample(example);
        } else {
            tradeResponse.getBody().setResultCount("0");
            tradeResponse.getBody().setTrade_details(null);
        }

        return results;
    }

}