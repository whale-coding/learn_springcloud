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

    // ------------------- Fanout交换机 -------------------

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanOutQueue1(String msg){
        System.out.println("消费者1 fanout.queue1的消息：【" + msg + "】");
    }


    @RabbitListener(queues = "fanout.queue2")
    public void listenFanOutQueue2(String msg) {
        System.err.println("消费者2 收到了fanout.queue2的消息......：【" + msg + "】");
    }

    // ------------------- Direct交换机 -------------------

    @RabbitListener(queues = "direct.queue1")
    public void listenDirectQueue1(String msg){
        System.out.println("消费者1 direct.queue1的消息：【" + msg + "】");
    }


    @RabbitListener(queues = "direct.queue2")
    public void listenDirectQueue2(String msg) {
        System.err.println("消费者2 收到了direct.queue2的消息......：【" + msg + "】");
    }

    // ------------------- Topic交换机 -------------------

    @RabbitListener(queues = "topic.queue1")
    public void listenTopicQueue1(String msg){
        System.out.println("消费者1 topic.queue1的消息：【" + msg + "】");
    }


    @RabbitListener(queues = "topic.queue2")
    public void listenTopicQueue2(String msg) {
        System.err.println("消费者2 topic.queue2的消息......：【" + msg + "】");
    }
}
