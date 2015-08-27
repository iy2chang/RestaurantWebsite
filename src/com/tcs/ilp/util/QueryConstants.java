package com.tcs.ilp.util;

public class QueryConstants 
{
	
	//Admin Queries
	public static final String A_LOGIN ="select * from TEAM3_ADMIN WHERE ADMIN_ID=? AND ADMIN_PASSWORD=?";
	
	//Menu Queries
	public static final String M_ADD="insert into TEAM3_MENU values (?,?,?,?)";
	public static final String M_UPDATE="UPDATE TEAM3_MENU set DESCRIPTION =?, PRICE=? where ITEM=?";
	public static final String M_VIEW=("select CATEGORY,ITEM, DESCRIPTION, PRICE  from TEAM3_MENU where ITEM=?");
	public static final String M_DELETE=("DELETE FROM TEAM3_MENU WHERE ITEM=?");
	public static final String M_VIEWALL=("SELECT*FROM TEAM3_MENU");
	
	public static final String C_ADD="insert into team3_customer_credentials values(?,?)";
	
	public static final String FIND_PASSWORD = "SELECT password FROM team3_customer_credentials WHERE username = ?";
	public static final String CC_INSERT = "INSERT INTO TEAM3_Credit_Card_INFO VALUES (?,?,?,?,?,?,?)";
	
	//Orders Queries
	public static final String O_INSERT = "insert into TEAM3_ORDERS values (?,?,?,?,?,?,?,?)";
	public static final String O_SELECT = "SELECT * FROM TEAM3_ORDERS WHERE ORDERS_ID=?";
	public static final String O_SELECTORDER = "select * from TEAM3_ORDERS order by= ?";
	public static final String O_GETALL_FRONT = "select * from TEAM3_ORDERS INNER JOIN TEAM3_REGISTERD_CUSTOMER " +
			"ON TEAM3_ORDERS.USERID = TEAM3_REGISTERD_CUSTOMER.USERID ORDER BY ";
	public static final String O_GETALL_BACK = " ASC";
	public static final String O_SELECT_ORDER_CUSTOMER = "SELECT * FROM TEAM3_ORDERS WHERE userid=?";
	public static final String O_DELETE = "delete from TEAM3_ORDERS where orders_id=?";
	public static final String O_UPDATE="UPDATE TEAM3_ORDERS set PAYMENT_TYPE =?, delivery_ADDRESS=?, QUANTITY=? where ORDERS_ID=?";
	public static final String O_SELECT_ONE ="select * from TEAM3_ORDERS where orders_id=?";
	
	
	//Generate Bill
	public static final String GENERATE = "SELECT * FROM " +
			"TEAM3_ORDERS O, TEAM3_REGISTERD_CUSTOMER R "+
			"WHERE O.USERID=R.USERID AND O.ORDERS_ID=?";
}
