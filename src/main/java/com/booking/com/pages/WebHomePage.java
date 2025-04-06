package com.booking.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebHomePage {

	private WebDriver driver;

	//Header Components
	By bookingdotcomlogo = By.xpath("//div[@class='Header_logo']");
	By herobanner = By.cssSelector("div[data-testid*='hero']");
	By stays = By.id("accommodations");
	By flights = By.id("flights");
	By cars = By.xpath("//a[@id='cars' and contains(@href,'ch.booking')]");
	By attractions = By.id("attractions");
	By taxis = By.xpath("//a[@id='airport_taxis' and contains(@href,'ch.booking')]");
	By DestinationField = By.cssSelector("div[data-testid='destination-container'] input");
	
	//Search Bar
	By SuggestedDestinationDropdown = By.xpath("//ul[@role='group' and not(contains(@aria-labelledby,'group-0heading'))]");
	By RoomsGuestsDropdownButton = By.cssSelector("span[data-testid='searchbox-form-button-icon'] svg");
	By AdultsPlusButton = By.xpath("(//input[@id='group_adults']/..//button)[last()]");
	By AdultsMinusButton = By.xpath("(//input[@id='group_adults']/..//button)[1]");
	By SearchButton = By.xpath("//div[@data-testid='searchbox-layout-wide']//button[@type='submit']");
    By RoomsGuestsDropdownDoneButton= By.xpath("(//div[@data-testid='occupancy-popup']//button)[last()]");
	
	public WebHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement bookingDotComLogo() {
		return driver.findElement(bookingdotcomlogo);
	}

	public WebElement heroBanner() {
		return driver.findElement(herobanner);
	}

	public WebElement staysLink() {
		return driver.findElement(stays);
	}

	public WebElement flightsLink() {
		return driver.findElement(flights);
	}

	public WebElement carsLink() {
		return driver.findElement(cars);
	}

	public WebElement attractionsLink() {
		return driver.findElement(attractions);
	}

	public WebElement taxisLink() {
		return driver.findElement(taxis);
	}

	public WebElement getDestinationField() {
		return driver.findElement(DestinationField);
	}

	public WebElement getSearchedDestinationFromDropdown(String searchedDestination) {
		By SearchedDestinationFromDropdown = By.xpath(String.format("//div[text()='%s']",searchedDestination));
		return driver.findElement(SearchedDestinationFromDropdown);
	}
	
	public WebElement getSuggestedDestinationDropdown() {
		return driver.findElement(SuggestedDestinationDropdown);
	}

	public WebElement getCheckInDate(String checkinDate) {
		By CheckInDate = By.cssSelector(
				String.format("div[data-testid='searchbox-datepicker-calendar'] span[data-date='%s']", checkinDate));
		return driver.findElement(CheckInDate);
	}

	public WebElement getCheckOutDate(String checkoutDate) {
		By CheckOutDate = By.cssSelector(
				String.format("div[data-testid='searchbox-datepicker-calendar'] span[data-date='%s']", checkoutDate));
		return driver.findElement(CheckOutDate);
	}

	public WebElement getRoomsGuestsDropdownButton() {
		return driver.findElement(RoomsGuestsDropdownButton);
	}

	public WebElement getAdultsPlusButton() {
		return driver.findElement(AdultsPlusButton);
	}

	public WebElement getAdultsMinusButton() {
		return driver.findElement(AdultsMinusButton);
	}

	public WebElement getSearchButton() {
		return driver.findElement(SearchButton);
	}
	
	public WebElement getRoomsGuestsDropdownDoneButton() {
		return driver.findElement(RoomsGuestsDropdownDoneButton);
	}

}
