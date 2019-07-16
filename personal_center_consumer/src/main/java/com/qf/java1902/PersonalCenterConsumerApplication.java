package com.qf.java1902;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PersonalCenterConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalCenterConsumerApplication.class, args);
	}

}
