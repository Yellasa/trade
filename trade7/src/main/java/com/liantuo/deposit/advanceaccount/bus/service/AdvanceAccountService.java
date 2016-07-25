package com.liantuo.deposit.advanceaccount.bus.service;

import java.util.List;

import com.liantuo.deposit.advanceaccount.bus.vo.AdvanceAccountVO;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.trade.exception.BusinessUncheckedException;

public interface AdvanceAccountService {

	/**
	 * @方法名: realTimeAccounting
	 * @方法说明: 实时账务处理
	 * @返回类型 void
	 * @创建人: bjl
	 * @创建时间: 2015年12月14日 下午5:34:37
	 */
	public List<RealTimeAccountingRsp> realTimeAccounting(List<RealTimeAccountingVo> list) throws BusinessUncheckedException;
	
    /**
     * @方法名: selectByAccountNo
     * @方法说明: 根据accountNo查询AdvanceAccountVO
     * @param accountNo
     * @返回类型 AdvanceAccountVO
     * @创建人: dll
     * @创建时间: 2016年5月6日 下午11:15:16
     */
    public AdvanceAccountVO selectByAccountNo (String accountNo);

}