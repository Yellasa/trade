package com.liantuo.trade.bus.template.impl;

import com.liantuo.trade.bus.service.NotifyLegderService;
import com.liantuo.trade.bus.service.NotifyTradeService;
import com.liantuo.trade.bus.vo.ANotifyBizVo;
import com.liantuo.trade.client.trade.packet.NotifyPacket;
import com.liantuo.trade.client.trade.packet.NotifyRspPacket;
import com.liantuo.trade.common.message.MessageBundleService;
import com.liantuo.trade.common.util.trade.NotifyReqContext;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.pojo.TradeLedgerLog;
import com.liantuo.trade.orm.service.TradeLedgerLogService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * 通知类模版
 */
public abstract class ANotifyTemp<R extends NotifyPacket, Q extends NotifyRspPacket, T extends ANotifyBizVo<?>> {

    private final Log logger = LogFactory.getLog(ANotifyTemp.class);
    
    private Class<R> entityClass;
    
    @Resource(name = "messageBundleServiceImpl")
    private MessageBundleService messageBundleService;
    
    @Resource
    private TradeLedgerLogService tradeLedgerLogService;

    /**
     * 交易执行
     * @param notifyPacket
     * @param reqContext
     * @return
     */
    public Q execute(R notifyPacket, NotifyReqContext reqContext) {
        try {
            this.build(notifyPacket);
        } catch (Exception e) {
            logger(reqContext, "", "", e);
            return buildRsp(null, this.getInternalFailureCode("withdraw.system.error"), 
                    this.getInternalFailureMessage("withdraw.system.error"));
        }
        /**执行交易*/
        return trade(notifyPacket, reqContext);
    }

    /**
     * 服务获取
     * @param roticePacke
     */
    protected void build(R roticePacke) {
        // 目前采用注入方式
    }

    /**
     * 处理交易
     * @param notifyPacket
     * @param reqContext
     * @return
     */
    private Q trade(R notifyPacket, NotifyReqContext reqContext) {
        T bizVo = null;
        Q rsp;
        try {

            bizVo = preTrade(notifyPacket, reqContext);

            rsp = validateBizData(notifyPacket, bizVo);

            if(rsp == null){
                rsp = doDistTx(notifyPacket, bizVo);
            }
        } catch (BizRuntimeException e) {
            logger.error(" >>> 交易执行前处理异常：{}", e);
            rsp = buildRsp(bizVo, e.getErrorCode(), e.getErrorMessage());
        } catch (BizException e) {
            logger.error(" >>> 交易执行前处理异常：{}", e);
            rsp = buildRsp(bizVo, e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            logger.error(" >>> 交易执行前处理异常：{}", e);
            rsp = buildRsp(bizVo, this.getInternalFailureCode("withdraw.system.error"), 
                    this.getInternalFailureMessage("withdraw.system.error"));
        } 
        
        postTrade(notifyPacket, rsp, bizVo);
        
        return rsp;
    }

    /**
     * 交易前处理
     *
     * @param notifyPacket
     * @param reqContext
     * @return
     * @throws BizException
     */
    protected abstract T preTrade(R notifyPacket, NotifyReqContext reqContext) throws BizException;
    
    protected abstract Q doDistTx(R notifyPacket, T bizVo);
    
    protected abstract void addTradeHistoryLog(T bizVo);

    protected void addTradeLedgerHistoryLog(TradeLedger ledger){
        TradeLedgerLog log = new TradeLedgerLog();
        BeanUtils.copyProperties(ledger, log);
        log.setId(null);
        tradeLedgerLogService.insertTradeLedgerLog(log);
    }

    protected final String getInternalFailureCode(String key) {
        return this.messageBundleService.getCode(key);
    }
    
    protected final String getInternalFailureMessage(String key) {
        return this.messageBundleService.getMessage(key, new Object[]{});
    }
    
    protected final String getInternalFailureMessage(String key, Object[] objs) {
        return this.messageBundleService.getMessage(key, objs);
    }
    
    public abstract NotifyLegderService<R,T> getNotifyLegderService();
    
    public abstract NotifyTradeService<R,T> getNotifyTradeService();
    
    protected abstract T assembleRequest(R notifyPacke) throws BizRuntimeException;

    /**
     * 业务校验
     * @param notifyPacke
     * @param bizVo
     * @return
     * @throws BizRuntimeException
     */
    protected abstract Q validateBizData(R notifyPacke, T bizVo) throws BizRuntimeException;

    protected abstract T queryOriginalTrade(R reqPacket, T bizVo);
    
    protected abstract Q buildRsp(T trade, String code, String message);

    /**
     * 交易后处理
     * @param notifyPacket
     * @param rsp
     * @param bizVo
     */
    protected abstract void postTrade(R notifyPacket, Q rsp, T bizVo);
    
    @SuppressWarnings("unchecked")
    public Class<R> getVoClass() {
        if(null == this.entityClass){
            Type genType = getClass().getGenericSuperclass();
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            entityClass = (Class<R>) params[0];
        }
        return entityClass;
    }

    protected void logger(NotifyReqContext reqContext, String errorCode, String errorMsg, Exception e){
        if(reqContext != null && reqContext.getReq() != null){
            StringBuffer sb=new StringBuffer();
            if(reqContext.getReq().getTradeNo()!=null){
                sb.append("TradeNo:").append(reqContext.getReq().getTradeNo());
            }
            if(reqContext.getReq().getReqNo() != null){
                sb.append("ReqNo:").append(reqContext.getReq().getReqNo());
            }
            if(e == null){
                sb.append(" errorCode:").append(errorCode);
                sb.append(" errorMsg:").append(errorMsg);
                logger.info(sb.toString());
            }else{
                logger.error(sb.toString(), e);
            }
            
        }else if(e != null){
            logger.error("", e);
        }
    }
    
    protected final <S extends BusinessException> S buildBusinessException(String key,Class<S> clazz){
        String errorCode =  getInternalFailureCode(key);
        String errorMessage = getInternalFailureMessage(key);
        try {
            S instance = clazz.newInstance();
            instance.setErrorCode(errorCode);
            instance.setErrorMessage(errorMessage);
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
