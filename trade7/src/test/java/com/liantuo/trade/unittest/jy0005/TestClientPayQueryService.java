package com.liantuo.trade.unittest.jy0005;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.service.ExceptionService;
import com.liantuo.trade.bus.service.impl.RechargeServiceImpl;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.body.single_recharge.TradePacketReqBodyQueryAndCheck;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.exception.BusinessPaymentException;
import com.liantuo.trade.orm.pojo.TradeRecharge;
import com.liantuo.trade.orm.pojo.TradeRechargeExample;
import com.liantuo.trade.orm.pojo.TradeRechargeExample.Criteria;

/**
 * 付款状态监测
 */

@Service
public class TestClientPayQueryService{

    private static final String EFFECTIVE_REQ_TYPE = "0005_001_006";
    private static final String TRADE_TYPE = "0005_001";
    private final Logger logger = LoggerFactory.getLogger(TestClientPayQueryService.class);
    @Autowired
    private ExceptionService exceptionService;
    //	@Autowired
//	private TradeRechargeService tradeRechargeServiceImpl;
    @Resource(name = "rechargeServiceImpl")
    private RechargeServiceImpl tradeRechargeServiceImpl;
    private TradeRecharge _recharge;//根据用户输入查询出来的充值交易记录

    @Resource(name = "bizAccountServiceImpl")
    private BizAccountService bizAccountService;

    private String req_no;//本次请求交易编号



    private void bizValidate(TradePacketReqBodyQueryAndCheck body) throws Exception {
        String trade_no = body.getTrade_no();
        TradeRechargeExample tradeRechargeExample = new TradeRechargeExample();
        Criteria criteria = tradeRechargeExample.createCriteria();
        if(!StringUtils.isEmpty(trade_no)){
        	criteria.andTradeNoEqualTo(trade_no);
        }
        List<TradeRecharge> recharge_list = tradeRechargeServiceImpl.queryByExample(tradeRechargeExample);
        TradeRecharge recharge = null;
        if (recharge_list != null && recharge_list.size() > 0) {
            recharge = recharge_list.get(0);
        }
        if (null == recharge) {
            throw exceptionService.buildBusinessException("JY00050010061000300");
        }
        //请求组别校验
//        String requestGroup = recharge.getRequestGroup();
//        if (!StringUtils.isEmpty(requestGroup)) {
//            if (!TradeConstants.REQUEST_GROUP_OF_HASCODE.equals(requestGroup)) {
//                throw exceptionService.buildBusinessException("JY00050010061000400");
//            }
//        }
        this._recharge = recharge;
        this.req_no = recharge.getLatestReqNo();
    }

    public void handlerRealAcount(TradePacketReqBodyQueryAndCheck body) throws Exception {
    	bizValidate(body);
        List<RealTimeAccountingVo> request_list = new ArrayList<RealTimeAccountingVo>();
        //1 充值补差出账
        RealTimeAccountingVo realAcountSetp1 = realAcountSetp1();
        if (realAcountSetp1 != null) {
            request_list.add(realAcountSetp1);
        }
        //2 充值入账
        RealTimeAccountingVo realAcountSetp2 = realAcountSetp2();
        if (realAcountSetp2 != null) {
            request_list.add(realAcountSetp2);
        }
        //3 手续费扣除
        RealTimeAccountingVo realAcountSetp3 = realAcountSetp3();
        if (realAcountSetp3 != null) {
            request_list.add(realAcountSetp3);
        }
        //4 手续费入账
        RealTimeAccountingVo realAcountSetp4 = realAcountStep4();
        if (realAcountSetp4 != null) {
            request_list.add(realAcountSetp4);
        }

        try {
            List<RealTimeAccountingRsp> list = this.bizAccountService.senderRequestToAccount(request_list);
            RealTimeAccountingRsp rsp;
            for (RealTimeAccountingRsp aList : list) {
                rsp = aList;
                if ("F".equals(rsp.getSuccess())) {
//					throw new BusinessPaymentException(rsp.getRetCode(), rsp.getErrMessage());
                    throw exceptionService.buildPaymentBusinessException(rsp.getRetCode(), rsp.getErrMessage());
                }
            }
        } catch (BusinessPaymentException e) {
            throw exceptionService.buildPaymentBusinessException(e.getBusErrorCode(), e.getBusErrorMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            throw exceptionService.buildPaymentBusinessException("JY000000000000401");
        }
    }

    private RealTimeAccountingVo realAcountSetp1() {
        String type = _recharge.getSupplyWay();
        Long money = _recharge.getSupplyAmount();
        if (!StringUtils.isEmpty(type) && TradeConstants.SUPPLY_WAY_CA.equals(type) && money != null && money > 0) {
            RealTimeAccountVO accountvo = new RealTimeAccountVO();
            accountvo.setCoreMerchantNo(_recharge.getCoreMerchantNo()); // 核心商户编号
            accountvo.setAccountNo(_recharge.getSupplyPayAccountNo());
            accountvo.setPoolNo(_recharge.getFundPoolNo()); // 资金池编号
            accountvo.setReservedFields1(_recharge.getSupplyPayAccountExtendField1());
            accountvo.setReservedFields2(_recharge.getSupplyPayAccountExtendField2());
            accountvo.setReservedFields3(_recharge.getSupplyPayAccountExtendField3());

            // accountvo.setRmk("备注");
            accountvo.setSequenceNo(_recharge.getOutTradeNo()); // 本交易业务系统订单号
            accountvo.setTradeCode(TRADE_TYPE); // 交易类型0005_001
            accountvo.setTradeNo(_recharge.getTradeNo()); // 本交易编号
            accountvo.setTradeGmtCreated(_recharge.getGmtCreated()); // 本交易创建时间
            accountvo.setTradeReqCode(TradeConstants.TRADE_ALIPAY_ONLINE_QUERY); // 交易请求类型0005_001_006
            accountvo.setTradeStepNo(req_no);// 交易请求编号
            if (!StringUtils.isEmpty(_recharge.getOutTradeNo())) {
                accountvo.setSequenceNo(_recharge.getOutTradeNo());// 本交易业务系统订单号
            }
            money = AmountUtils.bizAmountConvertToLong(String.valueOf(money));
            accountvo.setAmount(money);
            return  bizAccountService.avlBalIncrWrapper(accountvo);
//            return bizAccountService.avlBalDecrWrapper(accountvo);
        }
        return null;

    }

    /**
     * 充值入账
     *
     * @param tradeRquest
     * @return
     */
    private RealTimeAccountingVo realAcountSetp2() {
        RealTimeAccountVO accountvo = new RealTimeAccountVO();
        accountvo.setCoreMerchantNo(_recharge.getCoreMerchantNo()); // 核心商户编号
        accountvo.setAccountNo(_recharge.getRechargeAccountNo());
        accountvo.setPoolNo(_recharge.getFundPoolNo()); // 资金池编号
        accountvo.setReservedFields1(_recharge.getRechargeAccountExtendField1());
        accountvo.setReservedFields2(_recharge.getRechargeAccountExtendField2());
        accountvo.setReservedFields3(_recharge.getRechargeAccountExtendField3());

        accountvo.setSequenceNo(_recharge.getOutTradeNo()); // 本交易业务系统订单号
        accountvo.setTradeCode(TRADE_TYPE); // 交易类型0005_001
        accountvo.setTradeNo(_recharge.getTradeNo()); // 本交易编号
        accountvo.setTradeGmtCreated(_recharge.getGmtCreated()); // 本交易创建时间
        accountvo.setTradeReqCode(TradeConstants.TRADE_ALIPAY_ONLINE_QUERY); // 交易请求类型0005_001_006
        accountvo.setTradeStepNo(req_no);// 交易请求编号
        if (!StringUtils.isEmpty(_recharge.getOutTradeNo())) {
            accountvo.setSequenceNo(_recharge.getOutTradeNo());// 本交易业务系统订单号
        }

        Long money = _recharge.getRechargeAmount();//充值金额
        money = AmountUtils.bizAmountConvertToLong(String.valueOf(money));
        accountvo.setAmount(money);
        return bizAccountService.avlBalDecrWrapper(accountvo);
//        return bizAccountService.avlBalIncrWrapper(accountvo);

    }

    private RealTimeAccountingVo realAcountSetp3() {
        Long feeAmount = _recharge.getFeeAmount();//充值手续费
        if (null != feeAmount && feeAmount > 0) {
            RealTimeAccountVO accountvo = new RealTimeAccountVO();
            accountvo.setCoreMerchantNo(_recharge.getCoreMerchantNo()); // 核心商户编号
            accountvo.setAccountNo(_recharge.getRechargeAccountNo());
            accountvo.setPoolNo(_recharge.getFundPoolNo()); // 资金池编号
            accountvo.setReservedFields1(_recharge.getFeePayAccountExtendField1());
            accountvo.setReservedFields2(_recharge.getFeePayAccountExtendField2());
            accountvo.setReservedFields3(_recharge.getFeePayAccountExtendField3());

            accountvo.setSequenceNo(_recharge.getOutTradeNo()); // 本交易业务系统订单号
            accountvo.setTradeCode(TRADE_TYPE); // 交易类型0007_001
            accountvo.setTradeNo(_recharge.getTradeNo()); // 本交易编号
            accountvo.setTradeGmtCreated(_recharge.getGmtCreated()); // 本交易创建时间
            accountvo.setTradeReqCode(TradeConstants.TRADE_ALIPAY_ONLINE_QUERY); // 交易请求类型0005_001_006
            accountvo.setTradeStepNo(req_no);// 交易请求编号
            if (!StringUtils.isEmpty(_recharge.getOutTradeNo())) {
                accountvo.setSequenceNo(_recharge.getOutTradeNo());// 本交易业务系统订单号
            }
            feeAmount = AmountUtils.bizAmountConvertToLong(String.valueOf(feeAmount));
            accountvo.setAmount(feeAmount);
            return bizAccountService.avlBalIncrWrapper(accountvo);
//            return bizAccountService.avlBalDecrWrapper(accountvo);
        }
        return null;

    }

    private RealTimeAccountingVo realAcountStep4() {
        String type = _recharge.getFeeWay();//充值手续费接收方式
        Long feeAmount = _recharge.getFeeAmount();//充值手续费
        if (!StringUtils.isEmpty(type) && TradeConstants.SUPPLY_WAY_CA.equals(type) && feeAmount != null && feeAmount > 0) {
            RealTimeAccountVO accountvo = new RealTimeAccountVO();
            accountvo.setCoreMerchantNo(_recharge.getCoreMerchantNo()); // 核心商户编号
            accountvo.setAccountNo(_recharge.getFeeReceiveAccountNo());//充值手续费收款账号
            accountvo.setPoolNo(_recharge.getFundPoolNo()); // 资金池编号
            accountvo.setReservedFields1(_recharge.getFeeReceiveAccountExtendField1());
            accountvo.setReservedFields2(_recharge.getFeeReceiveAccountExtendField2());
            accountvo.setReservedFields3(_recharge.getFeeReceiveAccountExtendField3());

            accountvo.setSequenceNo(_recharge.getOutTradeNo()); // 本交易业务系统订单号
            accountvo.setTradeCode(TRADE_TYPE); // 交易类型0005_001
            accountvo.setTradeNo(_recharge.getTradeNo()); // 本交易编号
            accountvo.setTradeGmtCreated(_recharge.getGmtCreated()); // 本交易创建时间
            accountvo.setTradeReqCode(TradeConstants.TRADE_ALIPAY_ONLINE_QUERY); // 交易请求类型0005_001_006
            accountvo.setTradeStepNo(req_no);// 交易请求编号
            if (!StringUtils.isEmpty(_recharge.getOutTradeNo())) {
                accountvo.setSequenceNo(_recharge.getOutTradeNo());// 本交易业务系统订单号
            }
            feeAmount = AmountUtils.bizAmountConvertToLong(String.valueOf(feeAmount));
            accountvo.setAmount(feeAmount);
            return bizAccountService.avlBalDecrWrapper(accountvo);
//            return bizAccountService.avlBalIncrWrapper(accountvo);
        }
        return null;
    }

}