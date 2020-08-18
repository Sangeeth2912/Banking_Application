package com.bank.management.internaldetails.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bank.management.internaldetails.session")
@EnableDiscoveryClient


public class InternalaccountApplication {
	public static void main(String[] args) {
		SpringApplication.run(InternalaccountApplication.class, args);
	}

}
