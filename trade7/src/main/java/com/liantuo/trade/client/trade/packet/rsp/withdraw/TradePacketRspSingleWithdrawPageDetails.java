package com.liantuo.trade.client.trade.packet.rsp.withdraw;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawPageDetails;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketRspSingleWithdrawPageDetails extends TradePacket implements Serializable {
    @XmlTransient
    public TradePacketRspBodySingleWithdrawPageDetails getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodySingleWithdrawPageDetails body;

    public void setBody(TradePacketRspBodySingleWithdrawPageDetails body) {
        this.body = body;
    }

}
