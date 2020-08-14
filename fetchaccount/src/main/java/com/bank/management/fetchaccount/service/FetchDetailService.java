package com.bank.management.fetchaccount.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;
import com.bank.management.fetchaccount.model.response.FetchDetailsResponse;

@Service
@Component
@Resource
public interface FetchDetailService 
{
	public FetchDetailsResponse fetchDetails(FetchDetailsRequest req);
}
