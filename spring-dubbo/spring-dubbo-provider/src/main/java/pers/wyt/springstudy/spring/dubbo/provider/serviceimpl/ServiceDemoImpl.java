package pers.wyt.springstudy.spring.dubbo.provider.serviceimpl;

import pers.wyt.springstudy.spring.dubbo.api.service.ServiceDemo;

/**
 * @Author: wanyutong
 * @Date: 2018/12/7
 * @Description:
 */
public class ServiceDemoImpl implements ServiceDemo {

    public String helloWorld(String name) {
        return "helloWorld," + name;
    }
}
