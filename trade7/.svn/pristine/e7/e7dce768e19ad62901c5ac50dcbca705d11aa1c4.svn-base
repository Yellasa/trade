package com.liantuo.trade.client.trade.packet.rsp.withdraw;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.NotifyRspPacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.WithdrawNotifyRspBody;

@XmlRootElement(name = "Transaction")
public class WithdrawNotifyRspPacket extends NotifyRspPacket {

    @XmlElement(name = "body")
    private WithdrawNotifyRspBody body;

    @XmlTransient
    public WithdrawNotifyRspBody getBody() {
        return body;
    }

    public void setBody(WithdrawNotifyRspBody body) {
        this.body = body;
    }

}
