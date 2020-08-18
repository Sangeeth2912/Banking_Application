package com.bank.management.fetchaccount.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bank.management.fetchaccount.session")
@EnableDiscoveryClient
public class FetchaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchaccountApplication.class, args);
	}

}
