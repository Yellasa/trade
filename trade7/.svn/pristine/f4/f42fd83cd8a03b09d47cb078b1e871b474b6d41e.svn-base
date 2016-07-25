package com.liantuo.trade.bus.template.impl;


import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizExternalRuntimeException;
import com.liantuo.trade.exception.BizRuntimeException;

/**
 * 变更交易（资金类-有台账-无清算）
 * 参考（ 0001_001_002 线下付款成功,剩余解冻）
 */
public abstract class ATradeLegderNoPaymentModTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeLegderNoPayment<R, Q, T> {
    @Override
    protected final T realAccountPreHandle(R tradePacket, ReqContext reqContext) throws BizException {
        T trade = queryTrade(tradePacket, reqContext);//查询原交易

        if (this.chectTradeStatus(trade)) {//状态校验
        	throw buildBusinessException("trade.original.trade.status.faliure",BizException.class);
        }
        
        bizValidate(tradePacket, trade);//业务校验
        
        return trade;
    }

    protected abstract boolean chectTradeStatus(T trade);

    protected abstract void bizValidate(R tradePacket, T trade) throws BizException;

    @Override
    public void doDistTx(R tradePacket, T trade) throws BizExternalRuntimeException,BizRuntimeException {
    		/**实时记账操作*/
    		this.realAccount(tradePacket, trade);
    		/**创建外部收付款业务台账*/
    		this.createTradeLegder(tradePacket, trade);
    		/**修改交易状态*/
    		this.updateTradeStatus(tradePacket, trade);
    		/**交易历史插入*/
    		this.updateTradeChangeHis(trade);
    }
}