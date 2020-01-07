package com.deloitte.telecom.service;

import java.util.*;

import com.deloitte.telecom.*;
import com.deloitte.telecom.entities.*;

public interface ICustomerService {

	public Customer findByMobileno(String mobileno);

	public void rechargeAccount(Customer c, double amount);

	public Customer createAccount(String mobileno, double balance, String name);

	Set<Customer> allCustomers();

}
