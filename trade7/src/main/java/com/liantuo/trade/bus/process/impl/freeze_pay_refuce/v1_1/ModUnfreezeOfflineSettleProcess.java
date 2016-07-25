package com.liantuo.trade.bus.process.impl.freeze_pay_refuce.v1_1;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.trade.bus.process.TradeModSingleTxNoPaymentInterface;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.service.LegderService;
import com.liantuo.trade.bus.template.impl.v1_1.mod.ATradeModSingleTxNoPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyUnFreezeOfflineSettle;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.pojo.TradePayment;
import com.liantuo.trade.orm.pojo.TradePaymentExample;
import com.liantuo.trade.orm.pojo.TradePaymentLog;
import com.liantuo.trade.orm.service.TradePaymentLogService;
import com.liantuo.trade.orm.service.TradePaymentService;
import com.liantuo.trade.seqno.IdFactory;
import com.liantuo.trade.spring.annotation.JobFlow;

/**
 * 0001_001_002
 */
@JobFlow(value = "0001_001_002", version = "1.1", template = ATradeModSingleTxNoPaymentTemp.class)
public class ModUnfreezeOfflineSettleProcess implements TradeModSingleTxNoPaymentInterface<TradePacketReqBodyUnFreezeOfflineSettle> {
    private static final Log LOGGER = LogFactory.getLog(ModUnfreezeOfflineSettleProcess.class);
    
    @Resource(name = "tradePaymentService")
    private TradePaymentService tradePaymentService;

    @SuppressWarnings("rawtypes")
    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService accountService;

    @Resource(name="legderServiceImpl")
    private LegderService legderService;
    
    @Resource(name = "tradePaymentLogService")
    private TradePaymentLogService tradePaymentLogService;
    
    @Resource(name = "idFactoryTradeLegderLegderNo")
    private IdFactory idFactoryTradeLegderLegderNo;

    private TradePayment payment; // 存放交易数据 
    
    private String reqNo;
    private List<RealTimeAccountingRsp> realTimeAccountingRsps; // 存放账务结果数据
    @Autowired
	private ExceptionService exceptionService;
    @Override
    public void formatValidate(TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> tradeRquest) throws Exception {
        String msg = TradeValidationUtil.validateRequest(tradeRquest);
        if(!StringUtils.isEmpty(msg)){
            throw exceptionService.buildBusinessException("JY00010010021100100", msg);
        }
    }

    @Override
    public void bizValidate(TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> tradeRquest) throws Exception {

        // 校验原交易编号与资金池是否一致
        validateOriginalTrade(tradeRquest);

        // 校验交易状态
        if (!TradeConstants.TRADE_STATUS_FREEZE.equals(payment.getStatus())) {
            throw exceptionService.buildBusinessException("JY00010010021100400");
        }

        // 校验该交易的冻结金额是否足够
        checkUnFreezeAmount(tradeRquest);
    }

    private void validateOriginalTrade(TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> tradeRquest) throws Exception {
        // 校验原交易编号与资金池是否一致
        TradePaymentExample example = new TradePaymentExample();
        example.createCriteria().andTradeNoEqualTo(tradeRquest.getBody().getTrade_no())
                .andFundPoolNoEqualTo(tradeRquest.getHead().getFund_pool_no())
                .andCoreMerchantNoEqualTo(tradeRquest.getHead().getCore_merchant_no());
        List<TradePayment> list = (List<TradePayment>) tradePaymentService.queryExample(example);
        if (CollectionUtils.isEmpty(list)) {
            // 原交易不存在
            throw exceptionService.buildBusinessException("JY00010010021100300");
        } else {
            payment = list.get(0);
        }
    }

    private void checkUnFreezeAmount(TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> tradeRquest) throws Exception {
        // 校验该交易的冻结金额是否足够
        long actualUnFreezeAmount = 0;
        try {
            actualUnFreezeAmount = AmountUtils.bizAmountConvertToLong(tradeRquest.getBody().getActual_amount());
        } catch (BusinessException e) {
            throw exceptionService.buildBusinessException("JY000000000000201");
        }
        if (actualUnFreezeAmount > payment.getFreezeAmount()) {
            throw exceptionService.buildBusinessException("JY00010010021100500");
        }
    }

    public void transaction(TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> tradeRquest) throws Exception {
        try {
            // 账务操作
            realAccount(tradeRquest);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.error(" ->> 账务操作异常", e);
            throw exceptionService.buildBusinessException("JY000000000000401");
        }
        try {
            // 创建生效业务台账
            createLegder(tradeRquest);
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            LOGGER.error(" ->> 创建生效业务台账异常", e);
            throw exceptionService.buildBusinessException("JY000000000000501");
        }
        try {
            // 修改交易状态
            updateTradeStatus(tradeRquest);
            // 交易历史插入
            updateTradeChgHis();
        } catch (Exception e) {
            LOGGER.error(" ->> 更新交易状态异常", e);
            throw exceptionService.buildBusinessException("JY000000000000801");
        }
    }

    @SuppressWarnings({ "unchecked" })
    private void realAccount(TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> req) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setCoreMerchantNo(req.getHead().getCore_merchant_no()); // 核心商户编号
        accountvo.setPayAccountNo(payment.getPaymentAccountNo()); // 付款账号
        accountvo.setPoolNo(req.getHead().getFund_pool_no()); // 资金池编号
        // accountvo.setRmk("备注");
        accountvo.setSequenceNo(payment.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(req.getHead().getRequest_code())); // 交易类型0001_001
        accountvo.setTradeNo(payment.getTradeNo()); // 本交易编号
        accountvo.setTradeGmtCreated(payment.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(req.getHead().getRequest_code()); // 交易请求类型0001_001_002
        accountvo.setTradeStepNo(reqNo);// 交易请求编号
        accountvo.setFrozenTradeCode(TradeUtilCommon.getTradeType(req.getHead().getRequest_code())); // 所属业务冻结交易类型0001_001
        accountvo.setFrozenTradeNo(payment.getTradeNo()); // 所属业务冻结交易编号
        accountvo.setFreezeAmount(payment.getFreezeAmount()); // 冻结余额减少
        accountvo.setActualAmount(AmountUtils.bizAmountConvertToLong(req.getBody().getActual_amount()));// 实际付出金额

        accountvo.setFro_bal_decr_field_1(req.getBody().getFro_bal_decr_field_1());//冻结余额减少客户账务历史1
        accountvo.setFro_bal_decr_field_2(req.getBody().getFro_bal_decr_field_2());//冻结余额减少客户账务历史2
        accountvo.setFro_bal_decr_field_3(req.getBody().getFro_bal_decr_field_3());//冻结余额减少客户账务历史3

        accountvo.setAvl_bal_incr_field_1(req.getBody().getAvl_bal_incr_field_1());//可用余额增加客户账务历史1
        accountvo.setAvl_bal_incr_field_2(req.getBody().getAvl_bal_incr_field_2());//可用余额增加客户账务历史2
        accountvo.setAvl_bal_incr_field_3(req.getBody().getAvl_bal_incr_field_3());//可用余额增加客户账务历史3
        
        accountvo.setAvl_bal_decr_field_1(req.getBody().getAvl_bal_decr_field_1());//可用余额减少客户账务历史1
        accountvo.setAvl_bal_decr_field_2(req.getBody().getAvl_bal_decr_field_2());//可用余额减少客户账务历史2
        accountvo.setAvl_bal_decr_field_3(req.getBody().getAvl_bal_decr_field_3());//可用余额减少客户账务历史3
        
        realTimeAccountingRsps = accountService.unFreezeOffline(accountvo);

        for (Iterator<RealTimeAccountingRsp> it = realTimeAccountingRsps.iterator();it.hasNext();) {
            RealTimeAccountingRsp rsp = it.next();
            if ("F".equals(rsp.getSuccess())) {
                throw new BusinessException(rsp.getRetCode(), rsp.getErrMessage());
            }
        }
    }

    private void createLegder(TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> req) {
        TradeLedger ledger = new TradeLedger();
//        ledger.setLedgerNo(TradeUtilCommon.getServiceCode(req.getHead().getRequest_code()) + idFactoryTradeLegderLegderNo.generate().toString());// 业务台账编号
        ledger.setCoreMerchantNo(payment.getCoreMerchantNo());// 核心商户编号
        ledger.setFundPoolNo(payment.getFundPoolNo());// 资金池编号

        ledger.setMerchantExtendField1("");// 业务台账客户保留字段1
        ledger.setMerchantExtendField2("");
        ledger.setMerchantExtendField3("");
        ledger.setMerchantExtendField4("");
        ledger.setMerchantExtendField5("");

        ledger.setTradeType(TradeUtilCommon.getTradeType(req.getHead().getRequest_code())); // 所属业务交易类型（例：0001_001）
        ledger.setTradeNo(payment.getTradeNo()); // 交易编号
        ledger.setGmtTradeCreated(payment.getGmtCreated()); // 所属业务交易创建日期

//        ledger.setCreateReqType(req.getHead().getRequest_code());// 创建交易请求类型
//        ledger.setCreateReqNo(reqNo);// 创建交易请求编号
        ledger.setEffectiveReqType(req.getHead().getRequest_code()); // 生效交易请求类型
        ledger.setEffectiveReqNo(reqNo); // 生效交易请求编号
        if (!StringUtils.isEmpty(payment.getOutTradeNo())) {
            ledger.setOutTradeNo(payment.getOutTradeNo()); // 交易发起方业务系统订单号
        }
        ledger.setOutTradeNoExt(payment.getOutTradeNoExt()); // 交易发起方发起请求ID
//        ledger.setStatus(TradeConstants.LEDGER_STATUS_EFFECTIVITY); // 台账状态（00：新建
                                                                    // 01生效）
        ledger.setClearChannel(req.getBody().getClear_channel()); // 收付款渠道编号（请求业务参数）
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_1())) {
            ledger.setClearChannelAttr1(req.getBody().getClear_channel_attr_1());// 收付款属性1
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_2())) {
            ledger.setClearChannelAttr2(req.getBody().getClear_channel_attr_2());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_3())) {
            ledger.setClearChannelAttr3(req.getBody().getClear_channel_attr_3());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_3())) {
            ledger.setClearChannelAttr3(req.getBody().getClear_channel_attr_3());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_4())) {
            ledger.setClearChannelAttr4(req.getBody().getClear_channel_attr_4());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_5())) {
            ledger.setClearChannelAttr5(req.getBody().getClear_channel_attr_5());
        }
        if (!StringUtils.isEmpty(req.getBody().getClear_channel_attr_6())) {
            ledger.setClearChannelAttr6(req.getBody().getClear_channel_attr_6());
        }

        ledger.setPaymentAmount(AmountUtils.bizAmountConvertToLong(req.getBody().getActual_amount()));// 付款金额
        ledger.setGmtSuccessClearChannel(DateUtil.formatDateTime(req.getBody().getGmt_success_clear_channel()));// 外部渠道收付款成功日期时间
        ledger.setThirdTradeNo(req.getBody().getThird_trade_no());// 收付款渠道订单号
        ledger.setPaymentTradeNo(""); // 支付中心交易号

        legderService.createEffectiveLegder(ledger);
    }

    private void updateTradeStatus(TradeRequest<TradePacketReqBodyUnFreezeOfflineSettle> req) {
        //修改交易状态
        payment.setLatestTradeReqType(req.getHead().getRequest_code());   //本次请求类型
        payment.setLatestReqNo(reqNo);   //本次请求编号
        payment.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//【未结束】改为【已结束】
        payment.setGmtUnfreezeDedcut(realTimeAccountingRsps.get(0).getAccountingRecord().getGmtCreated());//来自扣款账务成功日期时间
        payment.setStatus(TradeConstants.TRADE_STATUS_UNFREEZE_OFFLINESETTLE);//【冻结成功】改为【线下付款成功】
        payment.setClearChannel(req.getBody().getClear_channel());//付款渠道编号
        payment.setGmtSuccessClearChannel(DateUtil.formatDateTime(req.getBody().getGmt_success_clear_channel()));//付款渠道成功日期时间
        payment.setThirdTradeNo(req.getBody().getThird_trade_no());//付款渠道订单号
        payment.setActualAmount(AmountUtils.bizAmountConvertToLong(req.getBody().getActual_amount()));//实际付出金额
        tradePaymentService.updateTradePayment(payment);
    }
    
    private void updateTradeChgHis() {
        TradePaymentLog his = new TradePaymentLog();
		// 为了插入version的变更所以需要重新查询交易
		TradePayment tradePayment = tradePaymentService.selectByPrimaryKey(payment.getId());
		BeanUtils.copyProperties(tradePayment, his);
		his.setId(null);
		tradePaymentLogService.insertTradePaymentLog(his);
		this.payment = tradePayment;
    }

	@Override
	public void setReqNo(String reqNo) {
		this.reqNo = reqNo;
	}

	@Override
	public Object getTradeDetails() {
		// TODO Auto-generated method stub
		return payment;
	}
    

}
