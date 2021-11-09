package com.pillar.workshop;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pillar.workshop.core.CustomerService;
import com.pillar.workshop.model.Customer;

@SpringBootTest
class CustomerServiceTests {
	@Autowired
	private CustomerService customerService;

	@Test
	void saveCustomersTest() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Eddy", "Gayol", "eddy.gayol@terra.com", "Unknown", new Date(), "Acme", "5535666600", "Mexico", 1456.54));
		customers.add(new Customer("Eddy", "Contreras", "eddy.contreras@terra.com", "Unknown", new Date(), "Meca", "6660055356", "Mexico", 193.5));
		customerService.saveCustomers(customers);
		
		List<Customer> allCustomers = customerService.findAllCustomers();
		assertThat(allCustomers).size().isEqualTo(2);
	}

}
