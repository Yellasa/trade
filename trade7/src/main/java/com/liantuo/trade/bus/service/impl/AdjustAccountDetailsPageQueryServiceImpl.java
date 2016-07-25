package com.liantuo.trade.bus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.AdjustAccountDetailsPageQueryService;
import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.orm.mapper.TradeAdjustAccountMapper;
import com.liantuo.trade.orm.pojo.TradeAdjustAccount;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountExample;
import com.liantuo.trade.spring.annotation.Page;

@Component(value="adjustAccountDetailsPageQueryServiceImpl")
public class AdjustAccountDetailsPageQueryServiceImpl implements
		AdjustAccountDetailsPageQueryService {

	@Resource
	private TradeAdjustAccountMapper tradeAdjustAccountMapper;
	
	@Page
	public List<TradeAdjustAccount> queryPageByExample(
			TradeAdjustAccountExample tradeAdjustAccountExample, Paging page) throws Exception {
		return tradeAdjustAccountMapper.selectByExample(tradeAdjustAccountExample);
	}

	@Override
	public int queryCountByExample(TradeAdjustAccountExample tradeAdjustAccountExample) {
		return tradeAdjustAccountMapper.selectCountByExample(tradeAdjustAccountExample);
	}

}
