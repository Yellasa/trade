package com.liantuo.trade.bus.process.impl.withdraw;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.liantuo.trade.bus.template.impl.ATradePayResultQueryTemp;
import com.liantuo.trade.bus.vo.WithdrawNotifyPayInfoVo;
import com.liantuo.trade.bus.vo.WithdrawPayResultBizVo;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawPayResultQuery;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPayResultQuery;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.TradePacketRspSingleWithdrawPayResultQuery;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.ValidationUtil;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.orm.pojo.TradeWithdrawErrorinfo;
import com.liantuo.trade.orm.service.TradeLedgerService;
import com.liantuo.trade.orm.service.TradeWithdrawErrorinfoService;
import com.payment.client.pay.vo1.BusTransactionRspPayNotify;


/**
 * 0002-001-004 成员提现到支付宝-查询出款结果
 */
@Component(value = "withdrawPayResultQueryProcess")
public class WithdrawPayResultQueryProcess extends ATradePayResultQueryTemp<
        TradePacketReqSingleWithdrawPayResultQuery,TradePacketRspSingleWithdrawPayResultQuery, WithdrawPayResultBizVo>{

    @Resource
    private TradeLedgerService tradeLedgerService;
    @Resource
    private TradeWithdrawErrorinfoService errorinfoService;
    
    
    private final Log LOGGER = LogFactory.getLog(WithdrawPayResultQueryProcess.class);

    /**
     * 查询原交易
     */
    @Override
    protected WithdrawPayResultBizVo queryOriginalTrade(TradePacketReqSingleWithdrawPayResultQuery tradePacket) {
        WithdrawPayResultBizVo trade = (WithdrawPayResultBizVo) this.getTradeService().queryOriginalTrade(tradePacket);
        // 原交易不存在
        if(trade == null || trade.getTradeWithdraw() == null){
            return null;
        }
        return trade;
    }
    
    /**
     * 业务数据校验
     */
    @Override
    protected void bizValidate(TradePacketReqSingleWithdrawPayResultQuery tradePacket, WithdrawPayResultBizVo trade) throws BizException {
        // 校验组别
        if(!TradeConstants.TRADE_GROUP_WITHDRAW_ALIPAY.equals(trade.getTradeWithdraw().getRequestGroup())){
            throw buildBusinessException("withdraw.req.group", BizException.class);
        }
    }
    
    /**
     * 交易系统  查询结果 处理， 如果还需要查询支付中心，则返回null
     */
    @Override
    protected TradePacketRspSingleWithdrawPayResultQuery processTradeQueryResult(TradePacketReqSingleWithdrawPayResultQuery tradePacket, WithdrawPayResultBizVo trade) {
        // 出款处理中
        if(TradeConstants.TRADE_WITHDRAW_PAYING.equals(trade.getTradeWithdraw().getStatus())){
            return null;
        }else if(TradeConstants.TRADE_WITHDRAW_PAY_SUCCESS.equals(trade.getTradeWithdraw().getStatus())){
            // 出款成功
            return buildRsp(trade, getInternalFailureCode("trade.success"), getInternalFailureMessage("trade.success"));
        }
        // 不是 “出款处理中” 状态
        return buildRsp(trade, getInternalFailureCode("withdraw.status.error"), getInternalFailureMessage("withdraw.status.error"));
    }

    /**
     * 报文格式校验
     */
    private String validateNotifyData(BusTransactionRspPayNotify notify){
        String validMsg = ValidationUtil.validateRequired(notify.getBusHead());
        if (StringUtils.isEmpty(validMsg)) {
          //交易协议参数格式校验
            validMsg = ValidationUtil.validateFormat(notify.getBusHead());
        }
        return validMsg;
    }
    
    /**
     * 支付中心查询结果数据校验 
     */
    @Override
    protected TradePacketRspSingleWithdrawPayResultQuery validatePaymentcenterQueryResultData(TradePacketReqSingleWithdrawPayResultQuery tradePacket, WithdrawPayResultBizVo trade) {
        TradeWithdraw withdrawTrade = trade.getTradeWithdraw();
        // 校验输入格式是否符合要求，若校验失败返回【失败】    异常原因【xxxx格式校验未通过】
        BusTransactionRspPayNotify notify = trade.getPayNotify();
        
        // 头信息参数校验
        String msg = validateNotifyData(notify);
        if(!StringUtils.isEmpty(msg)){
            return this.buildRsp(trade, getInternalFailureCode("trade.validate.failure"), getInternalFailureMessage("trade.validate.failure", new Object[]{msg}));
        }
        // 查询失败
        /** 查询结果为  -2、-3、-4 时，没有查询结果，不需要验证结果信息  */
        if(TradeConstants.ALIPAY_RET_CODE_FAILED.equals(notify.getBusBodyRspPay().getRet_code())){
            // 支付中心请求支付宝失败
            return this.buildRsp(trade, getInternalFailureCode("withdraw.alipay.req.failed"), 
                    getInternalFailureMessage("withdraw.alipay.req.failed")+":"+notify.getBusBodyRspPay().getPay_info());
        }else if(TradeConstants.ALIPAY_RET_CODE_EXCEPTION.equals(notify.getBusBodyRspPay().getRet_code())){
            // 支付中心处理异常
            return this.buildRsp(trade, getInternalFailureCode("withdraw.paymentcenter.exception"), 
                    getInternalFailureMessage("withdraw.paymentcenter.exception"));
        }else if(TradeConstants.ALIPAY_RET_CODE_PROCESS.equals(notify.getBusBodyRspPay().getRet_code())){
            // 支付宝批次状态处理中
            return this.buildRsp(trade, getInternalFailureCode("withdraw.alipay.processing"), 
                    getInternalFailureMessage("withdraw.alipay.processing"));
        } else if(!TradeConstants.PAYMENTCENTER_RETURN_SUCCESS.equals(notify.getBusBodyRspPay().getRet_code())
                && !TradeConstants.PAYMENTCENTER_RETURN_FAILED.equals(notify.getBusBodyRspPay().getRet_code())) {
            /** 非0，-1时，不再作处理，直接返回支付中心处理异常 */
            return this.buildRsp(trade, getInternalFailureCode("withdraw.paymentcenter.exception"), 
                    getInternalFailureMessage("withdraw.paymentcenter.exception"));
        }
        
        // 解析payInfo
        WithdrawNotifyPayInfoVo payInfo = assemblePayInfo(trade);
        trade.setPayInfo(payInfo);
        
        // 校验【流水号】与【提交第三方批次流水号】是否一致，若校验不一致返回【失败】   异常原因【提交第三方批次流水号不一致】
        if(!withdrawTrade.getWithdrawSerialNumber().equals(payInfo.getSerialNum())){
            return this.buildRsp(trade, getInternalFailureCode("withdraw.thired.batch.no"), getInternalFailureMessage("withdraw.thired.batch.no"));
        }
        // 校验【收款方账号】与【提现第三方账户】是否一致，若校验不一致返回【失败】    异常原因【提现第三方账户不一致】
        if(!withdrawTrade.getWithdrawThirdAccount().equals(payInfo.getReceiveAccount())){
            return this.buildRsp(trade, getInternalFailureCode("withdraw.thired.account"), getInternalFailureMessage("withdraw.thired.account"));
        }
        // 校验【收款账号姓名】与【提现第三方账户姓名】是否一致，若校验不一致返回【失败】 异常原因【提现第三方账户姓名不一致】
        if(!withdrawTrade.getWithdrawThirdAccountName().equals(payInfo.getReceiverName())){
            return this.buildRsp(trade, getInternalFailureCode("withdraw.thired.account.name"), getInternalFailureMessage("withdraw.thired.account.name"));
        }
        // 校验【付款金额】与【提现金额】是否一致，若校验不一致返回【失败】    异常原因【提现金额不一致】
        if(!withdrawTrade.getWithdrawAmount().equals(AmountUtils.bizAmountConvertToLong(payInfo.getAmount()))){
            return this.buildRsp(trade, getInternalFailureCode("withdraw.amount"), getInternalFailureMessage("withdraw.amount"));
        }
        // 校验【批次号】与【提交第三方批次号】是否一致，若校验不一致返回【失败】 异常原因【提交第三方批次号不一致】
        if(!withdrawTrade.getWithdrawBatchNo().equals(notify.getBusBodyRspPay().getOut_batch_no())){
            return this.buildRsp(trade, getInternalFailureCode("withdraw.thired.batch.no"), getInternalFailureMessage("withdraw.thired.batch.no"));
        }
        
        return null;
    }
    
    private TradeWithdrawErrorinfo getErrorInfo(String errorInfo){
        TradeWithdrawErrorinfo error = null;
        if(!StringUtils.isEmpty(errorInfo)){
            List<TradeWithdrawErrorinfo> errors = errorinfoService.queryBy(TradeConstants.WITHDRAW_ALIPAY_REQUESTER, 
                    TradeConstants.WITHDRAW_ALIPAY_BATCH_QUERY, errorInfo);
            if(!errors.isEmpty()){
                error = errors.get(0);
            }
        }
        return error;
    }
    
    private WithdrawNotifyPayInfoVo assemblePayInfo(WithdrawPayResultBizVo trade){
        // 解析payInfo
        String payInfoString = trade.getPayNotify().getBusBodyRspPay().getPay_info();
        String[] results = payInfoString.split("\\|");
        // 提现只有一条结果记录
        WithdrawNotifyPayInfoVo payInfo = null;
        String[] infos = results[0].split("\\^");
        if(infos.length == 8){
            payInfo = new WithdrawNotifyPayInfoVo();
            payInfo.setSerialNum(infos[0]);
            payInfo.setReceiveAccount(infos[1]);
            payInfo.setReceiverName(infos[2]);
            payInfo.setAmount(infos[3]);
            payInfo.setResultCode(infos[4]);
            payInfo.setErrorCode(infos[5]);
            payInfo.setCompleteTime(infos[6]);
            payInfo.setAlipayTradeNo(infos[7]);
        }
        return payInfo;
    }
    
    /**
     * 处理支付中心的查询结果
     */
    @Override
    protected TradePacketRspSingleWithdrawPayResultQuery processPaymentcenterQueryResult(TradePacketReqSingleWithdrawPayResultQuery tradePacket, WithdrawPayResultBizVo trade) {
        BusTransactionRspPayNotify notify = trade.getPayNotify();
        
        // 状态ret_code为0时，且支付宝pay_info中【明细状态（S）】为付款成功
        // 状态ret_code为-1时，且支付宝pay_info中【明细状态（F）】为付款失败
        
        if(     // ret_code为0 不检测： 且支付宝pay_info明细状态S
                TradeConstants.PAYMENTCENTER_RETURN_SUCCESS.equals(notify.getBusBodyRspPay().getRet_code())
                || 
                // ret_code为-1 不检测： 支付宝pay_info明细状态 F
                TradeConstants.PAYMENTCENTER_RETURN_FAILED.equals(notify.getBusBodyRspPay().getRet_code())
                        ){
            
            return null;
            
        }else{
            // 支付中心处理异常 -- 其他非预料结果
            return this.buildRsp(trade, getInternalFailureCode("withdraw.paymentcenter.exception"), 
                    getInternalFailureMessage("withdraw.paymentcenter.exception")+":"+notify.getBusBodyRspPay().getPay_info());
        }
        
    }
    
    

    /**
     * 查询交易对应的台帐
     * */
    @Override
    protected TradeLedger queryTradeLedger(WithdrawPayResultBizVo bizVo) {
        List<TradeLedger> ledgers = tradeLedgerService.queryTradeLedgerBy(bizVo.getTradeWithdraw().getLedgerNo());
        TradeLedger ledger = ledgers.get(0);
        return ledger;
    }
    
    /**
     * 根据支付中心返回的结果更新交易、台帐
     */
    @Override
    protected void updateTradeByPaymentcenterQueryResult(TradePacketReqSingleWithdrawPayResultQuery tradePacket, WithdrawPayResultBizVo trade, TradeLedger ledger) {
        BusTransactionRspPayNotify rsp = trade.getPayNotify();
        
        // ret_code为0 
        if(TradeConstants.PAYMENTCENTER_RETURN_SUCCESS.equals(rsp.getBusBodyRspPay().getRet_code()) ){
            updateTradeWithdrawSuccess(tradePacket, trade, ledger);
            updateTradeLedgerSuccess(tradePacket, trade, ledger);
        }
        // ret_code为-1 
        else if(TradeConstants.PAYMENTCENTER_RETURN_FAILED.equals(rsp.getBusBodyRspPay().getRet_code())){
            updateTradeWithdrawFailed(tradePacket, trade, ledger);
            updateTradeLedgerFailed(tradePacket, trade, ledger);
        }
    }

    private void updateTradeWithdrawSuccess(TradePacketReqSingleWithdrawPayResultQuery tradePacket, 
            WithdrawPayResultBizVo bizVo, TradeLedger ledger) {
        // 修改交易状态
        TradeWithdraw trade = bizVo.getTradeWithdraw(); 
        trade.setGmtLatestModified(new Date()); // 最后变更日期时间
        trade.setLatestTradeReqType(tradePacket.getBusHead().getRequest_code()); // 最后变更交易请求类型
        trade.setLatestReqNo(bizVo.getReqContext().getReq().getReqNo()); // 最后变更交易请求编号
        trade.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END); // 交易结束状态【已结束】
        trade.setStatus(TradeConstants.TRADE_WITHDRAW_PAY_SUCCESS); // 出款失败【出款成功】
        Date successDate = DateUtil.format(bizVo.getPayInfo().getCompleteTime(), DateUtil.YYYYMMDD);
        trade.setGmtPaySuccess(successDate); // 出款成功日期时间
        // trade.setPayClearChannel(bizVo.getPayInfo().getAlipayTradeNo()); // 出款渠道订单号-- 002时生成
        
        getTradeService().update(bizVo);
    }
    
    private void updateTradeLedgerSuccess(TradePacketReqSingleWithdrawPayResultQuery tradePacket, 
            WithdrawPayResultBizVo bizVo, TradeLedger ledger) {
        // 修改交易状态
        TradeWithdraw trade = bizVo.getTradeWithdraw(); 
        
        // 生效台帐状态
        ledger.setTradeType(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code())); // 所属业务交易类型
        ledger.setTradeNo(trade.getTradeNo()); // 交易编号
        ledger.setGmtTradeCreated(trade.getGmtCreated()); // 所属业务交易创建日期
        ledger.setEffectiveReqType(tradePacket.getBusHead().getRequest_code()); //生效交易请求类型
        ledger.setEffectiveReqNo(bizVo.getReqContext().getReq().getReqNo()); //生效交易请求编号
        Date successDate = DateUtil.format(bizVo.getPayInfo().getCompleteTime(), DateUtil.YYYYMMDD);
        ledger.setGmtSuccessClearChannel(successDate);//外部渠道收付款成功日期时间
        // ledger.setPaymentTradeNo(bizVo.getPayInfo().getAlipayTradeNo()); // 支付中心交易号-- 002时生成
        
        // 业务台账生效日期时间 -- 系统当前日期时间
        ledger.setGmtEffective(new Date());
        // 台账状态 - 生效
        ledger.setStatus(TradeConstants.LEDGER_STATUS_EFFECTIVITY);
        
        this.tradeLedgerService.updateTradeLedger(ledger);
    }
    
    private void updateTradeWithdrawFailed(TradePacketReqSingleWithdrawPayResultQuery tradePacket, 
            WithdrawPayResultBizVo bizVo, TradeLedger ledger) {
        // 修改交易状态
        TradeWithdraw trade = bizVo.getTradeWithdraw(); 
        trade.setGmtLatestModified(new Date()); // 最后变更日期时间
        trade.setLatestTradeReqType(tradePacket.getBusHead().getRequest_code()); // 最后变更交易请求类型
        trade.setLatestReqNo(bizVo.getReqContext().getReq().getReqNo()); // 最后变更交易请求编号
        trade.setStatus(TradeConstants.TRADE_WITHDRAW_PAY_FAILED); // 出款失败【出款失败】
        Date successDate = DateUtil.format(bizVo.getPayInfo().getCompleteTime(), DateUtil.YYYYMMDD);
        trade.setGmtLastPayFail(successDate); // 最后出款失败日期时间
        
        trade.setFailErrorCode(bizVo.getPayInfo().getErrorCode()); // 失败原因错误码
        // trade.setPayClearChannel(bizVo.getPayInfo().getAlipayTradeNo()); // 出款渠道订单号-- 002时生成
        
        getTradeService().update(bizVo);
    }
    
    private void updateTradeLedgerFailed(TradePacketReqSingleWithdrawPayResultQuery tradePacket, 
            WithdrawPayResultBizVo bizVo, TradeLedger ledger) {
        TradeWithdraw trade = bizVo.getTradeWithdraw(); 
        
        // 失败台帐状态
        ledger.setTradeType(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code())); // 所属业务交易类型
        ledger.setTradeNo(trade.getTradeNo()); // 交易编号
        ledger.setGmtTradeCreated(trade.getGmtCreated()); // 所属业务交易创建日期
        ledger.setFailReqType(tradePacket.getBusHead().getRequest_code()); //失败交易请求类型
        ledger.setFailReqNo(bizVo.getReqContext().getReq().getReqNo()); //失败交易请求编号
        // ledger.setPaymentTradeNo(bizVo.getPayInfo().getAlipayTradeNo()); // 支付中心交易号 -- 002时生成
        
        // 业务台账失败日期时间  -- 系统当前日期时间
        ledger.setGmtFailed(new Date());
        // 台账状态
        ledger.setStatus(TradeConstants.LEDGER_STATUS_FAILED);
        
        this.tradeLedgerService.updateTradeLedger(ledger);
    }

    @Override
    protected TradePacketRspSingleWithdrawPayResultQuery buildRsp(WithdrawPayResultBizVo trade, String code, String message) {
        TradePacketRspSingleWithdrawPayResultQuery rsp = new TradePacketRspSingleWithdrawPayResultQuery();
        TradePacketRspBodySingleWithdrawPayResultQuery body = new TradePacketRspBodySingleWithdrawPayResultQuery();
        LOGGER.error("code="+code+";message="+message);
        body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS); // 通信标识
        if(TradeConstants.TRADE_SUCCESS.equals(code)){
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS); // 业务处理成功
        }else{
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE); // 业务处理失败
            body.setErr_code(code);
            body.setErr_code_des(message);
        }
        if(null !=trade){
            String tradeDetails = null;
            try {
                tradeDetails = ObjectJsonUtil.object2String(trade.getTradeWithdraw());
            } catch (Exception e) {
               this.logger(trade.getReqContext(), "", "", e);
            }
            body.setTrade_details(tradeDetails);
        }
        rsp.setBody(body);
        return rsp;
    }

    /**
     * 当ret-code为-1时， 查询检测报文
     */
    @Override
    protected TradePacketRspSingleWithdrawPayResultQuery buildFailedResponse(WithdrawPayResultBizVo trade) {
        BusTransactionRspPayNotify rsp = trade.getPayNotify();
        // ret_code为-1 
        if(TradeConstants.PAYMENTCENTER_RETURN_FAILED.equals(rsp.getBusBodyRspPay().getRet_code())){
            WithdrawNotifyPayInfoVo payInfo = trade.getPayInfo();
            TradeWithdrawErrorinfo error = getErrorInfo(payInfo.getErrorCode());
            if(error != null){
                return this.buildRsp(trade, error.getErrorCode(), error.getErrorDesc());
            }
            // 第三方未知异常
            return this.buildRsp(trade, payInfo.getErrorCode(), this.getInternalFailureMessage("thired.unknown.error.code"));
        }
        return null;
    }

}
