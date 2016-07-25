package com.liantuo.trade.orm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeAdjustAccountLogMapper;
import com.liantuo.trade.orm.mapper.TradeRechargeLogMapper;
import com.liantuo.trade.orm.pojo.TradeRechargeLog;
import com.liantuo.trade.orm.service.TradeRechargeLogService;
@Service(value = "tradeRechargeLogService")
public class TradeRechargeServiceLogImpl implements TradeRechargeLogService {
	@Resource
    private TradeRechargeLogMapper tradeRechargeLogMapper;
	
	
	@Override
	public void insertTradeRechargeLog(TradeRechargeLog record) {
		// TODO Auto-generated method stub
		tradeRechargeLogMapper.insertSelective(record);
	}

}
