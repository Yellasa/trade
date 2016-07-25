package com.liantuo.deposit.advanceaccount.bus.service;



import java.util.List;

import com.liantuo.deposit.advanceaccount.orm.pojo.AccountForbidTrade;
import com.liantuo.deposit.advanceaccount.web.vo.req.AccountForbidReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.AccountForbidUpdateReqVo;

public interface AccountForbidTradeService {

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
    
    /**
     * 
    * @Title: selectByCA 
    * @Description: 根据CA查找
    * @param @param accountNo
    * @param @return
    * @return List<AccountForbidTrade>
    * @throws 
    * @author shihb
    * @date 2016-3-30 下午2:54:52
     */
    public List<AccountForbidTrade> selectByCA(String accountNo);

    /**
     * 
    * @Title: createAccountForbid 
    * @Description: 批量禁止结构变更
    * @param @param body
    * @return void
    * @throws 
    * @author shihb
    * @date 2016-3-31 下午4:06:01
     */
	void createAccountForbid(AccountForbidUpdateReqVo body,List<AccountForbidTrade> list,List<AccountForbidReqVo> forbidList) throws Exception;
	
	/**
	 * 
	* @Title: masterSelectByCA 
	* @Description: 通过ca查询主库
	* @param @param accountNo
	* @param @return
	* @return List<AccountForbidTrade>
	* @throws 
	* @author shihb
	* @date 2016-4-5 上午9:44:56
	 */
    public List<AccountForbidTrade> masterSelectByCA(String accountNo);

}