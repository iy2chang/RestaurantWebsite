package com.tcs.ilp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	
public static Connection CreateConnection() {
	Connection con = null;
		try {
			Class.forName(Constant.DRIVER);
			con = DriverManager.getConnection(Constant.DBURL, Constant.DBUSERNAME, Constant.DBUSERPASSWORD);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	return con;
	
	
}
}