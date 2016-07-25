/**
 * 
 */
package com.liantuo.trade.orm.service.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.liantuo.trade.orm.mapper.TradePaymentLogMapper;
import com.liantuo.trade.orm.pojo.TradePaymentLog;
import com.liantuo.trade.orm.service.TradePaymentLogService;

/**
 * @ClassName:     TradePaymentLogServiceImpl.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2015-12-16 下午6:57:39 
 */
@Service(value = "tradePaymentLogService")
public class TradePaymentLogServiceImpl implements TradePaymentLogService {
	private final Log LOG4J = LogFactory.getLog("trade");
	@Resource
	private TradePaymentLogMapper tradePaymentLogMapper;
	
	@Override
	public void insertTradePaymentLog(TradePaymentLog paymentlog){
		tradePaymentLogMapper.insertSelective(paymentlog);
	}
}
