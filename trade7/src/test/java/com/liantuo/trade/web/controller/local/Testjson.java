package com.liantuo.trade.web.controller.local;


import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;



public class Testjson {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		User user=null;
//		user=new User();
//		user.setAddress("beijing����");
//		user.setEmail("test.com����");
//		    	
//    	String jsonstr=tojson(user);//����ת����json
//    	User juser=jsonto(jsonstr,User.class);//jsonת���ɶ���
//    	System.out.println(juser.getAddress()+"----"+juser.getEmail());
//    	
//    	//Listת����json
//    	List<User> userList = new ArrayList<User>();
//		for(int i=0;i<3;i++){
//			user = new User();
//			user.setAddress("add"+i);
//			user.setEmail("test"+i);
//			userList.add(user);
//		}
//		String jsonlist=tojson(userList);
////		//jsonת����List
//		List<User> ulist = new ArrayList<User>();
//		ulist=(List<User>) json2List(jsonlist,new TypeReference<List<User>>() {});
//		System.out.println(ulist.get(0).getAddress());
//		
//		//Mapת����json
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("bool", Boolean.TRUE);
//		map.put("int", 321);
//		map.put("listuser", userList);
//		System.out.println(map);
//		String jsonmap=tojson(map);
//
//		//json
//		try {
//			JsonNode rootNode = objectMapper.readTree(jsonmap);
//			  List<User> userlist = jsonNodeTo(rootNode.path("listuser"),
//	                    new TypeReference<List<User>>() {
//	                    });
//			  System.out.println(userlist.get(0).getAddress());
//			 Integer aa= jsonNodeTo(rootNode.path("int"),
//	                    new TypeReference<Integer>() {
//	                    });
//			 System.out.println(aa.intValue());
//			  
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
	    
	}
	
	//
	private static String tojson(Object obj){
		String teste="";
		try {
    		//objectMapper.writeValue(System.out, e);
			teste=objectMapper.writeValueAsString(obj);
			System.out.println(teste);
			
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
		return teste;
	}
	
	/**
	 * ��json�ַ�ת����JavaBean����

	 * @param json
	 * @param valueType
	 * @return
	 */
	private static <T> T jsonto(String json,Class<T> valueType){
		String teste="";
		try {
	
			return  objectMapper.readValue(json, valueType);
			
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
	
	//
	public static List<?>  json2List(String json, @SuppressWarnings("rawtypes")
    TypeReference valueTypeRef){
		String teste="";
		try {
			return  objectMapper.readValue(json,  valueTypeRef);

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
	
	public static <T> T jsonNodeTo(JsonNode root, @SuppressWarnings("rawtypes")
    TypeReference valueTypeRef) {
        if (root != null) {
            try {
                return objectMapper.readValue(root, valueTypeRef);
            } catch (JsonParseException e) {
                e.printStackTrace();
                return null;
            } catch (JsonMappingException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
	
	
	 

}
