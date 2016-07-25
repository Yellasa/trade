package com.liantuo.trade.mq.rabbitmq.notice;

import java.text.MessageFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liantuo.trade.client.trade.packet.NotifyPacketResultInfo;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:config/spring/applicationContext-*.xml"
})
public class PaymentNotifyTemplateTest {
	@Autowired
	private RabbitTemplate amqpTemplate;
	private String routingKey = "com.liantuo.payment.trade.{0}";
	@Test
	public void testSendNotify(){
		NotifyPacketResultInfo notice = new NotifyPacketResultInfo();
		notice.setCore_merchant_no("000000000");
		notice.setErr_code("001001001");
		notice.setNotify_url("0005_001_005:1.0");
		final String notifyUrl = notice.getNotify_url();
		final String id = "123";
		amqpTemplate.setConfirmCallback(new ConfirmCallback(){

			@Override
			public void confirm(CorrelationData correlationData, boolean ack) {
				System.out.println(correlationData.getId());
				
			}
			
		});
//		amqpTemplate.setReturnCallback(new ReturnCallback(){
//
//			@Override
//			public void returnedMessage(Message message, int replyCode, String replyText, String exchange,
//					String routingKey) {
//				System.out.println(message);
//				
//			}
//			
//			
//		});
		amqpTemplate.convertAndSend(MessageFormat.format(routingKey, notifyUrl), notice,new MessagePostProcessor(){

			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				message.getMessageProperties().getHeaders().put("notifyUrl", notifyUrl);
				return message;
			}
		},new CorrelationData(id));
	}
}
