package com.liantuo.mc.web.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.alibaba.fastjson.JSON;
import com.liantuo.mc.web.req.MerchantOutRequest;
import com.liantuo.mc.web.rsp.MerchantResponse;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MerchantClient.class})
public class MerchantClientTest {

	@Test
	public void testGetMerchant() {
		MerchantResponse response = new MerchantResponse();
		response.setErrorCode("sdfdsf");
		response.setMerchantCode("sdfadf");

		MerchantClientMock.mockGetMerchant(response);
		System.out.println(JSON.toJSONString(MerchantClient
				.getMerchant(new MerchantOutRequest())));
		
	}
}
