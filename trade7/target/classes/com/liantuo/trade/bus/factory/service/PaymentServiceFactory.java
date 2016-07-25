package com.liantuo.trade.bus.factory.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.BizPaymentCenterService;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.constants.TradeConstants;

@Component("paymentServiceFactory")
public class PaymentServiceFactory implements ApplicationContextAware {

    private ApplicationContext context;
    private Map<String, BizPaymentCenterService> map = new HashMap<String, BizPaymentCenterService>();

    public BizPaymentCenterService create(TradePacket tradePacket) throws Exception {
        if (map.isEmpty()) { //TODO 配置化
        	//002-提现
            map.put(TradeConstants.TRADE_WITHDRAW_PAY, (BizPaymentCenterService) context.getBean("withdrawPaymentCenterServiceImpl"));//提现出款
            map.put(TradeConstants.TRADE_WITHDRAW_PAY_QUERY, (BizPaymentCenterService) context.getBean("bizWithdrawPaymentQueryServiceImpl"));//提现查询
        }
        return map.get(tradePacket.getBusHead().getRequest_code());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }


}
