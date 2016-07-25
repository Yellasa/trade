package org.springframework.context.annotation;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

public class JobFlowAnnotationBeanNameGenerator extends AnnotationBeanNameGenerator  {
	private static final String JOBFLOW_ANNOTATION_CLASSNAME = "com.liantuo.trade.spring.annotation.JobFlow";
	@SuppressWarnings("unchecked")
	protected String determineBeanNameFromAnnotation(AnnotatedBeanDefinition annotatedDef){
		AnnotationMetadata amd = annotatedDef.getMetadata();
		Set<String> types = amd.getAnnotationTypes();
		String beanName = null;
		for (String type : types) {
			AnnotationAttributes attributes = MetadataUtils.attributesFor(amd, type);
			if(isJobFlowWithNameValue(type, amd.getMetaAnnotationTypes(type), attributes)){
				Object value = attributes.get("value");
				Object version = attributes.get("version");
				beanName = value + ":" + version;
//				System.out.println(beanName);
				Class template = (Class)attributes.get("template");
				Type genType = template.getGenericSuperclass();
				Type[] params = ((ParameterizedType) genType)
						.getActualTypeArguments();
				try {
					if(!((Class) params[0]).isAssignableFrom(Class.forName(annotatedDef.getBeanClassName()))){
						throw new RuntimeException(beanName + "模板与接口配置不匹配，请检查!");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return beanName;
			}
			if (isStereotypeWithNameValue(type, amd.getMetaAnnotationTypes(type), attributes)) {
				Object value = attributes.get("value");
				if (value instanceof String) {
					String strVal = (String) value;
					if (StringUtils.hasLength(strVal)) {
						if (beanName != null && !strVal.equals(beanName)) {
							throw new IllegalStateException("Stereotype annotations suggest inconsistent " +
									"component names: '" + beanName + "' versus '" + strVal + "'");
						}
						beanName = strVal;
					}
				}
			}

		}
		return beanName;
	}
	protected boolean isJobFlowWithNameValue(String annotationType,
			Set<String> metaAnnotationTypes, Map<String, Object> attributes){
		boolean isStereotype = annotationType.equals(JOBFLOW_ANNOTATION_CLASSNAME);

		return isStereotype;
	}
}
