package com.liantuo.trade.orm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeAdjustAccountLogMapper;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountLog;
import com.liantuo.trade.orm.service.TradeAdjustAccountServiceLog;

/**
 * @ClassName:     TradeAdjustAccountServiceLogImpl.java
 * @Description:   TODO
 * Company:联拓金融信息服务有限公司
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-4-5 上午11:25:18 
 */
@Service(value = "tradeAdjustAccountLogService")
public class TradeAdjustAccountServiceLogImpl implements TradeAdjustAccountServiceLog {

	@Resource
    private TradeAdjustAccountLogMapper tradeAdjustAccountLogMapper;

	/* (non-Javadoc)
	 * @see com.liantuo.trade.orm.service.TradeAdjustAccountServiceLog#insertAdjustAccountLog(com.liantuo.trade.orm.pojo.TradeAdjustAccountLog)
	 */
	@Override
	public void insertAdjustAccountLog(TradeAdjustAccountLog record) {
		tradeAdjustAccountLogMapper.insertSelective(record);
	}
	
}
