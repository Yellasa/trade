package com.liantuo.trade.client.trade.packet.rsp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.NotifyPacketResultInfo;
import com.liantuo.trade.client.trade.packet.NotifyRspPacket;

@XmlRootElement(name = "Transaction")
public class NotifyRspCommonPacket extends NotifyRspPacket {

    @XmlElement(name = "body")
    private NotifyPacketResultInfo body;

    @XmlTransient
    public NotifyPacketResultInfo getBody() {
        return body;
    }

    public void setBody(NotifyPacketResultInfo body) {
        this.body = body;
    }

}
