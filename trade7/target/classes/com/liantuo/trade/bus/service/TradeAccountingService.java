/**
 * 
 */
package com.liantuo.trade.bus.service;

import java.util.List;

import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingRsp;
import com.liantuo.deposit.advanceaccount.bus.vo.RealTimeAccountingVo;

/**
 * 
* @ClassName TradeAccountingService
* @Description 账务公共类
* @author zhangjun
* @date 2015-12-16 上午11:31:59
 */
public interface TradeAccountingService {

    /**
     * @Title accountingCommon
     * @Description 账务共通方法
     * @author zhangjun
     * @param list
     * @return List<RealTimeAccountingRsp>
     */   
    List<RealTimeAccountingRsp> accountingCommon(List<RealTimeAccountingVo> list);
    
    /**
	 * 根据CA查询merchant_no
	 * @param accountno
	 * @return
	 */
	public String get_merchant_no(String accountno);
}
