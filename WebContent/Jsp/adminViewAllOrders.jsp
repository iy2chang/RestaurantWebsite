<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<div id="templatemo_topsection"> Order Management System : Sort Orders</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	
  <div id = "form">


<form name = "ViewAllOrderForm" action ="<%=request.getContextPath()%>/AdminServlet" method ="post" onsubmit="return validate()">
<input type="hidden" name="page" value="viewOrders">

<fieldset>
<table>
<tr>
	
<tr>	

		<td><label for="MenuItem" class ="label">View Order By : </label></td>
		<td>
		
		<select name ="sort">
		<option value ="DELIVERY_DATE"> Date </option>
		<option value ="Address"> Address </option>
		<option value ="Customer_Name"> Customer Name </option>
		<option value ="Email"> Email </option>
		<option value ="ORDERS_ID"> Order Id </option>
		
		</select>
		
		
		</td> 

</tr>


<tr>
		<td> </td>
		<td> 
		
		<input type="reset" >
		<input type ="submit" value ="View Order"> 
		
		</td>
</tr>

</table>
</fieldset>

</form>

</div>

<div id="templatemo_footer1">
  
  
</div>







</body>
</html>