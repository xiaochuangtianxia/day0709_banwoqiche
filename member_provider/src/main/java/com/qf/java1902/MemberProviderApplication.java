package com.qf.java1902;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MemberProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberProviderApplication.class, args);
	}

}
