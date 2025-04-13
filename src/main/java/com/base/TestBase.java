package com.base;

import com.drivers.DriverManager;
import com.utilities.Report;

public class TestBase extends Report {
			
	public void setup() {
		if(DriverManager.getDriver()==null) {
	         DriverManager.launchBrowser();
			}
	}

	public void tearDown() {
		if (DriverManager.getDriver() != null) {
			DriverManager.quitBrowser();
		}
	}

}
