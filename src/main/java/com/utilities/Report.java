package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest Reporter;
	
	static {
		sparkReporter = new ExtentSparkReporter("test-output/ExtentReports/extent.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
	}

}
