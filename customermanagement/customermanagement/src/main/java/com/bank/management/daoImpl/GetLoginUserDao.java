package com.bank.management.daoImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.bank.management.dao.LoginDao;
import com.bank.management.model.request.UserRequest;
import com.bank.management.model.response.UserResponse;
import com.bank.management.utils.TokenUtilJwt;
@Service
@Component
public class GetLoginUserDao implements LoginDao
{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/customer";
	static final String USER = "root";
	static final String PASS = "July@2020";
	UserResponse resp=new UserResponse();
	TokenUtilJwt tokenUtil=new TokenUtilJwt();
	@Override
	public UserResponse getLoginDetails(UserRequest user) {
		ResultSet rs=null;
		Statement stmt=null;
		Connection conn = null;
		int sessionstatus;
		int updateStat;
		try{
			stmt=getconnDetails();
			String sql;
			if(user.getUser_id() != null && user.getPassword()!= null)
			{
				String md5pwd=checkUserIDandPassword(user);
				sql = "SELECT user_id,user_status,password FROM user_login where user_id="+user.getUser_id();
				rs = stmt.executeQuery(sql);
				rs.next();
				int user_id=rs.getInt(1);
				int status=rs.getInt(2);
				String pwd=rs.getString(3);
				if(user_id==user.getUser_id() && pwd.equals(md5pwd) && status==1)
				{
					resp.setStatus(status);
					resp.setStatuscode("User Login Success"); 
					String token=tokenUtil.generateToken(user.getUser_name());
				//	tokenUtil.isTokenExpired(token);
			  	    String updatedQuery=updateSessionDetails(token,user.getUser_id());
					sessionstatus = stmt.executeUpdate(updatedQuery);
					resp.setSession_token(token);
				}
				else if(status==0)
				{
					resp.setStatus(status);
					resp.setStatuscode("Account is blocked. Contact Customer Care");
				}
				else
				{
					sql = "SELECT failed_attempts FROM user_login where user_id="+user.getUser_id()+" "+"AND user_status="+status;
					rs = stmt.executeQuery(sql);
					rs.next();
					int attempt=rs.getInt(1);
					if (attempt>=3)
					{
						sql = "UPDATE user_login SET updated_date=now(),user_status="+0+" where user_id="+user.getUser_id();
						updateStat = stmt.executeUpdate(sql);
						resp.setStatus(0);
						resp.setStatuscode("Account is blocked. Contact Customer Care");
					}
					else
					{
						attempt++;
						sql = "UPDATE user_login SET updated_date=now(),failed_attempts="+attempt+" where user_id="+user.getUser_id();
						updateStat = stmt.executeUpdate(sql);
						resp.setStatus(status);
						resp.setSession_token("");
						resp.setStatuscode("Invalid Credentials"); 
					}
				}
			}
			else
			{
				resp.setStatuscode("User Id or Password cannot be null");
			}
		}catch(SQLException se){
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
		return resp;
		
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

	public String checkUserIDandPassword(UserRequest user)
	{
		try { 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			byte[] messageDigest = md.digest(user.getPassword().getBytes()); 
			BigInteger no = new BigInteger(1, messageDigest); 
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		}  
		catch (NoSuchAlgorithmException e) 
		{ 
			throw new RuntimeException(e); 
		}

	}
	public String updateSessionDetails(String token,int userid)
	{
		String sql ;
		sql = "UPDATE user_login SET updated_date=now(),session_token="+"'"+token+"'"+" WHERE user_id="+userid;
		return sql;
	}

	
}

