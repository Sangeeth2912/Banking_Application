package com.bank.management.externaldetails.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bank.management.externaldetails.session")
@EnableDiscoveryClient
public class ExternalaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExternalaccountApplication.class, args);
	}

}
