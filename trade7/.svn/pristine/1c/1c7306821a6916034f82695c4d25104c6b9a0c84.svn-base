package com.liantuo.trade.orm.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.liantuo.trade.orm.pojo.TradeReqLogWithBLOBs;

/**
 * 
 * @作者 Jimmy
 * @日期 2015年12月15日 上午9:57:06
 * @最后修改人
 * @修改时间
 * @复审人
 */
@ContextConfiguration(locations = { "classpath:config/spring/applicationContext-myBatis.xml","classpath:config/spring/applicationContext-common.xml" })
public class TradeRequestLogServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Resource(name = "tradeReqLogServiceImpl")
    private TradeReqLogService tradeReqLogService;
    
    @Test
    public void testInsertTradeRequestLog(){
        Assert.assertNotNull(tradeReqLogService);
        
        TradeReqLogWithBLOBs log = getTradeReqLog();
        tradeReqLogService.insertTradeRequestLog(log);
        
        Assert.assertNotNull(log.getId());
        
        log = tradeReqLogService.getTradeReqLog(log.getId());
        Assert.assertEquals(0L, log.getReqCostTime().longValue());
    }
    
    
    private TradeReqLogWithBLOBs getTradeReqLog() {
        TradeReqLogWithBLOBs log = new TradeReqLogWithBLOBs();
        log.setReqDateTime(new Date());
        log.setGmtCreated(new Date());
        
        log.setReqNo("TODO"); //TODO 生成号
        log.setReqIp("127.0.0.1");
        log.setPartnerId("parentId");
        log.setCoreMerchantNo("core_m_no");
        log.setFundPoolNo("fundPoolNo");
        log.setServiceName("service_name");
        log.setServiceCode("serviceCode");

        log.setReqDateTime(new Date());
        log.setResDateTime(log.getReqDateTime());
        log.setReqCostTime(0L);
        
        log.setResText("<?xml version=\"1.0\" >");
        log.setReqText("<?xml version=\"1.0\" >");
        log.setReqStatus("S");
        log.setGmtCreated(new Date());
        
        return log;
    }
    
    @Test
    public void testUpdateTradeRequestLog(){
        TradeReqLogWithBLOBs log = getTradeReqLog();
        tradeReqLogService.insertTradeRequestLog(log);
        
        Assert.assertNotNull(log.getId());
        
        TradeReqLogWithBLOBs newLog = getUpdateTradeReqLog(log.getId());
        tradeReqLogService.updateTradeRequestLog(newLog);
        
        log = tradeReqLogService.getTradeReqLog(log.getId());
        Assert.assertEquals(800L, log.getReqCostTime().longValue());
    }

    public TradeReqLogWithBLOBs getUpdateTradeReqLog(Long id){
        TradeReqLogWithBLOBs log = new TradeReqLogWithBLOBs();
        log.setId(id);
        log.setResText("<?xml version=\"1.0\" ><trade></trade>");
        log.setReqStatus("F");

        log.setResDateTime(new Date());
        log.setReqCostTime(800L);
        return log;
    }
}
