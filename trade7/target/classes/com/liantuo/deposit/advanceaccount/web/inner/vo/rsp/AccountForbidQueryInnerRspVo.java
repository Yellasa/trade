package com.liantuo.deposit.advanceaccount.web.inner.vo.rsp;

import java.util.List;

import com.liantuo.deposit.advanceaccount.web.vo.rsp.AccountForbidRspVo;

public class AccountForbidQueryInnerRspVo extends DepositRsp{
	private List<AccountForbidRspVo> list;

	public List<AccountForbidRspVo> getList() {
		return list;
	}

	public void setList(List<AccountForbidRspVo> list) {
		this.list = list;
	}
}
