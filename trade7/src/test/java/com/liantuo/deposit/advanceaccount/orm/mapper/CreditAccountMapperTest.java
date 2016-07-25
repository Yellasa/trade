package com.liantuo.deposit.advanceaccount.orm.mapper;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBean;

import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.CreditAccountQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.returnvo.CreditAccountInnerVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.CreditAccountQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.returnvo.CreditAccountVo;
import com.liantuo.deposit.common.constants.CreditAccountConstants;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdbMock;
import com.liantuo.unittest.BaseDaoTest;




@Transactional(value = TransactionMode.ROLLBACK)
@DataSet(value = { "CreditAccount.CreditAccountMapper.xls" })
public class CreditAccountMapperTest extends BaseDaoTest {
	@SpringBean("creditAccountMapper")
	private CreditAccountMapper creditAccountMapper;
	private StepSequenceFactoryForSpdb idFactoryCaAccountNo;
	
	
	
	/**
	 * 
	 * @Description: 根据id查询creditAccount，存在查询结果
	 * @author JiangKun
	 * @date 2016年7月12日 上午10:20:48
	 */
	@Test
	public void testSelectByPrimaryKeyCase1(){
		Integer id = 1;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNotNull("不应该为空",ca);
		assertNotNull("结果id不应该为空",ca.getId());
		System.out.println(ca.getId());
	}
	
	/**
	 * 
	 * @Description: 根据id查询creditAccount，不存在查询结果
	 * @author JiangKun
	 * @date 2016年7月12日 上午10:20:48
	 */
	@Test
	public void testSelectByPrimaryKeyCase2(){
		Integer id = 999999;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNull("应该为空",ca);
	}
	
	/**
	 * 
	 * @Description: 根据accountNo查询creditAccount，存在查询结果
	 * @author JiangKun
	 * @date 2016年7月12日 上午10:44:23
	 */
	@Test
	public void testSelectByAccountNoCase1(){
		String accountNo = "CA08082110940001";
		CreditAccount ca = creditAccountMapper.selectByAccountNo(accountNo);
		assertNotNull("不应该为空", ca);
		assertEquals("accountNo应该相等！", accountNo, ca.getAccountNo());
	}
	
	/**
	 * 
	 * @Description: 根据accountNo查询creditAccount，存在查询结果
	 * @author JiangKun
	 * @date 2016年7月12日 上午10:44:23
	 */
	@Test
	public void testSelectByAccountNoCase2(){
		String accountNo = "CA18082110940001";
		CreditAccount ca = creditAccountMapper.selectByAccountNo(accountNo);
		assertNull("不应该为空", ca);
	}
	
	/**
	 * 
	 * @Description: 根据id和version更新可用余额，更新成功
	 * @author JiangKun
	 * @date 2016年7月12日 上午11:14:03
	 */
	@Test
	public void testUpdateAclBalanceCase1(){
		Integer id = 1234567;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNotNull("不应该为空",ca);
		//未修改之前数据
		Long version = ca.getVersion();
		Double total_balance = ca.getTotalBalance();
		Double available_balance = ca.getAvailableBalance();
		Date bal_last_change_time = ca.getBalLastChangeTime();
		Date sys_time = ca.getSysTime();
		//设置修改数据
		ca.setTotalBalance(new Double("1234"));
		ca.setAvailableBalance(new Double("100"));
		ca.setBalLastChangeTime(new Date());
		int result = creditAccountMapper.updateAvlBalance(ca);
		assertEquals("更新成功，返回应该为1",1,result);
		//校验更新后结果
		CreditAccount caUpdate = creditAccountMapper.selectByPrimaryKey(id);
		assertEquals("version更新后结果应该为:"+(version+1),new Long(version+1),caUpdate.getVersion());
		assertEquals("totalBalance更新后结果应该为1234",new Double("1234"),caUpdate.getTotalBalance());
		assertEquals("availableBalance更新后结果应该为100",new Double("100"),caUpdate.getAvailableBalance());
		
		assertNotEquals("version更新后结果应该不等于原来更新前的结果",version,caUpdate.getVersion());
		assertNotEquals("totalBalance更新后结果应该不等于原来更新前的结果",total_balance,caUpdate.getTotalBalance());
		assertNotEquals("available_balance更新后结果应该不等于原来更新前的结果",available_balance,caUpdate.getAvailableBalance());
		assertNotEquals("balLastChangeTime更新后结果应该不等于原来更新前的结果",bal_last_change_time,caUpdate.getBalLastChangeTime());
		assertNotEquals("systime更新后结果应该不等于原来更新前的结果",sys_time,caUpdate.getSysTime());	
	}
	
	/**
	 * 
	 * @Description: 根据id和version更新可用余额，version版本号不对，更新失败
	 * @author JiangKun
	 * @date 2016年7月12日 上午11:14:03
	 */
	@Test
	public void testUpdateAclBalanceCase2(){
		Integer id = 1234567;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNotNull("不应该为空",ca);
		//未修改之前数据
		Long version = ca.getVersion();
		System.out.println(version);
		Double total_balance = ca.getTotalBalance();
		Double available_balance = ca.getAvailableBalance();
		Date bal_last_change_time = ca.getBalLastChangeTime();
		Date sys_time = ca.getSysTime();
		//设置修改数据
		ca.setTotalBalance(new Double("1234"));
		ca.setAvailableBalance(new Double("100"));
		ca.setBalLastChangeTime(new Date());
		//修改version，使更新条件不满足
		ca.setVersion(version+1);
		int result = creditAccountMapper.updateAvlBalance(ca);
		
		assertEquals("更新失败，返回应该为0",0,result);
		//校验更新后结果
		CreditAccount caAfter = creditAccountMapper.selectByPrimaryKey(id);
		assertEquals("更新失败,version不变，应该为:"+version,version,caAfter.getVersion());
		assertEquals("更新失败,totalBalance应该为:"+total_balance,total_balance,caAfter.getTotalBalance());
		assertEquals("更新失败,availableBalance应该为:"+available_balance,available_balance,caAfter.getAvailableBalance());
		assertEquals("更新失败,balLastChangeTime应该为:"+bal_last_change_time,bal_last_change_time,caAfter.getBalLastChangeTime());
		assertEquals("更新失败,sysTime应该为:"+sys_time,sys_time,caAfter.getSysTime());
	}
	
	/**
	 * 
	 * @Description: 根据id和version更新可用余额，id不存在，更新失败
	 * @author JiangKun
	 * @date 2016年7月12日 上午11:14:03
	 */
	@Test
	public void testUpdateAclBalanceCase3(){
		Integer id = 1234568;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNull("应该为空",ca);
		//设置修改数据
		ca = new CreditAccount();
		ca.setId(1234568);
		ca.setTotalBalance(new Double("1234"));
		ca.setAvailableBalance(new Double("100"));
		ca.setBalLastChangeTime(new Date());
		ca.setVersion(1L);
		int result = creditAccountMapper.updateAvlBalance(ca);
		
		assertEquals("更新失败，返回应该为0",0,result);
	}
	
	/**
	 * 
	 * @Description: 根据id和version更新冻结余额，更新成功
	 * @author JiangKun
	 * @date 2016年7月12日 上午11:14:03
	 */
	@Test
	public void testUpdateFrozenBalanceCase1(){
		Integer id = 1234567;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNotNull("不应该为空",ca);
		//未修改之前数据
		Long version = ca.getVersion();
		Double total_balance = ca.getTotalBalance();
		Double freezen_balance = ca.getFreezenBalance();
		Date bal_last_change_time = ca.getBalLastChangeTime();
		Date sys_time = ca.getSysTime();
		//设置修改数据
		ca.setTotalBalance(new Double("1234"));
		ca.setFreezenBalance(new Double("100"));
		ca.setBalLastChangeTime(new Date());
		int result = creditAccountMapper.updateFrozenBalance(ca);
		assertEquals("更新成功，返回应该为1",1,result);
		//校验更新后结果
		CreditAccount caUpdate = creditAccountMapper.selectByPrimaryKey(id);
		assertEquals("version更新后结果应该为:"+(version+1),new Long(version+1),caUpdate.getVersion());
		assertEquals("totalBalance更新后结果应该为1234",new Double("1234"),caUpdate.getTotalBalance());
		assertEquals("freezenBalance更新后结果应该为100",new Double("100"),caUpdate.getFreezenBalance());
		
		assertNotEquals("version更新后结果应该不等于原来更新前的结果",version,caUpdate.getVersion());
		assertNotEquals("totalBalance更新后结果应该不等于原来更新前的结果",total_balance,caUpdate.getTotalBalance());
		assertNotEquals("freezenBalance更新后结果应该不等于原来更新前的结果",freezen_balance,caUpdate.getAvailableBalance());
		assertNotEquals("balLastChangeTime更新后结果应该不等于原来更新前的结果",bal_last_change_time,caUpdate.getBalLastChangeTime());
		assertNotEquals("systime更新后结果应该不等于原来更新前的结果",sys_time,caUpdate.getSysTime());
	}
	
	/**
	 * 
	 * @Description: 根据id和version更新冻结余额，id存在，version不正确，更新失败
	 * @author JiangKun
	 * @date 2016年7月12日 上午11:14:03
	 */
	@Test
	public void testUpdateFrozenBalanceCase2(){
		Integer id = 1234567;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNotNull("不应该为空",ca);
		//未修改之前数据
		Long version = ca.getVersion();
		Double total_balance = ca.getTotalBalance();
		Double freezen_balance = ca.getFreezenBalance();
		Date bal_last_change_time = ca.getBalLastChangeTime();
		Date sys_time = ca.getSysTime();
		//设置修改数据
		ca.setTotalBalance(new Double("1234"));
		ca.setFreezenBalance(new Double("100"));
		ca.setBalLastChangeTime(new Date());
		//修改version，使更新条件不满足
		ca.setVersion(version+1);
		int result = creditAccountMapper.updateFrozenBalance(ca);
		assertEquals("更新失败，返回应该为0",0,result);
		//校验更新后结果
		CreditAccount caAfter = creditAccountMapper.selectByPrimaryKey(id);
		assertEquals("更新失败,version不变，应该为:"+version,version,caAfter.getVersion());
		assertEquals("更新失败,totalBalance应该为:"+total_balance,total_balance,caAfter.getTotalBalance());
		assertEquals("更新失败,freezenBalance应该为:"+freezen_balance,freezen_balance,caAfter.getFreezenBalance());
		assertEquals("更新失败,balLastChangeTime应该为:"+bal_last_change_time,bal_last_change_time,caAfter.getBalLastChangeTime());
		assertEquals("更新失败,sysTime应该为:"+sys_time,sys_time,caAfter.getSysTime());
	}
	
	/**
	 * 
	 * @Description: 根据id和version更新冻结余额，id不存在，更新失败
	 * @author JiangKun
	 * @date 2016年7月12日 上午11:14:03
	 */
	@Test
	public void testUpdateFrozenBalanceCase3(){
		Integer id = 1234568;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNull("应该为空",ca);
		//设置修改数据
		ca = new CreditAccount();
		ca.setId(1234568);
		ca.setTotalBalance(new Double("1234"));
		ca.setAvailableBalance(new Double("100"));
		ca.setBalLastChangeTime(new Date());
		ca.setVersion(1L);
		int result = creditAccountMapper.updateFrozenBalance(ca);
		
		assertEquals("更新失败，返回应该为0",0,result);
	}
	
	/**
	 * 
	 * @Description: 根据账户编号，非授信账户，查询返回0条
	 * @author JiangKun
	 * @date 2016年7月12日 下午2:19:46
	 */
	@Test
	public void testFindAdvanceAccountByAccountNoCase1(){
		String accountNo = "CA08082045000001";
		List<CreditAccount> list = creditAccountMapper.findAdvanceAccountByAccountNo(accountNo);
		assertEquals("list的size为0",0,list.size());
	}
	
	/**
	 * 
	 * @Description: 根据账户编号，非授信账户，查询返回1条
	 * @author JiangKun
	 * @date 2016年7月12日 下午2:19:46
	 */
	@Test
	public void testFindAdvanceAccountByAccountNoCase2(){
		String accountNo = "CA08082045000000";
		List<CreditAccount> list = creditAccountMapper.findAdvanceAccountByAccountNo(accountNo);
		assertEquals("list的size应该为1",1,list.size());
		assertEquals("accountNo应该相等",accountNo,list.get(0).getAccountNo());
	}
	
	/**
	 * 
	 * @Description: 根据id 锁定账户，成功锁定
	 * @author JiangKun
	 * @date 2016年7月12日 下午3:02:38
	 */
	@Test
	public void testSelectByIdForUpdateCase1(){
		Integer id = 1;
		CreditAccount ca = creditAccountMapper.selectByIdForUpdate(id);
		assertNotNull("不应该为空",ca);
		assertEquals("id应该相等",id,ca.getId());
	}
	
	/**
	 * 
	 * @Description: 根据id 锁定账户，id不存在
	 * @author JiangKun
	 * @date 2016年7月12日 下午3:02:38
	 */
	@Test
	public void testSelectByIdForUpdateCase2(){
		Integer id = 999999;
		CreditAccount ca = creditAccountMapper.selectByIdForUpdate(id);
		assertNull("应该为空",ca);
	}
		
	/**
	 * 
	 * @Description:根据条件查询预存款账户列表--全条件查询
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:39:50
	 */
	@Test
	public void testFindAdvanceAccountByQueryVOCase1(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
		vo.setMerchantNo("ceshi1");
		vo.setAccountNo("CA08082110940001");
		vo.setAccountName("ceshiName1");
		vo.setAccountType(1);
		vo.setStatus(1);
		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
		vo.setCreateTimeStart(startDate);
		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(10);
		List<CreditAccountVo> list = creditAccountMapper.findAdvanceAccountByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("list中有应该有1条记录",1,list.size());
		assertEquals("accountNo应该和查询条件中相等！","CA08082110940001",list.get(0).getAccountNo());
	}
	
	/**
	 * 
	 * @Description:根据条件查询预存款账户列表--资金池编号查询
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:39:50
	 */
	@Test
	public void testFindAdvanceAccountByQueryVOCase2(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		List<CreditAccountVo> list = creditAccountMapper.findAdvanceAccountByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("查询结果应该有9条记录",9,list.size());
		System.out.println(list.size());
		assertEquals("资金池编号应该和查询条件相等！","PN01000000000001761",list.get(0).getPoolNo());
		
	}
	
	/**
	 * 
	 * @Description:根据条件查询预存款账户列表--商户编号
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:39:50
	 */
	@Test
	public void testFindAdvanceAccountByQueryVOCase3(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
		vo.setMerchantNo("ceshi2");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		List<CreditAccountVo> list = creditAccountMapper.findAdvanceAccountByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("查询结果应该有1条记录",1,list.size());
		System.out.println(list.size());
		assertEquals("商户编号应该和查询条件相等！","ceshi2",list.get(0).getMerchantNo());
	}
	
	/**
	 * 
	 * @Description:根据条件查询预存款账户列表--账户编号
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:39:50
	 */
	@Test
	public void testFindAdvanceAccountByQueryVOCase4(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi2");
		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		List<CreditAccountVo> list = creditAccountMapper.findAdvanceAccountByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("查询结果应该有1条记录",1,list.size());
		System.out.println(list.size());
		assertEquals("账户编号应该和查询条件相等！","CA08082110940001",list.get(0).getAccountNo());
	}
	
	/**
	 * 
	 * @Description:根据条件查询预存款账户列表--账户名称
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:39:50
	 */
	@Test
	public void testFindAdvanceAccountByQueryVOCase5(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi2");
//		vo.setAccountNo("CA08082110940001");
		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		List<CreditAccountVo> list = creditAccountMapper.findAdvanceAccountByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("查询结果应该有1条记录",1,list.size());
		System.out.println(list.size());
		assertEquals("账户名称应该和查询条件相等！","ceshiName1",list.get(0).getAccountName());
	}
	
	/**
	 * 
	 * @Description:根据条件查询预存款账户列表--账户类型
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:39:50
	 */
	@Test
	public void testFindAdvanceAccountByQueryVOCase6(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi2");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		List<CreditAccountVo> list = creditAccountMapper.findAdvanceAccountByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("查询结果应该有8条记录",8,list.size());
		System.out.println(list.size());
		assertEquals("账户类型应该和查询条件相等！","1",String.valueOf(list.get(0).getAccountType()));
	}
	
	
	
	/**
	 * 
	 * @Description:根据条件查询预存款账户列表--账户状态
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:39:50
	 */
	@Test
	public void testFindAdvanceAccountByQueryVOCase7(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi2");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		List<CreditAccountVo> list = creditAccountMapper.findAdvanceAccountByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("查询结果应该有5条记录",5,list.size());
		System.out.println(list.size());
		assertEquals("账户状态应该和查询条件相等！","1",String.valueOf(list.get(0).getStatus()));
	}
	
	
	/**
	 * 
	 * @Description:根据条件查询预存款账户列表--起始时间
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:39:50
	 */
	@Test
	public void testFindAdvanceAccountByQueryVOCase8(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi2");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
		Date startDate = DateUtil.format("2016-06-28 16:45:20", DateUtil.DEFAULT_DATE_TIME);
		Date endDate = DateUtil.format("2016-06-28 16:45:24", DateUtil.DEFAULT_DATE_TIME);
		vo.setCreateTimeStart(startDate);
		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		List<CreditAccountVo> list = creditAccountMapper.findAdvanceAccountByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("查询结果应该有5条记录",5,list.size());
		System.out.println(list.size());
	}
	

	/**
	 * 
	 * @Description: 根据条件查询预存款账户列表总记录数--全条件查询
	 * @author JiangKun
	 * @date 2016年7月4日 下午2:10:45
	 */
	@Test
	public void testCountAdvanceAccountByQueryVOCase1(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
		vo.setMerchantNo("ceshi1");
		vo.setAccountNo("CA08082110940001");
		vo.setAccountName("ceshiName1");
		vo.setAccountType(1);
		vo.setStatus(1);
		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
		Date endDate = DateUtil.format("2016-06-28 16:45:25", DateUtil.DEFAULT_DATE_TIME);
		vo.setCreateTimeStart(startDate);
		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountByQueryVO(vo);
		assertEquals("查询记录数应该为1",1,count);
		System.out.println(count);
	}
	
	/**
	 * 
	 * @Description: 根据资金池编号查询符合条件的记录数--资金池编号
	 * @author JiangKun
	 * @date 2016年7月4日 下午2:10:45
	 */
	@Test
	public void testCountAdvanceAccountByQueryVOCase2(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:24", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountByQueryVO(vo);
		assertEquals("查询记录数应该为9",9,count);
		System.out.println(count);
	}
	
	/**
	 * 
	 * @Description: 根据资金池编号查询符合条件的记录数--商户编号
	 * @author JiangKun
	 * @date 2016年7月4日 下午2:10:45
	 */
	@Test
	public void testCountAdvanceAccountByQueryVOCase3(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:24", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountByQueryVO(vo);
		assertEquals("查询记录数应该为1",1,count);
		System.out.println(count);
	}
	
	/**
	 * 
	 * @Description: 根据账户编号查询符合条件的记录数--账户编号
	 * @author JiangKun
	 * @date 2016年7月4日 下午2:10:45
	 */
	@Test
	public void testCountAdvanceAccountByQueryVOCase4(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:24", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountByQueryVO(vo);
		assertEquals("查询记录数应该为1",1,count);
		System.out.println(count);
	}
	
	/**
	 * 
	 * @Description: 根据账户名称查询符合条件的记录数--账户名称
	 * @author JiangKun
	 * @date 2016年7月4日 下午2:10:45
	 */
	@Test
	public void testCountAdvanceAccountByQueryVOCase5(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:24", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountByQueryVO(vo);
		assertEquals("查询记录数应该为1",1,count);
		System.out.println(count);
	}
	
	/**
	 * 
	 * @Description: 根据账户类型查询符合条件的记录数--资金池编号和账户类型
	 * @author JiangKun
	 * @date 2016年7月4日 下午2:10:45
	 */
	@Test
	public void testCountAdvanceAccountByQueryVOCase6(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:24", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountByQueryVO(vo);
		assertEquals("查询记录数应该为8",8,count);
		System.out.println(count);
	}
	
	/**
	 * 
	 * @Description: 根据账户状态查询符合条件的记录数--资金池编号，账户状态
	 * @author JiangKun
	 * @date 2016年7月4日 下午2:10:45
	 */
	@Test
	public void testCountAdvanceAccountByQueryVOCase7(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:24", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountByQueryVO(vo);
		assertEquals("查询记录数应该为5",5,count);
		System.out.println(count);
	}
	
	
	/**
	 * 
	 * @Description: 根据创建时间查询符合条件的记录数-资金池编号，起始时间
	 * @author JiangKun
	 * @date 2016年7月4日 下午2:10:45
	 */
	@Test
	public void testCountAdvanceAccountByQueryVOCase8(){
		CreditAccountQueryVo vo = new CreditAccountQueryVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
		Date endDate = DateUtil.format("2016-06-28 16:45:20", DateUtil.DEFAULT_DATE_TIME);
		vo.setCreateTimeStart(startDate);
		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountByQueryVO(vo);
		assertEquals("查询记录数应该为4",4,count);
		System.out.println(count);
	}
	
	/**
	 * 
	 * @Description: 内部系统使用的查询预存款账户列表--全条件查询
	 * @author JiangKun
	 * @date 2016年7月12日 下午4:42:20
	 */
	@Test
	public void testFindAdvanceAccountInnerByQueryVOCase1(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
		vo.setMerchantNo("ceshi1");
		vo.setAccountNo("CA08082110940001");
		vo.setAccountName("ceshiName1");
		vo.setAccountType(1);
		vo.setStatus(1);
		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
		vo.setCreateTimeStart(startDate);
		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		 List<CreditAccountInnerVo> list = creditAccountMapper.findAdvanceAccountInnerByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("list中有应该有1条记录",1,list.size());
		assertEquals("accountNo应该和查询条件中相等！","CA08082110940001",list.get(0).getAccountNo());
	
	}
	
	/**
	 * 
	 * @Description: 内部系统使用的查询预存款账户列表--资金池编号
	 * @author JiangKun
	 * @date 2016年7月12日 下午4:42:20
	 */
	@Test
	public void testFindAdvanceAccountInnerByQueryVOCase2(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		 List<CreditAccountInnerVo> list = creditAccountMapper.findAdvanceAccountInnerByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("list中有应该有9条记录",9,list.size());
		assertEquals("poolNo应该和查询条件中相等！","PN01000000000001761",list.get(0).getPoolNo());
	
	}
	
	/**
	 * 
	 * @Description: 内部系统使用的查询预存款账户列表--商户编号
	 * @author JiangKun
	 * @date 2016年7月12日 下午4:42:20
	 */
	@Test
	public void testFindAdvanceAccountInnerByQueryVOCase3(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		 List<CreditAccountInnerVo> list = creditAccountMapper.findAdvanceAccountInnerByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("list中有应该有1条记录",1,list.size());
		assertEquals("MerchantNo应该和查询条件中相等！","ceshi1",list.get(0).getMerchantNo());
	
	}
	
	/**
	 * 
	 * @Description: 内部系统使用的查询预存款账户列表--账户编号
	 * @author JiangKun
	 * @date 2016年7月12日 下午4:42:20
	 */
	@Test
	public void testFindAdvanceAccountInnerByQueryVOCase4(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		 List<CreditAccountInnerVo> list = creditAccountMapper.findAdvanceAccountInnerByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("list中有应该有1条记录",1,list.size());
		assertEquals("accountNo应该和查询条件中相等！","CA08082110940001",list.get(0).getAccountNo());
	
	}
	
	/**
	 * 
	 * @Description: 内部系统使用的查询预存款账户列表--账户名称
	 * @author JiangKun
	 * @date 2016年7月12日 下午4:42:20
	 */
	@Test
	public void testFindAdvanceAccountInnerByQueryVOCase5(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		 List<CreditAccountInnerVo> list = creditAccountMapper.findAdvanceAccountInnerByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("list中有应该有1条记录",1,list.size());
		assertEquals("accountName应该和查询条件中相等！","ceshiName1",list.get(0).getAccountName());
	
	}
	
	/**
	 * 
	 * @Description: 内部系统使用的查询预存款账户列表--资金池编号，账户类型
	 * @author JiangKun
	 * @date 2016年7月12日 下午4:42:20
	 */
	@Test
	public void testFindAdvanceAccountInnerByQueryVOCase6(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		 List<CreditAccountInnerVo> list = creditAccountMapper.findAdvanceAccountInnerByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("list中有应该有8条记录",8,list.size());
		assertEquals("accountType应该和查询条件中相等！","1",String.valueOf(list.get(0).getAccountType()));
	
	}
	
	/**
	 * 
	 * @Description: 内部系统使用的查询预存款账户列表--资金池编号，账户状态
	 * @author JiangKun
	 * @date 2016年7月12日 下午4:42:20
	 */
	@Test
	public void testFindAdvanceAccountInnerByQueryVOCase7(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-27 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-29 00:00:00", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		 List<CreditAccountInnerVo> list = creditAccountMapper.findAdvanceAccountInnerByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("list中有应该有5条记录",5,list.size());
		assertEquals("status应该和查询条件中相等！","1",String.valueOf(list.get(0).getStatus()));
	
	}
	
	/**
	 * 
	 * @Description: 内部系统使用的查询预存款账户列表--资金池编号，起始时间
	 * @author JiangKun
	 * @date 2016年7月12日 下午4:42:20
	 */
	@Test
	public void testFindAdvanceAccountInnerByQueryVOCase8(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
		Date endDate = DateUtil.format("2016-06-28 16:45:20", DateUtil.DEFAULT_DATE_TIME);
		vo.setCreateTimeStart(startDate);
		vo.setCreateTimeEnd(endDate);
		
		vo.setStartCount(0);
		vo.setShowCount(20);
		 List<CreditAccountInnerVo> list = creditAccountMapper.findAdvanceAccountInnerByQueryVO(vo);
		assertNotNull("根条件查询账户'查询不该为空", list);
		assertEquals("list中有应该有4条记录",4,list.size());

	}
	
	/**
	 * 
	 * @Description: 内部根据条件查询预存款账户列表总记录数--全条件查询
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:11:21
	 */
	@Test
	public void testCountAdvanceAccountInnerByQueryVOCase1(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
		vo.setMerchantNo("ceshi1");
		vo.setAccountNo("CA08082110940001");
		vo.setAccountName("ceshiName1");
		vo.setAccountType(1);
		vo.setStatus(1);
		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
		Date endDate = DateUtil.format("2016-06-28 16:45:25", DateUtil.DEFAULT_DATE_TIME);
		vo.setCreateTimeStart(startDate);
		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountInnerByQueryVO(vo);
		assertEquals("查询记录数应该为1",1,count);
		System.out.println(count);
	
	}
	
	/**
	 * 
	 * @Description: 内部根据条件查询预存款账户列表总记录数--资金池编号
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:11:21
	 */
	@Test
	public void testCountAdvanceAccountInnerByQueryVOCase2(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:25", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountInnerByQueryVO(vo);
		assertEquals("查询记录数应该为9",9,count);
		System.out.println(count);
	
	}
	
	/**
	 * 
	 * @Description: 内部根据条件查询预存款账户列表总记录数--商户编号
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:11:21
	 */
	@Test
	public void testCountAdvanceAccountInnerByQueryVOCase3(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:25", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountInnerByQueryVO(vo);
		assertEquals("查询记录数应该为1",1,count);
		System.out.println(count);
	
	}
	
	/**
	 * 
	 * @Description: 内部根据条件查询预存款账户列表总记录数--账户编号
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:11:21
	 */
	@Test
	public void testCountAdvanceAccountInnerByQueryVOCase4(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:25", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountInnerByQueryVO(vo);
		assertEquals("查询记录数应该为1",1,count);
		System.out.println(count);
	
	}
	
	/**
	 * 
	 * @Description: 内部根据条件查询预存款账户列表总记录数--账户名称
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:11:21
	 */
	@Test
	public void testCountAdvanceAccountInnerByQueryVOCase5(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
//		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:25", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountInnerByQueryVO(vo);
		assertEquals("查询记录数应该为1",1,count);
		System.out.println(count);
	
	}
	
	/**
	 * 
	 * @Description: 内部根据条件查询预存款账户列表总记录数--资金池编号，账户类型
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:11:21
	 */
	@Test
	public void testCountAdvanceAccountInnerByQueryVOCase6(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
		vo.setAccountType(1);
//		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:25", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountInnerByQueryVO(vo);
		assertEquals("查询记录数应该为8",8,count);
		System.out.println(count);
	
	}
	
	/**
	 * 
	 * @Description: 内部根据条件查询预存款账户列表总记录数--资金池编号，账户状态
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:11:21
	 */
	@Test
	public void testCountAdvanceAccountInnerByQueryVOCase7(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
		vo.setStatus(1);
//		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
//		Date endDate = DateUtil.format("2016-06-28 16:45:25", DateUtil.DEFAULT_DATE_TIME);
//		vo.setCreateTimeStart(startDate);
//		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountInnerByQueryVO(vo);
		assertEquals("查询记录数应该为5",5,count);
		System.out.println(count);
	
	}
	
	/**
	 * 
	 * @Description: 内部根据条件查询预存款账户列表总记录数--资金池编号，起始时间
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:11:21
	 */
	@Test
	public void testCountAdvanceAccountInnerByQueryVOCase8(){

		CreditAccountQueryInnerVo vo = new CreditAccountQueryInnerVo();
		vo.setCoreMerchantNo("liantuo");
		
		vo.setPoolNo("PN01000000000001761");
//		vo.setMerchantNo("ceshi1");
//		vo.setAccountNo("CA08082110940001");
//		vo.setAccountName("ceshiName1");
//		vo.setAccountType(1);
//		vo.setStatus(1);
		Date startDate = DateUtil.format("2016-06-28 16:45:17", DateUtil.DEFAULT_DATE_TIME);
		Date endDate = DateUtil.format("2016-06-28 16:45:20", DateUtil.DEFAULT_DATE_TIME);
		vo.setCreateTimeStart(startDate);
		vo.setCreateTimeEnd(endDate);
		
		int count = creditAccountMapper.countAdvanceAccountInnerByQueryVO(vo);
		assertEquals("查询记录数应该为4",4,count);
		System.out.println(count);
	
	}
	
	/**
	 * 
	 * @Description: 根据id和版本号version，更新账户名称、账户类型、账户状态,更新成功
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:20:48
	 */
	@Test
	public void testUpdateAccountInfoCase1(){
		Integer id = 1234567;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNotNull("不应该为空",ca);
		//未修改之前数据
		Long version = ca.getVersion();
		Integer accountType = ca.getAccountType();
		String accountName = ca.getSuperType();
		Integer status = ca.getStatus();
		//设置修改数据
		ca.setAccountType(2);
		ca.setSuperType("newName");
		ca.setStatus(2);
		
		boolean result = creditAccountMapper.updateAccountInfo(ca);
		assertTrue("更新成功result应该为true",result);

		//校验更新后结果
		CreditAccount caUpdate = creditAccountMapper.selectByPrimaryKey(id);
		assertEquals("version更新后结果应该为:"+(version+1),new Long(version+1),caUpdate.getVersion());
		assertEquals("accountType更新后结果应该为2","2",String.valueOf(caUpdate.getAccountType()));
		assertEquals("accountName更新后结果应该为newName","newName",caUpdate.getSuperType());
		assertEquals("status更新后结果应该为2","2",String.valueOf(ca.getStatus()));

	}
	
	/**
	 * 
	 * @Description: 根据id和版本号version，更新账户名称、账户类型、账户状态,id存在，但version版本不对
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:20:48
	 */
	@Test
	public void testUpdateAccountInfoCase2(){
		Integer id = 1234567;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNotNull("不应该为空",ca);
		//未修改之前数据
		Long version = ca.getVersion();
		Integer accountType = ca.getAccountType();
		String accountName = ca.getSuperType();
		Integer status = ca.getStatus();
		//设置修改数据
		ca.setAccountType(2);
		ca.setSuperType("newName");
		ca.setStatus(2);
		ca.setVersion(version+1);
		boolean result = creditAccountMapper.updateAccountInfo(ca);
		assertEquals("更新失败,result应该为false！",false,result);

		//校验更新后结果
		CreditAccount caAfter = creditAccountMapper.selectByPrimaryKey(id);
		assertEquals("更新失败,version不变，应该为:"+version,version,caAfter.getVersion());
		assertEquals("更新失败,accountType应该为:"+accountType,accountType,caAfter.getAccountType());
		assertEquals("更新失败,accountName应该为:"+accountName,accountName,caAfter.getSuperType());
		assertEquals("更新失败,status应该为:"+status,status,caAfter.getStatus());

	}
	
	/**
	 * 
	 * @Description: 根据id和版本号version，更新账户名称、账户类型、账户状态,更新成功，id不存在
	 * @author JiangKun
	 * @date 2016年7月12日 下午5:20:48
	 */
	@Test
	public void testUpdateAccountInfoCase3(){
		Integer id = 1234568;
		CreditAccount ca = creditAccountMapper.selectByPrimaryKey(id);
		assertNull("应该为空",ca);
		//未修改之前数据
		ca = new CreditAccount();
		ca.setId(id);
		ca.setAccountType(2);
		ca.setSuperType("newName");
		ca.setStatus(2);
		ca.setVersion(1L);
		
		boolean result = creditAccountMapper.updateAccountInfo(ca);
		assertEquals("更新失败,result应该为false！",false,result);
	}
	

	/**
	 * 
	 * @Description: 插入账户
	 * @author JiangKun
	 * @date 2016年6月29日 下午5:40:13
	 */
	@Test
	public void testInsert(){
		idFactoryCaAccountNo = mock(StepSequenceFactoryForSpdb.class);
		StepSequenceFactoryForSpdbMock.mockGenerate(idFactoryCaAccountNo, "123456");
		CreditAccount account = new CreditAccount();
        account.setMerchantNo("123456789123123");
        account.setAccountType(1);//1-企业 2-个人 3-内部
        account.setCoreMerchantNo("123456789123123");
        account.setPoolNo("333444");
        account.setSuperType("xxx");//account_name     
        account.setBalLastChangeTime(new Date());
        account.setStatus(CreditAccountConstants.CREDIT_ACCOUNT_STATUS_NORMAL);
        account.setVersion(0L);
        account.setAvailableBalance(0.0);
        account.setFreezenBalance(0.00);
        account.setFeeRate(0.0);
        account.setSysTime(new Date());
        account.setTotalBalance(0.00);
        account.setAccountNo(idFactoryCaAccountNo.generate().toString());
        account.setCreditType(CreditAccountConstants.CREDIT_TYPE_DEBIT);
        account.setCreditLine(0.0);
        account.setBalanceNFlag(CreditAccountConstants.BALANCE_N_FLAG_N);
        account.setGmtCreated(new Date());
        account.setGmtModified(new Date());
        account.setPassword("");
		int successCount = creditAccountMapper.insert(account);
		assertEquals("插入成功返回应该为1",1,successCount);
		System.out.println(successCount);
	}
	
	
}
