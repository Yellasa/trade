package com.liantuo.trade.bus.factory.template;

import com.liantuo.trade.bus.template.impl.ANotifyTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * 通知类 模版工厂
 */
public class NotifyTemplateFactory {
    
    private Map<String, ANotifyTemp> templateConfig = new HashMap<String, ANotifyTemp>();

    /**
     * 创建交易模板
     * @param request_code
     * @return
     * @throws Exception
     */
    public ANotifyTemp create(String request_code) throws Exception {
        return templateConfig.get(request_code);
    }
    
    public Map<String, ANotifyTemp> getTemplateConfig() {
        return templateConfig;
    }

    public void setTemplateConfig(Map<String, ANotifyTemp> templateConfig) {
        this.templateConfig = templateConfig;
    }
    
}
