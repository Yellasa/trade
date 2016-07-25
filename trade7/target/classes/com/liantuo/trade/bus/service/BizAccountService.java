package com.liantuo.trade.bus.service;

import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.trade.bus.vo.RealTimeAccountVO;
import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.exception.BusinessUncheckedException;

import java.util.Date;
import java.util.List;

/**
 * 账务服务
 */
public interface BizAccountService<R extends TradePacket> {

    /**
     * 根据收款账号查询账号信息
     * @param accountno
     * @return
     */
    CreditAccount selectByAccountNo(String accountno);
    
    /**
     * 冻结:第一步：可用余额减少	第二步：冻结余额增加
     * @param accountvo
     * @return
     * @throws BusinessUncheckedException
     */
    public List<RealTimeAccountingRsp> freeze(RealTimeAccountVO accountvo) throws BusinessUncheckedException;

    /**
     * 线下付款成功，剩余解冻:第一步：冻结余额减少	第二步：可用余额增加	第三步：可用余额减少
     * @param accountvo
     * @return
     * @throws BusinessUncheckedException
     */
    public List<RealTimeAccountingRsp> unFreezeOffline(RealTimeAccountVO accountvo) throws BusinessUncheckedException;
    
    /**全额解冻:第一步：冻结余额减少	第二步：可用余额增加
     * @param accountvo
     * @return
     * @throws BusinessUncheckedException
     */
    public List<RealTimeAccountingRsp> fullUnFreeze(RealTimeAccountVO accountvo) throws BusinessUncheckedException;
    
    
    /**
     * CA付款成功，剩余解冻：第一步：冻结余额减少	第二步：可用余额增加	第三步：可用余额减少	第四步：可用余额增加
     * @param accountvo
     * @return
     * @throws BusinessUncheckedException
     */
    public List<RealTimeAccountingRsp> unFreezeOnline(RealTimeAccountVO accountvo) throws BusinessUncheckedException;
    
    /**
     * 线下退款：可用余额增加
     * @param accountvo
     * @return
     * @throws BusinessUncheckedException
     */
    public List<RealTimeAccountingRsp> refundOffline(RealTimeAccountVO accountvo) throws BusinessUncheckedException;
    
    /**
     * 单边可用余额增加，多用于退回等操作
     * @param accountvo
     * @return
     * @throws BusinessUncheckedException
     */
    public List<RealTimeAccountingRsp> avlBalIncr(RealTimeAccountVO accountvo) throws BusinessUncheckedException;
    
    /**
     * 单边可用余额减少，多用于扣减等操作
     * @param accountvo
     * @return
     * @throws BusinessUncheckedException
     */
    public List<RealTimeAccountingRsp> avlBalDecr(RealTimeAccountVO accountvo) throws BusinessUncheckedException;

   /**
    * 成员CA转账
    * @param accountvo
    * @return list
    * @throws BusinessException
    */
    public List<RealTimeAccountingRsp> transfer(RealTimeAccountVO accountvo) throws BusinessException;
    
    /**
     * 单边可用余额减少请求对象组织
     * @param accountvo
     * @return
     * @throws BusinessUncheckedException
     */
    public RealTimeAccountingVo avlBalDecrWrapper(RealTimeAccountVO accountvo) throws BusinessException;
    
    /**
     *  单边可用余额增加请求对象组织
     * @param accountvo
     * @return
     * @throws BusinessUncheckedException
     */
    public RealTimeAccountingVo avlBalIncrWrapper(RealTimeAccountVO accountvo) throws BusinessException;
    
    /**
     * 发送账务请求
     * @param accounts
     * @return
     * @throws BusinessUncheckedException
     */
    public List<RealTimeAccountingRsp> senderRequestToAccount(List<RealTimeAccountingVo> accounts)  throws BusinessException;
    /**
     * @Title:FrozenBalDecrAmtWrapper
     * @Description:冻结余额减少
     * @param accountvo
     * @return
     * @throws BusinessException
     * @return:RealTimeAccountingVo
     * @author:zoran.huang
     * @date:2016年6月7日 上午9:27:34
     */
    public RealTimeAccountingVo FrozenBalDecrAmtWrapper(RealTimeAccountVO accountvo) throws BusinessException;
    
    /**
     * @Title:FrozenBalIncrAmtWrapper
     * @Description:冻结余额增加金额
     * @param accountvo
     * @return
     * @throws BusinessException
     * @return:RealTimeAccountingVo
     * @author:zoran.huang
     * @date:2016年6月7日 上午9:28:09
     */
    public RealTimeAccountingVo FrozenBalIncrAmtWrapper(RealTimeAccountVO accountvo) throws BusinessException;
}