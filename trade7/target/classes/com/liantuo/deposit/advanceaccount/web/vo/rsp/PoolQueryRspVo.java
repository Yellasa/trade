package com.liantuo.deposit.advanceaccount.web.vo.rsp;

import java.util.List;

public class PoolQueryRspVo extends DepositRsp{
	/**
	* @字段名 totalResult : 数据总条数
	*/
	private String totalResult;
	private List<PoolRspVo> list;
	public String getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(String totalResult) {
		this.totalResult = totalResult;
	}
	public List<PoolRspVo> getList() {
		return list;
	}
	public void setList(List<PoolRspVo> list) {
		this.list = list;
	}
	
}
