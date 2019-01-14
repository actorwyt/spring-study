package pers.wyt.springstudy.springboot.aop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.wyt.springstudy.springboot.aop.annotation.AuthorizationAnnotation;
import pers.wyt.springstudy.springboot.aop.annotation.FinanceEventAnnotation;
import pers.wyt.springstudy.springboot.aop.event.DemoEvent;

/**
 * @Author: wanyutong
 * @Date: 2019/1/3
 * @Description:
 */
@RestController
public class TestController {

    @GetMapping(value = "/hello")
    @AuthorizationAnnotation(roles = {"Hello"})
    @FinanceEventAnnotation(eventClass = DemoEvent.class, idIndex = "0")
    public String hello(Long id) throws Exception{
        return "Hello ID: " + id;
    }
}
