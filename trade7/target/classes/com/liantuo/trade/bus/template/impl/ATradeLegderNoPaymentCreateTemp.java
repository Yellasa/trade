package com.liantuo.trade.bus.template.impl;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizExternalRuntimeException;
import com.liantuo.trade.exception.BizRuntimeException;

/**
 * 创建交易（资金类-有台账-无清算）
 * 参考（ 0001_002_001 线下付款退回）
 */
public abstract class ATradeLegderNoPaymentCreateTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeLegderNoPayment<R, Q, T> {

    @Override
    protected T realAccountPreHandle(R tradePacket, ReqContext reqContext) throws BizException, BizRuntimeException {
        checkTradeDuplicate(tradePacket);//交易编号重复校验
        T originalTrade = queryTrade(tradePacket, reqContext);//查询原交易
        if (this.checkTradeStatus(tradePacket, originalTrade)) {//状态校验
        	throw buildBusinessException("trade.original.trade.status.faliure",BizException.class);
        }
        tradeCreate(tradePacket, originalTrade, reqContext);
        /**交易历史插入*/
        this.updateTradeChangeHis(originalTrade);
        return originalTrade;
    }

    protected abstract T tradeCreate(R tradePacket, T originalTrade, ReqContext reqContext);

    protected abstract boolean checkTradeStatus(R tradePacket, T trade);

    protected final void checkTradeDuplicate(R tradePacket) throws BizException {
        if (checkDuplicate(tradePacket)) {
            throw buildBusinessException("trade.validate.trade.duplicate",BizException.class);
        }
    }

    protected abstract boolean checkDuplicate(R tradePacket);

    @Override
    public void doDistTx(R tradePacket, T trade) throws BizExternalRuntimeException,BizRuntimeException {
        /**创建台账*/
        this.createTradeLegder(tradePacket, trade);
        /**实时记账操作*/
        this.realAccount(tradePacket, trade);
        /**更新交易状态*/
        this.updateTradeStatus(tradePacket, trade);
        /**交易历史插入*/
        this.updateTradeChangeHis(trade);
    }
}