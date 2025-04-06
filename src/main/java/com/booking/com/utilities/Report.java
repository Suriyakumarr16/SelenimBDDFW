package com.booking.com.utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Report {
	
	private static final Logger LOGGER = LogManager.getLogger(Report.class);
	
	public static void log(String msg)
	{
		LOGGER.info(msg);
	}

}
