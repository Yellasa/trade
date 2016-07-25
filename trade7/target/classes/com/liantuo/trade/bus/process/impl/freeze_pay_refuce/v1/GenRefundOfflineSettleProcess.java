package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.trade.bus.template.impl.ATradeLegderNoPaymentCreateTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.bus.vo.TradeRefundBizVO;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqRefundOfflineSettle;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspRefundOfflineSettle;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradeRefund;
import com.liantuo.trade.orm.service.impl.TradeRefundServiceImpl;
import com.liantuo.trade.seqno.IdFactory;

/**
 * 新交易创建（非支付中心交易有台账） 0001_002_001
 *
 * @作者 Jimmy
 * @日期 2015年12月18日 下午3:15:31
 * @最后修改人
 * @修改时间
 * @复审人
 */
@Component(value = "genRefundOfflineSettleProcess")
public class GenRefundOfflineSettleProcess extends ATradeLegderNoPaymentCreateTemp<TradePacketReqRefundOfflineSettle, TradePacketRspRefundOfflineSettle, TradeRefundBizVO> {
	
    private static final Log LOG = LogFactory.getLog(TradeRefundServiceImpl.class);
    
    @Resource(name = "idFactoryTradeRefundTradeNo")
    private IdFactory idFactoryTradeRefundTradeNo;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean checkDuplicate(TradePacketReqRefundOfflineSettle tradePacket) {
        // 交易发起方发起请求编号重复
        return this.getTradeService().checkDuplicate(tradePacket);
    }

    @Override
    protected TradeRefundBizVO queryOriginalTrade(TradePacketReqRefundOfflineSettle req, ReqContext reqContext) {
        TradeRefundBizVO trade = (TradeRefundBizVO) this.getTradeService().queryOriginalTrade(
                req.getBody().getOriginal_trade_no(), 
                req.getBusHead().getFund_pool_no(), req.getBusHead().getCore_merchant_no());
        if(trade.getPayment() == null){
            // 原交易不存在
            return null; // 外层会处理异常
        }
        trade.setReqContext(reqContext);
        return trade;
    }

    @Override
    protected boolean checkTradeStatus(TradePacketReqRefundOfflineSettle tradePacket, TradeRefundBizVO trade) {
        //getTradeService().queryOriginalTrade(tradePacket.getBody().getOriginal_trade_no());
        // 原交易状态不正确
        return !TradeConstants.TRADE_STATUS_UNFREEZE_OFFLINESETTLE.equals(trade.getPayment().getStatus());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected TradeRefundBizVO tradeCreate(TradePacketReqRefundOfflineSettle tradePacket, TradeRefundBizVO trade, ReqContext reqContext) {
        try {
            trade.setReqContext(reqContext);

            TradeRefund refund = createTradeRefund(trade, tradePacket);
            trade.setRefund(refund);
            getTradeService().create(trade);
        } catch (Exception e) {
            LOG.error(String.format("退款交易创建错误 OutTradeNo=%s ", reqContext.getReq().getOutTradeNo()), e);
        	throw buildBusinessUncheckedException("trade.record.save.error",BizRuntimeException.class);
        }
        return trade;
    }

    private TradeRefund createTradeRefund(TradeRefundBizVO trade, TradePacketReqRefundOfflineSettle req) throws Exception {
        TradePayment tradePayment = trade.getPayment();

        TradeRefund tr = new TradeRefund();
        tr.setTradeNo(TradeUtilCommon.getServiceCode(req.getBusHead().getRequest_code())+idFactoryTradeRefundTradeNo.generate().toString()); // 创建交易编号
        tr.setCoreMerchantNo(req.getBusHead().getCore_merchant_no()); // 核心商户编号
        tr.setFundPoolNo(req.getBusHead().getFund_pool_no()); // 所属主体资金池编号

        tr.setMerchantExtendField1(req.getBody().getMerchant_extend_field_1());
        tr.setMerchantExtendField2(req.getBody().getMerchant_extend_field_2());
        tr.setMerchantExtendField3(req.getBody().getMerchant_extend_field_3());
        tr.setMerchantExtendField4(req.getBody().getMerchant_extend_field_4());
        tr.setMerchantExtendField5(req.getBody().getMerchant_extend_field_5());

        tr.setOutTradeNo(req.getBody().getOut_trade_no()); // 交易发起方业务系统订单号
        tr.setOutTradeNoExt(req.getBody().getOut_trade_no_ext()); // 交易发起方发起请求ID

        // tr.setGmtCreated() // 交易创建日期时间--数据库自动生成
        // tr.setGmtLatestModified(); // 最后变更日期时间--数据库自动生成

        tr.setLatestTradeReqType(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_OFFLINE_SETTLE); // 最后变更交易请求类型----本次请求类型
        tr.setLatestReqNo(trade.getReqContext().getReq().getReqNo()); // 最后变更交易请求编号---本次请求编号

        tr.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT); // 交易结束状态----未结束

        tr.setOriginalTradeNo(req.getBody().getOriginal_trade_no()); // 原交易编号
        tr.setRefundAccountNo(tradePayment.getPaymentAccountNo()); // 退回CA账户编号----来自原交易【付出CA账户编号】
        tr.setRefundMerchantNo(tradePayment.getPaymentMerchantNo()); // 退回成员商户编号----来自原交易【付出CA账户编号】
        
        tr.setStatus(TradeConstants.TRADE_STATUS_INIT); // 交易状态交易状态（00创建 01 CA退款成功 ）
        tr.setClearChannel(tradePayment.getClearChannel()); // 付款渠道编号------来自原交易【付款渠道编号】

        tr.setGmtSuccessClearChannel(DateUtil.formatDateTime(req.getBody().getGmt_refund_clear_channel())); // 付款渠道退回日期时间 ---- 来自输入
        tr.setClearOrderNo(req.getBody().getThird_trade_no()); // 付款渠道订单号 -- 来自输入
        tr.setClearRefundAmount(AmountUtils.bizAmountConvertToLong(req.getBody().getClear_refund_amount())); // 付款渠道退回金额 ---- 来自输入

        // tr.setGmtRefundSuccess(); // 退回成功日期时间（账务返回成功日志）--空
        // tr.setReceiveAccountNo(""); // 原收款CA账户编号--空
        // tr.setReceiveMerchantNo(""); // 原收款成员商户编号--空
        tr.setVersion(TradeConstants.DEFAULT_LOCK_VRESION); // 版本号----乐观锁

        return tr;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<RealTimeAccountingRsp> account(TradePacketReqRefundOfflineSettle tradePacket, TradeRefundBizVO trade) {
        RealTimeAccountVO vo = getRealTimeAccountingVo(tradePacket, trade);
        
        List<RealTimeAccountingRsp> realTimeAccountingRsps = this.getAccountService().refundOffline(vo);
        trade.setRealTimeAccountingRsps(realTimeAccountingRsps);
        return realTimeAccountingRsps;
    }
    
    private RealTimeAccountVO getRealTimeAccountingVo(TradePacketReqRefundOfflineSettle tradePacket, TradeRefundBizVO trade){
        RealTimeAccountVO accounvo = new RealTimeAccountVO();
        
        accounvo.setReceiveAccountNo(trade.getRefund().getRefundAccountNo()); // 目标账户编号    来自交易【退回CA账户编号】
        accounvo.setCoreMerchantNo(trade.getRefund().getCoreMerchantNo()); //核心商户编号
        accounvo.setPoolNo(trade.getRefund().getFundPoolNo());//资金池编号
        
        accounvo.setTradeCode(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code()));//交易类型0001_002
        accounvo.setTradeNo(trade.getRefund().getTradeNo());//本交易编号
        accounvo.setTradeGmtCreated(trade.getRefund().getGmtCreated());//本交易创建时间
        
        accounvo.setTradeReqCode(tradePacket.getBusHead().getRequest_code()); // 交易请求类型0001_002_001
        accounvo.setTradeStepNo(trade.getReqContext().getReq().getReqNo()); // 交易请求编号
        if(!StringUtils.isEmpty(tradePacket.getBody().getOut_trade_no())){
        	accounvo.setSequenceNo(tradePacket.getBody().getOut_trade_no()); // 本交易业务系统订单号
        }
        
        accounvo.setRefundAmount(trade.getRefund().getClearRefundAmount()); // 可用余额增加金额 来自输入【付款渠道退回金额】
        
        return accounvo;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void updateStatus(TradePacketReqRefundOfflineSettle tradePacket, TradeRefundBizVO trade) {
        TradeRefund newRefund = trade.getRefund();
        newRefund.setId(trade.getRefund().getId());
        newRefund.setLatestTradeReqType(tradePacket.getBusHead().getRequest_code()); // 最后变更交易请求类型----本次请求类型
        newRefund.setLatestReqNo(trade.getReqContext().getReq().getReqNo()); // 最后变更交易请求编号---本次请求编号
        newRefund.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);  // 交易结束状态----结束
        newRefund.setGmtRefundSuccess(trade.getRealTimeAccountingRsps().get(0).getAccountingRecord().getGmtCreated()); // 退回成功日期时间（账务返回成功日志）
        newRefund.setStatus(TradeConstants.TRADE_STATUS_REFUND); // 交易状态交易状态（00创建 01CA退款成功 ）
        getTradeService().update(trade);
    }

    @Override
    protected TradePacketRspRefundOfflineSettle buildRsp(TradeRefundBizVO trade, String code, String message) {
        TradePacketRspRefundOfflineSettle rsp = new TradePacketRspRefundOfflineSettle();

        TradePacketRspBodyRefundOfflineSettle body = new TradePacketRspBodyRefundOfflineSettle();
        if (null != trade) {
            String tradeDetails = null;
            try {
                tradeDetails = ObjectJsonUtil.object2String(trade.getRefund());
            } catch (Exception e) {
               this.logger(trade.getReqContext(), "", "", e);
            }
            body.setTrade_details(tradeDetails);
        }
        body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        if (TradeConstants.TRADE_SUCCESS.equals(code)) {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS);
        } else {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE);
            body.setErr_code(code);
            body.setErr_code_des(message);
        }
        rsp.setBody(body);
        return rsp;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void createLedger(TradePacketReqRefundOfflineSettle tradePacket, TradeRefundBizVO trade) {
			getLegderService().create(tradePacket, trade);
    }

    @Override
    protected final void updateTradeChgHis(TradeRefundBizVO trade) {
        this.getTradeChangeHisService().create(trade);
    }
}
