<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tcs.ilp.bean.Order" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/customerMenu.jsp"%>

	<div id="templatemo_topsection"> Customer Management System : Display Orders</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
		

<div id="form">
<%
					String strExpired = (String) session.getAttribute("deleted");
						if (strExpired.equals("Order Deleted")){     
					out.print("Order Deleted");
}      
%>
		<fieldset>

	<div class="CSSTableGenerator" >

		<table>
			<caption>All Orders</caption>

			<tr>
				<th>UserID</th>
				<th>Cell Number</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Address</th>
				<th>OrderId</th>
				<th>Payment Type</th>
				<th>Delivery Date</th>
				<th>Delete?</th>
				<th>Update?</th>
			</tr>
			<tr>
				<%
					ArrayList<Order> accountlist = ((ArrayList<Order>) request
							.getAttribute("list"));

					for (Order order : accountlist) {
				%>
				<td><%=order.getUserId()%></td>
				<td><%=order.getCellNumber()%></td>
				<td><%=order.getCustomerName()%></td>
				<td><%=order.getPrice()%></td>
				<td><%=order.getQuantity()%></td>
				<td><%=order.getAddress()%></td>
				<td><%=order.getOrderId()%></td>
				<td><%=order.getPaymentType()%></td>
				<td><%=order.getDeliveryDate()%></td>
				<form name = viewOrder method = "post" action = "<%=request.getContextPath()%>/CustomerServelet">
				
 					<input type="hidden" name="page"  value="deleteupdateOrder">
					<input type="hidden" name="oid"  value="<%=order.getOrderId() %>">
				
				<td><input type = "radio" name = "Command" id = "delete" value="Delete"></td>
				<td><input type = "radio" name = "Command" id = "update" value="Update"></td>
				<td><input type = "submit" value="Submit"></td>
				
				</form>
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