   <%@page import="com.tcs.ilp.bean.Order" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Orders</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<body>


<div id ="templatemo_container">

	<%@ include file="/Jsp/adminOrder.jsp"%>

	<div id="templatemo_topsection"> Order Management System : View New Generated Orders</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	


	<div id="form">

<fieldset>

<div class="CSSTableGenerator" >
		<table>

			<caption>Menu Items</caption>

			<tr>
				<th>Customer Name</th>
				<th>Delivery Address</th>
				<th>Cellphone Number</th>
				<th>Quantity : Menu Item</th>
				<th>Delivery Date</th>
							

			</tr>
			<tr>
				<%
					ArrayList<Order> orderlist = ((ArrayList<Order>) request
							.getAttribute("allOrders"));

					for (Order order : orderlist) {
				%>

				<td><%=order.getCustomerName()%></td>
				<td><%=order.getAddress()%></td>
				<td><%=order.getCellNumber()%></td>
				<td><%=order.getQuantity()%></td>
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