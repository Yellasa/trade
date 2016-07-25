package com.liantuo.trade.bus.process.impl.simple_fund_handle.v1;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.trade.bus.process.TradeCreateSingleTxNoPaymentInterface;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.template.impl.v1_1.create.ATradeCreateSingleTxNoPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.simple_fund_handle.TradePacketReqBodyAdjustAccount;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeAdjustAccount;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountExample;
import com.liantuo.trade.orm.pojo.TradeAdjustAccountLog;
import com.liantuo.trade.orm.service.TradeAdjustAccountService;
import com.liantuo.trade.orm.service.TradeAdjustAccountServiceLog;
import com.liantuo.trade.seqno.IdFactory;
import com.liantuo.trade.spring.annotation.JobFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @version V1.0
 * @Description: 调账
 */
@JobFlow(value = "0003_001_001", version = "1.0", template = ATradeCreateSingleTxNoPaymentTemp.class)
public class TradeAdjustAccountProcess implements TradeCreateSingleTxNoPaymentInterface<TradePacketReqBodyAdjustAccount> {

    private final Logger logger = LoggerFactory.getLogger(TradeAdjustAccountProcess.class);

    @Resource(name = "idFactoryTradeAdjustAccountNo")
    private IdFactory idFactoryTradeAdjustAccountNo;

    @Resource(name = "tradeAdjustAccountService")
    private TradeAdjustAccountService tradeAdjustAccountService;

    @SuppressWarnings("rawtypes")
    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService bizAccountService;

    @Resource(name = "tradeAdjustAccountLogService")
    private TradeAdjustAccountServiceLog tradeAdjustAccountLogService;

    @Autowired
    private ExceptionService exceptionService;
    private String payMerchantNo;
    private String receiveMerchantNo;
    /**tradeAdjustAccount*/
    private TradeAdjustAccount adjustAccount;
    private String reqNo;
    private List<RealTimeAccountingRsp> realTimeAccountingRsps; // 存放账务结果数据

    @Override
    public void formatValidate(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) throws Exception {
        String msg = TradeValidationUtil.validateRequest(tradeRquest);
        if (!StringUtils.isEmpty(msg)) {
            throw exceptionService.buildBusinessException("JY00030010011000100", msg);
        }
    }

    @Override
    public void bizValidate(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) throws Exception {
        // 交易编号重复校验
        checkDuplicate(tradeRquest);
        // 查询付出CA所属商户编号
        CreditAccount payAccount = bizAccountService.selectByAccountNo(tradeRquest.getBody().getPayment_account_no());
        if (null == payAccount) {
            throw exceptionService.buildBusinessException("JY00030010011000400");
        } else {
            payMerchantNo = payAccount.getMerchantNo();
        }
        // 查询收到CA所属商户编号
        CreditAccount receiveAccount = bizAccountService.selectByAccountNo(tradeRquest.getBody().getReceive_account_no());
        if (null == receiveAccount) {
            throw exceptionService.buildBusinessException("JY00030010011000500");
        } else {
            receiveMerchantNo = receiveAccount.getMerchantNo();
        }
    }

    protected void checkDuplicate(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) throws Exception {
        TradeAdjustAccountExample tradeAdjustAccountExample = new TradeAdjustAccountExample();
        tradeAdjustAccountExample.createCriteria()
                .andFundPoolNoEqualTo(tradeRquest.getHead().getFund_pool_no())
                .andOutTradeNoExtEqualTo(tradeRquest.getBody().getOut_trade_no_ext());
        List<TradeAdjustAccount> list = tradeAdjustAccountService.queryExample(tradeAdjustAccountExample);
        if (!CollectionUtils.isEmpty(list)) {
            throw exceptionService.buildBusinessException("JY00030010011000300");
        }
    }

    @Override
    public void tradeCreate(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) throws Exception {
        try {
            this.tradeAdjustCreate(tradeRquest);// 创建交易
            this.updateTradeChgHis();// 交易历史插入

        } catch (Exception e) {
            logger.error(String.format("交易创建失败 OutTradeNoExt=%s ", tradeRquest.getBody().getOut_trade_no_ext()));
            throw exceptionService.buildBusinessException("JY000000000000301");
        }
    }

    protected void tradeAdjustCreate(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) throws Exception {
        TradeAdjustAccount adjust = new TradeAdjustAccount();
        adjust.setTradeNo(TradeUtilCommon.getServiceCode(tradeRquest.getHead().getRequest_code()) + idFactoryTradeAdjustAccountNo.generate().toString());
        adjust.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());// 核心商户编号
        adjust.setFundPoolNo(tradeRquest.getHead().getFund_pool_no());// 池编号
        adjust.setMerchantExtendField1(tradeRquest.getBody().getMerchant_extend_field_1());// 扩展
        adjust.setMerchantExtendField2(tradeRquest.getBody().getMerchant_extend_field_2());
        adjust.setMerchantExtendField3(tradeRquest.getBody().getMerchant_extend_field_3());
        adjust.setMerchantExtendField4(tradeRquest.getBody().getMerchant_extend_field_4());
        adjust.setMerchantExtendField5(tradeRquest.getBody().getMerchant_extend_field_5());
        adjust.setOutTradeNoExt(tradeRquest.getBody().getOut_trade_no_ext());// 交易发起方发起请求编号
        adjust.setOutTradeNo(tradeRquest.getBody().getOut_trade_no());// 交易发起方业务系统订单号
        adjust.setGmtCreated(new Date());// 创建时间
        adjust.setGmtLatestModified(new Date());// 最后变更时间
        adjust.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
        adjust.setLatestReqNo(reqNo);// 最后变更交易请求编号
        adjust.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT);// 交易结束状态-未结束
        adjust.setStatus(TradeConstants.TRADE_ADJUST_ACCOUNT_INIT);// 交易状态-创建
        adjust.setRequestGroup(TradeConstants.TRADE_GROUP_ADJUST_ACCOUNT);//请求组别01
        adjust.setVersion(TradeConstants.DEFAULT_LOCK_VRESION);// 初始版本为0
        adjust.setPaymentAccountNo(tradeRquest.getBody().getPayment_account_no());//付出CA账户编号
        adjust.setPaymentMerchantNo(payMerchantNo);//付出成员商户编号
        adjust.setPaymentAccountExtendField1(tradeRquest.getBody().getPayment_account_extend_field_1());//付出CA账务备注1
        adjust.setPaymentAccountExtendField2(tradeRquest.getBody().getPayment_account_extend_field_2());//付出CA账务备注2
        adjust.setPaymentAccountExtendField3(tradeRquest.getBody().getPayment_account_extend_field_3());//付出CA账务备注3
        adjust.setReceiveAccountNo(tradeRquest.getBody().getReceive_account_no());//收到CA账户编号
        adjust.setReceiveMerchantNo(receiveMerchantNo);//收到成员商户编号
        adjust.setReceiveAccountExtendField1(tradeRquest.getBody().getReceive_account_extend_field_1());//收到CA账务备注1
        adjust.setReceiveAccountExtendField2(tradeRquest.getBody().getReceive_account_extend_field_2());//收到CA账务备注2
        adjust.setReceiveAccountExtendField3(tradeRquest.getBody().getReceive_account_extend_field_3());//收到CA账务备注3

        long tradeAmount;
        try {
            tradeAmount = AmountUtils.bizAmountConvertToLong(tradeRquest.getBody().getAdjust_amount());
        } catch (AmountConvertException e) {
            throw exceptionService.buildBusinessException("JY000000000000201");
        }
        adjust.setAdjustAmount(tradeAmount);//调整金额

        tradeAdjustAccountService.insertAdjustAccount(adjust);
        this.adjustAccount = adjust;    //TODO
    }

    protected void updateTradeChgHis() throws Exception {
        TradeAdjustAccountLog tradeChgHis = new TradeAdjustAccountLog();
        // 为了插入version的变更所以需要重新查询交易
        TradeAdjustAccount tradeAdjust = tradeAdjustAccountService.selectByPrimaryKey(adjustAccount.getId());

        BeanUtils.copyProperties(tradeAdjust, tradeChgHis);
        tradeChgHis.setId(null);    //TODO
        tradeAdjustAccountLogService.insertAdjustAccountLog(tradeChgHis);

        this.adjustAccount = tradeAdjust;   //TODO
    }

    @Override
    public void transaction(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) throws Exception {
        accountingWithFreeze(tradeRquest);// 执行账务
        try {
            updateTradeStatus(tradeRquest);// 修改交易记录
            updateTradeChgHis();// 记录交易历史变更

        } catch (Exception e) {
            throw exceptionService.buildBusinessException("JY000000000000801");
        }
    }

    protected void accountingWithFreeze(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) throws Exception {
        /** 实时记账操作 */
        List<RealTimeAccountingRsp> resultlist;
        try {
            long start = System.currentTimeMillis();
            resultlist = account(tradeRquest);
            logger.info(" ->>> 账务执行时间：" + (System.currentTimeMillis() - start));
            RealTimeAccountingRsp rsp;
            for (Iterator<RealTimeAccountingRsp> it = resultlist.iterator(); it.hasNext(); ) {
                rsp = it.next();
                if ("F".equals(rsp.getSuccess())) {
                    throw new BusinessException(rsp.getRetCode(), rsp.getErrMessage());
                }
            }
        } catch (BusinessException e) {
            logger.error(tradeRquest.getHead().getRequest_code(), e);
            throw new BusinessException(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            throw exceptionService.buildBusinessException("JY000000000000401");
        }
    }

    @SuppressWarnings({"unchecked"})
    protected List<RealTimeAccountingRsp> account(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) throws Exception {
        List<RealTimeAccountingRsp> realTimeAccountingRsps;
        RealTimeAccountVO accounvo = new RealTimeAccountVO();
        accounvo.setPayAccountNo(tradeRquest.getBody().getPayment_account_no());// 付款CA账号
        accounvo.setPayCAFields1(tradeRquest.getBody().getPayment_account_extend_field_1());
        accounvo.setPayCAFields2(tradeRquest.getBody().getPayment_account_extend_field_2());
        accounvo.setPayCAFields3(tradeRquest.getBody().getPayment_account_extend_field_3());
        accounvo.setReceiveAccountNo(tradeRquest.getBody().getReceive_account_no());//收到CA账号
        accounvo.setRecCAFields1(tradeRquest.getBody().getReceive_account_extend_field_1());
        accounvo.setRecCAFields2(tradeRquest.getBody().getReceive_account_extend_field_2());
        accounvo.setRecCAFields3(tradeRquest.getBody().getReceive_account_extend_field_3());
        accounvo.setCoreMerchantNo(tradeRquest.getHead().getCore_merchant_no());// 核心商户编号
        accounvo.setPoolNo(tradeRquest.getHead().getFund_pool_no());// 资金池编号
        accounvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code()));// 交易类型0003_001
        accounvo.setTradeNo(adjustAccount.getTradeNo());// 本交易编号
        accounvo.setTradeGmtCreated(adjustAccount.getGmtCreated());// 本交易创建时间
        accounvo.setRmk("");
        accounvo.setTradeReqCode(tradeRquest.getHead().getRequest_code());// 交易请求类型0003_001_001
        accounvo.setTradeStepNo(reqNo);// 交易请求编号
        if (!StringUtils.isEmpty(tradeRquest.getBody().getOut_trade_no())) {
            accounvo.setSequenceNo(tradeRquest.getBody().getOut_trade_no());// 本交易业务系统订单号
        }
        accounvo.setAmount(adjustAccount.getAdjustAmount());//调账金额
        realTimeAccountingRsps = bizAccountService.transfer(accounvo);
        this.realTimeAccountingRsps = realTimeAccountingRsps;
        return realTimeAccountingRsps;
    }

    protected void updateTradeStatus(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) {
        adjustAccount.setGmtLatestModified(new Date());//最后变更日期时间
        adjustAccount.setLatestReqNo(reqNo);// 最后变更交易请求编号
        adjustAccount.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
        adjustAccount.setGmtAdjustSuccess(realTimeAccountingRsps.get(0).getAccountingRecord().getGmtCreated());// 调整时间，由账务来
        adjustAccount.setStatus(TradeConstants.TRADE_ADJUST_ACCOUNT_SUCCESS);// 【创建】改为【调整成功】
        adjustAccount.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//【未结束】改为【已结束】
        tradeAdjustAccountService.updateTradeAdjustAccount(adjustAccount);
    }

    /**
     * updateTradeStatusToFail
     * @param tradeRquest
     * @throws Exception
     */
    @Override
    public void tradeUpdateForFail(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) throws Exception {
        // 实现更新交易为失败状态
        try {
            updateTradeStatusToFail(tradeRquest);// 修改交易记录
            updateTradeChgHis();// 记录交易历史变更
        } catch (Exception e) {
            throw exceptionService.buildBusinessException("JY000000000000801");
        }
    }

    protected void updateTradeStatusToFail(TradeRequest<TradePacketReqBodyAdjustAccount> tradeRquest) {
        adjustAccount.setGmtLatestModified(new Date());//最后变更日期时间
        adjustAccount.setGmtCreatedFail(new Date());//创建失败日期时间
        adjustAccount.setLatestReqNo(reqNo);// 最后变更交易请求编号
        adjustAccount.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());// 最后变更交易请求类型
        adjustAccount.setStatus(TradeConstants.TRADE_ADJUST_ACCOUNT_FAILED);// 【创建】改为【创建失败】
        adjustAccount.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);//【未结束】改为【已结束】
        tradeAdjustAccountService.updateTradeAdjustAccount(adjustAccount);
    }

    @Override
    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    @Override
    public Object getTradeDetails() {
        return adjustAccount;
    }

}