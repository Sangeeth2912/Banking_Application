package com.bank.management.internaldetails.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.management.internaldetails.model.request.InternalDetailsRequest;
import com.bank.management.internaldetails.model.response.InternalDetailsResponse;



@Service
@Component
@Resource
public interface InternalDetailService 
{
	public InternalDetailsResponse fetchDetails(InternalDetailsRequest req);
}
