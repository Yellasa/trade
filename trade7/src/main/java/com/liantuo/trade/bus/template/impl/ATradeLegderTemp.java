package com.liantuo.trade.bus.template.impl;

import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.bus.factory.service.LegderServiceFactory;
import com.liantuo.trade.bus.service.BizLegderService;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.annotation.Template;
import com.liantuo.trade.exception.BizRuntimeException;

import javax.annotation.Resource;

/**
 * 资金类-有台账
 */
public abstract class ATradeLegderTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeSettleTemp<R, Q, T> {
	
    @Override
    protected void build(R tradePacket) {
        super.build(tradePacket);
        buildLegderCreateService(tradePacket);
    }

    @Resource(name = "legderServiceFactory")
    private LegderServiceFactory legderServiceFactory;

    private BizLegderService legderService;

    public BizLegderService getLegderService() {
        return legderService;
    }

    protected void buildLegderCreateService(R tradePacket) {
        try {
            legderService = this.legderServiceFactory.create(tradePacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected final void createTradeLegder(R tradePacket, T trade) throws BizRuntimeException{
        try {
            createLedger(tradePacket, trade);
        } catch (Exception e) {
            this.logger(trade.getReqContext(), "trade.legder.create.error", "业务台帐创建错误", e);
            throw buildBusinessUncheckedException("trade.legder.create.error",BizRuntimeException.class);
        }
    }

    protected abstract void createLedger(R tradePacket, T trade);
}