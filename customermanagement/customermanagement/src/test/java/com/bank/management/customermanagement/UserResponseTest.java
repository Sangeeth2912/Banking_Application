package com.bank.management.customermanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.model.response.UserResponse;

@RunWith(MockitoJUnitRunner.class)
public class UserResponseTest {

	@InjectMocks 
	UserResponse obj;
	
	@Test
	public void getSession_tokenTest() {
		obj.getSession_token();
	}
	
	@Test
	public void getStatuscodeTest() {
		obj.getStatuscode();
	}
	
	@Test
	public void getUser_idTest() {
		obj.getUser_id();
	}
	
	@Test
	public void setUser_idTest() {
		obj.setUser_id(1);
	}
	
	@Test
	public void getUser_nameTest() {
		obj.getUser_name();
	}
	
	@Test
	public void setUser_nameTest() {
		obj.setUser_name("user");
	}
	
	@Test
	public void getPasswordTest() {
		obj.getPassword();
	}
	
	@Test
	public void setPasswordTest() {
		obj.setPassword("password");
	}
	
	@Test
	public void getStatusTest() {
		obj.getStatus();
	}
	
	
}
