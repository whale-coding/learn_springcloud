package com.itheima.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname: MqListener
 * @Date: 2025/4/1 21:25
 * @Author: 聂建强
 * @Description: MQ监听器，用于接收消息
 */

@Slf4j
@Component
public class MqListener {

    // RabbitMQ监听器，监听消息
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg){
        System.out.println("消费者收到了simple.queue的消息：【" + msg + "】");
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1 work.queue的消息：【" + msg + "】");
        Thread.sleep(20);
    }


    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2 收到了work.queue的消息......：【" + msg + "】");
        Thread.sleep(200);
    }
}
