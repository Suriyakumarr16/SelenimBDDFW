Feature: Search

  Background: 
    Given User launches Booking.com application
    
@regression
  Scenario Outline: Booking.com HP Validations
    When User navigates to Booking.com Homepage
    And User enters Destination "<Destination>" in Destination Field Homepage
    And User selects check-in "<CheckInDate>" and check-out date "<CheckOutDate>" in Datepicker Homepage
    And User selects the guest count as <Adults> adults in Homepage
    And User clicks on Search CTA
    Then Verify User gets navigated to Search Results Page
    And Destination "<DestinationInSearchResults>" is displayed in Search Results Page
Examples: 
 | Destination | CheckInDate | CheckOutDate | Adults | DestinationInSearchResults |
 | Hyderabad | 30 | 31 | 3 | Hyderabad |
 | Chennai | 45 | 46 | 4 | Chennai |
 
