package com.liantuo.trade.bus.service.impl;

import com.liantuo.trade.bus.service.BizTradePageQueryService;
import com.liantuo.trade.bus.vo.WithdrawQueryBizVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawPageDetails;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPageDetails;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawExample;
import com.liantuo.trade.orm.pojo.TradeWithdrawExample.Criteria;
import com.liantuo.trade.orm.service.TradeWithdrawService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component(value = "withdrawPageQueryServiceImpl")
public class WithdrawPageQueryServiceImpl
        implements BizTradePageQueryService<TradePacketReqSingleWithdrawPageDetails, WithdrawQueryBizVO>,
        com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService<TradeRequest<TradePacketReqBodySingleWithdrawPageDetails>> {

    @Resource(name = "tradeWithdrawService")
    private TradeWithdrawService tradeWithdrawService;

    /**
     * 交易列表查询
     * v1.0
     */
    @Override
    public WithdrawQueryBizVO queryByPage(TradePacketReqSingleWithdrawPageDetails req, WithdrawQueryBizVO trade) {
        TradePacketReqBodySingleWithdrawPageDetails reqBody = req.getBody();
        TradeWithdrawExample example = new TradeWithdrawExample();

        Criteria accurateCondition = example.createCriteria();
        // 核心商户号
        accurateCondition.andCoreMerchantNoEqualTo(req.getBusHead().getCore_merchant_no());
        // 资金池编号
        accurateCondition.andFundPoolNoEqualTo(req.getBusHead().getFund_pool_no());

        // 交易编号
        if (StringUtils.isNotBlank(reqBody.getTrade_no())) {
            accurateCondition.andTradeNoEqualTo(reqBody.getTrade_no());
        }

        // 交易客户保留字段1 merchant_extend_field_1 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_1())) {
            accurateCondition.andMerchantExtendField1EqualTo(reqBody.getMerchant_extend_field_1());
        }
        // 交易客户保留字段2 merchant_extend_field_2 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_2())) {
            accurateCondition.andMerchantExtendField2EqualTo(reqBody.getMerchant_extend_field_2());
        }
        // 交易客户保留字段3 merchant_extend_field_3 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_3())) {
            accurateCondition.andMerchantExtendField3EqualTo(reqBody.getMerchant_extend_field_3());
        }
        // 交易客户保留字段4 merchant_extend_field_4 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_4())) {
            accurateCondition.andMerchantExtendField4EqualTo(reqBody.getMerchant_extend_field_4());
        }
        // 交易客户保留字段5 merchant_extend_field_5 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_5())) {
            accurateCondition.andMerchantExtendField5EqualTo(reqBody.getMerchant_extend_field_5());
        }
        // 交易发起方发起请求编号 字符串 64 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getOut_trade_no_ext())) {
            accurateCondition.andOutTradeNoExtEqualTo(reqBody.getOut_trade_no_ext());
        }
        // 交易发起方业务系统订单号 字符串 64 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getOut_trade_no())) {
            accurateCondition.andOutTradeNoEqualTo(reqBody.getOut_trade_no());
        }
        // 交易状态 枚举 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getStatus())) {
            if (reqBody.getStatus().contains("^")) {
                String[] arr = reqBody.getStatus().split("\\^");
                List<String> list = Arrays.asList(arr);
                Collections.sort(list);
                accurateCondition.andStatusIn(list);
            } else {
                accurateCondition.andStatusEqualTo(reqBody.getStatus());
            }
        }
        // 出款渠道编号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getPay_clear_channel())) {
            accurateCondition.andPayClearChannelEqualTo(reqBody.getPay_clear_channel());
        }
        // 提交第三方批次号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_batch_no())) {
            accurateCondition.andWithdrawBatchNoEqualTo(reqBody.getWithdraw_batch_no());
        }
        // 提交第三方批次流水号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_serial_number())) {
            accurateCondition.andWithdrawSerialNumberEqualTo(reqBody.getWithdraw_serial_number());
        }
        // 出款渠道订单号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getPay_third_trade_no())) {
            accurateCondition.andPayThirdTradeNoEqualTo(reqBody.getPay_third_trade_no());
        }
        // 付款方账户 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getPayer_account())) {
            accurateCondition.andPayerAccountEqualTo(reqBody.getPayer_account());
        }
        // 付款方账户名称 字符串 可空 模糊查询条件
        if (StringUtils.isNotBlank(reqBody.getPayer_name())) {
            accurateCondition.andPayerNameLike(reqBody.getPayer_name());
        }
        // 提现CA账户编号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_account_no())) {
            accurateCondition.andWithdrawAccountNoEqualTo(reqBody.getWithdraw_account_no());
        }
        // 提现成员商户编号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_merchant_no())) {
            accurateCondition.andWithdrawMerchantNoEqualTo(reqBody.getWithdraw_merchant_no());
        }
        // 提现银行/账户编码 枚举 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_account_type())) {
            accurateCondition.andWithdrawAccountTypeEqualTo(reqBody.getWithdraw_account_type());
        }
        // 提现银行账户 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_bank_account())) {
            accurateCondition.andWithdrawBankAccountEqualTo(reqBody.getWithdraw_bank_account());
        }
        // 提现第三方账户 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_third_account())) {
            accurateCondition.andWithdrawThirdAccountEqualTo(reqBody.getWithdraw_third_account());
        }
        // 提现第三方账户姓名 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_third_account_name())) {
            accurateCondition.andWithdrawThirdAccountNameEqualTo(reqBody.getWithdraw_third_account_name());
        }
        try {
            // 交易创建日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_created_start())) {
                accurateCondition.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_start()));
            }
            // 交易创建日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_created_end())) {
                accurateCondition.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_end()));
            }
            // 交易创建失败日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_created_fail_start())) {
                accurateCondition.andGmtCreatedFailGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_fail_start()));
            }
            // 交易创建失败日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_created_fail_end())) {
                accurateCondition.andGmtCreatedFailLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_fail_end()));
            }
            // 扣减成功日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_deduct_success_start())) {
                accurateCondition.andGmtDeductSuccessGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_deduct_success_start()));
            }
            // 扣减成功日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_deduct_success_end())) {
                accurateCondition.andGmtDeductSuccessLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_deduct_success_end()));
            }
            // 出款成功日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_pay_success_start())) {
                accurateCondition.andGmtPaySuccessGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_pay_success_start()));
            }
            // 出款成功日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_pay_success_end())) {
                accurateCondition.andGmtPaySuccessLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_pay_success_end()));
            }
            // 退回成功日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_refund_success_start())) {
                accurateCondition.andGmtRefundSuccessGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_refund_success_start()));
            }
            // 退回成功日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_refund_success_end())) {
                accurateCondition.andGmtRefundSuccessLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_refund_success_end()));
            }
            // 最后出款失败日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_last_pay_fail_start())) {
                accurateCondition.andGmtLastPayFailGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_last_pay_fail_start()));
            }
            // 最后出款失败日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_last_pay_fail_end())) {
                accurateCondition.andGmtLastPayFailLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_last_pay_fail_end()));
            }
        } catch (Exception e) {
            throw new BizRuntimeException("trade.details.date.error");
        }

        example.setOrderByClause("gmt_created DESC");

        trade.setResultCount(tradeWithdrawService.queryCount(example).toString());

        List<TradeWithdraw> withdraws = tradeWithdrawService.queryPageByExample(example, reqBody);
        if(CollectionUtils.isNotEmpty(withdraws)){
            trade.setList(withdraws);
        }

        return trade;
    }

    /**
     * v1.1
     *
     * @param req
     * @return
     */
    @Override
    public Object queryByPage(TradeRequest<TradePacketReqBodySingleWithdrawPageDetails> req, TradeResponse tradeResponse) {
        TradePacketReqBodySingleWithdrawPageDetails reqBody = req.getBody();
        TradeWithdrawExample example = new TradeWithdrawExample();

        Criteria criteria = example.createCriteria();

        TradePacketHead head = req.getHead();
        if (!com.alibaba.druid.util.StringUtils.isEmpty(head.getCore_merchant_no())) {                                                                      //交易编号
            criteria.andCoreMerchantNoEqualTo(req.getHead().getCore_merchant_no());                                                 //核心商户编号
        }

        if (!com.alibaba.druid.util.StringUtils.isEmpty(head.getFund_pool_no())) {                                                                      //交易编号
            criteria.andFundPoolNoEqualTo(req.getHead().getFund_pool_no());                                                         //资金池编号
        }

        // 交易编号
        if (StringUtils.isNotBlank(reqBody.getTrade_no())) {
            criteria.andTradeNoEqualTo(reqBody.getTrade_no());
        }

        // 交易客户保留字段1 merchant_extend_field_1 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_1())) {
            criteria.andMerchantExtendField1EqualTo(reqBody.getMerchant_extend_field_1());
        }
        // 交易客户保留字段2 merchant_extend_field_2 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_2())) {
            criteria.andMerchantExtendField2EqualTo(reqBody.getMerchant_extend_field_2());
        }
        // 交易客户保留字段3 merchant_extend_field_3 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_3())) {
            criteria.andMerchantExtendField3EqualTo(reqBody.getMerchant_extend_field_3());
        }
        // 交易客户保留字段4 merchant_extend_field_4 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_4())) {
            criteria.andMerchantExtendField4EqualTo(reqBody.getMerchant_extend_field_4());
        }
        // 交易客户保留字段5 merchant_extend_field_5 字符串 1024 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getMerchant_extend_field_5())) {
            criteria.andMerchantExtendField5EqualTo(reqBody.getMerchant_extend_field_5());
        }
        // 交易发起方发起请求编号 字符串 64 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getOut_trade_no_ext())) {
            criteria.andOutTradeNoExtEqualTo(reqBody.getOut_trade_no_ext());
        }
        // 交易发起方业务系统订单号 字符串 64 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getOut_trade_no())) {
            criteria.andOutTradeNoEqualTo(reqBody.getOut_trade_no());
        }
        // 交易状态 枚举 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getStatus())) {
            if (reqBody.getStatus().contains("^")) {
                String[] arr = reqBody.getStatus().split("\\^");
                List<String> list = Arrays.asList(arr);
                Collections.sort(list);
                criteria.andStatusIn(list);
            } else {
                criteria.andStatusEqualTo(reqBody.getStatus());
            }
        }
        // 出款渠道编号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getPay_clear_channel())) {
            criteria.andPayClearChannelEqualTo(reqBody.getPay_clear_channel());
        }
        // 提交第三方批次号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_batch_no())) {
            criteria.andWithdrawBatchNoEqualTo(reqBody.getWithdraw_batch_no());
        }
        // 提交第三方批次流水号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_serial_number())) {
            criteria.andWithdrawSerialNumberEqualTo(reqBody.getWithdraw_serial_number());
        }
        // 出款渠道订单号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getPay_third_trade_no())) {
            criteria.andPayThirdTradeNoEqualTo(reqBody.getPay_third_trade_no());
        }
        // 付款方账户 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getPayer_account())) {
            criteria.andPayerAccountEqualTo(reqBody.getPayer_account());
        }
        // 付款方账户名称 字符串 可空 模糊查询条件
        if (StringUtils.isNotBlank(reqBody.getPayer_name())) {
            criteria.andPayerNameLike(reqBody.getPayer_name());
        }
        // 提现CA账户编号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_account_no())) {
            criteria.andWithdrawAccountNoEqualTo(reqBody.getWithdraw_account_no());
        }
        // 提现成员商户编号 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_merchant_no())) {
            criteria.andWithdrawMerchantNoEqualTo(reqBody.getWithdraw_merchant_no());
        }
        // 提现银行/账户编码 枚举 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_account_type())) {
            criteria.andWithdrawAccountTypeEqualTo(reqBody.getWithdraw_account_type());
        }
        // 提现银行账户 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_bank_account())) {
            criteria.andWithdrawBankAccountEqualTo(reqBody.getWithdraw_bank_account());
        }
        // 提现第三方账户 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_third_account())) {
            criteria.andWithdrawThirdAccountEqualTo(reqBody.getWithdraw_third_account());
        }
        // 提现第三方账户姓名 字符串 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getWithdraw_third_account_name())) {
            criteria.andWithdrawThirdAccountNameEqualTo(reqBody.getWithdraw_third_account_name());
        }
        try {
            // 交易创建日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_created_start())) {
                criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_start()));
            }
            // 交易创建日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_created_end())) {
                criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_end()));
            }
            // 交易创建失败日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_created_fail_start())) {
                criteria.andGmtCreatedFailGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_fail_start()));
            }
            // 交易创建失败日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_created_fail_end())) {
                criteria.andGmtCreatedFailLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_fail_end()));
            }
            // 扣减成功日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_deduct_success_start())) {
                criteria.andGmtDeductSuccessGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_deduct_success_start()));
            }
            // 扣减成功日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_deduct_success_end())) {
                criteria.andGmtDeductSuccessLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_deduct_success_end()));
            }
            // 出款成功日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_pay_success_start())) {
                criteria.andGmtPaySuccessGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_pay_success_start()));
            }
            // 出款成功日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_pay_success_end())) {
                criteria.andGmtPaySuccessLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_pay_success_end()));
            }
            // 退回成功日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_refund_success_start())) {
                criteria.andGmtRefundSuccessGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_refund_success_start()));
            }
            // 退回成功日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_refund_success_end())) {
                criteria.andGmtRefundSuccessLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_refund_success_end()));
            }
            // 最后出款失败日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_last_pay_fail_start())) {
                criteria.andGmtLastPayFailGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_last_pay_fail_start()));
            }
            // 最后出款失败日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_last_pay_fail_end())) {
                criteria.andGmtLastPayFailLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_last_pay_fail_end()));
            }
        } catch (Exception e) {
            throw new BizRuntimeException("trade.details.date.error");
        }

        //查询结果 total
        List<TradeWithdraw> results = null;
        Long total = tradeWithdrawService.queryCount(example);
        if (0 < total) {
            example.setOrderByClause("gmt_created DESC");
            tradeResponse.getBody().setResultCount(total + "");
            results = tradeWithdrawService.queryPageByExample(example, reqBody);
        } else {
            tradeResponse.getBody().setResultCount("0");
            tradeResponse.getBody().setTrade_details(null);
        }

        return results;
    }
}