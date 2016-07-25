package com.liantuo.trade.orm.service;

import java.util.Date;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;
import com.liantuo.trade.orm.pojo.TradeReqLogWithBLOBs;

/**
 * 
 * @作者 Jimmy
 * @日期 2015年12月15日 上午9:40:04
 * @最后修改人
 * @修改时间
 * @复审人
 */
public interface TradeReqLogService {

    void insertTradeRequestLog(TradeReqLogWithBLOBs log);
    TradeReqLogWithBLOBs insertTradeRequestLog(TradeRequest<?> tradeReq,String ip,String requestXML);
    void updateTradeRequestLog(TradeReqLogWithBLOBs log);
    void updateTradeReqLogById(Long logId,String requestXml, TradeResponse tradeResponse, Date startTime);
    TradeReqLogWithBLOBs getTradeReqLog(Long id);
}
