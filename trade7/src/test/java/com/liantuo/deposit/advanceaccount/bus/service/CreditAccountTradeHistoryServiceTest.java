package com.liantuo.deposit.advanceaccount.bus.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;

import com.liantuo.deposit.advanceaccount.bus.service.impl.CreditAccountTradeHistoryServiceImpl;
import com.liantuo.deposit.advanceaccount.bus.vo.AccountingRecord;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountAccountRecord;
import com.liantuo.deposit.advanceaccount.orm.mapper.CreditAccountMapper;
import com.liantuo.deposit.advanceaccount.orm.mapper.CreditAccountMapperMock;
import com.liantuo.deposit.advanceaccount.orm.mapper.CreditAccountTradeHistoryMapper;
import com.liantuo.deposit.advanceaccount.orm.mapper.CreditAccountTradeHistoryMapperMock;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccountTradeHistory;
import com.liantuo.deposit.advanceaccount.web.inner.vo.req.SingleAccountHisPageQueryReqVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountHisPageQueryRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisQueryReqVo;
import com.liantuo.deposit.common.constants.ErrorCode001Constants;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode003Constants;
import com.liantuo.mc.web.client.MerchantClient;
import com.liantuo.trade.common.util.AmountUtilsMock;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.exception.BusinessUncheckedException;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdbMock;
import com.liantuo.unittest.BaseServiceTest;
@RunWith(PowerMockRunner.class)
@PrepareForTest({ MerchantClient.class,AmountUtils.class})
public class CreditAccountTradeHistoryServiceTest extends BaseServiceTest{
	private static final Logger LOGGER = LoggerFactory.getLogger(CreditAccountTradeHistoryServiceTest.class);
	private CreditAccountTradeHistoryServiceImpl creditAccountTradeHistoryService=new CreditAccountTradeHistoryServiceImpl();
	@Mock
	private CreditAccountMapper creditAccountMapper;
	@Mock
	private CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper;
	@Mock
	private StepSequenceFactoryForSpdb idFactoryDepositRecordNum;

	@Before
	public void init(){	
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(creditAccountTradeHistoryService, "creditAccountMapper", creditAccountMapper);
		ReflectionTestUtils.setField(creditAccountTradeHistoryService, "creditAccountTradeHistoryMapper", creditAccountTradeHistoryMapper);
		ReflectionTestUtils.setField(creditAccountTradeHistoryService, "idFactory", idFactoryDepositRecordNum);
	}
	
	/**
	 * 账务流水
	 * @throws Exception
	 */
	@Test
	public void testInsertCaTradeHistoryCase1() throws Exception {
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setDepositRecordNo("21222245");
		creditAccountTradeHistory.setAccountNo("CA21000000019141");
		creditAccountTradeHistory.setReservedFields1("预留1");
		creditAccountTradeHistory.setReservedFields2("预留2");
		creditAccountTradeHistory.setReservedFields3("预留3");
		creditAccountTradeHistory.setReservedFields4("预留4");
		creditAccountTradeHistory.setReservedFields5("预留5");
		creditAccountTradeHistory.setTradeCode("0001_001_001");
		creditAccountTradeHistory.setTradeNo("824544488889");
		creditAccountTradeHistory.setTradeGmtCreated(new Date());
		creditAccountTradeHistory.setTradeReqCode("deposit_0_0_1");
		creditAccountTradeHistory.setTradeStepNo("4645645645");
		creditAccountTradeHistory.setSequenceNo("da4557887740");
		creditAccountTradeHistory.setRmk("生成记录");
		creditAccountTradeHistory.setAvlBalIncrAmt(100l);
		creditAccountTradeHistory.setFrozenBalIncrAmt(10l);
		creditAccountTradeHistory.setAvlBalDecrAmt(100l);
		creditAccountTradeHistory.setFrozenBalDecrAmt(10l);
		creditAccountTradeHistory.setSysTime(new Date());
		creditAccountTradeHistory.setGmtCreated(new Date());
		
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(1l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setAccountNo("CA21000000019141");
		vo.setCoreMerchantNo("ebillmaster");
		vo.setPoolNo("PN01000000000003124");
		vo.setReservedFields1("预留1");
		vo.setReservedFields2("预留2");
		vo.setReservedFields3("预留3");
		vo.setReservedFields4("预留4");
		vo.setReservedFields5("预留5");
		vo.setTradeCode("0001_001_001");
		vo.setTradeNo("456");
		vo.setTradeGmtCreated(new Date());
		vo.setRmk("备注123123");
		vo.setTradeReqCode("0001_001_001");
		vo.setTradeStepNo("4645645645");
		vo.setSequenceNo("234234234234234");
		vo.setAvlBalDecrAmt(Long.valueOf(32323));
		vo.setAvlBalIncrAmt(Long.valueOf(1));
		vo.setFrozenBalDecrAmt(Long.valueOf(54));
		vo.setFrozenBalIncrAmt(Long.valueOf(8454));
		
		StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryDepositRecordNum, "123456");
		CreditAccountTradeHistoryMapperMock.mockInsert(creditAccountTradeHistoryMapper);
		CreditAccountTradeHistoryMapperMock.mockSelectByPrimaryKey(creditAccountTradeHistoryMapper,creditAccountTradeHistory);
		AccountingRecord accountRecord = creditAccountTradeHistoryService.insertCaTradeHistory(vo,creditAccount,new Date());
		assertNotNull("返回结果不为空",accountRecord);
	}

	/**
	 * 模拟插入数据异常
	 * @throws Exception
	 */
	@Test
	public void testInsertCaTradeHistoryCase2() throws Exception {
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setDepositRecordNo("21222245");
		creditAccountTradeHistory.setAccountNo("CA21000000019141");
		creditAccountTradeHistory.setReservedFields1("预留1");
		creditAccountTradeHistory.setReservedFields2("预留2");
		creditAccountTradeHistory.setReservedFields3("预留3");
		creditAccountTradeHistory.setReservedFields4("预留4");
		creditAccountTradeHistory.setReservedFields5("预留5");
		creditAccountTradeHistory.setTradeCode("0001_001_001");
		creditAccountTradeHistory.setTradeNo("824544488889");
		creditAccountTradeHistory.setTradeGmtCreated(new Date());
		creditAccountTradeHistory.setTradeReqCode("deposit_0_0_1");
		creditAccountTradeHistory.setTradeStepNo("4645645645");
		creditAccountTradeHistory.setSequenceNo("da4557887740");
		creditAccountTradeHistory.setRmk("生成记录");
		creditAccountTradeHistory.setAvlBalIncrAmt(100l);
		creditAccountTradeHistory.setFrozenBalIncrAmt(10l);
		creditAccountTradeHistory.setAvlBalDecrAmt(100l);
		creditAccountTradeHistory.setFrozenBalDecrAmt(10l);
		creditAccountTradeHistory.setId(1);
		creditAccountTradeHistory.setSysTime(new Date());
		creditAccountTradeHistory.setGmtCreated(new Date());
		
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(4l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setAccountNo("CA21000000019141");
		vo.setCoreMerchantNo("ebillmaster");
		vo.setPoolNo("PN01000000000003124");
		vo.setReservedFields1("预留1");
		vo.setReservedFields2("预留2");
		vo.setReservedFields3("预留3");
		vo.setReservedFields4("预留4");
		vo.setReservedFields5("预留5");
		vo.setTradeCode("0001_001_001");
		vo.setTradeNo("456");
		vo.setTradeGmtCreated(new Date());
		vo.setRmk("备注123123");
		vo.setTradeReqCode("0001_001_001");
		vo.setTradeStepNo("4645645645");
		vo.setSequenceNo("234234234234234");
		vo.setAvlBalDecrAmt(Long.valueOf(32323));
		vo.setAvlBalIncrAmt(Long.valueOf(1));
		vo.setFrozenBalDecrAmt(Long.valueOf(54));
		vo.setFrozenBalIncrAmt(Long.valueOf(8454));
		BusinessUncheckedException ex=null;
		try {
			StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryDepositRecordNum, "123456");
			CreditAccountTradeHistoryMapperMock.mockInsertException(creditAccountTradeHistoryMapper);
			CreditAccountTradeHistoryMapperMock.mockSelectByPrimaryKey(creditAccountTradeHistoryMapper,creditAccountTradeHistory);
			AccountingRecord accountRecord = creditAccountTradeHistoryService.insertCaTradeHistory(vo,creditAccount,new Date());
		} catch (BusinessUncheckedException e) {
			ex=e;
		}
		assertNotNull("异常信息不为空",ex);
		assertEquals("返回异常信息符合预期","系统异常",ex.getErrorMessage());
		assertEquals("返回异常错误码符合预期",ErrorCode001Constants.SYSTEM_EXCEPTION,ex.getErrorCode());
	}
	/**
	 * 模拟系统异常
	 * @throws Exception
	 */
	@Test
	public void testInsertCaTradeHistoryCase3() throws Exception {
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setDepositRecordNo("21222245");
		creditAccountTradeHistory.setAccountNo("CA21000000019141");
		creditAccountTradeHistory.setReservedFields1("预留1");
		creditAccountTradeHistory.setReservedFields2("预留2");
		creditAccountTradeHistory.setReservedFields3("预留3");
		creditAccountTradeHistory.setReservedFields4("预留4");
		creditAccountTradeHistory.setReservedFields5("预留5");
		creditAccountTradeHistory.setTradeCode("0001_001_001");
		creditAccountTradeHistory.setTradeNo("824544488889");
		creditAccountTradeHistory.setTradeGmtCreated(new Date());
		creditAccountTradeHistory.setTradeReqCode("deposit_0_0_1");
		creditAccountTradeHistory.setTradeStepNo("4645645645");
		creditAccountTradeHistory.setSequenceNo("da4557887740");
		creditAccountTradeHistory.setRmk("生成记录");
		creditAccountTradeHistory.setAvlBalIncrAmt(100l);
		creditAccountTradeHistory.setFrozenBalIncrAmt(10l);
		creditAccountTradeHistory.setAvlBalDecrAmt(100l);
		creditAccountTradeHistory.setFrozenBalDecrAmt(10l);
		creditAccountTradeHistory.setSysTime(new Date());
		creditAccountTradeHistory.setGmtCreated(new Date());
		
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(1l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setAccountNo("CA21000000019141");
		vo.setCoreMerchantNo("ebillmaster");
		vo.setPoolNo("PN01000000000003124");
		vo.setReservedFields1("预留1");
		vo.setReservedFields2("预留2");
		vo.setReservedFields3("预留3");
		vo.setReservedFields4("预留4");
		vo.setReservedFields5("预留5");
		vo.setTradeCode("0001_001_001");
		vo.setTradeNo("456");
		vo.setTradeGmtCreated(new Date());
		vo.setRmk("备注123123");
		vo.setTradeReqCode("0001_001_001");
		vo.setTradeStepNo("4645645645");
		vo.setSequenceNo("234234234234234");
		vo.setAvlBalDecrAmt(Long.valueOf(32323));
		vo.setAvlBalIncrAmt(Long.valueOf(1));
		vo.setFrozenBalDecrAmt(Long.valueOf(54));
		vo.setFrozenBalIncrAmt(Long.valueOf(8454));
		BusinessUncheckedException ex=null;
		try {
			StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryDepositRecordNum, "123456");
			CreditAccountTradeHistoryMapperMock.mockInsert(creditAccountTradeHistoryMapper);
			CreditAccountTradeHistoryMapperMock.mockSelectByPrimaryKeyException(creditAccountTradeHistoryMapper);
			AccountingRecord accountRecord = creditAccountTradeHistoryService.insertCaTradeHistory(vo,creditAccount,new Date());
		} catch (BusinessUncheckedException e) {
			ex=e;		
		}
		assertNotNull("异常信息不为空",ex);
		assertEquals("返回异常信息符合预期","系统异常",ex.getErrorMessage());
		assertEquals("返回异常错误码符合预期",ErrorCode001Constants.SYSTEM_EXCEPTION,ex.getErrorCode());
	}

	/**
	 * 模拟异常
	 * AmountConvertException异常
	 * @throws Exception
	 */
	@Test
	public void testInsertCaTradeHistoryCase4() throws Exception {
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setDepositRecordNo("21222245");
		creditAccountTradeHistory.setAccountNo("CA21000000019141");
		creditAccountTradeHistory.setReservedFields1("预留1");
		creditAccountTradeHistory.setReservedFields2("预留2");
		creditAccountTradeHistory.setReservedFields3("预留3");
		creditAccountTradeHistory.setReservedFields4("预留4");
		creditAccountTradeHistory.setReservedFields5("预留5");
		creditAccountTradeHistory.setTradeCode("0001_001_001");
		creditAccountTradeHistory.setTradeNo("824544488889");
		creditAccountTradeHistory.setTradeGmtCreated(new Date());
		creditAccountTradeHistory.setTradeReqCode("deposit_0_0_1");
		creditAccountTradeHistory.setTradeStepNo("4645645645");
		creditAccountTradeHistory.setSequenceNo("da4557887740");
		creditAccountTradeHistory.setRmk("生成记录");
		creditAccountTradeHistory.setAvlBalIncrAmt(100l);
		creditAccountTradeHistory.setFrozenBalIncrAmt(10l);
		creditAccountTradeHistory.setAvlBalDecrAmt(100l);
		creditAccountTradeHistory.setFrozenBalDecrAmt(10l);
		creditAccountTradeHistory.setSysTime(new Date());
		creditAccountTradeHistory.setGmtCreated(new Date());
		
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(1l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setAccountNo("CA21000000019141");
		vo.setCoreMerchantNo("ebillmaster");
		vo.setPoolNo("PN01000000000003124");
		vo.setReservedFields1("预留1");
		vo.setReservedFields2("预留2");
		vo.setReservedFields3("预留3");
		vo.setReservedFields4("预留4");
		vo.setReservedFields5("预留5");
		vo.setTradeCode("0001_001_001");
		vo.setTradeNo("456");
		vo.setTradeGmtCreated(new Date());
		vo.setRmk("备注123123");
		vo.setTradeReqCode("0001_001_001");
		vo.setTradeStepNo("4645645645");
		vo.setSequenceNo("234234234234234");
		vo.setFrozenBalIncrAmt(Long.valueOf(8454));
		BusinessUncheckedException ex=null;
		try {
			StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryDepositRecordNum, "123456");
			AmountUtilsMock.mockBizAmountConvertToLongAmountConverException(creditAccount.getFreezenBalance().toString());
			CreditAccountTradeHistoryMapperMock.mockInsert(creditAccountTradeHistoryMapper);
			CreditAccountTradeHistoryMapperMock.mockSelectByPrimaryKeyException(creditAccountTradeHistoryMapper);
			AccountingRecord accountRecord = creditAccountTradeHistoryService.insertCaTradeHistory(vo,creditAccount,new Date());
		} catch (BusinessUncheckedException e) {
			ex=e;
		}
		assertNotNull("异常信息不为空",ex);
		assertEquals("返回异常信息符合预期","系统异常",ex.getErrorMessage());
		assertEquals("返回异常错误码符合预期",ErrorCode001Constants.SYSTEM_EXCEPTION,ex.getErrorCode());
	}
	/**
	 * 模拟异常
	 * NumberFormatException异常
	 * @throws Exception
	 */
	@Test
	public void testInsertCaTradeHistoryCase5() throws Exception {
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setDepositRecordNo("21222245");
		creditAccountTradeHistory.setAccountNo("CA21000000019141");
		creditAccountTradeHistory.setReservedFields1("预留1");
		creditAccountTradeHistory.setReservedFields2("预留2");
		creditAccountTradeHistory.setReservedFields3("预留3");
		creditAccountTradeHistory.setReservedFields4("预留4");
		creditAccountTradeHistory.setReservedFields5("预留5");
		creditAccountTradeHistory.setTradeCode("0001_001_001");
		creditAccountTradeHistory.setTradeNo("824544488889");
		creditAccountTradeHistory.setTradeGmtCreated(new Date());
		creditAccountTradeHistory.setTradeReqCode("deposit_0_0_1");
		creditAccountTradeHistory.setTradeStepNo("4645645645");
		creditAccountTradeHistory.setSequenceNo("da4557887740");
		creditAccountTradeHistory.setRmk("生成记录");
		creditAccountTradeHistory.setAvlBalIncrAmt(100l);
		creditAccountTradeHistory.setFrozenBalIncrAmt(10l);
		creditAccountTradeHistory.setAvlBalDecrAmt(100l);
		creditAccountTradeHistory.setFrozenBalDecrAmt(10l);
		creditAccountTradeHistory.setSysTime(new Date());
		creditAccountTradeHistory.setGmtCreated(new Date());
		
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(1l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setAccountNo("CA21000000019141");
		vo.setCoreMerchantNo("ebillmaster");
		vo.setPoolNo("PN01000000000003124");
		vo.setReservedFields1("预留1");
		vo.setReservedFields2("预留2");
		vo.setReservedFields3("预留3");
		vo.setReservedFields4("预留4");
		vo.setReservedFields5("预留5");
		vo.setTradeCode("0001_001_001");
		vo.setTradeNo("456");
		vo.setTradeGmtCreated(new Date());
		vo.setRmk("备注123123");
		vo.setTradeReqCode("0001_001_001");
		vo.setTradeStepNo("4645645645");
		vo.setSequenceNo("234234234234234");
		vo.setFrozenBalIncrAmt(Long.valueOf(8454));
		BusinessUncheckedException ex=null;
		try {
			StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryDepositRecordNum, "123456");
			AmountUtilsMock.mockBizAmountConvertToLongNumberFormatException(creditAccount.getFreezenBalance().toString());
			CreditAccountTradeHistoryMapperMock.mockInsert(creditAccountTradeHistoryMapper);
			CreditAccountTradeHistoryMapperMock.mockSelectByPrimaryKeyException(creditAccountTradeHistoryMapper);
			AccountingRecord accountRecord = creditAccountTradeHistoryService.insertCaTradeHistory(vo,creditAccount,new Date());
		} catch (BusinessUncheckedException e) {
			ex=e;
		}
		assertNotNull("异常信息不为空",ex);
		assertEquals("返回异常信息符合预期","系统异常",ex.getErrorMessage());
		assertEquals("返回异常错误码符合预期",ErrorCode001Constants.SYSTEM_EXCEPTION,ex.getErrorCode());
	}
	/**
	 * 测试维护老版账务流水
	 * AvlBalIncrAmt不为空且不为0
	 * AvlBalDecrAmt不为空且不为0
	 * FrozenBalIncrAmt为0
	 * FrozenBalDecrAmt为0
	 * 覆盖两个分支中第一个分支
	 */
	@Test
	public void testInsertOldCaTradeHistoryCase1(){
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setAvlBalIncrAmt(10l);
		creditAccountTradeHistory.setFrozenBalIncrAmt(0l);
		creditAccountTradeHistory.setAvlBalDecrAmt(10l);
		creditAccountTradeHistory.setFrozenBalDecrAmt(0l);
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(1l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setAccountNo("CA21000000019141");
		vo.setCoreMerchantNo("ebillmaster");
		vo.setPoolNo("PN01000000000003124");
		vo.setReservedFields1("预留1");
		vo.setReservedFields2("预留2");
		vo.setReservedFields3("预留3");
		vo.setReservedFields4("预留4");
		vo.setReservedFields5("预留5");
		vo.setTradeCode("0001_001_001");
		vo.setTradeNo("456");
		vo.setTradeGmtCreated(new Date());
		vo.setRmk("备注123123");
		vo.setTradeReqCode("0001_001_001");
		vo.setTradeStepNo("4645645645");
		vo.setSequenceNo("234234234234234");
		vo.setAvlBalDecrAmt(Long.valueOf(32323));
		CreditAccountTradeHistory cath=creditAccountTradeHistoryService.insertOldCaTradeHistory(creditAccountTradeHistory, creditAccount, vo);
		System.out.println(cath);
		assertNotNull("返回结果不为空",cath);
	}
	/**
	 * 测试维护老版账务流水
	 * AvlBalIncrAmt为0
	 * AvlBalDecrAmt为0
	 * FrozenBalIncrAmt不为空且不为0
	 * FrozenBalDecrAmt不为空且不为0
	 * 覆盖两个分支中第二个分支
	 */
	@Test
	public void testInsertOldCaTradeHistoryCase2(){
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setAvlBalIncrAmt(0l);
		creditAccountTradeHistory.setFrozenBalIncrAmt(10l);
		creditAccountTradeHistory.setAvlBalDecrAmt(0l);
		creditAccountTradeHistory.setFrozenBalDecrAmt(10l);
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(1l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setAccountNo("CA21000000019141");
		vo.setCoreMerchantNo("ebillmaster");
		vo.setPoolNo("PN01000000000003124");
		vo.setReservedFields1("预留1");
		vo.setReservedFields2("预留2");
		vo.setReservedFields3("预留3");
		vo.setReservedFields4("预留4");
		vo.setReservedFields5("预留5");
		vo.setTradeCode("0001_001_001");
		vo.setTradeNo("456");
		vo.setTradeGmtCreated(new Date());
		vo.setRmk("备注123123");
		vo.setTradeReqCode("0001_001_001");
		vo.setTradeStepNo("4645645645");
		vo.setSequenceNo("234234234234234");
		vo.setAvlBalDecrAmt(Long.valueOf(32323));
		CreditAccountTradeHistory cath=creditAccountTradeHistoryService.insertOldCaTradeHistory(creditAccountTradeHistory, creditAccount, vo);
		System.out.println(cath);
		assertNotNull("返回结果不为空",cath);
	}
	/**
	 * 测试维护老版账务流水
	 * AvlBalIncrAmt为空
	 * AvlBalDecrAmt为空
	 * FrozenBalIncrAmt为空
	 * FrozenBalDecrAmt为空
	 * 覆盖两个分支中第三个分支
	 */
	@Test
	public void testInsertOldCaTradeHistoryCase3(){
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
//		creditAccountTradeHistory.setAvlBalIncrAmt(0l);
//		creditAccountTradeHistory.setFrozenBalIncrAmt(10l);
//		creditAccountTradeHistory.setAvlBalDecrAmt(0l);
//		creditAccountTradeHistory.setFrozenBalDecrAmt(10l);
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(1l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
		RealTimeAccountingVo vo = new RealTimeAccountingVo();
		vo.setAccountNo("CA21000000019141");
		vo.setCoreMerchantNo("ebillmaster");
		vo.setPoolNo("PN01000000000003124");
		vo.setReservedFields1("预留1");
		vo.setReservedFields2("预留2");
		vo.setReservedFields3("预留3");
		vo.setReservedFields4("预留4");
		vo.setReservedFields5("预留5");
		vo.setTradeCode("0001_001_001");
		vo.setTradeNo("456");
		vo.setTradeGmtCreated(new Date());
		vo.setRmk("备注123123");
		vo.setTradeReqCode("0001_001_001");
		vo.setTradeStepNo("4645645645");
		vo.setSequenceNo("234234234234234");
		vo.setAvlBalDecrAmt(Long.valueOf(32323));
		CreditAccountTradeHistory cath=creditAccountTradeHistoryService.insertOldCaTradeHistory(creditAccountTradeHistory, creditAccount, vo);
		System.out.println(cath);
		assertNotNull("返回结果不为空",cath);
	}
	
	/**
	 * 测试生成账户记录
	 * 保留字段不为空，可用余额增加金额、减少金额，冻结余额增加金额、减少金额不为空
	 */
	@Test
	public void testGenerateAccountingRecordCase1()throws Exception{
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setDepositRecordNo("21222245");
		creditAccountTradeHistory.setAccountNo("CA21000000019141");
		creditAccountTradeHistory.setReservedFields1("预留1");
		creditAccountTradeHistory.setReservedFields2("预留2");
		creditAccountTradeHistory.setReservedFields3("预留3");
		creditAccountTradeHistory.setReservedFields4("预留4");
		creditAccountTradeHistory.setReservedFields5("预留5");
		creditAccountTradeHistory.setTradeCode("0001_001_001");
		creditAccountTradeHistory.setTradeNo("824544488889");
		creditAccountTradeHistory.setTradeGmtCreated(new Date());
		creditAccountTradeHistory.setTradeReqCode("deposit_0_0_1");
		creditAccountTradeHistory.setTradeStepNo("4645645645");
		creditAccountTradeHistory.setSequenceNo("da4557887740");
		creditAccountTradeHistory.setRmk("生成记录");
		creditAccountTradeHistory.setAvlBalIncrAmt(100l);
		creditAccountTradeHistory.setFrozenBalIncrAmt(10l);
		creditAccountTradeHistory.setAvlBalDecrAmt(100l);
		creditAccountTradeHistory.setFrozenBalDecrAmt(10l);
		creditAccountTradeHistory.setId(1);
		creditAccountTradeHistory.setSysTime(new Date());
		creditAccountTradeHistory.setGmtCreated(new Date());
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(1l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
        CreditAccountTradeHistoryMapperMock.mockSelectByPrimaryKey(creditAccountTradeHistoryMapper,creditAccountTradeHistory);
		AccountingRecord accountRecord = creditAccountTradeHistoryService.generateAccountingRecord(creditAccount, creditAccountTradeHistory);
		assertNotNull("返回结果不应为空",accountRecord);
	}
	
	/**
	 * 测试生成账户记录异常
	 * 保留字段1、4不为空，可用余额增加金额、减少金额，冻结余额增加金额、减少金额不为空
	 */
	@Test
	public void testGenerateAccountingRecordCase2()throws Exception{
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setDepositRecordNo("21222245");
		creditAccountTradeHistory.setAccountNo("CA21000000019141");
		creditAccountTradeHistory.setReservedFields1("预留1");
		creditAccountTradeHistory.setReservedFields4("预留4");
		creditAccountTradeHistory.setTradeCode("0001_001_001");
		creditAccountTradeHistory.setTradeNo("824544488889");
		creditAccountTradeHistory.setTradeGmtCreated(new Date());
		creditAccountTradeHistory.setTradeReqCode("deposit_0_0_1");
		creditAccountTradeHistory.setTradeStepNo("4645645645");
		creditAccountTradeHistory.setSequenceNo("da4557887740");
		creditAccountTradeHistory.setRmk("生成记录");
		creditAccountTradeHistory.setAvlBalIncrAmt(100l);
		creditAccountTradeHistory.setFrozenBalIncrAmt(10l);
		creditAccountTradeHistory.setAvlBalDecrAmt(100l);
		creditAccountTradeHistory.setFrozenBalDecrAmt(10l);
		creditAccountTradeHistory.setId(1);
		creditAccountTradeHistory.setSysTime(new Date());
		creditAccountTradeHistory.setGmtCreated(new Date());
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setPoolNo("PN01000000000003124");
		creditAccount.setVersion(1l);
		creditAccount.setAvailableBalance(153d);
		creditAccount.setFreezenBalance(11d);
		creditAccount.setMerchantNo("CC_444684545");
		Exception ex=null;
		try {
			CreditAccountTradeHistoryMapperMock.mockSelectByPrimaryKeyException(creditAccountTradeHistoryMapper);
			AccountingRecord accountRecord = creditAccountTradeHistoryService.generateAccountingRecord(creditAccount, creditAccountTradeHistory);
			assertNull("返回结果应该为空",accountRecord);
		} catch (Exception e) {
			ex=e;
		}
		LOGGER.debug(ex.getMessage());
		assertNotNull("mock异常，异常信息不为空",ex);
	}
		
	/**
	 * 单账户查询(标准版)
	 * @Description: 单账户查询(标准版)
	 * 				由于分表要求gmt_create类型为date，修改了起始时间的类型针对这个问题做的测试
	 * 				case1：两个时间都传
	 * 按条件查询单账户信息
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase1(){
		SingleAccountHisQueryReqVo req = new SingleAccountHisQueryReqVo();
		req.setAccountNo("186791");
		req.setOutTradeNo("1379543234434");
		req.setTradeCode("123");
		req.setTradeNo("456");
		req.setTradeReqCode("avl_decr");
		req.setTradeReqNo("12345907654");
		
		req.setGmtCreateBegin("2015-12-01 00:00:00");
		req.setGmtCreateEnd("2016-12-30 00:00:00");
		req.setReservedFields1("可用金额减少1块钱");
		req.setSortType("01");
		List<SingleAccountAccountRecord> list=new ArrayList<SingleAccountAccountRecord>();
		SingleAccountAccountRecord saar=new SingleAccountAccountRecord();
		saar.setAccountNo("186791");
		list.add(saar);
		CreditAccountTradeHistoryMapperMock.mockSingleAccountHisPageQueryStand(creditAccountTradeHistoryMapper, list);
		List<SingleAccountAccountRecord> lists = creditAccountTradeHistoryService.singleAccountHisPageQueryStand(req);
		assertNotNull("返回结果不应该为空！",lists);
	}
	
	/**
	 * 单账户查询(标准版)
	 * @Description: 只有时间做参数查询
	 *模拟异常
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase2(){
		SingleAccountHisQueryReqVo req = new SingleAccountHisQueryReqVo();
		req.setAccountNo("CA21000000019141");
		req.setGmtCreateBegin("2015-11-23 14:23:06");
		req.setGmtCreateEnd("2015-11-23 14:23:06");
		List<SingleAccountAccountRecord> list=new ArrayList<SingleAccountAccountRecord>();
		Exception ex=null;
		try {
			CreditAccountTradeHistoryMapperMock.mockSingleAccountHisPageQueryStandException(creditAccountTradeHistoryMapper);
			list = creditAccountTradeHistoryService
					.singleAccountHisPageQueryStand(req);
		} catch (Exception e) {
			ex=e;
		}
		assertNotNull("异常信息不应为空",ex);
	}

	/**
	 * 单账户查询(标准版)
	 * @Description: 通过时间筛选没有记录
	 * 模拟没有记录的查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase3(){
		SingleAccountHisQueryReqVo req = new SingleAccountHisQueryReqVo();
		req.setAccountNo("186791");	
		req.setGmtCreateBegin("2015-11-23 14:23:07");
		req.setGmtCreateEnd("2015-11-23 14:23:08");
		List<SingleAccountAccountRecord> list=new ArrayList<SingleAccountAccountRecord>();
		CreditAccountTradeHistoryMapperMock.mockSingleAccountHisPageQueryStand(creditAccountTradeHistoryMapper,list);
		List<SingleAccountAccountRecord> listRecord = creditAccountTradeHistoryService.singleAccountHisPageQueryStand(req);
		assertEquals("查询不到记录，记录为0条!",0,listRecord.size());
	}

	
	/**
	 * 统计总数
	 * @Description: 多条件查询
	 */
	@Test
	public void testCountSingleAccountHisQueryCase1(){
		SingleAccountHisQueryReqVo req = new SingleAccountHisQueryReqVo();
		req.setAccountNo("186791");
		req.setOutTradeNo("1379543234434");
		req.setTradeCode("123");
		req.setTradeNo("456");
		req.setTradeReqCode("avl_decr");
		req.setTradeReqNo("12345907654");
		
		req.setGmtCreateBegin("2015-12-01 00:00:00");
		req.setGmtCreateEnd("2015-12-30 00:00:00");
		req.setReservedFields1("可用金额减少1块钱");
		CreditAccountTradeHistoryMapperMock.mockCountSingleAccountHisQuery(creditAccountTradeHistoryMapper);
		int count = creditAccountTradeHistoryService.countSingleAccountHisQuery(req);
		System.out.println(count);
		assertNotEquals("不应该为0条", 0, count);
	}
	
	/**
	 * 统计总数
	 * @Description: 只有时间和 必要条件
	 */
	@Test
	public void testCountSingleAccountHisQueryCase2(){
		SingleAccountHisQueryReqVo req = new SingleAccountHisQueryReqVo();
		req.setAccountNo("186791");
		req.setGmtCreateBegin("2015-11-23 12:23:06");
		req.setGmtCreateEnd("2015-11-23 14:43:26");
		CreditAccountTradeHistoryMapperMock.mockCountSingleAccountHisQuery(creditAccountTradeHistoryMapper);
		int count = creditAccountTradeHistoryService.countSingleAccountHisQuery(req);
		System.out.println(count);
		assertEquals("应该只有1条记录", 1, count);
		assertNotEquals("不应该为0条", 0, count);
		assertNotNull("不应该为空",count);
	}
	
	/**
	 * 统计总数
	 * @Description: 通过时间筛选没有记录
	 */
	@Test
	public void testCountSingleAccountHisQueryCase3(){
		SingleAccountHisQueryReqVo req = new SingleAccountHisQueryReqVo();
		req.setAccountNo("186791");
		req.setGmtCreateBegin("2015-11-23 15:53:07");
		req.setGmtCreateEnd("2015-11-23 16:23:08");
		CreditAccountTradeHistoryMapperMock.mockCountSingleAccountHisQueryNoCount(creditAccountTradeHistoryMapper);
		int count = creditAccountTradeHistoryService.countSingleAccountHisQuery(req);
		System.out.println(count);
		assertEquals("应该为0条记录", 0, count);
	}
		
	/**
	 * 
	 *  单账户账务历史查询接口--多条件
	 *  正常覆盖
	 */
	@Test
	public void testSingleAccountHisPageQueryCase1(){
		com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo vo = new com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo();
		vo.setCreditAccountId(186791);
		vo.setAccountNo("CA21000000019141");
		vo.setSequenceNo("EA2015112300000382156");
		vo.setTradeNo("0500005400201511230325097");
		vo.setTradeStepNo("20151123000000000367073");
		vo.setBeginTime("2015-11-01 00:00:00");
		vo.setEndTime("2015-12-30 00:00:00");
		vo.setCoreMerchantNo("ebillmaster");	
		List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> list=new ArrayList<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord>();
		
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA4154775214");
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r1=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA4154775487");
		list.add(r);
		list.add(r1);
		//模拟有ca
		CreditAccount ca=new CreditAccount();
		ca.setAccountNo("CA21000000019141");
		ca.setCoreMerchantNo("ebillmaster");
		ca.setId(4546);
		
		CreditAccountMapperMock.mockSelectByAccountNo(creditAccountMapper,ca);
		CreditAccountTradeHistoryMapperMock.mockSelectCountSingleAccountHis(creditAccountTradeHistoryMapper);
		CreditAccountTradeHistoryMapperMock.mockSingleAccountHisPageQuery(creditAccountTradeHistoryMapper,list);
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountHisPageQueryRspVo respVo = creditAccountTradeHistoryService.singleAccountHisPageQuery(vo);
		List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> listRecord = respVo.getList();
		assertNotNull("不应该为空",listRecord);
		assertEquals("查询条数应为2",2,listRecord.size());
	}
	/**
	 *  单账户账务历史查询接口--多条件
	 *  账户表中的核心商户和参数中的核心商户不符   --业务异常
	 */
	@Test
	public void testSingleAccountHisPageQueryCase2(){
		com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo vo = new com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo();
		vo.setCreditAccountId(186791);
		vo.setAccountNo("CA21000000019141");
		vo.setSequenceNo("EA2015112300000382156");
		vo.setTradeNo("0500005400201511230325097");
		vo.setTradeStepNo("20151123000000000367073");
		vo.setBeginTime("2015-11-01 00:00:00");
		vo.setEndTime("2015-12-30 00:00:00");
		vo.setCoreMerchantNo("ebillmaster");	
		List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> list=new ArrayList<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord>();
		
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA4154775214");
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r1=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA4154775487");
		list.add(r);
		list.add(r1);
		//模拟有ca
		CreditAccount ca=new CreditAccount();
    	ca.setAccountNo("CA21000dfa4f4adfa");
		ca.setCoreMerchantNo("liantuo");
		ca.setId(4546);
		BusinessUncheckedException ex=null;
		try {
		    CreditAccountMapperMock.mockSelectByAccountNo(creditAccountMapper,ca);
			CreditAccountTradeHistoryMapperMock.mockSelectCountSingleAccountHis(creditAccountTradeHistoryMapper);
			CreditAccountTradeHistoryMapperMock.mockSingleAccountHisPageQuery(creditAccountTradeHistoryMapper,list);
			com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountHisPageQueryRspVo respVo = creditAccountTradeHistoryService.singleAccountHisPageQuery(vo);
			List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> listRecord = respVo.getList();
			assertNotNull("不应该为空",listRecord);
			assertEquals("查询条数应为2",2,listRecord.size());
		}catch(BusinessUncheckedException e){
			ex=e;
		}
		assertNotNull("异常信息不为空",ex);
		assertEquals("返回异常信息符合预期","CA21000000019141账户表中的核心商户和参数中的核心商户不符",ex.getErrorMessage());
		assertEquals("返回异常错误码符合预期",ErrorCode001Constants.CORE_MERCHANT_NO_NOT_CORRECT,ex.getErrorCode());
	}
	
	/**
	 *  单账户账务历史查询接口--多条件
	 *  CA21000000019141账户不存在--业务异常
	 */
	@Test
	public void testSingleAccountHisPageQueryCase3(){
		com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo vo = new com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo();
		vo.setCreditAccountId(186791);
		vo.setAccountNo("CA21000000019141");
		vo.setSequenceNo("EA2015112300000382156");
		vo.setTradeNo("0500005400201511230325097");
		vo.setTradeStepNo("20151123000000000367073");
		vo.setBeginTime("2015-11-01 00:00:00");
		vo.setEndTime("2015-12-30 00:00:00");
		vo.setCoreMerchantNo("ebillmaster");	
		List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> list=new ArrayList<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord>();
		
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA4154775214");
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r1=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA4154775487");
		list.add(r);
		list.add(r1);
		//模拟有ca
		CreditAccount ca=new CreditAccount();
    	ca.setAccountNo("CA21000dfa4f4adfa");
		ca.setCoreMerchantNo("ebillmaster");
		ca.setId(4546);
		BusinessUncheckedException ex=null;
		try {
		    CreditAccountMapperMock.mockSelectByAccountNoNoResult(creditAccountMapper);
			CreditAccountTradeHistoryMapperMock.mockSelectCountSingleAccountHis(creditAccountTradeHistoryMapper);
			CreditAccountTradeHistoryMapperMock.mockSingleAccountHisPageQuery(creditAccountTradeHistoryMapper,list);
			com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountHisPageQueryRspVo respVo = creditAccountTradeHistoryService.singleAccountHisPageQuery(vo);
			List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> listRecord = respVo.getList();
			assertNotNull("不应该为空",listRecord);
			assertEquals("查询条数应为2",2,listRecord.size());
		}catch(BusinessUncheckedException e){
			ex=e;
		}
		assertNotNull("异常信息不为空",ex);
		assertEquals("返回异常信息符合预期","CA21000000019141账户不存在",ex.getErrorMessage());
		assertEquals("返回异常错误码符合预期",ErrorCode001Constants.ACCOUNT_NOT_EXIST,ex.getErrorCode());
	}
	/**
	 * 单账户账务历史查询接口--只有时间和必要条件
	 */
	@Test
	public void testSingleAccountHisPageQueryCase4(){
		com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo vo = new com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo();
		vo.setCreditAccountId(186791);
		vo.setAccountNo("CA21000000019141");
		vo.setBeginTime("2015-11-01 00:00:00");
		vo.setEndTime("2015-12-30 00:00:00");
		vo.setCoreMerchantNo("ebillmaster");	
		List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> list=new ArrayList<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord>();
		
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA4154775214");
		
		list.add(r);
		//模拟有ca
		CreditAccount ca=new CreditAccount();
		ca.setAccountNo("CA21000000019141");
		ca.setCoreMerchantNo("ebillmaster");
		ca.setId(4546);
		
		CreditAccountMapperMock.mockSelectByAccountNo(creditAccountMapper,ca);
		CreditAccountTradeHistoryMapperMock.mockSelectCountSingleAccountHis(creditAccountTradeHistoryMapper);
		CreditAccountTradeHistoryMapperMock.mockSingleAccountHisPageQuery(creditAccountTradeHistoryMapper,list);
		
			
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountHisPageQueryRspVo respVo = creditAccountTradeHistoryService.singleAccountHisPageQuery(vo);
		List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> listRecord = respVo.getList();
		assertNotNull("不应该为空",listRecord);
		assertEquals("应该只有1条记录", 1, listRecord.size());
	}
	
	/** 
	 * 单账户账务历史查询接口--只有时间和必要条件
	 * 查询为空的情况
	 */
	@Test
	public void testSingleAccountHisPageQueryCase5(){
		com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo vo = new com.liantuo.deposit.advanceaccount.web.vo.req.SingleAccountHisPageQueryReqVo();
		vo.setCreditAccountId(186791);
		vo.setAccountNo("CA21000000019141");
		vo.setBeginTime("2015-11-01 00:00:00");
		vo.setEndTime("2015-12-30 00:00:00");
		vo.setCoreMerchantNo("ebillmaster");	
		List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> list=new ArrayList<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord>();
		//模拟有ca
		CreditAccount ca=new CreditAccount();
		ca.setAccountNo("CA21000000019141");
		ca.setCoreMerchantNo("ebillmaster");
		ca.setId(4546);
		
		CreditAccountMapperMock.mockSelectByAccountNo(creditAccountMapper,ca);
		CreditAccountTradeHistoryMapperMock.mockSelectCountSingleAccountHis(creditAccountTradeHistoryMapper);
		CreditAccountTradeHistoryMapperMock.mockSingleAccountHisPageQueryNoResult(creditAccountTradeHistoryMapper);
		
			
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountHisPageQueryRspVo respVo = creditAccountTradeHistoryService.singleAccountHisPageQuery(vo);
		List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> listRecord = respVo.getList();
		assertNull("应该为空",listRecord);
	}
	
	
	/**
	 * 单账户账务历史查询接口(内部接口)
	 * 条件查询
	 */
	@Test
	public void testInnerSingleCAHisPageQueryCase1(){
		SingleAccountHisPageQueryReqVo vo = new SingleAccountHisPageQueryReqVo();
		vo.setCreditAccountId(186791);
		vo.setAccountNo("CA21000000019141");
		vo.setSequenceNo("EA2015112300000382156");
		vo.setTradeNo("0500005400201511230325097");
		vo.setTradeStepNo("20151123000000000367073");
		vo.setBeginTime("2015-11-01 00:00:00");
		vo.setEndTime("2015-12-30 00:00:00");
		
		CreditAccount ca=new CreditAccount();
		ca.setAccountNo("CA21000000019141");
		ca.setCoreMerchantNo("ebillmaster");
		ca.setId(4546);
		
        List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> list=new ArrayList<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord>();
		
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA4154775214");
		
		list.add(r);
		CreditAccountMapperMock.mockSelectByAccountNo(creditAccountMapper,ca);
		CreditAccountTradeHistoryMapperMock.mockSelectCountSingleInnerCAHis(creditAccountTradeHistoryMapper);
		CreditAccountTradeHistoryMapperMock.mockSelectSingleInnerCAHisPageQuery(creditAccountTradeHistoryMapper,list);
		SingleAccountHisPageQueryRspVo respVo = creditAccountTradeHistoryService.innerSingleCAHisPageQuery(vo);
		List<SingleAccountAccountingRecord> listRecord = respVo.getList();
		assertNotNull("不应该为空！",listRecord);
	}
	
	/**
	 * 单账户账务历史查询接口(内部接口)
	 *  只有时间作为条件
	 * CA21000000019141账户不存在--业务异常
	 */
	@Test
	public void testInnerSingleCAHisPageQueryCase2(){
		SingleAccountHisPageQueryReqVo vo = new SingleAccountHisPageQueryReqVo();
		vo.setCreditAccountId(186791);
		vo.setAccountNo("CA21000000019141");
		vo.setSequenceNo("EA2015112300000382156");
		vo.setTradeNo("0500005400201511230325097");
		vo.setTradeStepNo("20151123000000000367073");
		vo.setBeginTime("2015-11-01 00:00:00");
		vo.setEndTime("2015-12-30 00:00:00");
		
		CreditAccount ca=new CreditAccount();
		ca.setAccountNo("CA21000000019141");
		ca.setCoreMerchantNo("ebillmaster");
		ca.setId(4546);
		
        List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> list=new ArrayList<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord>();
		
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA41547df75214");
		
		list.add(r);
		BusinessUncheckedException ex=null;
		try {
			CreditAccountMapperMock.mockSelectByAccountNoNoResult(creditAccountMapper);
			CreditAccountTradeHistoryMapperMock.mockSelectCountSingleInnerCAHis(creditAccountTradeHistoryMapper);
			CreditAccountTradeHistoryMapperMock.mockSelectSingleInnerCAHisPageQuery(creditAccountTradeHistoryMapper,list);
			SingleAccountHisPageQueryRspVo respVo = creditAccountTradeHistoryService.innerSingleCAHisPageQuery(vo);
			List<SingleAccountAccountingRecord> listRecord = respVo.getList();
		} catch (BusinessUncheckedException e) {
			ex=e;
		}
		assertNotNull("异常信息不为空",ex);
		assertEquals("返回异常信息符合预期","CA21000000019141账户不存在",ex.getErrorMessage());
		assertEquals("返回异常错误码符合预期",ErrorCode003Constants.INNER_ACCOUNT_NOT_EXIST,ex.getErrorCode());
	}
	
	/**
	 * 单账户账务历史查询接口(内部接口)
	 * @Description: 通过时间筛选，没有记录
	 */
	@Test
	public void testInnerSingleCAHisPageQueryCase3(){
		SingleAccountHisPageQueryReqVo vo = new SingleAccountHisPageQueryReqVo();
		vo.setCreditAccountId(186791);
		vo.setAccountNo("CA21000000019141");
		vo.setSequenceNo("EA2015112300000382156");
		vo.setTradeNo("0500005400201511230325097");
		vo.setTradeStepNo("20151123000000000367073");
		vo.setBeginTime("2015-11-01 00:00:00");
		vo.setEndTime("2015-12-30 00:00:00");
		
		CreditAccount ca=new CreditAccount();
		ca.setAccountNo("CA21000000019141");
		ca.setCoreMerchantNo("ebillmaster");
		ca.setId(4546);
		
        List<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord> list=new ArrayList<com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord>();
		
		com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord r=new com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord();
		r.setAccountNo("CA4154775214");
		
		list.add(r);
		CreditAccountMapperMock.mockSelectByAccountNo(creditAccountMapper,ca);
		CreditAccountTradeHistoryMapperMock.mockSelectCountSingleInnerCAHis(creditAccountTradeHistoryMapper);
		CreditAccountTradeHistoryMapperMock.mockSingleAccountHisPageQueryNoResult(creditAccountTradeHistoryMapper);
		SingleAccountHisPageQueryRspVo respVo = creditAccountTradeHistoryService.innerSingleCAHisPageQuery(vo);
		List<SingleAccountAccountingRecord> listRecord = respVo.getList();
		assertNull("应该为空！",listRecord);
	}
}
