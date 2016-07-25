package com.liantuo.trade.bus.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.trade.bus.service.BizTradePageQueryService;
import com.liantuo.trade.bus.vo.TradePageQueryRefundBizVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundPageDetails;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqRefundPageDetails;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.pojo.TradeRefund;
import com.liantuo.trade.orm.pojo.TradeRefundExample;
import com.liantuo.trade.orm.pojo.TradeRefundExample.Criteria;
import com.liantuo.trade.orm.service.TradeRefundService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component(value = "bizRefundTradePageQueryServiceImpl")
public class BizRefundTradePageQueryServiceImpl implements BizTradePageQueryService<TradePacketReqRefundPageDetails, TradePageQueryRefundBizVO>
        , com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService<TradeRequest<TradePacketReqBodyRefundPageDetails>> {

    @Resource(name = "tradeRefundService")
    private TradeRefundService refundService;

    /**
     * 退款交易列表查询
     * v1.0
     */
    @Override
    public TradePageQueryRefundBizVO queryByPage(TradePacketReqRefundPageDetails req, TradePageQueryRefundBizVO trade) {
        TradeRefundExample example = new TradeRefundExample();
        TradePacketReqBodyRefundPageDetails refundCondition = req.getBody();

        Criteria condition = example.createCriteria();
        //核心商户号
        condition.andCoreMerchantNoEqualTo(req.getBusHead().getCore_merchant_no());
        //资金池编号
        condition.andFundPoolNoEqualTo(req.getBusHead().getFund_pool_no());
        //交易编号
        if (!StringUtils.isEmpty(refundCondition.getTrade_no())) {
            condition.andTradeNoEqualTo(refundCondition.getTrade_no());
        }
        //交易发起方发起请求编号
        if (!StringUtils.isEmpty(refundCondition.getOut_trade_no_ext())) {
            condition.andOutTradeNoExtEqualTo(refundCondition.getOut_trade_no_ext());
        }

        //原付出成员商户编号
        if (!StringUtils.isEmpty(refundCondition.getRefund_merchant_no())) {
            condition.andRefundMerchantNoEqualTo(refundCondition.getRefund_merchant_no());
        }
        //原收款成员商户编号
        if (!StringUtils.isEmpty(refundCondition.getReceive_merchant_no())) {
            condition.andReceiveMerchantNoEqualTo(refundCondition.getReceive_merchant_no());
        }
        try {
            //交易创建日期 区间查询
            if (!StringUtils.isEmpty(refundCondition.getGmt_created_start())) {
                condition.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(refundCondition.getGmt_created_start()));

            }
            if (!StringUtils.isEmpty(refundCondition.getGmt_created_end())) {
                condition.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(refundCondition.getGmt_created_end()));
            }
            //交易最后变更日期  区间查询
            if (!StringUtils.isEmpty(refundCondition.getGmt_latest_modified_start())) {
                condition.andGmtLatestModifiedGreaterThanOrEqualTo(DateUtil.formatDateTime(refundCondition.getGmt_latest_modified_start()));
            }
            if (!StringUtils.isEmpty(refundCondition.getGmt_latest_modified_end())) {
                condition.andGmtLatestModifiedLessThanOrEqualTo(DateUtil.formatDateTime(refundCondition.getGmt_latest_modified_end()));
            }

        } catch (Exception e) {
            throw new BizRuntimeException("trade.details.date.error");
        }

        if (refundService.selectCountByExample(example) > TradeConstants.TRADE_TYPE_REFUND_MAXRECORDS) {
            throw new BizRuntimeException("trade.details.size.over.limit");
        }

        if (refundService.selectCountByExample(example) > 0) {
            example.setOrderByClause("gmt_created desc");
            List<TradeRefund> refunds = refundService.queryTradeRefund(example);
            trade.setList(refunds);
        }

        return trade;
    }

    /**
     * 退款交易列表查询
     * v1.1
     */
    @Override
    public Object queryByPage(TradeRequest<TradePacketReqBodyRefundPageDetails> req, TradeResponse tradeResponse) {
        TradeRefundExample example = new TradeRefundExample();
        TradePacketReqBodyRefundPageDetails reqBody = req.getBody();

        Criteria accurateCondition = example.createCriteria();
//        Criteria fuzzyCondition = example.createCriteria();
//        example.or(fuzzyCondition);

        TradePacketHead head = req.getHead();
        if (!StringUtils.isEmpty(head.getCore_merchant_no())) {                                                                      //交易编号
            accurateCondition.andCoreMerchantNoEqualTo(req.getHead().getCore_merchant_no());                                                 //核心商户编号
        }

        if (!StringUtils.isEmpty(head.getFund_pool_no())) {                                                                      //交易编号
            accurateCondition.andFundPoolNoEqualTo(req.getHead().getFund_pool_no());                                                         //资金池编号
        }
        //交易编号
        if (!StringUtils.isEmpty(reqBody.getTrade_no())) {
            accurateCondition.andTradeNoEqualTo(reqBody.getTrade_no());
        }

        if (!StringUtils.isEmpty(reqBody.getOut_trade_no_ext())) {
            accurateCondition.andOutTradeNoExtEqualTo(reqBody.getOut_trade_no_ext());
        }

        if (!StringUtils.isEmpty(reqBody.getOut_trade_no())) {
            accurateCondition.andOutTradeNoEqualTo(reqBody.getOut_trade_no());
        }

        if (!StringUtils.isEmpty(reqBody.getClear_order_no())) {
            accurateCondition.andClearOrderNoEqualTo(reqBody.getClear_order_no());
        }

        //原付出成员商户编号
        if (!StringUtils.isEmpty(reqBody.getRefund_merchant_no())) {
            accurateCondition.andRefundMerchantNoEqualTo(reqBody.getRefund_merchant_no());
        }
        if (!StringUtils.isEmpty(reqBody.getRefund_account_no())) {
            accurateCondition.andRefundAccountNoEqualTo(reqBody.getRefund_account_no());
        }
        //原收款成员商户编号
        if (!StringUtils.isEmpty(reqBody.getReceive_merchant_no())) {
            accurateCondition.andReceiveMerchantNoEqualTo(reqBody.getReceive_merchant_no());
        }
        if (!StringUtils.isEmpty(reqBody.getReceive_account_no())) {
            accurateCondition.andReceiveAccountNoEqualTo(reqBody.getReceive_account_no());
        }

        //交易状态
        // 交易状态 枚举 可空 精确查询条件
        if (org.apache.commons.lang3.StringUtils.isNotBlank(reqBody.getStatus())) {
            if (reqBody.getStatus().contains("^")) {
                String[] arr = reqBody.getStatus().split("\\^");
                List<String> list = Arrays.asList(arr);
                Collections.sort(list);
                accurateCondition.andStatusIn(list);
            } else {
                accurateCondition.andStatusEqualTo(reqBody.getStatus());
            }
        }
        try {
            //交易创建日期 区间查询
            if (!StringUtils.isEmpty(reqBody.getGmt_created_start())) {
                accurateCondition.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_start()));

            }
            if (!StringUtils.isEmpty(reqBody.getGmt_created_end())) {
                accurateCondition.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_end()));
            }
            //交易最后变更日期  区间查询
            if (!StringUtils.isEmpty(reqBody.getGmt_latest_modified_start())) {
                accurateCondition.andGmtLatestModifiedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_latest_modified_start()));
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_latest_modified_end())) {
                accurateCondition.andGmtLatestModifiedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_latest_modified_end()));
            }

            if (!StringUtils.isEmpty(reqBody.getGmt_refund_success_start())) {
                accurateCondition.andGmtRefundSuccessGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_refund_success_start()));
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_refund_success_end())) {
                accurateCondition.andGmtRefundSuccessLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_refund_success_end()));
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_fund_channel_refund_success_start())) {
                accurateCondition.andGmtSuccessClearChannelGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_fund_channel_refund_success_start()));

            }
            if (!StringUtils.isEmpty(reqBody.getGmt_fund_channel_refund_success_end())) {
                accurateCondition.andGmtSuccessClearChannelLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_fund_channel_refund_success_end()));
            }

        } catch (Exception e) {
            throw new BizRuntimeException("trade.details.date.error");
        }

        //精确查询
        if (!StringUtils.isEmpty(reqBody.getExtend_field_1_accurate_query())) {
            accurateCondition.andMerchantExtendField1EqualTo(reqBody.getExtend_field_1_accurate_query());
        }
        if (!StringUtils.isEmpty(reqBody.getExtend_field_2_accurate_query())) {
            accurateCondition.andMerchantExtendField2EqualTo(reqBody.getExtend_field_2_accurate_query());
        }
        if (!StringUtils.isEmpty(reqBody.getExtend_field_3_accurate_query())) {
            accurateCondition.andMerchantExtendField3EqualTo(reqBody.getExtend_field_3_accurate_query());
        }
        if (!StringUtils.isEmpty(reqBody.getExtend_field_4_accurate_query())) {
            accurateCondition.andMerchantExtendField4EqualTo(reqBody.getExtend_field_4_accurate_query());
        }
        if (!StringUtils.isEmpty(reqBody.getExtend_field_5_accurate_query())) {
            accurateCondition.andMerchantExtendField5EqualTo(reqBody.getExtend_field_5_accurate_query());
        }

        //模糊查询
        if (StringUtils.isEmpty(reqBody.getExtend_field_1_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_1_fuzzy_query())) {
            accurateCondition.andMerchantExtendField1Like("%" + reqBody.getExtend_field_1_fuzzy_query() + "%");
        }
        if (StringUtils.isEmpty(reqBody.getExtend_field_2_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_2_fuzzy_query())) {
            accurateCondition.andMerchantExtendField2Like("%" + reqBody.getExtend_field_2_fuzzy_query() + "%");
        }
        if (StringUtils.isEmpty(reqBody.getExtend_field_3_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_3_fuzzy_query())) {
            accurateCondition.andMerchantExtendField3Like("%" + reqBody.getExtend_field_3_fuzzy_query() + "%");
        }
        if (StringUtils.isEmpty(reqBody.getExtend_field_4_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_4_fuzzy_query())) {
            accurateCondition.andMerchantExtendField4Like("%" + reqBody.getExtend_field_4_fuzzy_query() + "%");
        }
        if (StringUtils.isEmpty(reqBody.getExtend_field_5_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_5_fuzzy_query())) {
            accurateCondition.andMerchantExtendField5Like("%" + reqBody.getExtend_field_5_fuzzy_query() + "%");
        }

        List<TradeRefund> refunds = null;
        int total = refundService.selectCountByExample(example);
        if (0 < total) {
            example.setOrderByClause("gmt_created desc");
            tradeResponse.getBody().setResultCount(total + "");
            refunds = refundService.pageQueryByExample(example, reqBody);
        } else {
            tradeResponse.getBody().setResultCount("0");
            tradeResponse.getBody().setTrade_details(null);
        }

        return refunds;
    }
}