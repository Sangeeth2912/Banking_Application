package com.bank.management.internalaccount;

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

import com.bank.management.internaldetails.daoImpl.InternalDetailDaoImpl;
import com.bank.management.internaldetails.model.request.InternalDetailsRequest;
import com.bank.management.internaldetails.model.response.InternalDetailsResponse;
@RunWith(MockitoJUnitRunner.class)
public class InternalDetailDaoImplTest 
{
	@InjectMocks
	@Spy
	InternalDetailDaoImpl obj;
	
	@Mock
	ResultSet rs;

	@Mock
	Statement stmt;

	@Mock
	DriverManager dm;

	@Mock
	Connection cn;
	
	@Mock
	InternalDetailsRequest req;
	
	@Before
	public void initMocks() {
	}
	
	@Test
	public void fetchDetailsTest() throws SQLException
	{
		InternalDetailsRequest req=new InternalDetailsRequest();
		req.setCustomer_id(123);
		Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.doReturn("password").when(obj).cardNumMasking(Mockito.anyString());
		Mockito.when(rs.getInt(1)).thenReturn(123);
		Mockito.when(rs.getString(2)).thenReturn("Test");
		Mockito.when(rs.getString(3)).thenReturn("password");
		obj.fetchDetails(req);
	}
	
	@Test
	public void fetchDetailsTest1() throws SQLException
	{
		InternalDetailsRequest req=new InternalDetailsRequest();
		req.setCustomer_id(123);
		Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		obj.fetchDetails(req);
	}
	
	@Test
	public void getcardNumMaskingTest() {
		Mockito.when(obj.cardNumMasking("UfsOb89SvYVLyUhjjYjzCibbBYrByXyHpmo0QTXw/Q8=")).thenReturn("cardno");
		obj.cardNumMasking("UfsOb89SvYVLyUhjjYjzCibbBYrByXyHpmo0QTXw/Q8=");
	}
	
	@Test
	public void getconnDetailsTest() {
		obj.getconnDetails();
	}
	
	
}
