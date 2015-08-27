function validateCustomer()
{
	var uname = document.userLogin.username;
	var pwd = document.userLogin.password;
	
	if (uname.value.trim() == "")
		{
			alert('Please enter username');
			return false;
		}
	if (pwd.value.trim() == "")
		{
			alert('Please enter your password');
			return false;
		}
	return true;
}