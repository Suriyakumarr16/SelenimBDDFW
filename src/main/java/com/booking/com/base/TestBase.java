package com.booking.com.base;


import com.booking.com.drivers.DriverManager;
import com.booking.com.utilities.ConfigurationBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestBase {
	
	public static String scenarioName;
	ConfigurationBase config = new ConfigurationBase();
	
	public static String getScenarioName()
	{
		return scenarioName;
	}
	
	@Before
	public void setup(Scenario scenario) {
		scenarioName = scenario.getName();
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
