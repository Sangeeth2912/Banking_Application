package com.bank.management.externaldetails.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.management.externaldetails.dao.ExternalDetailDao;
import com.bank.management.externaldetails.model.request.ExternalDetailsRequest;
import com.bank.management.externaldetails.model.response.ExternalDetailsResponse;
import com.bank.management.externaldetails.utils.CryptoUtil;
@Service
@Component
public class ExternalDetailDaoImpl implements ExternalDetailDao
{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/customer";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "July@2020";
	ExternalDetailsResponse response=new ExternalDetailsResponse();
	@Override
	public ExternalDetailsResponse fetchDetails(ExternalDetailsRequest req) 
	{
		ResultSet rs=null;
		Statement stmt=null;
		Connection conn = null;
		String maskedAccno=null;
		try{
			stmt=getconnDetails();
			String sql;
			if(req.getCustomer_id() != null)
			{
				sql="select * from external_customer_details where customer_id="+req.getCustomer_id();
				rs = stmt.executeQuery(sql);
				boolean count=rs.next();
				if(count)
				{
					maskedAccno=cardNumMasking(rs.getString(3));
					response.setStatus(1);
					response.setExt_account_number(maskedAccno);
					response.setExt_account_balance(rs.getInt(4));
					response.setBranch_name(rs.getString(5));
					response.setStatus_code("External Data Fetched Successfully");
				}
				else
				{
					response.setStatus(0);
					response.setCustomer_id(0);
					response.setCustomer_name("");
					response.setExt_account_number("");
					response.setExt_account_balance(0);
					response.setStatus_code("External Data Fetching Failed");
				}
			}
		}
			catch(SQLException se){
				se.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		finally{
			try{

				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
			
		return response;
	}
	
	@Override
	public ExternalDetailsResponse addDetails(ExternalDetailsRequest req) 
	{
		Statement stmt=null;
		Connection conn = null;
		String encAccno=null;
		try
		{
			stmt=getconnDetails();
			String sql;
			if(req.getCustomer_id() != null)
			{
			    encAccno=CryptoUtil.encrypt(req.getAccount_number(), "customer@123");
				sql="Insert INTO external_customer_details(customer_id, customer_name,account_number,account_balance)"+"values"+"("+((req.getCustomer_id()+","+"'"+req.getCustomer_name()+"'"+","+"'"+encAccno+"'"+","+req.getAccount_balance()))+")";
				int updateStatus = stmt.executeUpdate(sql);
				if(updateStatus==1)
				{
					response.setStatus(1);
					response.setExt_account_balance(req.getAccount_balance());
					response.setStatus_code("Data Added Successfully");
				}
				else
				{
					response.setStatus(0);
					response.setStatus_code("Data Adding Failed");
				}
			}
		}
			catch(SQLException se){
				se.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		finally{
			try{

				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
			
		return response;
	}
	
	@Override
	public ExternalDetailsResponse updateDetails(ExternalDetailsRequest req) 
	{
		Statement stmt=null;
		Connection conn = null;
		try
		{
			stmt=getconnDetails();
			String sql;
			if(req.getCustomer_id() != null)
			{
				sql="update external_customer_details set customer_name="+"'"+req.getCustomer_name()+"',"+"account_balance="+req.getAccount_balance()+" "+"where customer_id="+req.getCustomer_id();
				int updateStatus = stmt.executeUpdate(sql);
				if(updateStatus==1)
				{
					response.setStatus(1);
					response.setExt_account_balance(req.getAccount_balance());
					response.setStatus_code("Data updated Successfully");
				}
				else
				{
					response.setStatus(0);
					response.setStatus_code("Data updation Failed");
				}
			}
		}
			catch(SQLException se){
				se.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		finally{
			try{

				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
			
		return response;
	}
	
	public Statement getconnDetails()
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return stmt;
	}

	@Override
	public ExternalDetailsResponse deleteDetails(ExternalDetailsRequest req)
	{
		Statement stmt=null;
		Connection conn = null;
		try
		{
			stmt=getconnDetails();
			String sql;
			if(req.getCustomer_id() != null)
			{
				sql="Delete from external_customer_details where customer_id="+req.getCustomer_id();
				int updateStatus = stmt.executeUpdate(sql);
				if(updateStatus==1)
				{
					response.setStatus(1);
					response.setStatus_code("Data Deleted Successfully");
				}
				else
				{
					response.setStatus(0);
					response.setStatus_code("Data Deleted Failed");
				}
			}
		}
			catch(SQLException se){
				se.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		finally{
			try{

				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
			
		return response;
	}

	
	public String cardNumMasking(String accNo)
	{
		String decryptedString = CryptoUtil.decrypt(accNo, "customer@123") ;
		String maskedAcc=maskString(decryptedString, 0, 12, '*');
		return maskedAcc;
		
	}

	private String maskString(String strText, int start, int end, char maskChar) 
	{
		int maskLength = end - start;
        if(maskLength == 0)
        return strText;
        StringBuilder sbMaskString = new StringBuilder(maskLength);
        for(int i = 0; i < maskLength; i++){
            sbMaskString.append(maskChar);
        }
        return strText.substring(0, start) 
            + sbMaskString.toString() 
            + strText.substring(start + maskLength);
    }
 
}
