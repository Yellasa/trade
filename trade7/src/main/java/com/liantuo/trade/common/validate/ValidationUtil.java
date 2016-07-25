package com.liantuo.trade.common.validate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;

import com.liantuo.trade.validator.AssociateWeak;
import com.liantuo.trade.validator.ConflictWeak;

public class ValidationUtil {
	
	private static final ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
	
	public static String validateRequiredWeaks(Object object){
		 String msg;
	        try {
	            msg = validateRequiredWeak(object);

	            if (StringUtils.isEmpty(msg)) {

	                Validator validator = vf.getValidator();
	                Set<ConstraintViolation<Object>> set = validator.validate(object, Required.class,Format.class);
	                for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext(); ) {
	                    ConstraintViolation<?> constraintViolation = iterator.next();
	                    return constraintViolation.getMessage();
	                }
	            }else {
	                return msg;
	            }
	        } catch (NoSuchMethodException e) {
	            e.printStackTrace();
	            return e.getMessage();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	            return e.getMessage();
	        } catch (InvocationTargetException e) {
	            e.printStackTrace();
	            return e.getMessage();
	        }

	        return null;
	}
	
	private static String validateRequiredWeak(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method;
        ConflictWeak requiredWeak;
        AssociateWeak associateWeak;
        Valid valid;
        String[] exclusion_prop_names;
        String prop_req_values;
        Set<ConstraintViolation<Object>> set;
        long time_start = System.currentTimeMillis();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
        	method = object.getClass().getDeclaredMethod("get" + field.getName().replaceFirst(field.getName().substring(0, 1), field.getName().substring(0, 1).toUpperCase()));
        	Object prop_req_value = null;
        	if (method != null)  prop_req_value =  method.invoke(object);
        	associateWeak = field.getAnnotation(AssociateWeak.class);
        	if(associateWeak != null){//关联必填
        		String prop_name = associateWeak.associate_prop_name();
        		 method = object.getClass().getDeclaredMethod("get" + prop_name.replaceFirst(prop_name.substring(0, 1), prop_name.substring(0, 1).toUpperCase()));
        		 String value =null;
        	     if (method != null) value = (String) method.invoke(object);
        		if(StringUtils.isNotEmpty(value) && value.matches(associateWeak.associate_prop_value())){
        			if(prop_req_value == null){
        				return associateWeak.message();
        			}
        		}
        	}
        	
            requiredWeak = field.getAnnotation(ConflictWeak.class);
            valid = field.getAnnotation(Valid.class);
            if (requiredWeak != null || valid !=null) {
            	
            	 if(field.getType().equals(String.class)){
                	 prop_req_values = requiredWeak.exclusion_prop_value();
                	 if(prop_req_value !=null && StringUtils.isNotEmpty(prop_req_values) &&  ((String)prop_req_value).matches(prop_req_values)){//带前提条件的冲突
                		 exclusion_prop_names = requiredWeak.mutual_exclusion_prop_name().split(",");
                		 String msg = checkConflictWeak(requiredWeak, exclusion_prop_names,object, time_start);
                		 if(StringUtils.isNotEmpty(msg)){
               			  return msg;
               		     }
                	 }
                	 prop_req_values = requiredWeak.exclusion_prop_name();
                	 if(StringUtils.isNotEmpty(prop_req_values) ){//冲突字段
                		 exclusion_prop_names = requiredWeak.exclusion_prop_name().split(",");
                		 String msg = checkConflictWeak(requiredWeak, exclusion_prop_names,object, time_start);
                		 if(StringUtils.isNotEmpty(msg)){
               			  return msg;
               		     }
                	 }
            	 }else if(field.getType().equals(List.class)){
                	 method = object.getClass().getDeclaredMethod("get" + field.getName().replaceFirst(field.getName().substring(0, 1), field.getName().substring(0, 1).toUpperCase()));
            		 List list = (List) method.invoke(object);
            		 if(list != null){
            			 for(Object obj : list){
            				 String msg =  validateRequiredWeak(obj);
            				 if(StringUtils.isNotEmpty(msg)){
            					 return msg;
            				 }
            			 }	 
            		 }
            	 }
            	}
            }
        System.out.println("validateRequiredWeak耗时：" + (System.currentTimeMillis() - time_start));
        return null;
    }

	/**
	 * 校验冲突
	 */
	private static String checkConflictWeak(ConflictWeak requiredWeak,String[] prop_names,
			Object body, long time_start) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		Method method;
		if(prop_names != null && prop_names.length >0){//校验冲突
		  boolean flag = false;
			    for(String prop_name : prop_names){
			    	 method = body.getClass().getDeclaredMethod("get" + prop_name.replaceFirst(prop_name.substring(0, 1), prop_name.substring(0, 1).toUpperCase()));
		           if (method != null) {
		              String value = (String) method.invoke(body);
		              if(!flag && !StringUtils.isEmpty(value)){
		              	flag = true;
		              	continue;
		              }else if(flag && !StringUtils.isEmpty(value)){
		              	System.out.println("validateRequiredWeak耗时：" + (System.currentTimeMillis() - time_start));
		              	return requiredWeak.message();
		              }
		           }
			    }
			    if(!flag){
			    	System.out.println("validateRequiredWeak耗时：" + (System.currentTimeMillis() - time_start));
		          	return requiredWeak.message();
			    }
		}
		return null;
	}

	
    public static String validateRequired(Object object) {

        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(object, Required.class);
        for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext(); ) {
            ConstraintViolation<?> constraintViolation = iterator.next();
            return constraintViolation.getMessage();
        }
        return null;
    }

    /**
     * 业务参数非空校验
     * @param object
     * @return
     */
    public static String validateBodyRequired(Object object) {
        Object body = null;

        Validator validator = vf.getValidator();
        try {
            body = object.getClass().getDeclaredMethod("getBody", null).invoke(object, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Set<ConstraintViolation<Object>> set = validator.validate(body, Required.class);
        for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext(); ) {
            ConstraintViolation<?> constraintViolation = iterator.next();
            return constraintViolation.getMessage();
        }
        return null;
    }

    /**
     * 业务参数格式校验
     * @param object
     * @return
     */
    public static String validateBodyFormat(Object object) {
        Object body = null;

        Validator validator = vf.getValidator();
        try {
            body = object.getClass().getDeclaredMethod("getBody", null).invoke(object, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Set<ConstraintViolation<Object>> set = validator.validate(body, Format.class);
        for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext(); ) {
            ConstraintViolation<?> constraintViolation = iterator.next();
            return constraintViolation.getMessage();
        }
        return null;
    }

    /**
     * 校验特殊可空对象参数格式
     *
     * @param object
     * @param arg1
     * @return
     */
    public static String validateObjectSpecial(Class clazz, List<String> validates, Object object, Class<?>... arg1) throws Exception {
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(object, arg1);
        for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext(); ) {
            ConstraintViolation<?> constraintViolation = iterator.next();
            return constraintViolation.getMessage();
        }
        Method[] methods = null;
        for (String property : validates) {
            if (methods == null) {
                methods = clazz.getMethods();
            }
            for (Method method : methods) {
                String name = method.getName();
                if (name.toLowerCase().indexOf("get" + property.toLowerCase()) > -1) {
                    String value = (String) method.invoke(clazz.newInstance());
                    if (StringUtils.isEmpty(value)) {
                        return property + " is required!";
                    }
                }
            }
        }
        return null;
    }

    public static String validateObjectAllMsg(Object object, Class<?>... arg1) {
        StringBuffer returnVal = new StringBuffer();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(object, arg1);
        for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext(); ) {
            ConstraintViolation<?> constraintViolation = iterator.next();
            returnVal.append(constraintViolation.getMessage()).append(",");
        }
        return StringUtils.isEmpty(returnVal.toString()) ? null : returnVal.deleteCharAt(returnVal.length() - 1).toString();
    }
    
    public static String validateFormat(Object object) {
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(object, Format.class);
        for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext(); ) {
            ConstraintViolation<?> constraintViolation = iterator.next();
            return constraintViolation.getMessage();
        }
        return null;
    }

    /**
     * 校验非空对象参数格式
     *
     * @param object
     * @param arg1
     * @return
     */
    public static String validateObject(Object object, Class<?>... arg1) {
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(object, arg1);
        for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext(); ) {
            ConstraintViolation<?> constraintViolation = iterator.next();
            return constraintViolation.getMessage();
        }
        return null;
    }
    /**
     * 按参数列表验证
     * @param object 需要被验证的对象
     * @param propertyNames 参数列表，使用","分开,支持通配符"*"
     * @param groups 
     * @return 第一个验证错误的字段
     */
    public static String validateObject(Object object,String propertyNames,Class<?>... groups){
        if(propertyNames == null || propertyNames.equals("*")){
        	return ValidationUtil.validateObject(object,groups);
        }
    	ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        String[] propertyNameArray = propertyNames.split(",");
        for(String propertyName:propertyNameArray){
        	propertyName = propertyName.trim();
        	Set<ConstraintViolation<Object>> set = validator.validateProperty(object, propertyName, groups);
        	for (Iterator<ConstraintViolation<Object>> iterator = set.iterator(); iterator.hasNext(); ) {
                ConstraintViolation<?> constraintViolation = iterator.next();
                return constraintViolation.getMessage();
            }
        }
        return null;
    }
    
    public static String validateObjectRequiredWeak(Object object,String propertyNames,Class<?>... groups){
    	        String msg;
    	        try {
    	            msg = validateRequiredWeak(object);
    	            if (StringUtils.isEmpty(msg)){
    	            	validateObject(object,propertyNames,groups);
    	            }else {
    	                return msg;
    	            }
    	        } catch (NoSuchMethodException e) {
    	            e.printStackTrace();
    	            return e.getMessage();
    	        } catch (IllegalAccessException e) {
    	            e.printStackTrace();
    	            return e.getMessage();
    	        } catch (InvocationTargetException e) {
    	            e.printStackTrace();
    	            return e.getMessage();
    	        }
    	        return null;
    }

}
