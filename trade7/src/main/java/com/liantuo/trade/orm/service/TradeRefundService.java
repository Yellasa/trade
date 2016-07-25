package com.liantuo.trade.orm.service;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.orm.pojo.TradeRefund;
import com.liantuo.trade.orm.pojo.TradeRefundExample;

import java.util.List;

/**
 * 退款交易
 * 
 * @作者 Jimmy
 * @最后修改人
 * @修改时间
 * @复审人
 */
public interface TradeRefundService {

    List<TradeRefund> pageQueryByExample(TradeRefundExample example, Paging page);

    TradeRefund insertTradeRefund(TradeRefund tradeRefund);

    void updateTradeRefund(TradeRefund tradeRefund);

    List<TradeRefund> queryTradeRefundByOriginalTradeNo(String originalTradeNo, String fundPoolNo, String coreMerchantNo);
    
    List<TradeRefund> queryTradeRefundByOutTradeNoExt(String outTradeNoExt, String fundPoolNo, String coreMerchantNo);
    
    List<TradeRefund> queryTradeRefund(TradeRefundExample query);
    
    TradeRefund queryTradeRefund(Long id);
    
    int selectCountByExample(TradeRefundExample query);

}
