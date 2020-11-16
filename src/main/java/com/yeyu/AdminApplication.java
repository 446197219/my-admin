package com.yeyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.yeyu.dao")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.yeyu.AdminApplication.class, args);
    }

}
