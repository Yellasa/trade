package com.liantuo.trade.common.util.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import com.liantuo.trade.client.trade.packet.body.single_payment_refund.OtherPofitLossLedgerForRefund;

public class ObjectJsonUtil
{

	private static final ObjectMapper mapper = new ObjectMapper();
    /**
     * 将json字符串转换为对象
     * 
     * @author dll 2013-6-21 修改者名字 修改日期 修改内容
     * @param <T>
     * @param convertStr
     * @param clazz
     * @return T
     * @throws Exception
     * @throws
     */
    public static <T> T string2Object(String convertStr, Class<T> clazz) throws Exception
    {
        T reply;
        mapper.registerSubtypes(clazz);
        reply = mapper.readValue(convertStr, clazz);
        return reply;
    }

    /**
     * 对象转换为json字符串
     * 
     * @author dll 2013-6-21 修改者名字 修改日期 修改内容
     * @param <T>
     * @param obj
     * @return String
     * @throws Exception
     * @throws
     */
    public static <T> String object2String(T obj) throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Inclusion.NON_NULL);
        mapper.registerSubtypes(obj.getClass());
        return mapper.writeValueAsString(obj);
    }
    
    /**
     * jason转换list
     * @param json
     * @param valueTypeRef
     * @return
     */
    public static List<?>  json2List(String json, @SuppressWarnings("rawtypes")
    TypeReference valueTypeRef){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return  mapper.readValue(json,  valueTypeRef);
		} catch (JsonGenerationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
    
	/**   
     * 获取泛型的Collection Type  
     * @param collectionClass 泛型的Collection   
     * @param elementClasses 元素类   
     * @return JavaType Java类型   
     * @since 1.0   
     */   
	 private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
	     return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	 }
	 
	 /**
	  * json数组转换为集合类型
	  * EX.
	  * String json = "[{\"ledger_no\":\"00060021606291601077410000185405\",\"income_incr\":\"0.08\"}]";
    	List<T> json2ArrayList = json2ArrayList(json, T.class);
	  * 
	  * @param json
	  * @param clazz
	  * @return
	  * @throws JsonParseException
	  * @throws JsonMappingException
	  * @throws IOException
	  */
	 public static <T> List<T> json2ArrayList(String json,Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		 JavaType javaType = getCollectionType(ArrayList.class, clazz);
		 return (List<T>)mapper.readValue(json, javaType);
	 }
    
}
