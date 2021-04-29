package com.iteyes.apiautomation;

import com.iteyes.apiautomation.controller.MainController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiautomationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiautomationApplication.class, args);
    }

}
