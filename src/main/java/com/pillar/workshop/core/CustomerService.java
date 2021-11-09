/**
 * 
 */
package com.pillar.workshop.core;

import java.util.List;

import com.pillar.workshop.model.Customer;

/**
 * @author abalderas
 *
 */
public interface CustomerService {
	/**
	 * 
	 * @param customers
	 */
	void saveCustomers(List<Customer> customers);
	
	/**
	 * 
	 * @param csvContent
	 */
	void importData(byte[] csvContent);
	
	/**
	 * 
	 * @param fisrtName
	 * @param lastName
	 * @param country
	 * @return
	 */
	List<Customer> searchCustomers(String fisrtName, String lastName, String country);
	
	/**
	 * 
	 * @return
	 */
	List<Customer> findAllCustomers();
}
