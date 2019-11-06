package com.luowei.socialclient.mq.producer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String queueName) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "756840349@qq.com");
        jsonObject.put("timestamp", System.currentTimeMillis());
        String jsonString = jsonObject.toJSONString();
        // 生产者发送消息的时候需要设置消息id
        Message message = MessageBuilder.withBody(jsonString.getBytes())
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setContentType(MessageProperties.CONTENT_TYPE_JSON).setContentEncoding("utf-8")
                .build();
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
