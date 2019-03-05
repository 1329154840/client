package com.example.configclient.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-02-17
 * Time: 19:53
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@RestController
@Slf4j
public class HystrixController {
    @RequestMapping("/hystrixtest")
    @HystrixCommand(fallbackMethod = "hystrixTestFallBack"
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"),
//                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
//                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "2000"),
//                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
//            }
    )
    public String hystrixTest(@RequestParam("id") String id) {
//        try{
//            TimeUnit.SECONDS.sleep(4);
//        }   catch (Exception e){
//            e.printStackTrace();
//        }
        if(Integer.parseInt(id)%2==0){
            return "successful";
        }
        if (Integer.parseInt(id)%2==1){
            throw new RuntimeException("Exception");
        }
        return "error";
    }

    private String hystrixTestFallBack(String id){
        return "FallBack";
    }
}
