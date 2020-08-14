package com.bank.management.customermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.management.model.request.UserRequest;
import com.bank.management.model.response.UserResponse;
import com.bank.management.service.SessionService;
import com.bank.management.serviceImpl.UserLoginService;
import com.google.gson.Gson;
@Component
@RestController

public class CustomerController {
	@Autowired UserLoginService userLoginService;
	@Autowired SessionService sessionService;
	@PostMapping(
			value = "/login", consumes = "application/json", produces = "application/json")
	public String userlogin(@RequestBody UserRequest user ) 
	{
		UserResponse userResponse=userLoginService.getUserLogin(user);
		Gson gsonObj=new Gson();
		String resp=gsonObj.toJson(userResponse);
		return resp;
	}

	
	@RequestMapping(value="/sessionValidation", method = RequestMethod.GET)
	public String sessionValidation(@RequestParam("token") String token)
	{
		String response=null;
		response=sessionService.getSession(token);
		return response;
		
	}
	

}