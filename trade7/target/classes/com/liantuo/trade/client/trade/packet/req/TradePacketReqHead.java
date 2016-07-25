package com.liantuo.trade.client.trade.packet.req;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyHead;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketReqHead extends TradePacket implements Serializable {
    @XmlElement(name = "body")
    private TradePacketReqBodyHead body;

    @XmlTransient
    public TradePacketReqBodyHead getBody() {
        return body;
    }

    public void setBody(TradePacketReqBodyHead body) {
        this.body = body;
    }
}
