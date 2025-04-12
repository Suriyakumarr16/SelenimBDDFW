package com.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utilities.ConfigurationBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager extends TestBase {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void launchBrowser() {
		String browserName = ConfigurationBase.getProperty("browser.name");
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().clearResolutionCache().setup();
			WebDriverManager.chromedriver().driverVersion("134.0.6940.0").setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--start-maximized");
			chromeOptions.addArguments("--disable-gpu");
			driver.set(new ChromeDriver(chromeOptions));
			Reporter.log(Status.INFO,"Driver Instantiated : Chrome");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().clearResolutionCache().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--start-maximized");
			firefoxOptions.addArguments("--disable-gpu");
			driver.set(new FirefoxDriver(firefoxOptions));
			Reporter.log(Status.INFO,"Driver Instantiated : FireFox");
			break;
			
		case "edge":
			WebDriverManager.edgedriver().clearResolutionCache().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--start-maximized");
			edgeOptions.addArguments("--disable-gpu");
			driver.set(new EdgeDriver(edgeOptions));
			Reporter.log(Status.INFO,"Driver Instantiated : Edge");
			break;
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
    public static void quitBrowser() {
        WebDriver driverInstance = driver.get();
        if (driverInstance != null) {
        	Reporter.log(Status.INFO,"Driver to be quit");
            driverInstance.quit();
            driver.remove();
        }
    }
}
