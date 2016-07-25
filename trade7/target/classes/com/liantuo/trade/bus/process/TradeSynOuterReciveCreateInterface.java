package com.liantuo.trade.bus.process;


import com.liantuo.payment.client.pay.PaymentRequest;
import com.liantuo.payment.client.pay.PaymentResponse;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;

/**
 * 公用的外部收款同步支付接口
 *
 * @param <B>
 * @author yangting
 *         2016年7月5日 上午11:27:37
 */
public interface TradeSynOuterReciveCreateInterface<B extends TradeRequestBody> {

    /**
     * 根据支付接口标准输入拆分组织支付中心输入内容
     *
     * @return 返回报文
     * @throws Exception
     */
    String createPaymentRequest(TradeRequest<B> tradeRquest) throws Exception;

    /**
     * 同步请求支付中心
     */
    PaymentResponse synRequestPayment(PaymentRequest payRequest) throws Exception;


    /**
     * xml序列化返回对象 用于更新请求支付中心日志
     *
     * @param obj
     * @return
     */
    String getPaymentResult(Object obj);

    /**
     * 解析调用结果 获取状态    如果获取不到链接 则抛出异常
     *
     * @param obj
     * @return
     * @throws Exception
     */
    void parseObject(PaymentResponse obj) throws Exception;

    /**
     * 修改收付款台账及外部返回
     *
     * @param tradeRquest
     */
    void updateSuccessOrFailLedger(TradeRequest<B> tradeRquest);

    String getResponseXml();

}