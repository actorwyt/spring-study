package pers.wyt.springstudy.spring.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.wyt.springstudy.spring.dubbo.api.service.ServiceDemo;

/**
 * @Author: wanyutong
 * @Date: 2018/12/7
 * @Description:
 */
public class ConsumerBootstrap {
    public static void main(String [] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ServiceDemo serviceDemo = (ServiceDemo) context.getBean("serviceDemo");
        String greetMessage = serviceDemo.helloWorld("Eric");
        System.out.println("Consumer ==> " + greetMessage);
        context.destroy();
    }
}
