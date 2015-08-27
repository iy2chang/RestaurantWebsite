package com.tcs.ilp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tcs.ilp.bean.CreditCard;
import com.tcs.ilp.util.ConnectionFactory;
import com.tcs.ilp.util.QueryConstants;

public class CreditCardDAO 
{
	public int addCreditCard(CreditCard cc)
	{
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		int count = -10;
//		try {Class.forName(ConnectionFactory.DRIVER);} catch (ClassNotFoundException e) {e.printStackTrace();}
//		String url = ConnectionFactory.URL;
		try{
		conn = ConnectionFactory.CreateConnection();
//		conn = DriverManager.getConnection(url, ConnectionFactory.USERNAME, ConnectionFactory.PASSWORD);
//		String query = "insert into student(studentid, name) values ("+stud.getSid()+", '"+stud.getName()+"')";
//		stmt = conn.createStatement();
		pstmt = conn.prepareStatement(QueryConstants.CC_INSERT);
		pstmt.setLong(1, cc.getCardNumber());
		pstmt.setString(2, cc.getCardType());
		pstmt.setString(3, cc.getNameOnCard());
		pstmt.setString(4, cc.getIssuer());
		pstmt.setString(5, cc.getExpDate());
		pstmt.setString(6, cc.getCvv());
		pstmt.setString(7, cc.getOrdersID());
		count = pstmt.executeUpdate(); 
		}
		catch (SQLException sqle)
		{
			System.out.println(sqle.toString());
			sqle.printStackTrace();
		}
		finally{
			if (conn!=null)
				try {
					conn.close();
					return count;
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return count;
	}
}
