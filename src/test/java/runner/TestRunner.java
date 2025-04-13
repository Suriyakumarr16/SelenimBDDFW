package runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(tags="@regression",features="src/test/java/features",glue= {"com.booking.com.base","stepdefenitions"}
,plugin= {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"},monochrome=true,publish=true)
public class TestRunner extends AbstractTestNGCucumberTests {
	
@Test(dataProvider="scenarios")
public void runScenario(PickleWrapper pickleWrapper,FeatureWrapper featureWrapper)
{
	TestNGCucumberRunner testNGCucumberRunner = new TestNGCucumberRunner(getClass());
	testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	testNGCucumberRunner.finish();
}

}
