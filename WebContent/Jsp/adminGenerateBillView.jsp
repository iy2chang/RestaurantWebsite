<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.tcs.ilp.bean.Bill" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Orders</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<body>


<div id ="templatemo_container">

	<%@ include file="/Jsp/adminMenu.jsp"%>

	<div id="templatemo_topsection"> Order Management System : View All Orders</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	
	<div id="form">

		<fieldset>

	<div class="CSSTableGenerator" >
		<table>
		
		<caption>Menu Items</caption>

			<tr>
				<th>Order Id</th>
				<th>User Id</th>
				<th>Customer Name</th>
				<th>Customer Address</th>
				<th>Cell Number</th>
				<th>Email</th>
				<th>Zip Code</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Payment Type</th>
				<th>Delivery Address</th>
				<th>Delivery Date</th>	
				<th>Landmark</th>
				
		
				
							

			</tr>
			<tr>
		
<%
	Bill b = (Bill)request.getAttribute("bill"); 
%>


				<td><%=b.getOrders_id()%></td>
				<td><%=b.getUser_id()%></td>
				<td><%= b.getCustomer_name()%></td>
				<td><%= b.getAddress()%></td>
				<td><%=b.getCell_number()%></td>
				<td><%=b.getEmail()%></td>
				<td><%=b.getZipCode()%></td>
				<td><%=b.getPrice()%></td>
				<td><%=b.getQuantity()%></td>
				<td><%= b.getPayment_type()%></td>
				<td><%=b.getDelivery_address()%></td>
				<td><%=b.getDelivery_date()%></td>
				<td><%=b.getLandMark()%></td>
				
			</tr>
			
			</table>
		</div>
		</fieldset>
				
		</div>

<div id="templatemo_footer1">
  
  
</div>		

	
</body>
</html>