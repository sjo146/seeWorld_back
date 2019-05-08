package com.seeworld.hl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "com.seeworld.hl.dao")
@ComponentScan(basePackages = {"com.seeworld.hl.*"})
public class HlApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlApplication.class, args);
    }

}
