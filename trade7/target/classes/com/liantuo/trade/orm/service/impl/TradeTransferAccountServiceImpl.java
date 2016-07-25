package com.liantuo.trade.orm.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liantuo.trade.client.trade.packet.Paging;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.mapper.TradeTransferAccountMapper;
import com.liantuo.trade.orm.pojo.TradeTransferAccount;
import com.liantuo.trade.orm.pojo.TradeTransferAccountExample;
import com.liantuo.trade.orm.service.TradeTransferAccountService;
import com.liantuo.trade.spring.annotation.Page;

@Service("tradeTransferAccountServiceImpl")
public class TradeTransferAccountServiceImpl implements TradeTransferAccountService {
	private final Log LOG4J = LogFactory.getLog("trade");
	
	@Autowired
	private TradeTransferAccountMapper mapper;
	
	@Override
	public long insert(TradeTransferAccount item) throws Exception {
		return mapper.insertSelective(item);
	}

	@Override
	public List<TradeTransferAccount> queryExample(TradeTransferAccountExample example) throws Exception {
		List<TradeTransferAccount> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public void updateStatus(TradeTransferAccount item) throws Exception{
		int count = mapper.updateByKeyVersionSelective(item);
        if (count != 1) {
            LOG4J.error(String.format("乐观锁更新失败 id=%d, version=%d", item.getId(), item.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
        }
	}

	@Override
	public TradeTransferAccount selectByPrimaryKey(Long id) throws Exception {

		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int selectCountByExample(TradeTransferAccountExample example)  {
		return mapper.selectCountByExample(example);
	}

	@Override
	@Page
	public List<TradeTransferAccount> pageQueryByExample(TradeTransferAccountExample example,Paging page){
		return mapper.pageQueryByExample(example);
	}

}
