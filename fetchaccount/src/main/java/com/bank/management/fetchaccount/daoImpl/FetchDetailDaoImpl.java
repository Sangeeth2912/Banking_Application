package com.bank.management.fetchaccount.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bank.management.fetchaccount.dao.FetchDetailDao;
import com.bank.management.fetchaccount.model.request.FetchDetailsRequest;
import com.bank.management.fetchaccount.model.response.FetchDetailsResponse;
@Service
@Component
public class FetchDetailDaoImpl implements FetchDetailDao{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/customer";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "July@2020";
	FetchDetailsResponse response=new FetchDetailsResponse();
	@Override
	public FetchDetailsResponse fetchDetails(FetchDetailsRequest req) {

		ResultSet rs=null;
		Statement stmt=null;
		Connection conn = null;
		try{
			stmt=getconnDetails();
			String sql;
			if(req.customer_id != null)
			{
				sql="select * from customers where customer_id="+req.customer_id;
				rs = stmt.executeQuery(sql);
				boolean count=rs.next();
				if(count)
				{
					response.status=1;
					response.customer_name=(rs.getString(1));
					response.age=(rs.getInt(2));
					response.email_id=rs.getString(3);
					response.phone_number=(rs.getString(4));
					response.customer_id=(rs.getInt(5));
					response.Status_code="Data Fetched Successfully";
				}
				else
				{
					response.status=0;
					response.customer_name="";
					response.age=0;
					response.email_id="";
					response.phone_number="";
					response.customer_id=0;
					response.Status_code="Data Fetching Failed";
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
	
}
