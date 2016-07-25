package com.liantuo.trade.bus.factory;

import com.liantuo.trade.client.trade.packet.TradeRequest;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.spring.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.stereotype.Component;

/**
 * JobFlow工厂，用于JobFlow注册和发现
 *
 * @author dengchao
 */
@Component
public class JobFlowFactory {

    private final Log logger = LogFactory.getLog(JobFlowFactory.class);


    /**
     * 通过RequestCode和Version发现@JobFlow
     * @JobFlow支持同一个业务编号多个实现版本
     * 如果没传Version默认使用1.0
     *
     * @param requestCode
     * @param version
     * @return
     * @throws NoSuchBeanDefinitionException
     * @see com.liantuo.trade.spring.annotation.JobFlow
     */
    public Object discover(String requestCode, String version) throws NoSuchBeanDefinitionException {
        if (StringUtils.isBlank(version)) {
            version = "1.0";
        }

        return SpringUtils.getBean(requestCode + ":" + version);

    }

    public Object discover(TradeRequest<?> request) throws NoSuchBeanDefinitionException {
        return discover(request.getHead());
    }

    public Object discover(TradePacketHead head) throws NoSuchBeanDefinitionException {
        return discover(head.getRequest_code(), head.getVersion());
    }

    public Object discover(String requestCode) throws NoSuchBeanDefinitionException {
        return discover(requestCode, "1.0");
    }


}
