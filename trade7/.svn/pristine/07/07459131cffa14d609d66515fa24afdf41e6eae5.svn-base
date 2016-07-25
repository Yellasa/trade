package com.liantuo.trade.client.trade.packet.req;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyCommon;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketReqCommon extends TradePacket implements Serializable {
    @XmlElement(name = "body")
    private TradePacketReqBodyCommon body;

    @XmlTransient
    public TradePacketReqBodyCommon getBody() {
        return body;
    }

    public void setBody(TradePacketReqBodyCommon body) {
        this.body = body;
    }
}
