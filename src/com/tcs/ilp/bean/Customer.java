package com.tcs.ilp.bean;

public class Customer {
private String id;
private String name;
private String address;
private String zip;
private String landmark;
private long cellnumber;
private String email;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}
public long getCellnumber() {
	return cellnumber;
}
public void setCellnumber(long cellnumber) {
	this.cellnumber = cellnumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Customer(String id, String name, String address, String zip,
		String landmark, long cellnumber, String email) {
	
	this.id = id;
	this.name = name;
	this.address = address;
	this.zip = zip;
	this.landmark = landmark;
	this.cellnumber = cellnumber;
	this.email = email;
}
public Customer() {
	// TODO Auto-generated constructor stub
}
}
