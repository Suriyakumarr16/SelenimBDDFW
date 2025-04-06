package com.booking.com.base;


import com.booking.com.drivers.DriverManager;
import com.booking.com.utilities.ConfigurationBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {

	@Before
	public void setup() {
		ConfigurationBase config = new ConfigurationBase();
		config.loadProperties();
		
		if(DriverManager.getDriver()==null) {
         DriverManager.launchBrowser();
		}
	}
	

	@After
	public void tearDown() {
		if (DriverManager.getDriver() != null) {
			DriverManager.quitBrowser();
		}
	}
}
