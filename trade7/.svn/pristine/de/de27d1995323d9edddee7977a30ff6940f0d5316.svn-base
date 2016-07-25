package com.liantuo.trade.client.trade.packet.req;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyRefundOfflineSettle;

@XmlRootElement(name = "trade")
public class TradePacketReqRefundOfflineSettle extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketReqBodyRefundOfflineSettle getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodyRefundOfflineSettle body;

    public void setBody(TradePacketReqBodyRefundOfflineSettle body) {
        this.body = body;
    }

}
