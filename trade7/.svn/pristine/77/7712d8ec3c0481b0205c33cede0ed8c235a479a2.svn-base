package com.liantuo.trade.client.trade.packet.rsp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyFreezeOfflineSettle;

@XmlRootElement(name = "trade")
public class TradePacketRspUnFreezeOfflineSettle extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketRspBodyFreezeOfflineSettle getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodyFreezeOfflineSettle body;

    public void setBody(TradePacketRspBodyFreezeOfflineSettle body) {
        this.body = body;
    }

}
