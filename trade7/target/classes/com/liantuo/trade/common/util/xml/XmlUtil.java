package com.liantuo.trade.common.util.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ebill.framework.datatype.StringUtil;
import com.liantuo.trade.common.constants.TradeConstants;
import com.liantuo.trade.common.util.json.ObjectJsonUtil;

public class XmlUtil {

	public static Element getRootElement(String reqXml,String charset) {
		InputStream in = null;  
		Element rootElement =null;
        try {  
            in = new ByteArrayInputStream(reqXml.getBytes(charset));  
            SAXReader reader = new SAXReader();  
            // 2、将流转成document对象  
            Document document = reader.read(in);  
            rootElement = document.getRootElement(); // 拿到根节点 
        } catch (UnsupportedEncodingException e) {  
            System.out.println("流操作异常");  
            e.printStackTrace();  
        } catch (DocumentException e) {  
            // TODO Auto-generated catch block  
            System.out.println("Document对象操作异常");  
            e.printStackTrace();  
        } finally {  
            try {  
                in.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                System.out.println("流关闭异常");  
                e.printStackTrace();  
            }  
        }  
        return rootElement;
	}
	
	public static void main(String[] args) {
		
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>"
					+" <trade>"
		+" <head> "
		+" <core_merchant_no>CC_C8785258588</core_merchant_no>"
		 +"</head>"
		+"  <body> "
		 +"  <is_success>S</is_success>  "
		 +"  <result_code>S</result_code>  "
		 +"  <trade_details>{\"id\":225,\"tradeNo\":\"20151228145220315000000000002915\",\"coreMerchantNo\":\"CC_C8785258588你好\",\"fundPoolNo\":\"PN01000000000010876\",\"outTradeNo\":null,\"outTradeNoExt\":\"df2015122800006\",\"version\":2}</trade_details>  "
		 +" </body> "
		  +" </trade>";
		Element root = XmlUtil.getRootElement(xml,TradeConstants.ENCODING);
		Element trade_details=root.element("body").element("trade_details");
		String detail="";
		if(null!=trade_details){
			detail=trade_details.getText();
		}
		System.out.println("detail="+detail);
		if(!StringUtils.isEmpty(detail)){
			try {
				 Map<String, Object> map = ObjectJsonUtil.string2Object(detail,Map.class);
				 String out_trade_no=(String)map.get("tradeNo");
				 if(!StringUtil.isEmpty(out_trade_no)){
					 System.out.println("123456");
				 }
				 System.out.println((String)map.get("tradeNo"));
				 System.out.println((String)map.get("outTradeNo"));
				 System.out.println((String)map.get("outTradeNoExt"));
				 System.out.println((String)map.get("outTradeNoExt1"));
				 System.out.println((String)map.get("coreMerchantNo"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
