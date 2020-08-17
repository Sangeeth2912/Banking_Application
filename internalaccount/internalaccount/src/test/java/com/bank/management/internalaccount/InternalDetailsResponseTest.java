package com.bank.management.internalaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.internaldetails.model.response.InternalDetailsResponse;

@RunWith(MockitoJUnitRunner.class)
public class InternalDetailsResponseTest {

	@InjectMocks 
	InternalDetailsResponse req;
	

	@Test
	public void getStatusTest() {
		req.getStatus();
	}
	
	@Test
	public void setStatusTest() {
		req.setStatus(1);
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
	
	
	@Test
	public void getPasswordTest() {
		req.getPassword();
	}
	
	@Test
	public void setPasswordTest() {
		req.setPassword("password");
	}
	
	@Test
	public void getaccount_numberTest()
	{
		req.getAccount_number();
	}
	
	@Test
	public void setaccount_numberTest() {
		req.setAccount_number("test");
	}
	
	
	@Test
	public void getAccount_balanceTest() {
		req.getAccount_balance();
	}
	
	@Test
	public void setAccount_balanceTest() {
		req.setAccount_balance(1);
	}
	
	
	@Test
	public void getstatus_codeTest() {
		req.getStatus_code();
	}
	
	@Test
	public void setStatus_codeTest() {
		req.setStatus_code("Test");
	}
	
	@Test
	public void getcustomer_nameTest() {
		req.getCustomer_name();
	}
	
	@Test
	public void setcustomer_nameTest() {
		req.setCustomer_name("Test");
	}
	
	@Test
	public void getcustomer_idTest() {
		req.getCustomer_id();
	}
	
	@Test
	public void setcustomer_idTest() {
		req.setCustomer_id(1);
	}
}
