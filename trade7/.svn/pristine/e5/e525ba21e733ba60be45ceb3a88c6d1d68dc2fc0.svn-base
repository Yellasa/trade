package com.liantuo.trade.bus.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.bus.service.ProfitLossLedgerService;
import com.liantuo.trade.bus.service.v1_1.BizTradePageQueryService;
import com.liantuo.trade.common.util.date.DateUtil;
import com.liantuo.trade.orm.pojo.TradeProfitLossLedger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({
        WebContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public class ProfitLossLedgerServiceImplTest {
	@Resource(name = "profitLossLedgerServiceImpl")
    private ProfitLossLedgerService profitLossLedgerService;
	@Test
	public void createEffectiveProfitLossLedger(){
		
		TradeProfitLossLedger ledger = new TradeProfitLossLedger();
		ledger.setCoreMerchantNo("CC_C8785258588");
		ledger.setFundPoolNo("PN01000000000010876");
		
		ledger.setTradeNo("20151223102915842000000000002300");
		ledger.setEffectiveReqType("0005_001_001");
		ledger.setEffectiveReqNo("20151223182801251000000000080601");
		ledger.setTradeType("0005_001");
		ledger.setGmtTradeCreated(new Date());
		try {
			profitLossLedgerService.createEffectiveProfitLossLedger(ledger);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void createBlankProfitLossLedger(){
		TradeProfitLossLedger ledger = new TradeProfitLossLedger();
		ledger.setCoreMerchantNo("CC_C8785258588");
		ledger.setFundPoolNo("PN01000000000010876");
		ledger.setGmtTradeCreated(new Date());
		ledger.setTradeNo("20151223102915842000000000002300");
		ledger.setCreateReqType("0005_001_001");
		ledger.setCreateReqNo("20151223182801251000000000080601");
		ledger.setTradeType("0005_001");
		try {
			profitLossLedgerService.createBlankProfitLossLedger(ledger);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateBlankLegderEffective(){
		TradeProfitLossLedger ledger = new TradeProfitLossLedger();
		ledger.setId(3l);
		ledger.setEffectiveReqNo("2121");
		ledger.setLedgerNo("00050011604261742319500000150000");
		ledger.setVersion(3);
		try {
			profitLossLedgerService.updateBlankLegderEffective(ledger);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateBlankLegderFail(){
		TradeProfitLossLedger ledger = new TradeProfitLossLedger();
		ledger.setId(3l);
		ledger.setEffectiveReqNo("2121");
		ledger.setLedgerNo("00050011604261742319500000150000");
		ledger.setVersion(4);
		try {
			profitLossLedgerService.updateBlankLegderFail(ledger);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
