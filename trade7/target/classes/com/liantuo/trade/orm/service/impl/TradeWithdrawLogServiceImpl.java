package com.liantuo.trade.orm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeWithdrawLogMapper;
import com.liantuo.trade.orm.pojo.TradeWithdrawLog;
import com.liantuo.trade.orm.service.TradeWithdrawLogService;

@Service(value = "tradeWithdrawLogService")
public class TradeWithdrawLogServiceImpl implements TradeWithdrawLogService{

    @Resource
    private TradeWithdrawLogMapper tradeWithdrawLogMapper;
    
    @Override
    public void insertTradeWithdrawLog(TradeWithdrawLog log) {
        tradeWithdrawLogMapper.insertSelective(log);
    }

}
