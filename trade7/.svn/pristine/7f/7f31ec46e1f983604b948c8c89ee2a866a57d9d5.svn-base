package com.liantuo.trade.bus.template.impl.v1_1.notify;

import com.liantuo.payment.client.pay.PaymentNotify;
import com.liantuo.trade.bus.process.TradeOnlinePaymentAsyNotifyInterface;
import com.liantuo.trade.bus.process.TradeState;
import com.liantuo.trade.bus.template.AbstractTradeNotifyTemplate;
import com.liantuo.trade.client.trade.packet.body.TradeNotifyRequestPacket;
import com.liantuo.trade.common.annotation.Template;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeNotifyPaymentLogWithBLOBs;
import com.liantuo.trade.orm.pojo.TradeOutFrontLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeNotifyPaymentLogService;
import com.liantuo.trade.orm.service.TradeOutFrontLogService;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;

@Template
public class ATradeNotifyOnlinePaymentAsyTemp
        extends AbstractTradeNotifyTemplate<TradeOnlinePaymentAsyNotifyInterface> {
    @Resource(name = "tradeNotifyPaymentLogServiceImpl")
    private TradeNotifyPaymentLogService tradeNotifyPaymentLogServiceImpl;
    @Resource(name = "tradeOutFrontLogServiceImpl")
    private TradeOutFrontLogService tradeOutFrontLogServiceImpl;
    @Resource(name = "idFactoryTradeOutFrontLogNo")
    private StepSequenceFactoryForSpdb idFactoryTradeOutFrontLogNo;
    private final Logger logger = LoggerFactory.getLogger(ATradeNotifyOnlinePaymentAsyTemp.class);

    protected TradeNotifyPaymentLogWithBLOBs tradeLog;
    private TradeOutFrontLogWithBLOBs tradeoutFrontLog;

    public void execute(PaymentNotify notify) throws Exception {
        process.setRequestDetail(notify, getIp());
        // 执行日志插入：允许失败
        try {
            tradeLog = tradeNotifyPaymentLogServiceImpl.insertTradeNotifyPaymentLog(process.getTradeRequest(), process.getServiceName());//插入支付中心异步通知给交易中心的日志log
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入请求日志异常", e);
        }
        process.setReqNo(tradeLog.getReqNo());
        // 执行验证
        Date startTime = new Date();
        try {
            process.validate(process.getTradeRequest());//验证处理(格式，业务)，并将解析后的实体类进行赋值以便下一步处理
        } catch (BusinessException e) {
            e.printStackTrace();
            try {
                tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), startTime);//部分更新支付中心异步通知交易中心的日志log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
            return;
        }
        TradeState state = process.getTradePaymentStatus();
        //付款成功
        switch (state) {
            case SUCCESS:
                try {
                    process.transactionReceipt(process.getTradeRequest());//执行第一步事务(收款成功)
                } catch (BusinessException e) {
                    e.printStackTrace();
                    try {
                        tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), startTime);//部分更新支付中心异步通知交易中心的日志log
                    } catch (Exception e0) {
                        e0.printStackTrace();
                    }
                    return;
                } catch (Exception e) {
                    try {
                        tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, TradeConstants.TRAED_SYSTEM_ERROR, startTime);//部分更新支付中心异步通知交易中心的日志log
                    } catch (Exception e0) {
                        e0.printStackTrace();
                    }
                    return;
                }
                try {
                    process.transactionEntry(process.getTradeRequest());//执行第二步事务(入账成功)
                    //组织成功报文用于后续向前置发送通知
                    process.getNotifyFrontDetailsInfo(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS, "", "", TradeConstants.TRADE_APLIPAY_ONLINE_RECHARGE_ASY_NOTIFY);
                } catch (BusinessException e) {
                    //组织失败报文用于后续向前置发送通知
                    process.getNotifyFrontDetailsInfo(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), e.getErrorMessage(), TradeConstants.TRADE_APLIPAY_ONLINE_RECHARGE_ASY_NOTIFY);
                    break;
                } catch (Exception e) {
                    //组织失败报文用于后续向前置发送通知
                    process.getNotifyFrontDetailsInfo(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, TradeConstants.TRAED_SYSTEM_ERROR, e.getMessage(), TradeConstants.TRADE_APLIPAY_ONLINE_RECHARGE_ASY_NOTIFY);
                }
                break;
            case FAILURE:
                try {
                    process.transactionFailure(process.getTradeRequest());//执行第一步事务(收款失败)
                    //组织失败报文用于后续向前置发送通知
                    process.getNotifyFrontDetailsInfo(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE,
                            process.getAliPaymentAsyNotifyDetail().getReason(),
                            process.getAliPaymentAsyNotifyDetail().getReason_commont(),
                            TradeConstants.TRADE_APLIPAY_ONLINE_RECHARGE_ASY_NOTIFY);

                } catch (BusinessException e) {
                    try {
                        tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), startTime);//部分更新支付中心异步通知交易中心的日志log
                    } catch (Exception e0) {
                        e0.printStackTrace();
                    }
                    return;
                } catch (Exception e) {
                    try {
                        tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, TradeConstants.TRAED_SYSTEM_ERROR, startTime);//部分更新支付中心异步通知交易中心的日志log
                    } catch (Exception e0) {
                        e0.printStackTrace();
                    }
                    return;
                }
                break;
        }

        //新增交易发送通知到前置的日志记录
        Date startLogTime = new Date();
        try {
            tradeOutFrontLogServiceImpl.insertTradeOutFrontLog(prepareInsertTradeOutFrontLog(process.getTradeRequest(), ObjectXmlUtil.marshal(process.getNotice()), startLogTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // 用前面组织好的报文通过MQ向前置发送通知 发送完成之后，写日志
            logger.info("在线充值--支付中心异步通知交易中心交易结果--开始发送mq异步消息");
            process.notifyFrontPaymentResult(process.getNotice());
        } catch (Exception e1) {
            logger.info("在线充值--支付中心异步通知交易中心交易结果---异步通知前置失败");
            try {
                tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS, TradeConstants.TRAED_SYSTEM_ERROR, startTime);// 部分更新支付中心异步通知交易中心的日志log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
        }
        try {
            logger.info("在线充值--支付中心异步通知交易中心交易结果--异步通知前置成功");
            tradeOutFrontLogServiceImpl.updateTradeOutFrontLog(prepareUpdateTradeOutFrontLog(startLogTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TradeOutFrontLogWithBLOBs prepareInsertTradeOutFrontLog(TradeNotifyRequestPacket tradeReq, String reqXml, Date startLogTime) {
        TradeOutFrontLogWithBLOBs log = new TradeOutFrontLogWithBLOBs();
        // 交易请求编号
        log.setReqNo(TradeUtilCommon.getServiceCode(process.getServiceName()) + idFactoryTradeOutFrontLogNo.generate().toString());
        // 核心商户编号
        log.setCoreMerchantNo(tradeReq.getCore_merchant_no());
        //前置接口编码
        log.setServiceName(TradeConstants.TRADE_SINGLE_NOTIFY_PAY_RESULT_CALL_BACK);
        // 交易编号
        log.setTradeNo(tradeReq.getTrade_no());
        // 请求日期时间
        log.setReqDateTime(startLogTime);
        // 请求报文
        log.setReqText(reqXml);
        // 记录创建日期
        log.setGmtCreated(startLogTime);
        this.tradeoutFrontLog = log;
        return log;
    }

    public TradeOutFrontLogWithBLOBs prepareUpdateTradeOutFrontLog(Date startLogTime) {
        TradeOutFrontLogWithBLOBs log = new TradeOutFrontLogWithBLOBs();
        log.setId(tradeoutFrontLog.getId());
        Date end = new Date();
        // 响应日期时间
        log.setResDateTime(end);
        // 请求耗时
        log.setReqCostTime(Long.toString(end.getTime() - startLogTime.getTime()));
        // 响应报文
        log.setResText(TradeConstants.NOTIFY_RESPONSE_SUCCESS_TEXT);
        // 通信状态
        log.setReqStatus(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        return log;
    }


}
