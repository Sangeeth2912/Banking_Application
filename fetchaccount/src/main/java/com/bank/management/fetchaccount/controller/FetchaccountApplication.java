package com.bank.management.fetchaccount.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bank.management.fetchaccount.session")
public class FetchaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetchaccountApplication.class, args);
	}

}
