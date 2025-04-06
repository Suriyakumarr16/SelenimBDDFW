package com.booking.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebSearchResultsPage {

	private WebDriver driver;
	
	public WebSearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getDestinationReturnedText(String destinationtxt) {
		By DestinationReturnedText = By.xpath(String.format("//h1[contains(text(),'%s')]",destinationtxt));
		return driver.findElement(DestinationReturnedText);
	}
	
}
