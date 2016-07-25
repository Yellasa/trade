package com.liantuo.trade.orm.service.impl;

import com.liantuo.spring.WebContextTestExecutionListener;
import com.liantuo.trade.orm.pojo.TradeRefundExample;
import com.liantuo.trade.orm.service.TradeRefundService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
@TestExecutionListeners({
        WebContextTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public class TradeRefundServiceImplTest {

    @Resource(name = "tradeRefundService")
    private TradeRefundService refundService;

    @Test
    public void testSelectCountByExample() throws Exception {
        Assert.assertNotNull(refundService);
        TradeRefundExample example = new TradeRefundExample();
        TradeRefundExample.Criteria condition = example.createCriteria();
        condition.andCoreMerchantNoEqualTo("SXSL");
        condition.andFundPoolNoEqualTo("PN01000000000000824");
        condition.andRefundAccountNoEqualTo("CA12050317300000");
//        example.setStart(0);
        example.setLimit(50);

        int count = refundService.selectCountByExample(example);
        System.err.println(count);
    }
}