package com.liantuo.trade.client.trade.packet.rsp;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketRspBodyMerchantFreeze;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketRspMerchantFreeze extends TradePacket implements Serializable {
    @XmlTransient
    public TradePacketRspBodyMerchantFreeze getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodyMerchantFreeze body;

    public void setBody(TradePacketRspBodyMerchantFreeze body) {
        this.body = body;
    }

}
