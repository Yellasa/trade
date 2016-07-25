package com.liantuo.trade.bus.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.BizPaymentCenterService;
import com.liantuo.trade.bus.vo.WithdrawPayResultBizVo;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPayResultQuery;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.orm.pojo.TradeOutPaymentLog;
import com.liantuo.trade.orm.pojo.TradeOutPaymentLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeOutPaymentLogService;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import com.payment.client.pay.BusHead;
import com.payment.client.pay.BusTransaction;
import com.payment.client.pay.PaymentClient1;
import com.payment.client.pay.PaymentConstants;
import com.payment.client.pay.vo1.BusBodyReqPayBatch;
import com.payment.client.pay.vo1.BusTransactionReqPayBatchQuery;
import com.payment.client.pay.vo1.BusTransactionRspPayNotify;

@Component(value = "bizWithdrawPaymentQueryServiceImpl")
public class BizWithdrawPaymentQueryServiceImpl implements BizPaymentCenterService<TradePacketReqSingleWithdrawPayResultQuery, WithdrawPayResultBizVo> {

    private static final Log LOGGER = LogFactory.getLog(BizWithdrawPaymentQueryServiceImpl.class);

    @Resource(name = "idFactoryTradeOutPaymentLogNo")
    private StepSequenceFactoryForSpdb idFactoryTradeOutPaymentLogNo;
    
    @Resource
    private TradeOutPaymentLogService tradeOutPaymentLogService;
    
	@Override
	public BusTransaction paymentRequest(TradePacketReqSingleWithdrawPayResultQuery tradePacket, WithdrawPayResultBizVo trade) {
	    BusTransactionReqPayBatchQuery pay = new BusTransactionReqPayBatchQuery();
        BusHead head = initBusHead();
        head.setTrade_type(String.valueOf(PaymentConstants.TRADE_TYPE_BATCH_PAY_QUERY));
        head.setTransaction_id(trade.getTradeWithdraw().getPayTransactionId());
        BusBodyReqPayBatch body = new BusBodyReqPayBatch();
        body.setPayer_account(trade.getTradeWithdraw().getPayerAccount());
        body.setBatch_no(trade.getTradeWithdraw().getWithdrawBatchNo());
        
        pay.setBusBodyReqPayBatch(body);
        pay.setBusHead(head);
        
        TradeOutPaymentLog log = createQueryPaymentOutLog(tradePacket, trade, pay);
        BusTransactionRspPayNotify rsp = (BusTransactionRspPayNotify) PaymentClient1.payBatchQuery(pay);
        updateQueryPaymentOutLog(log, trade, rsp);
        
        trade.setPayNotify(rsp);
        return rsp;
	}
	
    private static BusHead initBusHead() {
        BusHead head = new BusHead();
        head.setPay_channel(String.valueOf(PaymentConstants.PAY_CHANNEL_ALIPAY));
        head.setRequest_time(DateUtil.toString(new Date(), "yyyyMMddHHmmss"));
        head.setRequester(String.valueOf(PaymentConstants.BIZ_TYPE_B2B));
        head.setPartner_code("liantuo");
        head.setVersion("1");
        return head;
    }
    
    protected TradeOutPaymentLog createQueryPaymentOutLog(TradePacketReqSingleWithdrawPayResultQuery tradePacket, WithdrawPayResultBizVo trade, BusTransactionReqPayBatchQuery pay) {
        String xml = pay.marshal();
        LOGGER.info("支付中心请求参数：" + xml);
        
        TradeOutPaymentLogWithBLOBs log = new TradeOutPaymentLogWithBLOBs();
        // 交易请求编号
        log.setReqNo(TradeUtilCommon.getServiceCode(tradePacket.getBusHead().getRequest_code())+idFactoryTradeOutPaymentLogNo.generate().toString());
        // 支付中心渠道编号
        log.setPayChannel(TradeConstants.WITHDRAW_ALIPAY_REQUESTER);
        // 支付中心接口编号
        log.setTradeType(TradeConstants.WITHDRAW_ALIPAY_BATCH_QUERY);
        // 支付中心接口版本号 
        log.setPaymentVersion("1");
        // 支付中心第三方身份编号
        log.setTransactionId(trade.getTradeWithdraw().getPayTransactionId());
        // 交易编号
        log.setTradeNo(trade.getTradeWithdraw().getTradeNo());
        // 请求日期时间
        log.setReqDateTime(new Date());
        // 请求报文
        log.setReqText(xml);
        // 记录创建日期  --  数据库生成
        log.setGmtCreated(new Date());
        
        tradeOutPaymentLogService.insertTradeOutPaymentLog(log);
        return log;
    }

    protected void updateQueryPaymentOutLog(TradeOutPaymentLog log, WithdrawPayResultBizVo trade, BusTransactionRspPayNotify rsp) {
        TradeOutPaymentLogWithBLOBs newLog = new TradeOutPaymentLogWithBLOBs();
        newLog.setId(log.getId());
        // 响应日期时间
        newLog.setResDateTime(new Date());
        // 请求耗时
        newLog.setReqCostTime(Long.toString(System.currentTimeMillis() - log.getReqDateTime().getTime()));
        // 响应报文
        if(rsp != null){
            String xml = rsp.marshal();
            LOGGER.info("支付中心返回参数：" + xml);
            newLog.setResText(xml);
            newLog.setReqStatus(TradeConstants.ALIPAY_PAY_INFO_SUCCESS);
        }else{
            newLog.setReqStatus(TradeConstants.ALIPAY_PAY_INFO_FAILURE);
        }
        
        tradeOutPaymentLogService.updateTradeOutPaymentLog(newLog);
    }
    
}
