package com.bank.management.internalaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.internaldetails.controller.InternalAccDetailsController;
import com.bank.management.internaldetails.model.request.InternalDetailsRequest;
import com.bank.management.internaldetails.model.response.InternalDetailsResponse;
import com.bank.management.internaldetails.service.InternalDetailService;
import com.bank.management.internaldetails.session.SessionService;
import com.bank.management.internaldetails.utils.TokenUtilJwt;

@RunWith(MockitoJUnitRunner.class)
public class InternalAccDetailsControllerTest
{
	@InjectMocks
	InternalAccDetailsController obj;
	
	@Mock
	TokenUtilJwt tokenUtil;
	
	@Mock
	InternalDetailService internalDetailService;
	
	@Mock
	SessionService sessionService;
	
	@Test
	public void fetchAccountDetailsTest()
	{
		InternalDetailsRequest req=new InternalDetailsRequest();
		InternalDetailsResponse response=new InternalDetailsResponse();
		req.setCustomer_id(123);
		req.setPassword("password");
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Valid");
		Mockito.when(internalDetailService.fetchDetails(req)).thenReturn(response);
		obj.fetchAccountDetails("token", req);
	}
	
	
	@Test
	public void sessionExpiredTest()
	{
		InternalDetailsRequest req=new InternalDetailsRequest();
		req.setCustomer_id(123);
		req.setPassword("password");
		Mockito.when(sessionService.getSessionInfo("token")).thenReturn("Session is Invalid");
		obj.fetchAccountDetails("token", req);
	}
	
}
