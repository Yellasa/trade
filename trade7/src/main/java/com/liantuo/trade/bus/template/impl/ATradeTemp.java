package com.liantuo.trade.bus.template.impl;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liantuo.trade.bus.template.Execute;
import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.message.MessageBundleService;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.exception.BusinessCheckedException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.exception.BusinessUncheckedException;

/**
 * 资金交易模板
 */
public abstract class ATradeTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> implements Execute<R, Q, T> {
	private final Log LOGGER = LogFactory.getLog(ATradeTemp.class);
	@Resource(name = "messageBundleServiceImpl")
    private MessageBundleService messageBundleService;

    @Override
    public Q execute(R tradePacket, ReqContext reqContext) {
        LOGGER.info("请求报文参数："+tradePacket.marshal());
    	/**构建交易*/
        try {
            this.build(tradePacket);
        } catch (Exception e) {
        	logger(reqContext,"","",e);
            return buildRsp(null, "trade.system.error", null);
        }
        /**执行交易*/
        return trade(tradePacket, reqContext);
    }

    protected abstract void build(R TradePacket);

    protected abstract Q trade(R tradePacket, ReqContext reqContext);

    private Class<R> entityClass;

    /*public ATradeTemp() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }*/

    public Class<R> getVoClass() {
		if(null == this.entityClass){
			Type genType = getClass().getGenericSuperclass();
			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
			entityClass = (Class) params[0];
		}
        return entityClass;
    }

    protected final String getInternalFailureCode(String key) {
        return this.messageBundleService.getCode(key);
    }
    /**
     * 支持info与error
     * @param reqContext
     * @param errorCode   info级别业务异常使用
     * @param errorMsg    info级别业务异常使用
     * @param e   error级别使用
     */
    protected void logger(ReqContext reqContext,String errorCode,String errorMsg,Exception e){
    	if(reqContext!=null&&reqContext.getReq()!=null){
	    	StringBuffer sb=new StringBuffer();
	    	if(reqContext.getReq().getOutTradeNo()!=null){
	    		sb.append("OutTradeNo:").append(reqContext.getReq().getOutTradeNo());
	    	}
	    	if(reqContext.getReq().getTradeNo()!=null){
	    		sb.append("tradeNo:").append(reqContext.getReq().getTradeNo());
	    	}
	    	sb.append(" ReqNo:").append(reqContext.getReq().getReqNo());
	    	if(e==null){
		    	sb.append(" errorCode:").append(errorCode);
		    	sb.append(" errorMsg:").append(errorMsg);
		    	LOGGER.info(sb.toString());
	    	}else{
	    		LOGGER.error(sb.toString(), e);
	    	}
	    	
    	}else if(e!=null){
    		LOGGER.error("", e);
    	}
    }
    protected final String getInternalFailureMessage(String key, Object[] objs) {
        return this.messageBundleService.getMessage(key, objs);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	
    }
    protected final <S extends BusinessUncheckedException> S buildBusinessUncheckedException(String key,Class<S> clazz){
    	String errorCode =  getInternalFailureCode(key);
    	String errorMessage = getInternalFailureMessage(key);
    	
    	try {
			S instance = clazz.newInstance();
			instance.setErrorCode(errorCode);
			instance.setErrorMessage(errorMessage);
			return instance;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	
    }
    protected final BusinessException fixBusinessException(Exception e){
    	if(e instanceof BusinessException){
    		BusinessException s = (BusinessException) e;
        	if((StringUtils.isEmpty(s.getErrorCode()) ||  StringUtils.isEmpty(s.getErrorMessage())) && StringUtils.isNotEmpty(s.getKey())){
        		return buildBusinessException(s.getKey(),s.getClass());
        	}else if(StringUtils.isNotEmpty(s.getErrorCode()) &&  StringUtils.isNotEmpty(s.getErrorMessage())){
        		return s;
        	}else if(StringUtils.isEmpty(s.getKey())){
        		return buildBusinessException("trade.system.error",BusinessCheckedException.class);
        	}
    	}else{
    		buildBusinessException("trade.system.error",BusinessCheckedException.class);
    	}

    	
		return null;
    	
    }
    protected final String getInternalFailureMessage(String key) {
        return this.getInternalFailureMessage(key, null);
    }

    protected final void free(Object obj) {
        obj = null;
    }
    protected abstract Q buildRsp(T trade, String code, String message);
}
