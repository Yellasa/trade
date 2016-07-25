package com.liantuo.deposit.advanceaccount.orm.mapper;


import java.util.List;

import com.liantuo.deposit.advanceaccount.orm.pojo.AccountForbidTrade;

public interface AccountForbidTradeMapper {

    /**
     * 根据主键删除记录
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    int insert(AccountForbidTrade record);

    /**
     * 根据主键查询记录
     */
    AccountForbidTrade selectByPrimaryKey(Integer id);
    
    /**
     * @方法名: selectWhetherForbidAllByCA
     * @方法说明: 根据CA账号查询是否禁止所有的交易
     * @param accountNo
     * @return
     * @返回类型 AccountForbidTrade
     * @创建人: bjl
     * @创建时间: 2016年1月29日 下午5:43:45
     */
    public AccountForbidTrade selectWhetherForbidAllByCA(String accountNo);
    
    /**
     * @方法名: selectWhetherForbidThisTrade
     * @方法说明: 查询是否禁止该交易类型或该交易请求类型
     * @param accountForbidTrade
     * @return
     * @返回类型 AccountForbidTrade
     * @创建人: bjl
     * @创建时间: 2016年1月29日 下午6:07:43
     */
    public AccountForbidTrade selectWhetherForbidThisTrade(AccountForbidTrade accountForbidTrade);
    
    public List<AccountForbidTrade>selectByAccouNo(String accountNo);

    public List<AccountForbidTrade> selectByCAAndForbidCode(AccountForbidTrade record);

}