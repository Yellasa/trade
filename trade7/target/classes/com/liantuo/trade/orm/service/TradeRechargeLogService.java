package com.liantuo.trade.orm.service;

import com.liantuo.trade.orm.pojo.TradeAdjustAccount;
import com.liantuo.trade.orm.pojo.TradeRechargeLog;

/**
 * 
 * @ClassName:   TradeRechargeServiceLog.java
 * @Description: TODO(充值交易历史记录的service) 
 * @Company:     联拓金融信息服务有限公司
 * @author       zoran.huang
 * @version      V1.0  
 * @date         2016年4月26日 下午3:34:29
 */
public interface TradeRechargeLogService {
	/**
	 * @Title:insertAdjustAccount 
	 * @Description: 项充值交易历史记录表中插入充值历史记录数据 
	 * @param record
	 * @return:void
	 * @author:zoran.huang
	 * @date:2016年4月26日 下午3:35:56
	 */
	void insertTradeRechargeLog(TradeRechargeLog record);
}
