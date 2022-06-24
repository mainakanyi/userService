package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserServiceApplication.class, args);
        //Below statements will list all beans
//        ApplicationContext apc = SpringApplication.run(UserServiceApplication.class, args);
//
//        for(String s: apc.getBeanDefinitionNames()){
//          System.out.println(s);
//        }
    }

}
