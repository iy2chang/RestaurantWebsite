<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

ArrayList<Menu> orderPlaced = new ArrayList<Menu>();
int i = 0;
	ArrayList<Menu> accountlist = ((ArrayList<Menu>)session.getAttribute("list"));
	System.out.println("accountlist" +accountlist);
	
%>
<html>
<head>
<%@page import="com.tcs.ilp.bean.Menu" import="java.util.*" import = "com.tcs.ilp.bean.Customer"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<body>

	<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/customerMenu.jsp"%>

	<div id="templatemo_topsection"> Customer Management System : Display Menu</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
		

	
	<div id="form">
		<form name = "submitOrder" method = "post" action = "<%=request.getContextPath()%>/CustomerServelet">
		
		<fieldset>

	<div class="CSSTableGenerator" >
	
	<div id="body">
		<form name = "submitOrder" method = "post" action = "<%=request.getContextPath()%>/CustomerServelet" onsubmit="return validateMenu()">
		<table>

			<caption>Menu Items</caption>

			<tr>
				<th>Menu Category</th>
				<th>Menu Item</th>
				<th>Menu Description</th>
				<th>Menu Price</th>
				<th>Quantity</th>
			</tr>
			<tr>
				<%
			
					for (Menu menu : accountlist) {
// 						orderPlaced.add(menu);
				%>

				<td><%=menu.getCategory()%></td>
				
				<td><%=menu.getItem()%></td>
				<td><%=menu.getDescription()%></td>
				<td><%=menu.getPrice()%></td>
				<td><input type = "text" name = "quantity<%=i %>" id = "quantity"></td>
			</tr>
			<%
			i++;
				}
					
			%>
			<tr>			
				<td>
					Payment Type:
				</td>					
				<td>
					<input type="radio" name="paymentType" value="Cash">Cash on Delivery
					<input type="radio" name="paymentType" value="Card">Debit/Credit
				</td>
				<td>
				</td>
				<td>
				</td>
			</tr>	
			<tr>					
				</tr>
				<tr>
					<td>
						Delivery Address:
					</td>
					<td>
						<textarea name = "address" id = "address"></textarea>
					</td>
				</tr>
				<tr>
					<td>
						Billing Address:
					</td>
					<td>
						<%=((Customer)request.getAttribute("customer")).getAddress()%>
<%-- 						<%=cust.getAddress()%> --%>
					</td>
				</tr>
				
			<tr>
				<td>
					Delivery Date (mm/dd/yyyy):
				</td>
				<td>
					<select name="deliverydate">
					<option value=""></option>
					<%
					SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
					Calendar c1 = Calendar.getInstance();
					java.util.Date date = c1.getTime();
					
					date.setDate(date.getDate() - 1);
					for (int j = 0; j < 10; j++)
					{
						date.setDate(date.getDate() + 1);
						String dDisplay = (date.getMonth()+1)+"/"+(date.getDate())+"/"+(date.getYear() + 1900);

					%>
					<option value="<%= dDisplay%>"><%=dDisplay %></option>
					<%
					}
					%>
					</select>
<!-- 					<input type="text" name="deliverydate"> -->
				</td>
			</tr>		
			<tr>
				<td>
					<a href = "<%=request.getContextPath()%>/Jsp/Welcome.jsp">Back</a>
				</td>
			</tr>	 			
		</table>	
		<input type="hidden" name="page" value="addorder">
				<%
				
				%>	
				<input type="hidden" name="page"  value="payment">				
			
			
			
					<input type = "submit" name = "submitOrder" id = "submitOrdr" value = "Place Order">
		</div>
		</fieldset>
		
		
		</form>
		
		
	</div>
	
	<div id="templatemo_footer1">
  
  
</div>
	
	
	
</body>
</html>
