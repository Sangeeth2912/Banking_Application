package com.bank.management.fetchaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.fetchaccount.model.response.ExternalDetailsResponse;

@RunWith(MockitoJUnitRunner.class)
public class ExternalDetailsResponseTest {
	
	@InjectMocks
	ExternalDetailsResponse req;
	
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
	public void getExt_account_numberTest()
	{
		req.getExt_account_number();
	}
	@Test
	public void setExt_account_numberTest()
	{
		req.setExt_account_number("test");
	}
	@Test
	public void getExt_account_balanceTest()
	{
		req.getExt_account_balance();
	}
	@Test
	public void setExt_account_balanceTest()
	{
		req.setExt_account_balance(123);
	}
	@Test
	public void getBranch_nameTest()
	{
		req.getBranch_name();
	}
	@Test
	public void setBranch_nameTest()
	{
		req.setBranch_name("test");
	}


}
