package com.liantuo.trade.client.trade.packet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.head.NotifyPacketHead;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;

/**
 * 异步通知回调报文
 */
//@XmlRootElement(name = "Transaction")
public class NotifyPacket {

    @XmlElement(name = "Transaction_Header")
    private NotifyPacketHead busHead;

    @XmlTransient
    public NotifyPacketHead getBusHead() {
        return busHead;
    }

    public void setBusHead(NotifyPacketHead busHead) {
        this.busHead = busHead;
    }

    public static <T> T unmarshal(String xml, Class<T> a) {
        T obj = ObjectXmlUtil.unmarshal(xml, a);
        return obj;
    }

    public <T extends NotifyPacket> T unmarshal(String xml) {
        @SuppressWarnings("unchecked")
        T obj = (T) ObjectXmlUtil.unmarshal(xml, this.getClass());
        return obj;
    }

    public String marshal() {
        return ObjectXmlUtil.marshal(this);
    }

}
