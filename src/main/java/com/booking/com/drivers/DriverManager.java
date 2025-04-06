package com.booking.com.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.booking.com.utilities.ConfigurationBase;
import com.booking.com.utilities.Report;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
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
			Report.log("Driver Instantiated : Chrome");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().clearResolutionCache().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--start-maximized");
			firefoxOptions.addArguments("--disable-gpu");
			driver.set(new FirefoxDriver(firefoxOptions));
			Report.log("Driver Instantiated : FireFox");
			break;
			
		case "edge":
			WebDriverManager.edgedriver().clearResolutionCache().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--start-maximized");
			edgeOptions.addArguments("--disable-gpu");
			driver.set(new EdgeDriver(edgeOptions));
			Report.log("Driver Instantiated : Edge");
			break;
		}
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
    public static void quitBrowser() {
        WebDriver driverInstance = driver.get();
        if (driverInstance != null) {
        	Report.log("Driver to be quit");
            driverInstance.quit();
            driver.remove();
        }
    }
}
