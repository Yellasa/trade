package com.liantuo.deposit.advanceaccount.web.vo.rsp;

import java.util.List;

public class SingleAccountHisQueryRspVo extends DepositRsp{
	/**
	* @字段名 totalResult : 数据总条数
	*/
	private String totalResult;
	private List<SingleAccountAccountingHistoryRecord> list;
	public String getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(String totalResult) {
		this.totalResult = totalResult;
	}
	public List<SingleAccountAccountingHistoryRecord> getList() {
		return list;
	}
	public void setList(List<SingleAccountAccountingHistoryRecord> list) {
		this.list = list;
	}
 
}
