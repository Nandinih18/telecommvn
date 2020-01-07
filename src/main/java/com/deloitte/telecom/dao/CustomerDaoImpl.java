package com.deloitte.telecom.dao;

import com.deloitte.telecom.*;
import com.deloitte.telecom.entities.*;
import com.deloitte.telecom.exceptions.*;

import java.util.*;


public class CustomerDaoImpl implements ICustomerDao {
	private Map<String, Customer> store = new HashMap<>();

	public Map<String, Customer> getStore() {
		return store;
	}

	@Override
	public Customer findByMobileNo(String mobileno) {
		Customer c = store.get(mobileno);
		if (c == null) {
			throw new CustomerNotFoundException("customer not found for mobile number:" + mobileno);
		}
		return c;
	}

	@Override
	public void rechargeAccount(Customer c, double amount) {
		c.addAmount(amount);
	}

	@Override
	public Customer createAccount(String mobileno, double balance, String name) {
		Customer c = new Customer(mobileno, balance, name);
		store.put(mobileno, c);
		return c;
	}

	@Override
	public Set<Customer> allCustomers() {
		Collection<Customer> customers = store.values();
		Set<Customer> customerSet = new HashSet<>(customers);
		return customerSet;
	}

}
