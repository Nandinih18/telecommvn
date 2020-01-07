package com.deloitte.telecom.entities;

public class Customer {
	private String mobileno;
	private double balance;
	private String name;

	public Customer() {
	}

	public Customer(String mobileno, double balance, String name) {
		this.mobileno = mobileno;
		this.balance = balance;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void addAmount(double amount) {
		balance = balance + amount;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || !(obj instanceof Customer)) {
			return false;
		}

		Customer c = (Customer) obj;
		return c.mobileno.equals(this.mobileno);
	}

	@Override
	public int hashCode() {
		return mobileno.hashCode();
	}

	@Override
	public String toString() {
		return "Customer [mobileno=" + mobileno + ", balance=" + balance + ", name=" + name + "]";
	}
	


}
