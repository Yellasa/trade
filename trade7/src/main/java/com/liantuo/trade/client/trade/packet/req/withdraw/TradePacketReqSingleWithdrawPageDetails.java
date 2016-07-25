package com.liantuo.trade.client.trade.packet.req.withdraw;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawPageDetails;

@XmlRootElement(name = "trade")
public class TradePacketReqSingleWithdrawPageDetails extends TradePacket implements Serializable {

    public static final String REQUEST_CODE = "0002_001_998";

    @XmlTransient
    public TradePacketReqBodySingleWithdrawPageDetails getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodySingleWithdrawPageDetails body;

    public void setBody(TradePacketReqBodySingleWithdrawPageDetails body) {
        this.body = body;
    }

}
