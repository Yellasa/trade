package com.liantuo.trade.client.trade.packet.req;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyPayPageDetails;

@XmlRootElement(name = "trade")
public class TradePacketReqPayPageDetails extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketReqBodyPayPageDetails getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodyPayPageDetails body;

    public void setBody(TradePacketReqBodyPayPageDetails body) {
        this.body = body;
    }

}
