package com.liantuo.deposit.advanceaccount.web.inner.vo.rsp;

import java.util.List;

public class PoolQueryInnerRspVo extends DepositRsp{
	/**
	* @字段名 totalResult : 数据总条数
	*/
	private String totalResult;
	private List<PoolInnerRspVo> list;
	public String getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(String totalResult) {
		this.totalResult = totalResult;
	}
	public List<PoolInnerRspVo> getList() {
		return list;
	}
	public void setList(List<PoolInnerRspVo> list) {
		this.list = list;
	}
	
}
