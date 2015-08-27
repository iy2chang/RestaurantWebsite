package com.tcs.ilp.service;

import com.tcs.ilp.bean.Customer;

public class UserNameGenerator 
{

	public static String GenerateUserName(Customer cust)
	{
		String ema = cust.getEmail().split("@")[0];
		long ber = cust.getCellnumber();
		//String zip = cust.getZip();
		return ema + ber;
	}
}
