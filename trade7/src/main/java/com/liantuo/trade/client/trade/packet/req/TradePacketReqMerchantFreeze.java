package com.liantuo.trade.client.trade.packet.req;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.TradePacketReqBodyMerchantFreeze;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketReqMerchantFreeze extends TradePacket implements Serializable {
    @XmlTransient
    public TradePacketReqBodyMerchantFreeze getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodyMerchantFreeze body;

    public void setBody(TradePacketReqBodyMerchantFreeze body) {
        this.body = body;
    }

}
