package com.liantuo.trade.client.trade.packet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;

public abstract class TradePacket implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "head")
    private TradePacketHead busHead;

    @XmlTransient
    public TradePacketHead getBusHead() {
        return busHead;
    }

    public void setBusHead(TradePacketHead busHead) {
        this.busHead = busHead;
    }

    public static <T extends TradePacket> T unmarshal(String xml, Class<T> a) {
    	T obj = ObjectXmlUtil.unmarshal(xml, a);
    	return obj;
    }
    public <T extends TradePacket> T unmarshal(String xml){
    	T obj = (T) ObjectXmlUtil.unmarshal(xml, this.getClass());
    	return obj;
    }
    public String marshal() {
    	return ObjectXmlUtil.marshal(this);
    }
}
