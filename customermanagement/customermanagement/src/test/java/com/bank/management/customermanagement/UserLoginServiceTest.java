package com.bank.management.customermanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.daoImpl.GetLoginUserDao;
import com.bank.management.model.request.UserRequest;
import com.bank.management.model.response.UserResponse;
import com.bank.management.serviceImpl.UserLoginService;

@RunWith(MockitoJUnitRunner.class)
public class UserLoginServiceTest {

	@InjectMocks
	UserLoginService obj;
	
	@Mock
	GetLoginUserDao dao;
	
	@Test
	public void getUserLoginTest() {
		Mockito.when(dao.getLoginDetails(Mockito.any())).thenReturn(new UserResponse());
		obj.getUserLogin(new UserRequest());
	}
	
}
