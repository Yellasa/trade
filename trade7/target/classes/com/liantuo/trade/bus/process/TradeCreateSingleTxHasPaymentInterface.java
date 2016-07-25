package com.liantuo.trade.bus.process;


import com.liantuo.payment.client.pay.PaymentResponse;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import org.springframework.transaction.annotation.Transactional;


public interface TradeCreateSingleTxHasPaymentInterface<B extends TradeRequestBody> {

	/**
	 * 事务处理
	 */
	@Transactional(rollbackFor=Exception.class)
	void transaction(TradeRequest<B> tradeRquest) throws Exception;


	/**
	 * 格式、业务校验
	 */
	void validate(TradeRequest<B> tradeRquest) throws Exception;


	/**
	 * 调用支付中心
	 * @throws Exception
	 */
	PaymentResponse  requestPayment() throws Exception;

	/**
	 * 解析调用结果 获取状态  暂定obj对象   如果获取不到链接 则抛出异常
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	void parseObject(PaymentResponse obj) throws Exception;

	/**
	 * 创建失败交易记录
	 * @param tradeRquest
	 * @throws Exception
	 */
	void createPayFail(TradeRequest<B> tradeRquest) throws Exception;


	/**
	 *  组织支付中心请求报文
	 * @return 返回报文
	 * @throws Exception
	 */
	String createPaymentRequest(TradeRequest<B> tradeRquest) throws Exception;

	void setReqNo(String reqNo);

	Object getTradeDetails();

	/**
	 * xml序列化返回对象
	 * @param obj
	 * @return
	 */
	String getPaymentResult(Object obj);

	/**
	 * 修改交易记录
	 */
	void updateTradeRecord(TradeRequest<B> tradeRquest) throws Exception;

	/**
	 * 修改充值失败
	 * @param tradeRquest
	 */
	void updateTradeToFailure(TradeRequest<B> tradeRquest);

	String getResponseXml();

}