package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1;

import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.trade.bus.template.impl.ATradeLegderNoPaymentModTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.bus.vo.TradePaymentBizVO;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyFreezeOfflineSettle;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqUnFreezeOfflineSettle;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspUnFreezeOfflineSettle;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BizException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kelly
 * @version V1.0
 * @Description: 线下付款，剩余解冻
 * 0001_001_002
 */
@Component(value = "modUnfreezeOfflineSettleProcess")
public class ModUnfreezeOfflineSettleProcess
        extends ATradeLegderNoPaymentModTemp<TradePacketReqUnFreezeOfflineSettle, TradePacketRspUnFreezeOfflineSettle, TradePaymentBizVO> {
    @Override
    protected TradePaymentBizVO queryOriginalTrade(TradePacketReqUnFreezeOfflineSettle tradePacket, ReqContext reqContext) {
        TradePaymentBizVO trade = (TradePaymentBizVO) this.getTradeService().queryOriginalTrade(
                tradePacket.getBody().getTrade_no(), 
                tradePacket.getBusHead().getFund_pool_no(), tradePacket.getBusHead().getCore_merchant_no());
        return trade;
    }

    @Override
    protected boolean chectTradeStatus(TradePaymentBizVO trade) {
        return !TradeConstants.TRADE_STATUS_FREEZE.equals(trade.getPayment().getStatus());
    }

    @Override
    protected void bizValidate(TradePacketReqUnFreezeOfflineSettle tradePacket, TradePaymentBizVO trade) throws BizException {
        long actualUnFreezeAmount = 0;
        try {
            actualUnFreezeAmount = AmountUtils.bizAmountConvertToLong(tradePacket.getBody().getActual_amount());
        } catch (AmountConvertException e) {
        	this.logger(trade.getReqContext(), "", "", e);
        	throw buildBusinessException("trade.amount.convert.error",BizException.class);
        }
        if (actualUnFreezeAmount > trade.getPayment().getFreezeAmount()) {
            throw buildBusinessException("trade.freeze.amount.not.enough",BizException.class);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<RealTimeAccountingRsp> account(TradePacketReqUnFreezeOfflineSettle req, TradePaymentBizVO trade) throws BizException {
        List<RealTimeAccountingRsp> realTimeAccountingRsps = null;
        RealTimeAccountVO accountvo=new RealTimeAccountVO();
        accountvo.setCoreMerchantNo(req.getBusHead().getCore_merchant_no());//核心商户编号
        accountvo.setPayAccountNo(trade.getPayment().getPaymentAccountNo());//付款账号
        accountvo.setPoolNo(req.getBusHead().getFund_pool_no());//资金池编号
        //accountvo.setRmk("备注");
        accountvo.setSequenceNo(trade.getPayment().getOutTradeNo());//本交易业务系统订单号
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(req.getBusHead().getRequest_code()));//交易类型0001_001
        accountvo.setTradeNo(trade.getPayment().getTradeNo());//本交易编号
        accountvo.setTradeGmtCreated(trade.getPayment().getGmtCreated());//本交易创建时间
        accountvo.setTradeReqCode(req.getBusHead().getRequest_code());//交易请求类型0001_001_002
        accountvo.setTradeStepNo(trade.getReqContext().getReq().getReqNo());//交易请求编号
        accountvo.setFrozenTradeCode(TradeUtilCommon.getTradeType(req.getBusHead().getRequest_code()));//所属业务冻结交易类型0001_001
        accountvo.setFrozenTradeNo(trade.getPayment().getTradeNo());//所属业务冻结交易编号
        accountvo.setFreezeAmount(trade.getPayment().getFreezeAmount());//冻结余额减少
        accountvo.setActualAmount(AmountUtils.bizAmountConvertToLong(req.getBody().getActual_amount()));//实际付出金额
        realTimeAccountingRsps = getAccountService().unFreezeOffline(accountvo);
        trade.setRealTimeAccountingRsps(realTimeAccountingRsps);
        return realTimeAccountingRsps;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void updateStatus(TradePacketReqUnFreezeOfflineSettle tradePacket, TradePaymentBizVO trade) {
        //修改交易状态
        trade.getPayment().setLatestTradeReqType(tradePacket.getBusHead().getRequest_code());   //本次请求类型
        trade.getPayment().setLatestReqNo(trade.getReqContext().getReq().getReqNo());   //本次请求编号
        trade.getPayment().setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//【未结束】改为【已结束】
        trade.getPayment().setGmtUnfreezeDedcut(trade.getRealTimeAccountingRsps().get(0).getAccountingRecord().getGmtCreated());//来自扣款账务成功日期时间
        trade.getPayment().setStatus(TradeConstants.TRADE_STATUS_UNFREEZE_OFFLINESETTLE);//【冻结成功】改为【线下付款成功】
        trade.getPayment().setClearChannel(tradePacket.getBody().getClear_channel());//付款渠道编号
        trade.getPayment().setGmtSuccessClearChannel(DateUtil.formatDateTime(tradePacket.getBody().getGmt_success_clear_channel()));//付款渠道成功日期时间
        trade.getPayment().setThirdTradeNo(tradePacket.getBody().getThird_trade_no());//付款渠道订单号
        trade.getPayment().setActualAmount(AmountUtils.bizAmountConvertToLong(tradePacket.getBody().getActual_amount()));//实际付出金额
        getTradeService().update(trade);
    }

    @Override
    protected TradePacketRspUnFreezeOfflineSettle buildRsp(TradePaymentBizVO trade, String code, String message) {
        TradePacketRspUnFreezeOfflineSettle rsp = new TradePacketRspUnFreezeOfflineSettle();        
        TradePacketRspBodyFreezeOfflineSettle body = new TradePacketRspBodyFreezeOfflineSettle();        
        body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//通信标识
        if(TradeConstants.TRADE_SUCCESS.equals(code)){
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//业务处理成功
        }else{
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);//业务处理失败
            body.setErr_code(code);
            body.setErr_code_des(message);
        }
        if(null !=trade){
            String tradeDetails = null;
            try {
                tradeDetails = ObjectJsonUtil.object2String(trade.getPayment());
            } catch (Exception e) {
               this.logger(trade.getReqContext(), "", "", e);
            }
            body.setTrade_details(tradeDetails);
        } 
        rsp.setBody(body);
        return rsp;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void createLedger(TradePacketReqUnFreezeOfflineSettle tradePacket, TradePaymentBizVO trade) {
        getLegderService().create(tradePacket, trade);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void updateTradeChgHis(TradePaymentBizVO trade) {
            getTradeChangeHisService().create(trade);
    }
}
