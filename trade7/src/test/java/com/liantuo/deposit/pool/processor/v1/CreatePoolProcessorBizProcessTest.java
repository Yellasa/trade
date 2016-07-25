package com.liantuo.deposit.pool.processor.v1;

import static org.junit.Assert.*;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;
import org.unitils.spring.annotation.SpringBean;

import com.alibaba.fastjson.JSON;
import com.ebill.framework.exception.BusinessException;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.common.constants.errorcode.SystemErrorCode;
import com.liantuo.deposit.pool.bus.service.PoolService;
import com.liantuo.deposit.pool.bus.service.PoolServiceMock;
import com.liantuo.deposit.pool.processor.v1.vo.CreatePoolReqVO;
import com.liantuo.deposit.pool.processor.v1.vo.CreatePoolRspVO;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdbMock;
import com.liantuo.unittest.BaseProcessorTest;
import com.liantuo.unittest.mockito.IsTClass;

/**
 * @author dengll
 *
 */
public class CreatePoolProcessorBizProcessTest  extends BaseProcessorTest{

	@SpringBean("dep_0_005_1.0")
	private CreatePoolProcessor createPoolProcessor;
	
	private PoolService poolService;
	private StepSequenceFactoryForSpdb idFactoryPoolNo;

	@Before
	public void init() {
		poolService = mock(PoolService.class);
		idFactoryPoolNo = mock(StepSequenceFactoryForSpdb.class);
		ReflectionTestUtils.setField(createPoolProcessor, "poolService",
				poolService);
		ReflectionTestUtils.setField(createPoolProcessor, "idFactoryPoolNo",
				idFactoryPoolNo);
	}

	@Test
	public void testBizProcessSuccess() throws BusinessException {
		Pool record = new Pool();
		
		PoolServiceMock.mockCreatePool(poolService, record);		
		StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryPoolNo, "123456");

		CreatePoolReqVO req = new CreatePoolReqVO("123456", "123456",
				"12345678901234567", "123456");

		CreatePoolRspVO rsp = (CreatePoolRspVO) createPoolProcessor
				.bizProcess(req);

		
		verify(poolService, times(1)).createPool(
				argThat(new IsTClass<Pool>(record)));
		verify(idFactoryPoolNo, times(1)).generate();
		
		LOGGER.info("接口返回结果：{}", JSON.toJSONString(rsp));

		assertNotNull("创建资金池返回结果应该为非空！", rsp);
		assertEquals("创建资金池返回结果success错误！", "S",rsp.getSuccess());
	}
	
	@Test
	public void testBizProcessFail() throws BusinessException {
		Pool record = new Pool();
		
		PoolServiceMock.mockCreatePool(poolService,  new BusinessException(SystemErrorCode.UNKNOWN_EXCEPTION,"系统异常"));		
		StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryPoolNo, "123456");

		CreatePoolReqVO req = new CreatePoolReqVO("123456", "123456",
				"12345678901234567", "123456");

		CreatePoolRspVO rsp = (CreatePoolRspVO) createPoolProcessor
				.bizProcess(req);

		
		verify(poolService, times(1)).createPool(
				argThat(new IsTClass<Pool>(record)));
		verify(idFactoryPoolNo, times(1)).generate();
		
		LOGGER.info("接口返回结果：{}", JSON.toJSONString(rsp));

		assertNotNull("创建资金池返回结果应该为非空！", rsp);
		assertEquals("创建资金池返回结果success错误！", "F",rsp.getSuccess());
		assertEquals("创建资金池返回结果success错误！", SystemErrorCode.UNKNOWN_EXCEPTION,rsp.getRetCode());
		assertEquals("创建资金池返回结果success错误！", "系统异常",rsp.getRetInfo());
	}
	
	
	

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CreatePoolProcessorBizProcessTest.class);
}
