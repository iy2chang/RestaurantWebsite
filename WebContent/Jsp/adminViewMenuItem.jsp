
<%@page import="com.tcs.ilp.bean.Menu" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
<title>View Menu Items</title>
</head>
<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/adminMenu.jsp"%>

	<div id="templatemo_topsection"> Menu Management System : View Menu</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
		

	<div id="form">

<fieldset>
<div class="CSSTableGenerator" >
		<table>
		

			<caption>Menu Items</caption>

			<tr>
				<th>Menu Category</th>
				<th>Menu Item</th>
				<th>Menu Description</th>
				<th>Menu Price</th>

			</tr>
			<tr>
				<%
					ArrayList<Menu> accountlist = ((ArrayList<Menu>) request
							.getAttribute("list"));

					for (Menu menu : accountlist) {
				%>

				<td><%=menu.getCategory()%></td>
				<td><%=menu.getItem()%></td>
				<td><%=menu.getDescription()%></td>
				<td><%=menu.getPrice()%></td>


			</tr>
			<%
				}
			%>



		</table>
		</div>
		</fieldset>
		
	</div>
	
<div id="templatemo_footer1">
  
  
</div>


</body>
</html>