package com.liantuo.deposit.advanceaccount.bus.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.util.ReflectionTestUtils;
import com.ebill.framework.exception.BusinessException;
import com.liantuo.deposit.advanceaccount.bus.service.impl.AccountForbidTradeServiceImpl;
import com.liantuo.deposit.advanceaccount.orm.mapper.AccountForbidMapperMock;
import com.liantuo.deposit.advanceaccount.orm.mapper.AccountForbidTradeMapper;
import com.liantuo.deposit.advanceaccount.orm.pojo.AccountForbidTrade;
import com.liantuo.deposit.advanceaccount.web.vo.req.AccountForbidReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.AccountForbidUpdateReqVo;
import com.liantuo.mc.web.client.MerchantClient;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.unittest.BaseServiceTest;
@RunWith(PowerMockRunner.class)
@PrepareForTest({ MerchantClient.class,AmountUtils.class})


public class AccountForbidServiceTest extends BaseServiceTest{
	@Resource
	private AccountForbidTradeService accountForbidTradeService = new AccountForbidTradeServiceImpl() ;
	@Mock
	private AccountForbidTradeMapper accountForbidTradeMapper;
	
	@Before
	public void init(){
		accountForbidTradeMapper = mock(AccountForbidTradeMapper.class);
		ReflectionTestUtils.setField(accountForbidTradeService, "accountForbidTradeMapper", accountForbidTradeMapper);
	}
 
	// 正常流程
	@Test
	public void createAccountForbid() throws Exception {

		AccountForbidUpdateReqVo body = new AccountForbidUpdateReqVo();
		body.setAccountNo("CA21000000037382");
		body.setMerchantNo("CC_123654");
		List<AccountForbidTrade> list = new ArrayList<AccountForbidTrade>();
		AccountForbidTrade vo = new AccountForbidTrade();
		vo.setAccountNo("CA21000000037382");
		vo.setForbidCode("0001_001");
		vo.setType("1");
		list.add(vo);
		List<AccountForbidReqVo> forbidList = new ArrayList<AccountForbidReqVo>();
		AccountForbidReqVo reqVo = new AccountForbidReqVo();
		AccountForbidReqVo reqVo2 = new AccountForbidReqVo();
		reqVo.setForbidCode("0001_001");
		reqVo.setForbidType("01");
		reqVo.setType("1");
		forbidList.add(reqVo);
		reqVo2.setForbidCode("0001_002");
		reqVo2.setForbidType("01");
		reqVo2.setType("0");
		forbidList.add(reqVo2);
		int result = 1;
		AccountForbidMapperMock.mockDeleteByPrimaryKey(accountForbidTradeMapper, result);
		AccountForbidMapperMock.mockInsert(accountForbidTradeMapper, result);
		//                                            body  根据CA查db   ForbidDetail
		accountForbidTradeService.createAccountForbid(body, list, forbidList);

		
	}
	 
	// list去重
	@Test
	public void createAccountForbid2() throws Exception {

		AccountForbidUpdateReqVo body = new AccountForbidUpdateReqVo();
		body.setAccountNo("CA21000000037382");
		body.setMerchantNo("CC_123654");
		List<AccountForbidTrade> list = new ArrayList<AccountForbidTrade>();
		AccountForbidTrade vo = new AccountForbidTrade();
		vo.setAccountNo("CA21000000037382");
		vo.setForbidCode("0001_001");
		vo.setType("1");
		list.add(vo);
		List<AccountForbidReqVo> forbidList = new ArrayList<AccountForbidReqVo>();
		AccountForbidReqVo reqVo = new AccountForbidReqVo();
		AccountForbidReqVo reqVo2 = new AccountForbidReqVo();
		reqVo.setForbidCode("0001_001");
		reqVo.setForbidType("01");
		reqVo.setType("1");
		forbidList.add(reqVo);
		reqVo2.setForbidCode("0001_001");
		reqVo2.setForbidType("01");
		reqVo2.setType("1");
		forbidList.add(reqVo2);
		int result = 1;
		AccountForbidMapperMock.mockDeleteByPrimaryKey(accountForbidTradeMapper, result);
		AccountForbidMapperMock.mockInsert(accountForbidTradeMapper, result);
		//                                            body  根据CA查db   ForbidDetail
		accountForbidTradeService.createAccountForbid(body, list, forbidList);
		
	}
	
	//  执行删除逻辑中中代码不存在异常
	@Test
	public void createAccountForbid3()  {
		AccountForbidUpdateReqVo body = new AccountForbidUpdateReqVo();
		body.setAccountNo("CA21000000037382");
		body.setMerchantNo("CC_123654");
		List<AccountForbidTrade> list = new ArrayList<AccountForbidTrade>();
		AccountForbidTrade vo = new AccountForbidTrade();
		vo.setAccountNo("CA21000000037382");
		vo.setForbidCode("0001_001");
		vo.setType("1");
//		list.add(vo);
		List<AccountForbidReqVo> forbidList = new ArrayList<AccountForbidReqVo>();
		AccountForbidReqVo reqVo = new AccountForbidReqVo();
		AccountForbidReqVo reqVo2 = new AccountForbidReqVo();
		reqVo.setForbidCode("0001_001");
		reqVo.setForbidType("01");
		reqVo.setType("1");
		forbidList.add(reqVo);
		reqVo2.setForbidCode("0001_001");
		reqVo2.setForbidType("01");
		reqVo2.setType("1");
		forbidList.add(reqVo2);
		int result = 1;
		AccountForbidMapperMock.mockDeleteByPrimaryKey(accountForbidTradeMapper, result);
		AccountForbidMapperMock.mockInsert(accountForbidTradeMapper, result);
		BusinessException e= null;
		//                                            body  根据CA查db   ForbidDetail
		try {
			accountForbidTradeService.createAccountForbid(body, list, forbidList);
			
		} catch (BusinessException e1) {
			e = e1;
		}catch (Exception e2) {
		}
		assertEquals("ZW00121000500",e.getErrorCode());
		
	}
	
	//禁止结构全部添加
	@Test
	public void createAccountForbid4()  {
		AccountForbidUpdateReqVo body = new AccountForbidUpdateReqVo();
		body.setAccountNo("CA21000000037382");
		body.setMerchantNo("CC_123654");
		List<AccountForbidTrade> list = new ArrayList<AccountForbidTrade>();
		List<AccountForbidReqVo> forbidList = new ArrayList<AccountForbidReqVo>();
		AccountForbidReqVo reqVo = new AccountForbidReqVo();
		AccountForbidReqVo reqVo2 = new AccountForbidReqVo();
		reqVo.setForbidCode("0001_001");
		reqVo.setForbidType("01");
		reqVo.setType("0");
		forbidList.add(reqVo);
		reqVo2.setForbidCode("0001_001");
		reqVo2.setForbidType("01");
		reqVo2.setType("0");
		forbidList.add(reqVo2);
		int result = 1;
		AccountForbidMapperMock.mockDeleteByPrimaryKey(accountForbidTradeMapper, result);
		AccountForbidMapperMock.mockInsert(accountForbidTradeMapper, result);
		BusinessException e = null;
		//                                            body  根据CA查db   ForbidDetail
		try {
			accountForbidTradeService.createAccountForbid(body, list, forbidList);
			
		} catch (BusinessException e1) {
			e = e1;
		}catch (Exception e2) {
		}
		
	}
	//异常块数据不可重复
	@Test
	public void createAccountForbid5()  {
		AccountForbidUpdateReqVo body = new AccountForbidUpdateReqVo();
		body.setAccountNo("CA21000000037382");
		body.setMerchantNo("CC_123654");
		List<AccountForbidTrade> list = new ArrayList<AccountForbidTrade>();
		AccountForbidTrade vo = new AccountForbidTrade();
		vo.setAccountNo("CA21000000037382");
		vo.setForbidCode("0001_001");
		vo.setType("1");
		list.add(vo);
		List<AccountForbidReqVo> forbidList = new ArrayList<AccountForbidReqVo>();
		AccountForbidReqVo reqVo = new AccountForbidReqVo();
		AccountForbidReqVo reqVo2 = new AccountForbidReqVo();
		reqVo.setForbidCode("0001_001");
		reqVo.setForbidType("01");
		reqVo.setType("0");
		forbidList.add(reqVo);
		reqVo2.setForbidCode("0001_001");
		reqVo2.setForbidType("01");
		reqVo2.setType("0");
		forbidList.add(reqVo2);
		int result = 1;
		AccountForbidMapperMock.mockDeleteByPrimaryKey(accountForbidTradeMapper, result);
		AccountForbidMapperMock.mockInsert(accountForbidTradeMapper, result);
		//                                            body  根据CA查db   ForbidDetail
		try {
			accountForbidTradeService.createAccountForbid(body, list, forbidList);
			
		} catch (BusinessException e) {
			
		}catch (Exception e) {
			
		}
		
	}
	
	// 删除禁止结构
	@Test
	public void createAccountForbid6()  {
		AccountForbidUpdateReqVo body = new AccountForbidUpdateReqVo();
		body.setAccountNo("CA21000000037382");
		body.setMerchantNo("CC_123654");
		List<AccountForbidTrade> list = new ArrayList<AccountForbidTrade>();
		AccountForbidTrade vo = new AccountForbidTrade();
		vo.setAccountNo("CA21000000037382");
		vo.setForbidCode("0002_001_001");
		vo.setType("1");
		list.add(vo);
		List<AccountForbidReqVo> forbidList = new ArrayList<AccountForbidReqVo>();
		AccountForbidReqVo reqVo = new AccountForbidReqVo();
		AccountForbidReqVo reqVo2 = new AccountForbidReqVo();
		reqVo.setForbidCode("0002_001_001");
		reqVo.setForbidType("02");
		reqVo.setType("1");
		forbidList.add(reqVo);
		reqVo2.setForbidCode("0001_001");
		reqVo2.setForbidType("01");
		reqVo2.setType("1");
		forbidList.add(reqVo2);
		int result = 1;
		AccountForbidMapperMock.mockDeleteByPrimaryKey(accountForbidTradeMapper, result);
		AccountForbidMapperMock.mockInsert(accountForbidTradeMapper, result);
		BusinessException e = null;
		try {
			accountForbidTradeService.createAccountForbid(body, list, forbidList);
			
		} catch (BusinessException e1) {
			e = e1;
			e.printStackTrace();
		}catch (Exception e2) {

		}
		assertEquals("ZW00121000500",e.getErrorCode());
		
	}
	
	// 根据accountNo查询
	@Test
	public void selectByCA()  {
		List<AccountForbidTrade> list  = accountForbidTradeService.selectByCA("CA21000000037382");
		System.out.println(list.size()+"==============");
	}
	
	//根据accountNo 查询类型是ALL的
	@Test
	public void selectWhetherForbidAllByCA()  {
		AccountForbidTrade vo = accountForbidTradeService.selectWhetherForbidAllByCA("CA21000000037382");
	}
	
	// 根据accountNo，forbidCode,type 查询
	@Test
	public void selectWhetherForbidThisTrade()  {
		AccountForbidTrade vo = new AccountForbidTrade();
		vo.setAccountNo("CA21000000037382");
		vo.setForbidCode("ALL");
		vo.setType("01");
		AccountForbidTrade returnVo  = accountForbidTradeService.selectWhetherForbidThisTrade(vo);
	}
	
	// 根据CA查询结果集
	@Test
	public void masterSelectByCA()  {
		List<AccountForbidTrade> list = accountForbidTradeService.masterSelectByCA("CA21000000037382");
	}
}
