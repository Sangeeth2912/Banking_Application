package com.bank.management.externaldetails.dao;

import com.bank.management.externaldetails.model.request.ExternalDetailsRequest;
import com.bank.management.externaldetails.model.response.ExternalDetailsResponse;

public interface ExternalDetailDao 
{
	public ExternalDetailsResponse fetchDetails(ExternalDetailsRequest req);
	
	public ExternalDetailsResponse addDetails(ExternalDetailsRequest req);
	
	public ExternalDetailsResponse updateDetails(ExternalDetailsRequest req);
	
	public ExternalDetailsResponse deleteDetails(ExternalDetailsRequest req);
}

