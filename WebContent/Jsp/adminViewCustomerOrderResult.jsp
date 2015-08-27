<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="com.tcs.ilp.bean.Order"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customer Order</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/adminOrder.jsp"%>

	<div id="templatemo_topsection"> Order Management System : View Customer Order</div>

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
				<th>Price</th>
				<th>Quantity</th>
				<th>Payment Type</th>
				<th>Delivery Address</th>
				<th>Delivery Date</th>
							

			</tr>
			<tr>
				<%
					ArrayList<Order> orderlist = ((ArrayList<Order>) request
							.getAttribute("customerOrders"));

					for (Order order : orderlist) {
				%>

				<td><%=order.getOrderId()%></td>
				<td><%=order.getUserId()%></td>
				<td><%=order.getCustomerName()%></td>
				<td><%=order.getPrice()%></td>
				<td><%=order.getQuantity()%></td>
				<td><%=order.getPaymentType()%></td>
				<td><%=order.getAddress()%></td>
				<td><%=order.getDeliveryDate()%></td>

			</tr>
			<%
				}
			%>



		</table>
	</div>
</fieldset>

</div>

<div id="templatemo_footer1">
  
  
</div>

	
</body>
</html>