package com.liantuo.deposit.processor;

import java.util.Map;

import com.liantuo.deposit.web.vo.DepRsp;

public interface DepRequestProcessor {
	public DepRsp process(Map<String,String> param);
}
