package com.liantuo.trade.bus.factory.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.TradeChangeHisService;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.constants.TradeConstants;

@Component("tradeModifyHistoryServiceFactory")
public class TradeModifyHistoryServiceFactory implements ApplicationContextAware {

    private ApplicationContext context;
    private Map<String, TradeChangeHisService> map = new HashMap<String, TradeChangeHisService>();

    public TradeChangeHisService create(TradePacket tradePacket) throws Exception {
        if (map.isEmpty()) {//TODO 配置化
        	//001 冻减付
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_MERCHANT_FREEZE, (TradeChangeHisService) context.getBean("paymentChangeHisServiceImpl"));
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_UN_FREEZE_OFFLINE_SETTLE, (TradeChangeHisService) context.getBean("paymentChangeHisServiceImpl"));
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_FULL_UN_FREEEZE, (TradeChangeHisService) context.getBean("paymentChangeHisServiceImpl"));
            map.put(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_OFFLINE_SETTLE, (TradeChangeHisService) context.getBean("refundChangeHisServiceImpl"));
            
            //002 提现
            map.put(TradeConstants.TRADE_WITHDRAW_DEDUCT, (TradeChangeHisService) context.getBean("withdrawTradeChangeHisServiceImpl"));
            map.put(TradeConstants.TRADE_WITHDRAW_PAY_QUERY, (TradeChangeHisService) context.getBean("withdrawTradeChangeHisServiceImpl"));
            map.put(TradeConstants.TRADE_WITHDRAW_PAY, (TradeChangeHisService) context.getBean("withdrawTradeChangeHisServiceImpl"));
            map.put(TradeConstants.TRADE_WITHDRAW_REFUND, (TradeChangeHisService) context.getBean("withdrawTradeChangeHisServiceImpl"));
        }

        return map.get(tradePacket.getBusHead().getRequest_code());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}