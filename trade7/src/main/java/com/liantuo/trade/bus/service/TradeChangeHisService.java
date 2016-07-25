package com.liantuo.trade.bus.service;

import com.liantuo.trade.bus.vo.ATradeBizVO;

/**
 * 交易更新历史
 */
public interface TradeChangeHisService<T extends ATradeBizVO> {
    void create(T trade) ;
}