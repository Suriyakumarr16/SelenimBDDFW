package com.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.cucumber.testng.PickleWrapper;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utilities.ConfigurationBase;
import com.utilities.HelperUtilities;

public class TestNGListener extends TestBase implements ITestListener,ISuiteListener {
	private static ThreadLocal<String> scenarioName = new ThreadLocal<>();
	ConfigurationBase config = new ConfigurationBase();
	
	public void onTestStart(ITestResult result)
	{
		config.loadProperties();
		String name = extractScenarioName(result);
		scenarioName.set(name);
		Reporter = extent.createTest(name);
		Reporter.log(Status.INFO,"Test has started: "+ name);
		setup();
	}
	
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log(Status.PASS,"Test has completed: "+ scenarioName.get());
		tearDown();
	}
	
	public void onTestFailure(ITestResult result)
	{
		String scenarioname = scenarioName.get();
		HelperUtilities.takeScreenshot(scenarioname);
		Reporter.log(Status.FAIL,"Test has failed: "+ scenarioName.get());
		tearDown();
	}
	
	public void onTestSkipped(ITestResult result)
	{
		String scenarioname = scenarioName.get();
		HelperUtilities.takeScreenshot(scenarioname);
		Reporter.log(Status.WARNING,"Test has skipped: "+ scenarioName.get());
		tearDown();
	}
	
	public void onTestFailedButWithinSucessPercentage(ITestResult result)
	{
		String scenarioname = scenarioName.get();
		HelperUtilities.takeScreenshot(scenarioname);
		Reporter.log(Status.FAIL,"Test has failed, but within success percentage: "+ scenarioName.get());
		tearDown();
	}
	
	@Override
    public void onFinish(ITestContext context) {
        extent.flush();
        Reporter.log(Status.INFO,"Tests have completed "+ context.getName());
    }
	
	public void onStart(ISuite suite)
	{

	}
	
	public void onFinish(ISuite suite)
	{
		
	}
	
	private String extractScenarioName(ITestResult result)
	{
		Object[] params = result.getParameters();
		if(params!=null && params.length>0 && params[0] instanceof PickleWrapper)
		{
			PickleWrapper pickleWrapper = (PickleWrapper) params[0];
			return pickleWrapper.getPickle().getName();
		}
		return result.getName();
	}
}
