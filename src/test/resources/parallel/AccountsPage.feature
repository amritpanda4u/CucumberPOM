@browser
Feature: Verify accounts page

Background: 
Given The user is logged in to the application
| username | password |
|amritpanda4u@gmail.com | test123 |

Scenario: Verify logged in user
Given user is in Accounts page
When user gets the logged in username
Then the username should be "amrit panda"

Scenario: Verify page title
Given user is in Accounts page
When user gets the page title
Then page title should be "My account - My Store"

Scenario: Verify accounts menu list
Given user is in Accounts page
When user gets the accounts menu list
Then user gets 
		|ORDER HISTORY AND DETAILS|
		|MY CREDIT SLIPS|
		|MY ADDRESSES|
		|MY PERSONAL INFORMATION|
		|MY WISHLISTS|
And the menu list count 5
