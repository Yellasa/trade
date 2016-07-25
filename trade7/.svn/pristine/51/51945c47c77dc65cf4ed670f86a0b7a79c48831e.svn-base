package com.liantuo.trade.orm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeLedgerLogMapper;
import com.liantuo.trade.orm.pojo.TradeLedgerLog;
import com.liantuo.trade.orm.service.TradeLedgerLogService;

@Service(value = "tradeLedgerLogService")
public class TradeLedgerLogServiceImpl implements TradeLedgerLogService{

    @Resource
    private TradeLedgerLogMapper tradeLedgerLogMapper;
    
    @Override
    public void insertTradeLedgerLog(TradeLedgerLog log) {
        tradeLedgerLogMapper.insertSelective(log);
    }

}
