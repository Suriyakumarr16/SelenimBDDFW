package stepdefenitions;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.booking.com.drivers.DriverManager;
import com.booking.com.pages.WebHomePage;
import com.booking.com.utilities.ConfigurationBase;
import com.booking.com.utilities.DateUtility;
import com.booking.com.utilities.HelperUtilities;
import com.booking.com.utilities.Report;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepLibrary {

	private WebDriver driver = DriverManager.getDriver();
	private WebHomePage	homepage = new WebHomePage(driver);
	  
	
	@Given("User launches Booking.com application")
	public void user_launches_booking_com_application() {
		Report.log("Launching the Base URL");
		String baseurl = ConfigurationBase.getProperty("env.url");
		driver.get(baseurl);
	}

	@When("User navigates to Booking.com Homepage")
	public void user_navigates_to_booking_com_homepage() {
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "booking.com/";
		Report.log("Validation of Base URL Landing Page");
		Assert.assertEquals(actualurl.contains(expectedurl), true);
		HelperUtilities.waitForPageToLoad();
	}

	@Then("user verifies that the logo is displayed")
	public void user_verifies_that_the_logo_is_displayed() {
		homepage.bookingDotComLogo().isDisplayed();
	}

	@Then("user is able to view the Banner displayed")
	public void user_is_able_to_view_the_banner_displayed() {
		homepage.heroBanner().isDisplayed();
	}

	@Then("user verifies the Homepage Header")
	public void user_verifies_the_homepage_header() {
		homepage.staysLink().isDisplayed();
		homepage.flightsLink().isDisplayed();
		homepage.taxisLink().isDisplayed();
		homepage.attractionsLink().isDisplayed();
		homepage.carsLink().isDisplayed();
	}
	
	@When("User enters Destination {string} in Destination Field Homepage")
	public void user_enters_destination_in_destination_field_homepage(String Destination) throws InterruptedException {
		HelperUtilities.highlightElement(homepage.getDestinationField());
		homepage.getDestinationField().clear();
		homepage.getDestinationField().sendKeys(Destination);
		HelperUtilities.waitForElemenToBeClickable(homepage.getSuggestedDestinationDropdown());
		HelperUtilities.waitForVisible(homepage.getSearchedDestinationFromDropdown(Destination));
		HelperUtilities.highlightElement(homepage.getSearchedDestinationFromDropdown(Destination));
		homepage.getSearchedDestinationFromDropdown(Destination).click();
	}
	
	@When("User selects check-in {string} and check-out date {string} in Datepicker Homepage")
	public void user_selects_check_in_and_check_out_date_in_datepicker_homepage(String CheckInDate, String CheckOutDate) {
		String checkindate = DateUtility.getDate(Integer.parseInt(CheckInDate));
		String checkoutdate = DateUtility.getDate(Integer.parseInt(CheckOutDate));
		Report.log("User enters checkin and checkout date as :" + checkindate + " " +"&" +" " + checkoutdate);
		HelperUtilities.highlightElement(homepage.getCheckInDate(checkindate));
		homepage.getCheckInDate(checkindate).click();
		HelperUtilities.highlightElement(homepage.getCheckOutDate(checkoutdate));
		homepage.getCheckOutDate(checkoutdate).click();
	}

	@When("User selects the guest count as {int} adults in Homepage")
	public void user_selects_the_guest_count_as_adults_in_homepage(int Adults) {
		HelperUtilities.highlightElement(homepage.getRoomsGuestsDropdownButton());
		homepage.getRoomsGuestsDropdownButton().click();
		HelperUtilities.waitForVisible(homepage.getAdultsPlusButton());
		for(int i=2;i<Adults;i++) {
		HelperUtilities.highlightElement(homepage.getAdultsPlusButton());
		homepage.getAdultsPlusButton().click();
		}
		HelperUtilities.highlightElement(homepage.getRoomsGuestsDropdownDoneButton());
		homepage.getRoomsGuestsDropdownDoneButton().click();
	}

	@When("User clicks on Search CTA")
	public void user_clicks_on_search_cta() {
		HelperUtilities.highlightElement(homepage.getSearchButton());
		homepage.getSearchButton().click();
	}
}
