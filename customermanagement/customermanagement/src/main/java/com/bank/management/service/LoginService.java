package com.bank.management.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.management.model.request.UserRequest;
import com.bank.management.model.response.UserResponse;
@Service
@Component
@Resource
public interface LoginService {
	
	public UserResponse getUserLogin(UserRequest req);
	
}
