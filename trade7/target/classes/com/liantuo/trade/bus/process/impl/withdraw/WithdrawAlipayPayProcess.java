package com.liantuo.trade.bus.process.impl.withdraw;

import com.liantuo.trade.bus.template.impl.ATradeLegderPaymentModTemp;
import com.liantuo.trade.bus.vo.WithdrawAlipayPayBizVO;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawPay;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawPay;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.TradePacketRspSingleWithdrawPay;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.orm.pojo.*;
import com.liantuo.trade.orm.service.TradeLedgerLogService;
import com.liantuo.trade.orm.service.TradeLedgerService;
import com.liantuo.trade.orm.service.TradeWithdrawErrorinfoService;
import com.liantuo.trade.orm.service.TradeWithdrawLogService;
import com.liantuo.trade.orm.service.TradeWithdrawService;
import com.liantuo.trade.seqno.IdFactory;
import com.payment.client.pay.BusTransaction;
import com.payment.client.pay.PaymentConstants;
import com.payment.client.pay.vo1.BusTransactionRspPay;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 0002_001_002
 * 成员提现到支付宝-出款
 * V1.0
 */
@Component(value = "withdrawAlipayPayProcess")
public class WithdrawAlipayPayProcess extends ATradeLegderPaymentModTemp<TradePacketReqSingleWithdrawPay, TradePacketRspSingleWithdrawPay, WithdrawAlipayPayBizVO> {

    private final Log LOGGER = LogFactory.getLog(WithdrawAlipayPayProcess.class);

    @Resource(name = "idFactoryWithdrawThirdBatchno")
    private IdFactory idFactoryWithdrawThirdBatchno;

    @Resource
    private TradeLedgerService tradeLedgerService;
    
    @Resource(name = "tradeLedgerLogService")
    private TradeLedgerLogService tradeLedgerLogService;

    @Resource
    private TradeWithdrawLogService tradeWithdrawLogService;

    @Resource
    private TradeWithdrawService tradeWithdrawService;

    @Resource
    private TradeWithdrawErrorinfoService tradeWithdrawErrorinfoService;

    /**
     * 校验transaction_id
     * @param tradePacket
     * @return
     */
    @Override
    protected boolean checkCoreMerchantChannel(TradePacketReqSingleWithdrawPay tradePacket) {
        return this.getTradeService().checkDuplicate(tradePacket);
    }

    /**
     * 校验当前交易状态是否为【扣减成功】，若不是【扣减成功】，校验失败，返回【失败】
     * @param trade
     * @return
     */
    @Override
    protected boolean checkTradeStatus(WithdrawAlipayPayBizVO trade) {
    	LOGGER.info("-->开始校验交易状态：当前的交易状态【"+trade.getTradeWithdraw().getStatus()+"】");
        return !TradeConstants.TRADE_WITHDRAW_DEDUCT_SUCCESS.equals(trade.getTradeWithdraw().getStatus());
    }

    /**
     * 获取提现批次号和流水号
     * @param tradePacket
     * @param reqContext
     */
    @Override
    protected void createBatchNo(TradePacketReqSingleWithdrawPay tradePacket, ReqContext reqContext) {
        String batch_no = TradeUtilCommon.getServiceCode(tradePacket.getBusHead().getRequest_code())+idFactoryWithdrawThirdBatchno.generate().toString();
        String serial_number = TradeConstants.SERIAL_NUMBER;
        LOGGER.info("-->获取提现批次号和流水号");
        LOGGER.info("-->提现批次号【"+batch_no+"】");
        LOGGER.info("-->获取流水号【"+serial_number+"】");
        reqContext.put("batch_no", batch_no);
        reqContext.put("serial_number", serial_number);
    }

    /**
     * 创建空白台账
     * @param tradePacket
     * @param trade
     */
    @Override
    protected void createLedger(TradePacketReqSingleWithdrawPay tradePacket, WithdrawAlipayPayBizVO trade) {
    	LOGGER.info("-->开始创建空白台账：交易编号");
        getLegderService().create(tradePacket, trade);
        LOGGER.info("-->开始创建空白台账结束");

    }

    /**
     * 插入台账历史记录
     * @param tradePacket
     * @param trade
     */
    @Override
    protected void createLedgerHis(TradePacketReqSingleWithdrawPay tradePacket, WithdrawAlipayPayBizVO trade) {
    	LOGGER.info("-->开始插入台账历史记录");
    	TradeLedgerLog his = new TradeLedgerLog();
        TradeLedger ledger=tradeLedgerService.queryTradeLedgerBy(trade.getLedger().getLedgerNo()).get(0);
        BeanUtils.copyProperties(ledger, his);
        his.setId(null);
        tradeLedgerLogService.insertTradeLedgerLog(his);
        LOGGER.info("-->插入台账历史记录结束");
    }

    /**
     * 更新交易状态：【扣减成功】->【出款处理中】
     * @param tradePacket
     * @param trade
     */
    @Override
    protected void updateStatus(TradePacketReqSingleWithdrawPay tradePacket, WithdrawAlipayPayBizVO trade) {
    	LOGGER.info("-->更新交易状态：【扣减成功】->【出款处理中】");
    	trade.getTradeWithdraw().setLatestReqNo(trade.getReqContext().getReq().getReqNo());//最后变更交易请求编号
        trade.getTradeWithdraw().setLatestTradeReqType(tradePacket.getBusHead().getRequest_code());//最后变更交易请求类型
        trade.getTradeWithdraw().setStatus(TradeConstants.TRADE_WITHDRAW_PAYING);//出款处理中
        trade.getTradeWithdraw().setGmtFirstPay(new Date());//首次出款处理中日期时间
        trade.getTradeWithdraw().setPayClearChannel(TradeConstants.WITHDRAW_ALIPAY_TRADE_TYPE);//出款渠道编号
        trade.getTradeWithdraw().setPayTransactionId(tradePacket.getBody().getPay_transaction_id());//出款渠道身份编号
        if (StringUtils.isEmpty(tradePacket.getBody().getRequester())) {
            tradePacket.getBody().setRequester(TradeConstants.WITHDRAW_ALIPAY_REQUESTER);
        }
        trade.getTradeWithdraw().setBusinessType(tradePacket.getBody().getRequester());//金融业务类型
        trade.getTradeWithdraw().setWithdrawBatchNo((String) trade.getReqContext().get("batch_no"));//提交第三方批次号
        trade.getTradeWithdraw().setWithdrawSerialNumber((String) trade.getReqContext().get("serial_number"));//提交第三方批次流水号
        trade.getTradeWithdraw().setPayerAccount(tradePacket.getBody().getPayer_account());//付款方账户
        trade.getTradeWithdraw().setPayerName(tradePacket.getBody().getPayer_name());//付款方账户名称
        trade.getTradeWithdraw().setWithdrawAccountType(TradeConstants.WITHDRAW_ALIPAY_BANK_TYPE);//提现银行/账户编码
        trade.getTradeWithdraw().setWithdrawThirdAccount(tradePacket.getBody().getWithdraw_third_account());//提现第三方账户
        trade.getTradeWithdraw().setWithdrawThirdAccountName(tradePacket.getBody().getWithdraw_third_account_name());//提现第三方账户姓名
        trade.getTradeWithdraw().setWithdrawThirdUserid(tradePacket.getBody().getWithdraw_third_userid());//提现第三方UserID
        trade.getTradeWithdraw().setWithdrawThirdAccountPaymemo(tradePacket.getBody().getWithdraw_third_account_paymemo());//提现第三方账户付款说明
        trade.getTradeWithdraw().setNotifyUrl(tradePacket.getBody().getNotify_url());//异步通知地址
        trade.getTradeWithdraw().setRequestGroup(TradeConstants.WITHDRAW_REQUEST_GROUP);//请求组别
        trade.getTradeWithdraw().setLedgerNo((String) trade.getReqContext().get("ledgerno"));

        this.getTradeService().update(trade);
        LOGGER.info("-->更新交易状态：【扣减成功】->【出款处理中】结束。");
    }

    /**
     * 插入历史交易
     * @param trade
     */
    @Override
    protected void updateTradeChgHis(WithdrawAlipayPayBizVO trade) {
    	LOGGER.info("-->插入历史交易:交易编号");
        TradeWithdrawLog log = new TradeWithdrawLog();
        TradeWithdraw withdraw = tradeWithdrawService.queryById(trade.getTradeWithdraw().getId());
        trade.setTradeWithdraw(withdraw);
        BeanUtils.copyProperties(withdraw, log);
        log.setId(null);
        tradeWithdrawLogService.insertTradeWithdrawLog(log);
        LOGGER.info("-->插入历史交易结束");
    }

    /**
     * 查询原交易
     * @param tradePacket
     * @param reqContext
     * @return
     */
    @Override
    protected WithdrawAlipayPayBizVO queryOriginalTrade(TradePacketReqSingleWithdrawPay tradePacket, ReqContext reqContext) {
    	LOGGER.info("-->开始查询原交易");
    	LOGGER.info("-->核心商户编号:"+tradePacket.getBusHead().getCore_merchant_no());
    	LOGGER.info("-->资金池编号:"+tradePacket.getBusHead().getFund_pool_no());
    	LOGGER.info("-->交易编号:"+tradePacket.getBody().getTrade_no());
        WithdrawAlipayPayBizVO trade = (WithdrawAlipayPayBizVO) this.getTradeService().queryOriginalTrade(tradePacket);
        return trade;
    }

    /**
     * 请求支付中心
     * @param tradePacket
     * @param trade
     * @return
     */
    @Override
    protected BusTransaction paymentRequest(TradePacketReqSingleWithdrawPay tradePacket, WithdrawAlipayPayBizVO trade) {
    	LOGGER.info("-->开始请求支付中心:交易编号");
    	return getPaymentService().paymentRequest(tradePacket, trade);
    }

    /**
     * 支付中心结果校验
     * @param rsp
     * @param trade
     * @throws BizException
     */
    @Override
    protected void paymentCheck(BusTransaction rsp, WithdrawAlipayPayBizVO trade) throws BizException {
        BusTransactionRspPay rspPay = (BusTransactionRspPay) rsp;
        //批次号匹配校验
        if (!rspPay.getBusBodyRspPay().getOrder_no().equals(trade.getReqContext().get("batch_no"))) {
            throw buildBusinessException("withdraw.thired.batch.no", BizException.class);
        }
        if (!TradeConstants.PAYMENTCENTER_RETURN_SUCCESS.equals(rspPay.getBusBodyRspPay().getRet_code())) {
            //从错误码表中取得错误码
            String err_code = rspPay.getBusBodyRspPay().getRet_des();
            String err_message;

            TradeWithdrawErrorinfoExample query = new TradeWithdrawErrorinfoExample();
            query.createCriteria()
                    .andErrorCodeEqualTo(err_code)
                    .andPayChannelEqualTo(PaymentConstants.PAY_CHANNEL_ALIPAY + "")//支付宝渠道
                    .andChannelNoEqualTo(PaymentConstants.TRADE_TYPE_BATCH_PAY_NOPWD + "");//无密批付
            List<TradeWithdrawErrorinfo> list = tradeWithdrawErrorinfoService.query(query);

            TradeWithdrawErrorinfo withdrawErrorinfo;
            if (!CollectionUtils.isEmpty(list)) {
                withdrawErrorinfo = list.get(0);
                err_message = withdrawErrorinfo.getErrorDesc();
            } else {
//                err_code = TradeConstants.PAYMENT_CENTER_GLOBLE_ERROR_CODE;
//                err_message = rspPay.getBusBodyRspPay().getRet_des();
                err_code = rspPay.getBusBodyRspPay().getRet_des();
                err_message = getInternalFailureMessage("thired.unknown.error.code");
            }
            throw new BizException(err_code, err_message);
        }
    }

    /**
     * 交易返回报文
     * @param trade
     * @param code
     * @param message
     * @return
     */
    @Override
    protected TradePacketRspSingleWithdrawPay buildRsp(WithdrawAlipayPayBizVO trade, String code, String message) {
        TradePacketRspSingleWithdrawPay rsp = new TradePacketRspSingleWithdrawPay();
        TradePacketRspBodySingleWithdrawPay body = new TradePacketRspBodySingleWithdrawPay();
        LOGGER.error("code=" + code + ";message=" + message);
        body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//通信标识
        if (TradeConstants.TRADE_SUCCESS.equals(code)) {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//业务处理成功
        } else {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);//业务处理失败
            body.setErr_code(code);
            body.setErr_code_des(message);
        }
        if (null != trade) {
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
}