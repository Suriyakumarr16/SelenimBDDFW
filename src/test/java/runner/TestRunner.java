package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@smoke",features="src/test/java/features",glue= {"com.booking.com.base","stepdefenitions"}
,plugin= {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"},monochrome=true,publish=true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
