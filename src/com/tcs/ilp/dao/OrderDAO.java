package com.tcs.ilp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.tcs.ilp.bean.Bill;
import com.tcs.ilp.bean.Order;
import com.tcs.ilp.util.ConnectionFactory;
import com.tcs.ilp.util.QueryConstants;

public class OrderDAO {

	public ArrayList<Order> getCustomerOrders(String name){
		Connection con = null;
		ArrayList <Order> OrderList = new ArrayList<Order>();


		try {
			con = ConnectionFactory.CreateConnection();
			PreparedStatement pst = con.prepareStatement(
					QueryConstants.O_SELECT_ORDER_CUSTOMER);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				String quantity = rs.getString("QUANTITY");
				String address= rs.getString("DELIVERY_ADDRESS");
				Date deliveryDate = rs.getDate("DELIVERY_DATE");
				String paymentType = rs.getString("PAYMENT_TYPE");
				int price = rs.getInt("PRICE");
				int orderId = rs.getInt("ORDERS_ID");
				String userId = rs.getString("USERID");
				String customerName = rs.getString("CUSTOMER_NAME");

				Order acc = new Order(
						userId, customerName, price, quantity, address, orderId, paymentType, deliveryDate);

				OrderList.add(acc);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return OrderList;
	}

	public ArrayList<Order> getAllOrders(String customer) {
		Connection con = null;
		ArrayList <Order> OrderList = new ArrayList<Order>();

		try {

			con = ConnectionFactory.CreateConnection();

			PreparedStatement pst = con.prepareStatement(
					QueryConstants.O_GETALL_FRONT+customer+QueryConstants.O_GETALL_BACK);

			//pst.setString(1, customer);
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {

				String quantity = rs.getString("QUANTITY");
				String address= rs.getString("DELIVERY_ADDRESS");
				Date deliveryDate = rs.getDate("DELIVERY_DATE");
				String paymentType = rs.getString("PAYMENT_TYPE");
				int price = rs.getInt("PRICE");
				int orderId = rs.getInt("ORDERS_ID");
				String userId = rs.getString("USERID");
				String customerName = rs.getString("CUSTOMER_NAME");


				Order acc = new Order(userId, customerName, price, quantity, address, orderId, paymentType, deliveryDate);

				OrderList.add(acc);
			}
		}

		catch(Exception e){
			System.out.println("Exception occured: " + e);
		}
		finally {
			if(con != null){
				try {
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return OrderList;


	}	
	public Order getOrder(int customer) {
		Connection con = null;
		Order List =null;

		try {

			con = ConnectionFactory.CreateConnection();

			PreparedStatement pst = con.prepareStatement(QueryConstants.O_SELECT_ONE);

			pst.setInt(1, customer);
			ResultSet rs = pst.executeQuery();

			boolean b = rs.next();
			if (!b)
				return new Order();
			
				String quantity = rs.getString("QUANTITY");
				String address= rs.getString("DELIVERY_ADDRESS");
				Date deliveryDate = rs.getDate("DELIVERY_DATE");
				String paymentType = rs.getString("PAYMENT_TYPE");
				int price = rs.getInt("PRICE");
				String userId = rs.getString("USERID");
				String customerName = rs.getString("CUSTOMER_NAME");

				
				List = new Order(userId, customerName, price, quantity, address, customer, paymentType, deliveryDate);
				List.setOrderId(Integer.parseInt(rs.getString("ORDERS_ID")));
				
			
		}

		catch(Exception e){
			System.out.println("Exception occured: " + e);
		}
		finally {
			if(con != null){
				try {
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		return List;


	}	
	public Bill getBill(int orderId){
		Bill b = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			con = ConnectionFactory.CreateConnection();
			pstmt = con.prepareStatement(QueryConstants.GENERATE);

			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String quantity = rs.getString("QUANTITY");
				String delivery_address= rs.getString("DELIVERY_ADDRESS");
				Date deliveryDate = rs.getDate("DELIVERY_DATE");
				String paymentType = rs.getString("PAYMENT_TYPE");
				double price = rs.getInt("PRICE");
				String orders_Id = rs.getString("ORDERS_ID");
				String userId = rs.getString("USERID");
				String customerName = rs.getString("CUSTOMER_NAME");
				String customer_address = rs.getString("ADDRESS");
				String zipCode = rs.getString("ZIPCODE");
				String landMark = rs.getString("LANDMARK");
				long cellNumber = rs.getLong("CELLNUMBER");
				String email = rs.getString("EMAIL");

				b = new Bill(quantity, delivery_address, 
					deliveryDate, paymentType, price, orders_Id, userId,
					customerName, customer_address, zipCode, landMark, cellNumber, email);
				
			}

		} catch (SQLException e) {
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
				e.printStackTrace();
			}
		}
		return b;
	}
	public Order generateBill(int orderNumber)
	{
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			con = ConnectionFactory.CreateConnection();
			pstmt = con.prepareStatement(QueryConstants.O_SELECT);

			pstmt.setInt(1, orderNumber);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String quantity = rs.getString("QUANTITY");
				String address= rs.getString("DELIVERY_ADDRESS");
				Date deliveryDate = rs.getDate("DELIVERY_DATE");
				String paymentType = rs.getString("PAYMENT_TYPE");
				int price = rs.getInt("PRICE");
				int orderId = rs.getInt("ORDERS_ID");
				String userId = rs.getString("USERID");
				String customerName = rs.getString("CUSTOMER_NAME");

				order = new Order(userId, customerName, price, 
						quantity, address, orderId, paymentType, deliveryDate);
				
			}

		} catch (SQLException e) {
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
				e.printStackTrace();
			}
		}
		return order;
	}




	public int generateOrder(Order order) {
		Connection con = null;
		int numberOfAccountsAdded = 0;
		try {
			con = ConnectionFactory.CreateConnection();
			PreparedStatement pst = con.prepareStatement(QueryConstants.O_INSERT);
			pst.setString(1, order.getQuantity());
			pst.setString(2, order.getAddress());
			pst.setDate(3, (java.sql.Date) order.getDeliveryDate());
			pst.setString(4,order.getPaymentType());
			pst.setDouble(5,order.getPrice());
			pst.setInt(6,order.getOrderId());
			pst.setString(7,order.getUserId());
			pst.setString(8,order.getCustomerName());

			numberOfAccountsAdded = pst.executeUpdate();
			con.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con != null)
				try{
					con.close();
				}
			catch(SQLException e ) {
				e.printStackTrace();
			}
		}
		return numberOfAccountsAdded;

	}

	public ArrayList<Order> viewSelectedOrders(String sort)
	{
		Order order = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList <Order> OrderList = new ArrayList<Order>();
		try{

			con = ConnectionFactory.CreateConnection();
			
			pstmt = con.prepareStatement(QueryConstants.O_SELECT_ORDER_CUSTOMER);

			pstmt.setString(1, sort);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				String quantity = rs.getString("QUANTITY");
				String address= rs.getString("DELIVERY_ADDRESS");
				Date deliveryDate = rs.getDate("DELIVERY_DATE");
				String paymentType = rs.getString("PAYMENT_TYPE");
				int price = rs.getInt("PRICE");
				int orderId = rs.getInt("ORDERS_ID");
				String userId = rs.getString("USERID");
				String customerName = rs.getString("CUSTOMER_NAME");


				order = new Order(userId, customerName, price, quantity, address, orderId, paymentType, deliveryDate);
				OrderList.add(order);

			}

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

		return OrderList;
	}

	public int deleteOrder(int id) {
		Connection con = null;
		int numberOfOrdersDeleted = 0;
		try {

			con = ConnectionFactory.CreateConnection();
			PreparedStatement pst = con.prepareStatement(QueryConstants.O_DELETE);

			pst.setInt(1,id);


			numberOfOrdersDeleted = pst.executeUpdate();
			con.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con != null)
				try{
					con.close();
				}
			catch(SQLException e ) {
				e.printStackTrace();
			}
		}
		return numberOfOrdersDeleted;

	}


	public int updateOrder(Order order)
	{
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			con = ConnectionFactory.CreateConnection();
			//stmt = con.createStatement();
			//String query = "INSERT into tbl_student (studentid,name) values("+emp.getId()+",'"+emp.getName()+"')";
			//int count = stmt.executeUpdate(query);
			pstmt = con.prepareStatement(QueryConstants.O_UPDATE);
			pstmt.setString(1, order.getPaymentType());
			pstmt.setString(2, order.getAddress());
			pstmt.setString(3, order.getQuantity());
			pstmt.setInt(4, order.getOrderId());
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
		return count;
	}



}
