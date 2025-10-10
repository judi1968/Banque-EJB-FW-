package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.project.entity"}) // ou le package de vos entités
@EnableJpaRepositories("com.project.repository")
public class BanqueClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(BanqueClientApplication.class, args);
    }
}
