package com.liantuo.trade.bus.template.impl.v1_1.notify;

import com.liantuo.payment.client.pay.PaymentNotify;
import com.liantuo.trade.bus.process.TradeOnlineAsynPaymentNotifyInterface;
import com.liantuo.trade.bus.process.TradeState;
import com.liantuo.trade.bus.template.AbstractTradeNotifyTemplate;
import com.liantuo.trade.client.trade.packet.NotifyPacketResultInfo;
import com.liantuo.trade.client.trade.packet.body.TradeNotifyRequestBody;
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
public class ATradeNotifyOnlineAsynPaymentTemp
        extends AbstractTradeNotifyTemplate<TradeOnlineAsynPaymentNotifyInterface> {
    private final Logger logger = LoggerFactory.getLogger(ATradeNotifyOnlineAsynPaymentTemp.class);

    @Resource(name = "tradeNotifyPaymentLogServiceImpl")
    private TradeNotifyPaymentLogService tradeNotifyPaymentLogServiceImpl;
    @Resource(name = "tradeOutFrontLogServiceImpl")
    private TradeOutFrontLogService tradeOutFrontLogServiceImpl;
    @Resource(name = "idFactoryTradeOutFrontLogNo")
    private StepSequenceFactoryForSpdb idFactoryTradeOutFrontLogNo;
    protected TradeNotifyPaymentLogWithBLOBs tradeLog;

    private TradeOutFrontLogWithBLOBs tradeoutFrontLog;


    @SuppressWarnings("unchecked")
    @Override
    public void execute(PaymentNotify notify) throws Exception {
        //记录支付中心返回结果
        TradeNotifyRequestBody tradeNotifyRequestBody = null;
        //记录通知前置系统数据信息
        NotifyPacketResultInfo trade2FrontNotify = null;
        try {
            // 1.记录异步通知请求的数据
            tradeNotifyRequestBody = process.setRequestDetail(notify, getIp());
            String serviceName = process.getServiceName();
            tradeLog = tradeNotifyPaymentLogServiceImpl.insertTradeNotifyPaymentLog(tradeNotifyRequestBody.getNotifyRequestHead(), serviceName);// 插入支付中心异步通知给交易中心的日志log
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入请求日志异常", e);
        }
        process.setReqNo(tradeLog.getReqNo());
        // 2.根据空白台账解析是否找到对应的渠道流程信息
        Date startTime = new Date();
        try {
            process.validateClearChannel(notify);
        } catch (BusinessException e) {
            e.printStackTrace();
            try {
                tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), startTime);// 部分更新支付中心异步通知交易中心的日志log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
            return;
        }
        // 3.根据渠道编号解析对应的渠道接收对象
        try {
            process.parsePaymentNotify(notify, tradeNotifyRequestBody);
        } catch (BusinessException e) {
            e.printStackTrace();
            try {
                tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), startTime);// 部分更新支付中心异步通知交易中心的日志log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
            return;
        }
        // 4.入口校验第三发数据
        try {
            process.validateThirdData(tradeNotifyRequestBody);// 验证处理(格式，业务)，并将解析后的实体类进行赋值以便下一步处理
        } catch (BusinessException e) {
            e.printStackTrace();
            try {
                tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), startTime);// 部分更新支付中心异步通知交易中心的日志log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
            return;
        }
        // 5.判断支付状态
        TradeState state = process.getTradePaymentStatus(tradeNotifyRequestBody);
        switch (state) {
            case SUCCESS:// 5-1如果支付成功
                try {
                    //准备生效的外部台账数据
                    process.prepareEffectLedger(tradeNotifyRequestBody);
                    // 交易入口校验
                    process.validateTradeDate(tradeNotifyRequestBody);
                    // 5-1-1第一个等待入账的事物
                    process.transactionReceipt(tradeNotifyRequestBody);
                } catch (BusinessException e) {
                    e.printStackTrace();
                    try {
                        tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), startTime);// 部分更新支付中心异步通知交易中心的日志log
                    } catch (Exception e0) {
                        e0.printStackTrace();
                    }
                    return;
                } catch (Exception e) {
                    try {
                        tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, TradeConstants.TRAED_SYSTEM_ERROR, startTime);// 部分更新支付中心异步通知交易中心的日志log
                    } catch (Exception e0) {
                        e0.printStackTrace();
                    }
                    return;
                }
                try {
                    // // 执行第二步事务(账务处理)
                    process.transactionEntry(tradeNotifyRequestBody);
                    // 组织成功报文用于后续向前置发送通知
                    trade2FrontNotify = process.getNotifyFrontDetailsInfo(tradeNotifyRequestBody, TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS, "", "");
                } catch (BusinessException e) {
                    // 组织失败报文用于后续向前置发送通知
                    trade2FrontNotify = process.getNotifyFrontDetailsInfo(tradeNotifyRequestBody, TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), e.getErrorMessage());
                    break;
                } catch (Exception e) {
                    // 组织失败报文用于后续向前置发送通知
                    trade2FrontNotify = process.getNotifyFrontDetailsInfo(tradeNotifyRequestBody, TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, TradeConstants.TRAED_SYSTEM_ERROR, e.getMessage());
                }
                break;
            case FAILURE:
                try {
                    //准备失效的外部台账数据
                    process.prepareFailureLedger(tradeNotifyRequestBody);
                    // 支付失败处理
                    process.transactionFailure(tradeNotifyRequestBody);
                    // TODO 组织失败报文用于后续向前置发送通知 需要确认相关的错误吗和错误信息
                    trade2FrontNotify = process.getNotifyFrontDetailsInfo(tradeNotifyRequestBody, TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, process.getFailureMessage().getReason(), process.getFailureMessage().getReason_commont());
                } catch (BusinessException e) {
                    try {
                        tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, e.getErrorCode(), startTime);// 部分更新支付中心异步通知交易中心的日志log
                    } catch (Exception e0) {
                        e0.printStackTrace();
                    }
                    return;
                } catch (Exception e) {
                    try {
                        tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_FAILURE, TradeConstants.TRAED_SYSTEM_ERROR, startTime);// 部分更新支付中心异步通知交易中心的日志log
                    } catch (Exception e0) {
                        e0.printStackTrace();
                    }
                    return;
                }
                break;
            case UNKNOWN:
                try {
                    String unknownErrorCode = process.getUnknownErrorCode();
                    tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_UNKNOWN, unknownErrorCode, startTime);
                } catch (Exception e0) {
                    e0.printStackTrace();
                }
                return;
        }
        // 新增交易发送通知到前置的日志记录
        try {
            TradeOutFrontLogWithBLOBs logFront = prepareInsertTradeOutFrontLog(tradeNotifyRequestBody, trade2FrontNotify);
            tradeOutFrontLogServiceImpl.insertTradeOutFrontLog(logFront);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // 用前面组织好的报文通过MQ向前置发送通知 发送完成之后，写日志
            logger.info("支付中心异步通知交易中心交易结果--开始发送mq异步消息到前置");
            process.notifyFront(trade2FrontNotify);
        } catch (Exception e1) {
            logger.info("支付中心异步通知交易中心交易结果---异步通知前置失败");
            try {
                tradeNotifyPaymentLogServiceImpl.updateTradeNotifyPaymentLog(tradeLog.getId(), TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS, TradeConstants.TRAED_SYSTEM_ERROR, startTime);// 部分更新支付中心异步通知交易中心的日志log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
            return;
        }
        // 记录mq通知前置中心成功
        try {
            logger.info("支付中心异步通知交易中心交易结果--异步通知前置成功");
            TradeOutFrontLogWithBLOBs updateLogFront = prepareUpdateTradeOutFrontLog();
            tradeOutFrontLogServiceImpl.updateTradeOutFrontLog(updateLogFront);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TradeOutFrontLogWithBLOBs prepareInsertTradeOutFrontLog(TradeNotifyRequestBody tradeNotifyRequestBody, NotifyPacketResultInfo trade2FrontNotify) throws Exception {
        Date startLogTime = new Date();
        TradeOutFrontLogWithBLOBs log = new TradeOutFrontLogWithBLOBs();
        // 交易请求编号
        log.setReqNo(TradeUtilCommon.getServiceCode(process.getServiceName()) + idFactoryTradeOutFrontLogNo.generate().toString());
        // 核心商户编号
        log.setCoreMerchantNo(tradeNotifyRequestBody.getNotifyRequestHead().getCore_merchant_no());
        // 前置接口编码
        log.setServiceName(process.getFrontServiceName());
        // 交易编号
        log.setTradeNo(tradeNotifyRequestBody.getNotifyRequestHead().getTrade_no());
        // 请求日期时间
        log.setReqDateTime(startLogTime);
        // 请求报文
        log.setReqText(ObjectXmlUtil.marshal(trade2FrontNotify));
        // 记录创建日期
        log.setGmtCreated(startLogTime);
        this.tradeoutFrontLog = log;
        return log;
    }

    public TradeOutFrontLogWithBLOBs prepareUpdateTradeOutFrontLog() {
        TradeOutFrontLogWithBLOBs log = new TradeOutFrontLogWithBLOBs();
        log.setId(tradeoutFrontLog.getId());
        Date end = new Date();
        // 响应日期时间
        log.setResDateTime(end);
        // 请求耗时
        log.setReqCostTime(Long.toString(end.getTime() - tradeoutFrontLog.getReqDateTime().getTime()));
        // 响应报文
        log.setResText(TradeConstants.NOTIFY_RESPONSE_SUCCESS_TEXT);
        // 通信状态
        log.setReqStatus(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        return log;
    }

}
