package com.liantuo.trade.bus.template.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import com.liantuo.trade.bus.factory.service.LegderServiceFactory;
import com.liantuo.trade.bus.factory.service.PaymentServiceFactory;
import com.liantuo.trade.bus.factory.service.TradeModifyHistoryServiceFactory;
import com.liantuo.trade.bus.factory.service.TradeServiceFactory;
import com.liantuo.trade.bus.service.BizPaymentCenterService;
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
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.pojo.TradeLedgerLog;
import com.liantuo.trade.orm.service.TradeLedgerLogService;

/**
 * 第三方支付结果查询处理模板
 */
public abstract class ATradePayResultQueryTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeTemp<R, Q, T> implements DistributedHandle<R, T>{

    private final Log LOGGER = LogFactory.getLog(ATradePayResultQueryTemp.class);

    @Resource(name = "distributedHandleInvoker")
    private DistributedHandleInvoker distributedHandleInvoker;
    @Resource(name = "tradeServiceFactory")
    private TradeServiceFactory tradeServiceFactory;
    @Resource(name = "legderServiceFactory")
    private LegderServiceFactory legderServiceFactory;
    @Resource(name = "paymentServiceFactory")
    private PaymentServiceFactory paymentServiceFactory;
    @Resource(name = "tradeModifyHistoryServiceFactory")
    private TradeModifyHistoryServiceFactory tradeModifyHistoryServiceFactory;
    @Resource(name = "tradeLedgerLogService")
    private TradeLedgerLogService tradeLedgerLogService;
    
    private BizTradeService tradeService;
    private TradeChangeHisService tradeChangeHisService;
    private BizPaymentCenterService paymentCenterService;
    
    @Override
    protected void build(R tradePacket) {
        buildTradeService(tradePacket);
        buildTradeChangeHisService(tradePacket);
        buildBizPaymentCenterService(tradePacket);
    }

    @Override
    protected Q trade(R tradePacket, ReqContext reqContext) {
        T trade = null;
        try {
            trade = realAccountPreHandle(tradePacket, reqContext);
            if(trade == null){
                // 原交易不存在
                return this.buildRsp(trade, getInternalFailureCode("withdraw.trade.not.exists"), getInternalFailureMessage("withdraw.trade.not.exists"));
            }else{
                trade.setReqContext(reqContext);
            }
            // 交易系统中交易状态“不”为【出款处理中】时，返回当前交易数据
            Q rsp = processTradeQueryResult(tradePacket, trade);
            if (rsp != null) {
                return rsp;
            }
            // 处理交易系统的查询结果, 如果有结果，直接返回，没有结果则查询支付中心查询结果
            rsp = queryFromPaymentcenter(tradePacket, trade);
            if(rsp != null){
                return rsp;
            }
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
    
    /**
     * 处理交易系统的查询结果
     */
    protected abstract Q processTradeQueryResult(R tradePacket, T trade);
    
    protected Q queryFromPaymentcenter(R tradePacket, T trade) throws BizException,BizRuntimeException{
        // 从支付中心查询结果， 将查询结果放到  BizVO 中
        try {
            paymentCenterService.paymentRequest(tradePacket, trade);
        } catch (Exception e) {
            this.logger(trade.getReqContext(),getInternalFailureCode("withdraw.paymentcenter.exception"), 
                    getInternalFailureMessage("withdraw.paymentcenter.exception"), e);
            throw this.buildBusinessException("withdraw.paymentcenter.exception", BizException.class);
        }
        // 查询结果数据校验
        Q rsp = validatePaymentcenterQueryResultData(tradePacket, trade);
        if(rsp != null){
            return rsp;
        }
        // 处理支付中心的查询结果
        rsp = processPaymentcenterQueryResult(tradePacket, trade);
        if(rsp != null){
        	LOGGER.info("成员提现--->调用支付中心进行结果查询 返回数据如下：" + rsp.marshal());
            return rsp;
        }
        // 根据支付中心的查询结果，处理分布式事务
        distributedHandleInvoker.realAccountInvoke(this, tradePacket, trade);
        
        // 如果支付宝返回的结果是 ret_code=-1, 则需返回支付宝错误码
        rsp = buildFailedResponse(trade);
        if(rsp != null){
            return rsp;
        }
        return null;
    }
    
    protected abstract Q buildFailedResponse(T trade);

    protected abstract Q validatePaymentcenterQueryResultData(R tradePacket, T trade);

    // 根据支付中心的查询结果，处理分布式事务
    @Override
    public void doDistTx(R tradePacket, T trade) throws BizRuntimeException {
        TradeLedger ledger = queryTradeLedger(trade);
        // 更新 交易 状态 及 台帐 状态
        updateTradeByPaymentcenterQueryResult(tradePacket, trade, ledger);
        // 记录台帐历史
        addTradeLedgerHistoryLog(ledger);
        // 记录交易历史
        tradeChangeHisService.create(trade);
    }

    protected abstract TradeLedger queryTradeLedger(T trade);

    protected void addTradeLedgerHistoryLog(TradeLedger ledger){
        TradeLedgerLog log = new TradeLedgerLog();
        BeanUtils.copyProperties(ledger, log);
        log.setId(null);
        tradeLedgerLogService.insertTradeLedgerLog(log);
    }
    
    /**
     * 处理支付中心获得的查询结果
     */
    protected abstract Q processPaymentcenterQueryResult(R tradePacket, T trade);
    
    /**
     * 如果支付中心结果为处理完成（成功或失败），则更新交易状态
     */
    protected abstract void updateTradeByPaymentcenterQueryResult(R tradePacket, T trade, TradeLedger ledger);
    
    protected T realAccountPreHandle(R tradePacket, ReqContext reqContext) throws BizException{
        T trade = queryOriginalTrade(tradePacket);
        if(trade == null){
            return null;
        }
        
        bizValidate(tradePacket, trade);// 业务校验
        
        return trade;
    }
    
    protected abstract T queryOriginalTrade(R tradePacket);

    protected abstract void bizValidate(R tradePacket, T trade) throws BizException;

    protected final void buildTradeService(R tradePacket) {
        try {
            this.tradeService = this.tradeServiceFactory.create(tradePacket);
        } catch (Exception e) {
            LOGGER.error("buildTradeService", e);
        }
    }
    
    protected final void buildTradeChangeHisService(R tradePacket) {
        try {
            tradeChangeHisService = this.tradeModifyHistoryServiceFactory.create(tradePacket);
        } catch (Exception e) {
            LOGGER.error(tradePacket.getBusHead().getRequest_code(), e);
        }
    }
    
    protected final void buildBizPaymentCenterService(R tradePacket) {
        try {
            paymentCenterService = this.paymentServiceFactory.create(tradePacket);
        } catch (Exception e) {
            LOGGER.error(tradePacket.getBusHead().getRequest_code(), e);
        }
    }
    
    public BizTradeService getTradeService() {
        return tradeService;
    }
    
    public TradeChangeHisService getTradeChangeHisService() {
        return tradeChangeHisService;
    }
    
    public BizPaymentCenterService getPaymentCenterService() {
        return paymentCenterService;
    }
    
}
