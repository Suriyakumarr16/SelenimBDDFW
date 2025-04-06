package com.booking.com.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtility {
	
	/* This class contains all the utilities related to Date and its format */
	
	public static String getDate(int daysToAdd) {
		LocalDate currentdate = LocalDate.now();
		LocalDate date = currentdate.plusDays(daysToAdd);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		return date.format(formatter);
		}
}
