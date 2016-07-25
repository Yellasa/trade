package com.liantuo.trade.client.trade.packet.rsp;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyRefundPageDetails;

@XmlRootElement(name = "trade")
public class TradePacketRspRefundPageDetails extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketRspBodyRefundPageDetails getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodyRefundPageDetails body;

    public void setBody(TradePacketRspBodyRefundPageDetails body) {
        this.body = body;
    }

}
