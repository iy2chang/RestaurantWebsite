<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Information</title>
<link rel= "stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Restaurant.css">
<script src="<%=request.getContextPath()%>/js/validation.js"></script>
</head>
<body>

<div id ="templatemo_container">

	<%@ include file="/Jsp/customerMenu.jsp"%>

	<div id="templatemo_topsection"> Menu Management System : Payment Information</div>

	 <div id="templatemo_headersection"><img src="<%=request.getContextPath()%>/img/templatemo_header_photo.jpg" class="reflect rheight20 ropacity25" alt="templatemo.com" width="806" height="166"  /></div>
	


	<div id="form">
	
		<form name = "payment" method = "post" action = "<%=request.getContextPath()%>/CustomerServelet" onsubmit="return validatePI()">
			<input type = "hidden" name = "page" id = "payment" value="payment">
			<fieldset>
			<table>
				<tr>
					<td>
					 	Name on card:
					</td>
					<td>
						<input type = "text" name = "name" id = "id">
					</td>
				</tr> 
				<tr>
					<td>
					 	Card Number:
					</td>
					<td>
						<input type = "text" name = "cardNumber" id = "id">
					</td>
				</tr> 
				<tr>
					<td>
					 	Expiration Date (MM/YYYY):
					</td>
					<td>
						<input type = "text" name = "expMonth" id = "expMonth" size = "2">
						<input type = "text" name = "expYear" id = "expYear" size = "4">
					</td>				
				</tr> 
				<tr>
					<td>
						Card Issuer:
					</td>
					<td>
						<select name="issuer">
						<option value = "Visa" id = "Visa" >Visa</option>
						<option value = "MasterCard" id = "MasterCard">MasterCard</option>
						<option value = "American Express" id = "American Express">American Express</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>
						Card Type:
					</td>
					<td>
						<input type="radio" name="cardType" id="credit" value="Credit"><label for="credit">Credit</label>
						<input type="radio" name="cardType" id="debit" value="Debit"><label for="debit">Debit</label>
					</td>
				</tr>
				<tr>
					<td>
						CVV Number:
					</td>
					<td>
						<input type ="password" name="cvv" size ="4" maxlength="3">
					</td>
				</tr>	
				<tr>
					<td>
						<input type = "submit" name = "submitPyment" id = "submitPayment" value = "Submit Payment">	
					</td>
					<td>
						<a href = "<%=request.getContextPath()%>/Jsp/viewOrder.jsp">Back</a>	
					</td>								
			</table>	
			</fieldset>		
		</form>	
	</div>
	
	
	<div id="templatemo_footer1">
  
  
</div>
	</div>
</body>
</html>