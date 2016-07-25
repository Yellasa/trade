package com.liantuo.trade.client.trade.packet;

import com.liantuo.trade.client.trade.packet.body.TradeResponseBody;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import com.liantuo.trade.common.util.xml.ObjectXmlUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tradeResponse")
public class TradeResponse implements java.io.Serializable {

    private static final long serialVersionUID = 2372200063225121465L;

    protected TradeResponseBody body = new TradeResponseBody();


    public TradeResponseBody getBody() {
        return body;
    }

    public void setBody(TradeResponseBody body) {
        this.body = body;
    }


    private TradePacketHead head = new TradePacketHead();


    public TradePacketHead getHead() {
        return head;
    }

    public void setHead(TradePacketHead busHead) {
        this.head = busHead;
    }


    public String marshal() {
        return ObjectXmlUtil.marshal(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}