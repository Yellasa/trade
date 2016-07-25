package com.liantuo.trade.client.trade.packet.rsp.withdraw;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawPay;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketRspSingleWithdrawPay extends TradePacket implements Serializable {
    @XmlTransient
    public TradePacketRspBodySingleWithdrawPay getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodySingleWithdrawPay body;

    public void setBody(TradePacketRspBodySingleWithdrawPay body) {
        this.body = body;
    }

}
