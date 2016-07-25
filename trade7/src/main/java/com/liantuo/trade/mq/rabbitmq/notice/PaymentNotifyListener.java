package com.liantuo.trade.mq.rabbitmq.notice;

import com.liantuo.payment.client.pay.PaymentNotify;
import com.liantuo.trade.bus.template.AbstractTradeNotifyTemplate;
import com.liantuo.trade.spring.SpringUtils;
import com.liantuo.trade.spring.annotation.JobFlow;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a consumer of rabbitMQ notified by payment_center
 */
public class PaymentNotifyListener implements ChannelAwareMessageListener {
    private final Logger logger = LoggerFactory.getLogger(PaymentNotifyListener.class);

    private static final Map<MediaType, MessageConverter> converters = new HashMap<MediaType, MessageConverter>();

    static {
        converters.put(MediaType.APPLICATION_JSON, new Jackson2JsonMessageConverter());
        // converters.put(MediaType.APPLICATION_XML, value)
    }

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        String routingKey = message.getMessageProperties().getReceivedRoutingKey();
        String notifyUrl = (String) message.getMessageProperties().getHeaders().get("notifyUrl");
        String ip = (String) message.getMessageProperties().getHeaders().get("ip");

        MediaType mediaType = MediaType.parseMediaType(message.getMessageProperties().getContentType());
        MessageConverter messageConverter = getMessageConverter(mediaType);
        PaymentNotify notifyMessage = (PaymentNotify) messageConverter.fromMessage(message);
        logger.info("收到异步通知, 交易号：{}", notifyMessage.getZf_head().getTrade_no());

//		TradePaymentAsyNotifyPacket request =  (TradePaymentAsyNotifyPacket) JSONObject.parse(message.getBody());
//		TradePaymentAsyNotifyPacket request =  JSON.parseObject(message.getBody(),TradePaymentAsyNotifyPacket.class);
//		request.setRequestXML(JSON.toJSONString(JSON.parse(message.getBody())));
//      TradePaymentAsyNotifyPacket request = new TradePaymentAsyNotifyPacket();

        /**交易消息处理服务：查找*/
        Object jobFlow = SpringUtils.getBean(notifyUrl.trim());
        AbstractTradeNotifyTemplate template = getTemplate(jobFlow);
        template.setProcess(jobFlow);
        template.setIp(ip);

        /**交易消息处理服务：执行*/
        template.execute(notifyMessage);
    }

    /**
     * @param jobFlow
     * @return
     */
    private AbstractTradeNotifyTemplate getTemplate(Object jobFlow) {
        JobFlow annotation = jobFlow.getClass().getAnnotation(JobFlow.class);
        return (AbstractTradeNotifyTemplate) SpringUtils.getBean(annotation.template());
    }

    /**
     * @param mediaType
     * @return
     */
    private MessageConverter getMessageConverter(MediaType mediaType) {
        MessageConverter messageConverter = converters.get(mediaType);
        if (messageConverter == null) {
            throw new IllegalArgumentException("不支持的序列化类型" + mediaType.getType());
        } else {
            return messageConverter;
        }
    }
}
