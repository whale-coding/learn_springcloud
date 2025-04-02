package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: SpringAMQPTest
 * @Date: 2025/4/1 21:17
 * @Author: 聂建强
 * @Description: 测试SpringAMQPT的使用
 */

@SpringBootTest
public class SpringAMQPTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试往队列里面发送消息
     */
    @Test
    public void testSendMessage2Queue(){
        String queueName = "simple.queue";
        String msg = "hello amqp!";

        rabbitTemplate.convertAndSend(queueName,msg);
    }


    /**
     * 往队列里面发送50条消息
     */
    @Test
    public void testWorkQueue() throws InterruptedException {
        String queueName = "work.queue";
        for (int i = 0; i < 50; i++) {
            String msg = "hello worker, message_" + i;
            rabbitTemplate.convertAndSend(queueName,msg);

            Thread.sleep(20);
        }
    }

    /**
     * 往Fanout交换机里面发送消息
     */
    @Test
    public void testSendFanout(){
        String exchangeName = "hmall.fanout";
        String msg = "hello everyone !";

        rabbitTemplate.convertAndSend(exchangeName, null, msg);
    }

    /**
     * 往Direct交换机里面发送消息
     */
    @Test
    public void testSendDirect(){
        String exchangeName = "hmall.direct";
        String msg = "yellow";

        rabbitTemplate.convertAndSend(exchangeName, "yellow", msg);
    }

    /**
     * 往Topic交换机里面发送消息
     */
    @Test
    public void testSendTopic(){
        String exchangeName = "hmall.topic";
        String msg = "hello";

        rabbitTemplate.convertAndSend(exchangeName, "japan.news", msg);
    }

    /**
     * 往队列里面发送Map类型的数据
     */
    @Test
    public void testSendObject(){
        String queueName = "object.queue";

        Map<String,Object> msg = new HashMap<>(2);
        msg.put("name","jack");
        msg.put("age", 21);

        rabbitTemplate.convertAndSend(queueName,msg);
    }

}
