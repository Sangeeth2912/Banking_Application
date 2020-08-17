package com.bank.management.internalaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.internaldetails.dao.InternalDetailDao;
import com.bank.management.internaldetails.model.request.InternalDetailsRequest;
import com.bank.management.internaldetails.model.response.InternalDetailsResponse;
import com.bank.management.internaldetails.serviceImpl.InternalDetailServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class InternalDetailServiceImplTest {
	
	@InjectMocks
	InternalDetailServiceImpl obj;
	
	@Mock
	InternalDetailDao dao;
	
	@Test
	public void fetchDetails()
	{
		Mockito.when(dao.fetchDetails(Mockito.any())).thenReturn(new InternalDetailsResponse());
		obj.fetchDetails(new InternalDetailsRequest());
	}
}
