package pers.wyt.springstudy.springboot.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pers.wyt.springstudy.springboot.aop.service.AuthService;

/**
 * @Author: wanyutong
 * @Date: 2019/1/10
 * @Description:
 */
@SpringBootApplication
public class SpringBootAopApplication implements CommandLineRunner {

    @Autowired
    private AuthService authService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}
