package com.liantuo.deposit.web.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.ebill.framework.res.JsonUtil;
import com.liantuo.deposit.common.constants.ErrorCode001Constants;
import com.liantuo.deposit.processor.DepRequestProcessorFactory;
import com.liantuo.deposit.web.vo.DepRsp;

@Controller
@RequestMapping(value = "/api/depservice")
public class DepositBizController {

	@RequestMapping(value = "/{requestCode}/{version}", method = RequestMethod.POST)
	public void process(HttpServletRequest request,
			HttpServletResponse response,
			@PathVariable("requestCode") String requestCode,
			@PathVariable("version") String version) {
		DepRsp rsp = null;
		Map<String, String> param = getParameterMap(request);
		try {
			LOGGER.info("账务模块处理请求，请求代码：{}，版本号：{}，请求内容{}", requestCode, version,
					JSON.toJSONString(param));

			rsp = DepRequestProcessorFactory
					.getProccessor(requestCode, version).process(param);

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			rsp = new DepRsp();
			rsp.fail(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
		}

		String dataType = param.get("dataType");

		if (dataType == null || dataType.equalsIgnoreCase("json")) {
			try {
				LOGGER.info("账务模块处理请求返回结果，请求代码：{}，版本号：{}，数据类型：{}，返回内容：{}",
						requestCode, version, dataType, JSON.toJSONString(rsp));
				
				response.getWriter().write(JsonUtil.object2String(rsp));//客户端仍然使用JsonUtil
			} catch (Exception e) {
				LOGGER.error("接口返回结果失败！" + e.getMessage(), e);
			}
		}

	}

	private static Map<String, String> getParameterMap(
			HttpServletRequest request) {
		// 参数Map
		Map<?, ?> properties = request.getParameterMap();
		// 返回值Map
		Map<String, String> returnMap = new HashMap<String, String>();

		Iterator<?> entries = properties.entrySet().iterator();
		Map.Entry<?, ?> entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry<?, ?>) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}

	private Logger LOGGER = LoggerFactory.getLogger(DepositBizController.class);
}
