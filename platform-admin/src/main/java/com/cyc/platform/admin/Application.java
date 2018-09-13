package com.cyc.platform.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by huzuxing on 2018/9/12.
 */
@SpringBootApplication(scanBasePackages = {"com.cyc.platform.common.service"})
@EnableTransactionManagement
@MapperScan("com.cyc.platform.common.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
