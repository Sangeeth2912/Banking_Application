package com.bank.management.fetchaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.fetchaccount.model.response.CombinedResponse;

@RunWith(MockitoJUnitRunner.class)
public class CombinedResponseTest 
{
	@InjectMocks
	CombinedResponse req;
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
	@Test
	public void getSession_StatusTest()
	{
		req.getSession_Status();
	}
	@Test
	public void setSession_StatusTest()
	{
		req.setSession_Status("test");
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
	public void getEmail_idTest()
	{
		req.getEmail_id();
	}
	@Test
	public void setEmail_idTest()
	{
		req.setEmail_id("test");
	}
	@Test
	public void getAgeTest()
	{
		req.getAge();
	}
	@Test
	public void setAgeTest()
	{
		req.setAge(123);
	}
	@Test
	public void getPhone_numberTest()
	{
		req.getPhone_number();
	}
	@Test
	public void setPhone_numberTest()
	{
		req.setPhone_number("test");
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

}
