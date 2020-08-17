package com.bank.management.customermanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.model.request.UserRequest;
import com.bank.management.model.response.UserResponse;
import com.bank.management.service.SessionService;
import com.bank.management.serviceImpl.UserLoginService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	
	@InjectMocks
	CustomerController obj;
	
	@Mock
	UserLoginService service;
	
	@Mock
	SessionService sessionService;

	@Test
	public void userloginTest() {
		UserRequest user = new UserRequest();
		user.setUser_id(123);
		user.setPassword("password");
		user.setStatus(1);
		UserResponse userResponse=new UserResponse();
		Mockito.when(service.getUserLogin(user)).thenReturn(userResponse);
		obj.userlogin(user);
	}
	
	@Test
	public void sessionValidationTest() {
		Mockito.when(sessionService.getSession("token")).thenReturn("Response");
		obj.sessionValidation("token");
	}
}
