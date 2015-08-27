function validateCR()
{
	var name = document.registeruser.name;
	var add = document.registeruser.address;
	var zip = document.registeruser.zipcode;
	var phone = document.registeruser.phonenumber;
	var lm = document.registeruser.landmark;
	var email = document.registeruser.email;
	
	var numPatt = /^[0-9]+$/;
	
	if (name.value.trim() == "")
		{
			alert('Please insert name');
			return false;
		}
	if (add.value.trim() == "")
		{
			alert('Please insert address');
			return false;
		}
	if (zip.value.trim() == "")
		{
			alert('Please insert your zipcode');
			return false;
		}
	if (!numPatt.test(zip.value.trim()) || zip.value.trim().length != 6)
		{
			alert('Zipcode must be 6 digit number');
			return false;
		}
	if (phone.value.trim()=="" || phone.value.trim().length != 10)
		{
			alert('Phone number must be a 10 digit number');
			return false;
		}
	if (!numPatt.test(phone.value.trim()))
		{
			alert('Please insert 10 digit phone number');
			return false;
		}
	if (lm.value.trim() == "")
		{
			alert('Please insert landmark');
			return false;
		}
	if (email.value.trim() == "")
		{
			alert('Please insert an email');
			return false;
		}

	    var atpos = email.value.trim().indexOf("@");
	    var dotpos = email.value.trim().lastIndexOf(".");
	    var dotCheck = email.value.trim().indexOf(".");
	    
	if (atpos< 1) 
	{
	    alert('Not a valid e-mail address: [local]@[domainName].[net/com/org]');
	    return false;
	}
	if (dotpos < atpos+2)
	{
        alert('Not a valid e-mail address: [local]@[domainName].[net/com/org]');
        return false;
    }
	if (dotpos+2 >= email.length)
		{
		alert('Not a valid e-mail address: [local]@[domainName].[net/com/org]');
        return false;
		}
	if (dotpos != dotCheck)
		{
		alert('Only 1 dot after between domain name and domain: [local]@[domainName].[net/com/org]');
        return false;
		}
	if (dotpos == (email.value.trim().length - 1))
	{
		alert('Need a domain at the end @[domain].[net/com/org/etc]');
        return false;
		}
	return true;
}

function validatePI()
{
	
	var name = document.payment.name;
	var cn = document.payment.cardNumber;
	var edM = document.payment.expMonth;
	var edY = document.payment.expYear;
	var issuer = document.payment.issuer;
	var ctype = document.payment.cardType;
	var cvv = document.payment.cvv;
	
	var numPatt = /^[0-9]+$/;
	
	if (name.value.trim() == "")
		{
			alert('Please enter cardholder\'s name');
			return false;
		}
	if (cn.value.trim() == "")
		{
			alert('Please enter card number');
			return false;
		}
	if (cn.value.length != 16)
	{
		alert('Credit Card Number must be 16 digit number');
		return false;
	}
	if ( !numPatt.test(cn.value.trim()) )
	{
		alert('Credit Card Number must be numbers');
		return false;
	}
	if ( edM.value.trim().length != 2 || !numPatt.test(edM.value.trim()))
		{
			alert('Please enter two digit month representation');
			return false;
		}
	if ( edY.value.trim().length != 4 || !numPatt.test(edY.value.trim()))
		{
			alert('Please enter four digit year representation');
			return false;
		}
	if ( !checkedBox(ctype) )
		{
			alert('Please select type of card');
			return false;
		}
	if ( cvv.value.trim() == "" || cvv.value.trim().length != 3)
		{
			alert('Please enter 3 digit CVV code');
			return false;
		}
	if ( numPatt.test(cvv.value.trim()))
		{
			alert('CVV code entered not 3 digit number');
			return false;
		}
	return true;
	
}

function validateMenu()
{
	var dd = document.submitOrder.deliverydate;
	
	if (dd.selectedIndex == 0)
		{
			alert('Please select a date');
			return false;
		}
	
	var pt = document.submitOrder.paymentType;
	
	if (!checkedBox(pt))
		{
			alert('Please choose payment type');
			return false;
		}
	
	var ad = document.submitOrder.address;
	
	if (ad.value.trim() == "")
		{
			alert('Please enter an address');
			return false;
		}
	
	return true;
}

function checkedBox(pt)
{
	for (var i = 0; i< pt.length; i++)
		{
			if (pt[i].checked)
				return true;
		}
	return false;
}