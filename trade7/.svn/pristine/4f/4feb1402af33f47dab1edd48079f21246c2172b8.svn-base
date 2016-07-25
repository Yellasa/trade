package com.liantuo.trade.client.trade.packet.body.trade_payment.utiltest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import com.liantuo.trade.common.validate.ValidationUtil;
import org.apache.commons.lang3.StringUtils;
/**
 * @Author:ksh
 * @Description:vo 属性覆盖测试
 * @Date：2016-06-06 10:15:42
 */
public abstract class ParentTest {
	/**
	 * 该方法需传入要测试的对象VO
	 * @return
     */
	protected abstract Class<?> getObjectClzz();

	/**
	 * 用于查看对象信息
	 * @return
     */
	public  Map<String,String> getObjectInfo(){
		StringBuffer sb = new StringBuffer();
		Map<String,String> map = new HashMap<String, String>();
		int i=0;
		Field[] declaredFields = getObjectClzz().getDeclaredFields();
		sb.append("对象").append(getObjectClzz().getName()).append("共有：").append(declaredFields.length).append("个成员属性,");
		for (Field field : declaredFields) {
			if(field.getAnnotations().length!=0){i++;}
			for (Annotation annotation : field.getAnnotations()) {
				System.out.println(field.getName()+"      "+annotation.annotationType().getTypeParameters().toString()+"       "+annotation.annotationType().getSimpleName()
						+"     " + annotation.annotationType().getCanonicalName());
				if(!map.containsKey(field.getName())){
					map.put(field.getName(), "T");
				}
			}
		}

		sb.append("其中").append(i).append("个需要做规则校验");
		map.put("info", sb.toString());
		return map;
	}

	/**
	 * 通过反射调用相应的方法给属性赋值
	 * @param paraName
	 * @param val
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
     */
	public Object invokeSetter(String paraName,Object val) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException{
		Field field = getObjectClzz().getDeclaredField(paraName); // 获取实体类的所有属性，返回Field数组
		Object newInstance = getObjectClzz().newInstance();
		StringBuffer strBuff = new StringBuffer();
	    try {
//	            String type = field.getGenericType().toString(); // 获取属性的类型
	            Type type = field.getGenericType();
	            Class[] paraTypes = new Class[1];
	            paraTypes[0] = field.getType();
	            paraName = paraName.substring(0, 1).toUpperCase() + paraName.substring(1); // 将属性的首字符大写，方便构造get，set方法
	            strBuff.append("set").append(paraName);
	            Method m = newInstance.getClass().getMethod(strBuff.toString(),paraTypes);
	            if (type.toString().equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
	                m.invoke(newInstance, (String)val);
	            }
	            if (type.toString().equals("class java.lang.Integer")) {
	            	m.invoke(newInstance, (Integer)val);
	            }
	            if (type.toString().equals("class java.lang.Boolean")) {
	            	m.invoke(newInstance, (Boolean)val);
	            }
	            if (type.toString().equals("class java.util.Date")) {
	            	m.invoke(newInstance, (Date)val);
	            }
	// 如果有需要,可以仿照上面继续进行扩充,再增加对其它类型的判断
	    } catch (NoSuchMethodException e) {
	        e.printStackTrace();
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    } catch (InvocationTargetException e) {
	        e.printStackTrace();
	    }
	    return newInstance;
	}

	/**
	 * 校验参数规则
	 * @param paraName
	 * @param val
	 * @param memo
	 * @param groups
	 * @return
     * @throws Exception
     */
	public String checkParaMeters(String paraName,String val,String memo,Class  groups) throws Exception{
		Map<String, String> objectInfo = getObjectInfo();
		String  returnInfo = null;
		if(!objectInfo.containsKey(paraName)){
			throw new Exception(getObjectClzz().toString()+"没有"+paraName+"参数");
		}
		Object invokeSetter = invokeSetter(paraName, val);
		String err_msg = ValidationUtil.validateObject(invokeSetter, paraName, groups);
		if(StringUtils.isNotEmpty(err_msg)){
			returnInfo="FAIL"+"\t"+paraName+":"+val+"\t"+err_msg+"\t"+memo;
			throw new Exception(returnInfo);
		}
		returnInfo="OK"+"\t"+paraName+":"+val+"\t"+"校验通过"+"\t"+memo;
		return returnInfo;
	}
	
}
