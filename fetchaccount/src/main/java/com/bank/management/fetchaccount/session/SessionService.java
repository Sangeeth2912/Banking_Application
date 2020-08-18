package com.bank.management.fetchaccount.session;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="customermanagement")
public interface SessionService {
	@RequestMapping(value="/sessionValidation", method = RequestMethod.GET)
	public String getSessionInfo(@RequestParam("token") String token);
}
