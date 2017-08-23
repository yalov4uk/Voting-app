package com.yalovchuk.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.sql.DataSourceDefinition;

@SpringBootApplication
@ComponentScan(basePackages = "com.yalovchuk")
@EntityScan(basePackages = "com.yalovchuk")
@EnableJpaRepositories("com.yalovchuk")
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}
