/**
 * 
 */
package com.pillar.workshop;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pillar.workshop.model.Customer;
import com.pillar.workshop.model.CustomerRepository;

/**
 * @author abalderas
 *
 */
@DataJpaTest
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Test
	public void testFindCustomerByName() {
		//Save customer
		System.out.println("<<< Performing testFindCustomerByName");
		customerRepo.save(new Customer("Eddy", "Gayol", "eddy.gayol@terra.com", "Unknown", new Date(), "Acme", "5535666600", "Mexico", 1456.54));
		customerRepo.save(new Customer("Eddy", "Contreras", "eddy.contreras@terra.com", "Unknown", new Date(), "Meca", "6660055356", "Mexico", 193.5));
		
		List<Customer> results = customerRepo.findByFirstName("Eddy");
		
		System.out.println("#### CustomerList 📝 ");
		for (Customer customer : results) {
			System.out.println(customer);
		}
		
		assertThat(results).size().isEqualTo(2);
		System.out.println(">>>");
	}
	
	@Test
	public void searchCustomers() {
		//Save customer
		System.out.println("<<< Performing searchCustomers");		
		customerRepo.save(new Customer("Eddy", "Gayol", "eddy.gayol@terra.com", "Unknown", new Date(), "Acme", "5535666600", "Mexico", 1456.54));
		customerRepo.save(new Customer("Eddy", "Contreras", "eddy.contreras@terra.com", "Unknown", new Date(), "Meca", "6660055356", "Mexico", 193.5));
		
		List<Customer> results = customerRepo.findByFirstNameOrLastNameOrCountry("Eddy", "Gayol", "Mexico");
		
		System.out.println("#### CustomerList 📝 ");
		for (Customer customer : results) {
			System.out.println(customer);
		}
		
		assertThat(results).size().isEqualTo(2);
		System.out.println(">>>");	
	}
}
