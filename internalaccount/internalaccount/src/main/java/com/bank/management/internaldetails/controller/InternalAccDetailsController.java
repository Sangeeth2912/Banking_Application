package com.bank.management.internaldetails.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.management.internaldetails.model.request.InternalDetailsRequest;
import com.bank.management.internaldetails.model.response.InternalDetailsResponse;
import com.bank.management.internaldetails.utils.TokenUtilJwt;
import com.bank.management.internaldetails.service.InternalDetailService;
import com.bank.management.internaldetails.session.SessionService;
import com.google.gson.Gson;


@Component
@RestController
@ComponentScan({"com.bank.management.internaldetails"})
public class InternalAccDetailsController {
	TokenUtilJwt tokenUtil=new TokenUtilJwt();
	@Autowired InternalDetailService InternalDetailService;
	@Autowired SessionService sessionService;
	@PostMapping(value = "/fetchIntDetails")
	public String fetchAccountDetails(@RequestHeader(value="Authorization") String token,@RequestBody  InternalDetailsRequest req) 
	{
		String resp = null;
		InternalDetailsResponse response = null;
		if(token.isEmpty())
		{
			resp="Invalid Session. Login Again";
		}
		else
		{
		String sessionResponse=sessionService.getSessionInfo(token);
		if(sessionResponse.equalsIgnoreCase("Session is Valid") && !StringUtils.isEmpty(sessionResponse) )
		{
		response=InternalDetailService.fetchDetails(req);
		Gson gsonObj=new Gson();
	    resp=gsonObj.toJson(response);
		}
		else
		{
			resp="Session Expired. Login Again";
		}
		}
		return resp;
		}

}