package com.liantuo.trade.client.trade.packet.rsp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyFullUnFreeze;

@XmlRootElement(name = "trade")
public class TradePacketRspFullUnFreeze extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketRspBodyFullUnFreeze getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodyFullUnFreeze body;

    public void setBody(TradePacketRspBodyFullUnFreeze body) {
        this.body = body;
    }

}
