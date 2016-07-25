package com.liantuo.trade.client.trade.packet.req.withdraw;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawPay;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketReqSingleWithdrawPay extends TradePacket implements Serializable {
    public static final String REQUEST_CODE = "0002_001_002";

    @XmlTransient
    public TradePacketReqBodySingleWithdrawPay getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodySingleWithdrawPay body;

    public void setBody(TradePacketReqBodySingleWithdrawPay body) {
        this.body = body;
    }

}
