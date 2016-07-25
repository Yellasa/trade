package com.liantuo.deposit.advanceaccount.bus.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebill.framework.datatype.DoubleUtil;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountService;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.deposit.advanceaccount.orm.mapper.AccountForbidTradeMapper;
import com.liantuo.deposit.advanceaccount.orm.mapper.CreditAccountMapper;
import com.liantuo.deposit.advanceaccount.orm.mapper.PoolMapper;
import com.liantuo.deposit.advanceaccount.orm.pojo.AccountForbidTrade;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.deposit.advanceaccount.orm.pojo.Pool;
import com.liantuo.deposit.advanceaccount.web.inner.vo.queryvo.CreditAccountQueryInnerVo;
import com.liantuo.deposit.advanceaccount.web.inner.vo.returnvo.CreditAccountInnerVo;
import com.liantuo.deposit.advanceaccount.web.vo.queryvo.CreditAccountQueryVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.OpenCreditAccountReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.returnvo.CreditAccountVo;
import com.liantuo.deposit.advanceaccount.web.vo.rsp.OpenCreditAccountRspVo;
import com.liantuo.deposit.common.constants.AccountForbidTradeConstants;
import com.liantuo.deposit.common.constants.CreditAccountConstants;
import com.liantuo.deposit.common.constants.ErrorCode001Constants;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode009Constants;
import com.liantuo.mc.web.client.MerchantClient;
import com.liantuo.mc.web.req.MerchantOutRequest;
import com.liantuo.mc.web.req.RequestHead;
import com.liantuo.mc.web.rsp.MerchantResponse;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.exception.AmountConvertException;
import com.liantuo.trade.exception.BusinessException;
import com.liantuo.trade.exception.BusinessUncheckedException;
import com.liantuo.trade.seqno.StepSequenceFactoryForSpdb;

@Service(value="creditAccountServiceImpl")
public class CreditAccountServiceImpl implements CreditAccountService {
	private static final Logger  LOGGER = LoggerFactory.getLogger(CreditAccountServiceImpl.class);

	@Autowired
	private CreditAccountMapper creditAccountMapper;

	@Autowired
	private AccountForbidTradeMapper accountForbidTradeMapper;

	@Resource(name ="idFactoryCaAccountNo")
	private StepSequenceFactoryForSpdb idFactoryCaAccountNo;

	@Resource
	private PoolMapper poolMapper;
	@Override
	public CreditAccount selectByPrimaryKey(Integer id) {
		return creditAccountMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateAvlBalDecr(CreditAccount creditAccount, Long amount,
			Date balLastChangeTime) throws BusinessUncheckedException {
		Double availBalance = creditAccount.getAvailableBalance();//账户可用余额
		Double avlBalDecrAmt;//账户可用余额减少金额
		try {
			avlBalDecrAmt = Double.valueOf(AmountUtils.longConvertToBizAmount(amount));
			Double totalBalance = creditAccount.getTotalBalance();//账户总金额

			if(DoubleUtil.compareTo(availBalance, avlBalDecrAmt)<0){
				throw new BusinessUncheckedException(ErrorCode001Constants.ACCOUNT_BALANCE_NOT_ENOUGH, creditAccount.getAccountNo()+"账户余额不足");
			}

			availBalance = DoubleUtil.sub(availBalance, avlBalDecrAmt);
			totalBalance = DoubleUtil.sub(totalBalance,avlBalDecrAmt);

			creditAccount.setAvailableBalance(availBalance);
			creditAccount.setTotalBalance(totalBalance);
			creditAccount.setBalLastChangeTime(balLastChangeTime);

			if(creditAccountMapper.updateAvlBalance(creditAccount)>0){
				LOGGER.info("更新账户"+creditAccount.getAccountNo()+"余额成功,版本号"+creditAccount.getVersion());
				return true;
			}else {
				LOGGER.info("更新账户金额失败账户"+creditAccount.getAccountNo());
				throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
			}
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
		} catch (AmountConvertException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
		}

	}

	@Override
	public boolean updateAvlBalIncr(CreditAccount creditAccount, Long amount,
			Date balLastChangeTime) throws  BusinessUncheckedException{
		Double availBalance = creditAccount.getAvailableBalance();//账户可用余额
		Double totalBalance = creditAccount.getTotalBalance();//账户总金额
		Double avlBalIncrAmt;//账户可用余额增加金额
		try {
			avlBalIncrAmt = Double.valueOf(AmountUtils.longConvertToBizAmount(amount));

			availBalance = DoubleUtil.add(availBalance, avlBalIncrAmt);
			totalBalance = DoubleUtil.add(totalBalance, avlBalIncrAmt);

			creditAccount.setAvailableBalance(availBalance);
			creditAccount.setTotalBalance(totalBalance);
			creditAccount.setBalLastChangeTime(balLastChangeTime);

			if(creditAccountMapper.updateAvlBalance(creditAccount)>0){
				LOGGER.info("更新账户"+creditAccount.getAccountNo()+"余额成功,版本号"+creditAccount.getVersion());
				return true;
			}else {
				LOGGER.info("更新账户金额失败账户"+creditAccount.getAccountNo());
				throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
			}

		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
		} catch (AmountConvertException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
		}
	}

	@Override
	public boolean updateFrozenBalIncr(CreditAccount creditAccount, Long amount,
			Date balLastChangeTime) throws BusinessUncheckedException
			 {
		Double frozenBal = creditAccount.getFreezenBalance();
		Double totalBalance = creditAccount.getTotalBalance();
		Double frozenBalIncrAmt;
		try {
			frozenBalIncrAmt = Double.valueOf(AmountUtils.longConvertToBizAmount(amount));

			frozenBal = DoubleUtil.add(frozenBal, frozenBalIncrAmt);
			totalBalance = DoubleUtil.add(totalBalance, frozenBalIncrAmt);

			creditAccount.setFreezenBalance(frozenBal);
			creditAccount.setTotalBalance(totalBalance);
			creditAccount.setBalLastChangeTime(balLastChangeTime);

			if(creditAccountMapper.updateFrozenBalance(creditAccount)>0){
				LOGGER.info("更新账户"+creditAccount.getAccountNo()+"余额成功,版本号"+creditAccount.getVersion());
				return true;
			}else {
				LOGGER.info("更新账户金额失败账户"+creditAccount.getAccountNo());
				throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
			}
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
		} catch (AmountConvertException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
		}
	}

	@Override
	public boolean updateFrozenBalDecr(CreditAccount creditAccount, Long amount,
			Date balLastChangeTime) throws BusinessUncheckedException {
		Double frozenBal = creditAccount.getFreezenBalance();//账户冻结金额
		Double frozenBalDecrAmt;//账户冻结金额减少金额
		try {
			frozenBalDecrAmt = Double.valueOf(AmountUtils.longConvertToBizAmount(amount));//long类型的冻结金额减少金额转换为Double类型

			if(DoubleUtil.compareTo(frozenBal, frozenBalDecrAmt)<0){
				LOGGER.info("==========账户"+creditAccount.getAccountNo()+"冻结余额小于冻结金额减少金额");
				throw new BusinessUncheckedException(ErrorCode001Constants.ACCOUNT_BALANCE_NOT_ENOUGH, creditAccount.getAccountNo()+"账户余额不足");
			}

			frozenBal = DoubleUtil.sub(frozenBal, frozenBalDecrAmt);

			creditAccount.setFreezenBalance(frozenBal);
			creditAccount.setBalLastChangeTime(balLastChangeTime);
			creditAccount.setTotalBalance(DoubleUtil.sub(creditAccount.getTotalBalance(), frozenBalDecrAmt));

			if(creditAccountMapper.updateFrozenBalance(creditAccount)>0){
				LOGGER.info("更新账户"+creditAccount.getAccountNo()+"余额成功,版本号"+creditAccount.getVersion());
				return true;
			}else {
				LOGGER.info("更新账户金额失败账户"+creditAccount.getAccountNo());
				throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
			}
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
		} catch (AmountConvertException e) {
			LOGGER.error("金额转换异常，账户"+creditAccount.getAccountNo());
			throw new BusinessUncheckedException(ErrorCode001Constants.SYSTEM_EXCEPTION, "系统异常");
		}
	}

	@Override
	public CreditAccount selectByAccountNo(String accountNo) {
		return creditAccountMapper.selectByAccountNo(accountNo);
	}

	public HashMap<String, CreditAccount> ascAccountNosAndLock(Integer ids[]) {
		HashMap<String, CreditAccount> lockedCreditAccountMap = new HashMap<String,CreditAccount>();
		Arrays.sort(ids);
		for(int i=0;i<ids.length;i++){
			CreditAccount creditAccount = creditAccountMapper.selectByIdForUpdate(ids[i]);
			LOGGER.info("当前线程的ID"+Thread.currentThread().getId()+"账户"+creditAccount.getAccountNo()+"锁定成功,版本号"+creditAccount.getVersion());
			lockedCreditAccountMap.put(creditAccount.getAccountNo(), creditAccount);
		}
		return lockedCreditAccountMap;
	}

	/*@Override
	public HashMap<String, CreditAccount> ascAccountNosAndLock(List<RealTimeAccountingVo> list) {
		String[] accountNos = new String[list.size()];//循环遍历list
		for (int i = 0; i < list.size(); i++) {
			accountNos[i] = list.get(i).getAccountNo();
		}

		List<CreditAccount> creditAccounts = creditAccountMapper.ascAccountNos(accountNos);//对账户按ID进行升序操作
		HashMap<String, CreditAccount> lockedCreditAccountMap = new HashMap<String,CreditAccount>();

		for(int i=0;i<creditAccounts.size();i++){
			CreditAccount creditAccount = creditAccountMapper.selectByIdForUpdate(creditAccounts.get(i).getId());

			LOGGER.info("当前线程的ID"+Thread.currentThread().getId()+"账户"+creditAccount.getAccountNo()+"锁定成功,版本号"+creditAccount.getVersion());

			lockedCreditAccountMap.put(creditAccounts.get(i).getAccountNo(), creditAccount);
		}
		return lockedCreditAccountMap;
	}*/
	@SuppressWarnings("deprecation")
	@Override
	public boolean accountStatusValidate(RealTimeAccountingVo vo,CreditAccount creditAccount) throws BusinessUncheckedException{
		if(creditAccount == null){
			LOGGER.info(vo.getAccountNo()+"账户不存在");
			throw new BusinessUncheckedException(ErrorCode001Constants.ACCOUNT_NOT_EXIST, vo.getAccountNo()+"账户不存在");
		}

		if(!creditAccount.getCoreMerchantNo().equals(vo.getCoreMerchantNo())){
			LOGGER.info(vo.getAccountNo()+"账户表中的核心商户和参数中的核心商户不符");
			throw new BusinessUncheckedException(ErrorCode001Constants.CORE_MERCHANT_NO_NOT_CORRECT, vo.getAccountNo()+"账户表中的核心商户和参数中的核心商户不符");
		}

		if(!creditAccount.getPoolNo().equals(vo.getPoolNo())){
			LOGGER.info(vo.getAccountNo()+"账户表中资金池编号和参数中的资金池编号不符");
			throw new BusinessUncheckedException(ErrorCode001Constants.POOL_NO_NOT_CORRECT, vo.getAccountNo()+"账户表中资金池编号和参数中的资金池编号不符");
		}

		if(!creditAccount.getStatus().equals(1)){
			LOGGER.info(vo.getAccountNo()+"账户状态异常");
			throw new BusinessUncheckedException(ErrorCode001Constants.ACCOUNT_STATUS_EXCEPTION, vo.getAccountNo()+"账户状态异常");
		}

		if(accountForbidTradeMapper.selectWhetherForbidAllByCA(vo.getAccountNo()) != null){
			LOGGER.info(vo.getAccountNo()+"账户禁止该交易类型");
			throw new BusinessUncheckedException(ErrorCode001Constants.FORBID_THIS_TRADE_TYPE, vo.getAccountNo()+"账户禁止该交易类型");
		}

		AccountForbidTrade accountForbidTrade = new AccountForbidTrade();
		accountForbidTrade.setAccountNo(vo.getAccountNo());
		accountForbidTrade.setForbidCode(vo.getTradeCode());
		accountForbidTrade.setType(AccountForbidTradeConstants.TYPE_TRADE_TYPE);
		if(accountForbidTradeMapper.selectWhetherForbidThisTrade(accountForbidTrade) != null){
			LOGGER.info(vo.getAccountNo()+"账户禁止该交易类型");
			throw new BusinessUncheckedException(ErrorCode001Constants.FORBID_THIS_TRADE_TYPE, vo.getAccountNo()+"账户禁止该交易类型");
		}

		accountForbidTrade.setAccountNo(vo.getAccountNo());
		accountForbidTrade.setForbidCode(vo.getTradeReqCode());
		accountForbidTrade.setType(AccountForbidTradeConstants.TYPE_TRADE_REQUEST_TYPE);
		if(accountForbidTradeMapper.selectWhetherForbidThisTrade(accountForbidTrade) != null){
			LOGGER.info(vo.getAccountNo()+"账户禁止该交易请求类型");
			throw new BusinessUncheckedException(ErrorCode001Constants.FORBID_THIS_TRADE_REQUEST_TYPE, vo.getAccountNo()+"账户禁止该交易请求类型");
		}
		/****验证是否是授信账户***/
		List<CreditAccount> list=creditAccountMapper.findAdvanceAccountByAccountNo(vo.getAccountNo());
		if(list!=null&&list.size()>0){
			LOGGER.info(vo.getAccountNo()+"账户非预存款账户");
			throw new BusinessUncheckedException(ErrorCode001Constants.CREDIT_ACCOUNT_NOT_PRE_ACCOUNT, vo.getAccountNo()+"账户非预存款账户");
		}
		return true;
	}
	/**
	 * 查询账户
	 */
	public List<CreditAccountVo> findAdvanceAccountByQueryVO(CreditAccountQueryVo creditAccountQueryVo)
	{
		return creditAccountMapper.findAdvanceAccountByQueryVO(creditAccountQueryVo);
	}
	public int countAdvanceAccountByQueryVO(CreditAccountQueryVo creditAccountQueryVo)
	{
		return creditAccountMapper.countAdvanceAccountByQueryVO(creditAccountQueryVo);
	}
	/**
	 * 内部查询账户
	 * @Title:        findAccountsInnerQuery
	 * @author        liujingbei(添加方法的人)
	 * @Date          2016-3-24 上午11:12:02
	 */
	public List<CreditAccountInnerVo> findAdvanceAccountInnerByQueryVO(CreditAccountQueryInnerVo creditAccountQueryVo)
	{
		return creditAccountMapper.findAdvanceAccountInnerByQueryVO(creditAccountQueryVo);
	}

	public int countAdvanceAccountInnerByQueryVO(CreditAccountQueryInnerVo creditAccountQueryVo){
		return creditAccountMapper.countAdvanceAccountInnerByQueryVO(creditAccountQueryVo);
	}

	@Override
	public boolean updateAccountInfo(CreditAccount creditAccount) throws Exception {
		return creditAccountMapper.updateAccountInfo(creditAccount);
	}

	@Override
	public CreditAccount masterSelectByPrimaryKey(Integer id) {
		return creditAccountMapper.selectByPrimaryKey(id);
	}

	 /**
	  * 开通预存款业务校验
	  * @throws Exception
	  * @Title:serviceVerification
	  * @author：liujingbei(添加方法的人)
	  * @Date： 2016-06-30 下午2:06:53
	  */
	 public void serviceVerification(OpenCreditAccountReqVo vo) throws Exception
	 {
	   String coreMerchantNo=vo.getCoreMerchantNo();
	   String merchantNo=vo.getMerchantNo();
	   String poolNo=vo.getPoolNo();
	   Pool pool= poolMapper.selectByPoolNo(poolNo);
	    if(pool==null){
	         throw new BusinessException(ErrorCode009Constants.NUMBERS_ASSOCIATED_ERROR,"编号关联关系有误");
	    }
	   if(!pool.getMerchantNo().equalsIgnoreCase(vo.getCoreMerchantNo())){
	            throw new BusinessException(ErrorCode009Constants.NUMBERS_ASSOCIATED_ERROR,"编号关联关系有误");
	   }
	   if(!coreMerchantNo.equalsIgnoreCase(merchantNo)){
	     MerchantOutRequest request=new MerchantOutRequest();
	           request.setCoreMerchantCode(coreMerchantNo);
	           request.setMerchantCode(merchantNo);
	           RequestHead requestHead=new RequestHead();
	           requestHead.setApplicationName("trade");
	           requestHead.setOperationDatetime(new Date());
	           request.setRequestHead(requestHead);
	           MerchantResponse response=MerchantClient.getMerchant(request);
	           if(response!=null){
	             if(response.getReturnCode().equals("F")
	                     ||StringUtils.isEmpty(response.getMerchantFullName())
	                     ||StringUtils.isEmpty(response.getMerchantName())){
	               throw new BusinessException(ErrorCode009Constants.NOT_MERCHANTNO,"核心商户:"+coreMerchantNo+"下某成员商户:"+merchantNo+"不存在");
	             }
	           }else{
	             throw new BusinessException(ErrorCode009Constants.NOT_MERCHANTNO,"查询核心商户下某成员商户信息接口失败");
	           }
	   }

	 }

	 /**
	  * @Title: openDepositAccount
	  * @Description: 开通预存款接口
	  * @param OpenDepositAccountClientVO
	  * @return
	  * @author liujingbei
	  * @throws Exception
	  * @Date 2016-06-06 下午4:33:21
	  */
	public CreditAccount insertOpenCreditAccount(OpenCreditAccountReqVo vo)
			throws BusinessException {
		try {
			LOGGER.info(
					"参数merchantNo：{},coreMerchantNo：{}开始预存款账户的创建********start",
					vo.getMerchantNo(), vo.getCoreMerchantNo());
			CreditAccount account = this.initNewCreditAccount(vo);
			creditAccountMapper.insert(account);
			LOGGER.info(
					"参数merchantNo：{},coreMerchantNo：{}创建预存款creditAccount成功,accountNo:{}",
					account.getMerchantNo(), account.getCoreMerchantNo(),
					account.getAccountNo());
			return account;
		} catch (BusinessException e) {
			LOGGER.error(e.getMessage(), e);
			throw e;
		}
	}
       /**
        * @Title: initNewCreditAccount
        * @Description: 创建余额账户时初始化一个余额账户，并且设置默认值
        * @return CreditAccount
        * @author liujingbei
        * @throws Exception
        * @Date 2016-06-06 下午5:05:37
        */
       public CreditAccount initNewCreditAccount(OpenCreditAccountReqVo vo) {
           CreditAccount account = new CreditAccount();
           account.setMerchantNo(vo.getMerchantNo());
           account.setAccountType(vo.getAccountType() == null ?
                                   CreditAccountConstants.ACCOUNT_TYPE_ENT
                                   : Integer.parseInt(vo.getAccountType()));
           account.setCoreMerchantNo(vo.getCoreMerchantNo());
           account.setPoolNo(vo.getPoolNo());
           account.setSuperType(vo.getAccountName());
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
           return account;
       }
       public int insert(CreditAccount creditAccount){
         return creditAccountMapper.insert(creditAccount);
       }
}
