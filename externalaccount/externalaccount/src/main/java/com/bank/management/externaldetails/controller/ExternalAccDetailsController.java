package com.bank.management.externaldetails.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.management.externaldetails.model.request.ExternalDetailsRequest;
import com.bank.management.externaldetails.model.response.ExternalDetailsResponse;
import com.bank.management.externaldetails.service.ExternalDetailService;
import com.bank.management.externaldetails.session.SessionService;
import com.google.gson.Gson;




@Component
@RestController
@ComponentScan({"com.bank.management.externaldetails"})
public class ExternalAccDetailsController {
	@Autowired ExternalDetailService externalDetailService;
	@Autowired SessionService sessionService;
	@PostMapping(
			value = "/fetchExtDetails", consumes = "application/json", produces = "application/json")
	public String fetchAccountDetails(@RequestHeader(value="Authorization") String token,@RequestBody  ExternalDetailsRequest req) 
	{
		String resp = null;
		if(token.isEmpty())
		{
			resp="Invalid Session. Login Again";
		}
		else
		{
		String sessionResponse=sessionService.getSessionInfo(token);
		if(sessionResponse.equalsIgnoreCase("Session is Valid") && !StringUtils.isEmpty(sessionResponse) )
		{
		ExternalDetailsResponse response=externalDetailService.fetchDetails(req);
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

	@PostMapping(
			value = "/addExtDetails", consumes = "application/json", produces = "application/json")
	public String addAccountDetails(@RequestHeader(value="Authorization") String token,@RequestBody  ExternalDetailsRequest req) 
	{
		String resp = null;
		if(token.isEmpty())
		{
			resp="Invalid Session. Login Again";
		}
		else
		{
		String sessionResponse=sessionService.getSessionInfo(token);
		if(sessionResponse.equalsIgnoreCase("Session is Valid") && !StringUtils.isEmpty(sessionResponse) )
		{
		ExternalDetailsResponse response=externalDetailService.addDetails(req);
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
	
	
	@PostMapping(
			value = "/updateExtDetails", consumes = "application/json", produces = "application/json")
	public String updateAccountDetails(@RequestHeader(value="Authorization") String token,@RequestBody  ExternalDetailsRequest req) 
	{
		String resp = null;
		if(token.isEmpty())
		{
			resp="Invalid Session. Login Again";
		}
		else
		{
		String sessionResponse=sessionService.getSessionInfo(token);
		if(sessionResponse.equalsIgnoreCase("Session is Valid") && !StringUtils.isEmpty(sessionResponse) )
		{
		ExternalDetailsResponse response=externalDetailService.updateDetails(req);
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
	
	@PostMapping(
			value = "/deleteAccountDetails", consumes = "application/json", produces = "application/json")
	public String deleteAccountDetails(@RequestHeader(value="Authorization") String token,@RequestBody  ExternalDetailsRequest req) 
	{
		String resp = null;
		if(token.isEmpty())
		{
			resp="Invalid Session. Login Again";
		}
		else
		{
		String sessionResponse=sessionService.getSessionInfo(token);
		if(sessionResponse.equalsIgnoreCase("Session is Valid") && !StringUtils.isEmpty(sessionResponse) )
		{
		ExternalDetailsResponse response=externalDetailService.deleteDetails(req);
		Gson gsonObj=new Gson();
		resp=gsonObj.toJson(response);
		return resp;
		}
		else
		{
			resp="Session Expired. Login Again";
		}
		}
		return resp;
	}
	

}