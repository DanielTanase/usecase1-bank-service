package com.danieltns.bank.utils;

public class AppConstants {
	public static final String CLIENT_CONTROLLER = "/client";
	public static final String TRANSFER_CONTROLLER = "/transfer";
	public static final String REGISTER_CLIENT = "/register";
	public static final String TRANSFER_FUND = "/fundTransfer";
	public static final String GET_MONTHLY_TRANSACTIONS = "/statement";
	
	private AppConstants() {
	    throw new IllegalStateException("Constants class");
	  }

}
