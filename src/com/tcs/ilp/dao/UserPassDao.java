package com.tcs.ilp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.tcs.ilp.bean.CustomerCredentials;
import com.tcs.ilp.util.ConnectionFactory;
import com.tcs.ilp.util.QueryConstants;

public class UserPassDao {
	
	public int checkPassword(CustomerCredentials customer){
		
		PreparedStatement pstmt = null;
		Connection con = ConnectionFactory.CreateConnection();;
		int count = 0;		
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(QueryConstants.FIND_PASSWORD);
			pstmt.setString(1, customer.getUserName());		 	
			rs = pstmt.executeQuery();
			if(rs.next()!=false)
				
			System.out.println(rs.getObject("password"));
		    if(customer.getPassWord().equals(rs.getObject("password")))
		    {
		    	count=1;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return 0;
		}				
		finally
			{
				if(con != null)
					try {
						con.close();
						if(pstmt!=null)
							pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
			}
			System.out.println(count);
			return count;	 	
	}
public int addCustomerCredentails(CustomerCredentials customer){
		
		PreparedStatement pstmt = null;
		Connection con = ConnectionFactory.CreateConnection();;
		int count = 0;		
		try {
			pstmt = con.prepareStatement(QueryConstants.C_ADD);
			pstmt.setString(1, customer.getUserName());
			pstmt.setString(2, customer.getPassWord());
			
		    count = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		finally
			{
				if(con != null)
					try {
						con.close();
						if(pstmt!=null)
							pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}			
			}
			//System.out.println(count);
			return count;	 	
	}

}
