package com.danieltns.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Usecase1Application {

	public static void main(String[] args) {
		SpringApplication.run(Usecase1Application.class, args);
	}

}
