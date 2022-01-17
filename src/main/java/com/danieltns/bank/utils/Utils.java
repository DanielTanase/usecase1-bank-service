package com.danieltns.bank.utils;

import java.time.LocalDate;

public class Utils {
	
	private Utils() {
	    throw new IllegalStateException("Utility class");
	  }

	
	public static void checkDateValid(int month, int year) {
		if (month < 1 || month > 12 || year < 2020 || year > LocalDate.now().getYear()) {
			throw new IllegalArgumentException("Invalid parameter month/year!");
		}		
	}
	
}
