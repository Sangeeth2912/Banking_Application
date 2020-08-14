package com.bank.management.fetchaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;
import com.bank.management.fetchaccount.model.response.CombinedResponse;
import com.bank.management.fetchaccount.model.response.ExternalDetailsResponse;
import com.bank.management.fetchaccount.model.response.FetchDetailsResponse;
import com.bank.management.fetchaccount.model.response.InternalDetailsResponse;
import com.bank.management.fetchaccount.service.FetchDetailService;
import com.bank.management.fetchaccount.session.ExternalClient;
import com.bank.management.fetchaccount.session.InternalClient;
import com.bank.management.fetchaccount.session.SessionService;
import com.google.gson.Gson;

import io.netty.util.internal.StringUtil;


@Component
@RestController
@ComponentScan({"com.bank.management.fetchaccount"})
public class FetchAccController
{
	@Autowired FetchDetailService fetchService;
	@Autowired SessionService sessionService;
	@Autowired InternalClient internalService;
	@Autowired ExternalClient externalService;
	@PostMapping(value = "/fetchDetails", consumes = "application/json", produces = "application/json")
	public CombinedResponse fetchAccountDetails(@RequestHeader(value="Authorization") String token,@RequestBody FetchDetailsRequest req) 
	{
		FetchDetailsResponse fetchresponse = null;
		CombinedResponse finalResp=new CombinedResponse();
		if(token.isEmpty())
		{
			finalResp.setSession_Status("Invalid Session. Login Again");
		}
		else
		{
		String response=sessionService.getSessionInfo(token);
		if(response.equalsIgnoreCase("Session is Valid") && !StringUtil.isNullOrEmpty(response) )
		{
		fetchresponse=fetchService.fetchDetails(req);
		String intResponse=internalService.fetchDetails(token,req);
		ExternalDetailsResponse extResponse =externalService.fetchDetails(token, req);
		Gson gsonObj=new Gson();
	    InternalDetailsResponse internalresp=gsonObj.fromJson(intResponse, InternalDetailsResponse.class);
	    finalResp.setCustomer_id(fetchresponse.customer_id);
	    finalResp.setCustomer_name(fetchresponse.customer_name);
	    finalResp.setAge(fetchresponse.age);
	    finalResp.setEmail_id(fetchresponse.email_id);
	    finalResp.setPhone_number(fetchresponse.phone_number);
	    finalResp.setAccount_number(internalresp.getAccount_number());
	    finalResp.setAccount_balance(internalresp.getAccount_balance());
	    finalResp.setSession_Status(internalresp.getStatus_code());
	    finalResp.setExt_account_balance(extResponse.getExt_account_balance());
	    finalResp.setExt_account_number(extResponse.getExt_account_number());
	    finalResp.setBranch_name(extResponse.getBranch_name());
	    finalResp.setSession_Status(extResponse.getStatus_code());

		}
		else
		{
			finalResp.setSession_Status("Session Expired. Login Again");
		}
		}
		return finalResp;
	}
	}
