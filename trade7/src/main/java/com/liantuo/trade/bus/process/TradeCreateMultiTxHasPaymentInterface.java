package com.liantuo.trade.bus.process;


import com.liantuo.payment.client.pay.PaymentResponse;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.exception.BusinessException;
import org.springframework.transaction.annotation.Transactional;


public interface TradeCreateMultiTxHasPaymentInterface<B extends TradeRequestBody> {

	/**
	 * 事务处理(创建一系列记录)
	 */
	@Transactional(rollbackFor=Exception.class)
	void transactionCreate(TradeRequest<B> tradeRequest) throws Exception;

	/**
	 * 事务处理(更改为等待入账)
	 */
	@Transactional(rollbackFor=Exception.class)
	void transactionEntry(TradeRequest<B> tradeRequest) throws Exception;
	
	/**
	 * 事务处理(更改为支付成功)
	 */
	@Transactional(rollbackFor=Exception.class)
	void transactionPaySuccess(TradeRequest<B> tradeRequest) throws Exception;
	
	/**
	 * 事务处理(更改为支付失败)
	 */
	@Transactional(rollbackFor=Exception.class)
	void transactionPayFailure(TradeRequest<B> tradeRequest) throws Exception;
	
	/**
	 * 格式、业务校验
	 */
	void validate(TradeRequest<B> tradeRequest) throws Exception;
	
	
	/**
	 * 调用支付中心
	 * @throws Exception
	 */
	PaymentResponse requestPayment() throws Exception;
	
	/**
	 * 解析调用结果 获取状态  暂定obj对象   如果获取不到链接 则抛出异常
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	TradeState parseObject(PaymentResponse obj) throws Exception;
	
	/**
	 * 创建失败交易记录
	 * @param tradeRequest
	 * @throws Exception
	 */
	void createPayFail(TradeRequest<B> tradeRequest) throws Exception;
	
	
	/**
	 *  组织支付中心请求报文
	 * @return 返回报文
	 * @throws Exception
	 */
	String createPaymentRequest(TradeRequest<B> tradeRequest) throws Exception;
	
	void prepareLedgerData(TradeRequest<B> tradeRequest);
	
	void setReqNo(String reqNo);
	
	Object getTradeDetails();
	
	String getResponseXml();
	
	BusinessException getException();

}