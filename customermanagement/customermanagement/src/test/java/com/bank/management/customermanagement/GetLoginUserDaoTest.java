package com.bank.management.customermanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.daoImpl.GetLoginUserDao;
import com.bank.management.model.request.UserRequest;

@RunWith(MockitoJUnitRunner.class)
public class GetLoginUserDaoTest {

	@InjectMocks
	GetLoginUserDao obj;
	
	@Mock
	GetLoginUserDao login;
	
	@Mock
	ResultSet rs;
	
	@Mock
	Statement statement;
	
	
	
//	@Mock
//	UserRequest user;
	
	@Test
	public void getLoginDetailsTest() throws SQLException {
		UserRequest user =new UserRequest();
		user.setUser_id(123);
		user.setPassword("test@123");
		user.setStatus(0);
		
		Mockito.when(statement.executeQuery(Mockito.any())).thenReturn(rs);
//		Mockito.when(rs.getInt(1)).thenReturn(123);
//		Mockito.when(rs.getInt(2)).thenReturn(0);
//		Mockito.when(rs.getString(3)).thenReturn("test@123");
		obj.getLoginDetails(user);
	}
	
	
}
