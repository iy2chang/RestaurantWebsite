<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.tcs.ilp.bean.CustomerCredentials" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Newly Registered Customer</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>


<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/customerMenu.jsp"%>

	<div id="templatemo_topsection"> Customer Management System : Display Registered Customer</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
		
		
	<div id ="form">
	
	<fieldset>

	<div class="CSSTableGenerator" >
	
	
	<table>
		<tr>
			<td>Username :</td>
			<td><%=((CustomerCredentials)request.getAttribute("username")).getUserName()%></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><%=((CustomerCredentials)request.getAttribute("username")).getPassWord()%></td>
		</tr>
		<tr>
			<td><a href = "<%=request.getContextPath()%>/Jsp/UserLogin.jsp">Login</a></td>
		</tr>
	</table>
	</div>
	</fieldset>
</div> 

<div id="templatemo_footer1">
  
  
</div>



</body>
</html>