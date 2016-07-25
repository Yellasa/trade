package com.liantuo.trade.bus.process.impl.withdraw;

import com.liantuo.trade.bus.service.impl.WithdrawNotifyLegderService;
import com.liantuo.trade.bus.service.impl.WithdrawNotifyTradeService;
import com.liantuo.trade.bus.template.impl.ANotifyWithdrawTemp;
import com.liantuo.trade.bus.vo.WithdrawNotifyBizVo;
import com.liantuo.trade.bus.vo.WithdrawNotifyPayInfoVo;
import com.liantuo.trade.client.trade.packet.body.withdraw.WithdrawNotifyReqBody;
import com.liantuo.trade.client.trade.packet.body.withdraw.WithdrawNotifyRspBody;
import com.liantuo.trade.client.trade.packet.req.withdraw.WithdrawNotifyReqPacket;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.WithdrawNotifyRspPacket;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.pojo.TradeOutFrontLogWithBLOBs;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawErrorinfo;
import com.liantuo.trade.orm.pojo.TradeWithdrawLog;
import com.liantuo.trade.orm.service.TradeWithdrawLogService;
import com.liantuo.trade.orm.service.TradeWithdrawService;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 提现通知
 */
@Component(value = "withdrawNotifyProcess")
public class WithdrawNotifyProcess extends ANotifyWithdrawTemp<WithdrawNotifyReqPacket, WithdrawNotifyRspPacket, WithdrawNotifyBizVo>{
	private final Logger logger = LoggerFactory.getLogger(WithdrawNotifyProcess.class);
	
    @Resource
    private WithdrawNotifyLegderService withdrawNotifyLegderService;
    
    @Resource
    private WithdrawNotifyTradeService withdrawNotifyTradeService;

    @Resource
    private TradeWithdrawLogService tradeWithdrawLogService;
    
    @Resource
    private TradeWithdrawService tradeWithdrawService;
    
    @Resource(name = "idFactoryTradeOutFrontLogNo")
    private StepSequenceFactoryForSpdb idFactoryTradeOutFrontLogNo;

    /**
     * 格式校验与报文解封
     * @param notifyPacke
     * @return
     */
    @Override
    protected WithdrawNotifyBizVo assembleRequest(WithdrawNotifyReqPacket notifyPacke) {
    	logger.info("成员提现---> 支付中心异步通知结果如下：{}", notifyPacke.marshal());

        String alipayBatchWithdrawFieldPayInfo = notifyPacke.getBody().getPay_info();
        
        String[] fiedPayInfoArr = alipayBatchWithdrawFieldPayInfo.split("\\|");
        /**约定：单笔提现只有一条结果记录*/
        String[] infos = fiedPayInfoArr[0].split("\\^");
        WithdrawNotifyBizVo bizVo = new WithdrawNotifyBizVo();
        WithdrawNotifyPayInfoVo payInfo;
        if(infos.length == 8){
            payInfo = new WithdrawNotifyPayInfoVo();
            payInfo.setSerialNum(infos[0]);                 //提现单号
            payInfo.setReceiveAccount(infos[1]);            //提现收款账户
            payInfo.setReceiverName(infos[2]);              //收款账户名
            payInfo.setAmount(infos[3]);                    //转账金额
            payInfo.setResultCode(infos[4]);                //结果码
            payInfo.setErrorCode(infos[5]);                 //错误码
            payInfo.setAlipayTradeNo(infos[6]);             //支付宝流水号
            payInfo.setCompleteTime(infos[7]);              //完成时间
            bizVo.setPayInfo(payInfo);
        }else {
            logger.error("格式校验与报文解封失败，{}", alipayBatchWithdrawFieldPayInfo);
        }
        
        return bizVo;
    }

    /**
     * 原交易查询
     * @param reqPacket
     * @param bizVo
     * @return
     */
    @Override
    protected WithdrawNotifyBizVo queryOriginalTrade(WithdrawNotifyReqPacket reqPacket, WithdrawNotifyBizVo bizVo) {
        TradeWithdraw result = withdrawNotifyTradeService.queryOriginalTrade(reqPacket);
        logger.info("提现原交易trade_no：{} 查询原交易记录：{}", result.getTradeNo(), result.toString());

        /**原交易查询后放入交易VO，供整个交易上下文使用*/
        bizVo.setTrade(result);
        return bizVo;
    }

    /**
     * 业务校验
     * @param reqPacket
     * @param bizVo
     * @return
     * @throws BizRuntimeException
     */
    @Override
    protected WithdrawNotifyRspPacket validateBizData(WithdrawNotifyReqPacket reqPacket, WithdrawNotifyBizVo bizVo) throws BizRuntimeException {
        TradeWithdraw originalTrade = bizVo.getTrade();

        logger.info("支付中心提现返回trade_no:{}支付中心返回交易数据：{}", reqPacket.getBusHead().getTrade_no(), originalTrade.toString());

        WithdrawNotifyReqBody body = reqPacket.getBody();
        WithdrawNotifyPayInfoVo payInfo = (WithdrawNotifyPayInfoVo) bizVo.getPayInfo();
        
        if(StringUtils.isEmpty(originalTrade.getNotifyUrl())){
            // 校验【异步通知地址】是否为空
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.notify.url.empty"), this.getInternalFailureMessage("withdraw.notify.url.empty"));
        }
        if(!originalTrade.getWithdrawBatchNo().equals(body.getOut_batch_no())){
            // 提交第三方批次号不一致
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.thired.batch.no"), this.getInternalFailureMessage("withdraw.thired.batch.no"));
        }
        if(!originalTrade.getPayTransactionId().equals(reqPacket.getBusHead().getTransaction_id())){
            // 交易编号与出款渠道身份编号不对应  withdraw.channel.identity
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.channel.identity"), this.getInternalFailureMessage("withdraw.channel.identity"));
        }
        if(!originalTrade.getWithdrawSerialNumber().equals(payInfo.getSerialNum())){
            // 提交第三方批次流水号不一致
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.thired.serial.no"), this.getInternalFailureMessage("withdraw.thired.serial.no"));
        }
        if(!originalTrade.getWithdrawThirdAccount().equals(payInfo.getReceiveAccount())){
            // 提现第三方账户不一致
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.thired.account"), this.getInternalFailureMessage("withdraw.thired.account"));
        }
        if(!originalTrade.getWithdrawThirdAccountName().equals(payInfo.getReceiverName())){
            // 提现第三方账户姓名不一致
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.thired.account.name"), this.getInternalFailureMessage("withdraw.thired.account.name"));
        }
        if(!originalTrade.getWithdrawAmount().equals(AmountUtils.bizAmountConvertToLong(payInfo.getAmount()))){
            // 提现金额不一致
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.amount"), this.getInternalFailureMessage("withdraw.amount"));
        }
        if(!alipaySerialNumCheck(payInfo.getAlipayTradeNo(), originalTrade.getFundPoolNo(), originalTrade.getCoreMerchantNo())){
            // 支付宝内部流水号不唯一  
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.alipay.serial.no"), this.getInternalFailureMessage("withdraw.alipay.serial.no"));
        }
        if(!originalTrade.getStatus().equals(TradeConstants.TRADE_WITHDRAW_PAYING)){
            // 原交易状态不正确
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.original.originalTrade.status"), this.getInternalFailureMessage("withdraw.original.originalTrade.status"));
        }
        if(!TradeConstants.WITHDRAW_REQUEST_GROUP.equals(originalTrade.getRequestGroup())){
            // 请求组别错误  withdraw.req.group
            return buildRsp(bizVo, this.getInternalFailureCode("withdraw.req.group"), this.getInternalFailureMessage("withdraw.req.group"));
        }
        
        if(!TradeConstants.PAYMENTCENTER_RETURN_SUCCESS.equals(body.getRet_code())){
            // ret_code为-1时交易状态为【出款处理中】,返回【失败】，异常原因【支付中心处理异常】
            return buildRsp(bizVo, getInternalFailureCode("withdraw.paymentcenter.exception"), getInternalFailureMessage("withdraw.paymentcenter.exception"));
        }else if(!TradeConstants.ALIPAY_PAY_INFO_SUCCESS.equals(payInfo.getResultCode()) 
                && !TradeConstants.ALIPAY_PAY_INFO_FAILURE.equals(payInfo.getResultCode()) ){
            // ret_code为0， 但 payinfo中非S也非F时
            return buildRsp(bizVo, getInternalFailureCode("withdraw.paymentcenter.exception"), getInternalFailureMessage("withdraw.paymentcenter.exception"));
        }
        
        return null;
    }
    
    /**
     * 根据第三方错误码构建返回packet
     * @param bizVo
     * @return
     */
    protected WithdrawNotifyRspPacket paymentCenterError(WithdrawNotifyBizVo bizVo, String msgCode){
        WithdrawNotifyPayInfoVo payInfo = (WithdrawNotifyPayInfoVo) bizVo.getPayInfo();
        TradeWithdrawErrorinfo error = getErrorInfo(payInfo.getErrorCode());
        if(error != null){
            return buildRsp(bizVo, error.getErrorCode(), error.getErrorDesc());
        }
        return buildRsp(bizVo, payInfo.getErrorCode(), this.getInternalFailureMessage(msgCode));
    }

    private boolean alipaySerialNumCheck(String serialNum, String fundPoolNo, String coreMerchantNo){
        List<TradeWithdraw> list = tradeWithdrawService.queryByPayThirdTradeNo(serialNum, fundPoolNo, coreMerchantNo);
        return CollectionUtils.isEmpty(list);
    }
    
    @Override
    protected void addTradeHistoryLog(WithdrawNotifyBizVo bizVo) {
        TradeWithdrawLog log = new TradeWithdrawLog();
        BeanUtils.copyProperties(bizVo.getTrade(), log);
        log.setId(null);
        tradeWithdrawLogService.insertTradeWithdrawLog(log);
    }
    
    protected WithdrawNotifyRspPacket buildRsp(WithdrawNotifyBizVo trade, String code, String message){
        WithdrawNotifyRspPacket rsp = new WithdrawNotifyRspPacket();
        WithdrawNotifyRspBody body = new WithdrawNotifyRspBody();
        
        body.setTrade_code(TradeConstants.TRADE_WITHDRAW_NOTIFY);
        
        if(trade != null && trade.getTrade() != null){
            // 设置前置通知URL
            body.setNotify_url(trade.getTrade().getNotifyUrl());
            body.setCore_merchant_no(trade.getTrade().getCoreMerchantNo());
            body.setPartner_id(trade.getTrade().getPartnerId());
            body.setFund_pool_no(trade.getTrade().getFundPoolNo());
            
            String tradeDetails;
            try {
                tradeDetails = ObjectJsonUtil.object2String(trade.getTrade());
                body.setTrade_details(tradeDetails);
            } catch (Exception e) {
               this.logger(trade.getReqContext(), "", "", e);
            }
        }
        
        if (TradeConstants.TRADE_SUCCESS.equals(code)) {
            body.setResult_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        } else {
            body.setResult_code(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            body.setErr_code(code);
            body.setErr_code_des(message);
        }
        
        rsp.setBody(body);
        return rsp;
    }
    
    @Override
    public WithdrawNotifyLegderService getNotifyLegderService() {
        return withdrawNotifyLegderService;
    }

    @Override
    public WithdrawNotifyTradeService getNotifyTradeService() {
        return withdrawNotifyTradeService;
    }

    /**
     * 创建通知前置的日志信息
     */
    @Override
    protected TradeOutFrontLogWithBLOBs createNotifyOutLog(WithdrawNotifyReqPacket notifyPacket, WithdrawNotifyRspPacket rsp, WithdrawNotifyBizVo bizVo) {
        TradeWithdraw trade = bizVo.getTrade();
        TradeOutFrontLogWithBLOBs log = new TradeOutFrontLogWithBLOBs();
        // 交易请求编号
        log.setReqNo(TradeUtilCommon.getServiceCode(bizVo.getReqContext().getReq().getServiceName())+idFactoryTradeOutFrontLogNo.generate().toString());
        // 核心商户编号
        log.setCoreMerchantNo(trade.getCoreMerchantNo());
        // 前置接口编码
        log.setServiceName(TradeConstants.TRADE_SINGLE_WITHDRAW_PAY_RESULT_CALL_BACK);
        // 交易编号
        log.setTradeNo(notifyPacket.getBusHead().getTrade_no());
        Date start = new Date();
        // 请求日期时间
        log.setReqDateTime(start);
        // 请求报文
        log.setReqText(rsp.marshal());
        // 记录创建日期
        log.setGmtCreated(start);
        
        return log;
    }

    /**
     * 更新通知前置的日志信息
     */
    @Override
    protected TradeOutFrontLogWithBLOBs updateNotifyOutLogById(Long logId, Date start, WithdrawNotifyRspPacket rsp, WithdrawNotifyBizVo bizVo) {
        TradeOutFrontLogWithBLOBs log = new TradeOutFrontLogWithBLOBs();
        log.setId(logId);
        Date end = new Date();
        // 响应日期时间
        log.setResDateTime(end);
        // 请求耗时
        log.setReqCostTime(Long.toString(end.getTime() - start.getTime()));
        // 响应报文
        log.setResText(TradeConstants.NOTIFY_RESPONSE_SUCCESS_TEXT);
        // 通信状态
        log.setReqStatus(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        
        return log;
    }


    /**
     * 根据错误码查询错误信息
     * @param errorCode
     * @return
     */
    protected TradeWithdrawErrorinfo getErrorInfo(String errorCode){
        TradeWithdrawErrorinfo error = null;
        if(!StringUtils.isEmpty(errorCode)){
            List<TradeWithdrawErrorinfo> errors = getErrorinfoService().queryBy(TradeConstants.WITHDRAW_ALIPAY_REQUESTER, 
                    TradeConstants.WITHDRAW_ALIPAY_TRADE_TYPE, errorCode);
            if(!errors.isEmpty()){
                error = errors.get(0);
            }
        }
        return error;
    }
}
