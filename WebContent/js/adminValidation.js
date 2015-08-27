function validateDM()
{
	var item = document.Form.MenuItem;
	
	if (item.value.trim() == "")
		{
			alert('Insert a Item name to delete');
			return false;
		}
	
	return true;
}

function validateUM()
{
	var item = document.UpdateMenuForm.MenuItem;
	
	if (item.value.trim() == "")
	{
		alert('Insert a Item name to delete');
		return false;
	}
	
	return true;
}

function validateMM()
{
	var item = document.MenuForm.MenuItem;
	var desc = document.MenuForm.MenuDescription;
	var cat = document.MenuForm.MenuCategory;
	var price = document.MenuForm.MenuPrice;
	
	var numPatt = /^[0-9]+\.[0-9]+$/;
	
	if (cat.value.trim() == "")
	{
		alert('Please enter category of menu item');
		return false;
	}
	
	if (desc.value.trim() == "")
	{
		alert('Please enter description of menu item');
		return false;
	}
	
	if (item.value.trim() == "")
	{
		alert('Please enter name of menu item');
		return false;
	}
	
	if (price.value.trim() == "")
	{
		alert('Please enter price of menu item');
		return false;
	}
	
	if (!numPatt.test(price.value.trim()))
	{
		alert('Price must be represented as: xxx.xx where x is a number digit');
		return false;
	}
	
//	if (price.value.trim().split(".")[1].length >= 3)
//	{
//		alert('There cannot be more than two decimals in price');
//		return false;
//	}
	
	return true;
}