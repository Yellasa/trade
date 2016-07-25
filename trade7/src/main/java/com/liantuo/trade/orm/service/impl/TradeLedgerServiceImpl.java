package com.liantuo.trade.orm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeLedgerMapper;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.pojo.TradeLedgerExample;
import com.liantuo.trade.orm.service.TradeLedgerService;

@Service(value = "tradeLedgerService")
public class TradeLedgerServiceImpl implements TradeLedgerService {

    @Resource
    private TradeLedgerMapper tradeLedgerMapper;

    @Override
    public void insertTradeLedger(TradeLedger tradeLedger) {
        tradeLedgerMapper.insertSelective(tradeLedger);
    }
    
    @Override
    public void insertTradeLedgerBlank(TradeLedger tradeLedger) {
        tradeLedgerMapper.insertSelectiveBlank(tradeLedger);
    }
    
    @Override
    public void updateTradeLedger(TradeLedger tradeLedger){
        tradeLedgerMapper.updateByPrimaryKeySelective(tradeLedger);
    }

    @Override
    public List<TradeLedger> queryTradeLedgerBy(String ledgerNo) {
        TradeLedgerExample query = new TradeLedgerExample();
        query.createCriteria().andLedgerNoEqualTo(ledgerNo);
        return tradeLedgerMapper.selectByExample(query);
    }

	@Override
	public List<TradeLedger> selectByExample(TradeLedgerExample example) {
		return tradeLedgerMapper.selectByExample(example);
	}

	@Override
	public TradeLedger queryByLedgerNoAndTradeNo(String ledgerNo, String tradeNo) {
		if(ledgerNo !=null && tradeNo !=null ){
			 TradeLedgerExample query = new TradeLedgerExample();
		     query.createCriteria().andLedgerNoEqualTo(ledgerNo).andTradeNoEqualTo(tradeNo);
		     List<TradeLedger> list = tradeLedgerMapper.selectByExample(query);
		     if(list !=null && list.size() > 0 ){
		    	 return list.get(0); 
		     }
		}
		return null;
	}

}
