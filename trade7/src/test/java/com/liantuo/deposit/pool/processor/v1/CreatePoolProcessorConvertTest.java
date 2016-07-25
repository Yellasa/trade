package com.liantuo.deposit.pool.processor.v1;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.liantuo.deposit.pool.processor.v1.vo.CreatePoolReqVO;

public class CreatePoolProcessorConvertTest {

	private CreatePoolProcessor createPoolProcessor=new CreatePoolProcessor();
	@Test
	public void testConvertNull() {
		CreatePoolReqVO req = createPoolProcessor.convert(null);
		assertNull("请求参数转换结果应该是空", req);
	}

	@Test
	public void testConvertErrorKey() {
		CreatePoolReqVO req = createPoolProcessor
				.convert(new HashMap<String, String>());
		assertNotNull("请求参数转换结果应该是非空", req);
		assertNull("请求参数转换结果核心商户编号应该是空", req.getCoreMerchantNo());
		assertNull("请求参数转换结果商户合作号应该是空", req.getPartnerId());
		assertNull("请求参数转换结果资金池编号应该是空", req.getPoolName());
		assertNull("请求参数转换结果备注应该是空", req.getRmk());
	}

	@Test
	public void testConvertAllKeyNotNull() {
		Map<String, String> param = new HashMap<String, String>();
		param.put("coreMerchantNo", "1234123");
		param.put("poolName", "1234123");
		param.put("partnerId", "1234123");
		param.put("rmk", "1234123");
		CreatePoolReqVO req = createPoolProcessor.convert(param);

		assertNotNull("请求参数转换结果应该是非空", req);
		assertEquals("请求参数转换结果核心商户编号错误", "1234123", req.getCoreMerchantNo());
		assertEquals("请求参数转换结果商户合作号错误", "1234123", req.getPartnerId());
		assertEquals("请求参数转换结果资金池编号错误", "1234123", req.getPoolName());
		assertEquals("请求参数转换结果备注错误", "1234123", req.getRmk());

	}
	
}
