package com.liantuo.trade.orm.service;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawExample;

import java.util.List;


/**
 * 提现交易
 */
public interface TradeWithdrawService {

    TradeWithdraw insertTradeWithdraw(TradeWithdraw trade);
    
    void updateTradeWithdrawById(TradeWithdraw trade);
    
    List<TradeWithdraw> queryByBatchNo(String batchNo);
    
    List<TradeWithdraw> queryByTradeNo(String tradeNo);
    
    TradeWithdraw queryById(Long id);
    
    List<TradeWithdraw> queryByExample(TradeWithdrawExample example);
    
    List<TradeWithdraw> queryByPayThirdTradeNo(String payThirdTradeNo, String fundPoolNo, String coreMerchantNo);
    
    /** 查询总条数  */
    Long queryCount(TradeWithdrawExample example);
    
    /** 分页查询  */
    List<TradeWithdraw> queryPageByExample(TradeWithdrawExample example, Paging page);

    List<TradeWithdraw> queryPageByExample(TradeWithdrawExample example);

}
