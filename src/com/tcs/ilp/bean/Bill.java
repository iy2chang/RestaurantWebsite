package com.tcs.ilp.bean;

import java.sql.Date;

public class Bill {
	private String quantity;
	private String delivery_address;
	private Date delivery_date;
	private String payment_type;
	private double price;
	private String orders_id;
	private String user_id;
	private String customer_name;
	private String address;
	private String zipCode;
	private String landMark;
	private long cell_number;
	private String email;


	public Bill(String quantity, String delivery_address, Date delivery_date,
			String payment_type, double price, String orders_id, String user_id,
			String customer_name, String address, String zipCode, String landMark,
			long cell_number, String email) {
		super();
		this.quantity = quantity;
		this.delivery_address = delivery_address;
		this.delivery_date = delivery_date;
		this.payment_type = payment_type;
		this.price = price;
		this.orders_id = orders_id;
		this.user_id = user_id;
		this.customer_name = customer_name;
		this.address = address;
		this.zipCode = zipCode;
		this.landMark = landMark;
		this.cell_number = cell_number;
		this.email = email;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(String orders_id) {
		this.orders_id = orders_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public long getCell_number() {
		return cell_number;
	}
	public void setCell_number(long cell_number) {
		this.cell_number = cell_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
