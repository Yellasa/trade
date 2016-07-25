package com.liantuo.trade.client.trade.packet.req.withdraw;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.liantuo.trade.client.trade.packet.NotifyPacket;
import com.liantuo.trade.client.trade.packet.body.withdraw.WithdrawNotifyReqBody;

/**
 * 提现通知报文
 */
@XmlRootElement(name = "Transaction")
public class WithdrawNotifyReqPacket extends NotifyPacket{

    @XmlElement(name = "Transaction_Body")
    private WithdrawNotifyReqBody body;

    @XmlTransient
    public WithdrawNotifyReqBody getBody() {
        return body;
    }

    public void setBody(WithdrawNotifyReqBody body) {
        this.body = body;
    }
    
}
