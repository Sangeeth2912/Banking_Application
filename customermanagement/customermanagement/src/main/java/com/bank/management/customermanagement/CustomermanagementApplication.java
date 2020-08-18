package com.bank.management.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan({"com.bank.management"})
@EnableDiscoveryClient
@EnableFeignClients
public class CustomermanagementApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(CustomermanagementApplication.class, args);
	}

}
