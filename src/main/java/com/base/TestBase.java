package com.base;

import com.drivers.DriverManager;
import com.utilities.ConfigurationBase;
import com.utilities.Report;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestBase extends Report {
	
	private static String scenarioName;
	ConfigurationBase config = new ConfigurationBase();
	
	
	public static String getScenarioName()
	{
		return scenarioName;
	}
	
	@Before
	public void setup(Scenario scenario) {
		config.loadProperties();
		scenarioName = scenario.getName();
		Reporter = extent.createTest(scenarioName);
		
		if(DriverManager.getDriver()==null) {
         DriverManager.launchBrowser();
		}
	}

	@After
	public void tearDown() {
		if (DriverManager.getDriver() != null) {
			DriverManager.quitBrowser();
		}
		extent.flush();
	}

}
