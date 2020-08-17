package com.bank.management.customermanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.daoImpl.GetSessionInfo;
import com.bank.management.serviceImpl.SessionServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SessionServiceImplTest {

	@InjectMocks 
	SessionServiceImpl obj;
	
	@Mock
	GetSessionInfo sessionInfo;
	
	@Test
	public void getSessionTest() {
		Mockito.when(sessionInfo.getSessionDetails(Mockito.anyString())).thenReturn("value");
		obj.getSession("token");
	}
	
	
}
