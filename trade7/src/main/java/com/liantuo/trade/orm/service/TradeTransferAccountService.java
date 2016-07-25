package com.liantuo.trade.orm.service;

import java.util.List;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.orm.pojo.TradeTransferAccount;
import com.liantuo.trade.orm.pojo.TradeTransferAccountExample;

public interface TradeTransferAccountService {

	long insert(TradeTransferAccount item) throws Exception;
	
	List<TradeTransferAccount> queryExample(TradeTransferAccountExample example) throws Exception;
	
	void updateStatus(TradeTransferAccount item) throws Exception;
	
	TradeTransferAccount selectByPrimaryKey(Long id) throws Exception;
	
	int selectCountByExample(TradeTransferAccountExample example) ;
    
    List<TradeTransferAccount> pageQueryByExample(TradeTransferAccountExample example,Paging page) ;
}
