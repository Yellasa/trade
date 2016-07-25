package com.liantuo.trade.client.trade.packet;


import com.liantuo.trade.client.trade.packet.body.TradeRequestBody;
import com.liantuo.trade.client.trade.packet.head.TradePacketHead;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "tradeRequest")
@XmlAccessorType(value = XmlAccessType.PROPERTY)
public class TradeRequest<B extends TradeRequestBody> implements java.io.Serializable {

    private static final long serialVersionUID = 5099552708133757701L;

    private static Map<Class, JAXBContext> jaxbContextMap = new HashMap<Class, JAXBContext>();
    @Valid
    protected B body;
    @Valid
    private TradePacketHead head = new TradePacketHead();

    public TradePacketHead getHead() {
        return head;
    }

    public void setHead(TradePacketHead head) {
        this.head = head;
    }

    public B getBody() {
        return body;
    }

    public void setBody(B body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String marshal() throws JAXBException {
        JAXBContext jaxbContext;
        String xmlStr;
        if (jaxbContextMap.get(body.getClass()) == null) {
            jaxbContext = JAXBContext.newInstance(TradeRequest.class, body.getClass());
            jaxbContextMap.put(body.getClass(), jaxbContext);
        } else {
            jaxbContext = jaxbContextMap.get(body.getClass());
        }
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter out = new StringWriter();
        marshaller.marshal(this, new StreamResult(out));
        xmlStr = out.toString();
        return xmlStr;
    }

    public static TradeRequest<?> unmarshal(String xml, Class<?> bodyClass) throws JAXBException {
        JAXBContext jaxbContext;
        if (jaxbContextMap.get(bodyClass) == null) {
            jaxbContext = JAXBContext.newInstance(TradeRequest.class, bodyClass);
            jaxbContextMap.put(bodyClass, jaxbContext);
        } else {
            jaxbContext = jaxbContextMap.get(bodyClass);
        }
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (TradeRequest<?>) unmarshaller.unmarshal(new StringReader(xml));
    }
}