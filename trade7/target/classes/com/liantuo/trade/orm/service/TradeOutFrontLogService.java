/**
 * 
 */
package com.liantuo.trade.orm.service;

import java.util.List;

import com.liantuo.trade.orm.pojo.TradeOutFrontLogExample;
import com.liantuo.trade.orm.pojo.TradeOutFrontLogWithBLOBs;

/**
 * @ClassName:     TradeOutFrontLogService.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-2-2 下午1:08:06 
 */
public interface TradeOutFrontLogService {

	public void insertTradeOutFrontLog(TradeOutFrontLogWithBLOBs log);
	
	public void updateTradeOutFrontLog(TradeOutFrontLogWithBLOBs log);
	
	public List<TradeOutFrontLogWithBLOBs> queryTradeOutFrontLog(TradeOutFrontLogExample example);
}
