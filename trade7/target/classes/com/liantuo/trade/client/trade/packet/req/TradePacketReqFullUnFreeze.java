package com.liantuo.trade.client.trade.packet.req;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyFullUnFreeze;

@XmlRootElement(name = "trade")
public class TradePacketReqFullUnFreeze extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketReqBodyFullUnFreeze getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodyFullUnFreeze body;

    public void setBody(TradePacketReqBodyFullUnFreeze body) {
        this.body = body;
    }

}
