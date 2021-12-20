package com.skysoo.springclouddemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringCloudDemo2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemo2Application.class, args);
    }
}
