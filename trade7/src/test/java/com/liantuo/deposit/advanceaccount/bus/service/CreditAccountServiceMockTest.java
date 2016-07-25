package com.liantuo.deposit.advanceaccount.bus.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.liantuo.deposit.advanceaccount.bus.service.impl.CreditAccountServiceImpl;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.deposit.advanceaccount.orm.mapper.AccountForbidTradeMapper;
import com.liantuo.deposit.advanceaccount.orm.mapper.AccountForbidTradeMapperMock;
import com.liantuo.deposit.advanceaccount.orm.mapper.CreditAccountMapper;
import com.liantuo.deposit.advanceaccount.orm.mapper.CreditAccountMapperMock;
import com.liantuo.deposit.advanceaccount.orm.mapper.PoolMapper;
import com.liantuo.deposit.advanceaccount.orm.mapper.PoolMapperMock;
import com.liantuo.deposit.advanceaccount.orm.pojo.AccountForbidTrade;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.vo.req.OpenCreditAccountReqVo;
import com.liantuo.deposit.common.constants.ErrorCode001Constants;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode009Constants;
import com.liantuo.mc.web.client.MerchantClient;
import com.liantuo.mc.web.client.MerchantClientMock;
import com.liantuo.mc.web.rsp.MerchantResponse;
import com.liantuo.trade.common.util.AmountUtilsMock;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.exception.BusinessUncheckedException;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdbMock;
import com.liantuo.unittest.BaseServiceTest;
@RunWith(PowerMockRunner.class)
@PrepareForTest({ MerchantClient.class,AmountUtils.class})
public class CreditAccountServiceMockTest extends BaseServiceTest{
	
	private CreditAccountService creditAccountService=new CreditAccountServiceImpl();
	@Mock
	private CreditAccountMapper creditAccountMapper; 
	@Mock
	private AccountForbidTradeMapper accountForbidTradeMapper;
	@Mock
	private PoolMapper poolMapper;
	@Mock
	private StepSequenceFactoryForSpdb idFactoryCaAccountNo;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(creditAccountService, "poolMapper", poolMapper);
		ReflectionTestUtils.setField(creditAccountService, "creditAccountMapper", creditAccountMapper);
		ReflectionTestUtils.setField(creditAccountService, "accountForbidTradeMapper", accountForbidTradeMapper);
		ReflectionTestUtils.setField(creditAccountService, "idFactoryCaAccountNo", idFactoryCaAccountNo);
		
	}
	
	/**
	 * UpdateAvlBalDecr
	 * @Description: 可用余额减少，更新成功
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateAvlBalDecrCase1(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setAvailableBalance(new Double(200));
		ca.setTotalBalance(new Double(200));
		Long amount = 100000000L;
		Date balLastChangeTime = new Date();
		
		CreditAccountMapperMock.mockUpdateAvlBalance(creditAccountMapper);
		boolean result = creditAccountService.updateAvlBalDecr(ca, amount, balLastChangeTime);
		assertTrue("更新成功，应该返回true",result);
	}
	
	/**
	 * UpdateAvlBalDecr
	 * @Description: 可用余额减少更新失败，抛出异常
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateAvlBalDecrCase2(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setAvailableBalance(new Double(200));
		ca.setTotalBalance(new Double(200));
		Long amount = 100000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateAvlBalanceFailed(creditAccountMapper);
			creditAccountService.updateAvlBalDecr(ca, amount, balLastChangeTime);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * UpdateAvlBalDecr
	 * @Description: 可用余额减少金额 大于账户可用余额，抛出异常
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateAvlBalDecrCase3(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setAvailableBalance(new Double(200));
		ca.setTotalBalance(new Double(200));
		Long amount = 201000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateAvlBalance(creditAccountMapper);
			boolean result = creditAccountService.updateAvlBalDecr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100300","ZW000100300",e.getErrorCode());
		assertEquals("错误信息应该为："+ca.getAccountNo()+"账户余额不足",ca.getAccountNo()+"账户余额不足",e.getErrorMessage());
	}
	
	/**
	 * UpdateAvlBalDecr
	 * @Description: 程序运行中抛出NumberFormatException异常，被捕获
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateAvlBalDecrCase4(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setAvailableBalance(new Double(200));
		ca.setTotalBalance(new Double(200));
		Long amount = 100000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateAvlBalance(creditAccountMapper);
			AmountUtilsMock.mockLongConvertToBizAmountException1(amount);
			boolean result = creditAccountService.updateAvlBalDecr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * UpdateAvlBalDecr
	 * @Description: 程序运行中抛出AmountConvertException异常，被捕获
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateAvlBalDecrCase5(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setAvailableBalance(new Double(200));
		ca.setTotalBalance(new Double(200));
		Long amount = 100000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateAvlBalance(creditAccountMapper);
			AmountUtilsMock.mockLongConvertToBizAmountException2(amount);
			boolean result = creditAccountService.updateAvlBalDecr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * UpdateAvlBalIncr
	 * @Description: 可用余额增加，更新成功
	 * @author JiangKun
	 * @date 2016年7月13日 上午11:02:06
	 */
	@Test
	public void testUpdateAvlBalIncrCase1(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setAvailableBalance(new Double(200));
		ca.setTotalBalance(new Double(200));
		Long amount = 100000000L;
		Date balLastChangeTime = new Date();
	
		CreditAccountMapperMock.mockUpdateAvlBalance(creditAccountMapper);
		boolean result = creditAccountService.updateAvlBalIncr(ca, amount, balLastChangeTime);
		assertTrue("更新成功，应该返回true",result);

	}
	
	/**
	 * UpdateAvlBalIncr
	 * @Description: 可用余额增加更新失败，抛出异常
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateAvlBalIncrCase2(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setAvailableBalance(new Double(200));
		ca.setTotalBalance(new Double(200));
		Long amount = 100000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateAvlBalanceFailed(creditAccountMapper);
			creditAccountService.updateAvlBalIncr(ca, amount, balLastChangeTime);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * UpdateAvlBalIncr
	 * @Description: 程序运行中抛出NumberFormatException异常，被捕获
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateAvlBalIncrCase3(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setAvailableBalance(new Double(200));
		ca.setTotalBalance(new Double(200));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateAvlBalance(creditAccountMapper);
			AmountUtilsMock.mockLongConvertToBizAmountException1(amount);
			boolean result = creditAccountService.updateAvlBalIncr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e= e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * UpdateAvlBalIncr
	 * @Description: 程序运行中抛出AmountConvertException异常，被捕获
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateAvlBalIncrCase4(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setAvailableBalance(new Double(200));
		ca.setTotalBalance(new Double(200));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateAvlBalance(creditAccountMapper);
			AmountUtilsMock.mockLongConvertToBizAmountException2(amount);
			boolean result = creditAccountService.updateAvlBalIncr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * updateFrozenBalIncr
	 * @Description: 可用冻结余额增加，更新成功
	 * @author JiangKun
	 * @date 2016年7月13日 上午11:22:52
	 */
	@Test
	public void testUpdateFrozenBalIncrCase1(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setTotalBalance(new Double(200));
		ca.setAvailableBalance(new Double(100));
		ca.setFreezenBalance(new Double(100));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		CreditAccountMapperMock.mockUpdateFrozenBalance(creditAccountMapper);
		boolean result = creditAccountService.updateFrozenBalIncr(ca, amount, balLastChangeTime);
		assertTrue("更新成功，应该返回true",result);
	}
	
	/**
	 * updateFrozenBalIncr
	 * @Description: 可用冻结余额增加，更新失败，抛出异常
	 * @author JiangKun
	 * @date 2016年7月13日 上午11:22:52
	 */
	@Test
	public void testUpdateFrozenBalIncrCase2(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setTotalBalance(new Double(200));
		ca.setAvailableBalance(new Double(100));
		ca.setFreezenBalance(new Double(100));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateFrozenBalanceFailed(creditAccountMapper);
			creditAccountService.updateFrozenBalIncr(ca, amount, balLastChangeTime);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * updateFrozenBalIncr
	 * @Description: 程序运行中抛出NumberFormatException异常，被捕获
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateFrozenBalIncrCase3(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setTotalBalance(new Double(200));
		ca.setAvailableBalance(new Double(100));
		ca.setFreezenBalance(new Double(100));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateFrozenBalance(creditAccountMapper);
			AmountUtilsMock.mockLongConvertToBizAmountException1(amount);
			boolean result = creditAccountService.updateFrozenBalIncr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * updateFrozenBalIncr
	 * @Description: 程序运行中抛出AmountConvertException异常，被捕获
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateFrozenBalIncrCase4(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setTotalBalance(new Double(200));
		ca.setAvailableBalance(new Double(100));
		ca.setFreezenBalance(new Double(100));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateFrozenBalance(creditAccountMapper);
			AmountUtilsMock.mockLongConvertToBizAmountException2(amount);
			boolean result = creditAccountService.updateFrozenBalIncr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * updateFrozenBalDecr
	 * @Description: 可用冻结余额减少，更新成功
	 * @author JiangKun
	 * @date 2016年7月13日 上午11:22:52
	 */
	@Test
	public void testUpdateFrozenBalDecrCase1(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setTotalBalance(new Double(200));
		ca.setAvailableBalance(new Double(100));
		ca.setFreezenBalance(new Double(100));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		CreditAccountMapperMock.mockUpdateFrozenBalance(creditAccountMapper);
		boolean result = creditAccountService.updateFrozenBalDecr(ca, amount, balLastChangeTime);
		assertTrue("更新成功，应该返回true",result);
	}
	
	/**
	 * updateFrozenBalDecr
	 * @Description: 可用冻结余额减少，更新失败，抛出异常
	 * @author JiangKun
	 * @date 2016年7月13日 上午11:22:52
	 */
	@Test
	public void testUpdateFrozenBalDecrCase2(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setTotalBalance(new Double(200));
		ca.setAvailableBalance(new Double(100));
		ca.setFreezenBalance(new Double(100));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateFrozenBalanceFailed(creditAccountMapper);
			creditAccountService.updateFrozenBalDecr(ca, amount, balLastChangeTime);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * updateFrozenBalDecr
	 * @Description: 可用冻结余额减少金额 大于账户可用冻结余额，抛出异常
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateFrozenBalDecrCase3(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setTotalBalance(new Double(200));
		ca.setAvailableBalance(new Double(100));
		ca.setFreezenBalance(new Double(100));
		Long amount = 101000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateFrozenBalance(creditAccountMapper);
			boolean result = creditAccountService.updateFrozenBalDecr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100300","ZW000100300",e.getErrorCode());
		assertEquals("错误信息应该为："+ca.getAccountNo()+"账户余额不足",ca.getAccountNo()+"账户余额不足",e.getErrorMessage());
	}
	
	/**
	 * updateFrozenBalDecr
	 * @Description: 程序运行中抛出NumberFormatException异常，被捕获
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateFrozenBalDecrCase4(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setTotalBalance(new Double(200));
		ca.setAvailableBalance(new Double(100));
		ca.setFreezenBalance(new Double(100));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateFrozenBalance(creditAccountMapper);
			AmountUtilsMock.mockLongConvertToBizAmountException1(amount);
			boolean result = creditAccountService.updateFrozenBalDecr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * updateFrozenBalDecr
	 * @Description:程序抛出AmountConvertException异常，被捕获
	 * @author JiangKun
	 * @date 2016年7月13日 上午9:41:08
	 */
	@Test
	public void testUpdateFrozenBalDecrCase5(){
		CreditAccount ca = new CreditAccount();
		ca.setAccountNo("12345678");
		ca.setVersion(1L);
		ca.setTotalBalance(new Double(200));
		ca.setAvailableBalance(new Double(100));
		ca.setFreezenBalance(new Double(100));
		Long amount = 10000000L;
		Date balLastChangeTime = new Date();
		BusinessUncheckedException e = null;
		try{
			CreditAccountMapperMock.mockUpdateFrozenBalance(creditAccountMapper);
			AmountUtilsMock.mockLongConvertToBizAmountException2(amount);
			boolean result = creditAccountService.updateFrozenBalDecr(ca, amount, balLastChangeTime);
			assertNotEquals("更新失败，result不应该为true", true,result);
		}catch(BusinessUncheckedException e1){
			e = e1;
		}
		assertEquals("更新失败,错误码应该为ZW000100101","ZW000100101",e.getErrorCode());
		assertEquals("错误信息应该为：系统异常","系统异常",e.getErrorMessage());
	}
	
	/**
	 * AscAccountNosAndLock
	 * 对接口传过来的CA账号进行升序操作，然后执行悲观锁
	 * @Description: 
	 * @author JiangKun
	 * @date 2016年7月13日 上午11:57:01
	 */
	@Test
	public void testAscAccountNosAndLockCase(){
		Integer ids[] = {1,2,3};
		CreditAccount ca = new CreditAccount();
		CreditAccountMapperMock.mockSelectByIdForUpdate(creditAccountMapper, ca);
		Map<String, CreditAccount> map = creditAccountService.ascAccountNosAndLock(ids);
		assertNotNull("应该不为空",map);		
	}
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description: creditAccount为null，账户不存在
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase1(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setCoreMerchantNo("liantuo");
		vo.setPoolNo("p123123123");
		CreditAccount ca = null;
//		ca.setCoreMerchantNo("liantuo");
//		ca.setPoolNo("p123123123");
//		ca.setStatus(1);
		BusinessUncheckedException e = null;
		try {
			boolean result = creditAccountService.accountStatusValidate(vo, ca);
			assertNotEquals("ca为null，验证结果不应该为true",true ,result);
		} catch (BusinessUncheckedException e1) {
			e = e1;
		}
		assertEquals("ca为null，错误码应该为："+ErrorCode001Constants.ACCOUNT_NOT_EXIST,ErrorCode001Constants.ACCOUNT_NOT_EXIST,e.getErrorCode());
		assertEquals("ca为null，错误信息应为："+vo.getAccountNo()+"账户不存在",vo.getAccountNo()+"账户不存在",e.getErrorMessage());
	}
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description: 核心商户不符合
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase2(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setPoolNo("p123123123");
		CreditAccount ca = new CreditAccount();
		ca.setCoreMerchantNo("liantuo1");
		ca.setPoolNo("p123123123");
		ca.setStatus(1);
		BusinessUncheckedException e = null;
		try {
			boolean result = creditAccountService.accountStatusValidate(vo, ca);
			assertNotEquals("ca为null，验证结果不应该为true",true ,result);
		} catch (BusinessUncheckedException e1) {
			e = e1;
		}
		assertEquals("错误码应该为："+ErrorCode001Constants.CORE_MERCHANT_NO_NOT_CORRECT,ErrorCode001Constants.CORE_MERCHANT_NO_NOT_CORRECT,e.getErrorCode());
		assertEquals("错误信息应为："+vo.getAccountNo()+"账户表中的核心商户和参数中的核心商户不符",vo.getAccountNo()+"账户表中的核心商户和参数中的核心商户不符",e.getErrorMessage());
	}
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description: 账户表中资金池编号和参数中的资金池编号不符
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase3(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setPoolNo("p1231231234");
		CreditAccount ca = new CreditAccount();
		ca.setCoreMerchantNo("liantuo");
		ca.setPoolNo("p123123123");
		ca.setStatus(1);
		BusinessUncheckedException e = null;
		try {
			boolean result = creditAccountService.accountStatusValidate(vo, ca);
			assertNotEquals("验证结果不应该为true",true ,result);
		} catch (BusinessUncheckedException e1) {
			e = e1;
		}
		assertEquals("错误码应该为："+ErrorCode001Constants.POOL_NO_NOT_CORRECT,ErrorCode001Constants.POOL_NO_NOT_CORRECT,e.getErrorCode());
		assertEquals("错误信息应为："+vo.getAccountNo()+"账户表中资金池编号和参数中的资金池编号不符",vo.getAccountNo()+"账户表中资金池编号和参数中的资金池编号不符",e.getErrorMessage());
	}
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description: 账户状态异常
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase4(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setPoolNo("p123123123");
		CreditAccount ca = new CreditAccount();
		ca.setCoreMerchantNo("liantuo");
		ca.setPoolNo("p123123123");
		ca.setStatus(2);
		BusinessUncheckedException e = null;
		try {
			boolean result = creditAccountService.accountStatusValidate(vo, ca);
			assertNotEquals("验证结果不应该为true",true ,result);
		} catch (BusinessUncheckedException e1) {
			e = e1;
		}
		assertEquals("错误码应该为："+ErrorCode001Constants.ACCOUNT_STATUS_EXCEPTION,ErrorCode001Constants.ACCOUNT_STATUS_EXCEPTION,e.getErrorCode());
		assertEquals("错误信息应为："+vo.getAccountNo()+"账户状态异常",vo.getAccountNo()+"账户状态异常",e.getErrorMessage());
	}
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description: 账户禁止该交易类型
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase5(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setPoolNo("p123123123");
		CreditAccount ca = new CreditAccount();
		ca.setCoreMerchantNo("liantuo");
		ca.setPoolNo("p123123123");
		ca.setStatus(1);
		AccountForbidTrade forbidTrade = new AccountForbidTrade();
		BusinessUncheckedException e = null;
		try {
			AccountForbidTradeMapperMock.mockSelectWhetherForbidAllByCANotNull(accountForbidTradeMapper, vo.getAccountNo(),forbidTrade);
			boolean result = creditAccountService.accountStatusValidate(vo, ca);
			assertNotEquals("ca为null，验证结果不应该为true",true ,result);
		} catch (BusinessUncheckedException e1) {
			e=e1;
		}
		assertEquals("错误码应该为："+ErrorCode001Constants.FORBID_THIS_TRADE_TYPE,ErrorCode001Constants.FORBID_THIS_TRADE_TYPE,e.getErrorCode());
		assertEquals("错误信息应为："+vo.getAccountNo()+"账户禁止该交易类型",vo.getAccountNo()+"账户禁止该交易类型",e.getErrorMessage());
	}
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description: 账户禁止该交易类型
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase6(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setPoolNo("p123123123");
		CreditAccount ca = new CreditAccount();
		ca.setCoreMerchantNo("liantuo");
		ca.setPoolNo("p123123123");
		ca.setStatus(1);
		AccountForbidTrade forbidTrade = new AccountForbidTrade();
		BusinessUncheckedException e = null;
		try {
			AccountForbidTradeMapperMock.mockSelectWhetherForbidAllByCANull(accountForbidTradeMapper, vo.getAccountNo());
			AccountForbidTradeMapperMock.mockSelectWhetherForbidThisTradeNotNull(accountForbidTradeMapper,forbidTrade);
			boolean result = creditAccountService.accountStatusValidate(vo, ca);
			assertNotEquals("验证结果不应该为true",true ,result);
		} catch (BusinessUncheckedException e1) {
			e = e1;
		}
		assertEquals("错误码应该为："+ErrorCode001Constants.FORBID_THIS_TRADE_TYPE,ErrorCode001Constants.FORBID_THIS_TRADE_TYPE,e.getErrorCode());
		assertEquals("错误信息应为："+vo.getAccountNo()+"账户禁止该交易类型",vo.getAccountNo()+"账户禁止该交易类型",e.getErrorMessage());
	}
	
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description: 账户禁止该交易请求类型
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase7(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setPoolNo("p123123123");
		CreditAccount ca = new CreditAccount();
		ca.setCoreMerchantNo("liantuo");
		ca.setPoolNo("p123123123");
		ca.setStatus(1);
		AccountForbidTrade forbidTrade = new AccountForbidTrade();
		BusinessUncheckedException e = null;
		try {
			AccountForbidTradeMapperMock.mockSelectWhetherForbidAllByCANull(accountForbidTradeMapper, vo.getAccountNo());
			AccountForbidTradeMapperMock.mockSelectWhetherForbidThisTradeNullAndNotNull(accountForbidTradeMapper,forbidTrade);
			boolean result = creditAccountService.accountStatusValidate(vo, ca);
			assertNotEquals("验证结果不应该为true",true ,result);
		} catch (BusinessUncheckedException e1) {
			e = e1;
		}
		assertEquals("错误码应该为："+ErrorCode001Constants.FORBID_THIS_TRADE_REQUEST_TYPE,ErrorCode001Constants.FORBID_THIS_TRADE_REQUEST_TYPE,e.getErrorCode());
		assertEquals("错误信息应为："+vo.getAccountNo()+"账户禁止该交易请求类型",vo.getAccountNo()+"账户禁止该交易请求类型",e.getErrorMessage());
	}
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description:账户非预存款账户
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase8(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setPoolNo("p123123123");
		CreditAccount ca = new CreditAccount();
		ca.setCoreMerchantNo("liantuo");
		ca.setPoolNo("p123123123");
		ca.setStatus(1);
		AccountForbidTrade forbidTrade = new AccountForbidTrade();
		List<CreditAccount> list = new ArrayList<CreditAccount>();
		list.add(ca);
		BusinessUncheckedException e = null;
		try {
			AccountForbidTradeMapperMock.mockSelectWhetherForbidAllByCANull(accountForbidTradeMapper, vo.getAccountNo());
			AccountForbidTradeMapperMock.mockSelectWhetherForbidThisTradeNull(accountForbidTradeMapper);
			CreditAccountMapperMock.mockFindAdvanceAccountByAccountNo(creditAccountMapper, list,vo.getAccountNo());
			boolean result = creditAccountService.accountStatusValidate(vo, ca);
			assertNotEquals("验证结果不应该为true",true ,result);
		} catch (BusinessUncheckedException e1) {
			e = e1;
		}
		assertEquals("错误码应该为："+ErrorCode001Constants.CREDIT_ACCOUNT_NOT_PRE_ACCOUNT,ErrorCode001Constants.CREDIT_ACCOUNT_NOT_PRE_ACCOUNT,e.getErrorCode());
		assertEquals("错误信息应为："+vo.getAccountNo()+"账户非预存款账户",vo.getAccountNo()+"账户非预存款账户",e.getErrorMessage());
	}
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description:账户验证成功 list.size()=0
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase9(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setPoolNo("p123123123");
		CreditAccount ca = new CreditAccount();
		ca.setCoreMerchantNo("liantuo");
		ca.setPoolNo("p123123123");
		ca.setStatus(1);
		AccountForbidTrade forbidTrade = new AccountForbidTrade();
		List<CreditAccount> list = new ArrayList<CreditAccount>();
		
		AccountForbidTradeMapperMock.mockSelectWhetherForbidAllByCANull(accountForbidTradeMapper, vo.getAccountNo());
		AccountForbidTradeMapperMock.mockSelectWhetherForbidThisTradeNull(accountForbidTradeMapper);
		CreditAccountMapperMock.mockFindAdvanceAccountByAccountNo(creditAccountMapper, list,vo.getAccountNo());
		boolean result = creditAccountService.accountStatusValidate(vo, ca);
		assertEquals("验证结果不应该为true",true ,result);

	}
	
	/**
	 * AccountStatusValidate
	 * 账务实时充值接口账户状态验证
	 * @Description:账户验证成功 list =null
	 * @author JiangKun
	 * @date 2016年7月13日 下午1:33:08
	 */
	@Test
	public void testAccountStatusValidateCase10(){
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setAccountNo("12345678");
		vo.setTradeCode("0001_001");
		vo.setPoolNo("p123123123");
		CreditAccount ca = new CreditAccount();
		ca.setCoreMerchantNo("liantuo");
		ca.setPoolNo("p123123123");
		ca.setStatus(1);
		AccountForbidTrade forbidTrade = new AccountForbidTrade();
		List<CreditAccount> list = null;
		
		AccountForbidTradeMapperMock.mockSelectWhetherForbidAllByCANull(accountForbidTradeMapper, vo.getAccountNo());
		AccountForbidTradeMapperMock.mockSelectWhetherForbidThisTradeNull(accountForbidTradeMapper);
		CreditAccountMapperMock.mockFindAdvanceAccountByAccountNo(creditAccountMapper, list,vo.getAccountNo());
		boolean result = creditAccountService.accountStatusValidate(vo, ca);
		assertEquals("验证结果不应该为true",true ,result);

	}
	
	
	/**
	 * 
	 * @Description: 验证成功情况
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:05:13
	 */
	@Test
	public void testServiceVerificationCase1() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("CCZX");
		vo.setPoolNo("PN01000000000000761");
		//构建返回资金池信息
		Pool pool = new Pool();
		pool.setMerchantNo("liantuo");
		//构建调用接口返回
		MerchantResponse response = new MerchantResponse();
		response.setReturnCode("S");
		response.setMerchantFullName("不为空");
		response.setMerchantName("不为空");
		MerchantClientMock.mockGetMerchant(response);
		PoolMapperMock.mockSelectByPoolNo(poolMapper,pool);
		Exception e = null;
		try {
			creditAccountService.serviceVerification(vo);			
		} catch (Exception e1) {
			e = e1;
		}
		assertNull("验证成功异常应该为null",e);
		
	}
	
	/**
	 * 
	 * @Description: 资金池为空
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:07:50
	 */
	@Test
	public void testServiceVerificationCase2() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("CCZX");
		vo.setPoolNo("PN01000000000000761");
		
		//构建返回资金池信息
		Pool pool = null;
		
		//构建调用接口返回
		MerchantResponse response = new MerchantResponse();
		response.setReturnCode("S");
		response.setMerchantFullName("不为空");
		response.setMerchantName("不为空");
		
		MerchantClientMock.mockGetMerchant(response);
		PoolMapperMock.mockSelectByPoolNo(poolMapper,pool);
		BusinessException e=null;
		try{
			creditAccountService.serviceVerification(vo);
		}catch(BusinessException e1){
			e=e1;
		}
		assertNotNull("业务验证应该不通过！",e);
		assertEquals("异常描述有误！","编号关联关系有误", e.getErrorMessage());
		assertEquals("异常代码有误",ErrorCode009Constants.NUMBERS_ASSOCIATED_ERROR, e.getErrorCode());
	}
	
	/**
	 * 
	 * @Description: 资金池商户编号  不等于 核心商户编号
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:10:42
	 */
	@Test
	public void testServiceVerificationCase3() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("CCZX");
		vo.setPoolNo("PN01000000000000761");
		
		//构建返回资金池信息
		Pool pool = new Pool();
		pool.setMerchantNo("liantuo1");
		
		MerchantResponse response = new MerchantResponse();
		response.setReturnCode("S");
		response.setMerchantFullName("不为空");
		response.setMerchantName("不为空");
		MerchantClientMock.mockGetMerchant(response);
		PoolMapperMock.mockSelectByPoolNo(poolMapper,pool);
		BusinessException e=null;
		try{
			creditAccountService.serviceVerification(vo);
		}catch(BusinessException e1){
			e=e1;
		}
		assertNotNull("业务验证应该不通过！",e);
		assertEquals("异常描述有误！","编号关联关系有误", e.getErrorMessage());
		assertEquals("异常代码有误",ErrorCode009Constants.NUMBERS_ASSOCIATED_ERROR, e.getErrorCode());
	}
	
	/**
	 * 
	 * @Description: MerchantResponse 返回 为null
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:10:42
	 */
	@Test
	public void testServiceVerificationCase4() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("CCZX");
		vo.setPoolNo("PN01000000000000761");
		
		//构建返回资金池信息
		Pool pool = new Pool();
		pool.setMerchantNo("liantuo");
		
		MerchantResponse response = null;
//		response.setReturnCode("S");
//		response.setMerchantFullName("不为空");
//		response.setMerchantName("不为空");
		MerchantClientMock.mockGetMerchant(response);
		PoolMapperMock.mockSelectByPoolNo(poolMapper,pool);
		BusinessException e = null;
		try{
			creditAccountService.serviceVerification(vo);
		}catch(BusinessException e1){
			e= e1;
		}
		assertNotNull("业务验证应该不通过",e);
		assertEquals("异常信息描述不符合预期！", "查询核心商户下某成员商户信息接口失败", e.getErrorMessage());
		assertEquals("异常错误码不符合预期",ErrorCode009Constants.NOT_MERCHANTNO,e.getErrorCode());
	}
	
	/**
	 * 
	 * @Description: MerchantResponse 返回  returnCode 为 F 或者  merchantFullName为空或者merchantName为空
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:10:42
	 */
	@Test
	public void testServiceVerificationCase5() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("CCZX");
		vo.setPoolNo("PN01000000000000761");
		
		//构建返回资金池信息
		Pool pool = new Pool();
		pool.setMerchantNo("liantuo");
		
		MerchantResponse response = new MerchantResponse();
		response.setReturnCode("F");
		response.setMerchantFullName("不为空");
		response.setMerchantName("不为空");
		MerchantClientMock.mockGetMerchant(response);
		PoolMapperMock.mockSelectByPoolNo(poolMapper,pool);
		BusinessException e = null;
		try {
			creditAccountService.serviceVerification(vo);
		} catch (BusinessException e1) {
			e = e1;
		}
		assertNotNull("业务验证应该不通过",e);
		assertEquals("异常信息描述不符合预期！", "核心商户:"+pool.getMerchantNo()+"下某成员商户:"+vo.getMerchantNo()+"不存在", e.getErrorMessage());
		assertEquals("异常错误码不符合预期",ErrorCode009Constants.NOT_MERCHANTNO,e.getErrorCode());
	}
	
	/**
	 * 
	 * @Description: 验证成功情况-商户编号和核心相等的情况
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:05:13
	 */
	@Test
	public void testServiceVerificationCase6() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("liantuo");
		vo.setPoolNo("PN01000000000000761");
		//构建返回资金池信息
		Pool pool = new Pool();
		pool.setMerchantNo("liantuo");
		//构建调用接口返回
		MerchantResponse response = new MerchantResponse();
		response.setReturnCode("S");
		response.setMerchantFullName("不为空");
		response.setMerchantName("不为空");
		MerchantClientMock.mockGetMerchant(response);
		PoolMapperMock.mockSelectByPoolNo(poolMapper,pool);
		Exception e = null;
		try {
			creditAccountService.serviceVerification(vo);			
		} catch (Exception e1) {
			e = e1;
		}
		assertNull("验证成功异常应该为null",e);	
	}
	
	/**
	 * 
	 * @Description: MerchantResponse 返回  returnCode 为 F 或者  merchantFullName为空或者merchantName为空
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:10:42
	 */
	@Test
	public void testServiceVerificationCase7() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("CCZX");
		vo.setPoolNo("PN01000000000000761");
		
		//构建返回资金池信息
		Pool pool = new Pool();
		pool.setMerchantNo("liantuo");
		
		MerchantResponse response = new MerchantResponse();
		response.setReturnCode("S");
		response.setMerchantFullName("");
		response.setMerchantName("不为空");
		MerchantClientMock.mockGetMerchant(response);
		PoolMapperMock.mockSelectByPoolNo(poolMapper,pool);
		BusinessException e = null;
		try {
			creditAccountService.serviceVerification(vo);
		} catch (BusinessException e1) {
			e = e1;
		}
		assertNotNull("业务验证应该不通过",e);
		assertEquals("异常信息描述不符合预期！", "核心商户:"+pool.getMerchantNo()+"下某成员商户:"+vo.getMerchantNo()+"不存在", e.getErrorMessage());
		assertEquals("异常错误码不符合预期",ErrorCode009Constants.NOT_MERCHANTNO,e.getErrorCode());
	}
	
	/**
	 * 
	 * @Description: MerchantResponse 返回  returnCode 为 F 或者  merchantFullName为空或者merchantName为空
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:10:42
	 */
	@Test
	public void testServiceVerificationCase8() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setCoreMerchantNo("liantuo");
		vo.setMerchantNo("CCZX");
		vo.setPoolNo("PN01000000000000761");
		
		//构建返回资金池信息
		Pool pool = new Pool();
		pool.setMerchantNo("liantuo");
		
		MerchantResponse response = new MerchantResponse();
		response.setReturnCode("S");
		response.setMerchantFullName("不为空");
		response.setMerchantName("");
		MerchantClientMock.mockGetMerchant(response);
		PoolMapperMock.mockSelectByPoolNo(poolMapper,pool);
		BusinessException e = null;
		try {
			creditAccountService.serviceVerification(vo);
		} catch (BusinessException e1) {
			e = e1;
		}
		assertNotNull("业务验证应该不通过",e);
		assertEquals("异常信息描述不符合预期！", "核心商户:"+pool.getMerchantNo()+"下某成员商户:"+vo.getMerchantNo()+"不存在", e.getErrorMessage());
		assertEquals("异常错误码不符合预期",ErrorCode009Constants.NOT_MERCHANTNO,e.getErrorCode());
	}
	
	/**
	 * 
	 * @Description: 插入操作
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:17:34
	 */
	@Test
	public void testInsertOpenCreditAccountCase1() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setPoolNo("PN01000000000000762");
		vo.setAccountName("wode");
		CreditAccountMapperMock.mockInsert(creditAccountMapper);
		StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryCaAccountNo, "123456");
		creditAccountService.insertOpenCreditAccount(vo);
	}
	
	/**
	 * 
	 * @Description: 插入操作--异常情况--BusinessException
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:17:34
	 */
	@Test
	public void testInsertOpenCreditAccountCase2() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		
		CreditAccountMapperMock.mockInsertException(creditAccountMapper);
		StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryCaAccountNo, "123456");
		Exception e = null;
		try {
			creditAccountService.insertOpenCreditAccount(vo);			
		} catch (Exception e1) {
			e = e1;
		}
		assertNotNull("业务验证应该不通过",e);
	}
	
	/**
	 * 
	 * @Description: 插入操作--异常情况--BusinessException
	 * @author JiangKun
	 * @date 2016年6月30日 下午3:17:34
	 */
	@Test
	public void testInsertOpenCreditAccountCase3() throws Exception{
		OpenCreditAccountReqVo vo = new OpenCreditAccountReqVo();
		vo.setAccountType("1");
		CreditAccountMapperMock.mockInsertException(creditAccountMapper);
		StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryCaAccountNo, "123456");
		Exception e = null;
		try {
			creditAccountService.insertOpenCreditAccount(vo);			
		} catch (Exception e1) {
			e = e1;
		}
		assertNotNull("业务验证应该不通过",e);
	}
	
	
	
}
