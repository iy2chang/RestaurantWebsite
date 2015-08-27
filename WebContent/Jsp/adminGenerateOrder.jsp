<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Order</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
</head>
<body>

<div id ="templatemo_container">

	<%@include file="/Jsp/adminOrder.jsp"%>

	<div id="templatemo_topsection"> Order Management System : New Order</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	


	<div id="form">


		<form name="UpdateMenuForm"
			action="<%=request.getContextPath()%>/AdminServlet" method="post"
			onsubmit="return validate()">
			<input type="hidden" name="page" value="generateOrderCustomer">

			<fieldset>
				<table>


					<tr>

						<td><label for="CustomerName" class="label"> Customer
								Name </label></td>
						<td><input type="text" id="CustomerName" name="CustomerName"></td>

					</tr>

					<tr>

						<td><label for="DeliveryAddress" class="label">
								Delivery Address </label></td>
						<td><input type="text" id="DeliveryAddress"
							name="DeliveryAddress"></td>

					</tr>
					<tr>

						<td><label for="CellNumber" class="label"> Cell
								Number </label></td>
						<td><input type="text" id="CellNumber" name="CellNumber"></td>

					</tr>
					<tr>

						<td><label for="MenuItem" class="label"> Menu Item </label></td>
						<td><input type="text" id="MenuItem" name="MenuItem"></td>

					</tr>
					<tr>

						<td><label for="Quantity" class="label"> Quantity </label></td>
						<td><input type="text" id="Quantity" name="Quantity"></td>

					</tr>
					<tr>

						<td><label for="DeliveryDate" class="label"> Delivery
								Date (mm/dd/yyyy) </label></td>
						<td><input type="text" id="DeliveryDate" name="DeliveryDate"></td>

					</tr>



					<tr>
						<td></td>

						<td><input type="reset"> <input type="submit"
							value="Generate Order"></td>
					</tr>

				</table>
			</fieldset>

		</form>

	</div>

<div id="templatemo_footer1">
  
  
</div>




</body>
</html>