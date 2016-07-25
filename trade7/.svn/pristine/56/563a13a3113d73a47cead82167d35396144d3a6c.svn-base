package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.trade.bus.template.impl.ATradeNoLegderNoPaymentModTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.bus.vo.TradePaymentBizVO;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyFullUnFreeze;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqFullUnFreeze;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspFullUnFreeze;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BizRuntimeException;

/**
 * 0001_001_003
 * 成员委托付款 （冻付减）
 * 全额解冻V1.0
 */
@Component(value = "modUnfreezeFullProcess")
public class ModUnfreezeFullProcess extends ATradeNoLegderNoPaymentModTemp<TradePacketReqFullUnFreeze, TradePacketRspFullUnFreeze, TradePaymentBizVO> {
    @Override
    protected TradePaymentBizVO queryOriginalTrade(TradePacketReqFullUnFreeze tradePacket, ReqContext reqContext) {
        TradePaymentBizVO trade = (TradePaymentBizVO) this.getTradeService().queryOriginalTrade(
                tradePacket.getBody().getTrade_no(), 
                tradePacket.getBusHead().getFund_pool_no(), tradePacket.getBusHead().getCore_merchant_no());
        return trade;
    }

    @Override
    protected boolean checkTradeStatus(TradePaymentBizVO trade) {
        return !TradeConstants.TRADE_STATUS_FREEZE.equals(trade.getPayment().getStatus());
    }

    @Override
    protected List<RealTimeAccountingRsp> account(TradePacketReqFullUnFreeze tradePacket, TradePaymentBizVO trade) {
        List<RealTimeAccountingRsp> realTimeAccountingRsps;
        try {
            RealTimeAccountVO fullUnFreezeAccountParam = new RealTimeAccountVO(); // 全额解冻记账参数

            fullUnFreezeAccountParam.setCoreMerchantNo(tradePacket.getBusHead().getCore_merchant_no());////核心商户编号
            fullUnFreezeAccountParam.setPoolNo(tradePacket.getBusHead().getFund_pool_no());//资金池编号
            fullUnFreezeAccountParam.setPayAccountNo(trade.getPayment().getPaymentAccountNo());//付款账号
            fullUnFreezeAccountParam.setTradeCode(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code()));//交易类型0001_001
            fullUnFreezeAccountParam.setTradeNo(trade.getPayment().getTradeNo());//本交易编号
            fullUnFreezeAccountParam.setTradeGmtCreated(trade.getPayment().getGmtCreated());//本交易创建时间
            fullUnFreezeAccountParam.setTradeReqCode(tradePacket.getBusHead().getRequest_code());//交易请求类型0001_001_003
            fullUnFreezeAccountParam.setTradeStepNo(trade.getReqContext().getReq().getReqNo());//交易请求编号
            if(!StringUtils.isEmpty(trade.getPayment().getOutTradeNo())){
            	fullUnFreezeAccountParam.setSequenceNo(trade.getPayment().getOutTradeNo());//本交易业务系统订单号
            }
            fullUnFreezeAccountParam.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code()));//所属业务冻结交易类型0001_001
            fullUnFreezeAccountParam.setFrozenTradeNo(trade.getPayment().getTradeNo());//所属业务冻结交易编号
            fullUnFreezeAccountParam.setFreezeAmount(trade.getPayment().getFreezeAmount());//解冻金额

            realTimeAccountingRsps = getAccountService().fullUnFreeze(fullUnFreezeAccountParam);
        } catch (AmountConvertException e) {
            throw buildBusinessUncheckedException("trade.system.error", BizRuntimeException.class);
        }
        trade.setRealTimeAccountingRsps(realTimeAccountingRsps);
        return realTimeAccountingRsps;
    }

    @Override
    protected void updateStatus(TradePacketReqFullUnFreeze tradePacket, TradePaymentBizVO trade) {
//        trade.getPayment().setGmtLatestModified(new Date());    //当前系统日期时间
        trade.getPayment().setLatestTradeReqType(tradePacket.getBusHead().getRequest_code());   //本次请求类型
        trade.getPayment().setLatestReqNo(trade.getReqContext().getReq().getReqNo());   //【未结束】改为【已结束】
        trade.getPayment().setGmtUnfreeze(trade.getRealTimeAccountingRsps().get(0).getAccountingRecord().getGmtCreated());//来自解冻账务成功日期时间
        trade.getPayment().setStatus(TradeConstants.TRADE_STATUS_UNFREEZE_SUCCESS);
        trade.getPayment().setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
        getTradeService().update(trade);
    }

    @Override
    protected void updateTradeChgHis(TradePaymentBizVO trade) {
        getTradeChangeHisService().create(trade);
    }

    @Override
    protected TradePacketRspFullUnFreeze buildRsp(TradePaymentBizVO trade, String code, String message) {
        TradePacketRspFullUnFreeze rsp = new TradePacketRspFullUnFreeze();
        TradePacketRspBodyFullUnFreeze body = new TradePacketRspBodyFullUnFreeze();
        body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//通信标识
        if (TradeConstants.TRADE_SUCCESS.equals(code)) {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);//业务处理成功
        } else {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);//业务处理失败
            body.setErr_code(code);
            body.setErr_code_des(message);
        }

        if (null != trade) {
            String tradeDetails = "";
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
}