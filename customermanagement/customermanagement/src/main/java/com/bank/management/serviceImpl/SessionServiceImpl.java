package com.bank.management.serviceImpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.management.daoImpl.GetSessionInfo;
import com.bank.management.service.SessionService;
@Service
@Component
@Resource
public class SessionServiceImpl implements SessionService{
	@Autowired GetSessionInfo sessionInfo;

	

	@Override
	public String getSession(String token) {
		String response=sessionInfo.getSessionDetails(token);
		return response;
	}

}
