/**
 * 
 */
package com.liantuo.trade.orm.service;

import java.util.Date;

import com.liantuo.trade.client.trade.packet.TradePaymentAsyNotifyPacket;
import com.liantuo.trade.client.trade.packet.body.TradeNotifyRequestPacket;
import com.liantuo.trade.orm.pojo.TradeNotifyPaymentLogWithBLOBs;

/**
 * @ClassName:     TradeNotifyPaymentLogService.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-2-2 下午1:10:06 
 */
public interface TradeNotifyPaymentLogService {

	 public void insertTradeNotifyPaymentLog(TradeNotifyPaymentLogWithBLOBs log);
	 
	 public void updateTradeNotifyPaymentLogById(TradeNotifyPaymentLogWithBLOBs log);
	 
	 public TradeNotifyPaymentLogWithBLOBs insertTradeNotifyPaymentLog(TradeNotifyRequestPacket tradeReq,String serviceName);
	 
	 public void updateTradeNotifyPaymentLog(Long id,String isSuccess,String errorCode,Date startTime);
}
