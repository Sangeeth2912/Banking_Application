package com.bank.management.serviceImpl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.management.daoImpl.GetLoginUserDao;
import com.bank.management.model.request.UserRequest;
import com.bank.management.model.response.UserResponse;
import com.bank.management.service.LoginService;
@Service
@Component
@Resource
public class UserLoginService implements LoginService{
@Autowired GetLoginUserDao getLoginUserDao;
	@Override
	public UserResponse getUserLogin(UserRequest req) {
		// TODO Auto-generated method stub
		UserResponse response=getLoginUserDao.getLoginDetails(req);
		return response;
	}

	
}
