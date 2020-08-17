package com.bank.management.fetch.client;

import javax.annotation.Resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.bank.management.fetch.model.SessionDetails;
@Service
@Component
@Resource
@FeignClient(name="customermanagement")
public interface SessionInterface
{
	@RequestMapping(value="/sessionValidation", method = RequestMethod.GET)
	public SessionDetails getSessionInfo(@RequestParam("token") String token);
	
}

