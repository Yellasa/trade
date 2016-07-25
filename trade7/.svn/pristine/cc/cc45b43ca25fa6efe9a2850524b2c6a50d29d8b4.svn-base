package com.liantuo.deposit.advanceaccount.orm.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBean;

import com.alibaba.fastjson.JSON;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.PoolQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.PoolInnerRspVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.PoolQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.PoolRspVo;
import com.liantuo.unittest.BaseDaoTest;

@Transactional(value = TransactionMode.ROLLBACK)
@DataSet(value = { "DepPool.PoolMapper.xls" })
public class PoolMapperTest extends BaseDaoTest {

	@SpringBean("poolMapper")
	private PoolMapper poolMapper;

	/**
	 * 
	 * @Description: 根据资金池名称和核心商户号查询结果不为空
	 * @author JiangKun
	 * @date 2016年7月1日 下午4:12:45
	 */
	@Test
	public void testFindByMerchantNoAndPoolNameNotNull() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolName("单元测试数据111");
		poolQueryVo.setCoreMerchantNo("UNIT_TEST_MHT_1");
		PoolRspVo poolRspVo = poolMapper
				.findByMerchantNoAndPoolName(poolQueryVo);
		assertNotNull("poolMapper根据商户编号和资金池查找接口返回不应该是空！", poolRspVo);
		LOGGER.info("查询结果：{}", JSON.toJSONString(poolRspVo));
		assertEquals("查询结果核心商户编号错误", "UNIT_TEST_MHT_1",
				poolRspVo.getCoreMerchantNo());
	}
	
	/**
	 * 
	 * @Description: 根据资金池名称和核心商户号查询结果为空
	 * @author JiangKun
	 * @date 2016年7月1日 下午4:13:02
	 */
	@Test
	public void testFindByMerchantNoAndPoolNameNull() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolName("单元测试数据1111");
		poolQueryVo.setCoreMerchantNo("UNIT_TEST_MHT_1");
		PoolRspVo poolRspVo = poolMapper
				.findByMerchantNoAndPoolName(poolQueryVo);
		LOGGER.info("查询结果：{}", JSON.toJSONString(poolRspVo));
		assertEquals("查询结果应该为空", null,
				poolRspVo);
	}

	/**
	 * 
	 * @Description: 根据资金池编号和资金池名称查询
	 * @author JiangKun
	 * @date 2016年7月1日 下午4:13:41
	 */
	@Test
	public void testFindPoolsQueryWithNameAndNo() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setCoreMerchantNo("UNIT_TEST_MHT_1");
		poolQueryVo.setPoolName("单元测试数据1");
		poolQueryVo.setPoolNo("PN88000000000113152");
		poolQueryVo.setShowCount(10);
		List<PoolRspVo> list = poolMapper.findPoolsByQueryVO(poolQueryVo);
		assertNotNull("poolMapper根据商户编号和资金池查找接口返回不应该是空！", list);
		System.out.println(list.size());
	}
	
	/**
	 * 
	 * @Description: 根据资金池编号查询资金池
	 * @author JiangKun
	 * @date 2016年7月1日 下午4:13:41
	 */
	@Test
	public void testFindPoolsQueryWithNo() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setCoreMerchantNo("UNIT_TEST_MHT_1");
//		poolQueryVo.setPoolName("单元测试数据1");
		poolQueryVo.setPoolNo("PN88000000000113152");
		poolQueryVo.setShowCount(10);
		List<PoolRspVo> list = poolMapper.findPoolsByQueryVO(poolQueryVo);
		assertNotNull("poolMapper根据商户编号和资金池查找接口返回不应该是空！", list);
		System.out.println(list.size());
	}
	
	/**
	 * 
	 * @Description: 根据资金池名称查询资金池
	 * @author JiangKun
	 * @date 2016年7月1日 下午4:13:41
	 */
	@Test
	public void testFindPoolsQueryWithName() {
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolName("单元测试数据1");
		poolQueryVo.setCoreMerchantNo("UNIT_TEST_MHT_1");
		poolQueryVo.setShowCount(10);
		List<PoolRspVo> list = poolMapper.findPoolsByQueryVO(poolQueryVo);
		assertNotNull("poolMapper根据商户编号和资金池查找接口返回不应该是空！", list);
		System.out.println(list.size());
	}
	
	/**
	 * 
	 * @Description: 测试根据资金池名称和资金池编号查询资金池数量
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:10:55
	 */
	@Test
	public void testFindPoolsQueryCountWithNameAndNo(){
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolName("单元测试数据2");
		poolQueryVo.setCoreMerchantNo("UNIT_TEST_MHT_2");
		poolQueryVo.setPoolNo("PN88000000000113151");
		int count = poolMapper.countPoolsByQueryVO(poolQueryVo);
		LOGGER.info("根据条件查询出资金池总数:"+count);
		
	}
	
	/**
	 * 
	 * @Description: 测试根据资金池名称查询资金池数量
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:10:55
	 */
	@Test
	public void testFindPoolsQueryCountWithName(){
		PoolQueryVo poolQueryVo = new PoolQueryVo();
		poolQueryVo.setPoolName("单元测试数据2");
		poolQueryVo.setCoreMerchantNo("UNIT_TEST_MHT_2");
//		poolQueryVo.setPoolNo("PN88000000000113151");
		int count = poolMapper.countPoolsByQueryVO(poolQueryVo);
		LOGGER.info("根据条件查询出资金池总数:"+count);
		
	}
	
	/**
	 * 
	 * @Description: 测试根据资金池编号查询资金池数量
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:10:55
	 */
	@Test
	public void testFindPoolsQueryCountWithNo(){
		PoolQueryVo poolQueryVo = new PoolQueryVo();
//		poolQueryVo.setPoolName("单元测试数据2");
		poolQueryVo.setCoreMerchantNo("UNIT_TEST_MHT_2");
		poolQueryVo.setPoolNo("PN88000000000113151");
		int count = poolMapper.countPoolsByQueryVO(poolQueryVo);
		LOGGER.info("根据条件查询出资金池总数:"+count);
		
	}
	
	/**
	 * 
	 * @Description: 根据资金池名称和资金池编号查询资金池（内部接口）
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:19:34
	 */
	@Test
	public void testFindPoolsQueryInner(){
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setCoreMerchantNo("UNIT_TEST_MHT_1");
		poolQueryInnerVo.setPoolName("单元测试数据1");
		poolQueryInnerVo.setPoolNo("PN88000000000113152");
		poolQueryInnerVo.setShowCount(10);
		List<PoolInnerRspVo> list = poolMapper.findPoolsByQueryInnerVO(poolQueryInnerVo);
		assertNotNull("poolMapper根据商户编号和资金池查找接口返回不应该是空",list);
		System.out.println(list.size());
	}
	
	/**
	 * 
	 * @Description: 根据资金池名称查询资金池（内部接口）
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:19:34
	 */
	@Test
	public void testFindPoolsQueryInnerWithName(){
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setCoreMerchantNo("UNIT_TEST_MHT_1");
		poolQueryInnerVo.setPoolName("单元测试数据1");
//		poolQueryInnerVo.setPoolNo("PN88000000000113152");
		poolQueryInnerVo.setShowCount(10);
		List<PoolInnerRspVo> list = poolMapper.findPoolsByQueryInnerVO(poolQueryInnerVo);
		assertNotNull("poolMapper根据商户编号和资金池查找接口返回不应该是空",list);
		System.out.println(list.size());
	}
	
	/**
	 * 
	 * @Description: 根据资金池编号查询资金池（内部接口）
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:19:34
	 */
	@Test
	public void testFindPoolsQueryInnerWithNo(){
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setCoreMerchantNo("UNIT_TEST_MHT_1");
//		poolQueryInnerVo.setPoolName("单元测试数据1");
		poolQueryInnerVo.setPoolNo("PN88000000000113152");
		poolQueryInnerVo.setShowCount(10);
		List<PoolInnerRspVo> list = poolMapper.findPoolsByQueryInnerVO(poolQueryInnerVo);
		assertNotNull("poolMapper根据商户编号和资金池查找接口返回不应该是空",list);
		System.out.println(list.size());
	}
	
	/**
	 * 
	 * @Description:根据资金池名称和资金池编号查询资金池数量（内部接口）
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:21:25
	 */
	@Test
	public void testFindPoolsQueryInnerCount(){
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setCoreMerchantNo("UNIT_TEST_MHT_2");
		poolQueryInnerVo.setPoolName("单元测试数据2");
		poolQueryInnerVo.setPoolNo("PN88000000000113151");
		int count= poolMapper.countPoolsByQueryInnerVO(poolQueryInnerVo);
		LOGGER.info("根据条件查询出资金池总数:"+count);
	}
	
	/**
	 * 
	 * @Description:根据资金池名称和资金池编号查询资金池数量（内部接口）
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:21:25
	 */
	@Test
	public void testFindPoolsQueryInnerCountWithName(){
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setCoreMerchantNo("UNIT_TEST_MHT_2");
		poolQueryInnerVo.setPoolName("单元测试数据2");
//		poolQueryInnerVo.setPoolNo("PN88000000000113151");
		int count= poolMapper.countPoolsByQueryInnerVO(poolQueryInnerVo);
		LOGGER.info("根据条件查询出资金池总数:"+count);
	}
	
	/**
	 * 
	 * @Description:根据资金池名称和资金池编号查询资金池数量（内部接口）
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:21:25
	 */
	@Test
	public void testFindPoolsQueryInnerCountWithNo(){
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setCoreMerchantNo("UNIT_TEST_MHT_2");
//		poolQueryInnerVo.setPoolName("单元测试数据2");
		poolQueryInnerVo.setPoolNo("PN88000000000113151");
		int count= poolMapper.countPoolsByQueryInnerVO(poolQueryInnerVo);
		LOGGER.info("根据条件查询出资金池总数:"+count);
	}
	
	/**
	 * 
	 * @Description:根据资金池名称查询资金池数量（内部接口）---查出记录为0
	 * @author JiangKun
	 * @date 2016年6月29日 下午4:21:25
	 */
	@Test
	public void testFindPoolsQueryInnerCountIsNull(){
		PoolQueryInnerVo poolQueryInnerVo = new PoolQueryInnerVo();
		poolQueryInnerVo.setPoolName("单元测试数据999");
		poolQueryInnerVo.setCoreMerchantNo("UNIT_TEST_MHT_1");
		int count= poolMapper.countPoolsByQueryInnerVO(poolQueryInnerVo);
		LOGGER.info("根据条件查询出资金池总数:"+count);
	}
	
	/**
	 * 
	 * @Description: 根据资金池编号查询
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:00:05
	 */
	@Test
	public void testSelectByPoolNo(){
		String poolNo = "PN88000000000113152";//
		Pool pool = poolMapper.selectByPoolNo(poolNo);
		assertNotNull("根据资金池编号查询不应为空",pool);
	}
	
	
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PoolMapperTest.class);
}
