/**
 * 
 */
package com.pillar.workshop.rs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pillar.workshop.core.CustomerService;
import com.pillar.workshop.model.Customer;

/**
 * @author abalderas
 *
 */
@RestController
public class RetailRS {
	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/customer/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> sarch(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "country") String country) {

		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Eddy", "Gayol", "eddy.gayol@terra.com", "Unknown", new Date(), "Acme", "5535666600",
				"Mexico", 1456.54));
		customers.add(new Customer("Eddy", "Contreras", "eddy.contreras@terra.com", "Unknown", new Date(), "Meca",
				"6660055356", "Mexico", 193.5));
		customerService.saveCustomers(customers);

		return customerService.searchCustomers(firstName, lastName, country);
	}

	@GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAll() {
		return customerService.findAllCustomers();
	}

	@PostMapping(value = "/customer", consumes = { "multipart/form-data" })
	public void loadFile(@RequestParam(required = true) MultipartFile[] file) {
		System.out.println("Performing loadFile");

		List<Customer> customers = new ArrayList<>();

		for (MultipartFile multipartFile : file) {
			try {
				byte[] bytes = multipartFile.getBytes();
				Scanner scan = new Scanner(new ByteArrayInputStream(bytes));
				boolean headerRead = false;
				while (scan.hasNextLine()) {
					String line = scan.nextLine();
					System.out.println(line);

					if (headerRead) {
						String[] split = line.split(",");
						if (split.length == 10) {
							customers.add(new Customer(split[1], split[2], split[3], split[4], null, split[6], split[7],
									split[8], Double.parseDouble(split[9])));
						}
					}

					headerRead = true;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!customers.isEmpty()) {
			this.customerService.saveCustomers(customers);
		}
	}
}
