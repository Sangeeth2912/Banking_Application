package com.bank.management.fetchaccount;

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

import com.bank.management.fetchaccount.daoImpl.FetchDetailDaoImpl;
import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;

@RunWith(MockitoJUnitRunner.class)
public class FetchDetailDaoImplTest 
{
	@InjectMocks
	@Spy
	FetchDetailDaoImpl obj;
	
	@Mock
	ResultSet rs;

	@Mock
	Statement stmt;

	@Mock
	DriverManager dm;

	@Mock
	Connection cn;
	
	@Before
	public void initMocks() {
	}
	
	
	@Test
	public void fetchDetailsTest() throws SQLException
	{
		FetchDetailsRequest req=new FetchDetailsRequest();
		req.customer_id=123;
		Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.when(rs.getInt(2)).thenReturn(123);
		Mockito.when(rs.getString(1)).thenReturn("Test");
		Mockito.when(rs.getString(3)).thenReturn("password");
		obj.fetchDetails(req);
	}
	
	
	@Test
	public void fetchDetailsFailTest() throws SQLException
	{
		FetchDetailsRequest req=new FetchDetailsRequest();
		req.customer_id=123;
		Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(rs.next()).thenReturn(false);
		obj.fetchDetails(req);
	}
	
	@Test
	public void getconnDetailsTest() {
		obj.getconnDetails();
	}
	
}
