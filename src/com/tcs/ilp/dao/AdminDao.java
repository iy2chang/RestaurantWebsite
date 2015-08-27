package com.tcs.ilp.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.tcs.ilp.bean.Admin;
import com.tcs.ilp.util.ConnectionFactory;
import com.tcs.ilp.util.QueryConstants;

public class AdminDao {
	public Admin adminLoginCheck(Admin a){
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String userName = a.getAdmin_id();
		String passWord = a.getAdmin_password();

		try {

			con = ConnectionFactory.CreateConnection();
			stmt = con.prepareStatement(QueryConstants.A_LOGIN);
			stmt.setString(1,userName);
			stmt.setString(2, passWord);
			rs = stmt.executeQuery();

			boolean flag = rs.next();
			if(flag == false){
				System.out.println("hello");
			}
			else{
				String admin_id = rs.getString("ADMIN_ID");
				String admin_pass = rs.getString("ADMIN_PASSWORD");
				if(userName.equals(admin_id) && passWord.equals(admin_pass)){
					a.setValid(true);
				}
			}

			System.out.println("outside");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return a;

	}
}
