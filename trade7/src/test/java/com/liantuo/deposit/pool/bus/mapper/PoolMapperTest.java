package com.liantuo.deposit.pool.bus.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Test;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBean;
import com.liantuo.deposit.advanceaccount.orm.mapper.PoolMapper;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.PoolQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.PoolInnerRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.unittest.BaseDaoTest;


@Transactional(value = TransactionMode.ROLLBACK)
@DataSet(value = { "DepPool.PoolMapper.xls" })
public class PoolMapperTest extends BaseDaoTest{
	@SpringBean("poolMapper")
	private PoolMapper poolMapper;
	
	@Test
	public void testFindByMerchantNoAndPoolName() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolName("北京联拓天际电子商务有限公司");
		poolQueryVo.setCoreMerchantNo("liantuo");
		PoolRspVo returnVo= poolMapper.findByMerchantNoAndPoolName(poolQueryVo);
		assertEquals("PN01000000000000761",returnVo.getPoolNo());
	}
	@Test
	public void testFindByMerchantNoAndPoolName2() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setCoreMerchantNo("liantuo");
		PoolRspVo returnVo= poolMapper.findByMerchantNoAndPoolName(poolQueryVo);
		assertNull(returnVo);
	}
	@Test
	public void testFindByMerchantNoAndPoolName3() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolName("北京联拓天际电子商务有限公司");
		PoolRspVo returnVo= poolMapper.findByMerchantNoAndPoolName(poolQueryVo);
		assertNull(returnVo);
	}
	
	@Test
	public void testSelectByPoolNo() {
		String poolNo="PN01000000000000802";
        Pool pool =  poolMapper.selectByPoolNo(poolNo);
        assertEquals("成都启明航空服务有限公司",pool.getPoolName());
	}
	
	 
	@Test
	public void findPoolsByQueryVO() {
		String poolNo="PN01000000000000802";
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolNo(poolNo);
		List<PoolRspVo> list =  poolMapper.findPoolsByQueryVO(poolQueryVo);
		assertEquals("查询结果应该为空", 0,
				list.size());
	}
	@Test
	public void findPoolsByQueryVO2() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolName("北京联拓天际电子商务有限公司");;
		List<PoolRspVo> list =  poolMapper.findPoolsByQueryVO(poolQueryVo);
		assertEquals("查询结果应该为空", 0,
				list.size());
	}	
	
	@Test
	public void findPoolsByQueryVO3() {
		String poolNo="PN01000000000000761";
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolNo(poolNo);
		poolQueryVo.setCoreMerchantNo("liantuo");
		List<PoolRspVo> list =  poolMapper.findPoolsByQueryVO(poolQueryVo);
		assertNotNull(list);
	}
	
	@Test
	public void findPoolsByQueryInnerVO() {
		String poolNo="PN01000000000000802";
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setPoolNo(poolNo);
		List<PoolInnerRspVo> list =  poolMapper.findPoolsByQueryInnerVO(poolQueryInnerVo);
		assertEquals("查询结果应该为空", 0,
				list.size());
	}
	
	@Test
	public void findPoolsByQueryInnerVO2() {
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setPoolName("成都启明航空服务有限公司");
		List<PoolInnerRspVo> list =  poolMapper.findPoolsByQueryInnerVO(poolQueryInnerVo);
		assertEquals("查询结果应该为空", 0,
				list.size());
	}
	
	@Test
	public void findPoolsByQueryInnerVO3() {
		String poolNo="PN01000000000000802";
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setPoolName("成都启明航空服务有限公司");
		poolQueryInnerVo.setPoolNo(poolNo);
		poolQueryInnerVo.setCoreMerchantNo("CDQM");
		List<PoolInnerRspVo> list =  poolMapper.findPoolsByQueryInnerVO(poolQueryInnerVo);
		assertNotNull(list);
	}
	
	@Test
	public void insert() {
		Pool record = new Pool();
		record.setId(1);
		record.setMerchantNo("CC_123");
		record.setPoolNo("PN01000000000022802");
		record.setGmtCreated(DateUtil.format("2016-07-07 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		record.setCreatorNo("shb");
        record.setCreatorCn("shb");
        record.setGmtModified(DateUtil.format("2016-07-07 00:00:00", DateUtil.DEFAULT_DATE_TIME));
        record.setModifierNo("shb");
        record.setModifierCn("shb");
	    int successCount = poolMapper.insert(record);
	    assertEquals("插入成功返回应该为1",1,successCount);
		System.out.println(successCount);
	}
 
}
