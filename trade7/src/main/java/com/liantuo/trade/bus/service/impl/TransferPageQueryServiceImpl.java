package com.liantuo.trade.bus.service.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.simple_fund_transfer.QueryPage4TransferDetail;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.pojo.TradeTransferAccount;
import com.liantuo.trade.orm.pojo.TradeTransferAccountExample;
import com.liantuo.trade.orm.pojo.TradeTransferAccountExample.Criteria;
import com.liantuo.trade.orm.service.TradeTransferAccountService;

@Component(value = "transferPageQueryServiceImpl")
public class TransferPageQueryServiceImpl
        implements com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService<TradeRequest<QueryPage4TransferDetail>> {

	@Resource(name = "tradeTransferAccountServiceImpl")
    private TradeTransferAccountService transferService;
	
	@Autowired
	private ExceptionService exceptionService;

    /**
     * v1.1
     *
     * @param req
     * @return
     */
    @Override
    public Object queryByPage(TradeRequest<QueryPage4TransferDetail> req, TradeResponse tradeResponse) {
    	QueryPage4TransferDetail reqBody = req.getBody();
        TradeTransferAccountExample example = new TradeTransferAccountExample();

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
     // 交易发起方发起请求编号 字符串 64 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getOut_trade_no_ext())) {
            criteria.andOutTradeNoExtEqualTo(reqBody.getOut_trade_no_ext());
        }
        // 交易发起方业务系统订单号 字符串 64 可空 精确查询条件
        if (StringUtils.isNotBlank(reqBody.getOut_trade_no())) {
            criteria.andOutTradeNoEqualTo(reqBody.getOut_trade_no());
        }
        
        //付
        if (!StringUtils.isEmpty(reqBody.getPayment_merchant_no())) {
            criteria.andPaymentMerchantNoEqualTo(reqBody.getPayment_merchant_no());                                        //原付出成员商户编号
        }
        if (!StringUtils.isEmpty(reqBody.getPayment_account_no())) {
            criteria.andPaymentAccountNoEqualTo(reqBody.getPayment_account_no());                                          //付出CA账户编号
        }
        //收
        if (!StringUtils.isEmpty(reqBody.getReceive_merchant_no())) {
            criteria.andReceiveMerchantNoEqualTo(reqBody.getReceive_merchant_no());                                        //原收款成员商户编号
        }
        if (!StringUtils.isEmpty(reqBody.getReceive_account_no())) {
            criteria.andReceiveAccountNoEqualTo(reqBody.getReceive_account_no());                                          //收款CA账户编号
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
        try {
            // 交易创建日期时间起始 日期时间 可空 日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_created_start())) {
                criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_start()));
            }
            // 交易创建日期时间结束 日期时间 可空 日期时间截止
            if (StringUtils.isNotBlank(reqBody.getGmt_created_end())) {
                criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_created_end()));
            }
            // 交易最后变更日期时间起始
            if (StringUtils.isNotBlank(reqBody.getGmt_latest_modified_start())) {
            	criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_latest_modified_start()));
            }
            // 交易最后变更日期时间终止
            if (StringUtils.isNotBlank(reqBody.getGmt_latest_modified_end())) {
            	criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.formatDateTime(reqBody.getGmt_latest_modified_end()));
            }
            //转账起始金额
            if(StringUtils.isNotBlank(reqBody.getTransfer_amount_start())){
            	criteria.andTransferAmountGreaterThanOrEqualTo(AmountUtils.bizAmountConvertToLong(reqBody.getTransfer_amount_start()));
            }
            //转账结束金额
            if(StringUtils.isNotBlank(reqBody.getTransfer_amount_end())){
            	criteria.andTransferAmountLessThanOrEqualTo(AmountUtils.bizAmountConvertToLong(reqBody.getTransfer_amount_end()));
            }
        } catch (Exception e) {
//            throw new BizRuntimeException("trade.details.date.error");
        	throw exceptionService.buildBusinessException("JY000000000000101");
        }
        
      //精确查询
        if (!StringUtils.isEmpty(reqBody.getExtend_field_1_accurate_query())) {
            criteria.andMerchantExtendField1EqualTo(reqBody.getExtend_field_1_accurate_query());
        }
        if (!StringUtils.isEmpty(reqBody.getExtend_field_2_accurate_query())) {
            criteria.andMerchantExtendField2EqualTo(reqBody.getExtend_field_2_accurate_query());
        }
        if (!StringUtils.isEmpty(reqBody.getExtend_field_3_accurate_query())) {
            criteria.andMerchantExtendField3EqualTo(reqBody.getExtend_field_3_accurate_query());
        }
        if (!StringUtils.isEmpty(reqBody.getExtend_field_4_accurate_query())) {
            criteria.andMerchantExtendField4EqualTo(reqBody.getExtend_field_4_accurate_query());
        }
        if (!StringUtils.isEmpty(reqBody.getExtend_field_5_accurate_query())) {
            criteria.andMerchantExtendField5EqualTo(reqBody.getExtend_field_5_accurate_query());
        }

        //模糊查询
        if (StringUtils.isEmpty(reqBody.getExtend_field_1_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_1_fuzzy_query())) {
            criteria.andMerchantExtendField1Like("%" + reqBody.getExtend_field_1_fuzzy_query() + "%");
        }
        if (StringUtils.isEmpty(reqBody.getExtend_field_2_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_2_fuzzy_query())) {
            criteria.andMerchantExtendField2Like("%" + reqBody.getExtend_field_2_fuzzy_query() + "%");
        }
        if (StringUtils.isEmpty(reqBody.getExtend_field_3_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_3_fuzzy_query())) {
            criteria.andMerchantExtendField3Like("%" + reqBody.getExtend_field_3_fuzzy_query() + "%");
        }
        if (StringUtils.isEmpty(reqBody.getExtend_field_4_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_4_fuzzy_query())) {
            criteria.andMerchantExtendField4Like("%" + reqBody.getExtend_field_4_fuzzy_query() + "%");
        }
        if (StringUtils.isEmpty(reqBody.getExtend_field_5_accurate_query()) && !StringUtils.isEmpty(reqBody.getExtend_field_5_fuzzy_query())) {
            criteria.andMerchantExtendField5Like("%" + reqBody.getExtend_field_5_fuzzy_query() + "%");
        }

        //查询结果 total
        List<TradeTransferAccount> results = null;
        int total = transferService.selectCountByExample(example);
        if (0 < total) {
            example.setOrderByClause("gmt_created DESC");
            tradeResponse.getBody().setResultCount(total + "");
            results = transferService.pageQueryByExample(example,reqBody);
        } else {
            tradeResponse.getBody().setResultCount("0");
            tradeResponse.getBody().setTrade_details(null);
        }

        return results;
    }
}