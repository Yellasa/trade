/**
 * 
 */
package com.liantuo.trade.bus.service;

import com.liantuo.trade.orm.pojo.TradeLedger;

/**
 * @ClassName:     LegderService.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-3-2 下午3:54:56 
 */
public interface LegderService {

	/**
	 * 创建生效台账
	 * @param ledger
	 * @return
	 */
	public String createEffectiveLegder(TradeLedger ledger);
	
	/**
	 * 创建空白台账
	 * @param ledger
	 * @return
	 */
	public String createBlankLegder(TradeLedger ledger);
	
	/**
	 * 空白台账生效
	 * @param ledger
	 * @return
	 */
	public void updateBlankLegderEffective(TradeLedger ledger);
	
	/**
	 * 空白台账失败
	 * @param ledger
	 */
	public void updateBlankLegderFail(TradeLedger ledger);
}
