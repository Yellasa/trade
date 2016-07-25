package com.liantuo.trade.bus.template.impl;


import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizExternalRuntimeException;
import com.liantuo.trade.exception.BizRuntimeException;

/**
 * 变更交易（资金类-无台账-无清算）
 * 参考（ 0001_001_003 全额解冻）
 */
public abstract class ATradeNoLegderNoPaymentModTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeNoLegderTemp<R, Q, T> {

    @Override
    protected T realAccountPreHandle(R tradePacket, ReqContext reqContext) throws BizException {
        T trade = queryTrade(tradePacket, reqContext);//查询原交易

        if (this.checkTradeStatus(trade)) {//状态校验
            throw buildBusinessException("trade.original.trade.status.faliure",BizException.class);
        }

        return trade;
    }

    protected abstract boolean checkTradeStatus(T trade);

    @Override
    public void doDistTx(R tradePacket, T trade) throws BizExternalRuntimeException,BizRuntimeException {
        /**实时记账操作*/
        this.realAccount(tradePacket, trade);
        /**修改交易状态*/
        this.updateTradeStatus(tradePacket, trade);
        /**交易历史变更*/
        this.updateTradeChangeHis(trade);
    }

//    @Override
//    protected Q realAccountPstHandle(R tradePacket, T trade) {
//        return null;
//    }
}