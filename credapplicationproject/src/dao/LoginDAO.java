package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;
import model.login;

public class LoginDAO 
{
	public boolean checkCredential(login l) throws ClassNotFoundException, SQLException
	{
		//1. get the details from login.java file
		String username = l.getUsername();
		String password = l.getPassword();
		
		//2. jdbc connecton
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.establishConnection();
		
		//3. create the statement
		Statement st=con.createStatement();
		
		//4. write and execute the query
		ResultSet rt = st.executeQuery("select * from login");     //Query execution it is important
		
		//5. check the Username and password ....two user names 
		//login.java and login.table
		while(rt.next())
		{
			if(username.equals(rt.getString("username"))) {
				return true;
			}
		}
			cm.closeConnection();
			return false;
	}
		
	}

