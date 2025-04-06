package com.booking.com.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.booking.com.drivers.DriverManager;

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

}
