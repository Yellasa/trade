package com.liantuo.trade.client.trade.packet.req.withdraw;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawDeduct;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketReqSingleWithdrawDeduct extends TradePacket implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String REQUEST_CODE = "0002_001_001";

    @XmlTransient
    public TradePacketReqBodySingleWithdrawDeduct getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodySingleWithdrawDeduct body;

    public void setBody(TradePacketReqBodySingleWithdrawDeduct body) {
        this.body = body;
    }

}
