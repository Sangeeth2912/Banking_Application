package com.bank.management.internaldetails.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bank.management.internaldetails.session")
public class InternalaccountApplication {
	public static void main(String[] args) {
		SpringApplication.run(InternalaccountApplication.class, args);
	}

}
