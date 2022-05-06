package com.giantLink.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.giantLink.user",
                "com.giantLink.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.giantLink.clients"
)
public class UserApplication {
    public static  void  main(String[] args){
        SpringApplication.run(UserApplication.class, args);
    }
}
