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

import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountService;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountServiceMock;
import com.liantuo.deposit.advanceaccount.web.vo.req.CreditAccountPageQueryReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.returnvo.CreditAccountVo;

public class CreditAccountQueryControllerMockTest {

	private CreditAccountQueryController creditAccountQueryController = new CreditAccountQueryController();
	@Mock
	private CreditAccountService creditAccountService;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(creditAccountQueryController, "creditAccountService", creditAccountService);
	}
	
	/**
	 * 
	 * @Description: 账户查询-正常情况
	 * @author JiangKun
	 * @date 2016年7月1日 下午4:55:18
	 */
	@Test
	public void testAccountQueryCase1(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		CreditAccountPageQueryReqVo req = new CreditAccountPageQueryReqVo();
		req.setPartnerId("12345678901234567");
		req.setCoreMerchantNo("liantuo");
		req.setAccountNo("CA10073122120000");
		req.setAccountName("北京联拓结算账户");
		req.setPoolNo("PN01000000000000761");
		List<CreditAccountVo> list = new ArrayList<CreditAccountVo>();
		int count = 1;
		CreditAccountServiceMock.mockFindAccountsQuery(creditAccountService, list);
		CreditAccountServiceMock.mockFindAccountsQueryCount(creditAccountService, count);

		creditAccountQueryController.accountQuery(request, response, req);
		
	}
	
	/**
	 * 
	 * @Description: 账户查询-参数校验不通过
	 * @author JiangKun
	 * @date 2016年7月1日 下午4:55:18
	 */
	@Test
	public void testAccountQueryCase2(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		CreditAccountPageQueryReqVo req = new CreditAccountPageQueryReqVo();
		req.setPartnerId("123456789012345");
		req.setCoreMerchantNo("liantuo");
		req.setAccountNo("CA10073122120000");
		req.setAccountName("北京联拓结算账户");
		req.setPoolNo("PN01000000000000761");
		List<CreditAccountVo> list = new ArrayList<CreditAccountVo>();
		int count = 1;
		CreditAccountServiceMock.mockFindAccountsQuery(creditAccountService, list);
		CreditAccountServiceMock.mockFindAccountsQueryCount(creditAccountService, count);

		creditAccountQueryController.accountQuery(request, response, req);
		
	}
	
	
	/**
	 * 
	 * @Description: 账户查询-异常情况   Exception
	 * @author JiangKun
	 * @date 2016年7月1日 下午4:55:18
	 */
	@Test
	public void testAccountQueryCase3(){
		HttpServletRequest request = null;
		HttpServletResponse response = new MockHttpServletResponse();
		CreditAccountPageQueryReqVo req = new CreditAccountPageQueryReqVo();
		req.setPartnerId("12345678901234567");
		req.setCoreMerchantNo("liantuo");
		req.setAccountNo("CA10073122120000");
		req.setAccountName("北京联拓结算账户");
		req.setPoolNo("PN01000000000000761");
		List<CreditAccountVo> list = new ArrayList<CreditAccountVo>();
		int count = 1;
		CreditAccountServiceMock.mockFindAccountsQueryException(creditAccountService, list);
		CreditAccountServiceMock.mockFindAccountsQueryCount(creditAccountService, count);

		creditAccountQueryController.accountQuery(request, response, req);
		
	}
}
