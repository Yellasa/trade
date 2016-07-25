package com.liantuo.trade.bus.process.impl.withdraw;

import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.trade.bus.template.impl.ATradeNoLegderNoPaymentModTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.bus.vo.WithdrawRefundBizVo;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawDeductRefund;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawDeductRefund;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.TradePacketRspSingleWithdrawDeductRefund;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.exception.BizException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 0002_001_005
 * 成员提现-退回
 * V1.0
 */
@Component(value = "withdrawDeductRefundProcess")
public class WithdrawDeductRefundProcess extends ATradeNoLegderNoPaymentModTemp<TradePacketReqSingleWithdrawDeductRefund, TradePacketRspSingleWithdrawDeductRefund, WithdrawRefundBizVo>{

    /**
     * 查询原交易
     */
    @Override
    protected WithdrawRefundBizVo queryOriginalTrade(TradePacketReqSingleWithdrawDeductRefund tradePacket, ReqContext reqContext) {
        @SuppressWarnings("unchecked")
        WithdrawRefundBizVo trade = (WithdrawRefundBizVo) this.getTradeService().queryOriginalTrade(tradePacket);
        // 原交易不存在
        if(trade == null || trade.getTradeWithdraw() == null){
            return null;
        }
        return trade;
    }
    
    /**
     * 状态检测
     * 交易失败时  返回 true
     */
    @Override
    protected boolean checkTradeStatus(WithdrawRefundBizVo trade) {
        // 扣减成功、出款失败--校验通过
        if(TradeConstants.TRADE_WITHDRAW_DEDUCT_SUCCESS.equals(trade.getTradeWithdraw().getStatus())||
                TradeConstants.TRADE_WITHDRAW_PAY_FAILED.equals(trade.getTradeWithdraw().getStatus())){
            return false;
        }
        return true;
    }

    /**
     * 退回账务
     */
    @SuppressWarnings("unchecked")
    @Override
    protected List<RealTimeAccountingRsp> account(TradePacketReqSingleWithdrawDeductRefund tradePacket, WithdrawRefundBizVo trade) throws BizException {
        RealTimeAccountVO accountVO = new RealTimeAccountVO();
        // 目标账户编号--来自交易【提现CA账户编号】
        accountVO.setAccountNo(trade.getTradeWithdraw().getWithdrawAccountNo());
        // 核心商户编号-- 来自交易【核心商户编号】
        accountVO.setCoreMerchantNo(trade.getTradeWithdraw().getCoreMerchantNo());
        // 资金池编号--来自交易【资金池编号】
        accountVO.setPoolNo(trade.getTradeWithdraw().getFundPoolNo());
        
        // 提现客户账务历史1
        accountVO.setReservedFields1(tradePacket.getBody().getReserved_fields1());
        accountVO.setReservedFields2(tradePacket.getBody().getReserved_fields2());
        accountVO.setReservedFields3(tradePacket.getBody().getReserved_fields3());
        
        // 所属业务交易类型0002_001
        accountVO.setTradeCode(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code()));
        // 所属业务交易编号--来自交易【交易编号】
        accountVO.setTradeNo(trade.getTradeWithdraw().getTradeNo());
        // 所属业务交易创建日期--来自交易【交易创建日期时间】
        accountVO.setTradeGmtCreated(trade.getTradeWithdraw().getGmtCreated());
        // 交易请求类型 -- 0002_001_005
        accountVO.setTradeReqCode(tradePacket.getBusHead().getRequest_code());
        // 所属业务交易请求编号--本交易请求编号
        accountVO.setTradeStepNo(trade.getReqContext().getReq().getReqNo());
        // 所属业务业务系统订单号---本交易业务系统订单号 
        accountVO.setSequenceNo(trade.getTradeWithdraw().getOutTradeNo());
        // 可用余额增加金额----来自原交易【提现金额】
        accountVO.setAmount(trade.getTradeWithdraw().getWithdrawAmount());
        List<RealTimeAccountingRsp> realTimeAccountingRsps = getAccountService().avlBalIncr(accountVO);
        trade.setRealTimeAccountingRsps(realTimeAccountingRsps);
        
        return realTimeAccountingRsps;
    }

    @Override
    protected void updateStatus(TradePacketReqSingleWithdrawDeductRefund tradePacket, WithdrawRefundBizVo trade) {
        if(TradeConstants.TRADE_WITHDRAW_DEDUCT_SUCCESS.equals(trade.getTradeWithdraw().getStatus()) || // 扣减成功退回
                TradeConstants.TRADE_WITHDRAW_PAY_FAILED.equals(trade.getTradeWithdraw().getStatus()) ){ // 出款失败退回
            
            // 最后变更日期时间
            trade.getTradeWithdraw().setGmtLatestModified(new Date());
            // 最后变更交易请求类型
            trade.getTradeWithdraw().setLatestTradeReqType(tradePacket.getBusHead().getRequest_code());
            // 最后变更交易请求编号 
            trade.getTradeWithdraw().setLatestReqNo(trade.getReqContext().getReq().getReqNo());
            
            // 交易结束状态 --- 结束
            trade.getTradeWithdraw().setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
            // 交易状态
            trade.getTradeWithdraw().setStatus(TradeConstants.TRADE_WITHDRAW_REFUND_SUCCESS);
            // 退回成功日期时间
            trade.getTradeWithdraw().setGmtRefundSuccess(new Date());
            
            getTradeService().update(trade);
        }
    }

    @Override
    protected void updateTradeChgHis(WithdrawRefundBizVo trade) {
        getTradeChangeHisService().create(trade);
    }

    @Override
    protected TradePacketRspSingleWithdrawDeductRefund buildRsp(WithdrawRefundBizVo trade, String code, String message) {
        TradePacketRspSingleWithdrawDeductRefund rsp = new TradePacketRspSingleWithdrawDeductRefund();
        TradePacketRspBodySingleWithdrawDeductRefund body = new TradePacketRspBodySingleWithdrawDeductRefund();
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

}
