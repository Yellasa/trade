/**
 * 
 */
package com.liantuo.trade.bus.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.BizPaymentCenterService;
import com.liantuo.trade.bus.vo.WithdrawAlipayPayBizVO;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPay;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.orm.pojo.TradeOutPaymentLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeOutPaymentLogService;
import com.liantuo.trade.seqno.IdFactory;
import com.payment.client.pay.BusHead;
import com.payment.client.pay.BusTransaction;
import com.payment.client.pay.PaymentClient1;
import com.payment.client.pay.PaymentConstants;
import com.payment.client.pay.vo1.BusBodyReqPayBatch;
import com.payment.client.pay.vo1.BusTransactionReqPayBatch;
import com.payment.client.pay.vo1.BusTransactionRspPay;

/**
 * @ClassName:     WithdrawPaymentCenterServiceImpl.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-1-25 下午4:00:02 
 */
@Component(value = "withdrawPaymentCenterServiceImpl")
public class WithdrawPaymentCenterServiceImpl implements BizPaymentCenterService<TradePacketReqSingleWithdrawPay, WithdrawAlipayPayBizVO> {

	private final Log LOGGER = LogFactory.getLog(WithdrawPaymentCenterServiceImpl.class);
	
	@Value("#{propertiesReader['withdraw.alipay.notify.url']}")
    private String withdraw_notify_url;//withdraw.alipay.notify.url=http://192.168.19.63:8000/trade/notify/tx.in
	
	@Resource
	private TradeOutPaymentLogService tradeOutPaymentLogService;
	
	@Resource(name = "idFactoryTradeOutPaymentLogNo")
	private IdFactory idFactoryTradeOutPaymentLogNo;
	
	@Override
	public BusTransaction paymentRequest(TradePacketReqSingleWithdrawPay tradePacket, WithdrawAlipayPayBizVO trade) {
		BusTransactionReqPayBatch pay = new BusTransactionReqPayBatch();
		BusHead h = initBusHead();
		h.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_BATCH_PAY_NOPWD));
		h.setTransaction_id(tradePacket.getBody().getPay_transaction_id());//136385
		BusBodyReqPayBatch body = new BusBodyReqPayBatch();
		body.setPayer_account(tradePacket.getBody().getPayer_account());//zfbjk@liantuobank.com
		body.setPayer_code_name(tradePacket.getBusHead().getRequest_code()+"|"+trade.getTradeWithdraw().getTradeNo());
//		body.setPayer_code_name("trade");
		body.setPayer_name(tradePacket.getBody().getPayer_name());//合肥联拓金融信息服务有限公司北京分公司
		//001^ltftest02_zfb@126.com^合肥联拓金融信息服务有限公司^0.01^虚拟账户在线冲值批次号
		if(StringUtils.isEmpty(tradePacket.getBody().getWithdraw_third_account_paymemo())){
			tradePacket.getBody().setWithdraw_third_account_paymemo(trade.getTradeWithdraw().getTradeNo());
		}
		body.setBatch_detail(trade.getReqContext().get("serial_number")+"^"+tradePacket.getBody().getWithdraw_third_account()+"^"+tradePacket.getBody().getWithdraw_third_account_name()+"^"+AmountUtils.longConvertToBizAmount(trade.getTradeWithdraw().getWithdrawAmount())+"^"+tradePacket.getBody().getWithdraw_third_account_paymemo());
		body.setBatch_fee(AmountUtils.longConvertToBizAmount(trade.getTradeWithdraw().getWithdrawAmount()));//提现总金额
		body.setBatch_no((String)trade.getReqContext().get("batch_no"));//批次号
		body.setBatch_num("1");
		body.setNotify_url(withdraw_notify_url+"?trade_no="+trade.getTradeWithdraw().getTradeNo()+"&service_name="+TradeConstants.TRADE_WITHDRAW_NOTIFY+"&version="+tradePacket.getBusHead().getVersion());//tradePacket.getBody().getNotify_url()
//		body.setNotify_url(withdraw_notify_url);//tradePacket.getBody().getNotify_url()
		pay.setBusBodyReqPayBatch(body);
		pay.setBusHead(h);
		LOGGER.info("支付中心请求参数："+pay.marshal());
		TradeOutPaymentLogWithBLOBs log = createPaymentOutLog(tradePacket,trade,pay);
		BusTransactionRspPay rsp = (BusTransactionRspPay) PaymentClient1
				.batchPay(pay);
		LOGGER.info("支付中心响应报文："+rsp.marshal());
		updatePaymentOutLog(log,rsp);
//		System.out.println(rsp.marshal());
//		System.out.println(rsp.getBusBodyRspPay().getRet_code());
		return rsp;

	}
	
	private static BusHead initBusHead() {
		BusHead h = new BusHead();
		h.setPay_channel(String.valueOf(PaymentConstants.PAY_CHANNEL_ALIPAY));
		h.setRequest_time(DateUtil.toString(new Date(), "yyyyMMddHHmmss"));
		h.setRequester(String.valueOf(PaymentConstants.BIZ_TYPE_B2B));
		h.setPartner_code("liantuo");
		h.setVersion("1");
		return h;
	}
	
	 protected TradeOutPaymentLogWithBLOBs createPaymentOutLog(TradePacketReqSingleWithdrawPay tradePacket, WithdrawAlipayPayBizVO trade, BusTransactionReqPayBatch pay) {
	        String xml = pay.marshal();
	        
	        TradeOutPaymentLogWithBLOBs log = new TradeOutPaymentLogWithBLOBs();
	        log.setReqNo(getReqNo(tradePacket));
	        log.setTradeNo(tradePacket.getBody().getTrade_no());
	        log.setPaymentVersion("1");
	        log.setPayChannel(String.valueOf(PaymentConstants.PAY_CHANNEL_ALIPAY));
	        log.setTradeType(String.valueOf(PaymentConstants.TRADE_TYPE_BATCH_PAY_NOPWD));
	        log.setTransactionId(tradePacket.getBody().getPay_transaction_id());
//	         log.setGmtCreated(new Date()); // 自动生成
	        log.setReqDateTime(new Date());
//	        log.setReqStatus(TradeConstants.ALIPAY_PAY_INFO_SUCCESS);
	        log.setReqText(xml);
	        tradeOutPaymentLogService.insertTradeOutPaymentLog(log);
	        return log;
	    }

	    protected void updatePaymentOutLog(TradeOutPaymentLogWithBLOBs log, BusTransactionRspPay rsp) {
	    	TradeOutPaymentLogWithBLOBs newLog = new TradeOutPaymentLogWithBLOBs();
	        newLog.setId(log.getId());
	        newLog.setResDateTime(new Date());
	        newLog.setReqCostTime(System.currentTimeMillis() - log.getReqDateTime().getTime()+"");
	        if(rsp != null){
	            String xml = rsp.marshal();
	            newLog.setResText(xml);
	            newLog.setReqStatus(TradeConstants.ALIPAY_PAY_INFO_SUCCESS);
	        }else{
	            newLog.setReqStatus(TradeConstants.ALIPAY_PAY_INFO_FAILURE);
	        }
	        tradeOutPaymentLogService.updateTradeOutPaymentLog(newLog);
	    }
	    
	    private String getReqNo(TradePacketReqSingleWithdrawPay tradePacket){
	    	return TradeUtilCommon.getServiceCode(tradePacket.getBusHead().getRequest_code())+idFactoryTradeOutPaymentLogNo.generate().toString();
	    }
}