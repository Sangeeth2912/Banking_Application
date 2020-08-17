package com.bank.management.externalaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.externaldetails.controller.ExternalAccDetailsController;
import com.bank.management.externaldetails.model.request.ExternalDetailsRequest;
import com.bank.management.externaldetails.model.response.ExternalDetailsResponse;
import com.bank.management.externaldetails.service.ExternalDetailService;
import com.bank.management.externaldetails.session.SessionService;

@RunWith(MockitoJUnitRunner.class)
public class ExternalAccDetailsControllerTest 
{
	@InjectMocks
	ExternalAccDetailsController obj;
	
	@Mock
	SessionService sessionService;
	
	@Mock
	ExternalDetailService externalDetailService;
	@Test
	public void fetchAccountDetailsTest()
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		ExternalDetailsResponse response=new ExternalDetailsResponse();
		req.setCustomer_id(123);
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Valid");
		Mockito.when(externalDetailService.fetchDetails(req)).thenReturn(response);
		obj.fetchAccountDetails("token", req);
	}
	
	@Test
	public void fetchSessionExpiredTest()
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(123);
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Invalid");
		obj.fetchAccountDetails("token", req);
	}
	
	@Test
	public void addAccountDetailsTest()
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		ExternalDetailsResponse response=new ExternalDetailsResponse();
		req.setCustomer_id(123);
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is valid");
		Mockito.when(externalDetailService.addDetails(req)).thenReturn(response);	
		obj.addAccountDetails("token", req);
	}
	
	@Test
	public void updateSessionExpiredTest()
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(123);
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Invalid");
		obj.updateAccountDetails("token", req);
	}
	
	@Test
	public void updateAccountDetailsTest()
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		ExternalDetailsResponse response=new ExternalDetailsResponse();
		req.setCustomer_id(123);
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is valid");
		Mockito.when(externalDetailService.updateDetails(req)).thenReturn(response);	
		obj.updateAccountDetails("token", req);
	}
	
	@Test
	public void deleteSessionExpiredTest()
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(123);
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Invalid");
		obj.deleteAccountDetails("token", req);
	}
	
	@Test
	public void deleteAccountDetailsTest()
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		ExternalDetailsResponse response=new ExternalDetailsResponse();
		req.setCustomer_id(123);
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is valid");
		Mockito.when(externalDetailService.deleteDetails(req)).thenReturn(response);	
		obj.deleteAccountDetails("token", req);
	}
}
