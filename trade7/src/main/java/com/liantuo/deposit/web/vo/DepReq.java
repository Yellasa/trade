package com.liantuo.deposit.web.vo;

public interface DepReq {
	 /**
	  * 格式验证，验证通过时返回null,不通过时返回含错误描述的对象
	 * @return
	 */
	DepRsp validate();
}
