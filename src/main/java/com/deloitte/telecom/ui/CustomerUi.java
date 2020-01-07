package com.deloitte.telecom.ui;

import java.util.*;

import com.deloitte.telecom.*;
import com.deloitte.telecom.service.*;
import com.deloitte.telecom.dao.*;
import com.deloitte.telecom.entities.*;

public class CustomerUi {
	private ICustomerService service = new CustomerServiceImpl(new CustomerDaoImpl());

	public static void main(String[] args) {
		CustomerUi ui = new CustomerUi();
		ui.runUi();
	}

	public void runUi() {
		while (true) {
			try {

				System.out.println("Options available are");
				System.out.println("1. Account balance enquiry");
				System.out.println("2. Recharge account");
				System.out.println("3. Create account");
				System.out.println("4. Exit");
				System.out.println("Enter your choice:");
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();

				if (choice == 1) {
					System.out.println("Give mobileno:");
					String mobileno = sc.next();
					Customer fetched1 = service.findByMobileno(mobileno);
					System.out.println("Name:" + fetched1.getName() + "Balance:" + fetched1.getBalance());
				}

				if (choice == 2) {
					System.out.println("Give mobileno to recharge:");
					String mobileno = sc.next();
					System.out.println("Give balance to be added:");
					double balance = sc.nextDouble();
					Customer c = service.findByMobileno(mobileno);
					service.rechargeAccount(c, balance);
					System.out.println(c.getBalance());
				}

				if (choice == 3) {
					System.out.println("Give name of the customer:");
					String name = sc.next();
					System.out.println("Give mobileno of customer:");
					String mobileno = sc.next();
					System.out.println("Give balance:");
					double balance = sc.nextDouble();
					Customer c = service.createAccount(mobileno, balance, name);
					System.out.println(c);

				}

				if (choice == 4) {
					break;

				}

			} catch (Throwable e) {
				e.printStackTrace();
				System.out.println("something went wrong");
			}
		}
	}

}
