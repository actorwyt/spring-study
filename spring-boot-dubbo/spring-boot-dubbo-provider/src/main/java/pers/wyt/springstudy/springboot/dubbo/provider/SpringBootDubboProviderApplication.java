package pers.wyt.springstudy.springboot.dubbo.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringBootDubboProviderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootDubboProviderApplication.class)
                .web(false)
                .run(args);
    }
}
