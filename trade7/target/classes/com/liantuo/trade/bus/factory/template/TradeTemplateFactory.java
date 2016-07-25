package com.liantuo.trade.bus.factory.template;

import com.liantuo.trade.bus.template.impl.ATradeTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * 交易模板工厂
 */
public class TradeTemplateFactory {

    private Map<String, ATradeTemp> templateConfig = new HashMap<String, ATradeTemp>();

    public ATradeTemp create(String request_code) throws Exception {
        return templateConfig.get(request_code);
    }

    public Map<String, ATradeTemp> getTemplateConfig() {
        return templateConfig;
    }

    public void setTemplateConfig(Map<String, ATradeTemp> templateConfig) {
        this.templateConfig = templateConfig;
    }

}
