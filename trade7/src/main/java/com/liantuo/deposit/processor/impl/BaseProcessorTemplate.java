package com.liantuo.deposit.processor.impl;

import java.util.Map;

import com.liantuo.deposit.processor.DepRequestProcessor;
import com.liantuo.deposit.web.vo.DepRsp;
import com.liantuo.deposit.web.vo.DepReq;

public abstract class BaseProcessorTemplate<T extends DepReq> implements
		DepRequestProcessor {

	public final DepRsp process(Map<String, String> param) {
		DepRsp rsp = null;

		T t = convert(param);
		rsp = validate(t);

		if (rsp == null) {
			rsp = bizProcess(t);
		}

		return rsp;
	}

	/**
	 * 参数格式验证和业务验证，验证通过时返回null,不通过时返回含错误描述的对象
	 * 
	 * @param req
	 * @return
	 */
	private DepRsp validate(T req) {
		DepRsp rsp = req.validate();
		if (rsp == null) {
			rsp = bizValidate(req);
		}
		return rsp;
	}

	/**
	 * 业务校验验证通过时返回null,不通过时返回含错误描述的对象
	 * 
	 * @param req
	 * @return
	 */
	 protected abstract DepRsp bizValidate(T req);

	/**
	 * 输入参数转换为请求对象
	 * 
	 * @param param
	 * @return
	 */
	protected abstract T convert(Map<String, String> param);

	/**
	 * 业务逻辑处理
	 * 
	 * @param req
	 * @return
	 */
	protected abstract DepRsp bizProcess(T req);

}
