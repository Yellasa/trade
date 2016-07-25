/**
 * 
 */
package com.liantuo.trade.orm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradeOutPaymentLogMapper;
import com.liantuo.trade.orm.pojo.TradeOutPaymentLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeOutPaymentLogService;

/**
 * @ClassName:     TradeOutPaymentLogServiceImpl.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-2-2 下午1:00:12 
 */
@Service("tradeOutPaymentLogServiceImpl")
public class TradeOutPaymentLogServiceImpl implements TradeOutPaymentLogService {

	@Autowired
    private TradeOutPaymentLogMapper tradeOutPaymentLogMapper;
	
	@Override
    public void insertTradeOutPaymentLog(TradeOutPaymentLogWithBLOBs log) {
		tradeOutPaymentLogMapper.insertSelective(log);
    }

    @Override
    public void updateTradeOutPaymentLog(TradeOutPaymentLogWithBLOBs log) {
    	tradeOutPaymentLogMapper.updateByPrimaryKeySelective(log);
    }
}
