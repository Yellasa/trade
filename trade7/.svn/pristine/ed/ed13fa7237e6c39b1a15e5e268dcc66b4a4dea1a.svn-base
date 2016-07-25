package com.liantuo.trade.client;


import org.junit.Test;

import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyFullUnFreeze;
import com.liantuo.trade.client.trade.packet.req.TradePacketReqFullUnFreeze;

import com.liantuo.trade.common.util.sign.SignUtil;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;

import static org.assertj.core.api.Assertions.*;

public class SignTest {

	@Test
	public void testSign(){
		TradePacketReqFullUnFreeze tprfnf = new TradePacketReqFullUnFreeze();
		TradePacketReqBodyFullUnFreeze tprbfuf = new TradePacketReqBodyFullUnFreeze();
		tprbfuf.setTrade_no("0123456789");
		tprfnf.setBody(tprbfuf);
		String sign1 = SignUtil.createSign(tprfnf.getBody(), "123456", "UTF-8");
		String xml= ObjectXmlUtil.marshal(tprfnf);
		TradePacketReqFullUnFreeze obj = ObjectXmlUtil.unmarshal(xml, TradePacketReqFullUnFreeze.class);
		String sign2 = SignUtil.createSign(obj.getBody(), "123456", "UTF-8");
		assertThat(sign1).isEqualTo(sign2).as("a1与a2签名不相同");
	}

}
