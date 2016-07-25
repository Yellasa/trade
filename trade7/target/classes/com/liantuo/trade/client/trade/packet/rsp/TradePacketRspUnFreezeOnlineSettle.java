package com.liantuo.trade.client.trade.packet.rsp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyUnFreezeOnlineSettle;

@XmlRootElement(name = "trade")
public class TradePacketRspUnFreezeOnlineSettle extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketRspBodyUnFreezeOnlineSettle getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodyUnFreezeOnlineSettle body;

    public void setBody(TradePacketRspBodyUnFreezeOnlineSettle body) {
        this.body = body;
    }

}
