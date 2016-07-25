package com.liantuo.trade.client.trade.packet.rsp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyPayPageDetails;

@XmlRootElement(name = "trade")
public class TradePacketRspPayPageDetails extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketRspBodyPayPageDetails getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodyPayPageDetails body;

    public void setBody(TradePacketRspBodyPayPageDetails body) {
        this.body = body;
    }

}
