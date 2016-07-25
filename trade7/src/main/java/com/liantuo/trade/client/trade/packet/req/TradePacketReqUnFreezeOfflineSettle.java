package com.liantuo.trade.client.trade.packet.req;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyUnFreezeOfflineSettle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketReqUnFreezeOfflineSettle extends TradePacket implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketReqBodyUnFreezeOfflineSettle getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodyUnFreezeOfflineSettle body;

    public void setBody(TradePacketReqBodyUnFreezeOfflineSettle body) {
        this.body = body;
    }

}
