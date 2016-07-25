package com.liantuo.deposit.advanceaccount.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.util.ReflectionTestUtils;

import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountService;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountServiceMock;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.advanceaccount.web.vo.req.OpenCreditAccountReqVo;

public class OpenAdvanceAccountControllerMockTest {
	
	private OpenAdvanceAccountController openAdvanceAccountController = new OpenAdvanceAccountController();
	
	@Mock
	private CreditAccountService creditAccountService;
	
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(openAdvanceAccountController, "creditAccountService", creditAccountService);
		
	}
	
	
	
	/**
	 * 
	 * @Description: 开户正常case 
	 * @author JiangKun
	 * @date 2016年7月1日 下午3:42:55
	 */
	@Test
	public void testOpenDepositAccountCase1() throws Exception{
		HttpServletRequest request = new MockHttpServletRequest();
		request.setAttribute("success", "f");
		HttpServletResponse response = new MockHttpServletResponse();
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo(); 
		vo.setAccountName("新开户测试");//
		vo.setAccountType("1");//账户类型：0-余额账户;1-授信;2-收益; 3-支付手续费账号;4-资金账户;5-待清算;6-现金账户;7-钱包待清算账户;
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("ACCS");
		vo.setPartnerId("12345678901234567");
		vo.setPoolNo("PN01000000000000761");
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("ca3004005001001");
		CreditAccountServiceMock.mockInsertOpenCreditAccount(creditAccountService, ca);
		CreditAccountServiceMock.mockServiceVerification(creditAccountService);
		openAdvanceAccountController.openDepositAccount(request, response, vo);
	}
	
	/**
	 * 
	 * @Description: 开户异常--- 参数格式校验错误
	 * @author JiangKun
	 * @date 2016年7月1日 下午3:42:55
	 */
	@Test
	public void testOpenDepositAccountCase2() throws Exception{
		HttpServletRequest request = new MockHttpServletRequest();
		request.setAttribute("success", "f");
		HttpServletResponse response = new MockHttpServletResponse();
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo(); 
		vo.setAccountName("新开户测试");//
		vo.setAccountType("0");//1-企业; 2-个人; 3-内部账户
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("ACCS");
		vo.setPartnerId("12345678901234567");
		vo.setPoolNo("PN01000000000000761");
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("ca3004005001001");
		CreditAccountServiceMock.mockInsertOpenCreditAccount(creditAccountService, ca);
		CreditAccountServiceMock.mockServiceVerification(creditAccountService);
		openAdvanceAccountController.openDepositAccount(request, response, vo);
	}
	
	
	
	/**
	 * 
	 * @Description: 开户异常--- 捕获Exception异常
	 * @author JiangKun
	 * @date 2016年7月1日 下午3:42:55
	 */
	@Test
	public void testOpenDepositAccountCase3() throws Exception{
		HttpServletRequest request = new MockHttpServletRequest();
		request.setAttribute("success", "f");
		HttpServletResponse response = new MockHttpServletResponse();
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo(); 
		vo.setAccountName("新开户测试");//
		vo.setAccountType("1");//1-企业; 2-个人; 3-内部账户
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("ACCS");
		vo.setPartnerId("12345678901234567");
		vo.setPoolNo("PN01000000000000761");
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("ca3004005001001");
		CreditAccountServiceMock.mockInsertOpenCreditAccountBusinessException(creditAccountService, ca);
		CreditAccountServiceMock.mockServiceVerificationException(creditAccountService);
		openAdvanceAccountController.openDepositAccount(request, response, vo);
	}
	
	
	
	
}
