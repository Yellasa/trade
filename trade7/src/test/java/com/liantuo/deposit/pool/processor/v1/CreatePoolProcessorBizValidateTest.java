package com.liantuo.deposit.pool.processor.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;
import org.unitils.spring.annotation.SpringBean;

import com.alibaba.fastjson.JSON;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode005Constants;
import com.liantuo.deposit.pool.bus.service.PoolService;
import com.liantuo.deposit.pool.processor.v1.CreatePoolProcessor;
import com.liantuo.deposit.pool.processor.v1.vo.CreatePoolReqVO;
import com.liantuo.deposit.pool.processor.v1.vo.CreatePoolRspVO;
import com.liantuo.unittest.BaseProcessorTest;
import com.liantuo.unittest.mockito.IsTClass;

/**
 * @author dengll
 *
 */
public class CreatePoolProcessorBizValidateTest  extends BaseProcessorTest{

	@SpringBean("dep_0_005_1.0")
	private CreatePoolProcessor createPoolProcessor;
	private PoolService poolService;

	@Before
	public void init() {
		poolService = mock(PoolService.class);
		ReflectionTestUtils.setField(createPoolProcessor, "poolService",
				poolService);
	}
	@Test
	public void testBizValidatePoolNotExist() {

		CreatePoolReqVO req = new CreatePoolReqVO("123456", "123456",
				"12345678901234567", "123456");

		doReturn(null).when(poolService).findByMerchantNoAndPoolName(
				argThat(new IsTClass<PoolQueryVo>(new PoolQueryVo())));

		CreatePoolRspVO rsp = (CreatePoolRspVO) createPoolProcessor
				.bizValidate(req);

		verify(poolService, times(1)).findByMerchantNoAndPoolName(
				argThat(new IsTClass<PoolQueryVo>(new PoolQueryVo())));
		LOGGER.info("接口返回结果：{}", JSON.toJSONString(rsp));
		assertNull("创建资金池业务验证应该通过！", rsp);
	}

	@Test
	public void testBizValidatePoolExist() {

		CreatePoolReqVO req = new CreatePoolReqVO("123456", "123456",
				"12345678901234567", "123456");

		doReturn(new PoolRspVo()).when(poolService)
				.findByMerchantNoAndPoolName(
						argThat(new IsTClass<PoolQueryVo>(new PoolQueryVo())));

		CreatePoolRspVO rsp = (CreatePoolRspVO) createPoolProcessor
				.bizValidate(req);

		verify(poolService, times(1)).findByMerchantNoAndPoolName(
				argThat(new IsTClass<PoolQueryVo>(new PoolQueryVo())));

		LOGGER.info("接口返回结果：{}", JSON.toJSONString(rsp));
		assertNotNull("创建资金池业务验证应该失败！", rsp);
		assertNull("创建资金池返回结果Pool对象应该为空！", rsp.getPool());
		assertEquals("创建资金池资金池名称重复返回结果retCode错误", ErrorCode005Constants.POOL_OPEN_NAME_REPEAT, rsp.getRetCode());
		assertEquals("创建资金池资金池名称重复返回结果retInfo错误", "资金池名称重复", rsp.getRetInfo());
		assertEquals("请求参数转换结果创建资金池资金池名称重复返回结果success错误池编号错误", "F", rsp.getSuccess());
		
	}
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CreatePoolProcessorBizValidateTest.class);
}
