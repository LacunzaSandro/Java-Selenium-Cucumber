Feature: Facebook Login Validation
  Scenario: To check the functionality for the Facebook Login Page with invalid login credentials
    Given User Login to the Facebook Login Page
    When User Enter email "dfgfdsgfsdg@hotmail.com"
    And User Enter Password as "password"
    And Click on Log In button
    Then Login should be Unsuccessful and error message should be dislayed "Invalid username or password. Signon failed."
