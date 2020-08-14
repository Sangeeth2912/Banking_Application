package com.bank.management.fetchaccount.serviceImpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.management.fetchaccount.dao.FetchDetailDao;
import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;
import com.bank.management.fetchaccount.model.response.FetchDetailsResponse;
import com.bank.management.fetchaccount.service.FetchDetailService;
@Service
@Component
@Resource
public class FetchServiceImpl implements FetchDetailService {

	@Autowired FetchDetailDao getFetchDetails;
	

	@Override
	public FetchDetailsResponse fetchDetails(FetchDetailsRequest req) {
		FetchDetailsResponse response=getFetchDetails.fetchDetails(req);
		return response;
	}

}
