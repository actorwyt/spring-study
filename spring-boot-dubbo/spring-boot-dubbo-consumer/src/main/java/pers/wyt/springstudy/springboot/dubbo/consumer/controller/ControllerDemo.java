package pers.wyt.springstudy.springboot.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.wyt.springstudy.springboot.dubbo.api.service.ServiceDemo;

/**
 * @Author: wanyutong
 * @Date: 2018/12/6
 * @Description:
 */
@RestController
public class ControllerDemo {

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:12345")
    private ServiceDemo serviceDemo;

    @GetMapping("/helloWorld")
    public String helloWorld(@RequestParam String name) {
        return serviceDemo.helloWorld(name);
    }

}

