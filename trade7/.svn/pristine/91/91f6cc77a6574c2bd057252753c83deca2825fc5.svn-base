package com.liantuo.trade.bus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.liantuo.deposit.advanceaccount.bus.service.AdvanceAccountService;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountService;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.trade.bus.service.BizAccountService;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.exception.BusinessUncheckedException;

@SuppressWarnings("rawtypes")
@Component(value = "bizAccountServiceImpl")
public class BizAccountServiceImpl implements BizAccountService {
	private final Log LOGGER = LogFactory.getLog(BizAccountServiceImpl.class);
	
	@Resource(name = "advanceAccountServiceImpl")
    private AdvanceAccountService advanceAccountService;

    @Resource(name = "creditAccountServiceImpl")
    private CreditAccountService creditAccountService;

	private List<RealTimeAccountingVo> accounts;

    /* (non-Javadoc)
     * @see com.liantuo.trade.bus.service.BizAccountService#selectByAccountNo(java.lang.String)
     */
    @Override
    public CreditAccount selectByAccountNo(String accountno) {
        return creditAccountService.selectByAccountNo(accountno);
    }
    
    /* 冻结:第一步：可用余额减少	第二步：冻结余额增加
     * @see com.liantuo.trade.bus.service.BizAccountService#freeze(com.liantuo.trade.bus.vo.RealTimeAccountVO)
     */
    @Override
    public List<RealTimeAccountingRsp> freeze(RealTimeAccountVO accountvo) throws BusinessException {
        RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
        RealTimeAccountingVo freezeStep2 = new RealTimeAccountingVo();
        List<RealTimeAccountingVo> accounts = new ArrayList<RealTimeAccountingVo>();
        
        freezeStep1.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep1.setReservedFields1(accountvo.getAvl_bal_decr_field_1());//可用余额减少客户账务历史1
        freezeStep1.setReservedFields2(accountvo.getAvl_bal_decr_field_2());//可用余额减少客户账务历史2
        freezeStep1.setReservedFields3(accountvo.getAvl_bal_decr_field_3());//可用余额减少客户账务历史3
//        freezeStep1.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep1.setReservedFields5(accountvo.getReservedFields5());
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep1.setAvlBalDecrAmt(accountvo.getFreezeAmount());//可用余额减少金额,【冻结金额】
        accounts.add(freezeStep1);
        
        freezeStep2.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep2.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep2.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep2.setReservedFields1(accountvo.getFro_bal_incr_field_1());//冻结余额增加客户账务历史1
        freezeStep2.setReservedFields2(accountvo.getFro_bal_incr_field_2());//冻结余额增加客户账务历史2
        freezeStep2.setReservedFields3(accountvo.getFro_bal_incr_field_3());//冻结余额增加客户账务历史3
//        freezeStep2.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep2.setReservedFields5(accountvo.getReservedFields5());
        freezeStep2.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep2.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep2.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep2.setRmk(accountvo.getRmk());//备注
        freezeStep2.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep2.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep2.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep2.setFrozenTradeCode(accountvo.getFrozenTradeCode());//所属业务冻结交易类型
        freezeStep2.setFrozenTradeNo(accountvo.getFrozenTradeNo());//所属业务冻结交易编号
        freezeStep2.setFrozenBalIncrAmt(accountvo.getFreezeAmount());//冻结余额增加金额	
        accounts.add(freezeStep2);

        return this.advanceAccountService.realTimeAccounting(accounts);
    }

    /* 线下付款成功，剩余解冻:第一步：冻结余额减少	第二步：可用余额增加	第三步：可用余额减少
     * @see com.liantuo.trade.bus.service.BizAccountService#unFreeze(com.liantuo.trade.bus.vo.RealTimeAccountVO)
     */
    @Override
    public List<RealTimeAccountingRsp> unFreezeOffline(RealTimeAccountVO accountvo) throws BusinessException {
        RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
        RealTimeAccountingVo freezeStep2 = new RealTimeAccountingVo();
        RealTimeAccountingVo freezeStep3 = new RealTimeAccountingVo();
        List<RealTimeAccountingVo> accounts = new ArrayList<RealTimeAccountingVo>();
        
        freezeStep1.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep1.setReservedFields1(accountvo.getFro_bal_decr_field_1());//冻结余额减少客户账务历史1
        freezeStep1.setReservedFields2(accountvo.getFro_bal_decr_field_2());//冻结余额减少客户账务历史2
        freezeStep1.setReservedFields3(accountvo.getFro_bal_decr_field_3());//冻结余额减少客户账务历史3
//        freezeStep1.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep1.setReservedFields5(accountvo.getReservedFields5());
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode(accountvo.getFrozenTradeCode());//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo(accountvo.getFrozenTradeNo());//所属业务冻结交易编号
        freezeStep1.setFrozenBalDecrAmt(accountvo.getFreezeAmount());//冻结余额减少
        accounts.add(freezeStep1);
        
        freezeStep2.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep2.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep2.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep2.setReservedFields1(accountvo.getAvl_bal_incr_field_1());//可用余额增加客户账务历史1
        freezeStep2.setReservedFields2(accountvo.getAvl_bal_incr_field_2());//可用余额增加客户账务历史2
        freezeStep2.setReservedFields3(accountvo.getAvl_bal_incr_field_3());//可用余额增加客户账务历史3
//        freezeStep2.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep2.setReservedFields5(accountvo.getReservedFields5());
        freezeStep2.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep2.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep2.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep2.setRmk(accountvo.getRmk());//备注
        freezeStep2.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep2.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep2.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep2.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep2.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep2.setAvlBalIncrAmt(accountvo.getFreezeAmount());//可用余额增加
        accounts.add(freezeStep2);
        
        freezeStep3.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep3.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep3.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep3.setReservedFields1(accountvo.getAvl_bal_decr_field_1());//可用余额减少客户账务历史1
        freezeStep3.setReservedFields2(accountvo.getAvl_bal_decr_field_2());//可用余额减少客户账务历史2
        freezeStep3.setReservedFields3(accountvo.getAvl_bal_decr_field_3());//可用余额减少客户账务历史3
//        freezeStep3.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep3.setReservedFields5(accountvo.getReservedFields5());
        freezeStep3.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep3.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep3.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep3.setRmk(accountvo.getRmk());//备注
        freezeStep3.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep3.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep3.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep3.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep3.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep3.setAvlBalDecrAmt(accountvo.getActualAmount());//可用余额减少
        accounts.add(freezeStep3);
        return this.advanceAccountService.realTimeAccounting(accounts);
    }
    
    /* 全额解冻:第一步：冻结余额减少	第二步：可用余额增加
     * @see com.liantuo.trade.bus.service.BizAccountService#fullUnFreeze(com.liantuo.trade.bus.vo.RealTimeAccountVO)
     */
    @Override
    public List<RealTimeAccountingRsp> fullUnFreeze(RealTimeAccountVO accountvo) throws BusinessException {
        RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
        RealTimeAccountingVo freezeStep2 = new RealTimeAccountingVo();
        List<RealTimeAccountingVo> accounts = new ArrayList<RealTimeAccountingVo>();
        
        freezeStep1.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep1.setReservedFields1(accountvo.getFro_bal_decr_field_1());//冻结余额减少客户账务历史1
        freezeStep1.setReservedFields2(accountvo.getFro_bal_decr_field_2());//冻结余额减少客户账务历史2
        freezeStep1.setReservedFields3(accountvo.getFro_bal_decr_field_3());//冻结余额减少客户账务历史3
//        freezeStep1.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep1.setReservedFields5(accountvo.getReservedFields5());
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode(accountvo.getFrozenTradeCode());//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo(accountvo.getFrozenTradeNo());//所属业务冻结交易编号
        freezeStep1.setFrozenBalDecrAmt(accountvo.getFreezeAmount());//冻结余额减少
        accounts.add(freezeStep1);
        
        freezeStep2.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep2.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep2.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep2.setReservedFields1(accountvo.getAvl_bal_incr_field_1());//可用余额增加客户账务历史1
        freezeStep2.setReservedFields2(accountvo.getAvl_bal_incr_field_2());//可用余额增加客户账务历史2
        freezeStep2.setReservedFields3(accountvo.getAvl_bal_incr_field_3());//可用余额增加客户账务历史3
//        freezeStep2.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep2.setReservedFields5(accountvo.getReservedFields5());
        freezeStep2.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep2.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep2.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep2.setRmk(accountvo.getRmk());//备注
        freezeStep2.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep2.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep2.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep2.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep2.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep2.setAvlBalIncrAmt(accountvo.getFreezeAmount());//可用余额增加
        accounts.add(freezeStep2);
       
        return this.advanceAccountService.realTimeAccounting(accounts);
    }
    
    /* CA付款成功，剩余解冻：第一步：冻结余额减少	第二步：可用余额增加	第三步：可用余额减少	第四步：可用余额增加
     * @see com.liantuo.trade.bus.service.BizAccountService#unFreezeOnline(com.liantuo.trade.bus.vo.RealTimeAccountVO)
     */
    @Override
    public List<RealTimeAccountingRsp> unFreezeOnline(RealTimeAccountVO accountvo) throws BusinessException {
        RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
        RealTimeAccountingVo freezeStep2 = new RealTimeAccountingVo();
        RealTimeAccountingVo freezeStep3 = new RealTimeAccountingVo();
        RealTimeAccountingVo freezeStep4 = new RealTimeAccountingVo();
        List<RealTimeAccountingVo> accounts = new ArrayList<RealTimeAccountingVo>();
        
        freezeStep1.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep1.setReservedFields1(accountvo.getFro_bal_decr_field_1());
        freezeStep1.setReservedFields2(accountvo.getFro_bal_decr_field_2());
        freezeStep1.setReservedFields3(accountvo.getFro_bal_decr_field_3());
//        freezeStep1.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep1.setReservedFields5(accountvo.getReservedFields5());
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode(accountvo.getFrozenTradeCode());//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo(accountvo.getFrozenTradeNo());//所属业务冻结交易编号
        freezeStep1.setFrozenBalDecrAmt(accountvo.getFreezeAmount());//冻结余额减少
        accounts.add(freezeStep1);
        
        freezeStep2.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep2.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep2.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep2.setReservedFields1(accountvo.getAvl_bal_incr_field_1());
        freezeStep2.setReservedFields2(accountvo.getAvl_bal_incr_field_2());
        freezeStep2.setReservedFields3(accountvo.getAvl_bal_incr_field_3());
//        freezeStep2.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep2.setReservedFields5(accountvo.getReservedFields5());
        freezeStep2.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep2.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep2.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep2.setRmk(accountvo.getRmk());//备注
        freezeStep2.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep2.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep2.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep2.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep2.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep2.setAvlBalIncrAmt(accountvo.getFreezeAmount());//可用余额增加
        accounts.add(freezeStep2);
        
        freezeStep3.setAccountNo(accountvo.getPayAccountNo());//【付出CA账户编号】
        freezeStep3.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep3.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep3.setReservedFields1(accountvo.getAvl_bal_decr_field_1());
        freezeStep3.setReservedFields2(accountvo.getAvl_bal_decr_field_2());
        freezeStep3.setReservedFields3(accountvo.getAvl_bal_decr_field_3());
//        freezeStep3.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep3.setReservedFields5(accountvo.getReservedFields5());
        freezeStep3.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep3.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep3.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep3.setRmk(accountvo.getRmk());//备注
        freezeStep3.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep3.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep3.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep3.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep3.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep3.setAvlBalDecrAmt(accountvo.getActualAmount());//可用余额减少
        accounts.add(freezeStep3);
        
        freezeStep4.setAccountNo(accountvo.getReceiveAccountNo());//【收款CA账户编号】
        freezeStep4.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep4.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep4.setReservedFields1(accountvo.getAvl_bal_incr_field_1());
        freezeStep4.setReservedFields2(accountvo.getAvl_bal_incr_field_2());
        freezeStep4.setReservedFields3(accountvo.getAvl_bal_incr_field_3());
//        freezeStep4.setReservedFields4(accountvo.getReservedFields4());
//        freezeStep4.setReservedFields5(accountvo.getReservedFields5());
        freezeStep4.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep4.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep4.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep4.setRmk(accountvo.getRmk());//备注
        freezeStep4.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep4.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep4.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep4.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep4.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep4.setAvlBalIncrAmt(accountvo.getActualAmount());//可用余额增加
        accounts.add(freezeStep4);
        
        return this.advanceAccountService.realTimeAccounting(accounts);
    }
    
    /* 线下退款：可用余额增加
     * @see com.liantuo.trade.bus.service.BizAccountService#refundOffline(com.liantuo.trade.bus.vo.RealTimeAccountVO)
     */
    public List<RealTimeAccountingRsp> refundOffline(RealTimeAccountVO accountvo) throws BusinessException{
    	 RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
         List<RealTimeAccountingVo> accounts = new ArrayList<RealTimeAccountingVo>();
         
         freezeStep1.setAccountNo(accountvo.getReceiveAccountNo());// 
         freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
         freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
         freezeStep1.setReservedFields1(accountvo.getAvl_bal_incr_field_1());//可用余额增加客户账务历史1
         freezeStep1.setReservedFields2(accountvo.getAvl_bal_incr_field_2());//可用余额增加客户账务历史2
         freezeStep1.setReservedFields3(accountvo.getAvl_bal_incr_field_3());//可用余额增加客户账务历史3
//         freezeStep1.setReservedFields4(accountvo.getReservedFields4());
//         freezeStep1.setReservedFields5(accountvo.getReservedFields5());
         freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
         freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
         freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
         freezeStep1.setRmk(accountvo.getRmk());//备注
         freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
         freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
         freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
         freezeStep1.setFrozenTradeCode("");//所属业务冻结交易类型
         freezeStep1.setFrozenTradeNo("");//所属业务冻结交易编号
         freezeStep1.setAvlBalIncrAmt(accountvo.getRefundAmount());//可用余额增加
         accounts.add(freezeStep1);
        
         return this.advanceAccountService.realTimeAccounting(accounts);
    }
    
    /* 单边余额增加，多用于退回等操作
     * @see com.liantuo.trade.bus.service.BizAccountService#avlBalIncr(com.liantuo.trade.bus.vo.RealTimeAccountVO)
     */
    public List<RealTimeAccountingRsp> avlBalIncr(RealTimeAccountVO accountvo) throws BusinessException{
   	 RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
        List<RealTimeAccountingVo> accounts = new ArrayList<RealTimeAccountingVo>();
        
        freezeStep1.setAccountNo(accountvo.getAccountNo());// CA账户
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep1.setReservedFields1(accountvo.getReservedFields1());
        freezeStep1.setReservedFields2(accountvo.getReservedFields2());
        freezeStep1.setReservedFields3(accountvo.getReservedFields3());
        freezeStep1.setReservedFields4(accountvo.getReservedFields4());
        freezeStep1.setReservedFields5(accountvo.getReservedFields5());
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep1.setAvlBalIncrAmt(accountvo.getAmount());//可用余额增加
        accounts.add(freezeStep1);
       
        return this.advanceAccountService.realTimeAccounting(accounts);
   }
    
    /* 单边可用余额减少，多用于扣减等操作
     * @see com.liantuo.trade.bus.service.BizAccountService#avlBalDecr(com.liantuo.trade.bus.vo.RealTimeAccountVO)
     */
    public List<RealTimeAccountingRsp> avlBalDecr(RealTimeAccountVO accountvo) throws BusinessException{
      	 RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
           List<RealTimeAccountingVo> accounts = new ArrayList<RealTimeAccountingVo>();
           
           freezeStep1.setAccountNo(accountvo.getAccountNo());// CA账户
           freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
           freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
           freezeStep1.setReservedFields1(accountvo.getReservedFields1());
           freezeStep1.setReservedFields2(accountvo.getReservedFields2());
           freezeStep1.setReservedFields3(accountvo.getReservedFields3());
           freezeStep1.setReservedFields4(accountvo.getReservedFields4());
           freezeStep1.setReservedFields5(accountvo.getReservedFields5());
           freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
           freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
           freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
           freezeStep1.setRmk(accountvo.getRmk());//备注
           freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
           freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
           freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
           freezeStep1.setFrozenTradeCode("");//所属业务冻结交易类型
           freezeStep1.setFrozenTradeNo("");//所属业务冻结交易编号
           freezeStep1.setAvlBalDecrAmt(accountvo.getAmount());//可用余额减少
           accounts.add(freezeStep1);
          
           return this.advanceAccountService.realTimeAccounting(accounts);
      }
    
    /*
     * 成员转账/调账  第一步，可用余额减少；第二步，可用余额增加
     */
    public List<RealTimeAccountingRsp> transfer(RealTimeAccountVO accountvo) throws BusinessException{
    	RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
    	RealTimeAccountingVo freezeStep2 = new RealTimeAccountingVo();
    	List<RealTimeAccountingVo> accounts = new ArrayList<RealTimeAccountingVo>();
    	
    	//第一步
    	freezeStep1.setAccountNo(accountvo.getPayAccountNo());// 付出CA账户
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
	    freezeStep1.setReservedFields1(accountvo.getPayCAFields1());   //三个备注
	    freezeStep1.setReservedFields2(accountvo.getPayCAFields2());   //三个备注
	    freezeStep1.setReservedFields3(accountvo.getPayCAFields3());   //三个备注
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep1.setAvlBalDecrAmt(accountvo.getAmount());//可用余额减少
        accounts.add(freezeStep1);
    	
        //第二步
        freezeStep2.setAccountNo(accountvo.getReceiveAccountNo());//收到CA账户
        freezeStep2.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep2.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep2.setReservedFields1(accountvo.getRecCAFields1());   //三个备注
        freezeStep2.setReservedFields2(accountvo.getRecCAFields2());   //三个备注
        freezeStep2.setReservedFields3(accountvo.getRecCAFields3());   //三个备注
        freezeStep2.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep2.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep2.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep2.setRmk(accountvo.getRmk());//备注
        freezeStep2.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep2.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep2.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep2.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep2.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep2.setAvlBalIncrAmt(accountvo.getAmount());//可用余额增加
        
        accounts.add(freezeStep2);
        return this.advanceAccountService.realTimeAccounting(accounts);
    }

	/* 单边可用余额减少请求对象组织
	 * @see com.liantuo.trade.bus.service.BizAccountService#avlBalDecrWrapper(com.liantuo.trade.bus.vo.RealTimeAccountVO)
	 */
	@Override
	public RealTimeAccountingVo avlBalDecrWrapper(RealTimeAccountVO accountvo) throws BusinessException {
		RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
        
        freezeStep1.setAccountNo(accountvo.getAccountNo());// CA账户
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep1.setReservedFields1(accountvo.getReservedFields1());
        freezeStep1.setReservedFields2(accountvo.getReservedFields2());
        freezeStep1.setReservedFields3(accountvo.getReservedFields3());
        freezeStep1.setReservedFields4(accountvo.getReservedFields4());
        freezeStep1.setReservedFields5(accountvo.getReservedFields5());
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep1.setAvlBalDecrAmt(accountvo.getAmount());//可用余额减少
		return freezeStep1;
	}

	/* 单边可用余额增加请求对象组织
	 * @see com.liantuo.trade.bus.service.BizAccountService#avlBalIncrWrapper(com.liantuo.trade.bus.vo.RealTimeAccountVO)
	 */
	@Override
	public RealTimeAccountingVo avlBalIncrWrapper(RealTimeAccountVO accountvo) throws BusinessException {
		RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
        
        freezeStep1.setAccountNo(accountvo.getAccountNo());// CA账户
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep1.setReservedFields1(accountvo.getReservedFields1());
        freezeStep1.setReservedFields2(accountvo.getReservedFields2());
        freezeStep1.setReservedFields3(accountvo.getReservedFields3());
        freezeStep1.setReservedFields4(accountvo.getReservedFields4());
        freezeStep1.setReservedFields5(accountvo.getReservedFields5());
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型0001_001
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型0001_001_001
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode("");//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo("");//所属业务冻结交易编号
        freezeStep1.setAvlBalIncrAmt(accountvo.getAmount());//可用余额增加
		return freezeStep1;
	}

	@Override
	public List<RealTimeAccountingRsp> senderRequestToAccount(List accounts) throws BusinessException {
		return this.advanceAccountService.realTimeAccounting(accounts);
	}
	
	/**
	 * 单边冻结余额减少封装对象返回
	 */
	@Override
	public RealTimeAccountingVo FrozenBalDecrAmtWrapper(
			RealTimeAccountVO accountvo) throws BusinessException {
		RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
        
        freezeStep1.setAccountNo(accountvo.getAccountNo());// CA账户
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep1.setReservedFields1(accountvo.getReservedFields1());
        freezeStep1.setReservedFields2(accountvo.getReservedFields2());
        freezeStep1.setReservedFields3(accountvo.getReservedFields3());
        freezeStep1.setReservedFields4(accountvo.getReservedFields4());
        freezeStep1.setReservedFields5(accountvo.getReservedFields5());
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode(accountvo.getFrozenTradeCode());//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo(accountvo.getFrozenTradeNo());//所属业务冻结交易编号
        freezeStep1.setFrozenBalDecrAmt(accountvo.getAmount());//冻结余额减少
		return freezeStep1;
	}

	/**
	 * 单边冻结余额增加封装对象返回
	 */
	@Override
	public RealTimeAccountingVo FrozenBalIncrAmtWrapper(
			RealTimeAccountVO accountvo) throws BusinessException {
		RealTimeAccountingVo freezeStep1 = new RealTimeAccountingVo();
        
        freezeStep1.setAccountNo(accountvo.getAccountNo());// CA账户
        freezeStep1.setCoreMerchantNo(accountvo.getCoreMerchantNo());//【核心商户编号】
        freezeStep1.setPoolNo(accountvo.getPoolNo());//【资金池编号】
        freezeStep1.setReservedFields1(accountvo.getReservedFields1());
        freezeStep1.setReservedFields2(accountvo.getReservedFields2());
        freezeStep1.setReservedFields3(accountvo.getReservedFields3());
        freezeStep1.setReservedFields4(accountvo.getReservedFields4());
        freezeStep1.setReservedFields5(accountvo.getReservedFields5());
        freezeStep1.setTradeCode(accountvo.getTradeCode());//交易类型
        freezeStep1.setTradeNo(accountvo.getTradeNo());//本交易编号
        freezeStep1.setTradeGmtCreated(accountvo.getTradeGmtCreated());//本交易创建时间
        freezeStep1.setRmk(accountvo.getRmk());//备注
        freezeStep1.setTradeReqCode(accountvo.getTradeReqCode());//交易请求类型
        freezeStep1.setTradeStepNo(accountvo.getTradeStepNo());//交易请求编号
        freezeStep1.setSequenceNo(accountvo.getSequenceNo());//本交易业务系统订单号
        freezeStep1.setFrozenTradeCode(accountvo.getFrozenTradeCode());//所属业务冻结交易类型
        freezeStep1.setFrozenTradeNo(accountvo.getFrozenTradeNo());//所属业务冻结交易编号
        freezeStep1.setFrozenBalIncrAmt(accountvo.getAmount());//冻结余额增加
		return freezeStep1;
	}
	
    
}