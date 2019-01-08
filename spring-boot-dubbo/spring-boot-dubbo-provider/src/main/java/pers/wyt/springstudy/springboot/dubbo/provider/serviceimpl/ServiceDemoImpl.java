package pers.wyt.springstudy.springboot.dubbo.provider.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import pers.wyt.springstudy.springboot.dubbo.api.service.ServiceDemo;

/**
 * @Author: wanyutong
 * @Date: 2018/12/6
 * @Description:
 */
@Service(
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class ServiceDemoImpl implements ServiceDemo {

    public String helloWorld(String name) {
        return "hello world," + name;
    }
}
