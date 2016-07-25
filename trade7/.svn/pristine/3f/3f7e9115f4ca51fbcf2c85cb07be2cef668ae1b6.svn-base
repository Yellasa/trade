package com.liantuo.trade.orm.service;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.amount.AmountUtils;
import com.liantuo.trade.exception.BizRuntimeException;
import com.liantuo.trade.orm.pojo.TradeRefund;


/**
 * 乐观锁测试
 * @作者 Jimmy
 * @日期 2015年12月22日 上午9:34:31
 * @最后修改人
 * @修改时间
 * @复审人 
 */
@ContextConfiguration(locations = { 
        "classpath:config/spring/applicationContext-myBatis.xml",
        "classpath:config/spring/applicationContext-common.xml", 
        "classpath:config/spring/applicationContext-template.xml" })
public class TradeRefundServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private TradeRefundService tradeRefundService;
    
    @Test
    public void testLock(){
        TradeRefund tr = createTradeRefund();
        
        tradeRefundService.insertTradeRefund(tr);
        Assert.assertNotNull(tr.getId());
        
        TradeRefund newTr = tradeRefundService.queryTradeRefund(tr.getId());
        
        tradeRefundService.updateTradeRefund(newTr);
        Assert.assertTrue(true);
        
        try {
            tradeRefundService.updateTradeRefund(newTr);
        } catch (BizRuntimeException e) {
            Assert.assertTrue("捕获异常", true);
        }
        
    }
    
    private TradeRefund createTradeRefund(){
        TradeRefund tr = new TradeRefund();
        tr.setTradeNo("JY0001"); // 创建交易编号
        tr.setCoreMerchantNo("merchant"); // 核心商户编号
        tr.setFundPoolNo("pool"); // 所属主体资金池编号

        tr.setOutTradeNo("test001"); // 交易发起方业务系统订单号
        tr.setOutTradeNoExt("test001"); // 交易发起方发起请求ID

        tr.setLatestTradeReqType(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_OFFLINE_SETTLE); // 最后变更交易请求类型----本次请求类型
        tr.setLatestReqNo(TradeConstants.TRADE_TYPE_REFUND_NO_PWD_OFFLINE_SETTLE); // 最后变更交易请求编号---本次请求编号

        tr.setCloseStatus(TradeConstants.TRADE_CLOSE_STATUS_INIT); // 交易结束状态----未结束

        tr.setOriginalTradeNo("OT0001"); // 原交易编号
        tr.setRefundAccountNo("test"); // 付出CA账户编号----来自原交易【付出CA账户编号】
        tr.setRefundMerchantNo("test"); // 付出成员商户编号----来自原交易【付出CA账户编号】

        tr.setStatus(TradeConstants.TRADE_STATUS_INIT); // 交易状态交易状态（00创建 01冻结成功 02线下付款成功 03CA退款成功 04退款成功 05解冻成功 05异常中止）
        tr.setClearChannel("002"); // 付款渠道编号------来自原交易【付款渠道编号】
        tr.setVersion(0);
        
        tr.setGmtSuccessClearChannel(new Date()); // 付款渠道退回日期时间 ---- 来自输入
        tr.setClearOrderNo("test"); // 付款渠道订单号 -- 来自输入
        tr.setClearRefundAmount(AmountUtils.bizAmountConvertToLong("100.0"));
        return tr;
    }
    
    
}
