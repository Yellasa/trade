package com.liantuo.trade.bus.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.TradeChangeHisService;
import com.liantuo.trade.bus.vo.TradeRefundBizVO;
import com.liantuo.trade.orm.pojo.TradeRefund;
import com.liantuo.trade.orm.pojo.TradeRefundLog;
import com.liantuo.trade.orm.service.TradeRefundLogService;
import com.liantuo.trade.orm.service.TradeRefundService;


/**
 * 
 * @作者 Jimmy
 * @日期 2015年12月25日 下午5:01:03
 * @最后修改人
 * @修改时间
 * @复审人 
 */
@Component(value = "refundChangeHisServiceImpl")
public class RefundChangeHisServiceImpl implements TradeChangeHisService<TradeRefundBizVO> {

    @Autowired
    private TradeRefundService tradeRefundService;
    
    @Autowired
    private TradeRefundLogService tradeRefundLogService;
    
    public void create(TradeRefundBizVO trade) {
        TradeRefund refund = tradeRefundService.queryTradeRefund(trade.getRefund().getId());
        TradeRefundLog log = new TradeRefundLog();
        trade.setRefund(refund);
        BeanUtils.copyProperties(refund, log);
        log.setId(null);
        tradeRefundLogService.insertTradeRefund(log);
    }

}
