package com.liantuo.deposit.advanceaccount.bus.service;

import java.util.Date;
import java.util.List;

import com.liantuo.deposit.advanceaccount.bus.vo.AccountingRecord;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountAccountRecord;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccountTradeHistory;
import com.liantuo.deposit.advanceaccount.web.inner.vo.req.SingleAccountHisPageQueryReqVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountHisPageQueryRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisQueryReqVo;

//import com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo;
//import com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountHisPageQueryRspVo;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BusinessUncheckedException;

public interface CreditAccountTradeHistoryService {
	/**
	 * @方法名: insertCaTradeHistory
	 * @方法说明: 记笔账务流水
	 * @param vo
	 * @param creditAccount
	 * @return
	 * @返回类型 AccountingRecord
	 * @创建人: bjl
	 * @创建时间: 2015年12月16日 下午3:04:19
	 */
	public AccountingRecord insertCaTradeHistory(RealTimeAccountingVo vo,CreditAccount creditAccount
			,Date balLastChangeTime) throws BusinessUncheckedException;
	
	/**
	 * @方法名: insertOldCaTradeHistory
	 * @方法说明: 维护老版账务流水
	 * @param creditAccountTradeHistory
	 * @param creditAccount
	 * @param vo
	 * @返回类型 CreditAccountTradeHistory
	 * @创建人: bjl
	 * @创建时间: 2015年12月16日 下午4:18:10
	 */
	public CreditAccountTradeHistory insertOldCaTradeHistory(CreditAccountTradeHistory creditAccountTradeHistory
			,CreditAccount creditAccount,RealTimeAccountingVo vo) throws NumberFormatException, AmountConvertException;
	
	/**
	 * @方法名: singleAccountHisPageQuery
	 * @方法说明: 单账户账务历史查询接口
	 * @param vo
	 * @return
	 * @返回类型 SingleAccountHisPageQueryRspVo
	 * @创建人: bjl
	 * @创建时间: 2016年1月9日 下午11:40:15
	 */
	public com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountHisPageQueryRspVo singleAccountHisPageQuery(com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo vo);
	
	/**
	 * @方法名: 单账户账务历史查询接口(内部接口)
	 * @方法说明:
	 * @param vo
	 * @return
	 * @返回类型 SingleAccountHisPageQueryRspVo
	 * @创建人: bjl
	 * @创建时间: 2016年2月25日 下午2:22:46
	 */
	public SingleAccountHisPageQueryRspVo innerSingleCAHisPageQuery(SingleAccountHisPageQueryReqVo vo);

	/**
	 * 
	* @Title: singleAccountHisPageQueryStand 
	* @Description: 单账户查询(标准版)
	* @param @param req
	* @param @return
	* @return List<SingleAccountAccountRecord>
	* @throws 
	* @author shihb
	* @date 2016-4-28 下午3:18:39
	 */
	public List<SingleAccountAccountRecord> singleAccountHisPageQueryStand(SingleAccountHisQueryReqVo req);

	/**
	 * 
	* @Title: countSingleAccountHisQuery 
	* @Description: 统计总数
	* @param @param req
	* @param @return
	* @return Integer
	* @throws 
	* @author shihb
	* @date 2016-4-28 下午3:19:01
	 */
	public Integer countSingleAccountHisQuery(SingleAccountHisQueryReqVo req);
}
