package com.bank.management.externaldetails.session;

import javax.annotation.Resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Component
@Resource
@FeignClient(name="customermanagement",url="http://localhost:8081")
public interface SessionService {
	@RequestMapping(value="/sessionValidation", method = RequestMethod.GET)
	public String getSessionInfo(@RequestParam("token") String token);
}
