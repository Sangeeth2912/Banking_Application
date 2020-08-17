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
import com.bank.management.daoImpl.GetSessionInfo;

@RunWith(MockitoJUnitRunner.class)
public class GetSessionInfoTest {

	@InjectMocks
	GetSessionInfo obj;
	
	@Mock
	Statement statement;
	
	@Mock
	GetLoginUserDao getLogin;
	
	@Mock
	ResultSet rs;
	
	@Test
	public void getSessionDetailsTest() throws SQLException {
		Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);
		Mockito.doReturn(statement).when(getLogin).getconnDetails();
		Mockito.when(rs.getInt(2)).thenReturn(1);
		Mockito.when(rs.getString(1)).thenReturn("2020-08-15 13:25:11");
		obj.getSessionDetails("token");
	}
	
	@Test
	public void getSessionDetailsTest2() throws SQLException {
		obj.getSessionDetails("token");

	}
	
	
}
