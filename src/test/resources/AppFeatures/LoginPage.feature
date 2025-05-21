@Login
Feature: Login page feature

@Smoke
Scenario: Login page title
Given user is on login page
When user gets the title of the page
And page title should be "Cogmento CRM"

@Smoke
Scenario: Forgot password link
Given user is on login page
Then forgot your password link should be displayed

@Regression @Skip
Scenario: Login with correct credentials
Given user is on login page
When user enters username "hari251993@gmail.com"
And user enters password "Harikrishna@2025"
And user clicks on Login button
When user gets the title of the page
And page title should be "Cogmento CRM" 

@skip_scenario
Scenario: Login with correct credentials using skip concept
Given user is on login page
When user enters username "hari251993@gmail.com"
And user enters password "Harikrishna@2025"
And user clicks on Login button
When user gets the title of the page
And page title should be "Cogmento CRM" 