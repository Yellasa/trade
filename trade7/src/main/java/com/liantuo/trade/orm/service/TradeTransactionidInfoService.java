package com.liantuo.trade.orm.service;

import java.util.List;

import com.liantuo.trade.orm.pojo.TradeTransactionidInfo;
import com.liantuo.trade.orm.pojo.TradeTransactionidInfoExample;

public interface TradeTransactionidInfoService {

    List<TradeTransactionidInfo> query(TradeTransactionidInfoExample example);
    
    List<TradeTransactionidInfo> queryBy(String coreMerchantNo, String transactionId, String payerAccount);
    
}
