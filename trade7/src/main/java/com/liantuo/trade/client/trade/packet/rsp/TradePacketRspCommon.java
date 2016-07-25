package com.liantuo.trade.client.trade.packet.rsp;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyCommon;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyFreezeOfflineSettle;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketRspCommon extends TradePacket implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketRspBodyCommon getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodyCommon body;

    public void setBody(TradePacketRspBodyCommon body) {
        this.body = body;
    }

}
