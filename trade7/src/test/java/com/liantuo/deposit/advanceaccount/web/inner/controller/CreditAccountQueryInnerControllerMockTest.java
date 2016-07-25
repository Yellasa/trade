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

import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountService;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountServiceMock;
import com.liantuo.deposit.advanceaccount.web.inner.vo.req.CreditAccountPageQueryInnerReqVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.returnvo.CreditAccountInnerVo;

public class CreditAccountQueryInnerControllerMockTest {
	
	private CreditAccountQueryInnerController creditAccountQueryInnerController = new CreditAccountQueryInnerController();
	@Mock
	private CreditAccountService creditAccountService; 
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(creditAccountQueryInnerController, "creditAccountService", creditAccountService);
	}
	
	
	/**
	 * 
	 * @Description: 查询账户（内部接口）--正常情况
	 * @author JiangKun
	 * @date 2016年7月1日 下午5:37:15
	 */
	@Test
	public void testAccountQueryCase1(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		CreditAccountPageQueryInnerReqVo req = new CreditAccountPageQueryInnerReqVo();

		req.setCoreMerchantNo("liantuo");
		req.setAccountNo("CA10073122120000");
		req.setAccountName("北京联拓结算账户");
		req.setPoolNo("PN01000000000000761");
		List<CreditAccountInnerVo> list = new ArrayList<CreditAccountInnerVo>();
		int count = 1;
		CreditAccountServiceMock.mockFindAccountsInnerQuery(creditAccountService, list);
		CreditAccountServiceMock.mockFindAccountsInnerQueryCount(creditAccountService, count);
		creditAccountQueryInnerController.accountQuery(request, response, req);
	}
	
	/**
	 * 
	 * @Description: 查询账户（内部接口）--参数校验不通过
	 * @author JiangKun
	 * @date 2016年7月1日 下午5:37:15
	 */
	@Test
	public void testAccountQueryCase2(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		CreditAccountPageQueryInnerReqVo req = new CreditAccountPageQueryInnerReqVo();

		req.setCoreMerchantNo("l");
		req.setAccountNo("CA10073122120000");
		req.setAccountName("北京联拓结算账户");
		req.setPoolNo("PN01000000000000761");
		List<CreditAccountInnerVo> list = new ArrayList<CreditAccountInnerVo>();
		int count = 1;
		CreditAccountServiceMock.mockFindAccountsInnerQuery(creditAccountService, list);
		CreditAccountServiceMock.mockFindAccountsInnerQueryCount(creditAccountService, count);
		creditAccountQueryInnerController.accountQuery(request, response, req);
	}
	
	/**
	 * 
	 * @Description: 查询账户（内部接口）--异常情况
	 * @author JiangKun
	 * @date 2016年7月1日 下午5:37:15
	 */
	@Test
	public void testAccountQueryCase3(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		CreditAccountPageQueryInnerReqVo req = new CreditAccountPageQueryInnerReqVo();

		req.setCoreMerchantNo("liantuo");
		req.setAccountNo("CA10073122120000");
		req.setAccountName("北京联拓结算账户");
		req.setPoolNo("PN01000000000000761");
		List<CreditAccountInnerVo> list = new ArrayList<CreditAccountInnerVo>();
		int count = 1;
		CreditAccountServiceMock.mockFindAccountsInnerQueryException(creditAccountService, list);
		CreditAccountServiceMock.mockFindAccountsInnerQueryCount(creditAccountService, count);
		creditAccountQueryInnerController.accountQuery(request, response, req);
	}
	
}
