<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged failed</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/Restaurant.css">

</head>
<body>
	<div id="templatemo_container">

		

		<div id="templatemo_topsection">Log in Fail</div>

		<div id="templatemo_headersection">
			<img
				src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg"
				class="reflect rheight20 ropacity25" alt="templatemo.com"
				width="806" height="166" />
		</div>

		<div id="templatemo_content_section">

			<center>
				<h1>
					<marquee behavior="alternate">Logged in Failed!</marquee>
				</h1>
			</center>
		</div>

	</div>
	<div id="templatemo_footer"></div>
	<%
		out.print("logged in failed!");
	%>
</body>
</html>