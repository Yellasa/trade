package com.liantuo.trade.bus.template.impl;

import com.liantuo.trade.bus.factory.service.TradeQueryServiceFactory;
import com.liantuo.trade.bus.service.BizTradePageQueryService;
import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.exception.BusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;


/**
 * 资金类-交易查询
 * 参考（0001_001_998 0001_002_998）
 */
public abstract class ATradePageQueryTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeTemp<R, Q, T> {

    private final Log LOGGER = LogFactory.getLog(ATradePageQueryTemp.class);

    protected abstract Q buildRsp(T trade, String code, String message);

    @Override
    protected void build(R tradePacket) {
        buildTradeService(tradePacket);
    }

    @Resource(name = "tradeQueryServiceFactory")
    private TradeQueryServiceFactory tradeQueryServiceFactory;

    private BizTradePageQueryService tradeService;

    protected BizTradePageQueryService getTradeService() {
        return tradeService;
    }

    protected final void buildTradeService(R tradePacket) {
        try {
            this.tradeService = this.tradeQueryServiceFactory.createQuery(tradePacket);
        } catch (Exception e) {
            LOGGER.error("buildTradeService", e);
        }
    }

    @Override
    protected Q trade(R tradePacket, ReqContext reqContext) {
        T trade = null;
        try {
            trade = queryByPage(tradePacket);
        } catch (BizRuntimeException ex) {
            BusinessException e1 = fixBusinessException(ex);
            logger(reqContext, e1.getErrorCode(), e1.getErrorMessage(), null);
            return buildRsp(trade, e1.getErrorCode(), e1.getErrorMessage());
        } catch (Exception e) {
            logger(reqContext, "", "", e);
            return buildRsp(null, getInternalFailureCode("trade.system.error"), getInternalFailureCode("trade.system.error"));
        }
        return buildRsp(trade, getInternalFailureCode("trade.success"), getInternalFailureMessage("trade.success"));
    }

    protected abstract T queryByPage(R tradePacket);
}