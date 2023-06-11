package com.saxena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saxena.model.Customer;
import com.saxena.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// CRUD

	/**
	 * Method used to add new customer details in the database.
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		if (customer.getAccountNo() == null || customer.getAccountNo().isEmpty()) {
			// TODO: Add Custom Exception
			// TODO: Add Log Statement
			System.out.println("Account number is empty/null");
		}
		return customerService.addCustomer(customer);
	}

	/**
	 * 
	 * @param accountNo
	 * @return
	 */
	@GetMapping("/getCustomer")
	public Customer getCustomer(@RequestParam String accountNo) {
		if (accountNo == null || accountNo.isEmpty()) {
			// TODO: Add Custom Exception
			// TODO: Add Log Statement
			System.out.println("Account number is empty/null");
		}
		return customerService.getCustomer(accountNo);
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	/**
	 * 
	 * @param customer
	 * @return
	 */
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		if (customer.getAccountNo() == null || customer.getAccountNo().isEmpty()) {
			// TODO: Add Custom Exception
			// TODO: Add Log Statement
			System.out.println("Account number is empty/null");
		}
		return customerService.updateCustomer(customer);
	}
	/**
	 * 
	 * @param accountNo
	 * @return
	 */
	@DeleteMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam String accountNo) {
		if (accountNo == null || accountNo.isEmpty()) {
			// TODO: Add Custom Exception
			// TODO: Add Log Statement
			System.out.println("Account number is empty/null");
		}
		return customerService.deleteCustomer(accountNo);
	}

	//TODO: PatchMapping Implementation
	//TODO: Search customer based on multiple arguments
}
