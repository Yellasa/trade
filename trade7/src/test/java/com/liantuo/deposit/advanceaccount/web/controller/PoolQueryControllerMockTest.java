package com.liantuo.deposit.advanceaccount.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;

import com.liantuo.deposit.advanceaccount.web.vo.req.PoolQueryReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.deposit.pool.bus.service.PoolService;
import com.liantuo.deposit.pool.bus.service.PoolServiceMock;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import com.liantuo.unittest.BaseProcessorTest;

public class PoolQueryControllerMockTest extends BaseProcessorTest{
	
	
	
	private PoolQueryController poolQueryController = new PoolQueryController();
	@Mock
	private PoolService poolService;
//	@Mock
//	private StepSequenceFactoryForSpdb idFactoryPoolNo;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(poolQueryController, "poolService", poolService);
//		ReflectionTestUtils.setField(poolQueryController, "idFactoryPoolNo", idFactoryPoolNo);
	}
	
	/**
	 * 
	 * @Description: 资金池查询controller 正常返回
	 * @author JiangKun
	 * @date 2016年6月30日 下午4:22:29
	 */
	@Test
	public void testPoolQueryCase1(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		PoolQueryReqVo req = new PoolQueryReqVo();
		req.setPartnerId("12345678901234567");
		req.setCoreMerchantNo("liantuo");
		req.setPoolName("北京联拓天际电子商务有限公司");
		req.setPoolNo("PN01000000000000761");
		req.setCurrentPage("1");
		req.setShowCount("10");
		List<PoolRspVo> list = new ArrayList<PoolRspVo>();
		int count = 1;
		
		PoolServiceMock.mockFindPoolsQuery(poolService, list);
		PoolServiceMock.mockFindPoolsQueryAccount(poolService, count);
		
		poolQueryController.poolQuery(request, response, req);	
	}
	
	/**
	 * 
	 * @Description: 资金池查询controller 请求参数校验不通过
	 * @author JiangKun
	 * @date 2016年6月30日 下午4:22:29
	 */
	@Test
	public void testPoolQueryCase2(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		PoolQueryReqVo req = new PoolQueryReqVo();
		req.setPartnerId("123456789012345");//要求17位，这里15位，参数校验不通过
		req.setCoreMerchantNo("liantuo");
		req.setPoolName("北京联拓天际电子商务有限公司");
		req.setPoolNo("PN01000000000000761");
		List<PoolRspVo> list = new ArrayList<PoolRspVo>();
		int count = 1;
		
		PoolServiceMock.mockFindPoolsQuery(poolService, list);
		PoolServiceMock.mockFindPoolsQueryAccount(poolService, count);
		poolQueryController.poolQuery(request, response, req);	
		
	}
	
	/**
	 * 
	 * @Description: 资金池查询controller 抛出异常被捕获
	 * @author JiangKun
	 * @date 2016年6月30日 下午4:22:29
	 */
	@Test
	public void testPoolQueryCase3(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		PoolQueryReqVo req = new PoolQueryReqVo();
		req.setPartnerId("12345678901234567");//要求17位，这里15位，参数校验不通过
		req.setCoreMerchantNo("liantuo");
		req.setPoolName("北京联拓天际电子商务有限公司");
		req.setPoolNo("PN01000000000000761");
		List<PoolRspVo> list = null;
		int count = 1;
		
		PoolServiceMock.mockFindPoolsQueryException(poolService, list);
		PoolServiceMock.mockFindPoolsQueryAccount(poolService, count);
		poolQueryController.poolQuery(request, response, req);
	}
	



}
