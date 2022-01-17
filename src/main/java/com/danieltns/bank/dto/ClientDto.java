package com.danieltns.bank.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.danieltns.bank.entity.Account;

public class ClientDto {	
	@NotEmpty(message="First Name cannot be null/empty")
	private String firstName;
	
	@NotEmpty(message="Last Name cannot be null/empty")
	private String lastName;
	
	@NotEmpty(message="Personal code cannot be null/empty")
	private String personalCode;
	
	@Min(value=18, message="Age should not be less than 18")
	@Max(value=150, message="Age should not be greater than 150")
	private int age;
	
	@NotEmpty(message="Phone number cannot be null/empty")
	@Pattern(regexp="^\\d{10}$", message="Phone Number must have 10 digits")
	private String phoneNumber;
	
	@Email(message="Email is not valid")
	private String email;
	
	private Set<Account> accounts = new HashSet<>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
}
