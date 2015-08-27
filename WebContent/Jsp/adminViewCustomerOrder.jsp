<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">

<title>Customer Order</title>
</head>
<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/adminOrder.jsp"%>

	<div id="templatemo_topsection"> Order Management System : Customer Order</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	
<div id = "form">

<form name = "UpdateMenuForm" action ="<%=request.getContextPath()%>/AdminServlet" method ="post" onsubmit="return validate()">
<input type="hidden" name="page" value="viewOrderCustomer">

<fieldset>
<table>

	
<tr>	

		<td><label for= "CustomerName" class ="label"> Customer Id  </label></td>
		<td><input type ="text" id ="CustomerName" name = "CustomerName" ></td> 

</tr>


<tr>
		<td> </td>
		
		<td> 
		
		<input type ="reset" >
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