package com.capgemini.entities;

public class Transaction {
	String transid;
	String accountid;
	String date;
	double amount;
	double balance;
	public String getTransid() {
		return transid;
	}
	public void setTransid(String transid) {
		this.transid = transid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	String type;

	public Transaction(String transid, String accountid, String date, double amount, String type,double balance) {
		super();
		this.transid = transid;
		this.accountid = accountid;
		this.date = date;
		this.amount = amount;
		this.type = type;
		this.balance=balance;
	}
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

