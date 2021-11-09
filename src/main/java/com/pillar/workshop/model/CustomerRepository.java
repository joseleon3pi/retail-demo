/**
 * 
 */
package com.pillar.workshop.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author abalderas
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByFirstName(String firstName);
		
	List<Customer> findByFirstNameOrLastNameOrCountry(String firstName, String lastName, String country);
}
