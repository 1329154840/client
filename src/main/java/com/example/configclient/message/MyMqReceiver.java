package com.example.configclient.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-01-24
 * Time: 14:18
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@Component
public class MyMqReceiver {
//    @RabbitListener(queues = "myQueue")
    /**
     * 自动创建Queue，不用手动
     */

    @RabbitListener(bindings = @QueueBinding(exchange = @Exchange("MyOrder"), key = "delete", value = @Queue("deleteQueue")))
    public void deleteProcess(String message){
        log.info("deleteReceiver: {}", message);
    }

    @RabbitListener(bindings = @QueueBinding(exchange = @Exchange("MyOrder"), key = "add", value = @Queue("addQueue")))
    public void addProcess(String message){
        log.info("addReceiver: {}", message);
    }


}
