package com.bank.management.internaldetails.dao;

import com.bank.management.internaldetails.model.request.InternalDetailsRequest;
import com.bank.management.internaldetails.model.response.InternalDetailsResponse;

public interface InternalDetailDao 
{
	public InternalDetailsResponse fetchDetails(InternalDetailsRequest req);
}
