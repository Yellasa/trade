package com.liantuo.trade.bus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ebill.framework.datatype.StringUtil;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.single_recharge.QueryPage4RechargeDetail;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeStatusUtils;
import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.orm.pojo.TradeRechargeExample;
import com.liantuo.trade.orm.pojo.TradeRechargeExample.Criteria;
import com.liantuo.trade.orm.service.TradeRechargeService;

@Component(value = "rechargePageQueryServiceImpl")
public class RechargePageQueryServiceImpl implements com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService<TradeRequest<QueryPage4RechargeDetail>> {

    @Resource(name = "tradeRechargeServiceImpl")
    private TradeRechargeService rechargeService;

    @Override
    public Object queryByPage(TradeRequest<QueryPage4RechargeDetail> req, TradeResponse tradeResponse) {
        TradePacketHead head = req.getHead();
        QueryPage4RechargeDetail body = req.getBody();
        TradeRechargeExample example = new TradeRechargeExample();
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
        //交易发起方发起请求编号
        if (!StringUtil.isEmpty(body.getOut_trade_no_ext())) {
            criteria.andOutTradeNoExtEqualTo(body.getOut_trade_no_ext());
        }
        //交易发起发起方业务系统订单号
        if (!StringUtil.isEmpty(body.getOut_trade_no())) {
            criteria.andOutTradeNoEqualTo(body.getOut_trade_no());
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
        	criteria.andGmtLatestModifiedGreaterThanOrEqualTo(DateUtil.formatDateTime(body.getGmt_latest_modified_start()));
        }
        //最后变更日期时间截止
        if(!StringUtil.isEmpty(body.getGmt_latest_modified_end())){
        	criteria.andGmtLatestModifiedLessThanOrEqualTo(DateUtil.formatDateTime(body.getGmt_latest_modified_end()));
        }
        //充值CA账户编号
        if(!StringUtil.isEmpty(body.getRecharge_account_no())){
        	criteria.andRechargeAccountNoEqualTo(body.getRecharge_account_no());
        }
        //充值成员商户编号
        if(!StringUtil.isEmpty(body.getRecharge_merchant_no())){
        	criteria.andRechargeMerchantNoEqualTo(body.getRecharge_merchant_no());
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
        List<TradeRecharge> results = null;
        int total = rechargeService.selectCountByExample(example);
        if (0 < total) {
            example.setOrderByClause("gmt_created DESC");
            tradeResponse.getBody().setResultCount(total + "");
            results = rechargeService.pageQueryByExample(example, body);
        } else {
            tradeResponse.getBody().setResultCount("0");
            tradeResponse.getBody().setTrade_details(null);
        }

        return results;
    }

}