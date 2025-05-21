Feature: Home Page Feature


Background: 
Given user has already logged in to application
|username|password|
|hari251993@gmail.com|Harikrishna@2025|


Scenario: Home page title
Given user is on Home page
When user gets the title of the page
And page title should be "Cogmento CRM"


Scenario: Home page menu list count
Given user is on Home page
Then user gets home menu section
|Home|
|Calendar|
|Contacts|
|Companies|
|Deals|
|Tasks|
|Cases|
|Calls|
|Documents|
|Email|
|Campaigns|
|Forms|
|Reports|
And menu section count should be 13

 
 
