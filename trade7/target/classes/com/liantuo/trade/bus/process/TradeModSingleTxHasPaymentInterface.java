package com.liantuo.trade.bus.process;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import org.springframework.transaction.annotation.Transactional;

public interface TradeModSingleTxHasPaymentInterface<B extends TradeRequestBody> {

    /**
     * 事务处理
     */
    @Transactional(rollbackFor = Exception.class)
    void transaction(TradeRequest<B> tradeRquest) throws Exception;

    void formatValidate(TradeRequest<B> tradeRquest) throws Exception;

    /**
     * 查询【付出CA账户编号】所属商户编号，若查询不到，则返回【失败】，异常原因【付出CA账户编号无所属成员商户编号】
     */
    void bizValidate(TradeRequest<B> tradeRquest) throws Exception;

    void setReqNo(String reqNo);

    Object getTradeDetails();

    void createTradeFailRecode(TradeRequest<B> tradeRquest) throws Exception;
}