package com.itheima.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname: FanoutConfiguration
 * @Date: 2025/4/2 15:39
 * @Author: 聂建强
 * @Description: 声明一个Direct类型的交换机，并且创建队列与其绑定
 */

// @Configuration
public class DirectConfiguration {

    // 声明一个交换机(2种方式)
    @Bean
    public DirectExchange directExchange(){

        return ExchangeBuilder.directExchange("hmall.direct").build();

        // return new DirectExchange("hmall.direct");
    }

    // 声明队列(2种方式)
    @Bean
    public Queue directQueue1(){
        // return QueueBuilder.durable("direct.queue1").build();
        return new Queue("direct.queue1");
    }

    // 绑定交换机与队列(显示声明参数)
    @Bean
    public Binding directBindingRed(Queue directQueue1,DirectExchange directExchange){
        // 一次只能绑定一个routingKey
        return BindingBuilder.bind(directQueue1).to(directExchange).with("red");
    }

    @Bean
    public Binding directBindingBlue(Queue directQueue1,DirectExchange directExchange){
        // 一次只能绑定一个routingKey
        return BindingBuilder.bind(directQueue1).to(directExchange).with("blue");
    }

}
