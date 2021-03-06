package com.liantuo.trade.bus.template.impl.v1_1.mod;

import com.liantuo.trade.bus.process.TradeModSingleTxHasPaymentInterface;
import com.liantuo.trade.bus.template.AbstractTradeTemplate;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.TradeResponse;
import com.liantuo.trade.client.trade.packet.body.TradeResponseBody;
import com.liantuo.trade.common.annotation.Template;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeReqLogWithBLOBs;
import com.liantuo.trade.orm.service.TradeReqLogService;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 交易变更.有清算.单事务
 */
@Template
public class ATradeModSingleTxHasPaymentTemp extends AbstractTradeTemplate<TradeModSingleTxHasPaymentInterface> {

    @Resource(name = "tradeReqLogServiceImpl")
    private TradeReqLogService tradeReqLogServiceImpl;
    @Resource(name = "idFactoryTradeReqLogReqNo")
    private StepSequenceFactoryForSpdb idFactory;

    private final Logger logger = LoggerFactory.getLogger(ATradeModSingleTxHasPaymentTemp.class);
    protected TradeReqLogWithBLOBs tradeLog;

    @Override
    public TradeResponse execute(TradeRequest<?> request) throws Exception {
        //数据准备
        TradeResponseBody responseBody = new TradeResponseBody();
        response.setBody(responseBody);
        Date startTime = new Date();

        // 第零步，允许失败，需要返回系统错误
        try {
            tradeLog = tradeReqLogServiceImpl.insertTradeRequestLog(request, ip, requestXML);//插入请求log
        } catch (Exception e) {
            logger.error("插入请求日志异常", e);
            response = buildSystemExceptionResponse(e);
            return response;
        }
        process.setReqNo(tradeLog.getReqNo());
        // 第一步验证
        try {
            process.formatValidate(request);// 格式验证处理
            process.bizValidate(request);// 业务验证处理
        } catch (BusinessException e) {
            response = buildSystemExceptionResponse(e);

            try {
                tradeReqLogServiceImpl.updateTradeReqLogById(tradeLog.getId(), requestXML, response, startTime);//部分更新请求log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
            return response;
        }

        // 第二步
        try {
            process.transaction(request);// 事务处理
            responseBody.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
            responseBody.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
            responseBody.setTrade_details(ObjectJsonUtil.object2String(process.getTradeDetails()));
        } catch (BusinessException e) {
            try {
                process.createTradeFailRecode(request);
            } catch (Exception e0) {
                response = buildSystemExceptionResponse(e0);
                return response;
            }

            response = buildSystemExceptionResponse(e);
            response.getBody().setTrade_details(ObjectJsonUtil.object2String(process.getTradeDetails()));

            try {
                tradeReqLogServiceImpl.updateTradeReqLogById(tradeLog.getId(), requestXML, response, startTime);//部分更新请求log
            } catch (Exception e0) {
                e0.printStackTrace();
            }
            return response;
        }

        // 第三步，允许失败，但不影响业务，正常返回
        try {
            tradeReqLogServiceImpl.updateTradeReqLogById(tradeLog.getId(), requestXML, response, startTime);//部分更新请求log
        } catch (Exception e) {
            logger.error("更新请求日志异常", e);
        }

        return response;
    }
}