package com.tcs.ilp.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.tcs.ilp.bean.Customer;
import com.tcs.ilp.util.ConnectionFactory;

public class CustomerDAO {


	public int addCustomer(Customer cus)
	{ int count=0;
	Connection con = null;
	PreparedStatement pstmt = null;

	try {
		con= ConnectionFactory.CreateConnection();
		pstmt = con.prepareStatement("INSERT into TEAM3_REGISTERD_CUSTOMER  values(?,?,?,?,?,?,?)");

		pstmt.setString(1, cus.getId());
		pstmt.setString(2, cus.getName());
		pstmt.setString(3, cus.getAddress());
		pstmt.setString(4, cus.getZip());
		pstmt.setString(5, cus.getLandmark());
		pstmt.setLong(6,cus.getCellnumber());
		pstmt.setString(7, cus.getEmail());

		count = pstmt.executeUpdate();
		System.out.println(count);

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

	return count;
	}
	public Customer viewCustomer(String id)
	{ Customer c=null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try{
		con= ConnectionFactory.CreateConnection();
		pstmt = con.prepareStatement("select * from TEAM3_REGISTERD_CUSTOMER where userid=?");

		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		boolean b = rs.next();
		if (!b)
			return new Customer("DEFAULT", "NONE", "Not available", "000000", "None", 1234567890, "notreal@nowhere.org");
		String name= rs.getString("name");
		String add= rs.getString("address");
		String zip= rs.getString("zipcode");
		String ln= rs.getString("landmark");
		long no= rs.getLong("cellnumber");
		String mail= rs.getString("email");
		//	String name= rs.getString("name");


		c= new Customer(id,name,add,zip,ln,no,mail);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{

		try {
			if(con != null)
				con.close();
			if(pstmt!=null)
				pstmt.close();
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	return c;
	}

	public int updateCustomer(Customer  cus)
	{int count =0;
	Connection con = null;
	PreparedStatement pstmt = null;
	try{
		con= ConnectionFactory.CreateConnection();
		pstmt = con.prepareStatement("UPDATE TEAM3_REGISTERD_CUSTOMER set name=?,  address=?,  zipcode=?,  landmark=?, cellnumber=?, email=? where userid = ?");
		pstmt.setString(1,cus.getName());
		pstmt.setString(2,cus.getAddress());
		pstmt.setString(3,cus.getZip());
		pstmt.setString(4,cus.getLandmark());
		pstmt.setLong(5, cus.getCellnumber());
		pstmt.setString(6,cus.getEmail());
		pstmt.setString(7,cus.getId());
		count = pstmt.executeUpdate();
		System.out.println(count);

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
	return count;
	}

}


