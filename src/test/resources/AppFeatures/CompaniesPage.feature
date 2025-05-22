Feature: Companies Page Feature


Background: 
Given user has already logged in to application
|username|password|
|hari251993@gmail.com|Harikrishna@2025|


Scenario Outline: Create new Company scenario
Given user is on home page and verifies account name "<AccountName>" and account user "<AccountUser>"
When user moves to menu list and select add new company
Then user is on company page and verifies page title "<CompanyPageTitle>"
And user fills the form comapany name "<companyName>" and website "<website>" and email "<email>"
And user enters data for description "<description>" and no.of employees "<no_ofEpm>"
And user clicks on save button
Then user verifies company name and quits


Examples: 
|AccountName| AccountUser | CompanyPageTitle   | companyName | website 				| email 						| description 						| no_ofEpm |  
|Photon     | Har Kris     | Create new Company| Profilo     | www.profilo.com|profilo@outlook.com|Profilo software pvt lmtd| 10000    |
|Photon     | Har Kris     | Create new Company| Kuhana      | www.Kuhana.com |Kuhana@outlook.com |Kuhana software pvt lmtd | 30000    |
|Photon     | Har Kris     | Create new Company| Quantum     | www.Quantum.com|Quantum@outlook.com|Quantum software pvt lmtd| 60000    |
|Photon     | Har Kris     | Create new Company| Amazon      | www.Amazon.com |Amazon@outlook.com |Amazon software pvt lmtd | 90000    |

