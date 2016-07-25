package com.liantuo.trade.orm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeTransferAccountLogMapper;
import com.liantuo.trade.orm.pojo.TradeTransferAccountLog;
import com.liantuo.trade.orm.service.TradeTransferAccountLogService;

@Service("tradeTransferAccountLogService")
public class TradeTransferAccountLogServiceImpl implements TradeTransferAccountLogService {

	@Autowired
	private TradeTransferAccountLogMapper mapper;
	@Override
	public void insert(TradeTransferAccountLog item) throws Exception {
		mapper.insert(item);
		
	}

}
