package com.bank.management.fetchaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.fetchaccount.model.response.InternalDetailsResponse;

@RunWith(MockitoJUnitRunner.class)
public class InternalDetailsResponseTest {
	
	@InjectMocks
	InternalDetailsResponse req;
	
	@Test
	public void getStatus_codeTest()
	{
		req.getStatus_code();
	}
	@Test
	public void setStatus_codeTest()
	{
		req.setStatus_code("test");
	}
	@Test
	public void getCustomer_idTest()
	{
		req.getCustomer_id();
	}
	@Test
	public void setCustomer_idTest()
	{
		req.setCustomer_id(123);
	}
	@Test
	public void getCustomer_nameTest()
	{
		req.getCustomer_name();
	}
	@Test
	public void setCustomer_nameTest()
	{
		req.setCustomer_name("test");
	}
	@Test
	public void getPasswordTest()
	{
		req.getPassword();
	}
	@Test
	public void setPasswordTest()
	{
		req.setPassword("test");
	}
	@Test
	public void getStatusTest()
	{
		req.getStatus();
	}
	@Test
	public void setStatusTest()
	{
		req.setStatus(123);
	}
	@Test
	public void getSession_tokenTest()
	{
		req.getSession_token();
	}
	@Test
	public void setSession_tokenTest()
	{
		req.setSession_token("test");
	}
	@Test
	public void getAccount_numberTest()
	{
		req.getAccount_number();
	}
	@Test
	public void setAccount_numberTest()
	{
		req.setAccount_number("test");
	}
	@Test
	public void getAccount_balanceTest()
	{
		req.getAccount_balance();
	}
	@Test
	public void setAccount_balanceTest()
	{
		req.setAccount_balance(123);
	}
}
