package com.liantuo.deposit.advanceaccount.orm.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBean;

import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountAccountRecord;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountHisPageQueryInnerVo;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountHisPageQueryVo;
import com.liantuo.deposit.advanceaccount.bus.vo.SingleAccountHisQueryVo;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccountTradeHistory;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.SingleAccountAccountingRecord;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.unittest.BaseDaoTest;

@Transactional(value = TransactionMode.ROLLBACK)
@DataSet(value = { "CreditAccountTradeHistory.CreditAccountTradeHistoryMapper.xls" })
public class CreditAccountTradeHistoryMapperTest extends BaseDaoTest {
	@SpringBean("creditAccountTradeHistoryMapper")
	private CreditAccountTradeHistoryMapper creditAccountTradeHistoryMapper;
	
	/**
	 * 根据主键查询账务流水
	 * 查询结果有数据
	 */
	@Test
	public void testSelectByPrimaryKeyCase1(){
		Integer id=1;
		CreditAccountTradeHistory creditAccountTradeHistory=creditAccountTradeHistoryMapper.selectByPrimaryKey(id);
	    assertNotNull("查询结果不应为空：",creditAccountTradeHistory);
	    assertEquals("查询结果的id应为1","1",creditAccountTradeHistory.getId().toString());
	    System.out.println(creditAccountTradeHistory.getId());
	}
	/**
	 * 根据主键查询账务流水
	 * 查询结果无数据
	 */
	@Test
	public void testSelectByPrimaryKeyCase2(){
		Integer id=8;
		CreditAccountTradeHistory creditAccountTradeHistory=creditAccountTradeHistoryMapper.selectByPrimaryKey(id);
	    assertNull("查询结果应该为空：",creditAccountTradeHistory);
	    System.out.println(creditAccountTradeHistory);
	}
	/**
	 * 测试单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase1(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(429);
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
	    assertEquals("应该为0条",0,list.size());
	    System.out.println(list.size());
	}
	/**
	 * 测试单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和交易发起方业务系统订单号查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase2(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(428);
		vo.setSequenceNo("LVB2B201501040001");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
	    assertNotNull("查询结果不应为空",list);
	    assertEquals("查询结果预存款账户id应该为428","428",list.get(0).getCreditAccountId().toString());
	    assertEquals("查询结果交易发起方业务系统订单号应该为LVB2B201501040001","LVB2B201501040001",list.get(0).getSequenceNo().toString());
	    System.out.println(list.size());
	}
	/**
	 * 测试单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和所属业务交易类型查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase3(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setTradeCode("123");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
	    assertNotNull("查询结果不应为空",list);
	    assertEquals("查询结果预存款账户id应该为18670","18670",list.get(0).getCreditAccountId().toString());
	    assertEquals("查询结果所属业务交易类型应该为123","123",list.get(0).getTradeCode().toString());
	    System.out.println(list.size());
	}
	/**
	 * 测试单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和所属业务交易编号查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase4(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setTradeNo("456");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
	    assertNotNull("查询结果不应为空",list);
	    assertEquals("查询结果预存款账户id应该为18670","18670",list.get(0).getCreditAccountId().toString());
	    assertEquals("查询结果所属业务交易编号应该为456","456",list.get(0).getTradeNo().toString());
	    System.out.println(list.size());
	}
	/**
	 * 测试单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和所属业务交易请求类型查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase5(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setTradeReqCode("535345345");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
	    assertNotNull("查询结果不应为空",list);
	    assertEquals("查询结果预存款账户id应该为18670","18670",list.get(0).getCreditAccountId().toString());
	    assertEquals("查询结果所属业务交易请求类型应该为535345345","535345345",list.get(0).getTradeReqCode().toString());
	    System.out.println(list.size());
	}
	
	/**
	 * 测试单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和所属业务交易请求编号查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase6(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setTradeStepNo("4645645645");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
	    assertNotNull("查询结果不应为空",list);
	    assertEquals("查询结果预存款账户id应该为18670","18670",list.get(0).getCreditAccountId().toString());
	    assertEquals("查询结果所属业务交易请求编号应该为4645645645","4645645645",list.get(0).getTradeStepNo().toString());
	    System.out.println(list.size());
	}
	
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和账务历史开始时间、结束时间查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase7(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setBeginTime(DateUtil.format("2015-12-18 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		vo.setEndTime(DateUtil.format("2015-12-20 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和账务历史类型为冻结查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase8(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setType("FRZ");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和账务历史类型为可用查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase9(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setType("AVL");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		assertEquals("应为0条", 0,list.size());
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和精确查询条件1查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase10(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setReservedFields1("预留1");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和精确查询条件2查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase11(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setReservedFields2("预留2");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和精确查询条件3查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase12(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setReservedFields3("冻结金额增加12.2块");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和模糊查询条件1查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase13(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18671);
		vo.setReservedFields1Fuzzy("增加");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和模糊查询条件2查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase14(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18671);
		vo.setReservedFields2Fuzzy("预留");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和模糊查询条件3查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase15(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18671);
		vo.setReservedFields3Fuzzy("冻结");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和排序条件升序查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase16(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空",list);
		System.out.println(list.size());
		for(SingleAccountAccountingRecord d:list){
			System.out.println(d.getId());
		}
	}
	/**
	 * 单账户账务历史查询接口 (外部用)
	 * 根据预存款账户id和排序条件降序查询
	 */
	@Test
	public void testSelectSingleAccountHisPageQueryCase17(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
	    vo.setSortType("01");
		List<SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleAccountHisPageQuery(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase1(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和订单号查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase2(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setOutTradeNo("LVB2B201501040001");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和所属业务交易请求类型查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase3(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setTradeCode("123");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和所属业务交易请求编号查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase4(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setTradeNo("456");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和所属业务交易请求类型查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase5(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setTradeReqCode("535345345");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和所属业务交易请求编号查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase6(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setTradeReqNo("4645645645");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和账务历史开始时间、结束时间查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase7(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setGmtCreateBegin(DateUtil.format("2015-12-18 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		vo.setGmtCreateEnd(DateUtil.format("2015-12-20 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和账务历史类型为冻结查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase8(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setSubAccountType("FRZ");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和账务历史类型为可用查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase9(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setSubAccountType("AVL");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和精确查询条件1查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase10(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setReservedFields1("预留1");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和精确查询条件2查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase11(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setReservedFields2("预留2");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和精确查询条件3查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase12(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setReservedFields3("冻结金额增加12.2块");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和升序查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase13(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
		for(SingleAccountAccountRecord d:list){
			System.out.println(d.getAccountNo());
		}
	}
	/**
	 * 单账户账务历史查询接口-数据标准版
	 * 根据预存款账户id和降序查询
	 */
	@Test
	public void testSingleAccountHisPageQueryStandCase14(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setSortType("01");
		List<SingleAccountAccountRecord> list = creditAccountTradeHistoryMapper.singleAccountHisPageQueryStand(vo);
		assertNotNull("不应该为空！",list);
		System.out.println(list.size());
	}

	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase1(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(4286);
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
	    assertNotNull("查询结果不应为空",count);
	    System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和交易发起方业务系统订单号查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase2(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(4286);
		vo.setSequenceNo("LVB2B201501040001");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 *查询账务历史记录数
	 * 根据预存款账户id和所属业务交易类型查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase3(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setTradeCode("123");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和所属业务交易编号查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase4(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setTradeNo("456");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 *查询账务历史记录数
	 * 根据预存款账户id和所属业务交易请求类型查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase5(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setTradeReqCode("535345345");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和所属业务交易请求编号查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase6(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setTradeStepNo("4645645645");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和账务历史开始时间、结束时间查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase7(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setBeginTime(DateUtil.format("2015-12-18 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		vo.setEndTime(DateUtil.format("2015-12-20 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和账务历史类型为冻结查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase8(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setType("FRZ");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和账务历史类型为可用查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase9(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setType("AVL");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和精确查询条件1查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase10(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setReservedFields1("预留1");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和精确查询条件2查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase11(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setReservedFields2("预留2");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和精确查询条件3查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase12(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setReservedFields3("冻结金额增加12.2块");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和模糊查询条件1查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase13(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setReservedFields1Fuzzy("增加");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和模糊查询条件2查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase14(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setReservedFields2Fuzzy("预留");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	/**
	 * 查询账务历史记录数
	 * 根据预存款账户id和模糊查询条件3查询
	 */
	@Test
	public void testSelectCountSingleAccountHisCase15(){
		SingleAccountHisPageQueryVo vo = new SingleAccountHisPageQueryVo();
		vo.setCreditAccountId(18670);
		vo.setReservedFields3Fuzzy("冻结");
		Integer count = creditAccountTradeHistoryMapper.selectCountSingleAccountHis(vo);
		System.out.println(count);
	}
	
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 *  根据预存款账户id查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase1(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 *  根据预存款账户id和交易发起方业务系统订单号查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase2(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setSequenceNo("LVB2B201501040001");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 *  根据预存款账户id和所属业务交易类型查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase3(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setTradeCode("123");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 *  根据预存款账户id和所属业务交易编号查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase4(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setTradeNo("456");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 *  根据预存款账户id和所属业务交易请求类型查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase5(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setTradeReqCode("535345345");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 *  根据预存款账户id和所属业务交易请求编号查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase6(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setTradeStepNo("4645645645");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 *  根据预存款账户id和账务历史开始时间、结束时间查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase7(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setBeginTime(DateUtil.format("2015-12-18 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		vo.setEndTime(DateUtil.format("2015-12-20 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 * 根据预存款账户id和账务历史类型为冻结时的查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase8(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setType("FRZ");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 * 根据预存款账户id和账务历史类型为可用时的查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase9(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setType("AVL");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 * 根据预存款账户id和排序条件升序查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase10(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
//		for(com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord d:list){
//			System.out.println(d.getCreditAccountId());
//		}
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 * 根据预存款账户id和排序条件降序查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase11(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setType("01");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
//		for(com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord d:list){
//			System.out.println(d.getCreditAccountId());
//		}
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 * 根据所属业务冻结交易类型查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase12(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setFrozenTradeCode("addacc");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	/**
	 *  单账户账务历史查询接口(内部接口) 
	 * 根据所属业务冻结交易编号查询
	 */
	@Test
	public void testSelectSingleInnerCAHisPageQueryCase13(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setFrozenTradeNo("eeald");
		List<com.liantuo.deposit.advanceaccount.web.inner.vo.rsp.SingleAccountAccountingRecord> list = creditAccountTradeHistoryMapper.selectSingleInnerCAHisPageQuery(vo);
		System.out.println(list.size());
		assertNotNull("不应该为空",list);
	}
	
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 * 根据预存款账户id查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase1(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 * 根据预存款账户id和交易发起方业务系统订单号查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase2(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setSequenceNo("LVB2B201501040001");
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 * 根据预存款账户id和所属业务交易类型查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase3(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setTradeCode("123");
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 * 根据预存款账户id和所属业务交易编号查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase4(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setTradeNo("456");
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 *根据预存款账户id和所属业务交易请求类型查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase5(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setTradeReqCode("535345345");
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 *根据预存款账户id和所属业务交易请求编号查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase6(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setTradeStepNo("4645645645");
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 *根据预存款账户id和账务历史开始时间、结束时间查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase7(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setBeginTime(DateUtil.format("2015-12-18 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		vo.setEndTime(DateUtil.format("2015-12-20 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 *根据预存款账户id和账务历史类型为冻结时的查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase8(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setType("FRZ");
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 *根据预存款账户id和账务历史类型为可用时的查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase9(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setType("AVL");
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotNull("不应为空",count);
		System.out.print(count);
	}
	
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 *根据所属业务冻结交易类型查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase10(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setFrozenTradeCode("addacc");
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	
	/**
	 * 单账户账务历史查询总记录数接口(内部接口)
	 *根据所属业务冻结交易编号查询
	 */
	@Test
	public void testSelectCountSingleInnerCAHisCase11(){
		SingleAccountHisPageQueryInnerVo vo = new SingleAccountHisPageQueryInnerVo();
		vo.setCreditAccountId(18670);
		vo.setFrozenTradeNo("eeald");
		int count = creditAccountTradeHistoryMapper.selectCountSingleInnerCAHis(vo);
		assertNotEquals("查询记录数不应该为0", 0, count);
		System.out.print(count);
	}
	
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase1(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和订单号查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase2(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setOutTradeNo("LVB2B201501040001");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和所属业务交易请求类型查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase3(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setTradeCode("123");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和所属业务交易请求编号查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase4(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setTradeNo("456");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	/**
	 * 单外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和所属业务交易请求类型查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase5(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setTradeReqCode("535345345");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和所属业务交易请求编号查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase6(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setTradeReqNo("4645645645");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和账务历史开始时间、结束时间查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase7(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setGmtCreateBegin(DateUtil.format("2015-12-18 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		vo.setGmtCreateEnd(DateUtil.format("2015-12-20 00:00:00", DateUtil.DEFAULT_DATE_TIME));
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	/**
	 *外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和账务历史类型为冻结查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase8(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setSubAccountType("FRZ");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和账务历史类型为可用查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase9(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setSubAccountType("AVL");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和精确查询条件1查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase10(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setReservedFields1("预留1");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和精确查询条件2查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase11(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setReservedFields2("预留2");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	/**
	 * 外部系统使用的单账户账务历史查询总记录数接口（标准版本）
	 * 根据预存款账户id和精确查询条件3查询
	 */
	@Test
	public void testCountSingleAccountHisQueryStandCase12(){
		SingleAccountHisQueryVo vo = new SingleAccountHisQueryVo();
		vo.setAccountNo("18670");
		vo.setReservedFields3("冻结金额增加12.2块");
		Integer count = creditAccountTradeHistoryMapper.countSingleAccountHisQueryStand(vo);
		assertNotNull("不应该为空！",count);
		System.out.println(count);
	}
	
	/**
	 * 测试增加账务历史记录接口
	 */
	@Test
	public void testInsert(){
		CreditAccountTradeHistory creditAccountTradeHistory=new CreditAccountTradeHistory();
		creditAccountTradeHistory.setId(100);
		creditAccountTradeHistory.setCreditAccountId(11111);
		creditAccountTradeHistory.setIncome(3d);
		creditAccountTradeHistory.setPayout(4d);
		creditAccountTradeHistory.setBalance(100d);
		creditAccountTradeHistory.setCreditLine(10d);
		creditAccountTradeHistory.setCreatedCn("system");
		creditAccountTradeHistory.setTradeId(111);
		creditAccountTradeHistory.setDataFlag("1");
		creditAccountTradeHistory.setTradeType(2);
		creditAccountTradeHistory.setGmtCreated(new Date());
		int count=creditAccountTradeHistoryMapper.insert(creditAccountTradeHistory);
	    assertNotNull("不应为空",count);
	    assertEquals("应该返回1条", 1,count);
	    System.out.println(count);
	}

}
