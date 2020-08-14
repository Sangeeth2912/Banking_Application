package com.bank.management.externaldetails.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.management.externaldetails.model.request.ExternalDetailsRequest;
import com.bank.management.externaldetails.model.response.ExternalDetailsResponse;



@Service
@Component
@Resource
public interface ExternalDetailService 
{
	public ExternalDetailsResponse fetchDetails(ExternalDetailsRequest req);
	public ExternalDetailsResponse addDetails(ExternalDetailsRequest req);
	public ExternalDetailsResponse updateDetails(ExternalDetailsRequest req);
	public ExternalDetailsResponse deleteDetails(ExternalDetailsRequest req);
}
