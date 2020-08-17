package com.bank.management.customermanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.model.request.UserRequest;

@RunWith(MockitoJUnitRunner.class)
public class UserRequestTest {
	
	@InjectMocks
	UserRequest obj;
	
	@Test
	public void getStatusTest() {
		obj.getStatus();
	}

}
