package com.liantuo.trade.client.trade.packet.req;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.NotifyPacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.NotifyReqBody;

@XmlRootElement(name = "Transaction")
public class NotifyPacketReqCommon extends NotifyPacket {

    @XmlElement(name = "Transaction_Body")
    private NotifyReqBody body;

    @XmlTransient
    public NotifyReqBody getBody() {
        return body;
    }

    public void setBody(NotifyReqBody body) {
        this.body = body;
    }

}
