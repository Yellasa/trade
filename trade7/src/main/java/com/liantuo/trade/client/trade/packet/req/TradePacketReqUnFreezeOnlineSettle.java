package com.liantuo.trade.client.trade.packet.req;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyUnFreezeOnlineSettle;

@XmlRootElement(name = "trade")
public class TradePacketReqUnFreezeOnlineSettle extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketReqBodyUnFreezeOnlineSettle getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodyUnFreezeOnlineSettle body;

    public void setBody(TradePacketReqBodyUnFreezeOnlineSettle body) {
        this.body = body;
    }

}
