package com.liantuo.trade.common.message;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@ContextConfiguration(
		locations = {
                "classpath:config/spring/controller-context.xml",
                "classpath:config/spring/applicationContext-*.xml"
        }
)
public class MessageBundleServiceTest extends AbstractTestNGSpringContextTests {
//    @Resource(name = "messageBundleServiceImpl")
//    private MessageBundleService messageBundleService;
//
//    @Test
//    public void testMessageBundleService() {
//        Assert.assertNotNull(this.messageBundleService);
//        System.out.println(messageBundleService.getCode("trade.failure.process.not.found"));
//        System.out.println(messageBundleService.getMessage("trade.failure.process.not.found", new Object[]{"1", "0001_001_001"}));
//
//    }
//
//    public void afterClass() {
//
//    }
}