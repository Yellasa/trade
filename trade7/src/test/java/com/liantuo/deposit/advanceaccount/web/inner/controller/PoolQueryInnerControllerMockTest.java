package com.liantuo.deposit.advanceaccount.web.inner.controller;

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

import com.liantuo.deposit.advanceaccount.web.inner.vo.req.PoolQueryInnerReqVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.PoolInnerRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.PoolQueryReqVo;
import com.liantuo.deposit.pool.bus.service.PoolService;
import com.liantuo.deposit.pool.bus.service.PoolServiceMock;
import com.liantuo.unittest.BaseProcessorTest;

public class PoolQueryInnerControllerMockTest extends BaseProcessorTest{
	
	private PoolQueryInnerController poolQueryInnerController = new PoolQueryInnerController();
	@Mock
	private PoolService poolService;
	
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(poolQueryInnerController, "poolService", poolService);
	}
	
	
	/**
	 * 
	 * @Description: 资金池查询controller 正常返回
	 * @author JiangKun
	 * @date 2016年7月1日 上午11:29:52
	 */
	@Test
	public void testPoolQueryInnerCase1(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		PoolQueryInnerReqVo req = new PoolQueryInnerReqVo();
		
		req.setCoreMerchantNo("liantuo");
		req.setPoolName("北京联拓天际电子商务有限公司");
		req.setPoolNo("PN01000000000000761");
		req.setCurrentPage("1");
		req.setShowCount("10");
		List<PoolInnerRspVo> list = new ArrayList<PoolInnerRspVo>();
		int count = 1;
		
		PoolServiceMock.mockFindPoolsQueryInner(poolService, list);
		PoolServiceMock.mockFindPoolsQueryInnerAccount(poolService, count);
		
		poolQueryInnerController.poolQuery(request, response, req);	
	}
	
	
	/**
	 * 
	 * @Description: 资金池查询controller 请求参数校验不通过
	 * @author JiangKun
	 * @date 2016年7月1日 上午11:29:52
	 */
	@Test
	public void testPoolQueryInnerCase2(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		PoolQueryInnerReqVo req = new PoolQueryInnerReqVo();
		
		req.setCoreMerchantNo("liantuo");
		req.setPoolName("北京联拓天际电子商务有限公司超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度超出长度");
		req.setPoolNo("PN01000000000000761");
		req.setCurrentPage("1");
		req.setShowCount("10");
		List<PoolInnerRspVo> list = new ArrayList<PoolInnerRspVo>();
		int count = 1;
		
		PoolServiceMock.mockFindPoolsQueryInner(poolService, list);
		PoolServiceMock.mockFindPoolsQueryInnerAccount(poolService, count);
		
		poolQueryInnerController.poolQuery(request, response, req);	
	}
	
	
	/**
	 * 
	 * @Description: 资金池查询controller 方法跑出异常返回
	 * @author JiangKun
	 * @date 2016年7月1日 上午11:29:52
	 */
	@Test
	public void testPoolQueryInnerCase3(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		PoolQueryInnerReqVo req = new PoolQueryInnerReqVo();
		
		req.setCoreMerchantNo("liantuo");
		req.setPoolName("北京联拓天际电子商务有限公司");
		req.setPoolNo("PN01000000000000761");
		List<PoolInnerRspVo> list = new ArrayList<PoolInnerRspVo>();
		int count = 1;
		
		PoolServiceMock.mockFindPoolsQueryInnerRuntimeException(poolService, list);
		PoolServiceMock.mockFindPoolsQueryInnerAccount(poolService, count);
		
		poolQueryInnerController.poolQuery(request, response, req);	
	}
	
	
	
	/**
	 * 
	 * @Description: 资金池查询controller 资金池编号错误的时候     方法抛出异常BusinessUncheckedException
	 * @author JiangKun
	 * @date 2016年7月1日 上午11:29:52
	 */
	@Test
	public void testPoolQueryInnerCase4(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		PoolQueryInnerReqVo req = new PoolQueryInnerReqVo();
		
		req.setCoreMerchantNo("liantuo");
		req.setPoolName("北京联拓天际电子商务有限公司");
		req.setPoolNo("P");//资金池编号错误的时候
		List<PoolInnerRspVo> list = new ArrayList<PoolInnerRspVo>();
		int count = 1;
		
		PoolServiceMock.mockFindPoolsQueryInner(poolService, list);
		PoolServiceMock.mockFindPoolsQueryInnerAccount(poolService, count);
		
		poolQueryInnerController.poolQuery(request, response, req);	
	}
	
	/**
	 * 
	 * @Description: 资金池查询controller 方法抛出异常BusinessUncheckedException
	 * @author JiangKun
	 * @date 2016年7月1日 上午11:29:52
	 */
	@Test
	public void testPoolQueryInnerCase5(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		PoolQueryInnerReqVo req = new PoolQueryInnerReqVo();
		
		req.setCoreMerchantNo("liantuo");
		req.setPoolName("北京联拓天际电子商务有限公司");
		req.setPoolNo("PN01000000000000761");//资金池编号错误的时候
		List<PoolInnerRspVo> list = new ArrayList<PoolInnerRspVo>();
		int count = 1;
		
		PoolServiceMock.mockFindPoolsQueryInner(poolService, list);
		PoolServiceMock.mockFindPoolsQueryInnerAccount(poolService, count);
		
		poolQueryInnerController.poolQuery(request, response, req);	
	}
	
}
