package com.liantuo.trade.bus.process;


import org.springframework.transaction.annotation.Transactional;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.orm.pojo.TradeSinglePayment;

@Deprecated
public interface XXXInterface<B extends TradeRequestBody> extends TradeSynOuterReciveCreateInterface<B> {

	/**
	 * 格式、业务校验
	 */
	void validate(TradeRequest<B> tradeRquest) throws Exception;
	
	/**
	 * 根据支付接口标准输入转化空白收付款台账数据
	 */
//	TradeLedger data2BlankLedger(TradePaymentCommonEntry data) throws Exception;
	
	
	/**
	 * 事务处理
	 */
	@Transactional(rollbackFor=Exception.class)
	void transaction(TradeRequest<B> tradeRquest) throws Exception;
	
	/**
	 * 创建失败交易记录
	 * @param tradeRquest
	 * @throws Exception
	 */
	TradeSinglePayment createPayFail(TradeRequest<B> tradeRquest) throws Exception;
	
	/**
	 * 外部收款同步支付或成功，或失败后的事务
	 */
	@Transactional(rollbackFor=Exception.class)
	void transactionAfterRequestPayment(TradeRequest<B> tradeRquest) throws Exception;
	
	/**
	 * 外部收款同步支付事务成功后的另一个事务
	 */
	@Transactional(rollbackFor=Exception.class)
	void transactionAfterRequestPaymentSuccess(TradeRequest<B> tradeRquest) throws Exception;
	
	void setReqNo(String reqNo);
	
	Object getTradeDetails();
	
	
	/**
	 * 修改交易记录
	 */
	void updateTradeRecord(TradeRequest<B> tradeRquest) throws Exception;
	
	/**
	 * 修改充值失败
	 */
	void updateTradeToFailure(TradeRequest<B> tradeRquest);
	
}