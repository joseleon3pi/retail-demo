/**
 * 
 */
package com.pillar.workshop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author abalderas
 *
 */
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Date contractDate;
	private String companyName;
	private String phoneNumber;
	private String country;
	private Double availableCredit;
	
	public Customer() {
		super();
	}

	/**
	 * 
	 * @param firstName
	 * @param lasName
	 * @param email
	 * @param gender
	 * @param contractDate
	 * @param companyName
	 * @param phoneNumber
	 * @param country
	 * @param availableCredit
	 */
	public Customer(String firstName, String lasName, String email, String gender, Date contractDate,
			String companyName, String phoneNumber, String country, Double availableCredit) {
		super();
		this.firstName = firstName;
		this.lastName = lasName;
		this.email = email;
		this.gender = gender;
		this.contractDate = contractDate;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.availableCredit = availableCredit;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lasName
	 */
	public String getLasName() {
		return lastName;
	}

	/**
	 * @param lasName the lasName to set
	 */
	public void setLasName(String lasName) {
		this.lastName = lasName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the contractDate
	 */
	public Date getContractDate() {
		return contractDate;
	}

	/**
	 * @param contractDate the contractDate to set
	 */
	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the availableCredit
	 */
	public Double getAvailableCredit() {
		return availableCredit;
	}

	/**
	 * @param availableCredit the availableCredit to set
	 */
	public void setAvailableCredit(Double availableCredit) {
		this.availableCredit = availableCredit;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lasName=" + lastName + "]";
	}

}
