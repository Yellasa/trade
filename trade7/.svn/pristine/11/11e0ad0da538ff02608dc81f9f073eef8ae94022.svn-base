package com.liantuo.trade.common.util.xml;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamResult;

/**
 * <br>
 * <b>类名：ObjectXmlUtil.java</b><br>
 * <b>功能：ObjectXML序列化</b><br>
 * <b>作者：panhaohai</b><br>
 * <b>日期：2013-12-2</b><br>
 * <b>版权所有：<b>版权所有(C) 2013 EBILL<br>
 * <b>更新者：dingyaming</b><br>
 * <b>日期：2014-04-19</b> <br>
 * <b>更新内容：</b><br>
 * <b>描述：</b><br>
 *
 */
public class ObjectXmlUtil {
    /**
     * Object 序列化  XML
     * Object->@XmlRootElement
     * @param object
     * @return
     */
	public static String marshal( Object object) {
        String xmlStr = "";
        try {
        	JAXBContext jaxbContext = getJaxbContext(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter out = new StringWriter();
            marshaller.marshal(object  , new StreamResult(out));
            xmlStr = out.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlStr.toString();
    }
	
	/**
	 * XML 反序列化  Object
	 * Object->@XmlRootElement
	 * @param xml
	 * @param a
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(String xml, Class<T> valueType) {
        try {
        	JAXBContext jaxbContext = getJaxbContext(valueType);
        	Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
        	if(xml != null && !"".equals(xml)){
        		System.out.println("XML_TO_Objet_ERROR:"+xml);
            	e.printStackTrace();
        	}else{
        		System.out.println("RESPONSE_CONTENT_IS_NULL");
        	}
        }
        return null;

    }
    
    /**
     * 
     * 实例化JAXBContext对象，只实例化一次。
     * 因为 JAXBContext.newInstance()方法在并发量高时有性能问题。
     * 
     */
    private static Map<Class<?>,JAXBContext> map = new HashMap<Class<?>,JAXBContext>();
    
    private static synchronized JAXBContext getJaxbContext(Class<?> a) {
        try {
            if(map.containsKey(a)) {
	        	return map.get(a);
            } else {
            	JAXBContext jaxbContext = JAXBContext.newInstance(a);
            	map.put(a, jaxbContext);
            	return jaxbContext;
             }
        } catch (JAXBException e) {
        	e.printStackTrace();
        }
        return null;
    }
    
  
}

