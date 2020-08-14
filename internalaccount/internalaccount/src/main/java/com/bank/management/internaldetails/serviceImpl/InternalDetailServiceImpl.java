package com.bank.management.internaldetails.serviceImpl;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.bank.management.internaldetails.dao.InternalDetailDao;
import com.bank.management.internaldetails.model.request.InternalDetailsRequest;
import com.bank.management.internaldetails.model.response.InternalDetailsResponse;
import com.bank.management.internaldetails.service.InternalDetailService;


@Service
@Component
@Resource
public class InternalDetailServiceImpl implements InternalDetailService
{
	@Autowired InternalDetailDao getInternalDetails;
	
	

	@Override
	public InternalDetailsResponse fetchDetails(InternalDetailsRequest req) {
		InternalDetailsResponse response=getInternalDetails.fetchDetails(req);
		return response;
	}
}
