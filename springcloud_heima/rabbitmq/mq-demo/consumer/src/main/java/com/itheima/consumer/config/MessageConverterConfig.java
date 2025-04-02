package com.itheima.consumer.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname: MessageConverterConfig
 * @Date: 2025/4/2 16:39
 * @Author: 聂建强
 * @Description: 自定义消息转换器
 */
@Configuration
public class MessageConverterConfig {

    // 声明自定义的消息转换器
    @Bean
    public MessageConverter jacksonMessageConvertor(){
        return new Jackson2JsonMessageConverter();
    }
}
