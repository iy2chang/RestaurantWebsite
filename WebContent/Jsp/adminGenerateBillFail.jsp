<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.tcs.ilp.bean.Bill" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<body>
	<div id="templatemo_container">
		<%@ include file="/Jsp/adminMenu.jsp"%>
		<div id="templatemo_topsection">Menu Management System</div>

		<div id="templatemo_headersection">
			<img
				src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg"
				class="reflect rheight20 ropacity25" alt="templatemo.com"
				width="806" height="166" />
		</div>

		<div id="templatemo_content_section">

			<center>
				<h1>
					<marquee behavior="alternate">
						sorry, generate bill fail;
						<%
						String date = (String) request.getAttribute("currentDate");
						out.print("please wait till this date to bill: " + date);
					%>
					</marquee>
				</h1>
			</center>
		</div>


	</div>
	<div id="templatemo_footer"></div>

</body>
</html>