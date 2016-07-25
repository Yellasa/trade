package com.liantuo.trade.orm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.mapper.TradeAdjustAccountMapper;
import com.liantuo.trade.orm.pojo.TradeAdjustAccount;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountExample;
import com.liantuo.trade.orm.service.TradeAdjustAccountService;

/**
 * @ClassName:     TradeAdjustAccountServiceImpl.java
 * @Description:   0003
 * Company:联拓金融信息服务有限公司
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-4-5 上午11:22:23 
 */
@Service(value = "tradeAdjustAccountService")
public class TradeAdjustAccountServiceImpl implements TradeAdjustAccountService {
	private final Log LOG4J = LogFactory.getLog("trade");
	
	@Resource
    private TradeAdjustAccountMapper tradeAdjustAccountMapper;
	
	@Override
    public List<TradeAdjustAccount> queryExample(TradeAdjustAccountExample tradeAdjustAccountExample) {
		List<TradeAdjustAccount> list = tradeAdjustAccountMapper.selectByExample(tradeAdjustAccountExample);
        return list;
    }

	/* (non-Javadoc)
	 * @see com.liantuo.trade.orm.service.TradeAdjustAccountService#insertSelective(com.liantuo.trade.orm.pojo.TradeAdjustAccount)
	 */
	@Override
	public void insertAdjustAccount(TradeAdjustAccount record) {
		tradeAdjustAccountMapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.liantuo.trade.orm.service.TradeAdjustAccountService#selectByPrimaryKey(java.lang.Long)
	 */
	@Override
	public TradeAdjustAccount selectByPrimaryKey(Long id) {
		return tradeAdjustAccountMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.liantuo.trade.orm.service.TradeAdjustAccountService#updateTradeAdjustAccount(com.liantuo.trade.orm.pojo.TradeAdjustAccount)
	 */
	@Override
	public void updateTradeAdjustAccount(TradeAdjustAccount record) {
		int count = tradeAdjustAccountMapper.updateByKeyVersionSelective(record);
        if (count != 1) {
            LOG4J.error(String.format("乐观锁更新失败 id=%d, version=%d", record.getId(), record.getVersion()));
            throw new BizRuntimeException("trade.status.update.error");
        }
	}
	

}
