package com.liantuo.trade.orm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeProfitLossLedgerLogMapper;
import com.liantuo.trade.orm.pojo.TradeProfitLossLedgerLog;
import com.liantuo.trade.orm.service.TradeProfitLossLedgerLogService;
@Service(value = "tradeProfitLossLedgerLogService")
public class TradeProfitLossLedgerLogServiceImpl implements TradeProfitLossLedgerLogService {
	@Resource
	private TradeProfitLossLedgerLogMapper tradeProfitLossLedgerLogMapper;
	@Override
	public void insertTradeProfitLossLedgerLog(TradeProfitLossLedgerLog record) {
		// TODO Auto-generated method stub
		tradeProfitLossLedgerLogMapper.insertSelective(record);
	}

}
