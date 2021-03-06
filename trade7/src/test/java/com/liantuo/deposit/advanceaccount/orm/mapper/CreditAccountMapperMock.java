package com.liantuo.deposit.advanceaccount.orm.mapper;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.*;

import java.util.List;

import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.unittest.mockito.IsTClass;

public class CreditAccountMapperMock {

	
	public static void mockInsert(CreditAccountMapper accountMapper){
		doReturn(1).when(accountMapper).insert(argThat(new IsTClass<CreditAccount>(new CreditAccount())));
	}
	
	public static void mockInsertException(CreditAccountMapper accountMapper){
		doThrow(new BusinessException()).when(accountMapper).insert(argThat(new IsTClass<CreditAccount>(new CreditAccount())));
	}
	
	public static void mockUpdateAvlBalance(CreditAccountMapper accountMapper){
		doReturn(1).when(accountMapper).updateAvlBalance(argThat(new IsTClass<CreditAccount>(new CreditAccount())));
	}
	
	public static void mockUpdateAvlBalanceFailed(CreditAccountMapper accountMapper){
		doReturn(0).when(accountMapper).updateAvlBalance(argThat(new IsTClass<CreditAccount>(new CreditAccount())));
	}
	
	public static void mockUpdateFrozenBalance(CreditAccountMapper accountMapper){
		doReturn(1).when(accountMapper).updateFrozenBalance(argThat(new IsTClass<CreditAccount>(new CreditAccount())));
	}
	
	public static void mockUpdateFrozenBalanceFailed(CreditAccountMapper accountMapper){
		doReturn(0).when(accountMapper).updateFrozenBalance(argThat(new IsTClass<CreditAccount>(new CreditAccount())));
	}
	
	public static void mockFindAdvanceAccountByAccountNo(CreditAccountMapper accountMapper,List<CreditAccount> list,String accountNo){
		doReturn(list).when(accountMapper).findAdvanceAccountByAccountNo(accountNo);
	}
	
	public static void mockSelectByIdForUpdate(CreditAccountMapper accountMapper,CreditAccount ca){
		when(accountMapper.selectByIdForUpdate(anyInt())).thenReturn(ca);
		
	}
    
	public static void mockSelectByAccountNo(CreditAccountMapper accountMapper,CreditAccount creditAccount){
		doReturn(creditAccount).when(accountMapper).selectByAccountNo(argThat(new IsTClass<String>(creditAccount.getAccountNo())));
	}
	
	public static void mockSelectByAccountNoNoResult(CreditAccountMapper accountMapper){
		doReturn(null).when(accountMapper).selectByAccountNo(argThat(new IsTClass<String>("")));
	}
}
