package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.service")
@EntityScan(basePackages = "com.example.entity")
public class ListStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListStudentsApplication.class, args);
	}

}
