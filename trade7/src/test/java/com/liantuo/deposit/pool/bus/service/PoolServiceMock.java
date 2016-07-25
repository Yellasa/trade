package com.liantuo.deposit.pool.bus.service;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;

import com.ebill.framework.exception.BusinessException;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.PoolQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.PoolInnerRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.trade.exception.BusinessUncheckedException;
import com.liantuo.unittest.mockito.IsTClass;
public class PoolServiceMock {

	public static void mockCreatePool(PoolService poolService,Pool returnObject) throws BusinessException{
		doReturn(returnObject).when(poolService).createPool(
				argThat(new IsTClass<Pool>(new Pool())));
	}
	
	public static void mockCreatePool(PoolService poolService,BusinessException returnException) throws BusinessException{

		doThrow(returnException).when(poolService).createPool(
				argThat(new IsTClass<Pool>(new Pool())));
	}
	
	public static void mockFindPoolsQuery(PoolService poolService,List<PoolRspVo> returnObject){
		doReturn(returnObject).when(poolService).findPoolsByQueryVO(argThat(new IsTClass<PoolQueryVo>(new PoolQueryVo())));
	}
	
	public static void mockFindPoolsQueryException(PoolService poolService,List<PoolRspVo> returnObject){
		doThrow(new RuntimeException()).when(poolService).findPoolsByQueryVO(argThat(new IsTClass<PoolQueryVo>(new PoolQueryVo())));
	}
	
	public static void mockFindPoolsQueryAccount(PoolService poolService,int returnObject){
		doReturn(returnObject).when(poolService).countPoolsByQueryVO(argThat(new IsTClass<PoolQueryVo>(new PoolQueryVo())));
	}
	
	public static void mockFindPoolsQueryInner(PoolService poolService,List<PoolInnerRspVo> returnObject){
		doReturn(returnObject).when(poolService).findPoolsByQueryInnerVO(argThat(new IsTClass<PoolQueryInnerVo>(new PoolQueryInnerVo())));
	}
	
	public static void mockFindPoolsQueryInnerException(PoolService poolService,List<PoolInnerRspVo> returnObject){
		doThrow(new BusinessUncheckedException()).when(poolService).findPoolsByQueryInnerVO(argThat(new IsTClass<PoolQueryInnerVo>(new PoolQueryInnerVo())));
	}
	
	public static void mockFindPoolsQueryInnerRuntimeException(PoolService poolService,List<PoolInnerRspVo> returnObject){
		doThrow(new RuntimeException()).when(poolService).findPoolsByQueryInnerVO(argThat(new IsTClass<PoolQueryInnerVo>(new PoolQueryInnerVo())));
	}

	public static void mockFindPoolsQueryInnerAccount(PoolService poolService,int returnObject){
		doReturn(returnObject).when(poolService).countPoolsByQueryInnerVO(argThat(new IsTClass<PoolQueryInnerVo>(new PoolQueryInnerVo())));
	}
	
}
