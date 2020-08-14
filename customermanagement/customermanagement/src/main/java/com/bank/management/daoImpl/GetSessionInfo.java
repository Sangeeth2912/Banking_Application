package com.bank.management.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.bank.management.dao.SessionDao;
import com.bank.management.utils.TokenUtilJwt;
@Service
@Component
public class GetSessionInfo implements SessionDao
{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/customer";
	static final String USER = "root";
	static final String PASS = "July@2020";
	TokenUtilJwt tokenUtil=new TokenUtilJwt();
	GetLoginUserDao userinfo=new GetLoginUserDao();
	@Override
	public String getSessionDetails(String token)
	{
		ResultSet rs=null;
		Statement stmt=null;
		Connection conn = null;
		String sql;
		String response = null;
		try{
			stmt=userinfo.getconnDetails();
			sql="select updated_date,user_id from user_login where session_token="+"'"+token+"'";
			rs = stmt.executeQuery(sql);
			rs.next();
			String time=rs.getString(1);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(time);
			Timestamp timeStampDate = new Timestamp(date.getTime());
			int user_id=rs.getInt(2);
			Date currentdate= new Date();
			long currentTime = currentdate.getTime();
			Timestamp ts = new Timestamp(currentTime);
			long timediff=(ts.getTime()/1000)-(timeStampDate.getTime()/1000);
			if(timediff<tokenUtil.JWT_TOKEN_VALIDITY)
			{
				response="Session is Valid";
			}
			else
			{
				response="Session Expired";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
}
