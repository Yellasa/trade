/**
 * modify by kelly
 */
package com.liantuo.trade.bus.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.liantuo.deposit.advanceaccount.bus.service.AdvanceAccountService;
import com.liantuo.deposit.advanceaccount.bus.service.CreditAccountService;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;
import com.liantuo.deposit.advanceaccount.orm.pojo.CreditAccount;
import com.liantuo.trade.bus.service.TradeAccountingService;

@Service(value = "tradeAccountingService")
public class TradeAccountingServiceImpl implements TradeAccountingService{

	private final Log LOG4J = LogFactory.getLog("trade");
	
	@Resource(name = "advanceAccountServiceImpl")
    private AdvanceAccountService advanceAccountService;
	
	@Resource
    private CreditAccountService creditAccountService;

    @Override
    public List<RealTimeAccountingRsp> accountingCommon(List<RealTimeAccountingVo> list) {
        
        LOG4J.info("accountingCommon begin");
        List<RealTimeAccountingRsp> rspList = null;
        if(list !=null && list.size()>0){
            rspList = advanceAccountService.realTimeAccounting(list);
            LOG4J.info("accountingCommon end");
        }
        return rspList;
    }
    
    /* (non-Javadoc)
	 * @see com.liantuo.trade.bus.service.MerchantFreezeService#get_merchant_no(java.lang.String)
	 */
	public String get_merchant_no(String accountno){
		CreditAccount creditacc=creditAccountService.selectByAccountNo(accountno);
    	String merchant_no="";
    	if (creditacc != null) {
    		merchant_no=creditacc.getMerchantNo();
    	}
    	return merchant_no;
	}
}
