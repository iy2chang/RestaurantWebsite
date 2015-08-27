<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
<script src="../js/loginValidation"></script>
</head>
<body>

<div id ="templatemo_container">


	<div id="templatemo_topsection"> Login </div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>

<div id ="form">

	<form name = "userlogin" method = "post"  action = "<%=request.getContextPath()%>/CustomerServelet" onsubmit="return validateCustomer()">
		<table>
			<tr>
				<td>
					Username:
				</td>
				<td>
					<input type = "text" name = "username" id = "username">
				</td>				
			</tr>
			<tr>
				<td>
					Password:
				</td>
				<td>
					<input type = "password" name = "password" id = "password">
				</td>				
			</tr>
			<tr>
				<td>
					<input type = "submit" name = "login" id =  "login" value = "login">
				</td>
				<td>
					<input type = "reset" name = "reset" id = "reset">
				</td>
				<td>
					<a href= "<%=request.getContextPath()%>/Jsp/RegisterUser.jsp">New User</a>
								
				</td>				
			</tr>
			<tr>				
				<td> <a href = "<%=request.getContextPath()%>/Jsp/Home.jsp">Back</a></td>
			</tr>			
		</table>
	<input type="hidden" name="page"  value="ulogin">
	</form>
	</div>
	<div id="templatemo_footer1">
  
  
</div>
	
	</body>
</html>