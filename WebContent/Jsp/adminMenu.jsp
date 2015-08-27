<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	if (session.getAttribute("username").equals("")) {
		%>
		<jsp:forward page="/jsp/admin_login.jsp" />
	<% } %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <meta http-equiv="Pragma" content="no-cache">  
            <meta http-equiv="Expires" content="0">  
            <meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">  
            <script language="javascript">  
                  
                javascript:window.history.forward(-1);  
            </script>  
</head>
<body>




 <div class ="templatemo_topmenu">
 
 <ul>
 
  <li> <a href ="<%=request.getContextPath() %>/Jsp/admin_page.jsp" id = "link"> Home </a></li> 
 
   <li><a href ="<%=request.getContextPath() %>/Jsp/adminAddMenu.jsp" id = "link">  Add Menu Item </a> <li>
	
	<li><a href ="<%=request.getContextPath() %>/Jsp/adminUpdateMenu.jsp" id = "link"> Update Menu </a> </li>

	<li><a href ="<%=request.getContextPath() %>/Jsp/adminDeleteMenuItem.jsp" id = "link">  Delete Menu </a> </li>
	
	<li><a href ="<%=request.getContextPath()%>/AdminServlet?page=viewallMenu" id = "link"> View Menu </a></li>
	
 	<li> <a href ="<%=request.getContextPath()%>/AdminServlet?page=adminLogout" id = "link"> Logout </a></li>

</ul>
   </div>




</body>
</html>