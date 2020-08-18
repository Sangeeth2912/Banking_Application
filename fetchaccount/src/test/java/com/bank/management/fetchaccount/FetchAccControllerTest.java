package com.bank.management.fetchaccount;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.fetchaccount.controller.FetchAccController;
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

@RunWith(MockitoJUnitRunner.class)
public class FetchAccControllerTest {

	@InjectMocks
	FetchAccController obj;
	
	@Mock
	SessionService sessionService;
	
	@Mock
	FetchDetailService fetchService;
	
	@Mock
	InternalClient internalService;
	
	@Mock ExternalClient externalService;
	
	@Mock ExternalDetailsResponse resp;
	
	@Mock  InternalDetailsResponse internalresp;
	

	@Test
	public void fetchAccountDetailsTest()
	{
		Gson gsonObj=new Gson();
		FetchDetailsRequest req=new FetchDetailsRequest();
		CombinedResponse finalResp=new CombinedResponse();
		FetchDetailsResponse fetchresponse =new FetchDetailsResponse();
		fetchresponse.customer_id=123;
		fetchresponse.age=20;
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Valid");
		Mockito.when(fetchService.fetchDetails(req)).thenReturn(fetchresponse);
		Mockito.when(internalService.fetchDetails("token",req)).thenReturn("{response:response}");
		Mockito.when(externalService.fetchDetails("token", req)).thenReturn(resp);
		//Mockito.when(gsonObj.fromJson("", InternalDetailsResponse.class)).thenReturn(internalresp);
		obj.fetchAccountDetails("token", req);
	}
	

	@Test
	public void sessionExpiredTest()
	{
		FetchDetailsRequest req=new FetchDetailsRequest();
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Invalid");
		obj.fetchAccountDetails("token", req);
	}
	
}
