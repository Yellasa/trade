package com.liantuo.trade.bus.factory.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.BizTradePageQueryService;
import com.liantuo.trade.bus.service.BizTradeService;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.constants.TradeConstants;

@Component("tradeQueryServiceFactory")
public class TradeQueryServiceFactory implements ApplicationContextAware {

	private ApplicationContext context;
	private Map<String, BizTradePageQueryService> mapQuery = new HashMap<String, BizTradePageQueryService>();

	public BizTradePageQueryService createQuery(TradePacket tradePacket) throws Exception {
		if (mapQuery.isEmpty()) {// TODO 配置化
			//001 冻减付
			mapQuery.put(TradeConstants.TRADE_TYPE_PAY_NO_PWD_PAGE_DETAILS, (BizTradePageQueryService) context.getBean("bizPaymentTradePageQueryServiceImpl"));
			mapQuery.put(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_PAGE_DETAILS, (BizTradePageQueryService) context.getBean("bizRefundTradePageQueryServiceImpl"));
			
			// 提现交易查询
			mapQuery.put(TradeConstants.TRADE_WITHDRAW_QUERY, (BizTradePageQueryService) context.getBean("withdrawPageQueryServiceImpl"));
		}
		return mapQuery.get(tradePacket.getBusHead().getRequest_code());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
	    
}
