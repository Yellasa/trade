package com.liantuo.trade.bus.process.impl.withdraw;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.trade.bus.template.DistributedHandle;
import com.liantuo.trade.bus.template.impl.ATradeNoLegderNoPaymentCreateTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.bus.vo.WithdrawDeductBizVo;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawDeduct;
import com.liantuo.trade.client.trade.packet.req.withdraw.TradePacketReqSingleWithdrawDeduct;
import com.liantuo.trade.client.trade.packet.rsp.withdraw.TradePacketRspSingleWithdrawDeduct;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;
import com.liantuo.trade.common.util.trade.ReqContext;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.exception.BizException;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.pojo.TradeWithdraw;
import com.liantuo.trade.seqno.IdFactory;

/**
 * 0002_001_001
 * 成员提现-扣减
 * V1.0
 */
@Component(value = "withdrawDeductProcess")
public class WithdrawDeductProcess extends ATradeNoLegderNoPaymentCreateTemp<TradePacketReqSingleWithdrawDeduct, TradePacketRspSingleWithdrawDeduct, WithdrawDeductBizVo> {

    private final Log LOGGER = LogFactory.getLog(WithdrawDeductProcess.class);
    private final String KEY_MERCHANT_NO = "merchantNo";

    @Resource(name = "idFactoryWithdrawDeductTradeNo")
    private IdFactory idFactoryWithdrawDeductTradeNo;

    /**
     * 重复交易检查
     *
     * @param tradePacket
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    protected boolean checkDuplicate(TradePacketReqSingleWithdrawDeduct tradePacket) {
        return this.getTradeService().checkDuplicate(tradePacket);
    }

    @Override
    protected void bizValidate(TradePacketReqSingleWithdrawDeduct tradePacket, ReqContext reqContext) throws BizException {
        // 合作商户编号-权限

        // 查询【提现CA账户编号】所属成员商户编号，若查询不到，则返回【失败】
        CreditAccount ca = getAccountService().selectByAccountNo(tradePacket.getBody().getWithdraw_account_no());
        if (null == ca) {
            throw buildBusinessException("withdraw.ca.merchant", BizException.class);
        } else {
            reqContext.put(KEY_MERCHANT_NO, ca.getMerchantNo());
        }
    }

    /**
     * 创建交易记录：交易状态 -> 【扣减处理中】
     *
     * @param tradePacket
     * @param reqContext
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    protected WithdrawDeductBizVo tradeCreate(TradePacketReqSingleWithdrawDeduct tradePacket, ReqContext reqContext) {
        TradeWithdraw vo = new TradeWithdraw();
        vo.setTradeNo(TradeUtilCommon.getServiceCode(tradePacket.getBusHead().getRequest_code())+idFactoryWithdrawDeductTradeNo.generate().toString());
        // 核心商户编号
        vo.setCoreMerchantNo(tradePacket.getBusHead().getCore_merchant_no());
        // 资金池编号
        vo.setFundPoolNo(tradePacket.getBusHead().getFund_pool_no());
        // 交易客户保留字段1
        vo.setMerchantExtendField1(tradePacket.getBody().getMerchant_extend_field_1());
        vo.setMerchantExtendField2(tradePacket.getBody().getMerchant_extend_field_2());
        vo.setMerchantExtendField3(tradePacket.getBody().getMerchant_extend_field_3());
        vo.setMerchantExtendField4(tradePacket.getBody().getMerchant_extend_field_4());
        vo.setMerchantExtendField5(tradePacket.getBody().getMerchant_extend_field_5());

        // 交易发起方发起请求编号
        vo.setOutTradeNoExt(tradePacket.getBody().getOut_trade_no_ext());
        // 交易发起方业务系统订单号
        vo.setOutTradeNo(tradePacket.getBody().getOut_trade_no());

        // 交易创建日期时间
        vo.setGmtCreated(new Date());
        // 最后变更日期时间
        vo.setGmtLatestModified(new Date());

        // 最后变更交易请求类型
        vo.setLatestTradeReqType(tradePacket.getBusHead().getRequest_code());
        // 最后变更交易请求编号
        vo.setLatestReqNo(reqContext.getReq().getReqNo());
        // 交易结束状态 --- 未结束
        vo.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);
        // 交易状态 --- 扣减处理中
        vo.setStatus(TradeConstants.TRADE_WITHDRAW_DEDUCTING);
        // 提现CA账户编号
        vo.setWithdrawAccountNo(tradePacket.getBody().getWithdraw_account_no());

        // 提现成员商户编号----来自【提现CA账户编号】所属成员编号
        vo.setWithdrawMerchantNo(reqContext.get(KEY_MERCHANT_NO).toString());

        // 提现金额
        vo.setWithdrawAmount(AmountUtils.bizAmountConvertToLong(tradePacket.getBody().getWithdraw_amount()));
        // 交易版本号 
        vo.setVersion(TradeConstants.DEFAULT_LOCK_VRESION);
        // 请求组别 -- 002交易写入
        // vo.setRequestGroup(TradeConstants.TRADE_GROUP_WITHDRAW_ALIPAY);
        
        vo.setPartnerId(tradePacket.getBusHead().getPartner_id());
        
        WithdrawDeductBizVo bizVo = new WithdrawDeductBizVo();
        bizVo.setTradeWithdraw(vo);
        this.getTradeService().create(bizVo);
        return bizVo;
    }

    /**
     * 实时记账
     *
     * @param tradePacket
     * @param trade
     * @return
     * @throws BizException
     */
    @Override
    protected List<RealTimeAccountingRsp> account(TradePacketReqSingleWithdrawDeduct tradePacket, WithdrawDeductBizVo trade) throws BizException {
        RealTimeAccountVO accountVO = new RealTimeAccountVO();
        //提现CA账户编号
        accountVO.setAccountNo(tradePacket.getBody().getWithdraw_account_no());
        // accountVO.setPayAccountNo(tradePacket.getBody().getWithdraw_account_no()); 
        //核心商户编号
        accountVO.setCoreMerchantNo(tradePacket.getBusHead().getCore_merchant_no());
        //资金池编号
        accountVO.setPoolNo(tradePacket.getBusHead().getFund_pool_no());


        // 提现客户账务历史1
        accountVO.setReservedFields1(tradePacket.getBody().getReserved_fields1());
        accountVO.setReservedFields2(tradePacket.getBody().getReserved_fields2());
        accountVO.setReservedFields3(tradePacket.getBody().getReserved_fields3());

        // 交易类型0002_001
        accountVO.setTradeCode(TradeUtilCommon.getTradeType(tradePacket.getBusHead().getRequest_code()));
        // 本交易编号
        accountVO.setTradeNo(trade.getTradeWithdraw().getTradeNo());
        // 本交易创建时间
        accountVO.setTradeGmtCreated(trade.getTradeWithdraw().getGmtCreated());
        // 交易请求类型0002_001_001
        accountVO.setTradeReqCode(tradePacket.getBusHead().getRequest_code());
        // 交易请求编号
        accountVO.setTradeStepNo((String) trade.getReqContext().getReq().getReqNo());
        // 本交易业务系统订单号
        if (!StringUtils.isEmpty(tradePacket.getBody().getOut_trade_no())) {
            accountVO.setSequenceNo(tradePacket.getBody().getOut_trade_no());
        }
        // //可用余额减少金额,来自输入【提现金额】
        accountVO.setAmount(trade.getTradeWithdraw().getWithdrawAmount());

        // 需要可用额减少的账务操作
        @SuppressWarnings("unchecked")
        List<RealTimeAccountingRsp> realTimeAccountingRsps = getAccountService().avlBalDecr(accountVO);
        trade.setRealTimeAccountingRsps(realTimeAccountingRsps);

        return realTimeAccountingRsps;
    }

    /**
     * 修改交易记录：交易状态：【扣减处理中】->【扣减成功】
     *
     * @param tradePacket
     * @param trade
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void updateStatus(TradePacketReqSingleWithdrawDeduct tradePacket, WithdrawDeductBizVo trade) {
        // 最后变更日期时间
        trade.getTradeWithdraw().setGmtLatestModified(new Date());
        // 最后变更交易请求类型
        trade.getTradeWithdraw().setLatestTradeReqType(tradePacket.getBusHead().getRequest_code());
        // 最后变更交易请求编号 
        trade.getTradeWithdraw().setLatestReqNo(trade.getReqContext().getReq().getReqNo());

        // 交易状态
        trade.getTradeWithdraw().setStatus(TradeConstants.TRADE_WITHDRAW_DEDUCT_SUCCESS);//扣减成功
        // 扣减成功日期时间 --- 来自扣减账务成功日期时间
        trade.getTradeWithdraw().setGmtDeductSuccess(trade.getRealTimeAccountingRsps().get(0).getAccountingRecord().getGmtCreated());
        getTradeService().update(trade);
    }

    /**
     * 交易状态变更记录
     *
     * @param trade
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void updateTradeChgHis(WithdrawDeductBizVo trade) {
        getTradeChangeHisService().create(trade);
    }

    /**
     * 交易响应信息构建
     *
     * @param trade
     * @param code
     * @param message
     * @return
     */
    @Override
    protected TradePacketRspSingleWithdrawDeduct buildRsp(WithdrawDeductBizVo trade, String code, String message) {
        TradePacketRspSingleWithdrawDeduct rsp = new TradePacketRspSingleWithdrawDeduct();
        TradePacketRspBodySingleWithdrawDeduct body = new TradePacketRspBodySingleWithdrawDeduct();
        LOGGER.error("code=" + code + ";message=" + message);
        body.setReturn_code(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS); // 通信标识
        if (TradeConstants.TRADE_SUCCESS.equals(code)) {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_SUCCESS); // 业务处理成功
        } else {
            body.setIs_success(TradeConstants.TRADE_RESPONSE_STATUS_FAILURE); // 业务处理失败
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

    /**
     * 事务处理失败后的处理：交易状态->交易结束
     */
    @Override
    @SuppressWarnings("unchecked")
    protected void realAccountInvokeFailed(TradePacketReqSingleWithdrawDeduct tradePacket, WithdrawDeductBizVo trade) {
        // 交易创建失败日期时间
        trade.getTradeWithdraw().setGmtCreatedFail(new Date());
        // 最后变更日期时间
        trade.getTradeWithdraw().setGmtLatestModified(new Date());
        // 最后变更交易请求类型
        trade.getTradeWithdraw().setLatestTradeReqType(tradePacket.getBusHead().getRequest_code());
        // 最后变更交易请求编号 
        trade.getTradeWithdraw().setLatestReqNo(trade.getReqContext().getReq().getReqNo());

        // 交易状态
        trade.getTradeWithdraw().setStatus(TradeConstants.TRADE_WITHDRAW_DEDUCT_FAILED);// 扣减失败
        // 交易结束状态 --- 结束
        trade.getTradeWithdraw().setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);

        // 事务控制
        getDistributedHandleInvoker().realAccountInvoke(new DistributedHandle<TradePacketReqSingleWithdrawDeduct, WithdrawDeductBizVo>() {
            @Override
            public void doDistTx(TradePacketReqSingleWithdrawDeduct tradePacket, WithdrawDeductBizVo trade) throws BizRuntimeException {
                getTradeService().update(trade);
                /**交易历史变更*/
                updateTradeChgHis(trade);
            }
        }, tradePacket, trade);
    }
}
