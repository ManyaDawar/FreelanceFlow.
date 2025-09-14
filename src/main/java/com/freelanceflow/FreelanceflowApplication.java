package com.freelanceflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.freelanceflow.controller",
		"com.freelanceflow.service",
		"com.freelanceflow.config",
		"com.freelanceflow.dto"})
@EnableJpaRepositories("com.freelanceflow.repository")
@EntityScan("com.freelanceflow.model")
public class FreelanceflowApplication {
	public static void main(String[] args) {
		SpringApplication.run(FreelanceflowApplication.class, args);
	}
}

