package com.liantuo.trade.orm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeTransactionidInfoMapper;
import com.liantuo.trade.orm.pojo.TradeTransactionidInfo;
import com.liantuo.trade.orm.pojo.TradeTransactionidInfoExample;
import com.liantuo.trade.orm.service.TradeTransactionidInfoService;

@Service(value = "tradeTransactionidInfoService")
public class TradeTransactionidInfoServiceImpl implements TradeTransactionidInfoService{

    @Resource
    private TradeTransactionidInfoMapper tradeTransactionidInfoMapper;
    
    @Override
    public List<TradeTransactionidInfo> query(TradeTransactionidInfoExample example) {
        return tradeTransactionidInfoMapper.selectByExample(example);
    }

    public List<TradeTransactionidInfo> queryBy(String coreMerchantNo, String transactionId, String payerAccount){
        TradeTransactionidInfoExample query = new TradeTransactionidInfoExample();
        query.createCriteria().andCoreMerchantNoEqualTo(coreMerchantNo)
            .andTransactionIdEqualTo(transactionId).andPayerAccountEqualTo(payerAccount);
        return this.query(query);
    }
}
