package com.liantuo.deposit.advanceaccount.orm.mapper;

import java.util.List;

import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.CreditAccountQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.returnvo.CreditAccountInnerVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.CreditAccountQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.returnvo.CreditAccountVo;

public interface CreditAccountMapper {

    public CreditAccount selectByPrimaryKey(Integer id);

    /**
     * @方法名: selectByAccountNo
     * @方法说明: 根据accountNo查询CreditAccount
     * @param accountNo
     * @return
     * @返回类型 CreditAccount
     * @创建人: bjl
     * @创建时间: 2015年12月15日 下午1:10:23
     */
    public CreditAccount selectByAccountNo (String accountNo);

    /**
     * @方法名: updateAvlBalance
     * @方法说明: 更新可用余额
     * @param creditAccount
     * @返回类型 int
     * @创建人: bjl
     * @创建时间: 2015年12月16日 下午12:43:54
     */
    public int updateAvlBalance(CreditAccount creditAccount);

    /**
     * @方法名: updateFrozenBalance
     * @方法说明: 更新冻结金额
     * @param creditAccount
     * @返回类型 int
     * @创建人: bjl
     * @创建时间: 2015年12月16日 下午1:40:28
     */
    public int updateFrozenBalance(CreditAccount creditAccount);

//    /**
//     * @方法名: ascAccountNos
//     * @方法说明:对CA账号按Id执行升序
//     * @param accountNos
//     * @return
//     * @返回类型 List<CreditAccount>
//     * @创建人: bjl
//     * @创建时间: 2015年12月17日 上午9:37:04
//     */
//    public List<CreditAccount> ascAccountNos(String[] accountNos);

    /**
     * @方法名: findAccountNoNotSx
     * @方法说明: 并排除授信账户
     * @param accountNos
     * @return
     * @返回类型 List<CreditAccount>
     * @创建人: 刘景备
     * @创建时间: 2016年03月23日 上午9:37:04
     */
    public List<CreditAccount> findAdvanceAccountByAccountNo(String accountNo);
    /**
     * @方法名: selectByIdForUpdate
     * @方法说明:锁定账户
     * @param id
     * @return
     * @返回类型 CreditAccount
     * @创建人: bjl
     * @创建时间: 2015年12月17日 上午9:48:58
     */
    public CreditAccount selectByIdForUpdate(Integer id);


	/**
	* @方法名: findAdvanceAccountByQueryVO
     * @方法说明:外部系统使用的查询预存款账户列表
     * @param creditAccountQueryVo
     * @return
     * @返回类型 List<CreditAccountVo>
	 */
	public List<CreditAccountVo> findAdvanceAccountByQueryVO(CreditAccountQueryVo creditAccountQueryVo);

	public int countAdvanceAccountByQueryVO(CreditAccountQueryVo creditAccountQueryVo);

	/**
	* @方法名: findAdvanceAccountInnerByQueryVO
     * @方法说明:内部系统使用的查询预存款账户列表
     * @param creditAccountQueryInnerVo
     * @return
     * @返回类型 List<CreditAccountInnerVo>
	 */
	public List<CreditAccountInnerVo> findAdvanceAccountInnerByQueryVO(CreditAccountQueryInnerVo creditAccountQueryInnerVo);

	public int countAdvanceAccountInnerByQueryVO(CreditAccountQueryInnerVo creditAccountQueryVo);


	/**
	 *
	* @Title: updateAccountInfo
	* @Description: 更新账户名称和状态
	* @param @param creditAccount
	* @param @return
	* @return boolean
	* @throws
	* @author shihb
	* @date 2016-4-27 上午11:33:56
	 */
	public boolean updateAccountInfo(CreditAccount creditAccount);

	public int insert(CreditAccount creditAccount);
}