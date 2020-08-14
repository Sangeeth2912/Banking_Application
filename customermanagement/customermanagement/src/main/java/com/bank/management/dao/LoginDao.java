package com.bank.management.dao;

import com.bank.management.model.request.UserRequest;
import com.bank.management.model.response.UserResponse;

public interface LoginDao 
{
	public UserResponse getLoginDetails(UserRequest user);
}
