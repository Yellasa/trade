package com.liantuo.trade.client.trade.packet.rsp.withdraw;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketRspBodySingleWithdrawDeductRefund;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketRspSingleWithdrawDeductRefund extends TradePacket implements Serializable {
    @XmlTransient
    public TradePacketRspBodySingleWithdrawDeductRefund getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketRspBodySingleWithdrawDeductRefund body;

    public void setBody(TradePacketRspBodySingleWithdrawDeductRefund body) {
        this.body = body;
    }

}
