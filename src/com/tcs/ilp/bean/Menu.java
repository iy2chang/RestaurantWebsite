package com.tcs.ilp.bean;

public class Menu {
	@Override
	public String toString() {
		return "Menu [category=" + category + ", item=" + item
				+ ", description=" + description + ", price=" + price + "]";
	}
	public Menu(String category, String item, String description, double price) {
		
		this.category = category;
		this.item = item;
		this.description = description;
		this.price = price;
	}
	private String category;
	private String item;
	private String description;
	private double price;
	private int quantity;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
