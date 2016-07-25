package com.liantuo.trade.bus.factory.service;

import com.liantuo.trade.bus.service.BizLegderService;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.constants.TradeConstants;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("legderServiceFactory")
public class LegderServiceFactory implements ApplicationContextAware {

    private ApplicationContext context;
    private Map<String, BizLegderService> map = new HashMap<String, BizLegderService>();

    public BizLegderService create(TradePacket tradePacket) throws Exception {
        if (map.isEmpty()) { //TODO 配置化
        	//001 冻减付
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_UN_FREEZE_OFFLINE_SETTLE, (BizLegderService) context.getBean("bizPaymentLegderServiceImpl"));//线下付款其余解冻
            map.put(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_OFFLINE_SETTLE, (BizLegderService) context.getBean("bizRefundLegderServiceImpl"));//线下付款退回
            //002-提现
            map.put(TradeConstants.TRADE_WITHDRAW_PAY, (BizLegderService) context.getBean("bizWithdrawLegderServiceImpl"));//提现支付宝出款
        }
        return map.get(tradePacket.getBusHead().getRequest_code());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
