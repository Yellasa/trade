package com.liantuo.trade.bus.service.impl;

import com.liantuo.trade.bus.service.BizLegderService;
import com.liantuo.trade.bus.vo.TradePaymentBizVO;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqUnFreezeOfflineSettle;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.service.TradeLedgerService;
import com.liantuo.trade.seqno.IdFactory;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Component(value = "bizPaymentLegderServiceImpl")
public class BizPaymentLegderServiceImpl implements BizLegderService<TradePacketReqUnFreezeOfflineSettle, TradePaymentBizVO> {
	@Resource
    private TradeLedgerService tradeLedgerService;
    
    @Resource(name = "idFactoryTradeLegderLegderNo")
    private IdFactory idFactoryTradeLegderLegderNo;

    @Override
    public void create(TradePacketReqUnFreezeOfflineSettle unfreezeReq, TradePaymentBizVO trade) {
    	TradeLedger ledger = new TradeLedger();
        ledger.setLedgerNo(TradeUtilCommon.getServiceCode(unfreezeReq.getBusHead().getRequest_code())+idFactoryTradeLegderLegderNo.generate().toString());//业务台账编号
        ledger.setCoreMerchantNo(trade.getPayment().getCoreMerchantNo());//核心商户编号
        ledger.setFundPoolNo(trade.getPayment().getFundPoolNo());//资金池编号
        
        ledger.setMerchantExtendField1("");//业务台账客户保留字段1
        ledger.setMerchantExtendField2("");
        ledger.setMerchantExtendField3("");
        ledger.setMerchantExtendField4("");
        ledger.setMerchantExtendField5("");
        
        ledger.setTradeType(TradeUtilCommon.getTradeType(unfreezeReq.getBusHead().getRequest_code())); // 所属业务交易类型（例：0001_001）
        ledger.setTradeNo(trade.getPayment().getTradeNo()); // 交易编号
        ledger.setGmtTradeCreated(trade.getPayment().getGmtCreated()); // 所属业务交易创建日期

        ledger.setCreateReqType(unfreezeReq.getBusHead().getRequest_code());//创建交易请求类型
        ledger.setCreateReqNo(trade.getReqContext().getReq().getReqNo());//创建交易请求编号
        ledger.setEffectiveReqType(unfreezeReq.getBusHead().getRequest_code()); //生效交易请求类型
        ledger.setEffectiveReqNo(trade.getReqContext().getReq().getReqNo()); //生效交易请求编号
        if(!StringUtils.isEmpty(trade.getPayment().getOutTradeNo())){
        	ledger.setOutTradeNo(trade.getPayment().getOutTradeNo()); // 交易发起方业务系统订单号
        }
        ledger.setOutTradeNoExt(trade.getPayment().getOutTradeNoExt()); // 交易发起方发起请求ID
        ledger.setStatus(TradeConstants.LEDGER_STATUS_EFFECTIVITY); // 台账状态（00：新建 01生效）
        ledger.setClearChannel(unfreezeReq.getBody().getClear_channel()); // 收付款渠道编号（请求业务参数）
        if (!StringUtils.isEmpty(unfreezeReq.getBody().getClear_channel_attr_1())) {
            ledger.setClearChannelAttr1(unfreezeReq.getBody().getClear_channel_attr_1());//收付款属性1
        }
        if (!StringUtils.isEmpty(unfreezeReq.getBody().getClear_channel_attr_2())) {
            ledger.setClearChannelAttr2(unfreezeReq.getBody().getClear_channel_attr_2());
        }
        if (!StringUtils.isEmpty(unfreezeReq.getBody().getClear_channel_attr_3())) {
            ledger.setClearChannelAttr3(unfreezeReq.getBody().getClear_channel_attr_3());
        }
        if (!StringUtils.isEmpty(unfreezeReq.getBody().getClear_channel_attr_3())) {
            ledger.setClearChannelAttr3(unfreezeReq.getBody().getClear_channel_attr_3());
        }
        if (!StringUtils.isEmpty(unfreezeReq.getBody().getClear_channel_attr_4())) {
            ledger.setClearChannelAttr4(unfreezeReq.getBody().getClear_channel_attr_4());
        }
        if (!StringUtils.isEmpty(unfreezeReq.getBody().getClear_channel_attr_5())) {
            ledger.setClearChannelAttr5(unfreezeReq.getBody().getClear_channel_attr_5());
        }
        if (!StringUtils.isEmpty(unfreezeReq.getBody().getClear_channel_attr_6())) {
            ledger.setClearChannelAttr6(unfreezeReq.getBody().getClear_channel_attr_6());
        }
       
        ledger.setPaymentAmount(AmountUtils.bizAmountConvertToLong(unfreezeReq.getBody().getActual_amount()));//付款金额
        ledger.setGmtSuccessClearChannel(DateUtil.formatDateTime(unfreezeReq.getBody().getGmt_success_clear_channel()));//外部渠道收付款成功日期时间
        ledger.setThirdTradeNo(unfreezeReq.getBody().getThird_trade_no());//收付款渠道订单号
        ledger.setPaymentTradeNo(""); // 支付中心交易号
        
        this.tradeLedgerService.insertTradeLedger(ledger);
        trade.setLedger(ledger);
    }
}
