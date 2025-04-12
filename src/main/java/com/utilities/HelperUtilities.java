package com.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.TestBase;
import com.drivers.DriverManager;

public class HelperUtilities {
	
	/* This class contains all the Utilites related to Selenium Reusable Methods */

	public static void waitForPageToLoad() {
		WebDriver driver = DriverManager.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(webdriver -> js.executeScript("return document.readyState").equals("complete"));
	}

	public static void waitForVisible(WebElement ele) {
		WebDriver driver = DriverManager.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitForPresent(WebElement ele) {
		WebDriver driver = DriverManager.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) ele));
	}
	
	public static void waitForElemenToBeClickable(WebElement ele) {
		WebDriver driver = DriverManager.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void takeScreenshot() {
		File screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("screenshots/"+TestBase.getScenarioName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void highlightElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
		String OriginalStyle = element.getDomAttribute("style");
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"border: 1px solid red; background: red;" + OriginalStyle);
		
		js.executeScript(
		        "arguments[0].setAttribute('style', arguments[1]);", 
		        element, 
		        OriginalStyle
		    );
		
	}

}
