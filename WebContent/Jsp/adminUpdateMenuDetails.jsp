<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Menu Items</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/adminMenu.jsp"%>

	<div id="templatemo_topsection"> Menu Management System : Update Menu Details</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	

  <div id = "form">


<form action ="<%=request.getContextPath()%>/AdminServlet" method ="post" onsubmit="return validate()">
<input type="hidden" name="page" value="updateMenuDetails">

<fieldset>
<table>
<tr>
	<td><label for="MenuItem" class ="label"> Name </label></td>
	<td><input type ="text" id ="MenuItem" name ="MenuItem" value = "<%= request.getAttribute("item") %>"></td>
</tr>
<tr>
	<td><label for="MenuCategory" class ="label">Menu Category </label></td>
	<td><input type ="text" id ="MenuCategory"  name ="MenuCategory" value = "<%= request.getAttribute("category") %>"></td>
</tr>	
	
<tr>	
		<td><label for="MenuDescription" class ="label">Menu Description </label></td>
		<td><input type ="text" id ="MenuDescription" name = "MenuDescription" value = "<%= request.getAttribute("description") %>"></td> 
</tr>

<tr>	
		<td><label for="MenuPrice" class ="label"> Menu Price </label></td>
		<td><input type ="text" id ="MenuPrice" name = "MenuPrice" value = "<%= request.getAttribute("price") %>"></td> 
</tr>

<tr>
		<td> </td>
		<td> 
		<input type ="submit" value ="Update Menu Details"> 
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