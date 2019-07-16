package com.qf.java1902;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class HoutaishouyeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoutaishouyeApplication.class, args);
	}

}
