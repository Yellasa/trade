/**
 * 
 */
package com.liantuo.trade.orm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeOutFrontLogMapper;
import com.liantuo.trade.orm.pojo.TradeOutFrontLogExample;
import com.liantuo.trade.orm.pojo.TradeOutFrontLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeOutFrontLogService;

/**
 * @ClassName:     TradeOutFrontLogServiceImpl.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-2-2 下午1:08:43 
 */
@Service("tradeOutFrontLogServiceImpl")
public class TradeOutFrontLogServiceImpl implements TradeOutFrontLogService {

	@Autowired
    private TradeOutFrontLogMapper tradeOutFrontLogMapper;
	
	@Override
    public void insertTradeOutFrontLog(TradeOutFrontLogWithBLOBs log) {
		tradeOutFrontLogMapper.insertSelective(log);
    }

    @Override
    public void updateTradeOutFrontLog(TradeOutFrontLogWithBLOBs log) {
    	tradeOutFrontLogMapper.updateByPrimaryKeySelective(log);
    }

	@Override
	public List<TradeOutFrontLogWithBLOBs> queryTradeOutFrontLog(TradeOutFrontLogExample example) {
		return tradeOutFrontLogMapper.selectByExampleWithBLOBs(example);
	}
}
