package com.liantuo.trade.bus.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.NotifyTradeService;
import com.liantuo.trade.bus.vo.WithdrawNotifyBizVo;
import com.liantuo.trade.bus.vo.WithdrawNotifyPayInfoVo;
import com.liantuo.trade.client.trade.packet.req.withdraw.WithdrawNotifyReqPacket;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.service.TradeWithdrawErrorinfoService;
import com.liantuo.trade.orm.service.TradeWithdrawService;

@Component(value = "withdrawNotifyTradeService")
public class WithdrawNotifyTradeService implements NotifyTradeService<WithdrawNotifyReqPacket, WithdrawNotifyBizVo>{

    @Resource
    private TradeWithdrawService tradeWithdrawService;
    
    @Resource
    private TradeWithdrawErrorinfoService tradeWithdrawErrorinfoService;
    
    @SuppressWarnings("unchecked")
    @Override
    public TradeWithdraw queryOriginalTrade(WithdrawNotifyReqPacket notifyPacket) {
        List<TradeWithdraw> list = tradeWithdrawService.queryByTradeNo(notifyPacket.getBusHead().getTrade_no());
        if(list.size() == 1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public void updateToSuccess(WithdrawNotifyReqPacket notifyPacket, WithdrawNotifyBizVo bizVo) {
        TradeWithdraw trade = bizVo.getTrade();
        
        trade.setGmtLatestModified(new Date()); // 
        trade.setLatestTradeReqType(TradeConstants.TRADE_WITHDRAW_NOTIFY); // 最后变更交易请求类型
        trade.setLatestReqNo(bizVo.getReqContext().getReq().getReqNo()); // 最后变更交易请求编号
        trade.setStatus(TradeConstants.TRADE_WITHDRAW_PAY_SUCCESS); // 出款成功
        trade.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END); // 已结束
        
        WithdrawNotifyPayInfoVo info = (WithdrawNotifyPayInfoVo) bizVo.getPayInfo();
        trade.setGmtPaySuccess(DateUtil.format(info.getCompleteTime(), DateUtil.YYYYMMDDHHMMSS)); // 出款成功日期时间
        trade.setPayThirdTradeNo(info.getAlipayTradeNo()); // 出款渠道订单号
        // trade.setVersion(version); // 交易版本号 -- 自动更新
        
        tradeWithdrawService.updateTradeWithdrawById(trade);
        bizVo.setTrade(tradeWithdrawService.queryById(trade.getId()));
    }

    @Override
    public void updateToFailed(WithdrawNotifyReqPacket notifyPacket, WithdrawNotifyBizVo bizVo) {
        TradeWithdraw trade = bizVo.getTrade();
        
        trade.setGmtLatestModified(new Date()); // 最后变更日期时间
        trade.setLatestTradeReqType(TradeConstants.TRADE_WITHDRAW_NOTIFY); // 最后变更交易请求类型
        trade.setLatestReqNo(bizVo.getReqContext().getReq().getReqNo()); // 最后变更交易请求编号
        trade.setStatus(TradeConstants.TRADE_WITHDRAW_PAY_FAILED); // 出款失败
        
        WithdrawNotifyPayInfoVo info = (WithdrawNotifyPayInfoVo) bizVo.getPayInfo();
        trade.setGmtLastPayFail(DateUtil.format(info.getCompleteTime(), DateUtil.YYYYMMDDHHMMSS)); // 最后出款失败日期时间
        trade.setPayThirdTradeNo(info.getAlipayTradeNo()); // 出款渠道订单号
        
        // 支付中心错误码
        trade.setFailErrorCode(info.getErrorCode());
        // trade.setVersion(version); // 交易版本号 -- 自动更新
        
        tradeWithdrawService.updateTradeWithdrawById(trade);
        bizVo.setTrade(tradeWithdrawService.queryById(trade.getId()));
    }

}
