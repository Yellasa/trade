package com.liantuo.deposit.advanceaccount.web.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * <p>Title: </p>
 * <p>Description: </p>


 not attributable
 * @version 1.0
 */

public class MyBeanUtils
extends org.apache.commons.beanutils.BeanUtils {

    private static void convert(Object dest, Object orig) throws
    IllegalAccessException, InvocationTargetException {

        // Validate existence of the specified beans
        if (dest == null) {
            throw new IllegalArgumentException
            ("No destination bean specified");
        }
        if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        }

        // Copy the properties, converting as necessary
        if (orig instanceof DynaBean) {
            DynaProperty origDescriptors[] =
                    ( (DynaBean) orig).getDynaClass().getDynaProperties();
            for (int i = 0; i < origDescriptors.length; i++) {
                String name = origDescriptors[i].getName();
                if (PropertyUtils.isWriteable(dest, name)) {
                    Object value = ( (DynaBean) orig).get(name);
                    try {
                        copyProperty(dest, name, value);
                    }
                    catch (Exception e) {
                        ; // Should not happen
                    }

                }
            }
        }
        else if (orig instanceof Map) {
            Iterator names = ( (Map) orig).keySet().iterator();
            while (names.hasNext()) {
                String name = (String) names.next();
                if (PropertyUtils.isWriteable(dest, name)) {
                    Object value = ( (Map) orig).get(name);
                    try {
                        copyProperty(dest, name, value);
                    }
                    catch (Exception e) {
                        ; // Should not happen
                    }

                }
            }
        }
        else
            /* if (orig is a standard JavaBean) */
        {
            PropertyDescriptor origDescriptors[] =
                    PropertyUtils.getPropertyDescriptors(orig);
            for (int i = 0; i < origDescriptors.length; i++) {
                String name = origDescriptors[i].getName();
                //              String type = origDescriptors[i].getPropertyType().toString();
                if ("class".equals(name)) {
                    continue; // No point in trying to set an object's class
                }
                if (PropertyUtils.isReadable(orig, name) &&
                        PropertyUtils.isWriteable(dest, name)) {
                    try {
                        Object value = PropertyUtils.getSimpleProperty(orig, name);
                        copyProperty(dest, name, value);
                    }
                    catch (java.lang.IllegalArgumentException ie) {
                        ; // Should not happen
                    }
                    catch (Exception e) {
                        ; // Should not happen
                    }

                }
            }
        }

    }


    /**
     * 对象拷贝
     * 数据对象空值不拷贝到目标对象
     *
     * @param dataObject
     * @param toObject
     * @throws NoSuchMethodException
     * copy
     */
    public static void copyBeanNotNull2Bean(Object databean,Object tobean)throws Exception
    {
        PropertyDescriptor origDescriptors[] =
                PropertyUtils.getPropertyDescriptors(databean);
        for (int i = 0; i < origDescriptors.length; i++) {
            String name = origDescriptors[i].getName();
            //          String type = origDescriptors[i].getPropertyType().toString();
            if ("class".equals(name)) {
                continue; // No point in trying to set an object's class
            }
            if (PropertyUtils.isReadable(databean, name) &&
                    PropertyUtils.isWriteable(tobean, name)) {
                try {
                    Object value = PropertyUtils.getSimpleProperty(databean, name);
                    if(value!=null){
                        copyProperty(tobean, name, value);
                    }
                }
                catch (java.lang.IllegalArgumentException ie) {
                    ; // Should not happen
                }
                catch (Exception e) {
                    ; // Should not happen
                }

            }
        }
    }


    /**
     * 把orig和dest相同属性的value复制到dest中
     * @param dest
     * @param orig
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static void copyBean2Bean(Object dest, Object orig) throws Exception {
        convert(dest, orig);
    }

    public static void copyBean2Map(Map map, Object bean){
        PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(bean);
        for (int i =0;i<pds.length;i++)
        {
            PropertyDescriptor pd = pds[i];
            String propname = pd.getName();
            try {
                Object propvalue = PropertyUtils.getSimpleProperty(bean,propname);
                map.put(propname, propvalue);
            } catch (IllegalAccessException e) {
                //e.printStackTrace();
            } catch (InvocationTargetException e) {
                //e.printStackTrace();
            } catch (NoSuchMethodException e) {
                //e.printStackTrace();
            }
        }
    }

    /**
     * 将Map内的key与Bean中属性相同的内容复制到BEAN中
     * @param bean Object
     * @param properties Map
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static void copyMap2Bean(Object bean, Map properties) throws
    IllegalAccessException, InvocationTargetException {
        // Do nothing unless both arguments have been specified
        if ( (bean == null) || (properties == null)) {
            return;
        }
        // Loop through the property name/value pairs to be set
        Iterator names = properties.keySet().iterator();
        while (names.hasNext()) {
            String name = (String) names.next();
            // Identify the property name and value(s) to be assigned
            if (name == null) {
                continue;
            }
            Object value = properties.get(name);
            try {
                Class clazz = PropertyUtils.getPropertyType(bean, name);
                if (null == clazz) {
                    continue;
                }
                String className = clazz.getName();
                if (className.equalsIgnoreCase("java.sql.Timestamp")) {
                    if (value == null || value.equals("")) {
                        continue;
                    }
                }
                setProperty(bean, name, value);
            }
            catch (NoSuchMethodException e) {
                continue;
            }
        }
    }


    /**
     * 自动转Map key值大写
     * 将Map内的key与Bean中属性相同的内容复制到BEAN中
     * @param bean Object
     * @param properties Map
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static void copyMap2Bean_Nobig(Object bean, Map properties) throws
    IllegalAccessException, InvocationTargetException {
        // Do nothing unless both arguments have been specified
        if ( (bean == null) || (properties == null)) {
            return;
        }
        // Loop through the property name/value pairs to be set
        Iterator names = properties.keySet().iterator();
        while (names.hasNext()) {
            String name = (String) names.next();
            // Identify the property name and value(s) to be assigned
            if (name == null) {
                continue;
            }
            Object value = properties.get(name);
            //----------------------------------------------------------------
            //update-begin--Author:Quainty  Date:20130520 for：JDBC方式调用
            // 命名应该大小写应该敏感(否则取不到对象的属性)
            //name = name.toLowerCase();
            try {
                if (value == null) {	// 不光Date类型，好多类型在null时会出错
                    continue;	// 如果为null不用设 (对象如果有特殊初始值也可以保留？)
                }
                Class clazz = PropertyUtils.getPropertyType(bean, name);
                if (null == clazz) {	// 在bean中这个属性不存在
                    continue;
                }
                String className = clazz.getName();
                // 临时对策（如果不处理默认的类型转换时会出错）
                if (className.equalsIgnoreCase("java.util.Date")) {
                    value = new java.util.Date(((java.sql.Timestamp)value).getTime());// wait to do：貌似有时区问题, 待进一步确认
                }
                //              if (className.equalsIgnoreCase("java.sql.Timestamp")) {
                //                  if (value == null || value.equals("")) {
                //                      continue;
                //                  }
                //              }
                //update-end--Author:Quainty  Date:20130520 for：JDBC方式调用
                //----------------------------------------------------------------
                setProperty(bean, name, value);
            }
            catch (NoSuchMethodException e) {
                continue;
            }
        }
    }

    /**
     * Map内的key与Bean中属性相同的内容复制到BEAN中
     * 对于存在空值的取默认值
     * @param bean Object
     * @param properties Map
     * @param defaultValue String
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static void copyMap2Bean(Object bean, Map properties, String defaultValue) throws
    IllegalAccessException, InvocationTargetException {
        // Do nothing unless both arguments have been specified
        if ( (bean == null) || (properties == null)) {
            return;
        }
        // Loop through the property name/value pairs to be set
        Iterator names = properties.keySet().iterator();
        while (names.hasNext()) {
            String name = (String) names.next();
            // Identify the property name and value(s) to be assigned
            if (name == null) {
                continue;
            }
            Object value = properties.get(name);
            try {
                Class clazz = PropertyUtils.getPropertyType(bean, name);
                if (null == clazz) {
                    continue;
                }
                String className = clazz.getName();
                if (className.equalsIgnoreCase("java.sql.Timestamp")) {
                    if (value == null || value.equals("")) {
                        continue;
                    }
                }
                if (className.equalsIgnoreCase("java.lang.String")) {
                    if (value == null) {
                        value = defaultValue;
                    }
                }
                setProperty(bean, name, value);
            }
            catch (NoSuchMethodException e) {
                continue;
            }
        }
    }

    public MyBeanUtils() {
        super();
    }


    public static void copyPriperties(Object o1, Object o2) {

        String fileName,str,getName,setName;
        List fields = new ArrayList();
        Method getMethod = null;
        Method setMethod = null;
        try {
            Class c1 = o1.getClass();
            Class c2 = o2.getClass();

            Field[] fs1 = c1.getDeclaredFields();
            Field[] fs2 = c2.getDeclaredFields();
            //两个类属性比较剔除不相同的属性，只留下相同的属性
            for(int i = 0;i < fs2.length;i++) {
                for(int j = 0;j < fs1.length;j++) {
                    if(fs1[j].getName().equals(fs2[i].getName())) {
                        fields.add(fs1[j]);
                        break;
                    }
                }
            }
            if(null != fields && fields.size() > 0){
                for (int i = 0;i < fields.size();i++) {
                    //获取属性名称
                    Field f = (Field) fields.get(i);
                    fileName = f.getName();
                    //属性名第一个字母大写
                    str = fileName.substring(0, 1).toUpperCase();
                    //拼凑getXXX和setXXX方法名
                    getName = "get" + str + fileName.substring(1);
                    setName = "set" + str + fileName.substring(1);
                    //获取get、set方法
                    getMethod = c1.getMethod(getName, new Class[]{});
                    setMethod = c2.getMethod(setName, new Class[]{f.getType()});

                    //获取属性值
                    Object o = getMethod.invoke(o1, new Object[]{});
                    System.out.println(fileName + " : " + o);
                    //将属性值放入另一个对象中对应的属性
                    if(null != o) {
                        System.out.println("o2.setMethod = " + setMethod);
                        setMethod.invoke(o2, new Object[] {o});
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对象拷贝
     * 数据对象空值不拷贝到目标对象
     *
     * @param dataObject
     * @param toObject
     * @throws NoSuchMethodException
     * copy
     */
  public static void copyBeanNotNullTToBean(Object databean,Object tobean)throws Exception
  {
      PropertyDescriptor origDescriptors[] =
          PropertyUtils.getPropertyDescriptors(databean);
      for (int i = 0; i < origDescriptors.length; i++) {
          String name = origDescriptors[i].getName();
//          String type = origDescriptors[i].getPropertyType().toString();
          if ("class".equals(name)) {
              continue; // No point in trying to set an object's class
          }
          if (PropertyUtils.isReadable(databean, name) &&
              PropertyUtils.isWriteable(tobean, name)) {
              try {
                  Object value = PropertyUtils.getSimpleProperty(databean, name);
                  if(value!=null){
                        copyProperty(tobean, name, value);
                  }
              }
              catch (java.lang.IllegalArgumentException ie) {
                  ; // Should not happen
              }
              catch (Exception e) {
                  ; // Should not happen
              }

          }
      }
  }

}
