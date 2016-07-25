package com.liantuo.trade.bus.template.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.trade.bus.factory.service.AccountServiceFactory;
import com.liantuo.trade.bus.factory.service.TradeModifyHistoryServiceFactory;
import com.liantuo.trade.bus.factory.service.TradeServiceFactory;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.BizTradeService;
import com.liantuo.trade.bus.service.TradeChangeHisService;
import com.liantuo.trade.bus.template.DistributedHandle;
import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizExternalRuntimeException;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.exception.BusinessUncheckedException;

/**
 * 资金类-非查询类交易-模板
 */
public abstract class ATradeSettleTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeTemp<R, Q, T> implements DistributedHandle<R, T> {
    private final Log LOGGER = LogFactory.getLog(ATradeSettleTemp.class);

    @Resource(name = "distributedHandleInvoker")
    private DistributedHandleInvoker distributedHandleInvoker;

    @Override
    protected final Q trade(R tradePacket, ReqContext reqContext) {
        T trade = null;
        try {
            /**实时账务前处理*/
            trade = realAccountPreHandle(tradePacket, reqContext);
            /**分布式记账处理*/
            if (null != trade) {
                /**交易请求上下文*/
                trade.setReqContext(reqContext);
                /**实时账务处理*/
                realAccountInvoke(tradePacket, trade);
            }

            /**实时账务后处理，暂时没有*/
            realAccountPstHandle(tradePacket, trade);
        } catch (BizException e) {
            BusinessException e1 = fixBusinessException(e);
            logger(reqContext, e1.getErrorCode(), e1.getErrorMessage(), null);
            return buildRsp(trade, e1.getErrorCode(), e1.getErrorMessage());
        } catch (BizRuntimeException e) {
            BusinessException e1 = fixBusinessException(e);
            logger(reqContext, e1.getErrorCode(), e1.getErrorMessage(), null);
            return buildRsp(trade, e1.getErrorCode(), e1.getErrorMessage());
        } catch (BizExternalRuntimeException e) {
            BusinessException e1 = fixBusinessException(e);
            logger(reqContext, e1.getErrorCode(), e1.getErrorMessage(), null);
            return buildRsp(trade, e1.getErrorCode(), e1.getErrorMessage());
        } catch (Exception e) {
            logger(reqContext, "", "", e);
            return buildRsp(trade, getInternalFailureCode("trade.system.error"), getInternalFailureMessage("trade.system.error"));
        }

        return buildRsp(trade, getInternalFailureCode("trade.success"), getInternalFailureMessage("trade.success"));
    }
    
    private void realAccountInvoke(R tradePacket, T trade) throws Exception{
        try {
            distributedHandleInvoker.realAccountInvoke(this, tradePacket, trade);
        } catch (Exception e){
        	realAccountInvokeFailed(tradePacket, trade);
            throw e;
        }
    }

    /**
     * 同一事务中的交易处理失败后的处理
     */
    protected void realAccountInvokeFailed(R tradePacket, T trade){
        
    }
    
    protected DistributedHandleInvoker getDistributedHandleInvoker() {
        return distributedHandleInvoker;
    }
    
    protected void realAccountPstHandle(R tradePacket, T trade) throws BizRuntimeException, BizException {
    }

    @Override
    public abstract void doDistTx(R tradePacket, T trade) throws BizRuntimeException, BizExternalRuntimeException;

    protected abstract T realAccountPreHandle(R tradePacket, ReqContext reqContext) throws BizException;

    @Override
    protected void build(R tradePacket) {
        buildTradeService(tradePacket);
        buildAccountService(tradePacket);
        buildTradeChangeHisService(tradePacket);
    }

    @Resource(name = "tradeServiceFactory")
    private TradeServiceFactory tradeServiceFactory;
    @Resource(name = "accountServiceFactory")
    private AccountServiceFactory accountServiceFactory;
    @Resource(name = "tradeModifyHistoryServiceFactory")
    private TradeModifyHistoryServiceFactory tradeModifyHistoryServiceFactory;

    private BizTradeService tradeService;
    private BizAccountService accountService;
    private TradeChangeHisService tradeChangeHisService;

    protected BizTradeService getTradeService() {
        return tradeService;
    }

    protected BizAccountService getAccountService() {
        return accountService;
    }

    protected TradeChangeHisService getTradeChangeHisService() {
        return tradeChangeHisService;
    }

    protected final void buildTradeService(R tradePacket) {
        try {
            this.tradeService = this.tradeServiceFactory.create(tradePacket);
        } catch (Exception e) {
            LOGGER.error("buildTradeService", e);
        }
    }

    protected final void buildAccountService(R tradePacket) {
        try {
            accountService = this.accountServiceFactory.create(tradePacket);
        } catch (Exception e) {
            LOGGER.error(tradePacket.getBusHead().getRequest_code(), e);
        }
    }

    protected final void buildTradeChangeHisService(R tradePacket) {
        try {
            tradeChangeHisService = this.tradeModifyHistoryServiceFactory.create(tradePacket);
        } catch (Exception e) {
            LOGGER.error(tradePacket.getBusHead().getRequest_code(), e);
        }
    }

    protected final void realAccount(R tradePacket, T trade) throws BizExternalRuntimeException, BizRuntimeException {
        /**实时记账操作*/
        List<RealTimeAccountingRsp> resultlist;
        try {
            long start = System.currentTimeMillis();
			resultlist = account(tradePacket, trade);
			LOGGER.info(" ->>> 账务执行时间：" + (System.currentTimeMillis() - start));
            RealTimeAccountingRsp rsp;
            for (Iterator<RealTimeAccountingRsp> it = resultlist.iterator(); it.hasNext(); ) {
                rsp = it.next();
                if ("F".equals(rsp.getSuccess())) {
                    throw new BizExternalRuntimeException(rsp.getRetCode(), rsp.getErrMessage());
                }
            }
        } catch (BusinessUncheckedException e) {
        	LOGGER.error(tradePacket.getBusHead().getRequest_code(), e);
            throw new BizExternalRuntimeException(e.getErrorCode(), e.getErrorMessage());
        } catch (BizException e) {
			// TODO Auto-generated catch block
        	LOGGER.error(tradePacket.getBusHead().getRequest_code(), e);
        	throw buildBusinessUncheckedException("trade.real.account.error", BizRuntimeException.class);
		}
    }

    protected abstract List<RealTimeAccountingRsp> account(R tradePacket, T trade) throws BizException;

    /**
     * 更新交易状态
     *
     * @param trade
     */
    protected final void updateTradeStatus(R tradePacket, T trade) throws BizRuntimeException {
        try {
            updateStatus(tradePacket, trade);
        } catch (Exception e) {
            LOGGER.error(tradePacket.getBusHead().getRequest_code(), e);
            throw buildBusinessUncheckedException("trade.status.update.error", BizRuntimeException.class);
        }
    }

    protected abstract void updateStatus(R tradePacket, T trade);

    /**
     * 更新交易历史
     *
     * @param trade
     */
    protected final void updateTradeChangeHis(T trade) throws BizRuntimeException {
        try {
            updateTradeChgHis(trade);
        } catch (Exception e) {
            LOGGER.error(e);
            throw buildBusinessUncheckedException("trade.system.error", BizRuntimeException.class);
        }
    }

    protected abstract void updateTradeChgHis(T trade);

    /**
     * 查询原交易
     *
     * @param tradePacket
     * @return
     */
    protected final T queryTrade(R tradePacket, ReqContext reqContext) throws BizException, BizRuntimeException {
        T originalTrade;
        try {
            originalTrade = queryOriginalTrade(tradePacket, reqContext);
        } catch (Exception e) {
            logger(reqContext, "", "", e);
            throw buildBusinessUncheckedException("trade.system.error", BizRuntimeException.class);
        }
        if (null == originalTrade) {
            throw buildBusinessException("trade.original.trade.not.exists", BizException.class);
        }
        return originalTrade;
    }

    protected abstract T queryOriginalTrade(R tradePacket, ReqContext reqContext);


}