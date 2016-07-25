package com.liantuo.trade.client.trade.packet.rsp.withdraw;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawPayResultQuery;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketRspSingleWithdrawPayResultQuery extends TradePacket implements Serializable {
    @XmlTransient
    public TradePacketRspBodySingleWithdrawPayResultQuery getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodySingleWithdrawPayResultQuery body;

    public void setBody(TradePacketRspBodySingleWithdrawPayResultQuery body) {
        this.body = body;
    }

}
