package com.bank.management.internalaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.internaldetails.model.request.InternalDetailsRequest;

@RunWith(MockitoJUnitRunner.class)
public class InternalDetailsRequestTest {

	@InjectMocks
	InternalDetailsRequest req;
	
	@Test
	public void getCustomer_idTest()
	{
		req.getCustomer_id();
	}
	
	@Test
	public void setCustomer_idTest() {
		req.setCustomer_id(123);
	}
	
	@Test
	public void setStatusTest() {
		req.setStatus(1);
	}
	
	
	@Test
	public void getUser_nameTest()
	{
		req.getUser_name();
	}
	
	@Test
	public void setUser_nameTest() {
		req.setUser_name("test");
	}
	
	@Test
	public void getPasswordTest() {
		req.getPassword();
	}
	
	@Test
	public void setPasswordTest() {
		req.setPassword("password");
	}
	
	@Test
	public void getStatusTest() {
		req.getStatus();
	}
	
	
	@Test
	public void getSession_tokenTest()
	{
		req.getSession_token();
	}
	
	@Test
	public void setSession_tokenTest() {
		req.setSession_token("test");
	}
	
}
