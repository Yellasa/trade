package com.liantuo.trade.client.trade.packet.req.withdraw;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawPayResultQuery;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketReqSingleWithdrawPayResultQuery extends TradePacket implements Serializable {
    public static final String REQUEST_CODE = "0002_001_004";

    @XmlTransient
    public TradePacketReqBodySingleWithdrawPayResultQuery getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodySingleWithdrawPayResultQuery body;

    public void setBody(TradePacketReqBodySingleWithdrawPayResultQuery body) {
        this.body = body;
    }

}
