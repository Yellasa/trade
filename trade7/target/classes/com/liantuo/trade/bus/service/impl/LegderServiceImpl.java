/**
 * 
 */
package com.liantuo.trade.bus.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.service.LegderService;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.trade.TradeUtilCommon;
import com.liantuo.trade.orm.pojo.TradeLedger;
import com.liantuo.trade.orm.pojo.TradeLedgerLog;
import com.liantuo.trade.orm.service.TradeLedgerLogService;
import com.liantuo.trade.orm.service.TradeLedgerService;
import com.liantuo.trade.seqno.IdFactory;

/**
 * @ClassName:     LegderServiceImpl.java
 * @Description:   TODO  
 * <p>Company:联拓金融信息服务有限公司</p>
 * @author         kelly
 * @version        V1.0  
 * @Date           2016-3-2 下午3:55:20 
 */
@Component(value = "legderServiceImpl")
public class LegderServiceImpl implements LegderService {

	@Resource
    private TradeLedgerService tradeLedgerService;
	
	@Resource
    private TradeLedgerLogService tradeLedgerLogService;
    
    @Resource(name = "idFactoryTradeLegderLegderNo")
    private IdFactory idFactoryTradeLegderLegderNo;
    
	/* 创建生效台账
	 * @see com.liantuo.trade.bus.service.LegderService#createEffectiveLegder(com.liantuo.trade.orm.pojo.TradeLedger)
	 */
    @Override
	public String createEffectiveLegder(TradeLedger ledger){
    	String ledgerNo = TradeUtilCommon.getServiceCode(ledger.getTradeType())+idFactoryTradeLegderLegderNo.generate().toString();
		ledger.setLedgerNo(ledgerNo);//业务台账编号
		ledger.setCreateReqType(ledger.getEffectiveReqType());//创建交易请求类型
		ledger.setCreateReqNo(ledger.getEffectiveReqNo());//创建交易请求编号
		ledger.setStatus(TradeConstants.LEDGER_STATUS_EFFECTIVITY); // 台账状态（00：新建 01生效）
		this.tradeLedgerService.insertTradeLedger(ledger);
		createLegderHistory(ledger);
		return ledgerNo;
	}

	/* 创建空白台账
	 * @see com.liantuo.trade.bus.service.LegderService#createBlankLegder(com.liantuo.trade.orm.pojo.TradeLedger)
	 */
	@Override
	public String createBlankLegder(TradeLedger ledger) {
		// TODO Auto-generated method stub
		String ledgerNo = TradeUtilCommon.getServiceCode(ledger.getTradeType())+idFactoryTradeLegderLegderNo.generate().toString();
		ledger.setLedgerNo(ledgerNo);//业务台账编号
		ledger.setStatus(TradeConstants.LEDGER_STATUS_INIT); // 台账状态（00：新建 01生效）
		this.tradeLedgerService.insertTradeLedgerBlank(ledger);
		createLegderHistory(ledger);
		return ledgerNo;
	}
	
	/* 空白台账生效
	 * @see com.liantuo.trade.bus.service.LegderService#updateBlankLegderEffective(com.liantuo.trade.orm.pojo.TradeLedger)
	 */
	public void updateBlankLegderEffective(TradeLedger ledger){
		 // 业务台账生效日期时间 -- 系统当前日期时间
        ledger.setGmtEffective(new Date());
        // 台账状态 - 生效
        ledger.setStatus(TradeConstants.LEDGER_STATUS_EFFECTIVITY);
        
        tradeLedgerService.updateTradeLedger(ledger);
        createLegderHistory(ledger);
	}

	/* 空白台账失败
	 * @see com.liantuo.trade.bus.service.LegderService#updateBlankLegderFail(com.liantuo.trade.orm.pojo.TradeLedger)
	 */
	@Override
	public void updateBlankLegderFail(TradeLedger ledger) {
		// TODO Auto-generated method stub
		 // 业务台账失败日期时间  -- 系统当前日期时间
        ledger.setGmtFailed(new Date());
        // 台账状态 - 失败
        ledger.setStatus(TradeConstants.LEDGER_STATUS_FAILED);
        
        tradeLedgerService.updateTradeLedger(ledger);
        createLegderHistory(ledger);
	}
	
	private void createLegderHistory(TradeLedger ledger){
	    TradeLedgerLog log = new TradeLedgerLog();
	    TradeLedger ledger1=tradeLedgerService.queryTradeLedgerBy(ledger.getLedgerNo()).get(0);
        BeanUtils.copyProperties(ledger1, log);
        log.setId(null);
        tradeLedgerLogService.insertTradeLedgerLog(log);
	}
	
}
