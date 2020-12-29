package com.mounesh.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mounesh.resources", "com.mounesh.service"})
@EnableEurekaClient
public class SpringBootEmployeeAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmployeeAccountApplication.class, args);
    }

}
