package com.bank.management.internaldetails.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.bank.management.internaldetails.dao.InternalDetailDao;
import com.bank.management.internaldetails.model.request.InternalDetailsRequest;
import com.bank.management.internaldetails.model.response.InternalDetailsResponse;
import com.bank.management.internaldetails.utils.CryptoUtil;
@Service
@Component
public class InternalDetailDaoImpl implements InternalDetailDao
{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/customer";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "July@2020";
	InternalDetailsResponse response=new InternalDetailsResponse();
	@Override
	public InternalDetailsResponse fetchDetails(InternalDetailsRequest req) 
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
				sql="select * from internal_customer_details where customer_id="+req.getCustomer_id();
				rs = stmt.executeQuery(sql);
				boolean count=rs.next();
				if(count)
				{
					maskedAccno=cardNumMasking(rs.getString(3));
					response.setStatus(1);
					response.setCustomer_id(rs.getInt(1));
					response.setCustomer_name(rs.getString(2));
					if(!maskedAccno.isEmpty())
					response.setAccount_number(maskedAccno);
					response.setAccount_balance(rs.getInt(4));
					response.setStatus_code("Internal Data Fetched Successfully");
				}
				else
				{
					response.setStatus(0);
					response.setStatus_code("Internal Data Fetching Failed");
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
	
	
	public String cardNumMasking(String accNo)
	{
		String encryptedString = CryptoUtil.decrypt(accNo, "customer@123") ;
		String maskedAcc=maskString(encryptedString, 0, 12, '*');
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

	
