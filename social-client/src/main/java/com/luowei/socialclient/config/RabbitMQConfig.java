package com.luowei.socialclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;

import java.util.HashMap;

@Configuration
public class RabbitMQConfig {
    // 测试队列名称
    private String testQueueName = "test_queue";
    // 测试交换机名称
    private String testExchangeName = "test_exchange";
    // RoutingKey
    private String testRoutingKey = "test_routing_key";

    /** 创建队列 */
    @Bean
    public Queue queue() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        // 设置超时时间
        map.put("x-message-ttl", 1000);
        // 设置死信交换器
        map.put("x-dead-letter-exchange", "dead-letter-exchange");
        // 设置死信路由键
        map.put("x-dead-letter-routing-key", "dead-letter-routing");
        return new Queue("hello",false, false, false, map);
    }
    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }

    /**
     * 创建一个队列 -> "test"
     */
    @Bean
    public Queue testQueue() {
        return new Queue("test");
    }
    /**
     * 死信队列
     */
    @Bean
    public Queue deadQueue() {
        return new Queue("deadqueue");
    }

    /**
     * 死信交换器
     */
    @Bean
    public DirectExchange deadExchange() {
        return new DirectExchange("dead-letter-exchange");
    }
    /**
     * 绑定死信队列和死信交换器
     */
    @Bean
    public Binding deadBinding() {
        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("dead-letter-routing");
    }

    /**
     * 创建一个direct交换器
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("com.zonzie.directtest");
    }

    /**
     * 通过bindingKey -> "hellotest", 绑定queue->"hello"和上面的交换器
     */
    @Bean
    public Binding bindingKey() {
        return BindingBuilder.bind(queue()).to(directExchange()).with("hellotest");
    }

    /**
     * 创建topic交换器
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("com.zonzie.topictest");
    }

    /**
     * 通过bindingKey -> "com.*.test" 绑定queue->"test"和上面的topicExchange
     */
    @Bean
    public Binding topicBindKey() {
        return BindingBuilder.bind(testQueue()).to(topicExchange()).with("com.*.test");
    }

    /**
     * 通过bindingKey -> "com.#" 绑定 queue->"hello"和topicExchange
     */
    @Bean
    public Binding topicBindKey2() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with("com.#");
    }

}
