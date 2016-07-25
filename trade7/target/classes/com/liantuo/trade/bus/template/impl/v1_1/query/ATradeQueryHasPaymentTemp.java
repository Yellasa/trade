package com.liantuo.trade.bus.template.impl.v1_1.query;

import com.liantuo.payment.client.pay.PaymentResponse;
import com.liantuo.trade.bus.process.ATradeQueryHasPaymentInterface;
import com.liantuo.trade.bus.process.TradeState;
import com.liantuo.trade.bus.service.impl.TradeCallPaymentCenterLogServiceImpl;
import com.liantuo.trade.bus.template.AbstractTradeTemplate;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradeResponseBody;
import com.liantuo.trade.common.annotation.Template;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeOutPaymentLogWithBLOBs;
import com.liantuo.trade.orm.pojo.TradeReqLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeReqLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 查询类.交易状态
 */
@Template
public class ATradeQueryHasPaymentTemp extends AbstractTradeTemplate<ATradeQueryHasPaymentInterface> {

    @Resource(name = "tradeReqLogServiceImpl")
    private TradeReqLogService tradeReqLogServiceImpl;
    @Resource(name = "tradeCallPaymentCenterLogService")
    private TradeCallPaymentCenterLogServiceImpl outPayLogService;//交易请求支付日志服务

    private static final Logger logger = LoggerFactory.getLogger(ATradeQueryHasPaymentTemp.class);
    protected TradeReqLogWithBLOBs tradeLog;
    protected TradeOutPaymentLogWithBLOBs paymentLog;

    @Override
    public TradeResponse execute(TradeRequest<?> request) throws Exception {
        //数据准备
        TradeResponseBody responseBody = new TradeResponseBody();
        responseBody.setReturn_code(TradeConstants.TRADE_SUCCESS);
        responseBody.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        response.setBody(responseBody);
        Date startTime = new Date();
        TradeState state;

        boolean validateFlag;
        /**
         * 1、执行日志插入：允许失败，需要返回系统错误
         */
        try {
            tradeLog = tradeReqLogServiceImpl.insertTradeRequestLog(request, ip, requestXML);//插入请求log
        } catch (Exception e) {
            e.printStackTrace();
            response = buildSystemExceptionResponse(e);
            return response;
        }
        process.setReqNo(tradeLog.getReqNo());

        /**
         * 2、入口校验，并返回状态
         */
        try {
            validateFlag = process.validate(request);// true:需要调用支付中心  false:无需调用 直接返回
        } catch (BusinessException e) {
            response = buildSystemExceptionResponse(e);//验证异常已在此处处理，返回F
            try {
                tradeReqLogServiceImpl.updateTradeReqLogById(tradeLog.getId(), requestXML, response, startTime);//部分更新请求log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
            logger.info("--619返回--" + ObjectXmlUtil.marshal(response));
            return response;
        }

        /**
         * 3、状态改为两种值，判断是否需要调用支付中心，与验证方法合并
         */
        if (!validateFlag) {//如果支付状态返回false 直接组织返回
            responseBody.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
            responseBody.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
            responseBody.setTrade_details(ObjectJsonUtil.object2String(process.getTradeDetails()));
            try {
                tradeReqLogServiceImpl.updateTradeReqLogById(tradeLog.getId(), requestXML, response, startTime);//部分更新请求log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
            logger.info("--619返回--" + ObjectXmlUtil.marshal(response));
            return response;
        } else {
            String requestPaymentXML = process.createPaymentRequest();
            /*
             * 记录请求支付中心日志
			 */
            paymentLog = outPayLogService.createPaymentOutLog(request, requestPaymentXML);
            try {
                PaymentResponse response = process.requestPayment();
                //更新请求支付中心日志
                outPayLogService.updatePaymentOutLog(paymentLog, process.getResponseXml());
                //获取支付中心返回状态，进行后续处理
                state = process.parseObj(response);
            } catch (Exception e) {
                //未获取到支付中心返回结果，封装失败返回报文
                e.printStackTrace();
                logger.error(e.getMessage());
                response = buildSystemExceptionResponse(e);
                responseBody.setTrade_details(ObjectJsonUtil.object2String(process.getTradeDetails()));
                tradeReqLogServiceImpl.updateTradeReqLogById(tradeLog.getId(), requestXML, response, startTime);// 部分更新请求log
                logger.info("--619返回--" + ObjectXmlUtil.marshal(response));
                return response;
            }
            switch (state) {
                // 付款结果成功
                case SUCCESS:
                    try {
                    /*
					 * 收款成功
					 */
                        process.transactionReceipt(request);
                    } catch (Exception e) {
                        response = buildSystemExceptionResponse(e);
                        break;
                    }
                    try {
					/*
					 * 入账成功
					 */
                        process.transactionEntry(request);
                    } catch (Exception e) {
                        response = buildSystemExceptionResponse(e);
                        response.getBody().setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
                    }
                    break;
                // 付款结果失败
                case FAILURE:
                    try {
                        process.transactionFailure(request);
                    } catch (Exception e) {
                        response = buildSystemExceptionResponse(e);
                    }
                    break;
                //付款处理中
                case PROCESSING:
                    response.getBody().setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
                    break;
                //结果未知
                case UNKNOWN:
                    response.getBody().setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_UNKNOWN);
                    if (process.getException() != null) {
                        response.getBody().setErr_code(process.getException().getErrorCode());
                        response.getBody().setErr_code_des(process.getException().getErrorMessage());
                        response.getBody().setErr_code_des(process.getException().getErrorMessage());
                    }

                    break;
            }
        }
        /**
         * 4、更新log日志，封装返回
         */
        try {
            responseBody.setTrade_details(ObjectJsonUtil.object2String(process.getTradeDetails()));
            tradeReqLogServiceImpl.updateTradeReqLogById(tradeLog.getId(), requestXML, response, startTime);// 部分更新请求log
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("--619返回--" + ObjectXmlUtil.marshal(response));
        return response;
    }

}