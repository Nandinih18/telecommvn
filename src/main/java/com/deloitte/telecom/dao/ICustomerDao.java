package com.deloitte.telecom.dao;

import java.util.Map;

import java.util.Set;

import com.deloitte.telecom.*;
import com.deloitte.telecom.entities.*;

public interface ICustomerDao {

	public Customer findByMobileNo(String mobileno);

	public void rechargeAccount(Customer c, double amount);

	public Customer createAccount(String mobileno, double balance, String name);

	public Map<String, Customer> getStore();

	Set<Customer> allCustomers();

}
