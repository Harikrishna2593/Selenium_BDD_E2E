Feature: Create new contact in cogmento

Background: 
Given user has already logged in to application
|username|password|
|hari251993@gmail.com|Harikrishna@2025|

Scenario Outline: Create new contact with different set of data
Given user moves to create new contact page and verify label
When user fills the new contact form from given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on save button
Then verify the contact profile name

Examples: 
|SheetName|RowNumber|
|contacts|0|
|contacts|1|
|contacts|2|
|contacts|3|
|contacts|4|
|contacts|5|


 