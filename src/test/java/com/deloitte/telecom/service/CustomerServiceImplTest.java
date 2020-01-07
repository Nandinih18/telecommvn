package com.deloitte.telecom.service;

import java.util.*;

import org.junit.Test;
import com.deloitte.telecom.*;
import com.deloitte.telecom.entities.*;
import com.deloitte.telecom.dao.*;
import com.deloitte.telecom.exceptions.*;

import junit.framework.Assert;

public class CustomerServiceImplTest {

	@Test (expected= IncorrectMobNoException.class)
	public void testCreateAccount() {
		CustomerServiceImpl service = new CustomerServiceImpl(new CustomerDaoImpl());
		String mobileno = null;
		double balance = 1000;
		String name = "satya";
		Customer customer = service.createAccount(mobileno, balance, name);
		Assert.assertNotNull(customer);
		double resultBalance = customer.getBalance();
		Assert.assertEquals(balance, resultBalance);
		Assert.assertEquals(name, customer.getName());
		Map<String, Customer> store = service.getDao().getStore();
		Customer expected = store.get(mobileno);
		Assert.assertNotNull(expected);
		Assert.assertEquals(expected, customer);
	}

	@Test
	public void testFindCustomerByMobilenumber() {
		CustomerServiceImpl service = new CustomerServiceImpl(new CustomerDaoImpl());
		String mobileno = "1234567890";
		double balance = 1000;
		String name = "satya";
		Customer customer = service.createAccount(mobileno, balance, name);
		Map<String, Customer> store = service.getDao().getStore();
		store.put(mobileno, customer);
		Customer result = service.findByMobileno(mobileno);
		Customer expected = store.get(mobileno);
		Assert.assertEquals(expected, result);

	}

}
