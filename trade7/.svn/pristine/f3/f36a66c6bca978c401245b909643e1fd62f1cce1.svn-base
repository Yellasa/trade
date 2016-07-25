package com.liantuo.trade.bus.template.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizExternalRuntimeException;
import com.liantuo.trade.exception.BizRuntimeException;
import com.payment.client.pay.BusTransaction;
import com.payment.client.pay.vo1.BusTransactionRspPay;


/**
 * 修改交易（资金类-有台账-有清算）
 * （ 0002_001_002 成员提现，出款）
 */
public abstract class ATradeLegderPaymentModTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeLegderPaymentTemp<R, Q, T>{
	private final Log LOGGER = LogFactory.getLog(ATradeLegderPaymentModTemp.class);
	 
    @Override
    protected final T realAccountPreHandle(R tradePacket, ReqContext reqContext) throws BizException{
        T trade = queryTrade(tradePacket, reqContext);//查询原交易
        
        bizValidate(tradePacket, trade);//业务校验
        
        createBatchNo(tradePacket, reqContext);//获取提现批次号和流水号
        
        return trade;
    }
    
    private void bizValidate(R tradePacket, T trade) throws BizException {
        /** 合作商户编号权限校验  */
//        if(!checkPartnerHasAuthority(tradePacket)){
//            //TODO 添加异常
//        }
        
        /** 核心商户出款渠道身份校验  */
        if(checkCoreMerchantChannel(tradePacket)) {
        	throw buildBusinessException("withdraw.core.merchant.no.conf", BizException.class);
        }
        
        /** 交易状态校验  */
        if (this.checkTradeStatus(trade)) {//状态校验
            throw buildBusinessException("withdraw.original.trade.status", BizException.class);
        }
    }

    /** 
     * 合作商户编号权限校验 
     */
//    protected abstract boolean checkPartnerHasAuthority(R tradePacket);
    
    /**
     * 核心商户出款渠道身份校验
     */
    protected abstract boolean checkCoreMerchantChannel(R tradePacket);
    
    /**
     * 交易状态校验
     */
    protected abstract boolean checkTradeStatus(T trade);
    
    /**
     * 获取提现批次号和流水号
     * @param tradePacket
     * @param reqContext
     * @return
     */
    protected abstract void createBatchNo(R tradePacket, ReqContext reqContext);
    
    @Override
    public void doDistTx(R tradePacket, T trade) throws BizExternalRuntimeException,BizRuntimeException {
        /**创建空白业务台账*/
        this.createTradeLegder(tradePacket, trade);
        /**创建台账历史记录*/
        this.createTradeLegderHis(tradePacket, trade);
        /**修改交易状态*/
        this.updateTradeStatus(tradePacket, trade);
        /**交易历史变更*/
        this.updateTradeChangeHis(trade);
    }
    
    protected final void createTradeLegderHis(R tradePacket, T trade) throws BizRuntimeException{
        try {
            createLedgerHis(tradePacket, trade);
        } catch (Exception e) {
            LOGGER.error(e);
            throw buildBusinessUncheckedException("trade.system.error", BizRuntimeException.class);
        }
    }
    
    protected abstract void createLedgerHis(R tradePacket, T trade);

    @Override
    protected void realAccountPstHandle(R tradePacket, T trade) throws BizRuntimeException, BizException {
        /**
         * 9、提交支付中心
         * 10、校验同步返回参数
         * 11、校验返回业务数据
         */
    	BusTransaction rsp=paymentSend(tradePacket, trade);
    	
    	paymentCheck(rsp,trade);
    	
    }

    protected abstract void paymentCheck(BusTransaction rsp, T trade)  throws BizException;
    
    // 无需操作账务
    @Override
    protected List<RealTimeAccountingRsp> account(R tradePacket, T trade) throws BizException {
        return new ArrayList<RealTimeAccountingRsp>();
    }
    
}
