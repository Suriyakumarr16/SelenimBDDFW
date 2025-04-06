 Feature: HomePage
 
 Background:
 Given User launches Booking.com application
 
 @smoke
 Scenario: Booking.com HP Validations
 When User navigates to Booking.com Homepage
 Then user verifies that the logo is displayed
 And user is able to view the Banner displayed
 And user verifies the Homepage Header
  
 