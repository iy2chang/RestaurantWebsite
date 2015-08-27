package com.tcs.ilp.bean;

public class CreditCard 
{

	private long cardNumber;
	private String cardType;
	private String nameOnCard;
	private String issuer;
	private String expDate;
	private String cvv;
	private String ordersID;
	
	public CreditCard(long l, String cardType, String nameOnCard,
			String issuer, String expDate, String cvv, String ordersID) 
	{
		this.cardNumber = l;
		this.cardType = cardType;
		this.nameOnCard = nameOnCard;
		this.issuer = issuer;
		this.expDate = expDate;
		this.cvv = cvv;
		this.ordersID = ordersID;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getOrdersID() {
		return ordersID;
	}

	public void setOrdersID(String ordersID) {
		this.ordersID = ordersID;
	}
}
