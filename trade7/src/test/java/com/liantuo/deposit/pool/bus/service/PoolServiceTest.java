package com.liantuo.deposit.pool.bus.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;
import com.ebill.framework.exception.BusinessException;
import com.liantuo.deposit.advanceaccount.orm.mapper.PoolMapper;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.PoolQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.PoolInnerRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.deposit.pool.bus.service.impl.PoolServiceImpl;
import com.liantuo.unittest.BaseServiceTest;
public class PoolServiceTest extends BaseServiceTest {

	private PoolService poolService = new PoolServiceImpl();
	@Mock
	private PoolMapper poolMapper;
	
	@Before
	public void init(){
		poolMapper = mock(PoolMapper.class);
		ReflectionTestUtils.setField(poolService, "poolMapper", poolMapper);
	}
	
	@Test
	public void testFindByMerchantNoAndPoolName() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolName("北京联拓天际电子商务有限公司");
		poolQueryVo.setCoreMerchantNo("liantuo");
		PoolRspVo returnVo= poolService.findByMerchantNoAndPoolName(poolQueryVo);
		
	}
	
	
	@Test
	public void findByMerchantNoAndPoolName() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setCoreMerchantNo("WXZL");
		poolQueryVo.setPoolName("无锡市中国旅行社有限责任公司");
		PoolRspVo vo = poolService.findByMerchantNoAndPoolName(poolQueryVo);
	}
	@Test
	public void createPool() throws BusinessException {
		int i=1;
		Pool pool = new Pool();
		com.liantuo.deposit.pool.bus.mapper.PoolMapperMock.mockInsert(poolMapper, i);
		poolService.createPool(pool);
	}
	@Test
	public void findPoolsByQueryInnerVO() {
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setCoreMerchantNo("WXZL");
		poolQueryInnerVo.setPoolName("无锡市中国旅行社有限责任公司");
		List<PoolInnerRspVo>  list  = poolService.findPoolsByQueryInnerVO(poolQueryInnerVo);
		assertEquals(0,list.size());
	}
	@Test
	public void countPoolsByQueryInnerVO() {
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setCoreMerchantNo("WXZL");
		poolQueryInnerVo.setPoolName("无锡市中国旅行社有限责任公司");
		int count = poolService.countPoolsByQueryInnerVO(poolQueryInnerVo);
		assertEquals(0,count);
	}
	
}
