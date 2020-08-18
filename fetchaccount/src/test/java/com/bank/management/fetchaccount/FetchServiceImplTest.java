package com.bank.management.fetchaccount;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.fetchaccount.dao.FetchDetailDao;
import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;
import com.bank.management.fetchaccount.model.response.FetchDetailsResponse;
import com.bank.management.fetchaccount.serviceImpl.FetchServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FetchServiceImplTest {
	
	@InjectMocks
	FetchServiceImpl obj;
	
	@Mock
	FetchDetailDao dao;
	
	@Test
	public void fetchDetails()
	{
		Mockito.when(dao.fetchDetails(Mockito.any())).thenReturn(new FetchDetailsResponse());
		obj.fetchDetails(new FetchDetailsRequest());
	}

}
