package com.liantuo.deposit.pool.bus.mapper;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import com.liantuo.deposit.advanceaccount.orm.mapper.PoolMapper;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.PoolQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.PoolInnerRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.unittest.mockito.IsTClass;

public class PoolMapperMock {
	
	public static void mockInsert(PoolMapper poolMapper,int returnObject){
		doReturn(returnObject).when(poolMapper).insert(
				argThat(new IsTClass<Pool>(new Pool())));
	}
	public static void mockFindByMerchantNoAndPoolName(PoolMapper poolMapper,PoolRspVo returnObject,PoolQueryVo args){
		doReturn(returnObject).when(poolMapper).findByMerchantNoAndPoolName(
				argThat(new IsTClass<PoolQueryVo>(args)));
	}
	public static void mockSelectByPoolNo(PoolMapper poolMapper,Pool returnObject){
		doReturn(returnObject).when(poolMapper).selectByPoolNo(
				argThat(new IsTClass<String>(new String())));
	}
 
	 
}
