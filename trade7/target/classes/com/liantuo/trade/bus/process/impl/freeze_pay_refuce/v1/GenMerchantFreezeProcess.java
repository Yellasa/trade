package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.trade.bus.template.impl.ATradeNoLegderNoPaymentCreateTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.bus.vo.TradePaymentBizVO;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyMerchantFreeze;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqMerchantFreeze;
import com.liantuo.trade.client.trade.packet.rsp.TradePacketRspMerchantFreeze;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.seqno.IdFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 0001_001_001
 * v1.0
 */
@Component(value = "genMerchantFreezeProcess")
public class GenMerchantFreezeProcess extends ATradeNoLegderNoPaymentCreateTemp<TradePacketReqMerchantFreeze, TradePacketRspMerchantFreeze, TradePaymentBizVO> {

    private final Log LOGGER = LogFactory.getLog(GenMerchantFreezeProcess.class);

    @Resource(name = "idFactoryTradePaymentTradeNo")
    private IdFactory idFactoryTradePaymentTradeNo;

    private final String KEY_MERCHANT_NO = "merchantNo";

    @SuppressWarnings("unchecked")
    @Override
    protected boolean checkDuplicate(TradePacketReqMerchantFreeze tradePacket) {
        return getTradeService().checkDuplicate(tradePacket);
    }

    @Override
    protected void bizValidate(TradePacketReqMerchantFreeze tradePacket, ReqContext reqContext) throws BizException {
        CreditAccount ca = getAccountService().selectByAccountNo(tradePacket.getBody().getPayment_account_no());
        if (null == ca) {
            throw buildBusinessException("trade.pay.account.merchant.not.match", BizException.class);
        } else {
            reqContext.put(KEY_MERCHANT_NO, ca.getMerchantNo());
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"123"};
        System.err.println(arr.toString());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected TradePaymentBizVO tradeCreate(TradePacketReqMerchantFreeze tradePacket, ReqContext reqContext) {
        TradePaymentBizVO trade = new TradePaymentBizVO();
        TradePayment payment = new TradePayment();
        payment.setTradeNo(TradeUtilCommon.getServiceCode(tradePacket.getBusHead().getRequest_code()) + idFactoryTradePaymentTradeNo.generate().toString());
        payment.setCoreMerchantNo(tradePacket.getBusHead().getCore_merchant_no());// 核心商户编号
        payment.setFundPoolNo(tradePacket.getBusHead().getFund_pool_no());// 池编号
        payment.setMerchantExtendField1(tradePacket.getBody().getMerchant_extend_field_1());// 扩展
        payment.setMerchantExtendField2(tradePacket.getBody().getMerchant_extend_field_2());
        payment.setMerchantExtendField3(tradePacket.getBody().getMerchant_extend_field_3());
        payment.setMerchantExtendField4(tradePacket.getBody().getMerchant_extend_field_4());
        payment.setMerchantExtendField5(tradePacket.getBody().getMerchant_extend_field_5());
        payment.setOutTradeNo(tradePacket.getBody().getOut_trade_no());// 交易发起方业务系统订单号
        payment.setOutTradeNoExt(tradePacket.getBody().getOut_trade_no_ext());// 交易发起方发起请求编号
//        payment.setGmtCreated(new Date());// 创建时间
//        payment.setGmtLatestModified(new Date());// 最后变更时间
        payment.setLatestTradeReqType(tradePacket.getBusHead().getRequest_code());// 最后变更交易请求类型
        payment.setLatestReqNo(reqContext.getReq().getReqNo());// 最后变更交易请求编号
        payment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);// 交易结束状态-未结束
        payment.setPaymentAccountNo(tradePacket.getBody().getPayment_account_no());// 付出CA账户编号
        payment.setPaymentMerchantNo((String) reqContext.get(KEY_MERCHANT_NO));// 付出CA账户编号所属成员编号
        payment.setVersion(TradeConstants.DEFAULT_LOCK_VRESION);  // 初始版本为0
        long tradeAmount;
        try {
            tradeAmount = AmountUtils.bizAmountConvertToLong(tradePacket.getBody().getFreeze_amount());
        } catch (AmountConvertException e) {
            throw buildBusinessUncheckedException("trade.amount.convert.error", BizRuntimeException.class);
        }
        payment.setFreezeAmount(tradeAmount);// 冻结金额
        payment.setStatus(TradeConstants.TRADE_STATUS_INIT);// 交易状态-创建

        trade.setPayment(payment);
        getTradeService().create(trade);

        return trade;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<RealTimeAccountingRsp> account(TradePacketReqMerchantFreeze tradePacket, TradePaymentBizVO trade) {
        List<RealTimeAccountingRsp> realTimeAccountingRsps;
        RealTimeAccountVO accounvo = new RealTimeAccountVO();
        accounvo.setPayAccountNo(tradePacket.getBody().getPayment_account_no());//付款账号
        accounvo.setCoreMerchantNo(tradePacket.getBusHead().getCore_merchant_no());//核心商户编号
        accounvo.setPoolNo(tradePacket.getBusHead().getFund_pool_no());//资金池编号
        accounvo.setTradeCode(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code()));//交易类型0001_001
        accounvo.setTradeNo(trade.getPayment().getTradeNo());//本交易编号
        accounvo.setTradeGmtCreated(trade.getPayment().getGmtCreated());//本交易创建时间
        accounvo.setRmk("");
        accounvo.setTradeReqCode(tradePacket.getBusHead().getRequest_code());//交易请求类型0001_001_001
        accounvo.setTradeStepNo((String) trade.getReqContext().getReq().getReqNo());//交易请求编号
        if (!StringUtils.isEmpty(tradePacket.getBody().getOut_trade_no())) {
            accounvo.setSequenceNo(tradePacket.getBody().getOut_trade_no());//本交易业务系统订单号
        }
        accounvo.setFrozenTradeCode(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code()));//所属业务冻结交易类型0001_001
        accounvo.setFrozenTradeNo(trade.getPayment().getTradeNo());//所属业务冻结交易编号
        accounvo.setFreezeAmount(trade.getPayment().getFreezeAmount());//可用余额减少金额,来自输入【冻结金额】
        realTimeAccountingRsps = getAccountService().freeze(accounvo);
        trade.setRealTimeAccountingRsps(realTimeAccountingRsps);
        return realTimeAccountingRsps;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void updateStatus(TradePacketReqMerchantFreeze tradePacket, TradePaymentBizVO trade) {
        trade.getPayment().setLatestReqNo(trade.getReqContext().getReq().getReqNo());//最后变更交易请求编号
        trade.getPayment().setLatestTradeReqType(tradePacket.getBusHead().getRequest_code());//最后变更交易请求类型
        trade.getPayment().setGmtFreeze(trade.getRealTimeAccountingRsps().get(0).getAccountingRecord().getGmtCreated());//冻结时间，由账务来
        trade.getPayment().setStatus(TradeConstants.TRADE_STATUS_FREEZE);//冻结成功
        getTradeService().update(trade);
    }

    @Override
    protected TradePacketRspMerchantFreeze buildRsp(TradePaymentBizVO trade, String code, String message) {
        TradePacketRspMerchantFreeze rsp = new TradePacketRspMerchantFreeze();
        TradePacketRspBodyMerchantFreeze body = new TradePacketRspBodyMerchantFreeze();
//        LOGGER.error("code="+code+";message="+message);
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
    protected void updateTradeChgHis(TradePaymentBizVO trade) {
        // 插入交易变更历史
        getTradeChangeHisService().create(trade);
    }

}
