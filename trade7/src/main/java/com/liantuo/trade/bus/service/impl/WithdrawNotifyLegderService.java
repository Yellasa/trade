package com.liantuo.trade.bus.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.NotifyLegderService;
import com.liantuo.trade.bus.vo.WithdrawNotifyBizVo;
import com.liantuo.trade.bus.vo.WithdrawNotifyPayInfoVo;
import com.liantuo.trade.client.trade.packet.req.withdraw.WithdrawNotifyReqPacket;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.service.TradeLedgerLogService;
import com.liantuo.trade.orm.service.TradeLedgerService;

@Component(value = "withdrawNotifyLegderService")
public class WithdrawNotifyLegderService implements NotifyLegderService<WithdrawNotifyReqPacket, WithdrawNotifyBizVo>{

    @Resource
    private TradeLedgerService tradeLedgerService;

    @Resource
    private TradeLedgerLogService tradeLedgerLogService;
    
    @Override
    public TradeLedger updateToEffect(WithdrawNotifyReqPacket notifyPacket, WithdrawNotifyBizVo bizVo) {
        List<TradeLedger> ledgers = tradeLedgerService.queryTradeLedgerBy(bizVo.getTrade().getLedgerNo());
        TradeLedger ledger = ledgers.get(0);
        
        ledger.setEffectiveReqType(TradeConstants.TRADE_WITHDRAW_NOTIFY); // 生效交易请求类型
        ledger.setEffectiveReqNo(bizVo.getReqContext().getReq().getReqNo()); // 生效交易请求编号
        
        WithdrawNotifyPayInfoVo info = (WithdrawNotifyPayInfoVo) bizVo.getPayInfo();
        ledger.setGmtSuccessClearChannel(DateUtil.format(info.getCompleteTime(), DateUtil.YYYYMMDDHHMMSS)); // 外部渠道收付款成功日期时间
        ledger.setThirdTradeNo(info.getAlipayTradeNo()); // 收付款渠道订单号
        ledger.setPaymentTradeNo(notifyPacket.getBody().getHft_trade_no()); // 支付中心记录编号
        
        // 业务台账生效日期时间 -- 系统当前日期时间
        ledger.setGmtEffective(new Date());
        // 台账状态 - 生效
        ledger.setStatus(TradeConstants.LEDGER_STATUS_EFFECTIVITY);
        
        tradeLedgerService.updateTradeLedger(ledger);
        return ledger;
    }

    @Override
    public TradeLedger updateToField(WithdrawNotifyReqPacket notifyPacket, WithdrawNotifyBizVo bizVo) {
        List<TradeLedger> ledgers = tradeLedgerService.queryTradeLedgerBy(bizVo.getTrade().getLedgerNo());
        TradeLedger ledger = ledgers.get(0);
        
        ledger.setFailReqType(TradeConstants.TRADE_WITHDRAW_NOTIFY); // 失败交易请求类型
        ledger.setFailReqNo(bizVo.getReqContext().getReq().getReqNo()); // 失败交易请求编号
        
        WithdrawNotifyPayInfoVo info = (WithdrawNotifyPayInfoVo) bizVo.getPayInfo();
        ledger.setThirdTradeNo(info.getAlipayTradeNo()); // 收付款渠道订单号
        ledger.setPaymentTradeNo(notifyPacket.getBody().getHft_trade_no()); // 支付中心记录编号
        
        // 业务台账失败日期时间  -- 系统当前日期时间
        ledger.setGmtFailed(new Date());
        // 台账状态
        ledger.setStatus(TradeConstants.LEDGER_STATUS_FAILED);
        
        tradeLedgerService.updateTradeLedger(ledger);
        return ledger;
    }

}
