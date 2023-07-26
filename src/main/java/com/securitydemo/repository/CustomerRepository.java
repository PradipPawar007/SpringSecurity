package com.securitydemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securitydemo.model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

	List<Customer>findByEmail(String username);
}
