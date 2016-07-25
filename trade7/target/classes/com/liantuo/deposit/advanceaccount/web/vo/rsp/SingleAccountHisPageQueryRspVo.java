package com.liantuo.deposit.advanceaccount.web.vo.rsp;

import java.util.List;


/**
 * @类名: SingleAccountHisPageQueryRspVo
 * @类说明: 单账户账务历史查询接口回参(服务端)
 * @版本号 V1.0
 * @版权 Copyright © 2013-2016 合肥联拓金融信息服务有限公司
 * @创建人: bjl
 * @创建时间: 2016年1月8日 下午2:49:48
 *
 * 修改日期    修改者     版本      修改原因说明<br>
 * -----------------------------------------------------------------------------------<br>
 *                       <br>
 * -----------------------------------------------------------------------------------<br>
 */
public class SingleAccountHisPageQueryRspVo  extends DepositRsp{
	
	
	/**
	* @字段名 totalResult : 数据总条数
	*/
	private String totalResult;
	
	/**
	* @字段名 list : 账务历史
	*/
	private List<SingleAccountAccountingRecord> list;

	public List<SingleAccountAccountingRecord> getList() {
		return list;
	}

	public void setList(List<SingleAccountAccountingRecord> list) {
		this.list = list;
	}

	public String getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(String totalResult) {
		this.totalResult = totalResult;
	}
}
