package com.liantuo.trade.client.trade.packet.rsp.withdraw;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawDeduct;

@XmlRootElement(name = "trade")
public class TradePacketRspSingleWithdrawDeduct extends TradePacket implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlTransient
    public TradePacketRspBodySingleWithdrawDeduct getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodySingleWithdrawDeduct body;

    public void setBody(TradePacketRspBodySingleWithdrawDeduct body) {
        this.body = body;
    }

}
