package com.example.configclient;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-01-24
 * Time: 14:23
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@Component
public class MySenderTest extends ConfigclientApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Test
    public void send(){
        amqpTemplate.convertAndSend("MyOrder","delete", "delete Order");
        amqpTemplate.convertAndSend("MyOrder","add", "add Order");
    }
}
