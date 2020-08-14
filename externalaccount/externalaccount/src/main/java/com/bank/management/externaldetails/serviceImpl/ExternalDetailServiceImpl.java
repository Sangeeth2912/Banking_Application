package com.bank.management.externaldetails.serviceImpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.management.externaldetails.dao.ExternalDetailDao;
import com.bank.management.externaldetails.model.request.ExternalDetailsRequest;
import com.bank.management.externaldetails.model.response.ExternalDetailsResponse;
import com.bank.management.externaldetails.service.ExternalDetailService;


@Service
@Component
@Resource
public class ExternalDetailServiceImpl implements ExternalDetailService
{
	@Autowired ExternalDetailDao getExternalDetails;
	
	

	@Override
	public ExternalDetailsResponse fetchDetails(ExternalDetailsRequest req) {
		ExternalDetailsResponse response=getExternalDetails.fetchDetails(req);
		return response;
	}



	@Override
	public ExternalDetailsResponse addDetails(ExternalDetailsRequest req) {
		ExternalDetailsResponse response=getExternalDetails.addDetails(req);
		return response;
	}



	@Override
	public ExternalDetailsResponse updateDetails(ExternalDetailsRequest req) {
		ExternalDetailsResponse response=getExternalDetails.updateDetails(req);
		return response;
	}



	@Override
	public ExternalDetailsResponse deleteDetails(ExternalDetailsRequest req) {
		ExternalDetailsResponse response=getExternalDetails.deleteDetails(req);
		return response;
	}
}
