package com.saxena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saxena.model.Customer;
import com.saxena.repository.CustomerDetailsRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerDetailsRepository customerRepository;

	/**
	 * 
	 * @param customer
	 * @return
	 */
	public Customer addCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findByAccountNo(customer.getAccountNo());
		if (existingCustomer != null) {
			// TODO: Throw a custom exception.
			System.out.println("Customer information is already present in database");

		}
		Customer newCustomer = customerRepository.save(customer);
		return newCustomer;
	}

	/**
	 * 
	 * @param accountNo
	 * @return
	 */
	public Customer getCustomer(String accountNo) {
		Customer existingCustomer = customerRepository.findByAccountNo(accountNo);
		if (existingCustomer == null) {
			// TODO: Throw a custom exception.
			System.out.println("Customer information is not present in database");

		}
		return existingCustomer;
	}

	/**
	 * 
	 * @return
	 */
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	/**
	 * 
	 * @param customer
	 * @return
	 */
	public Customer updateCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findByAccountNo(customer.getAccountNo());
		if (existingCustomer == null) {
			// TODO: Throw a custom exception.
			System.out.println("Customer information is not present in database");

		}
		customer.setAccountType(existingCustomer.getAccountType());

		Customer updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;
	}

	/**
	 * 
	 * @param accountNo
	 * @return
	 */
	public String deleteCustomer(String accountNo) {
		Customer customer = customerRepository.findByAccountNo(accountNo);
		if (customer == null) {
			// TODO: Throw a custom exception.
			System.out.println("Customer information is not present in database");
		}
		customerRepository.delete(customer);
		return "Record deleted succefully";
	}
}
