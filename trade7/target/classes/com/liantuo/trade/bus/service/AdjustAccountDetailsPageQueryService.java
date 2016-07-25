package com.liantuo.trade.bus.service;

import java.util.List;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.orm.pojo.TradeAdjustAccount;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountExample;

/**
 * 调账记录交易明细分页查询
 */
public interface AdjustAccountDetailsPageQueryService {
	
    List<TradeAdjustAccount> queryPageByExample(TradeAdjustAccountExample tradeAdjustAccountExample, Paging page) throws Exception;
    
    //查询总条数
    int queryCountByExample(TradeAdjustAccountExample tradeAdjustAccountExample);
    
}