package com.liantuo.trade.bus.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.trade.bus.service.BizTradePageQueryService;
import com.liantuo.trade.bus.vo.TradePageQueryPaymentBizVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyPayPageDetails;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqPayPageDetails;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;
import com.liantuo.trade.orm.pojo.TradePaymentExample.Criteria;
import com.liantuo.trade.orm.service.TradePaymentService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component(value = "bizPaymentTradePageQueryServiceImpl")
public class BizPaymentTradePageQueryServiceImpl
        implements BizTradePageQueryService<TradePacketReqPayPageDetails, TradePageQueryPaymentBizVO>
        , com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService<TradeRequest<TradePacketReqBodyPayPageDetails>> {

    @Resource(name = "tradePaymentService")
    private TradePaymentService paymentService;

    /**
     * 交易列表查询 v1.0
     */
    @Override
    public TradePageQueryPaymentBizVO queryByPage(TradePacketReqPayPageDetails req, TradePageQueryPaymentBizVO trade) {
        TradePaymentExample example = new TradePaymentExample();

        TradePacketReqBodyPayPageDetails reqBody = req.getBody();
        //核心商户号
        Criteria condition = example.createCriteria();

        condition.andCoreMerchantNoEqualTo(req.getBusHead().getCore_merchant_no());                                                 //资金池编号
        condition.andFundPoolNoEqualTo(req.getBusHead().getFund_pool_no());                                                         //资金池编号
//    	condition.andVersionEqualTo(Float.parseFloat(req.getBusHead().getVersion()));                                               //版本号
        if (!StringUtils.isEmpty(reqBody.getTrade_no())) {
            condition.andTradeNoEqualTo(reqBody.getTrade_no());                                                            //交易编号
        }
        if (!StringUtils.isEmpty(reqBody.getOut_trade_no_ext())) {
            condition.andOutTradeNoExtEqualTo(reqBody.getOut_trade_no_ext());                                              //交易发起方发起请求编号
        }
        if (!StringUtils.isEmpty(reqBody.getPayment_merchant_no())) {
            condition.andPaymentMerchantNoEqualTo(reqBody.getPayment_merchant_no());                                       //原付出成员商户编号
        }
        if (!StringUtils.isEmpty(reqBody.getReceive_merchant_no())) {
            condition.andReceiveMerchantNoEqualTo(reqBody.getReceive_merchant_no());                                       //原收款成员商户编号
        }
        try {

            if (!StringUtils.isEmpty(reqBody.getGmt_created_start())) {
                condition.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_start()));               //交易创建日期 区间查询
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_created_end())) {
                condition.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_end()));
            }

            if (!StringUtils.isEmpty(reqBody.getGmt_latest_modified_start())) {
                condition.andGmtLatestModifiedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_latest_modified_start()));//交易最后变更日期  区间查询
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_latest_modified_end())) {
                condition.andGmtLatestModifiedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_latest_modified_end()));
            }
        } catch (Exception e) {
            throw new BizRuntimeException("trade.details.date.error");
        }

        if (TradeConstants.TRADE_TYPE_PAYMENT_MAXRECORDS < paymentService.selectCountByPaymentExample(example)) {
            throw new BizRuntimeException("trade.details.size.over.limit");
        }

        if (0 < paymentService.selectCountByPaymentExample(example)) {
            example.setOrderByClause("gmt_created desc");
            List<TradePayment> tradePayments = paymentService.queryExample(example);
            trade.setList(tradePayments);
        }
        return trade;
    }

    /**
     * 交易列表查询 v1.1
     */
    @Override
    public Object queryByPage(TradeRequest<TradePacketReqBodyPayPageDetails> req, TradeResponse tradeResponse) {
        TradePaymentExample example = new TradePaymentExample();
        TradePacketReqBodyPayPageDetails reqBody = req.getBody();
        //核心商户号
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

        if (!StringUtils.isEmpty(reqBody.getTrade_no())) {                                                                      //交易编号
            accurateCondition.andTradeNoEqualTo(reqBody.getTrade_no());
        }

        if (!StringUtils.isEmpty(reqBody.getOut_trade_no())) {
            accurateCondition.andOutTradeNoEqualTo(reqBody.getOut_trade_no());
        }

        if (!StringUtils.isEmpty(reqBody.getOut_trade_no_ext())) {
            accurateCondition.andOutTradeNoExtEqualTo(reqBody.getOut_trade_no_ext());
        }

        //付
        if (!StringUtils.isEmpty(reqBody.getPayment_merchant_no())) {
            accurateCondition.andPaymentMerchantNoEqualTo(reqBody.getPayment_merchant_no());                                        //原付出成员商户编号
        }
        if (!StringUtils.isEmpty(reqBody.getPayment_account_no())) {
            accurateCondition.andPaymentAccountNoEqualTo(reqBody.getPayment_account_no());                                          //付出CA账户编号
        }
        //收
        if (!StringUtils.isEmpty(reqBody.getReceive_merchant_no())) {
            accurateCondition.andReceiveMerchantNoEqualTo(reqBody.getReceive_merchant_no());                                        //原收款成员商户编号
        }
        if (!StringUtils.isEmpty(reqBody.getReceive_account_no())) {
            accurateCondition.andReceiveAccountNoEqualTo(reqBody.getReceive_account_no());                                          //收款CA账户编号
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
            if (!StringUtils.isEmpty(reqBody.getGmt_created_start())) {
                accurateCondition.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_start()));               //交易创建日期 区间查询
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_created_end())) {
                accurateCondition.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_end()));
            }

            if (!StringUtils.isEmpty(reqBody.getGmt_latest_modified_start())) {
                accurateCondition.andGmtLatestModifiedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_latest_modified_start()));//交易最后变更日期  区间查询
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_latest_modified_end())) {
                accurateCondition.andGmtLatestModifiedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_latest_modified_end()));
            }

            if (!StringUtils.isEmpty(reqBody.getGmt_freeze_success_datetime_start())) {
                accurateCondition.andGmtFreezeGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_freeze_success_datetime_start()));
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_freeze_success_datetime_end())) {
                accurateCondition.andGmtFreezeLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_freeze_success_datetime_end()));
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_un_freeze_success_datetime_start())) {
                accurateCondition.andGmtUnfreezeGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_un_freeze_success_datetime_start()));
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_un_freeze_success_datetime_end())) {
                accurateCondition.andGmtUnfreezeLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_un_freeze_success_datetime_end()));
            }
            if (!StringUtils.isEmpty(reqBody.getGmt_un_freeze_settlement_success_datetime_start())) {
                accurateCondition.andGmtUnfreezeDedcutGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_un_freeze_settlement_success_datetime_start()));

            }
            if (!StringUtils.isEmpty(reqBody.getGmt_un_freeze_settlement_success_datetime_end())) {
                accurateCondition.andGmtUnfreezeDedcutLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_un_freeze_settlement_success_datetime_end()));
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

        //查询结果 total
        List<TradePayment> tradePayments = null;
        int total = paymentService.selectCountByPaymentExample(example);

        if (0 < total) {
            example.setOrderByClause("gmt_created desc");
            tradePayments = paymentService.pageQueryByExample(example, reqBody);
            tradeResponse.getBody().setResultCount(total + "");
        } else {
            tradeResponse.getBody().setResultCount("0");
            tradeResponse.getBody().setTrade_details(null);
        }

        return tradePayments;
    }
}