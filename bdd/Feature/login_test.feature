Feature: Login Action

		Background:
    Given User is on Login Page
    When User enters UserName and Password
    And User enter pin
    
Scenario: Successful Login with Valid Credentials
		And User is on home page
    Then Message displayed Login Successfully
    And user close the web browser
Scenario: Successful LogOut
    When User LogOut from the Application
    Then Message displayed LogOut Successfully
    And user close the web browser