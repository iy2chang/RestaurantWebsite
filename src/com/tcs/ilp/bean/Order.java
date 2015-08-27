package com.tcs.ilp.bean;

import java.sql.Date;

public class Order {


	private String userId;
	private long cellNumber;
	private String customerName;
	private double price;
	private String quantity;
	private String address;
	private int orderId;
	private String paymentType;
	private Date deliveryDate;
	
	public Order(){
		
	}
	
	
	public Order(String userId, String customerName, double price, String quantity,
			String address, int orderId, String paymentType, Date deliveryDate) {

		this.userId = userId;
		this.customerName = customerName;
		this.price = price;
		this.quantity = quantity;
		this.address = address;
		this.orderId = orderId;
		this.paymentType = paymentType;
		this.deliveryDate = deliveryDate;
	}


	public Order(String customerName, double price,
			String address, int orderId) {
	
		this.customerName = customerName;
		this.price = price;
		this.address = address;
		this.orderId = orderId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public long getCellNumber() {
		return cellNumber;
	}


	public void setCellNumber(long c) {
		this.cellNumber = c;
	}

	
}
