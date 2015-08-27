<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/Restaurant.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id ="templatemo_container">

	<%@ include file="/Jsp/adminMenu.jsp"%>

	<div id="templatemo_topsection"> Order Management System : View All Orders</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	
	<div id="form">

		<fieldset>

	<div class="CSSTableGenerator" >
		<form action ="<%=request.getContextPath()%>/AdminServlet" method ="post" onsubmit="return validate()">
		<table>
				<tr>
					<td>Order Id</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td><input type="submit" value="generate"></td>
					<td><input type="hidden" name="page" value="genBill"></td>
				</tr>

		</table>
		</form>
		</div>
		</fieldset>
	</div>

<div id="templatemo_footer1">
  
  
</div>
</body>

</html>