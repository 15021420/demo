package com.lvt.demo.config;

import com.lvt.demo.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig{

    @Bean
    public Employee employee() {
        return new Employee();
    }
}
