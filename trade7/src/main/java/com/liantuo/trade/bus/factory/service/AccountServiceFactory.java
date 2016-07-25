package com.liantuo.trade.bus.factory.service;

import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.constants.TradeConstants;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component(value = "accountServiceFactory")
public class AccountServiceFactory implements ApplicationContextAware {

    private ApplicationContext context;
    private Map<String, BizAccountService> map = new HashMap<String, BizAccountService>();

    public BizAccountService create(TradePacket tradePacket) throws Exception {
        if (map.isEmpty()) { //TODO 配置化
        	//001 冻减付
            map.put(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_OFFLINE_SETTLE, (BizAccountService) context.getBean("bizAccountServiceImpl"));
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_MERCHANT_FREEZE, (BizAccountService) context.getBean("bizAccountServiceImpl"));
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_FULL_UN_FREEEZE, (BizAccountService) context.getBean("bizAccountServiceImpl"));
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_UN_FREEZE_OFFLINE_SETTLE, (BizAccountService) context.getBean("bizAccountServiceImpl"));
            
            // 002提现
            map.put(TradeConstants.TRADE_WITHDRAW_DEDUCT, (BizAccountService) context.getBean("bizAccountServiceImpl"));
            map.put(TradeConstants.TRADE_WITHDRAW_REFUND, (BizAccountService) context.getBean("bizAccountServiceImpl"));
        }
        return map.get(tradePacket.getBusHead().getRequest_code());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
