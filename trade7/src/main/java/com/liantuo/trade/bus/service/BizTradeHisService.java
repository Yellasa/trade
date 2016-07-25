package com.liantuo.trade.bus.service;

import com.liantuo.trade.bus.vo.ATradeBizVO;

/**
 * 交易更新历史
 */
public interface BizTradeHisService<T extends ATradeBizVO> {
    void createHis(T trade) throws Exception;
}