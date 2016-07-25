package com.liantuo.deposit.pool.processor.v1.vo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode005Constants;

/**
 * 创建资金池接口参数个数验证单元测试
 * 
 * @author dengll
 *
 */
public class CreatePoolReqValidateVOTest {
	@Test
	public void testValidateNormal() {
		CreatePoolReqVO req = new CreatePoolReqVO("adfd", "大大小小多多少少",
				"12345678901234567", "98765432109876543210");

		CreatePoolRspVO rsp = (CreatePoolRspVO) req.validate();
		LOGGER.info(JSON.toJSONString(rsp));
		assertNull(rsp);
	}

	@Test
	public void testValidatePartnerIdIsNotNumber() {
		CreatePoolReqVO req = new CreatePoolReqVO("adfd", "大大小小多多少少",
				"1a345678901%34567", "98765432109876543210");

		CreatePoolRspVO rsp = (CreatePoolRspVO) req.validate();
		assertNotNull(rsp);
		LOGGER.info(JSON.toJSONString(rsp));
		assertEquals("success 错误", "F", rsp.getSuccess());
		assertEquals("retCode 错误",
				ErrorCode005Constants.POOL_OPEN_CHECK_NOT_PASS,
				rsp.getRetCode());
		assertEquals("retInfo 错误", "格式校验未通过:partner_id format error；",
				rsp.getRetInfo());
	}

	@Test
	public void testValidateAllParamIsNull() {
		CreatePoolReqVO req = new CreatePoolReqVO(null, null, null, null);

		CreatePoolRspVO rsp = (CreatePoolRspVO) req.validate();
		assertNotNull(rsp);
		LOGGER.info(JSON.toJSONString(rsp));
		assertEquals("success 错误", "F", rsp.getSuccess());
		assertEquals("retCode 错误",
				ErrorCode005Constants.POOL_OPEN_CHECK_NOT_PASS,
				rsp.getRetCode());
		assertEquals(
				"retInfo 错误",
				("格式校验未通过:core_merchant_no is required；"
						+ "partner_id is required；"
						+ "pool_name is required；").length(), rsp.getRetInfo()
						.length());
	}

	@Test
	public void testValidateAllParamIsBlank() {
		CreatePoolReqVO req = new CreatePoolReqVO("", "", "", "");

		CreatePoolRspVO rsp = (CreatePoolRspVO) req.validate();
		assertNotNull(rsp);
		LOGGER.info(JSON.toJSONString(rsp));
		assertEquals("success 错误", "F", rsp.getSuccess());
		assertEquals("retCode 错误",
				ErrorCode005Constants.POOL_OPEN_CHECK_NOT_PASS,
				rsp.getRetCode());
		assertEquals("retInfo 错误", ("格式校验未通过:core_merchant_no is required；"
				+ "core_merchant_no format error；" + "pool_name is required；"
				+ "pool_name format error；" + "partner_id format error；"
				+ "partner_id is required；").length(), rsp.getRetInfo().length());
	}

	@Test
	public void testValidateAllParamLessThanMinLength() {
		CreatePoolReqVO req = new CreatePoolReqVO("a", "", "1", "");

		CreatePoolRspVO rsp = (CreatePoolRspVO) req.validate();
		assertNotNull(rsp);
		LOGGER.info(JSON.toJSONString(rsp));
		assertEquals("success 错误", "F", rsp.getSuccess());
		assertEquals("retCode 错误",
				ErrorCode005Constants.POOL_OPEN_CHECK_NOT_PASS,
				rsp.getRetCode());
		assertEquals("retInfo 错误", ("格式校验未通过:partner_id format error；"
				+ "core_merchant_no format error；" + "pool_name format error；"
				+ "pool_name is required；").length(), rsp.getRetInfo().length());
	}

	@Test
	public void testValidateAllParamGreaterThanMaxLength() {
		CreatePoolReqVO req = new CreatePoolReqVO(
				"123456789012345678901234567890123",
				"12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789",
				"123456789012345678",
				"12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "12345678901234567890123456789012345678901234567890"
						+ "1234567890123");

		CreatePoolRspVO rsp = (CreatePoolRspVO) req.validate();
		assertNotNull(rsp);
		LOGGER.info(JSON.toJSONString(rsp));
		assertEquals("success 错误", "F", rsp.getSuccess());
		assertEquals("retCode 错误",
				ErrorCode005Constants.POOL_OPEN_CHECK_NOT_PASS,
				rsp.getRetCode());
		assertEquals("retInfo 错误", ("格式校验未通过:core_merchant_no format error；"
				+ "rmk format error；" + "partner_id format error；"
				+ "pool_name format error；").length(), rsp.getRetInfo().length());
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CreatePoolReqValidateVOTest.class);
}
