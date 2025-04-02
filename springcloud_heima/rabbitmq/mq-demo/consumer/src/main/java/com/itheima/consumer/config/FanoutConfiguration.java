package com.itheima.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname: FanoutConfiguration
 * @Date: 2025/4/2 15:39
 * @Author: 聂建强
 * @Description: 声明一个Fanout类型的交换机，并且创建队列与其绑定
 */

@Configuration
public class FanoutConfiguration {

    // 声明一个交换机(2种方式)
    @Bean
    public FanoutExchange fanoutExchange(){
        // return ExchangeBuilder.fanoutExchange("hmall.fanout2").build();

        return new FanoutExchange("hmall.fanout2");
    }

    // 声明队列(2种方式)
    @Bean
    public Queue fanoutQueue3(){
        // return QueueBuilder.durable("fanout.queue3").build();

        return new Queue("fanout.queue3");
    }

    @Bean
    public Queue fanoutQueue4(){
        return QueueBuilder.durable("fanout.queue4").build();
    }

    // 绑定交换机与队列(显示声明参数)
    @Bean
    public Binding fanoutBinding3(Queue fanoutQueue3,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }

    // 绑定交换机与队列（直接调用函数）
    @Bean
    public Binding fanoutBinding4(){
        return BindingBuilder.bind(fanoutQueue4()).to(fanoutExchange());
    }
}
