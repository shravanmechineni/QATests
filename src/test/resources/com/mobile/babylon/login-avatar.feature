@Smoke1Login
Feature: Logging in to the application and Sharing your information to stakeholders
  
  In order to login
  As a Mobile user
  I want to Register and Login in to Babylon application and count the setting 
  So that I can access the features of the composer, profile and conversation

  Scenario Outline: Register/Login into the application
    Given I go to babylonApp on "<mobileDevice>"
    And I tap on "signUp"
    And I enter "eMail" as "mailIDText"
    And I enter "passWord" as "passwordText"
    And I enter "firstName" as "firstNameText"
    And I enter "lastName" as "lastNameText"
    And I tap on "DOB"
    And I enter DOB with "day", "month", "year" 
    And I press OK button
    And I tap on "checkBox" with classname
    And I tap on "createButton"
    Then I logged in "Successfully" with "babyloHelpText"

    Examples: 
      | mobileDevice |
      | Galaxy S5    |
      
      
    Scenario: Tap on Avatar and count and get the text of settings.
    Given I tap on "Avatar"
    When I click and get the value and Text of "Settings"
    Then I "signedOut"
    
    Scenario : close the app
    Given I close the application
