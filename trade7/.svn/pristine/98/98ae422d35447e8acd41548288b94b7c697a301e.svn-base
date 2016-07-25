package com.liantuo.trade.client.trade.packet.rsp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyRefundOfflineSettle;

@XmlRootElement(name = "trade")
public class TradePacketRspRefundOfflineSettle extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketRspBodyRefundOfflineSettle getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodyRefundOfflineSettle body;

    public void setBody(TradePacketRspBodyRefundOfflineSettle body) {
        this.body = body;
    }

}
