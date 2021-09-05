package com.app.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*
@Configuration
@ComponentScan("com.app.user.repository")
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
@EntityScan("com.app.user") // path of the entity model
@EnableJpaRepositories("com.app.user.controller")*/


public class UserApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);

	System.out.println("hello");
	}
}
