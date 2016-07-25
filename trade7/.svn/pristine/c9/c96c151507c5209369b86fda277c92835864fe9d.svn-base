package com.liantuo.deposit.advanceaccount.orm.mapper;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doReturn;

import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.unittest.mockito.IsTClass;

public class PoolMapperMock {
	public static void mockSelectByPoolNo(PoolMapper poolMapper,Pool returnObject){
		doReturn(returnObject).when(poolMapper).selectByPoolNo(
				argThat(new IsTClass<String>("PN01000000000000761")));
	}
}
