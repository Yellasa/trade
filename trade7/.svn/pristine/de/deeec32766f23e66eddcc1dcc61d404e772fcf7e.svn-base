package com.liantuo.trade.bus.factory.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.BizTradeService;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.constants.TradeConstants;


@Component("tradeServiceFactory")
public class TradeServiceFactory implements ApplicationContextAware {

    private ApplicationContext context;
    private Map<String, BizTradeService> map = new HashMap<String, BizTradeService>();
    
    public BizTradeService create(TradePacket tradePacket) throws Exception {
        if(map.isEmpty()){//TODO 配置化
        	//001 冻减付
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_MERCHANT_FREEZE, (BizTradeService) context.getBean("paymentTradeCreateServiceImpl"));
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_UN_FREEZE_OFFLINE_SETTLE, (BizTradeService) context.getBean("paymentTradeCreateServiceImpl"));
            map.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_FULL_UN_FREEEZE, (BizTradeService) context.getBean("paymentTradeCreateServiceImpl"));
            map.put(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_OFFLINE_SETTLE, (BizTradeService) context.getBean("refundTradeCreateServiceImpl"));
            
            //002 提现
            //提现-扣减
            map.put(TradeConstants.TRADE_WITHDRAW_DEDUCT, (BizTradeService) context.getBean("withdrawDeductServiceImpl"));
            map.put(TradeConstants.TRADE_WITHDRAW_PAY_QUERY, (BizTradeService) context.getBean("withdrawPaymentQueryServiceImpl"));
            map.put(TradeConstants.TRADE_WITHDRAW_PAY, (BizTradeService) context.getBean("withdrawAlipayPayServiceImpl"));//提现，支付宝出款
            //提现-退回
            map.put(TradeConstants.TRADE_WITHDRAW_REFUND, (BizTradeService) context.getBean("withdrawDeductRefundServiceImpl"));
        }
        return map.get(tradePacket.getBusHead().getRequest_code());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
