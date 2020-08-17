package com.bank.management.customermanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.daoImpl.GetLoginUserDao;
import com.bank.management.model.request.UserRequest;

@RunWith(MockitoJUnitRunner.class)
public class GetLoginUserDaoTest {

	@InjectMocks
	@Spy
	GetLoginUserDao obj;

	@Mock
	GetLoginUserDao login;

	@Mock
	ResultSet rs;

	@Mock
	Statement statement;

	@Mock
	DriverManager dm;

	@Mock
	Connection cn;

	@Mock
	UserRequest user;

	@Before
	public void initMocks() {
		// MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getLoginDetailsTest() throws SQLException {
		UserRequest user = new UserRequest();
		user.setUser_id(123);
		user.setPassword("password");
		user.setStatus(1);

		Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);
		// Mockito.when(cn.createStatement()).thenReturn(statement);
		Mockito.doReturn(statement).when(obj).getconnDetails();
		Mockito.doReturn("password").when(obj).checkUserIDandPassword(user);
		Mockito.when(rs.getInt(1)).thenReturn(123);
		Mockito.when(rs.getInt(2)).thenReturn(1);
		Mockito.when(rs.getString(3)).thenReturn("password");

		obj.getLoginDetails(user);
	}

	@Test
	public void getLoginDetailsTest2() throws SQLException {
		UserRequest user = new UserRequest();
		user.setUser_id(123);
		user.setPassword("password");
		user.setStatus(0);

		Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);
		// Mockito.when(cn.createStatement()).thenReturn(statement);
		Mockito.doReturn(statement).when(obj).getconnDetails();
		Mockito.doReturn("password").when(obj).checkUserIDandPassword(user);
		Mockito.when(rs.getInt(1)).thenReturn(123);
		Mockito.when(rs.getInt(2)).thenReturn(0);
		Mockito.when(rs.getString(3)).thenReturn("password");

		obj.getLoginDetails(user);
	}

	@Test
	public void getLoginDetailsTest3() throws SQLException {
		UserRequest user = new UserRequest();
		user.setUser_id(123);
		user.setPassword("password");
		user.setStatus(0);

		Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);
		// Mockito.when(cn.createStatement()).thenReturn(statement);
		Mockito.doReturn(statement).when(obj).getconnDetails();
		Mockito.doReturn("password").when(obj).checkUserIDandPassword(user);
		Mockito.when(rs.getInt(1)).thenReturn(123);
		Mockito.when(rs.getInt(2)).thenReturn(2);
		Mockito.when(rs.getString(3)).thenReturn("password");

		obj.getLoginDetails(user);
	}

	@Test
	public void getLoginDetailsTest4() throws SQLException {
		UserRequest user = new UserRequest();
		user.setUser_id(123);
		user.setPassword("password");
		user.setStatus(0);

		Mockito.when(statement.executeQuery(Mockito.anyString())).thenReturn(rs);
		// Mockito.when(cn.createStatement()).thenReturn(statement);
		Mockito.doReturn(statement).when(obj).getconnDetails();
		Mockito.doReturn("password").when(obj).checkUserIDandPassword(user);
		Mockito.when(rs.getInt(1)).thenReturn(2);
		Mockito.when(rs.getInt(2)).thenReturn(2);
		Mockito.when(rs.getString(3)).thenReturn("password");

		obj.getLoginDetails(user);
	}

	@Test
	public void getLoginDetailsTest5() throws SQLException {
		UserRequest user = new UserRequest();
		user.setUser_id(null);
		user.setPassword(null);
		user.setStatus(0);
		obj.getLoginDetails(user);
	}

	@Test
	public void getLoginDetailsTest6() throws SQLException {
		UserRequest user = new UserRequest();
		user.setUser_id(123);
		user.setPassword("password");
		user.setStatus(1);
		obj.getLoginDetails(user);
	}
	
	@Test
	public void getLoginDetailsTest7() throws SQLException {
		obj.getLoginDetails(user);
	}

	@Test
	public void getconnDetailsTest() {
		obj.getconnDetails();
	}

	@Test(expected = Exception.class)
	public void checkUserIDandPasswordTest() {
		obj.checkUserIDandPassword(user);
	}

}
