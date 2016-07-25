package com.liantuo.trade.bus.template.impl;

import javax.annotation.Resource;

import com.liantuo.trade.bus.factory.service.PaymentServiceFactory;
import com.liantuo.trade.bus.service.BizPaymentCenterService;
import com.liantuo.trade.bus.vo.ATradeBizVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizRuntimeException;
import com.payment.client.pay.BusTransaction;

/**
 * 资金类-有台账-有清算
 * 参考（暂无）
 */
public abstract class ATradeLegderPaymentTemp<R extends TradePacket, Q extends TradePacket, T extends ATradeBizVO> extends ATradeLegderTemp<R, Q, T> {

	 @Override
	    protected void build(R tradePacket) {
	        super.build(tradePacket);
	        buildPaymentCenterService(tradePacket);
	    }

	    @Resource(name = "paymentServiceFactory")
	    private PaymentServiceFactory paymentServiceFactory;

	    private BizPaymentCenterService paymentService;

	    public BizPaymentCenterService getPaymentService() {
			return paymentService;
		}

	    protected void buildPaymentCenterService(R tradePacket) {
	        try {
	        	paymentService = this.paymentServiceFactory.create(tradePacket);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /**
	     * 请求支付中心
	     *
	     * @param tradePacket
	     * @return
	     */
	    protected final BusTransaction paymentSend(R tradePacket, T trade) throws BizException, BizRuntimeException {
	    	BusTransaction paymentRsp;
	        try {
	        	paymentRsp = paymentRequest(tradePacket, trade);
	        } catch (Exception e) {
	            throw buildBusinessException("trade.system.error", BizException.class);
	        }
	        return paymentRsp;
	    }

	    protected abstract BusTransaction paymentRequest(R tradePacket, T trade);

	    
}