package com.liantuo.trade.bus.template.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizExternalRuntimeException;
import com.liantuo.trade.exception.BizRuntimeException;

/**
 * 新交易创建（无台账） 0001_001_001 成员冻结
 */
public abstract class ATradeNoLegderNoPaymentCreateTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeNoLegderTemp<R, Q, T> {
	private final Log LOGGER = LogFactory.getLog(ATradeNoLegderNoPaymentCreateTemp.class);
	@Override
    protected final T queryOriginalTrade(R tradePacket, ReqContext reqContext) {
        return null;
    }

    @Override
    protected T realAccountPreHandle(R tradePacket, ReqContext reqContext) throws BizException {
        checkTradeDuplicate(tradePacket);//交易编号重复校验
        bizValidate(tradePacket, reqContext);//业务校验
        
        T trade;
        try {
            trade = this.tradeCreate(tradePacket, reqContext);//创建交易
            this.updateTradeChangeHis(trade);//交易历史插入
        } catch (Exception e) {
        	LOGGER.error(String.format("交易创建失败 OutTradeNoExt=%s ", reqContext.getReq().getOutTradeNoExt()));
            throw buildBusinessException("trade.record.save.error",BizException.class);
        }
        return trade;
    }

    protected final void checkTradeDuplicate(R tradePacket) throws BizException {
        if (checkDuplicate(tradePacket)) {
            throw buildBusinessException("trade.validate.trade.duplicate",BizException.class);
        }
    }

    protected abstract boolean checkDuplicate(R tradePacket);

    protected abstract void bizValidate(R tradePacket, ReqContext reqContext) throws BizException;

    protected abstract T tradeCreate(R tradePacket, ReqContext reqContext);

    @Override
    public void doDistTx(R tradePacket, T trade) throws BizExternalRuntimeException,BizRuntimeException {
    	/**实时记账操作*/
    	this.realAccount(tradePacket, trade);
    	/**修改交易状态*/
        this.updateTradeStatus(tradePacket, trade);//交易更新
        /**交易历史变更*/
        this.updateTradeChangeHis(trade);//交易历史插入
    }
}