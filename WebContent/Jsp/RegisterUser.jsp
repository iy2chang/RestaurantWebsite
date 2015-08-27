<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
<script src="<%=request.getContextPath()%>/js/validation.js"></script>
</head>
<body>


<div id ="templatemo_container">

	<%@ include file="/Jsp/customerMenu.jsp"%>

	<div id="templatemo_topsection"> Menu Management System : Payment Information</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	


	<div id = "form">
	<form name = "registeruser" method = "post"  action = "<%=request.getContextPath()%>/CustomerServelet" onsubmit="return validateCR()">
		<fieldset>
		<table>
			<tr>
				<td>
					 Name:
				</td>
				<td>
					<input type = "text" name = "name" id = "name">
				</td>
			</tr>
			
			<tr>
				<td>
					Address:
				</td>
				<td>
					<textarea name = "address" id = "address"></textarea>
				</td>				
			</tr>			
			<tr>
				<td>
					Zip:
				</td>
				<td>
					<input type = "text" name = "zipcode" id = "zipcode">
				</td>
			</tr>
			<tr>
				<td>
					Phone number:
				</td>
				<td>
					<input type = "text" name = "phonenumber" id = "phonenumber" size="10">
				</td>
			</tr>
			<tr>
				<td>
					Landmark:
				</td>
				<td>
					<input type = "text" name = "Landmark" id = "landmark">
				</td>
			</tr>
			<tr>
				<td>
					Email:
				</td>
				<td>
					<input type = "text" name = "email" id = "email">
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
			<input type="hidden" name="page" value="registeruser">
					<input type = "submit" name = "register" id =  "register" value = "Register">
				</td>
				<td>
					<input type = "reset" name = "reset" id = "reset">
				</td>				
			</tr>
			<tr>
				<td><a href = "<%=request.getContextPath()%>/Jsp/UserLogin.jsp">Back</a></td>
			</tr>	
		</table>
		</fieldset>
	</form>
	</div>
	
	
	<div id="templatemo_footer1">
  
  
</div>
	
</body>
</html>