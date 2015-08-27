<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tcs.ilp.bean.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer Information</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/customerMenu.jsp"%>

	<div id="templatemo_topsection"> Customer Management System : Update Customer Information</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
		


<div id = "form">

<% Customer cc = (Customer)request.getAttribute("cust"); %>
<form action ="<%=request.getContextPath()%>/CustomerServelet" method ="post" onsubmit="return validate()">
<input type="hidden" name="page" value="updateCustomer">

<fieldset>
	<div class="CSSTableGenerator" >

<table>
<tr>
	<td><label for=Name class ="label"> Name </label></td>
	<td> <%= cc.getName() %></td>
</tr>
<tr>
	<td><label for="address" class ="label">Address </label></td>
	<td><input type ="text" id ="address"  name ="address" value = "<%= cc.getAddress() %>"></td>
</tr>	
	
<tr>	
		<td><label for="zip" class ="label">Zip Code </label></td>
		<td><%= cc.getZip() %></td> 
</tr>

<tr>	
		<td><label for="landmark" class ="label"> Landmark </label></td>
		<td><%= cc.getLandmark() %></td> 
</tr>

<tr>	
		<td><label for="cellnumber" class ="label"> CellNumber </label></td>
		<td><input type ="text" id ="cellnumber" name = "cellnumber" value = "<%= cc.getCellnumber() %>"></td> 
</tr>
<tr>	
		<td><label for="email" class ="label"> Email</label></td>
		<td><%= cc.getEmail() %></td> 
</tr>
<tr>
		<td> </td>
		<td> <input type ="submit" value ="Update Account"> </td>
		<td> <a href = "<%=request.getContextPath()%>/Jsp/Welcome.jsp">Back</a>
</tr>

</table>
</div>
</fieldset>

</form>


</div>

<div id="templatemo_footer1">
  
  
</div>



</body>
</html>