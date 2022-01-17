package com.danieltns.bank.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TransferRequestDto {
	
	@NotEmpty (message="Account number cannot be null/empty!")
	@Size(min=6, max=6, message="Account number must have 6 digits!")
	@Pattern(regexp="^\\d{6}$", message="Please specify sender account!")
	private String fromAccountNumber;
	
	@NotEmpty
	@Size(min=6, max=6)
	@Pattern(regexp="^\\d{6}$", message="Please specify destination account!")
	private String toAccountNumber;
	
	@Min(value=5, message="The value must be over 5!")
	private int value;
	
	@Size(max=50, message="Description is too long!")
	private String description;

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}  
	
}
