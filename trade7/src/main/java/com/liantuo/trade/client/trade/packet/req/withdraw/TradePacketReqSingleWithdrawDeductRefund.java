package com.liantuo.trade.client.trade.packet.req.withdraw;

import com.liantuo.trade.client.trade.packet.TradePacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.TradePacketReqBodySingleWithdrawDeductRefund;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "trade")
public class TradePacketReqSingleWithdrawDeductRefund extends TradePacket implements Serializable {
    public static final String REQUEST_CODE = "0002_001_005";

    @XmlTransient
    public TradePacketReqBodySingleWithdrawDeductRefund getBody() {
        return body;
    }

    @XmlElement(name = "body")
    private TradePacketReqBodySingleWithdrawDeductRefund body;

    public void setBody(TradePacketReqBodySingleWithdrawDeductRefund body) {
        this.body = body;
    }

}
