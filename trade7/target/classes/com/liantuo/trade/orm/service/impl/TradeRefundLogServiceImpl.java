package com.liantuo.trade.orm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeRefundLogMapper;
import com.liantuo.trade.orm.pojo.TradeRefundLog;
import com.liantuo.trade.orm.service.TradeRefundLogService;


/**
 * 
 * @作者 Jimmy
 * @日期 2015年12月25日 下午5:09:44
 * @最后修改人
 * @修改时间
 * @复审人 
 */
@Service(value = "tradeRefundLogService")
public class TradeRefundLogServiceImpl implements TradeRefundLogService {

    @Autowired
    private TradeRefundLogMapper tradeRefundLogMapper;
    
    @Override
    public void insertTradeRefund(TradeRefundLog tradeRefund) {
        tradeRefundLogMapper.insertSelective(tradeRefund);
    }

}
