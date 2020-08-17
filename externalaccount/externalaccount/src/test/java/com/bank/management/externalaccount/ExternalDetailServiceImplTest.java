package com.bank.management.externalaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.externaldetails.dao.ExternalDetailDao;
import com.bank.management.externaldetails.model.request.ExternalDetailsRequest;
import com.bank.management.externaldetails.model.response.ExternalDetailsResponse;
import com.bank.management.externaldetails.serviceImpl.ExternalDetailServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ExternalDetailServiceImplTest {

	@InjectMocks
	ExternalDetailServiceImpl obj;
	
	@Mock
	ExternalDetailDao dao;
	
	@Test
	public void fetchDetailsTest()
	{
		Mockito.when(dao.fetchDetails(Mockito.any())).thenReturn(new ExternalDetailsResponse());
		obj.fetchDetails(new ExternalDetailsRequest());
	}
	
	@Test
	public void addDetailsTest()
	{
		Mockito.when(dao.addDetails(Mockito.any())).thenReturn(new ExternalDetailsResponse());
		obj.addDetails(new ExternalDetailsRequest());
	}
	
	@Test
	public void updateDetailsTest()
	{
		Mockito.when(dao.updateDetails(Mockito.any())).thenReturn(new ExternalDetailsResponse());
		obj.updateDetails(new ExternalDetailsRequest());
	}
	
	@Test
	public void deleteDetailsTest()
	{
		Mockito.when(dao.deleteDetails(Mockito.any())).thenReturn(new ExternalDetailsResponse());
		obj.deleteDetails(new ExternalDetailsRequest());
	}
}
