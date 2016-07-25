package com.liantuo.deposit.advanceaccount.orm.mapper;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

import com.liantuo.deposit.advanceaccount.orm.pojo.AccountForbidTrade;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.common.constants.AccountForbidTradeConstants;
import com.liantuo.unittest.mockito.IsTClass;

public class AccountForbidTradeMapperMock {
	
	public static void mockSelectWhetherForbidAllByCANull(AccountForbidTradeMapper accountForbidTradeMapper,String accountNo){
		doReturn(null).when(accountForbidTradeMapper).selectWhetherForbidAllByCA(accountNo);
	}
	
	public static void mockSelectWhetherForbidAllByCANotNull(AccountForbidTradeMapper accountForbidTradeMapper
			,String accountNo
			,AccountForbidTrade accountForbidTrade){
		doReturn(accountForbidTrade).when(accountForbidTradeMapper).selectWhetherForbidAllByCA(accountNo);
	}
	
	public static void mockSelectWhetherForbidThisTradeNull(AccountForbidTradeMapper accountForbidTradeMapper){
		doReturn(null).when(accountForbidTradeMapper).selectWhetherForbidThisTrade(argThat(new IsTClass<AccountForbidTrade>(new AccountForbidTrade())));
	}
	
	public static void mockSelectWhetherForbidThisTradeNullAndNotNull(AccountForbidTradeMapper accountForbidTradeMapper,AccountForbidTrade accountForbidTrade){
		when(accountForbidTradeMapper.selectWhetherForbidThisTrade(argThat(new IsTClass<AccountForbidTrade>(new AccountForbidTrade())))).thenReturn(null).thenReturn(accountForbidTrade);
	}
	
	public static void mockSelectWhetherForbidThisTradeNotNull(AccountForbidTradeMapper accountForbidTradeMapper,AccountForbidTrade accountForbidTrade){
		doReturn(accountForbidTrade).when(accountForbidTradeMapper).selectWhetherForbidThisTrade(argThat(new IsTClass<AccountForbidTrade>(new AccountForbidTrade())));
	}
	
}
