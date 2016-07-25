package com.liantuo.trade.bus.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.liantuo.trade.bus.service.BizLegderService;
import com.liantuo.trade.bus.vo.TradeRefundBizVO;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqRefundOfflineSettle;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.service.TradeLedgerService;
import com.liantuo.trade.seqno.IdFactory;

@Component(value = "bizRefundLegderServiceImpl")
public class BizRefundLegderServiceImpl implements BizLegderService<TradePacketReqRefundOfflineSettle, TradeRefundBizVO> {
    @Resource
    private TradeLedgerService tradeLedgerService;
    
    @Resource(name = "idFactoryTradeLegderLegderNo")
    private IdFactory idFactoryTradeLegderLegderNo;

    @Override
    public void create(TradePacketReqRefundOfflineSettle refundReq, TradeRefundBizVO trade)  {
        TradeLedger ledger = new TradeLedger();
        ledger.setLedgerNo(TradeUtilCommon.getServiceCode(refundReq.getBusHead().getRequest_code())+idFactoryTradeLegderLegderNo.generate().toString());//业务台账编号
        ledger.setCoreMerchantNo(trade.getRefund().getCoreMerchantNo());//核心商户编号
        ledger.setFundPoolNo(trade.getRefund().getFundPoolNo());//资金池编号
        
        ledger.setMerchantExtendField1("");//业务台账客户保留字段1
        ledger.setMerchantExtendField2("");
        ledger.setMerchantExtendField3("");
        ledger.setMerchantExtendField4("");
        ledger.setMerchantExtendField5("");
        
        ledger.setTradeType(TradeUtilCommon.getTradeType(refundReq.getBusHead().getRequest_code())); // 所属业务交易类型（例：0001_001）
        ledger.setTradeNo(trade.getRefund().getTradeNo()); // 交易编号
        ledger.setGmtTradeCreated(trade.getRefund().getGmtCreated()); // 所属业务交易创建日期

        ledger.setCreateReqType(refundReq.getBusHead().getRequest_code());//创建交易请求类型
        ledger.setCreateReqNo(trade.getReqContext().getReq().getReqNo());//创建交易请求编号
        ledger.setEffectiveReqType(refundReq.getBusHead().getRequest_code()); //生效交易请求类型
        ledger.setEffectiveReqNo(trade.getReqContext().getReq().getReqNo()); //生效交易请求编号
        
        if(!StringUtils.isEmpty(trade.getPayment().getOutTradeNo())){
        	ledger.setOutTradeNo(refundReq.getBody().getOut_trade_no()); // 交易发起方业务系统订单号
        }
        ledger.setOutTradeNoExt(refundReq.getBody().getOut_trade_no_ext()); // 交易发起方发起请求ID
        ledger.setStatus(TradeConstants.LEDGER_STATUS_EFFECTIVITY); // 台账状态（00：新建 01生效）
        ledger.setClearChannel(trade.getPayment().getClearChannel()); // 收付款渠道编号（请求业务参数）
        if (!StringUtils.isEmpty(refundReq.getBody().getClear_channel_attr_1())) {
            ledger.setClearChannelAttr1(refundReq.getBody().getClear_channel_attr_1());//收付款属性1
        }
        if (!StringUtils.isEmpty(refundReq.getBody().getClear_channel_attr_2())) {
            ledger.setClearChannelAttr2(refundReq.getBody().getClear_channel_attr_2());
        }
        if (!StringUtils.isEmpty(refundReq.getBody().getClear_channel_attr_3())) {
            ledger.setClearChannelAttr3(refundReq.getBody().getClear_channel_attr_3());
        }
        if (!StringUtils.isEmpty(refundReq.getBody().getClear_channel_attr_4())) {
            ledger.setClearChannelAttr4(refundReq.getBody().getClear_channel_attr_4());
        }
        if (!StringUtils.isEmpty(refundReq.getBody().getClear_channel_attr_5())) {
            ledger.setClearChannelAttr5(refundReq.getBody().getClear_channel_attr_5());
        }
        if (!StringUtils.isEmpty(refundReq.getBody().getClear_channel_attr_6())) {
            ledger.setClearChannelAttr6(refundReq.getBody().getClear_channel_attr_6());
        }
       
        ledger.setReceiveAmount(AmountUtils.bizAmountConvertToLong(refundReq.getBody().getClear_refund_amount()));//收款金额
        ledger.setGmtSuccessClearChannel(DateUtil.formatDateTime(refundReq.getBody().getGmt_refund_clear_channel()));//付款渠道退回日期时间
        ledger.setThirdTradeNo(refundReq.getBody().getThird_trade_no());//收付款渠道订单号
        ledger.setPaymentTradeNo(""); // 支付中心交易号
        
        this.tradeLedgerService.insertTradeLedger(ledger);
        trade.setLedger(ledger);
    }
}
