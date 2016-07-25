package com.liantuo.trade.client.trade.packet.req;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundPageDetails;

@XmlRootElement(name = "trade")
public class TradePacketReqRefundPageDetails extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketReqBodyRefundPageDetails getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodyRefundPageDetails body;

    public void setBody(TradePacketReqBodyRefundPageDetails body) {
        this.body = body;
    }

}
