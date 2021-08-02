@browser
Feature: Login screen 

Scenario: Verify the fogot password link

Given user is on login page
When user clicks on Signin link
Then forgot password link is displayed

Scenario: Verify login to the application

Given user is on login page
When user clicks on Signin link
And user enters username "amritpanda4u@gmail.com"
And user enters password "test123"
And clicks on Signin button
Then user is in home page