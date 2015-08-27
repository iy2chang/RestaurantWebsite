<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Menu</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
<script src="../js/adminValidation.js"></script>
</head>
<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/adminMenu.jsp"%>

	<div id="templatemo_topsection"> Menu Management System : Update Menu</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	

  <div id = "form">


<form name = "UpdateMenuForm" action ="<%=request.getContextPath()%>/AdminServlet" method ="post" onsubmit="return validateUM()">
<input type="hidden" name="page" value="updateMenu">

<fieldset>
<table>
<tr>
	
<tr>	

		<td><label for="MenuItem" class ="label">Menu Item </label></td>
		<td><input type ="text" id ="MenuIem" name = "MenuItem" ></td> 

</tr>



<tr>
		<td> </td>
		<td>
		 <input type="reset">
		 <input type ="submit" value ="Update Menu"> 
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