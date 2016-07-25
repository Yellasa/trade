package com.liantuo.deposit.advanceaccount.bus.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebill.framework.exception.BusinessException;
import com.liantuo.deposit.advanceaccount.bus.service.AccountForbidTradeService;
import com.liantuo.deposit.advanceaccount.orm.mapper.AccountForbidTradeMapper;
import com.liantuo.deposit.advanceaccount.orm.pojo.AccountForbidTrade;
import com.liantuo.deposit.advanceaccount.web.vo.req.AccountForbidReqVo;
import com.liantuo.deposit.advanceaccount.web.vo.req.AccountForbidUpdateReqVo;
import com.liantuo.deposit.common.constants.errorcode.ErrorCode012Constants;

@Service(value="accountForbidTradeServiceImpl")
public class AccountForbidTradeServiceImpl implements AccountForbidTradeService {
    @Autowired
    private AccountForbidTradeMapper accountForbidTradeMapper;


	public AccountForbidTrade selectWhetherForbidAllByCA(String accountNo) {
		return this.accountForbidTradeMapper.selectWhetherForbidAllByCA(accountNo);
	}

	public AccountForbidTrade selectWhetherForbidThisTrade(
			AccountForbidTrade accountForbidTrade) {
		return this.accountForbidTradeMapper.selectWhetherForbidThisTrade(accountForbidTrade);
	}

	@Override
	public List<AccountForbidTrade> selectByCA(String accountNo) {
		return accountForbidTradeMapper.selectByAccouNo(accountNo);
	}

	@Override
	public void createAccountForbid(AccountForbidUpdateReqVo body,List<AccountForbidTrade> list,List<AccountForbidReqVo> forbidList) throws Exception {
		List<Integer> insertList = new ArrayList();
		StringBuffer strBuf= new StringBuffer();
		for(int i=0;i<list.size();i++){
			strBuf.append(list.get(i).getForbidCode()+",");
		}
		String dbCode=strBuf.toString();
		AccountForbidTrade record = new AccountForbidTrade();
		for (int j = 0; j <forbidList.size(); j++) {
			if(forbidList.get(j).getType().equals("0")){
				if(null == list || list.size()==0){
					record = genralVO(forbidList.get(j),record,body.getAccountNo(),body.getMerchantNo());
					accountForbidTradeMapper.insert(record);
				}else{
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).getForbidCode().equals(forbidList.get(j).getForbidCode())){
							throw new BusinessException(ErrorCode012Constants.DATA_REPEAT, list.get(i).getForbidCode()+"数据不可重复");
						}
						insertList.add(j);
					}
				}
				
			}else{
				if(null == list || list.size()==0){
					throw new BusinessException(ErrorCode012Constants.ACCOUNT_FORBID_DATA_NO_EXIST, forbidList.get(j).getForbidCode()+"数据不存在");
				}
				//  如果入参不存在数据库里 
				if(dbCode.indexOf(forbidList.get(j).getForbidCode())<0 ){
					throw new BusinessException(ErrorCode012Constants.ACCOUNT_FORBID_DATA_NO_EXIST, forbidList.get(j).getForbidCode()+"数据不存在");
				}
				record.setAccountNo(body.getAccountNo());
				record.setForbidCode(forbidList.get(j).getForbidCode());
				List<AccountForbidTrade>  dellist = accountForbidTradeMapper.selectByCAAndForbidCode(record);
				for(int i=0;i<dellist.size();i++){
					accountForbidTradeMapper.deleteByPrimaryKey(dellist.get(i).getId());
				}
			}
		}
		insertList = removeDuplicate(insertList);
		
		for(int i=0;i<insertList.size();i++){
			record.setAccountNo(body.getAccountNo());
			record.setCreatorCn(body.getMerchantNo());
			record.setCreatorNo(body.getMerchantNo());
			record.setForbidCode(forbidList.get(insertList.get(i)).getForbidCode());
			record.setGmtCreated(new Date());
			record.setType(forbidList.get(insertList.get(i)).getForbidType());
			accountForbidTradeMapper.insert(record);
		}
		 
	}
 
    //list去重
	private List<Integer> removeDuplicate(List<Integer> insertList) {
		HashSet h  =   new  HashSet(insertList); 
		insertList.clear(); 
		insertList.addAll(h); 
		return insertList;
	}

	//生成vo
	private AccountForbidTrade genralVO(AccountForbidReqVo accountForbidReqVo,
			AccountForbidTrade record,String accountNo,String merchaNo) {
		record.setAccountNo(accountNo);
		record.setCreatorCn(merchaNo);
		record.setCreatorNo(merchaNo);
		record.setForbidCode(accountForbidReqVo.getForbidCode());
		record.setGmtCreated(new Date());
		record.setType(accountForbidReqVo.getForbidType());
		return record;
	}

	@Override
	public List<AccountForbidTrade> masterSelectByCA(String accountNo) {
		return accountForbidTradeMapper.selectByAccouNo(accountNo);
	}
}