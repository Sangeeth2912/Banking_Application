package com.bank.management.internaldetails.session;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Component
@FeignClient(name="zuul-api-gateway-server/customermanagement")
public interface SessionService {
	@RequestMapping(value="/sessionValidation", method = RequestMethod.GET)
	public String getSessionInfo(@RequestParam("token") String token);
}
