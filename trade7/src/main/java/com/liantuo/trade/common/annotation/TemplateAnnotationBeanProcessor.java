package com.liantuo.trade.common.annotation;


import java.util.HashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import com.liantuo.trade.bus.factory.template.TradeTemplateFactory;
import com.liantuo.trade.bus.template.impl.ATradeTemp;
//@Component
public class TemplateAnnotationBeanProcessor extends
		InstantiationAwareBeanPostProcessorAdapter {
	@Autowired
	private TradeTemplateFactory templateFactory;
	@Override
	public boolean postProcessAfterInstantiation(final Object bean, String beanName)
			throws BeansException {
//		Class<? extends Object> clazz = bean.getClass();
//		if(clazz.isAnnotationPresent(Template.class)){
//			Template annotation = bean.getClass().getAnnotation(Template.class);
//			
//			if(templateFactory != null){
//				if(templateFactory.getTemplateConfig() == null){
//					templateFactory.setTemplateConfig(new HashMap<String, ATradeTemp>());
//				}
//				if(bean instanceof ATradeTemp){
//					templateFactory.getTemplateConfig().put(annotation.value(), (ATradeTemp) bean);
//				}else{
//					throw new BeanNotOfRequiredTypeException(bean.getClass().getName(),ATradeTemp.class,bean.getClass());
//				}
//			}
//		}
		return true;
		
	}
	
}
