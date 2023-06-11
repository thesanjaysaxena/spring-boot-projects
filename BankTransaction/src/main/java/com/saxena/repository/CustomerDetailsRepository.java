package com.saxena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saxena.model.Customer;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<Customer, Long> {
	Customer findByAccountNo(String accountNo);
}
