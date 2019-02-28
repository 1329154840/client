package com.example.configclient.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-01-21
 * Time: 18:55
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@Slf4j
@RestController
@RefreshScope
public class TestController {
    @Value("${env}")
    private String env;


    @RequestMapping("/")
    public String test(HttpServletRequest httpServletRequest){
        String name = "my name is yzy, develop on ";
        log.info(String.valueOf(httpServletRequest.getRemotePort()));
        return name + env;
    }

    @RequestMapping("/login")
    public String login(HttpServletResponse response,
                        HttpServletRequest request,
                        @RequestParam("id") String id){
        log.info("login");
        Cookie checkcookie = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie co:cookies){
                if(String.format("token_%s",id).equals(co.getName())){
                    checkcookie= co;
                    break;
                }
            }
        }
        if (checkcookie==null){
            Cookie cookie = new Cookie(String.format("token_%s",id),"abc");
            cookie.setPath("/");
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            return "new cookie";
        }

        return "ok";
    }


}
