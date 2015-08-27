package com.tcs.ilp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.tcs.ilp.bean.Customer;
import com.tcs.ilp.bean.Menu;
import com.tcs.ilp.bean.Order;

public class GenerateOrder 
{

	public static Order makeOrder(ArrayList<Menu> m, Customer c, int[] q, String address, String pType, String ddate)
	{
		Order o = new Order();
		o.setCellNumber(c.getCellnumber());
		o.setAddress(address);
		o.setPaymentType(pType);
		o.setCustomerName(c.getName());
		for (int s: q)
			System.out.println(s);
		SimpleDateFormat format = new SimpleDateFormat("M/dd/yyyy");
        java.util.Date parsed = null;
		try {
			parsed = format.parse(ddate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(parsed.toString());
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
		o.setDeliveryDate(sql);
		
		double price = 0.0;
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<m.size(); i++)
		{
			if (q[i] != 0)
			{
			sb.append(m.get(i).getItem()+" ");
			sb.append(q[i]+", ");
			price = price + (q[i]*m.get(i).getPrice());
			}
		}
		
		o.setPrice(price);
		o.setQuantity(sb.toString());
		o.setUserId(c.getId());
		return o;
	}
}
