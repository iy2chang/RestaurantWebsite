<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Order</title>
<script src="../js/validation.js"></script>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<%@page import="com.tcs.ilp.bean.Order"%>
<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/customerMenu.jsp"%>

	<div id="templatemo_topsection"> Menu Management System : Payment Information</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	


<div id = "form">

<% Order cc = (Order)request.getAttribute("ord"); %>
<form action ="<%=request.getContextPath()%>/CustomerServelet" method ="post" onsubmit="return validateOR()">
<input type="hidden" name="page" value="updateOrderInfo">

<fieldset>
<table>
<tr>
	<td><label for=cellNumber class ="label"> cellNumber </label></td>
	<td><input type ="text" id ="cellNumber" name ="cellNumber" value = "<%= cc.getCellNumber() %>"></td>
</tr>
<tr>
	<td><label for="customerName" class ="customerName">Name </label></td>
	<td><input type ="text" id ="customerName"  name ="customerName" value = "<%= cc.getCustomerName() %>"></td>
</tr>	
	
<tr>	
		<td><label for="price" class ="label">price </label></td>
		<td> <%= cc.getPrice() %></td> 
		<input type="hidden" name="price" value="<%= cc.getPrice() %>">
</tr>

<tr>	
		<td><label for="quantity" class ="label"> quantity </label></td>
		<td><input type ="text" id ="quantity" name = "quantity" value = "<%= cc.getQuantity() %>"></td> 
</tr>

<tr>	
		<td><label for="address" class ="label"> address </label></td>
		<td><input type ="text" id ="address" name = "address" value = "<%= cc.getAddress() %>"></td> 
</tr>
<tr>	
		<td><label for="orderId" class ="label"> orderId</label></td>
		<td><%= cc.getOrderId() %></td>
		<input type="hidden" name="orderId" value="<%= cc.getOrderId() %>"> 
</tr>
<tr>
<tr>	
		<td><label for="paymentType" class ="label"> paymentType</label></td>
		<td><input type ="text" id ="paymentType" name = "paymentType" value = "<%= cc.getPaymentType() %>"></td> 
</tr>
<tr>	
		<td><label for="deliveryDate" class ="label"> deliveryDate</label></td>
		<td>
				<select name="deliverydate" id="ddate">
					<option value=""></option>
					<%
					SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
					Calendar c1 = Calendar.getInstance();
					java.util.Date date = c1.getTime();
					int selectedDate = 0;
					date.setDate(date.getDate() - 1);
					for (int j = 0; j < 10; j++)
					{
						date.setDate(date.getDate() + 1);
						String dDisplay = (date.getMonth()+1)+"/"+(date.getDate())+"/"+(date.getYear() + 1900);
						if (cc.getDeliveryDate().getDate() == date.getDate())
							selectedDate = j+1;
					%>
					<option value="<%= dDisplay%>"><%=dDisplay %></option>
					<%
					}
					%>
				</select>
			<script>
			document.getElementById('ddate').selectedIndex=<%=selectedDate%>
			if (<%=selectedDate%> <= 2)
				document.getElementById('ddate').disabled="disabled";
			</script>
<%-- 		<input type ="text" id ="deliveryDate" name = "deliveryDate" value = "<%= cc.getDeliveryDate() %>"> --%>
		</td> 
</tr>
<tr>

		<td> </td>
		<td> <input type ="submit" value ="Update Order"> </td>
</tr>

</table>
</fieldset>

</form>


</div>

<div id="templatemo_footer1">
  
  
</div>

</body>
</html>