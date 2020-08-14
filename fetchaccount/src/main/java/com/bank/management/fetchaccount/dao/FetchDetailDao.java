package com.bank.management.fetchaccount.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;
import com.bank.management.fetchaccount.model.response.FetchDetailsResponse;

@Service
@Component
public interface FetchDetailDao 
{
	public FetchDetailsResponse fetchDetails(FetchDetailsRequest req);	
}
