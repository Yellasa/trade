package com.liantuo.trade.bus.process.impl.single_recharge.v1;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.trade.bus.process.TradeModSingleTxNoPaymentInterface;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.service.ProfitLossLedgerService;
import com.liantuo.trade.bus.service.RechargeService;
import com.liantuo.trade.bus.template.impl.v1_1.mod.ATradeModSingleTxNoPaymentTemp;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodySupplyBill;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.common.validate.TradeValidationUtil;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.orm.pojo.TradeProfitLossLedger;
import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.orm.pojo.TradeRechargeExample;
import com.liantuo.trade.spring.annotation.JobFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JobFlow(value = "0005_001_002", version = "1.0", template = ATradeModSingleTxNoPaymentTemp.class)
public class SingleRechargeOfflineSupplyAccountProcess implements TradeModSingleTxNoPaymentInterface<TradePacketReqBodySupplyBill> {
    private final Logger logger = LoggerFactory.getLogger(SingleRechargeOfflineSupplyAccountProcess.class);
    /*private static String LEDGER_TYPE="1";//台账*/

    @Autowired
    private ExceptionService exceptionService;

    @Resource(name = "rechargeServiceImpl")
    private RechargeService rechargeService;

    @SuppressWarnings("rawtypes")
    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService bizAccountService;

	/*@Resource(name="legderServiceImpl")
    private LegderService legderService;*/

    //损益台账service
    @Resource(name = "profitLossLedgerServiceImpl")
    private ProfitLossLedgerService profitLossLedgerService;

    private String supplyLedgerNo;//补差台账编号
    private String feeLedgerNo;//手续费台账编号
    private String reqNo;
    private TradeRecharge tradeRecharge;

    @Override
    public void formatValidate(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest)
            throws Exception {
        String msg = TradeValidationUtil.validateRequest(tradeRquest);
        if (!StringUtils.isEmpty(msg)) {
            logger.info("-->输入参数校验不通过：" + msg);
            throw exceptionService.buildBusinessException("JY00050010021000100", msg);
        }
    }

    @Override
    public void bizValidate(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest) throws Exception {
        validateOriginalTrade(tradeRquest);
    }

    private void validateOriginalTrade(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest) {
        TradeRechargeExample example = new TradeRechargeExample();
        example.createCriteria().andFundPoolNoEqualTo(tradeRquest.getHead().getFund_pool_no())
                .andCoreMerchantNoEqualTo(tradeRquest.getHead().getCore_merchant_no())
                .andTradeNoEqualTo(tradeRquest.getBody().getTrade_no());
        List<TradeRecharge> list = rechargeService.queryByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            logger.info("-->原交易不存在");
            throw exceptionService.buildBusinessException("JY00050010021000300");
        }
        tradeRecharge = list.get(0);
        if (!TradeConstants.TRADE_RECHARGE_WAIT_ENTER.equals(tradeRecharge.getStatus())) {
            logger.info("-->原交易状态异常：交易状态为：【" + tradeRecharge.getStatus() + "】");
            throw exceptionService.buildBusinessException("JY00050010021000400");
        }
    }

    @Override
    public void transaction(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest) throws Exception {
        //如果【充值补差付出方式】为【台账】且【充值补差金额】不为空，创建补差损益台账
        createFeeProfitLedger();
        //账务操作
        handlerRealAcount(tradeRquest);
        //如果充值手续费金额>0，不为空，且充值手续费接收方式为【台账】，创建手续费损益台账
        createSupplyProfitLedger();
        //修改交易记录
        updateTradeRecharge(tradeRquest);
    }

    /**
     * 创建手续费损益台账
     *
     * @Title:createProfitLedger
     * @Description: 创建手续费损益台账
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午4:13:53
     */
    private void createFeeProfitLedger() {
        String way = this.tradeRecharge.getFeeWay();
        Long amount = this.tradeRecharge.getFeeAmount();//手续费金额
        if (!StringUtils.isEmpty(way) && TradeConstants.FEE_WAY_LEDGER.equals(way) && amount != null && amount > 0) {
            TradeProfitLossLedger ledger = new TradeProfitLossLedger();
            try {
                //核心商户编号
                ledger.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo());
                //资金池编号
                ledger.setFundPoolNo(this.tradeRecharge.getFundPoolNo());
                //业务台账客户保留字段1
                ledger.setMerchantExtendField1(this.tradeRecharge.getFeeLedgerExtendField1());
                //业务台账客户保留字段2
                ledger.setMerchantExtendField2(this.tradeRecharge.getFeeLedgerExtendField2());
                //业务台账客户保留字段3
                ledger.setMerchantExtendField3(this.tradeRecharge.getFeeLedgerExtendField3());
                //所属业务交易类型
                ledger.setTradeType(TradeUtilCommon.getTradeType(TradeConstants.TRADE_ADD_COUNT));
                //所属业务交易编号
                ledger.setTradeNo(this.tradeRecharge.getTradeNo());
                //所属业务交易创建日期
                ledger.setGmtTradeCreated(this.tradeRecharge.getGmtCreated());
                //生效交易请求类型
                ledger.setEffectiveReqType(TradeConstants.TRADE_ADD_COUNT);
                //生效交易请求编号
                ledger.setEffectiveReqNo(this.reqNo);
                //交易发起方发起请求编号
                ledger.setOutTradeNoExt(this.tradeRecharge.getOutTradeNoExt());
                //交易发起方业务系统订单号
                ledger.setOutTradeNo(this.tradeRecharge.getOutTradeNo());
                ledger.setGmtEffective(new Date());
                ledger.setProfitLossAttr1(this.tradeRecharge.getFeeProfitLossAttr1());
                ledger.setProfitLossAttr2(this.tradeRecharge.getFeeProfitLossAttr2());
                ledger.setProfitLossAttr3(this.tradeRecharge.getFeeProfitLossAttr3());
                ledger.setProfitLossAttr4(this.tradeRecharge.getFeeProfitLossAttr4());
                ledger.setProfitLossAttr5(this.tradeRecharge.getFeeProfitLossAttr5());
                ledger.setProfitLossAttr6(this.tradeRecharge.getFeeProfitLossAttr6());
                ledger.setProfitLossAttr7(this.tradeRecharge.getFeeProfitLossAttr7());
                ledger.setProfitLossAttr8(this.tradeRecharge.getFeeProfitLossAttr8());
                ledger.setProfitLossAttr9(this.tradeRecharge.getFeeProfitLossAttr9());
                ledger.setProfitLossAttr10(this.tradeRecharge.getFeeProfitLossAttr10());
                String feeLedgerType = this.tradeRecharge.getFeeLedgerType();//充值手续费台账类别1收入增加,2成本费用减少,【充值手续费付出方式】为1时必输
                if (TradeConstants.HANDING_LEDGER_TYPE_INCOME_INC.equals(feeLedgerType)) {
                    //收入增加	来自交易【充值手续费金额】（【充值手续费台账类别】为【收入增加】）
                    ledger.setIncomeIncr(amount);
                } else if (TradeConstants.HANDING_LEDGER_TYPE_COSET_DEC.equals(feeLedgerType)) {
                    //成本费用减少	来自交易【充值手续费金额】（【充值手续费台账类别】为【成本费用减少】）
                    ledger.setCostDecr(amount);
                }
                this.feeLedgerNo = profitLossLedgerService.createEffectiveProfitLossLedger(ledger);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("-->创建损益台账失败：" + e.getMessage(), e);
                throw exceptionService.buildBusinessException("TZ000200101");
            }
        }
    }

    /**
     * 创建补差损益台账
     *
     * @Title:createProfitLedger
     * @Description: 创建补差损益台账
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午4:13:53
     */
    private void createSupplyProfitLedger() {
        String way = this.tradeRecharge.getSupplyWay();
        Long amount = this.tradeRecharge.getSupplyAmount();
        if (!StringUtils.isEmpty(way) && TradeConstants.SUPPLY_WAY_LEDGER.equals(way) && amount != null && amount > 0) {
            TradeProfitLossLedger ledger = new TradeProfitLossLedger();
            try {
                //核心商户编号
                ledger.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo());
                //资金池编号
                ledger.setFundPoolNo(this.tradeRecharge.getFundPoolNo());
                //业务台账客户保留字段1
                ledger.setMerchantExtendField1(this.tradeRecharge.getSupplyLedgerExtendField1());
                //业务台账客户保留字段2
                ledger.setMerchantExtendField2(this.tradeRecharge.getSupplyLedgerExtendField2());
                //业务台账客户保留字段3
                ledger.setMerchantExtendField3(this.tradeRecharge.getSupplyLedgerExtendField3());
                //所属业务交易类型
                ledger.setTradeType(TradeUtilCommon.getTradeType(TradeConstants.TRADE_ADD_COUNT));
                //所属业务交易编号
                ledger.setTradeNo(this.tradeRecharge.getTradeNo());
                //所属业务交易创建日期
                ledger.setGmtTradeCreated(this.tradeRecharge.getGmtCreated());
                //生效交易请求类型
                ledger.setEffectiveReqType(TradeConstants.TRADE_ADD_COUNT);
                //生效交易请求编号
                ledger.setEffectiveReqNo(this.reqNo);
                //交易发起方发起请求编号
                ledger.setOutTradeNoExt(this.tradeRecharge.getOutTradeNoExt());
                //交易发起方业务系统订单号
                ledger.setOutTradeNo(this.tradeRecharge.getOutTradeNo());
                ledger.setGmtEffective(new Date());
                ledger.setProfitLossAttr1(this.tradeRecharge.getSupplyProfitLossAttr1());
                ledger.setProfitLossAttr2(this.tradeRecharge.getSupplyProfitLossAttr2());
                ledger.setProfitLossAttr3(this.tradeRecharge.getSupplyProfitLossAttr3());
                ledger.setProfitLossAttr4(this.tradeRecharge.getSupplyProfitLossAttr4());
                ledger.setProfitLossAttr5(this.tradeRecharge.getSupplyProfitLossAttr5());
                ledger.setProfitLossAttr6(this.tradeRecharge.getSupplyProfitLossAttr6());
                ledger.setProfitLossAttr7(this.tradeRecharge.getSupplyProfitLossAttr7());
                ledger.setProfitLossAttr8(this.tradeRecharge.getSupplyProfitLossAttr8());
                ledger.setProfitLossAttr9(this.tradeRecharge.getSupplyProfitLossAttr9());
                ledger.setProfitLossAttr10(this.tradeRecharge.getSupplyProfitLossAttr10());
                String supplyLedgerType = this.tradeRecharge.getSupplyLedgerType();//充值补差台账类别
                if (TradeConstants.SUPPLY_LEDGER_TYPE_INCOME_DEC.equals(supplyLedgerType)) {
                    //收入减少金额	来自交易【充值补差金额】（【充值补差台账类别】为【收入减少】）
                    ledger.setIncomeDecr(amount);
                } else if (TradeConstants.SUPPLY_LEDGER_TYPE_COSET_INC.equals(supplyLedgerType)) {
                    //成本费用增加金额	来自交易【充值补差金额】（【充值补差台账类别】为【成本费用增加】）
                    ledger.setCostIncr(amount);
                }
                this.supplyLedgerNo = profitLossLedgerService.createEffectiveProfitLossLedger(ledger);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("-->创建损益台账失败：" + e.getMessage(), e);
                throw exceptionService.buildBusinessException("TZ000200101");
            }
        }
    }

    /**
     * 账务操作
     *
     * @param tradeRquest
     * @Title:handlerRealAcount
     * @Description:账务操作
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午4:29:11
     */
    private void handlerRealAcount(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest) {
        List<RealTimeAccountingVo> request_list = new ArrayList<RealTimeAccountingVo>();
        //1 充值补差出账
        RealTimeAccountingVo realAcountSetp1 = realAcountSetp1(tradeRquest);
        if (realAcountSetp1 != null) {
            request_list.add(realAcountSetp1);
        }
        //2 充值入账
        RealTimeAccountingVo realAcountSetp2 = realAcountSetp2(tradeRquest);
        if (realAcountSetp2 != null) {
            request_list.add(realAcountSetp2);
        }
        //3 手续费扣除
        RealTimeAccountingVo realAcountSetp3 = realAcountSetp3(tradeRquest);
        if (realAcountSetp3 != null) {
            request_list.add(realAcountSetp3);
        }
        //4 手续费入账
        RealTimeAccountingVo realAcountSetp4 = realAcountStep4(tradeRquest);
        if (realAcountSetp4 != null) {
            request_list.add(realAcountSetp4);
        }
        try {
            @SuppressWarnings("unchecked")
            List<RealTimeAccountingRsp> list = this.bizAccountService.senderRequestToAccount(request_list);
            RealTimeAccountingRsp rsp;
            for (RealTimeAccountingRsp aList : list) {
                rsp = aList;
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

    /**
     * 充值补差出账
     *
     * @param tradeRquest
     * @Title:realAcountSetp1
     * @Description: 充值补差出账
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午4:19:39
     */
    private RealTimeAccountingVo realAcountSetp1(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest) {
        String type = this.tradeRecharge.getSupplyWay();
        Long money = this.tradeRecharge.getSupplyAmount();
        if (!StringUtils.isEmpty(type) && TradeConstants.SUPPLY_WAY_CA.equals(type) && money != null && money > 0) {
            RealTimeAccountVO accountvo = new RealTimeAccountVO();
            accountvo.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo()); // 核心商户编号
            accountvo.setAccountNo(this.tradeRecharge.getSupplyPayAccountNo());
            accountvo.setPoolNo(this.tradeRecharge.getFundPoolNo()); // 资金池编号
            accountvo.setReservedFields1(this.tradeRecharge.getSupplyPayAccountExtendField1());
            accountvo.setReservedFields2(this.tradeRecharge.getSupplyPayAccountExtendField2());
            accountvo.setReservedFields3(this.tradeRecharge.getSupplyPayAccountExtendField3());

            accountvo.setSequenceNo(this.tradeRecharge.getOutTradeNo()); // 本交易业务系统订单号
            accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0005_001
            accountvo.setTradeNo(this.tradeRecharge.getTradeNo()); // 本交易编号
            accountvo.setTradeGmtCreated(this.tradeRecharge.getGmtCreated()); // 本交易创建时间
            accountvo.setTradeReqCode(TradeConstants.TRADE_ADD_COUNT); // 交易请求类型0005_001_002
            accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
            accountvo.setAmount(money);
            return bizAccountService.avlBalDecrWrapper(accountvo);
        }
        return null;
    }

    /**
     * 充值入账
     *
     * @param tradeRquest
     */
    private RealTimeAccountingVo realAcountSetp2(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest) {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo()); // 核心商户编号
        accountvo.setAccountNo(this.tradeRecharge.getRechargeAccountNo());
        accountvo.setPoolNo(this.tradeRecharge.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(this.tradeRecharge.getRechargeAccountExtendField1());
        accountvo.setReservedFields2(this.tradeRecharge.getRechargeAccountExtendField2());
        accountvo.setReservedFields3(this.tradeRecharge.getRechargeAccountExtendField3());

        accountvo.setSequenceNo(this.tradeRecharge.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0005_001
        accountvo.setTradeNo(this.tradeRecharge.getTradeNo()); // 本交易编号
        accountvo.setTradeGmtCreated(this.tradeRecharge.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_ADD_COUNT); // 交易请求类型0005_001_002
        accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
        accountvo.setAmount(this.tradeRecharge.getRechargeAmount());
        return bizAccountService.avlBalIncrWrapper(accountvo);

    }

    /**
     * 手续费扣除
     *
     * @param tradeRquest
     * @Title:realAcountSetp3
     * @Description: 手续费扣除
     * @return:void
     * @author:zoran.huang
     * @date:2016年5月4日 上午11:48:18
     */
    private RealTimeAccountingVo realAcountSetp3(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest) {
        Long feeAmount = this.tradeRecharge.getFeeAmount();//充值手续费
        if (null != feeAmount && feeAmount > 0) {
            RealTimeAccountVO accountvo = new RealTimeAccountVO();
            accountvo.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo()); // 核心商户编号
            accountvo.setAccountNo(this.tradeRecharge.getRechargeAccountNo());
            accountvo.setPoolNo(this.tradeRecharge.getFundPoolNo()); // 资金池编号
            accountvo.setReservedFields1(this.tradeRecharge.getFeePayAccountExtendField1());//充值手续费充值CA账户扣费账务历史1
            accountvo.setReservedFields2(this.tradeRecharge.getFeePayAccountExtendField2());//充值手续费充值CA账户扣费账务历史2
            accountvo.setReservedFields3(this.tradeRecharge.getFeePayAccountExtendField3());//充值手续费充值CA账户扣费账务历史3

            accountvo.setSequenceNo(this.tradeRecharge.getOutTradeNo()); // 本交易业务系统订单号
            accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0005_001
            accountvo.setTradeNo(this.tradeRecharge.getTradeNo()); // 本交易编号
            accountvo.setTradeGmtCreated(this.tradeRecharge.getGmtCreated()); // 本交易创建时间
            accountvo.setTradeReqCode(TradeConstants.TRADE_ADD_COUNT); // 交易请求类型0005_001_002
            accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
            accountvo.setAmount(feeAmount);
            return bizAccountService.avlBalDecrWrapper(accountvo);
        }
        return null;
    }

    /**
     * 手续费入帐
     *
     * @param tradeRquest
     * @Title:realAcountStep4
     * @Description: 手续费入帐
     * @return:void
     * @author:zoran.huang
     * @date:2016年5月4日 上午11:49:19
     */
    private RealTimeAccountingVo realAcountStep4(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest) {
        String type = this.tradeRecharge.getFeeWay();//充值手续费接收方式
        Long feeAmount = this.tradeRecharge.getFeeAmount();//充值手续费
        if (!StringUtils.isEmpty(type) && TradeConstants.SUPPLY_WAY_CA.equals(type) && feeAmount != null && feeAmount > 0) {
            RealTimeAccountVO accountvo = new RealTimeAccountVO();
            accountvo.setCoreMerchantNo(this.tradeRecharge.getCoreMerchantNo()); // 核心商户编号
            accountvo.setAccountNo(this.tradeRecharge.getFeeReceiveAccountNo());//充值手续费收款账号
            accountvo.setPoolNo(this.tradeRecharge.getFundPoolNo()); // 资金池编号
            accountvo.setReservedFields1(this.tradeRecharge.getFeeReceiveAccountExtendField1());//充值手续费收款账户入账账务历史1
            accountvo.setReservedFields2(this.tradeRecharge.getFeeReceiveAccountExtendField2());//充值手续费收款账户入账账务历史2
            accountvo.setReservedFields3(this.tradeRecharge.getFeeReceiveAccountExtendField3());//充值手续费收款账户入账账务历史3

            accountvo.setSequenceNo(this.tradeRecharge.getOutTradeNo()); // 本交易业务系统订单号
            accountvo.setTradeCode(TradeUtilCommon.getTradeType(tradeRquest.getHead().getRequest_code())); // 交易类型0005_001
            accountvo.setTradeNo(this.tradeRecharge.getTradeNo()); // 本交易编号
            accountvo.setTradeGmtCreated(this.tradeRecharge.getGmtCreated()); // 本交易创建时间
            accountvo.setTradeReqCode(TradeConstants.TRADE_ADD_COUNT); // 交易请求类型0005_001_002
            accountvo.setTradeStepNo(this.reqNo);// 交易请求编号
            accountvo.setAmount(feeAmount);
            return bizAccountService.avlBalIncrWrapper(accountvo);
        }
        return null;
    }

    /**
     * @param tradeRquest
     * @Title:updateTradeRecharge
     * @Description: 修改交易记录为成功关闭状态
     * @return:void
     * @author:zoran.huang
     * @date:2016年4月29日 下午5:02:37
     */
    private void updateTradeRecharge(TradeRequest<TradePacketReqBodySupplyBill> tradeRquest) {
        try {
            TradeRecharge newTradeRecharge = new TradeRecharge();
            BeanUtils.copyProperties(this.tradeRecharge, newTradeRecharge);
            Date successDateTime = new Date();
            //交易结束状态	【已结束】
            newTradeRecharge.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_END);
            //交易状态	【充值成功】
            newTradeRecharge.setStatus(TradeConstants.TRADE_RECHARGE_SUCCESS);
            //充值成功日期时间	系统日期时间
            newTradeRecharge.setGmtRechargeSuccess(successDateTime);
            //最后变更日期时间	系统日期时间
            newTradeRecharge.setGmtLatestModified(successDateTime);
            //最后变更交易请求类型	本次请求类型
            newTradeRecharge.setLatestTradeReqType(tradeRquest.getHead().getRequest_code());
            //最后变更交易请求编号	本次请求编号
            newTradeRecharge.setLatestReqNo(this.reqNo);
            //充值手续费台账编号	来自台账,【充值手续费接收方式】为【台账】时fee_ledger_no
            if (!StringUtils.isEmpty(this.feeLedgerNo)) {
                newTradeRecharge.setFeeLedgerNo(this.feeLedgerNo);
            }
            //充值补差台账编号	来自台账,【充值补差付出方式】为【台账】时supply_ledger_no
            if (!StringUtils.isEmpty(this.supplyLedgerNo)) {
                newTradeRecharge.setSupplyLedgerNo(this.supplyLedgerNo);
            }
            //交易版本号	原版本号+1

            this.tradeRecharge = rechargeService.updateTradeSuccess(newTradeRecharge);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("-->充值交易记录修改失败:" + e.getMessage(), e);
            throw exceptionService.buildBusinessException("JY00050010021000500");
        }
    }

    @Override
    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    @Override
    public Object getTradeDetails() {
        return this.tradeRecharge;
    }

}