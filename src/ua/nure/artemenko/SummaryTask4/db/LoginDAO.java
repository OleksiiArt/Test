package ua.nure.artemenko.SummaryTask4.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.nure.artemenko.SummaryTask4.db.entity.LoginBean;

public class LoginDAO {
	
	public String authenticateUser(LoginBean loginBean) throws Exception
	{
	 String login = loginBean.getLogin();
	 String password = loginBean.getPassword();
	 
	 Connection con = null;
	 Statement statement = null;
	 ResultSet resultSet = null;
	 
	 String loginDB = "";
	 String passwordDB = "";
	 String roleDB = "";
	 
	 try
	 {
	 con = DBManager.getInstance().getConnection();
	 statement = con.createStatement();
	 resultSet = statement.executeQuery(Constants.SQL_FIND_USER_BY_LOGIN);
	 System.out.println("DAO|");
	 
	 while(resultSet.next())
	 {
	 loginDB = resultSet.getString("login");
	 passwordDB = resultSet.getString("password");
	 roleDB = resultSet.getString("role_id");
	 
	 if(login.equals(loginDB) && password.equals(passwordDB) && roleDB.equals("1"))
	 return "administrator_Role";
	 else if(login.equals(loginDB) && password.equals(passwordDB) && roleDB.equals("2"))
	 return "dispatcher_Role";
//	 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
//	 return "User_Role";
	 }
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return "Invalid user credentials";
	}

}
