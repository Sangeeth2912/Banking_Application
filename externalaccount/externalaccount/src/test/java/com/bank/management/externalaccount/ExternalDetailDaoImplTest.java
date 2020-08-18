package com.bank.management.externalaccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.management.externaldetails.daoImpl.ExternalDetailDaoImpl;
import com.bank.management.externaldetails.model.request.ExternalDetailsRequest;

@RunWith(MockitoJUnitRunner.class)
public class ExternalDetailDaoImplTest 
{
	@InjectMocks
	@Spy
	ExternalDetailDaoImpl obj;
	
	@Mock
	ResultSet rs;

	@Mock
	Statement stmt;

	@Mock
	DriverManager dm;

	@Mock
	Connection cn;
	
	@Mock
	ExternalDetailsRequest req;
	
	@Before
	public void initMocks() {
	}
	
	@Test
	public void fetchDetailsTest() throws SQLException
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(123);
//		Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
		//Mockito.when(rs.next()).thenReturn(true);
		Mockito.doReturn("password").when(obj).cardNumMasking(Mockito.anyString());
		/*Mockito.when(rs.getInt(1)).thenReturn(123);
		Mockito.when(rs.getString(2)).thenReturn("Test");*/
		obj.fetchDetails(req);
	}
	
	@Test
	public void fetchDetailsfailedTest() throws SQLException
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(123);
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(stmt.executeQuery(Mockito.anyString())).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(false);
		obj.fetchDetails(req);
	}
	
	@Test
	public void addDetailsTest() throws SQLException
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(12345);
		req.setAccount_number("5242540200518978");
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(stmt.executeUpdate(Mockito.anyString())).thenReturn(1);
		obj.addDetails(req);
	}
	
	@Test
	public void addDetailsFailTest() throws SQLException
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(12345);
		req.setAccount_number("5242540200518078");
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(stmt.executeUpdate(Mockito.anyString())).thenReturn(0);
		obj.addDetails(req);
	}
	
	@Test
	public void updateDetailsTest() throws SQLException
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(12345);
		req.setAccount_number("5242540200518978");
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(stmt.executeUpdate(Mockito.anyString())).thenReturn(1);
		obj.updateDetails(req);
	}
	
	@Test
	public void updateDetailsFailTest() throws SQLException
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(12345);
		req.setAccount_number("5242540200518078");
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(stmt.executeUpdate(Mockito.anyString())).thenReturn(0);
		obj.updateDetails(req);
	}
	
	@Test
	public void deleteDetailsTest() throws SQLException
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(12345);
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(stmt.executeUpdate(Mockito.anyString())).thenReturn(1);
		obj.deleteDetails(req);
	}
	
	@Test
	public void deleteDetailsFailTest() throws SQLException
	{
		ExternalDetailsRequest req=new ExternalDetailsRequest();
		req.setCustomer_id(12345);
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		Mockito.when(stmt.executeUpdate(Mockito.anyString())).thenReturn(0);
		obj.deleteDetails(req);
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
	
	@Test
	public void fetchDetailsExceptionTest() throws SQLException
	{
		ExternalDetailsRequest req=null;
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		obj.fetchDetails(req);
	}
	@Test
	public void addDetailsExceptionTest() throws SQLException
	{
		ExternalDetailsRequest req=null;
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		obj.addDetails(req);
	}
	@Test
	public void updateDetailsExceptionTest() throws SQLException
	{
		ExternalDetailsRequest req=null;
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		obj.updateDetails(req);
	}
	@Test
	public void deleteDetailsExceptionTest() throws SQLException
	{
		ExternalDetailsRequest req=null;
		Mockito.doReturn(stmt).when(obj).getconnDetails();
		obj.deleteDetails(req);
	}
}
