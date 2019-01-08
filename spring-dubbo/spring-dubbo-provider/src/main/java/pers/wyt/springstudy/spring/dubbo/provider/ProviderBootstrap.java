package pers.wyt.springstudy.spring.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author: wanyutong
 * @Date: 2018/12/7
 * @Description:
 */
public class ProviderBootstrap {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "provider.xml");
        context.start();
        System.in.read();
    }
}
