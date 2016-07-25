package com.liantuo.trade.bus.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.TradeChangeHisService;
import com.liantuo.trade.bus.vo.WithdrawDeductBizVo;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawLog;
import com.liantuo.trade.orm.service.TradeWithdrawLogService;
import com.liantuo.trade.orm.service.TradeWithdrawService;

@Component(value = "withdrawTradeChangeHisServiceImpl")
public class WithdrawTradeChangeHisServiceImpl implements TradeChangeHisService<WithdrawDeductBizVo>{

    @Resource
    private TradeWithdrawLogService tradeWithdrawLogService;
    
    @Resource
    private TradeWithdrawService tradeWithdrawService;
    
    public void create(WithdrawDeductBizVo bizVo) {
        TradeWithdrawLog log = new TradeWithdrawLog();
        TradeWithdraw trade = tradeWithdrawService.queryById(bizVo.getTradeWithdraw().getId());
        bizVo.setTradeWithdraw(trade);
        BeanUtils.copyProperties(trade, log);
        log.setId(null);
        tradeWithdrawLogService.insertTradeWithdrawLog(log);
    }

}
