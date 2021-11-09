/**
 * 
 */
package com.pillar.workshop.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pillar.workshop.core.CustomerService;
import com.pillar.workshop.model.Customer;
import com.pillar.workshop.model.CustomerRepository;

/**
 * @author abalderas
 *
 */
@Service
public class CustomerServiceBean implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void importData(byte[] csvContent) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> searchCustomers(String fisrtName, String lastName, String country) {
		System.out.println("CustomerServiceBean::searchCustomers");
		return this.customerRepository.findByFirstNameOrLastNameOrCountry(fisrtName, lastName, country);
	}

	@Override
	public void saveCustomers(List<Customer> customers) {
		System.out.println("CustomerServiceBean::saveCustomers");
		this.customerRepository.saveAll(customers);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return (List<Customer>) this.customerRepository.findAll();
	}

}
