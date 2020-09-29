package com.dozer.sleepcat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.dozer.sleepcat.dao.dao")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SleepcatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleepcatApplication.class, args);
    }

}
