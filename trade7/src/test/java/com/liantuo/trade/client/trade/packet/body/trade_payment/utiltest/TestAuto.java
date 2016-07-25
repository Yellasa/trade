package com.liantuo.trade.client.trade.packet.body.trade_payment.utiltest;

import com.liantuo.trade.client.trade.packet.body.single_payment.TradePacketReqBodyInnerPayment;
import com.liantuo.trade.common.validate.Format;
import org.testng.annotations.DataProvider;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author:ksh
 * @Description:vo 属性覆盖测试
 * @Date：2016-06-06 10:15:42
 */
public class TestAuto extends ParentTest {

	@Override
	protected Class<?> getObjectClzz() {
		// TODO Auto-generated method stub
		return TradePacketReqBodyInnerPayment.class;
	}

	@DataProvider(name = "dataSourcefForAllParam")
    static Object[][] inintData() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        return new Object[][]{
//        		{"参数名","值","备注", 校验类型(Format.class)},
        		{"out_trade_no","112","case1", Format.class},
        		{"out_trade_no","552145111","case2", Format.class},
        		{"out_trade_no","abc_112233456678","case3", Format.class},
        		{"out_trade_no","1256985202144","case4", Format.class},
        		{"out_trade_no","axdcccccccccccccc","case5", Format.class}

        };
    }
	@org.testng.annotations.Test(dataProvider="dataSourcefForAllParam")
	public void testParam(String paraName,String val,String memo,Class<?> group) throws Exception{
//		String checkParaMeters = checkParaMeters(paraName, val,memo, group);
//		System.out.println(checkParaMeters);
	}

//查看VO相关信息
	@org.junit.Test
	public void testGetVoInfo(){
//		Map<String, String> objectInfo = getObjectInfo();
//		System.out.println((String)objectInfo.get("info"));
	}
	
	
	
}
